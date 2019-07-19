package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class zabq extends BroadcastReceiver
{
  private Context mContext;
  private final zabr zajh;

  public zabq(zabr paramzabr)
  {
    this.zajh = paramzabr;
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    Uri localUri = paramIntent.getData();
    String str = null;
    if (localUri != null)
      str = localUri.getSchemeSpecificPart();
    if ("com.google.android.gms".equals(str))
    {
      this.zajh.zas();
      unregister();
    }
  }

  public final void unregister()
  {
    try
    {
      if (this.mContext != null)
        this.mContext.unregisterReceiver(this);
      this.mContext = null;
      return;
    }
    finally
    {
    }
  }

  public final void zac(Context paramContext)
  {
    this.mContext = paramContext;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zabq
 * JD-Core Version:    0.6.2
 */