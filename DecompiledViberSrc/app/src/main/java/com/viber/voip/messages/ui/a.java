package com.viber.voip.messages.ui;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.viber.voip.ads.b.c.a.b;
import com.viber.voip.ads.b.c.a.i;
import com.viber.voip.messages.adapters.j;
import com.viber.voip.messages.adapters.u;
import com.viber.voip.ui.g.d;

public class a extends BaseAdapter
{
  protected final ListAdapter a;
  protected final com.viber.voip.messages.adapters.a.c.a b;
  protected int c;
  private final LayoutInflater d;
  private final i e;
  private final a f;
  private com.viber.voip.ads.b.c.c.c g;
  private j h;
  private final com.viber.voip.ads.b.b.b.c i;
  private final b j;
  private final int k;
  private View l;

  public a(Context paramContext, ListAdapter paramListAdapter, com.viber.voip.messages.adapters.a.c.a parama, final i parami, com.viber.voip.ads.b.b.b.c paramc, b paramb, int paramInt)
  {
    this.i = paramc;
    this.j = paramb;
    this.a = paramListAdapter;
    this.d = LayoutInflater.from(paramContext);
    this.k = paramInt;
    if (parama != null)
      this.b = parama;
    while (true)
    {
      this.e = new i()
      {
        public void a(com.viber.voip.ads.b.b.b.a paramAnonymousa, View paramAnonymousView)
        {
          parami.a(paramAnonymousa, paramAnonymousView);
        }

        public void a(com.viber.voip.ads.b.b.b.a paramAnonymousa, View paramAnonymousView, String paramAnonymousString)
        {
          parami.a(paramAnonymousa, paramAnonymousView, paramAnonymousString);
        }

        public void b(com.viber.voip.ads.b.b.b.a paramAnonymousa, View paramAnonymousView)
        {
          parami.b(paramAnonymousa, paramAnonymousView);
          a.this.b();
        }

        public void c(com.viber.voip.ads.b.b.b.a paramAnonymousa, View paramAnonymousView)
        {
          parami.c(paramAnonymousa, paramAnonymousView);
          a.this.c();
        }

        public void d(com.viber.voip.ads.b.b.b.a paramAnonymousa, View paramAnonymousView)
        {
          parami.d(paramAnonymousa, paramAnonymousView);
        }
      };
      this.f = new a(null);
      paramListAdapter.registerDataSetObserver(this.f);
      d();
      return;
      if ((paramListAdapter instanceof u))
        this.b = ((u)paramListAdapter).d();
      else
        this.b = null;
    }
  }

  private boolean a(int paramInt)
  {
    return (a()) && (paramInt == this.c);
  }

  private int b(int paramInt)
  {
    if ((a()) && (this.c < paramInt))
      paramInt--;
    return paramInt;
  }

  private View d()
  {
    if (this.l == null)
    {
      this.l = this.d.inflate(this.k, null);
      com.viber.voip.messages.adapters.a.b.a locala = new com.viber.voip.messages.adapters.a.b.a(this.l, this.e, this.i, this.j);
      this.l.setTag(locala);
    }
    return this.l;
  }

  public void a(com.viber.voip.ads.b.c.c.c paramc)
  {
    if ((this.g != null) && (this.g.equals(paramc)));
    while ((this.g == null) && (paramc == null))
      return;
    this.g = paramc;
    notifyDataSetChanged();
  }

  protected boolean a()
  {
    return (this.g != null) && (this.a.getCount() != 0);
  }

  public boolean areAllItemsEnabled()
  {
    return false;
  }

  protected void b()
  {
    a(null);
  }

  protected void c()
  {
    a(null);
  }

  public int getCount()
  {
    int m = this.a.getCount();
    if (a())
      m++;
    return m;
  }

  public Object getItem(int paramInt)
  {
    if (a(paramInt))
    {
      if ((this.h == null) || (this.h.j() != this.g))
        this.h = new j(this.g);
      return this.h;
    }
    return this.a.getItem(b(paramInt));
  }

  public long getItemId(int paramInt)
  {
    if (a(paramInt))
      return -10L;
    return this.a.getItemId(b(paramInt));
  }

  public int getItemViewType(int paramInt)
  {
    if (a(paramInt))
      return this.a.getViewTypeCount();
    return this.a.getItemViewType(b(paramInt));
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (a(paramInt))
    {
      if (paramView == null);
      for (Object localObject = null; ; localObject = paramView.getTag())
      {
        if (!(localObject instanceof com.viber.voip.messages.adapters.a.b.a))
          paramView = d();
        ((d)paramView.getTag()).a((com.viber.voip.messages.adapters.a.a)getItem(paramInt), this.b);
        return paramView;
      }
    }
    return this.a.getView(b(paramInt), paramView, paramViewGroup);
  }

  public int getViewTypeCount()
  {
    return 1 + this.a.getViewTypeCount();
  }

  public boolean isEnabled(int paramInt)
  {
    if (a(paramInt))
      return true;
    return this.a.isEnabled(b(paramInt));
  }

  private class a extends DataSetObserver
  {
    private a()
    {
    }

    public void onChanged()
    {
      a.this.notifyDataSetChanged();
    }

    public void onInvalidated()
    {
      a.this.notifyDataSetInvalidated();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.a
 * JD-Core Version:    0.6.2
 */