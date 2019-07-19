package com.google.android.gms.iid;

import android.content.Intent;
import android.util.Log;

final class zzh
  implements Runnable
{
  zzh(zzg paramzzg, Intent paramIntent)
  {
  }

  public final void run()
  {
    String str = this.zzbf.getAction();
    Log.w("EnhancedIntentService", 61 + String.valueOf(str).length() + "Service took too long to process intent: " + str + " App may get closed.");
    this.zzbl.finish();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.iid.zzh
 * JD-Core Version:    0.6.2
 */