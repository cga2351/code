package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CGetMyCommunitySettingsReplyMsg
{
  public final int seq;
  public final String settings;
  public final int status;

  public CGetMyCommunitySettingsReplyMsg(int paramInt1, int paramInt2, String paramString)
  {
    this.seq = paramInt1;
    this.status = paramInt2;
    this.settings = Im2Utils.checkStringValue(paramString);
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CGetMyCommunitySettingsReplyMsg{seq=" + this.seq + ", status=" + this.status + ", settings='" + this.settings + '\'' + '}';
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int FAILED = 1;
    public static final int OK = 0;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCGetMyCommunitySettingsReplyMsg(CGetMyCommunitySettingsReplyMsg paramCGetMyCommunitySettingsReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetMyCommunitySettingsReplyMsg
 * JD-Core Version:    0.6.2
 */