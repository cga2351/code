package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CChangeSettingsReplyMsg
{
  public final Integer sequence;
  public final int status;

  public CChangeSettingsReplyMsg(int paramInt)
  {
    this.status = paramInt;
    this.sequence = null;
    init();
  }

  public CChangeSettingsReplyMsg(int paramInt1, int paramInt2)
  {
    this.status = paramInt1;
    this.sequence = Integer.valueOf(paramInt2);
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CChangeSettingsReplyMsg{status=" + this.status + ", sequence=" + this.sequence + '}';
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int FAIL = 0;
    public static final int OK = 1;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCChangeSettingsReplyMsg(CChangeSettingsReplyMsg paramCChangeSettingsReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CChangeSettingsReplyMsg
 * JD-Core Version:    0.6.2
 */