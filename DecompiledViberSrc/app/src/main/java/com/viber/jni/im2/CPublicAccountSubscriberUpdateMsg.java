package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CPublicAccountSubscriberUpdateMsg
{
  public final String publicAccountID;
  public final int seq;
  public final int subscriberOperation;

  public CPublicAccountSubscriberUpdateMsg(String paramString, int paramInt1, int paramInt2)
  {
    this.publicAccountID = Im2Utils.checkStringValue(paramString);
    this.seq = paramInt1;
    this.subscriberOperation = paramInt2;
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface ESubscriberOperation
  {
    public static final int SUBSCRIBE_TO_PUBLIC_ACCOUNT = 0;
    public static final int UNSUBSCRIBE_FROM_PUBLIC_ACCOUNT = 1;
  }

  public static abstract interface Sender
  {
    public abstract void handleCPublicAccountSubscriberUpdateMsg(CPublicAccountSubscriberUpdateMsg paramCPublicAccountSubscriberUpdateMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CPublicAccountSubscriberUpdateMsg
 * JD-Core Version:    0.6.2
 */