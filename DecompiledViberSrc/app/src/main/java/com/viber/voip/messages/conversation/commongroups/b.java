package com.viber.voip.messages.conversation.commongroups;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.voip.R.attr;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.util.dc;
import com.viber.voip.util.dg;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f.b;
import com.viber.voip.widget.GroupIconView;

public class b extends RecyclerView.Adapter<a>
  implements com.viber.voip.ui.a.a
{
  private final LayoutInflater a;
  private final j b;
  private final dagger.a<com.viber.voip.messages.d.b> c;
  private final e d;
  private final com.viber.voip.util.e.f e;
  private final b f;

  public b(Context paramContext, j paramj, dagger.a<com.viber.voip.messages.d.b> parama, e parame, LayoutInflater paramLayoutInflater, b paramb)
  {
    this.b = paramj;
    this.c = parama;
    this.d = parame;
    this.a = paramLayoutInflater;
    this.e = com.viber.voip.util.e.f.a(dc.a(paramContext, R.attr.contactDefaultPhoto), f.b.b, false);
    this.f = paramb;
  }

  public a a(ViewGroup paramViewGroup, int paramInt)
  {
    return new a(this.a.inflate(R.layout.common_group_item, paramViewGroup, false), this.c, this.d, this.e, this);
  }

  public void a(int paramInt, View paramView)
  {
    if (this.f != null)
    {
      f localf = this.b.a(paramInt);
      if (localf != null)
        this.f.a(localf);
    }
  }

  public void a(a parama, int paramInt)
  {
    f localf = this.b.a(paramInt);
    if (localf != null)
      parama.a(localf);
  }

  public int getItemCount()
  {
    return this.b.b();
  }

  public long getItemId(int paramInt)
  {
    return this.b.b(paramInt);
  }

  public static class a extends RecyclerView.ViewHolder
    implements View.OnClickListener
  {
    private final dagger.a<com.viber.voip.messages.d.b> a;
    private final e b;
    private final com.viber.voip.util.e.f c;
    private final com.viber.voip.ui.a.a d;
    private final GroupIconView e;
    private final TextView f;

    a(View paramView, dagger.a<com.viber.voip.messages.d.b> parama, e parame, com.viber.voip.util.e.f paramf, com.viber.voip.ui.a.a parama1)
    {
      super();
      this.a = parama;
      this.b = parame;
      this.c = paramf;
      this.d = parama1;
      this.e = ((GroupIconView)paramView.findViewById(R.id.group_icon));
      this.f = ((TextView)paramView.findViewById(R.id.group_name));
      paramView.setOnClickListener(this);
    }

    public void a(f paramf)
    {
      dj.a(this.e, this.b, this.c, (com.viber.voip.messages.d.b)this.a.get(), paramf.d(), paramf.e());
      if (com.viber.common.d.a.e())
        this.e.invalidate();
      this.f.setText(dg.b(paramf.c()));
    }

    public void onClick(View paramView)
    {
      int i = getAdapterPosition();
      if (i != -1)
        this.d.a(i, paramView);
    }
  }

  public static abstract interface b
  {
    public abstract void a(f paramf);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.commongroups.b
 * JD-Core Version:    0.6.2
 */