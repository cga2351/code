package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CShareAddressBook2ReplyMsg
{
  public final short revision;
  public final int seq;
  public final int status;

  public CShareAddressBook2ReplyMsg(int paramInt1, short paramShort, int paramInt2)
  {
    this.seq = paramInt1;
    this.revision = paramShort;
    this.status = paramInt2;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCShareAddressBook2ReplyMsg(CShareAddressBook2ReplyMsg paramCShareAddressBook2ReplyMsg);
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface STATUS
  {
    public static final int BAD_REV = 1;
    public static final int FAILED = 4;
    public static final int INVALID_DATA = 2;
    public static final int NOT_UPDATED = 5;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 3;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CShareAddressBook2ReplyMsg
 * JD-Core Version:    0.6.2
 */