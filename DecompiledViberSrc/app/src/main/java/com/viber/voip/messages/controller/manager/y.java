package com.viber.voip.messages.controller.manager;

import android.content.Context;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import java.util.Locale;

public class y
{
  private final String a;
  private final boolean b;
  private final boolean c;
  private final boolean d;
  private final boolean e;
  private final boolean f;
  private final boolean g;
  private final boolean h;
  private final boolean i;
  private final boolean j;
  private final boolean k;
  private final boolean l;
  private final boolean m;
  private final boolean n;
  private final boolean o;
  private final String p;
  private final String q;
  private final String r;
  private final boolean s;
  private final int[] t;
  private final boolean u;

  y(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, String paramString2, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13, int[] paramArrayOfInt, boolean paramBoolean14, boolean paramBoolean15, boolean paramBoolean16)
  {
    this.a = paramString1;
    this.b = paramBoolean1;
    this.c = paramBoolean14;
    this.d = paramBoolean2;
    this.e = paramBoolean3;
    this.g = paramBoolean4;
    this.f = paramBoolean5;
    this.h = paramBoolean6;
    this.r = paramString2;
    this.i = paramBoolean7;
    this.j = paramBoolean9;
    this.k = paramBoolean8;
    this.l = paramBoolean10;
    this.m = paramBoolean11;
    this.n = paramBoolean12;
    this.u = paramBoolean15;
    this.s = paramBoolean13;
    if (paramArrayOfInt == null)
      paramArrayOfInt = new int[0];
    this.t = paramArrayOfInt;
    Context localContext = ViberApplication.getLocalizedContext();
    this.q = localContext.getString(R.string.broadcast_list);
    this.p = localContext.getString(R.string.default_group_name);
    this.o = paramBoolean16;
  }

  public String a()
  {
    return this.a;
  }

  public boolean b()
  {
    return this.b;
  }

  public boolean c()
  {
    return this.c;
  }

  public boolean d()
  {
    return this.d;
  }

  public boolean e()
  {
    return this.e;
  }

  public boolean f()
  {
    return this.g;
  }

  public boolean g()
  {
    return this.f;
  }

  public boolean h()
  {
    return this.h;
  }

  public boolean i()
  {
    return this.p.toLowerCase(Locale.getDefault()).indexOf(this.a.trim().toLowerCase(Locale.getDefault())) >= 0;
  }

  public boolean j()
  {
    return this.q.toLowerCase(Locale.getDefault()).indexOf(this.a.trim().toLowerCase(Locale.getDefault())) >= 0;
  }

  public String k()
  {
    return this.p;
  }

  public String l()
  {
    return this.r;
  }

  public boolean m()
  {
    return this.i;
  }

  public boolean n()
  {
    return this.j;
  }

  public boolean o()
  {
    return this.l;
  }

  public boolean p()
  {
    return this.m;
  }

  public String q()
  {
    return this.q;
  }

  public boolean r()
  {
    return this.k;
  }

  public boolean s()
  {
    return this.s;
  }

  public boolean t()
  {
    return this.o;
  }

  public String toString()
  {
    return "MessageQuery{mQuery='" + this.a + '\'' + ", mSearchMessages=" + this.b + ", mSearchRegularGroups=" + this.d + ", mSearchOneOnOne=" + this.f + ", mShowSystemMessages=" + this.h + ", mConversationsInStatement=" + this.r + ", mShowHiddenChats=" + this.i + ", mIsPinSearchEnabled=" + this.k + ", mSearchContactEnabled=" + this.o + '}';
  }

  public boolean u()
  {
    return this.u;
  }

  public static class a
  {
    private String a;
    private boolean b = true;
    private boolean c = false;
    private boolean d = true;
    private boolean e = true;
    private boolean f = true;
    private boolean g = true;
    private boolean h = true;
    private boolean i = true;
    private boolean j = true;
    private boolean k = false;
    private boolean l = true;
    private boolean m = true;
    private boolean n = true;
    private boolean o = false;
    private int[] p = new int[0];
    private boolean q = false;
    private boolean r = false;
    private String s = "";

    public a a(String paramString)
    {
      this.a = paramString;
      return this;
    }

    public a a(boolean paramBoolean)
    {
      this.o = paramBoolean;
      return this;
    }

    public a a(int[] paramArrayOfInt)
    {
      if (paramArrayOfInt == null)
        paramArrayOfInt = new int[0];
      this.p = paramArrayOfInt;
      return this;
    }

    public y a()
    {
      return new y(this.a, this.b, this.d, this.e, this.f, this.g, this.h, this.s, this.i, this.k, this.j, this.l, this.m, this.n, this.o, this.p, this.c, this.q, this.r);
    }

    public a b(String paramString)
    {
      this.s = paramString;
      return this;
    }

    public a b(boolean paramBoolean)
    {
      this.b = paramBoolean;
      return this;
    }

    public a c(boolean paramBoolean)
    {
      this.c = paramBoolean;
      return this;
    }

    public a d(boolean paramBoolean)
    {
      this.f = paramBoolean;
      return this;
    }

    public a e(boolean paramBoolean)
    {
      this.d = paramBoolean;
      return this;
    }

    public a f(boolean paramBoolean)
    {
      this.e = paramBoolean;
      return this;
    }

    public a g(boolean paramBoolean)
    {
      this.g = paramBoolean;
      return this;
    }

    public a h(boolean paramBoolean)
    {
      this.h = paramBoolean;
      return this;
    }

    public a i(boolean paramBoolean)
    {
      this.i = paramBoolean;
      return this;
    }

    public a j(boolean paramBoolean)
    {
      this.j = paramBoolean;
      return this;
    }

    public a k(boolean paramBoolean)
    {
      this.l = paramBoolean;
      return this;
    }

    public a l(boolean paramBoolean)
    {
      this.k = paramBoolean;
      return this;
    }

    public void m(boolean paramBoolean)
    {
      this.m = paramBoolean;
    }

    public void n(boolean paramBoolean)
    {
      this.n = paramBoolean;
    }

    public void o(boolean paramBoolean)
    {
      this.q = paramBoolean;
    }

    public void p(boolean paramBoolean)
    {
      this.r = paramBoolean;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.manager.y
 * JD-Core Version:    0.6.2
 */