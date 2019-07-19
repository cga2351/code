package com.viber.voip.messages.conversation.adapter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.viber.voip.ui.a.a;

public class r extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private a a;

  public r(View paramView)
  {
    super(paramView);
  }

  public void a(s params)
  {
    if (this.a != null)
      this.itemView.setOnClickListener(this);
  }

  public void a(a parama)
  {
    this.a = parama;
  }

  public void onClick(View paramView)
  {
    int i = getAdapterPosition();
    if (i != -1)
      this.a.a(i, paramView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.r
 * JD-Core Version:    0.6.2
 */