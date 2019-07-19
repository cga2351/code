package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.r;
import java.util.Collections;
import java.util.List;

public final class i
  implements j
{
  private final List<ae.a> a;
  private final q[] b;
  private boolean c;
  private int d;
  private int e;
  private long f;

  public i(List<ae.a> paramList)
  {
    this.a = paramList;
    this.b = new q[paramList.size()];
  }

  private boolean a(r paramr, int paramInt)
  {
    if (paramr.b() == 0)
      return false;
    if (paramr.h() != paramInt)
      this.c = false;
    this.d = (-1 + this.d);
    return this.c;
  }

  public void a()
  {
    this.c = false;
  }

  public void a(long paramLong, int paramInt)
  {
    if ((paramInt & 0x4) == 0)
      return;
    this.c = true;
    this.f = paramLong;
    this.e = 0;
    this.d = 2;
  }

  public void a(com.google.android.exoplayer2.extractor.i parami, ae.d paramd)
  {
    for (int i = 0; i < this.b.length; i++)
    {
      ae.a locala = (ae.a)this.a.get(i);
      paramd.a();
      q localq = parami.a(paramd.b(), 3);
      localq.a(Format.createImageSampleFormat(paramd.c(), "application/dvbsubs", null, -1, 0, Collections.singletonList(locala.c), locala.a, null));
      this.b[i] = localq;
    }
  }

  public void a(r paramr)
  {
    int i = 0;
    if ((!this.c) || ((this.d == 2) && (!a(paramr, 32))));
    while ((this.d == 1) && (!a(paramr, 0)))
      return;
    int j = paramr.d();
    int k = paramr.b();
    q[] arrayOfq = this.b;
    int m = arrayOfq.length;
    while (i < m)
    {
      q localq = arrayOfq[i];
      paramr.c(j);
      localq.a(paramr, k);
      i++;
    }
    this.e = (k + this.e);
  }

  public void b()
  {
    if (this.c)
    {
      q[] arrayOfq = this.b;
      int i = arrayOfq.length;
      for (int j = 0; j < i; j++)
        arrayOfq[j].a(this.f, 1, this.e, 0, null);
      this.c = false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.f.i
 * JD-Core Version:    0.6.2
 */