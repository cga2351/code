package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.io.IOException;

@SuppressLint({"HandlerLeak"})
final class zzkb extends Handler
  implements Runnable
{
  private final zzkc zzaqk;
  private final zzka zzaql;
  private final int zzaqm;
  private volatile Thread zzaqn;

  public zzkb(zzjz paramzzjz, Looper paramLooper, zzkc paramzzkc, zzka paramzzka, int paramInt)
  {
    super(paramLooper);
    this.zzaqk = paramzzkc;
    this.zzaql = paramzzka;
    this.zzaqm = 0;
  }

  public final void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 2)
      throw ((Error)paramMessage.obj);
    zzjz.zza(this.zzaqo, false);
    zzjz.zza(this.zzaqo, null);
    if (this.zzaqk.zzfq())
    {
      this.zzaql.zzb(this.zzaqk);
      return;
    }
    switch (paramMessage.what)
    {
    default:
      return;
    case 0:
      this.zzaql.zza(this.zzaqk);
      return;
    case 1:
    }
    this.zzaql.zza(this.zzaqk, (IOException)paramMessage.obj);
  }

  public final void quit()
  {
    this.zzaqk.zzfp();
    if (this.zzaqn != null)
      this.zzaqn.interrupt();
  }

  public final void run()
  {
    try
    {
      this.zzaqn = Thread.currentThread();
      if (this.zzaqm > 0)
        Thread.sleep(this.zzaqm);
      if (!this.zzaqk.zzfq())
        this.zzaqk.zzfr();
      sendEmptyMessage(0);
      return;
    }
    catch (IOException localIOException)
    {
      obtainMessage(1, localIOException).sendToTarget();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      zzkh.checkState(this.zzaqk.zzfq());
      sendEmptyMessage(0);
      return;
    }
    catch (Exception localException)
    {
      Log.e("LoadTask", "Unexpected exception loading stream", localException);
      obtainMessage(1, new zzkd(localException)).sendToTarget();
      return;
    }
    catch (Error localError)
    {
      Log.e("LoadTask", "Unexpected error loading stream", localError);
      obtainMessage(2, localError).sendToTarget();
      throw localError;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzkb
 * JD-Core Version:    0.6.2
 */