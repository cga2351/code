package com.viber.voip.messages.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.viber.voip.R.layout;
import com.viber.voip.messages.adapters.a.d;
import com.viber.voip.messages.adapters.a.f;
import com.viber.voip.messages.adapters.a.g;
import com.viber.voip.messages.adapters.a.h;
import com.viber.voip.messages.d.b;
import com.viber.voip.ui.a.a;
import java.util.ArrayList;
import java.util.List;

public class l extends RecyclerView.Adapter<i>
{
  private LayoutInflater a;
  private List<p> b;
  private Context c;
  private boolean d;
  private int e;
  private int f;
  private final a g;
  private b h;

  public l(Context paramContext, boolean paramBoolean, int paramInt1, int paramInt2, a parama, b paramb, LayoutInflater paramLayoutInflater)
  {
    this.c = paramContext;
    this.a = paramLayoutInflater;
    this.b = new ArrayList();
    this.d = paramBoolean;
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = parama;
    this.h = paramb;
  }

  public i a(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 0:
      g localg = new g(this.c, this.a.inflate(R.layout.list_item_view_info, paramViewGroup, false), this.d, this.e, this.f);
      localg.a(this.g);
      return localg;
    case 1:
      com.viber.voip.messages.adapters.a.i locali = new com.viber.voip.messages.adapters.a.i(this.c, this.a.inflate(R.layout.list_item_view_likes, paramViewGroup, false), this.e, this.f);
      locali.a(this.g);
      return locali;
    case 2:
      return new f(this.a.inflate(R.layout.list_header_view_likes, paramViewGroup, false));
    case 3:
      return new h(this.a.inflate(R.layout.list_header_view_likes, paramViewGroup, false));
    case 4:
    }
    return new d(this.c, this.a.inflate(R.layout.list_item_broadcast_view_info, paramViewGroup, false), this.h);
  }

  public p a(int paramInt)
  {
    return (p)this.b.get(paramInt);
  }

  public void a(i parami, int paramInt)
  {
    parami.a((p)this.b.get(paramInt));
  }

  public void a(List<p> paramList)
  {
    this.b = paramList;
  }

  public int getItemCount()
  {
    return this.b.size();
  }

  public long getItemId(int paramInt)
  {
    return ((p)this.b.get(paramInt)).i();
  }

  public int getItemViewType(int paramInt)
  {
    return ((p)this.b.get(paramInt)).b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.l
 * JD-Core Version:    0.6.2
 */