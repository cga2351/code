package com.viber.jni.secure;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class SecureSecondaryActivationListener extends ControllerListener<SecureSecondaryActivationDelegate>
  implements SecureSecondaryActivationDelegate
{
  public void onSecondaryStartActivation(final boolean paramBoolean)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(SecureSecondaryActivationDelegate paramAnonymousSecureSecondaryActivationDelegate)
      {
        paramAnonymousSecureSecondaryActivationDelegate.onSecondaryStartActivation(paramBoolean);
      }
    });
  }

  public void onSecureActivationCodeReceived(final String paramString1, final String paramString2, final String paramString3, final String paramString4)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(SecureSecondaryActivationDelegate paramAnonymousSecureSecondaryActivationDelegate)
      {
        paramAnonymousSecureSecondaryActivationDelegate.onSecureActivationCodeReceived(paramString1, paramString2, paramString3, paramString4);
      }
    });
  }

  public void onSecureSecondaryActivationFinished(final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(SecureSecondaryActivationDelegate paramAnonymousSecureSecondaryActivationDelegate)
      {
        paramAnonymousSecureSecondaryActivationDelegate.onSecureSecondaryActivationFinished(paramInt);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.secure.SecureSecondaryActivationListener
 * JD-Core Version:    0.6.2
 */