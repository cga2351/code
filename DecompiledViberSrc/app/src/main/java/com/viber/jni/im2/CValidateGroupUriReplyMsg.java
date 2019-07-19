package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CValidateGroupUriReplyMsg
{
  public final int context;
  public final String groupUri;
  public final int status;

  public CValidateGroupUriReplyMsg(int paramInt1, String paramString, int paramInt2)
  {
    this.status = paramInt1;
    this.groupUri = Im2Utils.checkStringValue(paramString);
    this.context = paramInt2;
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int FAIL = 1;
    public static final int OK = 0;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCValidateGroupUriReplyMsg(CValidateGroupUriReplyMsg paramCValidateGroupUriReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CValidateGroupUriReplyMsg
 * JD-Core Version:    0.6.2
 */