package com.viber.voip.messages.conversation.chatinfo.d;

public final class m
  implements d
{
  private final com.viber.voip.messages.conversation.chatinfo.presentation.a.d a;
  private final int b;
  private final boolean c;
  private final boolean d;
  private final String e;
  private final String f;
  private final String g;
  private final boolean h;

  private m(com.viber.voip.messages.conversation.chatinfo.presentation.a.d paramd, int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, boolean paramBoolean3)
  {
    this.a = paramd;
    this.b = paramInt;
    this.c = paramBoolean1;
    this.d = paramBoolean2;
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramString3;
    this.h = paramBoolean3;
  }

  public boolean a()
  {
    return this.c;
  }

  public boolean b()
  {
    return this.d;
  }

  public String c()
  {
    return this.e;
  }

  public com.viber.voip.messages.conversation.chatinfo.presentation.a.d d()
  {
    return this.a;
  }

  public int e()
  {
    return this.b;
  }

  public String f()
  {
    return this.f;
  }

  public String g()
  {
    return this.g;
  }

  public boolean h()
  {
    return this.h;
  }

  public static final class a
  {
    private com.viber.voip.messages.conversation.chatinfo.presentation.a.d a;
    private int b;
    private boolean c;
    private boolean d;
    private String e;
    private String f;
    private String g;
    private boolean h;

    public a a(int paramInt)
    {
      this.b = paramInt;
      return this;
    }

    public a a(com.viber.voip.messages.conversation.chatinfo.presentation.a.d paramd)
    {
      this.a = paramd;
      return this;
    }

    public a a(String paramString)
    {
      this.e = paramString;
      return this;
    }

    public a a(boolean paramBoolean)
    {
      this.c = paramBoolean;
      return this;
    }

    public m a()
    {
      return new m(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, null);
    }

    public a b(String paramString)
    {
      this.f = paramString;
      return this;
    }

    public a b(boolean paramBoolean)
    {
      this.d = paramBoolean;
      return this;
    }

    public a c(String paramString)
    {
      this.g = paramString;
      return this;
    }

    public a c(boolean paramBoolean)
    {
      this.h = paramBoolean;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.d.m
 * JD-Core Version:    0.6.2
 */