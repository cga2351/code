package com.viber.jni.im2;

import java.util.Arrays;

public class RecoveredPublicAccountDeleteAllUsersMessages
{
  public final DeleteAllUserMessagesInfo[] deleteAllUsersMessagesInfo;
  public final long publicChatId;

  public RecoveredPublicAccountDeleteAllUsersMessages(long paramLong, DeleteAllUserMessagesInfo[] paramArrayOfDeleteAllUserMessagesInfo)
  {
    this.publicChatId = paramLong;
    this.deleteAllUsersMessagesInfo = ((DeleteAllUserMessagesInfo[])Im2Utils.checkArrayValue(paramArrayOfDeleteAllUserMessagesInfo, [Lcom.viber.jni.im2.DeleteAllUserMessagesInfo.class));
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "RecoveredPublicAccountDeleteAllUsersMessages{publicChatId=" + this.publicChatId + ", deleteAllUsersMessagesInfo=" + Arrays.toString(this.deleteAllUsersMessagesInfo) + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.RecoveredPublicAccountDeleteAllUsersMessages
 * JD-Core Version:    0.6.2
 */