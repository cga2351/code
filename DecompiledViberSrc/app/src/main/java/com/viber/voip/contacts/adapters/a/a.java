package com.viber.voip.contacts.adapters.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.a.a.b;
import com.viber.voip.util.dj;

public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private static final Logger c = ViberEnv.getLogger();
  protected final Context a;
  protected final LayoutInflater b;
  private final b d;
  private final d e;
  private final d f = new d()
  {
    public void a(View paramAnonymousView, com.viber.voip.contacts.a.a.a.a paramAnonymousa)
    {
      if ((paramAnonymousa instanceof com.viber.voip.contacts.model.a.a.b))
        a.a(a.this, paramAnonymousView, (com.viber.voip.contacts.model.a.a.b)paramAnonymousa);
      while (!(paramAnonymousa instanceof com.viber.voip.contacts.model.a.a.a))
        return;
      a.a(a.this, paramAnonymousView, (com.viber.voip.contacts.model.a.a.a)paramAnonymousa);
    }
  };

  public a(Context paramContext, b paramb, d paramd)
  {
    this.a = paramContext;
    this.b = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.d = paramb;
    this.e = paramd;
  }

  private View a(ViewGroup paramViewGroup, int paramInt)
  {
    return this.b.inflate(paramInt, paramViewGroup, false);
  }

  private void a(View paramView, com.viber.voip.contacts.model.a.a.a parama)
  {
    if (this.e != null)
      this.e.a(paramView, parama);
  }

  private void a(View paramView, com.viber.voip.contacts.model.a.a.b paramb)
  {
    RecyclerView.ViewHolder localViewHolder = com.viber.voip.util.j.a.a.b(paramView);
    int i;
    label23: int j;
    int k;
    int m;
    if (localViewHolder != null)
    {
      i = localViewHolder.getAdapterPosition();
      if (localViewHolder != null)
        break label86;
      notifyDataSetChanged();
      j = this.d.a(paramb);
      k = i - j;
      m = 0;
    }
    while (true)
    {
      if (m >= this.d.a())
        break label223;
      com.viber.voip.contacts.a.a.a.a locala = this.d.a(m);
      if (!(locala instanceof com.viber.voip.contacts.model.a.a.b))
      {
        m++;
        continue;
        i = -1;
        break;
        label86: if (paramb.c())
        {
          notifyItemChanged(i);
          notifyItemRangeInserted(i + 1, this.d.a(paramb));
          break label23;
        }
        notifyItemChanged(i);
        notifyItemRangeRemoved(i + 1, this.d.a(paramb));
        break label23;
      }
      com.viber.voip.contacts.model.a.a.b localb = (com.viber.voip.contacts.model.a.a.b)locala;
      if ((localb == paramb) || (!localb.c()))
      {
        m++;
      }
      else
      {
        localb.e();
        if (-1 == j)
        {
          m++;
        }
        else
        {
          int n = m + k;
          notifyItemChanged(n);
          notifyItemRangeRemoved(n + 1, this.d.a(localb));
          m++;
        }
      }
    }
    label223: if (-1 == j)
      notifyDataSetChanged();
  }

  protected void a(a parama, int paramInt)
  {
    com.viber.voip.contacts.a.a.a.a locala = this.d.a(paramInt);
    if (!(locala instanceof com.viber.voip.contacts.model.a.a.a))
      return;
    parama.a((com.viber.voip.contacts.model.a.a.a)locala);
    if ((this.d.a(paramInt + 1) instanceof com.viber.voip.contacts.model.a.a.a))
    {
      parama.e();
      return;
    }
    parama.d();
  }

  protected void a(b paramb, int paramInt)
  {
    com.viber.voip.contacts.a.a.a.a locala = this.d.a(paramInt);
    if (!(locala instanceof com.viber.voip.contacts.model.a.a.b))
      return;
    com.viber.voip.contacts.model.a.a.b localb = (com.viber.voip.contacts.model.a.a.b)locala;
    paramb.a(localb);
    if (paramInt > 0)
    {
      paramb.e();
      if (!(this.d.a(paramInt + 1) instanceof com.viber.voip.contacts.model.a.a.a))
        break label78;
      paramb.b();
    }
    while (true)
    {
      paramb.a(localb.g());
      paramb.c();
      return;
      paramb.d();
      break;
      label78: paramb.a();
    }
  }

  public int getItemCount()
  {
    return this.d.a();
  }

  public int getItemViewType(int paramInt)
  {
    com.viber.voip.contacts.a.a.a.a locala = this.d.a(paramInt);
    if (locala != null)
      return locala.a();
    return -1;
  }

  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof b))
      a((b)paramViewHolder, paramInt);
    while (!(paramViewHolder instanceof a))
      return;
    a((a)paramViewHolder, paramInt);
  }

  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    b localb;
    if (1 == paramInt)
      localb = new b(a(paramViewGroup, R.layout.contact_details_call_ways_phone_number_group_item), this.f);
    do
    {
      return localb;
      if (4 == paramInt)
        return new a(a(paramViewGroup, R.layout.contact_details_call_ways_mobile_call_child_item), this.f);
      if (3 == paramInt)
        return new a(a(paramViewGroup, R.layout.contact_details_call_ways_viber_out_child_item), this.f);
      localb = null;
    }
    while (2 != paramInt);
    return new a(a(paramViewGroup, R.layout.contact_details_call_ways_video_call_child_item), this.f);
  }

  public static class a extends a.c<com.viber.voip.contacts.model.a.a.a>
  {
    public a(View paramView, a.d paramd)
    {
      super(paramd);
    }
  }

  public static class b extends a.c<com.viber.voip.contacts.model.a.a.b>
  {
    public final ImageView a;
    public final TextView b;
    public final View c;

    public b(View paramView, a.d paramd)
    {
      super(paramd);
      this.a = ((ImageView)paramView.findViewById(R.id.phone_number_actions_expander));
      this.b = ((TextView)paramView.findViewById(R.id.contact_details_call_ways_item_description_container));
      this.c = paramView.findViewById(R.id.contact_details_call_ways_item_secondary_divider);
    }

    public void a()
    {
      dj.c(this.c, 4);
    }

    public void a(String paramString)
    {
      this.b.setText(paramString);
    }

    public void b()
    {
      dj.c(this.c, 0);
    }

    public void c()
    {
      if (((com.viber.voip.contacts.model.a.a.b)this.g).c())
      {
        this.a.setImageResource(R.drawable.ic_collapse_arrow_up);
        return;
      }
      this.a.setImageResource(R.drawable.ic_collapse_arrow_down);
    }

    public void onClick(View paramView)
    {
      ((com.viber.voip.contacts.model.a.a.b)this.g).f();
      c();
      super.onClick(paramView);
    }
  }

  public static abstract class c<T extends com.viber.voip.contacts.a.a.a.a> extends RecyclerView.ViewHolder
    implements View.OnClickListener
  {
    public final ViewGroup d;
    public final View e;
    protected final a.d f;
    protected T g;

    public c(View paramView, a.d paramd)
    {
      super();
      this.f = paramd;
      this.d = ((ViewGroup)paramView.findViewById(R.id.contact_details_call_ways_item_container));
      this.e = paramView.findViewById(R.id.contact_details_call_ways_item_main_divider);
      this.d.setOnClickListener(this);
    }

    public void a(T paramT)
    {
      this.g = paramT;
    }

    public void d()
    {
      dj.c(this.e, 4);
    }

    public void e()
    {
      dj.c(this.e, 0);
    }

    public void onClick(View paramView)
    {
      if (this.f != null)
        this.f.a(this.itemView, this.g);
    }
  }

  public static abstract interface d
  {
    public abstract void a(View paramView, com.viber.voip.contacts.a.a.a.a parama);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.adapters.a.a
 * JD-Core Version:    0.6.2
 */