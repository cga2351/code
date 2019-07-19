package com.viber.voip.messages.conversation.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import com.viber.voip.R.attr;
import com.viber.voip.R.color;
import com.viber.voip.R.drawable;
import com.viber.voip.ui.ap;
import com.viber.voip.util.dc;
import com.viber.voip.util.df;

public class av extends ap<at>
{
  av(Context paramContext)
  {
    super(paramContext);
  }

  protected at a(int paramInt)
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

  abstract class a
    implements at
  {
    Integer a;
    Integer b;
    Integer c;
    Integer d;
    Integer e;

    a()
    {
    }

    public Drawable o()
    {
      return au.a(this);
    }
  }

  protected class b extends av.c
  {
    protected b()
    {
      super();
    }

    public int a()
    {
      Integer localInteger = df.a(this.a, av.B(av.this), R.color.blue_light_theme_alt_main_95);
      this.a = localInteger;
      return localInteger.intValue();
    }

    public int d()
    {
      Integer localInteger = Integer.valueOf(dc.a(this.b, av.D(av.this), R.attr.conversationComposeSendButtonInboxAlternativeColor));
      this.b = localInteger;
      return localInteger.intValue();
    }

    public ColorStateList e()
    {
      return ContextCompat.getColorStateList(av.C(av.this), R.color.btn_blue_light_theme);
    }

    public int k()
    {
      Integer localInteger = df.a(this.c, av.E(av.this), R.color.blue_light_theme_alt_main_95);
      this.c = localInteger;
      return localInteger.intValue();
    }

    public Drawable l()
    {
      Integer localInteger = Integer.valueOf(dc.a(this.e, av.F(av.this), R.attr.toolbarInboxAlternativeColor));
      this.e = localInteger;
      return new ColorDrawable(localInteger.intValue());
    }

    public int q()
    {
      Integer localInteger = df.a(this.d, av.G(av.this), R.color.negative);
      this.d = localInteger;
      return localInteger.intValue();
    }
  }

  protected class c extends av.e
  {
    protected c()
    {
      super();
    }

    public int a()
    {
      Integer localInteger = df.a(this.a, av.r(av.this), R.color.blue_theme_alt_main_95);
      this.a = localInteger;
      return localInteger.intValue();
    }

    public Drawable b()
    {
      return dc.g(av.s(av.this), R.attr.conversationComposeSendButtonInactiveInboxBackground);
    }

    public Drawable c()
    {
      return dc.g(av.u(av.this), R.attr.conversationComposeSendButtonInboxBackground);
    }

    public int d()
    {
      Integer localInteger = Integer.valueOf(dc.a(this.b, av.v(av.this), R.attr.conversationComposeSendButtonInboxColor));
      this.b = localInteger;
      return localInteger.intValue();
    }

    public ColorStateList e()
    {
      return ContextCompat.getColorStateList(av.t(av.this), R.color.btn_blue_theme);
    }

    public int k()
    {
      Integer localInteger = df.a(this.c, av.w(av.this), R.color.blue_theme_alt_main_95);
      this.c = localInteger;
      return localInteger.intValue();
    }

    public Drawable l()
    {
      Integer localInteger = Integer.valueOf(dc.a(this.e, av.x(av.this), R.attr.toolbarInboxColor));
      this.e = localInteger;
      return new ColorDrawable(localInteger.intValue());
    }

    public Drawable m()
    {
      return ContextCompat.getDrawable(av.A(av.this), R.drawable.ic_ab_theme_dark_back);
    }

    public int n()
    {
      return R.drawable.cursor_white;
    }

    public ColorStateList p()
    {
      return dc.e(av.y(av.this), R.attr.menuItemIconTintSecretColor);
    }

    public int q()
    {
      Integer localInteger = df.a(this.d, av.z(av.this), R.color.negative);
      this.d = localInteger;
      return localInteger.intValue();
    }
  }

  protected class d extends av.a
  {
    protected d()
    {
      super();
    }

    public int a()
    {
      Integer localInteger = df.a(this.a, av.H(av.this), R.color.dark_theme_alt_main_92);
      this.a = localInteger;
      return localInteger.intValue();
    }

    public Drawable b()
    {
      return dc.g(av.I(av.this), R.attr.conversationComposeSendButtonInactiveSecretBackground);
    }

    public Drawable c()
    {
      return dc.g(av.J(av.this), R.attr.conversationComposeSendButtonSecretBackground);
    }

    public int d()
    {
      Integer localInteger = Integer.valueOf(dc.a(this.b, av.K(av.this), R.attr.conversationComposeSendButtonSecretColor));
      this.b = localInteger;
      return localInteger.intValue();
    }

    public ColorStateList e()
    {
      return ContextCompat.getColorStateList(av.L(av.this), R.color.btn_dark_theme);
    }

    public int f()
    {
      return dc.a(av.M(av.this), R.attr.conversationStickerMenuTabsListBackground);
    }

    public Drawable g()
    {
      return dc.g(av.N(av.this), R.attr.conversationStickerMenuPackageSelectorBackground);
    }

    public Drawable h()
    {
      return ContextCompat.getDrawable(av.O(av.this), R.drawable.ic_stickers_menu_erase_emoticon_dark_theme);
    }

    public Drawable i()
    {
      return df.a(ContextCompat.getDrawable(av.P(av.this), R.drawable.ic_stickers_menu_search), dc.f(av.Q(av.this), R.attr.conversationStickerMenuIconDefaultTint), false);
    }

    public Drawable j()
    {
      return ContextCompat.getDrawable(av.R(av.this), R.drawable.ic_stickers_menu_add_dark);
    }

    public int k()
    {
      Integer localInteger = df.a(this.c, av.S(av.this), R.color.dark_theme_alt_main_92);
      this.c = localInteger;
      return localInteger.intValue();
    }

    public Drawable l()
    {
      Integer localInteger = Integer.valueOf(dc.a(this.e, av.T(av.this), R.attr.toolbarSecretColor));
      this.e = localInteger;
      return new ColorDrawable(localInteger.intValue());
    }

    public Drawable m()
    {
      return ContextCompat.getDrawable(av.W(av.this), R.drawable.ic_ab_theme_dark_back);
    }

    public int n()
    {
      return R.drawable.cursor_white;
    }

    public ColorStateList p()
    {
      return dc.e(av.U(av.this), R.attr.menuItemIconTintSecretColor);
    }

    public int q()
    {
      Integer localInteger = df.a(this.d, av.V(av.this), R.color.negative);
      this.d = localInteger;
      return localInteger.intValue();
    }
  }

  protected class e extends av.a
  {
    protected e()
    {
      super();
    }

    public int a()
    {
      Integer localInteger = df.a(this.a, av.a(av.this), R.color.banner_background_color);
      this.a = localInteger;
      return localInteger.intValue();
    }

    public Drawable b()
    {
      return dc.g(av.b(av.this), R.attr.conversationComposeSendButtonInactiveRegularBackground);
    }

    public Drawable c()
    {
      return dc.g(av.c(av.this), R.attr.conversationComposeSendButtonRegularBackground);
    }

    public int d()
    {
      Integer localInteger = Integer.valueOf(dc.a(this.b, av.e(av.this), R.attr.conversationComposeSendButtonRegularColor));
      this.b = localInteger;
      return localInteger.intValue();
    }

    public ColorStateList e()
    {
      return ContextCompat.getColorStateList(av.f(av.this), R.color.btn_purple_theme);
    }

    public int f()
    {
      return dc.a(av.g(av.this), R.attr.conversationStickerMenuTabsListBackground);
    }

    public Drawable g()
    {
      return dc.g(av.h(av.this), R.attr.conversationStickerMenuPackageSelectorBackground);
    }

    public Drawable h()
    {
      return ContextCompat.getDrawable(av.i(av.this), R.drawable.ic_stickers_menu_erase_emoticon);
    }

    public Drawable i()
    {
      return df.a(ContextCompat.getDrawable(av.j(av.this), R.drawable.ic_stickers_menu_search), dc.f(av.k(av.this), R.attr.conversationStickerMenuIconDefaultTint), false);
    }

    public Drawable j()
    {
      return ContextCompat.getDrawable(av.l(av.this), R.drawable.ic_stickers_menu_add);
    }

    public int k()
    {
      Integer localInteger = df.a(this.c, av.m(av.this), R.color.banner_background_color);
      this.c = localInteger;
      return localInteger.intValue();
    }

    public Drawable l()
    {
      return dc.g(av.n(av.this), R.attr.toolbarBackground);
    }

    public Drawable m()
    {
      return ContextCompat.getDrawable(av.d(av.this), R.drawable.ic_ab_theme_light_back);
    }

    public int n()
    {
      return R.drawable.cursor_purple;
    }

    public Drawable o()
    {
      return dc.g(av.o(av.this), R.attr.bottomNavigationBackground);
    }

    public ColorStateList p()
    {
      return dc.e(av.p(av.this), R.attr.menuItemIconTintColor);
    }

    public int q()
    {
      Integer localInteger = Integer.valueOf(dc.a(this.d, av.q(av.this), R.attr.toolbarTitleColor));
      this.d = localInteger;
      return localInteger.intValue();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.av
 * JD-Core Version:    0.6.2
 */