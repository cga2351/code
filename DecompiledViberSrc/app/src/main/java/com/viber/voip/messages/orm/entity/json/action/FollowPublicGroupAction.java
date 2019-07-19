package com.viber.voip.messages.orm.entity.json.action;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.ViberApplication;
import com.viber.voip.api.scheme.i;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.t;
import com.viber.voip.messages.controller.publicaccount.ae;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationData;
import com.viber.voip.messages.k;
import com.viber.voip.messages.m;
import com.viber.voip.messages.orm.entity.json.ActionType;
import com.viber.voip.publicaccount.d.a;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.util.ViberActionRunner.aq;
import com.viber.voip.util.bk;
import org.json.JSONException;
import org.json.JSONObject;

public class FollowPublicGroupAction extends PreviewPublicGroupAction
{
  public static final Parcelable.Creator<FollowPublicGroupAction> CREATOR = new Parcelable.Creator()
  {
    public FollowPublicGroupAction createFromParcel(Parcel paramAnonymousParcel)
    {
      return new FollowPublicGroupAction(paramAnonymousParcel);
    }

    public FollowPublicGroupAction[] newArray(int paramAnonymousInt)
    {
      return new FollowPublicGroupAction[paramAnonymousInt];
    }
  };
  private static final String KEY_GROUP_ID = "group_id";
  private static final String KEY_INVITATION_TOKEN = "invitation_token";
  private static final String KEY_INVITING_NUMBER = "inviting_number";
  private static final String KEY_OPEN_BOT = "open_bot";
  private static final String KEY_REVISION = "revision";
  private final long mGroupId;
  private final long mInvitationToken;
  private final String mInvitingNumber;
  private boolean mOpenBot;
  private boolean mOpenOnFollow;
  private final int mRevision;
  private ae mSource;

  FollowPublicGroupAction(Parcel paramParcel)
  {
    super(paramParcel);
    this.mOpenOnFollow = i;
    this.mGroupId = paramParcel.readLong();
    this.mInvitationToken = paramParcel.readLong();
    this.mInvitingNumber = paramParcel.readString();
    this.mRevision = paramParcel.readInt();
    if (paramParcel.readByte() == i);
    while (true)
    {
      this.mOpenBot = i;
      return;
      i = 0;
    }
  }

  public FollowPublicGroupAction(String paramString, ae paramae, boolean paramBoolean)
  {
    super(paramString);
    this.mOpenOnFollow = true;
    this.mGroupId = 0L;
    this.mInvitationToken = 0L;
    this.mInvitingNumber = null;
    this.mRevision = 0;
    this.mSource = paramae;
    this.mOpenOnFollow = paramBoolean;
  }

  FollowPublicGroupAction(JSONObject paramJSONObject)
    throws JSONException
  {
    super(paramJSONObject);
    this.mOpenOnFollow = bool;
    JSONObject localJSONObject = paramJSONObject.getJSONObject("parameters");
    this.mGroupId = bk.a("group_id", localJSONObject.getString("group_id"));
    this.mInvitationToken = bk.a("invitation_token", localJSONObject.getString("invitation_token"));
    this.mInvitingNumber = localJSONObject.getString("inviting_number");
    this.mRevision = bk.b("revision", localJSONObject.getString("revision"));
    if ((localJSONObject.has("open_bot")) && (localJSONObject.getBoolean("open_bot")));
    while (true)
    {
      this.mOpenBot = bool;
      return;
      bool = false;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void execute(Context paramContext, Action.ExecuteListener paramExecuteListener)
  {
    if (!a.a().e())
    {
      a.a().b();
      super.execute(paramContext, paramExecuteListener);
      return;
    }
    paramExecuteListener.onFinish(Action.ExecuteStatus.FAIL);
  }

  public long getGroupId()
  {
    return this.mGroupId;
  }

  public long getInvitationToken()
  {
    return this.mInvitationToken;
  }

  public String getInvitingNumber()
  {
    return this.mInvitingNumber;
  }

  public int getRevision()
  {
    return this.mRevision;
  }

  public ActionType getType()
  {
    return ActionType.FOLLOW_PUBLIC_GROUP;
  }

  protected void onPublicGroupInfoReady(final Context paramContext, boolean paramBoolean, final PublicAccount paramPublicAccount)
  {
    final int i = (int)(System.currentTimeMillis() / 1000L);
    if (this.mSource == null);
    GroupController localGroupController;
    for (ae localae = ae.e; ; localae = this.mSource)
    {
      this.mSource = null;
      if (!paramBoolean)
        ViberApplication.getInstance().getMessagesManager().b().a(new bv.t()
        {
          public void onJoinToPublicGroup(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            if (paramAnonymousInt1 != i);
            do
            {
              do
              {
                return;
                ViberApplication.getInstance().getMessagesManager().b().b(this);
              }
              while ((paramAnonymousInt3 != 0) && (paramAnonymousInt3 != 2));
              if (FollowPublicGroupAction.this.mOpenBot)
              {
                paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(i.a(paramPublicAccount.getPublicAccountId()))));
                return;
              }
            }
            while (!FollowPublicGroupAction.this.mOpenOnFollow);
            if (paramAnonymousInt2 == 5)
            {
              paramContext.startActivity(m.a(0L, paramAnonymousLong, null, null, paramAnonymousInt2, paramPublicAccount.getName(), false, false, false, false, false));
              return;
            }
            paramContext.startActivity(ViberActionRunner.aq.a(paramContext, true, paramPublicAccount.hasPublicChat(), new PublicGroupConversationData(paramPublicAccount)));
          }
        });
      localGroupController = ViberApplication.getInstance().getMessagesManager().d();
      if (!this.mOpenBot)
        break;
      localGroupController.a(i, paramPublicAccount.getGroupID(), this.mGroupUri, paramPublicAccount.getName(), paramPublicAccount.getIcon(), paramPublicAccount.getPublicAccountId(), this.mInvitationToken, this.mInvitingNumber, paramBoolean, localae);
      return;
    }
    localGroupController.a(i, paramPublicAccount.getGroupID(), this.mGroupUri, paramPublicAccount.getName(), paramPublicAccount.getIcon(), this.mInvitationToken, this.mInvitingNumber, paramBoolean, localae);
  }

  public String toString()
  {
    return "FollowPublicGroupAction{mGroupId=" + this.mGroupId + ", mInvitationToken=" + this.mInvitationToken + ", mInvitingNumber='" + this.mInvitingNumber + '\'' + ", mRevision=" + this.mRevision + ", mSource=" + this.mSource + ", mOpenOnFollow=" + this.mOpenOnFollow + ", mOpenBot=" + this.mOpenBot + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.mGroupId);
    paramParcel.writeLong(this.mInvitationToken);
    paramParcel.writeString(this.mInvitingNumber);
    paramParcel.writeInt(this.mRevision);
    if (this.mOpenBot);
    for (byte b = 1; ; b = 0)
    {
      paramParcel.writeByte(b);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.action.FollowPublicGroupAction
 * JD-Core Version:    0.6.2
 */