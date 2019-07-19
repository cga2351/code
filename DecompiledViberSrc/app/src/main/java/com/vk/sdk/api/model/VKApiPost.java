package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class VKApiPost extends VKAttachments.VKApiAttachment
  implements Parcelable, Identifiable
{
  public static Parcelable.Creator<VKApiPost> CREATOR = new Parcelable.Creator()
  {
    public VKApiPost createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKApiPost(paramAnonymousParcel);
    }

    public VKApiPost[] newArray(int paramAnonymousInt)
    {
      return new VKApiPost[paramAnonymousInt];
    }
  };
  public VKAttachments attachments = new VKAttachments();
  public boolean can_like;
  public boolean can_post_comment;
  public boolean can_publish;
  public int comments_count;
  public VKList<VKApiPost> copy_history;
  public long date;
  public boolean friends_only;
  public int from_id;
  public VKApiPlace geo;
  public int id;
  public int likes_count;
  public String post_type;
  public int reply_owner_id;
  public int reply_post_id;
  public int reposts_count;
  public int signer_id;
  public String text;
  public int to_id;
  public boolean user_likes;
  public boolean user_reposted;

  public VKApiPost()
  {
  }

  public VKApiPost(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.to_id = paramParcel.readInt();
    this.from_id = paramParcel.readInt();
    this.date = paramParcel.readLong();
    this.text = paramParcel.readString();
    this.reply_owner_id = paramParcel.readInt();
    this.reply_post_id = paramParcel.readInt();
    boolean bool2;
    boolean bool3;
    label105: boolean bool4;
    label129: boolean bool5;
    label145: boolean bool6;
    if (paramParcel.readByte() != 0)
    {
      bool2 = bool1;
      this.friends_only = bool2;
      this.comments_count = paramParcel.readInt();
      if (paramParcel.readByte() == 0)
        break label241;
      bool3 = bool1;
      this.can_post_comment = bool3;
      this.likes_count = paramParcel.readInt();
      if (paramParcel.readByte() == 0)
        break label247;
      bool4 = bool1;
      this.user_likes = bool4;
      if (paramParcel.readByte() == 0)
        break label253;
      bool5 = bool1;
      this.can_like = bool5;
      if (paramParcel.readByte() == 0)
        break label259;
      bool6 = bool1;
      label161: this.can_publish = bool6;
      this.reposts_count = paramParcel.readInt();
      if (paramParcel.readByte() == 0)
        break label265;
    }
    while (true)
    {
      this.user_reposted = bool1;
      this.post_type = paramParcel.readString();
      this.attachments = ((VKAttachments)paramParcel.readParcelable(VKAttachments.class.getClassLoader()));
      this.geo = ((VKApiPlace)paramParcel.readParcelable(VKApiPlace.class.getClassLoader()));
      this.signer_id = paramParcel.readInt();
      return;
      bool2 = false;
      break;
      label241: bool3 = false;
      break label105;
      label247: bool4 = false;
      break label129;
      label253: bool5 = false;
      break label145;
      label259: bool6 = false;
      break label161;
      label265: bool1 = false;
    }
  }

  public VKApiPost(JSONObject paramJSONObject)
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
    return "wall";
  }

  public VKApiPost parse(JSONObject paramJSONObject)
    throws JSONException
  {
    this.id = paramJSONObject.optInt("id");
    this.to_id = paramJSONObject.optInt("to_id");
    this.from_id = paramJSONObject.optInt("from_id");
    this.date = paramJSONObject.optLong("date");
    this.text = paramJSONObject.optString("text");
    this.reply_owner_id = paramJSONObject.optInt("reply_owner_id");
    this.reply_post_id = paramJSONObject.optInt("reply_post_id");
    this.friends_only = ParseUtils.parseBoolean(paramJSONObject, "friends_only");
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("comments");
    if (localJSONObject1 != null)
    {
      this.comments_count = localJSONObject1.optInt("count");
      this.can_post_comment = ParseUtils.parseBoolean(localJSONObject1, "can_post");
    }
    JSONObject localJSONObject2 = paramJSONObject.optJSONObject("likes");
    if (localJSONObject2 != null)
    {
      this.likes_count = localJSONObject2.optInt("count");
      this.user_likes = ParseUtils.parseBoolean(localJSONObject2, "user_likes");
      this.can_like = ParseUtils.parseBoolean(localJSONObject2, "can_like");
      this.can_publish = ParseUtils.parseBoolean(localJSONObject2, "can_publish");
    }
    JSONObject localJSONObject3 = paramJSONObject.optJSONObject("reposts");
    if (localJSONObject3 != null)
    {
      this.reposts_count = localJSONObject3.optInt("count");
      this.user_reposted = ParseUtils.parseBoolean(localJSONObject3, "user_reposted");
    }
    this.post_type = paramJSONObject.optString("post_type");
    this.attachments.fill(paramJSONObject.optJSONArray("attachments"));
    JSONObject localJSONObject4 = paramJSONObject.optJSONObject("geo");
    if (localJSONObject4 != null)
      this.geo = new VKApiPlace().parse(localJSONObject4);
    this.signer_id = paramJSONObject.optInt("signer_id");
    this.copy_history = new VKList(paramJSONObject.optJSONArray("copy_history"), VKApiPost.class);
    return this;
  }

  public CharSequence toAttachmentString()
  {
    return new StringBuilder("wall").append(this.to_id).append('_').append(this.id);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b1 = 1;
    paramParcel.writeInt(this.id);
    paramParcel.writeInt(this.to_id);
    paramParcel.writeInt(this.from_id);
    paramParcel.writeLong(this.date);
    paramParcel.writeString(this.text);
    paramParcel.writeInt(this.reply_owner_id);
    paramParcel.writeInt(this.reply_post_id);
    byte b2;
    byte b3;
    label92: byte b4;
    label116: byte b5;
    label132: byte b6;
    if (this.friends_only)
    {
      b2 = b1;
      paramParcel.writeByte(b2);
      paramParcel.writeInt(this.comments_count);
      if (!this.can_post_comment)
        break label215;
      b3 = b1;
      paramParcel.writeByte(b3);
      paramParcel.writeInt(this.likes_count);
      if (!this.user_likes)
        break label221;
      b4 = b1;
      paramParcel.writeByte(b4);
      if (!this.can_like)
        break label227;
      b5 = b1;
      paramParcel.writeByte(b5);
      if (!this.can_publish)
        break label233;
      b6 = b1;
      label148: paramParcel.writeByte(b6);
      paramParcel.writeInt(this.reposts_count);
      if (!this.user_reposted)
        break label239;
    }
    while (true)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.post_type);
      paramParcel.writeParcelable(this.attachments, paramInt);
      paramParcel.writeParcelable(this.geo, paramInt);
      paramParcel.writeInt(this.signer_id);
      return;
      b2 = 0;
      break;
      label215: b3 = 0;
      break label92;
      label221: b4 = 0;
      break label116;
      label227: b5 = 0;
      break label132;
      label233: b6 = 0;
      break label148;
      label239: b1 = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKApiPost
 * JD-Core Version:    0.6.2
 */