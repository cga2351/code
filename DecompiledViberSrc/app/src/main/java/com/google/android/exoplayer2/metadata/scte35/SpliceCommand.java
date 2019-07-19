package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.metadata.Metadata.Entry;

public abstract class SpliceCommand
  implements Metadata.Entry
{
  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return "SCTE-35 splice command: type=" + getClass().getSimpleName();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.SpliceCommand
 * JD-Core Version:    0.6.2
 */