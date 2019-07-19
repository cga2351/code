package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import com.google.android.gms.internal.ads.zzare;
import com.google.android.gms.internal.ads.zzazu;
import com.google.android.gms.internal.ads.zzyr;
import javax.annotation.Nullable;

@zzare
public final class zzp extends FrameLayout
  implements View.OnClickListener
{
  private final ImageButton zzdkw;
  private final zzx zzdkx;

  public zzp(Context paramContext, zzq paramzzq, @Nullable zzx paramzzx)
  {
    super(paramContext);
    this.zzdkx = paramzzx;
    setOnClickListener(this);
    this.zzdkw = new ImageButton(paramContext);
    this.zzdkw.setImageResource(17301527);
    this.zzdkw.setBackgroundColor(0);
    this.zzdkw.setOnClickListener(this);
    ImageButton localImageButton1 = this.zzdkw;
    zzyr.zzpa();
    int i = zzazu.zza(paramContext, paramzzq.paddingLeft);
    zzyr.zzpa();
    int j = zzazu.zza(paramContext, 0);
    zzyr.zzpa();
    int k = zzazu.zza(paramContext, paramzzq.paddingRight);
    zzyr.zzpa();
    localImageButton1.setPadding(i, j, k, zzazu.zza(paramContext, paramzzq.paddingBottom));
    this.zzdkw.setContentDescription("Interstitial close button");
    ImageButton localImageButton2 = this.zzdkw;
    zzyr.zzpa();
    int m = zzazu.zza(paramContext, paramzzq.size + paramzzq.paddingLeft + paramzzq.paddingRight);
    zzyr.zzpa();
    addView(localImageButton2, new FrameLayout.LayoutParams(m, zzazu.zza(paramContext, paramzzq.size + paramzzq.paddingBottom), 17));
  }

  public final void onClick(View paramView)
  {
    if (this.zzdkx != null)
      this.zzdkx.zztf();
  }

  public final void zzaf(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.zzdkw.setVisibility(8);
      return;
    }
    this.zzdkw.setVisibility(0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzp
 * JD-Core Version:    0.6.2
 */