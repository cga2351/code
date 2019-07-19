package com.viber.voip.messages.conversation.chatinfo.d;

import com.viber.jni.PeerTrustState.PeerTrustEnum;

public class o
  implements d
{
  private final boolean a;
  private final String b;
  private final String c;
  private final int d;
  private final PeerTrustState.PeerTrustEnum e;

  public o(boolean paramBoolean, String paramString1, String paramString2, int paramInt, PeerTrustState.PeerTrustEnum paramPeerTrustEnum)
  {
    this.a = paramBoolean;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramInt;
    this.e = paramPeerTrustEnum;
  }

  public boolean a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public com.viber.voip.messages.conversation.chatinfo.presentation.a.d d()
  {
    return com.viber.voip.messages.conversation.chatinfo.presentation.a.d.o;
  }

  public int e()
  {
    return e.a(this);
  }

  public int f()
  {
    return this.d;
  }

  public PeerTrustState.PeerTrustEnum g()
  {
    return this.e;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.d.o
 * JD-Core Version:    0.6.2
 */