package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.List;

@KeepForSdk
public class ConnectionTracker
{
  private static final Object zzdp = new Object();
  private static volatile ConnectionTracker zzfa;

  @VisibleForTesting
  private static boolean zzfb = false;
  private final List<String> zzfc = Collections.EMPTY_LIST;
  private final List<String> zzfd = Collections.EMPTY_LIST;
  private final List<String> zzfe = Collections.EMPTY_LIST;
  private final List<String> zzff = Collections.EMPTY_LIST;

  @KeepForSdk
  public static ConnectionTracker getInstance()
  {
    if (zzfa == null);
    synchronized (zzdp)
    {
      if (zzfa == null)
        zzfa = new ConnectionTracker();
      return zzfa;
    }
  }

  @KeepForSdk
  public boolean bindService(Context paramContext, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    return zza(paramContext, paramContext.getClass().getName(), paramIntent, paramServiceConnection, paramInt);
  }

  @SuppressLint({"UntrackedBindService"})
  @KeepForSdk
  public void unbindService(Context paramContext, ServiceConnection paramServiceConnection)
  {
    paramContext.unbindService(paramServiceConnection);
  }

  public final boolean zza(Context paramContext, String paramString, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    ComponentName localComponentName = paramIntent.getComponent();
    if (localComponentName == null);
    for (boolean bool = false; bool; bool = ClientLibraryUtils.zzc(paramContext, localComponentName.getPackageName()))
    {
      Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
      return false;
    }
    return paramContext.bindService(paramIntent, paramServiceConnection, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.stats.ConnectionTracker
 * JD-Core Version:    0.6.2
 */