package com.viber.jni.cdr.entity;

import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.LayoutParams;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.viber.dexshared.Logger;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.ViberEnv;
import com.viber.voip.i.f;
import com.viber.voip.messages.controller.manager.z;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.conversation.RegularConversationLoaderEntity;
import com.viber.voip.storage.b;
import com.viber.voip.util.d.b;
import com.viber.voip.util.i;
import java.util.concurrent.TimeUnit;

public class ConversationsScreenScrollCdrController
  implements AbsListView.OnScrollListener, d.b
{
  private static final long CDR_REPORT_DELAY_MILLIS = 0L;
  private static final Logger L = ViberEnv.getLogger();
  private static final int UNDEFINED = -1;
  private AppBarLayout mAppBarLayout;
  private final ICdrController mCdrController;
  private final dagger.a<z> mConversationHelperLazy;
  private int mConversationsCount;
  private int mFirstVisiblePosition;
  private volatile int mFirstVisiblePositionAfterScreenOpened = -1;
  private volatile boolean mIsCdrAlreadyTracked = false;
  private boolean mIsSendCdrActionPosted = false;
  private int mLastVisiblePosition;
  private AbsListView mListView;
  private final f mLoginFlagSwitcher;
  private final Runnable mSendCdrAction = new Runnable()
  {
    public void run()
    {
      ConversationsScreenScrollCdrController.access$002(ConversationsScreenScrollCdrController.this, false);
      ConversationsScreenScrollCdrController.access$102(ConversationsScreenScrollCdrController.this, true);
      ConversationsScreenScrollCdrController.this.updateFirstAndLastVisiblePositions(ConversationsScreenScrollCdrController.this.mListView);
      int i = Math.max(0, ConversationsScreenScrollCdrController.this.mFirstVisiblePositionAfterScreenOpened);
      int j = ConversationsScreenScrollCdrController.this.mFirstVisiblePosition;
      int k = ConversationsScreenScrollCdrController.this.mLastVisiblePosition;
      int m = ConversationsScreenScrollCdrController.this.mConversationsCount;
      ConversationsScreenScrollCdrController.this.mWorkingHandler.post(new ConversationsScreenScrollCdrController.1..Lambda.0(this, i, j, k, m));
    }
  };
  private final Handler mWaitingHandler;
  private final f mWasabiSwitcher;
  private final Handler mWorkingHandler;

  public ConversationsScreenScrollCdrController(f paramf1, f paramf2, Handler paramHandler1, Handler paramHandler2, dagger.a<z> parama, ICdrController paramICdrController)
  {
    this.mLoginFlagSwitcher = paramf1;
    this.mWasabiSwitcher = paramf2;
    this.mWaitingHandler = paramHandler1;
    this.mWorkingHandler = paramHandler2;
    this.mConversationHelperLazy = parama;
    this.mCdrController = paramICdrController;
  }

  private int correctLastVisibleItemPosition(AbsListView paramAbsListView, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= paramInt1)
      return paramInt1;
    View localView = paramAbsListView.getChildAt(paramInt2 - paramInt1);
    if ((localView == null) || (paramAbsListView.getHeight() - getAppBarVisibleHeight() <= localView.getTop()))
      return correctLastVisibleItemPosition(paramAbsListView, paramInt1, paramInt2 - 1);
    return paramInt2;
  }

  private int getAppBarVisibleHeight()
  {
    if (this.mAppBarLayout != null)
    {
      CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.LayoutParams)this.mAppBarLayout.getLayoutParams()).getBehavior();
      if ((localBehavior instanceof AppBarLayout.Behavior))
        return this.mAppBarLayout.getTotalScrollRange() + ((AppBarLayout.Behavior)localBehavior).getTopAndBottomOffset();
    }
    return 0;
  }

  private boolean isTrackingNeeded()
  {
    return (!this.mIsCdrAlreadyTracked) && ((this.mWasabiSwitcher.e()) || (this.mLoginFlagSwitcher.e()));
  }

  private String obtainConversationNameDebug(b<RegularConversationLoaderEntity> paramb, Object paramObject)
  {
    if ((paramObject instanceof com.viber.voip.messages.adapters.a.a))
    {
      ConversationLoaderEntity localConversationLoaderEntity = ((com.viber.voip.messages.adapters.a.a)paramObject).a();
      if ((localConversationLoaderEntity instanceof RegularConversationLoaderEntity))
        return paramb.a((RegularConversationLoaderEntity)localConversationLoaderEntity);
    }
    if (paramObject != null)
      return paramObject.getClass().getName();
    return "null";
  }

  private void updateFirstAndLastVisiblePositions(AbsListView paramAbsListView)
  {
    if (paramAbsListView != null)
    {
      this.mFirstVisiblePosition = paramAbsListView.getFirstVisiblePosition();
      this.mLastVisiblePosition = Math.min(Math.max(0, -1 + this.mConversationsCount), Math.max(paramAbsListView.getLastVisiblePosition(), 0));
      this.mLastVisiblePosition = correctLastVisibleItemPosition(paramAbsListView, this.mFirstVisiblePosition, this.mLastVisiblePosition);
    }
  }

  public void attachViews(AbsListView paramAbsListView, AppBarLayout paramAppBarLayout)
  {
    this.mListView = paramAbsListView;
    this.mAppBarLayout = paramAppBarLayout;
  }

  public void detachViews()
  {
    if (this.mListView != null)
    {
      if (isTrackingNeeded())
        updateFirstAndLastVisiblePositions(this.mListView);
      this.mListView = null;
    }
    this.mAppBarLayout = null;
  }

  public void onAppStopped()
  {
    i.c(this);
  }

  public void onBackground()
  {
    i.a(this);
  }

  public void onForeground()
  {
    i.b(this);
  }

  public void onForegroundStateChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mIsCdrAlreadyTracked = false;
      return;
    }
    this.mFirstVisiblePositionAfterScreenOpened = -1;
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (!isTrackingNeeded());
    do
    {
      do
      {
        return;
        switch (paramInt)
        {
        default:
          return;
        case 0:
        case 1:
        case 2:
        }
      }
      while (this.mIsSendCdrActionPosted);
      this.mIsSendCdrActionPosted = true;
      this.mWaitingHandler.removeCallbacks(this.mSendCdrAction);
      this.mWaitingHandler.postDelayed(this.mSendCdrAction, CDR_REPORT_DELAY_MILLIS);
      return;
    }
    while (!this.mIsSendCdrActionPosted);
    this.mWaitingHandler.removeCallbacks(this.mSendCdrAction);
    this.mIsSendCdrActionPosted = false;
  }

  public void update(int paramInt1, int paramInt2)
  {
    if (this.mFirstVisiblePositionAfterScreenOpened == -1)
      this.mFirstVisiblePositionAfterScreenOpened = paramInt1;
    this.mConversationsCount = paramInt2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.cdr.entity.ConversationsScreenScrollCdrController
 * JD-Core Version:    0.6.2
 */