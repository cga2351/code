package com.viber.jni.spam;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class BlockedUserSplashListener extends ControllerListener<BlockedUserSplashDelegate>
  implements BlockedUserSplashDelegate
{
  public void onBlockedStatus(final String paramString)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(BlockedUserSplashDelegate paramAnonymousBlockedUserSplashDelegate)
      {
        paramAnonymousBlockedUserSplashDelegate.onBlockedStatus(paramString);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.spam.BlockedUserSplashListener
 * JD-Core Version:    0.6.2
 */