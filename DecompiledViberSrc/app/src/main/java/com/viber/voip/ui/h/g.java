package com.viber.voip.ui.h;

import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class g extends RecyclerView.Adapter<f>
{
  private final List<b> a = new ArrayList();
  private final List<a> b = new ArrayList();
  private final LayoutInflater c;

  public g(LayoutInflater paramLayoutInflater)
  {
    this.c = paramLayoutInflater;
  }

  Pair<Object, Integer> a(int paramInt)
  {
    Iterator localIterator = this.b.iterator();
    int i = paramInt;
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      int j = locala.a();
      if (i < j)
        return new Pair(locala.b(i), Integer.valueOf(i));
      i -= j;
    }
    throw new IllegalStateException("Invalid adapterPosition=" + paramInt);
  }

  Pair<b, Integer> a(Object paramObject)
  {
    int i = this.a.size();
    for (int j = 0; j < i; j++)
    {
      b localb = (b)this.a.get(j);
      if (localb.a(paramObject))
        return new Pair(localb, Integer.valueOf(j));
    }
    throw new IllegalStateException("Invalid item=" + paramObject);
  }

  public f a(ViewGroup paramViewGroup, int paramInt)
  {
    return ((b)this.a.get(paramInt)).c(this.c, paramViewGroup);
  }

  public void a(a parama)
  {
    this.b.add(parama);
  }

  public void a(b paramb)
  {
    this.a.add(paramb);
  }

  public void a(f paramf, int paramInt)
  {
    b localb = (b)this.a.get(paramf.getItemViewType());
    paramf.a(a(paramInt).first);
    localb.b(paramf, paramf.e(), paramInt);
  }

  public int getItemCount()
  {
    Iterator localIterator = this.b.iterator();
    int i = 0;
    while (localIterator.hasNext())
      i += ((a)localIterator.next()).a();
    return i;
  }

  public int getItemViewType(int paramInt)
  {
    return ((Integer)a(a(paramInt).first).second).intValue();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.h.g
 * JD-Core Version:    0.6.2
 */