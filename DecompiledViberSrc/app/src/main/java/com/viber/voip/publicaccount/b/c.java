package com.viber.voip.publicaccount.b;

import android.net.Uri;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.publicaccount.entity.CrmItem;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;

public class c extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  e a;
  f b;
  TextView c;
  ImageView d;
  a e;

  public c(View paramView, a parama, e parame, f paramf)
  {
    super(paramView);
    this.d = ((ImageView)paramView.findViewById(R.id.image));
    this.c = ((TextView)paramView.findViewById(R.id.name));
    this.e = parama;
    this.a = parame;
    this.b = paramf;
    paramView.setOnClickListener(this);
  }

  public void a(CrmItem paramCrmItem)
  {
    this.a.a(Uri.parse(paramCrmItem.getImage()), this.d, this.b);
    this.c.setText(paramCrmItem.getName());
  }

  public void onClick(View paramView)
  {
    this.e.a(getAdapterPosition());
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.b.c
 * JD-Core Version:    0.6.2
 */