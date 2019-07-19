package com.appnexus.opensdk;

import android.view.View;
import com.appnexus.opensdk.utils.ViewUtil;

class q
  implements i
{
  private View a;
  private MediatedAdViewController b;

  q(MediatedAdViewController paramMediatedAdViewController)
  {
    this.b = paramMediatedAdViewController;
  }

  MediatedAdViewController a()
  {
    return this.b;
  }

  void a(View paramView)
  {
    this.a = paramView;
  }

  public void destroy()
  {
    this.b.b();
    ViewUtil.removeChildFromParent(this.a);
  }

  public View i()
  {
    return this.a;
  }

  public boolean j()
  {
    return this.b.f;
  }

  public int k()
  {
    if (this.a != null)
      return this.a.getWidth();
    return -1;
  }

  public int l()
  {
    if (this.a != null)
      return this.a.getHeight();
    return -1;
  }

  public void m()
  {
    this.b.onDestroy();
    destroy();
  }

  public void n()
  {
  }

  public void onPause()
  {
    this.b.onPause();
  }

  public void onResume()
  {
    this.b.onResume();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.q
 * JD-Core Version:    0.6.2
 */