package com.google.android.gms.iid;

import android.util.Log;

final class zzj
  implements Runnable
{
  zzj(zzi paramzzi, zzg paramzzg)
  {
  }

  public final void run()
  {
    if (Log.isLoggable("EnhancedIntentService", 3))
      Log.d("EnhancedIntentService", "bg processing of the intent starting now");
    zzi.zzd(this.zzbo).handleIntent(this.zzbn.intent);
    this.zzbn.finish();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.iid.zzj
 * JD-Core Version:    0.6.2
 */