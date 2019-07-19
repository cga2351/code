package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CGdprCommandReplyMsg
{
  public final int commandType;
  public final String jobId;
  public final int limitDays;
  public final int processDays;
  public final String requestDate;
  public final int seq;
  public final int status;

  public CGdprCommandReplyMsg(int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.seq = paramInt1;
    this.jobId = Im2Utils.checkStringValue(paramString1);
    this.processDays = paramInt2;
    this.requestDate = Im2Utils.checkStringValue(paramString2);
    this.status = paramInt3;
    this.commandType = paramInt4;
    this.limitDays = paramInt5;
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CGdprCommandReplyMsg{seq=" + this.seq + ", jobId='" + this.jobId + '\'' + ", processDays=" + this.processDays + ", requestDate='" + this.requestDate + '\'' + ", status=" + this.status + ", commandType=" + this.commandType + ", limitDays=" + this.limitDays + '}';
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int ALREADY_IN_PROCESS = 4;
    public static final int FAILED = 1;
    public static final int LIMIT_EXCEEDED = 5;
    public static final int NOT_REG = 3;
    public static final int OK = 0;
    public static final int TIMEOUT = 2;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCGdprCommandReplyMsg(CGdprCommandReplyMsg paramCGdprCommandReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGdprCommandReplyMsg
 * JD-Core Version:    0.6.2
 */