package com.viber.voip.messages.conversation.chatinfo.presentation.c;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.messages.conversation.chatinfo.d.l;
import com.viber.voip.messages.conversation.chatinfo.e.a;
import com.viber.voip.messages.conversation.chatinfo.e.e;
import com.viber.voip.messages.conversation.chatinfo.presentation.a.c;
import com.viber.voip.messages.conversation.chatinfo.presentation.b.n;

public class r extends g<l>
{
  private final c a;

  public r(View paramView, n paramn, a parama)
  {
    super(paramView);
    this.a = new c(paramView.getContext(), paramn, parama.b(), parama.g(), parama.h());
    RecyclerView localRecyclerView = (RecyclerView)this.itemView.findViewById(R.id.recentMediaRecyclerView);
    localRecyclerView.setAdapter(this.a);
    localRecyclerView.setNestedScrollingEnabled(false);
    localRecyclerView.addItemDecoration(parama.f());
    ((TextView)this.itemView.findViewById(R.id.viewAllText)).setOnClickListener(new s(paramn));
  }

  public void a(l paraml, e parame)
  {
    this.a.a(paraml.a());
    this.a.notifyDataSetChanged();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.presentation.c.r
 * JD-Core Version:    0.6.2
 */