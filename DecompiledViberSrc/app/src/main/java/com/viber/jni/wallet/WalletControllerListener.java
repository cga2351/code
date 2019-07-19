package com.viber.jni.wallet;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class WalletControllerListener extends ControllerListener<WalletControllerDelegate>
  implements WalletControllerDelegate
{
  public void onGetWalletSecureTokenReply(final String paramString, final int paramInt1, final int paramInt2, final int paramInt3)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(WalletControllerDelegate paramAnonymousWalletControllerDelegate)
      {
        paramAnonymousWalletControllerDelegate.onGetWalletSecureTokenReply(paramString, paramInt1, paramInt2, paramInt3);
      }
    });
  }

  public void onWalletSupported()
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(WalletControllerDelegate paramAnonymousWalletControllerDelegate)
      {
        paramAnonymousWalletControllerDelegate.onWalletSupported();
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.wallet.WalletControllerListener
 * JD-Core Version:    0.6.2
 */