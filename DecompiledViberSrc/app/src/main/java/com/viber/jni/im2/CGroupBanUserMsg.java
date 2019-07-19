package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CGroupBanUserMsg
{
  public final String emid;
  public final long groupID;
  public final int seq;
  public final int type;

  public CGroupBanUserMsg(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    this.seq = paramInt1;
    this.emid = Im2Utils.checkStringValue(paramString);
    this.groupID = paramLong;
    this.type = paramInt2;
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CGroupBanUserMsg{seq=" + this.seq + ", emid='" + this.emid + '\'' + ", groupID=" + this.groupID + ", type=" + this.type + '}';
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface BanType
  {
    public static final int Ban = 0;
    public static final int Unban = 1;
  }

  public static abstract interface Sender
  {
    public abstract void handleCGroupBanUserMsg(CGroupBanUserMsg paramCGroupBanUserMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGroupBanUserMsg
 * JD-Core Version:    0.6.2
 */