package com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.c;

public class MediaPlayer
  implements Parcelable
{
  public static final Parcelable.Creator<MediaPlayer> CREATOR = new Parcelable.Creator()
  {
    public MediaPlayer a(Parcel paramAnonymousParcel)
    {
      return new MediaPlayer(paramAnonymousParcel);
    }

    public MediaPlayer[] a(int paramAnonymousInt)
    {
      return new MediaPlayer[paramAnonymousInt];
    }
  };

  @c(a="ActionReplyData")
  private String mActionReplyData;

  @c(a="Loop")
  private boolean mLoop;

  @c(a="Subtitle")
  private String mSubtitle;

  @c(a="ThumbnailURL")
  private String mThumbnailURL;

  @c(a="Title")
  private String mTitle;

  public MediaPlayer()
  {
  }

  protected MediaPlayer(Parcel paramParcel)
  {
    this.mTitle = paramParcel.readString();
    this.mSubtitle = paramParcel.readString();
    this.mThumbnailURL = paramParcel.readString();
    if (paramParcel.readByte() == i);
    while (true)
    {
      this.mLoop = i;
      this.mActionReplyData = paramParcel.readString();
      return;
      i = 0;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool3;
    if (this == paramObject)
      bool3 = bool1;
    MediaPlayer localMediaPlayer;
    label89: label118: boolean bool4;
    boolean bool5;
    do
    {
      boolean bool6;
      do
      {
        boolean bool7;
        do
        {
          boolean bool8;
          do
          {
            boolean bool2;
            do
            {
              return bool3;
              bool2 = paramObject instanceof MediaPlayer;
              bool3 = false;
            }
            while (!bool2);
            localMediaPlayer = (MediaPlayer)paramObject;
            if (getTitle() == null)
              break;
            bool8 = getTitle().equals(localMediaPlayer.getTitle());
            bool3 = false;
          }
          while (!bool8);
          if (getSubtitle() == null)
            break label173;
          bool7 = getSubtitle().equals(localMediaPlayer.getSubtitle());
          bool3 = false;
        }
        while (!bool7);
        if (getThumbnailURL() == null)
          break label183;
        bool6 = getThumbnailURL().equals(localMediaPlayer.getThumbnailURL());
        bool3 = false;
      }
      while (bool6);
      bool4 = isLoop();
      bool5 = localMediaPlayer.isLoop();
      bool3 = false;
    }
    while (bool4 != bool5);
    if (getActionReplyData() != null)
      bool1 = getActionReplyData().equals(localMediaPlayer.getActionReplyData());
    while (true)
    {
      return bool1;
      if (localMediaPlayer.getTitle() == null)
        break;
      return false;
      label173: if (localMediaPlayer.getSubtitle() == null)
        break label89;
      return false;
      label183: if (localMediaPlayer.getThumbnailURL() != null)
        break label118;
      return false;
      if (localMediaPlayer.getActionReplyData() != null)
        bool1 = false;
    }
  }

  public String getActionReplyData()
  {
    return this.mActionReplyData;
  }

  public String getSubtitle()
  {
    return this.mSubtitle;
  }

  public String getThumbnailURL()
  {
    return this.mThumbnailURL;
  }

  public String getTitle()
  {
    return this.mTitle;
  }

  public int hashCode()
  {
    int i;
    int k;
    label35: int n;
    label59: int i1;
    if (getTitle() != null)
    {
      i = getTitle().hashCode();
      int j = i * 31;
      if (getSubtitle() == null)
        break label123;
      k = getSubtitle().hashCode();
      int m = 31 * (k + j);
      if (getThumbnailURL() == null)
        break label128;
      n = getThumbnailURL().hashCode();
      i1 = 31 * (n + m);
      if (!isLoop())
        break label134;
    }
    label128: label134: for (int i2 = 1; ; i2 = 0)
    {
      int i3 = 31 * (i2 + i1);
      String str = getActionReplyData();
      int i4 = 0;
      if (str != null)
        i4 = getActionReplyData().hashCode();
      return i3 + i4;
      i = 0;
      break;
      label123: k = 0;
      break label35;
      n = 0;
      break label59;
    }
  }

  public boolean isLoop()
  {
    return this.mLoop;
  }

  public void setActionReplyData(String paramString)
  {
    this.mActionReplyData = paramString;
  }

  public void setLoop(boolean paramBoolean)
  {
    this.mLoop = paramBoolean;
  }

  public void setSubtitle(String paramString)
  {
    this.mSubtitle = paramString;
  }

  public void setThumbnailURL(String paramString)
  {
    this.mThumbnailURL = paramString;
  }

  public void setTitle(String paramString)
  {
    this.mTitle = paramString;
  }

  public String toString()
  {
    return "MediaPlayer{mTitle='" + this.mTitle + '\'' + ", mSubtitle='" + this.mSubtitle + '\'' + ", mThumbnailURL='" + this.mThumbnailURL + '\'' + ", mLoop=" + this.mLoop + ", mActionReplyData=" + this.mActionReplyData + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mTitle);
    paramParcel.writeString(this.mSubtitle);
    paramParcel.writeString(this.mThumbnailURL);
    if (this.mLoop);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeString(this.mActionReplyData);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.MediaPlayer
 * JD-Core Version:    0.6.2
 */