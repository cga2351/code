package com.viber.voip.group.participants.ban;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.messages.conversation.adapter.a.b.c;
import com.viber.voip.messages.conversation.adapter.q;
import com.viber.voip.messages.conversation.adapter.r;
import com.viber.voip.messages.conversation.adapter.s;
import com.viber.voip.messages.conversation.adapter.w;
import com.viber.voip.ui.a.a;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.f;

public class d extends RecyclerView.Adapter<r>
  implements a
{
  private LayoutInflater a;
  private com.viber.voip.util.e.e b;
  private final Context c;
  private final com.viber.voip.group.participants.settings.d d;
  private f e;
  private a f;
  private final s g;
  private final s h;
  private final a i;

  public d(Context paramContext, com.viber.voip.group.participants.settings.d paramd, a parama, LayoutInflater paramLayoutInflater)
  {
    this.i = parama;
    this.a = paramLayoutInflater;
    this.b = com.viber.voip.util.e.e.a(paramContext);
    this.c = paramContext;
    this.d = paramd;
    this.e = f.b(paramContext);
    this.f = new a(paramContext, 2, 5);
    this.g = new w(7, this.c.getString(R.string.banned_users_title).toUpperCase(), null);
    this.h = new q(10);
  }

  public r a(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalStateException("Unsupported view type " + paramInt);
    case 0:
      View localView = this.a.inflate(R.layout.banned_participant_list_item, paramViewGroup, false);
      b localb = new b(this.b, this.e, this.f, localView);
      localb.a(this);
      return localb;
    case 7:
      return new com.viber.voip.messages.conversation.adapter.a.b.e(this.a.inflate(R.layout.chat_info_item_header, paramViewGroup, false));
    case 10:
    }
    return new r(this.a.inflate(R.layout.banned_participant_empty_list_item, paramViewGroup, false));
  }

  public void a(int paramInt)
  {
    if (this.f.c() != paramInt)
    {
      this.f.a(paramInt);
      notifyDataSetChanged();
    }
  }

  public void a(int paramInt, View paramView)
  {
    if ((a.a(this.f)) && (this.i != null))
      this.i.a(paramInt, paramView);
  }

  public void a(r paramr, int paramInt)
  {
    paramr.a(b(paramInt));
  }

  public void a(boolean paramBoolean)
  {
    if (a.a(this.f) != paramBoolean)
    {
      a.a(this.f, paramBoolean);
      notifyDataSetChanged();
    }
  }

  public s b(int paramInt)
  {
    int j = this.d.c();
    if ((paramInt == 0) && (j == 0))
      return this.h;
    if ((paramInt == 0) && (j > 0))
      return this.g;
    return this.d.a(paramInt - 1);
  }

  public int c(int paramInt)
  {
    int j = this.d.c();
    if (j == 0)
      return -1;
    if (paramInt == 0)
      return 0;
    if (paramInt <= j)
      return paramInt - 1;
    return j - 1;
  }

  public int getItemCount()
  {
    if (this.d.c() > 0)
      return 1 + this.d.c();
    return 1;
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    return b(paramInt).m();
  }

  private class a extends com.viber.voip.messages.conversation.adapter.a.c.a.e
  {
    private boolean b;

    public a(Context paramInt1, int paramInt2, int arg4)
    {
      super(paramInt2, i);
    }
  }

  private static class b extends c
  {
    private d.a e;
    private View f;

    public b(com.viber.voip.util.e.e parame, f paramf, d.a parama, View paramView)
    {
      super(paramf, parama, paramView);
      this.f = paramView.findViewById(R.id.remove_button);
      this.e = parama;
    }

    public void a(s params)
    {
      super.a(params);
      dj.c(this.f, d.a.a(this.e));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.group.participants.ban.d
 * JD-Core Version:    0.6.2
 */