package com.viber.voip.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class u
{
  private final ListView a;

  public u(ListView paramListView)
  {
    this.a = paramListView;
  }

  public boolean a(float paramFloat, View paramView)
  {
    boolean bool1 = true;
    int i = this.a.getHeight();
    int j = paramView.getHeight();
    if ((i == 0) || (j == 0))
      bool1 = false;
    int n;
    int i1;
    do
    {
      return bool1;
      int k = paramView.getTop();
      int m = paramView.getBottom();
      ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
      n = k + localViewGroup.getTop();
      i1 = localViewGroup.getBottom() - m;
    }
    while ((n > 0) && (i1 < i));
    int i2 = (int)(j - paramFloat * j);
    boolean bool2;
    boolean bool3;
    if (n + i2 > 0)
    {
      bool2 = bool1;
      if (i1 - i2 >= i)
        break label142;
      bool3 = bool1;
      label120: if ((!bool2) || (!bool3))
        break label148;
    }
    label142: label148: for (boolean bool4 = bool1; ; bool4 = false)
    {
      return bool4;
      bool2 = false;
      break;
      bool3 = false;
      break label120;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.u
 * JD-Core Version:    0.6.2
 */