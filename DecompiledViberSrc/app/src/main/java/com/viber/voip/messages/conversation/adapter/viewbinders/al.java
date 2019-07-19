package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.widget.TextView;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.d.g;
import com.viber.voip.messages.j.a;
import com.viber.voip.ui.g.e;

public class al extends e<a, i>
  implements View.OnClickListener
{
  private final TextView a;
  private g b;

  public al(TextView paramTextView)
  {
    this.a = paramTextView;
  }

  public al(TextView paramTextView, g paramg, View.OnCreateContextMenuListener paramOnCreateContextMenuListener)
  {
    this(paramTextView);
    this.b = paramg;
    this.a.setOnClickListener(this);
    this.a.setOnCreateContextMenuListener(paramOnCreateContextMenuListener);
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    aa localaa = parama.c();
    this.a.setText(parami.b(localaa).a);
  }

  public void onClick(View paramView)
  {
    a locala = (a)d();
    if ((locala != null) && (this.b != null))
      this.b.a(locala.c());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.al
 * JD-Core Version:    0.6.2
 */