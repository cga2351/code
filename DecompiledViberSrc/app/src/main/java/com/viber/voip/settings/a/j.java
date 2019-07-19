package com.viber.voip.settings.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.util.dj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class j extends RecyclerView.Adapter<b>
{
  private final int a;
  private final List<a> b;
  private final List<a> c;
  private final Context d;
  private final a e;
  private int f = -1;
  private final boolean g;
  private final LayoutInflater h;

  public j(Context paramContext, List<a> paramList, int paramInt, boolean paramBoolean, a parama, LayoutInflater paramLayoutInflater)
  {
    this.d = paramContext;
    this.a = paramInt;
    this.b = paramList;
    this.c = new ArrayList();
    this.e = parama;
    this.g = paramBoolean;
    this.h = paramLayoutInflater;
    a();
  }

  private void a()
  {
    this.c.clear();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.g())
        this.c.add(locala);
    }
  }

  public a a(int paramInt)
  {
    return (a)this.c.get(paramInt);
  }

  public b a(ViewGroup paramViewGroup, int paramInt)
  {
    return new b(this.h.inflate(this.a, paramViewGroup, false), this.e);
  }

  public void a(b paramb, int paramInt)
  {
    a locala = a(paramInt);
    paramb.b.setImageDrawable(locala.d());
    View localView;
    if (this.g)
    {
      localView = paramb.a;
      if (this.f != paramInt)
        break label76;
    }
    label76: for (boolean bool = true; ; bool = false)
    {
      localView.setSelected(bool);
      paramb.d.setText(locala.b());
      b.a(paramb, locala);
      dj.b(paramb.c, locala.i());
      return;
    }
  }

  public void b(int paramInt)
  {
    if (this.f == paramInt)
      return;
    int i = this.f;
    this.f = paramInt;
    if (i == -1)
    {
      notifyItemChanged(this.f);
      return;
    }
    if (this.f == -1)
    {
      notifyItemChanged(i);
      return;
    }
    int j = Math.min(i, this.f);
    notifyItemRangeChanged(j, 1 + (Math.max(i, this.f) - j));
  }

  public int c(int paramInt)
  {
    for (int i = 0; i < getItemCount(); i++)
      if (a(i).a() == paramInt)
        return i;
    return -1;
  }

  public a d(int paramInt)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.a() == paramInt)
        return locala;
    }
    return null;
  }

  public int getItemCount()
  {
    return this.c.size();
  }

  public long getItemId(int paramInt)
  {
    return a(paramInt).a();
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2);
  }

  public class b extends RecyclerView.ViewHolder
    implements View.OnClickListener
  {
    View a;
    ImageView b;
    ImageView c;
    TextView d;
    j.a e;
    a f;

    b(View parama, j.a arg3)
    {
      super();
      this.a = parama;
      this.b = ((ImageView)parama.findViewById(R.id.icon));
      this.c = ((ImageView)parama.findViewById(R.id.warning_icon));
      this.d = ((TextView)parama.findViewById(16908310));
      Object localObject;
      this.e = localObject;
      this.a.setOnClickListener(this);
    }

    private void a(a parama)
    {
      this.f = parama;
    }

    public void onClick(View paramView)
    {
      if (this.e != null)
      {
        int i = getAdapterPosition();
        if (i != -1)
          this.e.a(this.f.a(), i);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.a.j
 * JD-Core Version:    0.6.2
 */