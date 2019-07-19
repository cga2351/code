package com.viber.voip.messages.conversation.adapter.viewbinders.helpers.reply;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintLayout.a;
import android.view.View;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.b;

class a extends b
{
  private int a;
  private int b;

  a(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }

  protected void a(ConstraintLayout paramConstraintLayout, android.support.constraint.a parama)
  {
    View localView = paramConstraintLayout.a(this.b);
    ConstraintLayout.a locala1 = (ConstraintLayout.a)paramConstraintLayout.getLayoutParams();
    ConstraintLayout.a locala2 = (ConstraintLayout.a)localView.getLayoutParams();
    if ((locala1.width == 0) && (locala2.width == -2))
    {
      paramConstraintLayout.a(this.a).getLayoutParams().width = 0;
      locala2.width = 0;
    }
  }

  protected boolean a()
  {
    return (this.a != -1) && (this.b != -1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.reply.a
 * JD-Core Version:    0.6.2
 */