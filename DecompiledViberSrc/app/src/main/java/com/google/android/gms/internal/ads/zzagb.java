package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzagb extends zzfm
  implements zzafz
{
  zzagb(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.internal.formats.client.IShouldDelayBannerRenderingListener");
  }

  public final boolean zzq(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel1 = obtainAndWriteInterfaceToken();
    zzfo.zza(localParcel1, paramIObjectWrapper);
    Parcel localParcel2 = transactAndReadException(2, localParcel1);
    boolean bool = zzfo.zza(localParcel2);
    localParcel2.recycle();
    return bool;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzagb
 * JD-Core Version:    0.6.2
 */