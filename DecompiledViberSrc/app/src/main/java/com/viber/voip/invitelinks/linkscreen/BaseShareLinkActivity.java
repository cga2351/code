package com.viber.voip.invitelinks.linkscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.viber.common.d.c;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.m.c;
import com.viber.common.dialogs.z;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.l;
import com.viber.voip.util.cj;
import com.viber.voip.util.co;
import com.viber.voip.util.dj;

public abstract class BaseShareLinkActivity<V extends ScreenView, P extends BaseShareLinkPresenter<V>> extends ViberFragmentActivity
  implements View.OnClickListener, m.c, ScreenView
{
  protected final Logger a = ViberEnv.getLogger(getClass());
  protected P b;
  protected FragmentManager c;
  protected TextView d;
  protected TextView e;
  protected TextView f;
  protected TextView g;
  protected ViewStub h;

  private String a(Bundle paramBundle)
  {
    if (paramBundle == null)
      return null;
    return paramBundle.getString("share_entry_point_extra_key");
  }

  private void a(a.a parama, ScreenView.Error paramError)
  {
    parama.a(paramError).a(this).a(this.c);
  }

  protected abstract P a(InviteLinkData paramInviteLinkData, dagger.a<com.viber.voip.messages.k> parama, g paramg, cj paramcj, com.viber.voip.analytics.g paramg1, String paramString);

  protected V a()
  {
    return this;
  }

  protected void a(FragmentManager paramFragmentManager, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    this.c = paramFragmentManager;
    if (paramBoolean)
      co.a(paramViewGroup.findViewById(R.id.share_group_link_header_container));
    this.d = ((TextView)paramViewGroup.findViewById(R.id.share_group_link_explanation));
    this.e = ((TextView)paramViewGroup.findViewById(R.id.share_group_link_group_link));
    this.e.setOnClickListener(this);
    paramViewGroup.findViewById(R.id.share_group_link_send_via_viber).setOnClickListener(this);
    paramViewGroup.findViewById(R.id.share_group_link_copy_link).setOnClickListener(this);
    this.f = ((TextView)paramViewGroup.findViewById(R.id.share_group_link_share_group));
    this.f.setOnClickListener(this);
    this.g = ((TextView)paramViewGroup.findViewById(R.id.share_group_link_revoke_link));
    this.g.setOnClickListener(this);
    this.h = ((ViewStub)paramViewGroup.findViewById(R.id.extra_actions));
    dj.a(this.e);
  }

  public void a(ScreenView.Error paramError)
  {
    if (b(paramError))
    {
      a(l.g(), paramError);
      return;
    }
    a(com.viber.voip.ui.dialogs.k.n(), paramError);
  }

  public void a(String paramString)
  {
    this.e.setText(paramString);
  }

  public void a(boolean paramBoolean)
  {
    if (z.c(this.c, DialogCode.D_PROGRESS) != null);
    for (boolean bool = true; paramBoolean == bool; bool = false)
      return;
    if (paramBoolean)
    {
      ad.b().b(true).a(this).a(this.c);
      return;
    }
    z.b(this.c, DialogCode.D_PROGRESS);
  }

  protected abstract boolean b(ScreenView.Error paramError);

  public void c(ScreenView.Error paramError)
  {
    a(ad.a(), paramError);
  }

  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i == R.id.share_group_link_group_link) || (i == R.id.share_group_link_share_group))
      this.b.l();
    do
    {
      return;
      if (i == R.id.share_group_link_send_via_viber)
      {
        this.b.k();
        return;
      }
      if (i == R.id.share_group_link_copy_link)
      {
        this.b.j();
        return;
      }
    }
    while (i != R.id.share_group_link_revoke_link);
    this.b.g();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_share_group_link);
    if (this.mIsTablet)
      dj.a(this, 0.65F, 0.75F, 0.65F, 0.75F, true);
    setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
    getSupportActionBar().b(true);
    InviteLinkData localInviteLinkData = InviteLinkData.restoreFrom(getIntent().getExtras());
    if (localInviteLinkData != null)
    {
      dagger.a locala = ViberApplication.getInstance().getLazyMessagesManager();
      com.viber.voip.analytics.g localg = com.viber.voip.analytics.g.a();
      String str = a(getIntent().getExtras());
      this.b = a(localInviteLinkData, locala, new g(localInviteLinkData.conversationId, new com.viber.voip.messages.conversation.m(localInviteLinkData.conversationType, this, getSupportLoaderManager(), locala)), cj.a(getApplicationContext()), localg, str);
      a(getSupportFragmentManager(), (ViewGroup)findViewById(R.id.root), c.a());
      this.b.a(a());
      if (paramBundle != null)
        this.b.a(paramBundle.getParcelable("presenter_state"));
      return;
    }
    finish();
  }

  protected void onDestroy()
  {
    super.onDestroy();
    this.b.a();
  }

  public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    if ((paramm.a(DialogCode.D_PROGRESS)) && (paramInt == -1000))
      this.b.i();
    Object localObject;
    do
    {
      return;
      localObject = paramm.d();
    }
    while (!(localObject instanceof ScreenView.Error));
    this.b.a((ScreenView.Error)localObject);
  }

  protected void onPause()
  {
    super.onPause();
    this.b.c();
  }

  protected void onResume()
  {
    super.onResume();
    this.b.b();
    this.b.e();
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    Parcelable localParcelable = this.b.a(isChangingConfigurations());
    if (localParcelable != null)
      paramBundle.putParcelable("presenter_state", localParcelable);
  }

  public boolean onSupportNavigateUp()
  {
    if (!super.onSupportNavigateUp())
      onBackPressed();
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.invitelinks.linkscreen.BaseShareLinkActivity
 * JD-Core Version:    0.6.2
 */