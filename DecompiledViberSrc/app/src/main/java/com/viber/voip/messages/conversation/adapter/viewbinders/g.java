package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.widget.TextView;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.dj;

public class g extends e<a, i>
{
  private TextView a;
  private TextView b;
  private TextView c;

  public g(TextView paramTextView1, TextView paramTextView2, TextView paramTextView3)
  {
    this.a = paramTextView1;
    this.b = paramTextView2;
    this.c = paramTextView3;
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    aa localaa = parama.c();
    TextView localTextView1;
    boolean bool1;
    label50: TextView localTextView3;
    if (this.b.getVisibility() == 0)
    {
      localTextView1 = this.c;
      TextView localTextView2 = this.a;
      if (this.b.getVisibility() != 8)
        break label117;
      bool1 = true;
      dj.b(localTextView2, bool1);
      localTextView3 = this.c;
      if (this.b.getVisibility() != 0)
        break label123;
    }
    label117: label123: for (boolean bool2 = true; ; bool2 = false)
    {
      dj.b(localTextView3, bool2);
      if (localaa.m() <= 1)
        break label129;
      dj.b(localTextView1, true);
      localTextView1.setText(parami.d(localaa));
      return;
      localTextView1 = this.a;
      break;
      bool1 = false;
      break label50;
    }
    label129: if ((localaa.ap()) || ((localaa.s() > 0L) && (!localaa.aw())))
    {
      dj.b(localTextView1, true);
      localTextView1.setText(localaa.t());
      return;
    }
    dj.b(localTextView1, false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.g
 * JD-Core Version:    0.6.2
 */