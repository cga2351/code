package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class VKApiWikiPage extends VKAttachments.VKApiAttachment
  implements Parcelable
{
  public static Parcelable.Creator<VKApiWikiPage> CREATOR = new Parcelable.Creator()
  {
    public VKApiWikiPage createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKApiWikiPage(paramAnonymousParcel);
    }

    public VKApiWikiPage[] newArray(int paramAnonymousInt)
    {
      return new VKApiWikiPage[paramAnonymousInt];
    }
  };
  public long created;
  public int creator_id;
  public boolean current_user_can_edit;
  public boolean current_user_can_edit_access;
  public long edited;
  public int editor_id;
  public int group_id;
  public int id;
  public String parent;
  public String parent2;
  public String source;
  public String title;
  public int who_can_edit;
  public int who_can_view;

  public VKApiWikiPage()
  {
  }

  public VKApiWikiPage(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.group_id = paramParcel.readInt();
    this.creator_id = paramParcel.readInt();
    this.title = paramParcel.readString();
    this.source = paramParcel.readString();
    boolean bool2;
    if (paramParcel.readByte() != 0)
    {
      bool2 = bool1;
      this.current_user_can_edit = bool2;
      if (paramParcel.readByte() == 0)
        break label134;
    }
    while (true)
    {
      this.current_user_can_edit_access = bool1;
      this.who_can_view = paramParcel.readInt();
      this.who_can_edit = paramParcel.readInt();
      this.editor_id = paramParcel.readInt();
      this.edited = paramParcel.readLong();
      this.created = paramParcel.readLong();
      this.parent = paramParcel.readString();
      this.parent2 = paramParcel.readString();
      return;
      bool2 = false;
      break;
      label134: bool1 = false;
    }
  }

  public VKApiWikiPage(JSONObject paramJSONObject)
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
    return "page";
  }

  public VKApiWikiPage parse(JSONObject paramJSONObject)
  {
    this.id = paramJSONObject.optInt("id");
    this.group_id = paramJSONObject.optInt("group_id");
    this.creator_id = paramJSONObject.optInt("creator_id");
    this.title = paramJSONObject.optString("title");
    this.source = paramJSONObject.optString("source");
    this.current_user_can_edit = ParseUtils.parseBoolean(paramJSONObject, "current_user_can_edit");
    this.current_user_can_edit_access = ParseUtils.parseBoolean(paramJSONObject, "current_user_can_edit_access");
    this.who_can_view = paramJSONObject.optInt("who_can_view");
    this.who_can_edit = paramJSONObject.optInt("who_can_edit");
    this.editor_id = paramJSONObject.optInt("editor_id");
    this.edited = paramJSONObject.optLong("edited");
    this.created = paramJSONObject.optLong("created");
    this.parent = paramJSONObject.optString("parent");
    this.parent2 = paramJSONObject.optString("parent2");
    return this;
  }

  public CharSequence toAttachmentString()
  {
    return new StringBuilder("page").append(this.group_id).append('_').append(this.id);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b1 = 1;
    paramParcel.writeInt(this.id);
    paramParcel.writeInt(this.group_id);
    paramParcel.writeInt(this.creator_id);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.source);
    byte b2;
    if (this.current_user_can_edit)
    {
      b2 = b1;
      paramParcel.writeByte(b2);
      if (!this.current_user_can_edit_access)
        break label133;
    }
    while (true)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.who_can_view);
      paramParcel.writeInt(this.who_can_edit);
      paramParcel.writeInt(this.editor_id);
      paramParcel.writeLong(this.edited);
      paramParcel.writeLong(this.created);
      paramParcel.writeString(this.parent);
      paramParcel.writeString(this.parent2);
      return;
      b2 = 0;
      break;
      label133: b1 = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKApiWikiPage
 * JD-Core Version:    0.6.2
 */