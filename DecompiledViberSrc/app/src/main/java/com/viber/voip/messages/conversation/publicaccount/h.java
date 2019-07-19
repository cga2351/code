package com.viber.voip.messages.conversation.publicaccount;

import android.content.Context;
import android.view.View;
import com.viber.voip.R.attr;
import com.viber.voip.R.id;
import com.viber.voip.ads.d.n;
import com.viber.voip.util.dc;
import com.viber.voip.widget.PublicAccountAdView;
import com.viber.voip.widget.PublicAccountAdView.a;

public class h
{
  private View a;
  private PublicAccountAdView.a b;
  private PublicAccountAdView c;
  private n d;

  public h(View paramView, PublicAccountAdView.a parama)
  {
    this.a = paramView;
    this.b = parama;
    this.c = ((PublicAccountAdView)this.a.findViewById(R.id.root));
  }

  public void a(n paramn, boolean paramBoolean)
  {
    this.d = paramn;
    this.c.a(this.d, this.b);
    this.a.setActivated(false);
    View localView = this.a;
    Context localContext = this.a.getContext();
    if (paramBoolean);
    for (int i = R.attr.listItemSelectableBackground; ; i = R.attr.listItemActivatedBackground)
    {
      localView.setBackground(dc.g(localContext, i));
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.publicaccount.h
 * JD-Core Version:    0.6.2
 */