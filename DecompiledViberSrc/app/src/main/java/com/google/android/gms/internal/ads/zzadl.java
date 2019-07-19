package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

public abstract class zzadl extends zzfn
  implements zzadk
{
  public zzadl()
  {
    super("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      String str2 = zzqz();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str2);
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      return true;
      String str1 = getContent();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str1);
      continue;
      zzo(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      recordClick();
      paramParcel2.writeNoException();
      continue;
      recordImpression();
      paramParcel2.writeNoException();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzadl
 * JD-Core Version:    0.6.2
 */