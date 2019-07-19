package com.viber.jni;

public class BlockListInfo
{
  public static final int BLOCKED_BY_USER = 0;
  public static final int BLOCKED_REPORT_SPAM = 1;
  String blockedNumber;
  int blockingFlag;

  public BlockListInfo(String paramString, int paramInt)
  {
    this.blockedNumber = paramString;
    this.blockingFlag = paramInt;
  }

  public String toString()
  {
    return "BlockListInfo: blockedMemberId=" + this.blockedNumber + ", blockingFlag=" + this.blockingFlag;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.BlockListInfo
 * JD-Core Version:    0.6.2
 */