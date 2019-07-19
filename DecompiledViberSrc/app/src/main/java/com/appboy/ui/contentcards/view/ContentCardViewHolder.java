package com.appboy.ui.contentcards.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.appboy.ui.R.drawable;
import com.appboy.ui.R.id;

public class ContentCardViewHolder extends RecyclerView.ViewHolder
{
  private final TextView mActionHint;
  private final ImageView mPinnedIcon;
  private final View mUnreadBar;

  public ContentCardViewHolder(View paramView, boolean paramBoolean)
  {
    super(paramView);
    this.mUnreadBar = paramView.findViewById(R.id.com_appboy_content_cards_unread_bar);
    if (this.mUnreadBar != null)
    {
      if (!paramBoolean)
        break label84;
      this.mUnreadBar.setVisibility(0);
      this.mUnreadBar.setBackground(paramView.getContext().getResources().getDrawable(R.drawable.com_appboy_content_cards_unread_bar_background));
    }
    while (true)
    {
      this.mPinnedIcon = ((ImageView)paramView.findViewById(R.id.com_appboy_content_cards_pinned_icon));
      this.mActionHint = ((TextView)paramView.findViewById(R.id.com_appboy_content_cards_action_hint));
      return;
      label84: this.mUnreadBar.setVisibility(8);
    }
  }

  public View createCardImageWithStyle(Context paramContext, View paramView, int paramInt1, int paramInt2)
  {
    ImageView localImageView = new ImageView(new ContextThemeWrapper(paramContext, paramInt1), null, paramInt1);
    localImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    ((RelativeLayout)paramView.findViewById(paramInt2)).addView(localImageView);
    return localImageView;
  }

  public void setActionHintText(String paramString)
  {
    if (this.mActionHint != null)
      this.mActionHint.setText(paramString);
  }

  public void setActionHintVisible(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.mActionHint != null)
    {
      localTextView = this.mActionHint;
      if (!paramBoolean)
        break label24;
    }
    label24: for (int i = 0; ; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }

  public void setPinnedIconVisible(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.mPinnedIcon != null)
    {
      localImageView = this.mPinnedIcon;
      if (!paramBoolean)
        break label24;
    }
    label24: for (int i = 0; ; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }

  public void setUnreadBarVisible(boolean paramBoolean)
  {
    View localView;
    if (this.mUnreadBar != null)
    {
      localView = this.mUnreadBar;
      if (!paramBoolean)
        break label24;
    }
    label24: for (int i = 0; ; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.contentcards.view.ContentCardViewHolder
 * JD-Core Version:    0.6.2
 */