package com.google.e.f.a.a;

import java.util.ArrayList;
import java.util.List;

final class c
{
  private final List<b> a;
  private final int b;
  private final boolean c;

  c(List<b> paramList, int paramInt, boolean paramBoolean)
  {
    this.a = new ArrayList(paramList);
    this.b = paramInt;
    this.c = paramBoolean;
  }

  List<b> a()
  {
    return this.a;
  }

  boolean a(List<b> paramList)
  {
    return this.a.equals(paramList);
  }

  int b()
  {
    return this.b;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof c));
    c localc;
    do
    {
      return false;
      localc = (c)paramObject;
    }
    while ((!this.a.equals(localc.a())) || (this.c != localc.c));
    return true;
  }

  public int hashCode()
  {
    return this.a.hashCode() ^ Boolean.valueOf(this.c).hashCode();
  }

  public String toString()
  {
    return "{ " + this.a + " }";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.f.a.a.c
 * JD-Core Version:    0.6.2
 */