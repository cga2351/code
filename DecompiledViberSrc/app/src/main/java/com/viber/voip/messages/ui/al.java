package com.viber.voip.messages.ui;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public abstract class al<I, VH extends RecyclerView.ViewHolder,  extends a<I>> extends RecyclerView.Adapter<VH>
{
  private WeakHashMap<VH, Boolean> a = new WeakHashMap();

  public VH a(I paramI)
  {
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)localIterator.next();
      if ((((a)localViewHolder).b() != null) && (a(paramI, ((a)localViewHolder).b())) && (localViewHolder.getAdapterPosition() != -1))
        return localViewHolder;
    }
    return null;
  }

  protected abstract boolean a(I paramI1, I paramI2);

  public void b(I paramI)
  {
    RecyclerView.ViewHolder localViewHolder = a(paramI);
    if (localViewHolder != null)
      onBindViewHolder(localViewHolder, localViewHolder.getAdapterPosition());
  }

  protected abstract I d(int paramInt);

  public void onBindViewHolder(VH paramVH, int paramInt)
  {
    ((a)paramVH).a(d(paramInt));
  }

  public void onViewAttachedToWindow(VH paramVH)
  {
    this.a.put(paramVH, Boolean.TRUE);
  }

  public void onViewDetachedFromWindow(VH paramVH)
  {
    this.a.remove(paramVH);
  }

  public static abstract interface a<HI>
  {
    public abstract void a(HI paramHI);

    public abstract HI b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.al
 * JD-Core Version:    0.6.2
 */