package com.viber.voip.contacts.ui.list;

import android.net.Uri;
import android.os.Handler;
import com.viber.jni.Engine;
import com.viber.jni.OnlineContactInfo;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.analytics.story.b.a.c;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.flatbuffers.model.conference.ConferenceParticipant;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.d.b;
import com.viber.voip.mvp.core.State;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.viber.conference.mapper.ConferenceParticipantMapper;
import com.viber.voip.user.OnlineUserActivityHelper;
import com.viber.voip.user.OnlineUserActivityHelper.UiOnlineUserInfoDelegate;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.cj;
import com.viber.voip.util.cn;
import com.viber.voip.util.da;
import dagger.a;
import java.util.ArrayList;
import java.util.List;

public class GroupCallStartParticipantsPresenter extends BaseGroupCallParticipantsPresenterImpl<p>
{
  private final Handler b;
  private final PhoneController c;
  private final OnlineUserActivityHelper d;
  private final ConferenceParticipantMapper e;
  private final OnlineUserActivityHelper.UiOnlineUserInfoDelegate f = new OnlineUserActivityHelper.UiOnlineUserInfoDelegate()
  {
    public void onOnlineStatusActivityReady(int paramAnonymousInt, OnlineContactInfo[] paramAnonymousArrayOfOnlineContactInfo)
    {
      List localList = GroupCallStartParticipantsPresenter.a(GroupCallStartParticipantsPresenter.this).mapToGroupCallStartParticipantsItemList(GroupCallStartParticipantsPresenter.this.a.getParticipants(), paramAnonymousArrayOfOnlineContactInfo);
      GroupCallStartParticipantsPresenter.b(GroupCallStartParticipantsPresenter.this).post(new r(this, localList));
    }
  };

  GroupCallStartParticipantsPresenter(Handler paramHandler1, Handler paramHandler2, CallHandler paramCallHandler, PhoneController paramPhoneController, OnlineUserActivityHelper paramOnlineUserActivityHelper, cj paramcj, Engine paramEngine, ConferenceInfo paramConferenceInfo, long paramLong, ConferenceParticipantMapper paramConferenceParticipantMapper, UserManager paramUserManager, bs parambs, cn paramcn, b paramb, a<com.viber.voip.analytics.story.b.a.h> parama, a<c> parama1)
  {
    super(paramHandler2, parambs, paramUserManager, paramCallHandler, paramcj, paramEngine, paramcn, paramConferenceInfo, paramb, paramLong, parama, parama1);
    this.b = paramHandler1;
    this.c = paramPhoneController;
    this.d = paramOnlineUserActivityHelper;
    this.e = paramConferenceParticipantMapper;
  }

  private void a()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ConferenceParticipant[] arrayOfConferenceParticipant = this.a.getParticipants();
    int i = arrayOfConferenceParticipant.length;
    int j = 0;
    if (j < i)
    {
      ConferenceParticipant localConferenceParticipant = arrayOfConferenceParticipant[j];
      String str1 = localConferenceParticipant.getImage();
      String str2 = localConferenceParticipant.getMemberId();
      if (!da.a(str1));
      for (Uri localUri = Uri.parse(str1); ; localUri = null)
      {
        localArrayList1.add(new n(str2, localUri, localConferenceParticipant.getName(), null));
        localArrayList2.add(localConferenceParticipant.getMemberId());
        j++;
        break;
      }
    }
    ((p)this.mView).a(localArrayList1);
    int k = this.c.generateSequence();
    this.d.obtainInfo((String[])localArrayList2.toArray(new String[localArrayList2.size()]), k, this.f);
  }

  public void onDestroy(android.arch.lifecycle.h paramh)
  {
    super.onDestroy(paramh);
    this.d.removeListener(this.f);
  }

  protected void onViewAttached(State paramState)
  {
    super.onViewAttached(paramState);
    a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.list.GroupCallStartParticipantsPresenter
 * JD-Core Version:    0.6.2
 */