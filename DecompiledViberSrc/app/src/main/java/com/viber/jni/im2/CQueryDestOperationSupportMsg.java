package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CQueryDestOperationSupportMsg
{
  public final String destPhoneNumber;
  public final Boolean hasE2ESession;
  public final long operation;
  public final int seq;

  public CQueryDestOperationSupportMsg(String paramString, int paramInt, long paramLong)
  {
    this.destPhoneNumber = Im2Utils.checkStringValue(paramString);
    this.seq = paramInt;
    this.operation = paramLong;
    this.hasE2ESession = null;
    init();
  }

  public CQueryDestOperationSupportMsg(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    this.destPhoneNumber = Im2Utils.checkStringValue(paramString);
    this.seq = paramInt;
    this.operation = paramLong;
    this.hasE2ESession = Boolean.valueOf(paramBoolean);
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EQdosOperation
  {
    public static final long QDOS_OP_INSTANT_VIDEO = 3L;
    public static final long QDOS_OP_SECRET_CHAT = 4L;
    public static final long QDOS_OP_SEND_FILE = 1L;
    public static final long QDOS_OP_UNUSED = 0L;
    public static final long QDOS_OP_WINK_MESSAGE = 2L;
  }

  public static abstract interface Sender
  {
    public abstract void handleCQueryDestOperationSupportMsg(CQueryDestOperationSupportMsg paramCQueryDestOperationSupportMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CQueryDestOperationSupportMsg
 * JD-Core Version:    0.6.2
 */