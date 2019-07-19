package com.viber.voip.messages.conversation.adapter.viewbinders.helpers.file;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.a.a.d;
import android.view.View;
import android.view.ViewStub;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.b;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.c;
import com.viber.voip.util.dj;

public class a extends b
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
  private View k;

  a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.a = paramInt2;
    this.b = paramInt1;
    this.c = paramInt4;
    this.d = paramInt3;
    this.e = paramInt5;
    this.f = paramInt6;
  }

  private void a(ConstraintLayout paramConstraintLayout)
  {
    if (this.h == null)
      this.h = paramConstraintLayout.a(this.b);
    if (this.g == null)
      this.g = paramConstraintLayout.a(this.a);
    if ((this.j == null) && (this.d != -1))
      this.j = paramConstraintLayout.a(this.d);
    if (this.i == null)
    {
      View localView = paramConstraintLayout.a(this.c);
      if (!(localView instanceof ViewStub))
        this.i = localView;
    }
    if (this.k == null)
      this.k = paramConstraintLayout.a(this.e);
  }

  private void g(ConstraintLayout paramConstraintLayout, android.support.constraint.a parama)
  {
    boolean bool1 = dj.e(this.i);
    d locald1;
    d locald2;
    d locald3;
    d locald4;
    label59: boolean bool2;
    d locald5;
    label83: int m;
    label94: int n;
    int i1;
    int i2;
    label120: int i3;
    label132: int i4;
    if (bool1)
    {
      locald1 = paramConstraintLayout.a(this.i);
      locald2 = paramConstraintLayout.a(this.h);
      locald3 = paramConstraintLayout.a(this.g);
      if (this.j == null)
        break label226;
      locald4 = paramConstraintLayout.a(this.j);
      bool2 = dj.e(this.k);
      if (!bool2)
        break label232;
      locald5 = paramConstraintLayout.a(this.k);
      if (!bool1)
        break label238;
      m = locald1.o();
      n = locald2.o();
      i1 = locald3.o();
      if (locald4 == null)
        break label244;
      i2 = locald4.o();
      if (!bool2)
        break label250;
      i3 = locald5.o();
      i4 = Math.max(Math.max(Math.max(m, i3), n), Math.max(i1, i2));
      int i5 = c.a(paramConstraintLayout, parama);
      if (i4 >= i5)
        break label256;
      locald2.h(i5);
      locald3.h(i5);
      if (bool1)
        locald1.h(i5);
      if (locald4 != null)
        locald4.h(i5);
      if (bool2)
        locald5.h(i5);
    }
    label226: label232: label238: label244: label250: 
    do
    {
      return;
      locald1 = null;
      break;
      locald4 = null;
      break label59;
      locald5 = null;
      break label83;
      m = 0;
      break label94;
      i2 = 0;
      break label120;
      i3 = 0;
      break label132;
      if (n < i4)
        locald2.h(i4);
      if (i1 < i4)
        locald3.h(i4);
      if ((bool1) && (m < i4))
        locald1.h(i4);
      if ((i2 < i4) && (locald4 != null))
        locald4.h(i4);
    }
    while ((!bool2) || (i3 >= i4));
    label256: locald5.h(i4);
  }

  protected void a(ConstraintLayout paramConstraintLayout, android.support.constraint.a parama)
  {
    a(paramConstraintLayout);
    c.a(this.k, this.i, this.j, this.f);
  }

  protected boolean a()
  {
    return (this.a != -1) && (this.b != -1) && (this.c != -1) && (this.e != -1);
  }

  protected void c(ConstraintLayout paramConstraintLayout, android.support.constraint.a parama)
  {
    g(paramConstraintLayout, parama);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.file.a
 * JD-Core Version:    0.6.2
 */