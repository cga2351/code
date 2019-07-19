package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.MessageApi.MessageListener;

final class zzex extends zzn<Status>
{
  private ListenerHolder<MessageApi.MessageListener> zzax;
  private IntentFilter[] zzba;
  private MessageApi.MessageListener zzeg;

  private zzex(GoogleApiClient paramGoogleApiClient, MessageApi.MessageListener paramMessageListener, ListenerHolder<MessageApi.MessageListener> paramListenerHolder, IntentFilter[] paramArrayOfIntentFilter)
  {
    super(paramGoogleApiClient);
    this.zzeg = ((MessageApi.MessageListener)Preconditions.checkNotNull(paramMessageListener));
    this.zzax = ((ListenerHolder)Preconditions.checkNotNull(paramListenerHolder));
    this.zzba = ((IntentFilter[])Preconditions.checkNotNull(paramArrayOfIntentFilter));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzex
 * JD-Core Version:    0.6.2
 */