package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;

public abstract interface IAccountAccessor extends IInterface
{
  public abstract Account getAccount()
    throws RemoteException;

  public static abstract class Stub extends zzb
    implements IAccountAccessor
  {
    public Stub()
    {
      super();
    }

    public static IAccountAccessor asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
      if ((localIInterface instanceof IAccountAccessor))
        return (IAccountAccessor)localIInterface;
      return new zza(paramIBinder);
    }

    protected final boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      if (paramInt1 == 2)
      {
        Account localAccount = getAccount();
        paramParcel2.writeNoException();
        zzc.zzb(paramParcel2, localAccount);
        return true;
      }
      return false;
    }

    public static final class zza extends zza
      implements IAccountAccessor
    {
      zza(IBinder paramIBinder)
      {
        super("com.google.android.gms.common.internal.IAccountAccessor");
      }

      public final Account getAccount()
        throws RemoteException
      {
        Parcel localParcel = zza(2, zza());
        Account localAccount = (Account)zzc.zza(localParcel, Account.CREATOR);
        localParcel.recycle();
        return localAccount;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.IAccountAccessor
 * JD-Core Version:    0.6.2
 */