package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.yandex.mobile.ads.nativeads.i;

public final class iz extends je<ImageView, lh>
{
  private final i a;
  private final jj b;

  public iz(ImageView paramImageView, i parami)
  {
    super(paramImageView);
    this.a = parami;
    this.b = new jj(parami);
  }

  public final void a(ImageView paramImageView)
  {
    paramImageView.setImageDrawable(null);
    super.a(paramImageView);
  }

  public final void a(ImageView paramImageView, lh paramlh)
  {
    Bitmap localBitmap = this.a.a(paramlh);
    if (localBitmap != null)
      paramImageView.setImageBitmap(localBitmap);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.iz
 * JD-Core Version:    0.6.2
 */