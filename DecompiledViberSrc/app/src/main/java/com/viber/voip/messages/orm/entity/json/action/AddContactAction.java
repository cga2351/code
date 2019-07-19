package com.viber.voip.messages.orm.entity.json.action;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.ViberApplication;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.m;
import com.viber.voip.messages.orm.entity.json.ActionType;
import com.viber.voip.model.entity.g;
import com.viber.voip.permissions.n;
import com.viber.voip.registration.ao;
import com.viber.voip.util.ViberActionRunner.c;
import com.viber.voip.util.ViberActionRunner.o;
import com.viber.voip.util.dr;
import com.viber.voip.util.dr.a;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class AddContactAction extends Action
{
  public static final Parcelable.Creator<AddContactAction> CREATOR = new Parcelable.Creator()
  {
    public AddContactAction createFromParcel(Parcel paramAnonymousParcel)
    {
      return new AddContactAction(paramAnonymousParcel);
    }

    public AddContactAction[] newArray(int paramAnonymousInt)
    {
      return new AddContactAction[paramAnonymousInt];
    }
  };
  public static final String KEY_ACTION_PARAM_ALREADY_ADDED_ACTION = "already_added_action";
  public static final String KEY_CONTACT_NAME = "contact_name";
  public static final String KEY_CONTACT_NUMBER = "contact_number";
  public static final String KEY_SORT_NAME = "sort_name";
  private final String mActionIfAdded;
  private final String mContactName;
  private final String mContactNumber;
  private final String mSortName;

  AddContactAction(Parcel paramParcel)
  {
    super(paramParcel);
    this.mContactNumber = paramParcel.readString();
    this.mContactName = paramParcel.readString();
    this.mSortName = paramParcel.readString();
    this.mActionIfAdded = paramParcel.readString();
  }

  AddContactAction(JSONObject paramJSONObject)
    throws JSONException
  {
    super(paramJSONObject);
    JSONObject localJSONObject = paramJSONObject.getJSONObject("parameters");
    this.mContactNumber = localJSONObject.getString("contact_number");
    this.mContactName = localJSONObject.getString("contact_name");
    this.mSortName = localJSONObject.getString("sort_name");
    if (localJSONObject.has("already_added_action"))
    {
      this.mActionIfAdded = localJSONObject.getString("already_added_action");
      return;
    }
    this.mActionIfAdded = ActionType.ADD_CONTACT.getAction();
  }

  private boolean isSavedContact(boolean paramBoolean, g paramg)
  {
    return (paramBoolean) && (paramg != null) && (paramg.getId() > 0L);
  }

  private void openContactDetails(Context paramContext, g paramg)
  {
    ViberActionRunner.o.a(paramContext, ViberApplication.isTablet(paramContext), paramg.getId(), paramg.k(), paramg.q(), paramg.o());
  }

  public int describeContents()
  {
    return 0;
  }

  public void execute(final Context paramContext, final Action.ExecuteListener paramExecuteListener)
  {
    super.execute(paramContext, paramExecuteListener);
    dr.a(this.mContactNumber, new dr.a()
    {
      public void onCheckStatus(boolean paramAnonymousBoolean, int paramAnonymousInt, ParticipantSelector.Participant paramAnonymousParticipant, g paramAnonymousg)
      {
        switch (paramAnonymousInt)
        {
        case 2:
        case 3:
        case 4:
        default:
          paramExecuteListener.onFinish(Action.ExecuteStatus.FAIL);
          return;
        case 0:
          if (AddContactAction.this.mActionIfAdded.equals(ActionType.OPEN_CONVERSATION.getAction()))
          {
            Intent localIntent = m.a(((Member)paramAnonymousg.d().get(paramAnonymousParticipant.getNumber())).getId(), AddContactAction.this.mContactNumber, AddContactAction.this.mContactName, false, false, false, false);
            paramContext.startActivity(localIntent);
          }
          while (true)
          {
            paramExecuteListener.onFinish(Action.ExecuteStatus.OK);
            return;
            if (AddContactAction.this.isSavedContact(paramAnonymousBoolean, paramAnonymousg))
              AddContactAction.this.openContactDetails(paramContext, paramAnonymousg);
            else
              ViberActionRunner.c.b(paramContext, paramAnonymousParticipant.getNumber(), AddContactAction.this.mContactName, "Manual", "Formatted message");
          }
        case 1:
        case 5:
        case 6:
        case 7:
        }
        if (AddContactAction.this.isSavedContact(paramAnonymousBoolean, paramAnonymousg))
          AddContactAction.this.openContactDetails(paramContext, paramAnonymousg);
        while (true)
        {
          paramExecuteListener.onFinish(Action.ExecuteStatus.OK);
          return;
          if (!ao.f())
            ViberActionRunner.c.b(paramContext, paramAnonymousParticipant.getNumber(), AddContactAction.this.mContactName, "Manual", "Formatted message");
        }
      }
    });
  }

  public String getContactName()
  {
    return this.mContactName;
  }

  public String getContactNumber()
  {
    return this.mContactNumber;
  }

  public int getPermissionRequestCode()
  {
    return 74;
  }

  public String[] getRequiredPermissions()
  {
    return n.k;
  }

  public String getSortName()
  {
    return this.mSortName;
  }

  public ActionType getType()
  {
    return ActionType.ADD_CONTACT;
  }

  public String toString()
  {
    return getType() + " {contactNumber='" + this.mContactNumber + '\'' + ", contactName='" + this.mContactName + '\'' + ", sortName='" + this.mSortName + '\'' + ", actionIfAdded='" + this.mActionIfAdded + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mContactNumber);
    paramParcel.writeString(this.mContactName);
    paramParcel.writeString(this.mSortName);
    paramParcel.writeString(this.mActionIfAdded);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.action.AddContactAction
 * JD-Core Version:    0.6.2
 */