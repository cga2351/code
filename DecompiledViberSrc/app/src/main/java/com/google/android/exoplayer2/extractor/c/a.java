package com.google.android.exoplayer2.extractor.c;

import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.w;
import java.io.IOException;
import java.util.ArrayDeque;

final class a
  implements b
{
  private final byte[] a = new byte[8];
  private final ArrayDeque<a> b = new ArrayDeque();
  private final g c = new g();
  private c d;
  private int e;
  private int f;
  private long g;

  private long a(h paramh, int paramInt)
    throws IOException, InterruptedException
  {
    int i = 0;
    paramh.b(this.a, 0, paramInt);
    long l = 0L;
    while (i < paramInt)
    {
      l = l << 8 | 0xFF & this.a[i];
      i++;
    }
    return l;
  }

  private double b(h paramh, int paramInt)
    throws IOException, InterruptedException
  {
    long l = a(paramh, paramInt);
    if (paramInt == 4)
      return Float.intBitsToFloat((int)l);
    return Double.longBitsToDouble(l);
  }

  private long b(h paramh)
    throws IOException, InterruptedException
  {
    paramh.a();
    while (true)
    {
      paramh.c(this.a, 0, 4);
      int i = g.a(this.a[0]);
      if ((i != -1) && (i <= 4))
      {
        int j = (int)g.a(this.a, i, false);
        if (this.d.b(j))
        {
          paramh.b(i);
          return j;
        }
      }
      paramh.b(1);
    }
  }

  private String c(h paramh, int paramInt)
    throws IOException, InterruptedException
  {
    if (paramInt == 0)
      return "";
    byte[] arrayOfByte = new byte[paramInt];
    paramh.b(arrayOfByte, 0, paramInt);
    while ((paramInt > 0) && (arrayOfByte[(paramInt - 1)] == 0))
      paramInt--;
    return new String(arrayOfByte, 0, paramInt);
  }

  public void a()
  {
    this.e = 0;
    this.b.clear();
    this.c.a();
  }

  public void a(c paramc)
  {
    this.d = paramc;
  }

  public boolean a(h paramh)
    throws IOException, InterruptedException
  {
    boolean bool;
    if (this.d != null)
    {
      bool = true;
      com.google.android.exoplayer2.g.a.b(bool);
    }
    while (true)
    {
      if ((!this.b.isEmpty()) && (paramh.c() >= a.a((a)this.b.peek())))
      {
        this.d.c(a.b((a)this.b.pop()));
        return true;
        bool = false;
        break;
      }
      if (this.e == 0)
      {
        long l3 = this.c.a(paramh, true, false, 4);
        if (l3 == -2L)
          l3 = b(paramh);
        if (l3 == -1L)
          return false;
        this.f = ((int)l3);
        this.e = 1;
      }
      if (this.e == 1)
      {
        this.g = this.c.a(paramh, false, true, 8);
        this.e = 2;
      }
      int i = this.d.a(this.f);
      switch (i)
      {
      default:
        throw new w("Invalid element type " + i);
      case 1:
        long l1 = paramh.c();
        long l2 = l1 + this.g;
        this.b.push(new a(this.f, l2, null));
        this.d.a(this.f, l1, this.g);
        this.e = 0;
        return true;
      case 2:
        if (this.g > 8L)
          throw new w("Invalid integer size: " + this.g);
        this.d.a(this.f, a(paramh, (int)this.g));
        this.e = 0;
        return true;
      case 5:
        if ((this.g != 4L) && (this.g != 8L))
          throw new w("Invalid float size: " + this.g);
        this.d.a(this.f, b(paramh, (int)this.g));
        this.e = 0;
        return true;
      case 3:
        if (this.g > 2147483647L)
          throw new w("String element size: " + this.g);
        this.d.a(this.f, c(paramh, (int)this.g));
        this.e = 0;
        return true;
      case 4:
        this.d.a(this.f, (int)this.g, paramh);
        this.e = 0;
        return true;
      case 0:
      }
      paramh.b((int)this.g);
      this.e = 0;
    }
  }

  private static final class a
  {
    private final int a;
    private final long b;

    private a(int paramInt, long paramLong)
    {
      this.a = paramInt;
      this.b = paramLong;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.c.a
 * JD-Core Version:    0.6.2
 */