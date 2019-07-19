package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

public abstract class zzdo extends zzr
  implements zzdn
{
  public zzdo()
  {
    super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
  }

  public static zzdn asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    if ((localIInterface instanceof zzdn))
      return (zzdn)localIInterface;
    return new zzdp(paramIBinder);
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      initialize(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), (zzdy)zzs.zza(paramParcel1, zzdy.CREATOR), paramParcel1.readLong());
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    case 10:
    case 11:
    case 12:
    case 13:
    case 14:
    case 15:
    case 16:
    case 17:
    case 18:
    case 19:
    case 20:
    case 21:
    case 22:
    case 23:
    case 24:
    case 25:
    case 26:
    case 27:
    case 28:
    case 29:
    case 30:
    case 31:
    case 32:
    case 33:
    case 34:
    case 35:
    case 36:
    case 37:
      while (true)
      {
        paramParcel2.writeNoException();
        return true;
        logEvent(paramParcel1.readString(), paramParcel1.readString(), (Bundle)zzs.zza(paramParcel1, Bundle.CREATOR), zzs.zza(paramParcel1), zzs.zza(paramParcel1), paramParcel1.readLong());
        continue;
        String str6 = paramParcel1.readString();
        String str7 = paramParcel1.readString();
        Bundle localBundle2 = (Bundle)zzs.zza(paramParcel1, Bundle.CREATOR);
        IBinder localIBinder17 = paramParcel1.readStrongBinder();
        Object localObject17 = null;
        if (localIBinder17 == null);
        while (true)
        {
          logEventAndBundle(str6, str7, localBundle2, (zzdq)localObject17, paramParcel1.readLong());
          break;
          IInterface localIInterface17 = localIBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
          if ((localIInterface17 instanceof zzdq))
            localObject17 = (zzdq)localIInterface17;
          else
            localObject17 = new zzds(localIBinder17);
        }
        setUserProperty(paramParcel1.readString(), paramParcel1.readString(), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), zzs.zza(paramParcel1), paramParcel1.readLong());
        continue;
        String str4 = paramParcel1.readString();
        String str5 = paramParcel1.readString();
        boolean bool = zzs.zza(paramParcel1);
        IBinder localIBinder16 = paramParcel1.readStrongBinder();
        Object localObject16 = null;
        if (localIBinder16 == null);
        while (true)
        {
          getUserProperties(str4, str5, bool, (zzdq)localObject16);
          break;
          IInterface localIInterface16 = localIBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
          if ((localIInterface16 instanceof zzdq))
            localObject16 = (zzdq)localIInterface16;
          else
            localObject16 = new zzds(localIBinder16);
        }
        String str3 = paramParcel1.readString();
        IBinder localIBinder15 = paramParcel1.readStrongBinder();
        Object localObject15 = null;
        if (localIBinder15 == null);
        while (true)
        {
          getMaxUserProperties(str3, (zzdq)localObject15);
          break;
          IInterface localIInterface15 = localIBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
          if ((localIInterface15 instanceof zzdq))
            localObject15 = (zzdq)localIInterface15;
          else
            localObject15 = new zzds(localIBinder15);
        }
        setUserId(paramParcel1.readString(), paramParcel1.readLong());
        continue;
        setConditionalUserProperty((Bundle)zzs.zza(paramParcel1, Bundle.CREATOR), paramParcel1.readLong());
        continue;
        clearConditionalUserProperty(paramParcel1.readString(), paramParcel1.readString(), (Bundle)zzs.zza(paramParcel1, Bundle.CREATOR));
        continue;
        String str1 = paramParcel1.readString();
        String str2 = paramParcel1.readString();
        IBinder localIBinder14 = paramParcel1.readStrongBinder();
        Object localObject14 = null;
        if (localIBinder14 == null);
        while (true)
        {
          getConditionalUserProperties(str1, str2, (zzdq)localObject14);
          break;
          IInterface localIInterface14 = localIBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
          if ((localIInterface14 instanceof zzdq))
            localObject14 = (zzdq)localIInterface14;
          else
            localObject14 = new zzds(localIBinder14);
        }
        setMeasurementEnabled(zzs.zza(paramParcel1), paramParcel1.readLong());
        continue;
        resetAnalyticsData(paramParcel1.readLong());
        continue;
        setMinimumSessionDuration(paramParcel1.readLong());
        continue;
        setSessionTimeoutDuration(paramParcel1.readLong());
        continue;
        setCurrentScreen(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readLong());
        continue;
        IBinder localIBinder13 = paramParcel1.readStrongBinder();
        Object localObject13 = null;
        if (localIBinder13 == null);
        while (true)
        {
          getCurrentScreenName((zzdq)localObject13);
          break;
          IInterface localIInterface13 = localIBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
          if ((localIInterface13 instanceof zzdq))
            localObject13 = (zzdq)localIInterface13;
          else
            localObject13 = new zzds(localIBinder13);
        }
        IBinder localIBinder12 = paramParcel1.readStrongBinder();
        Object localObject12 = null;
        if (localIBinder12 == null);
        while (true)
        {
          getCurrentScreenClass((zzdq)localObject12);
          break;
          IInterface localIInterface12 = localIBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
          if ((localIInterface12 instanceof zzdq))
            localObject12 = (zzdq)localIInterface12;
          else
            localObject12 = new zzds(localIBinder12);
        }
        IBinder localIBinder11 = paramParcel1.readStrongBinder();
        Object localObject11 = null;
        if (localIBinder11 == null);
        while (true)
        {
          setInstanceIdProvider((zzdw)localObject11);
          break;
          IInterface localIInterface11 = localIBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
          if ((localIInterface11 instanceof zzdw))
            localObject11 = (zzdw)localIInterface11;
          else
            localObject11 = new zzdx(localIBinder11);
        }
        IBinder localIBinder10 = paramParcel1.readStrongBinder();
        Object localObject10 = null;
        if (localIBinder10 == null);
        while (true)
        {
          getCachedAppInstanceId((zzdq)localObject10);
          break;
          IInterface localIInterface10 = localIBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
          if ((localIInterface10 instanceof zzdq))
            localObject10 = (zzdq)localIInterface10;
          else
            localObject10 = new zzds(localIBinder10);
        }
        IBinder localIBinder9 = paramParcel1.readStrongBinder();
        Object localObject9 = null;
        if (localIBinder9 == null);
        while (true)
        {
          getAppInstanceId((zzdq)localObject9);
          break;
          IInterface localIInterface9 = localIBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
          if ((localIInterface9 instanceof zzdq))
            localObject9 = (zzdq)localIInterface9;
          else
            localObject9 = new zzds(localIBinder9);
        }
        IBinder localIBinder8 = paramParcel1.readStrongBinder();
        Object localObject8 = null;
        if (localIBinder8 == null);
        while (true)
        {
          getGmpAppId((zzdq)localObject8);
          break;
          IInterface localIInterface8 = localIBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
          if ((localIInterface8 instanceof zzdq))
            localObject8 = (zzdq)localIInterface8;
          else
            localObject8 = new zzds(localIBinder8);
        }
        IBinder localIBinder7 = paramParcel1.readStrongBinder();
        Object localObject7 = null;
        if (localIBinder7 == null);
        while (true)
        {
          generateEventId((zzdq)localObject7);
          break;
          IInterface localIInterface7 = localIBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
          if ((localIInterface7 instanceof zzdq))
            localObject7 = (zzdq)localIInterface7;
          else
            localObject7 = new zzds(localIBinder7);
        }
        beginAdUnitExposure(paramParcel1.readString(), paramParcel1.readLong());
        continue;
        endAdUnitExposure(paramParcel1.readString(), paramParcel1.readLong());
        continue;
        onActivityStarted(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readLong());
        continue;
        onActivityStopped(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readLong());
        continue;
        onActivityCreated(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), (Bundle)zzs.zza(paramParcel1, Bundle.CREATOR), paramParcel1.readLong());
        continue;
        onActivityDestroyed(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readLong());
        continue;
        onActivityPaused(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readLong());
        continue;
        onActivityResumed(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readLong());
        continue;
        IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder());
        IBinder localIBinder6 = paramParcel1.readStrongBinder();
        Object localObject6 = null;
        if (localIBinder6 == null);
        while (true)
        {
          onActivitySaveInstanceState(localIObjectWrapper, (zzdq)localObject6, paramParcel1.readLong());
          break;
          IInterface localIInterface6 = localIBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
          if ((localIInterface6 instanceof zzdq))
            localObject6 = (zzdq)localIInterface6;
          else
            localObject6 = new zzds(localIBinder6);
        }
        Bundle localBundle1 = (Bundle)zzs.zza(paramParcel1, Bundle.CREATOR);
        IBinder localIBinder5 = paramParcel1.readStrongBinder();
        Object localObject5 = null;
        if (localIBinder5 == null);
        while (true)
        {
          performAction(localBundle1, (zzdq)localObject5, paramParcel1.readLong());
          break;
          IInterface localIInterface5 = localIBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
          if ((localIInterface5 instanceof zzdq))
            localObject5 = (zzdq)localIInterface5;
          else
            localObject5 = new zzds(localIBinder5);
        }
        logHealthData(paramParcel1.readInt(), paramParcel1.readString(), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
        continue;
        IBinder localIBinder4 = paramParcel1.readStrongBinder();
        Object localObject4 = null;
        if (localIBinder4 == null);
        while (true)
        {
          setEventInterceptor((zzdt)localObject4);
          break;
          IInterface localIInterface4 = localIBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
          if ((localIInterface4 instanceof zzdt))
            localObject4 = (zzdt)localIInterface4;
          else
            localObject4 = new zzdv(localIBinder4);
        }
        IBinder localIBinder3 = paramParcel1.readStrongBinder();
        Object localObject3 = null;
        if (localIBinder3 == null);
        while (true)
        {
          registerOnMeasurementEventListener((zzdt)localObject3);
          break;
          IInterface localIInterface3 = localIBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
          if ((localIInterface3 instanceof zzdt))
            localObject3 = (zzdt)localIInterface3;
          else
            localObject3 = new zzdv(localIBinder3);
        }
        IBinder localIBinder2 = paramParcel1.readStrongBinder();
        Object localObject2 = null;
        if (localIBinder2 == null);
        while (true)
        {
          unregisterOnMeasurementEventListener((zzdt)localObject2);
          break;
          IInterface localIInterface2 = localIBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
          if ((localIInterface2 instanceof zzdt))
            localObject2 = (zzdt)localIInterface2;
          else
            localObject2 = new zzdv(localIBinder2);
        }
        initForTests(zzs.zzb(paramParcel1));
      }
    case 38:
    }
    IBinder localIBinder1 = paramParcel1.readStrongBinder();
    Object localObject1 = null;
    if (localIBinder1 == null);
    while (true)
    {
      getTestFlag((zzdq)localObject1, paramParcel1.readInt());
      break;
      IInterface localIInterface1 = localIBinder1.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
      if ((localIInterface1 instanceof zzdq))
        localObject1 = (zzdq)localIInterface1;
      else
        localObject1 = new zzds(localIBinder1);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzdo
 * JD-Core Version:    0.6.2
 */