package com.viber.jni.secure;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class SecurePrimaryActivationListener extends ControllerListener<SecurePrimaryActivationDelegate>
  implements SecurePrimaryActivationDelegate
{
  public void onSecureSecondaryDeviceActivated(final byte[] paramArrayOfByte, final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(SecurePrimaryActivationDelegate paramAnonymousSecurePrimaryActivationDelegate)
      {
        paramAnonymousSecurePrimaryActivationDelegate.onSecureSecondaryDeviceActivated(paramArrayOfByte, paramInt);
      }
    });
  }

  public void onSecureSecondaryRequest(final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(SecurePrimaryActivationDelegate paramAnonymousSecurePrimaryActivationDelegate)
      {
        paramAnonymousSecurePrimaryActivationDelegate.onSecureSecondaryRequest(paramInt);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.secure.SecurePrimaryActivationListener
 * JD-Core Version:    0.6.2
 */