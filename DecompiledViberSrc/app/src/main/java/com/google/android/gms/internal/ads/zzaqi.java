package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

public abstract class zzaqi extends zzfn
  implements zzaqh
{
  public zzaqi()
  {
    super("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
  }

  public static zzaqh zzac(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    if ((localIInterface instanceof zzaqh))
      return (zzaqh)localIInterface;
    return new zzaqj(paramIBinder);
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      onCreate((Bundle)zzfo.zza(paramParcel1, Bundle.CREATOR));
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
      onRestart();
      paramParcel2.writeNoException();
      continue;
      onStart();
      paramParcel2.writeNoException();
      continue;
      onResume();
      paramParcel2.writeNoException();
      continue;
      onPause();
      paramParcel2.writeNoException();
      continue;
      Bundle localBundle = (Bundle)zzfo.zza(paramParcel1, Bundle.CREATOR);
      onSaveInstanceState(localBundle);
      paramParcel2.writeNoException();
      zzfo.zzb(paramParcel2, localBundle);
      continue;
      onStop();
      paramParcel2.writeNoException();
      continue;
      onDestroy();
      paramParcel2.writeNoException();
      continue;
      zzdd();
      paramParcel2.writeNoException();
      continue;
      onBackPressed();
      paramParcel2.writeNoException();
      continue;
      boolean bool = zztg();
      paramParcel2.writeNoException();
      zzfo.writeBoolean(paramParcel2, bool);
      continue;
      onActivityResult(paramParcel1.readInt(), paramParcel1.readInt(), (Intent)zzfo.zza(paramParcel1, Intent.CREATOR));
      paramParcel2.writeNoException();
      continue;
      zzac(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaqi
 * JD-Core Version:    0.6.2
 */