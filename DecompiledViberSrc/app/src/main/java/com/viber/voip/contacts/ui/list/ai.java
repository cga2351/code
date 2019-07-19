package com.viber.voip.contacts.ui.list;

import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.util.cd;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.f;
import com.viber.voip.widget.AvatarWithInitialsView;

class ai extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  a a;
  com.viber.voip.util.e.e b;
  f c;
  AvatarWithInitialsView d;
  TextView e;
  TextView f;
  private View g;

  ai(View paramView, a parama, com.viber.voip.util.e.e parame, f paramf)
  {
    super(paramView);
    this.a = parama;
    this.b = parame;
    this.c = paramf;
    this.d = ((AvatarWithInitialsView)this.itemView.findViewById(R.id.icon));
    this.d.setClickable(false);
    this.e = ((TextView)this.itemView.findViewById(R.id.name));
    this.f = ((TextView)this.itemView.findViewById(R.id.groupRole));
    this.g = this.itemView.findViewById(R.id.adminIndicatorView);
    this.itemView.findViewById(R.id.group).setOnClickListener(this);
  }

  void a(z paramz, com.viber.voip.messages.conversation.adapter.a.c.a.e parame)
  {
    Pair localPair = paramz.a(parame);
    this.d.a((String)localPair.second, true);
    this.b.a(paramz.a(), this.d, this.c);
    this.e.setText((CharSequence)localPair.first);
    if (cd.c(paramz.b()))
      this.f.setText(R.string.superadmin);
    while (true)
    {
      dj.c(this.f, cd.b(paramz.b()));
      dj.c(this.g, cd.b(paramz.b()));
      return;
      this.f.setText(R.string.admin);
    }
  }

  public void onClick(View paramView)
  {
    this.a.b(getAdapterPosition());
  }

  static abstract interface a
  {
    public abstract void b(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.list.ai
 * JD-Core Version:    0.6.2
 */