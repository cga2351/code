package com.viber.jni.messenger;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class SyncMessagesReplyListener extends ControllerListener<MessengerDelegate.SyncMessagesReply>
  implements MessengerDelegate.SyncMessagesReply
{
  public void onSyncMessagesReply(final int paramInt1, final long[] paramArrayOfLong, final int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(MessengerDelegate.SyncMessagesReply paramAnonymousSyncMessagesReply)
      {
        paramAnonymousSyncMessagesReply.onSyncMessagesReply(paramInt1, paramArrayOfLong, paramInt2);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.messenger.SyncMessagesReplyListener
 * JD-Core Version:    0.6.2
 */