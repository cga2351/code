package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class VKApiMessage extends VKApiModel
  implements Parcelable, Identifiable
{
  public static Parcelable.Creator<VKApiMessage> CREATOR = new Parcelable.Creator()
  {
    public VKApiMessage createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKApiMessage(paramAnonymousParcel);
    }

    public VKApiMessage[] newArray(int paramAnonymousInt)
    {
      return new VKApiMessage[paramAnonymousInt];
    }
  };
  public VKAttachments attachments = new VKAttachments();
  public String body;
  public long date;
  public boolean deleted;
  public boolean emoji;
  public VKList<VKApiMessage> fwd_messages;
  public int id;
  public boolean out;
  public boolean read_state;
  public String title;
  public int user_id;

  public VKApiMessage()
  {
  }

  public VKApiMessage(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.user_id = paramParcel.readInt();
    this.date = paramParcel.readLong();
    boolean bool2;
    boolean bool3;
    label65: boolean bool4;
    if (paramParcel.readByte() != 0)
    {
      bool2 = bool1;
      this.read_state = bool2;
      if (paramParcel.readByte() == 0)
        break label153;
      bool3 = bool1;
      this.out = bool3;
      this.title = paramParcel.readString();
      this.body = paramParcel.readString();
      this.attachments = ((VKAttachments)paramParcel.readParcelable(VKAttachments.class.getClassLoader()));
      this.fwd_messages = ((VKList)paramParcel.readParcelable(VKList.class.getClassLoader()));
      if (paramParcel.readByte() == 0)
        break label159;
      bool4 = bool1;
      label129: this.emoji = bool4;
      if (paramParcel.readByte() == 0)
        break label165;
    }
    while (true)
    {
      this.deleted = bool1;
      return;
      bool2 = false;
      break;
      label153: bool3 = false;
      break label65;
      label159: bool4 = false;
      break label129;
      label165: bool1 = false;
    }
  }

  public VKApiMessage(JSONObject paramJSONObject)
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

  public VKApiMessage parse(JSONObject paramJSONObject)
    throws JSONException
  {
    this.id = paramJSONObject.optInt("id");
    this.user_id = paramJSONObject.optInt("user_id");
    this.date = paramJSONObject.optLong("date");
    this.read_state = ParseUtils.parseBoolean(paramJSONObject, "read_state");
    this.out = ParseUtils.parseBoolean(paramJSONObject, "out");
    this.title = paramJSONObject.optString("title");
    this.body = paramJSONObject.optString("body");
    this.attachments.fill(paramJSONObject.optJSONArray("attachments"));
    this.fwd_messages = new VKList(paramJSONObject.optJSONArray("fwd_messages"), VKApiMessage.class);
    this.emoji = ParseUtils.parseBoolean(paramJSONObject, "emoji");
    this.deleted = ParseUtils.parseBoolean(paramJSONObject, "deleted");
    return this;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b1 = 1;
    paramParcel.writeInt(this.id);
    paramParcel.writeInt(this.user_id);
    paramParcel.writeLong(this.date);
    byte b2;
    byte b3;
    label52: byte b4;
    if (this.read_state)
    {
      b2 = b1;
      paramParcel.writeByte(b2);
      if (!this.out)
        break label127;
      b3 = b1;
      paramParcel.writeByte(b3);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.body);
      paramParcel.writeParcelable(this.attachments, paramInt);
      paramParcel.writeParcelable(this.fwd_messages, paramInt);
      if (!this.emoji)
        break label133;
      b4 = b1;
      label102: paramParcel.writeByte(b4);
      if (!this.deleted)
        break label139;
    }
    while (true)
    {
      paramParcel.writeByte(b1);
      return;
      b2 = 0;
      break;
      label127: b3 = 0;
      break label52;
      label133: b4 = 0;
      break label102;
      label139: b1 = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKApiMessage
 * JD-Core Version:    0.6.2
 */