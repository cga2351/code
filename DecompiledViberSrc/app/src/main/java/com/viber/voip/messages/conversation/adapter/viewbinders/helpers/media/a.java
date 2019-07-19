package com.viber.voip.messages.conversation.adapter.viewbinders.helpers.media;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.a.a.c;
import android.support.constraint.a.a.c.c;
import android.support.constraint.a.a.d;
import android.view.View;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.b;

class a extends b
{
  private int a;
  private int b;
  private int c;
  private int d;
  private int e = -1;
  private int f = -1;

  a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }

  private void a(d paramd)
  {
    if (this.e < 0)
      this.e = paramd.a(c.c.c).e();
    if (this.f < 0)
      this.f = paramd.a(c.c.e).e();
  }

  protected boolean a()
  {
    return (this.a != 0) && (this.b != 0) && (this.c != 0) && (this.d != 0);
  }

  protected void c(ConstraintLayout paramConstraintLayout, android.support.constraint.a parama)
  {
    View localView1 = paramConstraintLayout.a(this.c);
    View localView2 = paramConstraintLayout.a(this.a);
    View localView3 = paramConstraintLayout.a(this.b);
    View localView4 = paramConstraintLayout.a(this.d);
    d locald1 = paramConstraintLayout.a(localView1);
    d locald2 = paramConstraintLayout.a(localView2);
    d locald3 = paramConstraintLayout.a(localView3);
    d locald4 = paramConstraintLayout.a(localView4);
    a(locald1);
    if (8 == locald2.k())
    {
      locald1.a(locald1.a(c.c.c));
      locald1.a(c.c.e, locald3, c.c.e, this.f);
      return;
    }
    locald1.a(c.c.c, locald2, c.c.e, this.e);
    locald1.a(c.c.e, locald4, c.c.e, this.f);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.media.a
 * JD-Core Version:    0.6.2
 */