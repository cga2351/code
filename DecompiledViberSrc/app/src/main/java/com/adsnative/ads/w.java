package com.adsnative.ads;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.adsnative.c.o;

public class w extends FrameLayout
{
  b.a a;
  Context b;
  int c;
  int d;
  com.adsnative.b.c e;
  i f;
  v g;

  public w(Context paramContext, com.adsnative.b.c paramc, i parami, b.a parama, int paramInt1, int paramInt2, v paramv)
  {
    super(paramContext);
    this.b = paramContext;
    this.a = parama;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramc;
    this.f = parami;
    this.g = paramv;
  }

  public void a()
  {
    c localc = new c(this.b, this.e.i(), this.g, this);
    if (this.a.i() != null)
      localc.loadUrl(this.a.i());
    while (true)
    {
      int i = (int)o.a(this.c, this.b);
      int j = (int)o.a(this.d, this.b);
      com.adsnative.c.i.b("scaledWidth: " + i + " scaledHeight: " + j);
      addView(localc, new FrameLayout.LayoutParams(i, j, 17));
      this.g.a(this);
      return;
      if (this.a.h() != null)
        localc.loadData(this.a.h(), "text/html", "UTF-8");
    }
  }

  public String getBannerEmbedUrl()
  {
    if (this.a != null)
      return this.a.i();
    return null;
  }

  public String getBannerHtml()
  {
    if (this.a != null)
      return this.a.h();
    return null;
  }

  public Double getBiddingInterval()
  {
    return this.f.b();
  }

  public Double getEcpm()
  {
    if (this.e != null)
      return this.e.e();
    return Double.valueOf(0.0D);
  }

  public void setBannerAdListener(v paramv)
  {
    this.g = paramv;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.ads.w
 * JD-Core Version:    0.6.2
 */