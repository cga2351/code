package com.viber.jni.like;

public class LikeControllerWrapper
  implements LikeController
{
  private final LikeController mLikeController;

  public LikeControllerWrapper(LikeController paramLikeController)
  {
    this.mLikeController = paramLikeController;
  }

  public boolean handleGetPublicGroupLikes(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    return this.mLikeController.handleGetPublicGroupLikes(paramInt1, paramLong, paramInt2, paramInt3);
  }

  public boolean handleGroupMessageLikeAck(long paramLong)
  {
    return this.mLikeController.handleGroupMessageLikeAck(paramLong);
  }

  public void handleSendSyncMessageLikeAck(long paramLong)
  {
    this.mLikeController.handleSendSyncMessageLikeAck(paramLong);
  }

  public boolean handleSyncMessageLikeAck(long paramLong)
  {
    return this.mLikeController.handleSyncMessageLikeAck(paramLong);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.like.LikeControllerWrapper
 * JD-Core Version:    0.6.2
 */