package com.viber.voip.messages.conversation.chatinfo.e;

import com.viber.jni.OnlineContactInfo;
import com.viber.jni.PeerTrustState.PeerTrustEnum;
import com.viber.voip.ui.ap;
import java.util.Map;

public class e
{
  private final ap<b> a;
  private final a b;
  private d c;

  public e(ap<b> paramap, a parama, d paramd)
  {
    this.a = paramap;
    this.b = parama;
    this.c = paramd;
  }

  public ap<b> a()
  {
    return this.a;
  }

  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    this.c = new d.a(this.c).a(paramInt1).b(paramInt2).a(paramLong).a();
  }

  public void a(Map<String, OnlineContactInfo> paramMap)
  {
    this.c = new d.a(this.c).a(paramMap).a();
  }

  public a b()
  {
    return this.b;
  }

  public void b(Map<String, PeerTrustState.PeerTrustEnum> paramMap)
  {
    this.c = new d.a(this.c).b(paramMap).a();
  }

  public d c()
  {
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.e.e
 * JD-Core Version:    0.6.2
 */