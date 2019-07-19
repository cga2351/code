package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CContactSavedInConversationNotificationReplyMsg
{
  public final int seq;
  public final int status;

  public CContactSavedInConversationNotificationReplyMsg(int paramInt1, int paramInt2)
  {
    this.seq = paramInt1;
    this.status = paramInt2;
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EContactSavedInConversationStatus
  {
    public static final int FAILED = 1;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCContactSavedInConversationNotificationReplyMsg(CContactSavedInConversationNotificationReplyMsg paramCContactSavedInConversationNotificationReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CContactSavedInConversationNotificationReplyMsg
 * JD-Core Version:    0.6.2
 */