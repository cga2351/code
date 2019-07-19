package com.viber.jni.apps;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class AppsSupportListener extends ControllerListener<AppsControllerDelegate.Support>
  implements AppsControllerDelegate.Support
{
  public void onAppsApiSupported()
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(AppsControllerDelegate.Support paramAnonymousSupport)
      {
        paramAnonymousSupport.onAppsApiSupported();
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.apps.AppsSupportListener
 * JD-Core Version:    0.6.2
 */