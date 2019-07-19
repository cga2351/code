package com.viber.jni.spam;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class UnknownNumberSaveListener extends ControllerListener<UnknownNumberSaveDelegate>
  implements UnknownNumberSaveDelegate
{
  public void onContactSavedNotificationReply(final int paramInt1, final int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(UnknownNumberSaveDelegate paramAnonymousUnknownNumberSaveDelegate)
      {
        paramAnonymousUnknownNumberSaveDelegate.onContactSavedNotificationReply(paramInt1, paramInt2);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.spam.UnknownNumberSaveListener
 * JD-Core Version:    0.6.2
 */