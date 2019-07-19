package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.t;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.r;

public final class h
  implements j
{
  private final r a = new r(new byte[18]);
  private final String b;
  private String c;
  private q d;
  private int e = 0;
  private int f;
  private int g;
  private long h;
  private Format i;
  private int j;
  private long k;

  public h(String paramString)
  {
    this.b = paramString;
  }

  private boolean a(r paramr, byte[] paramArrayOfByte, int paramInt)
  {
    int m = Math.min(paramr.b(), paramInt - this.f);
    paramr.a(paramArrayOfByte, this.f, m);
    this.f = (m + this.f);
    return this.f == paramInt;
  }

  private boolean b(r paramr)
  {
    while (paramr.b() > 0)
    {
      this.g <<= 8;
      this.g |= paramr.h();
      if (t.a(this.g))
      {
        this.a.a[0] = ((byte)(0xFF & this.g >> 24));
        this.a.a[1] = ((byte)(0xFF & this.g >> 16));
        this.a.a[2] = ((byte)(0xFF & this.g >> 8));
        this.a.a[3] = ((byte)(0xFF & this.g));
        this.f = 4;
        this.g = 0;
        return true;
      }
    }
    return false;
  }

  private void c()
  {
    byte[] arrayOfByte = this.a.a;
    if (this.i == null)
    {
      this.i = t.a(arrayOfByte, this.c, this.b, null);
      this.d.a(this.i);
    }
    this.j = t.b(arrayOfByte);
    this.h = ((int)(1000000L * t.a(arrayOfByte) / this.i.sampleRate));
  }

  public void a()
  {
    this.e = 0;
    this.f = 0;
    this.g = 0;
  }

  public void a(long paramLong, int paramInt)
  {
    this.k = paramLong;
  }

  public void a(i parami, ae.d paramd)
  {
    paramd.a();
    this.c = paramd.c();
    this.d = parami.a(paramd.b(), 1);
  }

  public void a(r paramr)
  {
    while (paramr.b() > 0)
    {
      switch (this.e)
      {
      default:
        throw new IllegalStateException();
      case 0:
        if (!b(paramr))
          continue;
        this.e = 1;
        break;
      case 1:
        if (!a(paramr, this.a.a, 18))
          continue;
        c();
        this.a.c(0);
        this.d.a(this.a, 18);
        this.e = 2;
        break;
      case 2:
      }
      int m = Math.min(paramr.b(), this.j - this.f);
      this.d.a(paramr, m);
      this.f = (m + this.f);
      if (this.f == this.j)
      {
        this.d.a(this.k, 1, this.j, 0, null);
        this.k += this.h;
        this.e = 0;
      }
    }
  }

  public void b()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.f.h
 * JD-Core Version:    0.6.2
 */