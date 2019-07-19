package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CSendConversationStatusReplyMsg
{
  public final String publicAccountId;
  public final int seq;
  public final int status;

  public CSendConversationStatusReplyMsg(int paramInt1, String paramString, int paramInt2)
  {
    this.status = paramInt1;
    this.publicAccountId = Im2Utils.checkStringValue(paramString);
    this.seq = paramInt2;
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface CStatus
  {
    public static final int FAILED = 1;
    public static final int NOT_REG = 2;
    public static final int OK = 0;
    public static final int PUBLIC_ACCOUNT_BLOCKED = 6;
    public static final int PUBLIC_ACCOUNT_NOT_FOUND = 4;
    public static final int PUBLIC_ACCOUNT_NOT_READY = 5;
    public static final int PUBLIC_ACCOUNT_SUSPENDED = 7;
    public static final int TIMEOUT = 3;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCSendConversationStatusReplyMsg(CSendConversationStatusReplyMsg paramCSendConversationStatusReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSendConversationStatusReplyMsg
 * JD-Core Version:    0.6.2
 */