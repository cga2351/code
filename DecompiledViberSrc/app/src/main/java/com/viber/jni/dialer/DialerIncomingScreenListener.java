package com.viber.jni.dialer;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;
import java.util.Map;

public class DialerIncomingScreenListener extends ControllerListener<DialerControllerDelegate.DialerIncomingScreen>
  implements DialerControllerDelegate.DialerIncomingScreen
{
  public void hideReception()
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DialerControllerDelegate.DialerIncomingScreen paramAnonymousDialerIncomingScreen)
      {
        paramAnonymousDialerIncomingScreen.hideReception();
      }
    });
  }

  public void showReception(final String paramString1, final String paramString2, final boolean paramBoolean, final int paramInt, final String paramString3, final String paramString4, final Map<String, String> paramMap)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(DialerControllerDelegate.DialerIncomingScreen paramAnonymousDialerIncomingScreen)
      {
        paramAnonymousDialerIncomingScreen.showReception(paramString1, paramString2, paramBoolean, paramInt, paramString3, paramString4, paramMap);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.dialer.DialerIncomingScreenListener
 * JD-Core Version:    0.6.2
 */