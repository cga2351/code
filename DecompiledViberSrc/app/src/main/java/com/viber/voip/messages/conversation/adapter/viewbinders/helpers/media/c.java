package com.viber.voip.messages.conversation.adapter.viewbinders.helpers.media;

import android.content.Context;
import android.content.res.Resources;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.a.a.d;
import android.view.View;
import com.viber.voip.R.id;
import com.viber.voip.messages.conversation.adapter.e.j;
import com.viber.voip.messages.conversation.adapter.e.k;

class c extends com.viber.voip.messages.conversation.adapter.viewbinders.helpers.b
{
  private final int a;
  private final j b;
  private final k c;
  private View d;

  c(Context paramContext, int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    Resources localResources = paramContext.getResources();
    this.b = new j(new com.viber.voip.app.b(paramContext, com.viber.voip.h.a.c()), localResources);
    this.c = new k(paramInt2, localResources);
  }

  private View a(ConstraintLayout paramConstraintLayout)
  {
    if (this.d == null)
      this.d = paramConstraintLayout.a(this.a);
    return this.d;
  }

  protected void a(ConstraintLayout paramConstraintLayout, android.support.constraint.a parama)
  {
    View localView = a(paramConstraintLayout);
    this.b.a(paramConstraintLayout.a(paramConstraintLayout).o(), this.c.a(), this.c.b(), this.c.c(), this.c.d());
    MediaMessageConstraintHelper.a locala = (MediaMessageConstraintHelper.a)localView.getTag(R.id.media_info);
    int i = this.b.a();
    int j = this.b.b();
    if (locala != null)
    {
      if (locala.a > 0)
        i = locala.a;
      if (locala.b <= 0);
    }
    for (int k = locala.b; ; k = j)
    {
      int[] arrayOfInt = this.b.a(i, k, true);
      localView.getLayoutParams().width = arrayOfInt[0];
      localView.getLayoutParams().height = arrayOfInt[1];
      return;
    }
  }

  protected boolean a()
  {
    return this.a != -1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.media.c
 * JD-Core Version:    0.6.2
 */