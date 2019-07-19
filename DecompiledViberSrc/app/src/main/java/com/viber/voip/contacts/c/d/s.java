package com.viber.voip.contacts.c.d;

public class s
{
  private final long a;
  private final String b;
  private final String c;
  private final String d;
  private final boolean e;

  private s(long paramLong, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.a = paramLong;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramBoolean;
  }

  public long a()
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

  public String d()
  {
    return this.d;
  }

  public boolean e()
  {
    return this.e;
  }

  public static class a
  {
    private long a = -1L;
    private String b;
    private String c;
    private String d;
    private boolean e = true;

    public a a(long paramLong)
    {
      this.a = paramLong;
      return this;
    }

    public a a(String paramString)
    {
      this.b = paramString;
      return this;
    }

    public a a(boolean paramBoolean)
    {
      this.e = paramBoolean;
      return this;
    }

    public s a()
    {
      return new s(this.a, this.b, this.c, this.d, this.e, null);
    }

    public a b(String paramString)
    {
      this.c = paramString;
      return this;
    }

    public a c(String paramString)
    {
      this.d = paramString;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.d.s
 * JD-Core Version:    0.6.2
 */