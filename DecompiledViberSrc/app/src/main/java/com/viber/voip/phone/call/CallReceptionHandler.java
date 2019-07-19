package com.viber.voip.phone.call;

import android.net.Uri;
import android.os.Handler;
import com.viber.voip.ViberApplication;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.contacts.c.d.g;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.messages.controller.ci;
import com.viber.voip.messages.controller.ci.a;
import com.viber.voip.messages.k;
import com.viber.voip.model.entity.d;
import com.viber.voip.phone.viber.conference.ConferenceParticipantsRepository;
import com.viber.voip.phone.viber.conference.model.ConferenceParticipantRepositoryEntity;
import com.viber.voip.util.da;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CallReceptionHandler
{
  private ConferenceParticipantsRepository getConferenceParticipantsRepository()
  {
    return (ConferenceParticipantsRepository)ViberApplication.getInstance().getLazyConferenceParticipantsRepository().get();
  }

  private com.viber.voip.model.a getContactEntity(String paramString)
  {
    Iterator localIterator = getContactManager().c().c(paramString).iterator();
    while (localIterator.hasNext())
    {
      com.viber.voip.model.a locala = (com.viber.voip.model.a)localIterator.next();
      if (locala != null)
        return locala;
    }
    return null;
  }

  private g getContactManager()
  {
    return ViberApplication.getInstance().getContactManager();
  }

  private ci getUserDataDelegate()
  {
    return ViberApplication.getInstance().getMessagesManager().e();
  }

  private void showCallReception(final String paramString1, final String paramString2, final boolean paramBoolean, final int paramInt, final String paramString3, final OnCreateCallInfoCallback paramOnCreateCallInfoCallback)
  {
    com.viber.voip.model.a locala = getContactEntity(paramString2);
    if ((locala == null) && (paramInt != 1))
    {
      getUserDataDelegate().a(paramString1, new ci.a()
      {
        public void onGetUserDetail(com.viber.voip.model.entity.m[] paramAnonymousArrayOfm)
        {
          com.viber.voip.model.entity.m localm = paramAnonymousArrayOfm[0];
          d locald = new d(localm.getViberName(), paramString2, Uri.parse(localm.e()));
          locald.c(true);
          paramOnCreateCallInfoCallback.onShowReception(paramString2, paramString1, CallInfo.CallType.INCOMING, paramInt, paramBoolean, false, false, false, locald, localm.j(), "", null, paramString3);
        }

        public void onGetUserError()
        {
          paramOnCreateCallInfoCallback.onShowReception(paramString2, paramString1, CallInfo.CallType.INCOMING, paramInt, paramBoolean, false, false, false, null, false, "", null, paramString3);
        }
      }
      , true);
      return;
    }
    if (da.a(paramString1));
    for (String str = paramString2; ; str = paramString1)
    {
      paramOnCreateCallInfoCallback.onShowReception(paramString2, str, CallInfo.CallType.INCOMING, paramInt, paramBoolean, false, false, false, locala, false, "", null, paramString3);
      return;
    }
  }

  private void showConferenceReception(String paramString1, String paramString2, boolean paramBoolean, int paramInt, String paramString3, Map<String, String> paramMap, String paramString4, OnCreateCallInfoCallback paramOnCreateCallInfoCallback)
  {
    Object localObject = getContactEntity(paramString2);
    ConferenceInfo localConferenceInfo = getConferenceParticipantsRepository().loadConferenceInfo(paramString1, paramMap);
    if (localConferenceInfo != null)
      localConferenceInfo.setIsSelfInitiated(false);
    boolean bool = false;
    ConferenceParticipantRepositoryEntity localConferenceParticipantRepositoryEntity;
    String str;
    if (localObject == null)
    {
      bool = false;
      if (paramInt != 1)
      {
        localConferenceParticipantRepositoryEntity = (ConferenceParticipantRepositoryEntity)getConferenceParticipantsRepository().loadParticipantInfos(Collections.singletonList(paramString1)).get(paramString1);
        bool = false;
        if (localConferenceParticipantRepositoryEntity != null)
        {
          bool = localConferenceParticipantRepositoryEntity.isUnknownParticipant;
          str = localConferenceParticipantRepositoryEntity.displayName;
          if (localConferenceParticipantRepositoryEntity.photo == null)
            break label156;
        }
      }
    }
    label156: for (Uri localUri = localConferenceParticipantRepositoryEntity.photo; ; localUri = Uri.parse(""))
    {
      localObject = new d(str, paramString2, localUri);
      ((d)localObject).c(true);
      paramOnCreateCallInfoCallback.onShowReception(paramString2, paramString1, CallInfo.CallType.INCOMING, paramInt, paramBoolean, false, false, false, (com.viber.voip.model.a)localObject, bool, paramString3, localConferenceInfo, paramString4);
      return;
    }
  }

  private void showReceptionInner(String paramString1, String paramString2, boolean paramBoolean, int paramInt, String paramString3, Map<String, String> paramMap, String paramString4, OnCreateCallInfoCallback paramOnCreateCallInfoCallback)
  {
    if (!da.a(paramString3))
    {
      showConferenceReception(paramString1, paramString2, paramBoolean, paramInt, paramString3, paramMap, paramString4, paramOnCreateCallInfoCallback);
      return;
    }
    showCallReception(paramString1, paramString2, paramBoolean, paramInt, paramString4, paramOnCreateCallInfoCallback);
  }

  void showReception(String paramString1, String paramString2, boolean paramBoolean, int paramInt, String paramString3, Map<String, String> paramMap, String paramString4, OnCreateCallInfoCallback paramOnCreateCallInfoCallback)
  {
    av.a(av.e.f).post(new CallReceptionHandler..Lambda.0(this, paramString1, paramString2, paramBoolean, paramInt, paramString3, paramMap, paramString4, paramOnCreateCallInfoCallback));
  }

  static abstract interface OnCreateCallInfoCallback
  {
    public abstract void onShowReception(String paramString1, String paramString2, CallInfo.CallType paramCallType, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, com.viber.voip.model.a parama, boolean paramBoolean5, String paramString3, ConferenceInfo paramConferenceInfo, String paramString4);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.call.CallReceptionHandler
 * JD-Core Version:    0.6.2
 */