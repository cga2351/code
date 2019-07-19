package com.viber.jni.dialer;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class DialerEndScreenListener extends ControllerListener<DialerControllerDelegate.DialerEndScreen>
  implements DialerControllerDelegate.DialerEndScreen
{
  public void hideEndCall()
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DialerControllerDelegate.DialerEndScreen paramAnonymousDialerEndScreen)
      {
        paramAnonymousDialerEndScreen.hideEndCall();
      }
    });
  }

  public void showEndCall()
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DialerControllerDelegate.DialerEndScreen paramAnonymousDialerEndScreen)
      {
        paramAnonymousDialerEndScreen.showEndCall();
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.dialer.DialerEndScreenListener
 * JD-Core Version:    0.6.2
 */