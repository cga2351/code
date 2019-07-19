package com.viber.voip.messages.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.bot.item.KeyboardItem;
import com.viber.voip.bot.item.b;
import com.viber.voip.stickers.ui.d;
import java.util.ArrayList;
import java.util.List;

public abstract class a<I extends KeyboardItem> extends BaseAdapter
{
  private static final Logger e = ViberEnv.getLogger();
  protected List<b<I>> a;
  protected LayoutInflater b;
  protected com.viber.voip.stickers.ui.a c = a(paramContext);
  protected int d;
  private final c f;

  public a(Context paramContext, c paramc, LayoutInflater paramLayoutInflater)
  {
    this.b = paramLayoutInflater;
    this.a = new ArrayList();
    this.f = paramc;
  }

  protected abstract int a();

  public b<I> a(int paramInt)
  {
    return (b)this.a.get(paramInt);
  }

  protected abstract a a(ViewGroup paramViewGroup);

  protected abstract com.viber.voip.stickers.ui.a a(Context paramContext);

  protected void b(int paramInt)
  {
    this.d = paramInt;
  }

  public int getCount()
  {
    return this.a.size();
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    a locala;
    if ((paramView == null) || (this.d > ((a)paramView.getTag()).d.length))
    {
      locala = a(paramViewGroup);
      locala.a();
      locala.b.setTag(locala);
    }
    while (true)
    {
      locala.a(a(paramInt), paramInt, getCount(), 0L, a(), this.f);
      return locala.b;
      locala = (a)paramView.getTag();
    }
  }

  public static abstract class a<I extends KeyboardItem, IW extends com.viber.voip.bot.a.c>
  {
    protected LayoutInflater a;
    public d b;
    public b<I> c;
    public IW[] d;
    protected final int e;
    protected final com.viber.voip.stickers.ui.a f;
    private final ViewGroup g;

    public a(LayoutInflater paramLayoutInflater, com.viber.voip.stickers.ui.a parama, ViewGroup paramViewGroup, int paramInt)
    {
      this.a = paramLayoutInflater;
      this.f = parama;
      this.g = paramViewGroup;
      this.e = paramInt;
    }

    protected abstract IW a(ViewGroup paramViewGroup);

    protected d a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
    {
      d locald = new d(paramViewGroup.getContext());
      if ((paramViewGroup instanceof AbsListView))
      {
        locald.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        return locald;
      }
      locald.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
      return locald;
    }

    public final void a()
    {
      if (this.b == null)
        this.b = a(this.a, this.g);
      this.b.setMeasure(this.f);
      if (this.d == null)
      {
        this.d = a(this.e);
        for (int i = 0; i < this.e; i++)
        {
          com.viber.voip.bot.a.c localc = a(this.g);
          this.d[i] = localc;
          this.b.addView(localc.c);
        }
      }
    }

    public void a(b<I> paramb, int paramInt1, int paramInt2, long paramLong, int paramInt3, c paramc)
    {
      this.c = paramb;
      a(this.b, paramInt1, paramInt2);
      this.b.a();
      List localList = this.c.a();
      for (int i = 0; i < localList.size(); i++)
      {
        int k = i + paramInt1 * paramInt3;
        this.d[i].a((KeyboardItem)localList.get(i), k, paramLong, paramc);
        this.d[i].c.setVisibility(0);
        this.b.a(this.d[i].c, this.d[i].d);
      }
      for (int j = localList.size(); j < this.d.length; j++)
      {
        com.viber.voip.bot.a.c localc = this.d[j];
        localc.a();
        localc.c.setVisibility(8);
      }
    }

    protected void a(d paramd, int paramInt1, int paramInt2)
    {
      if (paramInt1 >= paramInt2 - 1);
      for (boolean bool = true; ; bool = false)
      {
        paramd.a(false, bool);
        return;
      }
    }

    protected abstract IW[] a(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a
 * JD-Core Version:    0.6.2
 */