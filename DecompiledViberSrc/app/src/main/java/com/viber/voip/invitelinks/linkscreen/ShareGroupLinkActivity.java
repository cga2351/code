package com.viber.voip.invitelinks.linkscreen;

import android.support.v4.app.FragmentManager;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m;
import com.viber.voip.R.string;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.l;
import com.viber.voip.util.cj;
import dagger.a;

public class ShareGroupLinkActivity extends BaseShareLinkActivity<ScreenView, k>
  implements ScreenView
{
  protected void a(FragmentManager paramFragmentManager, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    super.a(paramFragmentManager, paramViewGroup, paramBoolean);
    setActionBarTitle(R.string.share_group_link);
    this.d.setText(R.string.link_explanation_text);
    this.f.setText(R.string.share_group);
    this.g.setText(R.string.disable_group_link);
  }

  protected k b(InviteLinkData paramInviteLinkData, a<com.viber.voip.messages.k> parama, g paramg, cj paramcj, com.viber.voip.analytics.g paramg1, String paramString)
  {
    return new k(paramInviteLinkData, paramg, new i(this), new h(this, paramg1), ((com.viber.voip.messages.k)parama.get()).s(), paramcj);
  }

  public void b()
  {
    l.j().a(this).a(this.c);
  }

  protected boolean b(ScreenView.Error paramError)
  {
    return ((paramError.operation == 0) && (paramError.status == 1)) || (((paramError.operation == 1) || (paramError.operation == 2)) && (paramError.status == 4));
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    if (paramm.a(DialogCode.D280c))
    {
      k localk = (k)this.b;
      if (paramInt == -1);
      for (boolean bool = true; ; bool = false)
      {
        localk.b(bool);
        return;
      }
    }
    super.onDialogAction(paramm, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.invitelinks.linkscreen.ShareGroupLinkActivity
 * JD-Core Version:    0.6.2
 */