package com.viber.jni.messenger;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;
import com.viber.jni.im2.CGroupMessageReceivedMsg;
import com.viber.jni.im2.CPGMessageReceivedMsg;
import com.viber.jni.im2.interfaces.IncomingGroupMessageReceiver;

public class IncomingGroupMessagesReceiverListener extends ControllerListener<IncomingGroupMessageReceiver>
  implements IncomingGroupMessageReceiver
{
  public void onCGroupMessageReceivedMsg(final CGroupMessageReceivedMsg paramCGroupMessageReceivedMsg)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(IncomingGroupMessageReceiver paramAnonymousIncomingGroupMessageReceiver)
      {
        paramAnonymousIncomingGroupMessageReceiver.onCGroupMessageReceivedMsg(paramCGroupMessageReceivedMsg);
      }
    });
  }

  public void onCPGMessageReceivedMsg(final CPGMessageReceivedMsg paramCPGMessageReceivedMsg)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(IncomingGroupMessageReceiver paramAnonymousIncomingGroupMessageReceiver)
      {
        paramAnonymousIncomingGroupMessageReceiver.onCPGMessageReceivedMsg(paramCPGMessageReceivedMsg);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.messenger.IncomingGroupMessagesReceiverListener
 * JD-Core Version:    0.6.2
 */