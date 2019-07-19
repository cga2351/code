package com.viber.jni.publicaccount;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class PublicAccountConversationStatusListener extends ControllerListener<PublicAccountControllerDelegate.PublicAccountConversationStatusReceiver>
  implements PublicAccountControllerDelegate.PublicAccountConversationStatusReceiver
{
  public void onSendConversationStatusReply(final String paramString, final int paramInt1, final int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PublicAccountControllerDelegate.PublicAccountConversationStatusReceiver paramAnonymousPublicAccountConversationStatusReceiver)
      {
        paramAnonymousPublicAccountConversationStatusReceiver.onSendConversationStatusReply(paramString, paramInt1, paramInt2);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.publicaccount.PublicAccountConversationStatusListener
 * JD-Core Version:    0.6.2
 */