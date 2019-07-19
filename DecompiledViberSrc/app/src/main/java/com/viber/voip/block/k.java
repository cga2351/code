package com.viber.voip.block;

public abstract interface k
{
  public abstract void a(b paramb);

  public abstract void a(c paramc);

  public abstract void b(b paramb);

  public static abstract interface a extends k.b
  {
    public abstract void a(int paramInt, String paramString);

    public abstract void b(int paramInt, String paramString);
  }

  public static abstract interface b
  {
  }

  public static abstract interface c
  {
    public abstract void a(k.b paramb);
  }

  public static abstract interface d extends k.b
  {
    public abstract void a(long paramLong, String paramString1, String paramString2);

    public abstract void b(long paramLong, String paramString1, String paramString2);
  }

  public static abstract interface e extends k.a
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.block.k
 * JD-Core Version:    0.6.2
 */