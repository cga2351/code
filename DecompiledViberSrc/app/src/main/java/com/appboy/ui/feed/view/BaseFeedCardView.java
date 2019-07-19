package com.appboy.ui.feed.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;
import com.appboy.ui.R.id;
import com.appboy.ui.actions.IAction;
import com.appboy.ui.feed.AppboyFeedManager;
import com.appboy.ui.feed.AppboyImageSwitcher;
import com.appboy.ui.feed.listeners.IFeedClickActionListener;
import com.appboy.ui.widget.BaseCardView;
import java.util.Observable;
import java.util.Observer;

public abstract class BaseFeedCardView<T extends com.appboy.e.a.c> extends BaseCardView<T>
  implements Observer
{
  private static final String TAG = com.appboy.f.c.a(BaseCardView.class);

  public BaseFeedCardView(Context paramContext)
  {
    super(paramContext);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(getLayoutResource(), this);
    this.mImageSwitcher = ((AppboyImageSwitcher)findViewById(R.id.com_appboy_newsfeed_item_read_indicator_image_switcher));
    if (this.mImageSwitcher != null)
      this.mImageSwitcher.setFactory(new ViewSwitcher.ViewFactory()
      {
        public View makeView()
        {
          return new ImageView(BaseFeedCardView.this.mContext.getApplicationContext());
        }
      });
    if ((!isUnreadIndicatorEnabled()) && (this.mImageSwitcher != null))
      this.mImageSwitcher.setVisibility(8);
  }

  public com.appboy.e.a.c getCard()
  {
    return this.mCard;
  }

  protected abstract int getLayoutResource();

  public View getProperViewFromInflatedStub(int paramInt)
  {
    ((ViewStub)findViewById(paramInt)).inflate();
    return findViewById(R.id.com_appboy_stubbed_feed_image_view);
  }

  protected boolean isClickHandled(Context paramContext, com.appboy.e.a.c paramc, IAction paramIAction)
  {
    return AppboyFeedManager.getInstance().getFeedCardClickActionListener().onFeedCardClicked(paramContext, paramc, paramIAction);
  }

  protected abstract void onSetCard(T paramT);

  public void setCard(T paramT)
  {
    this.mCard = paramT;
    onSetCard(paramT);
    paramT.addObserver(this);
    setCardViewedIndicator(this.mImageSwitcher, getCard());
  }

  public void update(Observable paramObservable, Object paramObject)
  {
    setCardViewedIndicator(this.mImageSwitcher, getCard());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.feed.view.BaseFeedCardView
 * JD-Core Version:    0.6.2
 */