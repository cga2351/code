package com.google.android.gms.wearable.internal;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelClient;
import com.google.android.gms.wearable.ChannelClient.Channel;
import com.google.android.gms.wearable.ChannelClient.ChannelCallback;
import java.io.InputStream;
import java.io.OutputStream;

public final class zzao extends ChannelClient
{
  private final zzaj zzcg = new zzaj();

  public zzao(Activity paramActivity, GoogleApi.Settings paramSettings)
  {
    super(paramActivity, paramSettings);
  }

  public zzao(Context paramContext, GoogleApi.Settings paramSettings)
  {
    super(paramContext, paramSettings);
  }

  private static zzay zza(Channel paramChannel)
  {
    Preconditions.checkNotNull(paramChannel, "channel must not be null");
    return (zzay)paramChannel;
  }

  private static zzay zza(ChannelClient.Channel paramChannel)
  {
    Preconditions.checkNotNull(paramChannel, "channel must not be null");
    return (zzay)paramChannel;
  }

  public final Task<Void> close(ChannelClient.Channel paramChannel)
  {
    return PendingResultUtil.toVoidTask(zza(paramChannel).close(asGoogleApiClient()));
  }

  public final Task<Void> close(ChannelClient.Channel paramChannel, int paramInt)
  {
    return PendingResultUtil.toVoidTask(zza(paramChannel).close(asGoogleApiClient(), paramInt));
  }

  public final Task<InputStream> getInputStream(ChannelClient.Channel paramChannel)
  {
    return PendingResultUtil.toTask(zza(paramChannel).getInputStream(asGoogleApiClient()), zzaq.zzbx);
  }

  public final Task<OutputStream> getOutputStream(ChannelClient.Channel paramChannel)
  {
    return PendingResultUtil.toTask(zza(paramChannel).getOutputStream(asGoogleApiClient()), zzar.zzbx);
  }

  public final Task<ChannelClient.Channel> openChannel(String paramString1, String paramString2)
  {
    return PendingResultUtil.toTask(this.zzcg.openChannel(asGoogleApiClient(), paramString1, paramString2), zzap.zzbx);
  }

  public final Task<Void> receiveFile(ChannelClient.Channel paramChannel, Uri paramUri, boolean paramBoolean)
  {
    return PendingResultUtil.toVoidTask(zza(paramChannel).receiveFile(asGoogleApiClient(), paramUri, paramBoolean));
  }

  public final Task<Void> registerChannelCallback(ChannelClient.Channel paramChannel, ChannelClient.ChannelCallback paramChannelCallback)
  {
    String str1 = ((zzay)paramChannel).zzc();
    Preconditions.checkNotNull(paramChannelCallback, "listener is null");
    Looper localLooper = getLooper();
    String str2 = String.valueOf(str1);
    if (str2.length() != 0);
    for (String str3 = "ChannelListener:".concat(str2); ; str3 = new String("ChannelListener:"))
    {
      ListenerHolder localListenerHolder = ListenerHolders.createListenerHolder(paramChannelCallback, localLooper, str3);
      IntentFilter[] arrayOfIntentFilter = new IntentFilter[1];
      arrayOfIntentFilter[0] = zzgj.zzc("com.google.android.gms.wearable.CHANNEL_EVENT");
      zzas localzzas = new zzas(paramChannelCallback);
      return doRegisterEventListener(new zzat(localzzas, str1, arrayOfIntentFilter, localListenerHolder, ListenerHolders.createListenerHolder(localzzas, getLooper(), "ChannelListener")), new zzau(localzzas, str1, localListenerHolder.getListenerKey()));
    }
  }

  public final Task<Void> registerChannelCallback(ChannelClient.ChannelCallback paramChannelCallback)
  {
    Preconditions.checkNotNull(paramChannelCallback, "listener is null");
    ListenerHolder localListenerHolder = ListenerHolders.createListenerHolder(paramChannelCallback, getLooper(), "ChannelListener");
    IntentFilter[] arrayOfIntentFilter = new IntentFilter[1];
    arrayOfIntentFilter[0] = zzgj.zzc("com.google.android.gms.wearable.CHANNEL_EVENT");
    zzas localzzas = new zzas(paramChannelCallback);
    return doRegisterEventListener(new zzat(localzzas, null, arrayOfIntentFilter, localListenerHolder, ListenerHolders.createListenerHolder(localzzas, getLooper(), "ChannelListener")), new zzau(localzzas, null, localListenerHolder.getListenerKey()));
  }

  public final Task<Void> sendFile(ChannelClient.Channel paramChannel, Uri paramUri)
  {
    return PendingResultUtil.toVoidTask(zza(paramChannel).sendFile(asGoogleApiClient(), paramUri));
  }

  public final Task<Void> sendFile(ChannelClient.Channel paramChannel, Uri paramUri, long paramLong1, long paramLong2)
  {
    return PendingResultUtil.toVoidTask(zza(paramChannel).sendFile(asGoogleApiClient(), paramUri, paramLong1, paramLong2));
  }

  public final Task<Boolean> unregisterChannelCallback(ChannelClient.Channel paramChannel, ChannelClient.ChannelCallback paramChannelCallback)
  {
    String str1 = zza(paramChannel).zzc();
    Looper localLooper = getLooper();
    String str2 = String.valueOf(str1);
    if (str2.length() != 0);
    for (String str3 = "ChannelListener:".concat(str2); ; str3 = new String("ChannelListener:"))
      return doUnregisterEventListener(ListenerHolders.createListenerHolder(paramChannelCallback, localLooper, str3).getListenerKey());
  }

  public final Task<Boolean> unregisterChannelCallback(ChannelClient.ChannelCallback paramChannelCallback)
  {
    return doUnregisterEventListener(ListenerHolders.createListenerHolder(paramChannelCallback, getLooper(), "ChannelListener").getListenerKey());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzao
 * JD-Core Version:    0.6.2
 */