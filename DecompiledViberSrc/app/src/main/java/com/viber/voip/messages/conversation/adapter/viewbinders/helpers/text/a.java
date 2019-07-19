package com.viber.voip.messages.conversation.adapter.viewbinders.helpers.text;

import android.support.constraint.ConstraintLayout;
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
  private final int e;
  private final int f;
  private View g;
  private View h;
  private View i;
  private View j;

  a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.a = paramInt1;
    this.b = paramInt3;
    this.c = paramInt2;
    this.d = paramInt4;
    this.e = paramInt5;
    this.f = paramInt6;
  }

  private void a(ConstraintLayout paramConstraintLayout)
  {
    boolean bool1 = dj.e(this.h);
    d locald1;
    d locald2;
    d locald3;
    label48: boolean bool2;
    d locald4;
    label72: int k;
    label82: int m;
    if (bool1)
    {
      locald1 = paramConstraintLayout.a(this.h);
      locald2 = paramConstraintLayout.a(this.g);
      if (this.i == null)
        break label210;
      locald3 = paramConstraintLayout.a(this.i);
      bool2 = dj.e(this.j);
      if (!bool2)
        break label216;
      locald4 = paramConstraintLayout.a(this.j);
      if (!bool1)
        break label222;
      k = locald1.o();
      m = locald2.o();
      if (locald3 == null)
        break label228;
    }
    label210: label216: label222: label228: for (int n = locald3.o(); ; n = 0)
    {
      int i1 = 0;
      if (bool2)
        i1 = locald4.o();
      int i2 = Math.max(Math.max(k, m), Math.max(n, i1));
      if (m < i2)
        locald2.h(i2);
      if ((bool1) && (k < i2))
        locald1.h(i2);
      if ((n < i2) && (locald3 != null))
        locald3.h(i2);
      if ((bool2) && (i1 < i2))
        locald4.h(i2);
      return;
      locald1 = null;
      break;
      locald3 = null;
      break label48;
      locald4 = null;
      break label72;
      k = 0;
      break label82;
    }
  }

  private void b(ConstraintLayout paramConstraintLayout)
  {
    if (this.g == null)
      this.g = paramConstraintLayout.a(this.a);
    if (this.h == null)
    {
      View localView = paramConstraintLayout.a(this.b);
      if ((localView instanceof PercentConstraintLayout))
        this.h = localView;
    }
    if ((this.i == null) && (this.c != -1))
      this.i = paramConstraintLayout.a(this.c);
    if (this.j == null)
      this.j = paramConstraintLayout.a(this.d);
  }

  protected void a(ConstraintLayout paramConstraintLayout, android.support.constraint.a parama)
  {
    b(paramConstraintLayout);
    c.a(this.j, this.h, this.i, this.f);
  }

  protected boolean a()
  {
    return (this.a != -1) && (this.b != -1) && (this.d != -1);
  }

  public void c(ConstraintLayout paramConstraintLayout, android.support.constraint.a parama)
  {
    if ((this.e != 0) || (dj.e(this.h)))
    {
      if (this.e == 1)
      {
        View[] arrayOfView = new View[2];
        arrayOfView[0] = this.h;
        arrayOfView[1] = this.j;
        if (dj.a(arrayOfView));
      }
    }
    else
      return;
    a(paramConstraintLayout);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.text.a
 * JD-Core Version:    0.6.2
 */