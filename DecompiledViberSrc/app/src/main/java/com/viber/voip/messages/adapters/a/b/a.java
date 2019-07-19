package com.viber.voip.messages.adapters.a.b;

import android.view.View;
import android.view.ViewGroup;
import com.viber.dexshared.Logger;
import com.viber.voip.R.attr;
import com.viber.voip.R.id;
import com.viber.voip.ViberEnv;
import com.viber.voip.ads.b.c.a.b;
import com.viber.voip.ads.b.c.a.i;
import com.viber.voip.messages.adapters.j;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import javax.annotation.Nullable;

public class a extends e<com.viber.voip.messages.adapters.a.a, com.viber.voip.messages.adapters.a.c.a>
{
  private static final Logger a = ViberEnv.getLogger();
  private final View b;
  private com.viber.voip.ads.b.c.a.a<com.viber.voip.ads.b.c.c.c> c;

  @Nullable
  private final View d;
  private final View e;
  private final View f;

  public a(View paramView, i parami, com.viber.voip.ads.b.b.b.c paramc, b paramb)
  {
    this.b = paramView;
    this.c = paramb.a(paramc, (ViewGroup)paramView, parami);
    this.d = paramView.findViewById(R.id.adViewPlaceholder);
    this.e = paramView.findViewById(R.id.overflowButton);
    this.f = paramView.findViewById(R.id.adProviderView);
  }

  public void a(com.viber.voip.messages.adapters.a.a parama, com.viber.voip.messages.adapters.a.c.a parama1)
  {
    super.a(parama, parama1);
    com.viber.voip.ads.b.c.c.c localc = ((j)parama).j();
    if (localc != null)
    {
      if ((this.d != null) && (this.d.getVisibility() == 0))
        com.viber.voip.ui.b.a.b(this.d, 100L, com.viber.voip.ui.b.c.a);
      this.c.a(localc);
    }
    while (this.d == null)
    {
      this.b.setActivated(false);
      this.b.setBackground(dc.g(this.b.getContext(), R.attr.listItemSelectableBackground));
      return;
    }
    View localView1 = this.b.findViewById(R.id.googleAdView);
    if (localView1 == null);
    for (View localView2 = this.b.findViewById(R.id.adViewContainer); ; localView2 = localView1)
    {
      if (localView2 != null)
        ((ViewGroup)this.b).removeView(localView2);
      if ((this.e != null) && (this.e.getVisibility() != 8))
        dj.b(this.e, false);
      if ((this.f != null) && (this.f.getVisibility() != 8))
        dj.b(this.f, false);
      if (this.d.getVisibility() == 0)
        break;
      dj.b(this.d, true);
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.b.a
 * JD-Core Version:    0.6.2
 */