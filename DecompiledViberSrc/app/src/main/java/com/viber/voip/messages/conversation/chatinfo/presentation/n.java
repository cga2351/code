package com.viber.voip.messages.conversation.chatinfo.presentation;

import com.viber.jni.PeerTrustState.PeerTrustEnum;

public final class n
{
  private final boolean a;
  private final boolean b;
  private final int c;
  private final boolean d;
  private final boolean e;
  private final b f;
  private final long g;
  private final int h;

  private n(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, boolean paramBoolean3, boolean paramBoolean4, b paramb, long paramLong, int paramInt2)
  {
    this.a = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramInt1;
    this.d = paramBoolean3;
    this.e = paramBoolean4;
    this.f = paramb;
    this.g = paramLong;
    this.h = paramInt2;
  }

  public boolean a()
  {
    return this.a;
  }

  public boolean b()
  {
    return this.b;
  }

  public int c()
  {
    return this.c;
  }

  public boolean d()
  {
    return this.d;
  }

  public boolean e()
  {
    return this.e;
  }

  public long f()
  {
    return this.g;
  }

  public b g()
  {
    return this.f;
  }

  public int h()
  {
    return this.h;
  }

  public static final class a
  {
    private boolean a;
    private boolean b;
    private int c;
    private boolean d;
    private boolean e;
    private n.b f;
    private long g;
    private int h;

    public a()
    {
    }

    private a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, boolean paramBoolean3, boolean paramBoolean4, n.b paramb, long paramLong, int paramInt2)
    {
      this.a = paramBoolean1;
      this.b = paramBoolean2;
      this.c = paramInt1;
      this.d = paramBoolean3;
      this.e = paramBoolean4;
      this.f = paramb;
      this.g = paramLong;
      this.h = paramInt2;
    }

    public static a a(n paramn)
    {
      return new a(n.a(paramn), n.b(paramn), n.c(paramn), n.d(paramn), n.e(paramn), n.f(paramn), n.g(paramn), n.h(paramn));
    }

    public a a(int paramInt)
    {
      this.c = paramInt;
      return this;
    }

    public a a(long paramLong)
    {
      this.g = paramLong;
      return this;
    }

    public a a(n.b paramb)
    {
      this.f = paramb;
      return this;
    }

    public a a(boolean paramBoolean)
    {
      this.a = paramBoolean;
      return this;
    }

    public n a()
    {
      return new n(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, null);
    }

    public a b(int paramInt)
    {
      this.h = paramInt;
      return this;
    }

    public a b(boolean paramBoolean)
    {
      this.b = paramBoolean;
      return this;
    }

    public a c(boolean paramBoolean)
    {
      this.d = paramBoolean;
      return this;
    }

    public a d(boolean paramBoolean)
    {
      this.e = paramBoolean;
      return this;
    }
  }

  public static class b
  {
    private final String a;
    private final PeerTrustState.PeerTrustEnum b;

    public b(String paramString, PeerTrustState.PeerTrustEnum paramPeerTrustEnum)
    {
      this.a = paramString;
      this.b = paramPeerTrustEnum;
    }

    public String a()
    {
      return this.a;
    }

    public PeerTrustState.PeerTrustEnum b()
    {
      return this.b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.presentation.n
 * JD-Core Version:    0.6.2
 */