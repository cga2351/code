package com.viber.jni.im2;

public class DeleteAllUserMessagesInfo
{
  public final CMoreUserInfo moreInfo;
  public final int seqInPG;
  public final long token;
  public final String user;

  public DeleteAllUserMessagesInfo(long paramLong, int paramInt, String paramString, CMoreUserInfo paramCMoreUserInfo)
  {
    this.token = paramLong;
    this.seqInPG = paramInt;
    this.user = Im2Utils.checkStringValue(paramString);
    this.moreInfo = ((CMoreUserInfo)Im2Utils.checkStructValue(paramCMoreUserInfo));
    init();
  }

  private void init()
  {
  }

  public com.viber.jni.DeleteAllUserMessagesInfo toLegacyDeleteAllUserMessagesInfo()
  {
    return new com.viber.jni.DeleteAllUserMessagesInfo(this.token, this.seqInPG, this.user);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.DeleteAllUserMessagesInfo
 * JD-Core Version:    0.6.2
 */