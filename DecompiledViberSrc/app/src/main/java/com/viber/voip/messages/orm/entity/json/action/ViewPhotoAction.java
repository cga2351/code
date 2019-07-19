package com.viber.voip.messages.orm.entity.json.action;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.messages.orm.entity.json.ActionType;
import org.json.JSONException;
import org.json.JSONObject;

public class ViewPhotoAction extends ViewMediaAction
{
  public static final Parcelable.Creator<ViewPhotoAction> CREATOR = new Parcelable.Creator()
  {
    public ViewPhotoAction createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ViewPhotoAction(paramAnonymousParcel);
    }

    public ViewPhotoAction[] newArray(int paramAnonymousInt)
    {
      return new ViewPhotoAction[paramAnonymousInt];
    }
  };

  ViewPhotoAction(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public ViewPhotoAction(String paramString, long paramLong)
  {
    super(paramString, paramLong);
  }

  ViewPhotoAction(JSONObject paramJSONObject)
    throws JSONException
  {
    super(paramJSONObject);
  }

  public int getMediaType()
  {
    return 1;
  }

  public ActionType getType()
  {
    return ActionType.VIEW_PHOTO;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.action.ViewPhotoAction
 * JD-Core Version:    0.6.2
 */