package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.d.g;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.d;
import com.viber.voip.messages.conversation.ui.ba;
import com.viber.voip.ui.bf;
import com.viber.voip.ui.g.e;

public class bl extends e<a, i>
  implements View.OnTouchListener, g
{
  private static final Logger a = ViberEnv.getLogger();
  private final bf b;
  private final ba c;
  private final GestureDetector d;
  private final a e;
  private final d f;

  public bl(bf parambf, ba paramba, d paramd)
  {
    this.b = parambf;
    this.c = paramba;
    this.e = new a();
    this.d = new GestureDetector(this.b.a().getContext(), this.e);
    this.b.a().setOnTouchListener(this);
    this.f = paramd;
  }

  private boolean b()
  {
    i locali = (i)e();
    return (locali != null) && (!locali.n());
  }

  public void a()
  {
    super.a();
    this.b.c();
    this.c.removeConversationIgnoredView(this.b.a());
  }

  public void a(aa paramaa)
  {
    if (b())
      this.b.d();
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    this.c.addConversationIgnoredView(this.b.a());
    if ((parama.i() == parami.g()) && (parama.i() > -1L));
    for (boolean bool = true; ; bool = false)
    {
      this.b.a(parama, bool);
      if (bool)
        parami.a(-1L);
      return;
    }
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool;
    if (!b())
      bool = false;
    int i;
    do
    {
      return bool;
      bool = this.d.onTouchEvent(paramMotionEvent);
      i = paramMotionEvent.getAction();
    }
    while ((3 != i) && (1 != i) && (4 != i));
    this.e.a();
    return bool;
  }

  class a extends GestureDetector.SimpleOnGestureListener
  {
    a()
    {
    }

    void a()
    {
      bl.a(bl.this).b(bl.a(bl.this).a());
    }

    public boolean onDown(MotionEvent paramMotionEvent)
    {
      bl.a(bl.this).a(bl.a(bl.this).a());
      return true;
    }

    public void onLongPress(MotionEvent paramMotionEvent)
    {
      bl.b(bl.this).a(paramMotionEvent.getX(), paramMotionEvent.getY());
    }

    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      bl.a(bl.this).a(bl.a(bl.this).a(), paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      return true;
    }

    public boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      a locala = (a)bl.this.d();
      if (locala != null)
        bl.this.a(locala.c());
      return true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.bl
 * JD-Core Version:    0.6.2
 */