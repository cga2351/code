package com.viber.voip.messages.orm.entity.json.action;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.messages.orm.entity.json.ActionType;
import org.json.JSONException;
import org.json.JSONObject;

public class CopyAction extends Action
{
  public static final Parcelable.Creator<CopyAction> CREATOR = new Parcelable.Creator()
  {
    public CopyAction createFromParcel(Parcel paramAnonymousParcel)
    {
      return new CopyAction(paramAnonymousParcel);
    }

    public CopyAction[] newArray(int paramAnonymousInt)
    {
      return new CopyAction[paramAnonymousInt];
    }
  };
  private static final String KEY_COPY_STRING = "str";
  private final String mCopyString;

  CopyAction(Parcel paramParcel)
  {
    super(paramParcel);
    this.mCopyString = paramParcel.readString();
  }

  CopyAction(JSONObject paramJSONObject)
    throws JSONException
  {
    super(paramJSONObject);
    this.mCopyString = paramJSONObject.getJSONObject("parameters").getString("str");
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

  public String getCopyString()
  {
    return this.mCopyString;
  }

  public ActionType getType()
  {
    return ActionType.COPY;
  }

  public String toString()
  {
    return getType() + " {copyString='" + this.mCopyString + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mCopyString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.action.CopyAction
 * JD-Core Version:    0.6.2
 */