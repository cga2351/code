package com.viber.voip.messages.conversation.adapter.viewbinders.helpers.text;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintLayout.a;
import android.support.constraint.a;
import android.support.constraint.a.a.c.c;
import android.support.constraint.a.a.d;
import android.view.View;
import com.viber.voip.widget.PercentTextView;

class b extends com.viber.voip.messages.conversation.adapter.viewbinders.helpers.b
{
  private final int a;
  private final int b;
  private int c;
  private PercentTextView d;
  private View e;

  b(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }

  private void a(ConstraintLayout paramConstraintLayout)
  {
    if (this.d == null)
      this.d = ((PercentTextView)paramConstraintLayout.a(this.a));
    if (this.e == null)
    {
      this.e = paramConstraintLayout.a(this.b);
      this.c = ((ConstraintLayout.a)this.e.getLayoutParams()).topMargin;
    }
  }

  private void a(ConstraintLayout paramConstraintLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    d locald = paramConstraintLayout.a(this.d);
    int j;
    int i;
    if (paramInt1 + paramInt3 <= paramInt4)
    {
      j = paramInt3 + locald.o();
      i = this.d.getBaseline() - this.e.getBaseline();
      if (this.d.getLineCount() > 1)
        i += this.d.getLineHeight() * (-1 + this.d.getLineCount());
    }
    while (true)
    {
      locald.h(j);
      locald.i(paramInt2);
      paramConstraintLayout.a(this.e).a(c.c.c).a(i);
      return;
      i = paramInt2 + this.c - com.viber.voip.messages.conversation.adapter.viewbinders.helpers.c.a(locald, c.c.c);
      j = Math.min(paramInt1, paramInt4);
      int k = this.d.getPaddingLeft();
      if (j < paramInt3 + k)
        j += k + paramInt3 - j;
    }
  }

  protected boolean a()
  {
    return (this.a != -1) && (this.b != -1);
  }

  protected void c(ConstraintLayout paramConstraintLayout, a parama)
  {
    a(paramConstraintLayout);
    int i = (int)(paramConstraintLayout.a(paramConstraintLayout).o() * this.d.getPercent());
    int j = com.viber.voip.messages.conversation.adapter.viewbinders.helpers.c.a(paramConstraintLayout, parama);
    d locald = paramConstraintLayout.a(this.d);
    a(paramConstraintLayout, com.viber.voip.messages.conversation.adapter.viewbinders.helpers.c.a(paramConstraintLayout, this.d, false), this.d.getMeasuredHeight() + com.viber.voip.messages.conversation.adapter.viewbinders.helpers.c.a(locald, c.c.c) + com.viber.voip.messages.conversation.adapter.viewbinders.helpers.c.a(locald, c.c.e), j, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.text.b
 * JD-Core Version:    0.6.2
 */