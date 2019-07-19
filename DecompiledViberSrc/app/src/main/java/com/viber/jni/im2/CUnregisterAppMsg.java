package com.viber.jni.im2;

public class CUnregisterAppMsg
{
  public final short appId;
  public final int sequence;

  public CUnregisterAppMsg(short paramShort, int paramInt)
  {
    this.appId = paramShort;
    this.sequence = paramInt;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCUnregisterAppMsg(CUnregisterAppMsg paramCUnregisterAppMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CUnregisterAppMsg
 * JD-Core Version:    0.6.2
 */