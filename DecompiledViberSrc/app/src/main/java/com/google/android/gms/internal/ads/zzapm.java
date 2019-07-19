package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.customtabs.b;
import android.support.customtabs.b.a;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.util.PlatformVersion;

@zzare
public final class zzapm
  implements MediationInterstitialAdapter
{
  private Uri uri;
  private Activity zzdhp;
  private MediationInterstitialListener zzdhq;

  public final void onDestroy()
  {
    zzbae.zzdp("Destroying AdMobCustomTabsAdapter adapter.");
  }

  public final void onPause()
  {
    zzbae.zzdp("Pausing AdMobCustomTabsAdapter adapter.");
  }

  public final void onResume()
  {
    zzbae.zzdp("Resuming AdMobCustomTabsAdapter adapter.");
  }

  public final void requestInterstitialAd(Context paramContext, MediationInterstitialListener paramMediationInterstitialListener, Bundle paramBundle1, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    this.zzdhq = paramMediationInterstitialListener;
    if (this.zzdhq == null)
    {
      zzbae.zzep("Listener not set for mediation. Returning.");
      return;
    }
    if (!(paramContext instanceof Activity))
    {
      zzbae.zzep("AdMobCustomTabs can only work with Activity context. Bailing out.");
      this.zzdhq.onAdFailedToLoad(this, 0);
      return;
    }
    if ((PlatformVersion.isAtLeastIceCreamSandwichMR1()) && (zzadr.zzj(paramContext)));
    for (int i = 1; i == 0; i = 0)
    {
      zzbae.zzep("Default browser does not support custom tabs. Bailing out.");
      this.zzdhq.onAdFailedToLoad(this, 0);
      return;
    }
    String str = paramBundle1.getString("tab_url");
    if (TextUtils.isEmpty(str))
    {
      zzbae.zzep("The tab_url retrieved from mediation metadata is empty. Bailing out.");
      this.zzdhq.onAdFailedToLoad(this, 0);
      return;
    }
    this.zzdhp = ((Activity)paramContext);
    this.uri = Uri.parse(str);
    this.zzdhq.onAdLoaded(this);
  }

  public final void showInterstitial()
  {
    b localb = new b.a().a();
    localb.a.setData(this.uri);
    AdOverlayInfoParcel localAdOverlayInfoParcel = new AdOverlayInfoParcel(new zzc(localb.a), null, new zzapn(this), null, new zzbaj(0, 0, false));
    zzaxj.zzdvx.post(new zzapo(this, localAdOverlayInfoParcel));
    zzk.zzlk().zzuy();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzapm
 * JD-Core Version:    0.6.2
 */