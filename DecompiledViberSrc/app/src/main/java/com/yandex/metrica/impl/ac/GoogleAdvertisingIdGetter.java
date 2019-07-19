package com.yandex.metrica.impl.ac;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Pair;
import com.yandex.metrica.impl.ob.h;
import com.yandex.metrica.impl.ob.k;
import com.yandex.metrica.impl.ob.l;
import com.yandex.metrica.impl.ob.l.a;
import com.yandex.metrica.impl.ob.m;
import com.yandex.metrica.impl.ob.ml;
import com.yandex.metrica.impl.ob.mw;
import com.yandex.metrica.impl.ob.od;
import com.yandex.metrica.impl.ob.r;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;

public class GoogleAdvertisingIdGetter
{
  private volatile String a = null;
  private volatile Boolean b = null;
  private final Object c = new Object();
  private volatile FutureTask<Pair<String, Boolean>> d;
  private mw e;
  private final e f;
  private Context g;

  private GoogleAdvertisingIdGetter(e parame)
  {
    this.f = parame;
    h.a().a(this, r.class, l.a(new k()
    {
      public void a(r paramAnonymousr)
      {
        synchronized (GoogleAdvertisingIdGetter.a(GoogleAdvertisingIdGetter.this))
        {
          GoogleAdvertisingIdGetter.a(GoogleAdvertisingIdGetter.this, paramAnonymousr.b);
          return;
        }
      }
    }).a());
  }

  public static GoogleAdvertisingIdGetter a()
  {
    return d.a;
  }

  private <T> T a(Context paramContext, g<T> paramg)
  {
    b(paramContext);
    try
    {
      Object localObject = paramg.b(this.d);
      return localObject;
    }
    catch (ExecutionException localExecutionException)
    {
      return null;
    }
    catch (InterruptedException localInterruptedException)
    {
      label22: break label22;
    }
  }

  private void a(String paramString)
  {
    h.a().b(new m(paramString));
    this.a = paramString;
  }

  public static GoogleAdvertisingIdGetter b()
  {
    return d.b;
  }

  private static boolean e(Context paramContext)
  {
    try
    {
      boolean bool = Class.forName("com.google.android.gms.common.GooglePlayServicesUtil").getMethod("isGooglePlayServicesAvailable", new Class[] { Context.class }).invoke(null, new Object[] { paramContext }).equals(Integer.valueOf(0));
      return bool;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  private void f()
  {
    if ((this.g != null) && (!e()))
      c(this.g);
  }

  public void a(Context paramContext)
  {
    this.g = paramContext.getApplicationContext();
  }

  public void b(final Context paramContext)
  {
    this.g = paramContext.getApplicationContext();
    if (this.d == null)
      synchronized (this.c)
      {
        if ((this.d == null) && (this.f.a(this.e)))
        {
          this.d = new FutureTask(new Callable()
          {
            public Pair<String, Boolean> a()
            {
              Context localContext = paramContext.getApplicationContext();
              if (GoogleAdvertisingIdGetter.d(localContext))
                GoogleAdvertisingIdGetter.a(GoogleAdvertisingIdGetter.this, localContext);
              if (!GoogleAdvertisingIdGetter.this.e())
                GoogleAdvertisingIdGetter.b(GoogleAdvertisingIdGetter.this, localContext);
              return new Pair(GoogleAdvertisingIdGetter.b(GoogleAdvertisingIdGetter.this), GoogleAdvertisingIdGetter.c(GoogleAdvertisingIdGetter.this));
            }
          });
          od.a("YMM-UT1", this.d).start();
        }
        return;
      }
  }

  public b c(Context paramContext)
  {
    if (this.f.a(this.e))
      return (b)a(paramContext, new g()
      {
        public GoogleAdvertisingIdGetter.b a(Future<Pair<String, Boolean>> paramAnonymousFuture)
          throws InterruptedException, ExecutionException
        {
          Pair localPair = (Pair)paramAnonymousFuture.get();
          return new GoogleAdvertisingIdGetter.b((String)localPair.first, (Boolean)localPair.second);
        }
      });
    return null;
  }

  public String c()
  {
    f();
    return this.a;
  }

  public Boolean d()
  {
    f();
    return this.b;
  }

  public boolean e()
  {
    try
    {
      if (this.a != null)
      {
        Boolean localBoolean = this.b;
        if (localBoolean != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  private static abstract interface GoogleAdvertisingInfo extends IInterface
  {
    public abstract boolean getEnabled(boolean paramBoolean)
      throws RemoteException;

    public abstract String getId()
      throws RemoteException;

    public static abstract class GoogleAdvertisingInfoBinder extends Binder
      implements GoogleAdvertisingIdGetter.GoogleAdvertisingInfo
    {
      public static GoogleAdvertisingIdGetter.GoogleAdvertisingInfo create(IBinder paramIBinder)
      {
        if (paramIBinder == null)
          return null;
        IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        if ((localIInterface != null) && ((localIInterface instanceof GoogleAdvertisingIdGetter.GoogleAdvertisingInfo)))
          return (GoogleAdvertisingIdGetter.GoogleAdvertisingInfo)localIInterface;
        return new GoogleAdvertisingInfoImplementation(paramIBinder);
      }

      public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
        throws RemoteException
      {
        switch (paramInt1)
        {
        default:
          return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        case 1:
          paramParcel1.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
          String str = getId();
          paramParcel2.writeNoException();
          paramParcel2.writeString(str);
          return true;
        case 2:
        }
        paramParcel1.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        if (paramParcel1.readInt() != 0);
        for (boolean bool1 = true; ; bool1 = false)
        {
          boolean bool2 = getEnabled(bool1);
          paramParcel2.writeNoException();
          int i = 0;
          if (bool2)
            i = 1;
          paramParcel2.writeInt(i);
          return true;
        }
      }

      private static class GoogleAdvertisingInfoImplementation
        implements GoogleAdvertisingIdGetter.GoogleAdvertisingInfo
      {
        private IBinder a;

        GoogleAdvertisingInfoImplementation(IBinder paramIBinder)
        {
          this.a = paramIBinder;
        }

        public IBinder asBinder()
        {
          return this.a;
        }

        public boolean getEnabled(boolean paramBoolean)
          throws RemoteException
        {
          int i = 1;
          Parcel localParcel1 = Parcel.obtain();
          Parcel localParcel2 = Parcel.obtain();
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            if (paramBoolean)
            {
              int j = i;
              localParcel1.writeInt(j);
              this.a.transact(2, localParcel1, localParcel2, 0);
              localParcel2.readException();
              int m = localParcel2.readInt();
              if (m == 0)
                break label79;
            }
            while (true)
            {
              return i;
              int k = 0;
              break;
              label79: i = 0;
            }
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }

        public String getId()
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
      }
    }
  }

  static class a
    implements GoogleAdvertisingIdGetter.e
  {
    public boolean a(mw parammw)
    {
      return true;
    }
  }

  public static class b
  {
    public final String a;
    public final Boolean b;

    public b(String paramString, Boolean paramBoolean)
    {
      this.a = paramString;
      this.b = paramBoolean;
    }
  }

  private class c
    implements ServiceConnection
  {
    private boolean b = false;
    private final BlockingQueue<IBinder> c = new LinkedBlockingQueue();

    private c()
    {
    }

    public IBinder a()
      throws InterruptedException
    {
      if (this.b)
        throw new IllegalStateException();
      this.b = true;
      return (IBinder)this.c.take();
    }

    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      try
      {
        this.c.put(paramIBinder);
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

  private static class d
  {

    @SuppressLint({"StaticFieldLeak"})
    static final GoogleAdvertisingIdGetter a = new GoogleAdvertisingIdGetter(new GoogleAdvertisingIdGetter.f(), (byte)0);

    @SuppressLint({"StaticFieldLeak"})
    static final GoogleAdvertisingIdGetter b = new GoogleAdvertisingIdGetter(new GoogleAdvertisingIdGetter.a(), (byte)0);
  }

  static abstract interface e
  {
    public abstract boolean a(mw parammw);
  }

  static class f
    implements GoogleAdvertisingIdGetter.e
  {
    public boolean a(mw parammw)
    {
      return (parammw != null) && ((parammw.n.g) || (!parammw.t));
    }
  }

  private static abstract interface g<T>
  {
    public abstract T b(Future<Pair<String, Boolean>> paramFuture)
      throws InterruptedException, ExecutionException;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ac.GoogleAdvertisingIdGetter
 * JD-Core Version:    0.6.2
 */