package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CJoinConfCallReplyMsg
{
  public final String attachment;
  public final long callToken;
  public final byte[] compressedSdpAnswer;
  public final String confID;
  public final int seq;
  public final int status;

  public CJoinConfCallReplyMsg(int paramInt1, long paramLong, byte[] paramArrayOfByte, String paramString1, String paramString2, int paramInt2)
  {
    this.status = paramInt1;
    this.callToken = paramLong;
    this.compressedSdpAnswer = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.attachment = Im2Utils.checkStringValue(paramString1);
    this.confID = Im2Utils.checkStringValue(paramString2);
    this.seq = paramInt2;
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int ALREADY_IN_CALL_ON_ANOTHER_DEVICE = 5;
    public static final int FAILED = 1;
    public static final int NOT_ALLOWED = 4;
    public static final int NO_SUCH_CALL = 3;
    public static final int OK = 0;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCJoinConfCallReplyMsg(CJoinConfCallReplyMsg paramCJoinConfCallReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CJoinConfCallReplyMsg
 * JD-Core Version:    0.6.2
 */