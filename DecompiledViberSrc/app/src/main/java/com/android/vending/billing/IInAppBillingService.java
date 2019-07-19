package com.android.vending.billing;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import java.util.List;

public abstract interface IInAppBillingService extends IInterface
{
  public abstract int consumePurchase(int paramInt, String paramString1, String paramString2)
    throws RemoteException;

  public abstract Bundle getBuyIntent(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
    throws RemoteException;

  public abstract Bundle getBuyIntentExtraParams(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
    throws RemoteException;

  public abstract Bundle getBuyIntentToReplaceSkus(int paramInt, String paramString1, List<String> paramList, String paramString2, String paramString3, String paramString4)
    throws RemoteException;

  public abstract Bundle getPurchaseHistory(int paramInt, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
    throws RemoteException;

  public abstract Bundle getPurchases(int paramInt, String paramString1, String paramString2, String paramString3)
    throws RemoteException;

  public abstract Bundle getSkuDetails(int paramInt, String paramString1, String paramString2, Bundle paramBundle)
    throws RemoteException;

  public abstract Bundle getSubscriptionManagementIntent(int paramInt, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
    throws RemoteException;

  public abstract int isBillingSupported(int paramInt, String paramString1, String paramString2)
    throws RemoteException;

  public abstract int isBillingSupportedExtraParams(int paramInt, String paramString1, String paramString2, Bundle paramBundle)
    throws RemoteException;

  public abstract int stub(int paramInt, String paramString1, String paramString2)
    throws RemoteException;

  public static abstract class Stub extends Binder
    implements IInAppBillingService
  {
    private static final String DESCRIPTOR = "com.android.vending.billing.IInAppBillingService";
    static final int TRANSACTION_consumePurchase = 5;
    static final int TRANSACTION_getBuyIntent = 3;
    static final int TRANSACTION_getBuyIntentExtraParams = 8;
    static final int TRANSACTION_getBuyIntentToReplaceSkus = 7;
    static final int TRANSACTION_getPurchaseHistory = 9;
    static final int TRANSACTION_getPurchases = 4;
    static final int TRANSACTION_getSkuDetails = 2;
    static final int TRANSACTION_getSubscriptionManagementIntent = 801;
    static final int TRANSACTION_isBillingSupported = 1;
    static final int TRANSACTION_isBillingSupportedExtraParams = 10;
    static final int TRANSACTION_stub = 6;

    public Stub()
    {
      attachInterface(this, "com.android.vending.billing.IInAppBillingService");
    }

    public static IInAppBillingService asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.android.vending.billing.IInAppBillingService");
      if ((localIInterface != null) && ((localIInterface instanceof IInAppBillingService)))
        return (IInAppBillingService)localIInterface;
      return new Proxy(paramIBinder);
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
        paramParcel2.writeString("com.android.vending.billing.IInAppBillingService");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.android.vending.billing.IInAppBillingService");
        int i6 = isBillingSupported(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(i6);
        return true;
      case 2:
        paramParcel1.enforceInterface("com.android.vending.billing.IInAppBillingService");
        int i4 = paramParcel1.readInt();
        String str13 = paramParcel1.readString();
        String str14 = paramParcel1.readString();
        int i5 = paramParcel1.readInt();
        Bundle localBundle11 = null;
        if (i5 != 0)
          localBundle11 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        Bundle localBundle12 = getSkuDetails(i4, str13, str14, localBundle11);
        paramParcel2.writeNoException();
        if (localBundle12 != null)
        {
          paramParcel2.writeInt(1);
          localBundle12.writeToParcel(paramParcel2, 1);
        }
        while (true)
        {
          return true;
          paramParcel2.writeInt(0);
        }
      case 3:
        paramParcel1.enforceInterface("com.android.vending.billing.IInAppBillingService");
        Bundle localBundle10 = getBuyIntent(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        if (localBundle10 != null)
        {
          paramParcel2.writeInt(1);
          localBundle10.writeToParcel(paramParcel2, 1);
        }
        while (true)
        {
          return true;
          paramParcel2.writeInt(0);
        }
      case 4:
        paramParcel1.enforceInterface("com.android.vending.billing.IInAppBillingService");
        Bundle localBundle9 = getPurchases(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        if (localBundle9 != null)
        {
          paramParcel2.writeInt(1);
          localBundle9.writeToParcel(paramParcel2, 1);
        }
        while (true)
        {
          return true;
          paramParcel2.writeInt(0);
        }
      case 5:
        paramParcel1.enforceInterface("com.android.vending.billing.IInAppBillingService");
        int i3 = consumePurchase(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(i3);
        return true;
      case 6:
        paramParcel1.enforceInterface("com.android.vending.billing.IInAppBillingService");
        int i2 = stub(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(i2);
        return true;
      case 7:
        paramParcel1.enforceInterface("com.android.vending.billing.IInAppBillingService");
        Bundle localBundle8 = getBuyIntentToReplaceSkus(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.createStringArrayList(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        if (localBundle8 != null)
        {
          paramParcel2.writeInt(1);
          localBundle8.writeToParcel(paramParcel2, 1);
        }
        while (true)
        {
          return true;
          paramParcel2.writeInt(0);
        }
      case 8:
        paramParcel1.enforceInterface("com.android.vending.billing.IInAppBillingService");
        int i1 = paramParcel1.readInt();
        String str9 = paramParcel1.readString();
        String str10 = paramParcel1.readString();
        String str11 = paramParcel1.readString();
        String str12 = paramParcel1.readString();
        Bundle localBundle6;
        if (paramParcel1.readInt() != 0)
        {
          localBundle6 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
          Bundle localBundle7 = getBuyIntentExtraParams(i1, str9, str10, str11, str12, localBundle6);
          paramParcel2.writeNoException();
          if (localBundle7 == null)
            break label624;
          paramParcel2.writeInt(1);
          localBundle7.writeToParcel(paramParcel2, 1);
        }
        while (true)
        {
          return true;
          localBundle6 = null;
          break;
          paramParcel2.writeInt(0);
        }
      case 9:
        paramParcel1.enforceInterface("com.android.vending.billing.IInAppBillingService");
        int n = paramParcel1.readInt();
        String str6 = paramParcel1.readString();
        String str7 = paramParcel1.readString();
        String str8 = paramParcel1.readString();
        Bundle localBundle4;
        if (paramParcel1.readInt() != 0)
        {
          localBundle4 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
          Bundle localBundle5 = getPurchaseHistory(n, str6, str7, str8, localBundle4);
          paramParcel2.writeNoException();
          if (localBundle5 == null)
            break label728;
          paramParcel2.writeInt(1);
          localBundle5.writeToParcel(paramParcel2, 1);
        }
        while (true)
        {
          return true;
          localBundle4 = null;
          break;
          paramParcel2.writeInt(0);
        }
      case 10:
        label624: paramParcel1.enforceInterface("com.android.vending.billing.IInAppBillingService");
        label728: int j = paramParcel1.readInt();
        String str4 = paramParcel1.readString();
        String str5 = paramParcel1.readString();
        int k = paramParcel1.readInt();
        Bundle localBundle3 = null;
        if (k != 0)
          localBundle3 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        int m = isBillingSupportedExtraParams(j, str4, str5, localBundle3);
        paramParcel2.writeNoException();
        paramParcel2.writeInt(m);
        return true;
      case 801:
      }
      paramParcel1.enforceInterface("com.android.vending.billing.IInAppBillingService");
      int i = paramParcel1.readInt();
      String str1 = paramParcel1.readString();
      String str2 = paramParcel1.readString();
      String str3 = paramParcel1.readString();
      Bundle localBundle1;
      if (paramParcel1.readInt() != 0)
      {
        localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        Bundle localBundle2 = getSubscriptionManagementIntent(i, str1, str2, str3, localBundle1);
        paramParcel2.writeNoException();
        if (localBundle2 == null)
          break label910;
        paramParcel2.writeInt(1);
        localBundle2.writeToParcel(paramParcel2, 1);
      }
      while (true)
      {
        return true;
        localBundle1 = null;
        break;
        label910: paramParcel2.writeInt(0);
      }
    }

    private static class Proxy
      implements IInAppBillingService
    {
      private IBinder mRemote;

      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }

      public IBinder asBinder()
      {
        return this.mRemote;
      }

      public int consumePurchase(int paramInt, String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          this.mRemote.transact(5, localParcel1, localParcel2, 0);
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

      public Bundle getBuyIntent(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeString(paramString3);
          localParcel1.writeString(paramString4);
          this.mRemote.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            localBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
            return localBundle;
          }
          Bundle localBundle = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public Bundle getBuyIntentExtraParams(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
            localParcel1.writeInt(paramInt);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeString(paramString3);
            localParcel1.writeString(paramString4);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              this.mRemote.transact(8, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                localBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
                return localBundle;
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
          Bundle localBundle = null;
        }
      }

      public Bundle getBuyIntentToReplaceSkus(int paramInt, String paramString1, List<String> paramList, String paramString2, String paramString3, String paramString4)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString1);
          localParcel1.writeStringList(paramList);
          localParcel1.writeString(paramString2);
          localParcel1.writeString(paramString3);
          localParcel1.writeString(paramString4);
          this.mRemote.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            localBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
            return localBundle;
          }
          Bundle localBundle = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public String getInterfaceDescriptor()
      {
        return "com.android.vending.billing.IInAppBillingService";
      }

      public Bundle getPurchaseHistory(int paramInt, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
            localParcel1.writeInt(paramInt);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeString(paramString3);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              this.mRemote.transact(9, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                localBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
                return localBundle;
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
          Bundle localBundle = null;
        }
      }

      public Bundle getPurchases(int paramInt, String paramString1, String paramString2, String paramString3)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeString(paramString3);
          this.mRemote.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            localBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
            return localBundle;
          }
          Bundle localBundle = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public Bundle getSkuDetails(int paramInt, String paramString1, String paramString2, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
            localParcel1.writeInt(paramInt);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              this.mRemote.transact(2, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                localBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
                return localBundle;
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
          Bundle localBundle = null;
        }
      }

      public Bundle getSubscriptionManagementIntent(int paramInt, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
            localParcel1.writeInt(paramInt);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeString(paramString3);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              this.mRemote.transact(801, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                localBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
                return localBundle;
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
          Bundle localBundle = null;
        }
      }

      public int isBillingSupported(int paramInt, String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
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

      public int isBillingSupportedExtraParams(int paramInt, String paramString1, String paramString2, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.mRemote.transact(10, localParcel1, localParcel2, 0);
            localParcel2.readException();
            int i = localParcel2.readInt();
            return i;
            localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public int stub(int paramInt, String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          this.mRemote.transact(6, localParcel1, localParcel2, 0);
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
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.android.vending.billing.IInAppBillingService
 * JD-Core Version:    0.6.2
 */