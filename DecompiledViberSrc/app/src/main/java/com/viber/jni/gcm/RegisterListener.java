package com.viber.jni.gcm;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class RegisterListener extends ControllerListener<RegisterDelegate>
  implements RegisterDelegate
{
  public void onIsRegistered(final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(RegisterDelegate paramAnonymousRegisterDelegate)
      {
        paramAnonymousRegisterDelegate.onIsRegistered(paramInt);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.gcm.RegisterListener
 * JD-Core Version:    0.6.2
 */