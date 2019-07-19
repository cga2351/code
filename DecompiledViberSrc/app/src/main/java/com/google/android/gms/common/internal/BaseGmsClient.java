package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.common.zze;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public abstract class BaseGmsClient<T extends IInterface>
{

  @KeepForSdk
  public static final int CONNECT_STATE_CONNECTED = 4;

  @KeepForSdk
  public static final int CONNECT_STATE_DISCONNECTED = 1;

  @KeepForSdk
  public static final int CONNECT_STATE_DISCONNECTING = 5;

  @KeepForSdk
  public static final String DEFAULT_ACCOUNT = "<<default account>>";

  @KeepForSdk
  public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = { "service_esmobile", "service_googleme" };

  @KeepForSdk
  public static final String KEY_PENDING_INTENT = "pendingIntent";
  private static final Feature[] zzbs = new Feature[0];
  private final Context mContext;
  final Handler mHandler;
  private final Object mLock = new Object();
  private int zzbt;
  private long zzbu;
  private long zzbv;
  private int zzbw;
  private long zzbx;

  @VisibleForTesting
  private zzh zzby;
  private final Looper zzbz;
  private final GmsClientSupervisor zzca;
  private final GoogleApiAvailabilityLight zzcb;
  private final Object zzcc = new Object();

  @GuardedBy("mServiceBrokerLock")
  private IGmsServiceBroker zzcd;

  @VisibleForTesting
  protected ConnectionProgressReportCallbacks zzce;

  @GuardedBy("mLock")
  private T zzcf;
  private final ArrayList<zzc<?>> zzcg = new ArrayList();

  @GuardedBy("mLock")
  private zze zzch;

  @GuardedBy("mLock")
  private int zzci = 1;
  private final BaseConnectionCallbacks zzcj;
  private final BaseOnConnectionFailedListener zzck;
  private final int zzcl;
  private final String zzcm;
  private ConnectionResult zzcn = null;
  private boolean zzco = false;
  private volatile zzb zzcp = null;

  @VisibleForTesting
  protected AtomicInteger zzcq = new AtomicInteger(0);

  @KeepForSdk
  @VisibleForTesting
  protected BaseGmsClient(Context paramContext, Handler paramHandler, GmsClientSupervisor paramGmsClientSupervisor, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, int paramInt, BaseConnectionCallbacks paramBaseConnectionCallbacks, BaseOnConnectionFailedListener paramBaseOnConnectionFailedListener)
  {
    this.mContext = ((Context)Preconditions.checkNotNull(paramContext, "Context must not be null"));
    this.mHandler = ((Handler)Preconditions.checkNotNull(paramHandler, "Handler must not be null"));
    this.zzbz = paramHandler.getLooper();
    this.zzca = ((GmsClientSupervisor)Preconditions.checkNotNull(paramGmsClientSupervisor, "Supervisor must not be null"));
    this.zzcb = ((GoogleApiAvailabilityLight)Preconditions.checkNotNull(paramGoogleApiAvailabilityLight, "API availability must not be null"));
    this.zzcl = paramInt;
    this.zzcj = paramBaseConnectionCallbacks;
    this.zzck = paramBaseOnConnectionFailedListener;
    this.zzcm = null;
  }

  @KeepForSdk
  protected BaseGmsClient(Context paramContext, Looper paramLooper, int paramInt, BaseConnectionCallbacks paramBaseConnectionCallbacks, BaseOnConnectionFailedListener paramBaseOnConnectionFailedListener, String paramString)
  {
    this(paramContext, paramLooper, GmsClientSupervisor.getInstance(paramContext), GoogleApiAvailabilityLight.getInstance(), paramInt, (BaseConnectionCallbacks)Preconditions.checkNotNull(paramBaseConnectionCallbacks), (BaseOnConnectionFailedListener)Preconditions.checkNotNull(paramBaseOnConnectionFailedListener), paramString);
  }

  @KeepForSdk
  @VisibleForTesting
  protected BaseGmsClient(Context paramContext, Looper paramLooper, GmsClientSupervisor paramGmsClientSupervisor, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, int paramInt, BaseConnectionCallbacks paramBaseConnectionCallbacks, BaseOnConnectionFailedListener paramBaseOnConnectionFailedListener, String paramString)
  {
    this.mContext = ((Context)Preconditions.checkNotNull(paramContext, "Context must not be null"));
    this.zzbz = ((Looper)Preconditions.checkNotNull(paramLooper, "Looper must not be null"));
    this.zzca = ((GmsClientSupervisor)Preconditions.checkNotNull(paramGmsClientSupervisor, "Supervisor must not be null"));
    this.zzcb = ((GoogleApiAvailabilityLight)Preconditions.checkNotNull(paramGoogleApiAvailabilityLight, "API availability must not be null"));
    this.mHandler = new zzb(paramLooper);
    this.zzcl = paramInt;
    this.zzcj = paramBaseConnectionCallbacks;
    this.zzck = paramBaseOnConnectionFailedListener;
    this.zzcm = paramString;
  }

  private final void zza(int paramInt, T paramT)
  {
    boolean bool1 = true;
    boolean bool2;
    boolean bool3;
    if (paramInt == 4)
    {
      bool2 = bool1;
      if (paramT == null)
        break label533;
      bool3 = bool1;
      label17: if (bool2 != bool3)
        break label539;
    }
    while (true)
    {
      Preconditions.checkArgument(bool1);
      while (true)
      {
        synchronized (this.mLock)
        {
          this.zzci = paramInt;
          this.zzcf = paramT;
          onSetConnectState(paramInt, paramT);
          switch (paramInt)
          {
          default:
            return;
          case 2:
          case 3:
            if ((this.zzch != null) && (this.zzby != null))
            {
              String str6 = this.zzby.zzt();
              String str7 = this.zzby.getPackageName();
              Log.e("GmsClient", 70 + String.valueOf(str6).length() + String.valueOf(str7).length() + "Calling connect() while still connected, missing disconnect() for " + str6 + " on " + str7);
              this.zzca.zza(this.zzby.zzt(), this.zzby.getPackageName(), this.zzby.zzq(), this.zzch, zzj());
              this.zzcq.incrementAndGet();
            }
            this.zzch = new zze(this.zzcq.get());
            if ((this.zzci == 3) && (getLocalStartServiceAction() != null))
            {
              localzzh = new zzh(getContext().getPackageName(), getLocalStartServiceAction(), true, 129);
              this.zzby = localzzh;
              GmsClientSupervisor localGmsClientSupervisor = this.zzca;
              String str1 = this.zzby.zzt();
              String str2 = this.zzby.getPackageName();
              int i = this.zzby.zzq();
              zze localzze = this.zzch;
              String str3 = zzj();
              if (localGmsClientSupervisor.zza(new GmsClientSupervisor.zza(str1, str2, i), localzze, str3))
                continue;
              String str4 = this.zzby.zzt();
              String str5 = this.zzby.getPackageName();
              Log.e("GmsClient", 34 + String.valueOf(str4).length() + String.valueOf(str5).length() + "unable to connect to service: " + str4 + " on " + str5);
              zza(16, null, this.zzcq.get());
            }
            break;
          case 4:
          case 1:
          }
        }
        zzh localzzh = new zzh(getStartServicePackage(), getStartServiceAction(), false, 129);
        continue;
        onConnectedLocked(paramT);
        continue;
        if (this.zzch != null)
        {
          this.zzca.zza(getStartServiceAction(), getStartServicePackage(), 129, this.zzch, zzj());
          this.zzch = null;
        }
      }
      bool2 = false;
      break;
      label533: bool3 = false;
      break label17;
      label539: bool1 = false;
    }
  }

  private final void zza(zzb paramzzb)
  {
    this.zzcp = paramzzb;
  }

  private final boolean zza(int paramInt1, int paramInt2, T paramT)
  {
    synchronized (this.mLock)
    {
      if (this.zzci != paramInt1)
        return false;
      zza(paramInt2, paramT);
      return true;
    }
  }

  private final void zzb(int paramInt)
  {
    int i;
    if (zzk())
    {
      i = 5;
      this.zzco = true;
    }
    while (true)
    {
      this.mHandler.sendMessage(this.mHandler.obtainMessage(i, this.zzcq.get(), 16));
      return;
      i = 4;
    }
  }

  private final String zzj()
  {
    if (this.zzcm == null)
      return this.mContext.getClass().getName();
    return this.zzcm;
  }

  private final boolean zzk()
  {
    while (true)
    {
      synchronized (this.mLock)
      {
        if (this.zzci == 3)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }

  private final boolean zzl()
  {
    if (this.zzco);
    while ((TextUtils.isEmpty(getServiceDescriptor())) || (TextUtils.isEmpty(getLocalStartServiceAction())))
      return false;
    try
    {
      Class.forName(getServiceDescriptor());
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
    return false;
  }

  @KeepForSdk
  public void checkAvailabilityAndConnect()
  {
    int i = this.zzcb.isGooglePlayServicesAvailable(this.mContext, getMinApkVersion());
    if (i != 0)
    {
      zza(1, null);
      triggerNotAvailable(new LegacyClientCallbackAdapter(), i, null);
      return;
    }
    connect(new LegacyClientCallbackAdapter());
  }

  @KeepForSdk
  protected final void checkConnected()
  {
    if (!isConnected())
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
  }

  @KeepForSdk
  public void connect(ConnectionProgressReportCallbacks paramConnectionProgressReportCallbacks)
  {
    this.zzce = ((ConnectionProgressReportCallbacks)Preconditions.checkNotNull(paramConnectionProgressReportCallbacks, "Connection progress callbacks cannot be null."));
    zza(2, null);
  }

  @KeepForSdk
  protected abstract T createServiceInterface(IBinder paramIBinder);

  @KeepForSdk
  public void disconnect()
  {
    this.zzcq.incrementAndGet();
    synchronized (this.zzcg)
    {
      int i = this.zzcg.size();
      for (int j = 0; j < i; j++)
        ((zzc)this.zzcg.get(j)).removeListener();
      this.zzcg.clear();
    }
    synchronized (this.zzcc)
    {
      this.zzcd = null;
      zza(1, null);
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }

  @KeepForSdk
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int i;
    IInterface localIInterface;
    synchronized (this.mLock)
    {
      i = this.zzci;
      localIInterface = this.zzcf;
    }
    while (true)
    {
      IGmsServiceBroker localIGmsServiceBroker;
      synchronized (this.zzcc)
      {
        localIGmsServiceBroker = this.zzcd;
        paramPrintWriter.append(paramString).append("mConnectState=");
        switch (i)
        {
        default:
          paramPrintWriter.print("UNKNOWN");
          paramPrintWriter.append(" mService=");
          if (localIInterface != null)
            break label552;
          paramPrintWriter.append("null");
          paramPrintWriter.append(" mServiceBroker=");
          if (localIGmsServiceBroker != null)
            break label586;
          paramPrintWriter.println("null");
          SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
          if (this.zzbv > 0L)
          {
            PrintWriter localPrintWriter3 = paramPrintWriter.append(paramString).append("lastConnectedTime=");
            long l3 = this.zzbv;
            String str3 = localSimpleDateFormat.format(new Date(this.zzbv));
            localPrintWriter3.println(21 + String.valueOf(str3).length() + l3 + " " + str3);
          }
          if (this.zzbu > 0L)
            paramPrintWriter.append(paramString).append("lastSuspendedCause=");
          switch (this.zzbt)
          {
          default:
            paramPrintWriter.append(String.valueOf(this.zzbt));
            PrintWriter localPrintWriter2 = paramPrintWriter.append(" lastSuspendedTime=");
            long l2 = this.zzbu;
            String str2 = localSimpleDateFormat.format(new Date(this.zzbu));
            localPrintWriter2.println(21 + String.valueOf(str2).length() + l2 + " " + str2);
            if (this.zzbx > 0L)
            {
              paramPrintWriter.append(paramString).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(this.zzbw));
              PrintWriter localPrintWriter1 = paramPrintWriter.append(" lastFailedTime=");
              long l1 = this.zzbx;
              String str1 = localSimpleDateFormat.format(new Date(this.zzbx));
              localPrintWriter1.println(21 + String.valueOf(str1).length() + l1 + " " + str1);
            }
            return;
            localObject2 = finally;
            throw localObject2;
          case 1:
          case 2:
          }
          break;
        case 2:
        case 3:
        case 4:
        case 5:
        case 1:
        }
      }
      paramPrintWriter.print("REMOTE_CONNECTING");
      continue;
      paramPrintWriter.print("LOCAL_CONNECTING");
      continue;
      paramPrintWriter.print("CONNECTED");
      continue;
      paramPrintWriter.print("DISCONNECTING");
      continue;
      paramPrintWriter.print("DISCONNECTED");
      continue;
      label552: paramPrintWriter.append(getServiceDescriptor()).append("@").append(Integer.toHexString(System.identityHashCode(localIInterface.asBinder())));
      continue;
      label586: paramPrintWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(localIGmsServiceBroker.asBinder())));
      continue;
      paramPrintWriter.append("CAUSE_SERVICE_DISCONNECTED");
      continue;
      paramPrintWriter.append("CAUSE_NETWORK_LOST");
    }
  }

  @KeepForSdk
  public Account getAccount()
  {
    return null;
  }

  @KeepForSdk
  public Feature[] getApiFeatures()
  {
    return zzbs;
  }

  @KeepForSdk
  public final Feature[] getAvailableFeatures()
  {
    zzb localzzb = this.zzcp;
    if (localzzb == null)
      return null;
    return localzzb.zzda;
  }

  @KeepForSdk
  public Bundle getConnectionHint()
  {
    return null;
  }

  @KeepForSdk
  public final Context getContext()
  {
    return this.mContext;
  }

  @KeepForSdk
  public String getEndpointPackageName()
  {
    if ((isConnected()) && (this.zzby != null))
      return this.zzby.getPackageName();
    throw new RuntimeException("Failed to connect when checking package");
  }

  @KeepForSdk
  protected Bundle getGetServiceRequestExtraArgs()
  {
    return new Bundle();
  }

  @KeepForSdk
  protected String getLocalStartServiceAction()
  {
    return null;
  }

  @KeepForSdk
  public final Looper getLooper()
  {
    return this.zzbz;
  }

  @KeepForSdk
  public int getMinApkVersion()
  {
    return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  }

  @KeepForSdk
  public void getRemoteService(IAccountAccessor paramIAccountAccessor, Set<Scope> paramSet)
  {
    Bundle localBundle = getGetServiceRequestExtraArgs();
    GetServiceRequest localGetServiceRequest = new GetServiceRequest(this.zzcl);
    localGetServiceRequest.zzdh = this.mContext.getPackageName();
    localGetServiceRequest.zzdk = localBundle;
    if (paramSet != null)
      localGetServiceRequest.zzdj = ((Scope[])paramSet.toArray(new Scope[paramSet.size()]));
    Account localAccount;
    if (requiresSignIn())
      if (getAccount() != null)
        localAccount = getAccount();
    while (true)
    {
      localGetServiceRequest.zzdl = localAccount;
      if (paramIAccountAccessor != null)
        localGetServiceRequest.zzdi = paramIAccountAccessor.asBinder();
      label105: localGetServiceRequest.zzdm = zzbs;
      localGetServiceRequest.zzdn = getApiFeatures();
      try
      {
        synchronized (this.zzcc)
        {
          if (this.zzcd != null)
          {
            this.zzcd.getService(new zzd(this, this.zzcq.get()), localGetServiceRequest);
            return;
            localAccount = new Account("<<default account>>", "com.google");
            continue;
            if (!requiresAccount())
              break label105;
            localGetServiceRequest.zzdl = getAccount();
            break label105;
          }
          Log.w("GmsClient", "mServiceBroker is null, client disconnected");
        }
      }
      catch (DeadObjectException localDeadObjectException)
      {
        Log.w("GmsClient", "IGmsServiceBroker.getService failed", localDeadObjectException);
        triggerConnectionSuspended(1);
        return;
      }
      catch (SecurityException localSecurityException)
      {
        throw localSecurityException;
      }
      catch (RemoteException localRemoteException)
      {
        Log.w("GmsClient", "IGmsServiceBroker.getService failed", localRemoteException);
        onPostInitHandler(8, null, null, this.zzcq.get());
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        label250: break label250;
      }
    }
  }

  @KeepForSdk
  protected Set<Scope> getScopes()
  {
    return Collections.EMPTY_SET;
  }

  @KeepForSdk
  public final T getService()
    throws DeadObjectException
  {
    synchronized (this.mLock)
    {
      if (this.zzci == 5)
        throw new DeadObjectException();
    }
    checkConnected();
    if (this.zzcf != null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "Client is connected but service is null");
      IInterface localIInterface = this.zzcf;
      return localIInterface;
    }
  }

  @KeepForSdk
  public IBinder getServiceBrokerBinder()
  {
    synchronized (this.zzcc)
    {
      if (this.zzcd == null)
        return null;
      IBinder localIBinder = this.zzcd.asBinder();
      return localIBinder;
    }
  }

  @KeepForSdk
  protected abstract String getServiceDescriptor();

  @KeepForSdk
  public Intent getSignInIntent()
  {
    throw new UnsupportedOperationException("Not a sign in API");
  }

  @KeepForSdk
  protected abstract String getStartServiceAction();

  @KeepForSdk
  protected String getStartServicePackage()
  {
    return "com.google.android.gms";
  }

  @KeepForSdk
  public boolean isConnected()
  {
    while (true)
    {
      synchronized (this.mLock)
      {
        if (this.zzci == 4)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }

  @KeepForSdk
  public boolean isConnecting()
  {
    while (true)
    {
      synchronized (this.mLock)
      {
        if (this.zzci != 2)
        {
          if (this.zzci != 3)
            break label40;
          break label35;
          return bool;
        }
      }
      label35: boolean bool = true;
      continue;
      label40: bool = false;
    }
  }

  @KeepForSdk
  protected void onConnectedLocked(T paramT)
  {
    this.zzbv = System.currentTimeMillis();
  }

  @KeepForSdk
  protected void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    this.zzbw = paramConnectionResult.getErrorCode();
    this.zzbx = System.currentTimeMillis();
  }

  @KeepForSdk
  protected void onConnectionSuspended(int paramInt)
  {
    this.zzbt = paramInt;
    this.zzbu = System.currentTimeMillis();
  }

  @KeepForSdk
  protected void onPostInitHandler(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramInt2, -1, new zzf(paramInt1, paramIBinder, paramBundle)));
  }

  @KeepForSdk
  void onSetConnectState(int paramInt, T paramT)
  {
  }

  @KeepForSdk
  public void onUserSignOut(SignOutCallbacks paramSignOutCallbacks)
  {
    paramSignOutCallbacks.onSignOutComplete();
  }

  @KeepForSdk
  public boolean providesSignIn()
  {
    return false;
  }

  @KeepForSdk
  public boolean requiresAccount()
  {
    return false;
  }

  @KeepForSdk
  public boolean requiresGooglePlayServices()
  {
    return true;
  }

  @KeepForSdk
  public boolean requiresSignIn()
  {
    return false;
  }

  @KeepForSdk
  public void triggerConnectionSuspended(int paramInt)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(6, this.zzcq.get(), paramInt));
  }

  @KeepForSdk
  @VisibleForTesting
  protected void triggerNotAvailable(ConnectionProgressReportCallbacks paramConnectionProgressReportCallbacks, int paramInt, PendingIntent paramPendingIntent)
  {
    this.zzce = ((ConnectionProgressReportCallbacks)Preconditions.checkNotNull(paramConnectionProgressReportCallbacks, "Connection progress callbacks cannot be null."));
    this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.zzcq.get(), paramInt, paramPendingIntent));
  }

  protected final void zza(int paramInt1, Bundle paramBundle, int paramInt2)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(7, paramInt2, -1, new zzg(paramInt1, null)));
  }

  @KeepForSdk
  public static abstract interface BaseConnectionCallbacks
  {
    @KeepForSdk
    public abstract void onConnected(Bundle paramBundle);

    @KeepForSdk
    public abstract void onConnectionSuspended(int paramInt);
  }

  @KeepForSdk
  public static abstract interface BaseOnConnectionFailedListener
  {
    public abstract void onConnectionFailed(ConnectionResult paramConnectionResult);
  }

  @KeepForSdk
  public static abstract interface ConnectionProgressReportCallbacks
  {
    @KeepForSdk
    public abstract void onReportServiceBinding(ConnectionResult paramConnectionResult);
  }

  protected class LegacyClientCallbackAdapter
    implements BaseGmsClient.ConnectionProgressReportCallbacks
  {
    @KeepForSdk
    public LegacyClientCallbackAdapter()
    {
    }

    public void onReportServiceBinding(ConnectionResult paramConnectionResult)
    {
      if (paramConnectionResult.isSuccess())
        BaseGmsClient.this.getRemoteService(null, BaseGmsClient.this.getScopes());
      while (BaseGmsClient.zzg(BaseGmsClient.this) == null)
        return;
      BaseGmsClient.zzg(BaseGmsClient.this).onConnectionFailed(paramConnectionResult);
    }
  }

  @KeepForSdk
  public static abstract interface SignOutCallbacks
  {
    @KeepForSdk
    public abstract void onSignOutComplete();
  }

  private abstract class zza extends BaseGmsClient.zzc<Boolean>
  {
    private final int statusCode;
    private final Bundle zzcr;

    protected zza(int paramBundle, Bundle arg3)
    {
      super(Boolean.valueOf(true));
      this.statusCode = paramBundle;
      Object localObject;
      this.zzcr = localObject;
    }

    protected abstract void zza(ConnectionResult paramConnectionResult);

    protected abstract boolean zzm();

    protected final void zzn()
    {
    }
  }

  final class zzb extends zze
  {
    public zzb(Looper arg2)
    {
      super();
    }

    private static void zza(Message paramMessage)
    {
      BaseGmsClient.zzc localzzc = (BaseGmsClient.zzc)paramMessage.obj;
      localzzc.zzn();
      localzzc.unregister();
    }

    private static boolean zzb(Message paramMessage)
    {
      return (paramMessage.what == 2) || (paramMessage.what == 1) || (paramMessage.what == 7);
    }

    public final void handleMessage(Message paramMessage)
    {
      if (BaseGmsClient.this.zzcq.get() != paramMessage.arg1)
      {
        if (zzb(paramMessage))
          zza(paramMessage);
        return;
      }
      if (((paramMessage.what == 1) || (paramMessage.what == 7) || (paramMessage.what == 4) || (paramMessage.what == 5)) && (!BaseGmsClient.this.isConnecting()))
      {
        zza(paramMessage);
        return;
      }
      if (paramMessage.what == 4)
      {
        BaseGmsClient.zza(BaseGmsClient.this, new ConnectionResult(paramMessage.arg2));
        if ((BaseGmsClient.zzb(BaseGmsClient.this)) && (!BaseGmsClient.zzc(BaseGmsClient.this)))
        {
          BaseGmsClient.zza(BaseGmsClient.this, 3, null);
          return;
        }
        if (BaseGmsClient.zzd(BaseGmsClient.this) != null);
        for (ConnectionResult localConnectionResult3 = BaseGmsClient.zzd(BaseGmsClient.this); ; localConnectionResult3 = new ConnectionResult(8))
        {
          BaseGmsClient.this.zzce.onReportServiceBinding(localConnectionResult3);
          BaseGmsClient.this.onConnectionFailed(localConnectionResult3);
          return;
        }
      }
      if (paramMessage.what == 5)
      {
        if (BaseGmsClient.zzd(BaseGmsClient.this) != null);
        for (ConnectionResult localConnectionResult2 = BaseGmsClient.zzd(BaseGmsClient.this); ; localConnectionResult2 = new ConnectionResult(8))
        {
          BaseGmsClient.this.zzce.onReportServiceBinding(localConnectionResult2);
          BaseGmsClient.this.onConnectionFailed(localConnectionResult2);
          return;
        }
      }
      if (paramMessage.what == 3)
      {
        boolean bool = paramMessage.obj instanceof PendingIntent;
        PendingIntent localPendingIntent = null;
        if (bool)
          localPendingIntent = (PendingIntent)paramMessage.obj;
        ConnectionResult localConnectionResult1 = new ConnectionResult(paramMessage.arg2, localPendingIntent);
        BaseGmsClient.this.zzce.onReportServiceBinding(localConnectionResult1);
        BaseGmsClient.this.onConnectionFailed(localConnectionResult1);
        return;
      }
      if (paramMessage.what == 6)
      {
        BaseGmsClient.zza(BaseGmsClient.this, 5, null);
        if (BaseGmsClient.zze(BaseGmsClient.this) != null)
          BaseGmsClient.zze(BaseGmsClient.this).onConnectionSuspended(paramMessage.arg2);
        BaseGmsClient.this.onConnectionSuspended(paramMessage.arg2);
        BaseGmsClient.zza(BaseGmsClient.this, 5, 1, null);
        return;
      }
      if ((paramMessage.what == 2) && (!BaseGmsClient.this.isConnected()))
      {
        zza(paramMessage);
        return;
      }
      if (zzb(paramMessage))
      {
        ((BaseGmsClient.zzc)paramMessage.obj).zzo();
        return;
      }
      int i = paramMessage.what;
      Log.wtf("GmsClient", 45 + "Don't know how to handle message: " + i, new Exception());
    }
  }

  protected abstract class zzc<TListener>
  {
    private TListener zzct;
    private boolean zzcu;

    public zzc()
    {
      Object localObject;
      this.zzct = localObject;
      this.zzcu = false;
    }

    public final void removeListener()
    {
      try
      {
        this.zzct = null;
        return;
      }
      finally
      {
      }
    }

    public final void unregister()
    {
      removeListener();
      synchronized (BaseGmsClient.zzf(BaseGmsClient.this))
      {
        BaseGmsClient.zzf(BaseGmsClient.this).remove(this);
        return;
      }
    }

    protected abstract void zza(TListener paramTListener);

    protected abstract void zzn();

    // ERROR //
    public final void zzo()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 21	com/google/android/gms/common/internal/BaseGmsClient$zzc:zzct	Ljava/lang/Object;
      //   6: astore_2
      //   7: aload_0
      //   8: getfield 23	com/google/android/gms/common/internal/BaseGmsClient$zzc:zzcu	Z
      //   11: ifeq +51 -> 62
      //   14: aload_0
      //   15: invokestatic 51	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   18: astore 5
      //   20: ldc 53
      //   22: new 55	java/lang/StringBuilder
      //   25: dup
      //   26: bipush 47
      //   28: aload 5
      //   30: invokestatic 51	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   33: invokevirtual 59	java/lang/String:length	()I
      //   36: iadd
      //   37: invokespecial 62	java/lang/StringBuilder:<init>	(I)V
      //   40: ldc 64
      //   42: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   45: aload 5
      //   47: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   50: ldc 70
      //   52: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   55: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   58: invokestatic 80	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   61: pop
      //   62: aload_0
      //   63: monitorexit
      //   64: aload_2
      //   65: ifnull +36 -> 101
      //   68: aload_0
      //   69: aload_2
      //   70: invokevirtual 82	com/google/android/gms/common/internal/BaseGmsClient$zzc:zza	(Ljava/lang/Object;)V
      //   73: aload_0
      //   74: monitorenter
      //   75: aload_0
      //   76: iconst_1
      //   77: putfield 23	com/google/android/gms/common/internal/BaseGmsClient$zzc:zzcu	Z
      //   80: aload_0
      //   81: monitorexit
      //   82: aload_0
      //   83: invokevirtual 84	com/google/android/gms/common/internal/BaseGmsClient$zzc:unregister	()V
      //   86: return
      //   87: astore_1
      //   88: aload_0
      //   89: monitorexit
      //   90: aload_1
      //   91: athrow
      //   92: astore 4
      //   94: aload_0
      //   95: invokevirtual 86	com/google/android/gms/common/internal/BaseGmsClient$zzc:zzn	()V
      //   98: aload 4
      //   100: athrow
      //   101: aload_0
      //   102: invokevirtual 86	com/google/android/gms/common/internal/BaseGmsClient$zzc:zzn	()V
      //   105: goto -32 -> 73
      //   108: astore_3
      //   109: aload_0
      //   110: monitorexit
      //   111: aload_3
      //   112: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   2	62	87	finally
      //   62	64	87	finally
      //   88	90	87	finally
      //   68	73	92	java/lang/RuntimeException
      //   75	82	108	finally
      //   109	111	108	finally
    }
  }

  @VisibleForTesting
  public static final class zzd extends IGmsCallbacks.zza
  {
    private BaseGmsClient zzcv;
    private final int zzcw;

    public zzd(BaseGmsClient paramBaseGmsClient, int paramInt)
    {
      this.zzcv = paramBaseGmsClient;
      this.zzcw = paramInt;
    }

    public final void onPostInitComplete(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    {
      Preconditions.checkNotNull(this.zzcv, "onPostInitComplete can be called only once per call to getRemoteService");
      this.zzcv.onPostInitHandler(paramInt, paramIBinder, paramBundle, this.zzcw);
      this.zzcv = null;
    }

    public final void zza(int paramInt, Bundle paramBundle)
    {
      Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    public final void zza(int paramInt, IBinder paramIBinder, zzb paramzzb)
    {
      Preconditions.checkNotNull(this.zzcv, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
      Preconditions.checkNotNull(paramzzb);
      BaseGmsClient.zza(this.zzcv, paramzzb);
      onPostInitComplete(paramInt, paramIBinder, paramzzb.zzcz);
    }
  }

  @VisibleForTesting
  public final class zze
    implements ServiceConnection
  {
    private final int zzcw;

    public zze(int arg2)
    {
      int i;
      this.zzcw = i;
    }

    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      if (paramIBinder == null)
      {
        BaseGmsClient.zza(BaseGmsClient.this, 16);
        return;
      }
      synchronized (BaseGmsClient.zza(BaseGmsClient.this))
      {
        BaseGmsClient localBaseGmsClient = BaseGmsClient.this;
        if (paramIBinder == null);
        IInterface localIInterface;
        for (Object localObject3 = null; ; localObject3 = (IGmsServiceBroker)localIInterface)
        {
          BaseGmsClient.zza(localBaseGmsClient, (IGmsServiceBroker)localObject3);
          BaseGmsClient.this.zza(0, null, this.zzcw);
          return;
          localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
          if ((localIInterface == null) || (!(localIInterface instanceof IGmsServiceBroker)))
            break;
        }
        localObject3 = new IGmsServiceBroker.Stub.zza(paramIBinder);
      }
    }

    public final void onServiceDisconnected(ComponentName paramComponentName)
    {
      synchronized (BaseGmsClient.zza(BaseGmsClient.this))
      {
        BaseGmsClient.zza(BaseGmsClient.this, null);
        BaseGmsClient.this.mHandler.sendMessage(BaseGmsClient.this.mHandler.obtainMessage(6, this.zzcw, 1));
        return;
      }
    }
  }

  protected final class zzf extends BaseGmsClient.zza
  {
    private final IBinder zzcx;

    public zzf(int paramIBinder, IBinder paramBundle, Bundle arg4)
    {
      super(paramIBinder, localBundle);
      this.zzcx = paramBundle;
    }

    protected final void zza(ConnectionResult paramConnectionResult)
    {
      if (BaseGmsClient.zzg(BaseGmsClient.this) != null)
        BaseGmsClient.zzg(BaseGmsClient.this).onConnectionFailed(paramConnectionResult);
      BaseGmsClient.this.onConnectionFailed(paramConnectionResult);
    }

    protected final boolean zzm()
    {
      IInterface localIInterface;
      do
      {
        try
        {
          String str1 = this.zzcx.getInterfaceDescriptor();
          if (!BaseGmsClient.this.getServiceDescriptor().equals(str1))
          {
            String str2 = BaseGmsClient.this.getServiceDescriptor();
            Log.e("GmsClient", 34 + String.valueOf(str2).length() + String.valueOf(str1).length() + "service descriptor mismatch: " + str2 + " vs. " + str1);
            return false;
          }
        }
        catch (RemoteException localRemoteException)
        {
          Log.w("GmsClient", "service probably died");
          return false;
        }
        localIInterface = BaseGmsClient.this.createServiceInterface(this.zzcx);
      }
      while ((localIInterface == null) || ((!BaseGmsClient.zza(BaseGmsClient.this, 2, 4, localIInterface)) && (!BaseGmsClient.zza(BaseGmsClient.this, 3, 4, localIInterface))));
      BaseGmsClient.zza(BaseGmsClient.this, null);
      Bundle localBundle = BaseGmsClient.this.getConnectionHint();
      if (BaseGmsClient.zze(BaseGmsClient.this) != null)
        BaseGmsClient.zze(BaseGmsClient.this).onConnected(localBundle);
      return true;
    }
  }

  protected final class zzg extends BaseGmsClient.zza
  {
    public zzg(int paramBundle, Bundle arg3)
    {
      super(paramBundle, null);
    }

    protected final void zza(ConnectionResult paramConnectionResult)
    {
      BaseGmsClient.this.zzce.onReportServiceBinding(paramConnectionResult);
      BaseGmsClient.this.onConnectionFailed(paramConnectionResult);
    }

    protected final boolean zzm()
    {
      BaseGmsClient.this.zzce.onReportServiceBinding(ConnectionResult.RESULT_SUCCESS);
      return true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.BaseGmsClient
 * JD-Core Version:    0.6.2
 */