package com.viber.voip.publicaccount.ui.screen.info;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.viber.common.dialogs.z;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.ViberApplication;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.t;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.conversation.adapter.n;
import com.viber.voip.messages.conversation.adapter.q;
import com.viber.voip.messages.conversation.adapter.y;
import com.viber.voip.messages.conversation.l.a;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.k;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.ui.holders.name.b;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.r;
import com.viber.voip.util.cj;
import java.util.HashSet;
import java.util.Set;

public class PublicAccountEditFragment extends a
  implements l.a, com.viber.voip.publicaccount.ui.holders.bottom.edit.a.a, com.viber.voip.publicaccount.ui.holders.d
{
  private final Set<String> Q = new HashSet();
  private int R = -1;
  private bv.t S = new bv.t()
  {
    public void onPublicGroupInfoChanged(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      if (PublicAccountEditFragment.a(PublicAccountEditFragment.this) == paramAnonymousInt1)
      {
        z.a(PublicAccountEditFragment.this, DialogCode.D_PROGRESS);
        PublicAccountEditFragment.a(PublicAccountEditFragment.this, -1);
      }
      switch (paramAnonymousInt2)
      {
      default:
        return;
      case 1:
      }
      av.a(av.e.a).postDelayed(new Runnable()
      {
        public void run()
        {
          PublicAccountEditFragment.b(PublicAccountEditFragment.this);
        }
      }
      , 100L);
    }
  };

  private PublicAccount P()
  {
    PublicAccount localPublicAccount = new PublicAccount(this.J);
    this.K.a(localPublicAccount);
    return localPublicAccount;
  }

  public n N()
  {
    return new y(getActivity(), this.I, true);
  }

  public void V_()
  {
    if ((this.Q.isEmpty()) && (this.J != null))
    {
      PublicAccount localPublicAccount = P();
      if (this.J.equalsBetweenAttributesChangedFlags(localPublicAccount))
        finish();
      while (!cj.a(true))
        return;
      int i = this.J.diffBetweenAttributesChangedFlags(localPublicAccount);
      this.R = ViberApplication.getInstance().getEngine(true).getPhoneController().generateSequence();
      o.a().a(this.S);
      ad.b().b(this);
      ViberApplication.getInstance().getMessagesManager().d().a(this.R, i, localPublicAccount);
      return;
    }
    r.q().b(this);
  }

  protected a.b a(Context paramContext, int paramInt, com.viber.voip.ui.a.a parama)
  {
    return new a(this, paramInt, parama, this, this);
  }

  protected void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity)
  {
    if (this.J == null)
    {
      this.J = new PublicAccount(this.I);
      return;
    }
    this.J.updateYourChatSolutionData(this.I);
  }

  public void a(com.viber.voip.publicaccount.ui.holders.c paramc, boolean paramBoolean)
  {
    String str = paramc.getClass().getName();
    if (!paramBoolean)
    {
      this.Q.add(str);
      return;
    }
    this.Q.remove(str);
  }

  public void b()
  {
    super.b();
  }

  protected void b(boolean paramBoolean)
  {
    if ((this.J != null) && (this.J.hasPublicChat()))
      super.b(paramBoolean);
    while (this.K.getItemCount() != 0)
      return;
    com.viber.voip.messages.conversation.adapter.m localm = new com.viber.voip.messages.conversation.adapter.m(null);
    localm.a(new q(5));
    localm.a(new q(6));
    this.K.a(localm);
  }

  protected boolean l()
  {
    return false;
  }

  protected boolean m()
  {
    return false;
  }

  public boolean onBackPressed()
  {
    if (this.J == null)
      return super.onBackPressed();
    PublicAccount localPublicAccount = P();
    if (this.J.equalsBetweenAttributesChangedFlags(localPublicAccount))
      return super.onBackPressed();
    r.s().a(this).b(this);
    return true;
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
    paramMenuInflater.inflate(R.menu.menu_pa_edit, paramMenu);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    setHasOptionsMenu(true);
    return paramLayoutInflater.inflate(R.layout.group_info_old_layout, paramViewGroup, false);
  }

  public void onDestroy()
  {
    super.onDestroy();
    o.a().b(this.S);
  }

  public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    super.onDialogAction(paramm, paramInt);
    if ((paramm.a(DialogCode.D2109)) && (-1 == paramInt))
      finish();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == R.id.menu_save)
    {
      V_();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  protected static class a extends a.b
  {
    private final Fragment f;
    private final com.viber.voip.publicaccount.ui.holders.bottom.edit.a.a g;
    private final com.viber.voip.publicaccount.ui.holders.d h;
    private final com.viber.voip.messages.controller.publicaccount.d i;
    private final bv j;

    public a(Fragment paramFragment, int paramInt, com.viber.voip.ui.a.a parama, com.viber.voip.publicaccount.ui.holders.bottom.edit.a.a parama1, com.viber.voip.publicaccount.ui.holders.d paramd)
    {
      super(paramInt, parama, paramFragment.getLayoutInflater());
      this.f = paramFragment;
      this.g = parama1;
      this.h = paramd;
      this.i = ViberApplication.getInstance().getMessagesManager().h();
      this.j = o.a();
    }

    protected a.c a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, com.viber.voip.publicaccount.ui.holders.c[] paramArrayOfc)
    {
      return new a.c(paramLayoutInflater.inflate(R.layout.layout_public_account_edit_header, paramViewGroup, false), paramArrayOfc);
    }

    protected a.c b(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, com.viber.voip.publicaccount.ui.holders.c[] paramArrayOfc)
    {
      return new a.c(paramLayoutInflater.inflate(R.layout.layout_public_account_edit_footer, paramViewGroup, false), paramArrayOfc);
    }

    protected com.viber.voip.publicaccount.ui.holders.c[] l()
    {
      com.viber.voip.publicaccount.ui.holders.name.a locala = new com.viber.voip.publicaccount.ui.holders.name.a(this.f);
      com.viber.voip.publicaccount.ui.holders.c[] arrayOfc = new com.viber.voip.publicaccount.ui.holders.c[4];
      arrayOfc[0] = new com.viber.voip.publicaccount.ui.holders.icon.a(this.f, this.h, true);
      arrayOfc[1] = new com.viber.voip.publicaccount.ui.holders.publication.a(this.f, this.h);
      arrayOfc[2] = new b(this.f.getContext(), this.h, locala, true);
      arrayOfc[3] = new com.viber.voip.publicaccount.ui.holders.general.edit.c(this.f, this.h);
      return arrayOfc;
    }

    protected com.viber.voip.publicaccount.ui.holders.c[] m()
    {
      com.viber.voip.publicaccount.ui.holders.c[] arrayOfc = new com.viber.voip.publicaccount.ui.holders.c[5];
      arrayOfc[0] = new com.viber.voip.publicaccount.ui.holders.separator.a();
      arrayOfc[1] = new com.viber.voip.publicaccount.ui.holders.background.a(this.f, this.h);
      arrayOfc[2] = new com.viber.voip.publicaccount.ui.holders.restriction.age.a(false);
      arrayOfc[3] = new com.viber.voip.publicaccount.ui.holders.chatsolution.edit.a(this.f, this.i, this.j);
      arrayOfc[4] = new com.viber.voip.publicaccount.ui.holders.bottom.edit.a(this.g, this.h);
      return arrayOfc;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.screen.info.PublicAccountEditFragment
 * JD-Core Version:    0.6.2
 */