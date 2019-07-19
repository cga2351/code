package com.appboy.ui.contentcards.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.appboy.e.a.e;
import com.appboy.f.i;
import com.appboy.ui.R.drawable;
import com.appboy.ui.R.id;
import com.appboy.ui.R.layout;
import com.appboy.ui.R.style;

public class ShortNewsContentCardView extends BaseContentCardView<e>
{
  public ShortNewsContentCardView(Context paramContext)
  {
    super(paramContext);
  }

  public void bindViewHolder(ContentCardViewHolder paramContentCardViewHolder, e parame)
  {
    super.bindViewHolder(paramContentCardViewHolder, parame);
    ViewHolder localViewHolder = (ViewHolder)paramContentCardViewHolder;
    localViewHolder.getTitle().setText(parame.e());
    localViewHolder.getDescription().setText(parame.a());
    if (i.c(parame.f()));
    for (String str = parame.b(); ; str = parame.f())
    {
      localViewHolder.setActionHintText(str);
      setOptionalCardImage(localViewHolder.getImageView(), 1.0F, parame.c(), 1.0F);
      if (Build.VERSION.SDK_INT >= 21)
        safeSetClipToOutline(localViewHolder.getImageView());
      return;
    }
  }

  public ContentCardViewHolder createViewHolder(ViewGroup paramViewGroup)
  {
    View localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.com_appboy_short_news_content_card, paramViewGroup, false);
    localView.setBackground(getResources().getDrawable(R.drawable.com_appboy_card_background));
    return new ViewHolder(localView);
  }

  private class ViewHolder extends ContentCardViewHolder
  {
    private View mCardImage = createCardImageWithStyle(ShortNewsContentCardView.this.getContext(), localView, R.style.Appboy_ContentCards_ShortNews_ImageContainer_Image, R.id.com_appboy_content_cards_short_news_card_image_container);
    private final TextView mDescription;
    private final TextView mTitle;

    ViewHolder(View arg2)
    {
      super(ShortNewsContentCardView.this.isUnreadIndicatorEnabled());
      this.mTitle = ((TextView)localView.findViewById(R.id.com_appboy_content_cards_short_news_card_title));
      this.mDescription = ((TextView)localView.findViewById(R.id.com_appboy_content_cards_short_news_card_description));
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
 * Qualified Name:     com.appboy.ui.contentcards.view.ShortNewsContentCardView
 * JD-Core Version:    0.6.2
 */