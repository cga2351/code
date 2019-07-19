package com.viber.voip.messages.ui.c;

import android.widget.TextView;
import com.viber.voip.util.dg;

public class b
{
  private final TextView a;
  private final c b;
  private final c[] c;

  public b(TextView paramTextView, c paramc, c[] paramArrayOfc)
  {
    this.a = paramTextView;
    this.b = paramc;
    this.c = paramArrayOfc;
  }

  public void a()
  {
    int i = -1 + this.c.length;
    int j = 0;
    int k = i;
    TextView localTextView;
    if (k >= 0)
    {
      j = this.c[k].d();
      if (j == 0);
    }
    else
    {
      localTextView = this.a;
      if (j == 0)
        break label55;
    }
    while (true)
    {
      dg.a(localTextView, j);
      return;
      k--;
      break;
      label55: j = this.b.d();
    }
  }

  public void b()
  {
    dg.a(this.a, this.b.d());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.c.b
 * JD-Core Version:    0.6.2
 */