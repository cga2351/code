package com.viber.jni.remoteconfig;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class RemoteConfigListener extends ControllerListener<RemoteConfigDelegate>
  implements RemoteConfigDelegate
{
  public void onConfigChange(final String paramString)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(RemoteConfigDelegate paramAnonymousRemoteConfigDelegate)
      {
        paramAnonymousRemoteConfigDelegate.onConfigChange(paramString);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.remoteconfig.RemoteConfigListener
 * JD-Core Version:    0.6.2
 */