package com.viber.voip.billing;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import org.json.JSONException;
import org.json.JSONObject;

public class Carrier
  implements Parcelable
{
  public static final Parcelable.Creator<Carrier> CREATOR = new Parcelable.Creator()
  {
    public Carrier a(Parcel paramAnonymousParcel)
    {
      return new Carrier(paramAnonymousParcel);
    }

    public Carrier[] a(int paramAnonymousInt)
    {
      return new Carrier[paramAnonymousInt];
    }
  };
  private static final Logger L = ViberEnv.getLogger();
  private String mImage;
  private String mName;

  public Carrier()
  {
  }

  public Carrier(Parcel paramParcel)
  {
    this.mName = paramParcel.readString();
    this.mImage = paramParcel.readString();
  }

  public static Carrier parseFromJson(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        Carrier localCarrier = new Carrier();
        localCarrier.setName(localJSONObject.getString("name"));
        localCarrier.setImage(localJSONObject.getString("image"));
        return localCarrier;
      }
      catch (JSONException localJSONException)
      {
      }
    return null;
  }

  public int describeContents()
  {
    return 0;
  }

  public String getImage()
  {
    return this.mImage;
  }

  public String getName()
  {
    return this.mName;
  }

  public void setImage(String paramString)
  {
    this.mImage = paramString;
  }

  public void setName(String paramString)
  {
    this.mName = paramString;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mName);
    paramParcel.writeString(this.mImage);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.billing.Carrier
 * JD-Core Version:    0.6.2
 */