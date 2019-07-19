package com.viber.voip.contacts.ui.list;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.viber.voip.R.dimen;
import com.viber.voip.ui.h.d;
import com.viber.voip.ui.h.e;

public class j
  implements d
{
  private a a;
  private int b;

  public j(Context paramContext, a parama)
  {
    this.a = parama;
    this.b = paramContext.getResources().getDimensionPixelOffset(R.dimen.group_call_participants_list_divider_vertical_padding);
  }

  public void a(Canvas paramCanvas, RecyclerView paramRecyclerView, int paramInt)
  {
    e.a(this, paramCanvas, paramRecyclerView, paramInt);
  }

  public void a(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, int paramInt)
  {
    e.a(this, paramCanvas, paramRecyclerView, paramView, paramInt);
  }

  public void a(Rect paramRect, int paramInt)
  {
    if (this.a.a(paramInt));
    for (int i = 0 + this.b; ; i = 0)
    {
      if (this.a.c(paramInt));
      for (int j = 0 + this.b; ; j = 0)
      {
        paramRect.set(0, i, 0, j);
        return;
      }
    }
  }

  public static abstract interface a
  {
    public abstract boolean a(int paramInt);

    public abstract boolean c(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.list.j
 * JD-Core Version:    0.6.2
 */