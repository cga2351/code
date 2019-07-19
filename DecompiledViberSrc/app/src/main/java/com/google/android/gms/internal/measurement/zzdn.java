package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

public abstract interface zzdn extends IInterface
{
  public abstract void beginAdUnitExposure(String paramString, long paramLong)
    throws RemoteException;

  public abstract void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle)
    throws RemoteException;

  public abstract void endAdUnitExposure(String paramString, long paramLong)
    throws RemoteException;

  public abstract void generateEventId(zzdq paramzzdq)
    throws RemoteException;

  public abstract void getAppInstanceId(zzdq paramzzdq)
    throws RemoteException;

  public abstract void getCachedAppInstanceId(zzdq paramzzdq)
    throws RemoteException;

  public abstract void getConditionalUserProperties(String paramString1, String paramString2, zzdq paramzzdq)
    throws RemoteException;

  public abstract void getCurrentScreenClass(zzdq paramzzdq)
    throws RemoteException;

  public abstract void getCurrentScreenName(zzdq paramzzdq)
    throws RemoteException;

  public abstract void getGmpAppId(zzdq paramzzdq)
    throws RemoteException;

  public abstract void getMaxUserProperties(String paramString, zzdq paramzzdq)
    throws RemoteException;

  public abstract void getTestFlag(zzdq paramzzdq, int paramInt)
    throws RemoteException;

  public abstract void getUserProperties(String paramString1, String paramString2, boolean paramBoolean, zzdq paramzzdq)
    throws RemoteException;

  public abstract void initForTests(Map paramMap)
    throws RemoteException;

  public abstract void initialize(IObjectWrapper paramIObjectWrapper, zzdy paramzzdy, long paramLong)
    throws RemoteException;

  public abstract void logEvent(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
    throws RemoteException;

  public abstract void logEventAndBundle(String paramString1, String paramString2, Bundle paramBundle, zzdq paramzzdq, long paramLong)
    throws RemoteException;

  public abstract void logHealthData(int paramInt, String paramString, IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3)
    throws RemoteException;

  public abstract void onActivityCreated(IObjectWrapper paramIObjectWrapper, Bundle paramBundle, long paramLong)
    throws RemoteException;

  public abstract void onActivityDestroyed(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException;

  public abstract void onActivityPaused(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException;

  public abstract void onActivityResumed(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException;

  public abstract void onActivitySaveInstanceState(IObjectWrapper paramIObjectWrapper, zzdq paramzzdq, long paramLong)
    throws RemoteException;

  public abstract void onActivityStarted(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException;

  public abstract void onActivityStopped(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException;

  public abstract void performAction(Bundle paramBundle, zzdq paramzzdq, long paramLong)
    throws RemoteException;

  public abstract void registerOnMeasurementEventListener(zzdt paramzzdt)
    throws RemoteException;

  public abstract void resetAnalyticsData(long paramLong)
    throws RemoteException;

  public abstract void setConditionalUserProperty(Bundle paramBundle, long paramLong)
    throws RemoteException;

  public abstract void setCurrentScreen(IObjectWrapper paramIObjectWrapper, String paramString1, String paramString2, long paramLong)
    throws RemoteException;

  public abstract void setEventInterceptor(zzdt paramzzdt)
    throws RemoteException;

  public abstract void setInstanceIdProvider(zzdw paramzzdw)
    throws RemoteException;

  public abstract void setMeasurementEnabled(boolean paramBoolean, long paramLong)
    throws RemoteException;

  public abstract void setMinimumSessionDuration(long paramLong)
    throws RemoteException;

  public abstract void setSessionTimeoutDuration(long paramLong)
    throws RemoteException;

  public abstract void setUserId(String paramString, long paramLong)
    throws RemoteException;

  public abstract void setUserProperty(String paramString1, String paramString2, IObjectWrapper paramIObjectWrapper, boolean paramBoolean, long paramLong)
    throws RemoteException;

  public abstract void unregisterOnMeasurementEventListener(zzdt paramzzdt)
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzdn
 * JD-Core Version:    0.6.2
 */