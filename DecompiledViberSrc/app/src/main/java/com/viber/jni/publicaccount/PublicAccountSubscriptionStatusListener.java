package com.viber.jni.publicaccount;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class PublicAccountSubscriptionStatusListener extends ControllerListener<PublicAccountControllerDelegate.PublicAccountSubscriptionStatusReceiver>
  implements PublicAccountControllerDelegate.PublicAccountSubscriptionStatusReceiver
{
  public void onSubscribeToPublicAccountReply(final int paramInt1, final int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PublicAccountControllerDelegate.PublicAccountSubscriptionStatusReceiver paramAnonymousPublicAccountSubscriptionStatusReceiver)
      {
        paramAnonymousPublicAccountSubscriptionStatusReceiver.onSubscribeToPublicAccountReply(paramInt1, paramInt2);
      }
    });
  }

  public void onUnSubscribeFromPublicAccountReply(final int paramInt1, final int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PublicAccountControllerDelegate.PublicAccountSubscriptionStatusReceiver paramAnonymousPublicAccountSubscriptionStatusReceiver)
      {
        paramAnonymousPublicAccountSubscriptionStatusReceiver.onUnSubscribeFromPublicAccountReply(paramInt1, paramInt2);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.publicaccount.PublicAccountSubscriptionStatusListener
 * JD-Core Version:    0.6.2
 */