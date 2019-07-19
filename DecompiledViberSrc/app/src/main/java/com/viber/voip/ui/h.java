package com.viber.voip.ui;

import android.view.View;
import com.viber.voip.R.id;
import com.viber.voip.util.dj;
import com.viber.voip.widget.ProgressBar;

public class h
{
  protected View m;
  protected ProgressBar n;

  public boolean a(View paramView)
  {
    return a(paramView, false);
  }

  public boolean a(View paramView, boolean paramBoolean)
  {
    if (e())
      return false;
    this.m = paramView;
    this.n = ((ProgressBar)paramView.findViewById(R.id.emptyProgress));
    if (this.n != null)
      dj.b(this.n, paramBoolean);
    return true;
  }

  public void b(View paramView, boolean paramBoolean)
  {
    if (this.n == null)
      this.n = ((ProgressBar)paramView.findViewById(R.id.emptyProgress));
    if (this.n != null)
      dj.b(this.n, paramBoolean);
  }

  public void d(boolean paramBoolean)
  {
    if (this.n == null)
      return;
    if (paramBoolean)
    {
      this.n.setVisibility(0);
      return;
    }
    this.n.setVisibility(8);
  }

  public boolean e()
  {
    return this.m != null;
  }

  public boolean f()
  {
    return (this.n != null) && (this.n.getVisibility() == 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.h
 * JD-Core Version:    0.6.2
 */