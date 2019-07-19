package com.viber.voip.messages.conversation.adapter.viewbinders.helpers.translate;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.a.a.d;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewStub;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.b;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.c;
import com.viber.voip.util.dj;
import com.viber.voip.widget.PercentTextView;

class a extends b
{
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  private final int f;
  private View g;
  private PercentTextView h;
  private View i;
  private View j;
  private View k;

  a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.f = paramInt6;
  }

  private void a(ConstraintLayout paramConstraintLayout)
  {
    if (this.g == null)
      this.g = paramConstraintLayout.a(this.a);
    if (this.h == null)
      this.h = ((PercentTextView)paramConstraintLayout.a(this.b));
    if ((this.i == null) && (this.c != -1))
      this.i = paramConstraintLayout.a(this.c);
    if (this.j == null)
    {
      View localView = paramConstraintLayout.a(this.d);
      if (!(localView instanceof ViewStub))
        this.j = localView;
    }
    if (this.k == null)
      this.k = paramConstraintLayout.a(this.e);
  }

  private void a(d paramd)
  {
    if (this.h.getMeasuredWidth() == paramd.o())
      return;
    int m = (int)(paramd.o() / this.h.getPercent());
    this.h.measure(View.MeasureSpec.makeMeasureSpec(m, 1073741824), View.MeasureSpec.makeMeasureSpec(paramd.q(), 1073741824));
  }

  private void g(ConstraintLayout paramConstraintLayout, android.support.constraint.a parama)
  {
    View[] arrayOfView = new View[1];
    arrayOfView[0] = this.j;
    boolean bool1 = dj.a(arrayOfView);
    d locald1;
    d locald2;
    d locald3;
    d locald4;
    label70: boolean bool2;
    d locald5;
    label94: int m;
    label106: int n;
    int i1;
    int i2;
    label132: int i3;
    label144: int i4;
    if (bool1)
    {
      locald1 = paramConstraintLayout.a(this.j);
      locald2 = paramConstraintLayout.a(this.g);
      locald3 = paramConstraintLayout.a(this.h);
      if (this.i == null)
        break label245;
      locald4 = paramConstraintLayout.a(this.i);
      bool2 = dj.e(this.k);
      if (!bool2)
        break label251;
      locald5 = paramConstraintLayout.a(this.k);
      if (!bool1)
        break label257;
      m = locald1.o();
      n = locald2.o();
      i1 = locald3.o();
      if (locald4 == null)
        break label263;
      i2 = locald4.o();
      if (!bool2)
        break label269;
      i3 = locald5.o();
      i4 = Math.max(Math.max(Math.max(m, i3), n), Math.max(i1, i2));
      int i5 = c.a(paramConstraintLayout, parama);
      if (i4 >= i5)
        break label275;
      locald2.h(i5);
      locald3.h(i5);
      if (bool1)
        locald1.h(i5);
      if (bool2)
        locald5.h(i5);
      if (locald4 != null)
        locald4.h(i5);
    }
    while (true)
    {
      a(locald3);
      return;
      locald1 = null;
      break;
      label245: locald4 = null;
      break label70;
      label251: locald5 = null;
      break label94;
      label257: m = 0;
      break label106;
      label263: i2 = 0;
      break label132;
      label269: i3 = 0;
      break label144;
      label275: if (n < i4)
        locald2.h(i4);
      if (i1 < i4)
        locald3.h(i4);
      if ((bool1) && (m < i4))
        locald1.h(i4);
      if ((bool2) && (i3 < i4))
        locald5.h(i4);
      if ((i2 < i4) && (locald4 != null))
        locald4.h(i4);
    }
  }

  protected void a(ConstraintLayout paramConstraintLayout, android.support.constraint.a parama)
  {
    a(paramConstraintLayout);
    c.a(this.k, this.j, this.i, this.f);
  }

  protected boolean a()
  {
    return (this.a != -1) && (this.b != -1) && (this.d != -1);
  }

  protected void c(ConstraintLayout paramConstraintLayout, android.support.constraint.a parama)
  {
    g(paramConstraintLayout, parama);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.translate.a
 * JD-Core Version:    0.6.2
 */