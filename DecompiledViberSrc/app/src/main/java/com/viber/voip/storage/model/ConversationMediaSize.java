package com.viber.voip.storage.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.c;
import com.google.d.f;
import com.viber.voip.storage.repository.MediaFileType;
import com.viber.voip.util.da;

public class ConversationMediaSize
  implements Parcelable
{
  public static final Parcelable.Creator<ConversationMediaSize> CREATOR = new Parcelable.Creator()
  {
    public ConversationMediaSize a(Parcel paramAnonymousParcel)
    {
      return new ConversationMediaSize(paramAnonymousParcel);
    }

    public ConversationMediaSize[] a(int paramAnonymousInt)
    {
      return new ConversationMediaSize[paramAnonymousInt];
    }
  };

  @c(a="a_ptt")
  private long mAudioPttBytes = -1L;

  @c(a="gifs")
  private long mGifsBytes = -1L;

  @c(a="picts")
  private long mPicturesBytes = -1L;
  private transient long mSummarySizeBytes = -1L;

  @c(a="v_ptt")
  private long mVideoPttBytes = -1L;

  @c(a="videos")
  private long mVideosBytes = -1L;

  private ConversationMediaSize()
  {
  }

  private ConversationMediaSize(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    this.mPicturesBytes = paramLong1;
    this.mVideosBytes = paramLong2;
    this.mGifsBytes = paramLong3;
    this.mAudioPttBytes = paramLong4;
    this.mVideoPttBytes = paramLong5;
    updateSummarySize();
  }

  protected ConversationMediaSize(Parcel paramParcel)
  {
    this.mPicturesBytes = paramParcel.readLong();
    this.mVideosBytes = paramParcel.readLong();
    this.mGifsBytes = paramParcel.readLong();
    this.mAudioPttBytes = paramParcel.readLong();
    this.mVideoPttBytes = paramParcel.readLong();
    updateSummarySize();
  }

  public static ConversationMediaSize createFromJson(f paramf, String paramString)
  {
    boolean bool = da.a(paramString);
    ConversationMediaSize localConversationMediaSize = null;
    if (!bool)
      localConversationMediaSize = (ConversationMediaSize)paramf.a(paramString, ConversationMediaSize.class);
    if (localConversationMediaSize == null)
      localConversationMediaSize = new ConversationMediaSize();
    localConversationMediaSize.updateSummarySize();
    return localConversationMediaSize;
  }

  private void updateSummarySize()
  {
    int i = 1;
    long l = 0L;
    boolean bool = this.mPicturesBytes < -1L;
    int j = 0;
    if (bool)
    {
      l += this.mPicturesBytes;
      j = i;
    }
    if (this.mVideosBytes != -1L)
    {
      l += this.mVideosBytes;
      j = i;
    }
    if (this.mGifsBytes != -1L)
    {
      l += this.mGifsBytes;
      j = i;
    }
    if (this.mAudioPttBytes != -1L)
    {
      l += this.mAudioPttBytes;
      j = i;
    }
    if (this.mVideoPttBytes != -1L)
      l += this.mVideoPttBytes;
    while (true)
    {
      if (i != 0);
      while (true)
      {
        this.mSummarySizeBytes = l;
        return;
        l = -1L;
      }
      i = j;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public long getMediaTypeSizeBytes(MediaFileType paramMediaFileType)
  {
    switch (2.a[paramMediaFileType.ordinal()])
    {
    default:
      return -1L;
    case 1:
      return this.mPicturesBytes;
    case 2:
      return this.mVideosBytes;
    case 3:
      return this.mGifsBytes;
    case 4:
      return this.mVideoPttBytes;
    case 5:
    }
    return this.mAudioPttBytes;
  }

  public long getSummarySizeBytes()
  {
    return this.mSummarySizeBytes;
  }

  public boolean hasSummarySize()
  {
    return this.mSummarySizeBytes != -1L;
  }

  public String toString()
  {
    return "ConversationMediaSize{mSummarySizeBytes=" + this.mSummarySizeBytes + " : mPicturesBytes=" + this.mPicturesBytes + ", mVideosBytes=" + this.mVideosBytes + ", mGifsBytes=" + this.mGifsBytes + ", mAudioPttBytes=" + this.mAudioPttBytes + ", mVideoPttBytes=" + this.mVideoPttBytes + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.mPicturesBytes);
    paramParcel.writeLong(this.mVideosBytes);
    paramParcel.writeLong(this.mGifsBytes);
    paramParcel.writeLong(this.mAudioPttBytes);
    paramParcel.writeLong(this.mVideoPttBytes);
  }

  public static final class a
  {
    private long a = -1L;
    private long b = -1L;
    private long c = -1L;
    private long d = -1L;
    private long e = -1L;

    public a()
    {
    }

    public a(ConversationMediaSize paramConversationMediaSize)
    {
      this.a = paramConversationMediaSize.mPicturesBytes;
      this.b = paramConversationMediaSize.mVideosBytes;
      this.c = paramConversationMediaSize.mGifsBytes;
      this.d = paramConversationMediaSize.mAudioPttBytes;
      this.e = paramConversationMediaSize.mVideoPttBytes;
    }

    private long a(long paramLong)
    {
      return Math.max(0L, paramLong);
    }

    private long a(long paramLong1, long paramLong2)
    {
      if (paramLong1 == -1L)
        return paramLong2;
      return paramLong2 + paramLong1;
    }

    private void b(MediaFileType paramMediaFileType, long paramLong)
    {
      switch (ConversationMediaSize.2.a[paramMediaFileType.ordinal()])
      {
      default:
        return;
      case 1:
        this.a = paramLong;
        return;
      case 2:
        this.b = paramLong;
        return;
      case 3:
        this.c = paramLong;
        return;
      case 4:
        this.e = paramLong;
        return;
      case 5:
      }
      this.d = paramLong;
    }

    public ConversationMediaSize a()
    {
      return new ConversationMediaSize(a(this.a), a(this.b), a(this.c), a(this.d), a(this.e), null);
    }

    public void a(MediaFileType paramMediaFileType, long paramLong)
    {
      switch (ConversationMediaSize.2.a[paramMediaFileType.ordinal()])
      {
      default:
        return;
      case 1:
        this.a = a(this.a, paramLong);
        return;
      case 2:
        this.b = a(this.b, paramLong);
        return;
      case 3:
        this.c = a(this.c, paramLong);
        return;
      case 4:
        this.e = a(this.e, paramLong);
        return;
      case 5:
      }
      this.d = a(this.d, paramLong);
    }

    public void a(MediaFileType[] paramArrayOfMediaFileType)
    {
      int i = paramArrayOfMediaFileType.length;
      for (int j = 0; j < i; j++)
        b(paramArrayOfMediaFileType[j], 0L);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.model.ConversationMediaSize
 * JD-Core Version:    0.6.2
 */