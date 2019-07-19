package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.a;
import com.google.android.exoplayer2.b.a.a;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.g.r;

public final class c
  implements j
{
  private final com.google.android.exoplayer2.g.q a = new com.google.android.exoplayer2.g.q(new byte['']);
  private final r b = new r(this.a.a);
  private final String c;
  private String d;
  private com.google.android.exoplayer2.extractor.q e;
  private int f = 0;
  private int g;
  private boolean h;
  private long i;
  private Format j;
  private int k;
  private long l;

  public c()
  {
    this(null);
  }

  public c(String paramString)
  {
    this.c = paramString;
  }

  private boolean a(r paramr, byte[] paramArrayOfByte, int paramInt)
  {
    int m = Math.min(paramr.b(), paramInt - this.g);
    paramr.a(paramArrayOfByte, this.g, m);
    this.g = (m + this.g);
    return this.g == paramInt;
  }

  private boolean b(r paramr)
  {
    if (paramr.b() > 0)
    {
      if (!this.h)
      {
        if (paramr.h() == 11);
        for (boolean bool2 = true; ; bool2 = false)
        {
          this.h = bool2;
          break;
        }
      }
      int m = paramr.h();
      if (m == 119)
      {
        this.h = false;
        return true;
      }
      if (m == 11);
      for (boolean bool1 = true; ; bool1 = false)
      {
        this.h = bool1;
        break;
      }
    }
    return false;
  }

  private void c()
  {
    this.a.a(0);
    a.a locala = a.a(this.a);
    if ((this.j == null) || (locala.d != this.j.channelCount) || (locala.c != this.j.sampleRate) || (locala.a != this.j.sampleMimeType))
    {
      this.j = Format.createAudioSampleFormat(this.d, locala.a, null, -1, -1, locala.d, locala.c, null, null, 0, this.c);
      this.e.a(this.j);
    }
    this.k = locala.e;
    this.i = (1000000L * locala.f / this.j.sampleRate);
  }

  public void a()
  {
    this.f = 0;
    this.g = 0;
    this.h = false;
  }

  public void a(long paramLong, int paramInt)
  {
    this.l = paramLong;
  }

  public void a(i parami, ae.d paramd)
  {
    paramd.a();
    this.d = paramd.c();
    this.e = parami.a(paramd.b(), 1);
  }

  public void a(r paramr)
  {
    while (paramr.b() > 0)
    {
      switch (this.f)
      {
      default:
        break;
      case 0:
        if (!b(paramr))
          continue;
        this.f = 1;
        this.b.a[0] = 11;
        this.b.a[1] = 119;
        this.g = 2;
        break;
      case 1:
        if (!a(paramr, this.b.a, 128))
          continue;
        c();
        this.b.c(0);
        this.e.a(this.b, 128);
        this.f = 2;
        break;
      case 2:
      }
      int m = Math.min(paramr.b(), this.k - this.g);
      this.e.a(paramr, m);
      this.g = (m + this.g);
      if (this.g == this.k)
      {
        this.e.a(this.l, 1, this.k, 0, null);
        this.l += this.i;
        this.f = 0;
      }
    }
  }

  public void b()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.f.c
 * JD-Core Version:    0.6.2
 */