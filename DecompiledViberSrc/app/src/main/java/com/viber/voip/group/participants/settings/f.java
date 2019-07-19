package com.viber.voip.group.participants.settings;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.messages.conversation.adapter.q;
import com.viber.voip.messages.conversation.adapter.r;
import com.viber.voip.messages.conversation.adapter.s;
import com.viber.voip.messages.conversation.adapter.w;
import java.util.Map;

public class f extends RecyclerView.Adapter<r>
{
  private LayoutInflater a;
  private com.viber.voip.util.e.e b;
  private final Context c;
  private final d d;
  private final b e;
  private final k f;
  private com.viber.voip.util.e.f g;
  private c h;
  private final s i;
  private final w j;
  private final s k;
  private final s l;
  private int m = 5;
  private boolean n = false;

  public f(Context paramContext, d paramd, b paramb, k paramk, LayoutInflater paramLayoutInflater)
  {
    this.a = paramLayoutInflater;
    this.b = com.viber.voip.util.e.e.a(paramContext);
    this.c = paramContext;
    this.d = paramd;
    this.e = paramb;
    this.f = paramk;
    this.g = com.viber.voip.util.e.f.b(paramContext);
    this.h = new c(paramContext, 2, 5);
    this.i = new w(7, this.c.getString(R.string.member_privileges_admins).toUpperCase(), null);
    this.j = new w(3, this.c.getString(R.string.show_all), null);
    this.j.a(3L);
    this.k = new q(8);
    this.l = new q(6);
  }

  private void a(boolean paramBoolean)
  {
    this.n = paramBoolean;
    notifyDataSetChanged();
  }

  private boolean a()
  {
    return this.d.c() != 0;
  }

  private boolean b()
  {
    return this.d.c() != 0;
  }

  private boolean c()
  {
    return (!this.n) && (this.d.c() > this.m);
  }

  private int d()
  {
    if (this.n)
      return this.d.c();
    return Math.min(this.d.c(), this.m);
  }

  public r a(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    case 1:
    case 2:
    case 4:
    case 5:
    default:
      throw new IllegalStateException("Unsupported view type " + paramInt);
    case 0:
      View localView = this.a.inflate(R.layout.participants_settings_list_item, paramViewGroup, false);
      return new i(this.b, this.g, this.h, localView, this.f);
    case 7:
      return new com.viber.voip.messages.conversation.adapter.a.b.e(this.a.inflate(R.layout.chat_info_item_header, paramViewGroup, false));
    case 3:
      com.viber.voip.messages.conversation.adapter.a.b.b localb = new com.viber.voip.messages.conversation.adapter.a.b.b(this.a.inflate(R.layout.chat_info_item_left_text_header, paramViewGroup, false));
      localb.a(new g(this));
      return localb;
    case 8:
      return new r(this.a.inflate(R.layout.participants_settings_divider, paramViewGroup, false));
    case 6:
    }
    return new a(this.a.inflate(R.layout.group2_chat_info_toggle, paramViewGroup, false), this.c, this.f, this.h, this.e);
  }

  public s a(int paramInt)
  {
    boolean bool = a();
    if (bool);
    int i2;
    for (int i1 = 1; ; i1 = 0)
    {
      i2 = getItemCount();
      if ((paramInt != 0) || (!bool))
        break;
      return this.i;
    }
    if ((paramInt == i2 - 3) && (c()))
      return this.j;
    if ((paramInt == i2 - 2) && (b()))
      return this.k;
    if (paramInt == i2 - 1)
      return this.l;
    if ((paramInt >= i1) && (paramInt < i1 + d()))
      return this.d.a(paramInt - i1);
    return null;
  }

  public void a(r paramr, int paramInt)
  {
    paramr.a(a(paramInt));
  }

  public void a(Map<String, ? extends b> paramMap, b paramb)
  {
    this.h.a(paramMap);
    this.h.a(paramb);
  }

  public int getItemCount()
  {
    boolean bool = a();
    int i1 = 0;
    if (bool)
      i1 = 1;
    if (c())
      i1++;
    int i2 = i1 + d();
    if (b())
      i2++;
    return i2 + 1;
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    return a(paramInt).m();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.group.participants.settings.f
 * JD-Core Version:    0.6.2
 */