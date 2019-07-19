package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import java.util.List;
import java.util.Map;

public abstract class zzbjh extends zzfn
  implements zzbjg
{
  public zzbjh()
  {
    super("com.google.android.gms.ads.measurement.IAppMeasurementProxy");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      performAction((Bundle)zzfo.zza(paramParcel1, Bundle.CREATOR));
      paramParcel2.writeNoException();
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
    }
    while (true)
    {
      return true;
      Bundle localBundle = performActionWithResponse((Bundle)zzfo.zza(paramParcel1, Bundle.CREATOR));
      paramParcel2.writeNoException();
      zzfo.zzb(paramParcel2, localBundle);
      continue;
      logEvent(paramParcel1.readString(), paramParcel1.readString(), (Bundle)zzfo.zza(paramParcel1, Bundle.CREATOR));
      paramParcel2.writeNoException();
      continue;
      zza(paramParcel1.readString(), paramParcel1.readString(), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      Map localMap = getUserProperties(paramParcel1.readString(), paramParcel1.readString(), zzfo.zza(paramParcel1));
      paramParcel2.writeNoException();
      paramParcel2.writeMap(localMap);
      continue;
      int i = getMaxUserProperties(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(i);
      continue;
      setConditionalUserProperty((Bundle)zzfo.zza(paramParcel1, Bundle.CREATOR));
      paramParcel2.writeNoException();
      continue;
      clearConditionalUserProperty(paramParcel1.readString(), paramParcel1.readString(), (Bundle)zzfo.zza(paramParcel1, Bundle.CREATOR));
      paramParcel2.writeNoException();
      continue;
      List localList = getConditionalUserProperties(paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeList(localList);
      continue;
      String str5 = getAppInstanceId();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str5);
      continue;
      String str4 = getGmpAppId();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str4);
      continue;
      long l = generateEventId();
      paramParcel2.writeNoException();
      paramParcel2.writeLong(l);
      continue;
      beginAdUnitExposure(paramParcel1.readString());
      paramParcel2.writeNoException();
      continue;
      endAdUnitExposure(paramParcel1.readString());
      paramParcel2.writeNoException();
      continue;
      zzb(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      continue;
      String str3 = getCurrentScreenName();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str3);
      continue;
      String str2 = getCurrentScreenClass();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str2);
      continue;
      String str1 = getAppIdOrigin();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str1);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbjh
 * JD-Core Version:    0.6.2
 */