package com.appboy.ui.contentcards.handlers;

import android.content.Context;
import android.view.ViewGroup;
import com.appboy.b.d;
import com.appboy.e.a.c;
import com.appboy.ui.contentcards.view.BannerImageContentCardView;
import com.appboy.ui.contentcards.view.BaseContentCardView;
import com.appboy.ui.contentcards.view.CaptionedImageContentCardView;
import com.appboy.ui.contentcards.view.ContentCardViewHolder;
import com.appboy.ui.contentcards.view.DefaultContentCardView;
import com.appboy.ui.contentcards.view.ShortNewsContentCardView;
import com.appboy.ui.contentcards.view.TextAnnouncementContentCardView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultContentCardsViewBindingHandler
  implements IContentCardsViewBindingHandler
{
  private final Map<d, BaseContentCardView> mContentCardViewCache = new HashMap();

  BaseContentCardView getContentCardsViewFromCache(Context paramContext, d paramd)
  {
    Object localObject;
    if (!this.mContentCardViewCache.containsKey(paramd))
      switch (1.$SwitchMap$com$appboy$enums$CardType[paramd.ordinal()])
      {
      default:
        localObject = new DefaultContentCardView(paramContext);
      case 1:
      case 2:
      case 3:
      case 4:
      }
    while (true)
    {
      this.mContentCardViewCache.put(paramd, localObject);
      return (BaseContentCardView)this.mContentCardViewCache.get(paramd);
      localObject = new BannerImageContentCardView(paramContext);
      continue;
      localObject = new CaptionedImageContentCardView(paramContext);
      continue;
      localObject = new ShortNewsContentCardView(paramContext);
      continue;
      localObject = new TextAnnouncementContentCardView(paramContext);
    }
  }

  public int getItemViewType(Context paramContext, List<c> paramList, int paramInt)
  {
    return ((c)paramList.get(paramInt)).d().a();
  }

  public void onBindViewHolder(Context paramContext, List<c> paramList, ContentCardViewHolder paramContentCardViewHolder, int paramInt)
  {
    c localc = (c)paramList.get(paramInt);
    getContentCardsViewFromCache(paramContext, localc.d()).bindViewHolder(paramContentCardViewHolder, localc);
  }

  public ContentCardViewHolder onCreateViewHolder(Context paramContext, List<c> paramList, ViewGroup paramViewGroup, int paramInt)
  {
    return getContentCardsViewFromCache(paramContext, d.a(paramInt)).createViewHolder(paramViewGroup);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.contentcards.handlers.DefaultContentCardsViewBindingHandler
 * JD-Core Version:    0.6.2
 */