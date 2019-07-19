package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.widget.TextView;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.ui.g.e;

public class bj extends e<a, i>
{
  private final TextView a;
  private final TextView b;

  public bj(TextView paramTextView1, TextView paramTextView2)
  {
    this.a = paramTextView1;
    this.b = paramTextView2;
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    aa localaa = parama.c();
    this.a.setText(localaa.i());
    this.b.setText(parami.v());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.bj
 * JD-Core Version:    0.6.2
 */