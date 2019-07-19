package com.viber.jni.im2;

public class CUnregisterAppReplyMsg
{
  public final int sequence;
  public final int status;

  public CUnregisterAppReplyMsg(int paramInt1, int paramInt2)
  {
    this.status = paramInt1;
    this.sequence = paramInt2;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCUnregisterAppReplyMsg(CUnregisterAppReplyMsg paramCUnregisterAppReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CUnregisterAppReplyMsg
 * JD-Core Version:    0.6.2
 */