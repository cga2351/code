package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.g.ag;
import java.util.Arrays;

public final class ChapterFrame extends Id3Frame
{
  public static final Parcelable.Creator<ChapterFrame> CREATOR = new Parcelable.Creator()
  {
    public ChapterFrame a(Parcel paramAnonymousParcel)
    {
      return new ChapterFrame(paramAnonymousParcel);
    }

    public ChapterFrame[] a(int paramAnonymousInt)
    {
      return new ChapterFrame[paramAnonymousInt];
    }
  };
  public static final String ID = "CHAP";
  public final String chapterId;
  public final long endOffset;
  public final int endTimeMs;
  public final long startOffset;
  public final int startTimeMs;
  private final Id3Frame[] subFrames;

  ChapterFrame(Parcel paramParcel)
  {
    super("CHAP");
    this.chapterId = ((String)ag.a(paramParcel.readString()));
    this.startTimeMs = paramParcel.readInt();
    this.endTimeMs = paramParcel.readInt();
    this.startOffset = paramParcel.readLong();
    this.endOffset = paramParcel.readLong();
    int i = paramParcel.readInt();
    this.subFrames = new Id3Frame[i];
    for (int j = 0; j < i; j++)
      this.subFrames[j] = ((Id3Frame)paramParcel.readParcelable(Id3Frame.class.getClassLoader()));
  }

  public ChapterFrame(String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2, Id3Frame[] paramArrayOfId3Frame)
  {
    super("CHAP");
    this.chapterId = paramString;
    this.startTimeMs = paramInt1;
    this.endTimeMs = paramInt2;
    this.startOffset = paramLong1;
    this.endOffset = paramLong2;
    this.subFrames = paramArrayOfId3Frame;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    ChapterFrame localChapterFrame;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localChapterFrame = (ChapterFrame)paramObject;
    }
    while ((this.startTimeMs == localChapterFrame.startTimeMs) && (this.endTimeMs == localChapterFrame.endTimeMs) && (this.startOffset == localChapterFrame.startOffset) && (this.endOffset == localChapterFrame.endOffset) && (ag.a(this.chapterId, localChapterFrame.chapterId)) && (Arrays.equals(this.subFrames, localChapterFrame.subFrames)));
    return false;
  }

  public Id3Frame getSubFrame(int paramInt)
  {
    return this.subFrames[paramInt];
  }

  public int getSubFrameCount()
  {
    return this.subFrames.length;
  }

  public int hashCode()
  {
    int i = 31 * (31 * (31 * (31 * (527 + this.startTimeMs) + this.endTimeMs) + (int)this.startOffset) + (int)this.endOffset);
    if (this.chapterId != null);
    for (int j = this.chapterId.hashCode(); ; j = 0)
      return j + i;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.chapterId);
    paramParcel.writeInt(this.startTimeMs);
    paramParcel.writeInt(this.endTimeMs);
    paramParcel.writeLong(this.startOffset);
    paramParcel.writeLong(this.endOffset);
    paramParcel.writeInt(this.subFrames.length);
    Id3Frame[] arrayOfId3Frame = this.subFrames;
    int i = arrayOfId3Frame.length;
    for (int j = 0; j < i; j++)
      paramParcel.writeParcelable(arrayOfId3Frame[j], 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.ChapterFrame
 * JD-Core Version:    0.6.2
 */