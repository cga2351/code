package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.g.ag;
import java.util.Arrays;

public final class ChapterTocFrame extends Id3Frame
{
  public static final Parcelable.Creator<ChapterTocFrame> CREATOR = new Parcelable.Creator()
  {
    public ChapterTocFrame a(Parcel paramAnonymousParcel)
    {
      return new ChapterTocFrame(paramAnonymousParcel);
    }

    public ChapterTocFrame[] a(int paramAnonymousInt)
    {
      return new ChapterTocFrame[paramAnonymousInt];
    }
  };
  public static final String ID = "CTOC";
  public final String[] children;
  public final String elementId;
  public final boolean isOrdered;
  public final boolean isRoot;
  private final Id3Frame[] subFrames;

  ChapterTocFrame(Parcel paramParcel)
  {
    super("CTOC");
    this.elementId = ((String)ag.a(paramParcel.readString()));
    boolean bool2;
    if (paramParcel.readByte() != 0)
    {
      bool2 = bool1;
      this.isRoot = bool2;
      if (paramParcel.readByte() == 0)
        break label111;
    }
    while (true)
    {
      this.isOrdered = bool1;
      this.children = paramParcel.createStringArray();
      int j = paramParcel.readInt();
      this.subFrames = new Id3Frame[j];
      while (i < j)
      {
        this.subFrames[i] = ((Id3Frame)paramParcel.readParcelable(Id3Frame.class.getClassLoader()));
        i++;
      }
      bool2 = false;
      break;
      label111: bool1 = false;
    }
  }

  public ChapterTocFrame(String paramString, boolean paramBoolean1, boolean paramBoolean2, String[] paramArrayOfString, Id3Frame[] paramArrayOfId3Frame)
  {
    super("CTOC");
    this.elementId = paramString;
    this.isRoot = paramBoolean1;
    this.isOrdered = paramBoolean2;
    this.children = paramArrayOfString;
    this.subFrames = paramArrayOfId3Frame;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    ChapterTocFrame localChapterTocFrame;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localChapterTocFrame = (ChapterTocFrame)paramObject;
    }
    while ((this.isRoot == localChapterTocFrame.isRoot) && (this.isOrdered == localChapterTocFrame.isOrdered) && (ag.a(this.elementId, localChapterTocFrame.elementId)) && (Arrays.equals(this.children, localChapterTocFrame.children)) && (Arrays.equals(this.subFrames, localChapterTocFrame.subFrames)));
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
    int i = 1;
    int j;
    int k;
    if (this.isRoot)
    {
      j = i;
      k = 31 * (j + 527);
      if (!this.isOrdered)
        break label69;
    }
    while (true)
    {
      int m = 31 * (k + i);
      String str = this.elementId;
      int n = 0;
      if (str != null)
        n = this.elementId.hashCode();
      return m + n;
      j = 0;
      break;
      label69: i = 0;
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.elementId);
    int j;
    if (this.isRoot)
    {
      j = i;
      paramParcel.writeByte((byte)j);
      if (!this.isOrdered)
        break label100;
    }
    while (true)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeStringArray(this.children);
      paramParcel.writeInt(this.subFrames.length);
      Id3Frame[] arrayOfId3Frame = this.subFrames;
      int k = arrayOfId3Frame.length;
      for (int m = 0; m < k; m++)
        paramParcel.writeParcelable(arrayOfId3Frame[m], 0);
      j = 0;
      break;
      label100: i = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.ChapterTocFrame
 * JD-Core Version:    0.6.2
 */