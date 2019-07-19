package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CBlockedUserInfo
{
  public final String blockedNumber;
  public final int blockingFlag;

  public CBlockedUserInfo(String paramString, int paramInt)
  {
    this.blockedNumber = Im2Utils.checkStringValue(paramString);
    this.blockingFlag = paramInt;
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EBlockingFlags
  {
    public static final int BLOCKED_BY_USER = 0;
    public static final int BLOCKED_REPORT_SPAM = 1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CBlockedUserInfo
 * JD-Core Version:    0.6.2
 */