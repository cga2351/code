package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

public class CCreateGroupReplyMsg
{
  public final int context;
  public final long groupID;
  public final Map<String, Integer> notFoundMembers;
  public final int status;

  public CCreateGroupReplyMsg(int paramInt1, int paramInt2, long paramLong, Map<String, Integer> paramMap)
  {
    this.status = paramInt1;
    this.context = paramInt2;
    this.groupID = paramLong;
    this.notFoundMembers = Im2Utils.checkMapValue(paramMap);
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int CREATE_GROUP_FAILED = 2;
    public static final int CREATE_GROUP_NOT_ENOUGH_VIBER_NUM = 1;
    public static final int CREATE_GROUP_OK = 0;
    public static final int CREATE_GROUP_OK_SECURE = 6;
    public static final int CREATE_GROUP_OUTDATED_DEVICE_LIST = 7;
    public static final int CREATE_GROUP_TIMEOUT = 4;
    public static final int CREATE_GROUP_TOO_MANY_MEMBERS = 3;
    public static final int CREATE_GROUP_URI_NOT_UNIQUE = 5;
    public static final int CREATE_PA_NOT_SUPPORTED = 8;
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCCreateGroupReplyMsg(CCreateGroupReplyMsg paramCCreateGroupReplyMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CCreateGroupReplyMsg
 * JD-Core Version:    0.6.2
 */