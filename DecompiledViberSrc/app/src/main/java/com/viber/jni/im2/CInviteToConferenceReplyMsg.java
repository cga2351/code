package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

public class CInviteToConferenceReplyMsg
{
  public final String attachment;
  public final long callToken;
  public final Map<String, Integer> memberStatus;
  public final int seq;
  public final int status;

  public CInviteToConferenceReplyMsg(long paramLong, int paramInt1, String paramString, Map<String, Integer> paramMap, int paramInt2)
  {
    this.callToken = paramLong;
    this.status = paramInt1;
    this.attachment = Im2Utils.checkStringValue(paramString);
    this.memberStatus = Im2Utils.checkMapValue(paramMap);
    this.seq = paramInt2;
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int FAILED = 1;
    public static final int NOT_A_CALL_PARTICIPANT = 4;
    public static final int NO_SUCH_CALL = 3;
    public static final int OK = 0;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCInviteToConferenceReplyMsg(CInviteToConferenceReplyMsg paramCInviteToConferenceReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CInviteToConferenceReplyMsg
 * JD-Core Version:    0.6.2
 */