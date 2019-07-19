package com.yandex.mobile.ads.nativeads.template.appearance;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class TextAppearance
  implements Parcelable
{
  public static final Parcelable.Creator<TextAppearance> CREATOR = new Parcelable.Creator()
  {
  };
  private final int a;
  private final float b;
  private final String c;
  private final int d;

  protected TextAppearance(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readFloat();
    this.c = paramParcel.readString();
    this.d = paramParcel.readInt();
  }

  private TextAppearance(Builder paramBuilder)
  {
    this.a = Builder.a(paramBuilder);
    this.b = Builder.b(paramBuilder);
    this.c = Builder.c(paramBuilder);
    this.d = Builder.d(paramBuilder);
  }

  public final int describeContents()
  {
    return 0;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    TextAppearance localTextAppearance;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localTextAppearance = (TextAppearance)paramObject;
      if (this.a != localTextAppearance.a)
        return false;
      if (Float.compare(localTextAppearance.b, this.b) != 0)
        return false;
      if (this.d != localTextAppearance.d)
        return false;
      if (this.c == null)
        break;
    }
    while (this.c.equals(localTextAppearance.c));
    while (localTextAppearance.c != null)
      return false;
    return true;
  }

  public final String getFontFamilyName()
  {
    return this.c;
  }

  public final int getFontStyle()
  {
    return this.d;
  }

  public final int getTextColor()
  {
    return this.a;
  }

  public final float getTextSize()
  {
    return this.b;
  }

  public final int hashCode()
  {
    int i = 31 * this.a;
    if (this.b != 0.0F);
    for (int j = Float.floatToIntBits(this.b); ; j = 0)
    {
      int k = 31 * (j + i);
      String str = this.c;
      int m = 0;
      if (str != null)
        m = this.c.hashCode();
      return 31 * (k + m) + this.d;
    }
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeFloat(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeInt(this.d);
  }

  public static final class Builder
  {
    private int a;
    private float b;
    private String c;
    private int d;

    public final TextAppearance build()
    {
      return new TextAppearance(this, (byte)0);
    }

    public final Builder setFontFamilyName(String paramString)
    {
      this.c = paramString;
      return this;
    }

    public final Builder setFontStyle(int paramInt)
    {
      this.d = paramInt;
      return this;
    }

    public final Builder setTextColor(int paramInt)
    {
      this.a = paramInt;
      return this;
    }

    public final Builder setTextSize(float paramFloat)
    {
      this.b = paramFloat;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.template.appearance.TextAppearance
 * JD-Core Version:    0.6.2
 */