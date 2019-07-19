package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CUpdateCommunitySettingsReplyMsg
{
  public final String invitationLink;
  public final int seq;
  public final int status;

  public CUpdateCommunitySettingsReplyMsg(int paramInt1, int paramInt2, String paramString)
  {
    this.seq = paramInt1;
    this.status = paramInt2;
    this.invitationLink = Im2Utils.checkStringValue(paramString);
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int FAILED = 2;
    public static final int NOT_ADMIN = 4;
    public static final int NOT_IN_GROUP = 3;
    public static final int OK = 0;
    public static final int TIMEOUT = 1;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCUpdateCommunitySettingsReplyMsg(CUpdateCommunitySettingsReplyMsg paramCUpdateCommunitySettingsReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CUpdateCommunitySettingsReplyMsg
 * JD-Core Version:    0.6.2
 */