package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class zzaxo extends BroadcastReceiver
{
  private zzaxo(zzaxj paramzzaxj)
  {
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.intent.action.USER_PRESENT".equals(paramIntent.getAction()))
      zzaxj.zza(this.zzdwb, true);
    while (!"android.intent.action.SCREEN_OFF".equals(paramIntent.getAction()))
      return;
    zzaxj.zza(this.zzdwb, false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaxo
 * JD-Core Version:    0.6.2
 */