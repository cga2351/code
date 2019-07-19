package com.mixpanel.android.mpmetrics;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.mixpanel.android.b.e;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniInAppNotification extends InAppNotification
{
  public static final Parcelable.Creator<MiniInAppNotification> CREATOR = new Parcelable.Creator()
  {
    public MiniInAppNotification a(Parcel paramAnonymousParcel)
    {
      return new MiniInAppNotification(paramAnonymousParcel);
    }

    public MiniInAppNotification[] a(int paramAnonymousInt)
    {
      return new MiniInAppNotification[paramAnonymousInt];
    }
  };
  private final int mBorderColor;
  private final String mCtaUrl;
  private final int mImageTintColor;

  public MiniInAppNotification(Parcel paramParcel)
  {
    super(paramParcel);
    this.mCtaUrl = paramParcel.readString();
    this.mImageTintColor = paramParcel.readInt();
    this.mBorderColor = paramParcel.readInt();
  }

  MiniInAppNotification(JSONObject paramJSONObject)
    throws b
  {
    super(paramJSONObject);
    try
    {
      this.mCtaUrl = e.a(paramJSONObject, "cta_url");
      this.mImageTintColor = paramJSONObject.getInt("image_tint_color");
      this.mBorderColor = paramJSONObject.getInt("border_color");
      return;
    }
    catch (JSONException localJSONException)
    {
      throw new b("Notification JSON was unexpected or bad", localJSONException);
    }
  }

  public int getBorderColor()
  {
    return this.mBorderColor;
  }

  public String getCtaUrl()
  {
    return this.mCtaUrl;
  }

  public int getImageTintColor()
  {
    return this.mImageTintColor;
  }

  public InAppNotification.a getType()
  {
    return InAppNotification.a.b;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mCtaUrl);
    paramParcel.writeInt(this.mImageTintColor);
    paramParcel.writeInt(this.mBorderColor);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.mpmetrics.MiniInAppNotification
 * JD-Core Version:    0.6.2
 */