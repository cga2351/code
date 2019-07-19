package com.viber.jni.publicaccount;

public class PublicAccountConversationStatusWrapper
  implements PublicAccountConversationStatusController
{
  private final PublicAccountConversationStatusController mController;

  public PublicAccountConversationStatusWrapper(PublicAccountConversationStatusController paramPublicAccountConversationStatusController)
  {
    this.mController = paramPublicAccountConversationStatusController;
  }

  public boolean handleSendConversationStatus(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, long paramLong, String paramString5, boolean paramBoolean, String paramString6)
  {
    return this.mController.handleSendConversationStatus(paramString1, paramInt1, paramString2, paramInt2, paramString3, paramString4, paramLong, paramString5, paramBoolean, paramString6);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.publicaccount.PublicAccountConversationStatusWrapper
 * JD-Core Version:    0.6.2
 */