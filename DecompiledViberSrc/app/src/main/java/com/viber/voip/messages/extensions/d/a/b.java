package com.viber.voip.messages.extensions.d.a;

public class b
{
  public final String a;
  public final String b;
  public final long c;
  public final long d;

  public b(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramLong1;
    this.d = paramLong2;
  }

  public boolean a()
  {
    return (this.c != 0L) && (this.d != 0L);
  }

  public boolean a(long paramLong)
  {
    return (this.c <= paramLong) && (paramLong < this.d);
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    b localb;
    boolean bool4;
    do
    {
      boolean bool3;
      do
      {
        boolean bool2;
        do
        {
          Class localClass1;
          Class localClass2;
          do
          {
            do
            {
              return bool1;
              bool1 = false;
            }
            while (paramObject == null);
            localClass1 = getClass();
            localClass2 = paramObject.getClass();
            bool1 = false;
          }
          while (localClass1 != localClass2);
          localb = (b)paramObject;
          bool2 = this.c < localb.c;
          bool1 = false;
        }
        while (bool2);
        bool3 = this.d < localb.d;
        bool1 = false;
      }
      while (bool3);
      bool4 = this.a.equals(localb.a);
      bool1 = false;
    }
    while (!bool4);
    return this.b.equals(localb.b);
  }

  public int hashCode()
  {
    return 31 * (31 * (31 * this.a.hashCode() + this.b.hashCode()) + (int)(this.c ^ this.c >>> 32)) + (int)(this.d ^ this.d >>> 32);
  }

  public String toString()
  {
    return "Item{keyword='" + this.a + '\'' + ", serviceUri='" + this.b + '\'' + ", timeframeFrom=" + this.c + ", timeframeTo=" + this.d + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.d.a.b
 * JD-Core Version:    0.6.2
 */