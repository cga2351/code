package com.viber.voip.messages.ui.forward;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.z;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.messages.forward.GroupReferralForwardInfo;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;

public class d extends com.viber.voip.mvp.core.d<ForwardPresenter>
  implements c
{
  private final FragmentActivity a;
  private final a b;

  public d(ForwardPresenter paramForwardPresenter, View paramView, FragmentActivity paramFragmentActivity, a parama)
  {
    super(paramForwardPresenter, paramView);
    this.a = paramFragmentActivity;
    this.b = parama;
  }

  public void a(Intent paramIntent)
  {
    this.b.a(paramIntent);
  }

  public void a(Intent paramIntent, GroupReferralForwardInfo paramGroupReferralForwardInfo)
  {
    paramIntent.setExtrasClassLoader(ConversationData.class.getClassLoader());
    Bundle localBundle = (Bundle)paramIntent.getParcelableExtra("options");
    if ((localBundle != null) && (paramGroupReferralForwardInfo != null))
      localBundle.putParcelable("group_referral_extra_info", paramGroupReferralForwardInfo);
    a(paramIntent);
  }

  public void a(Bundle paramBundle)
  {
    GroupReferralForwardInfo localGroupReferralForwardInfo = ((ForwardPresenter)this.mPresenter).f();
    if (localGroupReferralForwardInfo != null)
      paramBundle.putParcelable("group_referral_extra_info", localGroupReferralForwardInfo);
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ad.b().a(this.a);
      return;
    }
    z.a(this.a.getSupportFragmentManager(), DialogCode.D_PROGRESS);
  }

  public void b(Intent paramIntent)
  {
    ((ForwardPresenter)this.mPresenter).a(paramIntent);
  }

  public static abstract interface a
  {
    public abstract void a(Intent paramIntent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.forward.d
 * JD-Core Version:    0.6.2
 */