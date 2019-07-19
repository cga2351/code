package com.viber.jni.secure;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class SecureActivationWrapper
  implements SecureActivationController
{
  private static final Logger L = ViberEnv.getLogger();
  private final SecureActivationController mSecureActivationController;

  public SecureActivationWrapper(SecureActivationController paramSecureActivationController)
  {
    this.mSecureActivationController = paramSecureActivationController;
  }

  public String getHashForReRegister(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return this.mSecureActivationController.getHashForReRegister(paramArrayOfByte1, paramArrayOfByte2);
  }

  public String getSecureKeyforQR()
  {
    return this.mSecureActivationController.getSecureKeyforQR();
  }

  public boolean handleInitiateSecureSyncWithPrimary()
  {
    return this.mSecureActivationController.handleInitiateSecureSyncWithPrimary();
  }

  public void handleSecondaryDevicePush()
  {
    this.mSecureActivationController.handleSecondaryDevicePush();
  }

  public boolean handleSecondaryQRPhotographed(byte[] paramArrayOfByte, String paramString, boolean paramBoolean, int paramInt)
  {
    return this.mSecureActivationController.handleSecondaryQRPhotographed(paramArrayOfByte, paramString, paramBoolean, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.secure.SecureActivationWrapper
 * JD-Core Version:    0.6.2
 */