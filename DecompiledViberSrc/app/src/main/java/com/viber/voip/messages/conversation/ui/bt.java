package com.viber.voip.messages.conversation.ui;

import android.view.MotionEvent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.viber.voip.ConversationListView.a;
import com.viber.voip.util.e.j;

public class bt
  implements AbsListView.OnScrollListener, ConversationListView.a
{
  private static final float a = j.a(5.0F);
  private int b = 0;
  private Float c = null;
  private boolean d;
  private a e;

  private void a()
  {
    c();
    if (this.e != null)
      this.e.a();
  }

  private void a(boolean paramBoolean)
  {
    b(paramBoolean);
    if (this.e != null)
      this.e.c_(paramBoolean);
  }

  private boolean a(int paramInt)
  {
    if (this.b != paramInt)
    {
      this.b = paramInt;
      return true;
    }
    return false;
  }

  private void b()
  {
    d();
    if (this.e != null)
      this.e.b();
  }

  public void a(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default:
      return;
    case 0:
      this.c = Float.valueOf(paramMotionEvent.getY());
      return;
    case 2:
      if ((this.c != null) && (this.d))
      {
        if (this.c.floatValue() - a <= paramMotionEvent.getY())
          break label102;
        if (a(1))
          b();
      }
      while (true)
      {
        this.c = Float.valueOf(paramMotionEvent.getY());
        return;
        label102: if ((this.c.floatValue() + a < paramMotionEvent.getY()) && (a(-1)))
          a();
      }
    case 1:
    }
    this.c = null;
  }

  public void a(a parama)
  {
    this.e = parama;
  }

  protected void b(boolean paramBoolean)
  {
  }

  protected void c()
  {
  }

  protected void d()
  {
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 + paramInt2 < paramInt3 - 1);
    for (boolean bool = true; ; bool = false)
    {
      this.d = bool;
      if (this.e != null)
        this.e.a(paramInt1, paramInt2, paramInt3);
      if ((!this.d) && (a(0)))
        a(true);
      return;
    }
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    switch (paramInt)
    {
    default:
    case 0:
    }
    do
      return;
    while (!a(0));
    a(false);
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(int paramInt1, int paramInt2, int paramInt3);

    public abstract void b();

    public abstract void c_(boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.bt
 * JD-Core Version:    0.6.2
 */