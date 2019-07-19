package com.viber.voip.messages.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.R.id;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.g;
import com.viber.voip.messages.adapters.z.a;
import com.viber.voip.messages.conversation.ui.at;
import com.viber.voip.messages.ui.d.a.a.d;
import com.viber.voip.messages.ui.d.b.k;
import com.viber.voip.messages.ui.d.b.l;
import com.viber.voip.messages.ui.d.d.a;
import com.viber.voip.messages.ui.expanel.ExpandablePanelLayout;
import com.viber.voip.settings.d.ax;
import com.viber.voip.settings.d.r;
import com.viber.voip.sound.tones.IRingtonePlayer;
import com.viber.voip.stickers.i;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class x extends cv
{
  private static final Logger m = ViberEnv.getLogger();
  private MessageComposerView.b n = MessageComposerView.b.a;
  private SparseArray<k> o = new SparseArray();
  private b p;
  private com.viber.voip.messages.ui.d.a q;
  private Set<View> r = new HashSet();

  public x(Context paramContext, View paramView, LayoutInflater paramLayoutInflater, at paramat, b paramb, com.viber.voip.messages.ui.d.a.a parama)
  {
    super(paramContext, paramView, paramLayoutInflater, paramb, new cv.a()
    {
      public int a()
      {
        return d.ax.j.d();
      }

      public void a(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        d.ax.j.a(paramAnonymousInt);
      }
    }
    , b(paramat));
    this.p = paramb;
    this.q = new com.viber.voip.messages.ui.d.a(paramContext, parama, this.l);
  }

  private void a(MessageComposerView.b paramb)
  {
    this.n = paramb;
    d.ax.i.a(paramb.ordinal());
  }

  private static cv.c b(at paramat)
  {
    return new cv.c.a().b(paramat.f()).a(paramat.g()).c(paramat.i()).b(paramat.j()).d(paramat.h()).a();
  }

  private void b(int paramInt1, int paramInt2)
  {
    k localk = d(paramInt1);
    if (localk != null)
    {
      localk.b.a(paramInt2);
      c(localk.a);
      if (paramInt1 != 2)
        break label43;
    }
    label43: for (MessageComposerView.b localb = MessageComposerView.b.d; ; localb = MessageComposerView.b.c)
    {
      a(localb);
      return;
    }
  }

  private void b(View paramView)
  {
    this.r.add(paramView);
    this.g.addView(paramView);
  }

  private void c(View paramView)
  {
    s();
    paramView.setVisibility(0);
  }

  private k d(int paramInt)
  {
    k localk1;
    if (paramInt == 0)
      localk1 = null;
    do
    {
      return localk1;
      localk1 = (k)this.o.get(paramInt);
    }
    while (localk1 != null);
    k localk2 = l.a(paramInt, this.a, this.b, g.a());
    this.o.put(paramInt, localk2);
    b(localk2.a);
    return localk2;
  }

  private void s()
  {
    Iterator localIterator = this.r.iterator();
    while (localIterator.hasNext())
      ((View)localIterator.next()).setVisibility(8);
  }

  private void t()
  {
    if ((this.b != null) && (this.n == MessageComposerView.b.b))
    {
      int i = this.c.a();
      if ((i > 0) && (this.b.g(i) != null))
      {
        Engine localEngine = ViberApplication.getInstance().getEngine(true);
        localEngine.getCdrController().handleReportStickerMenuExposures(localEngine.getPhoneController().generateSequence(), String.valueOf(this.b.g(i).e()));
      }
    }
  }

  private boolean u()
  {
    return ((this.e instanceof ExpandablePanelLayout)) && (((ExpandablePanelLayout)this.e).b(R.id.options_menu_open_stickers));
  }

  protected int a(List<a.d> paramList, int paramInt, List<com.viber.voip.stickers.entity.a> paramList1)
  {
    paramList.add(new a.d(1, -1, true, false, false, false, false, false, com.viber.voip.messages.ui.d.a.a.a.a));
    int i = super.a(paramList, paramInt, paramList1);
    if ((-1 != i) && (((this.n == MessageComposerView.b.c) && (!((com.viber.voip.stickers.entity.a)paramList1.get(i)).h())) || ((this.n == MessageComposerView.b.d) && (((com.viber.voip.stickers.entity.a)paramList1.get(i)).g()))))
      this.n = MessageComposerView.b.b;
    switch (4.a[this.n.ordinal()])
    {
    default:
      return i;
    case 1:
      k();
      return 0;
    case 2:
      g();
    case 3:
    case 4:
    }
    return i + 1;
  }

  protected void a(int paramInt)
  {
    this.i.c().a(paramInt, new z.a()
    {
      public void a()
      {
        x.this.g();
      }
    });
  }

  public void a(int paramInt1, int paramInt2)
  {
    ViberApplication.getInstance().getRingtonePlayer().stopStickerPromo();
    if (1 == paramInt1)
    {
      k();
      return;
    }
    if (paramInt2 != 0)
    {
      this.h = paramInt1;
      this.c.a(paramInt1, true);
      b(paramInt2, paramInt1);
      c(paramInt1);
      return;
    }
    super.a(paramInt1, 0);
  }

  public void a(int paramInt, MessageComposerView.b paramb)
  {
    if (this.d)
    {
      k localk = d(paramInt);
      if (localk != null)
      {
        c(localk.a);
        localk.a.a(false);
      }
    }
    a(paramb);
  }

  protected void a(LayoutInflater paramLayoutInflater, com.viber.voip.stickers.entity.a parama)
  {
    super.a(paramLayoutInflater, parama);
    this.r.clear();
    this.o.clear();
    this.n = MessageComposerView.b.values()[d.ax.i.d()];
    this.r.add(this.i.c().b());
    this.q.a(paramLayoutInflater, this.g, this.e.getMeasuredWidth());
    b(this.q.a());
    if ((parama != null) && (this.n != MessageComposerView.b.a))
    {
      int i = l.a(parama);
      if (i != 0)
        b(i, parama.e());
    }
  }

  public void a(EditText paramEditText)
  {
    this.q.a(paramEditText);
  }

  public void a(at paramat)
  {
    a(b(paramat));
    this.q.a(this.l);
  }

  protected void a(com.viber.voip.stickers.entity.a parama, int paramInt1, List<com.viber.voip.stickers.entity.a> paramList, int paramInt2)
  {
    if (2 == paramInt2)
      g();
    while (true)
    {
      super.a(parama, paramInt1, paramList, paramInt2);
      return;
      if (parama.h())
        b(1, parama.e());
      else if ((!parama.o()) && (!parama.g()))
        b(2, parama.e());
    }
  }

  protected boolean a(com.viber.voip.stickers.entity.a parama)
  {
    if ((!parama.l()) && (u()))
    {
      super.a(parama);
      return true;
    }
    return false;
  }

  protected List<com.viber.voip.stickers.entity.a> b()
  {
    return this.b.g();
  }

  public boolean b(com.viber.voip.stickers.entity.a parama)
  {
    boolean bool = super.b(parama);
    if (bool)
    {
      if (u())
        g();
      if ((d()) && (this.i.c().g() != parama.e()))
        this.i.c().a(parama);
    }
    return bool;
  }

  protected com.viber.voip.stickers.e.b c()
  {
    // Byte code:
    //   0: new 423	com/viber/voip/messages/ui/x$2
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 424	com/viber/voip/messages/ui/x$2:<init>	(Lcom/viber/voip/messages/ui/x;)V
    //   8: areturn
  }

  public boolean d()
  {
    return this.d;
  }

  protected void e()
  {
    if (u())
      super.e();
  }

  public void f()
  {
    this.p.b();
    if (d.r.w.d())
    {
      d.r.w.a(false);
      List localList = i.a().g();
      com.viber.voip.stickers.entity.a locala = this.b.h(this.h);
      if (locala != null)
        a(locala, this.h, localList, 1);
    }
  }

  public void g()
  {
    if (this.d)
      c(this.i.c().b());
    a(MessageComposerView.b.b);
  }

  public void i()
  {
    super.i();
    if (this.d)
      t();
  }

  public void k()
  {
    if (this.d)
    {
      c(this.q.a());
      this.c.a(0, true);
      this.j.a(0);
      this.p.a();
    }
    a(MessageComposerView.b.a);
  }

  public void l()
  {
    a(1, MessageComposerView.b.c);
  }

  public void m()
  {
    a(2, MessageComposerView.b.d);
  }

  public void n()
  {
    super.n();
    if (this.d)
      d.ax.i.a(this.n.ordinal());
    this.q.b();
  }

  public static abstract interface a
  {
    public abstract void a();
  }

  public static abstract interface b extends d.a, x.a, x.c, x.d
  {
  }

  public static abstract interface c
  {
    public abstract void b();
  }

  public static abstract interface d
  {
    public abstract void a(com.viber.voip.messages.extensions.model.d paramd, Bundle paramBundle);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.x
 * JD-Core Version:    0.6.2
 */