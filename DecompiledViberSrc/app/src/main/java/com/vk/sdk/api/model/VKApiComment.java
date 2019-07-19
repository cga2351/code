package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONObject;

public class VKApiComment extends VKApiModel
  implements Parcelable, Identifiable
{
  public static Parcelable.Creator<VKApiComment> CREATOR = new Parcelable.Creator()
  {
    public VKApiComment createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKApiComment(paramAnonymousParcel);
    }

    public VKApiComment[] newArray(int paramAnonymousInt)
    {
      return new VKApiComment[paramAnonymousInt];
    }
  };
  public VKAttachments attachments = new VKAttachments();
  public boolean can_like;
  public long date;
  public int from_id;
  public int id;
  public int likes;
  public int reply_to_comment;
  public int reply_to_user;
  public String text;
  public boolean user_likes;

  public VKApiComment()
  {
  }

  public VKApiComment(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.from_id = paramParcel.readInt();
    this.date = paramParcel.readLong();
    this.text = paramParcel.readString();
    this.reply_to_user = paramParcel.readInt();
    this.reply_to_comment = paramParcel.readInt();
    this.likes = paramParcel.readInt();
    boolean bool2;
    if (paramParcel.readByte() != 0)
    {
      bool2 = bool1;
      this.user_likes = bool2;
      if (paramParcel.readByte() == 0)
        break label121;
    }
    while (true)
    {
      this.can_like = bool1;
      this.attachments = ((VKAttachments)paramParcel.readParcelable(VKAttachments.class.getClassLoader()));
      return;
      bool2 = false;
      break;
      label121: bool1 = false;
    }
  }

  public VKApiComment(JSONObject paramJSONObject)
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

  public VKApiComment parse(JSONObject paramJSONObject)
  {
    this.id = paramJSONObject.optInt("id");
    this.from_id = paramJSONObject.optInt("from_id");
    this.date = paramJSONObject.optLong("date");
    this.text = paramJSONObject.optString("text");
    this.reply_to_user = paramJSONObject.optInt("reply_to_user");
    this.reply_to_comment = paramJSONObject.optInt("reply_to_comment");
    this.attachments.fill(paramJSONObject.optJSONArray("attachments"));
    JSONObject localJSONObject = paramJSONObject.optJSONObject("likes");
    this.likes = ParseUtils.parseInt(localJSONObject, "count");
    this.user_likes = ParseUtils.parseBoolean(localJSONObject, "user_likes");
    this.can_like = ParseUtils.parseBoolean(localJSONObject, "can_like");
    return this;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b1 = 1;
    paramParcel.writeInt(this.id);
    paramParcel.writeInt(this.from_id);
    paramParcel.writeLong(this.date);
    paramParcel.writeString(this.text);
    paramParcel.writeInt(this.reply_to_user);
    paramParcel.writeInt(this.reply_to_comment);
    paramParcel.writeInt(this.likes);
    byte b2;
    if (this.user_likes)
    {
      b2 = b1;
      paramParcel.writeByte(b2);
      if (!this.can_like)
        break label102;
    }
    while (true)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeParcelable(this.attachments, paramInt);
      return;
      b2 = 0;
      break;
      label102: b1 = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKApiComment
 * JD-Core Version:    0.6.2
 */