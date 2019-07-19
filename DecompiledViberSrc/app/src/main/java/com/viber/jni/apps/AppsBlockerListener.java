package com.viber.jni.apps;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class AppsBlockerListener extends ControllerListener<AppsControllerDelegate.Blocker>
  implements AppsControllerDelegate.Blocker
{
  public void onBlockAppReply(final int paramInt1, final int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(AppsControllerDelegate.Blocker paramAnonymousBlocker)
      {
        paramAnonymousBlocker.onBlockAppReply(paramInt1, paramInt2);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.apps.AppsBlockerListener
 * JD-Core Version:    0.6.2
 */