package com.yandex.mobile.ads.nativeads.template.appearance;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class RatingAppearance
  implements Parcelable
{
  public static final Parcelable.Creator<RatingAppearance> CREATOR = new Parcelable.Creator()
  {
  };
  private final int a;
  private final int b;

  protected RatingAppearance(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
  }

  private RatingAppearance(Builder paramBuilder)
  {
    this.a = Builder.a(paramBuilder);
    this.b = Builder.b(paramBuilder);
  }

  public final int describeContents()
  {
    return 0;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    RatingAppearance localRatingAppearance;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localRatingAppearance = (RatingAppearance)paramObject;
      if (this.a != localRatingAppearance.a)
        return false;
    }
    while (this.b == localRatingAppearance.b);
    return false;
  }

  public final int getBackgroundStarColor()
  {
    return this.a;
  }

  public final int getProgressStarColor()
  {
    return this.b;
  }

  public final int hashCode()
  {
    return 31 * this.a + this.b;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
  }

  public static final class Builder
  {
    private int a;
    private int b;

    public final RatingAppearance build()
    {
      return new RatingAppearance(this, (byte)0);
    }

    public final Builder setBackgroundStarColor(int paramInt)
    {
      this.a = paramInt;
      return this;
    }

    public final Builder setProgressStarColor(int paramInt)
    {
      this.b = paramInt;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.template.appearance.RatingAppearance
 * JD-Core Version:    0.6.2
 */