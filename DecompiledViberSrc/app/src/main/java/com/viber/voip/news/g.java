package com.viber.voip.news;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.viber.voip.util.ViberActionRunner.ab;

class g extends l<MoreScreenNewsBrowserPresenter>
  implements f
{
  g(AppCompatActivity paramAppCompatActivity, Fragment paramFragment, MoreScreenNewsBrowserPresenter paramMoreScreenNewsBrowserPresenter, View paramView)
  {
    super(paramAppCompatActivity, paramFragment, paramMoreScreenNewsBrowserPresenter, paramView);
  }

  public void a()
  {
    this.a.startActivity(ViberActionRunner.ab.a(this.a));
    this.a.finish();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.news.g
 * JD-Core Version:    0.6.2
 */