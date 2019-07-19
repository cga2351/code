package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;

public final class zzeu
  implements MessageApi
{
  private static PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, MessageApi.MessageListener paramMessageListener, IntentFilter[] paramArrayOfIntentFilter)
  {
    return paramGoogleApiClient.enqueue(new zzex(paramGoogleApiClient, paramMessageListener, paramGoogleApiClient.registerListener(paramMessageListener), paramArrayOfIntentFilter, null));
  }

  public final PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, MessageApi.MessageListener paramMessageListener)
  {
    IntentFilter[] arrayOfIntentFilter = new IntentFilter[1];
    arrayOfIntentFilter[0] = zzgj.zzc("com.google.android.gms.wearable.MESSAGE_RECEIVED");
    return zza(paramGoogleApiClient, paramMessageListener, arrayOfIntentFilter);
  }

  public final PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, MessageApi.MessageListener paramMessageListener, Uri paramUri, int paramInt)
  {
    Preconditions.checkNotNull(paramUri, "uri must not be null");
    if ((paramInt == 0) || (paramInt == 1));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "invalid filter type");
      return zza(paramGoogleApiClient, paramMessageListener, new IntentFilter[] { zzgj.zza("com.google.android.gms.wearable.MESSAGE_RECEIVED", paramUri, paramInt) });
    }
  }

  public final PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, MessageApi.MessageListener paramMessageListener)
  {
    return paramGoogleApiClient.enqueue(new zzew(this, paramGoogleApiClient, paramMessageListener));
  }

  public final PendingResult<MessageApi.SendMessageResult> sendMessage(GoogleApiClient paramGoogleApiClient, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    return paramGoogleApiClient.enqueue(new zzev(this, paramGoogleApiClient, paramString1, paramString2, paramArrayOfByte));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzeu
 * JD-Core Version:    0.6.2
 */