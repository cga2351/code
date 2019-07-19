package com.google.e.f.a;

public class b
{
  private final int a;
  private final int b;

  public b(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }

  public final int a()
  {
    return this.a;
  }

  public final int b()
  {
    return this.b;
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof b));
    b localb;
    do
    {
      return false;
      localb = (b)paramObject;
    }
    while ((this.a != localb.a) || (this.b != localb.b));
    return true;
  }

  public final int hashCode()
  {
    return this.a ^ this.b;
  }

  public final String toString()
  {
    return this.a + "(" + this.b + ')';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.f.a.b
 * JD-Core Version:    0.6.2
 */