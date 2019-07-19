package com.appboy.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.appboy.e.a.a;
import com.appboy.f.c;
import com.appboy.ui.R.drawable;
import com.appboy.ui.R.id;
import com.appboy.ui.R.layout;
import com.appboy.ui.actions.IAction;
import com.appboy.ui.feed.view.BaseFeedCardView;

public class BannerImageCardView extends BaseFeedCardView<a>
{
  private static final String TAG = c.a(BannerImageCardView.class);
  private float mAspectRatio = 6.0F;
  private IAction mCardAction;
  private ImageView mImage = (ImageView)getProperViewFromInflatedStub(R.id.com_appboy_banner_image_card_imageview_stub);

  public BannerImageCardView(Context paramContext)
  {
    this(paramContext, null);
  }

  public BannerImageCardView(Context paramContext, a parama)
  {
    super(paramContext);
    this.mImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.mImage.setAdjustViewBounds(true);
    if (parama != null)
      setCard(parama);
    setBackground(getResources().getDrawable(R.drawable.com_appboy_card_background));
  }

  protected int getLayoutResource()
  {
    return R.layout.com_appboy_banner_image_card;
  }

  public void onSetCard(final a parama)
  {
    if (parama.c() != 0.0F)
      this.mAspectRatio = parama.c();
    setImageViewToUrl(this.mImage, parama.a(), this.mAspectRatio);
    this.mCardAction = getUriActionForCard(parama);
    setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        BannerImageCardView.this.handleCardClick(BannerImageCardView.this.mContext, parama, BannerImageCardView.this.mCardAction, BannerImageCardView.TAG);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.widget.BannerImageCardView
 * JD-Core Version:    0.6.2
 */