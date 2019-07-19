package com.viber.voip.calls.ui;

import android.os.Handler;
import com.viber.jni.Engine;
import com.viber.voip.analytics.story.b.a.c;
import com.viber.voip.analytics.story.b.a.h;
import com.viber.voip.contacts.ui.list.BaseGroupCallParticipantsPresenterImpl;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.flatbuffers.model.conference.ConferenceParticipant;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.d.b;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.cj;
import com.viber.voip.util.cn;
import com.viber.voip.util.p;
import dagger.a;

public class GroupCallDetailsPresenter extends BaseGroupCallParticipantsPresenterImpl<d>
{
  private com.viber.voip.calls.d b;

  GroupCallDetailsPresenter(Handler paramHandler, CallHandler paramCallHandler, cj paramcj, Engine paramEngine, com.viber.voip.calls.d paramd, UserManager paramUserManager, bs parambs, cn paramcn, b paramb, a<h> parama, a<c> parama1)
  {
    super(paramHandler, parambs, paramUserManager, paramCallHandler, paramcj, paramEngine, paramcn, null, paramb, -1L, parama, parama1);
    this.b = paramd;
  }

  public void a(long paramLong, ConferenceInfo paramConferenceInfo)
  {
    this.a = paramConferenceInfo;
    ConferenceParticipant[] arrayOfConferenceParticipant = this.a.getParticipants();
    boolean bool;
    d locald;
    if (arrayOfConferenceParticipant.length > 0)
    {
      bool = true;
      locald = (d)this.mView;
      if (!bool)
        break label97;
    }
    label97: for (String str = p.a(this.a, false); ; str = null)
    {
      locald.a(str);
      ((d)this.mView).a(bool);
      this.b.a(paramLong, new j(this, arrayOfConferenceParticipant));
      return;
      bool = false;
      break;
    }
  }

  public void a(ConferenceParticipant paramConferenceParticipant)
  {
    ((d)this.mView).a(paramConferenceParticipant);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.ui.GroupCallDetailsPresenter
 * JD-Core Version:    0.6.2
 */