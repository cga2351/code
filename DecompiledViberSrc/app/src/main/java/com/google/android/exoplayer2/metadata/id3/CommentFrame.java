package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.g.ag;

public final class CommentFrame extends Id3Frame
{
  public static final Parcelable.Creator<CommentFrame> CREATOR = new Parcelable.Creator()
  {
    public CommentFrame a(Parcel paramAnonymousParcel)
    {
      return new CommentFrame(paramAnonymousParcel);
    }

    public CommentFrame[] a(int paramAnonymousInt)
    {
      return new CommentFrame[paramAnonymousInt];
    }
  };
  public static final String ID = "COMM";
  public final String description;
  public final String language;
  public final String text;

  CommentFrame(Parcel paramParcel)
  {
    super("COMM");
    this.language = ((String)ag.a(paramParcel.readString()));
    this.description = ((String)ag.a(paramParcel.readString()));
    this.text = ((String)ag.a(paramParcel.readString()));
  }

  public CommentFrame(String paramString1, String paramString2, String paramString3)
  {
    super("COMM");
    this.language = paramString1;
    this.description = paramString2;
    this.text = paramString3;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    CommentFrame localCommentFrame;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localCommentFrame = (CommentFrame)paramObject;
    }
    while ((ag.a(this.description, localCommentFrame.description)) && (ag.a(this.language, localCommentFrame.language)) && (ag.a(this.text, localCommentFrame.text)));
    return false;
  }

  public int hashCode()
  {
    int i;
    int j;
    if (this.language != null)
    {
      i = this.language.hashCode();
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
    return this.id + ": language=" + this.language + ", description=" + this.description;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.language);
    paramParcel.writeString(this.text);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.CommentFrame
 * JD-Core Version:    0.6.2
 */