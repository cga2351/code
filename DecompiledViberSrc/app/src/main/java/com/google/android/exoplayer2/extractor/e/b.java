package com.google.android.exoplayer2.extractor.e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.o;
import com.google.android.exoplayer2.extractor.o.a;
import com.google.android.exoplayer2.extractor.p;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.j;
import com.google.android.exoplayer2.g.r;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class b extends i
{
  private j a;
  private a b;

  public static boolean a(r paramr)
  {
    return (paramr.b() >= 5) && (paramr.h() == 127) && (paramr.n() == 1179402563L);
  }

  private static boolean a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte[0];
    boolean bool = false;
    if (i == -1)
      bool = true;
    return bool;
  }

  private int c(r paramr)
  {
    int i = (0xFF & paramr.a[2]) >> 4;
    switch (i)
    {
    default:
      return -1;
    case 1:
      return 192;
    case 2:
    case 3:
    case 4:
    case 5:
      return 576 << i - 2;
    case 6:
    case 7:
      paramr.d(4);
      paramr.C();
      if (i == 6);
      for (int j = paramr.h(); ; j = paramr.i())
      {
        paramr.c(0);
        return j + 1;
      }
    case 8:
    case 9:
    case 10:
    case 11:
    case 12:
    case 13:
    case 14:
    case 15:
    }
    return 256 << i - 8;
  }

  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean)
    {
      this.a = null;
      this.b = null;
    }
  }

  protected boolean a(r paramr, long paramLong, i.a parama)
    throws IOException, InterruptedException
  {
    byte[] arrayOfByte1 = paramr.a;
    boolean bool;
    if (this.a == null)
    {
      this.a = new j(arrayOfByte1, 17);
      byte[] arrayOfByte2 = Arrays.copyOfRange(arrayOfByte1, 9, paramr.c());
      arrayOfByte2[4] = -128;
      List localList = Collections.singletonList(arrayOfByte2);
      parama.a = Format.createAudioSampleFormat(null, "audio/flac", null, -1, this.a.a(), this.a.f, this.a.e, localList, null, 0, null);
      bool = true;
    }
    a locala;
    do
    {
      return bool;
      if ((0x7F & arrayOfByte1[0]) == 3)
      {
        this.b = new a();
        this.b.a(paramr);
        break;
      }
      if (!a(arrayOfByte1))
        break;
      locala = this.b;
      bool = false;
    }
    while (locala == null);
    this.b.b(paramLong);
    parama.b = this.b;
    return false;
  }

  protected long b(r paramr)
  {
    if (!a(paramr.a))
      return -1L;
    return c(paramr);
  }

  private class a
    implements g, o
  {
    private long[] b;
    private long[] c;
    private long d = -1L;
    private long e = -1L;

    public a()
    {
    }

    public long a(h paramh)
      throws IOException, InterruptedException
    {
      if (this.e >= 0L)
      {
        long l = -(2L + this.e);
        this.e = -1L;
        return l;
      }
      return -1L;
    }

    public o.a a(long paramLong)
    {
      long l1 = b.this.b(paramLong);
      int i = ag.a(this.b, l1, true, true);
      long l2 = b.this.a(this.b[i]);
      p localp = new p(l2, this.d + this.c[i]);
      if ((l2 >= paramLong) || (i == -1 + this.b.length))
        return new o.a(localp);
      return new o.a(localp, new p(b.this.a(this.b[(i + 1)]), this.d + this.c[(i + 1)]));
    }

    public void a(r paramr)
    {
      paramr.d(1);
      int i = paramr.l() / 18;
      this.b = new long[i];
      this.c = new long[i];
      for (int j = 0; j < i; j++)
      {
        this.b[j] = paramr.r();
        this.c[j] = paramr.r();
        paramr.d(2);
      }
    }

    public boolean a()
    {
      return true;
    }

    public long a_(long paramLong)
    {
      long l = b.this.b(paramLong);
      int i = ag.a(this.b, l, true, true);
      this.e = this.b[i];
      return l;
    }

    public long b()
    {
      return b.a(b.this).b();
    }

    public void b(long paramLong)
    {
      this.d = paramLong;
    }

    public o c()
    {
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.e.b
 * JD-Core Version:    0.6.2
 */