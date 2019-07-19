package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.content.res.ColorStateList;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.a.a.d;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import com.viber.voip.flatbuffers.model.quote.QuotedMessageData;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.d.x;
import com.viber.voip.ui.d.g;
import com.viber.voip.util.dj;
import com.viber.voip.widget.PercentConstraintLayout;

public class at extends com.viber.voip.ui.g.e<a, i>
  implements View.OnClickListener
{
  private final View a;
  private final com.viber.voip.messages.conversation.adapter.viewbinders.helpers.e<PercentConstraintLayout> b;
  private final g c;
  private final x d;
  private final View.OnCreateContextMenuListener e;

  public at(View paramView, com.viber.voip.messages.conversation.adapter.viewbinders.helpers.e<PercentConstraintLayout> parame, g paramg, x paramx, View.OnCreateContextMenuListener paramOnCreateContextMenuListener)
  {
    this.a = paramView;
    this.b = parame;
    this.c = paramg;
    this.d = paramx;
    this.e = paramOnCreateContextMenuListener;
  }

  private int a(aa paramaa)
  {
    if (paramaa.ao())
      return 4;
    return 5;
  }

  private void a(View paramView)
  {
    if (!(this.a instanceof ConstraintLayout));
    d locald;
    do
    {
      return;
      locald = ((ConstraintLayout)this.a).a(paramView);
    }
    while (locald.k() == paramView.getVisibility());
    locald.e(paramView.getVisibility());
  }

  public void a(a parama, i parami)
  {
    boolean bool1 = true;
    super.a(parama, parami);
    aa localaa = parama.c();
    boolean bool2;
    boolean bool3;
    label84: boolean bool4;
    label102: PercentConstraintLayout localPercentConstraintLayout;
    if (localaa.bD())
    {
      ColorStateList localColorStateList = parami.e(a(localaa));
      if ((localaa.ap()) || (!localaa.aR()) || (parama.h()))
      {
        bool2 = bool1;
        if ((!localaa.aj()) && (localaa.q() != 4))
          break label221;
        bool3 = bool1;
        g localg = this.c;
        if (parama.h())
          break label227;
        bool4 = bool1;
        localg.a(bool4, bool2, bool3, localaa.ao(), localColorStateList, parami.j(false));
        dj.a(this.b.b(), this.c);
        dj.a(this.b.c(), this);
        dj.a(this.b.c(), this.e);
      }
    }
    else
    {
      localPercentConstraintLayout = (PercentConstraintLayout)this.b.c();
      if (parami.n())
        break label233;
    }
    while (true)
    {
      dj.d(localPercentConstraintLayout, bool1);
      dj.b(localPercentConstraintLayout, parama.c().bD());
      if (localPercentConstraintLayout != null)
        a(localPercentConstraintLayout);
      return;
      bool2 = false;
      break;
      label221: bool3 = false;
      break label84;
      label227: bool4 = false;
      break label102;
      label233: bool1 = false;
    }
  }

  public void onClick(View paramView)
  {
    a locala = (a)d();
    if (locala != null)
    {
      QuotedMessageData localQuotedMessageData = locala.c().bC();
      this.d.a_(localQuotedMessageData.getToken(), localQuotedMessageData.getMessageId(), 2000L);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.at
 * JD-Core Version:    0.6.2
 */