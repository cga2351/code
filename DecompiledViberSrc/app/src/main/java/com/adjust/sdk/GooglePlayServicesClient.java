package com.adjust.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.concurrent.LinkedBlockingQueue;

public class GooglePlayServicesClient
{
  // ERROR //
  public static GooglePlayServicesInfo getGooglePlayServicesInfo(android.content.Context paramContext)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: invokestatic 18	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   3: invokestatic 21	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   6: if_acmpne +13 -> 19
    //   9: new 23	java/lang/IllegalStateException
    //   12: dup
    //   13: ldc 25
    //   15: invokespecial 28	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   18: athrow
    //   19: aload_0
    //   20: invokevirtual 34	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   23: ldc 36
    //   25: iconst_0
    //   26: invokevirtual 42	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   29: pop
    //   30: new 44	com/adjust/sdk/GooglePlayServicesClient$a
    //   33: dup
    //   34: aconst_null
    //   35: invokespecial 47	com/adjust/sdk/GooglePlayServicesClient$a:<init>	(Lcom/adjust/sdk/GooglePlayServicesClient$1;)V
    //   38: astore_3
    //   39: new 49	android/content/Intent
    //   42: dup
    //   43: ldc 51
    //   45: invokespecial 52	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   48: astore 4
    //   50: aload 4
    //   52: ldc 54
    //   54: invokevirtual 58	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   57: pop
    //   58: aload_0
    //   59: aload 4
    //   61: aload_3
    //   62: iconst_1
    //   63: invokevirtual 62	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   66: ifeq +62 -> 128
    //   69: new 64	com/adjust/sdk/GooglePlayServicesClient$b
    //   72: dup
    //   73: aload_3
    //   74: invokevirtual 68	com/adjust/sdk/GooglePlayServicesClient$a:a	()Landroid/os/IBinder;
    //   77: invokespecial 71	com/adjust/sdk/GooglePlayServicesClient$b:<init>	(Landroid/os/IBinder;)V
    //   80: astore 6
    //   82: new 73	com/adjust/sdk/GooglePlayServicesClient$GooglePlayServicesInfo
    //   85: dup
    //   86: aload 6
    //   88: invokevirtual 76	com/adjust/sdk/GooglePlayServicesClient$b:a	()Ljava/lang/String;
    //   91: aload 6
    //   93: iconst_1
    //   94: invokevirtual 79	com/adjust/sdk/GooglePlayServicesClient$b:a	(Z)Ljava/lang/Boolean;
    //   97: invokespecial 82	com/adjust/sdk/GooglePlayServicesClient$GooglePlayServicesInfo:<init>	(Ljava/lang/String;Ljava/lang/Boolean;)V
    //   100: astore 7
    //   102: aload_0
    //   103: aload_3
    //   104: invokevirtual 86	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   107: aload 7
    //   109: areturn
    //   110: astore_1
    //   111: aload_1
    //   112: athrow
    //   113: astore 9
    //   115: aload 9
    //   117: athrow
    //   118: astore 8
    //   120: aload_0
    //   121: aload_3
    //   122: invokevirtual 86	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   125: aload 8
    //   127: athrow
    //   128: new 88	java/io/IOException
    //   131: dup
    //   132: ldc 90
    //   134: invokespecial 91	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   137: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   19	30	110	java/lang/Exception
    //   69	102	113	java/lang/Exception
    //   69	102	118	finally
    //   115	118	118	finally
  }

  public static final class GooglePlayServicesInfo
  {
    private final String gpsAdid;
    private final Boolean trackingEnabled;

    GooglePlayServicesInfo(String paramString, Boolean paramBoolean)
    {
      this.gpsAdid = paramString;
      this.trackingEnabled = paramBoolean;
    }

    public String getGpsAdid()
    {
      return this.gpsAdid;
    }

    public Boolean isTrackingEnabled()
    {
      return this.trackingEnabled;
    }
  }

  private static final class a
    implements ServiceConnection
  {
    boolean a = false;
    private final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue(1);

    public IBinder a()
      throws InterruptedException
    {
      if (this.a)
        throw new IllegalStateException();
      this.a = true;
      return (IBinder)this.b.take();
    }

    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      try
      {
        this.b.put(paramIBinder);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
      }
    }

    public void onServiceDisconnected(ComponentName paramComponentName)
    {
    }
  }

  private static final class b
    implements IInterface
  {
    private IBinder a;

    public b(IBinder paramIBinder)
    {
      this.a = paramIBinder;
    }

    public Boolean a(boolean paramBoolean)
      throws RemoteException
    {
      int i = 1;
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      while (true)
      {
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
          if (paramBoolean)
          {
            int j = i;
            localParcel1.writeInt(j);
            this.a.transact(2, localParcel1, localParcel2, 0);
            localParcel2.readException();
            if (localParcel2.readInt() != 0)
            {
              bool = i;
              Boolean localBoolean = Boolean.valueOf(bool);
              localParcel2.recycle();
              localParcel1.recycle();
              if (localBoolean == null)
                break;
              if (localBoolean.booleanValue())
                break label121;
              return Boolean.valueOf(i);
            }
          }
          else
          {
            int k = 0;
            continue;
          }
          boolean bool = false;
          continue;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        label121: i = 0;
      }
      return null;
    }

    public String a()
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        this.a.transact(1, localParcel1, localParcel2, 0);
        localParcel2.readException();
        String str = localParcel2.readString();
        return str;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }

    public IBinder asBinder()
    {
      return this.a;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.GooglePlayServicesClient
 * JD-Core Version:    0.6.2
 */