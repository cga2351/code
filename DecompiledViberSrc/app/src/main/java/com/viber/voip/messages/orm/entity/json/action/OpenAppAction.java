package com.viber.voip.messages.orm.entity.json.action;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.apps.b;
import com.viber.voip.apps.h;
import com.viber.voip.apps.h.a;
import com.viber.voip.market.b.n;
import com.viber.voip.messages.orm.entity.json.ActionType;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.bk;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenAppAction extends Action
{
  public static final Parcelable.Creator<OpenAppAction> CREATOR = new Parcelable.Creator()
  {
    public OpenAppAction createFromParcel(Parcel paramAnonymousParcel)
    {
      return new OpenAppAction(paramAnonymousParcel);
    }

    public OpenAppAction[] newArray(int paramAnonymousInt)
    {
      return new OpenAppAction[paramAnonymousInt];
    }
  };
  private static final String KEY_APP_ID = "id";
  private static final String KEY_APP_URL = "url";
  private final int mAppId;
  private final String mAppUrl;

  OpenAppAction(Parcel paramParcel)
  {
    super(paramParcel);
    this.mAppUrl = paramParcel.readString();
    this.mAppId = paramParcel.readInt();
  }

  OpenAppAction(JSONObject paramJSONObject)
    throws JSONException
  {
    super(paramJSONObject);
    JSONObject localJSONObject = paramJSONObject.getJSONObject("parameters");
    this.mAppUrl = localJSONObject.getString("url");
    this.mAppId = bk.b("id", localJSONObject.optString("id"));
  }

  public int describeContents()
  {
    return 0;
  }

  public void execute(Context paramContext, final Action.ExecuteListener paramExecuteListener)
  {
    super.execute(paramContext, paramExecuteListener);
    UserManager.from(paramContext).getAppsController().a(this.mAppId, true, new h.a()
    {
      public void onAppInfoFailed()
      {
        if (paramExecuteListener != null)
          paramExecuteListener.onFinish(Action.ExecuteStatus.FAIL);
      }

      public void onAppInfoReady(List<b> paramAnonymousList, boolean paramAnonymousBoolean)
      {
        if ((paramAnonymousList.isEmpty()) && (paramAnonymousBoolean));
        do
        {
          do
          {
            return;
            Iterator localIterator = paramAnonymousList.iterator();
            b localb;
            do
            {
              if (!localIterator.hasNext())
                break;
              localb = (b)localIterator.next();
            }
            while (localb.a() != OpenAppAction.this.mAppId);
            n.a(localb, "game_invite_viber", OpenAppAction.this.mAppUrl);
          }
          while (paramExecuteListener == null);
          paramExecuteListener.onFinish(Action.ExecuteStatus.OK);
          return;
        }
        while (paramExecuteListener == null);
        paramExecuteListener.onFinish(Action.ExecuteStatus.FAIL);
      }
    });
  }

  public int getAppId()
  {
    return this.mAppId;
  }

  public String getAppUrl()
  {
    return this.mAppUrl;
  }

  public ActionType getType()
  {
    return ActionType.OPEN_APP;
  }

  public String toString()
  {
    return getType() + " {appUrl='" + this.mAppUrl + '\'' + ", appId='" + this.mAppId + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mAppUrl);
    paramParcel.writeInt(this.mAppId);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.action.OpenAppAction
 * JD-Core Version:    0.6.2
 */