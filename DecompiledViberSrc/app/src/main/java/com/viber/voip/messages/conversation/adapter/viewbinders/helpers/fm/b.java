package com.viber.voip.messages.conversation.adapter.viewbinders.helpers.fm;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintLayout.a;
import android.support.constraint.a;
import android.support.constraint.a.a.c.c;
import android.support.constraint.a.a.d;
import android.view.View;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.c;
import com.viber.voip.messages.orm.entity.json.FormattedMessage;
import com.viber.voip.util.dj;

class b extends com.viber.voip.messages.conversation.adapter.viewbinders.helpers.b
{
  private final int a;
  private final int b;
  private final int c;
  private final int d;

  b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }

  private void g(ConstraintLayout paramConstraintLayout, a parama)
  {
    View localView = paramConstraintLayout.a(this.b);
    if (!dj.a(new View[] { localView }));
    d locald3;
    int k;
    int m;
    label157: 
    do
    {
      return;
      d locald1 = paramConstraintLayout.a(localView);
      d locald2 = paramConstraintLayout.a(paramConstraintLayout.a(this.a));
      if (this.c != -1);
      int i;
      int j;
      for (locald3 = paramConstraintLayout.a(paramConstraintLayout.a(this.c)); ; locald3 = null)
      {
        i = locald1.o();
        j = locald2.o();
        k = 0;
        if (locald3 != null)
          k = locald3.o();
        m = Math.max(Math.max(i, j), k);
        int n = c.a(paramConstraintLayout, parama);
        if (m >= n)
          break label157;
        locald2.h(n);
        locald1.h(n);
        if (locald3 == null)
          break;
        locald3.h(n);
        return;
      }
      if (j < m)
        locald2.h(m);
      if (i < m)
        locald1.h(m);
    }
    while ((k >= m) || (locald3 == null));
    locald3.h(m);
  }

  protected void a(ConstraintLayout paramConstraintLayout, a parama)
  {
    int i = 1;
    View localView = paramConstraintLayout.a(this.b);
    View[] arrayOfView = new View[i];
    arrayOfView[0] = localView;
    if (!dj.a(arrayOfView))
      return;
    FormattedMessageConstraintHelper.a locala = (FormattedMessageConstraintHelper.a)parama.getTag();
    if ((locala != null) && (locala.a.hasMedia()));
    d locald1;
    d locald2;
    ConstraintLayout.a locala1;
    while (true)
    {
      locald1 = paramConstraintLayout.a(localView);
      locald2 = paramConstraintLayout.a(paramConstraintLayout.a(this.a));
      locala1 = (ConstraintLayout.a)localView.getLayoutParams();
      if (i == 0)
        break label140;
      locala1.width = 0;
      if (this.d != 0)
        break;
      locald1.a(c.c.d, locald2, c.c.d);
      return;
      i = 0;
    }
    locald1.a(c.c.b, locald2, c.c.b);
    return;
    label140: locala1.width = -2;
    if (this.d == 0)
    {
      locald1.a(locald1.a(c.c.d));
      return;
    }
    locald1.a(locald1.a(c.c.b));
  }

  protected boolean a()
  {
    return (this.a != -1) && (this.b != -1);
  }

  protected void c(ConstraintLayout paramConstraintLayout, a parama)
  {
    FormattedMessageConstraintHelper.a locala = (FormattedMessageConstraintHelper.a)parama.getTag();
    if ((locala != null) && (locala.a.hasMedia()))
      return;
    g(paramConstraintLayout, parama);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.fm.b
 * JD-Core Version:    0.6.2
 */