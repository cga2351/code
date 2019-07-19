package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CUpdateUserNameReplyMsg
{
  public final int status;

  public CUpdateUserNameReplyMsg(int paramInt)
  {
    this.status = paramInt;
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int TIMEOUT = 2;
    public static final int USER_NAME_CHANGE_FAILED = 0;
    public static final int USER_NAME_CHANGE_OK = 1;
    public static final int USER_NAME_CHANGE_TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCUpdateUserNameReplyMsg(CUpdateUserNameReplyMsg paramCUpdateUserNameReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CUpdateUserNameReplyMsg
 * JD-Core Version:    0.6.2
 */