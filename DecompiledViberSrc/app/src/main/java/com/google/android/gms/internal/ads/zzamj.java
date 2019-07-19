package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@zzare
public final class zzamj extends zzbjh
{
  private static final AtomicBoolean zzdef = new AtomicBoolean(false);
  private final AppMeasurementSdk zzdeg;

  private zzamj(AppMeasurementSdk paramAppMeasurementSdk)
  {
    this.zzdeg = paramAppMeasurementSdk;
  }

  public static void initialize(Context paramContext, String paramString)
  {
    if (!zzdef.compareAndSet(false, true))
      return;
    new Thread(new zzamk(paramContext, paramString)).start();
  }

  public final void beginAdUnitExposure(String paramString)
    throws RemoteException
  {
    this.zzdeg.beginAdUnitExposure(paramString);
  }

  public final void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle)
    throws RemoteException
  {
    this.zzdeg.clearConditionalUserProperty(paramString1, paramString2, paramBundle);
  }

  public final void endAdUnitExposure(String paramString)
    throws RemoteException
  {
    this.zzdeg.endAdUnitExposure(paramString);
  }

  public final long generateEventId()
    throws RemoteException
  {
    return this.zzdeg.generateEventId();
  }

  public final String getAppIdOrigin()
    throws RemoteException
  {
    return this.zzdeg.getAppIdOrigin();
  }

  public final String getAppInstanceId()
    throws RemoteException
  {
    return this.zzdeg.getAppInstanceId();
  }

  public final List getConditionalUserProperties(String paramString1, String paramString2)
    throws RemoteException
  {
    return this.zzdeg.getConditionalUserProperties(paramString1, paramString2);
  }

  public final String getCurrentScreenClass()
    throws RemoteException
  {
    return this.zzdeg.getCurrentScreenClass();
  }

  public final String getCurrentScreenName()
    throws RemoteException
  {
    return this.zzdeg.getCurrentScreenName();
  }

  public final String getGmpAppId()
    throws RemoteException
  {
    return this.zzdeg.getGmpAppId();
  }

  public final int getMaxUserProperties(String paramString)
    throws RemoteException
  {
    return this.zzdeg.getMaxUserProperties(paramString);
  }

  public final Map getUserProperties(String paramString1, String paramString2, boolean paramBoolean)
    throws RemoteException
  {
    return this.zzdeg.getUserProperties(paramString1, paramString2, paramBoolean);
  }

  public final void logEvent(String paramString1, String paramString2, Bundle paramBundle)
    throws RemoteException
  {
    this.zzdeg.logEvent(paramString1, paramString2, paramBundle);
  }

  public final void performAction(Bundle paramBundle)
    throws RemoteException
  {
    this.zzdeg.performAction(paramBundle);
  }

  public final Bundle performActionWithResponse(Bundle paramBundle)
    throws RemoteException
  {
    return this.zzdeg.performActionWithResponse(paramBundle);
  }

  public final void setConditionalUserProperty(Bundle paramBundle)
    throws RemoteException
  {
    this.zzdeg.setConditionalUserProperty(paramBundle);
  }

  public final void zza(String paramString1, String paramString2, IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    AppMeasurementSdk localAppMeasurementSdk = this.zzdeg;
    if (paramIObjectWrapper != null);
    for (Object localObject = ObjectWrapper.unwrap(paramIObjectWrapper); ; localObject = null)
    {
      localAppMeasurementSdk.setUserProperty(paramString1, paramString2, localObject);
      return;
    }
  }

  public final void zzb(IObjectWrapper paramIObjectWrapper, String paramString1, String paramString2)
    throws RemoteException
  {
    AppMeasurementSdk localAppMeasurementSdk = this.zzdeg;
    if (paramIObjectWrapper != null);
    for (Activity localActivity = (Activity)ObjectWrapper.unwrap(paramIObjectWrapper); ; localActivity = null)
    {
      localAppMeasurementSdk.setCurrentScreen(localActivity, paramString1, paramString2);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzamj
 * JD-Core Version:    0.6.2
 */