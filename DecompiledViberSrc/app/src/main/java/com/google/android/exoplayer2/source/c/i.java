package com.google.android.exoplayer2.source.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ai;
import com.google.android.exoplayer2.f.ad;
import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.f.y;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.o;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.aa;
import com.google.android.exoplayer2.source.c.a.d.a;
import com.google.android.exoplayer2.source.c.a.i.b;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.m.a;
import com.google.android.exoplayer2.source.o.a;
import com.google.android.exoplayer2.source.z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;

public final class i
  implements i.b, l.a, m
{
  private final f a;
  private final com.google.android.exoplayer2.source.c.a.i b;
  private final e c;
  private final ad d;
  private final y e;
  private final o.a f;
  private final b g;
  private final IdentityHashMap<z, Integer> h;
  private final p i;
  private final com.google.android.exoplayer2.source.e j;
  private final boolean k;
  private m.a l;
  private int m;
  private TrackGroupArray n;
  private l[] o;
  private l[] p;
  private aa q;
  private boolean r;

  public i(f paramf, com.google.android.exoplayer2.source.c.a.i parami, e parame, ad paramad, y paramy, o.a parama, b paramb, com.google.android.exoplayer2.source.e parame1, boolean paramBoolean)
  {
    this.a = paramf;
    this.b = parami;
    this.c = parame;
    this.d = paramad;
    this.e = paramy;
    this.f = parama;
    this.g = paramb;
    this.j = parame1;
    this.k = paramBoolean;
    this.q = parame1.a(new aa[0]);
    this.h = new IdentityHashMap();
    this.i = new p();
    this.o = new l[0];
    this.p = new l[0];
    parama.a();
  }

  private static Format a(Format paramFormat)
  {
    String str1 = ag.a(paramFormat.codecs, 2);
    String str2 = o.f(str1);
    return Format.createVideoContainerFormat(paramFormat.id, paramFormat.label, paramFormat.containerMimeType, str2, str1, paramFormat.bitrate, paramFormat.width, paramFormat.height, paramFormat.frameRate, null, paramFormat.selectionFlags);
  }

  private static Format a(Format paramFormat1, Format paramFormat2, boolean paramBoolean)
  {
    String str1;
    int i1;
    int i2;
    String str3;
    String str2;
    if (paramFormat2 != null)
    {
      str1 = paramFormat2.codecs;
      i1 = paramFormat2.channelCount;
      i2 = paramFormat2.selectionFlags;
      str3 = paramFormat2.language;
      str2 = paramFormat2.label;
    }
    while (true)
    {
      String str4 = o.f(str1);
      if (paramBoolean);
      for (int i3 = paramFormat1.bitrate; ; i3 = -1)
      {
        return Format.createAudioContainerFormat(paramFormat1.id, str2, paramFormat1.containerMimeType, str4, str1, i3, i1, -1, null, i2, str3);
        str1 = ag.a(paramFormat1.codecs, 1);
        if (!paramBoolean)
          break label122;
        i1 = paramFormat1.channelCount;
        i2 = paramFormat1.selectionFlags;
        str3 = paramFormat1.label;
        str2 = paramFormat1.label;
        break;
      }
      label122: i1 = -1;
      str2 = null;
      i2 = 0;
      str3 = null;
    }
  }

  private l a(int paramInt, d.a[] paramArrayOfa, Format paramFormat, List<Format> paramList, long paramLong)
  {
    return new l(paramInt, this, new d(this.a, this.b, paramArrayOfa, this.c, this.d, this.i, paramList), this.g, paramLong, paramFormat, this.e, this.f);
  }

  private void a(com.google.android.exoplayer2.source.c.a.d paramd, long paramLong)
  {
    ArrayList localArrayList1 = new ArrayList(paramd.b);
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    int i1 = 0;
    if (i1 < localArrayList1.size())
    {
      d.a locala = (d.a)localArrayList1.get(i1);
      Format localFormat = locala.b;
      if ((localFormat.height > 0) || (ag.a(localFormat.codecs, 2) != null))
        localArrayList2.add(locala);
      while (true)
      {
        i1++;
        break;
        if (ag.a(localFormat.codecs, 1) != null)
          localArrayList3.add(locala);
      }
    }
    ArrayList localArrayList4;
    boolean bool;
    label149: d.a[] arrayOfa;
    String str;
    l locall;
    int i2;
    if (!localArrayList2.isEmpty())
    {
      localArrayList4 = localArrayList2;
      if (localArrayList4.isEmpty())
        break label335;
      bool = true;
      a.a(bool);
      arrayOfa = (d.a[])localArrayList4.toArray(new d.a[0]);
      str = arrayOfa[0].b.codecs;
      locall = a(0, arrayOfa, paramd.e, paramd.f, paramLong);
      this.o[0] = locall;
      if ((!this.k) || (str == null))
        break label693;
      if (ag.a(str, 2) == null)
        break label341;
      i2 = 1;
      label232: if (ag.a(str, 1) == null)
        break label347;
    }
    ArrayList localArrayList5;
    Format[] arrayOfFormat3;
    label335: label341: label347: for (int i3 = 1; ; i3 = 0)
    {
      localArrayList5 = new ArrayList();
      if (i2 == 0)
        break label507;
      arrayOfFormat3 = new Format[localArrayList4.size()];
      for (int i5 = 0; i5 < arrayOfFormat3.length; i5++)
        arrayOfFormat3[i5] = a(arrayOfa[i5].b);
      if (localArrayList3.size() < localArrayList1.size())
        localArrayList1.removeAll(localArrayList3);
      localArrayList4 = localArrayList1;
      break;
      bool = false;
      break label149;
      i2 = 0;
      break label232;
    }
    localArrayList5.add(new TrackGroup(arrayOfFormat3));
    if ((i3 != 0) && ((paramd.e != null) || (paramd.c.isEmpty())))
    {
      Format[] arrayOfFormat5 = new Format[1];
      arrayOfFormat5[0] = a(arrayOfa[0].b, paramd.e, false);
      localArrayList5.add(new TrackGroup(arrayOfFormat5));
    }
    List localList = paramd.f;
    if (localList != null)
    {
      for (int i6 = 0; i6 < localList.size(); i6++)
      {
        Format[] arrayOfFormat4 = new Format[1];
        arrayOfFormat4[0] = ((Format)localList.get(i6));
        localArrayList5.add(new TrackGroup(arrayOfFormat4));
      }
      label507: if (i3 != 0)
      {
        Format[] arrayOfFormat1 = new Format[localArrayList4.size()];
        for (int i4 = 0; i4 < arrayOfFormat1.length; i4++)
          arrayOfFormat1[i4] = a(arrayOfa[i4].b, paramd.e, true);
        localArrayList5.add(new TrackGroup(arrayOfFormat1));
      }
    }
    else
    {
      Format[] arrayOfFormat2 = new Format[1];
      arrayOfFormat2[0] = Format.createSampleFormat("ID3", "application/id3", null, -1, null);
      TrackGroup localTrackGroup = new TrackGroup(arrayOfFormat2);
      localArrayList5.add(localTrackGroup);
      locall.a(new TrackGroupArray((TrackGroup[])localArrayList5.toArray(new TrackGroup[0])), 0, new TrackGroupArray(new TrackGroup[] { localTrackGroup }));
      return;
    }
    throw new IllegalArgumentException("Unexpected codecs attribute: " + str);
    label693: locall.a(true);
    locall.b();
  }

  private void d(long paramLong)
  {
    com.google.android.exoplayer2.source.c.a.d locald = this.b.b();
    List localList1 = locald.c;
    List localList2 = locald.d;
    int i1 = 1 + localList1.size() + localList2.size();
    this.o = new l[i1];
    this.m = i1;
    a(locald, paramLong);
    int i2 = 0;
    int i3 = 1;
    if (i2 < localList1.size())
    {
      d.a locala2 = (d.a)localList1.get(i2);
      l locall2 = a(1, new d.a[] { locala2 }, null, Collections.emptyList(), paramLong);
      l[] arrayOfl2 = this.o;
      int i6 = i3 + 1;
      arrayOfl2[i3] = locall2;
      Format localFormat = locala2.b;
      if ((this.k) && (localFormat.codecs != null))
      {
        TrackGroup[] arrayOfTrackGroup2 = new TrackGroup[1];
        Format[] arrayOfFormat2 = new Format[1];
        arrayOfFormat2[0] = locala2.b;
        arrayOfTrackGroup2[0] = new TrackGroup(arrayOfFormat2);
        locall2.a(new TrackGroupArray(arrayOfTrackGroup2), 0, TrackGroupArray.EMPTY);
      }
      while (true)
      {
        i2++;
        i3 = i6;
        break;
        locall2.b();
      }
    }
    int i4 = 0;
    while (i4 < localList2.size())
    {
      d.a locala1 = (d.a)localList2.get(i4);
      l locall1 = a(3, new d.a[] { locala1 }, null, Collections.emptyList(), paramLong);
      l[] arrayOfl1 = this.o;
      int i5 = i3 + 1;
      arrayOfl1[i3] = locall1;
      TrackGroup[] arrayOfTrackGroup1 = new TrackGroup[1];
      Format[] arrayOfFormat1 = new Format[1];
      arrayOfFormat1[0] = locala1.b;
      arrayOfTrackGroup1[0] = new TrackGroup(arrayOfFormat1);
      locall1.a(new TrackGroupArray(arrayOfTrackGroup1), 0, TrackGroupArray.EMPTY);
      i4++;
      i3 = i5;
    }
    this.p = this.o;
  }

  public long a(long paramLong, ai paramai)
  {
    return paramLong;
  }

  public long a(com.google.android.exoplayer2.trackselection.e[] paramArrayOfe, boolean[] paramArrayOfBoolean1, z[] paramArrayOfz, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    int[] arrayOfInt1 = new int[paramArrayOfe.length];
    int[] arrayOfInt2 = new int[paramArrayOfe.length];
    int i1 = 0;
    if (i1 < paramArrayOfe.length)
    {
      int i9;
      label32: TrackGroup localTrackGroup;
      if (paramArrayOfz[i1] == null)
      {
        i9 = -1;
        arrayOfInt1[i1] = i9;
        arrayOfInt2[i1] = -1;
        if (paramArrayOfe[i1] != null)
          localTrackGroup = paramArrayOfe[i1].f();
      }
      for (int i10 = 0; ; i10++)
        if (i10 < this.o.length)
        {
          if (this.o[i10].f().indexOf(localTrackGroup) != -1)
            arrayOfInt2[i1] = i10;
        }
        else
        {
          i1++;
          break;
          i9 = ((Integer)this.h.get(paramArrayOfz[i1])).intValue();
          break label32;
        }
    }
    boolean bool1 = false;
    this.h.clear();
    z[] arrayOfz1 = new z[paramArrayOfe.length];
    z[] arrayOfz2 = new z[paramArrayOfe.length];
    com.google.android.exoplayer2.trackselection.e[] arrayOfe = new com.google.android.exoplayer2.trackselection.e[paramArrayOfe.length];
    l[] arrayOfl = new l[this.o.length];
    int i2 = 0;
    int i3 = 0;
    label219: l locall;
    label261: int i8;
    int i7;
    if (i2 < this.o.length)
    {
      int i4 = 0;
      if (i4 < paramArrayOfe.length)
      {
        z localz;
        if (arrayOfInt1[i4] == i2)
        {
          localz = paramArrayOfz[i4];
          arrayOfz2[i4] = localz;
          if (arrayOfInt2[i4] != i2)
            break label261;
        }
        for (com.google.android.exoplayer2.trackselection.e locale = paramArrayOfe[i4]; ; locale = null)
        {
          arrayOfe[i4] = locale;
          i4++;
          break;
          localz = null;
          break label219;
        }
      }
      locall = this.o[i2];
      boolean bool2 = locall.a(arrayOfe, paramArrayOfBoolean1, arrayOfz2, paramArrayOfBoolean2, paramLong, bool1);
      int i5 = 0;
      int i6 = 0;
      if (i6 < paramArrayOfe.length)
      {
        if (arrayOfInt2[i6] == i2)
          if (arrayOfz2[i6] != null)
          {
            bool4 = true;
            a.b(bool4);
            arrayOfz1[i6] = arrayOfz2[i6];
            i5 = 1;
            this.h.put(arrayOfz2[i6], Integer.valueOf(i2));
          }
        while (arrayOfInt1[i6] != i2)
          while (true)
          {
            i6++;
            break;
            boolean bool4 = false;
          }
        if (arrayOfz2[i6] == null);
        for (boolean bool3 = true; ; bool3 = false)
        {
          a.b(bool3);
          break;
        }
      }
      if (i5 == 0)
        break label546;
      arrayOfl[i3] = locall;
      i8 = i3 + 1;
      if (i3 == 0)
      {
        locall.a(true);
        if ((!bool2) && (this.p.length != 0) && (locall == this.p[0]))
          break label494;
        this.i.a();
        bool1 = true;
        i7 = i8;
      }
    }
    while (true)
    {
      i2++;
      i3 = i7;
      break;
      locall.a(false);
      label494: i7 = i8;
      continue;
      System.arraycopy(arrayOfz1, 0, paramArrayOfz, 0, arrayOfz1.length);
      this.p = ((l[])Arrays.copyOf(arrayOfl, i3));
      this.q = this.j.a(this.p);
      return paramLong;
      label546: i7 = i3;
    }
  }

  public void a(long paramLong)
  {
    this.q.a(paramLong);
  }

  public void a(long paramLong, boolean paramBoolean)
  {
    l[] arrayOfl = this.p;
    int i1 = arrayOfl.length;
    for (int i2 = 0; i2 < i1; i2++)
      arrayOfl[i2].a(paramLong, paramBoolean);
  }

  public void a(d.a parama)
  {
    this.b.c(parama);
  }

  public void a(l paraml)
  {
    this.l.a(this);
  }

  public void a(m.a parama, long paramLong)
  {
    this.l = parama;
    this.b.a(this);
    d(paramLong);
  }

  public boolean a(d.a parama, long paramLong)
  {
    boolean bool = true;
    l[] arrayOfl = this.o;
    int i1 = arrayOfl.length;
    for (int i2 = 0; i2 < i1; i2++)
      bool &= arrayOfl[i2].a(parama, paramLong);
    this.l.a(this);
    return bool;
  }

  public long b(long paramLong)
  {
    if (this.p.length > 0)
    {
      boolean bool = this.p[0].b(paramLong, false);
      for (int i1 = 1; i1 < this.p.length; i1++)
        this.p[i1].b(paramLong, bool);
      if (bool)
        this.i.a();
    }
    return paramLong;
  }

  public TrackGroupArray b()
  {
    return this.n;
  }

  public long c()
  {
    if (!this.r)
    {
      this.f.c();
      this.r = true;
    }
    return -9223372036854775807L;
  }

  public boolean c(long paramLong)
  {
    if (this.n == null)
    {
      l[] arrayOfl = this.o;
      int i1 = arrayOfl.length;
      for (int i2 = 0; ; i2++)
      {
        bool = false;
        if (i2 >= i1)
          break;
        arrayOfl[i2].b();
      }
    }
    boolean bool = this.q.c(paramLong);
    return bool;
  }

  public long d()
  {
    return this.q.d();
  }

  public long e()
  {
    return this.q.e();
  }

  public void f()
  {
    this.b.b(this);
    l[] arrayOfl = this.o;
    int i1 = arrayOfl.length;
    for (int i2 = 0; i2 < i1; i2++)
      arrayOfl[i2].h();
    this.l = null;
    this.f.b();
  }

  public void g()
  {
    int i1 = -1 + this.m;
    this.m = i1;
    if (i1 > 0)
      return;
    l[] arrayOfl1 = this.o;
    int i2 = arrayOfl1.length;
    int i3 = 0;
    int i4 = 0;
    while (i3 < i2)
    {
      i4 += arrayOfl1[i3].f().length;
      i3++;
    }
    TrackGroup[] arrayOfTrackGroup = new TrackGroup[i4];
    l[] arrayOfl2 = this.o;
    int i5 = arrayOfl2.length;
    int i6 = 0;
    int i9;
    for (int i7 = 0; i6 < i5; i7 = i9)
    {
      l locall = arrayOfl2[i6];
      int i8 = locall.f().length;
      i9 = i7;
      int i10 = 0;
      while (i10 < i8)
      {
        int i11 = i9 + 1;
        arrayOfTrackGroup[i9] = locall.f().get(i10);
        i10++;
        i9 = i11;
      }
      i6++;
    }
    this.n = new TrackGroupArray(arrayOfTrackGroup);
    this.l.a(this);
  }

  public void h()
  {
    this.l.a(this);
  }

  public void i_()
    throws IOException
  {
    l[] arrayOfl = this.o;
    int i1 = arrayOfl.length;
    for (int i2 = 0; i2 < i1; i2++)
      arrayOfl[i2].c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c.i
 * JD-Core Version:    0.6.2
 */