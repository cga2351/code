package com.google.android.gms.gcm;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.gcm.zzj;
import java.util.concurrent.BlockingQueue;

final class zzf extends zzj
{
  zzf(GoogleCloudMessaging paramGoogleCloudMessaging, Looper paramLooper)
  {
    super(paramLooper);
  }

  public final void handleMessage(Message paramMessage)
  {
    if ((paramMessage == null) || (!(paramMessage.obj instanceof Intent)))
      Log.w("GCM", "Dropping invalid message");
    Intent localIntent = (Intent)paramMessage.obj;
    if ("com.google.android.c2dm.intent.REGISTRATION".equals(localIntent.getAction()))
      GoogleCloudMessaging.zzd(this.zzak).add(localIntent);
    while (GoogleCloudMessaging.zzd(this.zzak, localIntent))
      return;
    localIntent.setPackage(GoogleCloudMessaging.zze(this.zzak).getPackageName());
    GoogleCloudMessaging.zze(this.zzak).sendBroadcast(localIntent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.gcm.zzf
 * JD-Core Version:    0.6.2
 */