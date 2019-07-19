package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CUpdateUserDateOfBirthReplyMsg
{
  public final int seq;
  public final int status;

  public CUpdateUserDateOfBirthReplyMsg(int paramInt1, int paramInt2)
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
    return "CUpdateUserDateOfBirthReplyMsg{seq=" + this.seq + ", status=" + this.status + '}';
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int FAILED = 1;
    public static final int OK = 0;
    public static final int TIMEOUT = 2;
    public static final int USER_DATE_OF_BIRTH_INVALID = 3;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCUpdateUserDateOfBirthReplyMsg(CUpdateUserDateOfBirthReplyMsg paramCUpdateUserDateOfBirthReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CUpdateUserDateOfBirthReplyMsg
 * JD-Core Version:    0.6.2
 */