package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.google.android.gms.common.api.internal.zaaw;
import com.google.android.gms.common.api.internal.zacm;
import com.google.android.gms.common.api.internal.zaj;
import com.google.android.gms.common.api.internal.zaq;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.ClientSettings.OptionalApiSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zaa;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public abstract class GoogleApiClient
{

  @KeepForSdk
  public static final String DEFAULT_ACCOUNT = "<<default account>>";
  public static final int SIGN_IN_MODE_OPTIONAL = 2;
  public static final int SIGN_IN_MODE_REQUIRED = 1;

  @GuardedBy("sAllClients")
  private static final Set<GoogleApiClient> zabq = Collections.newSetFromMap(new WeakHashMap());

  public static void dumpAll(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    synchronized (zabq)
    {
      String str = String.valueOf(paramString).concat("  ");
      Iterator localIterator = zabq.iterator();
      int j;
      for (int i = 0; localIterator.hasNext(); i = j)
      {
        GoogleApiClient localGoogleApiClient = (GoogleApiClient)localIterator.next();
        PrintWriter localPrintWriter = paramPrintWriter.append(paramString).append("GoogleApiClient#");
        j = i + 1;
        localPrintWriter.println(i);
        localGoogleApiClient.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      }
      return;
    }
  }

  @KeepForSdk
  public static Set<GoogleApiClient> getAllClients()
  {
    synchronized (zabq)
    {
      Set localSet2 = zabq;
      return localSet2;
    }
  }

  public abstract ConnectionResult blockingConnect();

  public abstract ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit);

  public abstract PendingResult<Status> clearDefaultAccountAndReconnect();

  public abstract void connect();

  public void connect(int paramInt)
  {
    throw new UnsupportedOperationException();
  }

  public abstract void disconnect();

  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);

  @KeepForSdk
  public <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T paramT)
  {
    throw new UnsupportedOperationException();
  }

  @KeepForSdk
  public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T paramT)
  {
    throw new UnsupportedOperationException();
  }

  @KeepForSdk
  public <C extends Api.Client> C getClient(Api.AnyClientKey<C> paramAnyClientKey)
  {
    throw new UnsupportedOperationException();
  }

  public abstract ConnectionResult getConnectionResult(Api<?> paramApi);

  @KeepForSdk
  public Context getContext()
  {
    throw new UnsupportedOperationException();
  }

  @KeepForSdk
  public Looper getLooper()
  {
    throw new UnsupportedOperationException();
  }

  @KeepForSdk
  public boolean hasApi(Api<?> paramApi)
  {
    throw new UnsupportedOperationException();
  }

  public abstract boolean hasConnectedApi(Api<?> paramApi);

  public abstract boolean isConnected();

  public abstract boolean isConnecting();

  public abstract boolean isConnectionCallbacksRegistered(ConnectionCallbacks paramConnectionCallbacks);

  public abstract boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener paramOnConnectionFailedListener);

  @KeepForSdk
  public boolean maybeSignIn(SignInConnectionListener paramSignInConnectionListener)
  {
    throw new UnsupportedOperationException();
  }

  @KeepForSdk
  public void maybeSignOut()
  {
    throw new UnsupportedOperationException();
  }

  public abstract void reconnect();

  public abstract void registerConnectionCallbacks(ConnectionCallbacks paramConnectionCallbacks);

  public abstract void registerConnectionFailedListener(OnConnectionFailedListener paramOnConnectionFailedListener);

  @KeepForSdk
  public <L> ListenerHolder<L> registerListener(L paramL)
  {
    throw new UnsupportedOperationException();
  }

  public abstract void stopAutoManage(FragmentActivity paramFragmentActivity);

  public abstract void unregisterConnectionCallbacks(ConnectionCallbacks paramConnectionCallbacks);

  public abstract void unregisterConnectionFailedListener(OnConnectionFailedListener paramOnConnectionFailedListener);

  public void zaa(zacm paramzacm)
  {
    throw new UnsupportedOperationException();
  }

  public void zab(zacm paramzacm)
  {
    throw new UnsupportedOperationException();
  }

  @KeepForSdk
  public static final class Builder
  {
    private final Context mContext;
    private Looper zabj;
    private final Set<Scope> zabr = new HashSet();
    private final Set<Scope> zabs = new HashSet();
    private int zabt;
    private View zabu;
    private String zabv;
    private String zabw;
    private final Map<Api<?>, ClientSettings.OptionalApiSettings> zabx = new ArrayMap();
    private final Map<Api<?>, Api.ApiOptions> zaby = new ArrayMap();
    private LifecycleActivity zabz;
    private int zaca = -1;
    private GoogleApiClient.OnConnectionFailedListener zacb;
    private GoogleApiAvailability zacc = GoogleApiAvailability.getInstance();
    private Api.AbstractClientBuilder<? extends zad, SignInOptions> zacd = zaa.zapg;
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> zace = new ArrayList();
    private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zacf = new ArrayList();
    private boolean zacg = false;
    private Account zax;

    @KeepForSdk
    public Builder(Context paramContext)
    {
      this.mContext = paramContext;
      this.zabj = paramContext.getMainLooper();
      this.zabv = paramContext.getPackageName();
      this.zabw = paramContext.getClass().getName();
    }

    @KeepForSdk
    public Builder(Context paramContext, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      this(paramContext);
      Preconditions.checkNotNull(paramConnectionCallbacks, "Must provide a connected listener");
      this.zace.add(paramConnectionCallbacks);
      Preconditions.checkNotNull(paramOnConnectionFailedListener, "Must provide a connection failed listener");
      this.zacf.add(paramOnConnectionFailedListener);
    }

    private final <O extends Api.ApiOptions> void zaa(Api<O> paramApi, O paramO, Scope[] paramArrayOfScope)
    {
      HashSet localHashSet = new HashSet(paramApi.zah().getImpliedScopes(paramO));
      int i = paramArrayOfScope.length;
      for (int j = 0; j < i; j++)
        localHashSet.add(paramArrayOfScope[j]);
      this.zabx.put(paramApi, new ClientSettings.OptionalApiSettings(localHashSet));
    }

    public final Builder addApi(Api<? extends Api.ApiOptions.NotRequiredOptions> paramApi)
    {
      Preconditions.checkNotNull(paramApi, "Api must not be null");
      this.zaby.put(paramApi, null);
      List localList = paramApi.zah().getImpliedScopes(null);
      this.zabs.addAll(localList);
      this.zabr.addAll(localList);
      return this;
    }

    public final <O extends Api.ApiOptions.HasOptions> Builder addApi(Api<O> paramApi, O paramO)
    {
      Preconditions.checkNotNull(paramApi, "Api must not be null");
      Preconditions.checkNotNull(paramO, "Null options are not permitted for this Api");
      this.zaby.put(paramApi, paramO);
      List localList = paramApi.zah().getImpliedScopes(paramO);
      this.zabs.addAll(localList);
      this.zabr.addAll(localList);
      return this;
    }

    public final <O extends Api.ApiOptions.HasOptions> Builder addApiIfAvailable(Api<O> paramApi, O paramO, Scope[] paramArrayOfScope)
    {
      Preconditions.checkNotNull(paramApi, "Api must not be null");
      Preconditions.checkNotNull(paramO, "Null options are not permitted for this Api");
      this.zaby.put(paramApi, paramO);
      zaa(paramApi, paramO, paramArrayOfScope);
      return this;
    }

    public final Builder addApiIfAvailable(Api<? extends Api.ApiOptions.NotRequiredOptions> paramApi, Scope[] paramArrayOfScope)
    {
      Preconditions.checkNotNull(paramApi, "Api must not be null");
      this.zaby.put(paramApi, null);
      zaa(paramApi, null, paramArrayOfScope);
      return this;
    }

    public final Builder addConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
    {
      Preconditions.checkNotNull(paramConnectionCallbacks, "Listener must not be null");
      this.zace.add(paramConnectionCallbacks);
      return this;
    }

    public final Builder addOnConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      Preconditions.checkNotNull(paramOnConnectionFailedListener, "Listener must not be null");
      this.zacf.add(paramOnConnectionFailedListener);
      return this;
    }

    public final Builder addScope(Scope paramScope)
    {
      Preconditions.checkNotNull(paramScope, "Scope must not be null");
      this.zabr.add(paramScope);
      return this;
    }

    @KeepForSdk
    public final Builder addScopeNames(String[] paramArrayOfString)
    {
      for (int i = 0; i < paramArrayOfString.length; i++)
        this.zabr.add(new Scope(paramArrayOfString[i]));
      return this;
    }

    public final GoogleApiClient build()
    {
      boolean bool1;
      ClientSettings localClientSettings;
      Object localObject1;
      ArrayMap localArrayMap1;
      ArrayMap localArrayMap2;
      ArrayList localArrayList;
      int i;
      label79: Object localObject3;
      boolean bool4;
      label129: Api.Client localClient;
      int k;
      if (!this.zaby.isEmpty())
      {
        bool1 = true;
        Preconditions.checkArgument(bool1, "must call addApi() to add at least one API");
        localClientSettings = buildClientSettings();
        localObject1 = null;
        Map localMap = localClientSettings.getOptionalApiSettings();
        localArrayMap1 = new ArrayMap();
        localArrayMap2 = new ArrayMap();
        localArrayList = new ArrayList();
        Iterator localIterator = this.zaby.keySet().iterator();
        i = 0;
        if (!localIterator.hasNext())
          break label337;
        localObject3 = (Api)localIterator.next();
        Object localObject4 = this.zaby.get(localObject3);
        if (localMap.get(localObject3) == null)
          break label312;
        bool4 = true;
        localArrayMap1.put(localObject3, Boolean.valueOf(bool4));
        zaq localzaq = new zaq((Api)localObject3, bool4);
        localArrayList.add(localzaq);
        Api.AbstractClientBuilder localAbstractClientBuilder = ((Api)localObject3).zai();
        localClient = localAbstractClientBuilder.buildClient(this.mContext, this.zabj, localClientSettings, localObject4, localzaq, localzaq);
        localArrayMap2.put(((Api)localObject3).getClientKey(), localClient);
        if (localAbstractClientBuilder.getPriority() != 1)
          break label604;
        if (localObject4 == null)
          break label318;
        k = 1;
      }
      while (true)
      {
        if (localClient.providesSignIn())
        {
          if (localObject1 == null)
            break label327;
          String str2 = ((Api)localObject3).getName();
          String str3 = localObject1.getName();
          throw new IllegalStateException(21 + String.valueOf(str2).length() + String.valueOf(str3).length() + str2 + " cannot be used with " + str3);
          bool1 = false;
          break;
          label312: bool4 = false;
          break label129;
          label318: k = 0;
          continue;
        }
        localObject3 = localObject1;
        label327: i = k;
        localObject1 = localObject3;
        break label79;
        label337: boolean bool2;
        if (localObject1 != null)
        {
          if (i != 0)
          {
            String str1 = localObject1.getName();
            throw new IllegalStateException(82 + String.valueOf(str1).length() + "With using " + str1 + ", GamesOptions can only be specified within GoogleSignInOptions.Builder");
          }
          if (this.zax != null)
            break label590;
          bool2 = true;
        }
        while (true)
        {
          Object[] arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = localObject1.getName();
          Preconditions.checkState(bool2, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", arrayOfObject1);
          boolean bool3 = this.zabr.equals(this.zabs);
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = localObject1.getName();
          Preconditions.checkState(bool3, "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", arrayOfObject2);
          int j = zaaw.zaa(localArrayMap2.values(), true);
          zaaw localzaaw = new zaaw(this.mContext, new ReentrantLock(), this.zabj, localClientSettings, this.zacc, this.zacd, localArrayMap1, this.zace, this.zacf, localArrayMap2, this.zaca, j, localArrayList, false);
          synchronized (GoogleApiClient.zal())
          {
            GoogleApiClient.zal().add(localzaaw);
            if (this.zaca >= 0)
              zaj.zaa(this.zabz).zaa(this.zaca, localzaaw, this.zacb);
            return localzaaw;
            label590: bool2 = false;
          }
        }
        label604: k = i;
      }
    }

    @KeepForSdk
    @VisibleForTesting
    public final ClientSettings buildClientSettings()
    {
      SignInOptions localSignInOptions = SignInOptions.DEFAULT;
      if (this.zaby.containsKey(zaa.API))
        localSignInOptions = (SignInOptions)this.zaby.get(zaa.API);
      return new ClientSettings(this.zax, this.zabr, this.zabx, this.zabt, this.zabu, this.zabv, this.zabw, localSignInOptions);
    }

    public final Builder enableAutoManage(FragmentActivity paramFragmentActivity, int paramInt, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      LifecycleActivity localLifecycleActivity = new LifecycleActivity(paramFragmentActivity);
      if (paramInt >= 0);
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkArgument(bool, "clientId must be non-negative");
        this.zaca = paramInt;
        this.zacb = paramOnConnectionFailedListener;
        this.zabz = localLifecycleActivity;
        return this;
      }
    }

    public final Builder enableAutoManage(FragmentActivity paramFragmentActivity, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      return enableAutoManage(paramFragmentActivity, 0, paramOnConnectionFailedListener);
    }

    public final Builder setAccountName(String paramString)
    {
      if (paramString == null);
      for (Account localAccount = null; ; localAccount = new Account(paramString, "com.google"))
      {
        this.zax = localAccount;
        return this;
      }
    }

    public final Builder setGravityForPopups(int paramInt)
    {
      this.zabt = paramInt;
      return this;
    }

    public final Builder setHandler(Handler paramHandler)
    {
      Preconditions.checkNotNull(paramHandler, "Handler must not be null");
      this.zabj = paramHandler.getLooper();
      return this;
    }

    public final Builder setViewForPopups(View paramView)
    {
      Preconditions.checkNotNull(paramView, "View must not be null");
      this.zabu = paramView;
      return this;
    }

    public final Builder useDefaultAccount()
    {
      return setAccountName("<<default account>>");
    }
  }

  public static abstract interface ConnectionCallbacks
  {
    public static final int CAUSE_NETWORK_LOST = 2;
    public static final int CAUSE_SERVICE_DISCONNECTED = 1;

    public abstract void onConnected(Bundle paramBundle);

    public abstract void onConnectionSuspended(int paramInt);
  }

  public static abstract interface OnConnectionFailedListener
  {
    public abstract void onConnectionFailed(ConnectionResult paramConnectionResult);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.GoogleApiClient
 * JD-Core Version:    0.6.2
 */