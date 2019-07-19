package com.viber.jni.messenger;

import com.viber.jni.controller.ControllerListener.ControllerListenerAction;
import com.viber.jni.controller.PausedControllerListener;

public class DeleteMessageListener extends PausedControllerListener<MessengerDelegate.DeleteMessages>
  implements MessengerDelegate.DeleteMessages
{
  public DeleteMessageListener()
  {
    super(new MessengerDelegate.DeleteMessages[0]);
  }

  public void onDeleteMessageReply(final long paramLong, int paramInt1, final int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(MessengerDelegate.DeleteMessages paramAnonymousDeleteMessages)
      {
        paramAnonymousDeleteMessages.onDeleteMessageReply(paramLong, paramInt2, this.val$status);
      }
    });
  }

  public boolean onDeletedGroupMessage(final String paramString, final long paramLong1, long paramLong2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(MessengerDelegate.DeleteMessages paramAnonymousDeleteMessages)
      {
        paramAnonymousDeleteMessages.onDeletedGroupMessage(paramString, paramLong1, this.val$messageToken);
      }
    });
    return false;
  }

  public boolean onDeletedMessage(final String paramString, final long paramLong)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(MessengerDelegate.DeleteMessages paramAnonymousDeleteMessages)
      {
        paramAnonymousDeleteMessages.onDeletedMessage(paramString, paramLong);
      }
    });
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.messenger.DeleteMessageListener
 * JD-Core Version:    0.6.2
 */