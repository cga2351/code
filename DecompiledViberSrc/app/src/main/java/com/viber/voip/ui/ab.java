package com.viber.voip.ui;

import android.view.View;
import android.view.View.OnTouchListener;
import com.viber.voip.R.id;

public class ab extends h
{
  private n a;
  private View b;

  public void a(boolean paramBoolean)
  {
    if (this.b != null)
      if (!paramBoolean)
        break label33;
    label33: for (int i = 0; ; i = 8)
    {
      this.b.setVisibility(i);
      this.a.a.setVisibility(i);
      return;
    }
  }

  public boolean a(View paramView, View.OnTouchListener paramOnTouchListener)
  {
    if (!super.a(paramView))
      return false;
    this.b = paramView.findViewById(R.id.recents_empty_root);
    this.a = new n(paramView);
    this.a.a();
    paramView.findViewById(16908292).setOnTouchListener(paramOnTouchListener);
    return true;
  }

  public void b(boolean paramBoolean)
  {
    if (!e())
      return;
    if (paramBoolean)
    {
      d(true);
      return;
    }
    d(false);
  }

  public void d(boolean paramBoolean)
  {
    super.d(paramBoolean);
    View localView;
    if (this.a.a != null)
    {
      localView = this.a.a;
      if (!paramBoolean)
        break label36;
    }
    label36: for (int i = 8; ; i = 0)
    {
      localView.setVisibility(i);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.ab
 * JD-Core Version:    0.6.2
 */