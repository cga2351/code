package com.viber.voip.shareviber.invitescreen.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.contacts.adapters.g.a;
import com.viber.voip.model.c;
import com.viber.voip.util.dj;

public class b extends g.a
  implements View.OnClickListener
{
  public final TextView t;
  private final a u;
  private final View v;
  private boolean w;

  public b(View paramView, int paramInt, a parama)
  {
    super(paramView, paramInt);
    this.u = parama;
    this.v = paramView.findViewById(R.id.selected_icon);
    this.t = ((TextView)paramView.findViewById(R.id.number));
    paramView.setOnClickListener(this);
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.w = paramBoolean1;
    dj.b(this.v, this.w);
    if ((this.u != null) && (paramBoolean2))
      this.u.a(this.p, this.w);
  }

  public void onClick(View paramView)
  {
    if (!this.w);
    for (boolean bool = true; ; bool = false)
    {
      a(bool, true);
      return;
    }
  }

  public static abstract interface a
  {
    public abstract void a(c paramc, boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.shareviber.invitescreen.a.b
 * JD-Core Version:    0.6.2
 */