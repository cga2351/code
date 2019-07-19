package com.viber.jni.secure;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class SecureMessagesListener extends ControllerListener<SecureMessagesDelegate>
  implements SecureMessagesDelegate
{
  public void onSecureSessionInfo(final String paramString1, final boolean paramBoolean, final String paramString2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(SecureMessagesDelegate paramAnonymousSecureMessagesDelegate)
      {
        paramAnonymousSecureMessagesDelegate.onSecureSessionInfo(paramString1, paramBoolean, paramString2);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.secure.SecureMessagesListener
 * JD-Core Version:    0.6.2
 */