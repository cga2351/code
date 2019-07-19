package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.internal.zzbt;

final class zzr extends zzbt
{
  zzr(GoogleMap paramGoogleMap, GoogleMap.SnapshotReadyCallback paramSnapshotReadyCallback)
  {
  }

  public final void onSnapshotReady(Bitmap paramBitmap)
    throws RemoteException
  {
    this.zzz.onSnapshotReady(paramBitmap);
  }

  public final void zzb(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    this.zzz.onSnapshotReady((Bitmap)ObjectWrapper.unwrap(paramIObjectWrapper));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.zzr
 * JD-Core Version:    0.6.2
 */