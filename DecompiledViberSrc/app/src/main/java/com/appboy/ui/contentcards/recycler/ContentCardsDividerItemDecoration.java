package com.appboy.ui.contentcards.recycler;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.appboy.ui.R.dimen;
import com.appboy.ui.contentcards.AppboyCardAdapter;

public class ContentCardsDividerItemDecoration extends RecyclerView.ItemDecoration
{
  private final Context mContext;
  private final int mItemDividerHeight;
  private final int mItemDividerMaxWidth;

  public ContentCardsDividerItemDecoration(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mItemDividerHeight = getItemDividerHeight();
    this.mItemDividerMaxWidth = getContentCardsItemMaxWidth();
  }

  private int getContentCardsItemMaxWidth()
  {
    return this.mContext.getResources().getDimensionPixelSize(R.dimen.com_appboy_content_cards_max_width);
  }

  private int getItemDividerHeight()
  {
    return this.mContext.getResources().getDimensionPixelSize(R.dimen.com_appboy_content_cards_divider_height);
  }

  private int getSidePaddingValue(int paramInt)
  {
    return Math.max((paramInt - this.mItemDividerMaxWidth) / 2, 0);
  }

  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    int i = paramRecyclerView.getChildAdapterPosition(paramView);
    AppboyCardAdapter localAppboyCardAdapter;
    if ((paramRecyclerView.getAdapter() instanceof AppboyCardAdapter))
    {
      localAppboyCardAdapter = (AppboyCardAdapter)paramRecyclerView.getAdapter();
      if (i <= 0);
    }
    for (boolean bool = localAppboyCardAdapter.isControlCardAtPosition(i); ; bool = false)
    {
      int j;
      int k;
      if (bool)
      {
        j = 0;
        paramRect.bottom = j;
        if (i == 0)
        {
          k = 0;
          if (!bool)
            break label104;
        }
      }
      while (true)
      {
        paramRect.top = k;
        paramRect.left = getSidePaddingValue(paramRecyclerView.getWidth());
        return;
        j = this.mItemDividerHeight;
        break;
        label104: k = this.mItemDividerHeight;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.contentcards.recycler.ContentCardsDividerItemDecoration
 * JD-Core Version:    0.6.2
 */