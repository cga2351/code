package com.google.android.exoplayer2.e.c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.google.android.exoplayer2.e.c;
import com.google.android.exoplayer2.e.e;
import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.r;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.Inflater;

public final class a extends c
{
  private final r a = new r();
  private final r b = new r();
  private final a c = new a();
  private Inflater d;

  public a()
  {
    super("PgsDecoder");
  }

  private static com.google.android.exoplayer2.e.b a(r paramr, a parama)
  {
    int i = paramr.c();
    int j = paramr.h();
    int k = paramr.i();
    int m = k + paramr.d();
    if (m > i)
    {
      paramr.c(i);
      return null;
    }
    com.google.android.exoplayer2.e.b localb = null;
    switch (j)
    {
    default:
    case 20:
    case 21:
    case 22:
    case 128:
    }
    while (true)
    {
      paramr.c(m);
      return localb;
      a.a(parama, paramr, k);
      localb = null;
      continue;
      a.b(parama, paramr, k);
      localb = null;
      continue;
      a.c(parama, paramr, k);
      localb = null;
      continue;
      localb = parama.a();
      parama.b();
    }
  }

  private void a(r paramr)
  {
    if ((paramr.b() > 0) && (paramr.f() == 120))
    {
      if (this.d == null)
        this.d = new Inflater();
      if (ag.a(paramr, this.b, this.d))
        paramr.a(this.b.a, this.b.c());
    }
  }

  protected e a(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
    throws g
  {
    this.a.a(paramArrayOfByte, paramInt);
    a(this.a);
    this.c.b();
    ArrayList localArrayList = new ArrayList();
    while (this.a.b() >= 3)
    {
      com.google.android.exoplayer2.e.b localb = a(this.a, this.c);
      if (localb != null)
        localArrayList.add(localb);
    }
    return new b(Collections.unmodifiableList(localArrayList));
  }

  private static final class a
  {
    private final r a = new r();
    private final int[] b = new int[256];
    private boolean c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;

    private void a(r paramr, int paramInt)
    {
      if (paramInt % 5 != 2)
        return;
      paramr.d(2);
      Arrays.fill(this.b, 0);
      int j = paramInt / 5;
      for (int k = 0; k < j; k++)
      {
        int m = paramr.h();
        int n = paramr.h();
        int i1 = paramr.h();
        int i2 = paramr.h();
        int i3 = paramr.h();
        int i4 = (int)(n + 1.402D * (i1 - 128));
        int i5 = (int)(n - 0.34414D * (i2 - 128) - 0.71414D * (i1 - 128));
        int i6 = (int)(n + 1.772D * (i2 - 128));
        this.b[m] = (i3 << 24 | ag.a(i4, 0, 255) << 16 | ag.a(i5, 0, 255) << 8 | ag.a(i6, 0, 255));
      }
      this.c = true;
    }

    private void b(r paramr, int paramInt)
    {
      if (paramInt < 4)
        return;
      paramr.d(3);
      if ((0x80 & paramr.h()) != 0);
      for (int j = 1; ; j = 0)
      {
        int k = paramInt - 4;
        if (j != 0)
        {
          if (k < 7)
            break;
          int i2 = paramr.l();
          if (i2 < 4)
            break;
          this.h = paramr.i();
          this.i = paramr.i();
          this.a.a(i2 - 4);
          k -= 7;
        }
        int m = this.a.d();
        int n = this.a.c();
        if ((m >= n) || (k <= 0))
          break;
        int i1 = Math.min(k, n - m);
        paramr.a(this.a.a, m, i1);
        this.a.c(i1 + m);
        return;
      }
    }

    private void c(r paramr, int paramInt)
    {
      if (paramInt < 19)
        return;
      this.d = paramr.i();
      this.e = paramr.i();
      paramr.d(11);
      this.f = paramr.i();
      this.g = paramr.i();
    }

    public com.google.android.exoplayer2.e.b a()
    {
      if ((this.d == 0) || (this.e == 0) || (this.h == 0) || (this.i == 0) || (this.a.c() == 0) || (this.a.d() != this.a.c()) || (!this.c))
        return null;
      this.a.c(0);
      int[] arrayOfInt = new int[this.h * this.i];
      int j = 0;
      while (j < arrayOfInt.length)
      {
        int k = this.a.h();
        if (k != 0)
        {
          int i2 = j + 1;
          arrayOfInt[j] = this.b[k];
          j = i2;
        }
        else
        {
          int m = this.a.h();
          if (m != 0)
          {
            int n;
            if ((m & 0x40) == 0)
            {
              n = m & 0x3F;
              label153: if ((m & 0x80) != 0)
                break label205;
            }
            label205: for (int i1 = 0; ; i1 = this.b[this.a.h()])
            {
              Arrays.fill(arrayOfInt, j, j + n, i1);
              j += n;
              break;
              n = (m & 0x3F) << 8 | this.a.h();
              break label153;
            }
          }
        }
      }
      return new com.google.android.exoplayer2.e.b(Bitmap.createBitmap(arrayOfInt, this.h, this.i, Bitmap.Config.ARGB_8888), this.f / this.d, 0, this.g / this.e, 0, this.h / this.d, this.i / this.e);
    }

    public void b()
    {
      this.d = 0;
      this.e = 0;
      this.f = 0;
      this.g = 0;
      this.h = 0;
      this.i = 0;
      this.a.a(0);
      this.c = false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.e.c.a
 * JD-Core Version:    0.6.2
 */