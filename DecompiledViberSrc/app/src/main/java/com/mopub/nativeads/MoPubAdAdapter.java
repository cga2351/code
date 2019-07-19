package com.mopub.nativeads;

import android.app.Activity;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.VisibilityTracker;
import com.mopub.common.VisibilityTracker.VisibilityTrackerListener;
import com.mopub.common.VisibleForTesting;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

public class MoPubAdAdapter extends BaseAdapter
{
  private final WeakHashMap<View, Integer> a;
  private final Adapter b;
  private final MoPubStreamAdPlacer c;
  private final VisibilityTracker d;
  private MoPubNativeAdLoadedListener e;

  public MoPubAdAdapter(Activity paramActivity, Adapter paramAdapter)
  {
    this(paramActivity, paramAdapter, MoPubNativeAdPositioning.serverPositioning());
  }

  public MoPubAdAdapter(Activity paramActivity, Adapter paramAdapter, MoPubNativeAdPositioning.MoPubClientPositioning paramMoPubClientPositioning)
  {
    this(new MoPubStreamAdPlacer(paramActivity, paramMoPubClientPositioning), paramAdapter, new VisibilityTracker(paramActivity));
  }

  public MoPubAdAdapter(Activity paramActivity, Adapter paramAdapter, MoPubNativeAdPositioning.MoPubServerPositioning paramMoPubServerPositioning)
  {
    this(new MoPubStreamAdPlacer(paramActivity, paramMoPubServerPositioning), paramAdapter, new VisibilityTracker(paramActivity));
  }

  @VisibleForTesting
  MoPubAdAdapter(MoPubStreamAdPlacer paramMoPubStreamAdPlacer, Adapter paramAdapter, VisibilityTracker paramVisibilityTracker)
  {
    this.b = paramAdapter;
    this.c = paramMoPubStreamAdPlacer;
    this.a = new WeakHashMap();
    this.d = paramVisibilityTracker;
    this.d.setVisibilityTrackerListener(new VisibilityTracker.VisibilityTrackerListener()
    {
      public void onVisibilityChanged(List<View> paramAnonymousList1, List<View> paramAnonymousList2)
      {
        MoPubAdAdapter.a(MoPubAdAdapter.this, paramAnonymousList1);
      }
    });
    this.b.registerDataSetObserver(new DataSetObserver()
    {
      public void onChanged()
      {
        MoPubAdAdapter.b(MoPubAdAdapter.this).setItemCount(MoPubAdAdapter.a(MoPubAdAdapter.this).getCount());
        MoPubAdAdapter.this.notifyDataSetChanged();
      }

      public void onInvalidated()
      {
        MoPubAdAdapter.this.notifyDataSetInvalidated();
      }
    });
    this.c.setAdLoadedListener(new MoPubNativeAdLoadedListener()
    {
      public void onAdLoaded(int paramAnonymousInt)
      {
        MoPubAdAdapter.this.a(paramAnonymousInt);
      }

      public void onAdRemoved(int paramAnonymousInt)
      {
        MoPubAdAdapter.this.b(paramAnonymousInt);
      }
    });
    this.c.setItemCount(this.b.getCount());
  }

  private void a(List<View> paramList)
  {
    Iterator localIterator = paramList.iterator();
    int i = 2147483647;
    int j = 0;
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      Integer localInteger = (Integer)this.a.get(localView);
      if (localInteger != null)
      {
        i = Math.min(localInteger.intValue(), i);
        j = Math.max(localInteger.intValue(), j);
      }
    }
    this.c.placeAdsInRange(i, j + 1);
  }

  @VisibleForTesting
  void a(int paramInt)
  {
    if (this.e != null)
      this.e.onAdLoaded(paramInt);
    notifyDataSetChanged();
  }

  public boolean areAllItemsEnabled()
  {
    return ((this.b instanceof ListAdapter)) && (((ListAdapter)this.b).areAllItemsEnabled());
  }

  @VisibleForTesting
  void b(int paramInt)
  {
    if (this.e != null)
      this.e.onAdRemoved(paramInt);
    notifyDataSetChanged();
  }

  public void clearAds()
  {
    this.c.clearAds();
  }

  public void destroy()
  {
    this.c.destroy();
    this.d.destroy();
  }

  public int getAdjustedPosition(int paramInt)
  {
    return this.c.getAdjustedPosition(paramInt);
  }

  public int getCount()
  {
    return this.c.getAdjustedCount(this.b.getCount());
  }

  public Object getItem(int paramInt)
  {
    Object localObject = this.c.getAdData(paramInt);
    if (localObject != null)
      return localObject;
    return this.b.getItem(this.c.getOriginalPosition(paramInt));
  }

  public long getItemId(int paramInt)
  {
    Object localObject = this.c.getAdData(paramInt);
    if (localObject != null)
      return -System.identityHashCode(localObject);
    return this.b.getItemId(this.c.getOriginalPosition(paramInt));
  }

  public int getItemViewType(int paramInt)
  {
    int i = this.c.getAdViewType(paramInt);
    if (i != 0)
      return -1 + (i + this.b.getViewTypeCount());
    return this.b.getItemViewType(this.c.getOriginalPosition(paramInt));
  }

  public int getOriginalPosition(int paramInt)
  {
    return this.c.getOriginalPosition(paramInt);
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = this.c.getAdView(paramInt, paramView, paramViewGroup);
    if (localView != null);
    while (true)
    {
      this.a.put(localView, Integer.valueOf(paramInt));
      this.d.addView(localView, 0, null);
      return localView;
      localView = this.b.getView(this.c.getOriginalPosition(paramInt), paramView, paramViewGroup);
    }
  }

  public int getViewTypeCount()
  {
    return this.b.getViewTypeCount() + this.c.getAdViewTypeCount();
  }

  public boolean hasStableIds()
  {
    return this.b.hasStableIds();
  }

  public void insertItem(int paramInt)
  {
    this.c.insertItem(paramInt);
  }

  public boolean isAd(int paramInt)
  {
    return this.c.isAd(paramInt);
  }

  public boolean isEmpty()
  {
    boolean bool1 = this.b.isEmpty();
    boolean bool2 = false;
    if (bool1)
    {
      int i = this.c.getAdjustedCount(0);
      bool2 = false;
      if (i == 0)
        bool2 = true;
    }
    return bool2;
  }

  public boolean isEnabled(int paramInt)
  {
    return (isAd(paramInt)) || (((this.b instanceof ListAdapter)) && (((ListAdapter)this.b).isEnabled(this.c.getOriginalPosition(paramInt))));
  }

  public void loadAds(String paramString)
  {
    this.c.loadAds(paramString);
  }

  public void loadAds(String paramString, RequestParameters paramRequestParameters)
  {
    this.c.loadAds(paramString, paramRequestParameters);
  }

  public void refreshAds(ListView paramListView, String paramString)
  {
    refreshAds(paramListView, paramString, null);
  }

  public void refreshAds(ListView paramListView, String paramString, RequestParameters paramRequestParameters)
  {
    if (!Preconditions.NoThrow.checkNotNull(paramListView, "You called MoPubAdAdapter.refreshAds with a null ListView"))
      return;
    View localView = paramListView.getChildAt(0);
    if (localView == null);
    int j;
    int k;
    for (int i = 0; ; i = localView.getTop())
    {
      j = paramListView.getFirstVisiblePosition();
      for (k = Math.max(j - 1, 0); (this.c.isAd(k)) && (k > 0); k--);
    }
    for (int m = paramListView.getLastVisiblePosition(); (this.c.isAd(m)) && (m < -1 + getCount()); m++);
    int n = this.c.getOriginalPosition(k);
    int i1 = this.c.getOriginalCount(m + 1);
    int i2 = this.c.getOriginalCount(getCount());
    this.c.removeAdsInRange(i1, i2);
    int i3 = this.c.removeAdsInRange(0, n);
    if (i3 > 0)
      paramListView.setSelectionFromTop(j - i3, i);
    loadAds(paramString, paramRequestParameters);
  }

  public final void registerAdRenderer(MoPubAdRenderer paramMoPubAdRenderer)
  {
    if (!Preconditions.NoThrow.checkNotNull(paramMoPubAdRenderer, "Tried to set a null ad renderer on the placer."))
      return;
    this.c.registerAdRenderer(paramMoPubAdRenderer);
  }

  public void removeItem(int paramInt)
  {
    this.c.removeItem(paramInt);
  }

  public final void setAdLoadedListener(MoPubNativeAdLoadedListener paramMoPubNativeAdLoadedListener)
  {
    this.e = paramMoPubNativeAdLoadedListener;
  }

  public void setOnClickListener(ListView paramListView, final AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    if (!Preconditions.NoThrow.checkNotNull(paramListView, "You called MoPubAdAdapter.setOnClickListener with a null ListView"))
      return;
    if (paramOnItemClickListener == null)
    {
      paramListView.setOnItemClickListener(null);
      return;
    }
    paramListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (!MoPubAdAdapter.b(MoPubAdAdapter.this).isAd(paramAnonymousInt))
          paramOnItemClickListener.onItemClick(paramAnonymousAdapterView, paramAnonymousView, MoPubAdAdapter.b(MoPubAdAdapter.this).getOriginalPosition(paramAnonymousInt), paramAnonymousLong);
      }
    });
  }

  public void setOnItemLongClickListener(ListView paramListView, final AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    if (!Preconditions.NoThrow.checkNotNull(paramListView, "You called MoPubAdAdapter.setOnItemLongClickListener with a null ListView"))
      return;
    if (paramOnItemLongClickListener == null)
    {
      paramListView.setOnItemLongClickListener(null);
      return;
    }
    paramListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        return (MoPubAdAdapter.this.isAd(paramAnonymousInt)) || (paramOnItemLongClickListener.onItemLongClick(paramAnonymousAdapterView, paramAnonymousView, MoPubAdAdapter.b(MoPubAdAdapter.this).getOriginalPosition(paramAnonymousInt), paramAnonymousLong));
      }
    });
  }

  public void setOnItemSelectedListener(ListView paramListView, final AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    if (!Preconditions.NoThrow.checkNotNull(paramListView, "You called MoPubAdAdapter.setOnItemSelectedListener with a null ListView"))
      return;
    if (paramOnItemSelectedListener == null)
    {
      paramListView.setOnItemSelectedListener(null);
      return;
    }
    paramListView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (!MoPubAdAdapter.this.isAd(paramAnonymousInt))
          paramOnItemSelectedListener.onItemSelected(paramAnonymousAdapterView, paramAnonymousView, MoPubAdAdapter.b(MoPubAdAdapter.this).getOriginalPosition(paramAnonymousInt), paramAnonymousLong);
      }

      public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView)
      {
        paramOnItemSelectedListener.onNothingSelected(paramAnonymousAdapterView);
      }
    });
  }

  public void setSelection(ListView paramListView, int paramInt)
  {
    if (!Preconditions.NoThrow.checkNotNull(paramListView, "You called MoPubAdAdapter.setSelection with a null ListView"))
      return;
    paramListView.setSelection(this.c.getAdjustedPosition(paramInt));
  }

  public void smoothScrollToPosition(ListView paramListView, int paramInt)
  {
    if (!Preconditions.NoThrow.checkNotNull(paramListView, "You called MoPubAdAdapter.smoothScrollToPosition with a null ListView"))
      return;
    paramListView.smoothScrollToPosition(this.c.getAdjustedPosition(paramInt));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.MoPubAdAdapter
 * JD-Core Version:    0.6.2
 */