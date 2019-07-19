package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CSecretChatSendEventReplyMsg
{
  public final int seq;
  public final int status;
  public final long token;

  public CSecretChatSendEventReplyMsg(int paramInt1, int paramInt2, long paramLong)
  {
    this.status = paramInt1;
    this.seq = paramInt2;
    this.token = paramLong;
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CSecretChatSendEventReplyMsg{status=" + this.status + ", seq=" + this.seq + ", token=" + this.token + '}';
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
    public abstract void onCSecretChatSendEventReplyMsg(CSecretChatSendEventReplyMsg paramCSecretChatSendEventReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSecretChatSendEventReplyMsg
 * JD-Core Version:    0.6.2
 */