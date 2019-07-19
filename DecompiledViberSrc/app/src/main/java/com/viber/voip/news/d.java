package com.viber.voip.news;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.viber.voip.widget.ViberWebView;

class d extends l<HomeTabNewsBrowserPresenter>
  implements c
{
  d(AppCompatActivity paramAppCompatActivity, Fragment paramFragment, HomeTabNewsBrowserPresenter paramHomeTabNewsBrowserPresenter, View paramView)
  {
    super(paramAppCompatActivity, paramFragment, paramHomeTabNewsBrowserPresenter, paramView);
  }

  public void a()
  {
    this.b.reload();
  }

  public void b()
  {
    ((HomeTabNewsBrowserPresenter)this.mPresenter).a();
  }

  public void onFragmentVisibilityChanged(boolean paramBoolean)
  {
    super.onFragmentVisibilityChanged(paramBoolean);
    ((HomeTabNewsBrowserPresenter)this.mPresenter).a(paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.news.d
 * JD-Core Version:    0.6.2
 */