package com.viber.jni.publicgroup;

import com.viber.jni.PublicGroupChangeEvent;
import com.viber.jni.PublicGroupMessage;

public class PublicGroupGetMessagesRetryListener extends PublicGroupGetMessagesListener
{
  private PublicGroupControllerRetry mPublicGroupController;

  public PublicGroupGetMessagesRetryListener(PublicGroupControllerRetry paramPublicGroupControllerRetry)
  {
    this.mPublicGroupController = paramPublicGroupControllerRetry;
  }

  public void onGetPublicGroupMessages(int paramInt1, long paramLong, PublicGroupMessage[] paramArrayOfPublicGroupMessage, PublicGroupChangeEvent[] paramArrayOfPublicGroupChangeEvent, int paramInt2)
  {
    if ((paramInt2 != 3) || (!this.mPublicGroupController.retryTask(paramInt1)))
    {
      this.mPublicGroupController.removeTask(paramInt1);
      super.onGetPublicGroupMessages(paramInt1, paramLong, paramArrayOfPublicGroupMessage, paramArrayOfPublicGroupChangeEvent, paramInt2);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.publicgroup.PublicGroupGetMessagesRetryListener
 * JD-Core Version:    0.6.2
 */