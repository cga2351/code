package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CLateErrorOnReceivedMessageReplyMsg
{
  public final int sequence;
  public final int status;

  public CLateErrorOnReceivedMessageReplyMsg(int paramInt1, int paramInt2)
  {
    this.sequence = paramInt1;
    this.status = paramInt2;
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CLateErrorOnReceivedMessageReplyMsg{sequence=" + this.sequence + ", status=" + this.status + '}';
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int FAILED = 3;
    public static final int NOT_REG = 0;
    public static final int OK = 1;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCLateErrorOnReceivedMessageReplyMsg(CLateErrorOnReceivedMessageReplyMsg paramCLateErrorOnReceivedMessageReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CLateErrorOnReceivedMessageReplyMsg
 * JD-Core Version:    0.6.2
 */