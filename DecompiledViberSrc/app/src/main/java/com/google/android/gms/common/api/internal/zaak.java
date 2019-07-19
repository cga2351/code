package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.ClientSettings.OptionalApiSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.zaj;
import com.google.android.gms.signin.zad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

public final class zaak
  implements zabd
{
  private final Context mContext;
  private final Api.AbstractClientBuilder<? extends zad, SignInOptions> zacd;
  private final Lock zaen;
  private final ClientSettings zaes;
  private final Map<Api<?>, Boolean> zaev;
  private final GoogleApiAvailabilityLight zaex;
  private ConnectionResult zafg;
  private final zabe zafs;
  private int zafv;
  private int zafw = 0;
  private int zafx;
  private final Bundle zafy = new Bundle();
  private final Set<Api.AnyClientKey> zafz = new HashSet();
  private zad zaga;
  private boolean zagb;
  private boolean zagc;
  private boolean zagd;
  private IAccountAccessor zage;
  private boolean zagf;
  private boolean zagg;
  private ArrayList<Future<?>> zagh = new ArrayList();

  public zaak(zabe paramzabe, ClientSettings paramClientSettings, Map<Api<?>, Boolean> paramMap, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, Api.AbstractClientBuilder<? extends zad, SignInOptions> paramAbstractClientBuilder, Lock paramLock, Context paramContext)
  {
    this.zafs = paramzabe;
    this.zaes = paramClientSettings;
    this.zaev = paramMap;
    this.zaex = paramGoogleApiAvailabilityLight;
    this.zacd = paramAbstractClientBuilder;
    this.zaen = paramLock;
    this.mContext = paramContext;
  }

  @GuardedBy("mLock")
  private final void zaa(zaj paramzaj)
  {
    if (!zac(0))
      return;
    ConnectionResult localConnectionResult1 = paramzaj.getConnectionResult();
    if (localConnectionResult1.isSuccess())
    {
      ResolveAccountResponse localResolveAccountResponse = paramzaj.zacw();
      ConnectionResult localConnectionResult2 = localResolveAccountResponse.getConnectionResult();
      if (!localConnectionResult2.isSuccess())
      {
        String str = String.valueOf(localConnectionResult2);
        Log.wtf("GoogleApiClientConnecting", 48 + String.valueOf(str).length() + "Sign-in succeeded with resolve account failure: " + str, new Exception());
        zae(localConnectionResult2);
        return;
      }
      this.zagd = true;
      this.zage = localResolveAccountResponse.getAccountAccessor();
      this.zagf = localResolveAccountResponse.getSaveDefaultAccount();
      this.zagg = localResolveAccountResponse.isFromCrossClientAuth();
      zaap();
      return;
    }
    if (zad(localConnectionResult1))
    {
      zaar();
      zaap();
      return;
    }
    zae(localConnectionResult1);
  }

  @GuardedBy("mLock")
  private final boolean zaao()
  {
    this.zafx = (-1 + this.zafx);
    if (this.zafx > 0)
      return false;
    if (this.zafx < 0)
    {
      Log.w("GoogleApiClientConnecting", this.zafs.zaed.zaay());
      Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
      zae(new ConnectionResult(8, null));
      return false;
    }
    if (this.zafg != null)
    {
      this.zafs.zahr = this.zafv;
      zae(this.zafg);
      return false;
    }
    return true;
  }

  @GuardedBy("mLock")
  private final void zaap()
  {
    if (this.zafx != 0);
    ArrayList localArrayList;
    do
    {
      do
        return;
      while ((this.zagc) && (!this.zagd));
      localArrayList = new ArrayList();
      this.zafw = 1;
      this.zafx = this.zafs.zagy.size();
      Iterator localIterator = this.zafs.zagy.keySet().iterator();
      while (localIterator.hasNext())
      {
        Api.AnyClientKey localAnyClientKey = (Api.AnyClientKey)localIterator.next();
        if (this.zafs.zaho.containsKey(localAnyClientKey))
        {
          if (zaao())
            zaaq();
        }
        else
          localArrayList.add((Api.Client)this.zafs.zagy.get(localAnyClientKey));
      }
    }
    while (localArrayList.isEmpty());
    this.zagh.add(zabh.zabb().submit(new zaaq(this, localArrayList)));
  }

  @GuardedBy("mLock")
  private final void zaaq()
  {
    this.zafs.zaba();
    zabh.zabb().execute(new zaal(this));
    if (this.zaga != null)
    {
      if (this.zagf)
        this.zaga.zaa(this.zage, this.zagg);
      zab(false);
    }
    Iterator localIterator = this.zafs.zaho.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api.AnyClientKey localAnyClientKey = (Api.AnyClientKey)localIterator.next();
      ((Api.Client)this.zafs.zagy.get(localAnyClientKey)).disconnect();
    }
    if (this.zafy.isEmpty());
    for (Bundle localBundle = null; ; localBundle = this.zafy)
    {
      this.zafs.zahs.zab(localBundle);
      return;
    }
  }

  @GuardedBy("mLock")
  private final void zaar()
  {
    this.zagc = false;
    this.zafs.zaed.zagz = Collections.emptySet();
    Iterator localIterator = this.zafz.iterator();
    while (localIterator.hasNext())
    {
      Api.AnyClientKey localAnyClientKey = (Api.AnyClientKey)localIterator.next();
      if (!this.zafs.zaho.containsKey(localAnyClientKey))
        this.zafs.zaho.put(localAnyClientKey, new ConnectionResult(17, null));
    }
  }

  private final void zaas()
  {
    ArrayList localArrayList = (ArrayList)this.zagh;
    int i = localArrayList.size();
    int j = 0;
    while (j < i)
    {
      Object localObject = localArrayList.get(j);
      j++;
      ((Future)localObject).cancel(true);
    }
    this.zagh.clear();
  }

  private final Set<Scope> zaat()
  {
    if (this.zaes == null)
      return Collections.emptySet();
    HashSet localHashSet = new HashSet(this.zaes.getRequiredScopes());
    Map localMap = this.zaes.getOptionalApiSettings();
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api localApi = (Api)localIterator.next();
      if (!this.zafs.zaho.containsKey(localApi.getClientKey()))
        localHashSet.addAll(((ClientSettings.OptionalApiSettings)localMap.get(localApi)).mScopes);
    }
    return localHashSet;
  }

  @GuardedBy("mLock")
  private final void zab(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean)
  {
    int i = 1;
    int j = paramApi.zah().getPriority();
    int k;
    if (paramBoolean)
    {
      if (paramConnectionResult.hasResolution())
      {
        k = i;
        if (k == 0)
          break label110;
      }
    }
    else
      if ((this.zafg != null) && (j >= this.zafv))
        break label110;
    while (true)
    {
      if (i != 0)
      {
        this.zafg = paramConnectionResult;
        this.zafv = j;
      }
      this.zafs.zaho.put(paramApi.getClientKey(), paramConnectionResult);
      return;
      if (this.zaex.getErrorResolutionIntent(paramConnectionResult.getErrorCode()) != null)
      {
        k = i;
        break;
      }
      k = 0;
      break;
      label110: i = 0;
    }
  }

  private final void zab(boolean paramBoolean)
  {
    if (this.zaga != null)
    {
      if ((this.zaga.isConnected()) && (paramBoolean))
        this.zaga.zacv();
      this.zaga.disconnect();
      this.zage = null;
    }
  }

  @GuardedBy("mLock")
  private final boolean zac(int paramInt)
  {
    if (this.zafw != paramInt)
    {
      Log.w("GoogleApiClientConnecting", this.zafs.zaed.zaay());
      String str1 = String.valueOf(this);
      Log.w("GoogleApiClientConnecting", 23 + String.valueOf(str1).length() + "Unexpected callback in " + str1);
      int i = this.zafx;
      Log.w("GoogleApiClientConnecting", 33 + "mRemainingConnections=" + i);
      String str2 = zad(this.zafw);
      String str3 = zad(paramInt);
      Log.wtf("GoogleApiClientConnecting", 70 + String.valueOf(str2).length() + String.valueOf(str3).length() + "GoogleApiClient connecting is in step " + str2 + " but received callback for step " + str3, new Exception());
      zae(new ConnectionResult(8, null));
      return false;
    }
    return true;
  }

  private static String zad(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "UNKNOWN";
    case 0:
      return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    case 1:
    }
    return "STEP_GETTING_REMOTE_SERVICE";
  }

  @GuardedBy("mLock")
  private final boolean zad(ConnectionResult paramConnectionResult)
  {
    return (this.zagb) && (!paramConnectionResult.hasResolution());
  }

  @GuardedBy("mLock")
  private final void zae(ConnectionResult paramConnectionResult)
  {
    zaas();
    if (!paramConnectionResult.hasResolution());
    for (boolean bool = true; ; bool = false)
    {
      zab(bool);
      this.zafs.zaf(paramConnectionResult);
      this.zafs.zahs.zac(paramConnectionResult);
      return;
    }
  }

  public final void begin()
  {
    this.zafs.zaho.clear();
    this.zagc = false;
    this.zafg = null;
    this.zafw = 0;
    this.zagb = true;
    this.zagd = false;
    this.zagf = false;
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.zaev.keySet().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Api localApi = (Api)localIterator.next();
      Api.Client localClient = (Api.Client)this.zafs.zagy.get(localApi.getClientKey());
      int j;
      label124: int k;
      boolean bool;
      if (localApi.zah().getPriority() == 1)
      {
        j = 1;
        k = j | i;
        bool = ((Boolean)this.zaev.get(localApi)).booleanValue();
        if (localClient.requiresSignIn())
        {
          this.zagc = true;
          if (!bool)
            break label217;
          this.zafz.add(localApi.getClientKey());
        }
      }
      while (true)
      {
        localHashMap.put(localClient, new zaam(this, localApi, bool));
        i = k;
        break;
        j = 0;
        break label124;
        label217: this.zagb = false;
      }
    }
    if (i != 0)
      this.zagc = false;
    if (this.zagc)
    {
      this.zaes.setClientSessionId(Integer.valueOf(System.identityHashCode(this.zafs.zaed)));
      zaat localzaat = new zaat(this, null);
      this.zaga = ((zad)this.zacd.buildClient(this.mContext, this.zafs.zaed.getLooper(), this.zaes, this.zaes.getSignInOptions(), localzaat, localzaat));
    }
    this.zafx = this.zafs.zagy.size();
    this.zagh.add(zabh.zabb().submit(new zaan(this, localHashMap)));
  }

  public final void connect()
  {
  }

  public final boolean disconnect()
  {
    zaas();
    zab(true);
    this.zafs.zaf(null);
    return true;
  }

  public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T paramT)
  {
    this.zafs.zaed.zafb.add(paramT);
    return paramT;
  }

  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T paramT)
  {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }

  @GuardedBy("mLock")
  public final void onConnected(Bundle paramBundle)
  {
    if (!zac(1));
    do
    {
      return;
      if (paramBundle != null)
        this.zafy.putAll(paramBundle);
    }
    while (!zaao());
    zaaq();
  }

  @GuardedBy("mLock")
  public final void onConnectionSuspended(int paramInt)
  {
    zae(new ConnectionResult(8, null));
  }

  @GuardedBy("mLock")
  public final void zaa(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean)
  {
    if (!zac(1));
    do
    {
      return;
      zab(paramConnectionResult, paramApi, paramBoolean);
    }
    while (!zaao());
    zaaq();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zaak
 * JD-Core Version:    0.6.2
 */