package com.google.android.gms.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

final class zzah extends BroadcastReceiver
{
  zzah(zzaf paramzzaf)
  {
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (Log.isLoggable("InstanceID", 3))
      Log.d("InstanceID", "Received GSF callback via dynamic receiver");
    this.zzdc.zzh(paramIntent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.iid.zzah
 * JD-Core Version:    0.6.2
 */