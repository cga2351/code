package com.viber.jni.like;

import com.viber.jni.controller.ControllerListener.ControllerListenerAction;
import com.viber.jni.controller.PausedControllerListener;
import com.viber.jni.publicgroup.PgAction;
import java.util.Map;

public class PublicGroupLikesListener extends PausedControllerListener<LikeControllerDelegate.PublicGroupLikes>
  implements LikeControllerDelegate.PublicGroupLikes
{
  public PublicGroupLikesListener()
  {
    super(new LikeControllerDelegate.PublicGroupLikes[0]);
  }

  public void onGetPublicGroupLikes(final int paramInt1, final int paramInt2, final boolean paramBoolean, final long paramLong, Map<Integer, PgAction> paramMap, final int paramInt3)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(LikeControllerDelegate.PublicGroupLikes paramAnonymousPublicGroupLikes)
      {
        paramAnonymousPublicGroupLikes.onGetPublicGroupLikes(paramInt1, paramInt2, paramBoolean, paramLong, paramInt3, this.val$status);
      }
    });
  }

  public void onLikePublicGroupMessage(final long paramLong1, long paramLong2, final int paramInt1, boolean paramBoolean, final int paramInt2, final long paramLong3, final int paramInt3)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(LikeControllerDelegate.PublicGroupLikes paramAnonymousPublicGroupLikes)
      {
        paramAnonymousPublicGroupLikes.onLikePublicGroupMessage(paramLong1, paramInt1, paramInt2, paramLong3, paramInt3, this.val$actionToken, this.val$status);
      }
    });
  }

  public boolean onSyncMessageLike(final long paramLong1, long paramLong2, final int paramInt, boolean paramBoolean, final long paramLong3)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(LikeControllerDelegate.PublicGroupLikes paramAnonymousPublicGroupLikes)
      {
        paramAnonymousPublicGroupLikes.onSyncMessageLike(paramLong1, paramInt, paramLong3, this.val$like, this.val$actionToken);
      }
    });
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.like.PublicGroupLikesListener
 * JD-Core Version:    0.6.2
 */