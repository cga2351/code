package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CGetUserDateOfBirthReplyMsg
{
  public final byte day;
  public final byte month;
  public final int seq;
  public final int status;
  public final short year;

  public CGetUserDateOfBirthReplyMsg(byte paramByte1, byte paramByte2, short paramShort, int paramInt1, int paramInt2)
  {
    this.day = paramByte1;
    this.month = paramByte2;
    this.year = paramShort;
    this.seq = paramInt1;
    this.status = paramInt2;
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CGetUserDateOfBirthReplyMsg{day=" + this.day + ", month=" + this.month + ", year=" + this.year + ", seq=" + this.seq + ", status=" + this.status + '}';
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
    public abstract void onCGetUserDateOfBirthReplyMsg(CGetUserDateOfBirthReplyMsg paramCGetUserDateOfBirthReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetUserDateOfBirthReplyMsg
 * JD-Core Version:    0.6.2
 */