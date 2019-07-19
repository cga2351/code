package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.measurement.zzu;
import com.google.android.gms.internal.measurement.zzv;

public final class zzbk
  implements ServiceConnection
{
  private final String packageName;

  zzbk(zzbj paramzzbj, String paramString)
  {
    this.packageName = paramString;
  }

  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (paramIBinder == null)
    {
      this.zzaoc.zzada.zzgt().zzjj().zzby("Install Referrer connection returned with null binder");
      return;
    }
    zzu localzzu;
    try
    {
      localzzu = zzv.zza(paramIBinder);
      if (localzzu == null)
      {
        this.zzaoc.zzada.zzgt().zzjj().zzby("Install Referrer Service implementation was not found");
        return;
      }
    }
    catch (Exception localException)
    {
      this.zzaoc.zzada.zzgt().zzjj().zzg("Exception occurred while calling Install Referrer API", localException);
      return;
    }
    this.zzaoc.zzada.zzgt().zzjm().zzby("Install Referrer Service connected");
    this.zzaoc.zzada.zzgs().zzc(new zzbl(this, localzzu, this));
  }

  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.zzaoc.zzada.zzgt().zzjm().zzby("Install Referrer Service disconnected");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzbk
 * JD-Core Version:    0.6.2
 */