package com.viber.jni.secure;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class TrustPeerMessagesListener extends ControllerListener<TrustPeerDelegate.MessagesDelegate>
  implements TrustPeerDelegate.MessagesDelegate
{
  public void onPeerIdentityBreached(final String paramString1, final String paramString2, final String paramString3)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(TrustPeerDelegate.MessagesDelegate paramAnonymousMessagesDelegate)
      {
        paramAnonymousMessagesDelegate.onPeerIdentityBreached(paramString1, paramString2, paramString3);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.secure.TrustPeerMessagesListener
 * JD-Core Version:    0.6.2
 */