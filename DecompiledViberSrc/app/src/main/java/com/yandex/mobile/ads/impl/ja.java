package com.yandex.mobile.ads.impl;

import android.widget.ImageView;
import com.yandex.mobile.ads.nativeads.MediaView;

public final class ja extends je<MediaView, lk>
{
  private final jf<ImageView, lh> a;
  private final jf<dp, lj> b;

  public ja(MediaView paramMediaView, jb paramjb, iz paramiz)
  {
    super(paramMediaView);
    this.a = new jf(paramiz);
    this.b = new jf(paramjb);
  }

  public final void a(le paramle, ji paramji)
  {
    this.a.a(paramle, paramji);
    this.b.a(paramle, paramji);
  }

  public final void a(lk paramlk)
  {
    if (paramlk.a() != null)
      this.b.a(paramlk.a());
    while (paramlk.b() == null)
      return;
    this.a.a(paramlk.b());
  }

  public final void a(MediaView paramMediaView)
  {
    this.a.a();
    this.b.a();
    super.a(paramMediaView);
  }

  public final void b(lk paramlk)
  {
    if ((paramlk.a() == null) && (paramlk.b() != null))
      this.a.a(paramlk.b());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ja
 * JD-Core Version:    0.6.2
 */