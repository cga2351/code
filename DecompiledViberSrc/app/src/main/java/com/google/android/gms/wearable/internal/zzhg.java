package com.google.android.gms.wearable.internal;

import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.PutDataRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import javax.annotation.Nullable;

public final class zzhg extends GmsClient<zzep>
{
  private final ExecutorService zzew;
  private final zzer<Object> zzex = new zzer();
  private final zzer<Object> zzey = new zzer();
  private final zzer<ChannelApi.ChannelListener> zzez = new zzer();
  private final zzer<DataApi.DataListener> zzfa = new zzer();
  private final zzer<MessageApi.MessageListener> zzfb = new zzer();
  private final zzer<Object> zzfc = new zzer();
  private final zzer<Object> zzfd = new zzer();
  private final zzer<CapabilityApi.CapabilityListener> zzfe = new zzer();
  private final zzhp zzff;

  public zzhg(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, ClientSettings paramClientSettings)
  {
    this(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramClientSettings, Executors.newCachedThreadPool(), zzhp.zza(paramContext));
  }

  @VisibleForTesting
  private zzhg(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, ClientSettings paramClientSettings, ExecutorService paramExecutorService, zzhp paramzzhp)
  {
    super(paramContext, paramLooper, 14, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zzew = ((ExecutorService)Preconditions.checkNotNull(paramExecutorService));
    this.zzff = paramzzhp;
  }

  public final void connect(BaseGmsClient.ConnectionProgressReportCallbacks paramConnectionProgressReportCallbacks)
  {
    if (!requiresGooglePlayServices())
      try
      {
        Bundle localBundle = getContext().getPackageManager().getApplicationInfo("com.google.android.wearable.app.cn", 128).metaData;
        int i = 0;
        if (localBundle != null)
          i = localBundle.getInt("com.google.android.wearable.api.version", 0);
        if (i < 8600000)
        {
          Log.w("WearableClient", 82 + "The Wear OS app is out of date. Requires API version 8600000 but found " + i);
          Context localContext1 = getContext();
          Context localContext2 = getContext();
          Intent localIntent = new Intent("com.google.android.wearable.app.cn.UPDATE_ANDROID_WEAR").setPackage("com.google.android.wearable.app.cn");
          if (localContext2.getPackageManager().resolveActivity(localIntent, 65536) != null);
          while (true)
          {
            triggerNotAvailable(paramConnectionProgressReportCallbacks, 6, PendingIntent.getActivity(localContext1, 0, localIntent, 0));
            return;
            localIntent = new Intent("android.intent.action.VIEW", Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.wearable.app.cn").build());
          }
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        triggerNotAvailable(paramConnectionProgressReportCallbacks, 16, null);
        return;
      }
    super.connect(paramConnectionProgressReportCallbacks);
  }

  public final int getMinApkVersion()
  {
    return 8600000;
  }

  protected final String getServiceDescriptor()
  {
    return "com.google.android.gms.wearable.internal.IWearableService";
  }

  protected final String getStartServiceAction()
  {
    return "com.google.android.gms.wearable.BIND";
  }

  protected final String getStartServicePackage()
  {
    if (this.zzff.zze("com.google.android.wearable.app.cn"))
      return "com.google.android.wearable.app.cn";
    return "com.google.android.gms";
  }

  protected final void onPostInitHandler(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    if (Log.isLoggable("WearableClient", 2))
      Log.v("WearableClient", 41 + "onPostInitHandler: statusCode " + paramInt1);
    if (paramInt1 == 0)
    {
      this.zzex.zza(paramIBinder);
      this.zzey.zza(paramIBinder);
      this.zzez.zza(paramIBinder);
      this.zzfa.zza(paramIBinder);
      this.zzfb.zza(paramIBinder);
      this.zzfc.zza(paramIBinder);
      this.zzfd.zza(paramIBinder);
      this.zzfe.zza(paramIBinder);
    }
    super.onPostInitHandler(paramInt1, paramIBinder, paramBundle, paramInt2);
  }

  public final boolean requiresGooglePlayServices()
  {
    return !this.zzff.zze("com.google.android.wearable.app.cn");
  }

  public final void zza(BaseImplementation.ResultHolder<DataApi.GetFdForAssetResult> paramResultHolder, Asset paramAsset)
    throws RemoteException
  {
    ((zzep)getService()).zza(new zzgx(paramResultHolder), paramAsset);
  }

  public final void zza(BaseImplementation.ResultHolder<Status> paramResultHolder, CapabilityApi.CapabilityListener paramCapabilityListener)
    throws RemoteException
  {
    this.zzfe.zza(this, paramResultHolder, paramCapabilityListener);
  }

  public final void zza(BaseImplementation.ResultHolder<Status> paramResultHolder, CapabilityApi.CapabilityListener paramCapabilityListener, ListenerHolder<CapabilityApi.CapabilityListener> paramListenerHolder, IntentFilter[] paramArrayOfIntentFilter)
    throws RemoteException
  {
    this.zzfe.zza(this, paramResultHolder, paramCapabilityListener, zzhk.zzd(paramListenerHolder, paramArrayOfIntentFilter));
  }

  public final void zza(BaseImplementation.ResultHolder<Status> paramResultHolder, ChannelApi.ChannelListener paramChannelListener, ListenerHolder<ChannelApi.ChannelListener> paramListenerHolder, @Nullable String paramString, IntentFilter[] paramArrayOfIntentFilter)
    throws RemoteException
  {
    if (paramString == null)
    {
      this.zzez.zza(this, paramResultHolder, paramChannelListener, zzhk.zzc(paramListenerHolder, paramArrayOfIntentFilter));
      return;
    }
    zzgc localzzgc = new zzgc(paramString, paramChannelListener);
    this.zzez.zza(this, paramResultHolder, localzzgc, zzhk.zza(paramListenerHolder, paramString, paramArrayOfIntentFilter));
  }

  public final void zza(BaseImplementation.ResultHolder<Status> paramResultHolder, ChannelApi.ChannelListener paramChannelListener, String paramString)
    throws RemoteException
  {
    if (paramString == null)
    {
      this.zzez.zza(this, paramResultHolder, paramChannelListener);
      return;
    }
    zzgc localzzgc = new zzgc(paramString, paramChannelListener);
    this.zzez.zza(this, paramResultHolder, localzzgc);
  }

  public final void zza(BaseImplementation.ResultHolder<Status> paramResultHolder, DataApi.DataListener paramDataListener)
    throws RemoteException
  {
    this.zzfa.zza(this, paramResultHolder, paramDataListener);
  }

  public final void zza(BaseImplementation.ResultHolder<Status> paramResultHolder, DataApi.DataListener paramDataListener, ListenerHolder<DataApi.DataListener> paramListenerHolder, IntentFilter[] paramArrayOfIntentFilter)
    throws RemoteException
  {
    this.zzfa.zza(this, paramResultHolder, paramDataListener, zzhk.zza(paramListenerHolder, paramArrayOfIntentFilter));
  }

  public final void zza(BaseImplementation.ResultHolder<Status> paramResultHolder, MessageApi.MessageListener paramMessageListener)
    throws RemoteException
  {
    this.zzfb.zza(this, paramResultHolder, paramMessageListener);
  }

  public final void zza(BaseImplementation.ResultHolder<Status> paramResultHolder, MessageApi.MessageListener paramMessageListener, ListenerHolder<MessageApi.MessageListener> paramListenerHolder, IntentFilter[] paramArrayOfIntentFilter)
    throws RemoteException
  {
    this.zzfb.zza(this, paramResultHolder, paramMessageListener, zzhk.zzb(paramListenerHolder, paramArrayOfIntentFilter));
  }

  public final void zza(BaseImplementation.ResultHolder<DataApi.DataItemResult> paramResultHolder, PutDataRequest paramPutDataRequest)
    throws RemoteException
  {
    Iterator localIterator1 = paramPutDataRequest.getAssets().entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Asset localAsset3 = (Asset)((Map.Entry)localIterator1.next()).getValue();
      if ((localAsset3.getData() == null) && (localAsset3.getDigest() == null) && (localAsset3.getFd() == null) && (localAsset3.getUri() == null))
      {
        String str6 = String.valueOf(paramPutDataRequest.getUri());
        String str7 = String.valueOf(localAsset3);
        throw new IllegalArgumentException(33 + String.valueOf(str6).length() + String.valueOf(str7).length() + "Put for " + str6 + " contains invalid asset: " + str7);
      }
    }
    PutDataRequest localPutDataRequest = PutDataRequest.zza(paramPutDataRequest.getUri());
    localPutDataRequest.setData(paramPutDataRequest.getData());
    if (paramPutDataRequest.isUrgent())
      localPutDataRequest.setUrgent();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator2 = paramPutDataRequest.getAssets().entrySet().iterator();
    while (localIterator2.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator2.next();
      Asset localAsset1 = (Asset)localEntry.getValue();
      if (localAsset1.getData() != null)
        try
        {
          ParcelFileDescriptor[] arrayOfParcelFileDescriptor = ParcelFileDescriptor.createPipe();
          if (Log.isLoggable("WearableClient", 3))
          {
            String str3 = String.valueOf(localAsset1);
            String str4 = String.valueOf(arrayOfParcelFileDescriptor[0]);
            String str5 = String.valueOf(arrayOfParcelFileDescriptor[1]);
            Log.d("WearableClient", 61 + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + "processAssets: replacing data with FD in asset: " + str3 + " read:" + str4 + " write:" + str5);
          }
          localPutDataRequest.putAsset((String)localEntry.getKey(), Asset.createFromFd(arrayOfParcelFileDescriptor[0]));
          FutureTask localFutureTask = new FutureTask(new zzhh(this, arrayOfParcelFileDescriptor[1], localAsset1.getData()));
          localArrayList.add(localFutureTask);
          this.zzew.submit(localFutureTask);
        }
        catch (IOException localIOException)
        {
          String str2 = String.valueOf(paramPutDataRequest);
          throw new IllegalStateException(60 + String.valueOf(str2).length() + "Unable to create ParcelFileDescriptor for asset in request: " + str2, localIOException);
        }
      else if (localAsset1.getUri() != null)
        try
        {
          Asset localAsset2 = Asset.createFromFd(getContext().getContentResolver().openFileDescriptor(localAsset1.getUri(), "r"));
          localPutDataRequest.putAsset((String)localEntry.getKey(), localAsset2);
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          new zzhb(paramResultHolder, localArrayList).zza(new zzfu(4005, null));
          String str1 = String.valueOf(localAsset1.getUri());
          Log.w("WearableClient", 28 + String.valueOf(str1).length() + "Couldn't resolve asset URI: " + str1);
          return;
        }
      else
        localPutDataRequest.putAsset((String)localEntry.getKey(), localAsset1);
    }
    ((zzep)getService()).zza(new zzhb(paramResultHolder, localArrayList), localPutDataRequest);
  }

  public final void zza(BaseImplementation.ResultHolder<Status> paramResultHolder, String paramString, Uri paramUri, long paramLong1, long paramLong2)
  {
    try
    {
      ExecutorService localExecutorService = this.zzew;
      Preconditions.checkNotNull(paramResultHolder);
      Preconditions.checkNotNull(paramString);
      Preconditions.checkNotNull(paramUri);
      boolean bool1;
      if (paramLong1 >= 0L)
      {
        bool1 = true;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Long.valueOf(paramLong1);
        Preconditions.checkArgument(bool1, "startOffset is negative: %s", arrayOfObject1);
        if (paramLong2 < -1L)
          break label122;
      }
      label122: for (boolean bool2 = true; ; bool2 = false)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Long.valueOf(paramLong2);
        Preconditions.checkArgument(bool2, "invalid length: %s", arrayOfObject2);
        localExecutorService.execute(new zzhj(this, paramUri, paramResultHolder, paramString, paramLong1, paramLong2));
        return;
        bool1 = false;
        break;
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      paramResultHolder.setFailedResult(new Status(8));
      throw localRuntimeException;
    }
  }

  public final void zza(BaseImplementation.ResultHolder<Status> paramResultHolder, String paramString, Uri paramUri, boolean paramBoolean)
  {
    try
    {
      ExecutorService localExecutorService = this.zzew;
      Preconditions.checkNotNull(paramResultHolder);
      Preconditions.checkNotNull(paramString);
      Preconditions.checkNotNull(paramUri);
      localExecutorService.execute(new zzhi(this, paramUri, paramResultHolder, paramBoolean, paramString));
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      paramResultHolder.setFailedResult(new Status(8));
      throw localRuntimeException;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzhg
 * JD-Core Version:    0.6.2
 */