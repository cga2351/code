package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

public final class zzdp extends zzq
  implements zzdn
{
  zzdp(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
  }

  public final void beginAdUnitExposure(String paramString, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString);
    localParcel.writeLong(paramLong);
    zza(23, localParcel);
  }

  public final void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzs.zza(localParcel, paramBundle);
    zza(9, localParcel);
  }

  public final void endAdUnitExposure(String paramString, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString);
    localParcel.writeLong(paramLong);
    zza(24, localParcel);
  }

  public final void generateEventId(zzdq paramzzdq)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel, paramzzdq);
    zza(22, localParcel);
  }

  public final void getAppInstanceId(zzdq paramzzdq)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel, paramzzdq);
    zza(20, localParcel);
  }

  public final void getCachedAppInstanceId(zzdq paramzzdq)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel, paramzzdq);
    zza(19, localParcel);
  }

  public final void getConditionalUserProperties(String paramString1, String paramString2, zzdq paramzzdq)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzs.zza(localParcel, paramzzdq);
    zza(10, localParcel);
  }

  public final void getCurrentScreenClass(zzdq paramzzdq)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel, paramzzdq);
    zza(17, localParcel);
  }

  public final void getCurrentScreenName(zzdq paramzzdq)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel, paramzzdq);
    zza(16, localParcel);
  }

  public final void getGmpAppId(zzdq paramzzdq)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel, paramzzdq);
    zza(21, localParcel);
  }

  public final void getMaxUserProperties(String paramString, zzdq paramzzdq)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString);
    zzs.zza(localParcel, paramzzdq);
    zza(6, localParcel);
  }

  public final void getTestFlag(zzdq paramzzdq, int paramInt)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel, paramzzdq);
    localParcel.writeInt(paramInt);
    zza(38, localParcel);
  }

  public final void getUserProperties(String paramString1, String paramString2, boolean paramBoolean, zzdq paramzzdq)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzs.writeBoolean(localParcel, paramBoolean);
    zzs.zza(localParcel, paramzzdq);
    zza(5, localParcel);
  }

  public final void initForTests(Map paramMap)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeMap(paramMap);
    zza(37, localParcel);
  }

  public final void initialize(IObjectWrapper paramIObjectWrapper, zzdy paramzzdy, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel, paramIObjectWrapper);
    zzs.zza(localParcel, paramzzdy);
    localParcel.writeLong(paramLong);
    zza(1, localParcel);
  }

  public final void logEvent(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzs.zza(localParcel, paramBundle);
    zzs.writeBoolean(localParcel, paramBoolean1);
    zzs.writeBoolean(localParcel, paramBoolean2);
    localParcel.writeLong(paramLong);
    zza(2, localParcel);
  }

  public final void logEventAndBundle(String paramString1, String paramString2, Bundle paramBundle, zzdq paramzzdq, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzs.zza(localParcel, paramBundle);
    zzs.zza(localParcel, paramzzdq);
    localParcel.writeLong(paramLong);
    zza(3, localParcel);
  }

  public final void logHealthData(int paramInt, String paramString, IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeInt(paramInt);
    localParcel.writeString(paramString);
    zzs.zza(localParcel, paramIObjectWrapper1);
    zzs.zza(localParcel, paramIObjectWrapper2);
    zzs.zza(localParcel, paramIObjectWrapper3);
    zza(33, localParcel);
  }

  public final void onActivityCreated(IObjectWrapper paramIObjectWrapper, Bundle paramBundle, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel, paramIObjectWrapper);
    zzs.zza(localParcel, paramBundle);
    localParcel.writeLong(paramLong);
    zza(27, localParcel);
  }

  public final void onActivityDestroyed(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel, paramIObjectWrapper);
    localParcel.writeLong(paramLong);
    zza(28, localParcel);
  }

  public final void onActivityPaused(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel, paramIObjectWrapper);
    localParcel.writeLong(paramLong);
    zza(29, localParcel);
  }

  public final void onActivityResumed(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel, paramIObjectWrapper);
    localParcel.writeLong(paramLong);
    zza(30, localParcel);
  }

  public final void onActivitySaveInstanceState(IObjectWrapper paramIObjectWrapper, zzdq paramzzdq, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel, paramIObjectWrapper);
    zzs.zza(localParcel, paramzzdq);
    localParcel.writeLong(paramLong);
    zza(31, localParcel);
  }

  public final void onActivityStarted(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel, paramIObjectWrapper);
    localParcel.writeLong(paramLong);
    zza(25, localParcel);
  }

  public final void onActivityStopped(IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel, paramIObjectWrapper);
    localParcel.writeLong(paramLong);
    zza(26, localParcel);
  }

  public final void performAction(Bundle paramBundle, zzdq paramzzdq, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel, paramBundle);
    zzs.zza(localParcel, paramzzdq);
    localParcel.writeLong(paramLong);
    zza(32, localParcel);
  }

  public final void registerOnMeasurementEventListener(zzdt paramzzdt)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel, paramzzdt);
    zza(35, localParcel);
  }

  public final void resetAnalyticsData(long paramLong)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeLong(paramLong);
    zza(12, localParcel);
  }

  public final void setConditionalUserProperty(Bundle paramBundle, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel, paramBundle);
    localParcel.writeLong(paramLong);
    zza(8, localParcel);
  }

  public final void setCurrentScreen(IObjectWrapper paramIObjectWrapper, String paramString1, String paramString2, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel, paramIObjectWrapper);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    localParcel.writeLong(paramLong);
    zza(15, localParcel);
  }

  public final void setEventInterceptor(zzdt paramzzdt)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel, paramzzdt);
    zza(34, localParcel);
  }

  public final void setInstanceIdProvider(zzdw paramzzdw)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel, paramzzdw);
    zza(18, localParcel);
  }

  public final void setMeasurementEnabled(boolean paramBoolean, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzs.writeBoolean(localParcel, paramBoolean);
    localParcel.writeLong(paramLong);
    zza(11, localParcel);
  }

  public final void setMinimumSessionDuration(long paramLong)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeLong(paramLong);
    zza(13, localParcel);
  }

  public final void setSessionTimeoutDuration(long paramLong)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeLong(paramLong);
    zza(14, localParcel);
  }

  public final void setUserId(String paramString, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString);
    localParcel.writeLong(paramLong);
    zza(7, localParcel);
  }

  public final void setUserProperty(String paramString1, String paramString2, IObjectWrapper paramIObjectWrapper, boolean paramBoolean, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzs.zza(localParcel, paramIObjectWrapper);
    zzs.writeBoolean(localParcel, paramBoolean);
    localParcel.writeLong(paramLong);
    zza(4, localParcel);
  }

  public final void unregisterOnMeasurementEventListener(zzdt paramzzdt)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzs.zza(localParcel, paramzzdt);
    zza(36, localParcel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzdp
 * JD-Core Version:    0.6.2
 */