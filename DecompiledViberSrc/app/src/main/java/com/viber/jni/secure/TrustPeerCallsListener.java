package com.viber.jni.secure;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class TrustPeerCallsListener extends ControllerListener<TrustPeerDelegate.CallsDelegate>
  implements TrustPeerDelegate.CallsDelegate
{
  public void onSecureCallStateChange(final long paramLong, int paramInt1, final byte[] paramArrayOfByte, final int paramInt2, final String paramString)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(TrustPeerDelegate.CallsDelegate paramAnonymousCallsDelegate)
      {
        paramAnonymousCallsDelegate.onSecureCallStateChange(paramLong, paramArrayOfByte, paramInt2, paramString, this.val$sharedSecretString);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.secure.TrustPeerCallsListener
 * JD-Core Version:    0.6.2
 */