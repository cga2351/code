package com.viber.voip.phone.viber.conference.ui.controls;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.InCallState;
import com.viber.voip.registration.HardwareParameters;
import com.viber.voip.sound.ISoundService;
import java.util.Observer;
import javax.inject.Inject;

public class ConferenceSpeakerStateResolver extends ControlStateResolver
{
  private static final Logger L = ViberEnv.getLogger();
  private CallHandler mCallHandler;
  private final HardwareParameters mHardwareParameters;
  private final Observer mInCallStateObserver = new ConferenceSpeakerStateResolver..Lambda.0(this);
  private final ISoundService mSoundService;
  private boolean mSpeakerInteractionAllowed;

  @Inject
  public ConferenceSpeakerStateResolver(CallHandler paramCallHandler, ISoundService paramISoundService, HardwareParameters paramHardwareParameters)
  {
    this.mCallHandler = paramCallHandler;
    this.mSoundService = paramISoundService;
    this.mHardwareParameters = paramHardwareParameters;
  }

  private void notifySpeakerStateListeners(boolean paramBoolean)
  {
    if (this.mOnControlStateChangeListener == null)
      return;
    int i;
    int k;
    if (paramBoolean)
    {
      i = 2;
      CallInfo localCallInfo = this.mCallHandler.getLastCallInfo();
      if (localCallInfo == null)
        break label69;
      if (!localCallInfo.getInCallState().isSpeakerEnabled())
        break label63;
      k = 8;
    }
    label40: label63: label69: for (int j = i | k; ; j = i | 0x4)
    {
      this.mOnControlStateChangeListener.onControlStateChanged(j);
      return;
      i = 1;
      break;
      k = 4;
      break label40;
    }
  }

  private void setSpeakerInteractionAllowed(boolean paramBoolean)
  {
    this.mSpeakerInteractionAllowed = paramBoolean;
    notifySpeakerStateListeners(paramBoolean);
  }

  private boolean updateSpeakerState()
  {
    boolean bool1 = this.mHardwareParameters.isGsmSupportedOrHavePhoneType();
    if ((this.mSoundService.isHeadsetPluggedIn()) || (this.mSoundService.isBluetoothOn()));
    for (int i = 1; ; i = 0)
    {
      if ((!bool1) && (i == 0))
        this.mSoundService.setSpeakerphoneOn(true);
      boolean bool2;
      if (!bool1)
      {
        bool2 = false;
        if (i == 0);
      }
      else
      {
        bool2 = true;
      }
      return bool2;
    }
  }

  public void activate(boolean paramBoolean)
  {
    this.mSoundService.setSpeakerphoneOn(paramBoolean);
  }

  public void disable()
  {
    if (this.mCallHandler.getLastCallInfo() != null)
      this.mCallHandler.getLastCallInfo().getInCallState().deleteObserver(this.mInCallStateObserver);
  }

  public void enable()
  {
    CallInfo localCallInfo = this.mCallHandler.getLastCallInfo();
    if (localCallInfo != null)
    {
      localCallInfo.getInCallState().addObserver(this.mInCallStateObserver);
      this.mInCallStateObserver.update(localCallInfo.getInCallState(), localCallInfo.getInCallState().clone());
    }
    setSpeakerInteractionAllowed(updateSpeakerState());
  }

  public void setOnControlStateChangeListener(ControlStateResolver.OnControlStateChangeListener paramOnControlStateChangeListener)
  {
    super.setOnControlStateChangeListener(paramOnControlStateChangeListener);
    notifySpeakerStateListeners(this.mSpeakerInteractionAllowed);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.ui.controls.ConferenceSpeakerStateResolver
 * JD-Core Version:    0.6.2
 */