package com.viber.jni.publicaccount;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class PublicAccountSubscribersCountListener extends ControllerListener<PublicAccountControllerDelegate.PublicAccountSubscribersCountReceiver>
  implements PublicAccountControllerDelegate.PublicAccountSubscribersCountReceiver
{
  public void onPublicAccountSubscribersCount(final int paramInt1, final int paramInt2, final String paramString, final int paramInt3)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PublicAccountControllerDelegate.PublicAccountSubscribersCountReceiver paramAnonymousPublicAccountSubscribersCountReceiver)
      {
        paramAnonymousPublicAccountSubscribersCountReceiver.onPublicAccountSubscribersCount(paramInt1, paramInt2, paramString, paramInt3);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.publicaccount.PublicAccountSubscribersCountListener
 * JD-Core Version:    0.6.2
 */