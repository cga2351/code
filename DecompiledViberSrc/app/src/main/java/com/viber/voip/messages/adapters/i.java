package com.viber.voip.messages.adapters;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.viber.voip.ui.a.a;

public class i extends RecyclerView.ViewHolder
{
  private a a;

  public i(View paramView)
  {
    super(paramView);
  }

  public void a(p paramp)
  {
    if (this.a != null)
      this.itemView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          i.a(i.this).a(i.this.getAdapterPosition(), paramAnonymousView);
        }
      });
  }

  public void a(a parama)
  {
    this.a = parama;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.i
 * JD-Core Version:    0.6.2
 */