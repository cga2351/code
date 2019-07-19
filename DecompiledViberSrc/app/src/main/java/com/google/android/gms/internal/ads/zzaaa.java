package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import java.util.List;

public abstract class zzaaa extends zzfn
  implements zzzz
{
  public zzaaa()
  {
    super("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      zza();
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
    }
    while (true)
    {
      return true;
      setAppVolume(paramParcel1.readFloat());
      paramParcel2.writeNoException();
      continue;
      zzbu(paramParcel1.readString());
      paramParcel2.writeNoException();
      continue;
      setAppMuted(zzfo.zza(paramParcel1));
      paramParcel2.writeNoException();
      continue;
      zzc(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      continue;
      zzb(paramParcel1.readString(), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      float f = zzpq();
      paramParcel2.writeNoException();
      paramParcel2.writeFloat(f);
      continue;
      boolean bool = zzpr();
      paramParcel2.writeNoException();
      zzfo.writeBoolean(paramParcel2, bool);
      continue;
      String str = getVersionString();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str);
      continue;
      zzbv(paramParcel1.readString());
      paramParcel2.writeNoException();
      continue;
      zza(zzamr.zzy(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      zza(zzait.zzw(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      List localList = zzps();
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(localList);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaaa
 * JD-Core Version:    0.6.2
 */