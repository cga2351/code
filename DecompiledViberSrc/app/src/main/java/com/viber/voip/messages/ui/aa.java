package com.viber.voip.messages.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.view.LayoutInflater;
import com.viber.voip.R.attr;
import com.viber.voip.R.integer;
import com.viber.voip.R.layout;
import com.viber.voip.util.dc;
import com.viber.voip.util.u;
import com.viber.voip.widget.a.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aa extends d
{
  private final Drawable c;
  private RecyclerView.ItemDecoration d;
  private List<ab.a> e;

  public aa(Context paramContext, LayoutInflater paramLayoutInflater)
  {
    super(paramContext, paramLayoutInflater);
    this.c = dc.g(paramContext, R.attr.conversationComposeExtraOptionDivider);
  }

  protected int a()
  {
    return this.b.getResources().getInteger(R.integer.conversations_menu_number_or_columns);
  }

  protected void a(RecyclerView paramRecyclerView)
  {
    paramRecyclerView.setBackground(dc.g(paramRecyclerView.getContext(), R.attr.conversationComposeExtraOptionBackground));
  }

  protected void a(RecyclerView paramRecyclerView, int paramInt)
  {
    if (this.d != null)
      paramRecyclerView.removeItemDecoration(this.d);
    if (this.c != null)
    {
      this.d = new f(paramInt, this.c, this.c, true);
      paramRecyclerView.addItemDecoration(this.d);
    }
  }

  protected void a(ArrayList<d.a> paramArrayList)
  {
    if (u.a(this.e));
    while (true)
    {
      return;
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext())
        paramArrayList.add(((ab.a)localIterator.next()).d(this.b));
    }
  }

  public void a(List<ab.a> paramList)
  {
    if (((this.e == null) && (paramList != null)) || ((this.e != null) && (!this.e.equals(paramList))))
    {
      this.e = paramList;
      g();
    }
  }

  protected int b()
  {
    return R.layout.menu_message_options_item;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.aa
 * JD-Core Version:    0.6.2
 */