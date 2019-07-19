package com.viber.jni.publicaccount;

public class PublicAccountSubscriptionWrapper
  implements PublicAccountSubscriptionController
{
  private final PublicAccountSubscriptionController mController;

  public PublicAccountSubscriptionWrapper(PublicAccountSubscriptionController paramPublicAccountSubscriptionController)
  {
    this.mController = paramPublicAccountSubscriptionController;
  }

  public boolean handleSubscribeToPublicAccount(int paramInt, String paramString)
  {
    return this.mController.handleSubscribeToPublicAccount(paramInt, paramString);
  }

  public boolean handleUnSubscribeFromPublicAccount(int paramInt, String paramString)
  {
    return this.mController.handleUnSubscribeFromPublicAccount(paramInt, paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.publicaccount.PublicAccountSubscriptionWrapper
 * JD-Core Version:    0.6.2
 */