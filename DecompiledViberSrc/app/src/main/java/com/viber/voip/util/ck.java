package com.viber.voip.util;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ck<T extends RecyclerView.Adapter> extends RecyclerView.Adapter
{
  protected ArrayList<ck<T>.b> a = new ArrayList();
  protected ArrayList<ck<T>.a> b = new ArrayList();
  private Context c;
  private int d = 0;

  public ck()
  {
  }

  public ck(Context paramContext)
  {
    this.c = paramContext;
  }

  public int a(ck<T>.b paramck)
  {
    Iterator localIterator = this.a.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb == paramck)
        return i;
      i += localb.a.getItemCount();
    }
    return -1;
  }

  public ck<T>.b a(int paramInt)
  {
    int i = this.a.size();
    int j = 0;
    int n;
    for (int k = 0; k < i; k = n)
    {
      b localb = (b)this.a.get(k);
      int m = j + localb.a.getItemCount();
      if (paramInt < m)
      {
        localb.b = (paramInt - j);
        return localb;
      }
      n = k + 1;
      j = m;
    }
    return null;
  }

  public void a(int paramInt, T paramT)
  {
    this.a.add(paramInt, new b(paramT));
    this.b.add(paramInt, new a((b)this.a.get(paramInt)));
    paramT.registerAdapterDataObserver((RecyclerView.AdapterDataObserver)this.b.get(paramInt));
    notifyDataSetChanged();
  }

  public void a(T paramT)
  {
    a(this.a.size(), paramT);
  }

  public void a(View paramView)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramView);
    a(localArrayList);
  }

  public void a(List<View> paramList)
  {
    a(new c(this.c, paramList));
  }

  public int getItemCount()
  {
    Iterator localIterator = this.a.iterator();
    int i = 0;
    while (localIterator.hasNext())
      i += ((b)localIterator.next()).a.getItemCount();
    return i;
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    b localb = a(paramInt);
    int i = localb.a.getItemViewType(localb.b);
    if (localb.c.containsValue(Integer.valueOf(i)))
    {
      Iterator localIterator = localb.c.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (((Integer)localEntry.getValue()).intValue() == i)
          return ((Integer)localEntry.getKey()).intValue();
      }
    }
    this.d = (1 + this.d);
    localb.c.put(Integer.valueOf(this.d), Integer.valueOf(i));
    return this.d;
  }

  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    b localb = a(paramInt);
    localb.a.onBindViewHolder(paramViewHolder, localb.b);
  }

  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.c.containsKey(Integer.valueOf(paramInt)))
        return localb.a.onCreateViewHolder(paramViewGroup, ((Integer)localb.c.get(Integer.valueOf(paramInt))).intValue());
    }
    return null;
  }

  private class a extends RecyclerView.AdapterDataObserver
  {
    private ck<T>.b b;

    public a()
    {
      Object localObject;
      this.b = localObject;
    }

    public void onChanged()
    {
      ck.this.notifyDataSetChanged();
    }

    public void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      int i = ck.this.a(this.b);
      if (i != -1)
      {
        super.onItemRangeChanged(i + paramInt1, paramInt2);
        ck.this.notifyItemRangeChanged(i + paramInt1, paramInt2);
      }
    }

    public void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      if (ck.this.a(this.b) != -1)
      {
        super.onItemRangeInserted(paramInt1, paramInt2);
        ck.this.notifyItemRangeInserted(paramInt1, paramInt2);
      }
    }

    public void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      if (ck.this.a(this.b) != -1)
      {
        super.onItemRangeRemoved(paramInt1, paramInt2);
        ck.this.notifyItemRangeRemoved(paramInt1, paramInt2);
      }
    }
  }

  public class b
  {
    public final T a;
    public int b = 0;
    public Map<Integer, Integer> c = new HashMap();

    public b()
    {
      Object localObject;
      this.a = localObject;
    }
  }

  public static class c extends RecyclerView.Adapter
  {
    private List<View> a = null;
    private Context b;

    public c(Context paramContext, List<View> paramList)
    {
      this.b = paramContext;
      this.a = paramList;
    }

    public int getItemCount()
    {
      return this.a.size();
    }

    public long getItemId(int paramInt)
    {
      return paramInt;
    }

    public int getItemViewType(int paramInt)
    {
      return paramInt;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
    {
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      return new ck.d((View)this.a.get(paramInt));
    }
  }

  public static class d extends RecyclerView.ViewHolder
  {
    public d(View paramView)
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.ck
 * JD-Core Version:    0.6.2
 */