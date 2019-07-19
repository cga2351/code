package com.appboy.ui.contentcards.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.appboy.e.a.b;
import com.appboy.f.i;
import com.appboy.ui.R.drawable;
import com.appboy.ui.R.id;
import com.appboy.ui.R.layout;
import com.appboy.ui.R.style;

public class CaptionedImageContentCardView extends BaseContentCardView<b>
{
  public CaptionedImageContentCardView(Context paramContext)
  {
    super(paramContext);
  }

  public void bindViewHolder(ContentCardViewHolder paramContentCardViewHolder, b paramb)
  {
    super.bindViewHolder(paramContentCardViewHolder, paramb);
    ViewHolder localViewHolder = (ViewHolder)paramContentCardViewHolder;
    localViewHolder.getTitle().setText(paramb.c());
    localViewHolder.getDescription().setText(paramb.e());
    if (i.c(paramb.f()));
    for (String str = paramb.b(); ; str = paramb.f())
    {
      localViewHolder.setActionHintText(str);
      setOptionalCardImage(localViewHolder.getImageView(), paramb.g(), paramb.a(), 1.333333F);
      return;
    }
  }

  public ContentCardViewHolder createViewHolder(ViewGroup paramViewGroup)
  {
    View localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.com_appboy_captioned_image_content_card, paramViewGroup, false);
    localView.setBackground(getResources().getDrawable(R.drawable.com_appboy_card_background));
    return new ViewHolder(localView);
  }

  private class ViewHolder extends ContentCardViewHolder
  {
    private View mCardImage = createCardImageWithStyle(CaptionedImageContentCardView.this.getContext(), localView, R.style.Appboy_ContentCards_CaptionedImage_ImageContainer_Image, R.id.com_appboy_content_cards_captioned_image_card_image_container);
    private final TextView mDescription;
    private final TextView mTitle;

    ViewHolder(View arg2)
    {
      super(CaptionedImageContentCardView.this.isUnreadIndicatorEnabled());
      this.mTitle = ((TextView)localView.findViewById(R.id.com_appboy_content_cards_captioned_image_title));
      this.mDescription = ((TextView)localView.findViewById(R.id.com_appboy_content_cards_captioned_image_description));
    }

    TextView getDescription()
    {
      return this.mDescription;
    }

    ImageView getImageView()
    {
      if ((this.mCardImage instanceof ImageView))
        return (ImageView)this.mCardImage;
      return null;
    }

    TextView getTitle()
    {
      return this.mTitle;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.contentcards.view.CaptionedImageContentCardView
 * JD-Core Version:    0.6.2
 */