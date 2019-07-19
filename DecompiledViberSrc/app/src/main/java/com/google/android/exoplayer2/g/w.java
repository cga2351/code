package com.google.android.exoplayer2.g;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class w
{
  private static final Comparator<a> a = x.a;
  private static final Comparator<a> b = y.a;
  private final int c;
  private final ArrayList<a> d;
  private final a[] e;
  private int f;
  private int g;
  private int h;
  private int i;

  public w(int paramInt)
  {
    this.c = paramInt;
    this.e = new a[5];
    this.d = new ArrayList();
    this.f = -1;
  }

  private void a()
  {
    if (this.f != 1)
    {
      Collections.sort(this.d, a);
      this.f = 1;
    }
  }

  private void b()
  {
    if (this.f != 0)
    {
      Collections.sort(this.d, b);
      this.f = 0;
    }
  }

  public float a(float paramFloat)
  {
    b();
    float f1 = paramFloat * this.h;
    int j = 0;
    int k = 0;
    while (j < this.d.size())
    {
      a locala = (a)this.d.get(j);
      k += locala.b;
      if (k >= f1)
        return locala.c;
      j++;
    }
    if (this.d.isEmpty())
      return (0.0F / 0.0F);
    return ((a)this.d.get(-1 + this.d.size())).c;
  }

  public void a(int paramInt, float paramFloat)
  {
    a();
    a locala1;
    if (this.i > 0)
    {
      a[] arrayOfa2 = this.e;
      int n = -1 + this.i;
      this.i = n;
      locala1 = arrayOfa2[n];
      int j = this.g;
      this.g = (j + 1);
      locala1.a = j;
      locala1.b = paramInt;
      locala1.c = paramFloat;
      this.d.add(locala1);
      this.h = (paramInt + this.h);
    }
    while (true)
    {
      if (this.h <= this.c)
        return;
      int k = this.h - this.c;
      a locala2 = (a)this.d.get(0);
      if (locala2.b <= k)
      {
        this.h -= locala2.b;
        this.d.remove(0);
        if (this.i >= 5)
          continue;
        a[] arrayOfa1 = this.e;
        int m = this.i;
        this.i = (m + 1);
        arrayOfa1[m] = locala2;
        continue;
        locala1 = new a(null);
        break;
      }
      locala2.b -= k;
      this.h -= k;
    }
  }

  private static class a
  {
    public int a;
    public int b;
    public float c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.g.w
 * JD-Core Version:    0.6.2
 */