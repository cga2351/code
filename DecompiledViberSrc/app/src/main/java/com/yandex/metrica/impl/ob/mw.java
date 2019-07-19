package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.br.a;
import java.util.Collections;
import java.util.List;

public class mw
{
  public final long A;
  public final long B;
  public final boolean C;
  public final String a;
  public final String b;
  public final String c;
  public final List<String> d;
  public final String e;
  public final String f;
  public final String g;
  public final List<String> h;
  public final List<String> i;
  public final List<String> j;
  public final List<String> k;
  public final String l;
  public final String m;
  public final ml n;
  public final hp o;
  public final hk p;
  public final mn q;
  public final String r;
  public final long s;
  public final boolean t;
  public final boolean u;
  public final List<br.a> v;
  public final String w;
  public final my x;
  public final List<iy> y;
  public final mm z;

  private mw(a parama)
  {
    this.a = parama.a;
    this.b = parama.b;
    this.c = parama.c;
    List localList1;
    List localList2;
    label75: List localList3;
    label90: List localList4;
    label106: List localList5;
    label122: List localList7;
    if (parama.d == null)
    {
      localList1 = null;
      this.d = localList1;
      this.e = parama.e;
      this.f = parama.f;
      this.g = parama.g;
      if (parama.h != null)
        break label296;
      localList2 = null;
      this.h = localList2;
      if (parama.i != null)
        break label307;
      localList3 = null;
      this.i = localList3;
      if (parama.j != null)
        break label319;
      localList4 = null;
      this.j = localList4;
      if (parama.k != null)
        break label331;
      localList5 = null;
      this.k = localList5;
      this.l = parama.l;
      this.m = parama.m;
      this.n = parama.n;
      this.o = parama.o;
      this.p = parama.p;
      this.q = parama.q;
      this.r = parama.t;
      this.s = parama.r;
      this.t = parama.s;
      this.u = parama.u;
      List localList6 = a.a(parama);
      localList7 = null;
      if (localList6 != null)
        break label343;
    }
    while (true)
    {
      this.v = localList7;
      this.w = a.b(parama);
      this.y = a.c(parama);
      this.z = a.d(parama);
      this.x = parama.v;
      this.A = a.e(parama);
      this.B = a.f(parama);
      this.C = parama.w;
      return;
      localList1 = Collections.unmodifiableList(parama.d);
      break;
      label296: localList2 = Collections.unmodifiableList(parama.h);
      break label75;
      label307: localList3 = Collections.unmodifiableList(parama.i);
      break label90;
      label319: localList4 = Collections.unmodifiableList(parama.j);
      break label106;
      label331: localList5 = Collections.unmodifiableList(parama.k);
      break label122;
      label343: localList7 = Collections.unmodifiableList(a.a(parama));
    }
  }

  public a a()
  {
    return new a(this.n).a(this.a).b(this.b).c(this.c).c(this.i).d(this.j).g(this.l).a(this.d).b(this.h).d(this.e).e(this.f).f(this.g).e(this.k).i(this.r).a(this.o).a(this.p).a(this.q).h(this.m).b(this.u).a(this.s).a(this.t).f(this.v).j(this.w).g(this.y).a(this.z).b(this.A).c(this.B).a(this.x).c(this.C);
  }

  public String toString()
  {
    return "StartupState{uuid='" + this.a + '\'' + ", deviceID='" + this.b + '\'' + ", deviceIDHash='" + this.c + '\'' + ", reportUrls=" + this.d + ", getAdUrl='" + this.e + '\'' + ", reportAdUrl='" + this.f + '\'' + ", sdkListUrl='" + this.g + '\'' + ", locationUrls=" + this.h + ", hostUrlsFromStartup=" + this.i + ", hostUrlsFromClient=" + this.j + ", diagnosticUrls=" + this.k + ", encodedClidsFromResponse='" + this.l + '\'' + ", lastStartupRequestClids='" + this.m + '\'' + ", collectingFlags=" + this.n + ", foregroundLocationCollectionConfig=" + this.o + ", backgroundLocationCollectionConfig=" + this.p + ", socketConfig=" + this.q + ", distributionReferrer='" + this.r + '\'' + ", obtainTime=" + this.s + ", hadFirstStartup=" + this.t + ", startupClidsMatchWithAppClids=" + this.u + ", requests=" + this.v + ", countryInit='" + this.w + '\'' + ", permissions=" + String.valueOf(this.y) + ", sdkFingerprintingConfig=" + this.z + ", obtainServerTime=" + this.A + ", firstStartupServerTime=" + this.B + ", statSending=" + this.x + '}';
  }

  public static class a
  {
    private mm A;
    private long B;
    private long C;
    String a;
    String b;
    String c;
    List<String> d;
    String e;
    String f;
    String g;
    List<String> h;
    List<String> i;
    List<String> j;
    List<String> k;
    String l;
    String m;
    final ml n;
    hp o;
    hk p;
    mn q;
    long r;
    boolean s;
    String t;
    boolean u;
    my v;
    boolean w;
    private List<br.a> x;
    private String y;
    private List<iy> z;

    public a(ml paramml)
    {
      this.n = paramml;
    }

    public a a(long paramLong)
    {
      this.r = paramLong;
      return this;
    }

    public a a(hk paramhk)
    {
      this.p = paramhk;
      return this;
    }

    public a a(hp paramhp)
    {
      this.o = paramhp;
      return this;
    }

    public a a(mm parammm)
    {
      this.A = parammm;
      return this;
    }

    public a a(mn parammn)
    {
      this.q = parammn;
      return this;
    }

    public a a(my parammy)
    {
      this.v = parammy;
      return this;
    }

    public a a(String paramString)
    {
      this.a = paramString;
      return this;
    }

    public a a(List<String> paramList)
    {
      this.d = paramList;
      return this;
    }

    public a a(boolean paramBoolean)
    {
      this.s = paramBoolean;
      return this;
    }

    public mw a()
    {
      return new mw(this, (byte)0);
    }

    public a b(long paramLong)
    {
      this.B = paramLong;
      return this;
    }

    public a b(String paramString)
    {
      this.b = paramString;
      return this;
    }

    public a b(List<String> paramList)
    {
      this.h = paramList;
      return this;
    }

    public a b(boolean paramBoolean)
    {
      this.u = paramBoolean;
      return this;
    }

    public a c(long paramLong)
    {
      this.C = paramLong;
      return this;
    }

    public a c(String paramString)
    {
      this.c = paramString;
      return this;
    }

    public a c(List<String> paramList)
    {
      this.i = paramList;
      return this;
    }

    public a c(boolean paramBoolean)
    {
      this.w = paramBoolean;
      return this;
    }

    public a d(String paramString)
    {
      this.e = paramString;
      return this;
    }

    public a d(List<String> paramList)
    {
      this.j = paramList;
      return this;
    }

    public a e(String paramString)
    {
      this.f = paramString;
      return this;
    }

    public a e(List<String> paramList)
    {
      this.k = paramList;
      return this;
    }

    public a f(String paramString)
    {
      this.g = paramString;
      return this;
    }

    public a f(List<br.a> paramList)
    {
      this.x = paramList;
      return this;
    }

    public a g(String paramString)
    {
      this.l = paramString;
      return this;
    }

    public a g(List<iy> paramList)
    {
      this.z = paramList;
      return this;
    }

    public a h(String paramString)
    {
      this.m = paramString;
      return this;
    }

    public a i(String paramString)
    {
      this.t = paramString;
      return this;
    }

    public a j(String paramString)
    {
      this.y = paramString;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.mw
 * JD-Core Version:    0.6.2
 */