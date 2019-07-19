package com.viber.jni.secure;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class SecureTokenListener extends ControllerListener<SecureTokenDelegate>
  implements SecureTokenDelegate
{
  public void onSecureTokenReply(final int paramInt, final long paramLong, byte[] paramArrayOfByte)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(SecureTokenDelegate paramAnonymousSecureTokenDelegate)
      {
        paramAnonymousSecureTokenDelegate.onSecureTokenReply(paramInt, paramLong, this.val$token);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.secure.SecureTokenListener
 * JD-Core Version:    0.6.2
 */