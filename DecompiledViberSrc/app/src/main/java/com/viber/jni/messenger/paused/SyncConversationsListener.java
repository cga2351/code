package com.viber.jni.messenger.paused;

import com.viber.jni.controller.ControllerListener.ControllerListenerAction;
import com.viber.jni.controller.PausedControllerListener;
import com.viber.jni.messenger.MessengerDelegate.SyncConversations;

public class SyncConversationsListener extends PausedControllerListener<MessengerDelegate.SyncConversations>
  implements MessengerDelegate.SyncConversations
{
  public SyncConversationsListener(MessengerDelegate.SyncConversations[] paramArrayOfSyncConversations)
  {
    super(paramArrayOfSyncConversations);
  }

  public boolean onSyncConversation(final String paramString, final long paramLong, int paramInt1, final int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(MessengerDelegate.SyncConversations paramAnonymousSyncConversations)
      {
        paramAnonymousSyncConversations.onSyncConversation(paramString, paramLong, paramInt2, this.val$chatType);
      }
    });
    return false;
  }

  public boolean onSyncGroup(final long paramLong1, long paramLong2, final int paramInt1, int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(MessengerDelegate.SyncConversations paramAnonymousSyncConversations)
      {
        paramAnonymousSyncConversations.onSyncGroup(paramLong1, paramInt1, this.val$lastMessageId, this.val$flags);
      }
    });
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.messenger.paused.SyncConversationsListener
 * JD-Core Version:    0.6.2
 */