package com.viber.voip.contacts.ui;

import com.viber.jni.Engine;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.contacts.b.b;
import com.viber.voip.h.a;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.k;
import com.viber.voip.ui.ac;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.cj;
import com.viber.voip.util.da;
import java.util.Set;

public class ba extends s
  implements ParticipantSelector.c
{
  public void a()
  {
    ViberApplication.getInstance().showToast(R.string.invite_5_contacts);
  }

  protected boolean canAddCustomNumber()
  {
    return false;
  }

  protected ParticipantSelector createParticipantSelector()
  {
    bb localbb = new bb(getActivity(), av.a(av.e.a), av.a(av.e.f), av.a(av.e.d), this, UserManager.from(getActivity()).getRegistrationValues(), (s.a)getActivity(), o.a(), a.b(), ViberApplication.getInstance().getEngine(false).getOnlineUserActivityHelper(), ViberApplication.getInstance().getMessagesManager().d(), ViberApplication.getInstance().getMessagesManager().z(), ab.b(), ak.a(), true, 6, this.mMessagesTracker);
    localbb.a(this);
    return localbb;
  }

  protected void handleDone()
  {
    if ((getActivity() != null) && (this.mSearchMediator != null))
      this.mSearchMediator.i();
    final long l = getGroupId();
    Set localSet = this.mParticipantSelector.a(new ParticipantSelector.b()
    {
      public boolean isParticipantValid(ParticipantSelector.Participant paramAnonymousParticipant, ParticipantSelector.a paramAnonymousa)
      {
        return (l <= 0L) || (!paramAnonymousa.c);
      }
    });
    if ((localSet.size() == 0) || (!cj.a(true)))
      return;
    ((PublicGroupInviteContactsListActivity)getActivity()).a(localSet);
  }

  protected void updateEmptyScreen()
  {
    x localx = this.mActivityWrapper;
    b.b localb = b.b.b;
    int i = this.mSyncState;
    if (!da.a(this.mSearchMediator.a()));
    for (boolean bool = true; ; bool = false)
    {
      localx.a(localb, i, true, bool, false);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.ba
 * JD-Core Version:    0.6.2
 */