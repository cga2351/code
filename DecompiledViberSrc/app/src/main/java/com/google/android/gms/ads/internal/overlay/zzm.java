package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzare;
import com.google.android.gms.internal.ads.zzaxj;
import com.google.android.gms.internal.ads.zzbaj;
import com.google.android.gms.internal.ads.zzxp;

@zzare
public final class zzm
{
  public static void zza(Context paramContext, AdOverlayInfoParcel paramAdOverlayInfoParcel, boolean paramBoolean)
  {
    if ((paramAdOverlayInfoParcel.zzdkt == 4) && (paramAdOverlayInfoParcel.zzdko == null))
    {
      if (paramAdOverlayInfoParcel.zzcgj != null)
        paramAdOverlayInfoParcel.zzcgj.onAdClicked();
      zzk.zzle();
      zza.zza(paramContext, paramAdOverlayInfoParcel.zzdkn, paramAdOverlayInfoParcel.zzdks);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.google.android.gms.ads.AdActivity");
    localIntent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", paramAdOverlayInfoParcel.zzbtd.zzdzg);
    localIntent.putExtra("shouldCallOnOverlayOpened", paramBoolean);
    AdOverlayInfoParcel.zza(localIntent, paramAdOverlayInfoParcel);
    if (!PlatformVersion.isAtLeastLollipop())
      localIntent.addFlags(524288);
    if (!(paramContext instanceof Activity))
      localIntent.addFlags(268435456);
    zzk.zzlg();
    zzaxj.zza(paramContext, localIntent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzm
 * JD-Core Version:    0.6.2
 */