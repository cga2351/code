package com.facebook.imagepipeline.image;

public class ImmutableQualityInfo
  implements QualityInfo
{
  public static final QualityInfo FULL_QUALITY = of(2147483647, true, true);
  boolean mIsOfFullQuality;
  boolean mIsOfGoodEnoughQuality;
  int mQuality;

  private ImmutableQualityInfo(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mQuality = paramInt;
    this.mIsOfGoodEnoughQuality = paramBoolean1;
    this.mIsOfFullQuality = paramBoolean2;
  }

  public static QualityInfo of(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return new ImmutableQualityInfo(paramInt, paramBoolean1, paramBoolean2);
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    ImmutableQualityInfo localImmutableQualityInfo;
    do
    {
      return true;
      if (!(paramObject instanceof ImmutableQualityInfo))
        return false;
      localImmutableQualityInfo = (ImmutableQualityInfo)paramObject;
    }
    while ((this.mQuality == localImmutableQualityInfo.mQuality) && (this.mIsOfGoodEnoughQuality == localImmutableQualityInfo.mIsOfGoodEnoughQuality) && (this.mIsOfFullQuality == localImmutableQualityInfo.mIsOfFullQuality));
    return false;
  }

  public int getQuality()
  {
    return this.mQuality;
  }

  public int hashCode()
  {
    int i = this.mQuality;
    if (this.mIsOfGoodEnoughQuality);
    for (int j = 4194304; ; j = 0)
    {
      int k = j ^ i;
      boolean bool = this.mIsOfFullQuality;
      int m = 0;
      if (bool)
        m = 8388608;
      return k ^ m;
    }
  }

  public boolean isOfFullQuality()
  {
    return this.mIsOfFullQuality;
  }

  public boolean isOfGoodEnoughQuality()
  {
    return this.mIsOfGoodEnoughQuality;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.image.ImmutableQualityInfo
 * JD-Core Version:    0.6.2
 */