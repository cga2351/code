package com.viber.voip.g.a.a.a;

import android.content.Intent;
import android.os.Bundle;
import com.viber.voip.invitelinks.f;
import com.viber.voip.messages.forward.GroupReferralForwardInfo;
import com.viber.voip.messages.ui.forward.ForwardActivity;
import com.viber.voip.messages.ui.forward.ForwardPresenter;
import dagger.a;

public abstract class y extends ai
{
  static ForwardPresenter a(ForwardActivity paramForwardActivity, a<f> parama)
  {
    Bundle localBundle1 = paramForwardActivity.getIntent().getExtras();
    Bundle localBundle2;
    if (localBundle1 != null)
    {
      localBundle2 = localBundle1.getBundle("options");
      if (localBundle2 == null)
        break label50;
    }
    label50: for (GroupReferralForwardInfo localGroupReferralForwardInfo = (GroupReferralForwardInfo)localBundle2.getParcelable("group_referral_extra_info"); ; localGroupReferralForwardInfo = null)
    {
      return new ForwardPresenter(parama, localGroupReferralForwardInfo);
      localBundle2 = null;
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.a.a.y
 * JD-Core Version:    0.6.2
 */