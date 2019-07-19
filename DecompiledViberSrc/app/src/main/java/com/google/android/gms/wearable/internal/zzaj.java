package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.ChannelApi.OpenChannelResult;

public final class zzaj
  implements ChannelApi
{
  public final PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, ChannelApi.ChannelListener paramChannelListener)
  {
    Preconditions.checkNotNull(paramGoogleApiClient, "client is null");
    Preconditions.checkNotNull(paramChannelListener, "listener is null");
    IntentFilter[] arrayOfIntentFilter = new IntentFilter[1];
    arrayOfIntentFilter[0] = zzgj.zzc("com.google.android.gms.wearable.CHANNEL_EVENT");
    return zzb.zza(paramGoogleApiClient, new zzal(arrayOfIntentFilter), paramChannelListener);
  }

  public final PendingResult<ChannelApi.OpenChannelResult> openChannel(GoogleApiClient paramGoogleApiClient, String paramString1, String paramString2)
  {
    Preconditions.checkNotNull(paramGoogleApiClient, "client is null");
    Preconditions.checkNotNull(paramString1, "nodeId is null");
    Preconditions.checkNotNull(paramString2, "path is null");
    return paramGoogleApiClient.enqueue(new zzak(this, paramGoogleApiClient, paramString1, paramString2));
  }

  public final PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, ChannelApi.ChannelListener paramChannelListener)
  {
    Preconditions.checkNotNull(paramGoogleApiClient, "client is null");
    Preconditions.checkNotNull(paramChannelListener, "listener is null");
    return paramGoogleApiClient.enqueue(new zzan(paramGoogleApiClient, paramChannelListener, null));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzaj
 * JD-Core Version:    0.6.2
 */