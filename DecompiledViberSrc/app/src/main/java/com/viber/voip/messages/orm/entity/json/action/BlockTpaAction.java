package com.viber.voip.messages.orm.entity.json.action;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.apps.AppsBlockerListener;
import com.viber.jni.apps.AppsController;
import com.viber.jni.apps.AppsControllerDelegate.Blocker;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberApplication;
import com.viber.voip.messages.orm.entity.json.ActionType;
import com.viber.voip.util.bk;
import org.json.JSONException;
import org.json.JSONObject;

public class BlockTpaAction extends Action
{
  public static final Parcelable.Creator<BlockTpaAction> CREATOR = new Parcelable.Creator()
  {
    public BlockTpaAction createFromParcel(Parcel paramAnonymousParcel)
    {
      return new BlockTpaAction(paramAnonymousParcel);
    }

    public BlockTpaAction[] newArray(int paramAnonymousInt)
    {
      return new BlockTpaAction[paramAnonymousInt];
    }
  };
  private static final String KEY_APP_ID = "app_id";
  private final int mAppId;

  BlockTpaAction(Parcel paramParcel)
  {
    super(paramParcel);
    this.mAppId = paramParcel.readInt();
  }

  BlockTpaAction(JSONObject paramJSONObject)
    throws JSONException
  {
    super(paramJSONObject);
    this.mAppId = bk.b("app_id", paramJSONObject.getJSONObject("parameters").getString("app_id"));
  }

  public int describeContents()
  {
    return 0;
  }

  public void execute(Context paramContext, final Action.ExecuteListener paramExecuteListener)
  {
    super.execute(paramContext, paramExecuteListener);
    final Engine localEngine = ViberApplication.getInstance().getEngine(false);
    AppsBlockerListener localAppsBlockerListener = localEngine.getDelegatesManager().getAppsBlockerListener();
    AppsControllerDelegate.Blocker[] arrayOfBlocker = new AppsControllerDelegate.Blocker[1];
    arrayOfBlocker[0] = new AppsControllerDelegate.Blocker()
    {
      public void onBlockAppReply(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        localEngine.getDelegatesManager().getAppsBlockerListener().removeDelegate(this);
        Action.ExecuteListener localExecuteListener;
        if (paramExecuteListener != null)
        {
          localExecuteListener = paramExecuteListener;
          if (paramAnonymousInt1 != 0)
            break label44;
        }
        label44: for (Action.ExecuteStatus localExecuteStatus = Action.ExecuteStatus.OK; ; localExecuteStatus = Action.ExecuteStatus.FAIL)
        {
          localExecuteListener.onFinish(localExecuteStatus);
          return;
        }
      }
    };
    localAppsBlockerListener.registerDelegate(arrayOfBlocker);
    localEngine.getAppsController().handleBlockApp(this.mAppId, true, localEngine.getPhoneController().generateSequence(), 0);
  }

  public int getAppId()
  {
    return this.mAppId;
  }

  public ActionType getType()
  {
    return ActionType.BLOCK_TPA;
  }

  public String toString()
  {
    return getType() + " {appId='" + this.mAppId + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.mAppId);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.action.BlockTpaAction
 * JD-Core Version:    0.6.2
 */