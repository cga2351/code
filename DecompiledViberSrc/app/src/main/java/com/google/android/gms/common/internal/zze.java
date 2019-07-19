package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.HashMap;
import javax.annotation.concurrent.GuardedBy;

final class zze extends GmsClientSupervisor
  implements Handler.Callback
{
  private final Handler mHandler;

  @GuardedBy("mConnectionStatus")
  private final HashMap<GmsClientSupervisor.zza, zzf> zzdu = new HashMap();
  private final Context zzdv;
  private final ConnectionTracker zzdw;
  private final long zzdx;
  private final long zzdy;

  zze(Context paramContext)
  {
    this.zzdv = paramContext.getApplicationContext();
    this.mHandler = new com.google.android.gms.internal.common.zze(paramContext.getMainLooper(), this);
    this.zzdw = ConnectionTracker.getInstance();
    this.zzdx = 5000L;
    this.zzdy = 300000L;
  }

  public final boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      return false;
    case 0:
      synchronized (this.zzdu)
      {
        GmsClientSupervisor.zza localzza2 = (GmsClientSupervisor.zza)paramMessage.obj;
        zzf localzzf2 = (zzf)this.zzdu.get(localzza2);
        if ((localzzf2 != null) && (localzzf2.zzr()))
        {
          if (localzzf2.isBound())
            localzzf2.zzf("GmsClientSupervisor");
          this.zzdu.remove(localzza2);
        }
        return true;
      }
    case 1:
    }
    while (true)
    {
      ComponentName localComponentName1;
      synchronized (this.zzdu)
      {
        GmsClientSupervisor.zza localzza1 = (GmsClientSupervisor.zza)paramMessage.obj;
        zzf localzzf1 = (zzf)this.zzdu.get(localzza1);
        if ((localzzf1 != null) && (localzzf1.getState() == 3))
        {
          String str = String.valueOf(localzza1);
          Log.wtf("GmsClientSupervisor", 47 + String.valueOf(str).length() + "Timeout waiting for ServiceConnection callback " + str, new Exception());
          localComponentName1 = localzzf1.getComponentName();
          if (localComponentName1 == null)
            localComponentName1 = localzza1.getComponentName();
          if (localComponentName1 == null)
          {
            localComponentName2 = new ComponentName(localzza1.getPackage(), "unknown");
            localzzf1.onServiceDisconnected(localComponentName2);
          }
        }
        else
        {
          return true;
        }
      }
      ComponentName localComponentName2 = localComponentName1;
    }
  }

  protected final boolean zza(GmsClientSupervisor.zza paramzza, ServiceConnection paramServiceConnection, String paramString)
  {
    Preconditions.checkNotNull(paramServiceConnection, "ServiceConnection must not be null");
    while (true)
    {
      zzf localzzf;
      synchronized (this.zzdu)
      {
        localzzf = (zzf)this.zzdu.get(paramzza);
        if (localzzf == null)
        {
          localzzf = new zzf(this, paramzza);
          localzzf.zza(paramServiceConnection, paramString);
          localzzf.zze(paramString);
          this.zzdu.put(paramzza, localzzf);
          boolean bool = localzzf.isBound();
          return bool;
        }
        this.mHandler.removeMessages(0, paramzza);
        if (localzzf.zza(paramServiceConnection))
        {
          String str = String.valueOf(paramzza);
          throw new IllegalStateException(81 + String.valueOf(str).length() + "Trying to bind a GmsServiceConnection that was already connected before.  config=" + str);
        }
      }
      localzzf.zza(paramServiceConnection, paramString);
      switch (localzzf.getState())
      {
      case 1:
        paramServiceConnection.onServiceConnected(localzzf.getComponentName(), localzzf.getBinder());
        break;
      case 2:
        localzzf.zze(paramString);
      }
    }
  }

  protected final void zzb(GmsClientSupervisor.zza paramzza, ServiceConnection paramServiceConnection, String paramString)
  {
    Preconditions.checkNotNull(paramServiceConnection, "ServiceConnection must not be null");
    zzf localzzf;
    synchronized (this.zzdu)
    {
      localzzf = (zzf)this.zzdu.get(paramzza);
      if (localzzf == null)
      {
        String str1 = String.valueOf(paramzza);
        throw new IllegalStateException(50 + String.valueOf(str1).length() + "Nonexistent connection status for service config: " + str1);
      }
    }
    if (!localzzf.zza(paramServiceConnection))
    {
      String str2 = String.valueOf(paramzza);
      throw new IllegalStateException(76 + String.valueOf(str2).length() + "Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + str2);
    }
    localzzf.zzb(paramServiceConnection, paramString);
    if (localzzf.zzr())
    {
      Message localMessage = this.mHandler.obtainMessage(0, paramzza);
      this.mHandler.sendMessageDelayed(localMessage, this.zzdx);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.zze
 * JD-Core Version:    0.6.2
 */