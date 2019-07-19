package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.g.ag;

public final class InternalFrame extends Id3Frame
{
  public static final Parcelable.Creator<InternalFrame> CREATOR = new Parcelable.Creator()
  {
    public InternalFrame a(Parcel paramAnonymousParcel)
    {
      return new InternalFrame(paramAnonymousParcel);
    }

    public InternalFrame[] a(int paramAnonymousInt)
    {
      return new InternalFrame[paramAnonymousInt];
    }
  };
  public static final String ID = "----";
  public final String description;
  public final String domain;
  public final String text;

  InternalFrame(Parcel paramParcel)
  {
    super("----");
    this.domain = ((String)ag.a(paramParcel.readString()));
    this.description = ((String)ag.a(paramParcel.readString()));
    this.text = ((String)ag.a(paramParcel.readString()));
  }

  public InternalFrame(String paramString1, String paramString2, String paramString3)
  {
    super("----");
    this.domain = paramString1;
    this.description = paramString2;
    this.text = paramString3;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    InternalFrame localInternalFrame;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localInternalFrame = (InternalFrame)paramObject;
    }
    while ((ag.a(this.description, localInternalFrame.description)) && (ag.a(this.domain, localInternalFrame.domain)) && (ag.a(this.text, localInternalFrame.text)));
    return false;
  }

  public int hashCode()
  {
    int i;
    int j;
    if (this.domain != null)
    {
      i = this.domain.hashCode();
      j = 31 * (i + 527);
      if (this.description == null)
        break label81;
    }
    label81: for (int k = this.description.hashCode(); ; k = 0)
    {
      int m = 31 * (k + j);
      String str = this.text;
      int n = 0;
      if (str != null)
        n = this.text.hashCode();
      return m + n;
      i = 0;
      break;
    }
  }

  public String toString()
  {
    return this.id + ": domain=" + this.domain + ", description=" + this.description;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.domain);
    paramParcel.writeString(this.text);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.InternalFrame
 * JD-Core Version:    0.6.2
 */