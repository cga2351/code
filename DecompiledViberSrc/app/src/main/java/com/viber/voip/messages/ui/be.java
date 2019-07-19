package com.viber.voip.messages.ui;

import android.content.Context;
import com.viber.voip.R.attr;
import com.viber.voip.R.color;
import com.viber.voip.ui.ap;
import com.viber.voip.util.dc;
import com.viber.voip.util.df;

public class be extends ap<bd>
{
  public be(Context paramContext)
  {
    super(paramContext);
  }

  protected bd a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return new e();
    case 1:
      return new d();
    case 2:
      return new c();
    case 3:
    }
    return new b();
  }

  protected abstract class a
    implements bd
  {
    protected Integer a;
    protected Integer b;
    protected Integer c;

    protected a()
    {
    }
  }

  protected class b extends be.a
  {
    protected b()
    {
      super();
    }

    public int a()
    {
      Integer localInteger = df.a(this.a, be.j(be.this), R.color.blue_light_theme_main);
      this.a = localInteger;
      return localInteger.intValue();
    }

    public int b()
    {
      Integer localInteger = df.a(this.b, be.k(be.this), R.color.negative);
      this.b = localInteger;
      return localInteger.intValue();
    }

    public int c()
    {
      Integer localInteger = df.a(this.c, be.l(be.this), R.color.negative);
      this.c = localInteger;
      return localInteger.intValue();
    }
  }

  protected class c extends be.a
  {
    protected c()
    {
      super();
    }

    public int a()
    {
      Integer localInteger = df.a(this.a, be.g(be.this), R.color.blue_theme_main);
      this.a = localInteger;
      return localInteger.intValue();
    }

    public int b()
    {
      Integer localInteger = df.a(this.b, be.h(be.this), R.color.negative);
      this.b = localInteger;
      return localInteger.intValue();
    }

    public int c()
    {
      Integer localInteger = df.a(this.c, be.i(be.this), R.color.negative);
      this.c = localInteger;
      return localInteger.intValue();
    }
  }

  protected class d extends be.a
  {
    protected d()
    {
      super();
    }

    public int a()
    {
      Integer localInteger = df.a(this.a, be.d(be.this), R.color.dark_theme_main);
      this.a = localInteger;
      return localInteger.intValue();
    }

    public int b()
    {
      Integer localInteger = df.a(this.b, be.e(be.this), R.color.negative);
      this.b = localInteger;
      return localInteger.intValue();
    }

    public int c()
    {
      Integer localInteger = df.a(this.c, be.f(be.this), R.color.negative);
      this.c = localInteger;
      return localInteger.intValue();
    }
  }

  protected class e extends be.a
  {
    protected e()
    {
      super();
    }

    public int a()
    {
      if (this.a == null)
        this.a = Integer.valueOf(dc.d(be.a(be.this), R.attr.contextMenuTitleBackground));
      return this.a.intValue();
    }

    public int b()
    {
      if (this.b == null)
        this.b = Integer.valueOf(dc.d(be.b(be.this), R.attr.contextMenuTitleColor));
      return this.b.intValue();
    }

    public int c()
    {
      if (this.c == null)
        this.c = Integer.valueOf(dc.d(be.c(be.this), R.attr.contextMenuTitleColor));
      return this.c.intValue();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.be
 * JD-Core Version:    0.6.2
 */