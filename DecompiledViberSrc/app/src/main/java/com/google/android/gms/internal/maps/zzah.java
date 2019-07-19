package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;

public final class zzah extends zza
  implements zzaf
{
  zzah(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.maps.model.internal.ITileProviderDelegate");
  }

  public final Tile getTile(int paramInt1, int paramInt2, int paramInt3)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    localParcel1.writeInt(paramInt1);
    localParcel1.writeInt(paramInt2);
    localParcel1.writeInt(paramInt3);
    Parcel localParcel2 = zza(1, localParcel1);
    Tile localTile = (Tile)zzc.zza(localParcel2, Tile.CREATOR);
    localParcel2.recycle();
    return localTile;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.maps.zzah
 * JD-Core Version:    0.6.2
 */