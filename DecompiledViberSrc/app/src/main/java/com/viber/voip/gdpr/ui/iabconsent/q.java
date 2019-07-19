package com.viber.voip.gdpr.ui.iabconsent;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class q<T> extends RecyclerView.Adapter<a>
{
  private final int a;
  private final b b;
  private List<T> c;
  private LayoutInflater d;

  public q(int paramInt, b<T> paramb, LayoutInflater paramLayoutInflater)
  {
    this.a = paramInt;
    this.b = paramb;
    this.d = paramLayoutInflater;
  }

  public q(int paramInt, b<T> paramb, T paramT, LayoutInflater paramLayoutInflater)
  {
    this(paramInt, paramb, paramLayoutInflater);
    this.c = new ArrayList(1);
    this.c.add(paramT);
  }

  public a a(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = this.d.inflate(this.a, paramViewGroup, false);
    b localb = this.b;
    a locala = null;
    if (localb != null)
      locala = this.b.a(localView);
    return locala;
  }

  public void a(a parama, int paramInt)
  {
    if (parama != null)
      parama.a(this.c.get(paramInt));
  }

  public void a(List<T> paramList)
  {
    this.c = paramList;
    notifyDataSetChanged();
  }

  public int getItemCount()
  {
    return this.c.size();
  }

  static abstract class a<T> extends RecyclerView.ViewHolder
  {
    public a(View paramView)
    {
      super();
    }

    public abstract void a(T paramT);
  }

  public static abstract interface b<T>
  {
    public abstract q.a<T> a(View paramView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gdpr.ui.iabconsent.q
 * JD-Core Version:    0.6.2
 */