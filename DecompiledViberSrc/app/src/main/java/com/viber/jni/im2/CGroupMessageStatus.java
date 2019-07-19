package com.viber.jni.im2;

public class CGroupMessageStatus
{
  public final int status;
  public final long token;
  public final CReadData[] users;

  public CGroupMessageStatus(long paramLong, int paramInt, CReadData[] paramArrayOfCReadData)
  {
    this.token = paramLong;
    this.status = paramInt;
    this.users = ((CReadData[])Im2Utils.checkArrayValue(paramArrayOfCReadData, [Lcom.viber.jni.im2.CReadData.class));
    init();
  }

  private void init()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGroupMessageStatus
 * JD-Core Version:    0.6.2
 */