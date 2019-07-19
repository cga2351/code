package com.viber.voip.messages.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.viber.common.permission.b;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.gallery.GalleryItem;
import com.viber.voip.messages.extensions.model.ChatExtensionLoaderEntity;
import com.viber.voip.permissions.f;
import com.viber.voip.permissions.m;
import com.viber.voip.permissions.n;
import java.util.ArrayList;
import java.util.List;

public abstract class d
  implements View.OnClickListener, ao.a
{
  static final Logger a = ViberEnv.getLogger();
  protected Context b;
  private final LayoutInflater c;
  private final com.viber.common.permission.c d;
  private RecyclerView e;
  private b f;
  private int g;
  private k h;
  private g i;
  private f j;
  private i k;
  private e l;
  private h m;
  private n n;
  private l o;
  private m p;
  private o q;
  private p r;
  private c s;
  private d t;
  private Handler u;
  private final b v;
  private Runnable w = new Runnable()
  {
    public void run()
    {
      int i = d.this.a();
      if (d.e(d.this) != i)
      {
        d.a(d.this, i);
        d.f(d.this).setLayoutManager(new GridLayoutManager(d.this.b, d.e(d.this)));
        d.this.a(d.f(d.this), d.e(d.this));
      }
    }
  };

  public d(Context paramContext, LayoutInflater paramLayoutInflater)
  {
    this.b = paramContext;
    this.c = paramLayoutInflater;
    this.d = com.viber.common.permission.c.a(paramContext);
    this.u = av.e.a.a();
    Context localContext = this.b;
    Pair[] arrayOfPair = new Pair[4];
    arrayOfPair[0] = m.a(14);
    arrayOfPair[1] = m.a(102);
    arrayOfPair[2] = m.a(80);
    arrayOfPair[3] = m.a(131);
    this.v = new f(localContext, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        default:
          return;
        case 14:
          d.a(d.this).f();
          return;
        case 102:
          d.b(d.this).j();
          return;
        case 80:
          d.c(d.this).H_();
          return;
        case 131:
        }
        d.d(d.this).e();
      }
    };
  }

  private void k()
  {
    if (this.d.a(n.j))
    {
      this.n.H_();
      return;
    }
    this.d.a(this.b, 80, n.j);
  }

  private void l()
  {
    if (this.d.a(n.m))
    {
      this.o.j();
      return;
    }
    this.d.a(this.b, 102, n.m);
  }

  private void m()
  {
    if (this.d.a(n.m))
    {
      this.j.e();
      return;
    }
    this.d.a(this.b, 131, n.m);
  }

  private void n()
  {
    if (this.d.a(n.b))
    {
      this.l.f();
      return;
    }
    this.d.a(this.b, 14, n.b);
  }

  protected abstract int a();

  public View a(View paramView)
  {
    if (paramView != null)
      return paramView;
    View localView = this.c.inflate(R.layout.menu_message_options, null);
    this.g = a();
    this.e = ((RecyclerView)localView.findViewById(R.id.buttons_grid));
    this.e.setLayoutManager(new GridLayoutManager(this.b, this.g));
    a(this.e);
    a(this.e, this.g);
    this.f = new b(b(), this, f(), this.c);
    this.e.setAdapter(this.f);
    this.u.postDelayed(this.w, 100L);
    return localView;
  }

  protected void a(RecyclerView paramRecyclerView)
  {
  }

  protected void a(RecyclerView paramRecyclerView, int paramInt)
  {
  }

  public void a(c paramc)
  {
    this.s = paramc;
  }

  public void a(d paramd)
  {
    this.t = paramd;
  }

  public void a(e parame)
  {
    this.l = parame;
  }

  public void a(f paramf)
  {
    this.j = paramf;
  }

  public void a(g paramg)
  {
    this.i = paramg;
  }

  public void a(h paramh)
  {
    this.m = paramh;
  }

  public void a(i parami)
  {
    this.k = parami;
  }

  public void a(k paramk)
  {
    this.h = paramk;
  }

  public void a(l paraml)
  {
    this.o = paraml;
  }

  public void a(m paramm)
  {
    this.p = paramm;
  }

  public void a(n paramn)
  {
    this.n = paramn;
  }

  public void a(o paramo)
  {
    this.q = paramo;
  }

  public void a(p paramp)
  {
    this.r = paramp;
  }

  protected abstract void a(ArrayList<a> paramArrayList);

  public abstract void a(List<ab.a> paramList);

  protected abstract int b();

  public void c()
  {
    this.d.a(this.v);
  }

  public void d()
  {
    this.d.b(this.v);
  }

  public void e()
  {
    this.u.removeCallbacks(this.w);
  }

  protected ArrayList<a> f()
  {
    ArrayList localArrayList = new ArrayList();
    a(localArrayList);
    while (localArrayList.size() % this.g != 0)
      localArrayList.add(new a(-1, -1, "", null));
    return localArrayList;
  }

  public final void g()
  {
    if (this.f != null)
    {
      this.f.a(f());
      this.f.notifyDataSetChanged();
    }
  }

  public void h()
  {
    ap.a(this);
  }

  public void i()
  {
    ap.b(this);
  }

  public void j()
  {
    ap.c(this);
  }

  public void onClick(View paramView)
  {
    int i1 = ((Integer)paramView.getTag()).intValue();
    if ((ab.a.d.q == i1) && (this.h != null))
      this.i.b();
    do
    {
      return;
      if ((ab.a.k.q == i1) && (this.j != null))
      {
        m();
        return;
      }
      if ((ab.a.j.q == i1) && (this.k != null))
      {
        this.k.l();
        return;
      }
      if ((ab.a.c.q == i1) && (this.l != null))
      {
        n();
        return;
      }
      if ((ab.a.b.q == i1) && (this.m != null))
      {
        this.m.c();
        return;
      }
      if ((ab.a.l.q == i1) && (this.n != null))
      {
        k();
        return;
      }
      if ((ab.a.i.q == i1) && (this.o != null))
      {
        l();
        return;
      }
      if ((ab.a.h.q == i1) && (this.p != null))
      {
        this.p.a();
        return;
      }
      if ((ab.a.m.q == i1) && (this.q != null))
      {
        this.q.g();
        return;
      }
      if ((ab.a.e.q == i1) && (this.r != null))
      {
        this.r.d();
        return;
      }
      if ((ab.a.g.q == i1) && (this.s != null))
      {
        this.s.a(false, "Keyboard", null, null);
        return;
      }
    }
    while ((ab.a.n.q != i1) || (this.t == null));
    this.t.h();
  }

  protected static class a
  {
    protected final int a;
    protected final int b;
    protected final String c;
    protected final String d;
    protected final Drawable e;
    protected boolean f;

    protected a(int paramInt1, int paramInt2, String paramString, Drawable paramDrawable)
    {
      this(paramInt1, paramInt2, paramString, null, paramDrawable, false);
    }

    protected a(int paramInt1, int paramInt2, String paramString1, String paramString2, Drawable paramDrawable, boolean paramBoolean)
    {
      this.b = paramInt1;
      this.a = paramInt2;
      this.c = paramString1;
      this.e = paramDrawable;
      this.d = paramString2;
      this.f = paramBoolean;
    }
  }

  private static class b extends RecyclerView.Adapter<a>
  {
    private final int a;
    private final View.OnClickListener b;
    private final ArrayList<d.a> c;
    private final LayoutInflater d;

    b(int paramInt, View.OnClickListener paramOnClickListener, ArrayList<d.a> paramArrayList, LayoutInflater paramLayoutInflater)
    {
      this.a = paramInt;
      this.b = paramOnClickListener;
      this.c = paramArrayList;
      this.d = paramLayoutInflater;
    }

    public a a(ViewGroup paramViewGroup, int paramInt)
    {
      return new a(this.d.inflate(this.a, paramViewGroup, false), this.b);
    }

    public void a(a parama, int paramInt)
    {
      d.a locala = (d.a)this.c.get(paramInt);
      c localc = parama.a;
      if (locala.a >= 0);
      for (boolean bool = true; ; bool = false)
      {
        localc.setEnabled(bool);
        localc.setId(locala.b);
        localc.setTag(Integer.valueOf(locala.a));
        localc.setText(locala.c);
        localc.setImage(locala.e);
        localc.setSubtext(locala.d);
        localc.setNew(locala.f);
        return;
      }
    }

    public void a(ArrayList<d.a> paramArrayList)
    {
      this.c.clear();
      this.c.addAll(paramArrayList);
    }

    public int getItemCount()
    {
      return this.c.size();
    }

    public long getItemId(int paramInt)
    {
      return paramInt;
    }

    public final class a extends RecyclerView.ViewHolder
    {
      final c a;

      a(View paramOnClickListener, View.OnClickListener arg3)
      {
        super();
        this.a = ((c)paramOnClickListener);
        View.OnClickListener localOnClickListener;
        this.a.setOnClickListener(localOnClickListener);
      }
    }
  }

  public static abstract interface c
  {
    public abstract void a(boolean paramBoolean, String paramString1, ChatExtensionLoaderEntity paramChatExtensionLoaderEntity, String paramString2);
  }

  public static abstract interface d
  {
    public abstract void h();
  }

  public static abstract interface e
  {
    public abstract void f();
  }

  public static abstract interface f
  {
    public abstract void e();
  }

  public static abstract interface g extends d.k
  {
    public abstract void a(ArrayList<GalleryItem> paramArrayList);

    public abstract void b();

    public abstract void k();
  }

  public static abstract interface h
  {
    public abstract void c();
  }

  public static abstract interface i
  {
    public abstract void l();
  }

  public static abstract interface j extends d.c, d.d, d.e, d.f, d.g, d.h, d.i, d.k, d.l, d.m, d.n, d.o, d.p
  {
  }

  public static abstract interface k
  {
    public abstract void m();
  }

  public static abstract interface l
  {
    public abstract void j();
  }

  public static abstract interface m
  {
    public abstract void a();
  }

  public static abstract interface n
  {
    public abstract void H_();
  }

  public static abstract interface o
  {
    public abstract void g();
  }

  public static abstract interface p
  {
    public abstract void d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.d
 * JD-Core Version:    0.6.2
 */