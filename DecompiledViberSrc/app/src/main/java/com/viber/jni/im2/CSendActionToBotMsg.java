package com.viber.jni.im2;

public class CSendActionToBotMsg
{
  public final int flags;
  public final String msgInfo;
  public final String publicAccountId;
  public final int seq;

  public CSendActionToBotMsg(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.publicAccountId = Im2Utils.checkStringValue(paramString1);
    this.flags = paramInt1;
    this.seq = paramInt2;
    this.msgInfo = Im2Utils.checkStringValue(paramString2);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCSendActionToBotMsg(CSendActionToBotMsg paramCSendActionToBotMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSendActionToBotMsg
 * JD-Core Version:    0.6.2
 */