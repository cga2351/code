package com.google.android.exoplayer2.source.c.a;

import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.offline.c;
import java.util.Collections;
import java.util.List;

public final class e extends f
{
  public final int a;
  public final long b;
  public final long c;
  public final boolean d;
  public final int e;
  public final long f;
  public final int g;
  public final long h;
  public final boolean i;
  public final boolean j;
  public final DrmInitData k;
  public final List<a> l;
  public final long m;

  public e(int paramInt1, String paramString, List<String> paramList, long paramLong1, long paramLong2, boolean paramBoolean1, int paramInt2, long paramLong3, int paramInt3, long paramLong4, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, DrmInitData paramDrmInitData, List<a> paramList1)
  {
    super(paramString, paramList, paramBoolean2);
    this.a = paramInt1;
    this.c = paramLong2;
    this.d = paramBoolean1;
    this.e = paramInt2;
    this.f = paramLong3;
    this.g = paramInt3;
    this.h = paramLong4;
    this.i = paramBoolean3;
    this.j = paramBoolean4;
    this.k = paramDrmInitData;
    this.l = Collections.unmodifiableList(paramList1);
    if (!paramList1.isEmpty())
    {
      a locala = (a)paramList1.get(-1 + paramList1.size());
      this.m = (locala.f + locala.c);
      if (paramLong1 != -9223372036854775807L)
        break label151;
      paramLong1 = -9223372036854775807L;
    }
    while (true)
    {
      this.b = paramLong1;
      return;
      this.m = 0L;
      break;
      label151: if (paramLong1 < 0L)
        paramLong1 += this.m;
    }
  }

  public long a()
  {
    return this.c + this.m;
  }

  public e a(long paramLong, int paramInt)
  {
    return new e(this.a, this.n, this.o, this.b, paramLong, true, paramInt, this.f, this.g, this.h, this.p, this.i, this.j, this.k, this.l);
  }

  public boolean a(e parame)
  {
    boolean bool1;
    if ((parame == null) || (this.f > parame.f))
      bool1 = true;
    boolean bool4;
    do
    {
      boolean bool3;
      do
      {
        int n;
        int i1;
        do
        {
          boolean bool2;
          do
          {
            return bool1;
            bool2 = this.f < parame.f;
            bool1 = false;
          }
          while (bool2);
          n = this.l.size();
          i1 = parame.l.size();
          if (n > i1)
            break;
          bool1 = false;
        }
        while (n != i1);
        bool3 = this.i;
        bool1 = false;
      }
      while (!bool3);
      bool4 = parame.i;
      bool1 = false;
    }
    while (bool4);
    return true;
  }

  public e b()
  {
    if (this.i)
      return this;
    return new e(this.a, this.n, this.o, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.p, true, this.j, this.k, this.l);
  }

  public e b(List<c> paramList)
  {
    return this;
  }

  public static final class a
    implements Comparable<Long>
  {
    public final String a;
    public final a b;
    public final long c;
    public final String d;
    public final int e;
    public final long f;
    public final DrmInitData g;
    public final String h;
    public final String i;
    public final long j;
    public final long k;
    public final boolean l;

    public a(String paramString, long paramLong1, long paramLong2)
    {
      this(paramString, null, "", 0L, -1, -9223372036854775807L, null, null, null, paramLong1, paramLong2, false);
    }

    public a(String paramString1, a parama, String paramString2, long paramLong1, int paramInt, long paramLong2, DrmInitData paramDrmInitData, String paramString3, String paramString4, long paramLong3, long paramLong4, boolean paramBoolean)
    {
      this.a = paramString1;
      this.b = parama;
      this.d = paramString2;
      this.c = paramLong1;
      this.e = paramInt;
      this.f = paramLong2;
      this.g = paramDrmInitData;
      this.h = paramString3;
      this.i = paramString4;
      this.j = paramLong3;
      this.k = paramLong4;
      this.l = paramBoolean;
    }

    public int a(Long paramLong)
    {
      if (this.f > paramLong.longValue())
        return 1;
      if (this.f < paramLong.longValue())
        return -1;
      return 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c.a.e
 * JD-Core Version:    0.6.2
 */