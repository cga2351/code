package com.viber.jni.im2;

public class CRefreshPublicAccountTokenMsg
{
  public final String publicAccountID;
  public final int seq;

  public CRefreshPublicAccountTokenMsg(int paramInt, String paramString)
  {
    this.seq = paramInt;
    this.publicAccountID = Im2Utils.checkStringValue(paramString);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCRefreshPublicAccountTokenMsg(CRefreshPublicAccountTokenMsg paramCRefreshPublicAccountTokenMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CRefreshPublicAccountTokenMsg
 * JD-Core Version:    0.6.2
 */