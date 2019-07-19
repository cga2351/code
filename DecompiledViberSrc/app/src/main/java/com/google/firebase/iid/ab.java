package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.Nullable;

@VisibleForTesting
final class ab extends BroadcastReceiver
{

  @Nullable
  private ac a;

  public ab(ac paramac)
  {
    this.a = paramac;
  }

  public final void a()
  {
    if (FirebaseInstanceId.zzm())
      Log.d("FirebaseInstanceId", "Connectivity change received registered");
    IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    this.a.a().registerReceiver(this, localIntentFilter);
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.a == null);
    while (!this.a.b())
      return;
    if (FirebaseInstanceId.zzm())
      Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
    FirebaseInstanceId.zza(this.a, 0L);
    this.a.a().unregisterReceiver(this);
    this.a = null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.iid.ab
 * JD-Core Version:    0.6.2
 */