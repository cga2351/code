package com.viber.jni.location;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class ViberLocationListener extends ControllerListener<ViberLocationDelegate>
  implements ViberLocationDelegate
{
  public void onSendLocation()
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(ViberLocationDelegate paramAnonymousViberLocationDelegate)
      {
        paramAnonymousViberLocationDelegate.onSendLocation();
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.location.ViberLocationListener
 * JD-Core Version:    0.6.2
 */