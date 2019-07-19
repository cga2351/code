package com.appboy.ui.contentcards.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.appboy.e.a.c;
import com.appboy.ui.R.layout;

public class DefaultContentCardView extends BaseContentCardView<c>
{
  public DefaultContentCardView(Context paramContext)
  {
    super(paramContext);
  }

  public void bindViewHolder(ContentCardViewHolder paramContentCardViewHolder, c paramc)
  {
  }

  public ContentCardViewHolder createViewHolder(ViewGroup paramViewGroup)
  {
    return new ContentCardViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.com_appboy_default_content_card, paramViewGroup, false), false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.contentcards.view.DefaultContentCardView
 * JD-Core Version:    0.6.2
 */