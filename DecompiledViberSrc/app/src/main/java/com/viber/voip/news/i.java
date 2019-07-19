package com.viber.voip.news;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.mvp.core.g;
import com.viber.voip.util.cj;
import com.viber.voip.util.cv;
import javax.inject.Inject;

abstract class i<PRESENTER extends NewsBrowserPresenter, VIEW extends l> extends g<VIEW>
{

  @Inject
  q a;

  @Inject
  cv b;

  @Inject
  cj c;

  @Inject
  com.viber.voip.util.i.a d;

  @Inject
  dagger.a<ICdrController> e;

  @Inject
  dagger.a<com.viber.voip.analytics.story.g.a> f;

  @Inject
  Handler g;
  protected PRESENTER h;
  protected VIEW i;

  protected void initModelComponent(View paramView, Bundle paramBundle)
  {
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.news.i
 * JD-Core Version:    0.6.2
 */