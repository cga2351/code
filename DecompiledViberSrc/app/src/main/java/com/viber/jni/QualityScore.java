package com.viber.jni;

import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class QualityScore
{
  private static final int DEFAULT_POLL_DELAY_MS = 1000;
  private static final Logger L = ViberEnv.getLogger();
  private AtomicBoolean exit_poller_flag = new AtomicBoolean(false);
  private final Handler handler;
  private InnerPoller inner_poller = new InnerPoller(null);
  private AtomicInteger last_quality_report = new AtomicInteger(-1);
  private long native_handle = newQualityScore_native();
  private Set<IQualityScoreClient> notifierSet = new HashSet();
  private final int poll_delay_ms;

  public QualityScore()
  {
    this(av.a(av.e.e));
  }

  public QualityScore(Handler paramHandler)
  {
    this(paramHandler, null, 1000);
  }

  public QualityScore(Handler paramHandler, IQualityScoreClient paramIQualityScoreClient, int paramInt)
  {
    this.poll_delay_ms = paramInt;
    this.handler = paramHandler;
    addNotifier(paramIQualityScoreClient);
  }

  public QualityScore(IQualityScoreClient paramIQualityScoreClient)
  {
    this(av.a(av.e.e), paramIQualityScoreClient, 1000);
  }

  public QualityScore(IQualityScoreClient paramIQualityScoreClient, int paramInt)
  {
    this(av.a(av.e.e), paramIQualityScoreClient, paramInt);
  }

  private void broadcastQualityReport(int paramInt1, int paramInt2)
  {
    synchronized (this.notifierSet)
    {
      HashSet localHashSet = new HashSet(this.notifierSet);
      Iterator localIterator = localHashSet.iterator();
      if (localIterator.hasNext())
        ((IQualityScoreClient)localIterator.next()).onQualityScoreUpdated(paramInt1, paramInt2);
    }
  }

  private void broadcastRawQualityReport(int paramInt)
  {
    synchronized (this.notifierSet)
    {
      HashSet localHashSet = new HashSet(this.notifierSet);
      Iterator localIterator = localHashSet.iterator();
      if (localIterator.hasNext())
        ((IQualityScoreClient)localIterator.next()).onRawQualityScore(paramInt);
    }
  }

  private static native int getQualityScore_native(long paramLong);

  private static native long newQualityScore_native();

  private void pollNativeQualityScore()
  {
    try
    {
      if (this.exit_poller_flag.get())
        return;
      int i = getQualityScore_native(this.native_handle);
      if ((i != -1) && (i != this.last_quality_report.get()))
        broadcastQualityReport(this.last_quality_report.getAndSet(i), this.last_quality_report.get());
      broadcastRawQualityReport(i);
      this.last_quality_report.set(i);
      rescheduleNativePoller();
      return;
    }
    finally
    {
    }
  }

  private static native void releaseQualityScore_native(long paramLong);

  private void rescheduleNativePoller()
  {
    if ((this.handler == null) || (this.inner_poller == null))
      return;
    try
    {
      if (this.exit_poller_flag.get())
        return;
    }
    finally
    {
    }
    this.handler.removeCallbacks(this.inner_poller);
    this.handler.postDelayed(this.inner_poller, this.poll_delay_ms);
  }

  public void addNotifier(IQualityScoreClient paramIQualityScoreClient)
  {
    int i = 0;
    if (paramIQualityScoreClient != null);
    synchronized (this.notifierSet)
    {
      this.notifierSet.add(paramIQualityScoreClient);
      int j = this.notifierSet.size();
      i = 0;
      if (1 == j)
        i = 1;
      if (i != 0)
        rescheduleNativePoller();
      return;
    }
  }

  public void dispose()
  {
    try
    {
      this.exit_poller_flag.set(true);
      if (0L != this.native_handle)
      {
        releaseQualityScore_native(this.native_handle);
        this.native_handle = 0L;
      }
      return;
    }
    finally
    {
    }
  }

  public int getLastQuality()
  {
    return this.last_quality_report.get();
  }

  public void removeNotifier(IQualityScoreClient paramIQualityScoreClient)
  {
    boolean bool = false;
    if (paramIQualityScoreClient != null);
    synchronized (this.notifierSet)
    {
      this.notifierSet.remove(paramIQualityScoreClient);
      int i = this.notifierSet.size();
      bool = false;
      if (i == 0)
        bool = true;
    }
    try
    {
      this.exit_poller_flag.set(bool);
      return;
      localObject2 = finally;
      throw localObject2;
    }
    finally
    {
    }
  }

  public static abstract interface IQualityScoreClient
  {
    public abstract void onQualityScoreUpdated(int paramInt1, int paramInt2);

    public abstract void onRawQualityScore(int paramInt);
  }

  private class InnerPoller
    implements Runnable
  {
    private InnerPoller()
    {
    }

    public void run()
    {
      QualityScore.this.pollNativeQualityScore();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.QualityScore
 * JD-Core Version:    0.6.2
 */