package com.viber.voip.messages.orm.entity.json.action;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.messages.orm.entity.json.ActionType;
import com.viber.voip.messages.orm.entity.json.TriggerType;
import com.viber.voip.publicaccount.d.a;
import com.viber.voip.util.ViberActionRunner.be;
import com.viber.voip.util.bk;
import com.viber.voip.util.links.SimpleOpenUrlSpec;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenUrlAction extends Action
{
  public static final Parcelable.Creator<OpenUrlAction> CREATOR = new Parcelable.Creator()
  {
    public OpenUrlAction createFromParcel(Parcel paramAnonymousParcel)
    {
      return new OpenUrlAction(paramAnonymousParcel);
    }

    public OpenUrlAction[] newArray(int paramAnonymousInt)
    {
      return new OpenUrlAction[paramAnonymousInt];
    }
  };
  private static final String KEY_EXTERNAL = "external";
  public static final String KEY_URL = "url";
  protected boolean mExternal;
  protected final String mUrl;
  private transient SimpleOpenUrlSpec mUrlSpec;

  OpenUrlAction(Parcel paramParcel)
  {
    super(paramParcel);
    this.mUrl = paramParcel.readString();
    if (paramParcel.readInt() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.mExternal = bool;
      return;
    }
  }

  protected OpenUrlAction(OpenUrlAction paramOpenUrlAction)
  {
    super(paramOpenUrlAction);
    this.mUrl = paramOpenUrlAction.mUrl;
    this.mExternal = paramOpenUrlAction.mExternal;
  }

  public OpenUrlAction(String paramString)
  {
    this.mUrl = paramString;
    this.mExternal = true;
  }

  OpenUrlAction(JSONObject paramJSONObject)
    throws JSONException
  {
    super(paramJSONObject);
    JSONObject localJSONObject = paramJSONObject.getJSONObject("parameters");
    this.mUrl = localJSONObject.getString("url");
    this.mExternal = localJSONObject.getBoolean("external");
  }

  private void finishListener(Action.ExecuteListener paramExecuteListener, Action.ExecuteStatus paramExecuteStatus)
  {
    if (paramExecuteListener != null)
      paramExecuteListener.onFinish(paramExecuteStatus);
  }

  private SimpleOpenUrlSpec getUrlSpec()
  {
    if (this.mUrlSpec != null)
      return this.mUrlSpec;
    SimpleOpenUrlSpec localSimpleOpenUrlSpec = createUrlSpec();
    this.mUrlSpec = localSimpleOpenUrlSpec;
    return localSimpleOpenUrlSpec;
  }

  protected SimpleOpenUrlSpec createUrlSpec()
  {
    return new SimpleOpenUrlSpec(this.mUrl, this.mExternal, true);
  }

  public int describeContents()
  {
    return 0;
  }

  public void execute(Context paramContext, Action.ExecuteListener paramExecuteListener)
  {
    if ((TriggerType.VIEW_PG_FROM_FORWARDED_PG_CONTENT == getTriggerType()) && (a.a().e()))
    {
      finishListener(paramExecuteListener, Action.ExecuteStatus.FAIL);
      return;
    }
    super.execute(paramContext, paramExecuteListener);
    if ((isFormatted()) && (!bk.a(this.mUrl)))
    {
      finishListener(paramExecuteListener, Action.ExecuteStatus.FAIL);
      return;
    }
    if (ViberActionRunner.be.a(paramContext, getUrlSpec()));
    for (Action.ExecuteStatus localExecuteStatus = Action.ExecuteStatus.OK; ; localExecuteStatus = Action.ExecuteStatus.FAIL)
    {
      finishListener(paramExecuteListener, localExecuteStatus);
      return;
    }
  }

  public ActionType getType()
  {
    return ActionType.OPEN_URL;
  }

  public String getUrl()
  {
    return this.mUrl;
  }

  final void invalidateUrlSpec()
  {
    this.mUrlSpec = null;
  }

  public void setIsExternal(boolean paramBoolean)
  {
    this.mExternal = paramBoolean;
    invalidateUrlSpec();
  }

  public String toString()
  {
    return "OpenUrlAction{mUrl='" + this.mUrl + '\'' + ", mExternal=" + this.mExternal + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mUrl);
    if (this.mExternal);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.action.OpenUrlAction
 * JD-Core Version:    0.6.2
 */