package com.viber.voip.phone.viber.conference.ui.controls;

import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.jni.dialer.DialerCallInterruptionListener;
import com.viber.jni.dialer.DialerController;
import com.viber.jni.dialer.DialerControllerDelegate.DialerCallInterruption;
import com.viber.jni.dialer.DialerControllerDelegate.DialerPhoneState;
import com.viber.jni.dialer.DialerPhoneStateListener;
import com.viber.voip.ViberEnv;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.InCallState;
import java.util.Observer;
import javax.inject.Inject;

public class ConferenceHoldStateResolver extends ControlStateResolver
{
  private static final Logger L = ViberEnv.getLogger();
  private CallHandler mCallHandler;
  private final DialerCallInterruptionListener mDialerCallInterruptionObservableListener;
  private final DialerControllerDelegate.DialerCallInterruption mDialerCallInterruptionObserverListener = new ConferenceHoldStateResolver..Lambda.0(this);
  private final DialerController mDialerController;
  private final DialerPhoneStateListener mDialerPhoneStateObservableListener;
  private final DialerControllerDelegate.DialerPhoneState mDialerPhoneStateObserverListener = new ConferenceHoldStateResolver..Lambda.1(this);
  private boolean mHoldInteractionAllowed;
  private final Observer mInCallStateObserver = new ConferenceHoldStateResolver..Lambda.2(this);
  private final Handler mUiExecutor;

  @Inject
  public ConferenceHoldStateResolver(CallHandler paramCallHandler, DialerController paramDialerController, DialerPhoneStateListener paramDialerPhoneStateListener, DialerCallInterruptionListener paramDialerCallInterruptionListener, Handler paramHandler)
  {
    this.mCallHandler = paramCallHandler;
    this.mDialerController = paramDialerController;
    this.mDialerPhoneStateObservableListener = paramDialerPhoneStateListener;
    this.mDialerCallInterruptionObservableListener = paramDialerCallInterruptionListener;
    this.mUiExecutor = paramHandler;
  }

  private void notifyHoldStateListeners(boolean paramBoolean)
  {
    if (this.mOnControlStateChangeListener == null)
      return;
    CallInfo localCallInfo = this.mCallHandler.getLastCallInfo();
    InCallState localInCallState;
    int i;
    label39: int j;
    label51: int m;
    if (localCallInfo != null)
    {
      localInCallState = localCallInfo.getInCallState();
      if ((localInCallState == null) || (!localInCallState.isTransferring()))
        break label97;
      i = 1;
      if ((!paramBoolean) || (i != 0))
        break label103;
      j = 2;
      if (localInCallState == null)
        break label115;
      if ((!localInCallState.isHoldEnabled()) || (!localInCallState.isHoldInitiator()))
        break label109;
      m = 8;
    }
    label73: label97: label103: label109: label115: for (int k = m | j; ; k = j | 0x4)
    {
      this.mOnControlStateChangeListener.onControlStateChanged(k);
      return;
      localInCallState = null;
      break;
      i = 0;
      break label39;
      j = 1;
      break label51;
      m = 4;
      break label73;
    }
  }

  private void setHoldInteractionAllowed(boolean paramBoolean)
  {
    this.mHoldInteractionAllowed = paramBoolean;
    notifyHoldStateListeners(paramBoolean);
  }

  public void activate(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mDialerController.handleLocalHold();
      return;
    }
    this.mDialerController.handleLocalUnhold();
  }

  public void disable()
  {
    this.mDialerPhoneStateObservableListener.removeDelegate(this.mDialerPhoneStateObserverListener);
    this.mDialerCallInterruptionObservableListener.removeDelegate(this.mDialerCallInterruptionObserverListener);
    if (this.mCallHandler.getLastCallInfo() != null)
      this.mCallHandler.getLastCallInfo().getInCallState().deleteObserver(this.mInCallStateObserver);
  }

  public void enable()
  {
    this.mDialerPhoneStateObservableListener.registerDelegate(this.mDialerPhoneStateObserverListener, this.mUiExecutor);
    this.mDialerCallInterruptionObservableListener.registerDelegate(this.mDialerCallInterruptionObserverListener, this.mUiExecutor);
    CallInfo localCallInfo = this.mCallHandler.getLastCallInfo();
    if (localCallInfo != null)
    {
      localCallInfo.getInCallState().addObserver(this.mInCallStateObserver);
      this.mInCallStateObserver.update(localCallInfo.getInCallState(), localCallInfo.getInCallState().clone());
      return;
    }
    setHoldInteractionAllowed(false);
  }

  public void setOnControlStateChangeListener(ControlStateResolver.OnControlStateChangeListener paramOnControlStateChangeListener)
  {
    super.setOnControlStateChangeListener(paramOnControlStateChangeListener);
    notifyHoldStateListeners(this.mHoldInteractionAllowed);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.ui.controls.ConferenceHoldStateResolver
 * JD-Core Version:    0.6.2
 */