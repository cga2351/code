package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

class zzbb extends BroadcastReceiver
{

  @VisibleForTesting
  private static final String zzabi = zzbb.class.getName();
  private boolean zzabj;
  private boolean zzabk;
  private final zzfn zzamx;

  zzbb(zzfn paramzzfn)
  {
    Preconditions.checkNotNull(paramzzfn);
    this.zzamx = paramzzfn;
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.zzamx.zzlx();
    String str = paramIntent.getAction();
    this.zzamx.zzgt().zzjo().zzg("NetworkBroadcastReceiver received action", str);
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(str))
    {
      boolean bool = this.zzamx.zzlt().zzfb();
      if (this.zzabk != bool)
      {
        this.zzabk = bool;
        this.zzamx.zzgs().zzc(new zzbc(this, bool));
      }
      return;
    }
    this.zzamx.zzgt().zzjj().zzg("NetworkBroadcastReceiver received unknown action", str);
  }

  public final void unregister()
  {
    this.zzamx.zzlx();
    this.zzamx.zzgs().zzaf();
    this.zzamx.zzgs().zzaf();
    if (!this.zzabj)
      return;
    this.zzamx.zzgt().zzjo().zzby("Unregistering connectivity change receiver");
    this.zzabj = false;
    this.zzabk = false;
    Context localContext = this.zzamx.getContext();
    try
    {
      localContext.unregisterReceiver(this);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.zzamx.zzgt().zzjg().zzg("Failed to unregister the network broadcast receiver", localIllegalArgumentException);
    }
  }

  public final void zzey()
  {
    this.zzamx.zzlx();
    this.zzamx.zzgs().zzaf();
    if (this.zzabj)
      return;
    this.zzamx.getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    this.zzabk = this.zzamx.zzlt().zzfb();
    this.zzamx.zzgt().zzjo().zzg("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzabk));
    this.zzabj = true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzbb
 * JD-Core Version:    0.6.2
 */