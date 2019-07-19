package com.viber.voip.messages.conversation.chatinfo.presentation.a;

import com.viber.jni.OnlineContactInfo;
import com.viber.jni.PeerTrustState.PeerTrustEnum;
import java.util.Map;

public abstract interface b
{
  public abstract void a(Map<String, OnlineContactInfo> paramMap);

  public abstract void b(Map<String, PeerTrustState.PeerTrustEnum> paramMap);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.presentation.a.b
 * JD-Core Version:    0.6.2
 */