package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzare;
import com.google.android.gms.internal.ads.zzayc;

@zzare
@VisibleForTesting
final class zzi extends RelativeLayout
{

  @VisibleForTesting
  private zzayc zzdkh;

  @VisibleForTesting
  boolean zzdki;

  public zzi(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext);
    this.zzdkh = new zzayc(paramContext, paramString1);
    this.zzdkh.zzp(paramString2);
  }

  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.zzdki)
      this.zzdkh.zzd(paramMotionEvent);
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzi
 * JD-Core Version:    0.6.2
 */