package com.viber.jni.secure;

public abstract interface SecureSecondaryActivationDelegate
{
  public abstract void onSecondaryStartActivation(boolean paramBoolean);

  public abstract void onSecureActivationCodeReceived(String paramString1, String paramString2, String paramString3, String paramString4);

  public abstract void onSecureSecondaryActivationFinished(int paramInt);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.secure.SecureSecondaryActivationDelegate
 * JD-Core Version:    0.6.2
 */