package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CSecretChatReceivedEventAckMsg
{
  public final int flags;
  public final long token;

  public CSecretChatReceivedEventAckMsg(long paramLong, int paramInt)
  {
    this.token = paramLong;
    this.flags = paramInt;
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CSecretChatReceivedEventAckMsg{token=" + this.token + ", flags=" + this.flags + '}';
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface AckFlags
  {
    public static final int PRE_ACK = 1;
  }

  public static abstract interface Sender
  {
    public abstract void handleCSecretChatReceivedEventAckMsg(CSecretChatReceivedEventAckMsg paramCSecretChatReceivedEventAckMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSecretChatReceivedEventAckMsg
 * JD-Core Version:    0.6.2
 */