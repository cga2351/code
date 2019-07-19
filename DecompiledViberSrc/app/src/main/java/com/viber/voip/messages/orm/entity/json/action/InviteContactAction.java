package com.viber.voip.messages.orm.entity.json.action;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.messages.orm.entity.json.ActionType;
import com.viber.voip.model.entity.g;
import com.viber.voip.util.ViberActionRunner.af;
import com.viber.voip.util.dr;
import com.viber.voip.util.dr.a;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;

public class InviteContactAction extends Action
{
  public static final Parcelable.Creator<InviteContactAction> CREATOR = new Parcelable.Creator()
  {
    public InviteContactAction createFromParcel(Parcel paramAnonymousParcel)
    {
      return new InviteContactAction(paramAnonymousParcel);
    }

    public InviteContactAction[] newArray(int paramAnonymousInt)
    {
      return new InviteContactAction[paramAnonymousInt];
    }
  };
  public static final String KEY_CONTACT_NAME = "contact_name";
  public static final String KEY_CONTACT_NUMBER = "contact_number";
  public static final String KEY_SORT_NAME = "sort_name";
  private final String mContactName;
  private final String mContactNumber;
  private final String mSortName;

  InviteContactAction(Parcel paramParcel)
  {
    super(paramParcel);
    this.mContactNumber = paramParcel.readString();
    this.mContactName = paramParcel.readString();
    this.mSortName = paramParcel.readString();
  }

  InviteContactAction(JSONObject paramJSONObject)
    throws JSONException
  {
    super(paramJSONObject);
    JSONObject localJSONObject = paramJSONObject.getJSONObject("parameters");
    this.mContactNumber = localJSONObject.getString("contact_number");
    this.mContactName = localJSONObject.getString("contact_name");
    this.mSortName = localJSONObject.getString("sort_name");
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
        case 1:
        case 5:
        case 6:
        case 7:
        }
        ViberActionRunner.af.a(paramContext, Collections.singletonList(paramAnonymousParticipant.getNumber()));
        paramExecuteListener.onFinish(Action.ExecuteStatus.OK);
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

  public String getSortName()
  {
    return this.mSortName;
  }

  public ActionType getType()
  {
    return ActionType.INVITE_CONTACT;
  }

  public String toString()
  {
    return getType() + " {contactNumber='" + this.mContactNumber + '\'' + ", contactName='" + this.mContactName + '\'' + ", sortName='" + this.mSortName + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mContactNumber);
    paramParcel.writeString(this.mContactName);
    paramParcel.writeString(this.mSortName);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.action.InviteContactAction
 * JD-Core Version:    0.6.2
 */