package com.viber.jni.secure;

public abstract interface SecurePrimaryActivationDelegate
{
  public abstract void onSecureSecondaryDeviceActivated(byte[] paramArrayOfByte, int paramInt);

  public abstract void onSecureSecondaryRequest(int paramInt);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.secure.SecurePrimaryActivationDelegate
 * JD-Core Version:    0.6.2
 */