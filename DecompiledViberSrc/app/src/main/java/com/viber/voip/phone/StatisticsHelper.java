package com.viber.voip.phone;

import android.os.Handler;
import android.os.Looper;
import com.viber.dexshared.Logger;
import com.viber.jni.PCStatistics;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.webrtc.MediaStreamTrack;
import org.webrtc.PeerConnection;
import org.webrtc.StatsObserver;
import org.webrtc.StatsReport;

public class StatisticsHelper
{
  private static final boolean ENABLE_RTC_STATISTICS = true;
  private static final Logger L = ViberEnv.getLogger();
  private static final int STATISTICS_GATHER_PERIOD = 1000;
  private static Set<IStatisticsObserver> g_observers = new HashSet();
  private final int NULL_TRACK_ID = 3917;
  private final boolean PER_STREAM_STATISTICS = false;
  final PeerConnection mPc;
  final IPeerConnectionTracker mPeerConnectionTracker;
  final AtomicBoolean mReschedule = new AtomicBoolean(true);
  StatisticsCollectorTask mStatisticsCollectorTask;
  Object mStatisticsCollectorTaskProtector = new Object();

  public StatisticsHelper(PeerConnection paramPeerConnection, IPeerConnectionTracker paramIPeerConnectionTracker)
  {
    this.mPc = paramPeerConnection;
    this.mPeerConnectionTracker = paramIPeerConnectionTracker;
  }

  public static void addObserver(IStatisticsObserver paramIStatisticsObserver)
  {
    synchronized (g_observers)
    {
      g_observers.add(paramIStatisticsObserver);
      return;
    }
  }

  private void cancelStatsUpdate(StatisticsCollectorTask paramStatisticsCollectorTask)
  {
    av.a(av.e.e).removeCallbacks(paramStatisticsCollectorTask);
  }

  private static void notifyObservers(final PCStatistics paramPCStatistics)
  {
    HashSet localHashSet;
    synchronized (g_observers)
    {
      localHashSet = new HashSet(g_observers);
      if (localHashSet.size() == 0)
        return;
    }
    Runnable local1 = new Runnable()
    {
      public void run()
      {
        Iterator localIterator = this.val$obs.iterator();
        while (localIterator.hasNext())
          ((StatisticsHelper.IStatisticsObserver)localIterator.next()).onNewStatisticsReport(paramPCStatistics);
      }
    };
    if (Thread.currentThread() == av.a(av.e.a).getLooper().getThread())
    {
      local1.run();
      return;
    }
    av.a(av.e.a).post(local1);
  }

  private void notifyStats(StatisticsCollectorTask paramStatisticsCollectorTask, StatsReport[] paramArrayOfStatsReport)
  {
    if (paramArrayOfStatsReport != null)
    {
      this.mPeerConnectionTracker.trackStatsReports(paramArrayOfStatsReport);
      notifyObservers(new PCStatistics(paramArrayOfStatsReport).publish());
    }
    synchronized (this.mReschedule)
    {
      if (this.mReschedule.get())
        scheduleStatsUpdate(paramStatisticsCollectorTask);
      return;
    }
  }

  public static void removeObserver(IStatisticsObserver paramIStatisticsObserver)
  {
    synchronized (g_observers)
    {
      g_observers.remove(paramIStatisticsObserver);
      return;
    }
  }

  private void scheduleStatsUpdate(StatisticsCollectorTask paramStatisticsCollectorTask)
  {
    synchronized (this.mReschedule)
    {
      if (!this.mReschedule.get())
        return;
      av.a(av.e.e).postDelayed(paramStatisticsCollectorTask, 1000L);
      return;
    }
  }

  public void cancelStreamStatistics(MediaStreamTrack paramMediaStreamTrack)
  {
    synchronized (this.mStatisticsCollectorTaskProtector)
    {
      cancelStatsUpdate(this.mStatisticsCollectorTask);
      return;
    }
  }

  public void dispose()
  {
    synchronized (this.mReschedule)
    {
      this.mReschedule.set(false);
      cancelStatsUpdate(this.mStatisticsCollectorTask);
      return;
    }
  }

  public void maybeScheduleStreamStatistics(MediaStreamTrack paramMediaStreamTrack)
  {
    synchronized (this.mReschedule)
    {
      synchronized (this.mStatisticsCollectorTaskProtector)
      {
        this.mStatisticsCollectorTask = new StatisticsCollectorTask(this, null, 3917);
        StatisticsCollectorTask localStatisticsCollectorTask = this.mStatisticsCollectorTask;
        if (localStatisticsCollectorTask != null)
        {
          this.mReschedule.set(true);
          scheduleStatsUpdate(localStatisticsCollectorTask);
        }
        return;
      }
    }
  }

  public static abstract interface IStatisticsObserver
  {
    public abstract void onNewStatisticsReport(PCStatistics paramPCStatistics);
  }

  private class StatisticsCollectorTask
    implements Runnable, StatsObserver
  {
    final StatisticsHelper mHelper;
    final int mId;
    final MediaStreamTrack mTrack;

    protected StatisticsCollectorTask(StatisticsHelper paramMediaStreamTrack, MediaStreamTrack paramInt, int arg4)
    {
      this.mHelper = paramMediaStreamTrack;
      this.mTrack = paramInt;
      int i;
      this.mId = i;
    }

    final int id()
    {
      return this.mId;
    }

    public void onComplete(StatsReport[] paramArrayOfStatsReport)
    {
      this.mHelper.notifyStats(this, paramArrayOfStatsReport);
    }

    public void run()
    {
      StatisticsHelper.this.mPc.getStats(this, this.mTrack);
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append("StatisticsCollectorTask:");
      if (this.mTrack != null);
      for (String str = this.mTrack.toString(); ; str = "global")
        return str;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.StatisticsHelper
 * JD-Core Version:    0.6.2
 */