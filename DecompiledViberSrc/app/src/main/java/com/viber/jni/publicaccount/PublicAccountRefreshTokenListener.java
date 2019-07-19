package com.viber.jni.publicaccount;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class PublicAccountRefreshTokenListener extends ControllerListener<PublicAccountControllerDelegate.PublicAccountRefreshTokenReceiver>
  implements PublicAccountControllerDelegate.PublicAccountRefreshTokenReceiver
{
  public void onPublicAccountRefreshToken(final int paramInt1, final int paramInt2, final String paramString1, final String paramString2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PublicAccountControllerDelegate.PublicAccountRefreshTokenReceiver paramAnonymousPublicAccountRefreshTokenReceiver)
      {
        paramAnonymousPublicAccountRefreshTokenReceiver.onPublicAccountRefreshToken(paramInt1, paramInt2, paramString1, paramString2);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.publicaccount.PublicAccountRefreshTokenListener
 * JD-Core Version:    0.6.2
 */