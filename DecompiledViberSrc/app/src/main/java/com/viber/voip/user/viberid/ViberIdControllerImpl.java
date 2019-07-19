package com.viber.voip.user.viberid;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.CActOnViberIdPasswordMsg;
import com.viber.jni.im2.CActOnViberIdPasswordReplyMsg;
import com.viber.jni.im2.CChangeViberIdEmailMsg;
import com.viber.jni.im2.CChangeViberIdEmailReplyMsg;
import com.viber.jni.im2.CCheckEmailStatusMsg;
import com.viber.jni.im2.CCheckEmailStatusReplyMsg;
import com.viber.jni.im2.CGetViberIdMsg;
import com.viber.jni.im2.CGetViberIdReplyMsg;
import com.viber.jni.im2.CRegisterViberIdMsg;
import com.viber.jni.im2.CRegisterViberIdReplyMsg;
import com.viber.jni.im2.CUnlinkViberIdMsg;
import com.viber.jni.im2.CUnlinkViberIdReplyMsg;
import com.viber.jni.im2.CViberIdChangedMsg;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.jni.im2.interfaces.ViberIdReceiver;
import com.viber.jni.im2.interfaces.ViberIdSender;
import com.viber.jni.viberid.ViberIdVersionDelegate;
import com.viber.jni.viberid.ViberIdVersionListener;
import com.viber.voip.ViberEnv;
import com.viber.voip.i.f;
import com.viber.voip.i.f.a;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.registration.af;
import com.viber.voip.user.UserData;
import com.viber.voip.util.av;
import org.greenrobot.eventbus.EventBus;

public class ViberIdControllerImpl
  implements ViberIdReceiver, ViberIdVersionDelegate, f.a, ViberIdController
{
  private static final Logger L = ViberEnv.getLogger();
  private final Context mContext;
  private final EventBus mEventBus;
  private final f mFeatureSwitcher;
  private final Handler mHandler;
  private final dagger.a<bs> mMessageEditHelper;
  private final com.viber.voip.analytics.story.g.a mOtherEventsTracker;
  private ViberIdController.PendingEmailChangingRequest mPendingEmailChangingRequest;
  private ViberIdController.PendingEmailRequest mPendingEmailRequest;
  private ViberIdController.PendingPasswordActionRequest mPendingPasswordActionRequest;
  private final Object mPendingRegistrationLock = new Object();
  private ViberIdController.PendingRegistrationRequest mPendingRegistrationRequest;
  private ViberIdController.PendingUnlinkViberIdRequest mPendingUnlinkViberIdRequest;
  private final PhoneController mPhoneController;
  private final ViberIdPromoStickerPackHelper mPromoStickerPackHelper;
  private final af mRegistrationValues;
  private final UserData mUserData;
  private final ViberIdDialogController mViberIdDialogController;
  private final ViberIdSender mViberIdSender;

  public ViberIdControllerImpl(Context paramContext, Im2Exchanger paramIm2Exchanger, PhoneController paramPhoneController, Handler paramHandler, EventBus paramEventBus, UserData paramUserData, af paramaf, f paramf, dagger.a<bs> parama, ViberIdPromoStickerPackHelper paramViberIdPromoStickerPackHelper, ViberIdDialogController paramViberIdDialogController, com.viber.voip.analytics.story.g.a parama1)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mViberIdSender = paramIm2Exchanger;
    this.mPhoneController = paramPhoneController;
    this.mHandler = paramHandler;
    this.mEventBus = paramEventBus;
    this.mUserData = paramUserData;
    this.mRegistrationValues = paramaf;
    this.mFeatureSwitcher = paramf;
    this.mMessageEditHelper = parama;
    this.mPromoStickerPackHelper = paramViberIdPromoStickerPackHelper;
    this.mViberIdDialogController = paramViberIdDialogController;
    this.mOtherEventsTracker = parama1;
  }

  private void getViberId()
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        int i = ViberIdControllerImpl.this.mPhoneController.generateSequence();
        ViberIdControllerImpl.this.mViberIdSender.handleCGetViberIdMsg(new CGetViberIdMsg(i));
      }
    });
  }

  private void performActionOnViberIdPassword(CActOnViberIdPasswordMsg paramCActOnViberIdPasswordMsg)
  {
    if (TextUtils.isEmpty(paramCActOnViberIdPasswordMsg.email));
    for (String str = getViberIdInfo().getEmail(); ; str = paramCActOnViberIdPasswordMsg.email)
    {
      this.mPendingPasswordActionRequest = new ViberIdController.PendingPasswordActionRequest(paramCActOnViberIdPasswordMsg.seq, str, paramCActOnViberIdPasswordMsg.oldPassword, paramCActOnViberIdPasswordMsg.newPassword, paramCActOnViberIdPasswordMsg.action);
      this.mViberIdSender.handleCActOnViberIdPasswordMsg(paramCActOnViberIdPasswordMsg);
      return;
    }
  }

  private void resetViberIdInfoAndNotify(int paramInt)
  {
    this.mUserData.resetViberIdInfo(paramInt);
    setViberInfoAndNotify(getViberIdInfo());
  }

  private void setViberInfoAndNotify(ViberIdInfo paramViberIdInfo)
  {
    this.mUserData.setViberIdInfo(paramViberIdInfo);
    this.mEventBus.post(new ViberIdEvents.ViberIdInfoChangedEvent(paramViberIdInfo));
  }

  private void setViberInfoAndNotify(String paramString, int paramInt, boolean paramBoolean)
  {
    setViberInfoAndNotify(new ViberIdInfo(paramString, paramInt, paramBoolean));
  }

  public void cancelEmailStatusCheck()
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        ViberIdControllerImpl.access$402(ViberIdControllerImpl.this, null);
      }
    });
  }

  public void changeEmail(final String paramString1, final String paramString2)
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        int i = ViberIdControllerImpl.this.mPhoneController.generateSequence();
        if (!ViberIdControllerImpl.this.getViberIdInfo().isAccountExist())
          return;
        ViberIdControllerImpl.access$602(ViberIdControllerImpl.this, new ViberIdController.PendingEmailChangingRequest(i, paramString1, paramString2));
        ViberIdControllerImpl.this.mViberIdSender.handleCChangeViberIdEmailMsg(new CChangeViberIdEmailMsg(i, paramString1, paramString2));
      }
    });
  }

  public void changePassword(final String paramString1, final String paramString2)
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        int i = ViberIdControllerImpl.this.mPhoneController.generateSequence();
        ViberIdControllerImpl.this.performActionOnViberIdPassword(CActOnViberIdPasswordMsg.createChangePasswordMessage(i, paramString1, paramString2));
      }
    });
  }

  public void checkEmailStatus(final String paramString)
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        int i = ViberIdControllerImpl.this.mPhoneController.generateSequence();
        ViberIdControllerImpl.access$402(ViberIdControllerImpl.this, new ViberIdController.PendingEmailRequest(i, paramString));
        ViberIdControllerImpl.this.mViberIdSender.handleCCheckEmailStatusMsg(new CCheckEmailStatusMsg(i, paramString));
      }
    });
  }

  public EventBus getEventBus()
  {
    return this.mEventBus;
  }

  public ViberIdController.PendingRegistrationRequest getPendingRegistrationRequest()
  {
    synchronized (this.mPendingRegistrationLock)
    {
      ViberIdController.PendingRegistrationRequest localPendingRegistrationRequest = this.mPendingRegistrationRequest;
      return localPendingRegistrationRequest;
    }
  }

  public ViberIdInfo getViberIdInfo()
  {
    return this.mUserData.getViberIdInfo();
  }

  public void init(Im2Exchanger paramIm2Exchanger, ViberIdVersionListener paramViberIdVersionListener)
  {
    paramIm2Exchanger.registerDelegate(this, this.mHandler);
    this.mFeatureSwitcher.a(this);
    paramViberIdVersionListener.registerDelegate(new ViberIdVersionDelegate[] { this });
    this.mViberIdDialogController.init();
  }

  public void onCActOnViberIdPasswordReplyMsg(CActOnViberIdPasswordReplyMsg paramCActOnViberIdPasswordReplyMsg)
  {
    Object localObject;
    if ((this.mPendingPasswordActionRequest != null) && (this.mPendingPasswordActionRequest.seq == paramCActOnViberIdPasswordReplyMsg.seq))
    {
      if ((this.mPendingPasswordActionRequest.action != 0) && (paramCActOnViberIdPasswordReplyMsg.status == 0))
        setViberInfoAndNotify(this.mPendingPasswordActionRequest.email, paramCActOnViberIdPasswordReplyMsg.version, true);
      if (this.mPendingPasswordActionRequest.action != 0)
        break label98;
      localObject = new ViberIdEvents.ViberIdForgotPasswordActionEvent(paramCActOnViberIdPasswordReplyMsg.status, paramCActOnViberIdPasswordReplyMsg.version);
    }
    while (true)
    {
      if (localObject != null)
        this.mEventBus.post(localObject);
      this.mPendingPasswordActionRequest = null;
      return;
      label98: if (2 == this.mPendingPasswordActionRequest.action)
      {
        localObject = new ViberIdEvents.ViberIdRetypePasswordActionEvent(paramCActOnViberIdPasswordReplyMsg.status, paramCActOnViberIdPasswordReplyMsg.version);
        this.mOtherEventsTracker.a("Rakuten", true);
      }
      else if (1 == this.mPendingPasswordActionRequest.action)
      {
        localObject = new ViberIdEvents.ViberIdChangePasswordActionEvent(paramCActOnViberIdPasswordReplyMsg.status, paramCActOnViberIdPasswordReplyMsg.version);
      }
      else
      {
        localObject = null;
      }
    }
  }

  public void onCChangeViberIdEmailReplyMsg(CChangeViberIdEmailReplyMsg paramCChangeViberIdEmailReplyMsg)
  {
    if ((this.mPendingEmailChangingRequest != null) && (this.mPendingEmailChangingRequest.seq == paramCChangeViberIdEmailReplyMsg.seq))
    {
      if (paramCChangeViberIdEmailReplyMsg.status == 0)
        setViberInfoAndNotify(this.mPendingEmailChangingRequest.email, paramCChangeViberIdEmailReplyMsg.version, true);
      this.mEventBus.post(new ViberIdEvents.ViberIdEmailChangingEvent(paramCChangeViberIdEmailReplyMsg.status));
      this.mPendingEmailChangingRequest = null;
    }
  }

  public void onCCheckEmailStatusReplyMsg(CCheckEmailStatusReplyMsg paramCCheckEmailStatusReplyMsg)
  {
    if ((this.mPendingEmailRequest != null) && (this.mPendingEmailRequest.seq == paramCCheckEmailStatusReplyMsg.seq))
    {
      this.mEventBus.post(new ViberIdEvents.ViberIdEmailStatusEvent(this.mPendingEmailRequest.email, paramCCheckEmailStatusReplyMsg.status, this.mRegistrationValues.q()));
      this.mPendingEmailRequest = null;
    }
  }

  public void onCGetViberIdReplyMsg(CGetViberIdReplyMsg paramCGetViberIdReplyMsg)
  {
    if (paramCGetViberIdReplyMsg.status == 0)
      setViberInfoAndNotify(paramCGetViberIdReplyMsg.email, paramCGetViberIdReplyMsg.version, getViberIdInfo().isRegisteredOnCurrentDevice());
    while (3 != paramCGetViberIdReplyMsg.status)
      return;
    resetViberIdInfoAndNotify(getViberIdInfo().getVersion());
  }

  public void onCRegisterViberIdReplyMsg(CRegisterViberIdReplyMsg paramCRegisterViberIdReplyMsg)
  {
    synchronized (this.mPendingRegistrationLock)
    {
      ViberIdController.PendingRegistrationRequest localPendingRegistrationRequest1 = this.mPendingRegistrationRequest;
      ViberIdController.PendingRegistrationRequest localPendingRegistrationRequest2 = null;
      if (localPendingRegistrationRequest1 != null)
      {
        int i = this.mPendingRegistrationRequest.seq;
        int j = paramCRegisterViberIdReplyMsg.seq;
        localPendingRegistrationRequest2 = null;
        if (i == j)
        {
          localPendingRegistrationRequest2 = this.mPendingRegistrationRequest;
          this.mPendingRegistrationRequest = null;
        }
      }
      if ((localPendingRegistrationRequest2 != null) && (localPendingRegistrationRequest2.seq == paramCRegisterViberIdReplyMsg.seq))
      {
        if (1 == paramCRegisterViberIdReplyMsg.status)
        {
          setViberInfoAndNotify(localPendingRegistrationRequest2.email, paramCRegisterViberIdReplyMsg.version, true);
          this.mOtherEventsTracker.a("Rakuten", true);
        }
        this.mEventBus.post(new ViberIdEvents.ViberIdRegistrationEvent(localPendingRegistrationRequest2.email, paramCRegisterViberIdReplyMsg.version, paramCRegisterViberIdReplyMsg.status));
      }
      return;
    }
  }

  public void onCUnlinkViberIdReplyMsg(CUnlinkViberIdReplyMsg paramCUnlinkViberIdReplyMsg)
  {
    if ((this.mPendingUnlinkViberIdRequest != null) && (this.mPendingUnlinkViberIdRequest.seq == paramCUnlinkViberIdReplyMsg.seq))
    {
      if (paramCUnlinkViberIdReplyMsg.status == 0)
        resetViberIdInfoAndNotify(paramCUnlinkViberIdReplyMsg.version);
      this.mEventBus.post(new ViberIdEvents.UnlinkViberIdEvent(paramCUnlinkViberIdReplyMsg.status));
      this.mPendingUnlinkViberIdRequest = null;
    }
  }

  public void onCViberIdChangedMsg(CViberIdChangedMsg paramCViberIdChangedMsg)
  {
    ViberIdInfo localViberIdInfo = getViberIdInfo();
    if (paramCViberIdChangedMsg.flags == 0)
      resetViberIdInfoAndNotify(paramCViberIdChangedMsg.version);
    do
    {
      return;
      if (av.d(paramCViberIdChangedMsg.flags, 2))
      {
        resetViberIdInfoAndNotify(paramCViberIdChangedMsg.version);
        ((bs)this.mMessageEditHelper.get()).b(ViberIdMessageUtil.createEmailConnectedSystemMessage(this.mContext, localViberIdInfo.getEmail()));
        return;
      }
    }
    while ((!localViberIdInfo.isAccountExist()) || (localViberIdInfo.getEmail().equals(paramCViberIdChangedMsg.email)));
    setViberInfoAndNotify(paramCViberIdChangedMsg.email, paramCViberIdChangedMsg.version, true);
    this.mViberIdDialogController.showAccountDitailsUpdatedOnRakutenSide();
  }

  public void onFeatureStateChanged(f paramf)
  {
    if (!paramf.e())
    {
      this.mUserData.resetViberIdInfo(0);
      setViberInfoAndNotify(getViberIdInfo());
    }
  }

  public void onUpdateViberIdVersion(int paramInt)
  {
    if (paramInt > getViberIdInfo().getVersion())
      getViberId();
  }

  public void performForgotPasswordAction(final String paramString)
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        int i = ViberIdControllerImpl.this.mPhoneController.generateSequence();
        ViberIdControllerImpl localViberIdControllerImpl = ViberIdControllerImpl.this;
        if (paramString == null);
        for (String str = ""; ; str = paramString)
        {
          localViberIdControllerImpl.performActionOnViberIdPassword(CActOnViberIdPasswordMsg.createForgotPasswordMessage(i, str));
          return;
        }
      }
    });
  }

  public void registerViberId(final String paramString1, final String paramString2, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        int i = ViberIdControllerImpl.this.mPhoneController.generateSequence();
        synchronized (ViberIdControllerImpl.this.mPendingRegistrationLock)
        {
          ViberIdControllerImpl.access$302(ViberIdControllerImpl.this, new ViberIdController.PendingRegistrationRequest(i, paramString1, paramString2, paramBoolean1, paramBoolean2));
          ViberIdControllerImpl.this.mViberIdSender.handleCRegisterViberIdMsg(new CRegisterViberIdMsg(i, paramString1, paramString2, paramBoolean2));
          return;
        }
      }
    });
  }

  public void retypePassword(final String paramString)
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        int i = ViberIdControllerImpl.this.mPhoneController.generateSequence();
        ViberIdControllerImpl.this.performActionOnViberIdPassword(CActOnViberIdPasswordMsg.createRetypePasswordMessage(i, paramString));
      }
    });
  }

  public void sendFreeStickerPackMessage()
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        MessageEntity localMessageEntity = ViberIdControllerImpl.this.mPromoStickerPackHelper.createFreeStickerPackMessage(ViberIdControllerImpl.this.mContext);
        if (localMessageEntity != null)
          ((bs)ViberIdControllerImpl.this.mMessageEditHelper.get()).b(localMessageEntity);
      }
    });
  }

  public void unlinkViberId()
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        int i = ViberIdControllerImpl.this.mPhoneController.generateSequence();
        if (!ViberIdControllerImpl.this.getViberIdInfo().isAccountExist())
          return;
        ViberIdControllerImpl.access$702(ViberIdControllerImpl.this, new ViberIdController.PendingUnlinkViberIdRequest(i));
        ViberIdControllerImpl.this.mViberIdSender.handleCUnlinkViberIdMsg(new CUnlinkViberIdMsg(i));
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.ViberIdControllerImpl
 * JD-Core Version:    0.6.2
 */