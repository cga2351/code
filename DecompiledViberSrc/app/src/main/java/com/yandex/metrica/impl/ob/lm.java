package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.text.TextUtils;
import com.yandex.metrica.b;
import com.yandex.metrica.impl.ac;
import com.yandex.metrica.impl.ac.GoogleAdvertisingIdGetter;
import com.yandex.metrica.impl.ac.GoogleAdvertisingIdGetter.b;
import com.yandex.metrica.impl.bn;
import com.yandex.metrica.impl.bu;
import com.yandex.metrica.impl.bw;
import com.yandex.metrica.impl.h;
import com.yandex.metrica.impl.h.b;
import java.util.Locale;

public class lm
{
  private String a;
  private h b;
  private final String c = "3.4.0";
  private final String d = "13097";
  private final String e;
  private final String f;
  private final String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  private GoogleAdvertisingIdGetter.b o;
  private String p;
  private String q;
  private mw r;

  public lm()
  {
    if (TextUtils.isEmpty(""));
    for (String str = "public"; ; str = "public_")
    {
      this.e = str;
      this.f = "android";
      this.g = "2";
      this.h = bn.b();
      this.p = b.a.name().toLowerCase(Locale.US);
      return;
    }
  }

  public String A()
  {
    return oq.b(this.p, b.a.name().toLowerCase(Locale.US));
  }

  public GoogleAdvertisingIdGetter.b B()
  {
    return this.o;
  }

  protected void a(GoogleAdvertisingIdGetter.b paramb)
  {
    this.o = paramb;
  }

  protected void a(h paramh)
  {
    this.b = paramh;
  }

  protected void a(mw parammw)
  {
    this.r = parammw;
  }

  protected void b(String paramString)
  {
    this.a = paramString;
  }

  public String c()
  {
    return this.a;
  }

  protected void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
      this.j = paramString;
  }

  protected mw d()
  {
    return this.r;
  }

  protected void d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
      this.i = paramString;
  }

  protected void e(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
        this.k = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean e()
  {
    boolean bool1 = true;
    try
    {
      String[] arrayOfString = new String[3];
      arrayOfString[0] = r();
      arrayOfString[1] = q();
      arrayOfString[2] = this.m;
      boolean bool2 = bu.a(arrayOfString);
      if (!bool2)
        return bool1;
      bool1 = false;
    }
    finally
    {
    }
  }

  public String f()
  {
    return oq.b(this.b.b, "");
  }

  protected void f(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
        this.l = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String g()
  {
    return "2";
  }

  protected void g(String paramString)
  {
    try
    {
      this.m = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String h()
  {
    return "3.4.0";
  }

  public void h(String paramString)
  {
    this.n = paramString;
  }

  public String i()
  {
    return "13097";
  }

  final void i(String paramString)
  {
    this.q = paramString;
  }

  public String j()
  {
    return this.e;
  }

  void j(String paramString)
  {
    this.p = paramString;
  }

  public String k()
  {
    return "android";
  }

  public String l()
  {
    return this.b.c;
  }

  public String m()
  {
    return this.b.d;
  }

  public int n()
  {
    return this.b.e;
  }

  public String o()
  {
    return oq.b(this.j, "");
  }

  public String p()
  {
    return oq.b(this.i, "");
  }

  public String q()
  {
    try
    {
      String str = oq.b(this.l, "");
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String r()
  {
    try
    {
      String str = oq.b(this.k, "");
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String s()
  {
    return this.b.h;
  }

  public String t()
  {
    return this.h;
  }

  public int u()
  {
    return this.b.f.a;
  }

  public int v()
  {
    return this.b.f.b;
  }

  public int w()
  {
    return this.b.f.c;
  }

  public float x()
  {
    return this.b.f.d;
  }

  public String y()
  {
    return oq.b(this.q, "");
  }

  public String z()
  {
    return this.n;
  }

  public static class a
  {
    public final String b;
    public final String c;
    public final String d;

    public a(String paramString1, String paramString2, String paramString3)
    {
      this.b = paramString1;
      this.c = paramString2;
      this.d = paramString3;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      a locala;
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
          return false;
        locala = (a)paramObject;
        if (this.b != null)
        {
          if (this.b.equals(locala.b));
        }
        else
          while (locala.b != null)
            return false;
        if (this.c != null)
        {
          if (this.c.equals(locala.c));
        }
        else
          while (locala.c != null)
            return false;
        if (this.d != null)
          return this.d.equals(locala.d);
      }
      while (locala.d == null);
      return false;
    }

    public int hashCode()
    {
      int i;
      int j;
      if (this.b != null)
      {
        i = this.b.hashCode();
        j = i * 31;
        if (this.c == null)
          break label77;
      }
      label77: for (int k = this.c.hashCode(); ; k = 0)
      {
        int m = 31 * (k + j);
        String str = this.d;
        int n = 0;
        if (str != null)
          n = this.d.hashCode();
        return m + n;
        i = 0;
        break;
      }
    }
  }

  protected static abstract class b<T extends lm, A extends lm.a>
    implements lm.d<T, lm.c<A>>
  {
    final Context a;
    final String b;

    protected b(Context paramContext, String paramString)
    {
      this.a = paramContext;
      this.b = paramString;
    }

    private void b(T paramT, lm.c<A> paramc)
    {
      try
      {
        paramT.e(paramc.a.a);
        a(paramT, paramc);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    String a(Context paramContext, String paramString)
    {
      if (paramString == null)
        paramString = h.a(paramContext).g;
      return paramString;
    }

    void a(T paramT, lm.c<A> paramc)
    {
      paramT.f(paramc.a.b);
      paramT.g(paramc.a.c);
    }

    protected abstract T b();

    public T c(lm.c<A> paramc)
    {
      lm locallm = b();
      h localh = h.a(this.a);
      locallm.a(localh);
      locallm.a(paramc.a);
      locallm.j(a(this.a, ((lm.a)paramc.b).b));
      locallm.h(oq.b(localh.a(paramc.a), ""));
      b(locallm, paramc);
      String str1 = this.b;
      String str2 = ((lm.a)paramc.b).c;
      Context localContext1 = this.a;
      if (TextUtils.isEmpty(str2))
        str2 = bw.b(localContext1, str1);
      locallm.d(str2);
      String str3 = this.b;
      String str4 = ((lm.a)paramc.b).d;
      Context localContext2 = this.a;
      if (TextUtils.isEmpty(str4))
        str4 = bw.a(localContext2, str3);
      locallm.c(str4);
      locallm.b(this.b);
      locallm.a(GoogleAdvertisingIdGetter.a().c(this.a));
      locallm.i(ac.a(this.a).a());
      return locallm;
    }
  }

  public static class c<A>
  {
    public final mw a;
    public final A b;

    public c(mw parammw, A paramA)
    {
      this.a = parammw;
      this.b = paramA;
    }
  }

  public static abstract interface d<T extends lm, D>
  {
    public abstract T a(D paramD);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.lm
 * JD-Core Version:    0.6.2
 */