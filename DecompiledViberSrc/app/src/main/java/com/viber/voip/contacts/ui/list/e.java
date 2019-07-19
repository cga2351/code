package com.viber.voip.contacts.ui.list;

import android.os.Handler;
import com.viber.jni.Engine;
import com.viber.jni.service.ServiceStateDelegate.ServiceState;
import com.viber.voip.R.string;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.flatbuffers.model.conference.ConferenceParticipant;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.d.b;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.call.listeners.ConferenceInitializationListenersStore;
import com.viber.voip.phone.call.listeners.ConferenceInitializationListenersStore.Listener;
import com.viber.voip.phone.conf.ConferenceCall;
import com.viber.voip.phone.conf.IConferenceCall.UiDelegate;
import com.viber.voip.phone.conf.IConferenceCall.UiDelegate..CC;
import com.viber.voip.registration.af;
import com.viber.voip.user.UserData;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.cj;
import com.viber.voip.util.cn;
import com.viber.voip.util.da;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public abstract class e
  implements d
{
  private final long mAssociatedConversationId;
  private final CallHandler mCallHandler;
  private final IConferenceCall.UiDelegate mConferenceCallback = new IConferenceCall.UiDelegate()
  {
    public void onConferenceCreated(int paramAnonymousInt, long paramAnonymousLong, Map<String, Integer> paramAnonymousMap)
    {
      e.this.changeConferenceCallListenersRegistration(false);
      if (e.this.isConferenceCreationPending())
      {
        e.this.markConferenceCreationPending(false);
        if (paramAnonymousInt == 0)
          e.this.getView().closeOnSuccess();
      }
      else
      {
        return;
      }
      if (5 == paramAnonymousInt)
      {
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        ConferenceParticipant[] arrayOfConferenceParticipant = e.this.getConferenceInfo().getParticipants();
        int i = arrayOfConferenceParticipant.length;
        int j = 0;
        if (j < i)
        {
          ConferenceParticipant localConferenceParticipant = arrayOfConferenceParticipant[j];
          Integer localInteger = (Integer)paramAnonymousMap.get(localConferenceParticipant.getMemberId());
          if (localInteger != null)
          {
            if (3 != localInteger.intValue())
              break label147;
            localArrayList1.add(localConferenceParticipant);
          }
          while (true)
          {
            j++;
            break;
            label147: if (localInteger.intValue() != 0)
              localArrayList2.add(localConferenceParticipant);
          }
        }
        int k = localArrayList1.size();
        if (k > 0)
        {
          int m = arrayOfConferenceParticipant.length;
          if (e.this.isTransferToConferenceFrom1On1())
            m--;
          if (m == k)
          {
            e.this.getView().showAllParticipantsUnsupportedVersionError();
            return;
          }
          e.access$102(e.this, (ConferenceParticipant[])localArrayList1.toArray(new ConferenceParticipant[0]));
          e.this.getView().showSomeParticipantsUnsupportedVersionError(e.this.mCreateFailedParticipants);
          return;
        }
        if (!localArrayList2.isEmpty())
        {
          e.access$102(e.this, (ConferenceParticipant[])localArrayList2.toArray(new ConferenceParticipant[0]));
          e.this.getView().showParticipantsUnavailableError(e.this.mCreateFailedParticipants);
          return;
        }
        e.this.getView().showGeneralError();
        return;
      }
      e.this.getView().showGeneralError();
    }

    public void onDisconnected()
    {
      IConferenceCall.UiDelegate..CC.onDisconnected(this);
    }

    public void onFirstPeerJoined(ConferenceCall paramAnonymousConferenceCall, String paramAnonymousString)
    {
      IConferenceCall.UiDelegate..CC.onFirstPeerJoined(this, paramAnonymousConferenceCall, paramAnonymousString);
    }

    public void onLastPeerLeft(ConferenceCall paramAnonymousConferenceCall)
    {
      IConferenceCall.UiDelegate..CC.onLastPeerLeft(this, paramAnonymousConferenceCall);
    }

    public void onNewPeerConnectionNeeded()
    {
      IConferenceCall.UiDelegate..CC.onNewPeerConnectionNeeded(this);
    }

    public void onPeersChanged(Collection paramAnonymousCollection)
    {
      IConferenceCall.UiDelegate..CC.onPeersChanged(this, paramAnonymousCollection);
    }

    public void onPeersInvited(int paramAnonymousInt, Map paramAnonymousMap)
    {
      IConferenceCall.UiDelegate..CC.onPeersInvited(this, paramAnonymousInt, paramAnonymousMap);
    }

    public void onVolumeLevelChanged(Map paramAnonymousMap, String paramAnonymousString)
    {
      IConferenceCall.UiDelegate..CC.onVolumeLevelChanged(this, paramAnonymousMap, paramAnonymousString);
    }
  };
  private final ConferenceInitializationListenersStore.Listener mConferenceInitializationListener = new f(this);
  private ConferenceParticipant[] mCreateFailedParticipants;
  private final Engine mEngine;
  private boolean mIsConferenceCreationPending;
  private final bs mMessageEditHelper;
  private final Handler mMessagesHandler;
  private final b mParticipantManager;
  private final cj mReachability;
  private final cn mResourcesProvider;
  private final UserManager mUserManager;

  public e(Handler paramHandler, bs parambs, UserManager paramUserManager, CallHandler paramCallHandler, cj paramcj, Engine paramEngine, cn paramcn, b paramb, long paramLong)
  {
    this.mMessagesHandler = paramHandler;
    this.mMessageEditHelper = parambs;
    this.mUserManager = paramUserManager;
    this.mCallHandler = paramCallHandler;
    this.mReachability = paramcj;
    this.mEngine = paramEngine;
    this.mResourcesProvider = paramcn;
    this.mParticipantManager = paramb;
    this.mAssociatedConversationId = paramLong;
  }

  private void changeConferenceCallListenersRegistration(boolean paramBoolean)
  {
    ConferenceCall localConferenceCall = this.mCallHandler.getCurrentConferenceCall();
    if (localConferenceCall == null);
    do
    {
      return;
      localConferenceCall.removeUiDelegate(this.mConferenceCallback);
    }
    while ((!paramBoolean) || (!isConferenceCreationPending()));
    localConferenceCall.addUiDelegate(this.mConferenceCallback);
  }

  private void changeConferenceInitializationRegistration(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mCallHandler.getConferenceInitializationListenersStore().registerListener(this.mConferenceInitializationListener);
      return;
    }
    this.mCallHandler.getConferenceInitializationListenersStore().unregisterListener(this.mConferenceInitializationListener);
  }

  private boolean checkConnection()
  {
    if (this.mReachability.a() == -1)
    {
      getView().showNoConnectionError();
      return false;
    }
    if (this.mEngine.getServiceState() != ServiceStateDelegate.ServiceState.SERVICE_CONNECTED)
    {
      getView().showNoServiceError();
      return false;
    }
    return true;
  }

  private void handleStartOneToOneCallWith(Member paramMember)
  {
    this.mCallHandler.handleDialViber(paramMember, false);
  }

  private void startOneToOneCall(String paramString)
  {
    if (checkConnection())
    {
      String str = this.mParticipantManager.b(paramString, 1);
      if (str != null)
      {
        handleStartOneToOneCallWith(new Member(paramString, str));
        getView().close();
      }
    }
    else
    {
      return;
    }
    getView().showGeneralError();
  }

  public abstract ConferenceInfo getConferenceInfo();

  public abstract a getView();

  public void handleClose()
  {
    getView().close();
  }

  protected void handleStartGroupCallWith(ConferenceInfo paramConferenceInfo)
  {
    if (isConferenceCreationPending());
    do
    {
      return;
      markConferenceCreationPending(true);
    }
    while (this.mCallHandler.handleDialAudioConference(paramConferenceInfo, this.mAssociatedConversationId));
    markConferenceCreationPending(false);
  }

  public boolean isConferenceCreationPending()
  {
    return this.mIsConferenceCreationPending;
  }

  public boolean isTransferToConferenceFrom1On1()
  {
    return false;
  }

  public void markConferenceCreationPending(boolean paramBoolean)
  {
    this.mIsConferenceCreationPending = paramBoolean;
  }

  public void onDestroy()
  {
    changeConferenceInitializationRegistration(false);
  }

  public void onViewAttached()
  {
    changeConferenceInitializationRegistration(true);
  }

  public void sendUpdateLink()
  {
    String str1 = this.mUserManager.getUserData().getViberName();
    if (da.a(str1))
      str1 = this.mUserManager.getRegistrationValues().h();
    String str2 = this.mResourcesProvider.b(R.string.send_update_link_no_calls_support_text, new Object[] { str1 });
    this.mMessagesHandler.post(new g(this, str2));
    getView().close();
  }

  public void startGroupCall()
  {
    if (checkConnection())
      handleStartGroupCallWith(getConferenceInfo());
  }

  public void startGroupCallWithoutFailedParticipants()
  {
    if (this.mCreateFailedParticipants == null)
      return;
    ConferenceInfo localConferenceInfo = getConferenceInfo();
    ArrayList localArrayList = new ArrayList();
    ConferenceParticipant[] arrayOfConferenceParticipant1 = localConferenceInfo.getParticipants();
    int i = arrayOfConferenceParticipant1.length;
    int j = 0;
    ConferenceParticipant localConferenceParticipant1;
    int m;
    if (j < i)
    {
      localConferenceParticipant1 = arrayOfConferenceParticipant1[j];
      ConferenceParticipant[] arrayOfConferenceParticipant2 = this.mCreateFailedParticipants;
      int k = arrayOfConferenceParticipant2.length;
      m = 0;
      label60: if (m >= k)
        break label177;
      ConferenceParticipant localConferenceParticipant2 = arrayOfConferenceParticipant2[m];
      if (!localConferenceParticipant1.getMemberId().equals(localConferenceParticipant2.getMemberId()));
    }
    label177: for (int n = 1; ; n = 0)
    {
      if (n == 0)
        localArrayList.add(localConferenceParticipant1);
      j++;
      break;
      m++;
      break label60;
      localConferenceInfo.setParticipants((ConferenceParticipant[])localArrayList.toArray(new ConferenceParticipant[0]));
      if ((localArrayList.size() == 1) && (!isTransferToConferenceFrom1On1()))
      {
        startOneToOneCall(((ConferenceParticipant)localArrayList.get(0)).getMemberId());
        return;
      }
      startGroupCall();
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.list.e
 * JD-Core Version:    0.6.2
 */