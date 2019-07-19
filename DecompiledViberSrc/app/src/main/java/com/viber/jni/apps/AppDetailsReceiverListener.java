package com.viber.jni.apps;

import com.viber.jni.CGetAppDetails;
import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class AppDetailsReceiverListener extends ControllerListener<AppsControllerDelegate.AppDetailsReceiver>
  implements AppsControllerDelegate.AppDetailsReceiver
{
  public void onGetAppDetails(final CGetAppDetails[] paramArrayOfCGetAppDetails, final int paramInt1, final int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(AppsControllerDelegate.AppDetailsReceiver paramAnonymousAppDetailsReceiver)
      {
        paramAnonymousAppDetailsReceiver.onGetAppDetails(paramArrayOfCGetAppDetails, paramInt1, paramInt2);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.apps.AppDetailsReceiverListener
 * JD-Core Version:    0.6.2
 */