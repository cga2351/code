package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CGroupChangedAckMsg
{
  public final Integer flags;
  public final long messageToken;

  public CGroupChangedAckMsg(long paramLong)
  {
    this.messageToken = paramLong;
    this.flags = null;
    init();
  }

  public CGroupChangedAckMsg(long paramLong, int paramInt)
  {
    this.messageToken = paramLong;
    this.flags = Integer.valueOf(paramInt);
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EAckFlags
  {
    public static final int ACK_PRE_ACK = 1;
    public static final int SENDER_INVALID_MEMBER_ID = 4;
    public static final int SENDER_NOT_IN_ADDRESS_BOOK = 2;
  }

  public static abstract interface Sender
  {
    public abstract void handleCGroupChangedAckMsg(CGroupChangedAckMsg paramCGroupChangedAckMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGroupChangedAckMsg
 * JD-Core Version:    0.6.2
 */