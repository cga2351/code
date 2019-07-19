package com.viber.jni.im2;

public class OnlineData
{
  public final boolean isOnline;
  public final long lastOnlineTime;

  public OnlineData(boolean paramBoolean, long paramLong)
  {
    this.isOnline = paramBoolean;
    this.lastOnlineTime = paramLong;
    init();
  }

  private void init()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.OnlineData
 * JD-Core Version:    0.6.2
 */