package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CIsRegisteredNumberReplyMsg
{
  public final int status;
  public final String toNumber;

  public CIsRegisteredNumberReplyMsg(String paramString, int paramInt)
  {
    this.toNumber = Im2Utils.checkStringValue(paramString);
    this.status = paramInt;
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int FAILED = 1;
    public static final int NET_ERROR = 2;
    public static final int OK = 0;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCIsRegisteredNumberReplyMsg(CIsRegisteredNumberReplyMsg paramCIsRegisteredNumberReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CIsRegisteredNumberReplyMsg
 * JD-Core Version:    0.6.2
 */