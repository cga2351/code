package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.d.m;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.dj;

public class ab extends e<a, i>
  implements View.OnClickListener
{
  private final TextView a;
  private final m b;
  private boolean c;

  public ab(TextView paramTextView, m paramm)
  {
    this.a = paramTextView;
    this.b = paramm;
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    if (parama.a())
    {
      if (!this.c)
      {
        this.c = true;
        this.a.setOnClickListener(this);
        this.a.setBackground(parami.H());
      }
      dj.b(this.a, true);
      return;
    }
    dj.b(this.a, false);
  }

  public void onClick(View paramView)
  {
    a locala = (a)d();
    if (locala != null)
      this.b.g(locala.c());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.ab
 * JD-Core Version:    0.6.2
 */