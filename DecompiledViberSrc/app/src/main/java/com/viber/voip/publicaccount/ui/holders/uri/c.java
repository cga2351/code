package com.viber.voip.publicaccount.ui.holders.uri;

import android.view.View;
import android.view.View.OnClickListener;
import com.viber.voip.R.id;
import com.viber.voip.util.dj;
import com.viber.voip.widget.TextWithDescriptionAndActionView;

class c
  implements b
{
  private final View a;
  private final TextWithDescriptionAndActionView b;

  public c(View paramView, View.OnClickListener paramOnClickListener)
  {
    this.a = paramView.findViewById(R.id.uri_divider);
    this.b = ((TextWithDescriptionAndActionView)paramView.findViewById(R.id.uri));
    this.b.setActionClickListener(paramOnClickListener);
  }

  public void a()
  {
    this.b.setActionClickListener(null);
  }

  public void a(String paramString)
  {
    dj.b(this.b, true);
    dj.b(this.a, true);
    this.b.setText(paramString);
  }

  public void b()
  {
    dj.b(this.b, false);
    dj.b(this.a, false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.uri.c
 * JD-Core Version:    0.6.2
 */