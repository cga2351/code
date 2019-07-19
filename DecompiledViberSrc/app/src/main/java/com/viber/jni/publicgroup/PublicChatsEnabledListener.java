package com.viber.jni.publicgroup;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class PublicChatsEnabledListener extends ControllerListener<PublicGroupControllerDelegate.EnabledDelegate>
  implements PublicGroupControllerDelegate.EnabledDelegate
{
  public void onPublicChatSupported(final int paramInt)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PublicGroupControllerDelegate.EnabledDelegate paramAnonymousEnabledDelegate)
      {
        paramAnonymousEnabledDelegate.onPublicChatSupported(paramInt);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.publicgroup.PublicChatsEnabledListener
 * JD-Core Version:    0.6.2
 */