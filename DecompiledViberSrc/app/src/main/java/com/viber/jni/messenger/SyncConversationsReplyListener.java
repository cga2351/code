package com.viber.jni.messenger;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class SyncConversationsReplyListener extends ControllerListener<MessengerDelegate.SyncConversationsReply>
  implements MessengerDelegate.SyncConversationsReply
{
  public void onSyncConversationReply(final String paramString, final long paramLong, int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(MessengerDelegate.SyncConversationsReply paramAnonymousSyncConversationsReply)
      {
        paramAnonymousSyncConversationsReply.onSyncConversationReply(paramString, paramLong, this.val$status);
      }
    });
  }

  public void onSyncGroupReply(final long paramLong1, long paramLong2, final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(MessengerDelegate.SyncConversationsReply paramAnonymousSyncConversationsReply)
      {
        paramAnonymousSyncConversationsReply.onSyncGroupReply(paramLong1, paramInt, this.val$status);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.messenger.SyncConversationsReplyListener
 * JD-Core Version:    0.6.2
 */