package com.mixpanel.android.mpmetrics;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.mixpanel.android.b.e;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TakeoverInAppNotification extends InAppNotification
{
  public static final Parcelable.Creator<TakeoverInAppNotification> CREATOR = new Parcelable.Creator()
  {
    public TakeoverInAppNotification a(Parcel paramAnonymousParcel)
    {
      return new TakeoverInAppNotification(paramAnonymousParcel);
    }

    public TakeoverInAppNotification[] a(int paramAnonymousInt)
    {
      return new TakeoverInAppNotification[paramAnonymousInt];
    }
  };
  private final ArrayList<InAppButton> mButtons;
  private final int mCloseButtonColor;
  private final boolean mShouldFadeImage;
  private final String mTitle;
  private final int mTitleColor;

  public TakeoverInAppNotification(Parcel paramParcel)
  {
    super(paramParcel);
    this.mButtons = paramParcel.createTypedArrayList(InAppButton.CREATOR);
    this.mCloseButtonColor = paramParcel.readInt();
    this.mTitle = paramParcel.readString();
    this.mTitleColor = paramParcel.readInt();
    if (paramParcel.readByte() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.mShouldFadeImage = bool;
      return;
    }
  }

  TakeoverInAppNotification(JSONObject paramJSONObject)
    throws b
  {
    super(paramJSONObject);
    try
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray("buttons");
      this.mButtons = new ArrayList();
      for (int i = 0; i < localJSONArray.length(); i++)
      {
        JSONObject localJSONObject = (JSONObject)localJSONArray.get(i);
        this.mButtons.add(new InAppButton(localJSONObject));
      }
      this.mCloseButtonColor = paramJSONObject.getInt("close_color");
      this.mTitle = e.a(paramJSONObject, "title");
      this.mTitleColor = paramJSONObject.optInt("title_color");
      this.mShouldFadeImage = getExtras().getBoolean("image_fade");
      return;
    }
    catch (JSONException localJSONException)
    {
      throw new b("Notification JSON was unexpected or bad", localJSONException);
    }
  }

  public InAppButton getButton(int paramInt)
  {
    if (this.mButtons.size() > paramInt)
      return (InAppButton)this.mButtons.get(paramInt);
    return null;
  }

  public int getCloseColor()
  {
    return this.mCloseButtonColor;
  }

  public int getNumButtons()
  {
    return this.mButtons.size();
  }

  public String getTitle()
  {
    return this.mTitle;
  }

  public int getTitleColor()
  {
    return this.mTitleColor;
  }

  public InAppNotification.a getType()
  {
    return InAppNotification.a.c;
  }

  public boolean hasTitle()
  {
    return this.mTitle != null;
  }

  public boolean setShouldShowShadow()
  {
    return this.mShouldFadeImage;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeTypedList(this.mButtons);
    paramParcel.writeInt(this.mCloseButtonColor);
    paramParcel.writeString(this.mTitle);
    paramParcel.writeInt(this.mTitleColor);
    if (this.mShouldFadeImage);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeByte((byte)i);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.mpmetrics.TakeoverInAppNotification
 * JD-Core Version:    0.6.2
 */