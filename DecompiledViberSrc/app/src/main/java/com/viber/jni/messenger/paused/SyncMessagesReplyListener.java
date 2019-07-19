package com.viber.jni.messenger.paused;

import com.viber.jni.controller.ControllerListener.ControllerListenerAction;
import com.viber.jni.controller.PausedControllerListener;
import com.viber.jni.messenger.MessengerDelegate.SyncMessagesReply;

public class SyncMessagesReplyListener extends PausedControllerListener<MessengerDelegate.SyncMessagesReply>
  implements MessengerDelegate.SyncMessagesReply
{
  public SyncMessagesReplyListener(MessengerDelegate.SyncMessagesReply[] paramArrayOfSyncMessagesReply)
  {
    super(paramArrayOfSyncMessagesReply);
  }

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
 * Qualified Name:     com.viber.jni.messenger.paused.SyncMessagesReplyListener
 * JD-Core Version:    0.6.2
 */