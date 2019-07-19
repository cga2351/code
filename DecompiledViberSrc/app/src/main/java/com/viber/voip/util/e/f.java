package com.viber.voip.util.e;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import com.viber.voip.R.attr;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.ViberApplication;
import com.viber.voip.util.dc;
import com.viber.voip.util.e.b.c;

public final class f
{
  private static final int o = localResources.getDimensionPixelSize(R.dimen.image_size_small);
  private static final int p = localResources.getDimensionPixelSize(R.dimen.image_size_medium);
  private static final int q = localResources.getDimensionPixelSize(R.dimen.bot_keyboard_image_size_small);
  private static final int r = localResources.getDimensionPixelSize(R.dimen.bot_keyboard_image_size_medium);
  private static final int s = localResources.getDimensionPixelSize(R.dimen.bot_keyboard_image_size_large);
  private static final int t = o;
  private static final int u = p;
  private static final int v = q;
  private static final int w = r;
  private static final int x = s;
  final Integer a;
  final Integer b;
  final boolean c;
  final boolean d;
  final boolean e;
  final boolean f;
  final boolean g;
  final boolean h;
  final boolean i;
  final b j;
  final b k;
  com.viber.voip.b.a l = com.viber.voip.b.a.i;
  final int m;
  final String n;
  private final int y;
  private final int z;

  static
  {
    Resources localResources = ViberApplication.getApplication().getResources();
  }

  private f(a parama)
  {
    this.a = a.a(parama);
    this.b = a.b(parama);
    this.c = a.c(parama);
    this.d = a.d(parama);
    this.e = a.e(parama);
    this.f = a.f(parama);
    this.h = a.g(parama);
    this.g = a.h(parama);
    this.i = a.i(parama);
    this.k = a.j(parama);
    this.y = a.k(parama);
    this.z = a.l(parama);
    this.j = a.m(parama);
    this.l = a.n(parama);
    this.m = a.o(parama);
    this.n = a.p(parama);
  }

  public static f a()
  {
    return new a().c();
  }

  public static f a(int paramInt)
  {
    return new a().a(Integer.valueOf(paramInt)).b(Integer.valueOf(paramInt)).c();
  }

  public static f a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return new a().a(new c(paramInt1, paramInt2, paramBoolean)).d(false).c();
  }

  public static f a(int paramInt, b paramb)
  {
    return new a().a(Integer.valueOf(paramInt)).b(Integer.valueOf(paramInt)).a(paramb).c();
  }

  public static f a(int paramInt, b paramb, boolean paramBoolean)
  {
    return new a().a(Integer.valueOf(paramInt)).b(Integer.valueOf(paramInt)).a(paramb).b(paramBoolean).c();
  }

  public static f a(Context paramContext)
  {
    return new a().a(b.b).a(new com.viber.voip.util.e.b.a(paramContext)).c();
  }

  public static f b()
  {
    return new a().a(Integer.valueOf(R.drawable.participant_image_generic)).b(Integer.valueOf(R.drawable.participant_image_generic)).a(b.b).a(true).c();
  }

  public static f b(int paramInt)
  {
    return new a().b(Integer.valueOf(paramInt)).a(b.a).c();
  }

  public static f b(Context paramContext)
  {
    int i1 = dc.a(paramContext, R.attr.contactDefaultPhoto);
    return new a().a(Integer.valueOf(i1)).b(Integer.valueOf(i1)).a(b.b).c();
  }

  public static f c()
  {
    return new a().b(Integer.valueOf(R.drawable.reply_banner_default_thumb)).a(b.b).c();
  }

  public static f c(int paramInt)
  {
    return new a().a(Integer.valueOf(paramInt)).b(Integer.valueOf(paramInt)).a(b.b).c();
  }

  public static f c(Context paramContext)
  {
    int i1 = dc.a(paramContext, R.attr.chatExLoadingIcon);
    int i2 = dc.a(paramContext, R.attr.chatExDefaultIcon);
    return new a().a(Integer.valueOf(i1)).b(Integer.valueOf(i2)).a(b.b).b(false).c();
  }

  public static f d()
  {
    return new a().b(false).b(Integer.valueOf(R.drawable.ic_game_generic)).c();
  }

  public static f d(int paramInt)
  {
    return new a().a(Integer.valueOf(paramInt)).b(Integer.valueOf(paramInt)).a(b.b).a(102400).c();
  }

  public static f e()
  {
    return new a().a(Integer.valueOf(R.drawable.ic_pa_info_joker_btn_placeholder)).b(Integer.valueOf(R.drawable.ic_pa_info_joker_btn_placeholder)).b(false).c();
  }

  public static f e(int paramInt)
  {
    return new a().a(true).b(Integer.valueOf(paramInt)).a(Integer.valueOf(paramInt)).c();
  }

  public static f f(int paramInt)
  {
    return new a().a(true).a(Integer.valueOf(paramInt)).b(Integer.valueOf(paramInt)).c();
  }

  public static f g(int paramInt)
  {
    return new a().a(Integer.valueOf(paramInt)).b(Integer.valueOf(paramInt)).b(false).a(com.viber.voip.b.a.l).c();
  }

  public a f()
  {
    a locala = new a();
    a.a(locala, this.a);
    a.b(locala, this.b);
    a.a(locala, this.c);
    a.b(locala, this.d);
    a.c(locala, this.g);
    a.d(locala, this.e);
    a.a(locala, this.m);
    a.a(locala, this.k);
    a.b(locala, this.y);
    a.c(locala, this.z);
    a.a(locala, this.j);
    a.a(locala, this.n);
    return locala;
  }

  int g()
  {
    switch (1.a[this.k.ordinal()])
    {
    default:
      return -1;
    case 1:
      return o;
    case 2:
      return p;
    case 3:
      return this.y;
    case 4:
      return q;
    case 5:
      return r;
    case 6:
    }
    return s;
  }

  int h()
  {
    switch (1.a[this.k.ordinal()])
    {
    default:
      return -1;
    case 1:
      return t;
    case 2:
      return u;
    case 3:
      return this.z;
    case 4:
      return v;
    case 5:
      return w;
    case 6:
    }
    return x;
  }

  public static class a
  {
    private Integer a;
    private Integer b;
    private boolean c = false;
    private boolean d = true;
    private boolean e = true;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;
    private boolean i = false;
    private f.b j = f.b.d;
    private int k;
    private int l;
    private b m;
    private com.viber.voip.b.a n = com.viber.voip.b.a.i;
    private int o = -1;
    private String p;

    public a a()
    {
      this.a = null;
      return this;
    }

    public a a(int paramInt)
    {
      this.o = paramInt;
      return this;
    }

    public a a(int paramInt1, int paramInt2)
    {
      this.j = f.b.c;
      this.l = paramInt2;
      this.k = paramInt1;
      return this;
    }

    public a a(com.viber.voip.b.a parama)
    {
      this.n = parama;
      return this;
    }

    public a a(b paramb)
    {
      this.m = paramb;
      return this;
    }

    public a a(f.b paramb)
    {
      this.j = paramb;
      return this;
    }

    public a a(Integer paramInteger)
    {
      this.a = paramInteger;
      return this;
    }

    public a a(String paramString)
    {
      this.p = paramString;
      return this;
    }

    public a a(boolean paramBoolean)
    {
      this.c = paramBoolean;
      return this;
    }

    public a b()
    {
      this.b = null;
      return this;
    }

    public a b(Integer paramInteger)
    {
      this.b = paramInteger;
      return this;
    }

    public a b(boolean paramBoolean)
    {
      this.d = paramBoolean;
      return this;
    }

    public a c(boolean paramBoolean)
    {
      this.h = paramBoolean;
      return this;
    }

    public f c()
    {
      return new f(this, null);
    }

    public a d(boolean paramBoolean)
    {
      this.e = paramBoolean;
      return this;
    }

    public a e(boolean paramBoolean)
    {
      this.f = paramBoolean;
      return this;
    }

    public a f(boolean paramBoolean)
    {
      this.i = paramBoolean;
      return this;
    }
  }

  public static enum b
  {
    private String h;

    static
    {
      b[] arrayOfb = new b[7];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
      arrayOfb[3] = d;
      arrayOfb[4] = e;
      arrayOfb[5] = f;
      arrayOfb[6] = g;
    }

    private b(String paramString)
    {
      this.h = paramString;
    }

    public String a()
    {
      return this.h;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.e.f
 * JD-Core Version:    0.6.2
 */