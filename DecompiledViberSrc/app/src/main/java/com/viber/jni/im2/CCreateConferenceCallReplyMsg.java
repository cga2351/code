package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

public class CCreateConferenceCallReplyMsg
{
  public final String attachment;
  public final long callToken;
  public final String confID;
  public final Map<String, Integer> memberStatus;
  public final int seq;
  public final int status;

  public CCreateConferenceCallReplyMsg(int paramInt1, int paramInt2, long paramLong, String paramString1, String paramString2, Map<String, Integer> paramMap)
  {
    this.status = paramInt1;
    this.seq = paramInt2;
    this.callToken = paramLong;
    this.confID = Im2Utils.checkStringValue(paramString1);
    this.attachment = Im2Utils.checkStringValue(paramString2);
    this.memberStatus = Im2Utils.checkMapValue(paramMap);
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int FAILED = 1;
    public static final int FAILED_MEMBERS = 5;
    public static final int NO_RECIPIENTS = 4;
    public static final int NO_SERVICE = 3;
    public static final int OK = 0;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCCreateConferenceCallReplyMsg(CCreateConferenceCallReplyMsg paramCCreateConferenceCallReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CCreateConferenceCallReplyMsg
 * JD-Core Version:    0.6.2
 */