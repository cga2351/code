package com.google.android.gms.wearable.internal;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataClient;
import com.google.android.gms.wearable.DataClient.GetFdForAssetResponse;
import com.google.android.gms.wearable.DataClient.OnDataChangedListener;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;

public final class zzcj extends DataClient
{
  private final DataApi zzdi = new zzbw();

  public zzcj(Activity paramActivity, GoogleApi.Settings paramSettings)
  {
    super(paramActivity, paramSettings);
  }

  public zzcj(Context paramContext, GoogleApi.Settings paramSettings)
  {
    super(paramContext, paramSettings);
  }

  private final Task<Void> zza(DataClient.OnDataChangedListener paramOnDataChangedListener, IntentFilter[] paramArrayOfIntentFilter)
  {
    ListenerHolder localListenerHolder = ListenerHolders.createListenerHolder(paramOnDataChangedListener, getLooper(), "DataListener");
    return doRegisterEventListener(new zzcv(paramOnDataChangedListener, paramArrayOfIntentFilter, localListenerHolder, null), new zzcw(paramOnDataChangedListener, localListenerHolder.getListenerKey(), null));
  }

  public final Task<Void> addListener(DataClient.OnDataChangedListener paramOnDataChangedListener)
  {
    IntentFilter[] arrayOfIntentFilter = new IntentFilter[1];
    arrayOfIntentFilter[0] = zzgj.zzc("com.google.android.gms.wearable.DATA_CHANGED");
    return zza(paramOnDataChangedListener, arrayOfIntentFilter);
  }

  public final Task<Void> addListener(DataClient.OnDataChangedListener paramOnDataChangedListener, Uri paramUri, int paramInt)
  {
    Asserts.checkNotNull(paramUri, "uri must not be null");
    if ((paramInt == 0) || (paramInt == 1));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "invalid filter type");
      return zza(paramOnDataChangedListener, new IntentFilter[] { zzgj.zza("com.google.android.gms.wearable.DATA_CHANGED", paramUri, paramInt) });
    }
  }

  public final Task<Integer> deleteDataItems(Uri paramUri)
  {
    return PendingResultUtil.toTask(this.zzdi.deleteDataItems(asGoogleApiClient(), paramUri), zzcp.zzbx);
  }

  public final Task<Integer> deleteDataItems(Uri paramUri, int paramInt)
  {
    return PendingResultUtil.toTask(this.zzdi.deleteDataItems(asGoogleApiClient(), paramUri, paramInt), zzcq.zzbx);
  }

  public final Task<DataItem> getDataItem(Uri paramUri)
  {
    return PendingResultUtil.toTask(this.zzdi.getDataItem(asGoogleApiClient(), paramUri), zzcl.zzbx);
  }

  public final Task<DataItemBuffer> getDataItems()
  {
    return PendingResultUtil.toTask(this.zzdi.getDataItems(asGoogleApiClient()), zzcm.zzbx);
  }

  public final Task<DataItemBuffer> getDataItems(Uri paramUri)
  {
    return PendingResultUtil.toTask(this.zzdi.getDataItems(asGoogleApiClient(), paramUri), zzcn.zzbx);
  }

  public final Task<DataItemBuffer> getDataItems(Uri paramUri, int paramInt)
  {
    return PendingResultUtil.toTask(this.zzdi.getDataItems(asGoogleApiClient(), paramUri, paramInt), zzco.zzbx);
  }

  public final Task<DataClient.GetFdForAssetResponse> getFdForAsset(Asset paramAsset)
  {
    return PendingResultUtil.toTask(this.zzdi.getFdForAsset(asGoogleApiClient(), paramAsset), zzcr.zzbx);
  }

  public final Task<DataClient.GetFdForAssetResponse> getFdForAsset(DataItemAsset paramDataItemAsset)
  {
    return PendingResultUtil.toTask(this.zzdi.getFdForAsset(asGoogleApiClient(), paramDataItemAsset), zzcs.zzbx);
  }

  public final Task<DataItem> putDataItem(PutDataRequest paramPutDataRequest)
  {
    return PendingResultUtil.toTask(this.zzdi.putDataItem(asGoogleApiClient(), paramPutDataRequest), zzck.zzbx);
  }

  public final Task<Boolean> removeListener(DataClient.OnDataChangedListener paramOnDataChangedListener)
  {
    return doUnregisterEventListener(ListenerHolders.createListenerHolder(paramOnDataChangedListener, getLooper(), "DataListener").getListenerKey());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcj
 * JD-Core Version:    0.6.2
 */