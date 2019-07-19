package com.viber.voip.shareviber.chatstrigger;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.util.cl;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.f.a;

public class i
  implements View.OnClickListener, h
{
  private View a;
  private e b;
  private f c;
  private h.a d = (h.a)cl.b(h.a.class);
  private ImageView[] e = new ImageView[3];
  private final com.b.a.a.a f;
  private final Context g;
  private LayoutInflater h;
  private FrameLayout i;
  private boolean j;
  private boolean k;

  public i(Context paramContext, com.b.a.a.a parama, LayoutInflater paramLayoutInflater)
  {
    this.f = parama;
    this.g = paramContext;
    this.h = paramLayoutInflater;
  }

  private FrameLayout d()
  {
    if (this.i == null)
    {
      this.i = new FrameLayout(this.g);
      this.i.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    }
    return this.i;
  }

  private void e()
  {
    View localView = this.h.inflate(R.layout.share_viber_chats_trigger, d(), true);
    this.a = localView.findViewById(R.id.avatars_container);
    localView.findViewById(R.id.invite_button).setOnClickListener(this);
    this.b = e.a(this.g);
    this.c = new f.a().a(true).b(Integer.valueOf(R.drawable.transparent_view)).a(com.viber.voip.b.a.j).c();
    this.e[0] = ((ImageView)localView.findViewById(R.id.avatar_1).findViewById(R.id.avatar));
    this.e[1] = ((ImageView)localView.findViewById(R.id.avatar_2).findViewById(R.id.avatar));
    this.e[2] = ((ImageView)localView.findViewById(R.id.avatar_3).findViewById(R.id.avatar));
    this.j = true;
  }

  public void a()
  {
    if (this.i == null);
    do
    {
      return;
      if (!this.j)
        e();
    }
    while (this.k);
    this.k = true;
    this.f.b(this.i, true);
  }

  public void a(h.a parama)
  {
    this.d = parama;
  }

  public void a(String[] paramArrayOfString)
  {
    int m = 0;
    this.a.setVisibility(0);
    while (m < 3)
    {
      this.b.a(null, Uri.parse(paramArrayOfString[m]), this.e[m], this.c);
      m++;
    }
  }

  public void b()
  {
    if (this.i == null);
    while ((!this.j) || (!this.k))
      return;
    this.k = false;
    this.f.b(this.i, false);
  }

  public void c()
  {
    this.f.a(d());
    this.f.b(d(), false);
  }

  public void onClick(View paramView)
  {
    this.d.z();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.shareviber.chatstrigger.i
 * JD-Core Version:    0.6.2
 */