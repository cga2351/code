package com.viber.voip.messages.conversation.chatinfo.presentation;

import com.viber.jni.OnlineContactInfo;
import com.viber.jni.PeerTrustState.PeerTrustEnum;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.chatinfo.c.a;
import com.viber.voip.messages.conversation.chatinfo.d.d;
import java.util.Map;

public abstract interface ae
{
  public abstract void B();

  public abstract void C();

  public abstract void D();

  public abstract void E();

  public abstract void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, int paramInt);

  public abstract void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, int paramInt1, int paramInt2);

  public abstract void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, int paramInt1, int paramInt2, String paramString);

  public abstract void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, int paramInt, String paramString);

  public abstract void a(a<d> parama);

  public abstract void a(Map<String, OnlineContactInfo> paramMap);

  public abstract void b(Map<String, PeerTrustState.PeerTrustEnum> paramMap);

  public abstract void d(boolean paramBoolean);

  public abstract void e(ConversationItemLoaderEntity paramConversationItemLoaderEntity);

  public abstract void y();

  public abstract void z();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.presentation.ae
 * JD-Core Version:    0.6.2
 */