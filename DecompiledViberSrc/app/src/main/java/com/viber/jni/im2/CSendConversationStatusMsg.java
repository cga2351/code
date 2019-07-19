package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CSendConversationStatusMsg
{
  public final String context;
  public final int conversationStatusFlags;
  public final Long groupId;
  public final String msgInfo;
  public final String peerMID;
  public final String publicAccountId;
  public final String replyType;
  public final int seq;
  public final Byte silent;
  public final String trackingData;

  public CSendConversationStatusMsg(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    this.publicAccountId = Im2Utils.checkStringValue(paramString1);
    this.conversationStatusFlags = paramInt1;
    this.context = Im2Utils.checkStringValue(paramString2);
    this.seq = paramInt2;
    this.trackingData = null;
    this.peerMID = null;
    this.groupId = null;
    this.replyType = null;
    this.silent = null;
    this.msgInfo = null;
    init();
  }

  public CSendConversationStatusMsg(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    this.publicAccountId = Im2Utils.checkStringValue(paramString1);
    this.conversationStatusFlags = paramInt1;
    this.context = Im2Utils.checkStringValue(paramString2);
    this.seq = paramInt2;
    this.trackingData = Im2Utils.checkStringValue(paramString3);
    this.peerMID = null;
    this.groupId = null;
    this.replyType = null;
    this.silent = null;
    this.msgInfo = null;
    init();
  }

  public CSendConversationStatusMsg(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    this.publicAccountId = Im2Utils.checkStringValue(paramString1);
    this.conversationStatusFlags = paramInt1;
    this.context = Im2Utils.checkStringValue(paramString2);
    this.seq = paramInt2;
    this.trackingData = Im2Utils.checkStringValue(paramString3);
    this.peerMID = Im2Utils.checkStringValue(paramString4);
    this.groupId = null;
    this.replyType = null;
    this.silent = null;
    this.msgInfo = null;
    init();
  }

  public CSendConversationStatusMsg(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, long paramLong)
  {
    this.publicAccountId = Im2Utils.checkStringValue(paramString1);
    this.conversationStatusFlags = paramInt1;
    this.context = Im2Utils.checkStringValue(paramString2);
    this.seq = paramInt2;
    this.trackingData = Im2Utils.checkStringValue(paramString3);
    this.peerMID = Im2Utils.checkStringValue(paramString4);
    this.groupId = Long.valueOf(paramLong);
    this.replyType = null;
    this.silent = null;
    this.msgInfo = null;
    init();
  }

  public CSendConversationStatusMsg(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, long paramLong, String paramString5)
  {
    this.publicAccountId = Im2Utils.checkStringValue(paramString1);
    this.conversationStatusFlags = paramInt1;
    this.context = Im2Utils.checkStringValue(paramString2);
    this.seq = paramInt2;
    this.trackingData = Im2Utils.checkStringValue(paramString3);
    this.peerMID = Im2Utils.checkStringValue(paramString4);
    this.groupId = Long.valueOf(paramLong);
    this.replyType = Im2Utils.checkStringValue(paramString5);
    this.silent = null;
    this.msgInfo = null;
    init();
  }

  public CSendConversationStatusMsg(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, long paramLong, String paramString5, byte paramByte)
  {
    this.publicAccountId = Im2Utils.checkStringValue(paramString1);
    this.conversationStatusFlags = paramInt1;
    this.context = Im2Utils.checkStringValue(paramString2);
    this.seq = paramInt2;
    this.trackingData = Im2Utils.checkStringValue(paramString3);
    this.peerMID = Im2Utils.checkStringValue(paramString4);
    this.groupId = Long.valueOf(paramLong);
    this.replyType = Im2Utils.checkStringValue(paramString5);
    this.silent = Byte.valueOf(paramByte);
    this.msgInfo = null;
    init();
  }

  public CSendConversationStatusMsg(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, long paramLong, String paramString5, byte paramByte, String paramString6)
  {
    this.publicAccountId = Im2Utils.checkStringValue(paramString1);
    this.conversationStatusFlags = paramInt1;
    this.context = Im2Utils.checkStringValue(paramString2);
    this.seq = paramInt2;
    this.trackingData = Im2Utils.checkStringValue(paramString3);
    this.peerMID = Im2Utils.checkStringValue(paramString4);
    this.groupId = Long.valueOf(paramLong);
    this.replyType = Im2Utils.checkStringValue(paramString5);
    this.silent = Byte.valueOf(paramByte);
    this.msgInfo = Im2Utils.checkStringValue(paramString6);
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EConversationStatusFlags
  {
    public static final int ENTER = 8;
    public static final int INLINE = 4;
    public static final int OPEN = 1;
    public static final int RESTART = 2;
  }

  public static abstract interface Sender
  {
    public abstract void handleCSendConversationStatusMsg(CSendConversationStatusMsg paramCSendConversationStatusMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSendConversationStatusMsg
 * JD-Core Version:    0.6.2
 */