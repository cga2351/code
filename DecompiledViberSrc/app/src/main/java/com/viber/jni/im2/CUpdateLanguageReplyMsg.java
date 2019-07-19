package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CUpdateLanguageReplyMsg
{
  public final int status;

  public CUpdateLanguageReplyMsg(int paramInt)
  {
    this.status = paramInt;
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface ELangUpdateStatus
  {
    public static final int LANGUAGE_UPDATE_FAILED = 0;
    public static final int LANGUAGE_UPDATE_NOT_NEEDED = 4;
    public static final int LANGUAGE_UPDATE_NOT_SUPPORTED = 3;
    public static final int LANGUAGE_UPDATE_OK = 1;
    public static final int LANGUAGE_UPDATE_TIMEOUT = 2;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCUpdateLanguageReplyMsg(CUpdateLanguageReplyMsg paramCUpdateLanguageReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CUpdateLanguageReplyMsg
 * JD-Core Version:    0.6.2
 */