package com.viber.jni.dialer;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class DialerPhoneStateListener extends ControllerListener<DialerControllerDelegate.DialerPhoneState>
  implements DialerControllerDelegate.DialerPhoneState
{
  public void onPhoneStateChanged(final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DialerControllerDelegate.DialerPhoneState paramAnonymousDialerPhoneState)
      {
        paramAnonymousDialerPhoneState.onPhoneStateChanged(paramInt);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.dialer.DialerPhoneStateListener
 * JD-Core Version:    0.6.2
 */