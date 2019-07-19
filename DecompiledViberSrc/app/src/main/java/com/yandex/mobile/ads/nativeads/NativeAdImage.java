package com.yandex.mobile.ads.nativeads;

import android.graphics.Bitmap;

public final class NativeAdImage
{
  private Bitmap a;
  private String b;
  private int c;
  private int d;

  public final String a()
  {
    return this.b;
  }

  final void a(int paramInt)
  {
    this.c = paramInt;
  }

  final void a(Bitmap paramBitmap)
  {
    this.a = paramBitmap;
  }

  final void a(String paramString)
  {
    this.b = paramString;
  }

  final void b(int paramInt)
  {
    this.d = paramInt;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    NativeAdImage localNativeAdImage;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localNativeAdImage = (NativeAdImage)paramObject;
      if (this.c != localNativeAdImage.c)
        return false;
      if (this.d != localNativeAdImage.d)
        return false;
      if (this.a != null)
      {
        if (this.a.equals(localNativeAdImage.a));
      }
      else
        while (localNativeAdImage.a != null)
          return false;
      if (this.b == null)
        break;
    }
    while (this.b.equals(localNativeAdImage.b));
    while (true)
    {
      return false;
      if (localNativeAdImage.b == null)
        break;
    }
  }

  public final Bitmap getBitmap()
  {
    return this.a;
  }

  public final int getHeight()
  {
    return this.c;
  }

  public final int getWidth()
  {
    return this.d;
  }

  public final int hashCode()
  {
    if (this.a != null);
    for (int i = this.a.hashCode(); ; i = 0)
    {
      int j = i * 31;
      String str = this.b;
      int k = 0;
      if (str != null)
        k = this.b.hashCode();
      return 31 * (31 * (j + k) + this.c) + this.d;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.NativeAdImage
 * JD-Core Version:    0.6.2
 */