package com.viber.jni.like;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class GroupLikesListener extends ControllerListener<LikeControllerDelegate.GroupLikes>
  implements LikeControllerDelegate.GroupLikes
{
  public boolean onGroupMessageLike(final long paramLong1, long paramLong2, final long paramLong3, String paramString, final long paramLong4, int paramInt, final boolean paramBoolean)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(LikeControllerDelegate.GroupLikes paramAnonymousGroupLikes)
      {
        paramAnonymousGroupLikes.onGroupMessageLike(paramLong1, paramLong3, paramLong4, paramBoolean, this.val$timeSent, this.val$flags, this.val$action);
      }
    });
    return false;
  }

  public void onLikeGroupMessageReply(final long paramLong, int paramInt1, final int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(LikeControllerDelegate.GroupLikes paramAnonymousGroupLikes)
      {
        paramAnonymousGroupLikes.onLikeGroupMessageReply(paramLong, paramInt2, this.val$status);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.like.GroupLikesListener
 * JD-Core Version:    0.6.2
 */