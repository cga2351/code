package com.viber.voip.contacts.ui;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.viber.common.permission.c;
import com.viber.dexshared.Logger;
import com.viber.voip.R.anim;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.b.b;
import com.viber.voip.registration.ao;
import com.viber.voip.ui.ViberTextView;
import com.viber.voip.ui.h;
import com.viber.voip.util.dj;

public class ak extends h
{
  private static final Logger a = ViberEnv.getLogger();
  private com.viber.voip.ui.n b;
  private ViberTextView c;
  private ProgressBar d;
  private View e;
  private TextView f;
  private View g;
  private c h;
  public View k;
  protected ImageView l;

  public ak(View paramView, c paramc)
  {
    this.h = paramc;
    this.e = paramView.findViewById(R.id.contacts_sync_top_view);
    this.f = ((TextView)paramView.findViewById(R.id.sync_progress_text));
    this.c = ((ViberTextView)paramView.findViewById(R.id.sync_retry));
    this.d = ((ProgressBar)paramView.findViewById(R.id.sync_progress));
  }

  private void a(int paramInt)
  {
    if (!e())
      return;
    switch (paramInt)
    {
    default:
      return;
    case 1:
      this.b.d();
      return;
    case 2:
      this.b.e();
      return;
    case 3:
      this.b.f();
      return;
    case 4:
      this.b.g();
      return;
    case 5:
    }
    this.b.h();
  }

  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    dj.b(this.b.a, paramBoolean1);
    dj.b(this.g, paramBoolean2);
  }

  private boolean a()
  {
    return (ao.f()) || (this.h.a(com.viber.voip.permissions.n.j));
  }

  void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0)
    {
      a(false, false);
      return;
    }
    if ((paramBoolean) && (!a()))
    {
      a(false, true);
      return;
    }
    a(true, false);
    a(paramInt);
  }

  public void a(Activity paramActivity, int paramInt)
  {
    int i = 1;
    int j;
    if ((this.e.getVisibility() == 8) && (paramInt != 4))
    {
      j = i;
      label22: if ((this.e.getVisibility() != 0) || (paramInt != 4))
        break label99;
      label37: if (!ViberApplication.isTablet(paramActivity))
      {
        if (j == 0)
          break label104;
        this.e.setVisibility(0);
      }
    }
    while (true)
      switch (paramInt)
      {
      default:
        return;
        j = 0;
        break label22;
        label99: i = 0;
        break label37;
        label104: if (i != 0)
        {
          this.e.setVisibility(8);
          this.e.startAnimation(AnimationUtils.loadAnimation(paramActivity, R.anim.sync_contatcs_slide_out));
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      }
    this.f.setText(R.string.contacts_sync_in_progress);
    this.c.setVisibility(8);
    this.d.setVisibility(0);
    return;
    this.f.setText(R.string.contacts_sync_incomplete);
    this.c.setVisibility(0);
    this.d.setVisibility(8);
    return;
    this.f.setText(R.string.contacts_sync_finished);
    this.c.setVisibility(8);
    this.d.setVisibility(8);
  }

  public void a(b.b paramb, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = 2;
    if (!e());
    do
    {
      return;
      d(false);
      if ((paramBoolean3) || ((paramBoolean2) && (!paramBoolean1)))
      {
        a(false, false);
        return;
      }
      if (!a())
        a(false, true);
      while (paramBoolean2)
      {
        a(4);
        return;
        a(true, false);
      }
    }
    while (paramBoolean1);
    switch (paramInt)
    {
    default:
      return;
    case 0:
      a(1);
      return;
    case 1:
    case 2:
      if ((paramb == b.b.d) || (paramb == b.b.a))
        i = 1;
      a(i);
      return;
    case 3:
      if ((paramb == b.b.d) || (paramb == b.b.a))
        i = 5;
      a(i);
      return;
    case 4:
    }
    switch (1.a[paramb.ordinal()])
    {
    default:
      return;
    case 1:
    case 2:
      a(3);
      return;
    case 3:
    }
    a(i);
  }

  public boolean a(View paramView, View.OnClickListener paramOnClickListener, int paramInt)
  {
    if (!super.a(paramView))
      return false;
    this.b = new com.viber.voip.ui.n(paramView);
    this.b.f.setOnClickListener(paramOnClickListener);
    this.g = paramView.findViewById(R.id.empty_no_permissions_root);
    this.l = ((ImageView)this.g.findViewById(R.id.permission_icon));
    this.l.setImageResource(R.drawable.ic_permission_contacts);
    ((TextView)this.g.findViewById(R.id.permission_description)).setText(paramInt);
    this.g.findViewById(R.id.button_request_permission).setOnClickListener(paramOnClickListener);
    if (this.c != null)
      this.c.setOnClickListener(paramOnClickListener);
    this.k = paramView.findViewById(16908292);
    return true;
  }

  public boolean b()
  {
    return (this.e != null) && (this.e.getVisibility() == 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.ak
 * JD-Core Version:    0.6.2
 */