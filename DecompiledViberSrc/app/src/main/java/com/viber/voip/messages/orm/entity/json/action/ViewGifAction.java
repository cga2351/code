package com.viber.voip.messages.orm.entity.json.action;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.messages.orm.entity.json.ActionType;

public class ViewGifAction extends ViewMediaAction
{
  public static final Parcelable.Creator<ViewGifAction> CREATOR = new Parcelable.Creator()
  {
    public ViewGifAction createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ViewGifAction(paramAnonymousParcel);
    }

    public ViewGifAction[] newArray(int paramAnonymousInt)
    {
      return new ViewGifAction[paramAnonymousInt];
    }
  };

  public ViewGifAction(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public ViewGifAction(String paramString, long paramLong)
  {
    super(paramString, paramLong);
  }

  public int getMediaType()
  {
    return 1005;
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
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.action.ViewGifAction
 * JD-Core Version:    0.6.2
 */