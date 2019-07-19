package com.viber.jni.publicaccount;

import com.viber.jni.PublicAccountInfo;
import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class PublicAccountInfoReceiverListener extends ControllerListener<PublicAccountControllerDelegate.PublicAccountInfoReceiver>
  implements PublicAccountControllerDelegate.PublicAccountInfoReceiver
{
  public void onPublicAccountInfo(final int paramInt1, final int paramInt2, final PublicAccountInfo paramPublicAccountInfo)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PublicAccountControllerDelegate.PublicAccountInfoReceiver paramAnonymousPublicAccountInfoReceiver)
      {
        paramAnonymousPublicAccountInfoReceiver.onPublicAccountInfo(paramInt1, paramInt2, paramPublicAccountInfo);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.publicaccount.PublicAccountInfoReceiverListener
 * JD-Core Version:    0.6.2
 */