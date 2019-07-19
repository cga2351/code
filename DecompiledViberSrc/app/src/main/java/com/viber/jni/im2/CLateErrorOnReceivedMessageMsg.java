package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CLateErrorOnReceivedMessageMsg
{
  public final int clientStatus;
  public final String clientStatusInfo;
  public final long messageToken;
  public final String publicAccountID;
  public final int sequence;

  public CLateErrorOnReceivedMessageMsg(int paramInt1, long paramLong, String paramString1, int paramInt2, String paramString2)
  {
    this.sequence = paramInt1;
    this.messageToken = paramLong;
    this.publicAccountID = Im2Utils.checkStringValue(paramString1);
    this.clientStatus = paramInt2;
    this.clientStatusInfo = Im2Utils.checkStringValue(paramString2);
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CLateErrorOnReceivedMessageMsg{sequence=" + this.sequence + ", messageToken=" + this.messageToken + ", publicAccountID='" + this.publicAccountID + '\'' + ", clientStatus=" + this.clientStatus + ", clientStatusInfo='" + this.clientStatusInfo + '\'' + '}';
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EClientStatus
  {
    public static final int CS_GENERAL_FAILURE = 4;
    public static final int CS_KEYBOARD_CORRUPTED = 1;
    public static final int CS_KEYBOARD_UNSUPPORTED_VERSION = 2;
    public static final int CS_MESSAGE_CONTENT_FAILURE = 3;
    public static final int CS_SERVICE_MESSAGE_BUSINESS_INBOX = 6;
    public static final int CS_SERVICE_MESSAGE_CAPPED = 5;
    public static final int CS_SUCCESS;
  }

  public static abstract interface Sender
  {
    public abstract void handleCLateErrorOnReceivedMessageMsg(CLateErrorOnReceivedMessageMsg paramCLateErrorOnReceivedMessageMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CLateErrorOnReceivedMessageMsg
 * JD-Core Version:    0.6.2
 */