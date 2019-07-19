package com.viber.jni.apps;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class AppsAuthentucatorListener extends ControllerListener<AppsControllerDelegate.Authenticator>
  implements AppsControllerDelegate.Authenticator
{
  public void onAuthenticateAppReply(final String paramString, final int paramInt1, final int paramInt2, final int paramInt3)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(AppsControllerDelegate.Authenticator paramAnonymousAuthenticator)
      {
        paramAnonymousAuthenticator.onAuthenticateAppReply(paramString, paramInt1, paramInt2, paramInt3);
      }
    });
  }

  public void onUnregisterAppReply(final int paramInt1, final int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(AppsControllerDelegate.Authenticator paramAnonymousAuthenticator)
      {
        paramAnonymousAuthenticator.onUnregisterAppReply(paramInt1, paramInt2);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.apps.AppsAuthentucatorListener
 * JD-Core Version:    0.6.2
 */