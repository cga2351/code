package com.viber.jni.messenger;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class SyncMessagesListener extends ControllerListener<MessengerDelegate.SyncMessages>
  implements MessengerDelegate.SyncMessages
{
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
 * Qualified Name:     com.viber.jni.messenger.SyncMessagesListener
 * JD-Core Version:    0.6.2
 */