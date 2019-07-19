package com.appboy.ui.contentcards.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.appboy.e.a.a;
import com.appboy.ui.R.drawable;
import com.appboy.ui.R.id;
import com.appboy.ui.R.layout;
import com.appboy.ui.R.style;

public class BannerImageContentCardView extends BaseContentCardView<a>
{
  public BannerImageContentCardView(Context paramContext)
  {
    super(paramContext);
  }

  public void bindViewHolder(ContentCardViewHolder paramContentCardViewHolder, a parama)
  {
    super.bindViewHolder(paramContentCardViewHolder, parama);
    setOptionalCardImage(((ViewHolder)paramContentCardViewHolder).getImageView(), parama.c(), parama.a(), 6.0F);
  }

  public ContentCardViewHolder createViewHolder(ViewGroup paramViewGroup)
  {
    View localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.com_appboy_banner_image_content_card, paramViewGroup, false);
    localView.setBackground(getResources().getDrawable(R.drawable.com_appboy_card_background));
    return new ViewHolder(localView);
  }

  private class ViewHolder extends ContentCardViewHolder
  {
    private View mCardImage = createCardImageWithStyle(BannerImageContentCardView.this.getContext(), localView, R.style.Appboy_ContentCards_BannerImage_ImageContainer_Image, R.id.com_appboy_content_cards_banner_image_card_image_container);

    ViewHolder(View arg2)
    {
      super(BannerImageContentCardView.this.isUnreadIndicatorEnabled());
    }

    ImageView getImageView()
    {
      if ((this.mCardImage instanceof ImageView))
        return (ImageView)this.mCardImage;
      return null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.contentcards.view.BannerImageContentCardView
 * JD-Core Version:    0.6.2
 */