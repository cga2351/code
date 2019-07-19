package com.yandex.mobile.ads.nativeads;

public final class NativeAdMedia
{
  private final float a;

  NativeAdMedia(float paramFloat)
  {
    this.a = paramFloat;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
    }
    while (Float.compare(((NativeAdMedia)paramObject).a, this.a) == 0);
    return false;
  }

  public final float getAspectRatio()
  {
    return this.a;
  }

  public final int hashCode()
  {
    if (this.a != 0.0F)
      return Float.floatToIntBits(this.a);
    return 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.NativeAdMedia
 * JD-Core Version:    0.6.2
 */