package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class zzdbg extends Handler
{
  private static volatile zzdbh zzgoy = null;

  public zzdbg()
  {
  }

  public zzdbg(Looper paramLooper)
  {
    super(paramLooper);
  }

  public final void dispatchMessage(Message paramMessage)
  {
    zzb(paramMessage);
  }

  protected void zzb(Message paramMessage)
  {
    super.dispatchMessage(paramMessage);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdbg
 * JD-Core Version:    0.6.2
 */