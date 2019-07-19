package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONObject;

public class VKApiGetMessagesResponse extends VKApiModel
  implements Parcelable
{
  public static Parcelable.Creator<VKApiGetMessagesResponse> CREATOR = new Parcelable.Creator()
  {
    public VKApiGetMessagesResponse createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKApiGetMessagesResponse(paramAnonymousParcel);
    }

    public VKApiGetMessagesResponse[] newArray(int paramAnonymousInt)
    {
      return new VKApiGetMessagesResponse[paramAnonymousInt];
    }
  };
  public int count;
  public VKList<VKApiMessage> items;

  public VKApiGetMessagesResponse()
  {
  }

  public VKApiGetMessagesResponse(Parcel paramParcel)
  {
    this.count = paramParcel.readInt();
    this.items = ((VKList)paramParcel.readParcelable(VKList.class.getClassLoader()));
  }

  public VKApiGetMessagesResponse(JSONObject paramJSONObject)
  {
    parse(paramJSONObject);
  }

  public int describeContents()
  {
    return 0;
  }

  public VKApiGetMessagesResponse parse(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject.optJSONObject("response");
    this.count = localJSONObject.optInt("count");
    this.items = new VKList(localJSONObject.optJSONArray("items"), VKApiMessage.class);
    return this;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.count);
    paramParcel.writeParcelable(this.items, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKApiGetMessagesResponse
 * JD-Core Version:    0.6.2
 */