package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CQueryDestOperationSupportReplyMsg
{
  public final int flags;
  public final int seq;
  public final int status;

  public CQueryDestOperationSupportReplyMsg(int paramInt1, int paramInt2, int paramInt3)
  {
    this.seq = paramInt1;
    this.status = paramInt2;
    this.flags = paramInt3;
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EQdosFlags
  {
    public static final int QDOS_FL_SUPPORTED = 1;
    public static final int QDOS_FL_UNSUPPORTED;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EQdosStatus
  {
    public static final int QDOS_ST_FAIL = 0;
    public static final int QDOS_ST_SUCCESS = 1;
    public static final int QDOS_ST_TIMEOUT = 2;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCQueryDestOperationSupportReplyMsg(CQueryDestOperationSupportReplyMsg paramCQueryDestOperationSupportReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CQueryDestOperationSupportReplyMsg
 * JD-Core Version:    0.6.2
 */