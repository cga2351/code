package com.google.android.exoplayer2.source.c;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.f.l;
import com.google.android.exoplayer2.g.af;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.b.a;
import com.google.android.exoplayer2.source.b.c;
import com.google.android.exoplayer2.source.c.a.e.a;
import com.google.android.exoplayer2.source.c.a.i;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

class d
{
  private final f a;
  private final com.google.android.exoplayer2.f.h b;
  private final com.google.android.exoplayer2.f.h c;
  private final p d;
  private final com.google.android.exoplayer2.source.c.a.d.a[] e;
  private final i f;
  private final TrackGroup g;
  private final List<Format> h;
  private boolean i;
  private byte[] j;
  private IOException k;
  private com.google.android.exoplayer2.source.c.a.d.a l;
  private boolean m;
  private Uri n;
  private byte[] o;
  private String p;
  private byte[] q;
  private com.google.android.exoplayer2.trackselection.e r;
  private long s;
  private boolean t;

  public d(f paramf, i parami, com.google.android.exoplayer2.source.c.a.d.a[] paramArrayOfa, e parame, com.google.android.exoplayer2.f.ad paramad, p paramp, List<Format> paramList)
  {
    this.a = paramf;
    this.f = parami;
    this.e = paramArrayOfa;
    this.d = paramp;
    this.h = paramList;
    this.s = -9223372036854775807L;
    Format[] arrayOfFormat = new Format[paramArrayOfa.length];
    int[] arrayOfInt = new int[paramArrayOfa.length];
    for (int i1 = 0; i1 < paramArrayOfa.length; i1++)
    {
      arrayOfFormat[i1] = paramArrayOfa[i1].b;
      arrayOfInt[i1] = i1;
    }
    this.b = parame.a(1);
    if (paramad != null)
      this.b.a(paramad);
    this.c = parame.a(3);
    this.g = new TrackGroup(arrayOfFormat);
    this.r = new d(this.g, arrayOfInt);
  }

  private long a(long paramLong)
  {
    long l1 = -9223372036854775807L;
    if (this.s != l1);
    for (int i1 = 1; ; i1 = 0)
    {
      if (i1 != 0)
        l1 = this.s - paramLong;
      return l1;
    }
  }

  private long a(h paramh, boolean paramBoolean, com.google.android.exoplayer2.source.c.a.e parame, long paramLong1, long paramLong2)
  {
    if ((paramh == null) || (paramBoolean))
    {
      long l1 = paramLong1 + parame.m;
      if ((paramh == null) || (this.m));
      while ((!parame.i) && (paramLong2 >= l1))
      {
        return parame.f + parame.l.size();
        paramLong2 = paramh.f;
      }
      long l2 = paramLong2 - paramLong1;
      List localList = parame.l;
      Long localLong = Long.valueOf(l2);
      if ((!this.f.e()) || (paramh == null));
      for (boolean bool = true; ; bool = false)
        return ag.a(localList, localLong, true, bool) + parame.f;
    }
    return paramh.g();
  }

  private a a(Uri paramUri, String paramString, int paramInt1, int paramInt2, Object paramObject)
  {
    l locall = new l(paramUri, 0L, -1L, null, 1);
    return new a(this.c, locall, this.e[paramInt1].b, paramInt2, paramObject, this.j, paramString);
  }

  private void a(Uri paramUri, String paramString, byte[] paramArrayOfByte)
  {
    String str;
    byte[] arrayOfByte1;
    byte[] arrayOfByte2;
    if (ag.d(paramString).startsWith("0x"))
    {
      str = paramString.substring(2);
      arrayOfByte1 = new BigInteger(str, 16).toByteArray();
      arrayOfByte2 = new byte[16];
      if (arrayOfByte1.length <= 16)
        break label110;
    }
    label110: for (int i1 = -16 + arrayOfByte1.length; ; i1 = 0)
    {
      System.arraycopy(arrayOfByte1, i1, arrayOfByte2, i1 + (arrayOfByte2.length - arrayOfByte1.length), arrayOfByte1.length - i1);
      this.n = paramUri;
      this.o = paramArrayOfByte;
      this.p = paramString;
      this.q = arrayOfByte2;
      return;
      str = paramString;
      break;
    }
  }

  private void a(com.google.android.exoplayer2.source.c.a.e parame)
  {
    if (parame.i);
    for (long l1 = -9223372036854775807L; ; l1 = parame.a() - this.f.c())
    {
      this.s = l1;
      return;
    }
  }

  private void e()
  {
    this.n = null;
    this.o = null;
    this.p = null;
    this.q = null;
  }

  public void a()
    throws IOException
  {
    if (this.k != null)
      throw this.k;
    if ((this.l != null) && (this.t))
      this.f.b(this.l);
  }

  public void a(long paramLong1, long paramLong2, List<h> paramList, b paramb)
  {
    h localh;
    int i1;
    label21: int i2;
    boolean bool1;
    label131: com.google.android.exoplayer2.source.c.a.d.a locala1;
    boolean bool6;
    if (paramList.isEmpty())
    {
      localh = null;
      if (localh != null)
        break label219;
      i1 = -1;
      long l1 = paramLong2 - paramLong1;
      long l2 = a(paramLong1);
      if ((localh != null) && (!this.m))
      {
        long l9 = localh.c();
        l1 = Math.max(0L, l1 - l9);
        if (l2 != -9223372036854775807L)
          l2 = Math.max(0L, l2 - l9);
      }
      com.google.android.exoplayer2.source.b.e[] arrayOfe = a(localh, paramLong2);
      this.r.a(paramLong1, l1, l2, paramList, arrayOfe);
      i2 = this.r.i();
      if (i1 == i2)
        break label236;
      bool1 = true;
      locala1 = this.e[i2];
      if (this.f.a(locala1))
        break label248;
      paramb.c = locala1;
      bool6 = this.t;
      if (this.l != locala1)
        break label242;
    }
    label219: label236: label242: for (boolean bool7 = true; ; bool7 = false)
    {
      this.t = (bool7 & bool6);
      this.l = locala1;
      return;
      localh = (h)paramList.get(-1 + paramList.size());
      break;
      i1 = this.g.indexOf(localh.c);
      break label21;
      bool1 = false;
      break label131;
    }
    label248: com.google.android.exoplayer2.source.c.a.e locale1 = this.f.a(locala1, true);
    this.m = locale1.p;
    a(locale1);
    long l3 = locale1.c - this.f.c();
    long l4 = a(localh, bool1, locale1, l3, paramLong2);
    long l5;
    com.google.android.exoplayer2.source.c.a.e locale2;
    com.google.android.exoplayer2.source.c.a.d.a locala2;
    int i3;
    if (l4 < locale1.f)
      if ((localh != null) && (bool1))
      {
        com.google.android.exoplayer2.source.c.a.d.a locala5 = this.e[i1];
        com.google.android.exoplayer2.source.c.a.e locale3 = this.f.a(locala5, true);
        long l8 = locale3.c - this.f.c();
        l4 = localh.g();
        l5 = l8;
        locale2 = locale3;
        locala2 = locala5;
        i3 = i1;
      }
    while (true)
    {
      int i4 = (int)(l4 - locale2.f);
      if (i4 >= locale2.l.size())
      {
        if (locale2.i)
        {
          paramb.b = true;
          return;
          this.k = new com.google.android.exoplayer2.source.b();
          return;
        }
        paramb.c = locala2;
        boolean bool4 = this.t;
        if (this.l == locala2);
        for (boolean bool5 = true; ; bool5 = false)
        {
          this.t = (bool5 & bool4);
          this.l = locala2;
          return;
        }
      }
      this.t = false;
      this.l = null;
      e.a locala3 = (e.a)locale2.l.get(i4);
      e.a locala4;
      if (locala3.h != null)
      {
        Uri localUri = af.a(locale2.n, locala3.h);
        if (!localUri.equals(this.n))
        {
          paramb.a = a(localUri, locala3.i, i3, this.r.b(), this.r.c());
          return;
        }
        if (!ag.a(locala3.i, this.p))
          a(localUri, locala3.i, this.o);
        locala4 = locala3.b;
        if (locala4 == null)
          break label874;
      }
      label874: for (l locall1 = new l(af.a(locale2.n, locala4.a), locala4.j, locala4.k, null); ; locall1 = null)
      {
        long l6 = l5 + locala3.f;
        int i5 = locale2.e + locala3.e;
        com.google.android.exoplayer2.g.ad localad = this.d.a(i5);
        l locall2 = new l(af.a(locale2.n, locala3.a), locala3.j, locala3.k, null);
        f localf = this.a;
        com.google.android.exoplayer2.f.h localh1 = this.b;
        List localList = this.h;
        int i6 = this.r.b();
        Object localObject = this.r.c();
        long l7 = l6 + locala3.c;
        boolean bool2 = locala3.l;
        boolean bool3 = this.i;
        DrmInitData localDrmInitData = locala3.g;
        byte[] arrayOfByte1 = this.o;
        byte[] arrayOfByte2 = this.q;
        paramb.a = new h(localf, localh1, locall2, locall1, locala2, localList, i6, localObject, l6, l7, l4, i5, bool2, bool3, localad, localh, localDrmInitData, arrayOfByte1, arrayOfByte2);
        return;
        e();
        break;
      }
      locale2 = locale1;
      locala2 = locala1;
      i3 = i2;
      l5 = l3;
    }
  }

  public void a(com.google.android.exoplayer2.source.b.b paramb)
  {
    if ((paramb instanceof a))
    {
      a locala = (a)paramb;
      this.j = locala.g();
      a(locala.a.a, locala.i, locala.h());
    }
  }

  public void a(com.google.android.exoplayer2.trackselection.e parame)
  {
    this.r = parame;
  }

  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }

  public boolean a(com.google.android.exoplayer2.source.b.b paramb, long paramLong)
  {
    return this.r.a(this.r.c(this.g.indexOf(paramb.c)), paramLong);
  }

  public boolean a(com.google.android.exoplayer2.source.c.a.d.a parama, long paramLong)
  {
    int i1 = this.g.indexOf(parama.b);
    if (i1 == -1);
    int i2;
    do
    {
      return true;
      i2 = this.r.c(i1);
    }
    while (i2 == -1);
    boolean bool1 = this.t;
    if (this.l == parama);
    for (boolean bool2 = true; ; bool2 = false)
    {
      this.t = (bool2 | bool1);
      boolean bool3;
      if (paramLong != -9223372036854775807L)
      {
        boolean bool4 = this.r.a(i2, paramLong);
        bool3 = false;
        if (!bool4);
      }
      else
      {
        bool3 = true;
      }
      return bool3;
    }
  }

  public com.google.android.exoplayer2.source.b.e[] a(h paramh, long paramLong)
  {
    int i1;
    com.google.android.exoplayer2.source.b.e[] arrayOfe;
    int i2;
    label24: int i3;
    com.google.android.exoplayer2.source.c.a.d.a locala;
    if (paramh == null)
    {
      i1 = -1;
      arrayOfe = new com.google.android.exoplayer2.source.b.e[this.r.g()];
      i2 = 0;
      if (i2 >= arrayOfe.length)
        break label209;
      i3 = this.r.b(i2);
      locala = this.e[i3];
      if (this.f.a(locala))
        break label98;
      arrayOfe[i2] = com.google.android.exoplayer2.source.b.e.a;
    }
    while (true)
    {
      i2++;
      break label24;
      i1 = this.g.indexOf(paramh.c);
      break;
      label98: com.google.android.exoplayer2.source.c.a.e locale = this.f.a(locala, false);
      long l1 = locale.c - this.f.c();
      if (i3 != i1);
      long l2;
      for (boolean bool = true; ; bool = false)
      {
        l2 = a(paramh, bool, locale, l1, paramLong);
        if (l2 >= locale.f)
          break label181;
        arrayOfe[i2] = com.google.android.exoplayer2.source.b.e.a;
        break;
      }
      label181: arrayOfe[i2] = new c(locale, l1, (int)(l2 - locale.f));
    }
    label209: return arrayOfe;
  }

  public TrackGroup b()
  {
    return this.g;
  }

  public com.google.android.exoplayer2.trackselection.e c()
  {
    return this.r;
  }

  public void d()
  {
    this.k = null;
  }

  private static final class a extends c
  {
    public final String i;
    private byte[] j;

    public a(com.google.android.exoplayer2.f.h paramh, l paraml, Format paramFormat, int paramInt, Object paramObject, byte[] paramArrayOfByte, String paramString)
    {
      super(paraml, 3, paramFormat, paramInt, paramObject, paramArrayOfByte);
      this.i = paramString;
    }

    protected void a(byte[] paramArrayOfByte, int paramInt)
      throws IOException
    {
      this.j = Arrays.copyOf(paramArrayOfByte, paramInt);
    }

    public byte[] h()
    {
      return this.j;
    }
  }

  public static final class b
  {
    public com.google.android.exoplayer2.source.b.b a;
    public boolean b;
    public com.google.android.exoplayer2.source.c.a.d.a c;

    public b()
    {
      a();
    }

    public void a()
    {
      this.a = null;
      this.b = false;
      this.c = null;
    }
  }

  private static final class c extends a
  {
    private final com.google.android.exoplayer2.source.c.a.e b;
    private final long c;

    public c(com.google.android.exoplayer2.source.c.a.e parame, long paramLong, int paramInt)
    {
      super(-1 + parame.l.size());
      this.b = parame;
      this.c = paramLong;
    }
  }

  private static final class d extends com.google.android.exoplayer2.trackselection.b
  {
    private int d = a(paramTrackGroup.getFormat(0));

    public d(TrackGroup paramTrackGroup, int[] paramArrayOfInt)
    {
      super(paramArrayOfInt);
    }

    public int a()
    {
      return this.d;
    }

    public void a(long paramLong1, long paramLong2, long paramLong3, List<? extends com.google.android.exoplayer2.source.b.d> paramList, com.google.android.exoplayer2.source.b.e[] paramArrayOfe)
    {
      long l = SystemClock.elapsedRealtime();
      if (!b(this.d, l))
        return;
      for (int i = -1 + this.b; i >= 0; i--)
        if (!b(i, l))
        {
          this.d = i;
          return;
        }
      throw new IllegalStateException();
    }

    public int b()
    {
      return 0;
    }

    public Object c()
    {
      return null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c.d
 * JD-Core Version:    0.6.2
 */