package com.viber.voip.phone;

import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.Window;
import com.viber.common.permission.b;
import com.viber.common.permission.c;
import com.viber.dexshared.Logger;
import com.viber.jni.dialer.DialerController;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.b.a.h;
import com.viber.voip.analytics.story.b.a.h.a;
import com.viber.voip.analytics.story.b.a.h.a.a;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.permissions.f;
import com.viber.voip.permissions.m;
import com.viber.voip.permissions.n;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.call.CallInitiationId;
import com.viber.voip.phone.call.listeners.CallInitiationListenersStore;
import com.viber.voip.phone.viber.conference.model.OngoingConferenceCallModel;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.util.ViberActionRunner.ah;
import com.viber.voip.util.dj;
import javax.inject.Inject;

public class PhoneFragmentActivity extends ViberFragmentActivity
  implements CallFragmentManager.CallFragmentManagerCallback
{
  private static final Logger L = ViberEnv.getLogger();
  private CallFragmentManager mCallFragmentManager;

  @Inject
  dagger.a<CallHandler> mCallHandler;

  @Inject
  dagger.a<DialerController> mDialerController;
  private b mPermissionListener;

  @Inject
  c mPermissionManager;

  @Inject
  dagger.a<h> mUserStartsCallEventCollector;

  public PhoneFragmentActivity()
  {
    Pair[] arrayOfPair = new Pair[2];
    arrayOfPair[0] = m.a(30);
    arrayOfPair[1] = m.a(59);
    this.mPermissionListener = new f(this, arrayOfPair)
    {
      public void onCustomDialogAction(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        if ((DialogCode.D_ASK_PERMISSION.code().equals(paramAnonymousString)) || ((DialogCode.D_EXPLAIN_PERMISSION.code().equals(paramAnonymousString)) && (paramAnonymousInt2 != -1)))
          PhoneFragmentActivity.this.finish();
      }

      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        default:
          return;
        case 30:
        case 59:
        }
        PhoneFragmentActivity.this.handleActionCall((Intent)paramAnonymousObject);
      }
    };
  }

  private void handleActionAcceptCall(Intent paramIntent)
  {
    this.mCallFragmentManager.setAcceptIncomingCall(true);
  }

  private void handleActionCall(Intent paramIntent)
  {
    KeyguardManager localKeyguardManager = (KeyguardManager)getSystemService("keyguard");
    boolean bool2;
    if (localKeyguardManager.inKeyguardRestrictedInputMode())
      if (com.viber.common.d.a.h())
        bool2 = localKeyguardManager.isDeviceLocked();
    while (true)
    {
      if (bool2)
      {
        Context localContext = getApplicationContext();
        long l1 = paramIntent.getLongExtra("conversation_id", -1L);
        long l2 = paramIntent.getLongExtra("contact_id", -1L);
        ViberActionRunner.ah.a(localContext, PendingIntent.getActivity(localContext, 100, paramIntent, 0), l1, l2);
        finish();
      }
      String[] arrayOfString;
      int i;
      label275: label282: OngoingConferenceCallModel localOngoingConferenceCallModel;
      do
      {
        return;
        if (!com.viber.common.d.a.a())
          break label344;
        if ((localKeyguardManager.isKeyguardLocked()) && (localKeyguardManager.isKeyguardSecure()))
        {
          bool2 = true;
          break;
        }
        bool2 = false;
        break;
        boolean bool1 = paramIntent.getBooleanExtra("is_video_call", false);
        if (bool1)
        {
          arrayOfString = n.g;
          if (!bool1)
            break label275;
        }
        for (i = 30; ; i = 59)
        {
          String str = PhoneUtils.getInitialNumber(paramIntent, this);
          if (!this.mPermissionManager.a(arrayOfString))
            break label330;
          ((CallHandler)this.mCallHandler.get()).getCallInitiationListenersStore().registerListener(new PhoneFragmentActivity..Lambda.0(this));
          if (TextUtils.isEmpty(str))
            break label282;
          CallInitiationId.noteNextCallInitiationAttemptId();
          ((h)this.mUserStartsCallEventCollector.get()).b(h.a.i().a(new String[] { str }).a("Notification").a(false, bool1).a(true).a());
          ((DialerController)this.mDialerController.get()).handleDial(str, bool1);
          return;
          arrayOfString = n.h;
          break;
        }
        localOngoingConferenceCallModel = (OngoingConferenceCallModel)paramIntent.getParcelableExtra("conference");
      }
      while (localOngoingConferenceCallModel == null);
      ((CallHandler)this.mCallHandler.get()).handleJoinOngoingAudioConference(localOngoingConferenceCallModel.callToken, localOngoingConferenceCallModel.conferenceInfo, localOngoingConferenceCallModel.conversationId);
      return;
      label330: this.mPermissionManager.a(this, i, arrayOfString, paramIntent);
      return;
      label344: bool2 = false;
    }
  }

  private void handleIntentAction(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if (str == null)
      return;
    int i = -1;
    switch (str.hashCode())
    {
    default:
    case -1885922324:
    case 1472990599:
    }
    while (true)
      switch (i)
      {
      default:
        return;
      case 0:
        handleActionAcceptCall(paramIntent);
        return;
        if (str.equals("com.viber.voip.action.ACCEPT_CALL"))
        {
          i = 0;
          continue;
          if (str.equals("com.viber.voip.action.CALL"))
            i = 1;
        }
        break;
      case 1:
      }
    handleActionCall(paramIntent);
  }

  private void tunePower()
  {
    getWindow().addFlags(4751360);
    if (!((PowerManager)getSystemService("power")).isScreenOn())
      getWindow().addFlags(2097152);
  }

  private void tuneScreen()
  {
    getWindow().setFormat(1);
    if (!ViberApplication.isTablet(this))
    {
      com.viber.voip.n.a.d(this);
      return;
    }
    dj.a(this, false, false);
  }

  public void endCall()
  {
    this.mCallFragmentManager.endCall();
  }

  public boolean isReadyToShowAd()
  {
    return this.mCallFragmentManager.isReadyToShowAd();
  }

  public void onBackPressed()
  {
    if (!this.mCallFragmentManager.canGoBack(this))
      super.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    super.onCreate(paramBundle);
    if (!this.mIsTablet)
      dj.c(this, false);
    this.mCallFragmentManager = new CallFragmentManager(this, R.id.phone_container, true, ViberApplication.isTablet(this));
    tunePower();
    tuneScreen();
    setContentView(R.layout.phone_content);
    handleIntentAction(getIntent());
  }

  protected void onDestroy()
  {
    super.onDestroy();
    this.mCallFragmentManager.onDestroy(this);
  }

  protected void onPause()
  {
    super.onPause();
    this.mCallFragmentManager.onPause(this);
  }

  protected void onResumeFragments()
  {
    super.onResumeFragments();
    this.mCallFragmentManager.onResume(this);
  }

  protected void onStart()
  {
    super.onStart();
    this.mCallFragmentManager.onStart(this);
    this.mPermissionManager.a(this.mPermissionListener);
  }

  protected void onStop()
  {
    super.onStop();
    this.mCallFragmentManager.onStop(this);
    this.mPermissionManager.b(this.mPermissionListener);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.PhoneFragmentActivity
 * JD-Core Version:    0.6.2
 */