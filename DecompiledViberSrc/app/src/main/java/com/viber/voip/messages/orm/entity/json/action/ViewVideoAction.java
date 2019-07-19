package com.viber.voip.messages.orm.entity.json.action;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.messages.orm.entity.json.ActionType;
import org.json.JSONException;
import org.json.JSONObject;

public class ViewVideoAction extends ViewMediaAction
{
  public static final Parcelable.Creator<ViewVideoAction> CREATOR = new Parcelable.Creator()
  {
    public ViewVideoAction createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ViewVideoAction(paramAnonymousParcel);
    }

    public ViewVideoAction[] newArray(int paramAnonymousInt)
    {
      return new ViewVideoAction[paramAnonymousInt];
    }
  };

  ViewVideoAction(Parcel paramParcel)
  {
    super(paramParcel);
  }

  ViewVideoAction(JSONObject paramJSONObject)
    throws JSONException
  {
    super(paramJSONObject);
  }

  public int getMediaType()
  {
    return 3;
  }

  public ActionType getType()
  {
    return ActionType.VIEW_VIDEO;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.action.ViewVideoAction
 * JD-Core Version:    0.6.2
 */