package com.yandex.mobile.ads.nativeads.template.appearance;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class ButtonAppearance
  implements Parcelable
{
  public static final Parcelable.Creator<ButtonAppearance> CREATOR = new Parcelable.Creator()
  {
  };
  private final int a;
  private final float b;
  private final int c;
  private final int d;
  private final TextAppearance e;

  protected ButtonAppearance(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readFloat();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = ((TextAppearance)paramParcel.readParcelable(TextAppearance.class.getClassLoader()));
  }

  private ButtonAppearance(Builder paramBuilder)
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
    ButtonAppearance localButtonAppearance;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localButtonAppearance = (ButtonAppearance)paramObject;
      if (this.a != localButtonAppearance.a)
        return false;
      if (Float.compare(localButtonAppearance.b, this.b) != 0)
        return false;
      if (this.c != localButtonAppearance.c)
        return false;
      if (this.d != localButtonAppearance.d)
        return false;
      if (this.e == null)
        break;
    }
    while (this.e.equals(localButtonAppearance.e));
    while (localButtonAppearance.e != null)
      return false;
    return true;
  }

  public final int getBorderColor()
  {
    return this.a;
  }

  public final float getBorderWidth()
  {
    return this.b;
  }

  public final int getNormalColor()
  {
    return this.c;
  }

  public final int getPressedColor()
  {
    return this.d;
  }

  public final TextAppearance getTextAppearance()
  {
    return this.e;
  }

  public final int hashCode()
  {
    int i = 31 * this.a;
    if (this.b != 0.0F);
    for (int j = Float.floatToIntBits(this.b); ; j = 0)
    {
      int k = 31 * (31 * (31 * (j + i) + this.c) + this.d);
      TextAppearance localTextAppearance = this.e;
      int m = 0;
      if (localTextAppearance != null)
        m = this.e.hashCode();
      return k + m;
    }
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeFloat(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeParcelable(this.e, 0);
  }

  public static final class Builder
  {
    private int a;
    private float b;
    private int c;
    private int d;
    private TextAppearance e;

    public final ButtonAppearance build()
    {
      return new ButtonAppearance(this, (byte)0);
    }

    public final Builder setBorderColor(int paramInt)
    {
      this.a = paramInt;
      return this;
    }

    public final Builder setBorderWidth(float paramFloat)
    {
      this.b = paramFloat;
      return this;
    }

    public final Builder setNormalColor(int paramInt)
    {
      this.c = paramInt;
      return this;
    }

    public final Builder setPressedColor(int paramInt)
    {
      this.d = paramInt;
      return this;
    }

    public final Builder setTextAppearance(TextAppearance paramTextAppearance)
    {
      this.e = paramTextAppearance;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.template.appearance.ButtonAppearance
 * JD-Core Version:    0.6.2
 */