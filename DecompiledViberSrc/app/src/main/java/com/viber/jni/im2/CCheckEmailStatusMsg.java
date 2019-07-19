package com.viber.jni.im2;

public class CCheckEmailStatusMsg
{
  public final String email;
  public final int seq;

  public CCheckEmailStatusMsg(int paramInt, String paramString)
  {
    this.seq = paramInt;
    this.email = Im2Utils.checkStringValue(paramString);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCCheckEmailStatusMsg(CCheckEmailStatusMsg paramCCheckEmailStatusMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CCheckEmailStatusMsg
 * JD-Core Version:    0.6.2
 */