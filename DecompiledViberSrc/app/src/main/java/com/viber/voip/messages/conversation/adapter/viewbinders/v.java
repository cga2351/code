package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.ui.g.e;

public class v extends e<a, i>
{
  private static final Logger a = ViberEnv.getLogger();
  private final TextView b;
  private final TextView c;

  public v(TextView paramTextView1, TextView paramTextView2)
  {
    this.b = paramTextView1;
    this.c = paramTextView2;
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    aa localaa = parama.c();
    String str1 = localaa.h();
    String str2 = parami.c(localaa);
    this.b.setText(str1);
    this.c.setText(str2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.v
 * JD-Core Version:    0.6.2
 */