package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.ArraySet;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.signin.zad;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public class GoogleApiManager
  implements Handler.Callback
{
  private static final Object lock = new Object();
  public static final Status zahw = new Status(4, "Sign-out occurred while this API call was in progress.");
  private static final Status zahx = new Status(4, "The user must be signed in to make this API call.");

  @GuardedBy("lock")
  private static GoogleApiManager zaib;
  private final Handler handler;
  private long zahy = 5000L;
  private long zahz = 120000L;
  private long zaia = 10000L;
  private final Context zaic;
  private final GoogleApiAvailability zaid;
  private final GoogleApiAvailabilityCache zaie;
  private final AtomicInteger zaif = new AtomicInteger(1);
  private final AtomicInteger zaig = new AtomicInteger(0);
  private final Map<zai<?>, zaa<?>> zaih = new ConcurrentHashMap(5, 0.75F, 1);

  @GuardedBy("lock")
  private zaae zaii = null;

  @GuardedBy("lock")
  private final Set<zai<?>> zaij = new ArraySet();
  private final Set<zai<?>> zaik = new ArraySet();

  @KeepForSdk
  private GoogleApiManager(Context paramContext, Looper paramLooper, GoogleApiAvailability paramGoogleApiAvailability)
  {
    this.zaic = paramContext;
    this.handler = new com.google.android.gms.internal.base.zal(paramLooper, this);
    this.zaid = paramGoogleApiAvailability;
    this.zaie = new GoogleApiAvailabilityCache(paramGoogleApiAvailability);
    this.handler.sendMessage(this.handler.obtainMessage(6));
  }

  @KeepForSdk
  public static void reportSignOut()
  {
    synchronized (lock)
    {
      if (zaib != null)
      {
        GoogleApiManager localGoogleApiManager = zaib;
        localGoogleApiManager.zaig.incrementAndGet();
        localGoogleApiManager.handler.sendMessageAtFrontOfQueue(localGoogleApiManager.handler.obtainMessage(10));
      }
      return;
    }
  }

  public static GoogleApiManager zab(Context paramContext)
  {
    synchronized (lock)
    {
      if (zaib == null)
      {
        HandlerThread localHandlerThread = new HandlerThread("GoogleApiHandler", 9);
        localHandlerThread.start();
        Looper localLooper = localHandlerThread.getLooper();
        zaib = new GoogleApiManager(paramContext.getApplicationContext(), localLooper, GoogleApiAvailability.getInstance());
      }
      GoogleApiManager localGoogleApiManager = zaib;
      return localGoogleApiManager;
    }
  }

  private final void zab(GoogleApi<?> paramGoogleApi)
  {
    zai localzai = paramGoogleApi.zak();
    zaa localzaa = (zaa)this.zaih.get(localzai);
    if (localzaa == null)
    {
      localzaa = new zaa(paramGoogleApi);
      this.zaih.put(localzai, localzaa);
    }
    if (localzaa.requiresSignIn())
      this.zaik.add(localzai);
    localzaa.connect();
  }

  public static GoogleApiManager zabc()
  {
    synchronized (lock)
    {
      Preconditions.checkNotNull(zaib, "Must guarantee manager is non-null before using getInstance");
      GoogleApiManager localGoogleApiManager = zaib;
      return localGoogleApiManager;
    }
  }

  public boolean handleMessage(Message paramMessage)
  {
    zak localzak;
    zai localzai3;
    zaa localzaa4;
    label308: int i;
    ConnectionResult localConnectionResult;
    zaa localzaa1;
    switch (paramMessage.what)
    {
    default:
      int j = paramMessage.what;
      Log.w("GoogleApiManager", 31 + "Unknown message id: " + j);
      return false;
    case 1:
      if (((Boolean)paramMessage.obj).booleanValue());
      for (long l = 10000L; ; l = 300000L)
      {
        this.zaia = l;
        this.handler.removeMessages(12);
        Iterator localIterator5 = this.zaih.keySet().iterator();
        while (localIterator5.hasNext())
        {
          zai localzai4 = (zai)localIterator5.next();
          this.handler.sendMessageDelayed(this.handler.obtainMessage(12, localzai4), this.zaia);
        }
      }
    case 2:
      localzak = (zak)paramMessage.obj;
      Iterator localIterator4 = localzak.zap().iterator();
      if (localIterator4.hasNext())
      {
        localzai3 = (zai)localIterator4.next();
        localzaa4 = (zaa)this.zaih.get(localzai3);
        if (localzaa4 != null)
          break label308;
        localzak.zaa(localzai3, new ConnectionResult(13), null);
      }
    case 3:
    case 4:
    case 8:
    case 13:
      while (true)
      {
        return true;
        if (localzaa4.isConnected())
        {
          localzak.zaa(localzai3, ConnectionResult.RESULT_SUCCESS, localzaa4.zaab().getEndpointPackageName());
          break;
        }
        if (localzaa4.zabm() != null)
        {
          localzak.zaa(localzai3, localzaa4.zabm(), null);
          break;
        }
        localzaa4.zaa(localzak);
        localzaa4.connect();
        break;
        Iterator localIterator3 = this.zaih.values().iterator();
        while (localIterator3.hasNext())
        {
          zaa localzaa3 = (zaa)localIterator3.next();
          localzaa3.zabl();
          localzaa3.connect();
        }
        zabv localzabv = (zabv)paramMessage.obj;
        zaa localzaa2 = (zaa)this.zaih.get(localzabv.zajs.zak());
        if (localzaa2 == null)
        {
          zab(localzabv.zajs);
          localzaa2 = (zaa)this.zaih.get(localzabv.zajs.zak());
        }
        if ((localzaa2.requiresSignIn()) && (this.zaig.get() != localzabv.zajr))
        {
          localzabv.zajq.zaa(zahw);
          localzaa2.zabj();
        }
        else
        {
          localzaa2.zaa(localzabv.zajq);
        }
      }
    case 5:
      i = paramMessage.arg1;
      localConnectionResult = (ConnectionResult)paramMessage.obj;
      Iterator localIterator2 = this.zaih.values().iterator();
      do
      {
        if (!localIterator2.hasNext())
          break;
        localzaa1 = (zaa)localIterator2.next();
      }
      while (localzaa1.getInstanceId() != i);
    case 6:
    case 7:
    case 9:
    case 10:
    case 11:
    case 12:
    case 14:
    case 15:
    case 16:
    }
    while (true)
    {
      if (localzaa1 != null)
      {
        String str1 = this.zaid.getErrorString(localConnectionResult.getErrorCode());
        String str2 = localConnectionResult.getErrorMessage();
        localzaa1.zac(new Status(17, 69 + String.valueOf(str1).length() + String.valueOf(str2).length() + "Error resolution was canceled by the user, original error message: " + str1 + ": " + str2));
        break;
      }
      Log.wtf("GoogleApiManager", 76 + "Could not find API instance " + i + " while trying to fail enqueued calls.", new Exception());
      break;
      if ((!PlatformVersion.isAtLeastIceCreamSandwich()) || (!(this.zaic.getApplicationContext() instanceof Application)))
        break;
      BackgroundDetector.initialize((Application)this.zaic.getApplicationContext());
      BackgroundDetector.getInstance().addListener(new zabi(this));
      if (BackgroundDetector.getInstance().readCurrentStateIfPossible(true))
        break;
      this.zaia = 300000L;
      break;
      zab((GoogleApi)paramMessage.obj);
      break;
      if (!this.zaih.containsKey(paramMessage.obj))
        break;
      ((zaa)this.zaih.get(paramMessage.obj)).resume();
      break;
      Iterator localIterator1 = this.zaik.iterator();
      while (localIterator1.hasNext())
      {
        zai localzai2 = (zai)localIterator1.next();
        ((zaa)this.zaih.remove(localzai2)).zabj();
      }
      this.zaik.clear();
      break;
      if (!this.zaih.containsKey(paramMessage.obj))
        break;
      ((zaa)this.zaih.get(paramMessage.obj)).zaav();
      break;
      if (!this.zaih.containsKey(paramMessage.obj))
        break;
      ((zaa)this.zaih.get(paramMessage.obj)).zabp();
      break;
      zaaf localzaaf = (zaaf)paramMessage.obj;
      zai localzai1 = localzaaf.zak();
      if (!this.zaih.containsKey(localzai1))
      {
        localzaaf.zaal().setResult(Boolean.valueOf(false));
        break;
      }
      boolean bool = zaa.zaa((zaa)this.zaih.get(localzai1), false);
      localzaaf.zaal().setResult(Boolean.valueOf(bool));
      break;
      zab localzab2 = (zab)paramMessage.obj;
      if (!this.zaih.containsKey(zab.zac(localzab2)))
        break;
      zaa.zaa((zaa)this.zaih.get(zab.zac(localzab2)), localzab2);
      break;
      zab localzab1 = (zab)paramMessage.obj;
      if (!this.zaih.containsKey(zab.zac(localzab1)))
        break;
      zaa.zab((zaa)this.zaih.get(zab.zac(localzab1)), localzab1);
      break;
      localzaa1 = null;
    }
  }

  final void maybeSignOut()
  {
    this.zaig.incrementAndGet();
    this.handler.sendMessage(this.handler.obtainMessage(10));
  }

  final PendingIntent zaa(zai<?> paramzai, int paramInt)
  {
    zaa localzaa = (zaa)this.zaih.get(paramzai);
    if (localzaa == null)
      return null;
    zad localzad = localzaa.zabq();
    if (localzad == null)
      return null;
    return PendingIntent.getActivity(this.zaic, paramInt, localzad.getSignInIntent(), 134217728);
  }

  public final <O extends Api.ApiOptions> Task<Boolean> zaa(GoogleApi<O> paramGoogleApi, ListenerHolder.ListenerKey<?> paramListenerKey)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    zah localzah = new zah(paramListenerKey, localTaskCompletionSource);
    this.handler.sendMessage(this.handler.obtainMessage(13, new zabv(localzah, this.zaig.get(), paramGoogleApi)));
    return localTaskCompletionSource.getTask();
  }

  public final <O extends Api.ApiOptions> Task<Void> zaa(GoogleApi<O> paramGoogleApi, RegisterListenerMethod<Api.AnyClient, ?> paramRegisterListenerMethod, UnregisterListenerMethod<Api.AnyClient, ?> paramUnregisterListenerMethod)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    zaf localzaf = new zaf(new zabw(paramRegisterListenerMethod, paramUnregisterListenerMethod), localTaskCompletionSource);
    this.handler.sendMessage(this.handler.obtainMessage(8, new zabv(localzaf, this.zaig.get(), paramGoogleApi)));
    return localTaskCompletionSource.getTask();
  }

  public final Task<Map<zai<?>, String>> zaa(Iterable<? extends GoogleApi<?>> paramIterable)
  {
    zak localzak = new zak(paramIterable);
    this.handler.sendMessage(this.handler.obtainMessage(2, localzak));
    return localzak.getTask();
  }

  public final void zaa(ConnectionResult paramConnectionResult, int paramInt)
  {
    if (!zac(paramConnectionResult, paramInt))
      this.handler.sendMessage(this.handler.obtainMessage(5, paramInt, 0, paramConnectionResult));
  }

  public final void zaa(GoogleApi<?> paramGoogleApi)
  {
    this.handler.sendMessage(this.handler.obtainMessage(7, paramGoogleApi));
  }

  public final <O extends Api.ApiOptions> void zaa(GoogleApi<O> paramGoogleApi, int paramInt, BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient> paramApiMethodImpl)
  {
    zae localzae = new zae(paramInt, paramApiMethodImpl);
    this.handler.sendMessage(this.handler.obtainMessage(4, new zabv(localzae, this.zaig.get(), paramGoogleApi)));
  }

  public final <O extends Api.ApiOptions, ResultT> void zaa(GoogleApi<O> paramGoogleApi, int paramInt, TaskApiCall<Api.AnyClient, ResultT> paramTaskApiCall, TaskCompletionSource<ResultT> paramTaskCompletionSource, StatusExceptionMapper paramStatusExceptionMapper)
  {
    zag localzag = new zag(paramInt, paramTaskApiCall, paramTaskCompletionSource, paramStatusExceptionMapper);
    this.handler.sendMessage(this.handler.obtainMessage(4, new zabv(localzag, this.zaig.get(), paramGoogleApi)));
  }

  public final void zaa(zaae paramzaae)
  {
    synchronized (lock)
    {
      if (this.zaii != paramzaae)
      {
        this.zaii = paramzaae;
        this.zaij.clear();
      }
      this.zaij.addAll(paramzaae.zaaj());
      return;
    }
  }

  final void zab(zaae paramzaae)
  {
    synchronized (lock)
    {
      if (this.zaii == paramzaae)
      {
        this.zaii = null;
        this.zaij.clear();
      }
      return;
    }
  }

  public final int zabd()
  {
    return this.zaif.getAndIncrement();
  }

  public final Task<Boolean> zac(GoogleApi<?> paramGoogleApi)
  {
    zaaf localzaaf = new zaaf(paramGoogleApi.zak());
    this.handler.sendMessage(this.handler.obtainMessage(14, localzaaf));
    return localzaaf.zaal().getTask();
  }

  final boolean zac(ConnectionResult paramConnectionResult, int paramInt)
  {
    return this.zaid.zaa(this.zaic, paramConnectionResult, paramInt);
  }

  public final void zao()
  {
    this.handler.sendMessage(this.handler.obtainMessage(3));
  }

  public final class zaa<O extends Api.ApiOptions>
    implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zar
  {
    private final zai<O> zafp;
    private final Queue<zab> zaim = new LinkedList();
    private final Api.Client zain;
    private final Api.AnyClient zaio;
    private final zaab zaip;
    private final Set<zak> zaiq = new HashSet();
    private final Map<ListenerHolder.ListenerKey<?>, zabw> zair = new HashMap();
    private final int zais;
    private final zace zait;
    private boolean zaiu;
    private final List<GoogleApiManager.zab> zaiv = new ArrayList();
    private ConnectionResult zaiw = null;

    public zaa()
    {
      Object localObject;
      this.zain = localObject.zaa(GoogleApiManager.zaa(GoogleApiManager.this).getLooper(), this);
      if ((this.zain instanceof SimpleClientAdapter));
      for (this.zaio = ((SimpleClientAdapter)this.zain).getClient(); ; this.zaio = this.zain)
      {
        this.zafp = localObject.zak();
        this.zaip = new zaab();
        this.zais = localObject.getInstanceId();
        if (!this.zain.requiresSignIn())
          break;
        this.zait = localObject.zaa(GoogleApiManager.zab(GoogleApiManager.this), GoogleApiManager.zaa(GoogleApiManager.this));
        return;
      }
      this.zait = null;
    }

    private final Feature zaa(Feature[] paramArrayOfFeature)
    {
      if ((paramArrayOfFeature == null) || (paramArrayOfFeature.length == 0))
        return null;
      Feature[] arrayOfFeature = this.zain.getAvailableFeatures();
      if (arrayOfFeature == null)
        arrayOfFeature = new Feature[0];
      ArrayMap localArrayMap = new ArrayMap(arrayOfFeature.length);
      int i = arrayOfFeature.length;
      for (int j = 0; j < i; j++)
      {
        Feature localFeature2 = arrayOfFeature[j];
        localArrayMap.put(localFeature2.getName(), Long.valueOf(localFeature2.getVersion()));
      }
      int k = paramArrayOfFeature.length;
      for (int m = 0; m < k; m++)
      {
        Feature localFeature1 = paramArrayOfFeature[m];
        if ((!localArrayMap.containsKey(localFeature1.getName())) || (((Long)localArrayMap.get(localFeature1.getName())).longValue() < localFeature1.getVersion()))
          return localFeature1;
      }
      return null;
    }

    private final void zaa(GoogleApiManager.zab paramzab)
    {
      if (!this.zaiv.contains(paramzab));
      while (this.zaiu)
        return;
      if (!this.zain.isConnected())
      {
        connect();
        return;
      }
      zabi();
    }

    private final void zab(GoogleApiManager.zab paramzab)
    {
      if (this.zaiv.remove(paramzab))
      {
        GoogleApiManager.zaa(GoogleApiManager.this).removeMessages(15, paramzab);
        GoogleApiManager.zaa(GoogleApiManager.this).removeMessages(16, paramzab);
        Feature localFeature = GoogleApiManager.zab.zad(paramzab);
        ArrayList localArrayList1 = new ArrayList(this.zaim.size());
        Iterator localIterator = this.zaim.iterator();
        while (localIterator.hasNext())
        {
          zab localzab2 = (zab)localIterator.next();
          if ((localzab2 instanceof zac))
          {
            Feature[] arrayOfFeature = ((zac)localzab2).zab(this);
            if ((arrayOfFeature != null) && (ArrayUtils.contains(arrayOfFeature, localFeature)))
              localArrayList1.add(localzab2);
          }
        }
        ArrayList localArrayList2 = (ArrayList)localArrayList1;
        int i = localArrayList2.size();
        int j = 0;
        while (j < i)
        {
          Object localObject = localArrayList2.get(j);
          j++;
          zab localzab1 = (zab)localObject;
          this.zaim.remove(localzab1);
          localzab1.zaa(new UnsupportedApiCallException(localFeature));
        }
      }
    }

    private final boolean zab(zab paramzab)
    {
      if (!(paramzab instanceof zac))
      {
        zac(paramzab);
        return true;
      }
      zac localzac = (zac)paramzab;
      Feature localFeature = zaa(localzac.zab(this));
      if (localFeature == null)
      {
        zac(paramzab);
        return true;
      }
      GoogleApiManager.zab localzab1;
      if (localzac.zac(this))
      {
        localzab1 = new GoogleApiManager.zab(this.zafp, localFeature, null);
        int i = this.zaiv.indexOf(localzab1);
        if (i >= 0)
        {
          GoogleApiManager.zab localzab2 = (GoogleApiManager.zab)this.zaiv.get(i);
          GoogleApiManager.zaa(GoogleApiManager.this).removeMessages(15, localzab2);
          GoogleApiManager.zaa(GoogleApiManager.this).sendMessageDelayed(Message.obtain(GoogleApiManager.zaa(GoogleApiManager.this), 15, localzab2), GoogleApiManager.zac(GoogleApiManager.this));
        }
      }
      while (true)
      {
        return false;
        this.zaiv.add(localzab1);
        GoogleApiManager.zaa(GoogleApiManager.this).sendMessageDelayed(Message.obtain(GoogleApiManager.zaa(GoogleApiManager.this), 15, localzab1), GoogleApiManager.zac(GoogleApiManager.this));
        GoogleApiManager.zaa(GoogleApiManager.this).sendMessageDelayed(Message.obtain(GoogleApiManager.zaa(GoogleApiManager.this), 16, localzab1), GoogleApiManager.zad(GoogleApiManager.this));
        ConnectionResult localConnectionResult = new ConnectionResult(2, null);
        if (!zah(localConnectionResult))
        {
          GoogleApiManager.this.zac(localConnectionResult, this.zais);
          continue;
          localzac.zaa(new UnsupportedApiCallException(localFeature));
        }
      }
    }

    private final void zabg()
    {
      zabl();
      zai(ConnectionResult.RESULT_SUCCESS);
      zabn();
      Iterator localIterator = this.zair.values().iterator();
      while (true)
      {
        zabw localzabw;
        if (localIterator.hasNext())
        {
          localzabw = (zabw)localIterator.next();
          if (zaa(localzabw.zajw.getRequiredFeatures()) != null)
            localIterator.remove();
        }
        else
        {
          try
          {
            localzabw.zajw.registerListener(this.zaio, new TaskCompletionSource());
          }
          catch (DeadObjectException localDeadObjectException)
          {
            onConnectionSuspended(1);
            this.zain.disconnect();
            zabi();
            zabo();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            localIterator.remove();
          }
        }
      }
    }

    private final void zabh()
    {
      zabl();
      this.zaiu = true;
      this.zaip.zaai();
      GoogleApiManager.zaa(GoogleApiManager.this).sendMessageDelayed(Message.obtain(GoogleApiManager.zaa(GoogleApiManager.this), 9, this.zafp), GoogleApiManager.zac(GoogleApiManager.this));
      GoogleApiManager.zaa(GoogleApiManager.this).sendMessageDelayed(Message.obtain(GoogleApiManager.zaa(GoogleApiManager.this), 11, this.zafp), GoogleApiManager.zad(GoogleApiManager.this));
      GoogleApiManager.zae(GoogleApiManager.this).flush();
    }

    private final void zabi()
    {
      ArrayList localArrayList = (ArrayList)new ArrayList(this.zaim);
      int i = localArrayList.size();
      int j = 0;
      while (j < i)
      {
        Object localObject = localArrayList.get(j);
        j++;
        zab localzab = (zab)localObject;
        if (!this.zain.isConnected())
          break;
        if (zab(localzab))
          this.zaim.remove(localzab);
      }
    }

    private final void zabn()
    {
      if (this.zaiu)
      {
        GoogleApiManager.zaa(GoogleApiManager.this).removeMessages(11, this.zafp);
        GoogleApiManager.zaa(GoogleApiManager.this).removeMessages(9, this.zafp);
        this.zaiu = false;
      }
    }

    private final void zabo()
    {
      GoogleApiManager.zaa(GoogleApiManager.this).removeMessages(12, this.zafp);
      GoogleApiManager.zaa(GoogleApiManager.this).sendMessageDelayed(GoogleApiManager.zaa(GoogleApiManager.this).obtainMessage(12, this.zafp), GoogleApiManager.zai(GoogleApiManager.this));
    }

    private final void zac(zab paramzab)
    {
      paramzab.zaa(this.zaip, requiresSignIn());
      try
      {
        paramzab.zaa(this);
        return;
      }
      catch (DeadObjectException localDeadObjectException)
      {
        onConnectionSuspended(1);
        this.zain.disconnect();
      }
    }

    private final boolean zac(boolean paramBoolean)
    {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(GoogleApiManager.this));
      if ((this.zain.isConnected()) && (this.zair.size() == 0))
      {
        if (!this.zaip.zaag())
          break label54;
        if (paramBoolean)
          zabo();
      }
      return false;
      label54: this.zain.disconnect();
      return true;
    }

    private final boolean zah(ConnectionResult paramConnectionResult)
    {
      synchronized (GoogleApiManager.zabe())
      {
        if ((GoogleApiManager.zaf(GoogleApiManager.this) != null) && (GoogleApiManager.zag(GoogleApiManager.this).contains(this.zafp)))
        {
          GoogleApiManager.zaf(GoogleApiManager.this).zab(paramConnectionResult, this.zais);
          return true;
        }
        return false;
      }
    }

    private final void zai(ConnectionResult paramConnectionResult)
    {
      Iterator localIterator = this.zaiq.iterator();
      while (localIterator.hasNext())
      {
        zak localzak = (zak)localIterator.next();
        boolean bool = Objects.equal(paramConnectionResult, ConnectionResult.RESULT_SUCCESS);
        String str = null;
        if (bool)
          str = this.zain.getEndpointPackageName();
        localzak.zaa(this.zafp, paramConnectionResult, str);
      }
      this.zaiq.clear();
    }

    public final void connect()
    {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(GoogleApiManager.this));
      if ((this.zain.isConnected()) || (this.zain.isConnecting()))
        return;
      int i = GoogleApiManager.zae(GoogleApiManager.this).getClientAvailability(GoogleApiManager.zab(GoogleApiManager.this), this.zain);
      if (i != 0)
      {
        onConnectionFailed(new ConnectionResult(i, null));
        return;
      }
      GoogleApiManager.zac localzac = new GoogleApiManager.zac(GoogleApiManager.this, this.zain, this.zafp);
      if (this.zain.requiresSignIn())
        this.zait.zaa(localzac);
      this.zain.connect(localzac);
    }

    public final int getInstanceId()
    {
      return this.zais;
    }

    final boolean isConnected()
    {
      return this.zain.isConnected();
    }

    public final void onConnected(Bundle paramBundle)
    {
      if (Looper.myLooper() == GoogleApiManager.zaa(GoogleApiManager.this).getLooper())
      {
        zabg();
        return;
      }
      GoogleApiManager.zaa(GoogleApiManager.this).post(new zabj(this));
    }

    public final void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(GoogleApiManager.this));
      if (this.zait != null)
        this.zait.zabs();
      zabl();
      GoogleApiManager.zae(GoogleApiManager.this).flush();
      zai(paramConnectionResult);
      if (paramConnectionResult.getErrorCode() == 4)
        zac(GoogleApiManager.zabf());
      do
      {
        return;
        if (this.zaim.isEmpty())
        {
          this.zaiw = paramConnectionResult;
          return;
        }
      }
      while ((zah(paramConnectionResult)) || (GoogleApiManager.this.zac(paramConnectionResult, this.zais)));
      if (paramConnectionResult.getErrorCode() == 18)
        this.zaiu = true;
      if (this.zaiu)
      {
        GoogleApiManager.zaa(GoogleApiManager.this).sendMessageDelayed(Message.obtain(GoogleApiManager.zaa(GoogleApiManager.this), 9, this.zafp), GoogleApiManager.zac(GoogleApiManager.this));
        return;
      }
      String str = this.zafp.zan();
      zac(new Status(17, 38 + String.valueOf(str).length() + "API: " + str + " is not available on this device."));
    }

    public final void onConnectionSuspended(int paramInt)
    {
      if (Looper.myLooper() == GoogleApiManager.zaa(GoogleApiManager.this).getLooper())
      {
        zabh();
        return;
      }
      GoogleApiManager.zaa(GoogleApiManager.this).post(new zabk(this));
    }

    public final boolean requiresSignIn()
    {
      return this.zain.requiresSignIn();
    }

    public final void resume()
    {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(GoogleApiManager.this));
      if (this.zaiu)
        connect();
    }

    public final void zaa(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean)
    {
      if (Looper.myLooper() == GoogleApiManager.zaa(GoogleApiManager.this).getLooper())
      {
        onConnectionFailed(paramConnectionResult);
        return;
      }
      GoogleApiManager.zaa(GoogleApiManager.this).post(new zabl(this, paramConnectionResult));
    }

    public final void zaa(zab paramzab)
    {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(GoogleApiManager.this));
      if (this.zain.isConnected())
      {
        if (zab(paramzab))
        {
          zabo();
          return;
        }
        this.zaim.add(paramzab);
        return;
      }
      this.zaim.add(paramzab);
      if ((this.zaiw != null) && (this.zaiw.hasResolution()))
      {
        onConnectionFailed(this.zaiw);
        return;
      }
      connect();
    }

    public final void zaa(zak paramzak)
    {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(GoogleApiManager.this));
      this.zaiq.add(paramzak);
    }

    public final Api.Client zaab()
    {
      return this.zain;
    }

    public final void zaav()
    {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(GoogleApiManager.this));
      if (this.zaiu)
      {
        zabn();
        if (GoogleApiManager.zah(GoogleApiManager.this).isGooglePlayServicesAvailable(GoogleApiManager.zab(GoogleApiManager.this)) != 18)
          break label71;
      }
      label71: for (Status localStatus = new Status(8, "Connection timed out while waiting for Google Play services update to complete."); ; localStatus = new Status(8, "API failed to connect while resuming due to an unknown error."))
      {
        zac(localStatus);
        this.zain.disconnect();
        return;
      }
    }

    public final void zabj()
    {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(GoogleApiManager.this));
      zac(GoogleApiManager.zahw);
      this.zaip.zaah();
      ListenerHolder.ListenerKey[] arrayOfListenerKey = (ListenerHolder.ListenerKey[])this.zair.keySet().toArray(new ListenerHolder.ListenerKey[this.zair.size()]);
      int i = arrayOfListenerKey.length;
      for (int j = 0; j < i; j++)
        zaa(new zah(arrayOfListenerKey[j], new TaskCompletionSource()));
      zai(new ConnectionResult(4));
      if (this.zain.isConnected())
        this.zain.onUserSignOut(new zabm(this));
    }

    public final Map<ListenerHolder.ListenerKey<?>, zabw> zabk()
    {
      return this.zair;
    }

    public final void zabl()
    {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(GoogleApiManager.this));
      this.zaiw = null;
    }

    public final ConnectionResult zabm()
    {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(GoogleApiManager.this));
      return this.zaiw;
    }

    public final boolean zabp()
    {
      return zac(true);
    }

    final zad zabq()
    {
      if (this.zait == null)
        return null;
      return this.zait.zabq();
    }

    public final void zac(Status paramStatus)
    {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(GoogleApiManager.this));
      Iterator localIterator = this.zaim.iterator();
      while (localIterator.hasNext())
        ((zab)localIterator.next()).zaa(paramStatus);
      this.zaim.clear();
    }

    public final void zag(ConnectionResult paramConnectionResult)
    {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(GoogleApiManager.this));
      this.zain.disconnect();
      onConnectionFailed(paramConnectionResult);
    }
  }

  private static final class zab
  {
    private final zai<?> zaja;
    private final Feature zajb;

    private zab(zai<?> paramzai, Feature paramFeature)
    {
      this.zaja = paramzai;
      this.zajb = paramFeature;
    }

    public final boolean equals(Object paramObject)
    {
      boolean bool1 = false;
      if (paramObject != null)
      {
        boolean bool2 = paramObject instanceof zab;
        bool1 = false;
        if (bool2)
        {
          zab localzab = (zab)paramObject;
          boolean bool3 = Objects.equal(this.zaja, localzab.zaja);
          bool1 = false;
          if (bool3)
          {
            boolean bool4 = Objects.equal(this.zajb, localzab.zajb);
            bool1 = false;
            if (bool4)
              bool1 = true;
          }
        }
      }
      return bool1;
    }

    public final int hashCode()
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.zaja;
      arrayOfObject[1] = this.zajb;
      return Objects.hashCode(arrayOfObject);
    }

    public final String toString()
    {
      return Objects.toStringHelper(this).add("key", this.zaja).add("feature", this.zajb).toString();
    }
  }

  private final class zac
    implements zach, BaseGmsClient.ConnectionProgressReportCallbacks
  {
    private final zai<?> zafp;
    private final Api.Client zain;
    private IAccountAccessor zajc = null;
    private Set<Scope> zajd = null;
    private boolean zaje = false;

    public zac(zai<?> arg2)
    {
      Object localObject1;
      this.zain = localObject1;
      Object localObject2;
      this.zafp = localObject2;
    }

    private final void zabr()
    {
      if ((this.zaje) && (this.zajc != null))
        this.zain.getRemoteService(this.zajc, this.zajd);
    }

    public final void onReportServiceBinding(ConnectionResult paramConnectionResult)
    {
      GoogleApiManager.zaa(GoogleApiManager.this).post(new zabo(this, paramConnectionResult));
    }

    public final void zaa(IAccountAccessor paramIAccountAccessor, Set<Scope> paramSet)
    {
      if ((paramIAccountAccessor == null) || (paramSet == null))
      {
        Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
        zag(new ConnectionResult(4));
        return;
      }
      this.zajc = paramIAccountAccessor;
      this.zajd = paramSet;
      zabr();
    }

    public final void zag(ConnectionResult paramConnectionResult)
    {
      ((GoogleApiManager.zaa)GoogleApiManager.zaj(GoogleApiManager.this).get(this.zafp)).zag(paramConnectionResult);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.GoogleApiManager
 * JD-Core Version:    0.6.2
 */