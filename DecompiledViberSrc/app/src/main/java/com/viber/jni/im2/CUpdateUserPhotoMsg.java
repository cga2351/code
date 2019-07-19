package com.viber.jni.im2;

public class CUpdateUserPhotoMsg
{
  public final long photoID;

  public CUpdateUserPhotoMsg(long paramLong)
  {
    this.photoID = paramLong;
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCUpdateUserPhotoMsg(CUpdateUserPhotoMsg paramCUpdateUserPhotoMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CUpdateUserPhotoMsg
 * JD-Core Version:    0.6.2
 */