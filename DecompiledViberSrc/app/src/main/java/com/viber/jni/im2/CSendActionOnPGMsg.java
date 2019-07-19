package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CSendActionOnPGMsg
{
  public final int clientAction;
  public final int context;
  public final long groupID;
  public final String messageSenderMID;
  public final long messageTime;
  public final long messageToken;
  public final int seqInPG;

  public CSendActionOnPGMsg(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, long paramLong3)
  {
    this.groupID = paramLong1;
    this.messageToken = paramLong2;
    this.seqInPG = paramInt1;
    this.clientAction = paramInt2;
    this.context = paramInt3;
    this.messageTime = paramLong3;
    this.messageSenderMID = null;
    init();
  }

  public CSendActionOnPGMsg(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, long paramLong3, String paramString)
  {
    this.groupID = paramLong1;
    this.messageToken = paramLong2;
    this.seqInPG = paramInt1;
    this.clientAction = paramInt2;
    this.context = paramInt3;
    this.messageTime = paramLong3;
    this.messageSenderMID = Im2Utils.checkStringValue(paramString);
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface PGClientAction
  {
    public static final int Like = 1;
    public static final int Unlike = 2;
  }

  public static abstract interface Sender
  {
    public abstract void handleCSendActionOnPGMsg(CSendActionOnPGMsg paramCSendActionOnPGMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSendActionOnPGMsg
 * JD-Core Version:    0.6.2
 */