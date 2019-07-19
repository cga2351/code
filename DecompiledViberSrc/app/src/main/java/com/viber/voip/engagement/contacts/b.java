package com.viber.voip.engagement.contacts;

import android.view.View;
import android.view.View.OnClickListener;
import com.viber.voip.R.id;
import com.viber.voip.contacts.adapters.g.a;

class b extends g.a
  implements View.OnClickListener, l
{
  private final g t;
  private final boolean u;
  private final SendHiButtonView v;

  public b(View paramView, int paramInt, g paramg, boolean paramBoolean)
  {
    super(paramView, paramInt);
    this.t = paramg;
    this.u = paramBoolean;
    this.v = ((SendHiButtonView)paramView.findViewById(R.id.engagement_contact_send_hi));
    this.v.setOnClickListener(this);
  }

  public void a(boolean paramBoolean)
  {
    this.v.a(paramBoolean);
  }

  public void b()
  {
    this.v.a();
  }

  public void c()
  {
    this.v.b();
  }

  public void onClick(View paramView)
  {
    this.t.a(this.p, this.u);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.contacts.b
 * JD-Core Version:    0.6.2
 */