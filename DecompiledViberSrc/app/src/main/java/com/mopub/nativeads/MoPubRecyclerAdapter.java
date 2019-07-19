package com.mopub.nativeads;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.VisibilityTracker;
import com.mopub.common.VisibilityTracker.VisibilityTrackerListener;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

public final class MoPubRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private final RecyclerView.AdapterDataObserver a;
  private RecyclerView b;
  private final MoPubStreamAdPlacer c;
  private final RecyclerView.Adapter d;
  private final VisibilityTracker e;
  private final WeakHashMap<View, Integer> f = new WeakHashMap();
  private ContentChangeStrategy g = ContentChangeStrategy.INSERT_AT_END;
  private MoPubNativeAdLoadedListener h;

  public MoPubRecyclerAdapter(Activity paramActivity, RecyclerView.Adapter paramAdapter)
  {
    this(paramActivity, paramAdapter, MoPubNativeAdPositioning.serverPositioning());
  }

  public MoPubRecyclerAdapter(Activity paramActivity, RecyclerView.Adapter paramAdapter, MoPubNativeAdPositioning.MoPubClientPositioning paramMoPubClientPositioning)
  {
    this(new MoPubStreamAdPlacer(paramActivity, paramMoPubClientPositioning), paramAdapter, new VisibilityTracker(paramActivity));
  }

  public MoPubRecyclerAdapter(Activity paramActivity, RecyclerView.Adapter paramAdapter, MoPubNativeAdPositioning.MoPubServerPositioning paramMoPubServerPositioning)
  {
    this(new MoPubStreamAdPlacer(paramActivity, paramMoPubServerPositioning), paramAdapter, new VisibilityTracker(paramActivity));
  }

  @VisibleForTesting
  MoPubRecyclerAdapter(MoPubStreamAdPlacer paramMoPubStreamAdPlacer, RecyclerView.Adapter paramAdapter, VisibilityTracker paramVisibilityTracker)
  {
    this.d = paramAdapter;
    this.e = paramVisibilityTracker;
    this.e.setVisibilityTrackerListener(new VisibilityTracker.VisibilityTrackerListener()
    {
      public void onVisibilityChanged(List<View> paramAnonymousList1, List<View> paramAnonymousList2)
      {
        MoPubRecyclerAdapter.a(MoPubRecyclerAdapter.this, paramAnonymousList1, paramAnonymousList2);
      }
    });
    a(this.d.hasStableIds());
    this.c = paramMoPubStreamAdPlacer;
    this.c.setAdLoadedListener(new MoPubNativeAdLoadedListener()
    {
      public void onAdLoaded(int paramAnonymousInt)
      {
        MoPubRecyclerAdapter.this.a(paramAnonymousInt);
      }

      public void onAdRemoved(int paramAnonymousInt)
      {
        MoPubRecyclerAdapter.this.b(paramAnonymousInt);
      }
    });
    this.c.setItemCount(this.d.getItemCount());
    this.a = new RecyclerView.AdapterDataObserver()
    {
      public void onChanged()
      {
        MoPubRecyclerAdapter.b(MoPubRecyclerAdapter.this).setItemCount(MoPubRecyclerAdapter.a(MoPubRecyclerAdapter.this).getItemCount());
        MoPubRecyclerAdapter.this.notifyDataSetChanged();
      }

      public void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int i = MoPubRecyclerAdapter.b(MoPubRecyclerAdapter.this).getAdjustedPosition(-1 + (paramAnonymousInt1 + paramAnonymousInt2));
        int j = MoPubRecyclerAdapter.b(MoPubRecyclerAdapter.this).getAdjustedPosition(paramAnonymousInt1);
        int k = 1 + (i - j);
        MoPubRecyclerAdapter.this.notifyItemRangeChanged(j, k);
      }

      public void onItemRangeInserted(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int i = MoPubRecyclerAdapter.b(MoPubRecyclerAdapter.this).getAdjustedPosition(paramAnonymousInt1);
        int j = MoPubRecyclerAdapter.a(MoPubRecyclerAdapter.this).getItemCount();
        MoPubRecyclerAdapter.b(MoPubRecyclerAdapter.this).setItemCount(j);
        if (paramAnonymousInt1 + paramAnonymousInt2 >= j);
        int m;
        for (int k = 1; ; k = 0)
        {
          if (MoPubRecyclerAdapter.ContentChangeStrategy.KEEP_ADS_FIXED != MoPubRecyclerAdapter.c(MoPubRecyclerAdapter.this))
          {
            MoPubRecyclerAdapter.ContentChangeStrategy localContentChangeStrategy1 = MoPubRecyclerAdapter.ContentChangeStrategy.INSERT_AT_END;
            MoPubRecyclerAdapter.ContentChangeStrategy localContentChangeStrategy2 = MoPubRecyclerAdapter.c(MoPubRecyclerAdapter.this);
            m = 0;
            if (localContentChangeStrategy1 != localContentChangeStrategy2)
              break;
            m = 0;
            if (k == 0)
              break;
          }
          MoPubRecyclerAdapter.this.notifyDataSetChanged();
          return;
        }
        while (m < paramAnonymousInt2)
        {
          MoPubRecyclerAdapter.b(MoPubRecyclerAdapter.this).insertItem(paramAnonymousInt1);
          m++;
        }
        MoPubRecyclerAdapter.this.notifyItemRangeInserted(i, paramAnonymousInt2);
      }

      public void onItemRangeMoved(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        MoPubRecyclerAdapter.this.notifyDataSetChanged();
      }

      public void onItemRangeRemoved(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int i = 0;
        int j = MoPubRecyclerAdapter.b(MoPubRecyclerAdapter.this).getAdjustedPosition(paramAnonymousInt1);
        int k = MoPubRecyclerAdapter.a(MoPubRecyclerAdapter.this).getItemCount();
        MoPubRecyclerAdapter.b(MoPubRecyclerAdapter.this).setItemCount(k);
        if (paramAnonymousInt1 + paramAnonymousInt2 >= k);
        for (int m = 1; (MoPubRecyclerAdapter.ContentChangeStrategy.KEEP_ADS_FIXED == MoPubRecyclerAdapter.c(MoPubRecyclerAdapter.this)) || ((MoPubRecyclerAdapter.ContentChangeStrategy.INSERT_AT_END == MoPubRecyclerAdapter.c(MoPubRecyclerAdapter.this)) && (m != 0)); m = 0)
        {
          MoPubRecyclerAdapter.this.notifyDataSetChanged();
          return;
        }
        int n = MoPubRecyclerAdapter.b(MoPubRecyclerAdapter.this).getAdjustedCount(k + paramAnonymousInt2);
        while (i < paramAnonymousInt2)
        {
          MoPubRecyclerAdapter.b(MoPubRecyclerAdapter.this).removeItem(paramAnonymousInt1);
          i++;
        }
        int i1 = n - MoPubRecyclerAdapter.b(MoPubRecyclerAdapter.this).getAdjustedCount(k);
        int i2 = j - (i1 - paramAnonymousInt2);
        MoPubRecyclerAdapter.this.notifyItemRangeRemoved(i2, i1);
      }
    };
    this.d.registerAdapterDataObserver(this.a);
  }

  private void a(List<View> paramList1, List<View> paramList2)
  {
    Iterator localIterator = paramList1.iterator();
    int i = 2147483647;
    int j = 0;
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      Integer localInteger = (Integer)this.f.get(localView);
      if (localInteger != null)
      {
        i = Math.min(localInteger.intValue(), i);
        j = Math.max(localInteger.intValue(), j);
      }
    }
    this.c.placeAdsInRange(i, j + 1);
  }

  private void a(boolean paramBoolean)
  {
    super.setHasStableIds(paramBoolean);
  }

  public static int computeScrollOffset(LinearLayoutManager paramLinearLayoutManager, RecyclerView.ViewHolder paramViewHolder)
  {
    if (paramViewHolder == null);
    View localView;
    do
    {
      return 0;
      localView = paramViewHolder.itemView;
      if (paramLinearLayoutManager.canScrollVertically())
      {
        if (paramLinearLayoutManager.getStackFromEnd())
          return localView.getBottom();
        return localView.getTop();
      }
    }
    while (!paramLinearLayoutManager.canScrollHorizontally());
    if (paramLinearLayoutManager.getStackFromEnd())
      return localView.getRight();
    return localView.getLeft();
  }

  @VisibleForTesting
  void a(int paramInt)
  {
    if (this.h != null)
      this.h.onAdLoaded(paramInt);
    notifyItemInserted(paramInt);
  }

  @VisibleForTesting
  void b(int paramInt)
  {
    if (this.h != null)
      this.h.onAdRemoved(paramInt);
    notifyItemRemoved(paramInt);
  }

  public void clearAds()
  {
    this.c.clearAds();
  }

  public void destroy()
  {
    this.d.unregisterAdapterDataObserver(this.a);
    this.c.destroy();
    this.e.destroy();
  }

  public int getAdjustedPosition(int paramInt)
  {
    return this.c.getAdjustedPosition(paramInt);
  }

  public int getItemCount()
  {
    return this.c.getAdjustedCount(this.d.getItemCount());
  }

  public long getItemId(int paramInt)
  {
    if (!this.d.hasStableIds())
      return -1L;
    Object localObject = this.c.getAdData(paramInt);
    if (localObject != null)
      return -System.identityHashCode(localObject);
    return this.d.getItemId(this.c.getOriginalPosition(paramInt));
  }

  public int getItemViewType(int paramInt)
  {
    int i = this.c.getAdViewType(paramInt);
    if (i != 0)
      return i - 56;
    return this.d.getItemViewType(this.c.getOriginalPosition(paramInt));
  }

  public int getOriginalPosition(int paramInt)
  {
    return this.c.getOriginalPosition(paramInt);
  }

  public boolean isAd(int paramInt)
  {
    return this.c.isAd(paramInt);
  }

  public void loadAds(String paramString)
  {
    this.c.loadAds(paramString);
  }

  public void loadAds(String paramString, RequestParameters paramRequestParameters)
  {
    this.c.loadAds(paramString, paramRequestParameters);
  }

  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.b = paramRecyclerView;
  }

  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject = this.c.getAdData(paramInt);
    if (localObject != null)
    {
      this.c.bindAdView((NativeAd)localObject, paramViewHolder.itemView);
      return;
    }
    this.f.put(paramViewHolder.itemView, Integer.valueOf(paramInt));
    this.e.addView(paramViewHolder.itemView, 0, null);
    this.d.onBindViewHolder(paramViewHolder, this.c.getOriginalPosition(paramInt));
  }

  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if ((paramInt >= -56) && (paramInt <= -56 + this.c.getAdViewTypeCount()))
    {
      MoPubAdRenderer localMoPubAdRenderer = this.c.getAdRendererForViewType(paramInt + 56);
      if (localMoPubAdRenderer == null)
      {
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "No view binder was registered for ads in MoPubRecyclerAdapter." });
        return null;
      }
      return new MoPubRecyclerViewHolder(localMoPubAdRenderer.createAdView((Activity)paramViewGroup.getContext(), paramViewGroup));
    }
    return this.d.onCreateViewHolder(paramViewGroup, paramInt);
  }

  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    this.b = null;
  }

  public boolean onFailedToRecycleView(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder instanceof MoPubRecyclerViewHolder))
      return super.onFailedToRecycleView(paramViewHolder);
    return this.d.onFailedToRecycleView(paramViewHolder);
  }

  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder instanceof MoPubRecyclerViewHolder))
    {
      super.onViewAttachedToWindow(paramViewHolder);
      return;
    }
    this.d.onViewAttachedToWindow(paramViewHolder);
  }

  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder instanceof MoPubRecyclerViewHolder))
    {
      super.onViewDetachedFromWindow(paramViewHolder);
      return;
    }
    this.d.onViewDetachedFromWindow(paramViewHolder);
  }

  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder instanceof MoPubRecyclerViewHolder))
    {
      super.onViewRecycled(paramViewHolder);
      return;
    }
    this.d.onViewRecycled(paramViewHolder);
  }

  public void refreshAds(String paramString)
  {
    refreshAds(paramString, null);
  }

  public void refreshAds(String paramString, RequestParameters paramRequestParameters)
  {
    if (this.b == null)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "This adapter is not attached to a RecyclerView and cannot be refreshed." });
      return;
    }
    RecyclerView.LayoutManager localLayoutManager = this.b.getLayoutManager();
    if (localLayoutManager == null)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Can't refresh ads when there is no layout manager on a RecyclerView." });
      return;
    }
    if ((localLayoutManager instanceof LinearLayoutManager))
    {
      LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)localLayoutManager;
      int i = localLinearLayoutManager.findFirstVisibleItemPosition();
      int j = computeScrollOffset(localLinearLayoutManager, this.b.findViewHolderForLayoutPosition(i));
      for (int k = Math.max(0, i - 1); (this.c.isAd(k)) && (k > 0); k--);
      int m = getItemCount();
      for (int n = localLinearLayoutManager.findLastVisibleItemPosition(); (this.c.isAd(n)) && (n < m - 1); n++);
      int i1 = this.c.getOriginalPosition(k);
      int i2 = this.c.getOriginalPosition(n);
      int i3 = this.d.getItemCount();
      this.c.removeAdsInRange(i2, i3);
      int i4 = this.c.removeAdsInRange(0, i1);
      if (i4 > 0)
        localLinearLayoutManager.scrollToPositionWithOffset(i - i4, j);
      loadAds(paramString, paramRequestParameters);
      return;
    }
    MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "This LayoutManager can't be refreshed." });
  }

  public void registerAdRenderer(MoPubAdRenderer paramMoPubAdRenderer)
  {
    if (!Preconditions.NoThrow.checkNotNull(paramMoPubAdRenderer, "Cannot register a null adRenderer"))
      return;
    this.c.registerAdRenderer(paramMoPubAdRenderer);
  }

  public void setAdLoadedListener(MoPubNativeAdLoadedListener paramMoPubNativeAdLoadedListener)
  {
    this.h = paramMoPubNativeAdLoadedListener;
  }

  public void setContentChangeStrategy(ContentChangeStrategy paramContentChangeStrategy)
  {
    if (!Preconditions.NoThrow.checkNotNull(paramContentChangeStrategy))
      return;
    this.g = paramContentChangeStrategy;
  }

  public void setHasStableIds(boolean paramBoolean)
  {
    a(paramBoolean);
    this.d.unregisterAdapterDataObserver(this.a);
    this.d.setHasStableIds(paramBoolean);
    this.d.registerAdapterDataObserver(this.a);
  }

  public static enum ContentChangeStrategy
  {
    static
    {
      KEEP_ADS_FIXED = new ContentChangeStrategy("KEEP_ADS_FIXED", 2);
      ContentChangeStrategy[] arrayOfContentChangeStrategy = new ContentChangeStrategy[3];
      arrayOfContentChangeStrategy[0] = INSERT_AT_END;
      arrayOfContentChangeStrategy[1] = MOVE_ALL_ADS_WITH_CONTENT;
      arrayOfContentChangeStrategy[2] = KEEP_ADS_FIXED;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.MoPubRecyclerAdapter
 * JD-Core Version:    0.6.2
 */