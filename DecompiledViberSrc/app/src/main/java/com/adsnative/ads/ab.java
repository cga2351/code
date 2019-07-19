package com.adsnative.ads;

import android.content.Context;
import android.os.Handler;
import com.adsnative.b.b;
import com.adsnative.c.i;

public class ab extends z
{
  private static final v d = new v()
  {
    public void a(w paramAnonymousw)
    {
    }

    public void a(String paramAnonymousString)
    {
    }

    public void b(w paramAnonymousw)
    {
    }

    public void c(w paramAnonymousw)
    {
    }
  };
  private static final p e = new p()
  {
    public void a()
    {
    }

    public void a(n paramAnonymousn)
    {
    }

    public void a(String paramAnonymousString)
    {
    }

    public boolean b(n paramAnonymousn)
    {
      return false;
    }
  };
  Handler b;
  Runnable c = null;
  private Context f;
  private v g = d;
  private p h = e;
  private String i;
  private o j;
  private b k;
  private Boolean l = Boolean.valueOf(false);
  private Boolean m = Boolean.valueOf(false);
  private aa n = null;
  private int o;
  private String p = "native";
  private int q = 0;
  private int r = 0;

  public ab(Context paramContext, String paramString, a.a parama)
  {
    super(paramContext, paramString);
    this.f = paramContext;
    this.i = paramString;
    this.p = parama.toString();
    this.b = new Handler();
    this.o = 60000;
  }

  public String a()
  {
    return this.p;
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.q = paramInt1;
    this.r = paramInt2;
  }

  public void a(aa paramaa)
  {
    a(this.i, paramaa);
  }

  public void a(p paramp)
  {
    this.h = paramp;
  }

  public void a(v paramv)
  {
    this.g = paramv;
  }

  public void a(Boolean paramBoolean)
  {
    this.m = paramBoolean;
  }

  public void a(String paramString, aa paramaa)
  {
    if (((this.p.equalsIgnoreCase("banner")) || (this.p.equalsIgnoreCase("all"))) && ((this.q == 0) || (this.r == 0)))
    {
      i.e("Banner height and width has to be set for Banner/ALL request types");
      return;
    }
    this.n = paramaa;
    this.k = new b(paramString, paramaa, this.f);
    this.k.a(this.a);
    this.k.a(this);
    if (this.g != null)
      this.k.a(this.g);
    this.j = new o()
    {
      public void a(f paramAnonymousf)
      {
        ab.a(ab.this).a(paramAnonymousf.a());
      }

      public void a(n paramAnonymousn)
      {
        paramAnonymousn.a(ab.a(ab.this));
        ab.a(ab.this).a(paramAnonymousn);
      }

      public void b(f paramAnonymousf)
      {
        ab.b(ab.this).a(paramAnonymousf.a());
      }
    };
    this.k.a(this.j);
    this.k.a();
  }

  public int b()
  {
    return this.q;
  }

  public int c()
  {
    return this.r;
  }

  public Boolean d()
  {
    return this.m;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.ads.ab
 * JD-Core Version:    0.6.2
 */