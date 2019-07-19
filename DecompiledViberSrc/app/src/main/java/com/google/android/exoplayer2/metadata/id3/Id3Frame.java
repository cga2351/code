package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.metadata.Metadata.Entry;

public abstract class Id3Frame
  implements Metadata.Entry
{
  public final String id;

  public Id3Frame(String paramString)
  {
    this.id = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return this.id;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.Id3Frame
 * JD-Core Version:    0.6.2
 */