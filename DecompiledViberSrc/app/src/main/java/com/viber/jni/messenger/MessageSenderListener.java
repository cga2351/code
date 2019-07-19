package com.viber.jni.messenger;

import com.viber.jni.controller.ControllerListener.ControllerListenerAction;
import com.viber.jni.controller.PausedControllerListener;

public class MessageSenderListener extends PausedControllerListener<MessengerDelegate.MessagesSender>
  implements MessengerDelegate.MessagesSender
{
  public MessageSenderListener()
  {
    super(new MessengerDelegate.MessagesSender[0]);
  }

  public boolean onMessageDelivered(final long paramLong1, long paramLong2, final int paramInt1, int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(MessengerDelegate.MessagesSender paramAnonymousMessagesSender)
      {
        paramAnonymousMessagesSender.onMessageDelivered(paramLong1, paramInt1, this.val$messageSeq, this.val$messageId);
      }
    });
    return false;
  }

  public void onSendMessageReply(final int paramInt1, final long paramLong, int paramInt2, final int paramInt3, final String paramString)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(MessengerDelegate.MessagesSender paramAnonymousMessagesSender)
      {
        paramAnonymousMessagesSender.onSendMessageReply(paramInt1, paramLong, paramInt3, paramString, this.val$formattedMsg);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.messenger.MessageSenderListener
 * JD-Core Version:    0.6.2
 */