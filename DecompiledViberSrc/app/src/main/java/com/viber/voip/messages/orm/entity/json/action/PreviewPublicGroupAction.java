package com.viber.voip.messages.orm.entity.json.action;

import android.content.Context;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.common.dialogs.a.a;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.PublicAccountInfo;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.publicaccount.PublicAccountControllerDelegate.PublicAccountInfoReceiver;
import com.viber.jni.publicaccount.PublicAccountInfoReceiverListener;
import com.viber.voip.ViberApplication;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationData;
import com.viber.voip.messages.orm.entity.json.ActionType;
import com.viber.voip.model.entity.h;
import com.viber.voip.publicaccount.d.a;
import com.viber.voip.publicaccount.d.e;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.util.ViberActionRunner.aq;
import com.viber.voip.viberout.ui.TermsAndConditionsActivity.a;
import org.json.JSONException;
import org.json.JSONObject;

public class PreviewPublicGroupAction extends Action
{
  public static final Parcelable.Creator<PreviewPublicGroupAction> CREATOR = new Parcelable.Creator()
  {
    public PreviewPublicGroupAction createFromParcel(Parcel paramAnonymousParcel)
    {
      return new PreviewPublicGroupAction(paramAnonymousParcel);
    }

    public PreviewPublicGroupAction[] newArray(int paramAnonymousInt)
    {
      return new PreviewPublicGroupAction[paramAnonymousInt];
    }
  };
  private static final String KEY_GROUP_NAME = "name";
  private static final String KEY_GROUP_URI = "uri";
  private static final String KEY_IMAGE_ID = "image_id";
  protected final String mGroupName;
  protected final String mGroupUri;
  protected final String mImageId;

  PreviewPublicGroupAction(Parcel paramParcel)
  {
    super(paramParcel);
    this.mImageId = paramParcel.readString();
    this.mGroupName = paramParcel.readString();
    this.mGroupUri = paramParcel.readString();
  }

  public PreviewPublicGroupAction(String paramString)
  {
    super(new JSONObject());
    this.mImageId = "";
    this.mGroupName = "";
    this.mGroupUri = paramString;
  }

  PreviewPublicGroupAction(JSONObject paramJSONObject)
    throws JSONException
  {
    super(paramJSONObject);
    JSONObject localJSONObject = paramJSONObject.getJSONObject("parameters");
    this.mImageId = localJSONObject.getString("image_id");
    this.mGroupName = localJSONObject.getString("name");
    this.mGroupUri = localJSONObject.getString("uri");
  }

  public int describeContents()
  {
    return 0;
  }

  public void execute(final Context paramContext, final Action.ExecuteListener paramExecuteListener)
  {
    if (a.a().e())
    {
      paramExecuteListener.onFinish(Action.ExecuteStatus.FAIL);
      return;
    }
    super.execute(paramContext, paramExecuteListener);
    av.a(av.e.d).post(new Runnable()
    {
      private void obtainInfoFromServer()
      {
        Engine localEngine = ViberApplication.getInstance().getEngine(false);
        if (localEngine.getPhoneController().isConnected())
        {
          localPublicAccountInfoReceiverListener = localEngine.getDelegatesManager().getPublicAccountInfoReceiverListener();
          arrayOfPublicAccountInfoReceiver = new PublicAccountControllerDelegate.PublicAccountInfoReceiver[1];
          arrayOfPublicAccountInfoReceiver[0] = new PublicAccountControllerDelegate.PublicAccountInfoReceiver()
          {
            public void onPublicAccountInfo(int paramAnonymous2Int1, int paramAnonymous2Int2, PublicAccountInfo paramAnonymous2PublicAccountInfo)
            {
              if (paramAnonymous2Int1 == 0)
                if ((0x8 & paramAnonymous2PublicAccountInfo.getGroupFlags()) != 0)
                {
                  PreviewPublicGroupAction.2.this.val$context.startActivity(ViberActionRunner.aq.b());
                  if (PreviewPublicGroupAction.2.this.val$l != null)
                    PreviewPublicGroupAction.2.this.val$l.onFinish(Action.ExecuteStatus.OK);
                }
              while (true)
              {
                localPublicAccountInfoReceiverListener.removeDelegate(this);
                return;
                PublicAccount localPublicAccount = new PublicAccount(paramAnonymous2PublicAccountInfo);
                PreviewPublicGroupAction.this.onPublicGroupInfoReady(PreviewPublicGroupAction.2.this.val$context, localPublicAccount.isAgeRestricted(), localPublicAccount);
                break;
                if (PreviewPublicGroupAction.2.this.val$l != null)
                  PreviewPublicGroupAction.2.this.val$l.onFinish(Action.ExecuteStatus.FAIL);
              }
            }
          };
          localPublicAccountInfoReceiverListener.registerDelegate(arrayOfPublicAccountInfoReceiver);
          localEngine.getPhoneController().handleGetPublicAccountInfoChatUri(localEngine.getPhoneController().generateSequence(), PreviewPublicGroupAction.this.mGroupUri);
        }
        while (paramExecuteListener == null)
        {
          final PublicAccountInfoReceiverListener localPublicAccountInfoReceiverListener;
          PublicAccountControllerDelegate.PublicAccountInfoReceiver[] arrayOfPublicAccountInfoReceiver;
          return;
        }
        paramExecuteListener.onFinish(Action.ExecuteStatus.NO_CONNECTION);
      }

      public void run()
      {
        ab localab = ab.b();
        h localh = localab.d(PreviewPublicGroupAction.this.mGroupUri);
        com.viber.voip.model.entity.r localr = localab.c(PreviewPublicGroupAction.this.mGroupUri);
        if ((localh != null) && (localr != null))
        {
          PublicAccount localPublicAccount = new PublicAccount(localh, localr);
          boolean bool = e.a(localh, localPublicAccount);
          PreviewPublicGroupAction.this.onPublicGroupInfoReady(paramContext, bool, localPublicAccount);
          if (paramExecuteListener != null)
            paramExecuteListener.onFinish(Action.ExecuteStatus.OK);
          return;
        }
        obtainInfoFromServer();
      }
    });
  }

  public String getGroupName()
  {
    return this.mGroupName;
  }

  public String getGroupUri()
  {
    return this.mGroupUri;
  }

  public String getImageId()
  {
    return this.mImageId;
  }

  public ActionType getType()
  {
    return ActionType.PREVIEW_PUBLIC_GROUP;
  }

  protected void onPublicGroupInfoReady(Context paramContext, boolean paramBoolean, PublicAccount paramPublicAccount)
  {
    if (paramBoolean)
    {
      com.viber.voip.ui.dialogs.r.b((int)(System.currentTimeMillis() / 1000L), -1L, paramPublicAccount.getGroupID(), null, paramPublicAccount.getGroupUri(), paramPublicAccount.getName(), 0L, "", TermsAndConditionsActivity.a.a, null).d();
      return;
    }
    PublicGroupConversationData localPublicGroupConversationData = new PublicGroupConversationData(paramPublicAccount);
    paramContext.startActivity(ViberActionRunner.aq.a(paramContext, true, localPublicGroupConversationData.publicGroupInfo.hasPublicChat(), localPublicGroupConversationData));
  }

  public String toString()
  {
    return getType() + " {imageId='" + this.mImageId + '\'' + ", groupName='" + this.mGroupName + '\'' + ", groupUri='" + this.mGroupUri + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mImageId);
    paramParcel.writeString(this.mGroupName);
    paramParcel.writeString(this.mGroupUri);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.action.PreviewPublicGroupAction
 * JD-Core Version:    0.6.2
 */