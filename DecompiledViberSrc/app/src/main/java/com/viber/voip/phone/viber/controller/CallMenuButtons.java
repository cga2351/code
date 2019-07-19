package com.viber.voip.phone.viber.controller;

import android.os.PowerManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ToggleButton;
import com.viber.common.b.d;
import com.viber.jni.dialer.DialerController;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.i.c.g;
import com.viber.voip.i.f;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.InCallState;
import com.viber.voip.settings.d.m;
import com.viber.voip.sound.ISoundService;
import com.viber.voip.util.dj;
import java.util.Observable;
import java.util.Observer;

public class CallMenuButtons
  implements View.OnClickListener, Observer
{
  private View mAddToCallOverlay;
  private CallHandler mCallHandler;
  private CallInfo mCallInfo;
  private DialerController mDialerController;
  private View[] mDisabledViews;
  private boolean mEnableSpeaker;
  private ToggleButton mHold;
  private Button mKeypad;
  private boolean mMenuEnabled = true;
  private ToggleButton mMute;
  private View.OnClickListener mOnKeypadClickListener;
  private View.OnClickListener mOnVideoClickListener;
  private PowerManager mPowerManager;
  private ISoundService mSoundService;
  private ToggleButton mSpeaker;
  private ToggleButton mTransfer;
  private Button mVideo;

  public CallMenuButtons(View paramView, CallHandler paramCallHandler, CallInfo paramCallInfo, boolean paramBoolean, ISoundService paramISoundService, DialerController paramDialerController, PowerManager paramPowerManager)
  {
    this.mCallHandler = paramCallHandler;
    this.mCallInfo = paramCallInfo;
    this.mSoundService = paramISoundService;
    this.mDialerController = paramDialerController;
    this.mPowerManager = paramPowerManager;
    setEnableSpeaker(paramBoolean);
    if (paramView != null)
      initCallMenu(paramView);
  }

  private void animateAddToCall()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(1000L);
    localAlphaAnimation.setInterpolator(new LinearInterpolator());
    localAlphaAnimation.setRepeatCount(3);
    localAlphaAnimation.setRepeatMode(2);
    localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        dj.b(CallMenuButtons.this.mAddToCallOverlay, false);
      }

      public void onAnimationRepeat(Animation paramAnonymousAnimation)
      {
      }

      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
        dj.b(CallMenuButtons.this.mAddToCallOverlay, true);
      }
    });
    this.mAddToCallOverlay.startAnimation(localAlphaAnimation);
  }

  private void updateAddToCall(boolean paramBoolean, CallInfo paramCallInfo)
  {
    if ((paramBoolean) && (paramCallInfo != null) && (!paramCallInfo.isViberOut()) && (paramCallInfo.getInCallState().isConferenceSupported()));
    int i;
    for (boolean bool = true; ; bool = false)
    {
      this.mKeypad.setEnabled(bool);
      if ((bool) && (this.mCallInfo.showAddToCallAnimation()))
      {
        i = d.m.u.d();
        if ((i != 1) && (i != 3) && (i != 5))
          break;
        if (this.mPowerManager.isScreenOn())
        {
          animateAddToCall();
          updateAudioConferenceNumber(i);
        }
      }
      return;
    }
    updateAudioConferenceNumber(i);
  }

  private void updateAudioConferenceNumber(int paramInt)
  {
    this.mCallInfo.setShowAddToCallAnimation(false);
    if (paramInt == 5)
    {
      d.m.u.a(0);
      return;
    }
    d.m.u.a(paramInt + 1);
  }

  private void updateKeypadButton(CallInfo paramCallInfo)
  {
    int i = 1;
    int j;
    int k;
    if ((paramCallInfo != null) && (paramCallInfo.isViberOut()))
    {
      j = i;
      if ((paramCallInfo == null) || (!paramCallInfo.isViberIn()))
        break label103;
      k = i;
      label29: if ((!c.g.a.e()) || (j != 0) || (k != 0))
        break label109;
      label47: if ((i == 0) || (this.mKeypad.getId() == R.id.call_btn_add_to_call))
        break label114;
      this.mKeypad.setId(R.id.call_btn_add_to_call);
      this.mKeypad.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.call_incall_add_to_call, 0, 0);
      this.mKeypad.setText(R.string.add_to_call);
    }
    label103: label109: label114: 
    while ((i != 0) || (this.mKeypad.getId() == R.id.keypad))
    {
      return;
      j = 0;
      break;
      k = 0;
      break label29;
      i = 0;
      break label47;
    }
    this.mKeypad.setId(R.id.keypad);
    this.mKeypad.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.call_incall_keypad, 0, 0);
    this.mKeypad.setText(R.string.tab_phone);
  }

  public void initCallMenu(View paramView)
  {
    this.mKeypad = ((Button)paramView.findViewById(R.id.keypad));
    this.mAddToCallOverlay = paramView.findViewById(R.id.add_to_call_overlay);
    this.mTransfer = ((ToggleButton)paramView.findViewById(R.id.call_transfer));
    this.mMute = ((ToggleButton)paramView.findViewById(R.id.mute));
    this.mHold = ((ToggleButton)paramView.findViewById(R.id.hold));
    this.mSpeaker = ((ToggleButton)paramView.findViewById(R.id.speaker));
    this.mVideo = ((Button)paramView.findViewById(R.id.video));
    updateKeypadButton(this.mCallInfo);
    this.mSpeaker.setEnabled(this.mEnableSpeaker);
    View[] arrayOfView = new View[2];
    arrayOfView[0] = this.mKeypad;
    arrayOfView[1] = this.mMute;
    this.mDisabledViews = arrayOfView;
    this.mTransfer.setOnClickListener(this);
    this.mMute.setOnClickListener(this);
    this.mSpeaker.setOnClickListener(this);
    this.mHold.setOnClickListener(this);
    if (this.mOnKeypadClickListener != null)
      this.mKeypad.setOnClickListener(this.mOnKeypadClickListener);
    if (this.mOnVideoClickListener != null)
      this.mVideo.setOnClickListener(this.mOnVideoClickListener);
  }

  public boolean isMenuEnabled()
  {
    return this.mMenuEnabled;
  }

  public void onClick(View paramView)
  {
    if (paramView == this.mHold)
      if (this.mHold.isChecked())
        this.mDialerController.handleLocalHold();
    do
    {
      return;
      this.mDialerController.handleLocalUnhold();
      return;
      if (paramView == this.mMute)
      {
        if (this.mMute.isChecked())
        {
          this.mDialerController.handleMute();
          return;
        }
        this.mDialerController.handleUnmute();
        return;
      }
      if (paramView == this.mSpeaker)
      {
        this.mSoundService.setSpeakerphoneOn(this.mSpeaker.isChecked());
        return;
      }
    }
    while (paramView != this.mTransfer);
    this.mDialerController.handleTransfer(this.mTransfer.isChecked());
  }

  public void setCallInfo(CallInfo paramCallInfo)
  {
    this.mCallInfo = paramCallInfo;
  }

  public void setEnableSpeaker(boolean paramBoolean)
  {
    this.mEnableSpeaker = paramBoolean;
    if (this.mSpeaker != null)
      this.mSpeaker.setEnabled(paramBoolean);
  }

  public void setEnabled(boolean paramBoolean)
  {
    boolean bool1 = true;
    if (this.mCallInfo == null)
      return;
    this.mMenuEnabled = paramBoolean;
    View[] arrayOfView = this.mDisabledViews;
    int i = arrayOfView.length;
    for (int j = 0; j < i; j++)
      arrayOfView[j].setEnabled(paramBoolean);
    boolean bool2;
    boolean bool3;
    label122: boolean bool4;
    label163: ToggleButton localToggleButton2;
    if ((paramBoolean) && (!this.mCallInfo.getInCallState().isHoldEnabled()))
    {
      bool2 = bool1;
      Button localButton = this.mVideo;
      if ((!bool2) || (!this.mCallInfo.isLocalVideoAvailable()) || (!this.mCallHandler.isLocalVideoAvailable()) || (this.mCallInfo.isViberOut()) || (this.mCallInfo.isViberIn()))
        break label238;
      bool3 = bool1;
      localButton.setEnabled(bool3);
      ToggleButton localToggleButton1 = this.mTransfer;
      if ((!bool2) || (this.mCallInfo.isViberOut()) || (this.mCallInfo.isViberIn()))
        break label244;
      bool4 = bool1;
      localToggleButton1.setEnabled(bool4);
      localToggleButton2 = this.mHold;
      if ((!paramBoolean) || (!this.mCallInfo.isViberCallInProgress()) || (this.mCallInfo.getInCallState().isTransferring()))
        break label250;
    }
    while (true)
    {
      localToggleButton2.setEnabled(bool1);
      if (R.id.call_btn_add_to_call != this.mKeypad.getId())
        break label255;
      updateAddToCall(paramBoolean, this.mCallInfo);
      return;
      bool2 = false;
      break;
      label238: bool3 = false;
      break label122;
      label244: bool4 = false;
      break label163;
      label250: bool1 = false;
    }
    label255: this.mKeypad.setEnabled(paramBoolean);
  }

  public void setOnKeypadClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnKeypadClickListener = paramOnClickListener;
    if (this.mKeypad != null)
      this.mKeypad.setOnClickListener(paramOnClickListener);
  }

  public void setOnVideoClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnVideoClickListener = paramOnClickListener;
    if (this.mVideo != null)
      this.mVideo.setOnClickListener(paramOnClickListener);
  }

  public void update(Observable paramObservable, Object paramObject)
  {
    boolean bool1 = true;
    InCallState localInCallState = (InCallState)paramObservable;
    boolean bool2;
    ToggleButton localToggleButton;
    if ((this.mCallInfo.isCallInProgress()) && (!localInCallState.isDataInterrupted()))
    {
      bool2 = bool1;
      setEnabled(bool2);
      this.mMute.setChecked(localInCallState.isMuteEnabled());
      this.mSpeaker.setChecked(localInCallState.isSpeakerEnabled());
      localToggleButton = this.mHold;
      if ((!localInCallState.isHoldEnabled()) || (!localInCallState.isHoldInitiator()))
        break label125;
    }
    while (true)
    {
      localToggleButton.setChecked(bool1);
      this.mTransfer.setChecked(localInCallState.isTransferring());
      if (!this.mEnableSpeaker)
        this.mSpeaker.setEnabled(localInCallState.isHeadphonesEnabled());
      return;
      bool2 = false;
      break;
      label125: bool1 = false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.controller.CallMenuButtons
 * JD-Core Version:    0.6.2
 */