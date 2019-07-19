package com.google.android.gms.wearable.internal;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageClient;
import com.google.android.gms.wearable.MessageClient.OnMessageReceivedListener;

public final class zzez extends MessageClient
{

  @VisibleForTesting
  private final MessageApi zzei = new zzeu();

  public zzez(Activity paramActivity, GoogleApi.Settings paramSettings)
  {
    super(paramActivity, paramSettings);
  }

  public zzez(Context paramContext, GoogleApi.Settings paramSettings)
  {
    super(paramContext, paramSettings);
  }

  private final Task<Void> zza(MessageClient.OnMessageReceivedListener paramOnMessageReceivedListener, IntentFilter[] paramArrayOfIntentFilter)
  {
    ListenerHolder localListenerHolder = ListenerHolders.createListenerHolder(paramOnMessageReceivedListener, getLooper(), "MessageListener");
    return doRegisterEventListener(new zzfc(paramOnMessageReceivedListener, paramArrayOfIntentFilter, localListenerHolder, null), new zzfd(paramOnMessageReceivedListener, localListenerHolder.getListenerKey(), null));
  }

  public final Task<Void> addListener(MessageClient.OnMessageReceivedListener paramOnMessageReceivedListener)
  {
    IntentFilter[] arrayOfIntentFilter = new IntentFilter[1];
    arrayOfIntentFilter[0] = zzgj.zzc("com.google.android.gms.wearable.MESSAGE_RECEIVED");
    return zza(paramOnMessageReceivedListener, arrayOfIntentFilter);
  }

  public final Task<Void> addListener(MessageClient.OnMessageReceivedListener paramOnMessageReceivedListener, Uri paramUri, int paramInt)
  {
    android.support.v4.util.Preconditions.checkNotNull(paramUri, "uri must not be null");
    if ((paramInt == 0) || (paramInt == 1));
    for (boolean bool = true; ; bool = false)
    {
      com.google.android.gms.common.internal.Preconditions.checkArgument(bool, "invalid filter type");
      return zza(paramOnMessageReceivedListener, new IntentFilter[] { zzgj.zza("com.google.android.gms.wearable.MESSAGE_RECEIVED", paramUri, paramInt) });
    }
  }

  public final Task<Boolean> removeListener(MessageClient.OnMessageReceivedListener paramOnMessageReceivedListener)
  {
    return doUnregisterEventListener(ListenerHolders.createListenerHolder(paramOnMessageReceivedListener, getLooper(), "MessageListener").getListenerKey());
  }

  public final Task<Integer> sendMessage(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    return PendingResultUtil.toTask(this.zzei.sendMessage(asGoogleApiClient(), paramString1, paramString2, paramArrayOfByte), zzfa.zzbx);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzez
 * JD-Core Version:    0.6.2
 */