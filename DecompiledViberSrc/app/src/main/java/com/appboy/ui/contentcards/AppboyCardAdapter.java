package com.appboy.ui.contentcards;

import android.content.Context;
import android.os.Handler;
import android.support.v7.d.c.a;
import android.support.v7.d.c.b;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.ViewGroup;
import com.appboy.ui.contentcards.handlers.IContentCardsViewBindingHandler;
import com.appboy.ui.contentcards.listeners.IContentCardsActionListener;
import com.appboy.ui.contentcards.recycler.ItemTouchHelperAdapter;
import com.appboy.ui.contentcards.view.ContentCardViewHolder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AppboyCardAdapter extends RecyclerView.Adapter<ContentCardViewHolder>
  implements ItemTouchHelperAdapter
{
  private static final String TAG = com.appboy.f.c.a(AppboyCardAdapter.class);
  private List<com.appboy.e.a.c> mCardData;
  private final IContentCardsViewBindingHandler mContentCardsViewBindingHandler;
  private final Context mContext;
  private final Handler mHandler;
  private Set<String> mImpressedCardIds = new HashSet();
  private final LinearLayoutManager mLayoutManager;

  public AppboyCardAdapter(Context paramContext, LinearLayoutManager paramLinearLayoutManager, List<com.appboy.e.a.c> paramList, IContentCardsViewBindingHandler paramIContentCardsViewBindingHandler)
  {
    this.mContext = paramContext;
    this.mCardData = paramList;
    this.mHandler = new Handler();
    this.mLayoutManager = paramLinearLayoutManager;
    this.mContentCardsViewBindingHandler = paramIContentCardsViewBindingHandler;
    setHasStableIds(true);
  }

  public List<String> getImpressedCardIds()
  {
    return new ArrayList(this.mImpressedCardIds);
  }

  public int getItemCount()
  {
    return this.mCardData.size();
  }

  public long getItemId(int paramInt)
  {
    return ((com.appboy.e.a.c)this.mCardData.get(paramInt)).m().hashCode();
  }

  public int getItemViewType(int paramInt)
  {
    return this.mContentCardsViewBindingHandler.getItemViewType(this.mContext, this.mCardData, paramInt);
  }

  boolean isAdapterPositionOnScreen(int paramInt)
  {
    int i = Math.min(this.mLayoutManager.findFirstVisibleItemPosition(), this.mLayoutManager.findFirstCompletelyVisibleItemPosition());
    int j = Math.max(this.mLayoutManager.findLastVisibleItemPosition(), this.mLayoutManager.findLastCompletelyVisibleItemPosition());
    return (i <= paramInt) && (j >= paramInt);
  }

  public boolean isControlCardAtPosition(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mCardData.size()))
      return false;
    return ((com.appboy.e.a.c)this.mCardData.get(paramInt)).u();
  }

  public boolean isItemDismissable(int paramInt)
  {
    if (this.mCardData.isEmpty())
      return false;
    return ((com.appboy.e.a.c)this.mCardData.get(paramInt)).r();
  }

  void logImpression(com.appboy.e.a.c paramc)
  {
    if (!this.mImpressedCardIds.contains(paramc.m()))
    {
      paramc.i();
      this.mImpressedCardIds.add(paramc.m());
      com.appboy.f.c.a(TAG, "Logged impression for card " + paramc.m());
    }
    while (true)
    {
      if (!paramc.l())
        paramc.c(true);
      return;
      com.appboy.f.c.a(TAG, "Already counted impression for card " + paramc.m());
    }
  }

  public void markOnScreenCardsAsRead()
  {
    if (this.mCardData.isEmpty())
    {
      com.appboy.f.c.b(TAG, "Card list is empty. Not marking on-screen cards as read.");
      return;
    }
    final int i = this.mLayoutManager.findFirstVisibleItemPosition();
    final int j = this.mLayoutManager.findLastVisibleItemPosition();
    if ((i < 0) || (j < 0))
    {
      com.appboy.f.c.b(TAG, "Not marking all on-screen cards as read. Either the first or last index is negative. First visible: " + i + " . Last visible: " + j);
      return;
    }
    for (int k = i; k <= j; k++)
      ((com.appboy.e.a.c)this.mCardData.get(k)).a(true);
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        int i = 1 + (j - i);
        AppboyCardAdapter.this.notifyItemRangeChanged(i, i);
      }
    });
  }

  public void onBindViewHolder(ContentCardViewHolder paramContentCardViewHolder, int paramInt)
  {
    this.mContentCardsViewBindingHandler.onBindViewHolder(this.mContext, this.mCardData, paramContentCardViewHolder, paramInt);
  }

  public ContentCardViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return this.mContentCardsViewBindingHandler.onCreateViewHolder(this.mContext, this.mCardData, paramViewGroup, paramInt);
  }

  public void onItemDismiss(int paramInt)
  {
    com.appboy.e.a.c localc = (com.appboy.e.a.c)this.mCardData.remove(paramInt);
    localc.b(true);
    notifyItemRemoved(paramInt);
    AppboyContentCardsManager.getInstance().getContentCardsActionListener().onContentCardDismissed(this.mContext, localc);
  }

  public void onViewAttachedToWindow(ContentCardViewHolder paramContentCardViewHolder)
  {
    super.onViewAttachedToWindow(paramContentCardViewHolder);
    if (this.mCardData.isEmpty())
      return;
    int i = paramContentCardViewHolder.getAdapterPosition();
    if ((i == -1) || (!isAdapterPositionOnScreen(i)))
    {
      com.appboy.f.c.a(TAG, "The card at position " + i + " isn't on screen or does not have a valid adapter position. Not logging impression.");
      return;
    }
    logImpression((com.appboy.e.a.c)this.mCardData.get(i));
  }

  public void onViewDetachedFromWindow(ContentCardViewHolder paramContentCardViewHolder)
  {
    super.onViewDetachedFromWindow(paramContentCardViewHolder);
    if (this.mCardData.isEmpty())
      return;
    final int i = paramContentCardViewHolder.getAdapterPosition();
    if ((i == -1) || (!isAdapterPositionOnScreen(i)))
    {
      com.appboy.f.c.a(TAG, "The card at position " + i + " isn't on screen or does not have a valid adapter position. Not marking as read.");
      return;
    }
    ((com.appboy.e.a.c)this.mCardData.get(i)).a(true);
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        AppboyCardAdapter.this.notifyItemChanged(i);
      }
    });
  }

  public void replaceCards(List<com.appboy.e.a.c> paramList)
  {
    try
    {
      c.b localb = android.support.v7.d.c.a(new CardListDiffCallback(this.mCardData, paramList));
      this.mCardData.clear();
      this.mCardData.addAll(paramList);
      localb.a(this);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setImpressedCardIds(List<String> paramList)
  {
    this.mImpressedCardIds = new HashSet(paramList);
  }

  private class CardListDiffCallback extends c.a
  {
    private final List<com.appboy.e.a.c> mNewCards;
    private final List<com.appboy.e.a.c> mOldCards;

    CardListDiffCallback(List<com.appboy.e.a.c> arg2)
    {
      Object localObject1;
      this.mOldCards = localObject1;
      Object localObject2;
      this.mNewCards = localObject2;
    }

    private boolean doItemsShareIds(int paramInt1, int paramInt2)
    {
      return ((com.appboy.e.a.c)this.mOldCards.get(paramInt1)).m().equals(((com.appboy.e.a.c)this.mNewCards.get(paramInt2)).m());
    }

    public boolean areContentsTheSame(int paramInt1, int paramInt2)
    {
      return doItemsShareIds(paramInt1, paramInt2);
    }

    public boolean areItemsTheSame(int paramInt1, int paramInt2)
    {
      return doItemsShareIds(paramInt1, paramInt2);
    }

    public int getNewListSize()
    {
      return this.mNewCards.size();
    }

    public int getOldListSize()
    {
      return this.mOldCards.size();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.contentcards.AppboyCardAdapter
 * JD-Core Version:    0.6.2
 */