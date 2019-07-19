package com.viber.voip.messages.conversation.adapter.viewbinders.helpers.text;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintLayout.a;
import android.support.constraint.a;
import android.view.View;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.b;
import com.viber.voip.util.dj;
import com.viber.voip.widget.PercentConstraintLayout;

public class c extends b
{
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  private final int f;
  private final int g;
  private View h;
  private View i;
  private View j;
  private View k;

  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.f = paramInt6;
    this.g = paramInt7;
  }

  private void a(ConstraintLayout paramConstraintLayout)
  {
    if (this.h == null)
      this.h = paramConstraintLayout.a(this.a);
    if ((this.i == null) && (this.b != -1))
      this.i = paramConstraintLayout.a(this.b);
    if (this.j == null)
    {
      View localView = paramConstraintLayout.a(this.c);
      if ((localView instanceof PercentConstraintLayout))
        this.j = localView;
    }
    if (this.k == null)
      this.k = paramConstraintLayout.a(this.d);
  }

  private void b()
  {
    ConstraintLayout.a locala = (ConstraintLayout.a)this.h.getLayoutParams();
    if (dj.e(this.j))
    {
      locala.u = this.f;
      return;
    }
    if (dj.e(this.i))
    {
      locala.u = this.e;
      return;
    }
    locala.u = this.g;
  }

  protected void a(ConstraintLayout paramConstraintLayout, a parama)
  {
    a(paramConstraintLayout);
    if (dj.e(this.k))
      return;
    b();
  }

  protected boolean a()
  {
    return (this.a != -1) && (this.d != -1) && (this.c != -1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.text.c
 * JD-Core Version:    0.6.2
 */