package com.viber.voip.contacts.ui.list;

import android.support.v7.d.c.b;
import android.support.v7.d.d;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.viber.voip.R.layout;
import com.viber.voip.util.e.f;
import java.util.ArrayList;
import java.util.List;

public class ab extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements ah.a, ai.a
{
  private LayoutInflater a;
  private a b;
  private com.viber.voip.util.e.e c;
  private f d;
  private com.viber.voip.messages.conversation.adapter.a.c.a.e e;
  private List<z> f;
  private int g;
  private boolean h;

  ab(a parama, com.viber.voip.util.e.e parame, f paramf, com.viber.voip.messages.conversation.adapter.a.c.a.e parame1, LayoutInflater paramLayoutInflater)
  {
    this.b = parama;
    this.c = parame;
    this.d = paramf;
    this.e = parame1;
    this.f = new ArrayList();
    this.a = paramLayoutInflater;
  }

  private int a()
  {
    return 1 + this.f.size();
  }

  private int f(int paramInt)
  {
    return paramInt + 1;
  }

  private z g(int paramInt)
  {
    return (z)this.f.get(paramInt - 1);
  }

  void a(int paramInt)
  {
    this.g = paramInt;
    notifyItemChanged(0);
  }

  void a(com.viber.voip.messages.conversation.adapter.a.c.a.e parame)
  {
    this.e = parame;
    notifyItemRangeChanged(f(0), this.f.size());
  }

  void a(List<z> paramList)
  {
    this.f = paramList;
    notifyDataSetChanged();
  }

  void a(List<z> paramList, int paramInt1, int paramInt2)
  {
    notifyItemChanged(-1 + (1 + this.f.size()));
    this.f = paramList;
    notifyItemRangeInserted(f(paramInt1), paramInt2);
  }

  void a(List<z> paramList, c.b paramb)
  {
    this.f = paramList;
    paramb.a(new d()
    {
      public void onChanged(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        ab.this.notifyItemRangeChanged(ab.a(ab.this, paramAnonymousInt1), paramAnonymousInt2, paramAnonymousObject);
      }

      public void onInserted(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        ab.this.notifyItemRangeInserted(ab.a(ab.this, paramAnonymousInt1), paramAnonymousInt2);
      }

      public void onMoved(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        ab.this.notifyItemMoved(ab.a(ab.this, paramAnonymousInt1), ab.a(ab.this, paramAnonymousInt2));
      }

      public void onRemoved(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        ab.this.notifyItemRangeRemoved(ab.a(ab.this, paramAnonymousInt1), paramAnonymousInt2);
      }
    });
  }

  void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
    notifyItemChanged(a());
  }

  public void b(int paramInt)
  {
    this.b.a(g(paramInt));
  }

  public boolean c(int paramInt)
  {
    return paramInt - 1 == 0;
  }

  public boolean d(int paramInt)
  {
    return paramInt - 1 == -1 + this.f.size();
  }

  public boolean e(int paramInt)
  {
    return (this.h) && (a() == paramInt);
  }

  public int getItemCount()
  {
    if (this.f.size() > 0)
      return 1 + (1 + this.f.size());
    return 0;
  }

  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0)
      return b.a.ordinal();
    if (paramInt == a())
      return b.c.ordinal();
    return b.b.ordinal();
  }

  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof ag))
      ((ag)paramViewHolder).a(this.g);
    do
    {
      return;
      if ((paramViewHolder instanceof ai))
      {
        ((ai)paramViewHolder).a(g(paramInt), this.e);
        return;
      }
    }
    while (!(paramViewHolder instanceof ad));
    ((ad)paramViewHolder).a(this.h);
  }

  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (b.a.ordinal() == paramInt)
      return new ag(this.a.inflate(R.layout.participants_list_header, paramViewGroup, false));
    if (b.b.ordinal() == paramInt)
      return new ai(this.a.inflate(R.layout.participants_list_item, paramViewGroup, false), this, this.c, this.d);
    if (b.c.ordinal() == paramInt)
      return new ad(this.a.inflate(R.layout.load_more_participants_progress_layout, paramViewGroup, false));
    return null;
  }

  static abstract interface a
  {
    public abstract void a(z paramz);
  }

  static enum b
  {
    static
    {
      b[] arrayOfb = new b[3];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.list.ab
 * JD-Core Version:    0.6.2
 */