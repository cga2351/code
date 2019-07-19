package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzaf;

final class zzs
  implements TileProvider
{
  private final zzaf zzel = TileOverlayOptions.zza(this.zzem);

  zzs(TileOverlayOptions paramTileOverlayOptions)
  {
  }

  public final Tile getTile(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      Tile localTile = this.zzel.getTile(paramInt1, paramInt2, paramInt3);
      return localTile;
    }
    catch (RemoteException localRemoteException)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.zzs
 * JD-Core Version:    0.6.2
 */