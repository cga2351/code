package com.viber.common.dialogs;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import java.util.List;

public class i extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private final LayoutInflater a;
  private final List<?> b;
  private final c c;
  private final b d;
  private final int e;

  i(Context paramContext, List<?> paramList, c paramc, b paramb, int paramInt)
  {
    this.a = LayoutInflater.from(paramContext);
    this.b = paramList;
    this.c = paramc;
    this.d = paramb;
    this.e = paramInt;
  }

  private View a(ViewGroup paramViewGroup, int paramInt)
  {
    return this.a.inflate(paramInt, paramViewGroup, false);
  }

  public int getItemCount()
  {
    if (this.b != null)
      return this.b.size();
    return 0;
  }

  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.b == null);
    a locala;
    do
    {
      return;
      locala = (a)paramViewHolder;
      locala.a(this.b.get(paramInt));
    }
    while (this.d == null);
    this.d.a(locala);
  }

  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new a(a(paramViewGroup, this.e), this.c);
  }

  public static final class a extends RecyclerView.ViewHolder
    implements View.OnClickListener
  {
    private final i.c a;
    private final SparseArray<View> b = new SparseArray();
    private Object c;

    public a(View paramView, i.c paramc)
    {
      super();
      this.a = paramc;
      paramView.setOnClickListener(this);
    }

    public <T> T a()
    {
      return this.c;
    }

    public void a(Object paramObject)
    {
      this.c = paramObject;
    }

    public void onClick(View paramView)
    {
      int i = getAdapterPosition();
      if ((this.a != null) && (-1 != i))
        this.a.a(this.c, i);
    }
  }

  public static abstract interface b
  {
    public abstract void a(i.a parama);
  }

  public static abstract interface c
  {
    public abstract void a(Object paramObject, int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.dialogs.i
 * JD-Core Version:    0.6.2
 */