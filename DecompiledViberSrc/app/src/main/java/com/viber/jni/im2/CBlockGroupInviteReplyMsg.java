package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CBlockGroupInviteReplyMsg
{
  public final int seq;
  public final int status;

  public CBlockGroupInviteReplyMsg(int paramInt1, int paramInt2)
  {
    this.status = paramInt1;
    this.seq = paramInt2;
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int FAIL = 2;
    public static final int OK = 0;
    public static final int TIMEOUT = 1;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCBlockGroupInviteReplyMsg(CBlockGroupInviteReplyMsg paramCBlockGroupInviteReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CBlockGroupInviteReplyMsg
 * JD-Core Version:    0.6.2
 */