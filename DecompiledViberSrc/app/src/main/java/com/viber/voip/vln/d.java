package com.viber.voip.vln;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.ListView;
import com.getkeepsafe.taptargetview.b;
import com.viber.voip.R.color;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.messages.adapters.u;

public class d
  implements View.OnLayoutChangeListener
{
  private final Context a;
  private final com.viber.common.b.d b;
  private ListView c;
  private u d;
  private a e;

  public d(Context paramContext, com.viber.common.b.d paramd)
  {
    this.a = paramContext;
    this.b = paramd;
  }

  private b a(ListView paramListView, int paramInt)
  {
    View localView = paramListView.getChildAt(paramInt).findViewById(R.id.icon);
    b localb = null;
    if (localView != null)
    {
      String str = this.a.getString(R.string.vln_discoverability_message);
      Drawable localDrawable = ContextCompat.getDrawable(this.a, R.drawable.ic_list_item_vln_inbox_target);
      localb = b.a(localView, str, null).a(R.color.main_light).b(R.color.negative).c(R.color.negative).b(true).c(true).d(false).a(localDrawable);
    }
    return localb;
  }

  public void a()
  {
    this.b.a(3);
    b();
  }

  public void a(ListView paramListView, u paramu, a parama)
  {
    if (this.b.d() == 2)
    {
      this.c = paramListView;
      this.d = paramu;
      this.e = parama;
      if (this.c != null)
        this.c.addOnLayoutChangeListener(this);
    }
  }

  public void b()
  {
    if (this.c != null)
      this.c.removeOnLayoutChangeListener(this);
  }

  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (paramInt4 - paramInt2 <= 0)
      break label7;
    label7: label51: label124: 
    while (true)
    {
      return;
      if ((this.c != null) && (this.d != null) && (this.b.d() == 2))
      {
        int i = this.c.getFirstVisiblePosition();
        int j = this.c.getLastVisiblePosition();
        if (i < j)
          if (this.d.getItemViewType(i) != 6);
        while (true)
        {
          if (i == -1)
            break label124;
          b localb = a(this.c, i);
          if ((localb == null) || (this.e == null))
            break;
          this.e.a(localb);
          return;
          i++;
          break label51;
          i = -1;
        }
      }
    }
  }

  public static abstract interface a
  {
    public abstract void a(b paramb);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.vln.d
 * JD-Core Version:    0.6.2
 */