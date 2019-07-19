package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zac;

public abstract interface IResolveAccountCallbacks extends IInterface
{
  public abstract void onAccountResolutionComplete(ResolveAccountResponse paramResolveAccountResponse)
    throws RemoteException;

  public static abstract class Stub extends zab
    implements IResolveAccountCallbacks
  {
    public Stub()
    {
      super();
    }

    public static IResolveAccountCallbacks asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IResolveAccountCallbacks");
      if ((localIInterface instanceof IResolveAccountCallbacks))
        return (IResolveAccountCallbacks)localIInterface;
      return new Proxy(paramIBinder);
    }

    protected boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      if (paramInt1 == 2)
      {
        onAccountResolutionComplete((ResolveAccountResponse)zac.zaa(paramParcel1, ResolveAccountResponse.CREATOR));
        paramParcel2.writeNoException();
        return true;
      }
      return false;
    }

    public static class Proxy extends zaa
      implements IResolveAccountCallbacks
    {
      Proxy(IBinder paramIBinder)
      {
        super("com.google.android.gms.common.internal.IResolveAccountCallbacks");
      }

      public void onAccountResolutionComplete(ResolveAccountResponse paramResolveAccountResponse)
        throws RemoteException
      {
        Parcel localParcel = zaa();
        zac.zaa(localParcel, paramResolveAccountResponse);
        zab(2, localParcel);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.IResolveAccountCallbacks
 * JD-Core Version:    0.6.2
 */