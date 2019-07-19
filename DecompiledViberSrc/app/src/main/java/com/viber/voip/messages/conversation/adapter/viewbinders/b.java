package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.view.View;
import android.view.View.OnClickListener;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.util.cd;
import com.viber.voip.util.dj;
import com.viber.voip.widget.AvatarWithInitialsView;

public class b extends com.viber.voip.ui.g.e<a, i>
  implements View.OnClickListener
{
  private final AvatarWithInitialsView a;
  private final com.viber.voip.messages.conversation.adapter.d.f b;
  private final View c;

  public b(AvatarWithInitialsView paramAvatarWithInitialsView, View paramView, com.viber.voip.messages.conversation.adapter.d.f paramf)
  {
    this.a = paramAvatarWithInitialsView;
    this.b = paramf;
    this.c = paramView;
    this.a.setOnClickListener(this);
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    aa localaa = parama.c();
    if (parama.h())
    {
      this.a.setClickable(false);
      dj.c(this.a, false);
      dj.c(this.c, false);
      return;
    }
    AvatarWithInitialsView localAvatarWithInitialsView = this.a;
    if (!localaa.O());
    for (boolean bool1 = true; ; bool1 = false)
    {
      localAvatarWithInitialsView.setClickable(bool1);
      dj.c(this.a, true);
      View localView = this.c;
      boolean bool2 = cd.b(localaa.bG());
      boolean bool3 = false;
      if (bool2)
      {
        boolean bool4 = localaa.aV();
        bool3 = false;
        if (bool4)
          bool3 = true;
      }
      dj.c(localView, bool3);
      if ((!localaa.O()) || (!localaa.ao()))
        break;
      this.a.setImageDrawable(parami.i(localaa.S()));
      return;
    }
    c localc = parama.e();
    this.a.a(localc.b(parami.h()), true);
    if (localc.a());
    for (com.viber.voip.util.e.f localf = parami.z(); ; localf = parami.y())
    {
      parami.T().a(localc.a(parami.U()), this.a, localf);
      return;
    }
  }

  public void onClick(View paramView)
  {
    a locala = (a)d();
    if (locala != null)
      this.b.a(paramView, locala.c());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.b
 * JD-Core Version:    0.6.2
 */