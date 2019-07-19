package com.google.android.gms.ads.internal.overlay;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.google.android.gms.ads.internal.zzh;
import com.google.android.gms.internal.ads.zzare;
import com.google.android.gms.internal.ads.zzaww;
import com.google.android.gms.internal.ads.zzaxj;
import com.google.android.gms.internal.ads.zzaxp;
import com.google.android.gms.internal.ads.zzazi;

@zzare
final class zzk extends zzaww
{
  private zzk(zzd paramzzd)
  {
  }

  public final void zzto()
  {
    Bitmap localBitmap = com.google.android.gms.ads.internal.zzk.zzlz().zza(Integer.valueOf(this.zzdkk.zzdjn.zzdkv.zzbrk));
    if (localBitmap != null)
    {
      Drawable localDrawable = com.google.android.gms.ads.internal.zzk.zzli().zza(this.zzdkk.mActivity, localBitmap, this.zzdkk.zzdjn.zzdkv.zzbri, this.zzdkk.zzdjn.zzdkv.zzbrj);
      zzaxj.zzdvx.post(new zzl(this, localDrawable));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzk
 * JD-Core Version:    0.6.2
 */