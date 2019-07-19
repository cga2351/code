package com.viber.jni.messenger;

import com.viber.jni.CGroupMessageStatus;
import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class GroupMessageStatusListener extends ControllerListener<MessengerDelegate.GroupMessageStatusReply>
  implements MessengerDelegate.GroupMessageStatusReply
{
  public boolean onGetGroupMessageStatusReply(final long paramLong, int paramInt1, final int paramInt2, final CGroupMessageStatus[] paramArrayOfCGroupMessageStatus)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(MessengerDelegate.GroupMessageStatusReply paramAnonymousGroupMessageStatusReply)
      {
        paramAnonymousGroupMessageStatusReply.onGetGroupMessageStatusReply(paramLong, paramInt2, paramArrayOfCGroupMessageStatus, this.val$messages);
      }
    });
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.messenger.GroupMessageStatusListener
 * JD-Core Version:    0.6.2
 */