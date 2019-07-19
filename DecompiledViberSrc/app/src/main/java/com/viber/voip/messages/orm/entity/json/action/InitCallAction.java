package com.viber.voip.messages.orm.entity.json.action;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.widget.Toast;
import com.viber.jni.Engine;
import com.viber.jni.dialer.DialerController;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.analytics.story.b.a.h;
import com.viber.voip.analytics.story.b.a.h.a;
import com.viber.voip.analytics.story.b.a.h.a.a;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.messages.orm.entity.json.ActionType;
import com.viber.voip.model.entity.g;
import com.viber.voip.permissions.n;
import com.viber.voip.phone.call.CallInitiationId;
import com.viber.voip.util.dr;
import com.viber.voip.util.dr.a;
import dagger.a;
import org.json.JSONException;
import org.json.JSONObject;

public class InitCallAction extends Action
{
  public static final Parcelable.Creator<InitCallAction> CREATOR = new Parcelable.Creator()
  {
    public InitCallAction createFromParcel(Parcel paramAnonymousParcel)
    {
      return new InitCallAction(paramAnonymousParcel);
    }

    public InitCallAction[] newArray(int paramAnonymousInt)
    {
      return new InitCallAction[paramAnonymousInt];
    }
  };
  private static final String KEY_CALL_NUMBER = "call";
  private final String mCallNumber;

  InitCallAction(Parcel paramParcel)
  {
    super(paramParcel);
    this.mCallNumber = paramParcel.readString();
  }

  InitCallAction(JSONObject paramJSONObject)
    throws JSONException
  {
    super(paramJSONObject);
    this.mCallNumber = paramJSONObject.getJSONObject("parameters").getString("call");
  }

  public int describeContents()
  {
    return 0;
  }

  public void execute(Context paramContext, final Action.ExecuteListener paramExecuteListener)
  {
    super.execute(paramContext, paramExecuteListener);
    if (TextUtils.isEmpty(this.mCallNumber))
    {
      Toast.makeText(paramContext, R.string.viberout_dialog_regular_call_unsupported_title, 1).show();
      if (paramExecuteListener != null)
        paramExecuteListener.onFinish(Action.ExecuteStatus.FAIL);
      return;
    }
    dr.a(this.mCallNumber, new dr.a()
    {
      public void onCheckStatus(boolean paramAnonymousBoolean, int paramAnonymousInt, ParticipantSelector.Participant paramAnonymousParticipant, g paramAnonymousg)
      {
        boolean bool1;
        boolean bool2;
        if ((1 == paramAnonymousInt) || (7 == paramAnonymousInt))
        {
          bool1 = true;
          CallInitiationId.noteNextCallInitiationAttemptId();
          h localh = (h)ViberApplication.getInstance().getLazyUserStartsCallEventCollector().get();
          h.a.a locala1 = h.a.i();
          String[] arrayOfString = new String[1];
          arrayOfString[0] = InitCallAction.this.mCallNumber;
          h.a.a locala2 = locala1.a(arrayOfString).a(bool1, false).a("Message").b(bool1);
          if (bool1)
            break label157;
          bool2 = true;
          label89: localh.b(locala2.a(bool2).a());
          if (!bool1)
            break label163;
          ViberApplication.getInstance().getEngine(true).getDialerController().handleDialViberOut(InitCallAction.this.mCallNumber);
        }
        while (true)
        {
          if (paramExecuteListener != null)
            paramExecuteListener.onFinish(Action.ExecuteStatus.OK);
          return;
          bool1 = false;
          break;
          label157: bool2 = false;
          break label89;
          label163: ViberApplication.getInstance().getEngine(true).getDialerController().handleDial(InitCallAction.this.mCallNumber, false);
        }
      }
    });
  }

  public String getCallNumber()
  {
    return this.mCallNumber;
  }

  public int getPermissionRequestCode()
  {
    return 56;
  }

  public String[] getRequiredPermissions()
  {
    return n.h;
  }

  public ActionType getType()
  {
    return ActionType.INIT_CALL;
  }

  public String toString()
  {
    return getType() + " {callNumber='" + this.mCallNumber + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mCallNumber);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.action.InitCallAction
 * JD-Core Version:    0.6.2
 */