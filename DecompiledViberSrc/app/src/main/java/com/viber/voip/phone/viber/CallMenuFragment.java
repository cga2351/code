package com.viber.voip.phone.viber;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.dialer.DialerCallInterruptionListener;
import com.viber.jni.dialer.DialerControllerDelegate.DialerCallInterruption;
import com.viber.jni.dialer.DialerControllerDelegate.DialerPhoneState;
import com.viber.jni.dialer.DialerPhoneStateListener;
import com.viber.voip.R.layout;
import com.viber.voip.av.e;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.InCallState;
import com.viber.voip.phone.viber.controller.CallMenuButtons;
import com.viber.voip.registration.HardwareParameters;
import com.viber.voip.sound.ISoundService;

public class CallMenuFragment extends CallViewHolder
  implements DialerControllerDelegate.DialerCallInterruption, DialerControllerDelegate.DialerPhoneState
{
  private CallInfo mCallInfo;
  private CallMenuButtons mCallMenuButtons;

  public CallMenuFragment(CallFragment paramCallFragment)
  {
    super(paramCallFragment);
  }

  private boolean updateSpeakerState()
  {
    ISoundService localISoundService = getFragment().getSoundService();
    boolean bool1 = getFragment().getHardwareParameters().isGsmSupportedOrHavePhoneType();
    if ((localISoundService.isHeadsetPluggedIn()) || (localISoundService.isBluetoothOn()));
    for (int i = 1; ; i = 0)
    {
      if ((!bool1) && (i == 0))
        localISoundService.setSpeakerphoneOn(true);
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

  public CallMenuButtons getCallMenuButtons()
  {
    return this.mCallMenuButtons;
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.phone_incall_menu, paramViewGroup, false);
    if (this.mCallMenuButtons == null)
    {
      CallFragment localCallFragment = getFragment();
      CallHandler localCallHandler = localCallFragment.getCallHandler();
      this.mCallMenuButtons = new CallMenuButtons(localView, localCallHandler, localCallHandler.getLastCallInfo(), false, localCallFragment.getSoundService(), localCallFragment.getDialerController(), localCallFragment.getPowerManager());
      return localView;
    }
    this.mCallMenuButtons.initCallMenu(localView);
    return localView;
  }

  public void onDataInterruption(boolean paramBoolean)
  {
    CallMenuButtons localCallMenuButtons;
    if (this.mCallMenuButtons != null)
    {
      localCallMenuButtons = this.mCallMenuButtons;
      if (paramBoolean)
        break label24;
    }
    label24: for (boolean bool = true; ; bool = false)
    {
      localCallMenuButtons.setEnabled(bool);
      return;
    }
  }

  public void onDestroy()
  {
    CallFragment localCallFragment = getFragment();
    localCallFragment.getDelegatesManager().getDialerPhoneStateListener().removeDelegate(this);
    localCallFragment.getDelegatesManager().getDialerCallInterruptionListener().removeDelegate(this);
    setFragment(null);
    this.mCallMenuButtons = null;
    this.mCallInfo = null;
  }

  public void onHide()
  {
    CallFragment localCallFragment = getFragment();
    localCallFragment.getDelegatesManager().getDialerPhoneStateListener().removeDelegate(this);
    localCallFragment.getDelegatesManager().getDialerCallInterruptionListener().removeDelegate(this);
    if (this.mCallInfo == null);
    InCallState localInCallState;
    do
    {
      return;
      localInCallState = this.mCallInfo.getInCallState();
    }
    while (localInCallState == null);
    localInCallState.deleteObserver(this.mCallMenuButtons);
  }

  public void onPhoneStateChanged(int paramInt)
  {
    CallMenuButtons localCallMenuButtons;
    if (this.mCallMenuButtons != null)
    {
      localCallMenuButtons = this.mCallMenuButtons;
      if (paramInt != 3)
        break label25;
    }
    label25: for (boolean bool = true; ; bool = false)
    {
      localCallMenuButtons.setEnabled(bool);
      return;
    }
  }

  public void onShow()
  {
    CallFragment localCallFragment = getFragment();
    localCallFragment.getDelegatesManager().getDialerPhoneStateListener().registerDelegate(this, av.e.a.a());
    localCallFragment.getDelegatesManager().getDialerCallInterruptionListener().registerDelegate(this, av.e.a.a());
    this.mCallInfo = localCallFragment.getCallHandler().getLastCallInfo();
    if (this.mCallInfo == null)
      return;
    this.mCallMenuButtons.setCallInfo(this.mCallInfo);
    this.mCallInfo.getInCallState().addObserver(this.mCallMenuButtons);
    InCallState localInCallState = (InCallState)this.mCallInfo.getInCallState().clone();
    this.mCallMenuButtons.update(this.mCallInfo.getInCallState(), localInCallState);
    this.mCallMenuButtons.setEnableSpeaker(updateSpeakerState());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.CallMenuFragment
 * JD-Core Version:    0.6.2
 */