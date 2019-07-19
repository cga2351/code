package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClientEventManager;
import com.google.android.gms.common.internal.GmsClientEventManager.GmsClientEventState;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.common.internal.service.zac;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

public final class zaaw extends GoogleApiClient
  implements zabt
{
  private final Context mContext;
  private final Looper zabj;
  private final int zaca;
  private final GoogleApiAvailability zacc;
  private final Api.AbstractClientBuilder<? extends zad, SignInOptions> zacd;
  private boolean zacg;
  private final Lock zaen;
  private final ClientSettings zaes;
  private final Map<Api<?>, Boolean> zaev;

  @VisibleForTesting
  final Queue<BaseImplementation.ApiMethodImpl<?, ?>> zafb = new LinkedList();
  private final GmsClientEventManager zagr;
  private zabs zags = null;
  private volatile boolean zagt;
  private long zagu;
  private long zagv;
  private final zabb zagw;

  @VisibleForTesting
  private zabq zagx;
  final Map<Api.AnyClientKey<?>, Api.Client> zagy;
  Set<Scope> zagz;
  private final ListenerHolders zaha;
  private final ArrayList<zaq> zahb;
  private Integer zahc;
  Set<zacm> zahd;
  final zacp zahe;
  private final GmsClientEventManager.GmsClientEventState zahf;

  public zaaw(Context paramContext, Lock paramLock, Looper paramLooper, ClientSettings paramClientSettings, GoogleApiAvailability paramGoogleApiAvailability, Api.AbstractClientBuilder<? extends zad, SignInOptions> paramAbstractClientBuilder, Map<Api<?>, Boolean> paramMap, List<GoogleApiClient.ConnectionCallbacks> paramList, List<GoogleApiClient.OnConnectionFailedListener> paramList1, Map<Api.AnyClientKey<?>, Api.Client> paramMap1, int paramInt1, int paramInt2, ArrayList<zaq> paramArrayList, boolean paramBoolean)
  {
    if (ClientLibraryUtils.isPackageSide());
    for (long l = 10000L; ; l = 120000L)
    {
      this.zagu = l;
      this.zagv = 5000L;
      this.zagz = new HashSet();
      this.zaha = new ListenerHolders();
      this.zahc = null;
      this.zahd = null;
      this.zahf = new zaax(this);
      this.mContext = paramContext;
      this.zaen = paramLock;
      this.zacg = false;
      this.zagr = new GmsClientEventManager(paramLooper, this.zahf);
      this.zabj = paramLooper;
      this.zagw = new zabb(this, paramLooper);
      this.zacc = paramGoogleApiAvailability;
      this.zaca = paramInt1;
      if (this.zaca >= 0)
        this.zahc = Integer.valueOf(paramInt2);
      this.zaev = paramMap;
      this.zagy = paramMap1;
      this.zahb = paramArrayList;
      this.zahe = new zacp(this.zagy);
      Iterator localIterator1 = paramList.iterator();
      while (localIterator1.hasNext())
      {
        GoogleApiClient.ConnectionCallbacks localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)localIterator1.next();
        this.zagr.registerConnectionCallbacks(localConnectionCallbacks);
      }
    }
    Iterator localIterator2 = paramList1.iterator();
    while (localIterator2.hasNext())
    {
      GoogleApiClient.OnConnectionFailedListener localOnConnectionFailedListener = (GoogleApiClient.OnConnectionFailedListener)localIterator2.next();
      this.zagr.registerConnectionFailedListener(localOnConnectionFailedListener);
    }
    this.zaes = paramClientSettings;
    this.zacd = paramAbstractClientBuilder;
  }

  private final void resume()
  {
    this.zaen.lock();
    try
    {
      if (this.zagt)
        zaau();
      return;
    }
    finally
    {
      this.zaen.unlock();
    }
  }

  public static int zaa(Iterable<Api.Client> paramIterable, boolean paramBoolean)
  {
    int i = 1;
    Iterator localIterator = paramIterable.iterator();
    int j = 0;
    int k = 0;
    if (localIterator.hasNext())
    {
      Api.Client localClient = (Api.Client)localIterator.next();
      if (localClient.requiresSignIn())
        k = i;
      if (!localClient.providesSignIn())
        break label88;
    }
    label88: for (int m = i; ; m = j)
    {
      j = m;
      break;
      if (k != 0)
      {
        if ((j != 0) && (paramBoolean))
          i = 2;
        return i;
      }
      return 3;
    }
  }

  private final void zaa(GoogleApiClient paramGoogleApiClient, StatusPendingResult paramStatusPendingResult, boolean paramBoolean)
  {
    Common.zaph.zaa(paramGoogleApiClient).setResultCallback(new zaba(this, paramStatusPendingResult, paramBoolean, paramGoogleApiClient));
  }

  @GuardedBy("mLock")
  private final void zaau()
  {
    this.zagr.enableCallbacks();
    this.zags.connect();
  }

  private final void zaav()
  {
    this.zaen.lock();
    try
    {
      if (zaaw())
        zaau();
      return;
    }
    finally
    {
      this.zaen.unlock();
    }
  }

  private final void zae(int paramInt)
  {
    if (this.zahc == null)
      this.zahc = Integer.valueOf(paramInt);
    while (this.zags != null)
    {
      return;
      if (this.zahc.intValue() != paramInt)
      {
        String str1 = zaf(paramInt);
        String str2 = zaf(this.zahc.intValue());
        throw new IllegalStateException(51 + String.valueOf(str1).length() + String.valueOf(str2).length() + "Cannot use sign-in mode: " + str1 + ". Mode was already set to " + str2);
      }
    }
    Iterator localIterator = this.zagy.values().iterator();
    int i = 0;
    int j = 0;
    if (localIterator.hasNext())
    {
      Api.Client localClient = (Api.Client)localIterator.next();
      if (localClient.requiresSignIn())
        j = 1;
      if (!localClient.providesSignIn())
        break label467;
    }
    label467: for (int k = 1; ; k = i)
    {
      i = k;
      break;
      switch (this.zahc.intValue())
      {
      case 3:
      default:
      case 1:
      case 2:
      }
      while ((this.zacg) && (i == 0))
      {
        this.zags = new zax(this.mContext, this.zaen, this.zabj, this.zacc, this.zagy, this.zaes, this.zaev, this.zacd, this.zahb, this, false);
        return;
        if (j == 0)
          throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
        if (i != 0)
        {
          throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
          if (j != 0)
          {
            if (this.zacg)
            {
              this.zags = new zax(this.mContext, this.zaen, this.zabj, this.zacc, this.zagy, this.zaes, this.zaev, this.zacd, this.zahb, this, true);
              return;
            }
            this.zags = zas.zaa(this.mContext, this, this.zaen, this.zabj, this.zacc, this.zagy, this.zaes, this.zaev, this.zacd, this.zahb);
            return;
          }
        }
      }
      this.zags = new zabe(this.mContext, this, this.zaen, this.zabj, this.zacc, this.zagy, this.zaes, this.zaev, this.zacd, this.zahb, this);
      return;
    }
  }

  private static String zaf(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "UNKNOWN";
    case 3:
      return "SIGN_IN_MODE_NONE";
    case 1:
      return "SIGN_IN_MODE_REQUIRED";
    case 2:
    }
    return "SIGN_IN_MODE_OPTIONAL";
  }

  public final ConnectionResult blockingConnect()
  {
    boolean bool1 = true;
    boolean bool2;
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      bool2 = bool1;
      Preconditions.checkState(bool2, "blockingConnect must not be called on the UI thread");
      this.zaen.lock();
    }
    label43: 
    do
      try
      {
        if (this.zaca >= 0)
          if (this.zahc != null)
            Preconditions.checkState(bool1, "Sign-in mode should have been set explicitly by auto-manage.");
        while (true)
        {
          zae(this.zahc.intValue());
          this.zagr.enableCallbacks();
          ConnectionResult localConnectionResult = this.zags.blockingConnect();
          return localConnectionResult;
          bool2 = false;
          break;
          bool1 = false;
          break label43;
          if (this.zahc != null)
            break label143;
          this.zahc = Integer.valueOf(zaa(this.zagy.values(), false));
        }
      }
      finally
      {
        this.zaen.unlock();
      }
    while (this.zahc.intValue() != 2);
    label143: throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
  }

  public final ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    Looper localLooper1 = Looper.myLooper();
    Looper localLooper2 = Looper.getMainLooper();
    boolean bool = false;
    if (localLooper1 != localLooper2)
      bool = true;
    Preconditions.checkState(bool, "blockingConnect must not be called on the UI thread");
    Preconditions.checkNotNull(paramTimeUnit, "TimeUnit must not be null");
    this.zaen.lock();
    try
    {
      if (this.zahc == null)
        this.zahc = Integer.valueOf(zaa(this.zagy.values(), false));
      while (this.zahc.intValue() != 2)
      {
        zae(this.zahc.intValue());
        this.zagr.enableCallbacks();
        ConnectionResult localConnectionResult = this.zags.blockingConnect(paramLong, paramTimeUnit);
        return localConnectionResult;
      }
      throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
    }
    finally
    {
      this.zaen.unlock();
    }
  }

  public final PendingResult<Status> clearDefaultAccountAndReconnect()
  {
    Preconditions.checkState(isConnected(), "GoogleApiClient is not connected yet.");
    if (this.zahc.intValue() != 2);
    StatusPendingResult localStatusPendingResult;
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
      localStatusPendingResult = new StatusPendingResult(this);
      if (!this.zagy.containsKey(Common.CLIENT_KEY))
        break;
      zaa(this, localStatusPendingResult, false);
      return localStatusPendingResult;
    }
    AtomicReference localAtomicReference = new AtomicReference();
    zaay localzaay = new zaay(this, localAtomicReference, localStatusPendingResult);
    zaaz localzaaz = new zaaz(this, localStatusPendingResult);
    GoogleApiClient localGoogleApiClient = new GoogleApiClient.Builder(this.mContext).addApi(Common.API).addConnectionCallbacks(localzaay).addOnConnectionFailedListener(localzaaz).setHandler(this.zagw).build();
    localAtomicReference.set(localGoogleApiClient);
    localGoogleApiClient.connect();
    return localStatusPendingResult;
  }

  public final void connect()
  {
    this.zaen.lock();
    do
      try
      {
        if (this.zaca >= 0)
        {
          Integer localInteger = this.zahc;
          boolean bool = false;
          if (localInteger != null)
            bool = true;
          Preconditions.checkState(bool, "Sign-in mode should have been set explicitly by auto-manage.");
        }
        while (true)
        {
          connect(this.zahc.intValue());
          return;
          if (this.zahc != null)
            break;
          this.zahc = Integer.valueOf(zaa(this.zagy.values(), false));
        }
      }
      finally
      {
        this.zaen.unlock();
      }
    while (this.zahc.intValue() != 2);
    throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
  }

  public final void connect(int paramInt)
  {
    int i = 1;
    this.zaen.lock();
    if ((paramInt == 3) || (paramInt == i) || (paramInt == 2));
    try
    {
      Preconditions.checkArgument(i, 33 + "Illegal sign-in mode: " + paramInt);
      zae(paramInt);
      zaau();
      return;
      i = 0;
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
      this.zahe.release();
      if (this.zags != null)
        this.zags.disconnect();
      this.zaha.release();
      Iterator localIterator = this.zafb.iterator();
      while (localIterator.hasNext())
      {
        BaseImplementation.ApiMethodImpl localApiMethodImpl = (BaseImplementation.ApiMethodImpl)localIterator.next();
        localApiMethodImpl.zaa(null);
        localApiMethodImpl.cancel();
      }
    }
    finally
    {
      this.zaen.unlock();
    }
    this.zafb.clear();
    zabs localzabs = this.zags;
    if (localzabs == null)
    {
      this.zaen.unlock();
      return;
    }
    zaaw();
    this.zagr.disableCallbacks();
    this.zaen.unlock();
  }

  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.append(paramString).append("mContext=").println(this.mContext);
    paramPrintWriter.append(paramString).append("mResuming=").print(this.zagt);
    paramPrintWriter.append(" mWorkQueue.size()=").print(this.zafb.size());
    zacp localzacp = this.zahe;
    paramPrintWriter.append(" mUnconsumedApiCalls.size()=").println(localzacp.zaky.size());
    if (this.zags != null)
      this.zags.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }

  public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T paramT)
  {
    boolean bool1;
    if (paramT.getClientKey() != null)
      bool1 = true;
    while (true)
    {
      Preconditions.checkArgument(bool1, "This task can not be enqueued (it's probably a Batch or malformed)");
      boolean bool2 = this.zagy.containsKey(paramT.getClientKey());
      String str;
      if (paramT.getApi() != null)
      {
        str = paramT.getApi().getName();
        label46: Preconditions.checkArgument(bool2, 65 + String.valueOf(str).length() + "GoogleApiClient is not configured to use " + str + " required for this call.");
        this.zaen.lock();
      }
      try
      {
        if (this.zags == null)
        {
          this.zafb.add(paramT);
          return paramT;
          bool1 = false;
          continue;
          str = "the API";
          break label46;
        }
        BaseImplementation.ApiMethodImpl localApiMethodImpl = this.zags.enqueue(paramT);
        return localApiMethodImpl;
      }
      finally
      {
        this.zaen.unlock();
      }
    }
  }

  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T paramT)
  {
    boolean bool1;
    boolean bool2;
    if (paramT.getClientKey() != null)
    {
      bool1 = true;
      Preconditions.checkArgument(bool1, "This task can not be executed (it's probably a Batch or malformed)");
      bool2 = this.zagy.containsKey(paramT.getClientKey());
      if (paramT.getApi() == null)
        break label134;
    }
    label134: for (String str = paramT.getApi().getName(); ; str = "the API")
    {
      Preconditions.checkArgument(bool2, 65 + String.valueOf(str).length() + "GoogleApiClient is not configured to use " + str + " required for this call.");
      this.zaen.lock();
      try
      {
        if (this.zags != null)
          break label142;
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
      }
      finally
      {
        this.zaen.unlock();
      }
      bool1 = false;
      break;
    }
    label142: if (this.zagt)
    {
      this.zafb.add(paramT);
      while (!this.zafb.isEmpty())
      {
        BaseImplementation.ApiMethodImpl localApiMethodImpl2 = (BaseImplementation.ApiMethodImpl)this.zafb.remove();
        this.zahe.zab(localApiMethodImpl2);
        localApiMethodImpl2.setFailedResult(Status.RESULT_INTERNAL_ERROR);
      }
      this.zaen.unlock();
      return paramT;
    }
    BaseImplementation.ApiMethodImpl localApiMethodImpl1 = this.zags.execute(paramT);
    this.zaen.unlock();
    return localApiMethodImpl1;
  }

  public final <C extends Api.Client> C getClient(Api.AnyClientKey<C> paramAnyClientKey)
  {
    Api.Client localClient = (Api.Client)this.zagy.get(paramAnyClientKey);
    Preconditions.checkNotNull(localClient, "Appropriate Api was not requested.");
    return localClient;
  }

  public final ConnectionResult getConnectionResult(Api<?> paramApi)
  {
    this.zaen.lock();
    try
    {
      if ((!isConnected()) && (!this.zagt))
        throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
    }
    finally
    {
      this.zaen.unlock();
    }
    if (this.zagy.containsKey(paramApi.getClientKey()))
    {
      ConnectionResult localConnectionResult1 = this.zags.getConnectionResult(paramApi);
      if (localConnectionResult1 == null)
      {
        if (this.zagt)
        {
          ConnectionResult localConnectionResult3 = ConnectionResult.RESULT_SUCCESS;
          this.zaen.unlock();
          return localConnectionResult3;
        }
        Log.w("GoogleApiClientImpl", zaay());
        Log.wtf("GoogleApiClientImpl", String.valueOf(paramApi.getName()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map"), new Exception());
        ConnectionResult localConnectionResult2 = new ConnectionResult(8, null);
        this.zaen.unlock();
        return localConnectionResult2;
      }
      this.zaen.unlock();
      return localConnectionResult1;
    }
    throw new IllegalArgumentException(String.valueOf(paramApi.getName()).concat(" was never registered with GoogleApiClient"));
  }

  public final Context getContext()
  {
    return this.mContext;
  }

  public final Looper getLooper()
  {
    return this.zabj;
  }

  public final boolean hasApi(Api<?> paramApi)
  {
    return this.zagy.containsKey(paramApi.getClientKey());
  }

  public final boolean hasConnectedApi(Api<?> paramApi)
  {
    if (!isConnected())
      return false;
    Api.Client localClient = (Api.Client)this.zagy.get(paramApi.getClientKey());
    return (localClient != null) && (localClient.isConnected());
  }

  public final boolean isConnected()
  {
    return (this.zags != null) && (this.zags.isConnected());
  }

  public final boolean isConnecting()
  {
    return (this.zags != null) && (this.zags.isConnecting());
  }

  public final boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return this.zagr.isConnectionCallbacksRegistered(paramConnectionCallbacks);
  }

  public final boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return this.zagr.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }

  public final boolean maybeSignIn(SignInConnectionListener paramSignInConnectionListener)
  {
    return (this.zags != null) && (this.zags.maybeSignIn(paramSignInConnectionListener));
  }

  public final void maybeSignOut()
  {
    if (this.zags != null)
      this.zags.maybeSignOut();
  }

  public final void reconnect()
  {
    disconnect();
    connect();
  }

  public final void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.zagr.registerConnectionCallbacks(paramConnectionCallbacks);
  }

  public final void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.zagr.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }

  public final <L> ListenerHolder<L> registerListener(L paramL)
  {
    this.zaen.lock();
    try
    {
      ListenerHolder localListenerHolder = this.zaha.zaa(paramL, this.zabj, "NO_TYPE");
      return localListenerHolder;
    }
    finally
    {
      this.zaen.unlock();
    }
  }

  public final void stopAutoManage(FragmentActivity paramFragmentActivity)
  {
    LifecycleActivity localLifecycleActivity = new LifecycleActivity(paramFragmentActivity);
    if (this.zaca >= 0)
    {
      zaj.zaa(localLifecycleActivity).zaa(this.zaca);
      return;
    }
    throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
  }

  public final void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.zagr.unregisterConnectionCallbacks(paramConnectionCallbacks);
  }

  public final void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.zagr.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }

  public final void zaa(zacm paramzacm)
  {
    this.zaen.lock();
    try
    {
      if (this.zahd == null)
        this.zahd = new HashSet();
      this.zahd.add(paramzacm);
      return;
    }
    finally
    {
      this.zaen.unlock();
    }
  }

  @GuardedBy("mLock")
  final boolean zaaw()
  {
    if (!this.zagt)
      return false;
    this.zagt = false;
    this.zagw.removeMessages(2);
    this.zagw.removeMessages(1);
    if (this.zagx != null)
    {
      this.zagx.unregister();
      this.zagx = null;
    }
    return true;
  }

  final boolean zaax()
  {
    this.zaen.lock();
    try
    {
      Set localSet = this.zahd;
      if (localSet == null)
        return false;
      boolean bool1 = this.zahd.isEmpty();
      boolean bool2 = false;
      if (!bool1)
        bool2 = true;
      return bool2;
    }
    finally
    {
      this.zaen.unlock();
    }
  }

  final String zaay()
  {
    StringWriter localStringWriter = new StringWriter();
    dump("", null, new PrintWriter(localStringWriter), null);
    return localStringWriter.toString();
  }

  @GuardedBy("mLock")
  public final void zab(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == 1) && (!paramBoolean) && (!this.zagt))
    {
      this.zagt = true;
      if ((this.zagx == null) && (!ClientLibraryUtils.isPackageSide()))
        this.zagx = this.zacc.zaa(this.mContext.getApplicationContext(), new zabc(this));
      this.zagw.sendMessageDelayed(this.zagw.obtainMessage(1), this.zagu);
      this.zagw.sendMessageDelayed(this.zagw.obtainMessage(2), this.zagv);
    }
    this.zahe.zabx();
    this.zagr.onUnintentionalDisconnection(paramInt);
    this.zagr.disableCallbacks();
    if (paramInt == 2)
      zaau();
  }

  @GuardedBy("mLock")
  public final void zab(Bundle paramBundle)
  {
    while (!this.zafb.isEmpty())
      execute((BaseImplementation.ApiMethodImpl)this.zafb.remove());
    this.zagr.onConnectionSuccess(paramBundle);
  }

  public final void zab(zacm paramzacm)
  {
    this.zaen.lock();
    while (true)
    {
      try
      {
        if (this.zahd == null)
        {
          Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
          return;
        }
        if (!this.zahd.remove(paramzacm))
        {
          Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
          continue;
        }
      }
      finally
      {
        this.zaen.unlock();
      }
      if (!zaax())
        this.zags.zaw();
    }
  }

  @GuardedBy("mLock")
  public final void zac(ConnectionResult paramConnectionResult)
  {
    if (!this.zacc.isPlayServicesPossiblyUpdating(this.mContext, paramConnectionResult.getErrorCode()))
      zaaw();
    if (!this.zagt)
    {
      this.zagr.onConnectionFailure(paramConnectionResult);
      this.zagr.disableCallbacks();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zaaw
 * JD-Core Version:    0.6.2
 */