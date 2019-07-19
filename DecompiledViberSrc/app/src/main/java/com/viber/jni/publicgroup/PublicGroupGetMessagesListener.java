package com.viber.jni.publicgroup;

import com.viber.jni.PublicGroupChangeEvent;
import com.viber.jni.PublicGroupMessage;
import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class PublicGroupGetMessagesListener extends ControllerListener<PublicGroupControllerDelegate.PublicGroupGetMessages>
  implements PublicGroupControllerDelegate.PublicGroupGetMessages
{
  public void onGetPublicGroupMessages(final int paramInt1, final long paramLong, PublicGroupMessage[] paramArrayOfPublicGroupMessage, final PublicGroupChangeEvent[] paramArrayOfPublicGroupChangeEvent, final int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PublicGroupControllerDelegate.PublicGroupGetMessages paramAnonymousPublicGroupGetMessages)
      {
        paramAnonymousPublicGroupGetMessages.onGetPublicGroupMessages(paramInt1, paramLong, paramArrayOfPublicGroupChangeEvent, paramInt2, this.val$status);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.publicgroup.PublicGroupGetMessagesListener
 * JD-Core Version:    0.6.2
 */