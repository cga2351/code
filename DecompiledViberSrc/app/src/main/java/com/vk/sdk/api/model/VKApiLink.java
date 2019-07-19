package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public class VKApiLink extends VKAttachments.VKApiAttachment
  implements Parcelable
{
  public static Parcelable.Creator<VKApiLink> CREATOR = new Parcelable.Creator()
  {
    public VKApiLink createFromParcel(Parcel paramAnonymousParcel)
    {
      return new VKApiLink(paramAnonymousParcel, null);
    }

    public VKApiLink[] newArray(int paramAnonymousInt)
    {
      return new VKApiLink[paramAnonymousInt];
    }
  };
  public String description;
  public String image_src;
  public String preview_page;
  public String title;
  public String url;

  public VKApiLink()
  {
  }

  private VKApiLink(Parcel paramParcel)
  {
    this.url = paramParcel.readString();
    this.title = paramParcel.readString();
    this.description = paramParcel.readString();
    this.image_src = paramParcel.readString();
    this.preview_page = paramParcel.readString();
  }

  public VKApiLink(String paramString)
  {
    this.url = paramString;
  }

  public VKApiLink(JSONObject paramJSONObject)
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
    return 0;
  }

  public String getType()
  {
    return "link";
  }

  public VKApiLink parse(JSONObject paramJSONObject)
  {
    this.url = paramJSONObject.optString("url");
    this.title = paramJSONObject.optString("title");
    this.description = paramJSONObject.optString("description");
    this.image_src = paramJSONObject.optString("image_src");
    this.preview_page = paramJSONObject.optString("preview_page");
    return this;
  }

  public CharSequence toAttachmentString()
  {
    return this.url;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.description);
    paramParcel.writeString(this.image_src);
    paramParcel.writeString(this.preview_page);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKApiLink
 * JD-Core Version:    0.6.2
 */