package com.viber.voip.user;

import android.os.Handler;
import com.viber.common.b.a;
import com.viber.common.b.b;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineBackend;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.OnlineContactInfo;
import com.viber.jni.lastonline.LastOnlineControllerCaller;
import com.viber.jni.lastonline.LastOnlineDelegate;
import com.viber.jni.lastonline.LastOnlineListener;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.d;
import com.viber.voip.messages.controller.bv.e;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.settings.d.al;
import com.viber.voip.settings.d.bf;
import com.viber.voip.settings.d.g;
import com.viber.voip.util.d.b;
import com.viber.voip.util.i;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class OnlineUserActivityHelper
{
  private static final Logger L = ViberEnv.getLogger();
  private static final long OBSERVING_CONVERSATION_BACKGROUND_TIMEOUT = TimeUnit.SECONDS.toMillis(30L);
  private final d.b mAppStateListener;
  private final ViberApplication mApplication;
  private long mBackgroundStartTime = -1L;
  private final bv.e mConversationChangeListener;
  private volatile boolean mIsOnlineEnabled;
  private LastOnlineControllerCaller mLastOnlineControllerCaller;
  private final Set<UiOnlineUserInfoDelegate> mListeners = new HashSet();
  private long mObservableConversationId = -1L;
  private String mObservableMemberId;
  private final Object mObservingConversationLock = new Object();
  private LastOnlineDelegate mOnlineUserInfoDelegate = new LastOnlineDelegate()
  {
    private void notifyListeners(int paramAnonymousInt, OnlineContactInfo[] paramAnonymousArrayOfOnlineContactInfo)
    {
      synchronized (OnlineUserActivityHelper.this.mListeners)
      {
        HashSet localHashSet = new HashSet(OnlineUserActivityHelper.this.mListeners);
        Iterator localIterator = localHashSet.iterator();
        if (localIterator.hasNext())
          ((OnlineUserActivityHelper.UiOnlineUserInfoDelegate)localIterator.next()).onOnlineStatusActivityReady(paramAnonymousInt, paramAnonymousArrayOfOnlineContactInfo);
      }
    }

    public void onLastOnline(OnlineContactInfo[] paramAnonymousArrayOfOnlineContactInfo, int paramAnonymousInt)
    {
      notifyListeners(paramAnonymousInt, paramAnonymousArrayOfOnlineContactInfo);
    }
  };
  private d.al mPrefListener;

  public OnlineUserActivityHelper(EngineBackend paramEngineBackend, Engine paramEngine, EngineDelegatesManager paramEngineDelegatesManager, com.viber.voip.util.d paramd, bv parambv, ViberApplication paramViberApplication)
  {
    a[] arrayOfa = new a[2];
    arrayOfa[0] = d.bf.j;
    arrayOfa[1] = d.g.a;
    this.mPrefListener = new d.al(arrayOfa)
    {
      public void onPreferencesChanged(a paramAnonymousa)
      {
        if (d.bf.j.c().equals(paramAnonymousa.c()))
          OnlineUserActivityHelper.access$102(OnlineUserActivityHelper.this, d.bf.j.d());
      }
    };
    this.mAppStateListener = new d.b()
    {
      public void onAppStopped()
      {
        i.c(this);
      }

      public void onBackground()
      {
        synchronized (OnlineUserActivityHelper.this.mObservingConversationLock)
        {
          if (OnlineUserActivityHelper.this.isObservingConversation())
            OnlineUserActivityHelper.access$402(OnlineUserActivityHelper.this, System.currentTimeMillis());
          return;
        }
      }

      public void onForeground()
      {
        synchronized (OnlineUserActivityHelper.this.mObservingConversationLock)
        {
          if ((OnlineUserActivityHelper.this.isObservingConversation()) && (OnlineUserActivityHelper.this.getMessageManagerData().b(false) == OnlineUserActivityHelper.this.mObservableConversationId) && (OnlineUserActivityHelper.this.mObservableMemberId != null) && (OnlineUserActivityHelper.this.mBackgroundStartTime > 0L) && (System.currentTimeMillis() - OnlineUserActivityHelper.this.mBackgroundStartTime >= OnlineUserActivityHelper.OBSERVING_CONVERSATION_BACKGROUND_TIMEOUT))
            OnlineUserActivityHelper.this.obtainInfo(OnlineUserActivityHelper.this.mObservableMemberId, (int)(System.currentTimeMillis() / 1000L), null);
          OnlineUserActivityHelper.access$402(OnlineUserActivityHelper.this, -1L);
          return;
        }
      }

      public void onForegroundStateChanged(boolean paramAnonymousBoolean)
      {
        i.a(this, paramAnonymousBoolean);
      }
    };
    this.mConversationChangeListener = new bv.d()
    {
      public void onConversationClosed(boolean paramAnonymousBoolean, long paramAnonymousLong)
      {
        synchronized (OnlineUserActivityHelper.this.mObservingConversationLock)
        {
          OnlineUserActivityHelper.this.clearObservingConversationData();
          return;
        }
      }

      public void onOpenConversation(ConversationItemLoaderEntity paramAnonymousConversationItemLoaderEntity)
      {
        synchronized (OnlineUserActivityHelper.this.mObservingConversationLock)
        {
          if ((OnlineUserActivityHelper.this.mIsOnlineEnabled) && (paramAnonymousConversationItemLoaderEntity.isConversation1on1()) && (!paramAnonymousConversationItemLoaderEntity.isSystemConversation()) && (!paramAnonymousConversationItemLoaderEntity.isOneToOneWithPublicAccount()) && (!paramAnonymousConversationItemLoaderEntity.isAnonymous()))
          {
            OnlineUserActivityHelper.access$602(OnlineUserActivityHelper.this, paramAnonymousConversationItemLoaderEntity.getId());
            OnlineUserActivityHelper.access$702(OnlineUserActivityHelper.this, paramAnonymousConversationItemLoaderEntity.getParticipantMemberId());
          }
          return;
        }
      }
    };
    this.mApplication = paramViberApplication;
    LastOnlineListener localLastOnlineListener = paramEngineDelegatesManager.getLastOnlineListener();
    LastOnlineDelegate[] arrayOfLastOnlineDelegate = new LastOnlineDelegate[1];
    arrayOfLastOnlineDelegate[0] = this.mOnlineUserInfoDelegate;
    localLastOnlineListener.registerDelegate(arrayOfLastOnlineDelegate);
    this.mLastOnlineControllerCaller = new LastOnlineControllerCaller(paramEngineBackend, paramEngine);
    this.mIsOnlineEnabled = d.bf.j.d();
    com.viber.voip.settings.d.a(this.mPrefListener);
    paramd.a(this.mAppStateListener);
    parambv.a(this.mConversationChangeListener);
  }

  public static boolean canFetchOnlineInfo(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    return (paramConversationItemLoaderEntity != null) && (paramConversationItemLoaderEntity.getGroupRole() != 3) && (!paramConversationItemLoaderEntity.isCommunityType()) && ((!paramConversationItemLoaderEntity.isPublicGroupType()) || (paramConversationItemLoaderEntity.getGroupRole() == 2)) && ((!paramConversationItemLoaderEntity.isCommunityType()) || (paramConversationItemLoaderEntity.getGroupRole() != 3)) && (!paramConversationItemLoaderEntity.isOneToOneWithPublicAccount()) && (!paramConversationItemLoaderEntity.isSystemConversation()) && (!paramConversationItemLoaderEntity.isSystemReplyableChat()) && (!paramConversationItemLoaderEntity.isAnonymous());
  }

  private void clearObservingConversationData()
  {
    this.mObservableConversationId = -1L;
    this.mObservableMemberId = null;
    this.mBackgroundStartTime = -1L;
  }

  private com.viber.voip.messages.controller.manager.k getMessageManagerData()
  {
    return this.mApplication.getMessagesManager().a();
  }

  private boolean isObservingConversation()
  {
    return (this.mIsOnlineEnabled) && (this.mObservableConversationId > 0L);
  }

  private void registryListener(UiOnlineUserInfoDelegate paramUiOnlineUserInfoDelegate)
  {
    if (paramUiOnlineUserInfoDelegate != null)
      synchronized (this.mListeners)
      {
        this.mListeners.add(paramUiOnlineUserInfoDelegate);
        return;
      }
  }

  public boolean isObtainOnlineStatusesAvailable()
  {
    return this.mIsOnlineEnabled;
  }

  public void obtainInfo(String paramString, int paramInt, UiOnlineUserInfoDelegate paramUiOnlineUserInfoDelegate)
  {
    obtainInfo(new String[] { paramString }, paramInt, paramUiOnlineUserInfoDelegate);
  }

  public void obtainInfo(final String[] paramArrayOfString, final int paramInt, UiOnlineUserInfoDelegate paramUiOnlineUserInfoDelegate)
  {
    if (paramArrayOfString.length == 0)
      return;
    registryListener(paramUiOnlineUserInfoDelegate);
    av.a(av.e.g).post(new Runnable()
    {
      public void run()
      {
        if (OnlineUserActivityHelper.this.isObtainOnlineStatusesAvailable())
          OnlineUserActivityHelper.this.mLastOnlineControllerCaller.handleGetLastOnline(paramArrayOfString, paramInt);
      }
    });
  }

  public void obtainInfoSync(String[] paramArrayOfString, int paramInt, UiOnlineUserInfoDelegate paramUiOnlineUserInfoDelegate)
  {
    if (paramArrayOfString.length == 0);
    do
    {
      return;
      registryListener(paramUiOnlineUserInfoDelegate);
    }
    while (!isObtainOnlineStatusesAvailable());
    this.mLastOnlineControllerCaller.handleGetLastOnline(paramArrayOfString, paramInt);
  }

  public void removeListener(UiOnlineUserInfoDelegate paramUiOnlineUserInfoDelegate)
  {
    synchronized (this.mListeners)
    {
      this.mListeners.remove(paramUiOnlineUserInfoDelegate);
      return;
    }
  }

  public static abstract interface UiOnlineUserInfoDelegate
  {
    public abstract void onOnlineStatusActivityReady(int paramInt, OnlineContactInfo[] paramArrayOfOnlineContactInfo);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.OnlineUserActivityHelper
 * JD-Core Version:    0.6.2
 */