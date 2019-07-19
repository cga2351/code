package com.shopchat.library.mvp.a;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;

public class c<ITEM, LISTENER extends a<ITEM>> extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  protected ITEM a;
  protected LISTENER b;

  public c(View paramView)
  {
    super(paramView);
  }

  public void a(LISTENER paramLISTENER)
  {
    this.b = paramLISTENER;
  }

  public void a(ITEM paramITEM)
  {
    this.a = paramITEM;
  }

  public void onClick(View paramView)
  {
    if ((this.b == null) || (this.a == null))
      return;
    this.b.a(getAdapterPosition(), this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.mvp.a.c
 * JD-Core Version:    0.6.2
 */