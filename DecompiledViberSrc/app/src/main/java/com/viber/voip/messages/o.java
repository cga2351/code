package com.viber.voip.messages;

import android.view.View.OnClickListener;
import com.viber.voip.R.string;
import com.viber.voip.messages.ui.PinDialogLayout.a;

public class o
{
  private View.OnClickListener a;
  private View.OnClickListener b;
  private PinDialogLayout.a c;
  private View.OnClickListener d;
  private View.OnClickListener e;
  private a f;
  private String g;
  private String h;
  private a i;
  private String j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;

  public o(a parama)
  {
    a(parama, null, 0, 0, 0, 0);
  }

  private void a(a parama1, a parama2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.f = parama1;
    this.i = parama2;
    this.l = paramInt1;
    this.o = paramInt2;
    this.k = paramInt3;
    this.q = paramInt4;
  }

  public View.OnClickListener a()
  {
    return this.a;
  }

  public void a(int paramInt)
  {
    this.k = paramInt;
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.o = paramInt1;
    this.p = paramInt2;
  }

  public void a(View.OnClickListener paramOnClickListener)
  {
    this.a = paramOnClickListener;
  }

  public void a(a parama)
  {
    this.i = parama;
  }

  public void a(PinDialogLayout.a parama)
  {
    this.c = parama;
  }

  public void a(String paramString)
  {
    this.g = paramString;
  }

  public View.OnClickListener b()
  {
    return this.b;
  }

  public void b(int paramInt)
  {
    this.l = paramInt;
  }

  public void b(View.OnClickListener paramOnClickListener)
  {
    this.b = paramOnClickListener;
  }

  public void b(String paramString)
  {
    this.j = paramString;
  }

  public PinDialogLayout.a c()
  {
    return this.c;
  }

  public void c(int paramInt)
  {
    this.o = paramInt;
  }

  public void c(View.OnClickListener paramOnClickListener)
  {
    this.e = paramOnClickListener;
  }

  public void c(String paramString)
  {
    this.h = paramString;
  }

  public a d()
  {
    return this.f;
  }

  public void d(int paramInt)
  {
    this.m = paramInt;
  }

  public String e()
  {
    return this.g;
  }

  public a f()
  {
    return this.i;
  }

  public String g()
  {
    return this.j;
  }

  public int h()
  {
    return this.k;
  }

  public int i()
  {
    if (this.l != 0)
      return this.l;
    return this.f.b();
  }

  public int j()
  {
    if (this.o != 0)
      return this.o;
    return this.f.c();
  }

  public int k()
  {
    return this.p;
  }

  public View.OnClickListener l()
  {
    return this.e;
  }

  public int m()
  {
    return this.n;
  }

  public int n()
  {
    return this.m;
  }

  public View.OnClickListener o()
  {
    return this.d;
  }

  public String p()
  {
    return this.h;
  }

  public static enum a
  {
    private boolean i;
    private int j;
    private int k;

    static
    {
      a[] arrayOfa = new a[8];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
      arrayOfa[6] = g;
      arrayOfa[7] = h;
    }

    private a(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      this.i = paramBoolean;
      this.j = paramInt1;
      this.k = paramInt2;
    }

    public static a a(int paramInt)
    {
      for (int m = 0; m < values().length; m++)
        if (paramInt == values()[m].ordinal())
          return values()[m];
      return a;
    }

    public boolean a()
    {
      return this.i;
    }

    public int b()
    {
      return this.j;
    }

    public int c()
    {
      return this.k;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.o
 * JD-Core Version:    0.6.2
 */