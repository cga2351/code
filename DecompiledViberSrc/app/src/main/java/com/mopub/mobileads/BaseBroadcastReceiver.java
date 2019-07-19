package com.mopub.mobileads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import com.mopub.common.Preconditions;

public abstract class BaseBroadcastReceiver extends BroadcastReceiver
{
  private final long a;
  private Context b;

  public BaseBroadcastReceiver(long paramLong)
  {
    this.a = paramLong;
  }

  public static void broadcastAction(Context paramContext, long paramLong, String paramString)
  {
    Preconditions.checkNotNull(paramContext, "context cannot be null");
    Preconditions.checkNotNull(paramString, "action cannot be null");
    Intent localIntent = new Intent(paramString);
    localIntent.putExtra("broadcastIdentifier", paramLong);
    LocalBroadcastManager.getInstance(paramContext.getApplicationContext()).sendBroadcast(localIntent);
  }

  public abstract IntentFilter getIntentFilter();

  public void register(BroadcastReceiver paramBroadcastReceiver, Context paramContext)
  {
    this.b = paramContext;
    LocalBroadcastManager.getInstance(this.b).registerReceiver(paramBroadcastReceiver, getIntentFilter());
  }

  public boolean shouldConsumeBroadcast(Intent paramIntent)
  {
    Preconditions.checkNotNull(paramIntent, "intent cannot be null");
    long l = paramIntent.getLongExtra("broadcastIdentifier", -1L);
    return this.a == l;
  }

  public void unregister(BroadcastReceiver paramBroadcastReceiver)
  {
    if ((this.b != null) && (paramBroadcastReceiver != null))
    {
      LocalBroadcastManager.getInstance(this.b).unregisterReceiver(paramBroadcastReceiver);
      this.b = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.BaseBroadcastReceiver
 * JD-Core Version:    0.6.2
 */