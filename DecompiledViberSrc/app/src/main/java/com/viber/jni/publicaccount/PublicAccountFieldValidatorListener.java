package com.viber.jni.publicaccount;

import com.viber.jni.PublicAccountFieldStatusMap;
import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class PublicAccountFieldValidatorListener extends ControllerListener<PublicAccountControllerDelegate.PublicAccountFieldsValidatorReceiver>
  implements PublicAccountControllerDelegate.PublicAccountFieldsValidatorReceiver
{
  public void onValidatePublicAccountFieldsReply(final int paramInt1, final PublicAccountFieldStatusMap paramPublicAccountFieldStatusMap, final int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PublicAccountControllerDelegate.PublicAccountFieldsValidatorReceiver paramAnonymousPublicAccountFieldsValidatorReceiver)
      {
        paramAnonymousPublicAccountFieldsValidatorReceiver.onValidatePublicAccountFieldsReply(paramInt1, paramPublicAccountFieldStatusMap, paramInt2);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.publicaccount.PublicAccountFieldValidatorListener
 * JD-Core Version:    0.6.2
 */