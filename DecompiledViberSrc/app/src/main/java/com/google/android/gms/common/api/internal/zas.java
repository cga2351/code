package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zal;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

final class zas
  implements zabs
{
  private final Context mContext;
  private final Looper zabj;
  private final zaaw zaed;
  private final zabe zaee;
  private final zabe zaef;
  private final Map<Api.AnyClientKey<?>, zabe> zaeg;
  private final Set<SignInConnectionListener> zaeh = Collections.newSetFromMap(new WeakHashMap());
  private final Api.Client zaei;
  private Bundle zaej;
  private ConnectionResult zaek = null;
  private ConnectionResult zael = null;
  private boolean zaem = false;
  private final Lock zaen;

  @GuardedBy("mLock")
  private int zaeo = 0;

  private zas(Context paramContext, zaaw paramzaaw, Lock paramLock, Looper paramLooper, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> paramMap1, Map<Api.AnyClientKey<?>, Api.Client> paramMap2, ClientSettings paramClientSettings, Api.AbstractClientBuilder<? extends zad, SignInOptions> paramAbstractClientBuilder, Api.Client paramClient, ArrayList<zaq> paramArrayList1, ArrayList<zaq> paramArrayList2, Map<Api<?>, Boolean> paramMap3, Map<Api<?>, Boolean> paramMap4)
  {
    this.mContext = paramContext;
    this.zaed = paramzaaw;
    this.zaen = paramLock;
    this.zabj = paramLooper;
    this.zaei = paramClient;
    this.zaee = new zabe(paramContext, this.zaed, paramLock, paramLooper, paramGoogleApiAvailabilityLight, paramMap2, null, paramMap4, null, paramArrayList2, new zau(this, null));
    this.zaef = new zabe(paramContext, this.zaed, paramLock, paramLooper, paramGoogleApiAvailabilityLight, paramMap1, paramClientSettings, paramMap3, paramAbstractClientBuilder, paramArrayList1, new zav(this, null));
    ArrayMap localArrayMap = new ArrayMap();
    Iterator localIterator1 = paramMap2.keySet().iterator();
    while (localIterator1.hasNext())
      localArrayMap.put((Api.AnyClientKey)localIterator1.next(), this.zaee);
    Iterator localIterator2 = paramMap1.keySet().iterator();
    while (localIterator2.hasNext())
      localArrayMap.put((Api.AnyClientKey)localIterator2.next(), this.zaef);
    this.zaeg = Collections.unmodifiableMap(localArrayMap);
  }

  public static zas zaa(Context paramContext, zaaw paramzaaw, Lock paramLock, Looper paramLooper, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> paramMap, ClientSettings paramClientSettings, Map<Api<?>, Boolean> paramMap1, Api.AbstractClientBuilder<? extends zad, SignInOptions> paramAbstractClientBuilder, ArrayList<zaq> paramArrayList)
  {
    Object localObject1 = null;
    ArrayMap localArrayMap1 = new ArrayMap();
    ArrayMap localArrayMap2 = new ArrayMap();
    Iterator localIterator1 = paramMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      Api.Client localClient = (Api.Client)localEntry.getValue();
      if (localClient.providesSignIn())
        localObject1 = localClient;
      if (localClient.requiresSignIn())
        localArrayMap1.put((Api.AnyClientKey)localEntry.getKey(), localClient);
      else
        localArrayMap2.put((Api.AnyClientKey)localEntry.getKey(), localClient);
    }
    boolean bool;
    ArrayMap localArrayMap3;
    ArrayMap localArrayMap4;
    Iterator localIterator2;
    if (!localArrayMap1.isEmpty())
    {
      bool = true;
      Preconditions.checkState(bool, "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
      localArrayMap3 = new ArrayMap();
      localArrayMap4 = new ArrayMap();
      localIterator2 = paramMap1.keySet().iterator();
    }
    while (true)
      if (localIterator2.hasNext())
      {
        Api localApi = (Api)localIterator2.next();
        Api.AnyClientKey localAnyClientKey = localApi.getClientKey();
        if (localArrayMap1.containsKey(localAnyClientKey))
        {
          localArrayMap3.put(localApi, (Boolean)paramMap1.get(localApi));
          continue;
          bool = false;
          break;
        }
        if (localArrayMap2.containsKey(localAnyClientKey))
          localArrayMap4.put(localApi, (Boolean)paramMap1.get(localApi));
        else
          throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
      }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = (ArrayList)paramArrayList;
    int i = localArrayList3.size();
    int j = 0;
    while (j < i)
    {
      Object localObject2 = localArrayList3.get(j);
      j++;
      zaq localzaq = (zaq)localObject2;
      if (localArrayMap3.containsKey(localzaq.mApi))
        localArrayList1.add(localzaq);
      else if (localArrayMap4.containsKey(localzaq.mApi))
        localArrayList2.add(localzaq);
      else
        throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
    }
    return new zas(paramContext, paramzaaw, paramLock, paramLooper, paramGoogleApiAvailabilityLight, localArrayMap1, localArrayMap2, paramClientSettings, paramAbstractClientBuilder, localObject1, localArrayList1, localArrayList2, localArrayMap3, localArrayMap4);
  }

  @GuardedBy("mLock")
  private final void zaa(int paramInt, boolean paramBoolean)
  {
    this.zaed.zab(paramInt, paramBoolean);
    this.zael = null;
    this.zaek = null;
  }

  private final void zaa(Bundle paramBundle)
  {
    if (this.zaej == null)
      this.zaej = paramBundle;
    while (paramBundle == null)
      return;
    this.zaej.putAll(paramBundle);
  }

  @GuardedBy("mLock")
  private final void zaa(ConnectionResult paramConnectionResult)
  {
    switch (this.zaeo)
    {
    default:
      Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
    case 2:
    case 1:
    }
    while (true)
    {
      this.zaeo = 0;
      return;
      this.zaed.zac(paramConnectionResult);
      zay();
    }
  }

  private final boolean zaa(BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient> paramApiMethodImpl)
  {
    Api.AnyClientKey localAnyClientKey = paramApiMethodImpl.getClientKey();
    Preconditions.checkArgument(this.zaeg.containsKey(localAnyClientKey), "GoogleApiClient is not configured to use the API required for this call.");
    return ((zabe)this.zaeg.get(localAnyClientKey)).equals(this.zaef);
  }

  private final PendingIntent zaaa()
  {
    if (this.zaei == null)
      return null;
    return PendingIntent.getActivity(this.mContext, System.identityHashCode(this.zaed), this.zaei.getSignInIntent(), 134217728);
  }

  private static boolean zab(ConnectionResult paramConnectionResult)
  {
    return (paramConnectionResult != null) && (paramConnectionResult.isSuccess());
  }

  @GuardedBy("mLock")
  private final void zax()
  {
    if (zab(this.zaek))
      if ((zab(this.zael)) || (zaz()))
        switch (this.zaeo)
        {
        default:
          Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
          this.zaeo = 0;
        case 2:
        case 1:
        }
    do
    {
      do
      {
        return;
        this.zaed.zab(this.zaej);
        zay();
        break;
      }
      while (this.zael == null);
      if (this.zaeo == 1)
      {
        zay();
        return;
      }
      zaa(this.zael);
      this.zaee.disconnect();
      return;
      if ((this.zaek != null) && (zab(this.zael)))
      {
        this.zaef.disconnect();
        zaa(this.zaek);
        return;
      }
    }
    while ((this.zaek == null) || (this.zael == null));
    ConnectionResult localConnectionResult = this.zaek;
    if (this.zaef.zahr < this.zaee.zahr)
      localConnectionResult = this.zael;
    zaa(localConnectionResult);
  }

  @GuardedBy("mLock")
  private final void zay()
  {
    Iterator localIterator = this.zaeh.iterator();
    while (localIterator.hasNext())
      ((SignInConnectionListener)localIterator.next()).onComplete();
    this.zaeh.clear();
  }

  @GuardedBy("mLock")
  private final boolean zaz()
  {
    return (this.zael != null) && (this.zael.getErrorCode() == 4);
  }

  @GuardedBy("mLock")
  public final ConnectionResult blockingConnect()
  {
    throw new UnsupportedOperationException();
  }

  @GuardedBy("mLock")
  public final ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    throw new UnsupportedOperationException();
  }

  @GuardedBy("mLock")
  public final void connect()
  {
    this.zaeo = 2;
    this.zaem = false;
    this.zael = null;
    this.zaek = null;
    this.zaee.connect();
    this.zaef.connect();
  }

  @GuardedBy("mLock")
  public final void disconnect()
  {
    this.zael = null;
    this.zaek = null;
    this.zaeo = 0;
    this.zaee.disconnect();
    this.zaef.disconnect();
    zay();
  }

  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.append(paramString).append("authClient").println(":");
    this.zaef.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.append(paramString).append("anonClient").println(":");
    this.zaee.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }

  @GuardedBy("mLock")
  public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T paramT)
  {
    if (zaa(paramT))
    {
      if (zaz())
      {
        paramT.setFailedResult(new Status(4, null, zaaa()));
        return paramT;
      }
      return this.zaef.enqueue(paramT);
    }
    return this.zaee.enqueue(paramT);
  }

  @GuardedBy("mLock")
  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T paramT)
  {
    if (zaa(paramT))
    {
      if (zaz())
      {
        paramT.setFailedResult(new Status(4, null, zaaa()));
        return paramT;
      }
      return this.zaef.execute(paramT);
    }
    return this.zaee.execute(paramT);
  }

  @GuardedBy("mLock")
  public final ConnectionResult getConnectionResult(Api<?> paramApi)
  {
    if (((zabe)this.zaeg.get(paramApi.getClientKey())).equals(this.zaef))
    {
      if (zaz())
        return new ConnectionResult(4, zaaa());
      return this.zaef.getConnectionResult(paramApi);
    }
    return this.zaee.getConnectionResult(paramApi);
  }

  public final boolean isConnected()
  {
    int i = 1;
    this.zaen.lock();
    try
    {
      if (this.zaee.isConnected())
        if ((!this.zaef.isConnected()) && (!zaz()))
        {
          int j = this.zaeo;
          if (j != i);
        }
        else
        {
          return i;
        }
      i = 0;
    }
    finally
    {
      this.zaen.unlock();
    }
  }

  public final boolean isConnecting()
  {
    this.zaen.lock();
    try
    {
      int i = this.zaeo;
      if (i == 2)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
      this.zaen.unlock();
    }
  }

  public final boolean maybeSignIn(SignInConnectionListener paramSignInConnectionListener)
  {
    this.zaen.lock();
    try
    {
      if (((isConnecting()) || (isConnected())) && (!this.zaef.isConnected()))
      {
        this.zaeh.add(paramSignInConnectionListener);
        if (this.zaeo == 0)
          this.zaeo = 1;
        this.zael = null;
        this.zaef.connect();
        return true;
      }
      return false;
    }
    finally
    {
      this.zaen.unlock();
    }
  }

  public final void maybeSignOut()
  {
    this.zaen.lock();
    try
    {
      boolean bool = isConnecting();
      this.zaef.disconnect();
      this.zael = new ConnectionResult(4);
      if (bool)
        new zal(this.zabj).post(new zat(this));
      while (true)
      {
        return;
        zay();
      }
    }
    finally
    {
      this.zaen.unlock();
    }
  }

  @GuardedBy("mLock")
  public final void zaw()
  {
    this.zaee.zaw();
    this.zaef.zaw();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zas
 * JD-Core Version:    0.6.2
 */