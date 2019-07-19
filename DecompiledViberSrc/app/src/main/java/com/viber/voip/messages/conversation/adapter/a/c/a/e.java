package com.viber.voip.messages.conversation.adapter.a.c.a;

import android.content.Context;
import com.viber.jni.OnlineContactInfo;
import com.viber.jni.PeerTrustState.PeerTrustEnum;
import com.viber.voip.R.string;
import com.viber.voip.ui.g.a.a;
import java.util.Map;

public class e extends a
{
  private final String a;
  private final String b;
  private Map<String, OnlineContactInfo> c;
  private Map<String, PeerTrustState.PeerTrustEnum> d;
  private long e;
  private int f;
  private int g;
  private boolean h;

  public e(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    this.a = paramContext.getString(R.string.conversation_you);
    this.b = paramContext.getString(R.string.conversation_info_your_list_item);
    this.f = paramInt1;
    this.g = paramInt2;
  }

  public void a(int paramInt)
  {
    this.f = paramInt;
  }

  public void a(long paramLong)
  {
    this.e = paramLong;
  }

  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }

  public String b()
  {
    return this.a;
  }

  public void b(int paramInt)
  {
    this.g = paramInt;
  }

  public void b(Map<String, OnlineContactInfo> paramMap)
  {
    if ((this.c != null) && (paramMap != null))
    {
      this.c.putAll(paramMap);
      return;
    }
    this.c = paramMap;
  }

  public int c()
  {
    return this.f;
  }

  public void c(Map<String, PeerTrustState.PeerTrustEnum> paramMap)
  {
    if ((this.d != null) && (paramMap != null))
    {
      this.d.putAll(paramMap);
      return;
    }
    this.d = paramMap;
  }

  public long d()
  {
    return this.e;
  }

  public int e()
  {
    return this.g;
  }

  public String f()
  {
    return this.b;
  }

  public Map<String, OnlineContactInfo> g()
  {
    return this.c;
  }

  public Map<String, PeerTrustState.PeerTrustEnum> h()
  {
    return this.d;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.a.c.a.e
 * JD-Core Version:    0.6.2
 */