package com.appboy.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.appboy.e.a.b;
import com.appboy.f.c;
import com.appboy.ui.R.drawable;
import com.appboy.ui.R.id;
import com.appboy.ui.R.layout;
import com.appboy.ui.actions.IAction;
import com.appboy.ui.feed.view.BaseFeedCardView;

public class CaptionedImageCardView extends BaseFeedCardView<b>
{
  private static final String TAG = c.a(CaptionedImageCardView.class);
  private float mAspectRatio = 1.333333F;
  private IAction mCardAction;
  private final TextView mDescription;
  private final TextView mDomain;
  private ImageView mImage = (ImageView)getProperViewFromInflatedStub(R.id.com_appboy_captioned_image_card_imageview_stub);
  private final TextView mTitle;

  public CaptionedImageCardView(Context paramContext)
  {
    this(paramContext, null);
  }

  public CaptionedImageCardView(Context paramContext, b paramb)
  {
    super(paramContext);
    this.mImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.mImage.setAdjustViewBounds(true);
    this.mTitle = ((TextView)findViewById(R.id.com_appboy_captioned_image_title));
    this.mDescription = ((TextView)findViewById(R.id.com_appboy_captioned_image_description));
    this.mDomain = ((TextView)findViewById(R.id.com_appboy_captioned_image_card_domain));
    if (paramb != null)
      setCard(paramb);
    setBackground(getResources().getDrawable(R.drawable.com_appboy_card_background));
  }

  protected int getLayoutResource()
  {
    return R.layout.com_appboy_captioned_image_card;
  }

  public void onSetCard(final b paramb)
  {
    this.mTitle.setText(paramb.c());
    this.mDescription.setText(paramb.e());
    setOptionalTextView(this.mDomain, paramb.f());
    this.mCardAction = getUriActionForCard(paramb);
    setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CaptionedImageCardView.this.handleCardClick(CaptionedImageCardView.this.mContext, paramb, CaptionedImageCardView.this.mCardAction, CaptionedImageCardView.TAG);
      }
    });
    if (paramb.g() != 0.0F)
      this.mAspectRatio = paramb.g();
    setImageViewToUrl(this.mImage, paramb.a(), this.mAspectRatio);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.widget.CaptionedImageCardView
 * JD-Core Version:    0.6.2
 */