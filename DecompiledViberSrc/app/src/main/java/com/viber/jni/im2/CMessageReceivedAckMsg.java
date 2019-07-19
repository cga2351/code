package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CMessageReceivedAckMsg
{
  public final Integer clientStatus;
  public final String clientStatusInfo;
  public final Short decryptionStatus;
  public final Integer flags;
  public final String messageContentDetails;
  public final long messageToken;

  public CMessageReceivedAckMsg(long paramLong)
  {
    this.messageToken = paramLong;
    this.flags = null;
    this.decryptionStatus = null;
    this.clientStatus = null;
    this.clientStatusInfo = null;
    this.messageContentDetails = null;
    init();
  }

  public CMessageReceivedAckMsg(long paramLong, int paramInt)
  {
    this.messageToken = paramLong;
    this.flags = Integer.valueOf(paramInt);
    this.decryptionStatus = null;
    this.clientStatus = null;
    this.clientStatusInfo = null;
    this.messageContentDetails = null;
    init();
  }

  public CMessageReceivedAckMsg(long paramLong, int paramInt, short paramShort)
  {
    this.messageToken = paramLong;
    this.flags = Integer.valueOf(paramInt);
    this.decryptionStatus = Short.valueOf(paramShort);
    this.clientStatus = null;
    this.clientStatusInfo = null;
    this.messageContentDetails = null;
    init();
  }

  public CMessageReceivedAckMsg(long paramLong, int paramInt1, short paramShort, int paramInt2)
  {
    this.messageToken = paramLong;
    this.flags = Integer.valueOf(paramInt1);
    this.decryptionStatus = Short.valueOf(paramShort);
    this.clientStatus = Integer.valueOf(paramInt2);
    this.clientStatusInfo = null;
    this.messageContentDetails = null;
    init();
  }

  public CMessageReceivedAckMsg(long paramLong, int paramInt1, short paramShort, int paramInt2, String paramString)
  {
    this.messageToken = paramLong;
    this.flags = Integer.valueOf(paramInt1);
    this.decryptionStatus = Short.valueOf(paramShort);
    this.clientStatus = Integer.valueOf(paramInt2);
    this.clientStatusInfo = Im2Utils.checkStringValue(paramString);
    this.messageContentDetails = null;
    init();
  }

  public CMessageReceivedAckMsg(long paramLong, int paramInt1, short paramShort, int paramInt2, String paramString1, String paramString2)
  {
    this.messageToken = paramLong;
    this.flags = Integer.valueOf(paramInt1);
    this.decryptionStatus = Short.valueOf(paramShort);
    this.clientStatus = Integer.valueOf(paramInt2);
    this.clientStatusInfo = Im2Utils.checkStringValue(paramString1);
    this.messageContentDetails = Im2Utils.checkStringValue(paramString2);
    init();
  }

  private void init()
  {
  }

  public static int translateClientStatus(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new RuntimeException("Invalid clientStatus");
    case 0:
      return 0;
    case 1:
      return 1;
    case 2:
      return 2;
    case 3:
      return 3;
    case 4:
      return 4;
    case 5:
      return 5;
    case 6:
    }
    return 6;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface AckFlags
  {
    public static final int ACK_PRE_ACK = 1;
    public static final int G2_INVITER_NOT_IN_ADDRESS_BOOK = 64;
    public static final int M2M_SENDER_NOT_IN_ADDRESS_BOOK = 32;
    public static final int MESSAGE_NOT_DISPLAYED_BY_CLIENT = 16;
    public static final int MESSAGE_NOT_SHOWN = 2;
    public static final int NO_ACK_FLAGS = 0;
    public static final int SENDER_INVALID_MEMBER_ID = 8;
    public static final int SENDER_NOT_IN_ADDRESS_BOOK = 4;
  }

  public static abstract interface Sender
  {
    public abstract void handleCMessageReceivedAckMsg(CMessageReceivedAckMsg paramCMessageReceivedAckMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CMessageReceivedAckMsg
 * JD-Core Version:    0.6.2
 */