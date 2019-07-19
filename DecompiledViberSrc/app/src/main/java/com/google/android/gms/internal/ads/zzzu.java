package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

public abstract class zzzu extends zzfn
  implements zzzt
{
  public zzzu()
  {
    super("com.google.android.gms.ads.internal.client.IClientApi");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      zzzi localzzzi3 = zza(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), (zzyb)zzfo.zza(paramParcel1, zzyb.CREATOR), paramParcel1.readString(), zzamr.zzy(paramParcel1.readStrongBinder()), paramParcel1.readInt());
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzzi3);
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
    }
    while (true)
    {
      return true;
      zzzi localzzzi2 = zzb(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), (zzyb)zzfo.zza(paramParcel1, zzyb.CREATOR), paramParcel1.readString(), zzamr.zzy(paramParcel1.readStrongBinder()), paramParcel1.readInt());
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzzi2);
      continue;
      zzzd localzzzd = zza(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readString(), zzamr.zzy(paramParcel1.readStrongBinder()), paramParcel1.readInt());
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzzd);
      continue;
      zzzz localzzzz2 = zzg(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzzz2);
      continue;
      zzael localzzael = zzc(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzael);
      continue;
      zzasx localzzasx = zza(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), zzamr.zzy(paramParcel1.readStrongBinder()), paramParcel1.readInt());
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzasx);
      continue;
      zzaqr localzzaqr = zzh(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzaqr);
      continue;
      zzaqh localzzaqh = zzf(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzaqh);
      continue;
      zzzz localzzzz1 = zza(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readInt());
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzzz1);
      continue;
      zzzi localzzzi1 = zza(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), (zzyb)zzfo.zza(paramParcel1, zzyb.CREATOR), paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzzi1);
      continue;
      zzaeq localzzaeq = zza(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzaeq);
      continue;
      zzatu localzzatu = zzb(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readString(), zzamr.zzy(paramParcel1.readStrongBinder()), paramParcel1.readInt());
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzatu);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzzu
 * JD-Core Version:    0.6.2
 */