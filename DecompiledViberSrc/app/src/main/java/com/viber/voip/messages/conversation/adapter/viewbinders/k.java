package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.d.ad;
import com.viber.voip.messages.conversation.adapter.d.o;
import com.viber.voip.messages.conversation.ui.ba;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.dj;
import com.viber.voip.widget.b.b.a;
import com.viber.voip.widget.b.c;
import com.viber.voip.widget.b.c.a;

public class k extends e<com.viber.voip.messages.conversation.adapter.a.a, i>
  implements View.OnClickListener, View.OnLongClickListener, b.a
{
  private final View a;
  private final View b;
  private final View c;
  private final o d;
  private final c e;
  private final ad f;
  private final ba g;
  private final c.a h;

  public k(View paramView1, View paramView2, View paramView3, o paramo, ad paramad, c paramc, ba paramba, c.a parama)
  {
    this.f = paramad;
    this.a = paramView1;
    this.b = paramView2;
    this.c = paramView3;
    this.d = paramo;
    this.e = paramc;
    this.g = paramba;
    this.h = parama;
    this.c.setOnClickListener(this);
    this.a.setOnLongClickListener(this);
  }

  public void a(com.viber.voip.messages.conversation.adapter.a.a parama, i parami)
  {
    boolean bool1 = true;
    super.a(parama, parami);
    dj.b(this.b, parama.m());
    com.viber.voip.messages.conversation.adapter.a.c.a.a locala1 = parami.F();
    boolean bool2;
    int i;
    com.viber.voip.messages.conversation.adapter.a.c.a.a locala2;
    if ((parama.h()) && (!parama.n()))
    {
      bool2 = bool1;
      i = locala1.a(bool2);
      locala2 = parami.F();
      if ((!parama.j()) || (parama.n()))
        break label192;
    }
    while (true)
    {
      int j = locala2.b(bool1);
      if ((this.a.getPaddingTop() != i) || (this.a.getPaddingBottom() != j))
        this.a.setPadding(this.a.getPaddingLeft(), i, this.a.getPaddingRight(), j);
      this.c.setClickable(parami.n());
      this.c.setActivated(parama.l());
      if (!parama.a(parami))
        break label197;
      this.e.a(this.h);
      return;
      bool2 = false;
      break;
      label192: bool1 = false;
    }
    label197: this.e.b(this.h);
  }

  public void a(boolean paramBoolean)
  {
    com.viber.voip.messages.conversation.adapter.a.a locala = (com.viber.voip.messages.conversation.adapter.a.a)d();
    if ((paramBoolean) && (locala != null))
    {
      if (e() != null)
        ((i)e()).aB().a();
      this.f.a(locala.c(), 1);
    }
    this.g.removeConversationIgnoredView(this.a);
    this.a.postDelayed(new l(this), 3 * ViewConfiguration.getLongPressTimeout());
  }

  public void b()
  {
    this.g.addConversationIgnoredView(this.a);
  }

  public void onClick(View paramView)
  {
    com.viber.voip.messages.conversation.adapter.a.a locala = (com.viber.voip.messages.conversation.adapter.a.a)d();
    o localo;
    aa localaa;
    if (locala != null)
    {
      localo = this.d;
      localaa = locala.c();
      if (locala.l())
        break label48;
    }
    label48: for (boolean bool = true; ; bool = false)
    {
      localo.a(localaa, bool);
      return;
    }
  }

  public boolean onLongClick(View paramView)
  {
    com.viber.voip.messages.conversation.adapter.a.a locala = (com.viber.voip.messages.conversation.adapter.a.a)d();
    if (locala != null)
    {
      this.d.a(locala.c());
      return true;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.k
 * JD-Core Version:    0.6.2
 */