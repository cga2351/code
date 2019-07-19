package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CSyncConversationReplyMsg
{
  public final long lastMessageToken;
  public final String peerNumber;
  public final int status;
  public final byte[] udid;

  public CSyncConversationReplyMsg(byte[] paramArrayOfByte, String paramString, long paramLong, int paramInt)
  {
    this.udid = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.peerNumber = Im2Utils.checkStringValue(paramString);
    this.lastMessageToken = paramLong;
    this.status = paramInt;
    init();
  }

  private void init()
  {
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
    public abstract void onCSyncConversationReplyMsg(CSyncConversationReplyMsg paramCSyncConversationReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSyncConversationReplyMsg
 * JD-Core Version:    0.6.2
 */