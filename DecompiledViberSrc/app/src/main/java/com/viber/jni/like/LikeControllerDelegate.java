package com.viber.jni.like;

import com.viber.jni.publicgroup.PgAction;
import java.util.Map;

public abstract interface LikeControllerDelegate
{
  public static abstract interface GroupLikes
  {
    public abstract boolean onGroupMessageLike(long paramLong1, long paramLong2, long paramLong3, String paramString, long paramLong4, int paramInt, boolean paramBoolean);

    public abstract void onLikeGroupMessageReply(long paramLong, int paramInt1, int paramInt2);
  }

  public static abstract interface LikeDelegate extends LikeControllerDelegate.GroupLikes, LikeControllerDelegate.PublicGroupLikes
  {
  }

  public static abstract interface PublicGroupLikes
  {
    public abstract void onGetPublicGroupLikes(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong, Map<Integer, PgAction> paramMap, int paramInt3);

    public abstract void onLikePublicGroupMessage(long paramLong1, long paramLong2, int paramInt1, boolean paramBoolean, int paramInt2, long paramLong3, int paramInt3);

    public abstract boolean onSyncMessageLike(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean, long paramLong3);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.like.LikeControllerDelegate
 * JD-Core Version:    0.6.2
 */