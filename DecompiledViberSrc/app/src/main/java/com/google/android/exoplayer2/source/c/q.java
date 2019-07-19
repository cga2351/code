package com.google.android.exoplayer2.source.c;

import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.n;
import com.google.android.exoplayer2.extractor.o.b;
import com.google.android.exoplayer2.g.ad;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.w;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class q
  implements g
{
  private static final Pattern a = Pattern.compile("LOCAL:([^,]+)");
  private static final Pattern b = Pattern.compile("MPEGTS:(\\d+)");
  private final String c;
  private final ad d;
  private final r e;
  private i f;
  private byte[] g;
  private int h;

  public q(String paramString, ad paramad)
  {
    this.c = paramString;
    this.d = paramad;
    this.e = new r();
    this.g = new byte[1024];
  }

  private com.google.android.exoplayer2.extractor.q a(long paramLong)
  {
    com.google.android.exoplayer2.extractor.q localq = this.f.a(0, 3);
    localq.a(Format.createTextSampleFormat(null, "text/vtt", null, -1, 0, this.c, null, paramLong));
    this.f.a();
    return localq;
  }

  private void a()
    throws w
  {
    r localr = new r(this.g);
    com.google.android.exoplayer2.e.h.h.a(localr);
    long l1 = 0L;
    long l2 = 0L;
    while (true)
    {
      String str = localr.B();
      if (TextUtils.isEmpty(str))
        break;
      if (str.startsWith("X-TIMESTAMP-MAP"))
      {
        Matcher localMatcher2 = a.matcher(str);
        if (!localMatcher2.find())
          throw new w("X-TIMESTAMP-MAP doesn't contain local timestamp: " + str);
        Matcher localMatcher3 = b.matcher(str);
        if (!localMatcher3.find())
          throw new w("X-TIMESTAMP-MAP doesn't contain media timestamp: " + str);
        l2 = com.google.android.exoplayer2.e.h.h.a(localMatcher2.group(1));
        l1 = ad.d(Long.parseLong(localMatcher3.group(1)));
      }
    }
    Matcher localMatcher1 = com.google.android.exoplayer2.e.h.h.c(localr);
    if (localMatcher1 == null)
    {
      a(0L);
      return;
    }
    long l3 = com.google.android.exoplayer2.e.h.h.a(localMatcher1.group(1));
    long l4 = this.d.b(ad.e(l1 + l3 - l2));
    com.google.android.exoplayer2.extractor.q localq = a(l4 - l3);
    this.e.a(this.g, this.h);
    localq.a(this.e, this.h);
    localq.a(l4, 1, this.h, 0, null);
  }

  public int a(com.google.android.exoplayer2.extractor.h paramh, n paramn)
    throws IOException, InterruptedException
  {
    int i = (int)paramh.d();
    byte[] arrayOfByte;
    if (this.h == this.g.length)
    {
      arrayOfByte = this.g;
      if (i == -1)
        break label107;
    }
    label107: for (int k = i; ; k = this.g.length)
    {
      this.g = Arrays.copyOf(arrayOfByte, k * 3 / 2);
      int j = paramh.a(this.g, this.h, this.g.length - this.h);
      if (j == -1)
        break;
      this.h = (j + this.h);
      if ((i != -1) && (this.h == i))
        break;
      return 0;
    }
    a();
    return -1;
  }

  public void a(long paramLong1, long paramLong2)
  {
    throw new IllegalStateException();
  }

  public void a(i parami)
  {
    this.f = parami;
    parami.a(new o.b(-9223372036854775807L));
  }

  public boolean a(com.google.android.exoplayer2.extractor.h paramh)
    throws IOException, InterruptedException
  {
    paramh.b(this.g, 0, 6, false);
    this.e.a(this.g, 6);
    if (com.google.android.exoplayer2.e.h.h.b(this.e))
      return true;
    paramh.b(this.g, 6, 3, false);
    this.e.a(this.g, 9);
    return com.google.android.exoplayer2.e.h.h.b(this.e);
  }

  public void c()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c.q
 * JD-Core Version:    0.6.2
 */