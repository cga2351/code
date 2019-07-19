package com.appboy.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.appboy.a;
import com.appboy.ui.adapters.AppboyListAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

public class AppboyFeedFragment extends ListFragment
  implements SwipeRefreshLayout.OnRefreshListener
{
  private static final String TAG = com.appboy.f.c.a(AppboyFeedFragment.class);
  private AppboyListAdapter mAdapter;
  private EnumSet<com.appboy.b.b> mCategories;
  int mCurrentCardIndexAtBottomOfScreen = 0;
  private LinearLayout mEmptyFeedLayout;
  private RelativeLayout mFeedRootLayout;
  private SwipeRefreshLayout mFeedSwipeLayout;
  private com.appboy.c.c<com.appboy.c.b> mFeedUpdatedSubscriber;
  private GestureDetectorCompat mGestureDetector;
  private ProgressBar mLoadingSpinner;
  private final Handler mMainThreadLooper = new Handler(Looper.getMainLooper());
  private LinearLayout mNetworkErrorLayout;
  int mPreviousVisibleHeadCardIndex = 0;
  private final Runnable mShowNetworkError = new Runnable()
  {
    public void run()
    {
      if (AppboyFeedFragment.this.mLoadingSpinner != null)
        AppboyFeedFragment.this.mLoadingSpinner.setVisibility(8);
      if (AppboyFeedFragment.this.mNetworkErrorLayout != null)
        AppboyFeedFragment.this.mNetworkErrorLayout.setVisibility(0);
    }
  };
  boolean mSkipCardImpressionsReset = false;
  private boolean mSortEnabled = false;
  private View mTransparentFullBoundsContainerView;

  private void setOnScreenCardsToRead()
  {
    this.mAdapter.batchSetCardsToRead(this.mPreviousVisibleHeadCardIndex, this.mCurrentCardIndexAtBottomOfScreen);
  }

  void loadFragmentStateFromSavedInstanceState(Bundle paramBundle)
  {
    if (paramBundle == null);
    while (true)
    {
      return;
      if (this.mCategories == null)
        this.mCategories = com.appboy.b.b.a();
      this.mPreviousVisibleHeadCardIndex = paramBundle.getInt("PREVIOUS_VISIBLE_HEAD_CARD_INDEX", 0);
      this.mCurrentCardIndexAtBottomOfScreen = paramBundle.getInt("CURRENT_CARD_INDEX_AT_BOTTOM_OF_SCREEN", 0);
      this.mSkipCardImpressionsReset = paramBundle.getBoolean("SKIP_CARD_IMPRESSIONS_RESET", false);
      ArrayList localArrayList = paramBundle.getStringArrayList("CARD_CATEGORY");
      if (localArrayList != null)
      {
        this.mCategories.clear();
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          this.mCategories.add(com.appboy.b.b.valueOf(str));
        }
      }
    }
  }

  @SuppressLint({"InflateParams"})
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    loadFragmentStateFromSavedInstanceState(paramBundle);
    if (this.mSkipCardImpressionsReset)
      this.mSkipCardImpressionsReset = false;
    while (true)
    {
      LayoutInflater localLayoutInflater = LayoutInflater.from(getActivity());
      final ListView localListView = getListView();
      localListView.addHeaderView(localLayoutInflater.inflate(R.layout.com_appboy_feed_header, null));
      localListView.addFooterView(localLayoutInflater.inflate(R.layout.com_appboy_feed_footer, null));
      this.mFeedRootLayout.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return AppboyFeedFragment.this.mGestureDetector.onTouchEvent(paramAnonymousMotionEvent);
        }
      });
      localListView.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          SwipeRefreshLayout localSwipeRefreshLayout = AppboyFeedFragment.this.mFeedSwipeLayout;
          if (paramAnonymousInt1 == 0);
          for (boolean bool = true; ; bool = false)
          {
            localSwipeRefreshLayout.setEnabled(bool);
            if (paramAnonymousInt2 != 0)
              break;
            return;
          }
          int i = paramAnonymousInt1 - 1;
          if (i > AppboyFeedFragment.this.mPreviousVisibleHeadCardIndex)
            AppboyFeedFragment.this.mAdapter.batchSetCardsToRead(AppboyFeedFragment.this.mPreviousVisibleHeadCardIndex, i);
          AppboyFeedFragment.this.mPreviousVisibleHeadCardIndex = i;
          AppboyFeedFragment.this.mCurrentCardIndexAtBottomOfScreen = (paramAnonymousInt1 + paramAnonymousInt2);
        }

        public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
        }
      });
      this.mTransparentFullBoundsContainerView.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return paramAnonymousView.getVisibility() == 0;
        }
      });
      a.a(getContext()).a(this.mFeedUpdatedSubscriber, com.appboy.c.b.class);
      this.mFeedUpdatedSubscriber = new com.appboy.c.c()
      {
        public void trigger(final com.appboy.c.b paramAnonymousb)
        {
          FragmentActivity localFragmentActivity = AppboyFeedFragment.this.getActivity();
          if (localFragmentActivity == null)
            return;
          localFragmentActivity.runOnUiThread(new Runnable()
          {
            public void run()
            {
              com.appboy.f.c.a(AppboyFeedFragment.TAG, "Updating feed views in response to FeedUpdatedEvent: " + paramAnonymousb);
              AppboyFeedFragment.this.mMainThreadLooper.removeCallbacks(AppboyFeedFragment.this.mShowNetworkError);
              AppboyFeedFragment.this.mNetworkErrorLayout.setVisibility(8);
              if (paramAnonymousb.b(AppboyFeedFragment.this.mCategories) == 0)
              {
                AppboyFeedFragment.5.this.val$listView.setVisibility(8);
                AppboyFeedFragment.this.mAdapter.clear();
              }
              while ((paramAnonymousb.a()) && (1000L * (60L + paramAnonymousb.b()) < System.currentTimeMillis()))
              {
                com.appboy.f.c.c(AppboyFeedFragment.TAG, "Feed received was older than the max time to live of 60 seconds, displaying it for now, but requesting an updated view from the server.");
                a.a(AppboyFeedFragment.this.getContext()).e();
                if (paramAnonymousb.b(AppboyFeedFragment.this.mCategories) != 0)
                  break;
                com.appboy.f.c.b(AppboyFeedFragment.TAG, "Old feed was empty, putting up a network spinner and registering the network error message with a delay of 5000ms.");
                AppboyFeedFragment.this.mEmptyFeedLayout.setVisibility(8);
                AppboyFeedFragment.this.mLoadingSpinner.setVisibility(0);
                AppboyFeedFragment.this.mTransparentFullBoundsContainerView.setVisibility(0);
                AppboyFeedFragment.this.mMainThreadLooper.postDelayed(AppboyFeedFragment.this.mShowNetworkError, 5000L);
                return;
                AppboyFeedFragment.this.mEmptyFeedLayout.setVisibility(8);
                AppboyFeedFragment.this.mLoadingSpinner.setVisibility(8);
                AppboyFeedFragment.this.mTransparentFullBoundsContainerView.setVisibility(8);
              }
              if (paramAnonymousb.b(AppboyFeedFragment.this.mCategories) == 0)
              {
                AppboyFeedFragment.this.mLoadingSpinner.setVisibility(8);
                AppboyFeedFragment.this.mEmptyFeedLayout.setVisibility(0);
                AppboyFeedFragment.this.mTransparentFullBoundsContainerView.setVisibility(0);
                AppboyFeedFragment.this.mFeedSwipeLayout.setRefreshing(false);
                return;
              }
              if ((AppboyFeedFragment.this.mSortEnabled) && (paramAnonymousb.b(AppboyFeedFragment.this.mCategories) != paramAnonymousb.c(AppboyFeedFragment.this.mCategories)))
                AppboyFeedFragment.this.mAdapter.replaceFeed(AppboyFeedFragment.this.sortFeedCards(paramAnonymousb.a(AppboyFeedFragment.this.mCategories)));
              while (true)
              {
                AppboyFeedFragment.5.this.val$listView.setVisibility(0);
                break;
                AppboyFeedFragment.this.mAdapter.replaceFeed(paramAnonymousb.a(AppboyFeedFragment.this.mCategories));
              }
            }
          });
        }
      };
      a.a(getContext()).c(this.mFeedUpdatedSubscriber);
      localListView.setAdapter(this.mAdapter);
      a.a(getContext()).d();
      return;
      this.mAdapter.resetCardImpressionTracker();
      com.appboy.f.c.b(TAG, "Resetting card impressions.");
    }
  }

  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    if (this.mAdapter == null)
    {
      this.mAdapter = new AppboyListAdapter(paramContext, R.id.tag, new ArrayList());
      this.mCategories = com.appboy.b.b.a();
    }
    this.mGestureDetector = new GestureDetectorCompat(paramContext, new FeedGestureListener());
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.com_appboy_feed, paramViewGroup, false);
    this.mNetworkErrorLayout = ((LinearLayout)localView.findViewById(R.id.com_appboy_feed_network_error));
    this.mLoadingSpinner = ((ProgressBar)localView.findViewById(R.id.com_appboy_feed_loading_spinner));
    this.mEmptyFeedLayout = ((LinearLayout)localView.findViewById(R.id.com_appboy_feed_empty_feed));
    this.mFeedRootLayout = ((RelativeLayout)localView.findViewById(R.id.com_appboy_feed_root));
    this.mFeedSwipeLayout = ((SwipeRefreshLayout)localView.findViewById(R.id.appboy_feed_swipe_container));
    this.mFeedSwipeLayout.setOnRefreshListener(this);
    this.mFeedSwipeLayout.setEnabled(false);
    SwipeRefreshLayout localSwipeRefreshLayout = this.mFeedSwipeLayout;
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = R.color.com_appboy_newsfeed_swipe_refresh_color_1;
    arrayOfInt[1] = R.color.com_appboy_newsfeed_swipe_refresh_color_2;
    arrayOfInt[2] = R.color.com_appboy_newsfeed_swipe_refresh_color_3;
    arrayOfInt[3] = R.color.com_appboy_newsfeed_swipe_refresh_color_4;
    localSwipeRefreshLayout.setColorSchemeResources(arrayOfInt);
    this.mTransparentFullBoundsContainerView = localView.findViewById(R.id.com_appboy_feed_transparent_full_bounds_container_view);
    return localView;
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    a.a(getContext()).a(this.mFeedUpdatedSubscriber, com.appboy.c.b.class);
    setOnScreenCardsToRead();
  }

  public void onDetach()
  {
    super.onDetach();
    setListAdapter(null);
  }

  public void onPause()
  {
    super.onPause();
    setOnScreenCardsToRead();
  }

  public void onRefresh()
  {
    a.a(getContext()).e();
    this.mMainThreadLooper.postDelayed(new Runnable()
    {
      public void run()
      {
        AppboyFeedFragment.this.mFeedSwipeLayout.setRefreshing(false);
      }
    }
    , 2500L);
  }

  public void onResume()
  {
    super.onResume();
    a.a(getContext()).b();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putInt("PREVIOUS_VISIBLE_HEAD_CARD_INDEX", this.mPreviousVisibleHeadCardIndex);
    paramBundle.putInt("CURRENT_CARD_INDEX_AT_BOTTOM_OF_SCREEN", this.mCurrentCardIndexAtBottomOfScreen);
    paramBundle.putBoolean("SKIP_CARD_IMPRESSIONS_RESET", this.mSkipCardImpressionsReset);
    if (this.mCategories == null)
      this.mCategories = com.appboy.b.b.a();
    ArrayList localArrayList = new ArrayList(this.mCategories.size());
    Iterator localIterator = this.mCategories.iterator();
    while (localIterator.hasNext())
      localArrayList.add(((com.appboy.b.b)localIterator.next()).name());
    paramBundle.putStringArrayList("CARD_CATEGORY", localArrayList);
    super.onSaveInstanceState(paramBundle);
    if (isVisible())
      this.mSkipCardImpressionsReset = true;
  }

  public List<com.appboy.e.a.c> sortFeedCards(List<com.appboy.e.a.c> paramList)
  {
    Collections.sort(paramList, new Comparator()
    {
      public int compare(com.appboy.e.a.c paramAnonymousc1, com.appboy.e.a.c paramAnonymousc2)
      {
        if (paramAnonymousc1.k() == paramAnonymousc2.k())
          return 0;
        if (paramAnonymousc1.k())
          return 1;
        return -1;
      }
    });
    return paramList;
  }

  public class FeedGestureListener extends GestureDetector.SimpleOnGestureListener
  {
    public FeedGestureListener()
    {
    }

    public boolean onDown(MotionEvent paramMotionEvent)
    {
      return true;
    }

    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      long l = 2L * (paramMotionEvent2.getEventTime() - paramMotionEvent1.getEventTime());
      int i = (int)(paramFloat2 * (float)l / 1000.0F);
      AppboyFeedFragment.this.getListView().smoothScrollBy(-i, (int)(l * 2L));
      return true;
    }

    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      AppboyFeedFragment.this.getListView().smoothScrollBy((int)paramFloat2, 0);
      return true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.AppboyFeedFragment
 * JD-Core Version:    0.6.2
 */