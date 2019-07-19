package com.viber.voip.ui.h;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class b<M, VH extends f<M>>
{
  private List<d> a;

  public b()
  {
  }

  public b(d paramd)
  {
    a(paramd);
  }

  void a(Canvas paramCanvas, RecyclerView paramRecyclerView, int paramInt)
  {
    if (this.a == null);
    while (true)
    {
      return;
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
        ((d)localIterator.next()).a(paramCanvas, paramRecyclerView, paramInt);
    }
  }

  void a(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, int paramInt)
  {
    if (this.a == null);
    while (true)
    {
      return;
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
        ((d)localIterator.next()).a(paramCanvas, paramRecyclerView, paramView, paramInt);
    }
  }

  void a(Rect paramRect, int paramInt)
  {
    if (this.a == null);
    while (true)
    {
      return;
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
        ((d)localIterator.next()).a(paramRect, paramInt);
    }
  }

  public final void a(d paramd)
  {
    if (this.a == null)
      this.a = new ArrayList();
    this.a.add(paramd);
  }

  public abstract void a(VH paramVH, M paramM, int paramInt);

  boolean a()
  {
    return this.a != null;
  }

  public abstract boolean a(Object paramObject);

  public abstract VH b(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup);

  public void b(VH paramVH, M paramM, int paramInt)
  {
    a(paramVH, paramM, paramInt);
  }

  public VH c(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return b(paramLayoutInflater, paramViewGroup);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.h.b
 * JD-Core Version:    0.6.2
 */