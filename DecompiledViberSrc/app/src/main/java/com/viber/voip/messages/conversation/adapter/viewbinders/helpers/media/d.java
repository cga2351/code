package com.viber.voip.messages.conversation.adapter.viewbinders.helpers.media;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.a;
import android.view.View;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.b;
import com.viber.voip.util.dj;
import com.viber.voip.widget.PercentConstraintLayout;

public class d extends b
{
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  private final int f;

  public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.f = paramInt6;
  }

  protected void a(ConstraintLayout paramConstraintLayout, a parama)
  {
    View localView1 = paramConstraintLayout.a(this.a);
    boolean bool1 = dj.e(localView1);
    View localView2 = paramConstraintLayout.a(this.c);
    boolean bool2 = dj.e(localView2);
    View localView3 = paramConstraintLayout.a(this.b);
    if ((localView3 instanceof PercentConstraintLayout));
    while (true)
    {
      boolean bool3 = dj.e(localView3);
      if (bool1)
      {
        if ((bool3) || (!bool2))
          break label125;
        localView1.setPadding(localView1.getPaddingLeft(), localView1.getPaddingTop(), localView1.getPaddingRight(), 0);
      }
      while (true)
      {
        if (bool2)
        {
          if ((bool3) || (!bool1))
            break;
          localView2.setPadding(localView2.getPaddingLeft(), 0, localView2.getPaddingRight(), this.e);
        }
        return;
        label125: localView1.setPadding(localView1.getPaddingLeft(), localView1.getPaddingTop(), localView1.getPaddingRight(), this.d);
      }
      localView2.setPadding(localView2.getPaddingLeft(), this.f, localView2.getPaddingRight(), this.f);
      return;
      localView3 = null;
    }
  }

  protected boolean a()
  {
    return (this.a != -1) && (this.c != -1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.media.d
 * JD-Core Version:    0.6.2
 */