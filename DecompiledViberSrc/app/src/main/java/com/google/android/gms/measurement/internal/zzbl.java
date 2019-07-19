package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzu;

final class zzbl
  implements Runnable
{
  zzbl(zzbk paramzzbk, zzu paramzzu, ServiceConnection paramServiceConnection)
  {
  }

  public final void run()
  {
    zzbj localzzbj = this.zzaof.zzaoc;
    String str1 = zzbk.zza(this.zzaof);
    zzu localzzu = this.zzaod;
    ServiceConnection localServiceConnection = this.zzaoe;
    Bundle localBundle1 = localzzbj.zza(str1, localzzu);
    localzzbj.zzada.zzgs().zzaf();
    long l1;
    if (localBundle1 != null)
    {
      l1 = 1000L * localBundle1.getLong("install_begin_timestamp_seconds", 0L);
      if (l1 != 0L)
        break label107;
      localzzbj.zzada.zzgt().zzjg().zzby("Service response is missing Install Referrer install timestamp");
    }
    while (true)
    {
      if (localServiceConnection != null)
        ConnectionTracker.getInstance().unbindService(localzzbj.zzada.getContext(), localServiceConnection);
      return;
      label107: String str2 = localBundle1.getString("install_referrer");
      if ((str2 == null) || (str2.isEmpty()))
      {
        localzzbj.zzada.zzgt().zzjg().zzby("No referrer defined in install referrer response");
      }
      else
      {
        localzzbj.zzada.zzgt().zzjo().zzg("InstallReferrer API result", str2);
        zzfx localzzfx = localzzbj.zzada.zzgr();
        String str3 = String.valueOf(str2);
        if (str3.length() != 0);
        Bundle localBundle2;
        for (String str4 = "?".concat(str3); ; str4 = new String("?"))
        {
          localBundle2 = localzzfx.zza(Uri.parse(str4));
          if (localBundle2 != null)
            break label246;
          localzzbj.zzada.zzgt().zzjg().zzby("No campaign params defined in install referrer result");
          break;
        }
        label246: String str5 = localBundle2.getString("medium");
        int i;
        if ((str5 != null) && (!"(not set)".equalsIgnoreCase(str5)) && (!"organic".equalsIgnoreCase(str5)))
          i = 1;
        while (true)
          if (i != 0)
          {
            long l2 = 1000L * localBundle1.getLong("referrer_click_timestamp_seconds", 0L);
            if (l2 == 0L)
            {
              localzzbj.zzada.zzgt().zzjg().zzby("Install Referrer is missing click timestamp for ad campaign");
              break;
              i = 0;
              continue;
            }
            localBundle2.putLong("click_timestamp", l2);
          }
        if (l1 == localzzbj.zzada.zzgu().zzani.get())
        {
          localzzbj.zzada.zzgw();
          localzzbj.zzada.zzgt().zzjo().zzby("Campaign has already been logged");
        }
        else
        {
          localzzbj.zzada.zzgu().zzani.set(l1);
          localzzbj.zzada.zzgw();
          localzzbj.zzada.zzgt().zzjo().zzg("Logging Install Referrer campaign from sdk with ", "referrer API");
          localBundle2.putString("_cis", "referrer API");
          localzzbj.zzada.zzgj().logEvent("auto", "_cmp", localBundle2);
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzbl
 * JD-Core Version:    0.6.2
 */