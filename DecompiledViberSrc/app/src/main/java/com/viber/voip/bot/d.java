package com.viber.voip.bot;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;

public class d extends RecyclerView.OnScrollListener
{
  private final b a;
  private final LinearLayoutManager b;
  private a c;

  public d(b paramb, LinearLayoutManager paramLinearLayoutManager)
  {
    this.a = paramb;
    this.b = paramLinearLayoutManager;
  }

  private void b()
  {
    if (this.c == null)
      return;
    int i = this.b.findFirstCompletelyVisibleItemPosition();
    if (i < 0)
    {
      i = this.b.findFirstVisibleItemPosition();
      if (i < 0)
        i = 0;
    }
    aa localaa = this.c.c();
    this.a.a(localaa.a(), i);
  }

  public void a()
  {
    if (this.c == null)
      return;
    aa localaa = this.c.c();
    Integer localInteger = this.a.a(localaa.a());
    if (localInteger == null);
    for (int i = localaa.M(); ; i = localInteger.intValue())
    {
      this.b.scrollToPosition(i);
      return;
    }
  }

  public void a(a parama)
  {
    this.c = parama;
  }

  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
      b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.bot.d
 * JD-Core Version:    0.6.2
 */