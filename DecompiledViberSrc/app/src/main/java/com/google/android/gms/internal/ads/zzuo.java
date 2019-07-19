package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.google.android.gms.common.util.PlatformVersion;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@zzare
@ParametersAreNonnullByDefault
public final class zzuo
{
  private final Object zzbur = new Object();

  @GuardedBy("activityTrackerLock")
  private zzup zzbus = null;

  @GuardedBy("activityTrackerLock")
  private boolean zzbut = false;

  public final Activity getActivity()
  {
    synchronized (this.zzbur)
    {
      if (!PlatformVersion.isAtLeastIceCreamSandwich())
        return null;
      if (this.zzbus != null)
      {
        Activity localActivity = this.zzbus.getActivity();
        return localActivity;
      }
    }
    return null;
  }

  public final Context getContext()
  {
    synchronized (this.zzbur)
    {
      if (!PlatformVersion.isAtLeastIceCreamSandwich())
        return null;
      if (this.zzbus != null)
      {
        Context localContext = this.zzbus.getContext();
        return localContext;
      }
    }
    return null;
  }

  public final void initialize(Context paramContext)
  {
    while (true)
    {
      synchronized (this.zzbur)
      {
        if (this.zzbut)
          break label103;
        if (!PlatformVersion.isAtLeastIceCreamSandwich())
          return;
        Context localContext = paramContext.getApplicationContext();
        if (localContext == null)
          localContext = paramContext;
        if (!(localContext instanceof Application))
          break label106;
        localApplication = (Application)localContext;
        if (localApplication == null)
        {
          zzaxa.zzep("Can not cast Context to Application");
          return;
        }
      }
      if (this.zzbus == null)
        this.zzbus = new zzup();
      this.zzbus.zza(localApplication, paramContext);
      this.zzbut = true;
      label103: return;
      label106: Application localApplication = null;
    }
  }

  public final void zza(zzur paramzzur)
  {
    synchronized (this.zzbur)
    {
      if (!PlatformVersion.isAtLeastIceCreamSandwich())
        return;
      if (this.zzbus == null)
        this.zzbus = new zzup();
      this.zzbus.zza(paramzzur);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzuo
 * JD-Core Version:    0.6.2
 */