package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONObject;

public class VKApiGetDialogResponse extends VKApiModel
  implements Parcelable
{
  public static Parcelable.Creator<VKApiGetDialogResponse> CREATOR = new Parcelable.Creator()
  {
    public VKApiGetDialogResponse createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKApiGetDialogResponse(paramAnonymousParcel);
    }

    public VKApiGetDialogResponse[] newArray(int paramAnonymousInt)
    {
      return new VKApiGetDialogResponse[paramAnonymousInt];
    }
  };
  public int count;
  public VKList<VKApiDialog> items;
  public int unread_dialogs;

  public VKApiGetDialogResponse()
  {
  }

  public VKApiGetDialogResponse(Parcel paramParcel)
  {
    this.count = paramParcel.readInt();
    this.unread_dialogs = paramParcel.readInt();
    this.items = ((VKList)paramParcel.readParcelable(VKList.class.getClassLoader()));
  }

  public VKApiGetDialogResponse(JSONObject paramJSONObject)
  {
    parse(paramJSONObject);
  }

  public int describeContents()
  {
    return 0;
  }

  public VKApiGetDialogResponse parse(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject.optJSONObject("response");
    this.count = localJSONObject.optInt("count");
    this.unread_dialogs = localJSONObject.optInt("unread_dialogs");
    this.items = new VKList(localJSONObject.optJSONArray("items"), VKApiDialog.class);
    return this;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.count);
    paramParcel.writeInt(this.unread_dialogs);
    paramParcel.writeParcelable(this.items, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKApiGetDialogResponse
 * JD-Core Version:    0.6.2
 */