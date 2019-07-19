package com.viber.voip.messages.conversation.adapter.viewbinders.helpers.fm;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.a.a.c.c;
import android.support.constraint.a.a.d;
import android.view.View;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.b;
import com.viber.voip.messages.orm.entity.json.FormattedMessage;

class a extends b
{
  private final int a;
  private final int b;

  a(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }

  protected boolean a()
  {
    return (this.a != -1) && (this.b != -1);
  }

  protected void c(ConstraintLayout paramConstraintLayout, android.support.constraint.a parama)
  {
    FormattedMessageConstraintHelper.a locala = (FormattedMessageConstraintHelper.a)parama.getTag();
    if ((locala != null) && (locala.a.hasLastMedia()));
    d locald1;
    d locald2;
    for (int i = 1; ; i = 0)
    {
      View localView1 = paramConstraintLayout.a(this.a);
      View localView2 = paramConstraintLayout.a(this.b);
      locald1 = paramConstraintLayout.a(localView1);
      locald2 = paramConstraintLayout.a(localView2);
      d locald3 = paramConstraintLayout.a(paramConstraintLayout);
      if (i == 0)
        break;
      locald2.a(c.c.e, locald3, c.c.e);
      return;
    }
    locald2.a(c.c.e, locald1, c.c.c);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.fm.a
 * JD-Core Version:    0.6.2
 */