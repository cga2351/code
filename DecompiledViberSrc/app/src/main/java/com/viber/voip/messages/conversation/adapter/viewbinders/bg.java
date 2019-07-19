package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.text.TextUtils;
import android.widget.TextView;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.e.l;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.f;
import com.viber.voip.messages.conversation.adapter.x;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.dg;
import com.viber.voip.util.dj;

public class bg extends e<a, i>
{
  private final TextView a;

  public bg(TextView paramTextView, f paramf)
  {
    this.a = paramTextView;
    this.a.setMovementMethod(new l(this.a, paramf));
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    aa localaa = parama.c();
    if ((localaa.aY()) || (!TextUtils.isEmpty(localaa.i())))
    {
      dj.b(this.a, true);
      this.a.setText(localaa.a(parami.V(), parami.U(), parami.W().a(localaa), parami.k(), parami.h()));
      if ((parami.c(localaa.y())) && (!TextUtils.isEmpty(parami.f())))
        dg.b(this.a, parami.f(), this.a.getText().length());
      return;
    }
    dj.b(this.a, false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.bg
 * JD-Core Version:    0.6.2
 */