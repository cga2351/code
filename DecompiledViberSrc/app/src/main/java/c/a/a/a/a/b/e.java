package c.a.a.a.a.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import c.a.a.a.c;
import c.a.a.a.l;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class e
  implements f
{
  private final Context a;

  public e(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }

  // ERROR //
  public b a()
  {
    // Byte code:
    //   0: invokestatic 34	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   3: invokestatic 37	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   6: if_acmpne +17 -> 23
    //   9: invokestatic 43	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   12: ldc 45
    //   14: ldc 47
    //   16: invokeinterface 52 3 0
    //   21: aconst_null
    //   22: areturn
    //   23: aload_0
    //   24: getfield 21	c/a/a/a/a/b/e:a	Landroid/content/Context;
    //   27: invokevirtual 56	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   30: ldc 58
    //   32: iconst_0
    //   33: invokevirtual 64	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   36: pop
    //   37: new 66	c/a/a/a/a/b/e$a
    //   40: dup
    //   41: aconst_null
    //   42: invokespecial 69	c/a/a/a/a/b/e$a:<init>	(Lc/a/a/a/a/b/e$1;)V
    //   45: astore 4
    //   47: new 71	android/content/Intent
    //   50: dup
    //   51: ldc 73
    //   53: invokespecial 76	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   56: astore 5
    //   58: aload 5
    //   60: ldc 78
    //   62: invokevirtual 82	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   65: pop
    //   66: aload_0
    //   67: getfield 21	c/a/a/a/a/b/e:a	Landroid/content/Context;
    //   70: aload 5
    //   72: aload 4
    //   74: iconst_1
    //   75: invokevirtual 86	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   78: istore 8
    //   80: iload 8
    //   82: ifeq +138 -> 220
    //   85: new 88	c/a/a/a/a/b/e$b
    //   88: dup
    //   89: aload 4
    //   91: invokevirtual 91	c/a/a/a/a/b/e$a:a	()Landroid/os/IBinder;
    //   94: invokespecial 94	c/a/a/a/a/b/e$b:<init>	(Landroid/os/IBinder;)V
    //   97: astore 9
    //   99: new 96	c/a/a/a/a/b/b
    //   102: dup
    //   103: aload 9
    //   105: invokevirtual 99	c/a/a/a/a/b/e$b:a	()Ljava/lang/String;
    //   108: aload 9
    //   110: invokevirtual 103	c/a/a/a/a/b/e$b:b	()Z
    //   113: invokespecial 106	c/a/a/a/a/b/b:<init>	(Ljava/lang/String;Z)V
    //   116: astore 10
    //   118: aload_0
    //   119: getfield 21	c/a/a/a/a/b/e:a	Landroid/content/Context;
    //   122: aload 4
    //   124: invokevirtual 110	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   127: aload 10
    //   129: areturn
    //   130: astore_2
    //   131: invokestatic 43	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   134: ldc 45
    //   136: ldc 112
    //   138: invokeinterface 52 3 0
    //   143: aconst_null
    //   144: areturn
    //   145: astore_1
    //   146: invokestatic 43	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   149: ldc 45
    //   151: ldc 114
    //   153: aload_1
    //   154: invokeinterface 117 4 0
    //   159: aconst_null
    //   160: areturn
    //   161: astore 12
    //   163: invokestatic 43	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   166: ldc 45
    //   168: ldc 119
    //   170: aload 12
    //   172: invokeinterface 122 4 0
    //   177: aload_0
    //   178: getfield 21	c/a/a/a/a/b/e:a	Landroid/content/Context;
    //   181: aload 4
    //   183: invokevirtual 110	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   186: aconst_null
    //   187: areturn
    //   188: astore 7
    //   190: invokestatic 43	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   193: ldc 45
    //   195: ldc 124
    //   197: aload 7
    //   199: invokeinterface 117 4 0
    //   204: aconst_null
    //   205: areturn
    //   206: astore 11
    //   208: aload_0
    //   209: getfield 21	c/a/a/a/a/b/e:a	Landroid/content/Context;
    //   212: aload 4
    //   214: invokevirtual 110	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   217: aload 11
    //   219: athrow
    //   220: invokestatic 43	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   223: ldc 45
    //   225: ldc 124
    //   227: invokeinterface 52 3 0
    //   232: aconst_null
    //   233: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   23	37	130	android/content/pm/PackageManager$NameNotFoundException
    //   23	37	145	java/lang/Exception
    //   85	118	161	java/lang/Exception
    //   66	80	188	java/lang/Throwable
    //   118	127	188	java/lang/Throwable
    //   177	186	188	java/lang/Throwable
    //   208	220	188	java/lang/Throwable
    //   220	232	188	java/lang/Throwable
    //   85	118	206	finally
    //   163	177	206	finally
  }

  private static final class a
    implements ServiceConnection
  {
    private boolean a = false;
    private final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue(1);

    public IBinder a()
    {
      if (this.a)
        c.g().e("Fabric", "getBinder already called");
      this.a = true;
      try
      {
        IBinder localIBinder = (IBinder)this.b.poll(200L, TimeUnit.MILLISECONDS);
        return localIBinder;
      }
      catch (InterruptedException localInterruptedException)
      {
      }
      return null;
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
      this.b.clear();
    }
  }

  private static final class b
    implements IInterface
  {
    private final IBinder a;

    public b(IBinder paramIBinder)
    {
      this.a = paramIBinder;
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
      catch (Exception localException)
      {
        c.g().a("Fabric", "Could not get parcel from Google Play Service to capture AdvertisingId");
        return null;
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

    public boolean b()
      throws RemoteException
    {
      boolean bool = true;
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        localParcel1.writeInt(1);
        this.a.transact(2, localParcel1, localParcel2, 0);
        localParcel2.readException();
        int i = localParcel2.readInt();
        if (i != 0);
        while (true)
        {
          return bool;
          bool = false;
        }
      }
      catch (Exception localException)
      {
        c.g().a("Fabric", "Could not get parcel from Google Play Service to capture Advertising limitAdTracking");
        return false;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.b.e
 * JD-Core Version:    0.6.2
 */