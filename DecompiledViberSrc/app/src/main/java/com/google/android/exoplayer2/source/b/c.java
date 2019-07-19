package com.google.android.exoplayer2.source.b;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.f.ac;
import com.google.android.exoplayer2.f.h;
import com.google.android.exoplayer2.f.l;
import com.google.android.exoplayer2.g.ag;
import java.io.IOException;
import java.util.Arrays;

public abstract class c extends b
{
  private byte[] i;
  private volatile boolean j;

  public c(h paramh, l paraml, int paramInt1, Format paramFormat, int paramInt2, Object paramObject, byte[] paramArrayOfByte)
  {
    super(paramh, paraml, paramInt1, paramFormat, paramInt2, paramObject, -9223372036854775807L, -9223372036854775807L);
    this.i = paramArrayOfByte;
  }

  private void a(int paramInt)
  {
    if (this.i == null)
      this.i = new byte[16384];
    while (this.i.length >= paramInt + 16384)
      return;
    this.i = Arrays.copyOf(this.i, 16384 + this.i.length);
  }

  public final void a()
  {
    this.j = true;
  }

  protected abstract void a(byte[] paramArrayOfByte, int paramInt)
    throws IOException;

  public final void b()
    throws IOException, InterruptedException
  {
    int k = 0;
    try
    {
      this.h.a(this.a);
      int m = 0;
      while ((k != -1) && (!this.j))
      {
        a(m);
        k = this.h.a(this.i, m, 16384);
        if (k != -1)
          m += k;
      }
      if (!this.j)
        a(this.i, m);
      return;
    }
    finally
    {
      ag.a(this.h);
    }
  }

  public byte[] g()
  {
    return this.i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.c
 * JD-Core Version:    0.6.2
 */