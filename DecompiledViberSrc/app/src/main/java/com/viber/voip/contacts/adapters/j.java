package com.viber.voip.contacts.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.contacts.a;
import com.viber.voip.contacts.b.a;
import com.viber.voip.model.c;
import com.viber.voip.util.dj;

public class j extends i
  implements e, m
{
  private m k;
  private e l;
  private boolean m;

  public j(Context paramContext, boolean paramBoolean1, a parama, m paramm, e parame, b.a parama1, boolean paramBoolean2, LayoutInflater paramLayoutInflater)
  {
    super(paramContext, paramBoolean1, parama, parama1, paramLayoutInflater);
    this.k = paramm;
    this.l = parame;
    this.m = paramBoolean2;
  }

  protected f a(Context paramContext, LayoutInflater paramLayoutInflater)
  {
    return new k(paramContext, paramLayoutInflater, this, this);
  }

  protected void a(int paramInt, View paramView, c paramc)
  {
    boolean bool1 = true;
    super.a(paramInt, paramView, paramc);
    g.a locala = (g.a)paramView.getTag();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)locala.s.getLayoutParams();
    if (this.m)
    {
      View localView1 = locala.d;
      boolean bool2;
      label110: int i;
      if (!paramc.p())
      {
        bool2 = bool1;
        dj.b(localView1, bool2);
        dj.b(locala.k, paramc.p());
        View localView2 = locala.l;
        if ((this.h) || (!this.i) || (!paramc.p()))
          break label153;
        dj.b(localView2, bool1);
        if (!paramc.p())
          break label167;
        if (!this.i)
          break label159;
        i = R.id.videoCallButtonView;
      }
      while (true)
      {
        localLayoutParams.addRule(0, i);
        return;
        bool2 = false;
        break;
        label153: bool1 = false;
        break label110;
        label159: i = R.id.callButtonView;
        continue;
        label167: i = R.id.invite_button;
      }
    }
    dj.b(locala.d, false);
    dj.b(locala.k, false);
    dj.b(locala.l, false);
    localLayoutParams.addRule(11);
  }

  public void a(c paramc)
  {
    if (this.l != null)
      this.l.a(paramc);
  }

  public void b(c paramc)
  {
    if (this.l != null)
      this.l.b(paramc);
  }

  public void c(c paramc)
  {
    if (this.k != null)
      this.k.c(paramc);
  }

  public static class a extends g.a
    implements View.OnClickListener
  {
    private m t;
    private e u;

    public a(View paramView, int paramInt, m paramm, e parame)
    {
      super(paramInt);
      this.t = paramm;
      this.u = parame;
      if (this.d != null)
        this.d.setOnClickListener(this);
      if (this.k != null)
        this.k.setOnClickListener(this);
      if (this.l != null)
        this.l.setOnClickListener(this);
    }

    public void onClick(View paramView)
    {
      if (paramView == this.d)
        if (this.t != null)
          this.t.c(this.p);
      do
      {
        do
        {
          return;
          if (paramView != this.k)
            break;
        }
        while (this.u == null);
        this.u.a(this.p);
        return;
      }
      while ((paramView != this.l) || (this.u == null));
      this.u.b(this.p);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.adapters.j
 * JD-Core Version:    0.6.2
 */