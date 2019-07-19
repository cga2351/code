package com.viber.voip.messages.adapters.a.b;

import android.content.Context;
import android.widget.TextView;
import com.viber.voip.R.string;
import com.viber.voip.messages.adapters.a.c;
import com.viber.voip.messages.adapters.a.c.a;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;

public class w extends e<c, a>
{
  private final Context a;
  private final TextView b;
  private String c;

  public w(Context paramContext, TextView paramTextView)
  {
    this.a = paramContext;
    this.b = paramTextView;
    this.c = this.a.getString(R.string.public_groups_followers_label);
  }

  public void a(c paramc, a parama)
  {
    super.a(paramc, parama);
    TextView localTextView = this.b;
    String str = this.c;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = da.b(paramc.n());
    localTextView.setText(String.format(str, arrayOfObject));
    dj.b(this.b, paramc.m());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.b.w
 * JD-Core Version:    0.6.2
 */