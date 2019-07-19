package com.viber.jni.messenger.paused;

import com.viber.jni.controller.ControllerListener.ControllerListenerAction;
import com.viber.jni.controller.PausedControllerListener;
import com.viber.jni.messenger.MessengerDelegate.SyncMessages;

public class SyncMessagesListener extends PausedControllerListener<MessengerDelegate.SyncMessages>
  implements MessengerDelegate.SyncMessages
{
  public SyncMessagesListener(MessengerDelegate.SyncMessages[] paramArrayOfSyncMessages)
  {
    super(paramArrayOfSyncMessages);
  }

  public boolean onSyncMessages(final long[] paramArrayOfLong1, final long[] paramArrayOfLong2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(MessengerDelegate.SyncMessages paramAnonymousSyncMessages)
      {
        paramAnonymousSyncMessages.onSyncMessages(paramArrayOfLong1, paramArrayOfLong2);
      }
    });
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.messenger.paused.SyncMessagesListener
 * JD-Core Version:    0.6.2
 */