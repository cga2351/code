package com.viber.voip.ads.b.c;

import android.app.Activity;
import com.viber.voip.ads.b.c.c.a;

public abstract interface b<T extends a>
{
  public static class a
  {
    public final Activity a;
    private final boolean b;
    private final Integer c;
    private final String d;
    private final int e;
    private final String f;

    private a(a parama)
    {
      this.a = a.a(parama);
      this.b = a.b(parama);
      this.c = a.c(parama);
      this.d = a.d(parama);
      this.e = a.e(parama);
      this.f = a.f(parama);
    }

    public Activity a()
    {
      return this.a;
    }

    public boolean b()
    {
      return this.b;
    }

    public Integer c()
    {
      return this.c;
    }

    public String d()
    {
      return this.d;
    }

    public int e()
    {
      return this.e;
    }

    public String f()
    {
      return this.f;
    }

    public static class a
    {
      private final Activity a;
      private boolean b;
      private Integer c;
      private String d = "";
      private int e = 0;
      private String f = "";

      public a(Activity paramActivity)
      {
        this.a = paramActivity;
      }

      public a(b.a parama)
      {
        this.a = parama.a;
        this.b = b.a.a(parama);
        this.c = b.a.b(parama);
      }

      public a a(int paramInt)
      {
        this.c = Integer.valueOf(paramInt);
        return this;
      }

      public a a(String paramString)
      {
        this.d = paramString;
        return this;
      }

      public a a(boolean paramBoolean)
      {
        this.b = paramBoolean;
        return this;
      }

      public b.a a()
      {
        return new b.a(this, null);
      }

      public a b(int paramInt)
      {
        this.e = paramInt;
        return this;
      }

      public a b(String paramString)
      {
        this.f = paramString;
        return this;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.b.c.b
 * JD-Core Version:    0.6.2
 */