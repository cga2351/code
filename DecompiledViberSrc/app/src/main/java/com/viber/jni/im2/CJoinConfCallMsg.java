package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CJoinConfCallMsg
{
  public final String attachment;
  public final long callToken;
  public final byte[] sdpOffer;
  public final int sdpPlan;
  public final int seq;

  public CJoinConfCallMsg(long paramLong, byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2)
  {
    this.callToken = paramLong;
    this.sdpOffer = ((byte[])Im2Utils.checkArrayValue(paramArrayOfByte, [B.class));
    this.attachment = Im2Utils.checkStringValue(paramString);
    this.sdpPlan = paramInt1;
    this.seq = paramInt2;
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface ESdpPlan
  {
    public static final int PLAN_B = 0;
    public static final int UNIFIED_PLAN = 1;
  }

  public static abstract interface Sender
  {
    public abstract void handleCJoinConfCallMsg(CJoinConfCallMsg paramCJoinConfCallMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CJoinConfCallMsg
 * JD-Core Version:    0.6.2
 */