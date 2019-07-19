package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CUpdateMyCommunitySettingsReplyMsg
{
  public final int seq;
  public final int status;

  public CUpdateMyCommunitySettingsReplyMsg(int paramInt1, int paramInt2)
  {
    this.seq = paramInt1;
    this.status = paramInt2;
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CUpdateMyCommunitySettingsReplyMsg{seq=" + this.seq + ", status=" + this.status + '}';
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int FAILED = 1;
    public static final int INVALID_INPUT = 3;
    public static final int OK = 0;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCUpdateMyCommunitySettingsReplyMsg(CUpdateMyCommunitySettingsReplyMsg paramCUpdateMyCommunitySettingsReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CUpdateMyCommunitySettingsReplyMsg
 * JD-Core Version:    0.6.2
 */