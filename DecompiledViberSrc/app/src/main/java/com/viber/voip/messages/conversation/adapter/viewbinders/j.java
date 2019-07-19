package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.widget.TextView;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.dg;

public class j extends e<a, i>
{
  private TextView a;

  public j(TextView paramTextView)
  {
    this.a = paramTextView;
  }

  private void a(aa paramaa)
  {
    int i = dg.d(paramaa.h());
    if (!"rtl".equals(this.a.getTag()))
    {
      this.a.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
      return;
    }
    this.a.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
  }

  private void a(aa paramaa, i parami)
  {
    if ((paramaa.bK()) && (paramaa.bL()))
    {
      this.a.setText(parami.e(paramaa));
      return;
    }
    this.a.setText(dg.a(paramaa.h(), paramaa.m()));
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    aa localaa = parama.c();
    a(localaa);
    a(localaa, parami);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.j
 * JD-Core Version:    0.6.2
 */