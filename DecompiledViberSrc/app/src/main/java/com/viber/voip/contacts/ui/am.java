package com.viber.voip.contacts.ui;

import android.view.View;
import com.viber.common.permission.c;
import com.viber.voip.ViberApplication;
import com.viber.voip.ui.ac;
import com.viber.voip.util.dj;

public class am extends x
{
  private ParticipantSelector o;
  private View p;

  public am(View paramView, c paramc, ParticipantSelector paramParticipantSelector)
  {
    super(paramView, paramc);
    this.o = paramParticipantSelector;
    this.p = paramView;
  }

  public void a(boolean paramBoolean, ac paramac)
  {
    if ((paramBoolean) || (this.o.a(false) > 0))
      this.c.setVisibility(0);
    while (true)
    {
      a(ViberApplication.isTablet(this.p.getContext()), dj.c(this.p.getContext()));
      return;
      this.c.setVisibility(8);
      if (paramac != null)
        paramac.i();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.am
 * JD-Core Version:    0.6.2
 */