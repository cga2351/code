package com.android.music.player.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MusicAlbumInfo
  implements Parcelable
{
  public static final Parcelable.Creator<MusicAlbumInfo> CREATOR = new Parcelable.Creator()
  {
    public MusicAlbumInfo a(Parcel paramAnonymousParcel)
    {
      MusicAlbumInfo localMusicAlbumInfo = new MusicAlbumInfo();
      localMusicAlbumInfo.mTitle = paramAnonymousParcel.readString();
      localMusicAlbumInfo.mAlbum = paramAnonymousParcel.readString();
      localMusicAlbumInfo.mArtist = paramAnonymousParcel.readString();
      localMusicAlbumInfo.mAlbumID = paramAnonymousParcel.readInt();
      return localMusicAlbumInfo;
    }

    public MusicAlbumInfo[] a(int paramAnonymousInt)
    {
      return new MusicAlbumInfo[paramAnonymousInt];
    }
  };
  public String mAlbum;
  public int mAlbumID;
  public String mArtist;
  public String mTitle;

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mTitle);
    paramParcel.writeString(this.mAlbum);
    paramParcel.writeString(this.mArtist);
    paramParcel.writeInt(this.mAlbumID);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.android.music.player.data.MusicAlbumInfo
 * JD-Core Version:    0.6.2
 */