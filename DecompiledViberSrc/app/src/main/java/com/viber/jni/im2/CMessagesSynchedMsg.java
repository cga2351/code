package com.viber.jni.im2;

public class CMessagesSynchedMsg
{
  public final ConversationToken[] deletedConversationTokens;
  public final GroupToken[] deletedGroupTokens;
  public final ConversationToken[] readConversationTokens;
  public final GroupToken[] readGroupTokens;

  public CMessagesSynchedMsg(ConversationToken[] paramArrayOfConversationToken1, ConversationToken[] paramArrayOfConversationToken2, GroupToken[] paramArrayOfGroupToken1, GroupToken[] paramArrayOfGroupToken2)
  {
    this.readConversationTokens = ((ConversationToken[])Im2Utils.checkArrayValue(paramArrayOfConversationToken1, [Lcom.viber.jni.im2.ConversationToken.class));
    this.deletedConversationTokens = ((ConversationToken[])Im2Utils.checkArrayValue(paramArrayOfConversationToken2, [Lcom.viber.jni.im2.ConversationToken.class));
    this.readGroupTokens = ((GroupToken[])Im2Utils.checkArrayValue(paramArrayOfGroupToken1, [Lcom.viber.jni.im2.GroupToken.class));
    this.deletedGroupTokens = ((GroupToken[])Im2Utils.checkArrayValue(paramArrayOfGroupToken2, [Lcom.viber.jni.im2.GroupToken.class));
    init();
  }

  private void init()
  {
  }

  public static abstract interface Receiver extends Im2ReceiverBase
  {
    public abstract void onCMessagesSynchedMsg(CMessagesSynchedMsg paramCMessagesSynchedMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CMessagesSynchedMsg
 * JD-Core Version:    0.6.2
 */