package com.viber.jni.secure;

public abstract interface SecureActivationController
{
  public abstract String getHashForReRegister(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);

  public abstract String getSecureKeyforQR();

  public abstract boolean handleInitiateSecureSyncWithPrimary();

  public abstract void handleSecondaryDevicePush();

  public abstract boolean handleSecondaryQRPhotographed(byte[] paramArrayOfByte, String paramString, boolean paramBoolean, int paramInt);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.secure.SecureActivationController
 * JD-Core Version:    0.6.2
 */