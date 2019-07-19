package com.viber.voip.gallery.selection;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.widget.CheckableImageView;

class e extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public final CheckableImageView a;
  public final TextView b;
  public final TextView c;
  private final a d;

  e(View paramView, a parama)
  {
    super(paramView);
    this.d = parama;
    this.a = ((CheckableImageView)paramView.findViewById(R.id.image));
    this.a.setOnClickListener(this);
    this.b = ((TextView)paramView.findViewById(R.id.name));
    this.c = ((TextView)paramView.findViewById(R.id.count));
  }

  public void onClick(View paramView)
  {
    this.d.a(getAdapterPosition());
  }

  static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.selection.e
 * JD-Core Version:    0.6.2
 */