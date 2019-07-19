package com.yandex.mobile.ads.impl;

import android.view.View;
import android.view.View.OnClickListener;

public final class jx
  implements View.OnClickListener
{
  private final View a;

  public jx(View paramView)
  {
    this.a = paramView;
  }

  public final void onClick(View paramView)
  {
    View localView;
    if (this.a != null)
    {
      localView = this.a;
      if (this.a.isSelected())
        break label30;
    }
    label30: for (boolean bool = true; ; bool = false)
    {
      localView.setSelected(bool);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.jx
 * JD-Core Version:    0.6.2
 */