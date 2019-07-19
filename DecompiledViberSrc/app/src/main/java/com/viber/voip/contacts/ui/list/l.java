package com.viber.voip.contacts.ui.list;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.common.dialogs.m.c;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.R.layout;
import com.viber.voip.analytics.story.b.a.h;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.d.b;
import com.viber.voip.mvp.core.g;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.viber.conference.mapper.ConferenceParticipantMapper;
import com.viber.voip.user.OnlineUserActivityHelper;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.cj;
import com.viber.voip.util.cn;
import com.viber.voip.util.e.e;
import javax.inject.Inject;

public class l extends g<q>
  implements m.c
{

  @Inject
  Handler a;

  @Inject
  Handler b;

  @Inject
  CallHandler c;

  @Inject
  PhoneController d;

  @Inject
  OnlineUserActivityHelper e;

  @Inject
  cj f;

  @Inject
  Engine g;

  @Inject
  e h;

  @Inject
  com.viber.common.permission.c i;

  @Inject
  UserManager j;

  @Inject
  bs k;

  @Inject
  cn l;

  @Inject
  ConferenceParticipantMapper m;

  @Inject
  b n;

  @Inject
  dagger.a<h> o;

  @Inject
  dagger.a<com.viber.voip.analytics.story.b.a.c> p;

  protected void createViewPresenters(View paramView, Bundle paramBundle)
  {
    Bundle localBundle = getArguments();
    ConferenceInfo localConferenceInfo = (ConferenceInfo)localBundle.getParcelable("conference_info");
    long l1 = localBundle.getLong("associated_conversation_id", -1L);
    String str = localBundle.getString("analytics_entry_point", "");
    GroupCallStartParticipantsPresenter localGroupCallStartParticipantsPresenter = new GroupCallStartParticipantsPresenter(this.a, this.b, this.c, this.d, this.e, this.f, this.g, localConferenceInfo, l1, this.m, this.j, this.k, this.l, this.n, this.o, this.p);
    localGroupCallStartParticipantsPresenter.a(str);
    addMvpView(new q(localGroupCallStartParticipantsPresenter, paramView, this, this.h, this.i), localGroupCallStartParticipantsPresenter, paramBundle);
  }

  protected void initModelComponent(View paramView, Bundle paramBundle)
  {
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.fragment_group_call_start_participants, paramViewGroup, false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.list.l
 * JD-Core Version:    0.6.2
 */