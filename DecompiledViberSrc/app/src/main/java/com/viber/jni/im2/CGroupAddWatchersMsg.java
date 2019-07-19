package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CGroupAddWatchersMsg
{
  public final long groupID;
  public final long invitationToken;
  public final String inviterPhonerNumber;
  public final boolean isJoin;
  public final int seq;
  public final Integer source;
  public final String[] watchers;

  public CGroupAddWatchersMsg(long paramLong1, int paramInt, boolean paramBoolean, String[] paramArrayOfString, String paramString, long paramLong2)
  {
    this.groupID = paramLong1;
    this.seq = paramInt;
    this.isJoin = paramBoolean;
    this.watchers = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.inviterPhonerNumber = Im2Utils.checkStringValue(paramString);
    this.invitationToken = paramLong2;
    this.source = null;
    init();
  }

  public CGroupAddWatchersMsg(long paramLong1, int paramInt1, boolean paramBoolean, String[] paramArrayOfString, String paramString, long paramLong2, int paramInt2)
  {
    this.groupID = paramLong1;
    this.seq = paramInt1;
    this.isJoin = paramBoolean;
    this.watchers = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.inviterPhonerNumber = Im2Utils.checkStringValue(paramString);
    this.invitationToken = paramLong2;
    this.source = Integer.valueOf(paramInt2);
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EGroupAddWatcherSource
  {
    public static final int ADDED_BY_USER = 3;
    public static final int INVITE_LINK = 1;
    public static final int SEARCH = 2;
    public static final int STICKERS = 4;
    public static final int UNKNOWN;
  }

  public static abstract interface Sender
  {
    public abstract void handleCGroupAddWatchersMsg(CGroupAddWatchersMsg paramCGroupAddWatchersMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGroupAddWatchersMsg
 * JD-Core Version:    0.6.2
 */