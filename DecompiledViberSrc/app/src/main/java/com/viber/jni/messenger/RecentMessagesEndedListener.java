package com.viber.jni.messenger;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class RecentMessagesEndedListener extends ControllerListener<MessengerDelegate.RecentMessagesEnded>
  implements MessengerDelegate.RecentMessagesEnded
{
  public void onGetRecentMessagesEnded(final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(MessengerDelegate.RecentMessagesEnded paramAnonymousRecentMessagesEnded)
      {
        paramAnonymousRecentMessagesEnded.onGetRecentMessagesEnded(paramInt);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.messenger.RecentMessagesEndedListener
 * JD-Core Version:    0.6.2
 */