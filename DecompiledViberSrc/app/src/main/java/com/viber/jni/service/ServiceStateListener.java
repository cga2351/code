package com.viber.jni.service;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class ServiceStateListener extends ControllerListener<ServiceStateDelegate>
  implements ServiceStateDelegate
{
  public void onServiceStateChanged(final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(ServiceStateDelegate paramAnonymousServiceStateDelegate)
      {
        paramAnonymousServiceStateDelegate.onServiceStateChanged(paramInt);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.service.ServiceStateListener
 * JD-Core Version:    0.6.2
 */