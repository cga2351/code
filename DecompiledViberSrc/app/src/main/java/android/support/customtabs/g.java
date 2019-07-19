package android.support.customtabs;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface g extends IInterface
{
  public abstract void a(e parame, Bundle paramBundle)
    throws RemoteException;

  public abstract void a(e parame, String paramString, Bundle paramBundle)
    throws RemoteException;

  public static abstract class a extends Binder
    implements g
  {
    public a()
    {
      attachInterface(this, "android.support.customtabs.IPostMessageService");
    }

    public IBinder asBinder()
    {
      return this;
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("android.support.customtabs.IPostMessageService");
        return true;
      case 2:
        paramParcel1.enforceInterface("android.support.customtabs.IPostMessageService");
        e locale2 = e.a.a(paramParcel1.readStrongBinder());
        int j = paramParcel1.readInt();
        Bundle localBundle2 = null;
        if (j != 0)
          localBundle2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        a(locale2, localBundle2);
        paramParcel2.writeNoException();
        return true;
      case 3:
      }
      paramParcel1.enforceInterface("android.support.customtabs.IPostMessageService");
      e locale1 = e.a.a(paramParcel1.readStrongBinder());
      String str = paramParcel1.readString();
      int i = paramParcel1.readInt();
      Bundle localBundle1 = null;
      if (i != 0)
        localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      a(locale1, str, localBundle1);
      paramParcel2.writeNoException();
      return true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.customtabs.g
 * JD-Core Version:    0.6.2
 */