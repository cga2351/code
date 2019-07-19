package com.viber.voip.messages.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.util.CircularIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.common.dialogs.l.a;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.market.StickerMarketActivity;
import com.viber.voip.messages.adapters.z.a;
import com.viber.voip.messages.ui.d.a.a.a;
import com.viber.voip.messages.ui.d.a.a.b;
import com.viber.voip.messages.ui.d.a.a.c;
import com.viber.voip.messages.ui.d.a.a.d;
import com.viber.voip.messages.ui.d.d;
import com.viber.voip.messages.ui.d.d.a;
import com.viber.voip.sound.tones.IRingtonePlayer;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.i;
import com.viber.voip.stickers.n;
import com.viber.voip.stickers.x;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.util.cj;
import com.viber.voip.util.dg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class cv
  implements ao.a, a.b
{
  private static final Logger m = ViberEnv.getLogger();
  protected final Context a;
  protected final i b;
  protected final a c;
  protected boolean d;
  protected final View e;
  protected ViewGroup f;
  protected ViewGroup g;
  protected int h;
  protected final d i;
  protected com.viber.voip.messages.ui.d.a.a j;
  protected final Handler k;
  protected c l;
  private View n;
  private final Object o;
  private IRingtonePlayer p;
  private final CircularIntArray q;
  private LayoutInflater r;
  private final com.viber.voip.stickers.e.b s = c();
  private final com.viber.voip.stickers.e.a t = new com.viber.voip.stickers.e.a()
  {
    private int a()
    {
      int i = cv.a(cv.this).size();
      int j = 0;
      if (i > 0)
        while ((cv.a(cv.this).size() > 0) && (cv.this.b.m(cv.a(cv.this).getLast())))
          j = cv.a(cv.this).popLast();
      return j;
    }

    public void onStickerPackageChanged(List<com.viber.voip.stickers.entity.a> paramAnonymousList1, List<com.viber.voip.stickers.entity.a> paramAnonymousList2)
    {
      if (!cv.this.d())
        return;
      int i = cv.this.h;
      int j = a();
      if (j > 0)
        cv.this.c.a(j, false);
      List localList;
      com.viber.voip.stickers.entity.a locala;
      for (int k = 2; ; k = 1)
      {
        cv.this.h = cv.this.c.a();
        localList = cv.this.b();
        locala = cv.this.b.g(cv.this.h);
        if (locala == null)
          break;
        if ((locala.h()) || (!locala.g()) || (cv.this.i.c().g() == cv.this.h))
          break label189;
        cv.this.i.c().a(cv.this.h, new cw(this, locala, i, localList, k));
        return;
      }
      label189: cv.this.a(locala, i, localList, k);
    }
  };

  public cv(Context paramContext, View paramView, LayoutInflater paramLayoutInflater, d.a parama, final a parama1, c paramc)
  {
    long l1 = System.currentTimeMillis();
    this.a = paramContext;
    this.r = paramLayoutInflater;
    this.b = i.a();
    this.q = new CircularIntArray(10);
    this.c = new a()
    {
      public int a()
      {
        int i = parama1.a();
        if (!cv.this.b.m(i))
        {
          int j = cv.this.a();
          parama1.a(j, false);
        }
        return parama1.a();
      }

      public void a(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        int i = parama1.a();
        if (!cv.this.b.m(paramAnonymousInt))
          paramAnonymousInt = cv.this.a();
        parama1.a(paramAnonymousInt, paramAnonymousBoolean);
        if ((i != 0) && (i != paramAnonymousInt))
          cv.this.b.a(i, paramAnonymousInt);
      }
    };
    this.e = paramView;
    this.k = av.a(av.e.a);
    this.p = ViberApplication.getInstance().getRingtonePlayer();
    this.i = new d(this.a, this.k, this.b, parama);
    this.l = paramc;
    this.j = new com.viber.voip.messages.ui.d.a.a(this.a, this.l);
    this.o = new Object();
    k();
    (System.currentTimeMillis() - l1);
  }

  private void a(int paramInt, List<com.viber.voip.stickers.entity.a> paramList, a.c paramc)
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = a(localArrayList, paramInt, paramList);
    com.viber.voip.messages.ui.d.a.a locala = this.j;
    if (-1 == i1)
      i1 = 0;
    locala.a(localArrayList, i1, paramc);
    this.n.setVisibility(0);
  }

  private void d(int paramInt)
  {
    if (this.d)
    {
      a(paramInt, b(), a.c.c);
      this.c.a(paramInt, true);
      this.p.stopStickerPromo();
      a(paramInt);
    }
  }

  private void g()
  {
    if (this.d)
      return;
    this.h = this.c.a();
    this.d = true;
    this.f = ((ViewGroup)this.r.inflate(R.layout.conversation_menu_sticker_panel, null));
    this.f.setBackgroundResource(this.l.a());
    this.g = ((ViewGroup)this.f.findViewById(R.id.stickers_content));
    this.n = this.f.findViewById(R.id.sticker_menu_container);
    this.j.a(this.n);
    this.j.a(this);
    a(this.r, this.b.g(this.h));
    a(this.h, b(), a.c.b);
    dg.a(this.n, "Sticker packages menu");
  }

  private void k()
  {
    this.b.a(this.s);
    this.b.a(this.t);
  }

  private void l()
  {
    this.b.b(this.t);
    this.b.b(this.s);
  }

  private void m()
  {
    int i1 = this.b.x();
    if ((this.d) && (this.i.e()) && (i1 != 0) && (i1 != this.c.a()))
      this.k.postAtTime(new Runnable()
      {
        public void run()
        {
          cv.this.e();
        }
      }
      , this.o, 1000L + SystemClock.uptimeMillis());
  }

  private boolean s()
  {
    return cj.c(this.a);
  }

  protected int a()
  {
    Iterator localIterator = b().iterator();
    while (localIterator.hasNext())
    {
      com.viber.voip.stickers.entity.a locala = (com.viber.voip.stickers.entity.a)localIterator.next();
      if (!locala.h())
        return locala.e();
    }
    return 0;
  }

  protected int a(List<a.d> paramList, int paramInt, List<com.viber.voip.stickers.entity.a> paramList1)
  {
    int i1 = -1;
    int i2 = 0;
    int i3 = paramList1.size();
    if (i2 < i3)
    {
      com.viber.voip.stickers.entity.a locala = (com.viber.voip.stickers.entity.a)paramList1.get(i2);
      if (locala.e() == paramInt)
        i1 = i2;
      a.a locala1;
      boolean bool;
      if ((!locala.g()) && (!locala.h()) && (!locala.o()))
      {
        locala1 = a.a.c;
        bool = true;
      }
      while (true)
      {
        paramList.add(new a.d(locala.e(), locala.a(), false, locala.m(), locala.h(), locala.n(), bool, locala.o(), locala1));
        i2++;
        break;
        if ((locala.d()) && (!locala.h()))
        {
          locala1 = a.a.b;
          bool = false;
        }
        else
        {
          locala1 = a.a.a;
          bool = false;
        }
      }
    }
    if (this.l.g())
      paramList.add(new a.d(5, -1, true, false, false, false, false, false, a.a.a));
    return i1;
  }

  public View a(View paramView)
  {
    if ((!this.d) || (paramView == null))
    {
      if (paramView == null)
        this.d = false;
      g();
    }
    return this.f;
  }

  protected void a(int paramInt)
  {
    this.i.c().a(paramInt, null);
  }

  public void a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default:
      this.b.f().a();
      this.h = paramInt1;
      this.c.a(paramInt1, true);
      a(paramInt1);
      c(paramInt1);
    case 3:
    case 4:
    case 2:
    case 5:
    }
    do
    {
      return;
      i.a().A().a(this.a);
      return;
      ad.a((MessageComposerView)((View)this.e.getParent()).findViewById(R.id.message_composer)).a(this.a);
      return;
      ad.i().a(this.a);
      return;
    }
    while (!s());
    this.a.startActivity(new Intent("com.viber.voip.action.STICKER_MARKET_SETTINGS"));
  }

  public void a(int paramInt, z.a parama)
  {
    this.h = paramInt;
    if (this.d)
      this.i.c().a(this.h, parama);
  }

  protected void a(LayoutInflater paramLayoutInflater, com.viber.voip.stickers.entity.a parama)
  {
    this.i.a(parama, this.g, this.n, paramLayoutInflater);
    this.g.addView(this.i.c().b());
  }

  public void a(c paramc)
  {
    this.l = paramc;
    this.j.a(this.l);
  }

  protected void a(com.viber.voip.stickers.entity.a parama, int paramInt1, List<com.viber.voip.stickers.entity.a> paramList, int paramInt2)
  {
    int i1;
    int i2;
    if ((2 == paramInt2) || (parama.e() != paramInt1))
    {
      i1 = 1;
      i2 = parama.e();
      if (i1 == 0)
        break label53;
    }
    label53: for (a.c localc = a.c.c; ; localc = a.c.a)
    {
      a(i2, paramList, localc);
      return;
      i1 = 0;
      break;
    }
  }

  protected boolean a(com.viber.voip.stickers.entity.a parama)
  {
    this.q.addFirst(parama.e());
    return true;
  }

  protected List<com.viber.voip.stickers.entity.a> b()
  {
    ArrayList localArrayList = new ArrayList(this.b.g());
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
      if (((com.viber.voip.stickers.entity.a)localIterator.next()).h())
        localIterator.remove();
    return localArrayList;
  }

  public void b(int paramInt)
  {
  }

  public boolean b(com.viber.voip.stickers.entity.a parama)
  {
    if (parama == null)
      return false;
    this.c.a(parama.e(), false);
    d(parama.e());
    return true;
  }

  protected com.viber.voip.stickers.e.b c()
  {
    return new b();
  }

  protected void c(int paramInt)
  {
    Engine localEngine = ViberApplication.getInstance().getEngine(true);
    ViberApplication.getInstance().getEngine(true).getCdrController().handleReportStickerMenuExposures(localEngine.getPhoneController().generateSequence(), String.valueOf(paramInt));
  }

  public boolean d()
  {
    return this.d;
  }

  protected void e()
  {
    int i1 = this.b.x();
    if (i1 != 0)
    {
      this.h = i1;
      d(this.h);
    }
  }

  public void f()
  {
  }

  public void h()
  {
    this.p.stopStickerPromo();
  }

  public void i()
  {
    if (this.d)
    {
      this.i.a();
      m();
    }
  }

  public void j()
  {
    this.i.b();
    this.p.stopStickerPromo();
  }

  public void n()
  {
    if (this.d)
    {
      this.c.a(this.h, false);
      this.d = false;
    }
    this.k.removeCallbacksAndMessages(this.o);
    l();
    this.j.a();
  }

  public void o()
  {
    if (this.d)
      m();
  }

  public void p()
  {
  }

  public void q()
  {
    if ((s()) && ((this.a instanceof Activity)))
      StickerMarketActivity.a(6, "+", "Top");
  }

  public a r()
  {
    return this.c;
  }

  public static abstract interface a
  {
    public abstract int a();

    public abstract void a(int paramInt, boolean paramBoolean);
  }

  protected class b extends n
  {
    protected b()
    {
    }

    public void onStickerDeployed(Sticker paramSticker)
    {
      if (cv.this.d())
        cv.this.i.c().a(paramSticker);
    }

    public void onStickerPackageDeployed(com.viber.voip.stickers.entity.a parama)
    {
      if (!parama.o())
        cv.this.a(parama);
    }
  }

  public static class c
  {
    private final int a;
    private final int b;
    private final Drawable c;
    private final Drawable d;
    private final Drawable e;
    private final Drawable f;
    private final boolean g;
    private final boolean h;

    c(int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramDrawable1;
      this.d = paramDrawable2;
      this.e = paramDrawable3;
      this.f = paramDrawable4;
      this.g = paramBoolean1;
      this.h = paramBoolean2;
    }

    public int a()
    {
      return this.a;
    }

    public int b()
    {
      return this.b;
    }

    public Drawable c()
    {
      return this.c;
    }

    public Drawable d()
    {
      return this.e;
    }

    public Drawable e()
    {
      return this.d;
    }

    public Drawable f()
    {
      return this.f;
    }

    public boolean g()
    {
      return this.g;
    }

    public static class a
    {
      private int a;
      private int b;
      private Drawable c;
      private Drawable d;
      private Drawable e;
      private Drawable f;
      private boolean g = true;
      private boolean h = true;

      public a a(int paramInt)
      {
        this.a = paramInt;
        return this;
      }

      public a a(Drawable paramDrawable)
      {
        this.c = paramDrawable;
        return this;
      }

      public a a(boolean paramBoolean)
      {
        this.g = paramBoolean;
        return this;
      }

      public cv.c a()
      {
        return new cv.c(this.a, this.b, this.c, this.e, this.d, this.f, this.g, this.h);
      }

      public a b(int paramInt)
      {
        this.b = paramInt;
        return this;
      }

      public a b(Drawable paramDrawable)
      {
        this.d = paramDrawable;
        return this;
      }

      public a b(boolean paramBoolean)
      {
        this.h = paramBoolean;
        return this;
      }

      public a c(Drawable paramDrawable)
      {
        this.e = paramDrawable;
        return this;
      }

      public a d(Drawable paramDrawable)
      {
        this.f = paramDrawable;
        return this;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.cv
 * JD-Core Version:    0.6.2
 */