package com.viber.jni.im2;

public class CUnlinkViberIdMsg
{
  public final int seq;

  public CUnlinkViberIdMsg(int paramInt)
  {
    this.seq = paramInt;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCUnlinkViberIdMsg(CUnlinkViberIdMsg paramCUnlinkViberIdMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CUnlinkViberIdMsg
 * JD-Core Version:    0.6.2
 */