package com.viber.voip.messages.conversation.chatinfo.presentation;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.b.a.h.a;
import com.viber.voip.analytics.story.b.a.h.a.a;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.block.g;
import com.viber.voip.contacts.c.c.c.a;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.chatinfo.presentation.b.j;
import com.viber.voip.messages.conversation.ui.bm;
import com.viber.voip.messages.conversation.ui.presenter.DeleteConversationRelatedActionsPresenter;
import com.viber.voip.messages.k;
import com.viber.voip.permissions.e;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.call.CallInitiationId;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository.ConferenceAvailabilityListener;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository.ConferenceAvailabilityListener..CC;
import com.viber.voip.phone.viber.conference.model.OngoingConferenceCallModel;
import com.viber.voip.ui.GenericWebViewActivity;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.util.ViberActionRunner.ay;
import com.viber.voip.util.ViberActionRunner.bm;
import com.viber.voip.util.ViberActionRunner.n;
import com.viber.voip.util.ae;
import com.viber.voip.util.at;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;
import com.viber.voip.util.dj;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

public class o extends b
  implements c.a, j, ConferenceCallsRepository.ConferenceAvailabilityListener
{
  private static final Logger O = ViberEnv.getLogger();

  @Inject
  ICdrController H;

  @Inject
  com.viber.voip.contacts.c.c.b I;
  Uri J;
  a K;
  com.viber.voip.messages.conversation.chatinfo.presentation.a.a L;
  protected Menu M;

  @Inject
  com.viber.voip.analytics.story.d.c N;
  private bm P;
  private com.viber.common.permission.b Q;

  public o()
  {
    Pair[] arrayOfPair = new Pair[1];
    arrayOfPair[0] = com.viber.voip.permissions.m.a(130);
    this.Q = new e(this, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        default:
        case 130:
        }
        do
          return;
        while (!(paramAnonymousObject instanceof Bundle));
        Bundle localBundle = (Bundle)paramAnonymousObject;
        ViberActionRunner.bm.a(o.this.getActivity(), localBundle.getBoolean("is_wink"), localBundle.getLong("message_id"), o.this.G);
      }
    };
  }

  private void Q()
  {
    if (this.G != null)
    {
      at.d(getActivity(), Uri.parse(this.G.getBackgroundLandscape()));
      at.d(getActivity(), Uri.parse(this.G.getBackgroundPortrait()));
      this.b.d().a(this.G.getId(), this.G.getConversationType(), "", "");
      Toast.makeText(getActivity(), getString(R.string.conversation_info_bg_changed), 1).show();
    }
  }

  private void R()
  {
    int i = 1;
    MenuItem localMenuItem1;
    MenuItem localMenuItem2;
    MenuItem localMenuItem3;
    label90: boolean bool;
    int j;
    if (this.M != null)
    {
      localMenuItem1 = this.M.findItem(R.id.menu_add_participants);
      localMenuItem2 = this.M.findItem(R.id.menu_share_group_link);
      localMenuItem3 = this.M.findItem(R.id.menu_add_members);
      if (this.G == null)
        break label145;
      if (!this.G.isCommunityType())
        break label131;
      int m = com.viber.voip.messages.m.e(this.G);
      if (m != i)
        break label120;
      int n = i;
      if (m != 2)
        break label126;
      int i2 = n;
      bool = false;
      j = i2;
    }
    while (true)
    {
      dj.a(localMenuItem1, bool);
      dj.a(localMenuItem2, i);
      dj.a(localMenuItem3, j);
      return;
      label120: int i1 = 0;
      break;
      label126: i = 0;
      break label90;
      label131: bool = m();
      i = 0;
      int k = 0;
      continue;
      label145: i = 0;
      k = 0;
      bool = false;
    }
  }

  private void a(Uri paramUri1, Uri paramUri2)
  {
    if (this.G == null);
    while (true)
    {
      ViberApplication.getInstance().showToast(ViberApplication.getLocalizedResources().getString(R.string.conversation_info_bg_changed));
      return;
      if ((paramUri1 != null) && (paramUri2 != null) && ((!paramUri1.toString().equals(this.G.getBackgroundPortrait())) || (!paramUri2.toString().equals(this.G.getBackgroundLandscape()))))
        this.b.d().a(this.G.getId(), this.G.getConversationType(), paramUri1.toString(), paramUri2.toString());
    }
  }

  private void c(Map<Long, OngoingConferenceCallModel> paramMap)
  {
    if ((this.G != null) && (paramMap.containsKey(Long.valueOf(this.G.getId()))))
      this.L.notifyDataSetChanged();
  }

  private void d(String paramString)
  {
    if (this.G == null)
      return;
    this.m.a(ae.b(), this.G, paramString);
  }

  public void H()
  {
    this.y.f();
  }

  public void I()
  {
    this.A.b();
  }

  public void J()
  {
    Set localSet;
    if ((this.G != null) && (getActivity() != null))
    {
      Member localMember = Member.from(this.G);
      if (!da.a(localMember.getId()))
      {
        localSet = Collections.singleton(localMember);
        if (!g.a(localMember))
          break label88;
        g.a(getActivity(), localSet, this.G.getParticipantName(), this.G.isSecret(), new p(this));
        this.N.b(1.0D, "Chat Info");
      }
    }
    return;
    label88: g.a(getActivity(), localSet, this.G.getParticipantName(), false, new q(this), true, this.G.isSecret());
    this.y.m();
    this.N.a(1.0D, "Chat Info");
  }

  public void M()
  {
    int i;
    if ((this.G.isConversation1on1()) || (this.G.isOneToOneWithPublicAccount()))
      i = 2;
    while (true)
    {
      ViberActionRunner.ay.a(getContext(), this.G.getId(), i);
      return;
      if (this.G.isCommunityType())
        i = 4;
      else
        i = 3;
    }
  }

  protected void N()
  {
    if ((this.K != null) && (this.G != null))
    {
      onActivityResult(this.K.a, this.K.b, this.K.c);
      this.K = null;
    }
  }

  protected com.viber.voip.messages.conversation.chatinfo.presentation.a.a a(Context paramContext)
  {
    return new com.viber.voip.messages.conversation.chatinfo.presentation.a.a(getLayoutInflater(), new com.viber.voip.messages.conversation.chatinfo.presentation.b.h(paramContext, this, this.H), this.w);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    super.a(paramConversationItemLoaderEntity, paramBoolean);
    R();
    N();
  }

  public void a(com.viber.voip.messages.conversation.chatinfo.c.a<com.viber.voip.messages.conversation.chatinfo.d.d> parama)
  {
    this.L.a(parama);
  }

  public void a(Set<Member> paramSet, boolean paramBoolean)
  {
    if (this.y != null)
    {
      w localw = this.y;
      localw.getClass();
      runOnUiThread(r.a(localw));
    }
  }

  public void b(Set<Member> paramSet, boolean paramBoolean)
  {
    if (this.y != null)
    {
      w localw = this.y;
      localw.getClass();
      runOnUiThread(s.a(localw));
    }
  }

  public void c(String paramString)
  {
    ViberActionRunner.n.a(requireContext(), paramString);
  }

  public void f(boolean paramBoolean)
  {
    this.A.b(paramBoolean);
  }

  public void g(boolean paramBoolean)
  {
    this.A.a(paramBoolean);
  }

  public void h(boolean paramBoolean)
  {
    this.m.a(this.G.getParticipantMemberId(), "Contact Info Screen", 2);
    startActivity(com.viber.voip.messages.m.a(this.G.getParticipantMemberId(), this.G.getNumber(), dg.b(this.G), paramBoolean, false, false, false));
  }

  public void i(boolean paramBoolean)
  {
    this.y.a(paramBoolean);
  }

  public void j(boolean paramBoolean)
  {
    if ((this.G != null) && (this.G.isOneToOneWithPublicAccount()))
      a(this.G.getPublicAccountId(), paramBoolean);
  }

  protected com.viber.voip.messages.conversation.chatinfo.presentation.a.b o()
  {
    return this.L;
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (!isAdded())
    {
      this.K = new a();
      this.K.a = paramInt1;
      this.K.b = paramInt2;
      this.K.c = paramIntent;
      return;
    }
    if (paramInt2 == -1)
      switch (paramInt1)
      {
      default:
      case 2001:
      }
    while (true)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      if ("remove_conversation_background".equals(paramIntent.getAction()))
      {
        Q();
        d("Image Removed");
      }
      else if ("conversation_viber_background_set".equals(paramIntent.getAction()))
      {
        d("Gallery");
      }
      else if (paramIntent.getExtras() != null)
      {
        Uri localUri1 = Uri.parse(paramIntent.getStringExtra("portraitUri"));
        Uri localUri2 = Uri.parse(paramIntent.getStringExtra("landscapeUri"));
        d(paramIntent.getStringExtra("image_change_type"));
        a(localUri1, localUri2);
        if (this.J != null)
          this.J = null;
      }
    }
  }

  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    N();
    if (this.mIsTablet)
      setHasOptionsMenu(true);
    this.L = a(paramContext);
    this.P = new bm(paramContext, ViberApplication.getInstance().getChangePhoneNumberController().b(), this.i);
  }

  public void onConferenceMissedInProgress(OngoingConferenceCallModel paramOngoingConferenceCallModel, String paramString1, String paramString2)
  {
    ConferenceCallsRepository.ConferenceAvailabilityListener..CC.onConferenceMissedInProgress(this, paramOngoingConferenceCallModel, paramString1, paramString2);
  }

  public void onConferencesAvailable(Map<Long, OngoingConferenceCallModel> paramMap)
  {
    c(paramMap);
  }

  public void onConferencesUnavailable(Map<Long, OngoingConferenceCallModel> paramMap)
  {
    c(paramMap);
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof ViberFragmentActivity))
      ((ViberFragmentActivity)localFragmentActivity).setupAndShowPinDialog(this);
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenuInflater.inflate(R.menu.menu_conversation_info, paramMenu);
    this.M = paramMenu;
    R();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.group_info_old_layout, paramViewGroup, false);
    RecyclerView localRecyclerView = (RecyclerView)localView.findViewById(R.id.conversationInfo);
    DefaultItemAnimator localDefaultItemAnimator = new DefaultItemAnimator();
    localDefaultItemAnimator.setSupportsChangeAnimations(false);
    localRecyclerView.setItemAnimator(localDefaultItemAnimator);
    localRecyclerView.setAdapter(this.L);
    this.I.a(this);
    return localView;
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    this.I.b(this);
    this.P.a();
  }

  public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    if ((paramm.a(DialogCode.D1500)) || (paramm.a(DialogCode.D1500c)))
      switch (paramInt)
      {
      default:
      case -1:
      case -2:
      }
    do
    {
      return;
      CallInitiationId.noteNextCallInitiationAttemptId();
      com.viber.voip.analytics.story.b.a.h localh = (com.viber.voip.analytics.story.b.a.h)this.k.get();
      h.a.a locala = h.a.i();
      String[] arrayOfString = new String[1];
      arrayOfString[0] = this.G.getNumber();
      localh.b(locala.a(arrayOfString).a("Chat Info").b("Free Audio 1-On-1 Call").a(true).a());
      CallHandler localCallHandler = this.f.getCallHandler();
      localCallHandler.setNextCallIsFromSecretConversation(this.G.isSecret());
      localCallHandler.handleDialViber(Member.from(this.G), false);
      return;
      GenericWebViewActivity.a(getActivity(), ap.c().ai, getString(R.string.learn_more));
      return;
      if (!paramm.a(DialogCode.D_PIN))
        break;
    }
    while ((-1 != paramInt) && (-3 != paramInt));
    ai localai = this.b.c();
    long l = this.G.getId();
    if (!this.G.isHiddenConversation());
    for (boolean bool = true; ; bool = false)
    {
      localai.a(l, bool, true);
      return;
    }
    super.onDialogAction(paramm, paramInt);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    if (i == R.id.menu_add_participants)
    {
      a(1, "Participants List");
      return true;
    }
    if (i == R.id.menu_share_group_link)
    {
      this.y.k();
      return true;
    }
    if (i == R.id.menu_add_members)
    {
      b("Participants List");
      return true;
    }
    return false;
  }

  public void onPeerIdentityBreached(String paramString1, String paramString2, String paramString3)
  {
    if (this.L != null)
      this.L.notifyDataSetChanged();
  }

  public void onStart()
  {
    super.onStart();
    this.d.a(this.Q);
    ((ConferenceCallsRepository)this.j.get()).registerConferenceAvailabilityListener(this);
  }

  public void onStop()
  {
    super.onStop();
    this.d.b(this.Q);
    ((ConferenceCallsRepository)this.j.get()).unregisterConferenceAvailabilityListener(this);
  }

  protected void t()
  {
  }

  static class a
  {
    int a;
    int b;
    Intent c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.presentation.o
 * JD-Core Version:    0.6.2
 */