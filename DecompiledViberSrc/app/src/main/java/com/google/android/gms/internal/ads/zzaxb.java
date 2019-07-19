package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.ads.internal.zzk;

@zzare
public final class zzaxb extends zzdbg
{
  public zzaxb(Looper paramLooper)
  {
    super(paramLooper);
  }

  public final void handleMessage(Message paramMessage)
  {
    try
    {
      super.handleMessage(paramMessage);
      return;
    }
    catch (Exception localException)
    {
      zzk.zzlk().zza(localException, "AdMobHandler.handleMessage");
    }
  }

  protected final void zzb(Message paramMessage)
  {
    try
    {
      super.zzb(paramMessage);
      return;
    }
    catch (Throwable localThrowable)
    {
      zzk.zzlg();
      zzaxj.zza(zzk.zzlk().getApplicationContext(), localThrowable);
      throw localThrowable;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaxb
 * JD-Core Version:    0.6.2
 */