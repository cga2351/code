package com.viber.voip.messages.orm.entity.json.action;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.viber.voip.messages.orm.entity.json.ActionType;
import com.viber.voip.messages.orm.entity.json.TriggerType;
import org.json.JSONObject;

public abstract class Action
  implements Parcelable
{
  public static final String KEY_ACTION_NAME = "name";
  public static final String KEY_ACTION_PARAMS = "parameters";
  public static final String KEY_TRIGGER_NAME = "trigger";
  private final boolean mIsFormatted;
  private final TriggerType mTriggerType;

  public Action()
  {
    this.mTriggerType = null;
    this.mIsFormatted = false;
  }

  public Action(Parcel paramParcel)
  {
    this.mTriggerType = TriggerType.toEnum(paramParcel.readString());
    if (paramParcel.readByte() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.mIsFormatted = bool;
      return;
    }
  }

  public Action(Action paramAction)
  {
    this.mTriggerType = paramAction.mTriggerType;
    this.mIsFormatted = paramAction.mIsFormatted;
  }

  public Action(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null);
    for (TriggerType localTriggerType = TriggerType.toEnum(paramJSONObject.optString("trigger")); ; localTriggerType = null)
    {
      this.mTriggerType = localTriggerType;
      this.mIsFormatted = true;
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void execute(Context paramContext, ExecuteListener paramExecuteListener)
  {
  }

  public int getPermissionRequestCode()
  {
    return -1;
  }

  public String[] getRequiredPermissions()
  {
    return null;
  }

  public TriggerType getTriggerType()
  {
    return this.mTriggerType;
  }

  public abstract ActionType getType();

  public final boolean isFormatted()
  {
    return this.mIsFormatted;
  }

  public final boolean isPermissionsRequired()
  {
    return (getPermissionRequestCode() > 0) && (getRequiredPermissions() != null);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    String str;
    if (this.mTriggerType != null)
    {
      str = this.mTriggerType.getTrigger();
      paramParcel.writeString(str);
      if (!this.mIsFormatted)
        break label43;
    }
    label43: for (int i = 1; ; i = 0)
    {
      paramParcel.writeByte((byte)i);
      return;
      str = null;
      break;
    }
  }

  public static abstract interface ExecuteListener
  {
    public abstract void onFinish(Action.ExecuteStatus paramExecuteStatus);
  }

  public static enum ExecuteStatus
  {
    static
    {
      FAIL = new ExecuteStatus("FAIL", 1);
      NO_CONNECTION = new ExecuteStatus("NO_CONNECTION", 2);
      ExecuteStatus[] arrayOfExecuteStatus = new ExecuteStatus[3];
      arrayOfExecuteStatus[0] = OK;
      arrayOfExecuteStatus[1] = FAIL;
      arrayOfExecuteStatus[2] = NO_CONNECTION;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.action.Action
 * JD-Core Version:    0.6.2
 */