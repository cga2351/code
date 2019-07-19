package com.appboy.ui.widget;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.appboy.a.b;
import com.appboy.b.e;
import com.appboy.g;
import com.appboy.h;
import com.appboy.ui.AppboyNavigator;
import com.appboy.ui.R.drawable;
import com.appboy.ui.R.string;
import com.appboy.ui.actions.ActionFactory;
import com.appboy.ui.actions.IAction;
import com.appboy.ui.actions.UriAction;
import com.appboy.ui.feed.AppboyImageSwitcher;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class BaseCardView<T extends com.appboy.e.a.c> extends RelativeLayout
{
  private static final String TAG = com.appboy.f.c.a(BaseCardView.class);
  private static Boolean sUnreadCardVisualIndicatorEnabled;
  protected b mAppboyConfigurationProvider;
  protected T mCard;
  private final String mClassLogTag;
  protected final Context mContext;
  protected AppboyImageSwitcher mImageSwitcher;

  public BaseCardView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext.getApplicationContext();
    if (this.mAppboyConfigurationProvider == null)
      this.mAppboyConfigurationProvider = new b(paramContext);
    if (sUnreadCardVisualIndicatorEnabled == null)
      sUnreadCardVisualIndicatorEnabled = Boolean.valueOf(this.mAppboyConfigurationProvider.l());
    this.mClassLogTag = com.appboy.f.c.a(getClass());
  }

  protected static UriAction getUriActionForCard(com.appboy.e.a.c paramc)
  {
    Bundle localBundle = new Bundle();
    Iterator localIterator = paramc.n().keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localBundle.putString(str, (String)paramc.n().get(str));
    }
    return ActionFactory.createUriActionFromUrlString(paramc.b(), localBundle, paramc.p(), e.c);
  }

  public String getClassLogTag()
  {
    return this.mClassLogTag;
  }

  protected void handleCardClick(Context paramContext, com.appboy.e.a.c paramc, IAction paramIAction, String paramString)
  {
    paramc.a(true);
    if (paramIAction != null)
    {
      if (paramc.j())
        com.appboy.f.c.b(paramString, "Logged click for card: " + paramc.m());
      while (!isClickHandled(paramContext, paramc, paramIAction))
        if ((paramIAction instanceof UriAction))
        {
          AppboyNavigator.getAppboyNavigator().gotoUri(paramContext, (UriAction)paramIAction);
          return;
          com.appboy.f.c.b(paramString, "Logging click failed for card: " + paramc.m());
        }
        else
        {
          com.appboy.f.c.b(TAG, "Executing non uri action for click on card: " + paramc.m());
          paramIAction.execute(paramContext);
          return;
        }
      com.appboy.f.c.b(TAG, "Card click was handled by custom listener for card: " + paramc.m());
      return;
    }
    com.appboy.f.c.a(TAG, "Card action is null. Not performing any click action for card: " + paramc.m());
  }

  protected abstract boolean isClickHandled(Context paramContext, com.appboy.e.a.c paramc, IAction paramIAction);

  public boolean isUnreadIndicatorEnabled()
  {
    return sUnreadCardVisualIndicatorEnabled.booleanValue();
  }

  public void setCardViewedIndicator(AppboyImageSwitcher paramAppboyImageSwitcher, com.appboy.e.a.c paramc)
  {
    if (paramc == null);
    String str;
    label91: 
    do
    {
      do
      {
        com.appboy.f.c.b(getClassLogTag(), "The card is null. Not setting read/unread indicator.");
        do
          return;
        while (paramAppboyImageSwitcher == null);
        str = (String)paramAppboyImageSwitcher.getTag(R.string.com_appboy_image_is_read_tag_key);
        if (str == null)
          break;
        if (!paramc.k())
          break label91;
      }
      while (str.equals("icon_read"));
      if (paramAppboyImageSwitcher.getReadIcon() != null)
        paramAppboyImageSwitcher.setImageDrawable(paramAppboyImageSwitcher.getReadIcon());
      while (true)
      {
        paramAppboyImageSwitcher.setTag(R.string.com_appboy_image_is_read_tag_key, "icon_read");
        return;
        str = "";
        break;
        paramAppboyImageSwitcher.setImageResource(R.drawable.icon_read);
      }
    }
    while (str.equals("icon_unread"));
    if (paramAppboyImageSwitcher.getUnReadIcon() != null)
      paramAppboyImageSwitcher.setImageDrawable(paramAppboyImageSwitcher.getUnReadIcon());
    while (true)
    {
      paramAppboyImageSwitcher.setTag(R.string.com_appboy_image_is_read_tag_key, "icon_unread");
      return;
      paramAppboyImageSwitcher.setImageResource(R.drawable.icon_unread);
    }
  }

  public void setImageViewToUrl(final ImageView paramImageView, String paramString, final float paramFloat)
  {
    if (paramString == null)
      com.appboy.f.c.d(TAG, "The image url to render is null. Not setting the card image.");
    do
    {
      return;
      if (paramFloat == 0.0F)
      {
        com.appboy.f.c.d(TAG, "The image aspect ratio is 0. Not setting the card image.");
        return;
      }
    }
    while (paramString.equals(paramImageView.getTag(R.string.com_appboy_image_resize_tag_key)));
    if (paramFloat != 1.0F)
    {
      ViewTreeObserver localViewTreeObserver = paramImageView.getViewTreeObserver();
      if (localViewTreeObserver.isAlive())
        localViewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public void onGlobalLayout()
          {
            int i = paramImageView.getWidth();
            paramImageView.setLayoutParams(new RelativeLayout.LayoutParams(i, (int)(i / paramFloat)));
            paramImageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
          }
        });
    }
    paramImageView.setImageResource(17170445);
    com.appboy.a.a(getContext()).h().a(getContext(), paramString, paramImageView, com.appboy.b.a.d);
    paramImageView.setTag(R.string.com_appboy_image_resize_tag_key, paramString);
  }

  public void setOptionalTextView(TextView paramTextView, String paramString)
  {
    if ((paramString != null) && (!paramString.trim().equals("")))
    {
      paramTextView.setText(paramString);
      paramTextView.setVisibility(0);
      return;
    }
    paramTextView.setText("");
    paramTextView.setVisibility(8);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.widget.BaseCardView
 * JD-Core Version:    0.6.2
 */