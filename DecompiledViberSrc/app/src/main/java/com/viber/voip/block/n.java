package com.viber.voip.block;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.viber.common.dialogs.h.a;
import com.viber.jni.Engine;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.contacts.b.b;
import com.viber.voip.contacts.ui.ParticipantSelector;
import com.viber.voip.contacts.ui.ParticipantSelector.f;
import com.viber.voip.contacts.ui.s;
import com.viber.voip.contacts.ui.s.a;
import com.viber.voip.h.a;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.k;
import com.viber.voip.ui.dialogs.r;
import com.viber.voip.user.UserManager;
import java.util.ArrayList;

public class n extends s
{
  protected int countParticipantsForDoneButton()
  {
    return this.mParticipantSelector.a(false);
  }

  protected ParticipantSelector createParticipantSelector()
  {
    return new ParticipantSelector(getActivity(), av.a(av.e.a), av.a(av.e.f), av.a(av.e.d), this, UserManager.from(getActivity()).getRegistrationValues(), (s.a)getActivity(), o.a(), a.b(), ViberApplication.getInstance().getEngine(false).getOnlineUserActivityHelper(), ViberApplication.getInstance().getMessagesManager().d(), ViberApplication.getInstance().getMessagesManager().z(), ab.b(), ak.a(), -1, false, true, getChatOrigin(getArguments()), this.mMessagesTracker, ParticipantSelector.f.a);
  }

  protected void ensureContactIsNotBlocked(com.viber.voip.model.c paramc, g.a parama)
  {
    parama.a(g.a(paramc));
  }

  protected b.b getContactsLoaderMode()
  {
    return b.b.b;
  }

  protected int getContactsPermissionString()
  {
    return R.string.block_list_permission_description;
  }

  protected int getMinCheckedParticipantsCountForDoneButton()
  {
    return 0;
  }

  protected void handleDone()
  {
    Intent localIntent = new Intent();
    localIntent.putParcelableArrayListExtra("added_participants", new ArrayList(this.mParticipantSelector.f()));
    localIntent.putParcelableArrayListExtra("removed_participants", new ArrayList(this.mParticipantSelector.h()));
    getActivity().setResult(-1, localIntent);
    getActivity().finish();
  }

  protected boolean isAllowUncheckDisabled()
  {
    return true;
  }

  public void onParticipantAlreadyAdded(String paramString)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
      r.a(com.viber.common.d.c.a(paramString)).a(localFragmentActivity);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.block.n
 * JD-Core Version:    0.6.2
 */