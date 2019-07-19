package com.google.android.exoplayer2.f;

import android.content.Context;
import android.os.Handler;
import android.util.SparseArray;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.b;
import com.google.android.exoplayer2.g.w;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class n
  implements ad, d
{
  public static final Map<String, int[]> a = c();
  public static final long[] b = { 5700000L, 3400000L, 1900000L, 1000000L, 400000L };
  public static final long[] c = { 169000L, 129000L, 114000L, 102000L, 87000L };
  public static final long[] d = { 2100000L, 1300000L, 950000L, 700000L, 400000L };
  public static final long[] e = { 6900000L, 4300000L, 2700000L, 1600000L, 450000L };
  private final com.google.android.exoplayer2.g.h<d.a> f = new com.google.android.exoplayer2.g.h();
  private final w g;
  private final b h;
  private int i;
  private long j;
  private long k;
  private long l;
  private long m;
  private long n;

  public n()
  {
    this(1000000L, 2000, b.a);
  }

  private n(long paramLong, int paramInt, b paramb)
  {
    this.g = new w(paramInt);
    this.h = paramb;
    this.n = paramLong;
  }

  private void a(int paramInt, long paramLong1, long paramLong2)
  {
    this.f.a(new o(paramInt, paramLong1, paramLong2));
  }

  private static Map<String, int[]> c()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("AD", new int[] { 1, 0, 0, 0 });
    localHashMap.put("AE", new int[] { 1, 3, 4, 4 });
    localHashMap.put("AF", new int[] { 4, 4, 3, 2 });
    localHashMap.put("AG", new int[] { 3, 2, 1, 2 });
    localHashMap.put("AI", new int[] { 1, 0, 0, 2 });
    localHashMap.put("AL", new int[] { 1, 1, 1, 1 });
    localHashMap.put("AM", new int[] { 2, 2, 4, 3 });
    localHashMap.put("AO", new int[] { 2, 4, 2, 0 });
    localHashMap.put("AR", new int[] { 2, 3, 2, 3 });
    localHashMap.put("AS", new int[] { 3, 4, 4, 1 });
    localHashMap.put("AT", new int[] { 0, 1, 0, 0 });
    localHashMap.put("AU", new int[] { 0, 3, 0, 0 });
    localHashMap.put("AW", new int[] { 1, 1, 0, 4 });
    localHashMap.put("AX", new int[] { 0, 1, 0, 0 });
    localHashMap.put("AZ", new int[] { 3, 3, 2, 2 });
    localHashMap.put("BA", new int[] { 1, 1, 1, 2 });
    localHashMap.put("BB", new int[] { 0, 1, 0, 0 });
    localHashMap.put("BD", new int[] { 2, 1, 3, 2 });
    localHashMap.put("BE", new int[] { 0, 0, 0, 0 });
    localHashMap.put("BF", new int[] { 4, 4, 4, 1 });
    localHashMap.put("BG", new int[] { 0, 0, 0, 1 });
    localHashMap.put("BH", new int[] { 2, 1, 3, 4 });
    localHashMap.put("BI", new int[] { 4, 3, 4, 4 });
    localHashMap.put("BJ", new int[] { 4, 3, 4, 3 });
    localHashMap.put("BL", new int[] { 1, 0, 1, 2 });
    localHashMap.put("BM", new int[] { 1, 0, 0, 0 });
    localHashMap.put("BN", new int[] { 4, 3, 3, 3 });
    localHashMap.put("BO", new int[] { 2, 2, 1, 2 });
    localHashMap.put("BQ", new int[] { 1, 1, 2, 4 });
    localHashMap.put("BR", new int[] { 2, 3, 2, 2 });
    localHashMap.put("BS", new int[] { 1, 1, 0, 2 });
    localHashMap.put("BT", new int[] { 3, 0, 2, 1 });
    localHashMap.put("BW", new int[] { 4, 4, 2, 3 });
    localHashMap.put("BY", new int[] { 1, 1, 1, 1 });
    localHashMap.put("BZ", new int[] { 2, 3, 3, 1 });
    localHashMap.put("CA", new int[] { 0, 2, 2, 3 });
    localHashMap.put("CD", new int[] { 4, 4, 2, 1 });
    localHashMap.put("CF", new int[] { 4, 4, 3, 3 });
    localHashMap.put("CG", new int[] { 4, 4, 4, 4 });
    localHashMap.put("CH", new int[] { 0, 0, 0, 0 });
    localHashMap.put("CI", new int[] { 4, 4, 4, 4 });
    localHashMap.put("CK", new int[] { 2, 4, 2, 0 });
    localHashMap.put("CL", new int[] { 2, 2, 2, 3 });
    localHashMap.put("CM", new int[] { 3, 4, 3, 1 });
    localHashMap.put("CN", new int[] { 2, 0, 1, 2 });
    localHashMap.put("CO", new int[] { 2, 3, 2, 1 });
    localHashMap.put("CR", new int[] { 2, 2, 4, 4 });
    localHashMap.put("CU", new int[] { 4, 4, 4, 1 });
    localHashMap.put("CV", new int[] { 2, 2, 2, 4 });
    localHashMap.put("CW", new int[] { 1, 1, 0, 0 });
    localHashMap.put("CX", new int[] { 1, 2, 2, 2 });
    localHashMap.put("CY", new int[] { 1, 1, 0, 0 });
    localHashMap.put("CZ", new int[] { 0, 1, 0, 0 });
    localHashMap.put("DE", new int[] { 0, 2, 2, 2 });
    localHashMap.put("DJ", new int[] { 3, 4, 4, 0 });
    localHashMap.put("DK", new int[] { 0, 0, 0, 0 });
    localHashMap.put("DM", new int[] { 2, 0, 3, 4 });
    localHashMap.put("DO", new int[] { 3, 3, 4, 4 });
    localHashMap.put("DZ", new int[] { 3, 3, 4, 4 });
    localHashMap.put("EC", new int[] { 2, 3, 3, 1 });
    localHashMap.put("EE", new int[] { 0, 0, 0, 0 });
    localHashMap.put("EG", new int[] { 3, 3, 1, 1 });
    localHashMap.put("EH", new int[] { 2, 0, 2, 3 });
    localHashMap.put("ER", new int[] { 4, 2, 2, 2 });
    localHashMap.put("ES", new int[] { 0, 0, 1, 1 });
    localHashMap.put("ET", new int[] { 4, 4, 4, 0 });
    localHashMap.put("FI", new int[] { 0, 0, 1, 0 });
    localHashMap.put("FJ", new int[] { 3, 2, 3, 3 });
    localHashMap.put("FK", new int[] { 3, 4, 2, 1 });
    localHashMap.put("FM", new int[] { 4, 2, 4, 0 });
    localHashMap.put("FO", new int[] { 0, 0, 0, 1 });
    localHashMap.put("FR", new int[] { 1, 0, 2, 1 });
    localHashMap.put("GA", new int[] { 3, 3, 2, 1 });
    localHashMap.put("GB", new int[] { 0, 1, 3, 2 });
    localHashMap.put("GD", new int[] { 2, 0, 3, 0 });
    localHashMap.put("GE", new int[] { 1, 1, 0, 3 });
    localHashMap.put("GF", new int[] { 1, 2, 4, 4 });
    localHashMap.put("GG", new int[] { 0, 1, 0, 0 });
    localHashMap.put("GH", new int[] { 3, 2, 2, 2 });
    localHashMap.put("GI", new int[] { 0, 0, 0, 1 });
    localHashMap.put("GL", new int[] { 2, 4, 1, 4 });
    localHashMap.put("GM", new int[] { 4, 3, 3, 0 });
    localHashMap.put("GN", new int[] { 4, 4, 3, 4 });
    localHashMap.put("GP", new int[] { 2, 2, 1, 3 });
    localHashMap.put("GQ", new int[] { 4, 4, 3, 1 });
    localHashMap.put("GR", new int[] { 1, 1, 0, 1 });
    localHashMap.put("GT", new int[] { 3, 2, 3, 4 });
    localHashMap.put("GU", new int[] { 1, 0, 4, 4 });
    localHashMap.put("GW", new int[] { 4, 4, 4, 0 });
    localHashMap.put("GY", new int[] { 3, 4, 1, 0 });
    localHashMap.put("HK", new int[] { 0, 2, 3, 4 });
    localHashMap.put("HN", new int[] { 3, 3, 2, 2 });
    localHashMap.put("HR", new int[] { 1, 0, 0, 2 });
    localHashMap.put("HT", new int[] { 3, 3, 3, 3 });
    localHashMap.put("HU", new int[] { 0, 0, 1, 0 });
    localHashMap.put("ID", new int[] { 2, 3, 3, 4 });
    localHashMap.put("IE", new int[] { 0, 0, 1, 1 });
    localHashMap.put("IL", new int[] { 0, 1, 1, 3 });
    localHashMap.put("IM", new int[] { 0, 1, 0, 1 });
    localHashMap.put("IN", new int[] { 2, 3, 3, 4 });
    localHashMap.put("IO", new int[] { 4, 2, 2, 2 });
    localHashMap.put("IQ", new int[] { 3, 3, 4, 3 });
    localHashMap.put("IR", new int[] { 3, 2, 4, 4 });
    localHashMap.put("IS", new int[] { 0, 0, 0, 0 });
    localHashMap.put("IT", new int[] { 1, 0, 1, 3 });
    localHashMap.put("JE", new int[] { 0, 0, 0, 1 });
    localHashMap.put("JM", new int[] { 3, 3, 3, 2 });
    localHashMap.put("JO", new int[] { 1, 1, 1, 2 });
    localHashMap.put("JP", new int[] { 0, 1, 1, 2 });
    localHashMap.put("KE", new int[] { 3, 3, 3, 3 });
    localHashMap.put("KG", new int[] { 2, 2, 3, 3 });
    localHashMap.put("KH", new int[] { 1, 0, 4, 4 });
    localHashMap.put("KI", new int[] { 4, 4, 4, 4 });
    localHashMap.put("KM", new int[] { 4, 4, 2, 2 });
    localHashMap.put("KN", new int[] { 1, 0, 1, 3 });
    localHashMap.put("KP", new int[] { 1, 2, 2, 2 });
    localHashMap.put("KR", new int[] { 0, 4, 0, 2 });
    localHashMap.put("KW", new int[] { 1, 2, 1, 2 });
    localHashMap.put("KY", new int[] { 1, 1, 0, 2 });
    localHashMap.put("KZ", new int[] { 1, 2, 2, 3 });
    localHashMap.put("LA", new int[] { 3, 2, 2, 2 });
    localHashMap.put("LB", new int[] { 3, 2, 0, 0 });
    localHashMap.put("LC", new int[] { 2, 2, 1, 0 });
    localHashMap.put("LI", new int[] { 0, 0, 1, 2 });
    localHashMap.put("LK", new int[] { 1, 1, 2, 2 });
    localHashMap.put("LR", new int[] { 3, 4, 3, 1 });
    localHashMap.put("LS", new int[] { 3, 3, 2, 0 });
    localHashMap.put("LT", new int[] { 0, 0, 0, 1 });
    localHashMap.put("LU", new int[] { 0, 0, 1, 0 });
    localHashMap.put("LV", new int[] { 0, 0, 0, 0 });
    localHashMap.put("LY", new int[] { 4, 4, 4, 4 });
    localHashMap.put("MA", new int[] { 2, 1, 2, 2 });
    localHashMap.put("MC", new int[] { 1, 0, 1, 0 });
    localHashMap.put("MD", new int[] { 1, 1, 0, 0 });
    localHashMap.put("ME", new int[] { 1, 2, 2, 3 });
    localHashMap.put("MF", new int[] { 1, 4, 3, 3 });
    localHashMap.put("MG", new int[] { 3, 4, 1, 2 });
    localHashMap.put("MH", new int[] { 4, 0, 2, 3 });
    localHashMap.put("MK", new int[] { 1, 0, 0, 1 });
    localHashMap.put("ML", new int[] { 4, 4, 4, 4 });
    localHashMap.put("MM", new int[] { 2, 3, 1, 2 });
    localHashMap.put("MN", new int[] { 2, 2, 2, 4 });
    localHashMap.put("MO", new int[] { 0, 1, 4, 4 });
    localHashMap.put("MP", new int[] { 0, 0, 4, 4 });
    localHashMap.put("MQ", new int[] { 1, 1, 1, 3 });
    localHashMap.put("MR", new int[] { 4, 2, 4, 2 });
    localHashMap.put("MS", new int[] { 1, 2, 1, 2 });
    localHashMap.put("MT", new int[] { 0, 0, 0, 0 });
    localHashMap.put("MU", new int[] { 2, 2, 4, 4 });
    localHashMap.put("MV", new int[] { 4, 2, 0, 1 });
    localHashMap.put("MW", new int[] { 3, 2, 1, 1 });
    localHashMap.put("MX", new int[] { 2, 4, 3, 1 });
    localHashMap.put("MY", new int[] { 2, 3, 3, 3 });
    localHashMap.put("MZ", new int[] { 3, 3, 2, 4 });
    localHashMap.put("NA", new int[] { 4, 2, 1, 1 });
    localHashMap.put("NC", new int[] { 2, 1, 3, 3 });
    localHashMap.put("NE", new int[] { 4, 4, 4, 4 });
    localHashMap.put("NF", new int[] { 0, 2, 2, 2 });
    localHashMap.put("NG", new int[] { 3, 4, 2, 2 });
    localHashMap.put("NI", new int[] { 3, 4, 3, 3 });
    localHashMap.put("NL", new int[] { 0, 1, 3, 2 });
    localHashMap.put("NO", new int[] { 0, 0, 1, 0 });
    localHashMap.put("NP", new int[] { 2, 3, 2, 2 });
    localHashMap.put("NR", new int[] { 4, 3, 4, 1 });
    localHashMap.put("NU", new int[] { 4, 2, 2, 2 });
    localHashMap.put("NZ", new int[] { 0, 0, 0, 1 });
    localHashMap.put("OM", new int[] { 2, 2, 1, 3 });
    localHashMap.put("PA", new int[] { 1, 3, 2, 3 });
    localHashMap.put("PE", new int[] { 2, 2, 4, 4 });
    localHashMap.put("PF", new int[] { 2, 2, 0, 1 });
    localHashMap.put("PG", new int[] { 4, 4, 4, 4 });
    localHashMap.put("PH", new int[] { 3, 0, 4, 4 });
    localHashMap.put("PK", new int[] { 3, 3, 3, 3 });
    localHashMap.put("PL", new int[] { 1, 0, 1, 3 });
    localHashMap.put("PM", new int[] { 0, 2, 2, 3 });
    localHashMap.put("PR", new int[] { 2, 3, 4, 3 });
    localHashMap.put("PS", new int[] { 2, 3, 0, 4 });
    localHashMap.put("PT", new int[] { 1, 1, 1, 1 });
    localHashMap.put("PW", new int[] { 3, 2, 3, 0 });
    localHashMap.put("PY", new int[] { 2, 1, 3, 3 });
    localHashMap.put("QA", new int[] { 2, 3, 1, 2 });
    localHashMap.put("RE", new int[] { 1, 1, 2, 2 });
    localHashMap.put("RO", new int[] { 0, 1, 1, 3 });
    localHashMap.put("RS", new int[] { 1, 1, 0, 0 });
    localHashMap.put("RU", new int[] { 0, 1, 1, 1 });
    localHashMap.put("RW", new int[] { 3, 4, 3, 1 });
    localHashMap.put("SA", new int[] { 3, 2, 2, 3 });
    localHashMap.put("SB", new int[] { 4, 4, 3, 0 });
    localHashMap.put("SC", new int[] { 4, 2, 0, 1 });
    localHashMap.put("SD", new int[] { 3, 4, 4, 4 });
    localHashMap.put("SE", new int[] { 0, 0, 0, 0 });
    localHashMap.put("SG", new int[] { 1, 2, 3, 3 });
    localHashMap.put("SH", new int[] { 4, 2, 2, 2 });
    localHashMap.put("SI", new int[] { 0, 1, 0, 0 });
    localHashMap.put("SJ", new int[] { 3, 2, 0, 2 });
    localHashMap.put("SK", new int[] { 0, 1, 0, 1 });
    localHashMap.put("SL", new int[] { 4, 3, 2, 4 });
    localHashMap.put("SM", new int[] { 1, 0, 1, 1 });
    localHashMap.put("SN", new int[] { 4, 4, 4, 2 });
    localHashMap.put("SO", new int[] { 4, 4, 4, 3 });
    localHashMap.put("SR", new int[] { 3, 2, 2, 3 });
    localHashMap.put("SS", new int[] { 4, 3, 4, 2 });
    localHashMap.put("ST", new int[] { 3, 2, 2, 2 });
    localHashMap.put("SV", new int[] { 2, 3, 2, 3 });
    localHashMap.put("SX", new int[] { 2, 4, 2, 0 });
    localHashMap.put("SY", new int[] { 4, 4, 2, 0 });
    localHashMap.put("SZ", new int[] { 3, 4, 1, 1 });
    localHashMap.put("TC", new int[] { 2, 1, 2, 1 });
    localHashMap.put("TD", new int[] { 4, 4, 4, 3 });
    localHashMap.put("TG", new int[] { 3, 2, 2, 0 });
    localHashMap.put("TH", new int[] { 1, 3, 4, 4 });
    localHashMap.put("TJ", new int[] { 4, 4, 4, 4 });
    localHashMap.put("TL", new int[] { 4, 2, 4, 4 });
    localHashMap.put("TM", new int[] { 4, 1, 3, 3 });
    localHashMap.put("TN", new int[] { 2, 2, 1, 2 });
    localHashMap.put("TO", new int[] { 2, 3, 3, 1 });
    localHashMap.put("TR", new int[] { 1, 2, 0, 2 });
    localHashMap.put("TT", new int[] { 2, 1, 1, 0 });
    localHashMap.put("TV", new int[] { 4, 2, 2, 4 });
    localHashMap.put("TW", new int[] { 0, 0, 0, 1 });
    localHashMap.put("TZ", new int[] { 3, 3, 3, 2 });
    localHashMap.put("UA", new int[] { 0, 2, 1, 3 });
    localHashMap.put("UG", new int[] { 4, 3, 2, 2 });
    localHashMap.put("US", new int[] { 0, 1, 3, 3 });
    localHashMap.put("UY", new int[] { 2, 1, 2, 2 });
    localHashMap.put("UZ", new int[] { 4, 3, 2, 4 });
    localHashMap.put("VA", new int[] { 1, 2, 2, 2 });
    localHashMap.put("VC", new int[] { 2, 0, 3, 2 });
    localHashMap.put("VE", new int[] { 3, 4, 4, 3 });
    localHashMap.put("VG", new int[] { 3, 1, 3, 4 });
    localHashMap.put("VI", new int[] { 1, 0, 2, 4 });
    localHashMap.put("VN", new int[] { 0, 2, 4, 4 });
    localHashMap.put("VU", new int[] { 4, 1, 3, 2 });
    localHashMap.put("WS", new int[] { 3, 2, 3, 0 });
    localHashMap.put("XK", new int[] { 1, 2, 1, 0 });
    localHashMap.put("YE", new int[] { 4, 4, 4, 2 });
    localHashMap.put("YT", new int[] { 3, 1, 1, 2 });
    localHashMap.put("ZA", new int[] { 2, 3, 1, 2 });
    localHashMap.put("ZM", new int[] { 3, 3, 3, 1 });
    localHashMap.put("ZW", new int[] { 3, 3, 2, 1 });
    return Collections.unmodifiableMap(localHashMap);
  }

  public long a()
  {
    try
    {
      long l1 = this.n;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(Handler paramHandler, d.a parama)
  {
    this.f.a(paramHandler, parama);
  }

  public void a(d.a parama)
  {
    this.f.a(parama);
  }

  public void a(h paramh, l paraml, boolean paramBoolean)
  {
  }

  public void a(h paramh, l paraml, boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean);
    while (true)
    {
      return;
      try
      {
        this.k += paramInt;
      }
      finally
      {
      }
    }
  }

  public ad b()
  {
    return this;
  }

  public void b(h paramh, l paraml, boolean paramBoolean)
  {
    if (!paramBoolean);
    while (true)
    {
      return;
      try
      {
        if (this.i == 0)
          this.j = this.h.a();
        this.i = (1 + this.i);
      }
      finally
      {
      }
    }
  }

  public void c(h paramh, l paraml, boolean paramBoolean)
  {
    if (!paramBoolean)
      return;
    while (true)
    {
      try
      {
        if (this.i > 0)
        {
          bool = true;
          a.b(bool);
          long l1 = this.h.a();
          int i1 = (int)(l1 - this.j);
          this.l += i1;
          this.m += this.k;
          if (i1 > 0)
          {
            float f1 = (float)(8000L * this.k / i1);
            this.g.a((int)Math.sqrt(this.k), f1);
            if ((this.l >= 2000L) || (this.m >= 524288L))
              this.n = (()this.g.a(0.5F));
          }
          a(i1, this.k, this.n);
          int i2 = -1 + this.i;
          this.i = i2;
          if (i2 > 0)
            this.j = l1;
          this.k = 0L;
          break;
        }
      }
      finally
      {
      }
      boolean bool = false;
    }
  }

  public static final class a
  {
    private final Context a;
    private Handler b;
    private d.a c;
    private SparseArray<Long> d;
    private int e;
    private b f;

    @Deprecated
    public a()
    {
      this(null);
    }

    public a(Context paramContext)
    {
      if (paramContext == null);
      for (Context localContext = null; ; localContext = paramContext.getApplicationContext())
      {
        this.a = localContext;
        this.d = a(ag.b(paramContext));
        this.e = 2000;
        this.f = b.a;
        return;
      }
    }

    private static SparseArray<Long> a(String paramString)
    {
      int[] arrayOfInt = b(paramString);
      SparseArray localSparseArray = new SparseArray(6);
      localSparseArray.append(0, Long.valueOf(1000000L));
      localSparseArray.append(2, Long.valueOf(n.b[arrayOfInt[0]]));
      localSparseArray.append(3, Long.valueOf(n.c[arrayOfInt[1]]));
      localSparseArray.append(4, Long.valueOf(n.d[arrayOfInt[2]]));
      localSparseArray.append(5, Long.valueOf(n.e[arrayOfInt[3]]));
      localSparseArray.append(7, Long.valueOf(n.b[arrayOfInt[0]]));
      return localSparseArray;
    }

    private static int[] b(String paramString)
    {
      int[] arrayOfInt = (int[])n.a.get(paramString);
      if (arrayOfInt == null)
      {
        arrayOfInt = new int[4];
        arrayOfInt[0] = 2;
        arrayOfInt[1] = 2;
        arrayOfInt[2] = 2;
        arrayOfInt[3] = 2;
      }
      return arrayOfInt;
    }

    public n a()
    {
      Long localLong = (Long)this.d.get(ag.a(this.a));
      if (localLong == null)
        localLong = (Long)this.d.get(0);
      n localn = new n(localLong.longValue(), this.e, this.f, null);
      if ((this.b != null) && (this.c != null))
        localn.a(this.b, this.c);
      return localn;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.f.n
 * JD-Core Version:    0.6.2
 */