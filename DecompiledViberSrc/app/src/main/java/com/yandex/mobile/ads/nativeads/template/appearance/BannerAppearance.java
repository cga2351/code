package com.yandex.mobile.ads.nativeads.template.appearance;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.yandex.mobile.ads.nativeads.template.HorizontalOffset;

public final class BannerAppearance
  implements Parcelable
{
  public static final Parcelable.Creator<BannerAppearance> CREATOR = new Parcelable.Creator()
  {
  };
  private final int a;
  private final int b;
  private final float c;
  private final HorizontalOffset d;
  private final HorizontalOffset e;

  protected BannerAppearance(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readFloat();
    this.d = ((HorizontalOffset)paramParcel.readParcelable(HorizontalOffset.class.getClassLoader()));
    this.e = ((HorizontalOffset)paramParcel.readParcelable(HorizontalOffset.class.getClassLoader()));
  }

  private BannerAppearance(Builder paramBuilder)
  {
    this.a = Builder.a(paramBuilder);
    this.b = Builder.b(paramBuilder);
    this.c = Builder.c(paramBuilder);
    this.d = Builder.d(paramBuilder);
    this.e = Builder.e(paramBuilder);
  }

  public final int describeContents()
  {
    return 0;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    BannerAppearance localBannerAppearance;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localBannerAppearance = (BannerAppearance)paramObject;
      if (this.a != localBannerAppearance.a)
        return false;
      if (this.b != localBannerAppearance.b)
        return false;
      if (Float.compare(localBannerAppearance.c, this.c) != 0)
        return false;
      if (this.d != null)
      {
        if (this.d.equals(localBannerAppearance.d));
      }
      else
        while (localBannerAppearance.d != null)
          return false;
      if (this.e == null)
        break;
    }
    while (this.e.equals(localBannerAppearance.e));
    while (true)
    {
      return false;
      if (localBannerAppearance.e == null)
        break;
    }
  }

  public final int getBackgroundColor()
  {
    return this.a;
  }

  public final int getBorderColor()
  {
    return this.b;
  }

  public final float getBorderWidth()
  {
    return this.c;
  }

  public final HorizontalOffset getContentPadding()
  {
    return this.d;
  }

  public final HorizontalOffset getImageMargins()
  {
    return this.e;
  }

  public final int hashCode()
  {
    int i = 31 * (31 * this.a + this.b);
    int j;
    int k;
    if (this.c != 0.0F)
    {
      j = Float.floatToIntBits(this.c);
      k = 31 * (j + i);
      if (this.d == null)
        break label99;
    }
    label99: for (int m = this.d.hashCode(); ; m = 0)
    {
      int n = 31 * (m + k);
      HorizontalOffset localHorizontalOffset = this.e;
      int i1 = 0;
      if (localHorizontalOffset != null)
        i1 = this.e.hashCode();
      return n + i1;
      j = 0;
      break;
    }
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeFloat(this.c);
    paramParcel.writeParcelable(this.d, 0);
    paramParcel.writeParcelable(this.e, 0);
  }

  public static final class Builder
  {
    private int a;
    private int b;
    private float c;
    private HorizontalOffset d;
    private HorizontalOffset e;

    public final BannerAppearance build()
    {
      return new BannerAppearance(this, (byte)0);
    }

    public final Builder setBackgroundColor(int paramInt)
    {
      this.a = paramInt;
      return this;
    }

    public final Builder setBorderColor(int paramInt)
    {
      this.b = paramInt;
      return this;
    }

    public final Builder setBorderWidth(float paramFloat)
    {
      this.c = paramFloat;
      return this;
    }

    public final Builder setContentPadding(HorizontalOffset paramHorizontalOffset)
    {
      this.d = paramHorizontalOffset;
      return this;
    }

    public final Builder setImageMargins(HorizontalOffset paramHorizontalOffset)
    {
      this.e = paramHorizontalOffset;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.template.appearance.BannerAppearance
 * JD-Core Version:    0.6.2
 */