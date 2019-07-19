package com.viber.jni.wallet;

public abstract interface WalletControllerDelegate
{
  public abstract void onGetWalletSecureTokenReply(String paramString, int paramInt1, int paramInt2, int paramInt3);

  public abstract void onWalletSupported();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.wallet.WalletControllerDelegate
 * JD-Core Version:    0.6.2
 */