package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class VKApiDialog extends VKApiModel
  implements Parcelable, Identifiable
{
  public static Parcelable.Creator<VKApiDialog> CREATOR = new Parcelable.Creator()
  {
    public VKApiDialog createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKApiDialog(paramAnonymousParcel);
    }

    public VKApiDialog[] newArray(int paramAnonymousInt)
    {
      return new VKApiDialog[paramAnonymousInt];
    }
  };
  public VKApiMessage message;
  public int unread;

  public VKApiDialog()
  {
  }

  public VKApiDialog(Parcel paramParcel)
  {
    this.unread = paramParcel.readInt();
    this.message = ((VKApiMessage)paramParcel.readParcelable(VKApiMessage.class.getClassLoader()));
  }

  public VKApiDialog(JSONObject paramJSONObject)
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
    return this.message.getId();
  }

  public VKApiDialog parse(JSONObject paramJSONObject)
    throws JSONException
  {
    this.unread = paramJSONObject.optInt("unread");
    this.message = new VKApiMessage(paramJSONObject.optJSONObject("message"));
    return this;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.unread);
    paramParcel.writeParcelable(this.message, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKApiDialog
 * JD-Core Version:    0.6.2
 */