package com.viber.jni.apps;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class AppsUserAppsReceiverListener extends ControllerListener<AppsControllerDelegate.UserAppsReceiver>
  implements AppsControllerDelegate.UserAppsReceiver
{
  public void onGetUserAppsReply(final int[] paramArrayOfInt, final int paramInt1, final int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(AppsControllerDelegate.UserAppsReceiver paramAnonymousUserAppsReceiver)
      {
        paramAnonymousUserAppsReceiver.onGetUserAppsReply(paramArrayOfInt, paramInt1, paramInt2);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.apps.AppsUserAppsReceiverListener
 * JD-Core Version:    0.6.2
 */