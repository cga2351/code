package com.viber.jni.im2;

public class COnClickMsg
{
  public final int elementIndex;
  public final String onClickStr;
  public final String senderNum;
  public final int seq;

  public COnClickMsg(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.onClickStr = Im2Utils.checkStringValue(paramString1);
    this.elementIndex = paramInt1;
    this.seq = paramInt2;
    this.senderNum = Im2Utils.checkStringValue(paramString2);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCOnClickMsg(COnClickMsg paramCOnClickMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.COnClickMsg
 * JD-Core Version:    0.6.2
 */