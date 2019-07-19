package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.impl.bw;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ls extends lp
{
  private List<String> a;
  private List<String> b;
  private String c;
  private Map<String, String> d;
  private List<String> e;
  private boolean f;
  private boolean g;
  private String h;
  private long i = 0L;

  public long D()
  {
    return this.i;
  }

  public List<String> E()
  {
    return this.b;
  }

  public Map<String, String> F()
  {
    return this.d;
  }

  public String G()
  {
    return this.c;
  }

  public List<String> H()
  {
    return this.e;
  }

  public boolean I()
  {
    return this.f;
  }

  public String J()
  {
    return this.h;
  }

  public List<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (!bw.a(this.a))
      localArrayList.addAll(this.a);
    if (!bw.a(this.b))
      localArrayList.addAll(this.b);
    localArrayList.add("https://startup.mobile.yandex.net/");
    return localArrayList;
  }

  void a(long paramLong)
  {
    if (this.i == 0L)
      this.i = paramLong;
  }

  public void a(String paramString)
  {
    this.h = paramString;
  }

  void a(List<String> paramList)
  {
    this.b = paramList;
  }

  void a(Map<String, String> paramMap)
  {
    this.d = paramMap;
  }

  void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }

  public long b(long paramLong)
  {
    a(paramLong);
    return D();
  }

  void b(List<String> paramList)
  {
    this.a = paramList;
  }

  public void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }

  public boolean b()
  {
    return this.g;
  }

  public void c(List<String> paramList)
  {
    this.e = paramList;
  }

  public String toString()
  {
    return "StartupRequestConfig{mStartupHostsFromStartup=" + this.a + ", mStartupHostsFromClient=" + this.b + ", mDistributionReferrer='" + this.c + '\'' + ", mClidsFromClient=" + this.d + ", mNewCustomHosts=" + this.e + ", mHasNewCustomHosts=" + this.f + ", mSuccessfulStartup=" + this.g + ", mCountryInit='" + this.h + '\'' + ", mFirstStartupTime='" + this.i + '\'' + '}';
  }

  public static class a extends lm.a
  {
    public final String a;
    public final Map<String, String> e;
    public final boolean f;
    public final List<String> g;

    public a(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap, boolean paramBoolean, List<String> paramList)
    {
      super(paramString2, paramString3);
      this.a = paramString4;
      this.e = paramMap;
      this.f = paramBoolean;
      this.g = paramList;
    }
  }

  public static class b extends lp.a<ls, ls.a>
  {
    public b(Context paramContext, String paramString)
    {
      super(paramString);
    }

    protected ls a()
    {
      return new ls((byte)0);
    }

    public ls a(lm.c<ls.a> paramc)
    {
      ls localls = (ls)super.b(paramc);
      a(localls, paramc.a);
      ls.a(localls, oq.b(((ls.a)paramc.b).a, paramc.a.r));
      localls.a(((ls.a)paramc.b).e);
      localls.b(((ls.a)paramc.b).f);
      localls.c(((ls.a)paramc.b).g);
      localls.a(paramc.a.t);
      localls.a(paramc.a.w);
      localls.a(paramc.a.B);
      return localls;
    }

    void a(ls paramls, mw parammw)
    {
      paramls.b(parammw.i);
      paramls.a(parammw.j);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ls
 * JD-Core Version:    0.6.2
 */