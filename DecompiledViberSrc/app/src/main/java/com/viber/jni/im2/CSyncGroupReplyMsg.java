package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CSyncGroupReplyMsg
{
  public final long groupID;
  public final Long lastMessageToken;
  public final int status;
  public final byte[] udid;

  public CSyncGroupReplyMsg(byte[] paramArrayOfByte, long paramLong, int paramInt)
  {
    this.udid = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.groupID = paramLong;
    this.status = paramInt;
    this.lastMessageToken = null;
    init();
  }

  public CSyncGroupReplyMsg(byte[] paramArrayOfByte, long paramLong1, int paramInt, long paramLong2)
  {
    this.udid = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.groupID = paramLong1;
    this.status = paramInt;
    this.lastMessageToken = Long.valueOf(paramLong2);
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
    public abstract void onCSyncGroupReplyMsg(CSyncGroupReplyMsg paramCSyncGroupReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSyncGroupReplyMsg
 * JD-Core Version:    0.6.2
 */