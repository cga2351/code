package com.viber.voip.messages.extensions.ui;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.R.layout;
import com.viber.voip.messages.extensions.model.d;
import java.util.Collections;
import java.util.List;

final class l extends RecyclerView.Adapter<j>
{
  private final LayoutInflater a;
  private final a b;
  private List<d> c;

  public l(a parama, LayoutInflater paramLayoutInflater)
  {
    this.a = paramLayoutInflater;
    this.c = Collections.emptyList();
    this.b = parama;
  }

  private d a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.c.size()))
      return null;
    return (d)this.c.get(paramInt);
  }

  private View b(ViewGroup paramViewGroup, int paramInt)
  {
    return this.a.inflate(paramInt, paramViewGroup, false);
  }

  public j a(ViewGroup paramViewGroup, int paramInt)
  {
    e locale;
    if (5 == paramInt)
      locale = new e(b(paramViewGroup, R.layout.keyboard_extension_empty_item_layout));
    do
    {
      return locale;
      if (4 == paramInt)
        return new f(b(paramViewGroup, R.layout.keyboard_extension_loading_item_layout));
      if (1 == paramInt)
        return new h(b(paramViewGroup, R.layout.keyboard_extension_suggestion_item_layout), this.b);
      if (2 == paramInt)
        return new g(b(paramViewGroup, R.layout.keyboard_extension_suggestion_item_layout), this.b);
      locale = null;
    }
    while (3 != paramInt);
    return new i(b(paramViewGroup, R.layout.keyboard_extension_suggestion_sticker_item_layout), this.b);
  }

  public void a(j paramj, int paramInt)
  {
    paramj.a((d)this.c.get(paramInt));
  }

  public void a(List<d> paramList)
  {
    this.c = paramList;
  }

  public int getItemCount()
  {
    return this.c.size();
  }

  public int getItemViewType(int paramInt)
  {
    d locald = a(paramInt);
    if (locald == null)
      return -1;
    if (locald.q())
      return 5;
    if (locald.p())
      return 4;
    if (locald.i())
      return 2;
    if (locald.j())
      return 3;
    return 1;
  }

  public static abstract interface a
  {
    public abstract void a(View paramView, d paramd);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.ui.l
 * JD-Core Version:    0.6.2
 */