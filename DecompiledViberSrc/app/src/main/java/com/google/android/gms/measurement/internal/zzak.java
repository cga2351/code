package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzr;
import com.google.android.gms.internal.measurement.zzs;
import java.util.List;

public abstract class zzak extends zzr
  implements zzaj
{
  public zzak()
  {
    super("com.google.android.gms.measurement.internal.IMeasurementService");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    case 3:
    case 8:
    default:
      return false;
    case 1:
      zza((zzag)zzs.zza(paramParcel1, zzag.CREATOR), (zzk)zzs.zza(paramParcel1, zzk.CREATOR));
      paramParcel2.writeNoException();
    case 2:
    case 4:
    case 5:
    case 6:
    case 7:
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
      zza((zzfu)zzs.zza(paramParcel1, zzfu.CREATOR), (zzk)zzs.zza(paramParcel1, zzk.CREATOR));
      paramParcel2.writeNoException();
      continue;
      zza((zzk)zzs.zza(paramParcel1, zzk.CREATOR));
      paramParcel2.writeNoException();
      continue;
      zza((zzag)zzs.zza(paramParcel1, zzag.CREATOR), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      continue;
      zzb((zzk)zzs.zza(paramParcel1, zzk.CREATOR));
      paramParcel2.writeNoException();
      continue;
      List localList5 = zza((zzk)zzs.zza(paramParcel1, zzk.CREATOR), zzs.zza(paramParcel1));
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(localList5);
      continue;
      byte[] arrayOfByte = zza((zzag)zzs.zza(paramParcel1, zzag.CREATOR), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeByteArray(arrayOfByte);
      continue;
      zza(paramParcel1.readLong(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      continue;
      String str = zzc((zzk)zzs.zza(paramParcel1, zzk.CREATOR));
      paramParcel2.writeNoException();
      paramParcel2.writeString(str);
      continue;
      zza((zzo)zzs.zza(paramParcel1, zzo.CREATOR), (zzk)zzs.zza(paramParcel1, zzk.CREATOR));
      paramParcel2.writeNoException();
      continue;
      zzb((zzo)zzs.zza(paramParcel1, zzo.CREATOR));
      paramParcel2.writeNoException();
      continue;
      List localList4 = zza(paramParcel1.readString(), paramParcel1.readString(), zzs.zza(paramParcel1), (zzk)zzs.zza(paramParcel1, zzk.CREATOR));
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(localList4);
      continue;
      List localList3 = zza(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), zzs.zza(paramParcel1));
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(localList3);
      continue;
      List localList2 = zza(paramParcel1.readString(), paramParcel1.readString(), (zzk)zzs.zza(paramParcel1, zzk.CREATOR));
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(localList2);
      continue;
      List localList1 = zze(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(localList1);
      continue;
      zzd((zzk)zzs.zza(paramParcel1, zzk.CREATOR));
      paramParcel2.writeNoException();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzak
 * JD-Core Version:    0.6.2
 */