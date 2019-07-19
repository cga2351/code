package com.viber.jni.im2;

public class CGetViberIdMsg
{
  public final int seq;

  public CGetViberIdMsg(int paramInt)
  {
    this.seq = paramInt;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCGetViberIdMsg(CGetViberIdMsg paramCGetViberIdMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetViberIdMsg
 * JD-Core Version:    0.6.2
 */