package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CConfCallNotificationMsg
{
  public final String attachment;
  public final long callToken;
  public final String confID;
  public final int eventType;
  public final byte[] sdpOffer;

  public CConfCallNotificationMsg(long paramLong, String paramString1, int paramInt, byte[] paramArrayOfByte, String paramString2)
  {
    this.callToken = paramLong;
    this.confID = paramString1;
    this.eventType = paramInt;
    this.sdpOffer = paramArrayOfByte;
    this.attachment = paramString2;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface NotifyEventType
  {
    public static final int CBN_INVALID = 0;
    public static final int CBN_JOIN = 1;
    public static final int CBN_KICK = 3;
    public static final int CBN_LEFT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCConfCallNotificationMsg(CConfCallNotificationMsg paramCConfCallNotificationMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CConfCallNotificationMsg
 * JD-Core Version:    0.6.2
 */