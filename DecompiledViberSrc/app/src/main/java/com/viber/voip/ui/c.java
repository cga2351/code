package com.viber.voip.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import com.viber.voip.R.attr;
import com.viber.voip.R.color;
import com.viber.voip.ui.c.f;
import com.viber.voip.util.dc;
import com.viber.voip.util.df;

public class c extends ap<a>
{
  private f b;

  public c(Context paramContext, f paramf)
  {
    super(paramContext);
    this.b = paramf;
  }

  protected a a(int paramInt)
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

  public int c(int paramInt)
  {
    return this.b.a(paramInt);
  }

  protected abstract class a
    implements a
  {
    protected Integer a;
    protected Integer b;
    protected Integer c;
    protected Integer d;

    protected a()
    {
    }

    public void a(AppCompatActivity paramAppCompatActivity)
    {
      b.a(this, paramAppCompatActivity);
    }

    public void a(Toolbar paramToolbar)
    {
      b.a(this, paramToolbar);
    }

    public void b(AppCompatActivity paramAppCompatActivity)
    {
      b.b(this, paramAppCompatActivity);
    }

    public void c(AppCompatActivity paramAppCompatActivity)
    {
      b.c(this, paramAppCompatActivity);
    }

    public void d(AppCompatActivity paramAppCompatActivity)
    {
      b.d(this, paramAppCompatActivity);
    }
  }

  protected class b extends c.a
  {
    protected b()
    {
      super();
    }

    public Drawable a()
    {
      Integer localInteger = Integer.valueOf(dc.a(this.a, c.this.a, R.attr.toolbarInboxAlternativeColor));
      this.a = localInteger;
      return new ColorDrawable(localInteger.intValue());
    }

    public int b()
    {
      Integer localInteger = Integer.valueOf(dc.a(this.b, c.this.a, R.attr.primaryInboxAlternativeDarkColor));
      this.b = localInteger;
      return localInteger.intValue();
    }

    public boolean c()
    {
      return false;
    }

    public ColorStateList d()
    {
      return ContextCompat.getColorStateList(c.this.a, R.color.theme_dark_action_tint);
    }

    public int e()
    {
      Integer localInteger = df.a(this.c, c.this.a, R.color.negative);
      this.c = localInteger;
      return localInteger.intValue();
    }

    public int f()
    {
      Integer localInteger = df.a(this.d, c.this.a, R.color.negative);
      this.d = localInteger;
      return localInteger.intValue();
    }
  }

  protected class c extends c.a
  {
    protected c()
    {
      super();
    }

    public Drawable a()
    {
      Integer localInteger = Integer.valueOf(dc.a(this.a, c.this.a, R.attr.toolbarInboxColor));
      this.a = localInteger;
      return new ColorDrawable(localInteger.intValue());
    }

    public int b()
    {
      Integer localInteger = Integer.valueOf(dc.a(this.b, c.this.a, R.attr.primaryInboxDarkColor));
      this.b = localInteger;
      return localInteger.intValue();
    }

    public boolean c()
    {
      return false;
    }

    public ColorStateList d()
    {
      return ContextCompat.getColorStateList(c.this.a, R.color.theme_dark_action_tint);
    }

    public int e()
    {
      Integer localInteger = df.a(this.c, c.this.a, R.color.negative);
      this.c = localInteger;
      return localInteger.intValue();
    }

    public int f()
    {
      Integer localInteger = df.a(this.d, c.this.a, R.color.negative);
      this.d = localInteger;
      return localInteger.intValue();
    }
  }

  protected class d extends c.a
  {
    protected d()
    {
      super();
    }

    public Drawable a()
    {
      Integer localInteger = Integer.valueOf(dc.a(this.a, c.this.a, R.attr.toolbarSecretColor));
      this.a = localInteger;
      return new ColorDrawable(localInteger.intValue());
    }

    public int b()
    {
      Integer localInteger = Integer.valueOf(dc.a(this.b, c.this.a, R.attr.primarySecretDarkColor));
      this.b = localInteger;
      return localInteger.intValue();
    }

    public boolean c()
    {
      return false;
    }

    public ColorStateList d()
    {
      return ContextCompat.getColorStateList(c.this.a, R.color.theme_dark_action_tint);
    }

    public int e()
    {
      Integer localInteger = df.a(this.c, c.this.a, R.color.negative);
      this.c = localInteger;
      return localInteger.intValue();
    }

    public int f()
    {
      Integer localInteger = df.a(this.d, c.this.a, R.color.negative);
      this.d = localInteger;
      return localInteger.intValue();
    }
  }

  protected class e extends c.a
  {
    protected e()
    {
      super();
    }

    public Drawable a()
    {
      return dc.g(c.this.a, R.attr.toolbarBackground);
    }

    public int b()
    {
      if (this.b != null)
        return this.b.intValue();
      if (com.viber.common.d.a.i());
      for (int i = dc.a(c.this.a, R.attr.statusBarDefaultLollipopColor, ContextCompat.getColor(c.this.a, R.color.status_bar_grey)); ; i = dc.a(c.this.a, R.attr.colorPrimaryDark, ContextCompat.getColor(c.this.a, R.color.light_theme_main_dark)))
      {
        Integer localInteger = Integer.valueOf(i);
        this.b = localInteger;
        return localInteger.intValue();
      }
    }

    public boolean c()
    {
      return dc.b();
    }

    public ColorStateList d()
    {
      return ColorStateList.valueOf(dc.d(c.this.a, R.attr.menuItemIconTintColor));
    }

    public int e()
    {
      Integer localInteger = Integer.valueOf(dc.a(this.c, c.this.a, R.attr.toolbarTitleColor));
      this.c = localInteger;
      return localInteger.intValue();
    }

    public int f()
    {
      Integer localInteger = Integer.valueOf(dc.a(this.d, c.this.a, R.attr.toolbarSubtitleColor));
      this.d = localInteger;
      return localInteger.intValue();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.c
 * JD-Core Version:    0.6.2
 */