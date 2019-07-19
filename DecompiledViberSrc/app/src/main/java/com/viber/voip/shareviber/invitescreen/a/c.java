package com.viber.voip.shareviber.invitescreen.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.contacts.adapters.g;
import com.viber.voip.shareviber.invitescreen.d;
import com.viber.voip.util.dj;

public class c extends g
  implements b.a
{
  private final b.a j;
  private final d k;

  public c(Context paramContext, boolean paramBoolean, com.viber.voip.contacts.a parama, b.a parama1, d paramd, LayoutInflater paramLayoutInflater)
  {
    super(paramContext, paramBoolean, parama, paramLayoutInflater);
    this.j = parama1;
    this.k = paramd;
  }

  protected com.viber.voip.contacts.adapters.f a(Context paramContext, LayoutInflater paramLayoutInflater)
  {
    return new a(paramContext, paramLayoutInflater, this);
  }

  protected void a(int paramInt, View paramView, com.viber.voip.model.c paramc)
  {
    super.a(paramInt, paramView, paramc);
    b localb = (b)paramView.getTag();
    if (paramc.w() == null)
      return;
    localb.t.setText(paramc.w().a());
    localb.a(this.k.b(paramc.w().c()), false);
  }

  public void a(com.viber.voip.model.c paramc, boolean paramBoolean)
  {
    this.j.a(paramc, paramBoolean);
  }

  protected View d(int paramInt)
  {
    View localView = super.d(paramInt);
    if (paramInt == 1)
    {
      dj.b(localView.findViewById(R.id.top_divider), false);
      ((b)localView.getTag()).h.setText(R.string.forward_selection_contacts);
    }
    return localView;
  }

  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0)
      return 1;
    return 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.shareviber.invitescreen.a.c
 * JD-Core Version:    0.6.2
 */