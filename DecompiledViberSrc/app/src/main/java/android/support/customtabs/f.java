package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import java.util.List;

public abstract interface f extends IInterface
{
  public abstract int a(e parame, String paramString, Bundle paramBundle)
    throws RemoteException;

  public abstract Bundle a(String paramString, Bundle paramBundle)
    throws RemoteException;

  public abstract boolean a(long paramLong)
    throws RemoteException;

  public abstract boolean a(e parame)
    throws RemoteException;

  public abstract boolean a(e parame, Uri paramUri)
    throws RemoteException;

  public abstract boolean a(e parame, Uri paramUri, Bundle paramBundle, List<Bundle> paramList)
    throws RemoteException;

  public abstract boolean a(e parame, Bundle paramBundle)
    throws RemoteException;

  public static abstract class a extends Binder
    implements f
  {
    public a()
    {
      attachInterface(this, "android.support.customtabs.ICustomTabsService");
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
        paramParcel2.writeString("android.support.customtabs.ICustomTabsService");
        return true;
      case 2:
        paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsService");
        boolean bool5 = a(paramParcel1.readLong());
        paramParcel2.writeNoException();
        if (bool5);
        for (int i1 = 1; ; i1 = 0)
        {
          paramParcel2.writeInt(i1);
          return true;
        }
      case 3:
        paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsService");
        boolean bool4 = a(e.a.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        int n = 0;
        if (bool4)
          n = 1;
        paramParcel2.writeInt(n);
        return true;
      case 4:
        paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsService");
        e locale4 = e.a.a(paramParcel1.readStrongBinder());
        Uri localUri2;
        if (paramParcel1.readInt() != 0)
        {
          localUri2 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label283;
        }
        for (Bundle localBundle5 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle5 = null)
        {
          boolean bool3 = a(locale4, localUri2, localBundle5, paramParcel1.createTypedArrayList(Bundle.CREATOR));
          paramParcel2.writeNoException();
          int m = 0;
          if (bool3)
            m = 1;
          paramParcel2.writeInt(m);
          return true;
          localUri2 = null;
          break;
        }
      case 5:
        paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsService");
        String str2 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0);
        for (Bundle localBundle3 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle3 = null)
        {
          Bundle localBundle4 = a(str2, localBundle3);
          paramParcel2.writeNoException();
          if (localBundle4 == null)
            break;
          paramParcel2.writeInt(1);
          localBundle4.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 6:
        paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsService");
        e locale3 = e.a.a(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0);
        for (Bundle localBundle2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle2 = null)
        {
          boolean bool2 = a(locale3, localBundle2);
          paramParcel2.writeNoException();
          int k = 0;
          if (bool2)
            k = 1;
          paramParcel2.writeInt(k);
          return true;
        }
      case 7:
        label283: paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsService");
        e locale2 = e.a.a(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0);
        for (Uri localUri1 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1); ; localUri1 = null)
        {
          boolean bool1 = a(locale2, localUri1);
          paramParcel2.writeNoException();
          int j = 0;
          if (bool1)
            j = 1;
          paramParcel2.writeInt(j);
          return true;
        }
      case 8:
      }
      paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsService");
      e locale1 = e.a.a(paramParcel1.readStrongBinder());
      String str1 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0);
      for (Bundle localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle1 = null)
      {
        int i = a(locale1, str1, localBundle1);
        paramParcel2.writeNoException();
        paramParcel2.writeInt(i);
        return true;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.customtabs.f
 * JD-Core Version:    0.6.2
 */