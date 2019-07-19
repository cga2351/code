package com.viber.jni.im2;

public class CGetPersonalDetailsMsg
{
  public final int seq;

  public CGetPersonalDetailsMsg(int paramInt)
  {
    this.seq = paramInt;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCGetPersonalDetailsMsg(CGetPersonalDetailsMsg paramCGetPersonalDetailsMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetPersonalDetailsMsg
 * JD-Core Version:    0.6.2
 */