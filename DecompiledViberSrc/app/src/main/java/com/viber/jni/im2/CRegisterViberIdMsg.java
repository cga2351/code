package com.viber.jni.im2;

public class CRegisterViberIdMsg
{
  public final String email;
  public final String emailPassword;
  public final boolean promotionsAgreed;
  public final int seq;

  public CRegisterViberIdMsg(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.seq = paramInt;
    this.email = Im2Utils.checkStringValue(paramString1);
    this.emailPassword = Im2Utils.checkStringValue(paramString2);
    this.promotionsAgreed = paramBoolean;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCRegisterViberIdMsg(CRegisterViberIdMsg paramCRegisterViberIdMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CRegisterViberIdMsg
 * JD-Core Version:    0.6.2
 */