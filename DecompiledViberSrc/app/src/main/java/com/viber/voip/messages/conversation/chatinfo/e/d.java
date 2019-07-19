package com.viber.voip.messages.conversation.chatinfo.e;

import com.viber.jni.OnlineContactInfo;
import com.viber.jni.PeerTrustState.PeerTrustEnum;
import java.util.Map;

public final class d
{
  private final int a;
  private final int b;
  private final long c;
  private final String d;
  private final String e;
  private final Map<String, OnlineContactInfo> f;
  private final Map<String, PeerTrustState.PeerTrustEnum> g;

  private d(int paramInt1, int paramInt2, long paramLong, String paramString1, String paramString2, Map<String, OnlineContactInfo> paramMap, Map<String, PeerTrustState.PeerTrustEnum> paramMap1)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramLong;
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramMap;
    this.g = paramMap1;
  }

  public int a()
  {
    return this.a;
  }

  public int b()
  {
    return this.b;
  }

  public long c()
  {
    return this.c;
  }

  public String d()
  {
    return this.d;
  }

  public String e()
  {
    return this.e;
  }

  public Map<String, OnlineContactInfo> f()
  {
    return this.f;
  }

  public Map<String, PeerTrustState.PeerTrustEnum> g()
  {
    return this.g;
  }

  public static final class a
  {
    private int a;
    private int b;
    private long c;
    private String d;
    private String e;
    private Map<String, OnlineContactInfo> f;
    private Map<String, PeerTrustState.PeerTrustEnum> g;

    public a()
    {
    }

    public a(d paramd)
    {
      this.a = paramd.a();
      this.b = paramd.b();
      this.c = paramd.c();
      this.d = paramd.d();
      this.e = paramd.e();
      a(paramd.f());
      b(paramd.g());
    }

    public a a(int paramInt)
    {
      this.a = paramInt;
      return this;
    }

    public a a(long paramLong)
    {
      this.c = paramLong;
      return this;
    }

    public a a(String paramString)
    {
      this.d = paramString;
      return this;
    }

    final a a(Map<String, OnlineContactInfo> paramMap)
    {
      if ((this.f != null) && (paramMap != null))
      {
        this.f.putAll(paramMap);
        return this;
      }
      this.f = paramMap;
      return this;
    }

    public d a()
    {
      return new d(this.a, this.b, this.c, this.d, this.e, this.f, this.g, null);
    }

    public a b(int paramInt)
    {
      this.b = paramInt;
      return this;
    }

    public a b(String paramString)
    {
      this.e = paramString;
      return this;
    }

    final a b(Map<String, PeerTrustState.PeerTrustEnum> paramMap)
    {
      if ((this.g != null) && (paramMap != null))
      {
        this.g.putAll(paramMap);
        return this;
      }
      this.g = paramMap;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.e.d
 * JD-Core Version:    0.6.2
 */