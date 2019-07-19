package com.viber.jni.im2;

public class MediaObjectDetails
{
  public final int groupType;
  public final int mediaType;
  public final long objectID;

  public MediaObjectDetails(long paramLong, int paramInt1, int paramInt2)
  {
    this.objectID = paramLong;
    this.mediaType = paramInt1;
    this.groupType = paramInt2;
    init();
  }

  private void init()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.MediaObjectDetails
 * JD-Core Version:    0.6.2
 */