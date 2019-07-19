package com.appboy.ui.widget;

import android.content.Context;
import com.appboy.ui.R.layout;
import com.appboy.ui.feed.view.BaseFeedCardView;

public class DefaultCardView extends BaseFeedCardView<com.appboy.e.a.c>
{
  private static final String TAG = com.appboy.f.c.a(DefaultCardView.class);

  public DefaultCardView(Context paramContext)
  {
    this(paramContext, null);
  }

  public DefaultCardView(Context paramContext, com.appboy.e.a.c paramc)
  {
    super(paramContext);
    if (paramc != null)
      setCard(paramc);
  }

  protected int getLayoutResource()
  {
    return R.layout.com_appboy_default_card;
  }

  public void onSetCard(com.appboy.e.a.c paramc)
  {
    com.appboy.f.c.d(TAG, "onSetCard called for blank view with: " + paramc.toString());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.widget.DefaultCardView
 * JD-Core Version:    0.6.2
 */