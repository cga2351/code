package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONArray;
import org.json.JSONObject;

public class VKApiChat extends VKApiModel
  implements Parcelable, Identifiable
{
  public static Parcelable.Creator<VKApiChat> CREATOR = new Parcelable.Creator()
  {
    public VKApiChat createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKApiChat(paramAnonymousParcel);
    }

    public VKApiChat[] newArray(int paramAnonymousInt)
    {
      return new VKApiChat[paramAnonymousInt];
    }
  };
  public int admin_id;
  public int id;
  public String title;
  public String type;
  public int[] users;

  public VKApiChat()
  {
  }

  public VKApiChat(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.type = paramParcel.readString();
    this.title = paramParcel.readString();
    this.admin_id = paramParcel.readInt();
    this.users = paramParcel.createIntArray();
  }

  public VKApiChat(JSONObject paramJSONObject)
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

  public VKApiChat parse(JSONObject paramJSONObject)
  {
    this.id = paramJSONObject.optInt("id");
    this.type = paramJSONObject.optString("type");
    this.title = paramJSONObject.optString("title");
    this.admin_id = paramJSONObject.optInt("admin_id");
    JSONArray localJSONArray = paramJSONObject.optJSONArray("users");
    if (localJSONArray != null)
    {
      this.users = new int[localJSONArray.length()];
      for (int i = 0; i < this.users.length; i++)
        this.users[i] = localJSONArray.optInt(i);
    }
    return this;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.id);
    paramParcel.writeString(this.type);
    paramParcel.writeString(this.title);
    paramParcel.writeInt(this.admin_id);
    paramParcel.writeIntArray(this.users);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKApiChat
 * JD-Core Version:    0.6.2
 */