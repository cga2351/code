package com.yandex.mobile.ads.nativeads;

import com.yandex.mobile.ads.impl.lh;
import com.yandex.mobile.ads.impl.lj;

public abstract class NativeAdAssets
{
  private NativeAdMedia a;
  private String b;
  private String c;
  private String d;
  private String e;
  private NativeAdImage f;
  private NativeAdImage g;
  private NativeAdImage h;
  private String i;
  private Float j;
  private String k;
  private String l;
  private String m;
  private String n;

  private static NativeAdImage d(lh paramlh, i parami)
  {
    if (paramlh != null)
    {
      NativeAdImage localNativeAdImage = new NativeAdImage();
      localNativeAdImage.a(paramlh.b());
      localNativeAdImage.b(paramlh.a());
      localNativeAdImage.a(paramlh.d());
      localNativeAdImage.a(parami.a(paramlh));
      return localNativeAdImage;
    }
    return null;
  }

  final void a(lh paramlh, i parami)
  {
    this.f = d(paramlh, parami);
  }

  final void a(lj paramlj)
  {
    if (paramlj != null);
    for (NativeAdMedia localNativeAdMedia = new NativeAdMedia(paramlj.b()); ; localNativeAdMedia = null)
    {
      this.a = localNativeAdMedia;
      return;
    }
  }

  final void a(String paramString)
  {
    this.b = paramString;
  }

  final void b(lh paramlh, i parami)
  {
    this.g = d(paramlh, parami);
  }

  final void b(String paramString)
  {
    this.c = paramString;
  }

  final void c(lh paramlh, i parami)
  {
    this.h = d(paramlh, parami);
  }

  final void c(String paramString)
  {
    this.d = paramString;
  }

  final void d(String paramString)
  {
    this.e = paramString;
  }

  final void e(String paramString)
  {
    this.i = paramString;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    NativeAdAssets localNativeAdAssets;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localNativeAdAssets = (NativeAdAssets)paramObject;
      if (this.a != null)
      {
        if (this.a.equals(localNativeAdAssets.a));
      }
      else
        while (localNativeAdAssets.a != null)
          return false;
      if (this.b != null)
      {
        if (this.b.equals(localNativeAdAssets.b));
      }
      else
        while (localNativeAdAssets.b != null)
          return false;
      if (this.c != null)
      {
        if (this.c.equals(localNativeAdAssets.c));
      }
      else
        while (localNativeAdAssets.c != null)
          return false;
      if (this.d != null)
      {
        if (this.d.equals(localNativeAdAssets.d));
      }
      else
        while (localNativeAdAssets.d != null)
          return false;
      if (this.e != null)
      {
        if (this.e.equals(localNativeAdAssets.e));
      }
      else
        while (localNativeAdAssets.e != null)
          return false;
      if (this.f != null)
      {
        if (this.f.equals(localNativeAdAssets.f));
      }
      else
        while (localNativeAdAssets.f != null)
          return false;
      if (this.g != null)
      {
        if (this.g.equals(localNativeAdAssets.g));
      }
      else
        while (localNativeAdAssets.g != null)
          return false;
      if (this.h != null)
      {
        if (this.h.equals(localNativeAdAssets.h));
      }
      else
        while (localNativeAdAssets.h != null)
          return false;
      if (this.i != null)
      {
        if (this.i.equals(localNativeAdAssets.i));
      }
      else
        while (localNativeAdAssets.i != null)
          return false;
      if (this.j != null)
      {
        if (this.j.equals(localNativeAdAssets.j));
      }
      else
        while (localNativeAdAssets.j != null)
          return false;
      if (this.k != null)
      {
        if (this.k.equals(localNativeAdAssets.k));
      }
      else
        while (localNativeAdAssets.k != null)
          return false;
      if (this.l != null)
      {
        if (this.l.equals(localNativeAdAssets.l));
      }
      else
        while (localNativeAdAssets.l != null)
          return false;
      if (this.m != null)
      {
        if (this.m.equals(localNativeAdAssets.m));
      }
      else
        while (localNativeAdAssets.m != null)
          return false;
      if (this.n != null)
        return this.n.equals(localNativeAdAssets.n);
    }
    while (localNativeAdAssets.n == null);
    return false;
  }

  final void f(String paramString)
  {
    if (paramString != null);
    try
    {
      this.j = Float.valueOf(Float.parseFloat(paramString));
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      String.format("Could not parse rating value. Rating value is %s", new Object[] { paramString });
    }
  }

  final void g(String paramString)
  {
    this.k = paramString;
  }

  public String getAge()
  {
    return this.b;
  }

  public String getBody()
  {
    return this.c;
  }

  public String getCallToAction()
  {
    return this.d;
  }

  public String getDomain()
  {
    return this.e;
  }

  public NativeAdImage getFavicon()
  {
    return this.f;
  }

  public NativeAdImage getIcon()
  {
    return this.g;
  }

  public NativeAdImage getImage()
  {
    return this.h;
  }

  public NativeAdMedia getMedia()
  {
    return this.a;
  }

  public String getPrice()
  {
    return this.i;
  }

  public Float getRating()
  {
    return this.j;
  }

  public String getReviewCount()
  {
    return this.k;
  }

  public String getSponsored()
  {
    return this.l;
  }

  public String getTitle()
  {
    return this.m;
  }

  public String getWarning()
  {
    return this.n;
  }

  final void h(String paramString)
  {
    this.l = paramString;
  }

  public int hashCode()
  {
    int i1;
    int i3;
    label35: int i5;
    label59: int i7;
    label85: int i9;
    label111: int i11;
    label137: int i13;
    label163: int i15;
    label189: int i17;
    label215: int i19;
    label241: int i21;
    label267: int i23;
    label293: int i24;
    if (this.a != null)
    {
      i1 = this.a.hashCode();
      int i2 = i1 * 31;
      if (this.b == null)
        break label363;
      i3 = this.b.hashCode();
      int i4 = 31 * (i3 + i2);
      if (this.c == null)
        break label368;
      i5 = this.c.hashCode();
      int i6 = 31 * (i5 + i4);
      if (this.d == null)
        break label374;
      i7 = this.d.hashCode();
      int i8 = 31 * (i7 + i6);
      if (this.e == null)
        break label380;
      i9 = this.e.hashCode();
      int i10 = 31 * (i9 + i8);
      if (this.f == null)
        break label386;
      i11 = this.f.hashCode();
      int i12 = 31 * (i11 + i10);
      if (this.g == null)
        break label392;
      i13 = this.g.hashCode();
      int i14 = 31 * (i13 + i12);
      if (this.h == null)
        break label398;
      i15 = this.h.hashCode();
      int i16 = 31 * (i15 + i14);
      if (this.i == null)
        break label404;
      i17 = this.i.hashCode();
      int i18 = 31 * (i17 + i16);
      if (this.j == null)
        break label410;
      i19 = this.j.hashCode();
      int i20 = 31 * (i19 + i18);
      if (this.k == null)
        break label416;
      i21 = this.k.hashCode();
      int i22 = 31 * (i21 + i20);
      if (this.l == null)
        break label422;
      i23 = this.l.hashCode();
      i24 = 31 * (i23 + i22);
      if (this.m == null)
        break label428;
    }
    label386: label392: label398: label404: label410: label416: label422: label428: for (int i25 = this.m.hashCode(); ; i25 = 0)
    {
      int i26 = 31 * (i25 + i24);
      String str = this.n;
      int i27 = 0;
      if (str != null)
        i27 = this.n.hashCode();
      return i26 + i27;
      i1 = 0;
      break;
      label363: i3 = 0;
      break label35;
      label368: i5 = 0;
      break label59;
      label374: i7 = 0;
      break label85;
      label380: i9 = 0;
      break label111;
      i11 = 0;
      break label137;
      i13 = 0;
      break label163;
      i15 = 0;
      break label189;
      i17 = 0;
      break label215;
      i19 = 0;
      break label241;
      i21 = 0;
      break label267;
      i23 = 0;
      break label293;
    }
  }

  final void i(String paramString)
  {
    this.m = paramString;
  }

  final void j(String paramString)
  {
    this.n = paramString;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.NativeAdAssets
 * JD-Core Version:    0.6.2
 */