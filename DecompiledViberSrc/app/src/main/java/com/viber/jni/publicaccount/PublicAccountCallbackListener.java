package com.viber.jni.publicaccount;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;
import java.util.Map;

public class PublicAccountCallbackListener extends ControllerListener<PublicAccountControllerDelegate.PublicAccountDelegate>
  implements PublicAccountControllerDelegate.PublicAccountDelegate
{
  public void onChangePublicAccountReply(final long paramLong1, long paramLong2, final int paramInt1, int paramInt2, final int paramInt3, final int paramInt4)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PublicAccountControllerDelegate.PublicAccountDelegate paramAnonymousPublicAccountDelegate)
      {
        paramAnonymousPublicAccountDelegate.onChangePublicAccountReply(paramLong1, paramInt1, paramInt3, paramInt4, this.val$revision, this.val$status);
      }
    });
  }

  public void onCreatePublicAccountReply(final int paramInt1, final int paramInt2, final long paramLong, String paramString1, final Map<String, Integer> paramMap, final String paramString2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PublicAccountControllerDelegate.PublicAccountDelegate paramAnonymousPublicAccountDelegate)
      {
        paramAnonymousPublicAccountDelegate.onCreatePublicAccountReply(paramInt1, paramInt2, paramLong, paramMap, paramString2, this.val$authToken);
      }
    });
  }

  public void onJoinPublicGroup(final long paramLong, int paramInt1, final int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PublicAccountControllerDelegate.PublicAccountDelegate paramAnonymousPublicAccountDelegate)
      {
        paramAnonymousPublicAccountDelegate.onJoinPublicGroup(paramLong, paramInt2, this.val$status);
      }
    });
  }

  public void onPublicAccountRefreshToken(final int paramInt1, final int paramInt2, final String paramString1, final String paramString2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PublicAccountControllerDelegate.PublicAccountDelegate paramAnonymousPublicAccountDelegate)
      {
        paramAnonymousPublicAccountDelegate.onPublicAccountRefreshToken(paramInt1, paramInt2, paramString1, paramString2);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.publicaccount.PublicAccountCallbackListener
 * JD-Core Version:    0.6.2
 */