package com.appboy.ui.contentcards.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.appboy.e.a.f;
import com.appboy.f.i;
import com.appboy.ui.R.drawable;
import com.appboy.ui.R.id;
import com.appboy.ui.R.layout;

public class TextAnnouncementContentCardView extends BaseContentCardView<f>
{
  public TextAnnouncementContentCardView(Context paramContext)
  {
    super(paramContext);
  }

  public void bindViewHolder(ContentCardViewHolder paramContentCardViewHolder, f paramf)
  {
    super.bindViewHolder(paramContentCardViewHolder, paramf);
    ViewHolder localViewHolder = (ViewHolder)paramContentCardViewHolder;
    localViewHolder.getTitle().setText(paramf.c());
    localViewHolder.getDescription().setText(paramf.a());
    if (i.c(paramf.e()));
    for (String str = paramf.b(); ; str = paramf.e())
    {
      localViewHolder.setActionHintText(str);
      return;
    }
  }

  public ContentCardViewHolder createViewHolder(ViewGroup paramViewGroup)
  {
    View localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.com_appboy_text_announcement_content_card, paramViewGroup, false);
    localView.setBackground(getResources().getDrawable(R.drawable.com_appboy_card_background));
    return new ViewHolder(localView);
  }

  private class ViewHolder extends ContentCardViewHolder
  {
    private final TextView mDescription;
    private final TextView mTitle;

    ViewHolder(View arg2)
    {
      super(TextAnnouncementContentCardView.this.isUnreadIndicatorEnabled());
      this.mTitle = ((TextView)localView.findViewById(R.id.com_appboy_content_cards_text_announcement_card_title));
      this.mDescription = ((TextView)localView.findViewById(R.id.com_appboy_content_cards_text_announcement_card_description));
    }

    TextView getDescription()
    {
      return this.mDescription;
    }

    TextView getTitle()
    {
      return this.mTitle;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.contentcards.view.TextAnnouncementContentCardView
 * JD-Core Version:    0.6.2
 */