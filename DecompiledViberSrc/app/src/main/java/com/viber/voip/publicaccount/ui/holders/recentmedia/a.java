package com.viber.voip.publicaccount.ui.holders.recentmedia;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.v;
import com.viber.voip.messages.ui.al;
import com.viber.voip.messages.ui.al.a;
import com.viber.voip.util.e.b.b;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.f.a;
import com.viber.voip.util.e.g;

public class a extends al<aa, a>
{
  private LayoutInflater a;
  private v b;
  private g c;
  private f d;
  private f e;
  private c.a f;

  public a(Context paramContext, v paramv, g paramg, int paramInt, c.a parama, LayoutInflater paramLayoutInflater)
  {
    this.a = paramLayoutInflater;
    this.b = paramv;
    this.c = paramg;
    this.d = new f.a().a(Integer.valueOf(R.drawable.bg_loading_gallery_image)).a(paramInt, paramInt).e(true).c();
    int i = paramContext.getResources().getDimensionPixelSize(R.dimen.public_account_info_recent_media_iamge_blur_size);
    this.e = this.d.f().a(new b(i, true)).c();
    this.f = parama;
  }

  protected aa a(int paramInt)
  {
    return this.b.f(paramInt);
  }

  public a a(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = this.a.inflate(R.layout.layout_pa_info_recent_media_item, paramViewGroup, false);
    if (paramInt == 0)
      return new b(localView);
    if (1 == paramInt)
      return new c(localView);
    return null;
  }

  public void a(a parama, int paramInt)
  {
    super.onBindViewHolder(parama, paramInt);
    parama.c();
  }

  protected boolean a(aa paramaa1, aa paramaa2)
  {
    if (paramaa1.bo() != null)
      return paramaa1.bo().equals(paramaa2.bo());
    return paramaa2.bo() == null;
  }

  public int getItemCount()
  {
    return this.b.getCount();
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

  private class b extends a.a
  {
    b(View arg2)
    {
      super(localView);
    }

    public void c()
    {
      a.c(a.this).a(this.a.bo(), this.b, a.b(a.this), null, this.a.a(), this.a.B(), this.a.o(), this.a.q(), this.a.bx().getThumbnailEP(), this.a.aT());
    }

    public void onClick(View paramView)
    {
      a.a(a.this).a(this.a);
    }
  }

  private class c extends a.a
  {
    c(View arg2)
    {
      super(localView);
      this.c.setVisibility(0);
    }

    public void c()
    {
      a.c(a.this).a(this.a.bo(), this.b, a.d(a.this), null, this.a.a(), this.a.B(), this.a.o(), this.a.q(), this.a.bx().getThumbnailEP(), this.a.aT());
    }

    public void onClick(View paramView)
    {
      a.a(a.this).h();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.recentmedia.a
 * JD-Core Version:    0.6.2
 */