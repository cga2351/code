package com.appboy.ui.contentcards.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.appboy.a.b;
import com.appboy.e.a.c;
import com.appboy.ui.actions.IAction;
import com.appboy.ui.actions.UriAction;
import com.appboy.ui.contentcards.AppboyContentCardsManager;
import com.appboy.ui.contentcards.listeners.IContentCardsActionListener;
import com.appboy.ui.widget.BaseCardView;

public abstract class BaseContentCardView<T extends c> extends BaseCardView<T>
{
  public BaseContentCardView(Context paramContext)
  {
    super(paramContext);
  }

  public void bindViewHolder(ContentCardViewHolder paramContentCardViewHolder, final T paramT)
  {
    boolean bool1 = true;
    paramContentCardViewHolder.setPinnedIconVisible(paramT.o());
    boolean bool2;
    if ((this.mAppboyConfigurationProvider.v()) && (!paramT.k()))
    {
      bool2 = bool1;
      paramContentCardViewHolder.setUnreadBarVisible(bool2);
      final UriAction localUriAction = getUriActionForCard(paramT);
      paramContentCardViewHolder.itemView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          BaseContentCardView.this.handleCardClick(BaseContentCardView.this.mContext, paramT, localUriAction, BaseContentCardView.this.getClassLogTag());
        }
      });
      if (localUriAction == null)
        break label77;
    }
    while (true)
    {
      paramContentCardViewHolder.setActionHintVisible(bool1);
      return;
      bool2 = false;
      break;
      label77: bool1 = false;
    }
  }

  public abstract ContentCardViewHolder createViewHolder(ViewGroup paramViewGroup);

  protected boolean isClickHandled(Context paramContext, c paramc, IAction paramIAction)
  {
    return AppboyContentCardsManager.getInstance().getContentCardsActionListener().onContentCardClicked(paramContext, paramc, paramIAction);
  }

  @TargetApi(21)
  protected void safeSetClipToOutline(ImageView paramImageView)
  {
    if (paramImageView != null)
      paramImageView.setClipToOutline(true);
  }

  public void setOptionalCardImage(ImageView paramImageView, float paramFloat1, String paramString, float paramFloat2)
  {
    if (paramFloat1 != 0.0F);
    while (true)
    {
      if (paramImageView != null)
        setImageViewToUrl(paramImageView, paramString, paramFloat1);
      return;
      paramFloat1 = paramFloat2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.contentcards.view.BaseContentCardView
 * JD-Core Version:    0.6.2
 */