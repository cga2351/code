package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

public class CGetInviteLinksReplyMsg
{
  public final String groupInviteLink;
  public final Map<String, String> inviteLinks;
  public final int seq;
  public final int status;

  public CGetInviteLinksReplyMsg(int paramInt1, int paramInt2, String paramString, Map<String, String> paramMap)
  {
    this.seq = paramInt1;
    this.status = paramInt2;
    this.groupInviteLink = Im2Utils.checkStringValue(paramString);
    this.inviteLinks = Im2Utils.checkMapValue(paramMap);
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int FAILED = 1;
    public static final int INVALID_INPUT = 4;
    public static final int NO_PRIVILEGES = 3;
    public static final int OK = 0;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCGetInviteLinksReplyMsg(CGetInviteLinksReplyMsg paramCGetInviteLinksReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetInviteLinksReplyMsg
 * JD-Core Version:    0.6.2
 */