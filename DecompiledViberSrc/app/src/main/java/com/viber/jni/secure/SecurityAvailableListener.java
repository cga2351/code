package com.viber.jni.secure;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class SecurityAvailableListener extends ControllerListener<SecurityAvailableDelegate>
  implements SecurityAvailableDelegate
{
  public void onSecurityAvailable(final boolean paramBoolean)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(SecurityAvailableDelegate paramAnonymousSecurityAvailableDelegate)
      {
        paramAnonymousSecurityAvailableDelegate.onSecurityAvailable(paramBoolean);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.secure.SecurityAvailableListener
 * JD-Core Version:    0.6.2
 */