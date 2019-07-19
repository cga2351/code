package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CBlockAppMsg
{
  public final short appId;
  public final boolean block;
  public final Integer flags;
  public final int sequence;

  public CBlockAppMsg(short paramShort, int paramInt, boolean paramBoolean)
  {
    this.appId = paramShort;
    this.sequence = paramInt;
    this.block = paramBoolean;
    this.flags = null;
    init();
  }

  public CBlockAppMsg(short paramShort, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    this.appId = paramShort;
    this.sequence = paramInt1;
    this.block = paramBoolean;
    this.flags = Integer.valueOf(paramInt2);
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EFlags
  {
    public static final int NONE = 0;
    public static final int OVERLAY_ACTION = 1;
    public static final int OVERLAY_X_BUTTON = 2;
  }

  public static abstract interface Sender
  {
    public abstract void handleCBlockAppMsg(CBlockAppMsg paramCBlockAppMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CBlockAppMsg
 * JD-Core Version:    0.6.2
 */