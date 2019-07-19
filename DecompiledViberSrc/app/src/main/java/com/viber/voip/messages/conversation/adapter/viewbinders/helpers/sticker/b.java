package com.viber.voip.messages.conversation.adapter.viewbinders.helpers.sticker;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintLayout.a;
import android.support.constraint.a;
import android.view.View;
import com.viber.voip.util.dj;
import com.viber.voip.widget.PercentConstraintLayout;

class b extends com.viber.voip.messages.conversation.adapter.viewbinders.helpers.b
{
  private final int a;
  private final int b;
  private final int c;
  private View d;
  private View e;
  private View f;

  b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }

  private void a(ConstraintLayout paramConstraintLayout)
  {
    if (this.d == null)
    {
      View localView = paramConstraintLayout.a(this.a);
      if ((localView instanceof PercentConstraintLayout))
        this.d = localView;
    }
    if (this.e == null)
      this.e = paramConstraintLayout.a(this.b);
    if (this.f == null)
      this.f = paramConstraintLayout.a(this.c);
  }

  protected void a(ConstraintLayout paramConstraintLayout, a parama)
  {
    a(paramConstraintLayout);
    ConstraintLayout.a locala = (ConstraintLayout.a)this.f.getLayoutParams();
    if ((dj.e(this.d)) && (!dj.e(this.e)))
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
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.sticker.b
 * JD-Core Version:    0.6.2
 */