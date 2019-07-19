package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class VKApiNote extends VKAttachments.VKApiAttachment
  implements Parcelable, Identifiable
{
  public static Parcelable.Creator<VKApiNote> CREATOR = new Parcelable.Creator()
  {
    public VKApiNote createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKApiNote(paramAnonymousParcel);
    }

    public VKApiNote[] newArray(int paramAnonymousInt)
    {
      return new VKApiNote[paramAnonymousInt];
    }
  };
  public int comments;
  public long date;
  public int id;
  public int read_comments;
  public String text;
  public String title;
  public int user_id;
  public String view_url;

  public VKApiNote()
  {
  }

  public VKApiNote(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.user_id = paramParcel.readInt();
    this.title = paramParcel.readString();
    this.text = paramParcel.readString();
    this.date = paramParcel.readLong();
    this.comments = paramParcel.readInt();
    this.read_comments = paramParcel.readInt();
    this.view_url = paramParcel.readString();
  }

  public VKApiNote(JSONObject paramJSONObject)
    throws JSONException
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
    return "note";
  }

  public VKApiNote parse(JSONObject paramJSONObject)
  {
    this.id = paramJSONObject.optInt("id");
    this.user_id = paramJSONObject.optInt("user_id");
    this.title = paramJSONObject.optString("title");
    this.text = paramJSONObject.optString("text");
    this.date = paramJSONObject.optLong("date");
    this.comments = paramJSONObject.optInt("comments");
    this.read_comments = paramJSONObject.optInt("read_comments");
    this.view_url = paramJSONObject.optString("view_url");
    return this;
  }

  public CharSequence toAttachmentString()
  {
    return new StringBuilder("note").append(this.user_id).append('_').append(this.id);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.id);
    paramParcel.writeInt(this.user_id);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.text);
    paramParcel.writeLong(this.date);
    paramParcel.writeInt(this.comments);
    paramParcel.writeInt(this.read_comments);
    paramParcel.writeString(this.view_url);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKApiNote
 * JD-Core Version:    0.6.2
 */