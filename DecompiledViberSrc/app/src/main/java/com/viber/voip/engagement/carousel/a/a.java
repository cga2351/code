package com.viber.voip.engagement.carousel.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import java.util.Iterator;
import java.util.List;

public abstract class a<T, VH extends b<T>> extends RecyclerView.Adapter<VH>
{
  private static final Object i = new Object();
  protected final Context a;
  protected final LayoutInflater b;
  protected List<T> c;
  protected int d;
  protected int e;
  protected int f = -1;
  protected boolean g;
  protected boolean h;

  public a(Context paramContext, List<T> paramList, int paramInt1, int paramInt2, LayoutInflater paramLayoutInflater)
  {
    this.a = paramContext;
    this.b = paramLayoutInflater;
    this.c = paramList;
    this.d = paramInt1;
    this.e = paramInt2;
  }

  public void a()
  {
    this.g = true;
  }

  public void a(int paramInt)
  {
    int j = this.f;
    if (j != paramInt)
    {
      this.f = paramInt;
      if (j != -1)
        notifyItemChanged(j, a.b);
      if (paramInt != -1)
        notifyItemChanged(paramInt, a.a);
    }
  }

  public void a(VH paramVH, int paramInt)
  {
    Object localObject = this.c.get(paramInt);
    if (paramInt == this.f);
    for (boolean bool = true; ; bool = false)
    {
      paramVH.a(localObject, paramInt, bool);
      return;
    }
  }

  public void a(VH paramVH, int paramInt, List<Object> paramList)
  {
    if (!paramList.isEmpty())
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if ((localObject instanceof a))
        {
          if (localObject == a.a);
          for (boolean bool = true; ; bool = false)
          {
            paramVH.c(bool);
            break;
          }
        }
        if ((localObject == i) && (paramVH.a()))
          super.onBindViewHolder(paramVH, paramInt, paramList);
      }
    }
    super.onBindViewHolder(paramVH, paramInt, paramList);
  }

  public void a(boolean paramBoolean)
  {
    this.h = true;
  }

  public void b()
  {
    this.g = false;
  }

  public void b(boolean paramBoolean)
  {
    this.h = false;
  }

  public void c()
  {
  }

  public void d()
  {
  }

  public void e()
  {
    int j = getItemCount();
    if (j > 0)
      notifyItemRangeChanged(0, j, i);
  }

  public int getItemCount()
  {
    return this.c.size();
  }

  private static enum a
  {
    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.carousel.a.a
 * JD-Core Version:    0.6.2
 */