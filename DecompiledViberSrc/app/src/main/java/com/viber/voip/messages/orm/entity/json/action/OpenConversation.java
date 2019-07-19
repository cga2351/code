package com.viber.voip.messages.orm.entity.json.action;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.messages.orm.entity.json.ActionType;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenConversation extends Action
{
  public static final Parcelable.Creator<OpenConversation> CREATOR = new Parcelable.Creator()
  {
    public OpenConversation createFromParcel(Parcel paramAnonymousParcel)
    {
      return new OpenConversation(paramAnonymousParcel);
    }

    public OpenConversation[] newArray(int paramAnonymousInt)
    {
      return new OpenConversation[paramAnonymousInt];
    }
  };
  private static final String KEY_CONTACT_NUMBER = "number";
  private final String mContactNumber;

  OpenConversation(Parcel paramParcel)
  {
    super(paramParcel);
    this.mContactNumber = paramParcel.readString();
  }

  OpenConversation(JSONObject paramJSONObject)
    throws JSONException
  {
    super(paramJSONObject);
    this.mContactNumber = paramJSONObject.getJSONObject("parameters").getString("number");
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

  public String getContactNumber()
  {
    return this.mContactNumber;
  }

  public ActionType getType()
  {
    return ActionType.OPEN_CONVERSATION;
  }

  public String toString()
  {
    return getType() + " {contactNumber='" + this.mContactNumber + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mContactNumber);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.action.OpenConversation
 * JD-Core Version:    0.6.2
 */