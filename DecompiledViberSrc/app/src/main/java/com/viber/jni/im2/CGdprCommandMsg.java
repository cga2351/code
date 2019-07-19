package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CGdprCommandMsg
{
  public final int commandType;
  public final int seq;

  public CGdprCommandMsg(int paramInt1, int paramInt2)
  {
    this.seq = paramInt1;
    this.commandType = paramInt2;
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CGdprCommandMsg{seq=" + this.seq + ", commandType=" + this.commandType + '}';
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface ECommandType
  {
    public static final int ERASE_GDPR_INFO = 1;
    public static final int GET_GDPR_INFO;
  }

  public static abstract interface Sender
  {
    public abstract void handleCGdprCommandMsg(CGdprCommandMsg paramCGdprCommandMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGdprCommandMsg
 * JD-Core Version:    0.6.2
 */