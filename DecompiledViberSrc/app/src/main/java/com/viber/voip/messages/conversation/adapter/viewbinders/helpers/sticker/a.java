package com.viber.voip.messages.conversation.adapter.viewbinders.helpers.sticker;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.a.a.c.c;
import android.support.constraint.a.a.d;
import android.view.View;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.b;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.c;
import com.viber.voip.util.dj;
import com.viber.voip.widget.PercentConstraintLayout;

class a extends b
{
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  private View e;
  private View f;
  private View g;

  a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInt2;
    this.b = paramInt1;
    this.c = paramInt3;
    this.d = paramInt4;
  }

  private void a(ConstraintLayout paramConstraintLayout)
  {
    d locald1 = paramConstraintLayout.a(this.e);
    d locald2 = paramConstraintLayout.a(this.f);
    int i = locald1.o();
    int j = c.a(paramConstraintLayout, this.f, true);
    int k = Math.max(i, j);
    if (i < k)
    {
      View[] arrayOfView = new View[1];
      arrayOfView[0] = this.e;
      if (dj.a(arrayOfView))
        locald1.h(k);
    }
    if (j < k)
      locald2.h(k - (c.a(locald2, c.c.b) + c.a(locald2, c.c.d)));
  }

  private void b(ConstraintLayout paramConstraintLayout)
  {
    if (this.e == null)
    {
      View localView = paramConstraintLayout.a(this.a);
      if ((localView instanceof PercentConstraintLayout))
        this.e = localView;
    }
    if (this.f == null)
      this.f = paramConstraintLayout.a(this.b);
    if (this.g == null)
      this.g = paramConstraintLayout.a(this.c);
  }

  protected void a(ConstraintLayout paramConstraintLayout, android.support.constraint.a parama)
  {
    b(paramConstraintLayout);
    if (dj.e(this.f))
    {
      if ((!dj.e(this.e)) && (dj.e(this.g)))
        this.f.setPadding(this.f.getPaddingLeft(), this.f.getPaddingTop(), this.f.getPaddingRight(), 0);
    }
    else
      return;
    this.f.setPadding(this.f.getPaddingLeft(), this.f.getPaddingTop(), this.f.getPaddingRight(), this.d);
  }

  protected boolean a()
  {
    return (this.b != -1) && (this.a != -1) && (this.c != -1);
  }

  protected void c(ConstraintLayout paramConstraintLayout, android.support.constraint.a parama)
  {
    if (!dj.e(this.e))
      return;
    a(paramConstraintLayout);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.sticker.a
 * JD-Core Version:    0.6.2
 */