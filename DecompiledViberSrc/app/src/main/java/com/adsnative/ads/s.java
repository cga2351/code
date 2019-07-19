package com.adsnative.ads;

import java.util.ArrayList;
import java.util.Collections;

public final class s
{
  public static a a()
  {
    return new a(null);
  }

  static a a(a parama)
  {
    if (parama == null)
      throw new NullPointerException("Positioning cannot be null");
    a locala = new a(null);
    a.a(locala).addAll(a.a(parama));
    a.a(locala, a.b(parama));
    return locala;
  }

  public static class a
  {
    private final ArrayList<Integer> a = new ArrayList();
    private int b = 2147483647;

    public a a(int paramInt)
    {
      if (paramInt < 0);
      int i;
      do
      {
        return this;
        i = Collections.binarySearch(this.a, Integer.valueOf(paramInt));
      }
      while (i >= 0);
      this.a.add(i ^ 0xFFFFFFFF, Integer.valueOf(paramInt));
      return this;
    }

    public a b(int paramInt)
    {
      if (paramInt <= 1)
      {
        this.b = 2147483647;
        return this;
      }
      this.b = paramInt;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.ads.s
 * JD-Core Version:    0.6.2
 */