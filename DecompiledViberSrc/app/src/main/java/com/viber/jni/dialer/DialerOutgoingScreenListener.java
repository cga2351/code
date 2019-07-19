package com.viber.jni.dialer;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class DialerOutgoingScreenListener extends ControllerListener<DialerControllerDelegate.DialerOutgoingScreen>
  implements DialerControllerDelegate.DialerOutgoingScreen
{
  public void hideCall(final String paramString, final boolean paramBoolean)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DialerControllerDelegate.DialerOutgoingScreen paramAnonymousDialerOutgoingScreen)
      {
        paramAnonymousDialerOutgoingScreen.hideCall(paramString, paramBoolean);
      }
    });
  }

  public void showCall(final String paramString, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DialerControllerDelegate.DialerOutgoingScreen paramAnonymousDialerOutgoingScreen)
      {
        paramAnonymousDialerOutgoingScreen.showCall(paramString, paramBoolean1, paramBoolean2);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.dialer.DialerOutgoingScreenListener
 * JD-Core Version:    0.6.2
 */