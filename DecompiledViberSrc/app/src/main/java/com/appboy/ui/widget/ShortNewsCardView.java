package com.appboy.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.appboy.e.a.e;
import com.appboy.f.c;
import com.appboy.ui.R.drawable;
import com.appboy.ui.R.id;
import com.appboy.ui.R.layout;
import com.appboy.ui.actions.IAction;
import com.appboy.ui.feed.view.BaseFeedCardView;

public class ShortNewsCardView extends BaseFeedCardView<e>
{
  private static final String TAG = c.a(ShortNewsCardView.class);
  private final float mAspectRatio = 1.0F;
  private IAction mCardAction;
  private final TextView mDescription = (TextView)findViewById(R.id.com_appboy_short_news_card_description);
  private final TextView mDomain = (TextView)findViewById(R.id.com_appboy_short_news_card_domain);
  private ImageView mImage = (ImageView)getProperViewFromInflatedStub(R.id.com_appboy_short_news_card_imageview_stub);
  private final TextView mTitle = (TextView)findViewById(R.id.com_appboy_short_news_card_title);

  public ShortNewsCardView(Context paramContext)
  {
    this(paramContext, null);
  }

  public ShortNewsCardView(Context paramContext, e parame)
  {
    super(paramContext);
    this.mImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.mImage.setAdjustViewBounds(true);
    if (parame != null)
      setCard(parame);
    setBackground(getResources().getDrawable(R.drawable.com_appboy_card_background));
  }

  protected int getLayoutResource()
  {
    return R.layout.com_appboy_short_news_card;
  }

  public void onSetCard(final e parame)
  {
    this.mDescription.setText(parame.a());
    setOptionalTextView(this.mTitle, parame.e());
    setOptionalTextView(this.mDomain, parame.f());
    this.mCardAction = getUriActionForCard(parame);
    setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ShortNewsCardView.this.handleCardClick(ShortNewsCardView.this.mContext, parame, ShortNewsCardView.this.mCardAction, ShortNewsCardView.TAG);
      }
    });
    setImageViewToUrl(this.mImage, parame.c(), 1.0F);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.widget.ShortNewsCardView
 * JD-Core Version:    0.6.2
 */