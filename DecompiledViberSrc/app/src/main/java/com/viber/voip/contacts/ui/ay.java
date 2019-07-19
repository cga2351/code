package com.viber.voip.contacts.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.c;
import com.viber.jni.Engine;
import com.viber.voip.ViberApplication;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.h.a;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.k;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.r;
import com.viber.voip.user.UserManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class ay extends s
  implements m.c
{
  public static ay a(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("allow_uncheck_disabled", paramBoolean);
    ay localay = new ay();
    localay.setArguments(localBundle);
    return localay;
  }

  protected ParticipantSelector createParticipantSelector()
  {
    return new bb(getActivity(), av.a(av.e.a), av.a(av.e.f), av.a(av.e.d), this, UserManager.from(getActivity()).getRegistrationValues(), (s.a)getActivity(), o.a(), a.b(), ViberApplication.getInstance().getEngine(false).getOnlineUserActivityHelper(), ViberApplication.getInstance().getMessagesManager().d(), ViberApplication.getInstance().getMessagesManager().z(), ab.b(), ak.a(), 250, isAllowUncheckDisabled(), this.mMessagesTracker);
  }

  protected void handleDone()
  {
    if (isAllowUncheckDisabled())
    {
      Intent localIntent = new Intent();
      localIntent.putParcelableArrayListExtra("added_participants", new ArrayList(this.mParticipantSelector.f()));
      localIntent.putParcelableArrayListExtra("removed_participants", new ArrayList(this.mParticipantSelector.h()));
      getActivity().setResult(-1, localIntent);
      getActivity().finish();
    }
    Set localSet;
    do
    {
      return;
      final long l = getGroupId();
      localSet = this.mParticipantSelector.a(new ParticipantSelector.b()
      {
        public boolean isParticipantValid(ParticipantSelector.Participant paramAnonymousParticipant, ParticipantSelector.a paramAnonymousa)
        {
          return (l <= 0L) || (!paramAnonymousa.c);
        }
      });
    }
    while (localSet.size() == 0);
    if (localSet.size() > 1)
    {
      l.a locala2 = r.e();
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(localSet.size());
      locala2.b(-1, arrayOfObject2).a(this).b(this);
      return;
    }
    ParticipantSelector.Participant localParticipant = (ParticipantSelector.Participant)localSet.iterator().next();
    l.a locala1 = r.d();
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = localParticipant.getDisplayNameNotNull(getActivity());
    locala1.b(-1, arrayOfObject1).a(this).b(this);
  }

  protected boolean isAllowUncheckDisabled()
  {
    Bundle localBundle = getArguments();
    return (localBundle != null) && (localBundle.getBoolean("allow_uncheck_disabled"));
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    if ((paramm.a(DialogCode.D1005)) || (paramm.a(DialogCode.D1005a)))
    {
      if (paramInt == -1)
        a(this);
      return;
    }
    super.onDialogAction(paramm, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.ay
 * JD-Core Version:    0.6.2
 */