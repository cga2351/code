package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.g.c;
import com.google.android.exoplayer2.g.p;
import com.google.android.exoplayer2.g.p.b;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.w;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  public final List<byte[]> a;
  public final int b;
  public final int c;
  public final int d;
  public final float e;

  private a(List<byte[]> paramList, int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    this.a = paramList;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramFloat;
  }

  public static a a(r paramr)
    throws w
  {
    int i = -1;
    int j = 0;
    int k;
    try
    {
      paramr.d(4);
      k = 1 + (0x3 & paramr.h());
      if (k == 3)
        throw new IllegalStateException();
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      throw new w("Error parsing AVC config", localArrayIndexOutOfBoundsException);
    }
    ArrayList localArrayList = new ArrayList();
    int m = 0x1F & paramr.h();
    for (int n = 0; n < m; n++)
      localArrayList.add(b(paramr));
    int i1 = paramr.h();
    while (j < i1)
    {
      localArrayList.add(b(paramr));
      j++;
    }
    float f = 1.0F;
    int i2;
    if (m > 0)
    {
      byte[] arrayOfByte = (byte[])localArrayList.get(0);
      p.b localb = p.a((byte[])localArrayList.get(0), k, arrayOfByte.length);
      i2 = localb.e;
      i = localb.f;
      f = localb.g;
    }
    while (true)
    {
      a locala = new a(localArrayList, k, i2, i, f);
      return locala;
      i2 = i;
    }
  }

  private static byte[] b(r paramr)
  {
    int i = paramr.i();
    int j = paramr.d();
    paramr.d(i);
    return c.a(paramr.a, j, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.video.a
 * JD-Core Version:    0.6.2
 */