package com.viber.voip.messages.conversation.adapter.e;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.viber.dexshared.Logger;
import com.viber.voip.ConversationListView;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.w;
import com.viber.voip.messages.controller.y;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.aj;
import com.viber.voip.messages.d.l;
import com.viber.voip.stickers.b;

public class c
{
  private static final Logger a = ViberEnv.getLogger();
  private final com.viber.voip.messages.conversation.q b;
  private final com.viber.voip.messages.conversation.adapter.a.c.a.i c;
  private final b d;
  private final aj e;
  private final w f;
  private final com.viber.voip.u.d g;
  private final com.viber.voip.q.i h;
  private final com.viber.voip.stickers.f i;
  private final q[] j;
  private final y k;
  private final ConversationListView l;
  private final Handler m;
  private int n;
  private long o;
  private int p = 0;
  private boolean q;
  private final Runnable r = new d(this);
  private final AbsListView.OnScrollListener s = new AbsListView.OnScrollListener()
  {
    public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      c.a(c.this, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
    }

    public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
    {
      c.a(c.this, paramAnonymousInt);
    }
  };

  public c(Handler paramHandler, ConversationListView paramConversationListView, b paramb, aj paramaj, w paramw, com.viber.voip.u.d paramd, com.viber.voip.q.i parami, y paramy, com.viber.voip.stickers.f paramf, com.viber.voip.messages.conversation.q paramq, com.viber.voip.messages.conversation.adapter.a.c.a.i parami1, q[] paramArrayOfq)
  {
    this.m = paramHandler;
    this.l = paramConversationListView;
    this.c = parami1;
    this.b = paramq;
    this.d = paramb;
    this.e = paramaj;
    this.f = paramw;
    this.g = paramd;
    this.h = parami;
    this.k = paramy;
    this.i = paramf;
    this.j = paramArrayOfq;
    this.l.a(this.s);
  }

  private void a(int paramInt)
  {
    com.viber.voip.messages.conversation.adapter.a.c.a.i locali = this.c;
    if (paramInt == 0);
    for (boolean bool = true; ; bool = false)
    {
      locali.e(bool);
      this.p = paramInt;
      this.d.a(paramInt);
      this.k.a(paramInt);
      switch (paramInt)
      {
      default:
        return;
      case 1:
      case 0:
      }
    }
    this.e.a();
    return;
    d();
  }

  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    b(paramInt1, paramInt2, paramInt3);
    if ((this.p != 2) && (this.p != 1))
    {
      if (this.c.n())
      {
        this.m.removeCallbacks(this.r);
        this.m.postDelayed(this.r, 350L);
      }
    }
    else
      return;
    d();
  }

  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0);
    do
    {
      return;
      if (!this.q)
      {
        int[] arrayOfInt2 = this.b.a(true, paramInt1, 20);
        this.q = true;
        this.n = paramInt1;
        this.i.a(arrayOfInt2, null);
        return;
      }
    }
    while ((paramInt1 % 15 != 0) || (this.n == paramInt1));
    boolean bool;
    if (this.n > paramInt1)
    {
      bool = true;
      if (!bool)
        break label117;
    }
    label117: for (int i1 = paramInt1; ; i1 = -1 + (paramInt1 + paramInt2))
    {
      int[] arrayOfInt1 = this.b.a(bool, i1, 20);
      this.n = paramInt1;
      this.i.a(arrayOfInt1, null);
      return;
      bool = false;
      break;
    }
  }

  public void a()
  {
    if ((this.o > 0L) && (this.g.b(this.o)))
    {
      this.g.c();
      this.h.a();
      this.g.a();
      d();
    }
    this.d.b();
  }

  public void a(long paramLong)
  {
    if (this.o != paramLong)
    {
      this.o = paramLong;
      this.k.b();
      this.g.a(paramLong);
      this.l.f();
      this.f.a();
      this.d.a(paramLong);
    }
  }

  public void a(boolean paramBoolean)
  {
    this.e.a(paramBoolean);
    if (paramBoolean)
    {
      d();
      return;
    }
    this.e.a();
  }

  public void b()
  {
    this.d.c();
    this.e.a();
    this.g.c();
    this.h.a();
  }

  public void c()
  {
    this.m.removeCallbacks(this.r);
    this.d.b(this.o);
    this.k.c();
    this.e.b();
    this.g.c(this.o);
  }

  void d()
  {
    int i1 = this.l.getFirstVisiblePosition();
    int i2 = 1 + (this.l.getLastVisiblePosition() - i1);
    q[] arrayOfq1 = this.j;
    int i3 = arrayOfq1.length;
    for (int i4 = 0; i4 < i3; i4++)
      arrayOfq1[i4].a();
    int i5 = 0;
    if (i5 < i2)
    {
      com.viber.voip.ui.g.a locala = (com.viber.voip.ui.g.a)this.l.getChildAt(i5).getTag();
      if (locala == null);
      while (true)
      {
        i5++;
        break;
        com.viber.voip.ui.g.d locald = locala.a();
        com.viber.voip.messages.conversation.adapter.a.a locala1 = (com.viber.voip.messages.conversation.adapter.a.a)locald.d();
        if (locala1 != null)
        {
          l locall = locala1.d();
          aa localaa = locala1.c();
          View localView = locala.b().a();
          if (localaa.ax())
            locald.a(locala1, this.c);
          q[] arrayOfq3 = this.j;
          int i8 = arrayOfq3.length;
          for (int i9 = 0; (i9 < i8) && (!arrayOfq3[i9].a(localView, locall, localaa)); i9++);
        }
      }
    }
    q[] arrayOfq2 = this.j;
    int i6 = arrayOfq2.length;
    for (int i7 = 0; i7 < i6; i7++)
      arrayOfq2[i7].b();
  }

  public void e()
  {
    this.q = false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.e.c
 * JD-Core Version:    0.6.2
 */