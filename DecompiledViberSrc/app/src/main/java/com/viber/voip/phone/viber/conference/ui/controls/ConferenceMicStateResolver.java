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

public class ConferenceMicStateResolver extends ControlStateResolver
{
  private static final Logger L = ViberEnv.getLogger();
  private CallHandler mCallHandler;
  private final DialerCallInterruptionListener mDialerCallInterruptionObservableListener;
  private final DialerControllerDelegate.DialerCallInterruption mDialerCallInterruptionObserverListener = new ConferenceMicStateResolver..Lambda.0(this);
  private final DialerController mDialerController;
  private final DialerPhoneStateListener mDialerPhoneStateObservableListener;
  private final DialerControllerDelegate.DialerPhoneState mDialerPhoneStateObserverListener = new ConferenceMicStateResolver..Lambda.1(this);
  private final Observer mInCallStateObserver = new ConferenceMicStateResolver..Lambda.2(this);
  private boolean mMuteInteractionAllowed;
  private final Handler mUiExecutor;

  @Inject
  public ConferenceMicStateResolver(CallHandler paramCallHandler, DialerController paramDialerController, DialerPhoneStateListener paramDialerPhoneStateListener, DialerCallInterruptionListener paramDialerCallInterruptionListener, Handler paramHandler)
  {
    this.mCallHandler = paramCallHandler;
    this.mDialerController = paramDialerController;
    this.mDialerPhoneStateObservableListener = paramDialerPhoneStateListener;
    this.mDialerCallInterruptionObservableListener = paramDialerCallInterruptionListener;
    this.mUiExecutor = paramHandler;
  }

  private void notifyMuteStateListeners(boolean paramBoolean)
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
      if (!localCallInfo.getInCallState().isMuteEnabled())
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

  private void setMuteInteractionAllowed(boolean paramBoolean)
  {
    this.mMuteInteractionAllowed = paramBoolean;
    notifyMuteStateListeners(paramBoolean);
  }

  public void activate(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mDialerController.handleMute();
      return;
    }
    this.mDialerController.handleUnmute();
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
    setMuteInteractionAllowed(false);
  }

  public void setOnControlStateChangeListener(ControlStateResolver.OnControlStateChangeListener paramOnControlStateChangeListener)
  {
    super.setOnControlStateChangeListener(paramOnControlStateChangeListener);
    notifyMuteStateListeners(this.mMuteInteractionAllowed);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.ui.controls.ConferenceMicStateResolver
 * JD-Core Version:    0.6.2
 */