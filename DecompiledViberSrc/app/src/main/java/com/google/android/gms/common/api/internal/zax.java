package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.ClientSettings.OptionalApiSettings;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import com.google.android.gms.tasks.Task;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

public final class zax
  implements zabs
{
  private final Looper zabj;
  private final GoogleApiManager zabm;
  private final Lock zaen;
  private final ClientSettings zaes;
  private final Map<Api.AnyClientKey<?>, zaw<?>> zaet = new HashMap();
  private final Map<Api.AnyClientKey<?>, zaw<?>> zaeu = new HashMap();
  private final Map<Api<?>, Boolean> zaev;
  private final zaaw zaew;
  private final GoogleApiAvailabilityLight zaex;
  private final Condition zaey;
  private final boolean zaez;
  private final boolean zafa;
  private final Queue<BaseImplementation.ApiMethodImpl<?, ?>> zafb = new LinkedList();

  @GuardedBy("mLock")
  private boolean zafc;

  @GuardedBy("mLock")
  private Map<zai<?>, ConnectionResult> zafd;

  @GuardedBy("mLock")
  private Map<zai<?>, ConnectionResult> zafe;

  @GuardedBy("mLock")
  private zaaa zaff;

  @GuardedBy("mLock")
  private ConnectionResult zafg;

  public zax(Context paramContext, Lock paramLock, Looper paramLooper, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> paramMap, ClientSettings paramClientSettings, Map<Api<?>, Boolean> paramMap1, Api.AbstractClientBuilder<? extends zad, SignInOptions> paramAbstractClientBuilder, ArrayList<zaq> paramArrayList, zaaw paramzaaw, boolean paramBoolean)
  {
    this.zaen = paramLock;
    this.zabj = paramLooper;
    this.zaey = paramLock.newCondition();
    this.zaex = paramGoogleApiAvailabilityLight;
    this.zaew = paramzaaw;
    this.zaev = paramMap1;
    this.zaes = paramClientSettings;
    this.zaez = paramBoolean;
    HashMap localHashMap1 = new HashMap();
    Iterator localIterator1 = paramMap1.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Api localApi2 = (Api)localIterator1.next();
      localHashMap1.put(localApi2.getClientKey(), localApi2);
    }
    HashMap localHashMap2 = new HashMap();
    ArrayList localArrayList = (ArrayList)paramArrayList;
    int i = localArrayList.size();
    int j = 0;
    while (j < i)
    {
      Object localObject = localArrayList.get(j);
      j++;
      zaq localzaq = (zaq)localObject;
      localHashMap2.put(localzaq.mApi, localzaq);
    }
    Iterator localIterator2 = paramMap.entrySet().iterator();
    int k = 1;
    int m = 0;
    int n = 0;
    Map.Entry localEntry;
    Api localApi1;
    Api.Client localClient;
    int i1;
    int i3;
    int i2;
    if (localIterator2.hasNext())
    {
      localEntry = (Map.Entry)localIterator2.next();
      localApi1 = (Api)localHashMap1.get(localEntry.getKey());
      localClient = (Api.Client)localEntry.getValue();
      if (localClient.requiresGooglePlayServices())
      {
        i1 = 1;
        if (((Boolean)this.zaev.get(localApi1)).booleanValue())
          break label488;
        i3 = k;
        i2 = 1;
      }
    }
    while (true)
    {
      zaw localzaw = new zaw(paramContext, localApi1, paramLooper, localClient, (zaq)localHashMap2.get(localApi1), paramClientSettings, paramAbstractClientBuilder);
      this.zaet.put((Api.AnyClientKey)localEntry.getKey(), localzaw);
      if (localClient.requiresSignIn())
        this.zaeu.put((Api.AnyClientKey)localEntry.getKey(), localzaw);
      n = i1;
      k = i3;
      m = i2;
      break;
      i1 = n;
      i2 = m;
      i3 = 0;
      continue;
      if ((n != 0) && (k == 0) && (m == 0));
      for (boolean bool = true; ; bool = false)
      {
        this.zafa = bool;
        this.zabm = GoogleApiManager.zabc();
        return;
      }
      label488: i3 = k;
      i2 = m;
    }
  }

  private final ConnectionResult zaa(Api.AnyClientKey<?> paramAnyClientKey)
  {
    this.zaen.lock();
    try
    {
      zaw localzaw = (zaw)this.zaet.get(paramAnyClientKey);
      if ((this.zafd != null) && (localzaw != null))
      {
        ConnectionResult localConnectionResult = (ConnectionResult)this.zafd.get(localzaw.zak());
        return localConnectionResult;
      }
      return null;
    }
    finally
    {
      this.zaen.unlock();
    }
  }

  private final boolean zaa(zaw<?> paramzaw, ConnectionResult paramConnectionResult)
  {
    return (!paramConnectionResult.isSuccess()) && (!paramConnectionResult.hasResolution()) && (((Boolean)this.zaev.get(paramzaw.getApi())).booleanValue()) && (paramzaw.zaab().requiresGooglePlayServices()) && (this.zaex.isUserResolvableError(paramConnectionResult.getErrorCode()));
  }

  private final boolean zaac()
  {
    this.zaen.lock();
    try
    {
      if (this.zafc)
      {
        boolean bool1 = this.zaez;
        if (bool1);
      }
      else
      {
        return false;
      }
      Iterator localIterator = this.zaeu.keySet().iterator();
      while (localIterator.hasNext())
      {
        ConnectionResult localConnectionResult = zaa((Api.AnyClientKey)localIterator.next());
        if (localConnectionResult != null)
        {
          boolean bool2 = localConnectionResult.isSuccess();
          if (bool2)
            break;
        }
        else
        {
          return false;
        }
      }
      return true;
    }
    finally
    {
      this.zaen.unlock();
    }
  }

  @GuardedBy("mLock")
  private final void zaad()
  {
    if (this.zaes == null)
    {
      this.zaew.zagz = Collections.emptySet();
      return;
    }
    HashSet localHashSet = new HashSet(this.zaes.getRequiredScopes());
    Map localMap = this.zaes.getOptionalApiSettings();
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api localApi = (Api)localIterator.next();
      ConnectionResult localConnectionResult = getConnectionResult(localApi);
      if ((localConnectionResult != null) && (localConnectionResult.isSuccess()))
        localHashSet.addAll(((ClientSettings.OptionalApiSettings)localMap.get(localApi)).mScopes);
    }
    this.zaew.zagz = localHashSet;
  }

  @GuardedBy("mLock")
  private final void zaae()
  {
    while (!this.zafb.isEmpty())
      execute((BaseImplementation.ApiMethodImpl)this.zafb.remove());
    this.zaew.zab(null);
  }

  @GuardedBy("mLock")
  private final ConnectionResult zaaf()
  {
    Iterator localIterator = this.zaet.values().iterator();
    int i = 0;
    Object localObject1 = null;
    int j = 0;
    Object localObject2 = null;
    Object localObject3;
    int m;
    while (localIterator.hasNext())
    {
      zaw localzaw = (zaw)localIterator.next();
      Api localApi = localzaw.getApi();
      zai localzai = localzaw.zak();
      ConnectionResult localConnectionResult = (ConnectionResult)this.zafd.get(localzai);
      if ((!localConnectionResult.isSuccess()) && ((!((Boolean)this.zaev.get(localApi)).booleanValue()) || (localConnectionResult.hasResolution()) || (this.zaex.isUserResolvableError(localConnectionResult.getErrorCode()))))
        if ((localConnectionResult.getErrorCode() == 4) && (this.zaez))
        {
          int n = localApi.zah().getPriority();
          if ((localObject1 == null) || (i > n))
          {
            i = n;
            localObject1 = localConnectionResult;
          }
        }
        else
        {
          int k = localApi.zah().getPriority();
          if ((localObject2 != null) && (j <= k))
            break label232;
          localObject3 = localConnectionResult;
          m = k;
        }
    }
    while (true)
    {
      j = m;
      localObject2 = localObject3;
      break;
      if ((localObject2 != null) && (localObject1 != null) && (j > i))
        return localObject1;
      return localObject2;
      label232: m = j;
      localObject3 = localObject2;
    }
  }

  private final <T extends BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient>> boolean zab(T paramT)
  {
    Api.AnyClientKey localAnyClientKey = paramT.getClientKey();
    ConnectionResult localConnectionResult = zaa(localAnyClientKey);
    if ((localConnectionResult != null) && (localConnectionResult.getErrorCode() == 4))
    {
      paramT.setFailedResult(new Status(4, null, this.zabm.zaa(((zaw)this.zaet.get(localAnyClientKey)).zak(), System.identityHashCode(this.zaew))));
      return true;
    }
    return false;
  }

  @GuardedBy("mLock")
  public final ConnectionResult blockingConnect()
  {
    connect();
    while (isConnecting())
      try
      {
        this.zaey.await();
      }
      catch (InterruptedException localInterruptedException)
      {
        Thread.currentThread().interrupt();
        return new ConnectionResult(15, null);
      }
    if (isConnected())
      return ConnectionResult.RESULT_SUCCESS;
    if (this.zafg != null)
      return this.zafg;
    return new ConnectionResult(13, null);
  }

  @GuardedBy("mLock")
  public final ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    connect();
    long l1 = paramTimeUnit.toNanos(paramLong);
    while (isConnecting())
    {
      if (l1 <= 0L);
      try
      {
        disconnect();
        return new ConnectionResult(14, null);
        long l2 = this.zaey.awaitNanos(l1);
        l1 = l2;
      }
      catch (InterruptedException localInterruptedException)
      {
        Thread.currentThread().interrupt();
        return new ConnectionResult(15, null);
      }
    }
    if (isConnected())
      return ConnectionResult.RESULT_SUCCESS;
    if (this.zafg != null)
      return this.zafg;
    return new ConnectionResult(13, null);
  }

  public final void connect()
  {
    this.zaen.lock();
    try
    {
      boolean bool = this.zafc;
      if (bool)
        return;
      this.zafc = true;
      this.zafd = null;
      this.zafe = null;
      this.zaff = null;
      this.zafg = null;
      this.zabm.zao();
      this.zabm.zaa(this.zaet.values()).addOnCompleteListener(new HandlerExecutor(this.zabj), new zaz(this, null));
      return;
    }
    finally
    {
      this.zaen.unlock();
    }
  }

  public final void disconnect()
  {
    this.zaen.lock();
    try
    {
      this.zafc = false;
      this.zafd = null;
      this.zafe = null;
      if (this.zaff != null)
      {
        this.zaff.cancel();
        this.zaff = null;
      }
      this.zafg = null;
      while (!this.zafb.isEmpty())
      {
        BaseImplementation.ApiMethodImpl localApiMethodImpl = (BaseImplementation.ApiMethodImpl)this.zafb.remove();
        localApiMethodImpl.zaa(null);
        localApiMethodImpl.cancel();
      }
    }
    finally
    {
      this.zaen.unlock();
    }
    this.zaey.signalAll();
    this.zaen.unlock();
  }

  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
  }

  public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T paramT)
  {
    if ((this.zaez) && (zab(paramT)))
      return paramT;
    if (!isConnected())
    {
      this.zafb.add(paramT);
      return paramT;
    }
    this.zaew.zahe.zab(paramT);
    return ((zaw)this.zaet.get(paramT.getClientKey())).doRead(paramT);
  }

  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T paramT)
  {
    Api.AnyClientKey localAnyClientKey = paramT.getClientKey();
    if ((this.zaez) && (zab(paramT)))
      return paramT;
    this.zaew.zahe.zab(paramT);
    return ((zaw)this.zaet.get(localAnyClientKey)).doWrite(paramT);
  }

  public final ConnectionResult getConnectionResult(Api<?> paramApi)
  {
    return zaa(paramApi.getClientKey());
  }

  public final boolean isConnected()
  {
    this.zaen.lock();
    try
    {
      if (this.zafd != null)
      {
        ConnectionResult localConnectionResult = this.zafg;
        if (localConnectionResult == null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
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
      if (this.zafd == null)
      {
        boolean bool2 = this.zafc;
        if (bool2)
        {
          bool1 = true;
          return bool1;
        }
      }
      boolean bool1 = false;
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
      if ((this.zafc) && (!zaac()))
      {
        this.zabm.zao();
        this.zaff = new zaaa(this, paramSignInConnectionListener);
        this.zabm.zaa(this.zaeu.values()).addOnCompleteListener(new HandlerExecutor(this.zabj), this.zaff);
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
      this.zabm.maybeSignOut();
      if (this.zaff != null)
      {
        this.zaff.cancel();
        this.zaff = null;
      }
      if (this.zafe == null)
        this.zafe = new ArrayMap(this.zaeu.size());
      ConnectionResult localConnectionResult = new ConnectionResult(4);
      Iterator localIterator = this.zaeu.values().iterator();
      while (localIterator.hasNext())
      {
        zaw localzaw = (zaw)localIterator.next();
        this.zafe.put(localzaw.zak(), localConnectionResult);
      }
    }
    finally
    {
      this.zaen.unlock();
    }
    if (this.zafd != null)
      this.zafd.putAll(this.zafe);
    this.zaen.unlock();
  }

  public final void zaw()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zax
 * JD-Core Version:    0.6.2
 */