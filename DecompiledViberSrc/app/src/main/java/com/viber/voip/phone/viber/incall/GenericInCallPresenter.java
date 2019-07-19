package com.viber.voip.phone.viber.incall;

import android.net.Uri;
import android.os.Handler;
import com.viber.jni.Engine;
import com.viber.voip.analytics.story.b.a.h.a;
import com.viber.voip.analytics.story.b.a.h.a.a;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.contacts.ui.list.e;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.flatbuffers.model.conference.ConferenceParticipant;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.d.b;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.mvp.core.State;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.CallerInfo;
import com.viber.voip.phone.viber.conference.mapper.ConferenceParticipantMapper;
import com.viber.voip.settings.d.m;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.cj;
import com.viber.voip.util.cn;
import com.viber.voip.util.n;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

public class GenericInCallPresenter extends BaseMvpPresenter<GenericInCallMvpView, State>
  implements com.viber.voip.contacts.ui.list.d
{
  private final CallHandler mCallHandler;
  private ConferenceInfo mConferenceInfo;
  private final e mDelegate;
  private CallInfo mLastCallInfo;
  private final ConferenceParticipantMapper mMapper;
  private final dagger.a<com.viber.voip.analytics.story.b.a.h> mUserStartsCallEventCollector;

  @Inject
  public GenericInCallPresenter(Handler paramHandler, bs parambs, UserManager paramUserManager, CallHandler paramCallHandler, cj paramcj, Engine paramEngine, cn paramcn, b paramb, ConferenceParticipantMapper paramConferenceParticipantMapper, dagger.a<com.viber.voip.analytics.story.b.a.h> parama)
  {
    this.mCallHandler = paramCallHandler;
    this.mMapper = paramConferenceParticipantMapper;
    this.mUserStartsCallEventCollector = parama;
    this.mDelegate = new e(paramHandler, parambs, paramUserManager, this.mCallHandler, paramcj, paramEngine, paramcn, paramb, -1L)
    {
      public ConferenceInfo getConferenceInfo()
      {
        return GenericInCallPresenter.this.mConferenceInfo;
      }

      public com.viber.voip.contacts.ui.list.a getView()
      {
        return (com.viber.voip.contacts.ui.list.a)GenericInCallPresenter.this.mView;
      }

      protected void handleStartGroupCallWith(ConferenceInfo paramAnonymousConferenceInfo)
      {
        GenericInCallPresenter.this.handleStartGroupCallWith(paramAnonymousConferenceInfo);
      }

      public boolean isTransferToConferenceFrom1On1()
      {
        return true;
      }
    };
  }

  private void handleStartGroupCallWith(ConferenceInfo paramConferenceInfo)
  {
    CallInfo localCallInfo = this.mCallHandler.getCallInfo();
    if (localCallInfo == null)
      return;
    ConferenceParticipant[] arrayOfConferenceParticipant = paramConferenceInfo.getParticipants();
    String[] arrayOfString1 = new String[arrayOfConferenceParticipant.length];
    arrayOfString1[0] = localCallInfo.getCallerInfo().getMemberId();
    int i = arrayOfConferenceParticipant.length;
    int j = 0;
    int k = 1;
    int m;
    if (j < i)
    {
      ConferenceParticipant localConferenceParticipant = arrayOfConferenceParticipant[j];
      if (localConferenceParticipant.getMemberId().equals(arrayOfString1[0]))
        break label183;
      m = k + 1;
      arrayOfString1[k] = localConferenceParticipant.getMemberId();
    }
    while (true)
    {
      j++;
      k = m;
      break;
      this.mDelegate.markConferenceCreationPending(true);
      if (!this.mCallHandler.handleTransferToConferenceFrom1on1(arrayOfString1))
        this.mDelegate.markConferenceCreationPending(false);
      String[] arrayOfString2 = (String[])n.a(String.class, arrayOfConferenceParticipant, GenericInCallPresenter..Lambda.0.$instance);
      ((com.viber.voip.analytics.story.b.a.h)this.mUserStartsCallEventCollector.get()).a(h.a.i().b(arrayOfString2).a("1-On-1 Call").b("Group Audio Call").c(true).a());
      return;
      label183: m = k;
    }
  }

  private ConferenceInfo mapToConferenceInfo(List<ParticipantSelector.Participant> paramList)
  {
    ConferenceInfo localConferenceInfo = new ConferenceInfo();
    ConferenceParticipant[] arrayOfConferenceParticipant = new ConferenceParticipant[paramList.size()];
    Iterator localIterator = paramList.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      ParticipantSelector.Participant localParticipant = (ParticipantSelector.Participant)localIterator.next();
      j = i + 1;
      arrayOfConferenceParticipant[i] = this.mMapper.mapToConferenceParticipant(localParticipant);
    }
    localConferenceInfo.setParticipants(arrayOfConferenceParticipant);
    return localConferenceInfo;
  }

  public void handleAddToCallClick()
  {
    ((GenericInCallMvpView)this.mView).openConferenceParticipantsSelector(this.mLastCallInfo.getCallerInfo().getMemberId(), d.m.w.d());
  }

  public void handleClose()
  {
    this.mDelegate.handleClose();
  }

  public void handleEndCallClick()
  {
    this.mCallHandler.handleHangup();
  }

  public void handleSelectConferenceParticipants(List<ParticipantSelector.Participant> paramList)
  {
    this.mConferenceInfo = mapToConferenceInfo(paramList);
    this.mConferenceInfo.setIsSelfInitiated(true);
    handleStartGroupCallWith(this.mConferenceInfo);
  }

  public void onDestroy(android.arch.lifecycle.h paramh)
  {
    super.onDestroy(paramh);
    this.mDelegate.onDestroy();
  }

  public void onResume(android.arch.lifecycle.h paramh)
  {
    super.onResume(paramh);
    CallInfo localCallInfo = this.mCallHandler.getCallInfo();
    Uri localUri;
    GenericInCallMvpView localGenericInCallMvpView;
    if ((localCallInfo != null) && (localCallInfo != this.mLastCallInfo))
    {
      this.mLastCallInfo = localCallInfo;
      CallerInfo localCallerInfo = localCallInfo.getCallerInfo();
      com.viber.voip.model.a locala = localCallerInfo.getContact();
      localUri = localCallerInfo.getCallerPhoto();
      localGenericInCallMvpView = (GenericInCallMvpView)this.mView;
      if (locala == null)
        break label76;
    }
    label76: for (boolean bool = true; ; bool = false)
    {
      localGenericInCallMvpView.loadPhoto(bool, localUri);
      return;
    }
  }

  protected void onViewAttached(State paramState)
  {
    super.onViewAttached(paramState);
    this.mDelegate.onViewAttached();
  }

  public void sendUpdateLink()
  {
    this.mDelegate.sendUpdateLink();
  }

  public void startGroupCall()
  {
    this.mDelegate.startGroupCall();
  }

  public void startGroupCallWithoutFailedParticipants()
  {
    this.mDelegate.startGroupCallWithoutFailedParticipants();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.incall.GenericInCallPresenter
 * JD-Core Version:    0.6.2
 */