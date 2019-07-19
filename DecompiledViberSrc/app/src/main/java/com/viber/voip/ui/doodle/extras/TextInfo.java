package com.viber.voip.ui.doodle.extras;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.viber.voip.ui.doodle.objects.BaseObject.a;
import com.viber.voip.util.da;

public class TextInfo
  implements Parcelable, e.a
{
  private static final long CONSTANT_CONTENT_SIZE_IN_BYTES = i.b + i.a;
  public static final Parcelable.Creator<TextInfo> CREATOR = new Parcelable.Creator()
  {
    public TextInfo a(Parcel paramAnonymousParcel)
    {
      return new TextInfo(paramAnonymousParcel, null);
    }

    public TextInfo[] a(int paramAnonymousInt)
    {
      return new TextInfo[paramAnonymousInt];
    }
  };
  private int mColor;
  private final long mId;
  private CharSequence mText;

  public TextInfo(long paramLong, CharSequence paramCharSequence, int paramInt)
  {
    this.mId = paramLong;
    this.mText = paramCharSequence;
    this.mColor = paramInt;
  }

  private TextInfo(Parcel paramParcel)
  {
    this.mId = paramParcel.readLong();
    this.mText = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.mColor = paramParcel.readInt();
  }

  public TextInfo(CharSequence paramCharSequence, int paramInt)
  {
    this(-1L, paramCharSequence, paramInt);
  }

  public int describeContents()
  {
    return 0;
  }

  public long geId()
  {
    return this.mId;
  }

  public int getColor()
  {
    return this.mColor;
  }

  public long getSavedStateSizeInBytes()
  {
    return CONSTANT_CONTENT_SIZE_IN_BYTES + i.a(this.mText);
  }

  public CharSequence getText()
  {
    return this.mText;
  }

  public BaseObject.a getType()
  {
    return BaseObject.a.c;
  }

  public void setColor(int paramInt)
  {
    this.mColor = paramInt;
  }

  public void setText(CharSequence paramCharSequence)
  {
    this.mText = paramCharSequence;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("TextInfo{mId=").append(this.mId).append(", mText=");
    if (this.mText == null);
    for (String str = ""; ; str = da.b(this.mText.toString()))
      return str + ", mColor=" + this.mColor + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.mId);
    TextUtils.writeToParcel(this.mText, paramParcel, paramInt);
    paramParcel.writeInt(this.mColor);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.extras.TextInfo
 * JD-Core Version:    0.6.2
 */