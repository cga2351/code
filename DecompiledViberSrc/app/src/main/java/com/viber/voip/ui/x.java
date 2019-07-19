package com.viber.voip.ui;

import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.attr;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.av.e;
import com.viber.voip.contacts.ui.m;
import com.viber.voip.i.c.i;
import com.viber.voip.messages.conversation.j;
import com.viber.voip.model.c;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import com.viber.voip.util.dj.a;
import com.viber.voip.util.e.e;
import com.viber.voip.widget.AvatarWithInitialsView;

public class x extends h
  implements com.viber.voip.i.f.a
{
  public View a;
  public View b;
  protected n c;
  public m[] d;
  private Handler e;
  private e f;
  private com.viber.voip.util.e.f g;
  private a h;
  private b i;
  private TextView j;

  private void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    d(paramBoolean);
    this.b.setVisibility(paramInt4);
    b(paramInt1);
    this.c.f.setVisibility(paramInt2);
    this.c.c.setVisibility(8);
    this.a.setVisibility(8);
    this.c.d.setVisibility(paramInt3);
    this.i.f(false);
  }

  private void a(boolean paramBoolean, j paramj)
  {
    a(paramj, paramBoolean);
  }

  private void b()
  {
    for (final int k = 0; k < 4; k++)
      if ((this.d != null) && (this.d[k] != null))
        this.d[k].r.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if (x.a(x.this) != null)
              x.a(x.this).a(paramAnonymousView, k);
          }
        });
  }

  private void b(View paramView)
  {
    Resources localResources = this.b.getResources();
    View localView = paramView.findViewById(R.id.contacts_container);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
    localMarginLayoutParams.topMargin = localResources.getDimensionPixelSize(R.dimen.quick_compose_marginTop_small);
    localMarginLayoutParams.bottomMargin = localResources.getDimensionPixelSize(R.dimen.quick_compose_marginBottom_small);
    localView.setLayoutParams(localMarginLayoutParams);
    int k = localResources.getDimensionPixelSize(R.dimen.quick_compose_size_small);
    int m = localResources.getDimensionPixelSize(R.dimen.quick_compose_photo_padding_left_right_small);
    int n = localResources.getDimensionPixelSize(R.dimen.quick_compose_photo_padding_top_bottom_small);
    int i1 = localResources.getDimensionPixelSize(R.dimen.contacts_favorites_name_size_small);
    for (m localm : this.d)
      if (localm != null)
        localm.a(k, m, n, i1);
  }

  private m c(View paramView)
  {
    if (paramView != null)
      return new m(paramView);
    return null;
  }

  protected void a()
  {
    this.c.d.setImageResource(R.drawable.empty_not_found);
  }

  protected void a(int paramInt)
  {
  }

  public void a(int paramInt1, int paramInt2, boolean paramBoolean, j paramj)
  {
    int k = 8;
    if (!e())
      return;
    a(paramInt2);
    int m = 0;
    switch (paramInt1)
    {
    default:
    case 3:
    case 2:
    case 1:
    case 0:
    }
    while (m != 0)
    {
      c.i.b.a(this);
      return;
      if (paramBoolean)
        k = 0;
      a(false, 0, k, 0, 0);
      m = 0;
      continue;
      a(paramBoolean, paramj);
      m = 1;
      continue;
      a(false, 0, k, 0, k);
      m = 0;
      continue;
      a(true, k, k, k, k);
      m = 0;
    }
    c.i.b.b(this);
  }

  protected void a(j paramj, boolean paramBoolean)
  {
    d(false);
    this.b.setVisibility(0);
    b(0);
    this.c.f.setVisibility(8);
    this.c.c.setVisibility(0);
    this.a.setVisibility(0);
    this.c.d.setVisibility(8);
    int k = 0;
    if (k < 4)
    {
      c localc = paramj.e(k);
      if (localc == null)
        this.d[k].q.setVisibility(8);
      while (true)
      {
        k++;
        break;
        this.d[k].q.setVisibility(0);
        this.d[k].s.setText(localc.k());
        this.f.a(localc.o(), this.d[k].r, this.g);
      }
    }
    dj.b(this.j, c.i.b.e());
    this.i.f(true);
    if (!dj.c(this.m.getContext()))
      dj.a(this.b, new dj.a()
      {
        public boolean onGlobalLayout()
        {
          if ((x.this.b.canScrollVertically(1)) || (x.this.b.canScrollVertically(-1)))
            x.a(x.this, x.this.m);
          return true;
        }
      });
  }

  public void a(a parama)
  {
    this.h = parama;
  }

  public boolean a(View paramView, View.OnClickListener paramOnClickListener, View.OnTouchListener paramOnTouchListener, b paramb)
  {
    if (!super.a(paramView, true))
      return false;
    this.e = av.e.a.a();
    this.c = new n(paramView);
    this.c.c();
    this.c.a.setVisibility(0);
    this.a = paramView.findViewById(R.id.compose_view);
    this.b = paramView.findViewById(16908292);
    this.d = new m[4];
    this.d[0] = c(paramView.findViewById(R.id.contact_photo_first));
    this.d[1] = c(paramView.findViewById(R.id.contact_photo_second));
    this.d[2] = c(paramView.findViewById(R.id.contact_photo_third));
    this.d[3] = c(paramView.findViewById(R.id.contact_photo_fourth));
    b();
    a();
    this.j = ((TextView)paramView.findViewById(R.id.say_hi_to_friends_link));
    this.j.setOnClickListener(paramOnClickListener);
    dj.a(this.j, true);
    paramView.findViewById(R.id.compose_btn).setOnClickListener(paramOnClickListener);
    this.i = paramb;
    this.f = e.a(paramView.getContext());
    this.g = new com.viber.voip.util.e.f.a().b(false).b(Integer.valueOf(dc.a(paramView.getContext(), R.attr.contactDefaultPhoto))).c();
    this.c.f.setOnClickListener(paramOnClickListener);
    this.b.setOnTouchListener(paramOnTouchListener);
    return true;
  }

  protected void b(int paramInt)
  {
    if (this.c.b != null)
      this.c.b.setVisibility(paramInt);
  }

  public void onFeatureStateChanged(com.viber.voip.i.f paramf)
  {
    if (paramf == c.i.b)
      this.e.post(new Runnable()
      {
        public void run()
        {
          dj.b(x.b(x.this), c.i.b.e());
        }
      });
  }

  public static abstract interface a
  {
    public abstract void a(View paramView, int paramInt);
  }

  public static abstract interface b
  {
    public abstract void f(boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.x
 * JD-Core Version:    0.6.2
 */