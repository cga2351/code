package com.yandex.mobile.ads.nativeads.template;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class SizeConstraint
  implements Parcelable
{
  public static final Parcelable.Creator<SizeConstraint> CREATOR = new Parcelable.Creator()
  {
  };
  private final float a;
  private final SizeConstraintType b;

  protected SizeConstraint(Parcel paramParcel)
  {
    this.a = paramParcel.readFloat();
    int i = paramParcel.readInt();
    if (i == -1);
    for (SizeConstraintType localSizeConstraintType = null; ; localSizeConstraintType = SizeConstraintType.values()[i])
    {
      this.b = localSizeConstraintType;
      return;
    }
  }

  public SizeConstraint(SizeConstraintType paramSizeConstraintType, float paramFloat)
  {
    this.b = paramSizeConstraintType;
    this.a = paramFloat;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    SizeConstraint localSizeConstraint;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localSizeConstraint = (SizeConstraint)paramObject;
      if (Float.compare(localSizeConstraint.a, this.a) != 0)
        return false;
    }
    while (this.b == localSizeConstraint.b);
    return false;
  }

  public final SizeConstraintType getSizeConstraintType()
  {
    return this.b;
  }

  public final float getValue()
  {
    return this.a;
  }

  public final int hashCode()
  {
    if (this.a != 0.0F);
    for (int i = Float.floatToIntBits(this.a); ; i = 0)
    {
      int j = i * 31;
      SizeConstraintType localSizeConstraintType = this.b;
      int k = 0;
      if (localSizeConstraintType != null)
        k = this.b.hashCode();
      return j + k;
    }
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeFloat(this.a);
    if (this.b == null);
    for (int i = -1; ; i = this.b.ordinal())
    {
      paramParcel.writeInt(i);
      return;
    }
  }

  public static enum SizeConstraintType
  {
    static
    {
      SizeConstraintType[] arrayOfSizeConstraintType = new SizeConstraintType[3];
      arrayOfSizeConstraintType[0] = FIXED;
      arrayOfSizeConstraintType[1] = FIXED_RATIO;
      arrayOfSizeConstraintType[2] = PREFERRED_RATIO;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.template.SizeConstraint
 * JD-Core Version:    0.6.2
 */