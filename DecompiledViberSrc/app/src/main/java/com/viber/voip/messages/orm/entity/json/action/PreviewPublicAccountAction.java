package com.viber.voip.messages.orm.entity.json.action;

import android.content.Context;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.PublicAccountInfo;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.publicaccount.PublicAccountControllerDelegate.PublicAccountInfoReceiver;
import com.viber.jni.publicaccount.PublicAccountInfoReceiverListener;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.orm.entity.json.ActionType;
import com.viber.voip.model.entity.h;
import com.viber.voip.model.entity.r;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.entity.PublicAccount.Background;
import org.json.JSONObject;

public class PreviewPublicAccountAction extends Action
{
  public static final Parcelable.Creator<PreviewPublicAccountAction> CREATOR = new Parcelable.Creator()
  {
    public PreviewPublicAccountAction createFromParcel(Parcel paramAnonymousParcel)
    {
      return new PreviewPublicAccountAction(paramAnonymousParcel);
    }

    public PreviewPublicAccountAction[] newArray(int paramAnonymousInt)
    {
      return new PreviewPublicAccountAction[paramAnonymousInt];
    }
  };
  private static final Logger L = ViberEnv.getLogger();
  protected final String mPublicAccountId;
  protected final String mPublicAccountUri;

  PreviewPublicAccountAction(Parcel paramParcel)
  {
    super(paramParcel);
    this.mPublicAccountId = paramParcel.readString();
    this.mPublicAccountUri = paramParcel.readString();
  }

  public PreviewPublicAccountAction(String paramString1, String paramString2)
  {
    super(new JSONObject());
    this.mPublicAccountId = paramString1;
    this.mPublicAccountUri = paramString2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void execute(final Context paramContext, final Action.ExecuteListener paramExecuteListener)
  {
    super.execute(paramContext, paramExecuteListener);
    av.a(av.e.d).post(new Runnable()
    {
      private void obtainInfoFromServer()
      {
        int i = 1;
        Engine localEngine = ViberApplication.getInstance().getEngine(i);
        if (localEngine.getPhoneController().isConnected())
        {
          localPublicAccountInfoReceiverListener = localEngine.getDelegatesManager().getPublicAccountInfoReceiverListener();
          arrayOfPublicAccountInfoReceiver = new PublicAccountControllerDelegate.PublicAccountInfoReceiver[i];
          arrayOfPublicAccountInfoReceiver[0] = new PublicAccountControllerDelegate.PublicAccountInfoReceiver()
          {
            public void onPublicAccountInfo(int paramAnonymous2Int1, int paramAnonymous2Int2, PublicAccountInfo paramAnonymous2PublicAccountInfo)
            {
              int i = 1;
              localPublicAccountInfoReceiverListener.removeDelegate(this);
              int j;
              if (paramAnonymous2Int1 != 0)
              {
                j = i;
                if ((0x200 & paramAnonymous2PublicAccountInfo.getGroupFlags()) == 0)
                  break label70;
                label30: if ((j | i) == 0)
                  break label76;
                if (PreviewPublicAccountAction.2.this.val$executeListener != null)
                  PreviewPublicAccountAction.2.this.val$executeListener.onFinish(Action.ExecuteStatus.FAIL);
              }
              label70: label76: 
              do
              {
                return;
                j = 0;
                break;
                i = 0;
                break label30;
                PreviewPublicAccountAction.this.onPublicAccountInfoReady(PreviewPublicAccountAction.2.this.val$context, false, new PublicAccount(paramAnonymous2PublicAccountInfo));
              }
              while (PreviewPublicAccountAction.2.this.val$executeListener == null);
              PreviewPublicAccountAction.2.this.val$executeListener.onFinish(Action.ExecuteStatus.OK);
            }
          };
          localPublicAccountInfoReceiverListener.registerDelegate(arrayOfPublicAccountInfoReceiver);
          if (!TextUtils.isEmpty(PreviewPublicAccountAction.this.mPublicAccountId))
          {
            bool = localEngine.getPhoneController().handleGetPublicAccountInfoAccountId(localEngine.getPhoneController().generateSequence(), PreviewPublicAccountAction.this.mPublicAccountId, 3, i, i);
            if ((!bool) && (paramExecuteListener != null))
              paramExecuteListener.onFinish(Action.ExecuteStatus.FAIL);
          }
        }
        while (paramExecuteListener == null)
          while (true)
          {
            final PublicAccountInfoReceiverListener localPublicAccountInfoReceiverListener;
            PublicAccountControllerDelegate.PublicAccountInfoReceiver[] arrayOfPublicAccountInfoReceiver;
            boolean bool;
            return;
            if (!TextUtils.isEmpty(PreviewPublicAccountAction.this.mPublicAccountUri))
              bool = localEngine.getPhoneController().handleGetPublicAccountInfoChatUri(localEngine.getPhoneController().generateSequence(), PreviewPublicAccountAction.this.mPublicAccountUri);
            else if (paramExecuteListener != null)
              paramExecuteListener.onFinish(Action.ExecuteStatus.FAIL);
          }
        paramExecuteListener.onFinish(Action.ExecuteStatus.NO_CONNECTION);
      }

      public void run()
      {
        ab localab = ab.b();
        r localr;
        if (!TextUtils.isEmpty(PreviewPublicAccountAction.this.mPublicAccountId))
          localr = localab.a(PreviewPublicAccountAction.this.mPublicAccountId);
        while (true)
        {
          h localh1;
          h localh2;
          if (localr != null)
          {
            localh1 = localab.a(localr.b(), false);
            if (localh1 == null)
              localh2 = localab.b(localr.a());
          }
          while (true)
          {
            if ((localh1 != null) || (localh2 != null))
            {
              PublicAccount localPublicAccount = new PublicAccount();
              localPublicAccount.setGroupID(localr.a());
              localPublicAccount.setPublicAccountId(localr.b());
              localPublicAccount.setFlags(localr.x());
              if (localh2 != null)
              {
                localPublicAccount.setBackground(new PublicAccount.Background(localr.f(), null));
                localPublicAccount.setIcon(localh2.q());
                localPublicAccount.setName(localh2.o());
              }
              PreviewPublicAccountAction localPreviewPublicAccountAction = PreviewPublicAccountAction.this;
              Context localContext = paramContext;
              boolean bool = false;
              if (localh1 != null)
                bool = true;
              localPreviewPublicAccountAction.onPublicAccountInfoReady(localContext, bool, localPublicAccount);
              if (paramExecuteListener != null)
                paramExecuteListener.onFinish(Action.ExecuteStatus.OK);
              return;
              if (TextUtils.isEmpty(PreviewPublicAccountAction.this.mPublicAccountUri))
                break label244;
              localr = localab.c(PreviewPublicAccountAction.this.mPublicAccountUri);
              break;
            }
            obtainInfoFromServer();
            return;
            localh2 = null;
            continue;
            localh1 = null;
            localh2 = null;
          }
          label244: localr = null;
        }
      }
    });
  }

  public ActionType getType()
  {
    return ActionType.PREVIEW_PUBLIC_ACCOUNT;
  }

  protected void onPublicAccountInfoReady(Context paramContext, boolean paramBoolean, PublicAccount paramPublicAccount)
  {
  }

  public String toString()
  {
    return getType() + " {publicAccountId='" + this.mPublicAccountId + '\'' + ',' + "publicAccountUri='" + this.mPublicAccountUri + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mPublicAccountId);
    paramParcel.writeString(this.mPublicAccountUri);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.action.PreviewPublicAccountAction
 * JD-Core Version:    0.6.2
 */