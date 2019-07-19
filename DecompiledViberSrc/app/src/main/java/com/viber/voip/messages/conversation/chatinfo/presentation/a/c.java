package com.viber.voip.messages.conversation.chatinfo.presentation.a;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.chatinfo.presentation.b.n;
import com.viber.voip.messages.ui.al;
import com.viber.voip.messages.ui.al.a;
import com.viber.voip.publicaccount.ui.holders.recentmedia.b;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.g;

public class c extends al<aa, a>
{
  private final LayoutInflater a;
  private b b;
  private final g c;
  private final f d;
  private final f e;
  private n f;

  public c(Context paramContext, n paramn, g paramg, f paramf1, f paramf2)
  {
    this.a = LayoutInflater.from(paramContext);
    this.f = paramn;
    this.c = paramg;
    this.d = paramf1;
    this.e = paramf2;
  }

  protected aa a(int paramInt)
  {
    if (this.b == null)
      return null;
    return this.b.f(paramInt);
  }

  public a a(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = this.a.inflate(R.layout.layout_pa_info_recent_media_item, paramViewGroup, false);
    if (paramInt == 0)
      return new c(localView);
    if (1 == paramInt)
      return new d(localView);
    return new b(paramViewGroup.getContext());
  }

  public void a(a parama, int paramInt)
  {
    super.onBindViewHolder(parama, paramInt);
    parama.c();
  }

  public void a(b paramb)
  {
    this.b = paramb;
  }

  protected boolean a(aa paramaa1, aa paramaa2)
  {
    if (paramaa1.bo() != null)
      return paramaa1.bo().equals(paramaa2.bo());
    return paramaa2.bo() == null;
  }

  public int getItemCount()
  {
    if (this.b != null)
      return this.b.getCount();
    return 0;
  }

  public int getItemViewType(int paramInt)
  {
    if (paramInt == -1 + getItemCount())
      return 1;
    return 0;
  }

  abstract class a extends RecyclerView.ViewHolder
    implements View.OnClickListener, al.a<aa>
  {
    aa a;
    ImageView b;
    TextView c;

    a(View arg2)
    {
      super();
      this.b = ((ImageView)localView.findViewById(R.id.image));
      this.c = ((TextView)localView.findViewById(R.id.text));
      localView.setOnClickListener(this);
    }

    public aa a()
    {
      return this.a;
    }

    public void a(aa paramaa)
    {
      this.a = paramaa;
    }

    public abstract void c();
  }

  private class b extends c.a
  {
    b(Context arg2)
    {
      super(new View(localContext));
    }

    public void c()
    {
    }

    public void onClick(View paramView)
    {
    }
  }

  private class c extends c.a
  {
    c(View arg2)
    {
      super(localView);
    }

    public void c()
    {
      c.b(c.this).a(this.a.bo(), this.b, c.a(c.this), null);
    }

    public void onClick(View paramView)
    {
      c.c(c.this).a(this.a);
    }
  }

  private class d extends c.a
  {
    d(View arg2)
    {
      super(localView);
      this.c.setVisibility(0);
    }

    public void c()
    {
      c.b(c.this).a(this.a.bo(), this.b, c.d(c.this), null);
    }

    public void onClick(View paramView)
    {
      c.c(c.this).f();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.presentation.a.c
 * JD-Core Version:    0.6.2
 */