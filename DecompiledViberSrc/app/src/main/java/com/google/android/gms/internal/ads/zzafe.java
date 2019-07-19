package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import java.util.List;

public abstract class zzafe extends zzfn
  implements zzafd
{
  public zzafe()
  {
    super("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
  }

  public static zzafd zzn(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    if ((localIInterface instanceof zzafd))
      return (zzafd)localIInterface;
    return new zzaff(paramIBinder);
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      String str2 = zzcj(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeString(str2);
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
    }
    while (true)
    {
      return true;
      zzaeh localzzaeh = zzck(paramParcel1.readString());
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzaeh);
      continue;
      List localList = getAvailableAssetNames();
      paramParcel2.writeNoException();
      paramParcel2.writeStringList(localList);
      continue;
      String str1 = getCustomTemplateId();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str1);
      continue;
      performClick(paramParcel1.readString());
      paramParcel2.writeNoException();
      continue;
      recordImpression();
      paramParcel2.writeNoException();
      continue;
      zzaap localzzaap = getVideoController();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzaap);
      continue;
      destroy();
      paramParcel2.writeNoException();
      continue;
      IObjectWrapper localIObjectWrapper2 = zzrm();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localIObjectWrapper2);
      continue;
      boolean bool = zzp(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      zzfo.writeBoolean(paramParcel2, bool);
      continue;
      IObjectWrapper localIObjectWrapper1 = zzrh();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localIObjectWrapper1);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzafe
 * JD-Core Version:    0.6.2
 */