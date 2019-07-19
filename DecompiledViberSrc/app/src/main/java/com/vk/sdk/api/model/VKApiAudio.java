package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import org.json.JSONObject;

public class VKApiAudio extends VKAttachments.VKApiAttachment
  implements Parcelable, Identifiable
{
  public static Parcelable.Creator<VKApiAudio> CREATOR = new Parcelable.Creator()
  {
    public VKApiAudio createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKApiAudio(paramAnonymousParcel);
    }

    public VKApiAudio[] newArray(int paramAnonymousInt)
    {
      return new VKApiAudio[paramAnonymousInt];
    }
  };
  public String access_key;
  public int album_id;
  public String artist;
  public int duration;
  public int genre;
  public int id;
  public int lyrics_id;
  public int owner_id;
  public String title;
  public String url;

  public VKApiAudio()
  {
  }

  public VKApiAudio(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.owner_id = paramParcel.readInt();
    this.artist = paramParcel.readString();
    this.title = paramParcel.readString();
    this.duration = paramParcel.readInt();
    this.url = paramParcel.readString();
    this.lyrics_id = paramParcel.readInt();
    this.album_id = paramParcel.readInt();
    this.genre = paramParcel.readInt();
    this.access_key = paramParcel.readString();
  }

  public VKApiAudio(JSONObject paramJSONObject)
  {
    parse(paramJSONObject);
  }

  public int describeContents()
  {
    return 0;
  }

  public int getId()
  {
    return this.id;
  }

  public String getType()
  {
    return "audio";
  }

  public VKApiAudio parse(JSONObject paramJSONObject)
  {
    this.id = paramJSONObject.optInt("id");
    this.owner_id = paramJSONObject.optInt("owner_id");
    this.artist = paramJSONObject.optString("artist");
    this.title = paramJSONObject.optString("title");
    this.duration = paramJSONObject.optInt("duration");
    this.url = paramJSONObject.optString("url");
    this.lyrics_id = paramJSONObject.optInt("lyrics_id");
    this.album_id = paramJSONObject.optInt("album_id");
    this.genre = paramJSONObject.optInt("genre_id");
    this.access_key = paramJSONObject.optString("access_key");
    return this;
  }

  public CharSequence toAttachmentString()
  {
    StringBuilder localStringBuilder = new StringBuilder("audio").append(this.owner_id).append('_').append(this.id);
    if (!TextUtils.isEmpty(this.access_key))
    {
      localStringBuilder.append('_');
      localStringBuilder.append(this.access_key);
    }
    return localStringBuilder;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.id);
    paramParcel.writeInt(this.owner_id);
    paramParcel.writeString(this.artist);
    paramParcel.writeString(this.title);
    paramParcel.writeInt(this.duration);
    paramParcel.writeString(this.url);
    paramParcel.writeInt(this.lyrics_id);
    paramParcel.writeInt(this.album_id);
    paramParcel.writeInt(this.genre);
    paramParcel.writeString(this.access_key);
  }

  public static final class Genre
  {
    public static final int ACOUSTIC_AND_VOCAL = 14;
    public static final int ALTERNATIVE = 21;
    public static final int CHANSON = 12;
    public static final int CLASSICAL = 16;
    public static final int DANCE_AND_HOUSE = 5;
    public static final int DRUM_AND_BASS = 10;
    public static final int DUBSTEP = 8;
    public static final int EASY_LISTENING = 4;
    public static final int ELECTROPOP_AND_DISCO = 22;
    public static final int ETHNIC = 13;
    public static final int INDIE_POP = 17;
    public static final int INSTRUMENTAL = 6;
    public static final int JAZZ_AND_BLUES = 9;
    public static final int METAL = 7;
    public static final int OTHER = 18;
    public static final int POP = 2;
    public static final int RAP_AND_HIPHOP = 3;
    public static final int REGGAE = 15;
    public static final int ROCK = 1;
    public static final int SPEECH = 19;
    public static final int TRANCE = 11;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKApiAudio
 * JD-Core Version:    0.6.2
 */