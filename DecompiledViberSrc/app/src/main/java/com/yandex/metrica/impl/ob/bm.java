package com.yandex.metrica.impl.ob;

import android.content.Context;
import java.util.List;

public class bm extends lp
{
  private List<String> a;
  private String b;

  public List<String> a()
  {
    return this.a;
  }

  public void a(String paramString)
  {
    this.b = paramString;
  }

  public void a(List<String> paramList)
  {
    this.a = paramList;
  }

  public String b()
  {
    return this.b;
  }

  public String toString()
  {
    return "DiagnosticRequestConfig{mDiagnosticHosts=" + this.a + ", mApiKey='" + this.b + '\'' + '}';
  }

  public static final class a extends lm.a
  {
    public final String a;

    public a(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      super(paramString2, paramString3);
      this.a = paramString4;
    }
  }

  public static class b extends lp.a<bm, bm.a>
  {
    public b(Context paramContext, String paramString)
    {
      super(paramString);
    }

    protected bm a()
    {
      return new bm();
    }

    public bm a(lm.c<bm.a> paramc)
    {
      bm localbm = (bm)super.b(paramc);
      localbm.a(paramc.a.k);
      localbm.a(((bm.a)paramc.b).a);
      return localbm;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.bm
 * JD-Core Version:    0.6.2
 */