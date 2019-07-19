package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;

@TargetApi(14)
final class zzdu
  implements Application.ActivityLifecycleCallbacks
{
  private zzdu(zzda paramzzda)
  {
  }

  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    int i = 1;
    while (true)
    {
      String str1;
      String str2;
      try
      {
        this.zzarh.zzgt().zzjo().zzby("onActivityCreated");
        Intent localIntent = paramActivity.getIntent();
        if (localIntent != null)
        {
          Uri localUri = localIntent.getData();
          if ((localUri != null) && (localUri.isHierarchical()))
          {
            if (paramBundle == null)
            {
              Bundle localBundle = this.zzarh.zzgr().zza(localUri);
              this.zzarh.zzgr();
              if (!zzfx.zzc(localIntent))
                break label281;
              str1 = "gs";
              if (localBundle != null)
                this.zzarh.logEvent(str1, "_cmp", localBundle);
            }
            str2 = localUri.getQueryParameter("referrer");
            if (TextUtils.isEmpty(str2))
              return;
            if ((!str2.contains("gclid")) || ((!str2.contains("utm_campaign")) && (!str2.contains("utm_source")) && (!str2.contains("utm_medium")) && (!str2.contains("utm_term")) && (!str2.contains("utm_content"))))
              break label234;
            if (i != 0)
              break label239;
            this.zzarh.zzgt().zzjn().zzby("Activity created with data 'referrer' param without gclid and at least one utm field");
            return;
          }
        }
      }
      catch (Exception localException)
      {
        this.zzarh.zzgt().zzjg().zzg("Throwable caught in onActivityCreated", localException);
        this.zzarh.zzgm().onActivityCreated(paramActivity, paramBundle);
        return;
      }
      label234: i = 0;
      continue;
      label239: this.zzarh.zzgt().zzjn().zzg("Activity created with referrer", str2);
      if (!TextUtils.isEmpty(str2))
      {
        this.zzarh.zzb("auto", "_ldl", str2, true);
        continue;
        label281: str1 = "auto";
      }
    }
  }

  public final void onActivityDestroyed(Activity paramActivity)
  {
    this.zzarh.zzgm().onActivityDestroyed(paramActivity);
  }

  public final void onActivityPaused(Activity paramActivity)
  {
    this.zzarh.zzgm().onActivityPaused(paramActivity);
    zzfd localzzfd = this.zzarh.zzgo();
    long l = localzzfd.zzbx().elapsedRealtime();
    localzzfd.zzgs().zzc(new zzfh(localzzfd, l));
  }

  public final void onActivityResumed(Activity paramActivity)
  {
    this.zzarh.zzgm().onActivityResumed(paramActivity);
    zzfd localzzfd = this.zzarh.zzgo();
    long l = localzzfd.zzbx().elapsedRealtime();
    localzzfd.zzgs().zzc(new zzfg(localzzfd, l));
  }

  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    this.zzarh.zzgm().onActivitySaveInstanceState(paramActivity, paramBundle);
  }

  public final void onActivityStarted(Activity paramActivity)
  {
  }

  public final void onActivityStopped(Activity paramActivity)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzdu
 * JD-Core Version:    0.6.2
 */