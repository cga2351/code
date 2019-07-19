package com.yandex.mobile.ads.impl;

import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.yandex.mobile.ads.nativeads.MediaView;
import com.yandex.mobile.ads.nativeads.i;

final class iu
{
  private final i a;
  private final iw b;

  iu(i parami)
  {
    this.a = parami;
    this.b = new iw();
  }

  static in<String> a(TextView paramTextView)
  {
    if (paramTextView != null);
    for (jd localjd = new jd(paramTextView); ; localjd = null)
    {
      io localio = null;
      if (localjd != null)
        localio = new io(localjd);
      return localio;
    }
  }

  final in<lh> a(ImageView paramImageView)
  {
    if (paramImageView != null);
    for (iz localiz = new iz(paramImageView, this.a); ; localiz = null)
    {
      iq localiq = null;
      if (localiz != null)
        localiq = new iq(localiz);
      return localiq;
    }
  }

  final in<lk> a(ImageView paramImageView, MediaView paramMediaView)
  {
    iz localiz1;
    it localit;
    iz localiz2;
    if (paramImageView != null)
    {
      localiz1 = new iz(paramImageView, this.a);
      if (paramMediaView == null)
        break label167;
      i locali = this.a;
      localit = new it(paramMediaView.getContext());
      paramMediaView.removeAllViews();
      ImageView localImageView = localit.a();
      localImageView.setAdjustViewBounds(true);
      localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      paramMediaView.addView(localImageView, localLayoutParams);
      paramMediaView.addView(localit.b(), localLayoutParams);
      localiz2 = new iz(localit.a(), locali);
    }
    label167: for (ja localja = new ja(paramMediaView, new jb(localit.b()), localiz2); ; localja = null)
    {
      ir localir;
      if (localiz1 == null)
      {
        localir = null;
        if (localja == null);
      }
      else
      {
        localir = new ir(localiz1, localja);
      }
      return localir;
      localiz1 = null;
      break;
    }
  }

  final in<lg> b(TextView paramTextView)
  {
    if (paramTextView != null);
    for (iy localiy = new iy(paramTextView, this.a); ; localiy = null)
    {
      iq localiq = null;
      if (localiy != null)
        localiq = new iq(localiy);
      return localiq;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.iu
 * JD-Core Version:    0.6.2
 */