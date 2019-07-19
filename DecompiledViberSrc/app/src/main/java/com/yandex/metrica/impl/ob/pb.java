package com.yandex.metrica.impl.ob;

public enum pb
{
  private final int d;

  static
  {
    pb[] arrayOfpb = new pb[3];
    arrayOfpb[0] = a;
    arrayOfpb[1] = b;
    arrayOfpb[2] = c;
  }

  private pb(int paramInt)
  {
    this.d = paramInt;
  }

  public static pb a(int paramInt)
  {
    for (pb localpb : values())
      if (localpb.a() == paramInt)
        return localpb;
    return null;
  }

  public int a()
  {
    return this.d;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.pb
 * JD-Core Version:    0.6.2
 */