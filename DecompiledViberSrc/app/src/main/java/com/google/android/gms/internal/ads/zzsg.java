package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

@SuppressLint({"HandlerLeak"})
final class zzsg<T extends zzsh> extends Handler
  implements Runnable
{
  private volatile boolean zzacf;
  private volatile Thread zzaqn;
  private final T zzbmt;
  private final zzsf<T> zzbmu;
  public final int zzbmv;
  private final long zzbmw;
  private IOException zzbmx;
  private int zzbmy;

  public zzsg(Looper paramLooper, T paramT, zzsf<T> paramzzsf, int paramInt, long paramLong)
  {
    super(paramT);
    this.zzbmt = paramzzsf;
    this.zzbmu = paramInt;
    this.zzbmv = paramLong;
    Object localObject;
    this.zzbmw = localObject;
  }

  private final void execute()
  {
    this.zzbmx = null;
    zzse.zzb(this.zzbmz).execute(zzse.zza(this.zzbmz));
  }

  private final void finish()
  {
    zzse.zza(this.zzbmz, null);
  }

  public final void handleMessage(Message paramMessage)
  {
    if (this.zzacf);
    int i;
    do
    {
      return;
      if (paramMessage.what == 0)
      {
        execute();
        return;
      }
      if (paramMessage.what == 4)
        throw ((Error)paramMessage.obj);
      finish();
      long l1 = SystemClock.elapsedRealtime();
      long l2 = l1 - this.zzbmw;
      if (this.zzbmt.zzfq())
      {
        this.zzbmu.zza(this.zzbmt, l1, l2, false);
        return;
      }
      switch (paramMessage.what)
      {
      default:
        return;
      case 1:
        this.zzbmu.zza(this.zzbmt, l1, l2, false);
        return;
      case 2:
        this.zzbmu.zza(this.zzbmt, l1, l2);
        return;
      case 3:
      }
      this.zzbmx = ((IOException)paramMessage.obj);
      i = this.zzbmu.zza(this.zzbmt, l1, l2, this.zzbmx);
      if (i == 3)
      {
        zzse.zza(this.zzbmz, this.zzbmx);
        return;
      }
    }
    while (i == 2);
    if (i == 1);
    for (int j = 1; ; j = 1 + this.zzbmy)
    {
      this.zzbmy = j;
      zzeq(Math.min(1000 * (-1 + this.zzbmy), 5000));
      return;
    }
  }

  public final void run()
  {
    try
    {
      this.zzaqn = Thread.currentThread();
      if (!this.zzbmt.zzfq())
      {
        String str1 = String.valueOf(this.zzbmt.getClass().getSimpleName());
        if (str1.length() == 0)
          break label82;
        str2 = "load:".concat(str1);
        zzsx.beginSection(str2);
      }
    }
    catch (IOException localIOException)
    {
      try
      {
        while (true)
        {
          this.zzbmt.zzfr();
          zzsx.endSection();
          if (this.zzacf)
            break;
          sendEmptyMessage(2);
          return;
          String str2 = new String("load:");
        }
        localIOException = localIOException;
        if (!this.zzacf)
        {
          obtainMessage(3, localIOException).sendToTarget();
          return;
        }
      }
      finally
      {
        zzsx.endSection();
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      zzsk.checkState(this.zzbmt.zzfq());
      if (!this.zzacf)
      {
        sendEmptyMessage(2);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.e("LoadTask", "Unexpected exception loading stream", localException);
      if (!this.zzacf)
      {
        obtainMessage(3, new zzsi(localException)).sendToTarget();
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Log.e("LoadTask", "OutOfMemory error loading stream", localOutOfMemoryError);
      if (!this.zzacf)
      {
        obtainMessage(3, new zzsi(localOutOfMemoryError)).sendToTarget();
        return;
      }
    }
    catch (Error localError)
    {
      label82: Log.e("LoadTask", "Unexpected error loading stream", localError);
      if (!this.zzacf)
        obtainMessage(4, localError).sendToTarget();
      throw localError;
    }
  }

  public final void zzbm(int paramInt)
    throws IOException
  {
    if ((this.zzbmx != null) && (this.zzbmy > paramInt))
      throw this.zzbmx;
  }

  public final void zzeq(long paramLong)
  {
    if (zzse.zza(this.zzbmz) == null);
    for (boolean bool = true; ; bool = false)
    {
      zzsk.checkState(bool);
      zzse.zza(this.zzbmz, this);
      if (paramLong <= 0L)
        break;
      sendEmptyMessageDelayed(0, paramLong);
      return;
    }
    execute();
  }

  public final void zzl(boolean paramBoolean)
  {
    this.zzacf = paramBoolean;
    this.zzbmx = null;
    if (hasMessages(0))
    {
      removeMessages(0);
      if (!paramBoolean)
        sendEmptyMessage(1);
    }
    while (true)
    {
      if (paramBoolean)
      {
        finish();
        long l = SystemClock.elapsedRealtime();
        this.zzbmu.zza(this.zzbmt, l, l - this.zzbmw, true);
      }
      return;
      this.zzbmt.zzfp();
      if (this.zzaqn != null)
        this.zzaqn.interrupt();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzsg
 * JD-Core Version:    0.6.2
 */