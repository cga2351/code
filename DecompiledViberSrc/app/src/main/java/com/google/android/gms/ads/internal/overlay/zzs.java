package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.internal.ads.zzare;
import com.google.android.gms.internal.ads.zzaxa;

@zzare
public final class zzs extends zzd
{
  public zzs(Activity paramActivity)
  {
    super(paramActivity);
  }

  public final void onCreate(Bundle paramBundle)
  {
    zzaxa.zzds("AdOverlayParcel is null or does not contain valid overlay type.");
    this.zzdjy = 3;
    this.mActivity.finish();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzs
 * JD-Core Version:    0.6.2
 */