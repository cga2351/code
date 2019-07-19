package com.viber.jni.dialer;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class DialerMuteStateListener extends ControllerListener<DialerControllerDelegate.DialerMuteState>
  implements DialerControllerDelegate.DialerMuteState
{
  public void mute()
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DialerControllerDelegate.DialerMuteState paramAnonymousDialerMuteState)
      {
        paramAnonymousDialerMuteState.mute();
      }
    });
  }

  public void unmute()
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DialerControllerDelegate.DialerMuteState paramAnonymousDialerMuteState)
      {
        paramAnonymousDialerMuteState.unmute();
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.dialer.DialerMuteStateListener
 * JD-Core Version:    0.6.2
 */