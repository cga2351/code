package com.mixpanel.android.mpmetrics;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class InAppButton
  implements Parcelable
{
  public static final Parcelable.Creator<InAppButton> CREATOR = new Parcelable.Creator()
  {
    public InAppButton a(Parcel paramAnonymousParcel)
    {
      return new InAppButton(paramAnonymousParcel);
    }

    public InAppButton[] a(int paramAnonymousInt)
    {
      return new InAppButton[paramAnonymousInt];
    }
  };
  private static final String LOGTAG = "MixpanelAPI.InAppButton";
  private int mBackgroundColor;
  private int mBorderColor;
  private String mCtaUrl;
  private JSONObject mDescription;
  private String mText;
  private int mTextColor;

  public InAppButton(Parcel paramParcel)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject2 = new JSONObject(paramParcel.readString());
      this.mDescription = localJSONObject2;
      this.mText = paramParcel.readString();
      this.mTextColor = paramParcel.readInt();
      this.mBackgroundColor = paramParcel.readInt();
      this.mBorderColor = paramParcel.readInt();
      this.mCtaUrl = paramParcel.readString();
      return;
    }
    catch (JSONException localJSONException)
    {
      while (true)
      {
        Log.e("MixpanelAPI.InAppButton", "Error reading JSON when creating InAppButton from Parcel");
        JSONObject localJSONObject2 = localJSONObject1;
      }
    }
  }

  InAppButton(JSONObject paramJSONObject)
    throws JSONException
  {
    this.mDescription = paramJSONObject;
    this.mText = paramJSONObject.getString("text");
    this.mTextColor = paramJSONObject.getInt("text_color");
    this.mBackgroundColor = paramJSONObject.getInt("bg_color");
    this.mBorderColor = paramJSONObject.getInt("border_color");
    this.mCtaUrl = paramJSONObject.getString("cta_url");
  }

  public int describeContents()
  {
    return 0;
  }

  public int getBackgroundColor()
  {
    return this.mBackgroundColor;
  }

  public int getBorderColor()
  {
    return this.mBorderColor;
  }

  public String getCtaUrl()
  {
    return this.mCtaUrl;
  }

  public String getText()
  {
    return this.mText;
  }

  public int getTextColor()
  {
    return this.mTextColor;
  }

  public String toString()
  {
    return this.mDescription.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mDescription.toString());
    paramParcel.writeString(this.mText);
    paramParcel.writeInt(this.mTextColor);
    paramParcel.writeInt(this.mBackgroundColor);
    paramParcel.writeInt(this.mBorderColor);
    paramParcel.writeString(this.mCtaUrl);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.mpmetrics.InAppButton
 * JD-Core Version:    0.6.2
 */