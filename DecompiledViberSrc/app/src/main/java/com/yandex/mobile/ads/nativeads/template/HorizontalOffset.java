package com.yandex.mobile.ads.nativeads.template;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class HorizontalOffset
  implements Parcelable
{
  public static final Parcelable.Creator<HorizontalOffset> CREATOR = new Parcelable.Creator()
  {
  };
  private final float a;
  private final float b;

  public HorizontalOffset(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }

  protected HorizontalOffset(Parcel paramParcel)
  {
    this.a = paramParcel.readFloat();
    this.b = paramParcel.readFloat();
  }

  public final int describeContents()
  {
    return 0;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    HorizontalOffset localHorizontalOffset;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localHorizontalOffset = (HorizontalOffset)paramObject;
      if (Float.compare(localHorizontalOffset.a, this.a) != 0)
        return false;
    }
    while (Float.compare(localHorizontalOffset.b, this.b) == 0);
    return false;
  }

  public final float getLeft()
  {
    return this.a;
  }

  public final float getRight()
  {
    return this.b;
  }

  public final int hashCode()
  {
    if (this.a != 0.0F);
    for (int i = Float.floatToIntBits(this.a); ; i = 0)
    {
      int j = i * 31;
      boolean bool = this.b < 0.0F;
      int k = 0;
      if (bool)
        k = Float.floatToIntBits(this.b);
      return j + k;
    }
  }

  public final String toString()
  {
    return this.a + ", " + this.b;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeFloat(this.a);
    paramParcel.writeFloat(this.b);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.template.HorizontalOffset
 * JD-Core Version:    0.6.2
 */