package com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.b;
import com.google.d.a.c;

public class Frame
  implements Parcelable
{
  public static final Parcelable.Creator<Frame> CREATOR = new Parcelable.Creator()
  {
    public Frame a(Parcel paramAnonymousParcel)
    {
      return new Frame(paramAnonymousParcel);
    }

    public Frame[] a(int paramAnonymousInt)
    {
      return new Frame[paramAnonymousInt];
    }
  };
  public static final Integer DEFAULT_BORDER_COLOR = Integer.valueOf(-16777216);
  public static final Integer DEFAULT_BORDER_WIDTH = Integer.valueOf(1);

  @b(a="Lcom/viber/voip/flatbuffers/c/h;")
  @c(a="BorderColor")
  private Integer mBorderColor;

  @c(a="BorderWidth")
  private Integer mBorderWidth;

  @c(a="CornerRadius")
  private int mCornerRadius;

  public Frame()
  {
  }

  protected Frame(Parcel paramParcel)
  {
    this.mBorderWidth = Integer.valueOf(paramParcel.readInt());
    this.mBorderColor = Integer.valueOf(paramParcel.readInt());
    if (this.mBorderColor.intValue() == -2147483648)
      this.mBorderColor = null;
    this.mCornerRadius = paramParcel.readInt();
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2;
    if (this == paramObject)
      bool2 = bool1;
    Frame localFrame;
    int i;
    int j;
    do
    {
      Integer localInteger1;
      Integer localInteger2;
      do
      {
        Class localClass1;
        Class localClass2;
        do
        {
          do
          {
            return bool2;
            bool2 = false;
          }
          while (paramObject == null);
          localClass1 = getClass();
          localClass2 = paramObject.getClass();
          bool2 = false;
        }
        while (localClass1 != localClass2);
        localFrame = (Frame)paramObject;
        localInteger1 = this.mBorderWidth;
        localInteger2 = localFrame.mBorderWidth;
        bool2 = false;
      }
      while (localInteger1 != localInteger2);
      i = this.mCornerRadius;
      j = localFrame.mCornerRadius;
      bool2 = false;
    }
    while (i != j);
    if (this.mBorderColor != null)
      bool1 = this.mBorderColor.equals(localFrame.mBorderColor);
    while (true)
    {
      return bool1;
      if (localFrame.mBorderColor != null)
        bool1 = false;
    }
  }

  public Integer getBorderColor()
  {
    if (this.mBorderColor == null)
      return DEFAULT_BORDER_COLOR;
    return this.mBorderColor;
  }

  public Integer getBorderWidth()
  {
    if (this.mBorderWidth == null)
      return DEFAULT_BORDER_WIDTH;
    return this.mBorderWidth;
  }

  public int getCornerRadius()
  {
    return this.mCornerRadius;
  }

  public int hashCode()
  {
    int i = 31 * this.mBorderWidth.intValue();
    if (this.mBorderColor != null);
    for (int j = this.mBorderColor.hashCode(); ; j = 0)
      return 31 * (j + i) + this.mCornerRadius;
  }

  public void setBorderColor(Integer paramInteger)
  {
    this.mBorderColor = paramInteger;
  }

  public void setBorderWidth(Integer paramInteger)
  {
    if (paramInteger.intValue() < 0)
      paramInteger = null;
    this.mBorderWidth = paramInteger;
  }

  public void setCornerRadius(int paramInt)
  {
    this.mCornerRadius = paramInt;
  }

  public String toString()
  {
    return "Frame{mBorderWidth=" + this.mBorderWidth + ", mBorderColor='" + this.mBorderColor + '\'' + ", mCornerRadius=" + this.mCornerRadius + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mBorderWidth.intValue());
    if (this.mBorderColor == null);
    for (int i = -2147483648; ; i = this.mBorderColor.intValue())
    {
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.mCornerRadius);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.Frame
 * JD-Core Version:    0.6.2
 */