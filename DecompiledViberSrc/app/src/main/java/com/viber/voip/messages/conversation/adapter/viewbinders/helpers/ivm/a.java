package com.viber.voip.messages.conversation.adapter.viewbinders.helpers.ivm;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintLayout.a;
import android.view.View;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.b;
import com.viber.voip.util.dj;

class a extends b
{
  private final int a;
  private final int b;
  private final int c;

  a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }

  protected void a(ConstraintLayout paramConstraintLayout, android.support.constraint.a parama)
  {
    ConstraintLayout.a locala = (ConstraintLayout.a)paramConstraintLayout.a(this.c).getLayoutParams();
    if ((dj.e(paramConstraintLayout.a(this.a))) && (!dj.e(paramConstraintLayout.a(this.b))))
    {
      locala.i = this.a;
      return;
    }
    locala.i = this.b;
  }

  protected boolean a()
  {
    return (this.a != -1) && (this.b != -1) && (this.c != -1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.ivm.a
 * JD-Core Version:    0.6.2
 */