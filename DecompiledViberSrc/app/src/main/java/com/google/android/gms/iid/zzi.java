package com.google.android.gms.iid;

import android.os.Binder;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.ExecutorService;

public final class zzi extends Binder
{
  private final zze zzbm;

  zzi(zze paramzze)
  {
    this.zzbm = paramzze;
  }

  public final void zzd(zzg paramzzg)
  {
    if (Binder.getCallingUid() != Process.myUid())
      throw new SecurityException("Binding only allowed within app");
    if (Log.isLoggable("EnhancedIntentService", 3))
      Log.d("EnhancedIntentService", "service received new intent via bind strategy");
    if (Log.isLoggable("EnhancedIntentService", 3))
      Log.d("EnhancedIntentService", "intent being queued for bg execution");
    this.zzbm.zzbb.execute(new zzj(this, paramzzg));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.iid.zzi
 * JD-Core Version:    0.6.2
 */