package com.viber.voip.invitelinks.linkscreen;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.viber.common.d.c;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.messages.k;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.l;
import com.viber.voip.util.cj;
import com.viber.voip.util.dj;

public class ShareCommunityFollowerLinkActivity extends BaseShareLinkActivity<e, j>
  implements e
{
  private View i;
  private TextView j;
  private TextView k;
  private SwitchCompat l;
  private View m;

  public void D_()
  {
    l.m().a(this).a(this);
  }

  protected void a(FragmentManager paramFragmentManager, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    super.a(paramFragmentManager, paramViewGroup, paramBoolean);
    getSupportActionBar().b(R.string.join_community_link_msg_title);
    this.h.setLayoutResource(R.layout.members_can_share);
    this.h.inflate();
    this.i = paramViewGroup.findViewById(R.id.members_can_share_trigger);
    this.i.setOnClickListener(this);
    this.l = ((SwitchCompat)paramViewGroup.findViewById(R.id.checker));
    this.j = ((TextView)paramViewGroup.findViewById(R.id.title));
    this.k = ((TextView)paramViewGroup.findViewById(R.id.summary));
    this.m = paramViewGroup.findViewById(R.id.members_can_share_trigger_divider);
    this.d.setText(R.string.join_community_link_msg);
    this.f.setText(R.string.join_community_link_msg_title);
    this.g.setText(R.string.disable_community_link);
    this.j.setText(R.string.member_can_share_trigger_title);
    this.k.setText(c.b(getString(R.string.member_can_share_trigger_summary)));
  }

  protected j b(InviteLinkData paramInviteLinkData, dagger.a<k> parama, g paramg, cj paramcj, com.viber.voip.analytics.g paramg1, String paramString)
  {
    return new j(paramInviteLinkData, paramg, new i(this), new f(this, paramg1, paramString), ((k)parama.get()).u(), paramcj);
  }

  public void b()
  {
    l.l().a(this).a(this.c);
  }

  public void b(boolean paramBoolean)
  {
    dj.b(this.i, paramBoolean);
    dj.b(this.m, paramBoolean);
  }

  protected boolean b(ScreenView.Error paramError)
  {
    return ((paramError.operation == 0) && (paramError.status == 3)) || (((paramError.operation == 1) || (paramError.operation == 2)) && (paramError.status == 4));
  }

  public void c(boolean paramBoolean)
  {
    this.l.setChecked(paramBoolean);
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default:
    case 100:
    }
    do
      return;
    while (paramInt2 != -1);
    setResult(-1);
    finish();
  }

  public void onClick(View paramView)
  {
    if (R.id.members_can_share_trigger == paramView.getId())
    {
      ((j)this.b).c(false);
      return;
    }
    super.onClick(paramView);
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    boolean bool = true;
    if (paramm.a(DialogCode.D280f))
    {
      j localj = (j)this.b;
      if (paramInt == -1)
        localj.b(bool);
    }
    do
    {
      return;
      bool = false;
      break;
      if (!paramm.a(DialogCode.D1034))
        break label65;
    }
    while (paramInt != -1);
    ((j)this.b).c(bool);
    return;
    label65: super.onDialogAction(paramm, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.invitelinks.linkscreen.ShareCommunityFollowerLinkActivity
 * JD-Core Version:    0.6.2
 */