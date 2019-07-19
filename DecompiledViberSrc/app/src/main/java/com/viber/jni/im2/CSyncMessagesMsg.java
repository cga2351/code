package com.viber.jni.im2;

public class CSyncMessagesMsg
{
  public final ConversationToken[] deletedConversationTokens;
  public final GroupToken[] deletedGroupTokens;
  public final ConversationToken[] readConversationTokens;
  public final GroupToken[] readGroupTokens;
  public final int sequence;

  public CSyncMessagesMsg(int paramInt, ConversationToken[] paramArrayOfConversationToken1, ConversationToken[] paramArrayOfConversationToken2, GroupToken[] paramArrayOfGroupToken1, GroupToken[] paramArrayOfGroupToken2)
  {
    this.sequence = paramInt;
    this.readConversationTokens = ((ConversationToken[])Im2Utils.checkArrayValue(paramArrayOfConversationToken1, [Lcom.viber.jni.im2.ConversationToken.class));
    this.deletedConversationTokens = ((ConversationToken[])Im2Utils.checkArrayValue(paramArrayOfConversationToken2, [Lcom.viber.jni.im2.ConversationToken.class));
    this.readGroupTokens = ((GroupToken[])Im2Utils.checkArrayValue(paramArrayOfGroupToken1, [Lcom.viber.jni.im2.GroupToken.class));
    this.deletedGroupTokens = ((GroupToken[])Im2Utils.checkArrayValue(paramArrayOfGroupToken2, [Lcom.viber.jni.im2.GroupToken.class));
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCSyncMessagesMsg(CSyncMessagesMsg paramCSyncMessagesMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CSyncMessagesMsg
 * JD-Core Version:    0.6.2
 */