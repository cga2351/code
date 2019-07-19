package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.g.ag;

public final class TextInformationFrame extends Id3Frame
{
  public static final Parcelable.Creator<TextInformationFrame> CREATOR = new Parcelable.Creator()
  {
    public TextInformationFrame a(Parcel paramAnonymousParcel)
    {
      return new TextInformationFrame(paramAnonymousParcel);
    }

    public TextInformationFrame[] a(int paramAnonymousInt)
    {
      return new TextInformationFrame[paramAnonymousInt];
    }
  };
  public final String description;
  public final String value;

  TextInformationFrame(Parcel paramParcel)
  {
    super((String)ag.a(paramParcel.readString()));
    this.description = paramParcel.readString();
    this.value = ((String)ag.a(paramParcel.readString()));
  }

  public TextInformationFrame(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1);
    this.description = paramString2;
    this.value = paramString3;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    TextInformationFrame localTextInformationFrame;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localTextInformationFrame = (TextInformationFrame)paramObject;
    }
    while ((this.id.equals(localTextInformationFrame.id)) && (ag.a(this.description, localTextInformationFrame.description)) && (ag.a(this.value, localTextInformationFrame.value)));
    return false;
  }

  public int hashCode()
  {
    int i = 31 * (527 + this.id.hashCode());
    if (this.description != null);
    for (int j = this.description.hashCode(); ; j = 0)
    {
      int k = 31 * (j + i);
      String str = this.value;
      int m = 0;
      if (str != null)
        m = this.value.hashCode();
      return k + m;
    }
  }

  public String toString()
  {
    return this.id + ": value=" + this.value;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.description);
    paramParcel.writeString(this.value);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.TextInformationFrame
 * JD-Core Version:    0.6.2
 */