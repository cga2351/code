package com.viber.voip.user.viberid;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.i.c.o;
import com.viber.voip.i.f;
import com.viber.voip.i.f.a;
import com.viber.voip.user.UserData;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ViberIdTriggerStateHolder
  implements f.a
{
  private static final Logger L = ViberEnv.getLogger();
  private final EventBus mControllerEventBus;
  private final EventBus mEventBus;
  private final f mFeatureSwitcher;
  private Object mTriggerStateListener;
  private final UserData mUserData;

  public ViberIdTriggerStateHolder(ViberIdController paramViberIdController, UserData paramUserData, EventBus paramEventBus)
  {
    this(paramViberIdController, paramUserData, paramEventBus, c.o.a);
  }

  ViberIdTriggerStateHolder(ViberIdController paramViberIdController, UserData paramUserData, EventBus paramEventBus, f paramf)
  {
    this.mControllerEventBus = paramViberIdController.getEventBus();
    this.mUserData = paramUserData;
    this.mEventBus = paramEventBus;
    this.mFeatureSwitcher = paramf;
  }

  private void updateViberIdTriggerStateAndNotify()
  {
    try
    {
      boolean bool = isViberIdTriggerAvailable();
      this.mEventBus.post(new ViberIdTriggerStateChangedEvent(bool));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean isViberIdTriggerAvailable()
  {
    ViberIdInfo localViberIdInfo = this.mUserData.getViberIdInfo();
    boolean bool1 = this.mFeatureSwitcher.e();
    boolean bool2 = localViberIdInfo.isAccountExist();
    boolean bool3 = localViberIdInfo.isRegisteredOnCurrentDevice();
    if ((bool2) && (bool3));
    for (int i = 1; (bool1) && (i == 0); i = 0)
      return true;
    return false;
  }

  public void onFeatureStateChanged(f paramf)
  {
    updateViberIdTriggerStateAndNotify();
  }

  @Subscribe(threadMode=ThreadMode.POSTING)
  public void onViberIdInfoChanged(ViberIdEvents.ViberIdInfoChangedEvent paramViberIdInfoChangedEvent)
  {
    updateViberIdTriggerStateAndNotify();
  }

  public void register(Object paramObject)
  {
    while (true)
    {
      try
      {
        Object localObject2 = this.mTriggerStateListener;
        if (localObject2 == paramObject)
          return;
        if (this.mTriggerStateListener == null)
        {
          this.mFeatureSwitcher.a(this);
          if (!this.mControllerEventBus.isRegistered(this))
            this.mControllerEventBus.register(this);
          this.mTriggerStateListener = paramObject;
          if (this.mEventBus.isRegistered(this.mTriggerStateListener))
            continue;
          this.mEventBus.register(this.mTriggerStateListener);
          continue;
        }
      }
      finally
      {
      }
      this.mEventBus.unregister(this.mTriggerStateListener);
    }
  }

  public void unregister()
  {
    try
    {
      Object localObject2 = this.mTriggerStateListener;
      if (localObject2 == null);
      while (true)
      {
        return;
        this.mFeatureSwitcher.b(this);
        this.mEventBus.unregister(this.mTriggerStateListener);
        this.mControllerEventBus.unregister(this);
      }
    }
    finally
    {
    }
  }

  public static class ViberIdTriggerStateChangedEvent
  {
    public final boolean isViberIdTriggerAvailable;

    ViberIdTriggerStateChangedEvent(boolean paramBoolean)
    {
      this.isViberIdTriggerAvailable = paramBoolean;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.ViberIdTriggerStateHolder
 * JD-Core Version:    0.6.2
 */