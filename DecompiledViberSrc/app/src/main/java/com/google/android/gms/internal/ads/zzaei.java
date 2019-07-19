package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract class zzaei extends zzfn
  implements zzaeh
{
  public zzaei()
  {
    super("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
  }

  public static zzaeh zzk(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    if ((localIInterface instanceof zzaeh))
      return (zzaeh)localIInterface;
    return new zzaej(paramIBinder);
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      IObjectWrapper localIObjectWrapper = zzrf();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localIObjectWrapper);
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      return true;
      Uri localUri = getUri();
      paramParcel2.writeNoException();
      zzfo.zzb(paramParcel2, localUri);
      continue;
      double d = getScale();
      paramParcel2.writeNoException();
      paramParcel2.writeDouble(d);
      continue;
      int j = getWidth();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(j);
      continue;
      int i = getHeight();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(i);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaei
 * JD-Core Version:    0.6.2
 */