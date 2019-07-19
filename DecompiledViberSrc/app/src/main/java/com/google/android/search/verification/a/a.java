package com.google.android.search.verification.a;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface a extends IInterface
{
  public abstract int a()
    throws RemoteException;

  public abstract boolean a(Intent paramIntent, Bundle paramBundle)
    throws RemoteException;

  public static abstract class a extends Binder
    implements a
  {
    public static a a(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.search.verification.api.ISearchActionVerificationService");
      if ((localIInterface != null) && ((localIInterface instanceof a)))
        return (a)localIInterface;
      return new a(paramIBinder);
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.search.verification.api.ISearchActionVerificationService");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.search.verification.api.ISearchActionVerificationService");
        Intent localIntent;
        Bundle localBundle;
        if (paramParcel1.readInt() != 0)
        {
          localIntent = (Intent)Intent.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label138;
          localBundle = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
          label102: boolean bool = a(localIntent, localBundle);
          paramParcel2.writeNoException();
          if (!bool)
            break label144;
        }
        label138: label144: for (int j = 1; ; j = 0)
        {
          paramParcel2.writeInt(j);
          return true;
          localIntent = null;
          break;
          localBundle = null;
          break label102;
        }
      case 2:
      }
      paramParcel1.enforceInterface("com.google.android.search.verification.api.ISearchActionVerificationService");
      int i = a();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(i);
      return true;
    }

    private static class a
      implements a
    {
      private IBinder a;

      a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }

      public int a()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.search.verification.api.ISearchActionVerificationService");
          this.a.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public boolean a(Intent paramIntent, Bundle paramBundle)
        throws RemoteException
      {
        boolean bool = true;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.search.verification.api.ISearchActionVerificationService");
            if (paramIntent != null)
            {
              localParcel1.writeInt(1);
              paramIntent.writeToParcel(localParcel1, 0);
              if (paramBundle != null)
              {
                localParcel1.writeInt(1);
                paramBundle.writeToParcel(localParcel1, 0);
                this.a.transact(1, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                if (i == 0)
                  break label131;
                return bool;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          localParcel1.writeInt(0);
          continue;
          label131: bool = false;
        }
      }

      public IBinder asBinder()
      {
        return this.a;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.search.verification.a.a
 * JD-Core Version:    0.6.2
 */