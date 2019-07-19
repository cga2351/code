package com.viber.voip.messages.orm.entity.json.action;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.messages.orm.entity.json.ActionType;
import org.json.JSONException;
import org.json.JSONObject;

public class ForwardAction extends Action
{
  public static final Parcelable.Creator<ForwardAction> CREATOR = new Parcelable.Creator()
  {
    public ForwardAction createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ForwardAction(paramAnonymousParcel);
    }

    public ForwardAction[] newArray(int paramAnonymousInt)
    {
      return new ForwardAction[paramAnonymousInt];
    }
  };
  private static final String KEY_FORWARD_STRING = "str";
  private final String mForwardString;

  ForwardAction(Parcel paramParcel)
  {
    super(paramParcel);
    this.mForwardString = paramParcel.readString();
  }

  ForwardAction(JSONObject paramJSONObject)
    throws JSONException
  {
    super(paramJSONObject);
    this.mForwardString = paramJSONObject.getJSONObject("parameters").getString("str");
  }

  public int describeContents()
  {
    return 0;
  }

  public void execute(Context paramContext, Action.ExecuteListener paramExecuteListener)
  {
    super.execute(paramContext, paramExecuteListener);
    paramExecuteListener.onFinish(Action.ExecuteStatus.FAIL);
  }

  public String getForwardString()
  {
    return this.mForwardString;
  }

  public ActionType getType()
  {
    return ActionType.FORWARD;
  }

  public String toString()
  {
    return getType() + " {forwardString='" + this.mForwardString + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mForwardString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.action.ForwardAction
 * JD-Core Version:    0.6.2
 */