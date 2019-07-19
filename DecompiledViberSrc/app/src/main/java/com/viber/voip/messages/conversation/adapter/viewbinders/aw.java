package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.annotation.SuppressLint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import com.viber.voip.bot.d;
import com.viber.voip.messages.adapters.x;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.e.b;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.rm.RichMessageBottomConstraintHelper;
import com.viber.voip.messages.conversation.ui.j;
import com.viber.voip.widget.a.c;

public class aw extends com.viber.voip.ui.g.e<a, i>
{
  private final j a;
  private final RecyclerView b;
  private final x c;
  private final d d;
  private final RichMessageBottomConstraintHelper e;

  @SuppressLint({"ClickableViewAccessibility"})
  public aw(RecyclerView paramRecyclerView, b paramb, LinearLayoutManager paramLinearLayoutManager, j paramj, com.viber.voip.bot.a.e parame, d paramd, RichMessageBottomConstraintHelper paramRichMessageBottomConstraintHelper)
  {
    this.a = paramj;
    this.b = paramRecyclerView;
    this.d = paramd;
    this.e = paramRichMessageBottomConstraintHelper;
    this.b.addItemDecoration(new c(parame.d()));
    this.b.addOnScrollListener(this.d);
    this.b.setLayoutManager(paramLinearLayoutManager);
    this.c = new x(paramRecyclerView.getContext(), paramb, true, parame, LayoutInflater.from(paramRecyclerView.getContext()));
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    int i = this.c.a();
    this.c.a(parama, parami);
    if (i < this.c.a())
      this.b.setAdapter(this.c);
    while (true)
    {
      this.d.a(parama);
      this.d.a();
      this.e.setTag(parama.c());
      return;
      this.c.notifyDataSetChanged();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.aw
 * JD-Core Version:    0.6.2
 */