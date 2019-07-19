package com.viber.jni.im2;

public class CChangeViberIdEmailMsg
{
  public final String newEmail;
  public final String password;
  public final int seq;

  public CChangeViberIdEmailMsg(int paramInt, String paramString1, String paramString2)
  {
    this.seq = paramInt;
    this.newEmail = Im2Utils.checkStringValue(paramString1);
    this.password = Im2Utils.checkStringValue(paramString2);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCChangeViberIdEmailMsg(CChangeViberIdEmailMsg paramCChangeViberIdEmailMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CChangeViberIdEmailMsg
 * JD-Core Version:    0.6.2
 */