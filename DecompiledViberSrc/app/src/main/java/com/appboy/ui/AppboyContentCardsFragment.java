package com.appboy.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.SimpleItemAnimator;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.appboy.ui.contentcards.AppboyCardAdapter;
import com.appboy.ui.contentcards.AppboyEmptyContentCardsAdapter;
import com.appboy.ui.contentcards.handlers.DefaultContentCardsUpdateHandler;
import com.appboy.ui.contentcards.handlers.DefaultContentCardsViewBindingHandler;
import com.appboy.ui.contentcards.handlers.IContentCardsUpdateHandler;
import com.appboy.ui.contentcards.handlers.IContentCardsViewBindingHandler;
import com.appboy.ui.contentcards.recycler.ContentCardsDividerItemDecoration;
import com.appboy.ui.contentcards.recycler.SimpleItemTouchHelperCallback;
import java.util.ArrayList;
import java.util.List;

public class AppboyContentCardsFragment extends Fragment
  implements SwipeRefreshLayout.OnRefreshListener
{
  private static final String TAG = com.appboy.f.c.a(AppboyContentCardsFragment.class);
  private AppboyCardAdapter mCardAdapter;
  private SwipeRefreshLayout mContentCardsSwipeLayout;
  private com.appboy.c.c<com.appboy.c.a> mContentCardsUpdatedSubscriber;
  private IContentCardsUpdateHandler mCustomContentCardUpdateHandler;
  private IContentCardsViewBindingHandler mCustomContentCardsViewBindingHandler;
  private IContentCardsUpdateHandler mDefaultContentCardUpdateHandler = new DefaultContentCardsUpdateHandler();
  private IContentCardsViewBindingHandler mDefaultContentCardsViewBindingHandler = new DefaultContentCardsViewBindingHandler();
  private AppboyEmptyContentCardsAdapter mEmptyContentCardsAdapter;
  private final Handler mMainThreadLooper = new Handler(Looper.getMainLooper());
  private RecyclerView mRecyclerView;
  private Runnable mShowNetworkUnavailableRunnable;

  private void swapRecyclerViewAdapter(RecyclerView.Adapter paramAdapter)
  {
    if ((this.mRecyclerView != null) && (this.mRecyclerView.getAdapter() != paramAdapter))
      this.mRecyclerView.setAdapter(paramAdapter);
  }

  public IContentCardsUpdateHandler getContentCardUpdateHandler()
  {
    if (this.mCustomContentCardUpdateHandler != null)
      return this.mCustomContentCardUpdateHandler;
    return this.mDefaultContentCardUpdateHandler;
  }

  public IContentCardsViewBindingHandler getContentCardsViewBindingHandler()
  {
    if (this.mCustomContentCardsViewBindingHandler != null)
      return this.mCustomContentCardsViewBindingHandler;
    return this.mDefaultContentCardsViewBindingHandler;
  }

  public void initializeRecyclerView()
  {
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getActivity());
    this.mCardAdapter = new AppboyCardAdapter(getContext(), localLinearLayoutManager, new ArrayList(), getContentCardsViewBindingHandler());
    this.mRecyclerView.setAdapter(this.mCardAdapter);
    this.mRecyclerView.setLayoutManager(localLinearLayoutManager);
    new ItemTouchHelper(new SimpleItemTouchHelperCallback(this.mCardAdapter)).attachToRecyclerView(this.mRecyclerView);
    RecyclerView.ItemAnimator localItemAnimator = this.mRecyclerView.getItemAnimator();
    if ((localItemAnimator instanceof SimpleItemAnimator))
      ((SimpleItemAnimator)localItemAnimator).setSupportsChangeAnimations(false);
    this.mRecyclerView.addItemDecoration(new ContentCardsDividerItemDecoration(getContext()));
    this.mEmptyContentCardsAdapter = new AppboyEmptyContentCardsAdapter();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mShowNetworkUnavailableRunnable = new NetworkUnavailableRunnable(getContext(), null);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.com_appboy_content_cards, paramViewGroup, false);
    this.mRecyclerView = ((RecyclerView)localView.findViewById(R.id.com_appboy_content_cards_recycler));
    initializeRecyclerView();
    this.mContentCardsSwipeLayout = ((SwipeRefreshLayout)localView.findViewById(R.id.appboy_content_cards_swipe_container));
    this.mContentCardsSwipeLayout.setOnRefreshListener(this);
    SwipeRefreshLayout localSwipeRefreshLayout = this.mContentCardsSwipeLayout;
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = R.color.com_appboy_content_cards_swipe_refresh_color_1;
    arrayOfInt[1] = R.color.com_appboy_content_cards_swipe_refresh_color_2;
    arrayOfInt[2] = R.color.com_appboy_content_cards_swipe_refresh_color_3;
    arrayOfInt[3] = R.color.com_appboy_content_cards_swipe_refresh_color_4;
    localSwipeRefreshLayout.setColorSchemeResources(arrayOfInt);
    return localView;
  }

  public void onPause()
  {
    super.onPause();
    com.appboy.a.a(getContext()).a(this.mContentCardsUpdatedSubscriber, com.appboy.c.a.class);
    this.mMainThreadLooper.removeCallbacks(this.mShowNetworkUnavailableRunnable);
    this.mCardAdapter.markOnScreenCardsAsRead();
  }

  public void onRefresh()
  {
    com.appboy.a.a(getContext()).a(false);
    this.mMainThreadLooper.postDelayed(new Runnable()
    {
      public void run()
      {
        AppboyContentCardsFragment.this.mContentCardsSwipeLayout.setRefreshing(false);
      }
    }
    , 2500L);
  }

  public void onResume()
  {
    super.onResume();
    com.appboy.a.a(getContext()).a(this.mContentCardsUpdatedSubscriber, com.appboy.c.a.class);
    if (this.mContentCardsUpdatedSubscriber == null)
      this.mContentCardsUpdatedSubscriber = new com.appboy.c.c()
      {
        public void trigger(com.appboy.c.a paramAnonymousa)
        {
          AppboyContentCardsFragment.ContentCardsUpdateRunnable localContentCardsUpdateRunnable = new AppboyContentCardsFragment.ContentCardsUpdateRunnable(AppboyContentCardsFragment.this, paramAnonymousa);
          AppboyContentCardsFragment.this.mMainThreadLooper.post(localContentCardsUpdateRunnable);
        }
      };
    com.appboy.a.a(getContext()).b(this.mContentCardsUpdatedSubscriber);
    com.appboy.a.a(getContext()).a(true);
    com.appboy.a.a(getContext()).a();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if ((this.mRecyclerView != null) && (this.mRecyclerView.getLayoutManager() != null))
      paramBundle.putParcelable("LAYOUT_MANAGER_SAVED_INSTANCE_STATE_KEY", this.mRecyclerView.getLayoutManager().onSaveInstanceState());
    if (this.mCardAdapter != null)
      paramBundle.putStringArrayList("KNOWN_CARD_IMPRESSIONS_SAVED_INSTANCE_STATE_KEY", (ArrayList)this.mCardAdapter.getImpressedCardIds());
  }

  public void onViewStateRestored(final Bundle paramBundle)
  {
    super.onViewStateRestored(paramBundle);
    if (paramBundle == null)
      return;
    this.mMainThreadLooper.post(new Runnable()
    {
      public void run()
      {
        Parcelable localParcelable = paramBundle.getParcelable("LAYOUT_MANAGER_SAVED_INSTANCE_STATE_KEY");
        RecyclerView.LayoutManager localLayoutManager = AppboyContentCardsFragment.this.mRecyclerView.getLayoutManager();
        if ((localParcelable != null) && (localLayoutManager != null))
          localLayoutManager.onRestoreInstanceState(localParcelable);
        ArrayList localArrayList = paramBundle.getStringArrayList("KNOWN_CARD_IMPRESSIONS_SAVED_INSTANCE_STATE_KEY");
        if (localArrayList != null)
          AppboyContentCardsFragment.this.mCardAdapter.setImpressedCardIds(localArrayList);
      }
    });
  }

  private class ContentCardsUpdateRunnable
    implements Runnable
  {
    private final com.appboy.c.a mEvent;

    ContentCardsUpdateRunnable(com.appboy.c.a arg2)
    {
      Object localObject;
      this.mEvent = localObject;
    }

    public void run()
    {
      com.appboy.f.c.a(AppboyContentCardsFragment.TAG, "Updating Content Cards views in response to ContentCardsUpdatedEvent: " + this.mEvent);
      List localList = AppboyContentCardsFragment.this.getContentCardUpdateHandler().handleCardUpdate(this.mEvent);
      AppboyContentCardsFragment.this.mCardAdapter.replaceCards(localList);
      AppboyContentCardsFragment.this.mMainThreadLooper.removeCallbacks(AppboyContentCardsFragment.this.mShowNetworkUnavailableRunnable);
      if ((this.mEvent.a()) && (1000L * (60L + this.mEvent.d()) < System.currentTimeMillis()))
      {
        com.appboy.f.c.c(AppboyContentCardsFragment.TAG, "ContentCards received was older than the max time to live of 60 seconds, displaying it for now, but requesting an updated view from the server.");
        com.appboy.a.a(AppboyContentCardsFragment.this.getContext()).a(false);
        if (this.mEvent.c())
        {
          AppboyContentCardsFragment.this.mContentCardsSwipeLayout.setRefreshing(true);
          com.appboy.f.c.b(AppboyContentCardsFragment.TAG, "Old Content Cards was empty, putting up a network spinner and registering the network error message on a delay of 5000ms.");
          AppboyContentCardsFragment.this.mMainThreadLooper.postDelayed(AppboyContentCardsFragment.this.mShowNetworkUnavailableRunnable, 5000L);
          return;
        }
      }
      if (!this.mEvent.c())
        AppboyContentCardsFragment.this.swapRecyclerViewAdapter(AppboyContentCardsFragment.this.mCardAdapter);
      while (true)
      {
        AppboyContentCardsFragment.this.mContentCardsSwipeLayout.setRefreshing(false);
        return;
        AppboyContentCardsFragment.this.swapRecyclerViewAdapter(AppboyContentCardsFragment.this.mEmptyContentCardsAdapter);
      }
    }
  }

  private class NetworkUnavailableRunnable
    implements Runnable
  {
    private final Context mApplicationContext;

    private NetworkUnavailableRunnable(Context arg2)
    {
      Object localObject;
      this.mApplicationContext = localObject;
    }

    public void run()
    {
      com.appboy.f.c.a(AppboyContentCardsFragment.TAG, "Displaying network unavailable toast.");
      Toast.makeText(this.mApplicationContext, this.mApplicationContext.getString(R.string.com_appboy_feed_connection_error_title), 1).show();
      AppboyContentCardsFragment.this.swapRecyclerViewAdapter(AppboyContentCardsFragment.this.mEmptyContentCardsAdapter);
      AppboyContentCardsFragment.this.mContentCardsSwipeLayout.setRefreshing(false);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.AppboyContentCardsFragment
 * JD-Core Version:    0.6.2
 */