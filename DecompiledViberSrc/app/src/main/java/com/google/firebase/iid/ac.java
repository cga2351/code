package com.google.firebase.iid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.FirebaseApp;
import java.io.IOException;

final class ac
  implements Runnable
{
  private final long a;
  private final PowerManager.WakeLock b;
  private final FirebaseInstanceId c;
  private final ae d;

  @VisibleForTesting
  ac(FirebaseInstanceId paramFirebaseInstanceId, p paramp, ae paramae, long paramLong)
  {
    this.c = paramFirebaseInstanceId;
    this.d = paramae;
    this.a = paramLong;
    this.b = ((PowerManager)a().getSystemService("power")).newWakeLock(1, "fiid-sync");
    this.b.setReferenceCounted(false);
  }

  @VisibleForTesting
  private final boolean c()
  {
    z localz = this.c.zzk();
    if ((!this.c.zzr()) && (!this.c.zza(localz)));
    while (true)
    {
      return true;
      try
      {
        String str3 = this.c.zzl();
        if (str3 == null)
        {
          Log.e("FirebaseInstanceId", "Token retrieval failed: null");
          return false;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3))
          Log.d("FirebaseInstanceId", "Token successfully retrieved");
        if ((localz != null) && ((localz == null) || (str3.equals(localz.a))))
          continue;
        Context localContext = a();
        Intent localIntent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
        localIntent.putExtra("token", str3);
        x.b(localContext, localIntent);
        x.a(localContext, new Intent("com.google.firebase.iid.TOKEN_REFRESH"));
        return true;
      }
      catch (IOException localIOException)
      {
        String str1 = String.valueOf(localIOException.getMessage());
        if (str1.length() != 0);
        for (String str2 = "Token retrieval failed: ".concat(str1); ; str2 = new String("Token retrieval failed: "))
        {
          Log.e("FirebaseInstanceId", str2);
          return false;
        }
      }
      catch (SecurityException localSecurityException)
      {
        label143: break label143;
      }
    }
  }

  final Context a()
  {
    return this.c.zzi().a();
  }

  final boolean b()
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)a().getSystemService("connectivity");
    if (localConnectivityManager != null);
    for (NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo(); (localNetworkInfo != null) && (localNetworkInfo.isConnected()); localNetworkInfo = null)
      return true;
    return false;
  }

  @SuppressLint({"Wakelock"})
  public final void run()
  {
    try
    {
      if (x.a().a(a()))
        this.b.acquire();
      this.c.zza(true);
      if (!this.c.zzo())
      {
        this.c.zza(false);
        return;
      }
      if ((x.a().b(a())) && (!b()))
      {
        new ab(this).a();
        return;
      }
      if ((c()) && (this.d.a(this.c)))
        this.c.zza(false);
      while (true)
      {
        return;
        this.c.zza(this.a);
      }
    }
    finally
    {
      if (x.a().a(a()))
        this.b.release();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.iid.ac
 * JD-Core Version:    0.6.2
 */