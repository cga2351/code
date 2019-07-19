package com.viber.voip.contacts.ui.list;

import android.os.Handler;
import com.viber.jni.Engine;
import com.viber.voip.analytics.story.b.a.c;
import com.viber.voip.analytics.story.b.a.h.a;
import com.viber.voip.analytics.story.b.a.h.a.a;
import com.viber.voip.analytics.story.b.f;
import com.viber.voip.analytics.story.b.f.b;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.d.b;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.mvp.core.State;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.cj;
import com.viber.voip.util.cn;
import com.viber.voip.util.n;

public class BaseGroupCallParticipantsPresenterImpl<MVP_VIEW extends a> extends BaseMvpPresenter<MVP_VIEW, State>
  implements d
{
  protected ConferenceInfo a;
  private final e b;
  private final long c;
  private String d = "";
  private final dagger.a<com.viber.voip.analytics.story.b.a.h> e;
  private final dagger.a<c> f;

  public BaseGroupCallParticipantsPresenterImpl(Handler paramHandler, bs parambs, UserManager paramUserManager, CallHandler paramCallHandler, cj paramcj, Engine paramEngine, cn paramcn, ConferenceInfo paramConferenceInfo, b paramb, long paramLong, dagger.a<com.viber.voip.analytics.story.b.a.h> parama, dagger.a<c> parama1)
  {
    this.a = paramConferenceInfo;
    this.c = paramLong;
    this.e = parama;
    this.f = parama1;
    this.b = new e(paramHandler, parambs, paramUserManager, paramCallHandler, paramcj, paramEngine, paramcn, paramb, this.c)
    {
      public ConferenceInfo getConferenceInfo()
      {
        return BaseGroupCallParticipantsPresenterImpl.this.a;
      }

      public a getView()
      {
        return (a)BaseGroupCallParticipantsPresenterImpl.a(BaseGroupCallParticipantsPresenterImpl.this);
      }
    };
  }

  public void a(String paramString)
  {
    this.d = paramString;
  }

  public void handleClose()
  {
    f localf = f.b.a(this.a);
    ((c)this.f.get()).a(localf, true, 13);
    this.b.handleClose();
  }

  public void onDestroy(android.arch.lifecycle.h paramh)
  {
    super.onDestroy(paramh);
    this.b.onDestroy();
  }

  protected void onViewAttached(State paramState)
  {
    super.onViewAttached(paramState);
    this.b.onViewAttached();
  }

  public void sendUpdateLink()
  {
    this.b.sendUpdateLink();
  }

  public void startGroupCall()
  {
    if (this.a != null)
    {
      String[] arrayOfString = (String[])n.a(String.class, this.a.getParticipants(), h.a);
      ((com.viber.voip.analytics.story.b.a.h)this.e.get()).a(h.a.i().b(arrayOfString).a(this.d).b("Group Audio Call").c(true).a());
    }
    this.b.startGroupCall();
  }

  public void startGroupCallWithoutFailedParticipants()
  {
    this.b.startGroupCallWithoutFailedParticipants();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.list.BaseGroupCallParticipantsPresenterImpl
 * JD-Core Version:    0.6.2
 */