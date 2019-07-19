package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CSendActionToBotReplyMsg
{
  public final long messageToken;
  public final String msgInfo;
  public final String publicAccountId;
  public final int seq;
  public final int status;

  public CSendActionToBotReplyMsg(String paramString1, int paramInt1, String paramString2, long paramLong, int paramInt2)
  {
    this.publicAccountId = Im2Utils.checkStringValue(paramString1);
    this.seq = paramInt1;
    this.msgInfo = Im2Utils.checkStringValue(paramString2);
    this.messageToken = paramLong;
    this.status = paramInt2;
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EServerStatus
  {
    public static final int ERR_BAD_DATA = 3;
    public static final int ERR_GENERIC = 1;
    public static final int ERR_TIMEOUT = 2;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCSendActionToBotReplyMsg(CSendActionToBotReplyMsg paramCSendActionToBotReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSendActionToBotReplyMsg
 * JD-Core Version:    0.6.2
 */