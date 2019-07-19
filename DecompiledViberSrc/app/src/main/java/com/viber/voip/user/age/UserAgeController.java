package com.viber.voip.user.age;

import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Handler;
import com.viber.common.b.a;
import com.viber.common.b.b;
import com.viber.dexshared.Logger;
import com.viber.jni.connection.ConnectionController;
import com.viber.jni.connection.ConnectionDelegate;
import com.viber.jni.connection.ConnectionListener;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.CGetUserDateOfBirthMsg;
import com.viber.jni.im2.CGetUserDateOfBirthReplyMsg;
import com.viber.jni.im2.CGetUserDateOfBirthReplyMsg.Receiver;
import com.viber.jni.im2.CUpdateUserDateOfBirthMsg;
import com.viber.jni.im2.CUpdateUserDateOfBirthReplyMsg;
import com.viber.jni.im2.CUpdateUserDateOfBirthReplyMsg.Receiver;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.voip.ViberEnv;
import com.viber.voip.i.f.a;
import com.viber.voip.settings.d.al;

public class UserAgeController
  implements CGetUserDateOfBirthReplyMsg.Receiver, CUpdateUserDateOfBirthReplyMsg.Receiver
{
  private static final Logger L = ViberEnv.getLogger();
  private SharedPreferences.OnSharedPreferenceChangeListener mBirthdatePrefChangeListener;
  private final com.viber.common.b.d mBirthdateScreenStatePref;
  private final ConnectionController mConnectionController;
  private final ConnectionDelegate mConnectionDelegate = new ConnectionDelegate()
  {
    public void onConnect()
    {
      if ((UserAgeController.this.mGdprMainPrimaryFeature.e()) && (UserAgeController.this.mUpdateUserBirthdateRequestSeqPref.d() != UserAgeController.this.mUpdateUserBirthdateRequestSeqPref.f()))
        UserAgeController.this.sendUserBirthdateUpdateRequest();
      if (UserAgeController.this.mReceiveUserBirthdateLatestSeq.d() > 0)
      {
        if (UserAgeController.this.mGdprMainPrimaryFeature.e())
          UserAgeController.this.tryReceiveUserBirthdateFromServer();
      }
      else
        return;
      UserAgeController.this.mReceiveUserBirthdateLatestSeq.b();
    }

    public void onConnectionStateChange(int paramAnonymousInt)
    {
    }
  };
  private final com.viber.voip.i.f mGdprMainPrimaryFeature;
  private f.a mGdprMainPrimaryFeatureListener = new f.a()
  {
    public void onFeatureStateChanged(com.viber.voip.i.f paramAnonymousf)
    {
      if (paramAnonymousf.e())
        UserAgeController.this.mWorkerHandler.post(new UserAgeController.2..Lambda.0(UserAgeController.this));
    }
  };
  private final Im2Exchanger mIm2Exchanger;
  private volatile boolean mInitialized = false;
  private long mJustReceivedUserDateOfBirthMillis = -9223372036854775808L;
  private final b mNeedFetchUserBirthdate;
  private final PhoneController mPhoneController;
  private final com.viber.common.b.d mReceiveUserBirthdateLatestSeq;
  private final com.viber.common.b.d mUpdateUserBirthdateRequestSeqPref;
  private final com.viber.voip.gdpr.f mUserBirthdateAgeSynchronizer;
  private final com.viber.common.b.e mUserBirthdatePref;
  private final Handler mWorkerHandler;

  public UserAgeController(Im2Exchanger paramIm2Exchanger, PhoneController paramPhoneController, ConnectionController paramConnectionController, Handler paramHandler, com.viber.voip.i.f paramf, com.viber.common.b.e parame, com.viber.common.b.d paramd1, b paramb, com.viber.common.b.d paramd2, com.viber.common.b.d paramd3, com.viber.voip.gdpr.f paramf1)
  {
    this.mIm2Exchanger = paramIm2Exchanger;
    this.mPhoneController = paramPhoneController;
    this.mConnectionController = paramConnectionController;
    this.mWorkerHandler = paramHandler;
    this.mGdprMainPrimaryFeature = paramf;
    this.mUserBirthdatePref = parame;
    this.mUpdateUserBirthdateRequestSeqPref = paramd1;
    this.mNeedFetchUserBirthdate = paramb;
    this.mReceiveUserBirthdateLatestSeq = paramd2;
    this.mBirthdateScreenStatePref = paramd3;
    this.mUserBirthdateAgeSynchronizer = paramf1;
  }

  private boolean isBirthdateSet()
  {
    return this.mUserBirthdatePref.d() != this.mUserBirthdatePref.f();
  }

  private void resetReceiveUserAgeState()
  {
    this.mNeedFetchUserBirthdate.a(false);
    this.mReceiveUserBirthdateLatestSeq.b();
    this.mBirthdateScreenStatePref.a(1);
  }

  private void sendUserBirthdateUpdateRequest()
  {
    if (!isBirthdateSet())
      this.mUpdateUserBirthdateRequestSeqPref.b();
    int i;
    do
    {
      return;
      i = this.mPhoneController.generateSequence();
      this.mUpdateUserBirthdateRequestSeqPref.a(i);
    }
    while (!this.mConnectionController.isConnected());
    com.viber.voip.gdpr.e locale = com.viber.voip.gdpr.e.a(this.mUserBirthdatePref.d());
    byte b1 = (byte)locale.f();
    byte b2 = (byte)(1 + locale.e());
    short s = (short)locale.d();
    this.mIm2Exchanger.handleCUpdateUserDateOfBirthMsg(new CUpdateUserDateOfBirthMsg(i, b1, b2, s));
  }

  private void tryReceiveUserBirthdateFromServer()
  {
    if (!this.mNeedFetchUserBirthdate.d())
      this.mReceiveUserBirthdateLatestSeq.b();
    int i;
    do
    {
      return;
      if (isBirthdateSet())
      {
        resetReceiveUserAgeState();
        return;
      }
      i = this.mPhoneController.generateSequence();
      this.mReceiveUserBirthdateLatestSeq.a(i);
    }
    while (!this.mConnectionController.isConnected());
    this.mIm2Exchanger.handleCGetUserDateOfBirthMsg(new CGetUserDateOfBirthMsg(i));
  }

  public void init(ConnectionListener paramConnectionListener)
  {
    if (this.mInitialized)
      return;
    this.mInitialized = true;
    this.mIm2Exchanger.registerDelegate(this, this.mWorkerHandler);
    paramConnectionListener.registerDelegate(this.mConnectionDelegate, this.mWorkerHandler);
    Handler localHandler = this.mWorkerHandler;
    a[] arrayOfa = new a[1];
    arrayOfa[0] = this.mUserBirthdatePref;
    this.mBirthdatePrefChangeListener = new d.al(localHandler, arrayOfa)
    {
      public void onPreferencesChanged(a paramAnonymousa)
      {
        if (UserAgeController.this.isBirthdateSet())
          UserAgeController.this.resetReceiveUserAgeState();
        if ((UserAgeController.this.mUserBirthdatePref.d() != UserAgeController.this.mJustReceivedUserDateOfBirthMillis) && (UserAgeController.this.mGdprMainPrimaryFeature.e()))
          UserAgeController.this.sendUserBirthdateUpdateRequest();
        UserAgeController.access$902(UserAgeController.this, -9223372036854775808L);
      }
    };
    com.viber.voip.settings.d.a(this.mBirthdatePrefChangeListener);
    this.mGdprMainPrimaryFeature.a(this.mGdprMainPrimaryFeatureListener);
  }

  public void onCGetUserDateOfBirthReplyMsg(CGetUserDateOfBirthReplyMsg paramCGetUserDateOfBirthReplyMsg)
  {
    if (paramCGetUserDateOfBirthReplyMsg.seq != this.mReceiveUserBirthdateLatestSeq.d())
      return;
    if (isBirthdateSet())
    {
      resetReceiveUserAgeState();
      return;
    }
    switch (paramCGetUserDateOfBirthReplyMsg.status)
    {
    case 1:
    case 2:
    default:
      return;
    case 0:
      this.mJustReceivedUserDateOfBirthMillis = com.viber.voip.gdpr.e.a(paramCGetUserDateOfBirthReplyMsg.day, -1 + paramCGetUserDateOfBirthReplyMsg.month, paramCGetUserDateOfBirthReplyMsg.year).b();
      this.mUserBirthdateAgeSynchronizer.a(this.mJustReceivedUserDateOfBirthMillis);
    case 3:
    }
    resetReceiveUserAgeState();
  }

  public void onCUpdateUserDateOfBirthReplyMsg(CUpdateUserDateOfBirthReplyMsg paramCUpdateUserDateOfBirthReplyMsg)
  {
    if (((paramCUpdateUserDateOfBirthReplyMsg.status == 0) || (paramCUpdateUserDateOfBirthReplyMsg.status == 3)) && (paramCUpdateUserDateOfBirthReplyMsg.seq == this.mUpdateUserBirthdateRequestSeqPref.d()))
      this.mUpdateUserBirthdateRequestSeqPref.b();
  }

  public void startFetchUserBirthdate()
  {
    boolean bool = this.mGdprMainPrimaryFeature.e();
    this.mNeedFetchUserBirthdate.a(true);
    if (bool)
      this.mWorkerHandler.post(new UserAgeController..Lambda.0(this));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.age.UserAgeController
 * JD-Core Version:    0.6.2
 */