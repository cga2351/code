package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.content.res.ColorStateList;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.d.g;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.dj;

public class c extends e<com.viber.voip.messages.conversation.adapter.a.a, i>
  implements View.OnClickListener
{
  private final View a;
  private final com.viber.voip.messages.conversation.adapter.a.b.a b;
  private final g c;

  public c(View paramView, com.viber.voip.messages.conversation.adapter.a.b.a parama)
  {
    this(paramView, parama, null, null);
  }

  public c(View paramView, com.viber.voip.messages.conversation.adapter.a.b.a parama, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, g paramg)
  {
    this.a = paramView;
    this.b = parama;
    this.c = paramg;
    this.a.setOnClickListener(this);
    this.a.setOnCreateContextMenuListener(paramOnCreateContextMenuListener);
  }

  private int a(aa paramaa)
  {
    if (paramaa.ao())
      return 0;
    if ((paramaa.f() == -1) && ((0x10 & paramaa.E()) == 0))
      return 1;
    if (paramaa.bA())
      return 2;
    return 3;
  }

  public void a(com.viber.voip.messages.conversation.adapter.a.a parama, i parami)
  {
    boolean bool1 = true;
    super.a(parama, parami);
    aa localaa = parama.c();
    boolean bool2;
    View localView1;
    if ((!localaa.bD()) && ((localaa.q() == 4) || (localaa.aj())))
    {
      bool2 = bool1;
      localView1 = this.a;
      if (bool2)
        break label77;
    }
    label77: for (boolean bool3 = bool1; ; bool3 = false)
    {
      dj.b(localView1, bool3);
      if (!bool2)
        break label83;
      return;
      bool2 = false;
      break;
    }
    label83: ColorStateList localColorStateList = parami.e(a(localaa));
    com.viber.voip.messages.conversation.adapter.a.b.a locala = this.b;
    boolean bool4;
    boolean bool6;
    label193: View localView3;
    if (!parama.h())
    {
      bool4 = bool1;
      boolean bool5 = locala.a(bool4, localaa.ao(), localColorStateList, parami.j(localaa.at()));
      dj.a(this.a, this.b);
      if (bool5)
        this.a.invalidate();
      this.a.setActivated(parami.c(localaa.y()));
      View localView2 = this.a;
      if (parami.n())
        break label226;
      bool6 = bool1;
      localView2.setClickable(bool6);
      localView3 = this.a;
      if (parami.n())
        break label232;
    }
    while (true)
    {
      localView3.setLongClickable(bool1);
      return;
      bool4 = false;
      break;
      label226: bool6 = false;
      break label193;
      label232: bool1 = false;
    }
  }

  public void onClick(View paramView)
  {
    com.viber.voip.messages.conversation.adapter.a.a locala = (com.viber.voip.messages.conversation.adapter.a.a)d();
    if ((this.c != null) && (locala != null))
      this.c.a(locala.c());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.c
 * JD-Core Version:    0.6.2
 */