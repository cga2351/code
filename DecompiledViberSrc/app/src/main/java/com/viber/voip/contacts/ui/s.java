package com.viber.voip.contacts.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m.c;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.provider.d;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.contacts.adapters.h;
import com.viber.voip.contacts.b.a;
import com.viber.voip.contacts.b.b;
import com.viber.voip.contacts.c.d.n.a;
import com.viber.voip.invitelinks.f.a;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.ai.h;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.model.j;
import com.viber.voip.settings.d.p;
import com.viber.voip.ui.aa;
import com.viber.voip.ui.ac;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ViberActionRunner.af;
import com.viber.voip.util.cd;
import com.viber.voip.util.cj;
import com.viber.voip.util.dj;
import com.viber.voip.util.dr;
import com.viber.voip.util.dw;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.inject.Inject;

public class s extends aa
  implements m.c, n.a, com.viber.voip.invitelinks.linkscreen.g.a
{
  private static final long CLOSE_KEYBOARD_DELAY = 100L;
  public static final String KEY_CONVERSATION_ID = "conversationId";
  private static final Logger L = ViberEnv.getLogger();
  protected static final int MIN_NEW_BROADCAST_LIST_RECIPIENTS = 2;
  protected static final int MIN_NEW_COMMUNITY_RECIPIENTS = 0;
  private static final long NO_CONTACT_ID = -1L;
  public static final long NO_THREAD = -1L;
  protected aj mActionHost;

  @Inject
  dagger.a<com.viber.voip.invitelinks.f> mCommunityFollowerInviteLinksHelper;
  private int mComposeChatModeMultiple = 0;
  private com.viber.voip.contacts.b mContactsLoader;
  private dagger.a<com.viber.voip.contacts.c.d.g> mContactsManager;
  private com.viber.voip.contacts.adapters.n mContactsRecentListAdapter;
  private View mContactsSection;
  private long mConversationId;
  private com.viber.voip.invitelinks.linkscreen.g mConversationRepository;
  private final com.viber.common.permission.b mEmptyScreenPermissionListener;
  private boolean mExcludeMode = true;
  private long mGroupId;
  private int mGroupRole;
  private boolean mHideKeyboardDelayInProgress;
  private String mInvitationText;

  @Inject
  dagger.a<com.viber.voip.invitelinks.linkscreen.f> mLinkActionsInteractor;
  protected com.b.a.a.a mMergeAdapter;

  @Inject
  public com.viber.voip.analytics.story.e.c mMessagesTracker;
  private boolean mOpenNativeLinkShare;
  private boolean mOpenedForForward;
  protected Toast mParticipantsLimitToast;
  private com.viber.common.permission.c mPermissionManager;
  private ParticipantSelector.f mSelectorMode;
  private boolean mShareLinkOnConversationLoad;
  private View mSubAdapterHeaderSection;
  protected int mSyncState = -1;
  protected int mTotalParticipants = 250;

  public s()
  {
    Pair[] arrayOfPair = new Pair[1];
    arrayOfPair[0] = com.viber.voip.permissions.m.a(93);
    this.mEmptyScreenPermissionListener = new com.viber.voip.permissions.g(this, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
      }
    };
  }

  private void closeScreen()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
      localFragmentActivity.finish();
  }

  private ParticipantSelector.Participant[] contactToParticipants(com.viber.voip.model.c paramc)
  {
    boolean bool = getContactsLoaderMode().equals(b.b.b);
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = paramc.s().iterator();
    while (localIterator1.hasNext())
    {
      j localj = (j)localIterator1.next();
      localHashMap.put(localj.c(), ParticipantSelector.Participant.from(localj, paramc));
    }
    if (bool)
    {
      Iterator localIterator2 = paramc.t().iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        if (!localHashMap.containsKey(str))
          localHashMap.put(str, ParticipantSelector.Participant.from(Member.fromVln(str)));
      }
    }
    return (ParticipantSelector.Participant[])localHashMap.values().toArray(new ParticipantSelector.Participant[0]);
  }

  private ParticipantSelector.Participant findSelectedParticipant(com.viber.voip.model.c paramc)
  {
    Set localSet = this.mParticipantSelector.b(true);
    Iterator localIterator = paramc.s().iterator();
    while (localIterator.hasNext())
    {
      ParticipantSelector.Participant localParticipant = ParticipantSelector.Participant.from((j)localIterator.next(), paramc);
      if (localSet.contains(localParticipant))
        return localParticipant;
    }
    return null;
  }

  private boolean isBroadcastList()
  {
    return this.mComposeChatModeMultiple == 1;
  }

  private boolean isCommunity()
  {
    return this.mComposeChatModeMultiple == 2;
  }

  private void openNativeLinkShare(com.viber.voip.invitelinks.linkscreen.g paramg)
  {
    showLoading(true);
    ConversationItemLoaderEntity localConversationItemLoaderEntity = paramg.b();
    if ((localConversationItemLoaderEntity instanceof PublicGroupConversationItemLoaderEntity))
    {
      startLinkSharing((PublicGroupConversationItemLoaderEntity)localConversationItemLoaderEntity);
      return;
    }
    this.mShareLinkOnConversationLoad = true;
  }

  private void openShareGroupLink()
  {
    boolean bool = isCommunity();
    if (bool);
    for (int i = 5; ; i = 1)
    {
      ViberActionRunner.af.a(getActivity(), this.mGroupId, this.mConversationId, i, "Add Participants Screen", bool);
      return;
    }
  }

  private void showChooserForShareCommunityLink(CharSequence paramCharSequence)
  {
    Intent localIntent = ViberActionRunner.af.b(getContext(), this.mInvitationText);
    startActivity(dw.a(getContext(), localIntent, getString(R.string.share_group_link), "share_type_invite_community"));
  }

  private void showLoading(boolean paramBoolean)
  {
    dj.a(this, paramBoolean);
  }

  private void startLinkSharing(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity)
  {
    ((com.viber.voip.invitelinks.f)this.mCommunityFollowerInviteLinksHelper.get()).a(paramPublicGroupConversationItemLoaderEntity, true, new b(this));
  }

  protected boolean addSubAdapterHeader()
  {
    return false;
  }

  protected boolean canAddCustomNumber()
  {
    return true;
  }

  protected boolean canRemoveAddedParticipants()
  {
    return this.mExcludeMode;
  }

  protected boolean canRestoreSearch()
  {
    return (this.mOpenedForForward) && (this.mContactsLoader != null);
  }

  protected boolean considerHimself()
  {
    return (this.mComposeChatModeMultiple == 0) || (isCommunity());
  }

  protected com.viber.voip.contacts.adapters.n createParticipantAdapter()
  {
    h localh = new h(getActivity(), this.mIsTablet, this.mContactsLoader.w(), isAllowUncheckDisabled(), this.mContactsLoader.u(), getContactsLoaderMode().equals(b.b.b), getLayoutInflater());
    this.mMergeAdapter.a(localh);
    return localh;
  }

  protected d createParticipantLoader(boolean paramBoolean)
  {
    this.mContactsLoader = new com.viber.voip.contacts.b(5, getActivity(), getLoaderManager(), this.mContactsManager, this, getContactsLoaderMode());
    this.mContactsLoader.p();
    com.viber.voip.contacts.b localb = this.mContactsLoader;
    String[] arrayOfString = new String[1];
    arrayOfString[0] = ("conversationId:" + this.mConversationId);
    localb.b(arrayOfString);
    if (paramBoolean)
      this.mContactsLoader.b(getContactsLoaderMode());
    return this.mContactsLoader;
  }

  protected ParticipantSelector createParticipantSelector()
  {
    int j;
    int i;
    switch (this.mComposeChatModeMultiple)
    {
    default:
      if (this.mSelectorMode == ParticipantSelector.f.d)
      {
        j = 50;
        i = j + 250;
        label45: Bundle localBundle = getArguments();
        if (localBundle == null)
          break label212;
        this.mTotalParticipants = localBundle.getInt("max_participant_count", i);
        label66: if ((this.mSelectorMode != ParticipantSelector.f.a) || (!isCommunity()))
          break label220;
      }
      break;
    case 1:
    }
    label212: label220: for (ParticipantSelector.f localf = ParticipantSelector.f.b; ; localf = this.mSelectorMode)
    {
      return new ParticipantSelector(getActivity(), av.a(av.e.a), av.a(av.e.f), av.a(av.e.d), this, UserManager.from(getActivity()).getRegistrationValues(), (a)getActivity(), com.viber.voip.messages.controller.manager.o.a(), com.viber.voip.h.a.b(), ViberApplication.getInstance().getEngine(false).getOnlineUserActivityHelper(), ViberApplication.getInstance().getMessagesManager().d(), ViberApplication.getInstance().getMessagesManager().z(), ab.b(), ak.a(), this.mTotalParticipants, considerHimself(), getChatOrigin(getArguments()), this.mMessagesTracker, localf);
      i = 50;
      break label45;
      j = 0;
      break;
      this.mTotalParticipants = i;
      break label66;
    }
  }

  protected com.viber.voip.contacts.adapters.n createSubAdapter()
  {
    return new com.viber.voip.contacts.adapters.l(getActivity(), this.mIsTablet, this.mContactsLoader.v(), false, getLayoutInflater());
  }

  protected void ensureContactIsNotBlocked(com.viber.voip.model.c paramc, com.viber.voip.block.g.a parama)
  {
    com.viber.voip.block.g.a(getActivity(), paramc, parama);
  }

  protected ParticipantSelector.Participant findByPosition(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getAllContactsCount()));
    com.viber.voip.model.c localc;
    do
    {
      return null;
      localc = this.mContactsLoader.w().c(paramInt);
    }
    while (localc == null);
    return findSelectedParticipant(localc);
  }

  protected int findPosition(ParticipantSelector.Participant paramParticipant)
  {
    if (this.mContactsLoader == null);
    while (true)
    {
      return -1;
      b.a locala = this.mContactsLoader.w();
      int i = locala.getCount();
      for (int j = 0; j < i; j++)
      {
        ParticipantSelector.Participant[] arrayOfParticipant = contactToParticipants(locala.c(j));
        int k = arrayOfParticipant.length;
        for (int m = 0; m < k; m++)
          if (arrayOfParticipant[m].equals(paramParticipant))
            return j;
      }
    }
  }

  protected ListAdapter getAdapter()
  {
    return this.mMergeAdapter;
  }

  protected int getAllContactsCount()
  {
    if (this.mContactsLoader != null)
      return this.mContactsLoader.w().getCount();
    return 0;
  }

  protected b.b getContactsLoaderMode()
  {
    return b.b.d;
  }

  public long getConversationId()
  {
    return this.mConversationId;
  }

  public long getGroupId()
  {
    return this.mGroupId;
  }

  protected int getMinCheckedParticipantsCountForDoneButton()
  {
    if ((isBroadcastList()) && (this.mConversationId <= 0L))
      return 2;
    if ((isCommunity()) && (this.mConversationId <= 0L))
      return 0;
    return super.getMinCheckedParticipantsCountForDoneButton();
  }

  protected int getSubAdapterCount()
  {
    return this.mContactsLoader.v().getCount();
  }

  protected String getSubAdapterHeaderText()
  {
    return getString(R.string.recent_section_title);
  }

  protected void handleArguments(Bundle paramBundle)
  {
    int i = 1;
    if (paramBundle == null);
    ArrayList localArrayList;
    label241: 
    do
    {
      int j;
      boolean bool2;
      do
      {
        return;
        j = paramBundle.getInt("participants_count", 0);
        this.mConversationId = paramBundle.getLong("thread_id", -1L);
        this.mGroupId = paramBundle.getLong("extra_group_id", 0L);
        this.mInvitationText = paramBundle.getString("share_text");
        boolean bool1 = paramBundle.getBoolean("can_share_group_link");
        this.mOpenNativeLinkShare = paramBundle.getBoolean("open_native_link_share");
        this.mGroupRole = paramBundle.getInt("group_role");
        bool2 = paramBundle.getBoolean("ignore_participants", false);
        this.mActivityWrapper.a(this.mGroupId);
        this.mActivityWrapper.b(bool1);
        this.mActivityWrapper.c(isBroadcastList());
        this.mActivityWrapper.a(isCommunity(), R.string.new_community_explanation, null);
        if (this.mOpenNativeLinkShare)
          showLoading(false);
      }
      while (bool2);
      localArrayList = paramBundle.getParcelableArrayList("already_added_participants");
      if (((this.mConversationId > 0L) && (j > i)) || ((localArrayList != null) && (localArrayList.size() > 0)))
        if (localArrayList != null)
          break label241;
      while (true)
      {
        this.mExcludeMode = i;
        if (this.mConversationId <= 0L)
          break;
        ViberApplication.getInstance().getMessagesManager().c().a(this.mConversationId, new ai.h()
        {
          public void a(Map<com.viber.voip.model.entity.m, com.viber.voip.model.entity.l> paramAnonymousMap)
          {
            HashMap localHashMap = new HashMap(paramAnonymousMap.size());
            Iterator localIterator = paramAnonymousMap.entrySet().iterator();
            while (localIterator.hasNext())
            {
              Map.Entry localEntry = (Map.Entry)localIterator.next();
              localHashMap.put(ParticipantSelector.Participant.from((com.viber.voip.model.entity.m)localEntry.getKey()), localEntry.getValue());
            }
            s.this.onParticipantsReady(localHashMap, s.this.mGroupRole);
          }
        });
        return;
        i = 0;
      }
    }
    while (localArrayList == null);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      ParticipantSelector.Participant localParticipant = (ParticipantSelector.Participant)localIterator.next();
      com.viber.voip.model.entity.l locall = new com.viber.voip.model.entity.l();
      locall.a(0);
      localHashMap.put(localParticipant, locall);
    }
    onParticipantsReady(localHashMap, this.mGroupRole);
  }

  protected void handleDone()
  {
    long l = 0L;
    final boolean bool1 = isBroadcastList();
    final boolean bool2 = isCommunity();
    if ((!isCommunity()) || (this.mGroupId > l));
    for (int i = 1; ; i = 0)
    {
      if (((bool1) || (bool2) || (cj.a(true))) && (!this.mHideKeyboardDelayInProgress) && (!this.mParticipantSelector.l()))
      {
        this.mHideKeyboardDelayInProgress = true;
        if (i != 0)
          this.mSearchMediator.i();
        Set localSet = this.mParticipantSelector.g();
        if (localSet.size() > 0)
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("group_id", this.mGroupId);
          localIntent.putParcelableArrayListExtra("selected_admins", new ArrayList(localSet));
          dj.d(getActivity());
          getActivity().setResult(-1, localIntent);
        }
        int j = this.mParticipantSelector.f().size();
        if ((!bool2) && (j == 0))
          closeScreen();
        com.viber.voip.analytics.g.a().c().g().a(this.mConversationId, j);
        Handler localHandler = this.mUiHandler;
        Runnable local4 = new Runnable()
        {
          public void run()
          {
            s.access$402(s.this, false);
            if (s.this.getActivity() != null)
            {
              if (bool1)
                s.this.mParticipantSelector.a(s.this.mConversationId);
            }
            else
              return;
            s.this.mParticipantSelector.a(s.this.mGroupId, s.this.mGroupRole, bool2);
          }
        };
        if (i != 0)
          l = 100L;
        localHandler.postDelayed(local4, l);
      }
      return;
    }
  }

  protected x inflateEmptyStub(View paramView)
  {
    if (this.mOpenedForForward)
      return new am(paramView, this.mPermissionManager, this.mParticipantSelector);
    return new x(paramView, this.mPermissionManager);
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.mMergeAdapter = new com.b.a.a.a();
    if (!this.mOpenedForForward)
    {
      this.mContactsRecentListAdapter = createSubAdapter();
      if (addSubAdapterHeader())
      {
        this.mMergeAdapter.a(this.mSubAdapterHeaderSection);
        this.mMergeAdapter.b(this.mSubAdapterHeaderSection, false);
      }
      this.mMergeAdapter.a(this.mContactsRecentListAdapter);
      this.mMergeAdapter.a(this.mContactsSection);
      this.mMergeAdapter.b(this.mContactsSection, false);
      if ((isCommunity()) && (this.mConversationId > 0L))
      {
        this.mConversationRepository = new com.viber.voip.invitelinks.linkscreen.g(this.mConversationId, new com.viber.voip.messages.conversation.m(5, getContext(), getLoaderManager(), ViberApplication.getInstance().getLazyMessagesManager()));
        this.mConversationRepository.a(this);
      }
    }
    if (!this.mPermissionManager.a(com.viber.voip.permissions.n.j))
      av.a(av.e.a).postDelayed(new Runnable()
      {
        public void run()
        {
          if (s.this.mSearchMediator != null)
            s.this.mSearchMediator.i();
        }
      }
      , 300L);
  }

  public void onAttach(Activity paramActivity)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramActivity);
    if (!(paramActivity instanceof a))
      throw new ClassCastException("Activity must implement fragment's callbacks." + paramActivity);
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.sync_contact_btn)
      this.mActionHost.b();
    do
    {
      return;
      if (i == R.id.invite_contact_btn)
      {
        startActivity(new Intent("com.viber.voip.action.INVITE_TO_VIBER"));
        return;
      }
      if (i == R.id.sync_retry)
      {
        this.mActionHost.b();
        return;
      }
      if (i != R.id.share_group_link)
        break label99;
      if ((!isCommunity()) || (!this.mOpenNativeLinkShare))
        break;
    }
    while (this.mConversationRepository == null);
    openNativeLinkShare(this.mConversationRepository);
    return;
    openShareGroupLink();
    return;
    label99: if (i == R.id.button_request_permission)
    {
      this.mPermissionManager.a(this, 93, com.viber.voip.permissions.n.j);
      return;
    }
    if (paramView.getId() == R.id.community_share_link)
    {
      showChooserForShareCommunityLink(((TextView)paramView).getText());
      return;
    }
    super.onClick(paramView);
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    View localView = getView();
    if (localView != null)
      localView.invalidate();
  }

  public void onConversationDeleted()
  {
    closeScreen();
  }

  public void onConversationReceived(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if (paramConversationItemLoaderEntity.isCommunityBlocked())
      closeScreen();
    do
    {
      do
        return;
      while ((!paramConversationItemLoaderEntity.isCommunityType()) || (!this.mShareLinkOnConversationLoad));
      this.mShareLinkOnConversationLoad = false;
    }
    while (!(paramConversationItemLoaderEntity instanceof PublicGroupConversationItemLoaderEntity));
    startLinkSharing((PublicGroupConversationItemLoaderEntity)paramConversationItemLoaderEntity);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mActionHost = new aj(getActivity());
    this.mContactsManager = ViberApplication.getInstance().getLazyContactManager();
    this.mPermissionManager = com.viber.common.permission.c.a(getActivity());
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.mOpenedForForward = localBundle.getBoolean("open_for_forward", false);
      this.mComposeChatModeMultiple = localBundle.getInt("compose_chat_mode_multiple", 0);
      this.mSelectorMode = ParticipantSelector.f.values()[localBundle.getInt("extra_participants_selector_mode")];
    }
  }

  public void onDestroy()
  {
    if (this.mConversationRepository != null)
      this.mConversationRepository.d();
    this.mContactsLoader.q();
    this.mContactsLoader.j();
    super.onDestroy();
  }

  public void onDestroyView()
  {
    removeRequestLayoutListViewCallbacks();
    super.onDestroyView();
  }

  public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    if (paramm.a(DialogCode.D108));
    switch (paramInt)
    {
    default:
      return;
    case -1:
    }
    this.mActionHost.b();
  }

  public void onListItemClick(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    m localm = (m)paramView.getTag();
    if (localm == null);
    com.viber.voip.model.c localc;
    do
    {
      return;
      localc = localm.a();
    }
    while ((localc == null) || (localc.getId() == -1L) || ((getContactsLoaderMode().equals(b.b.d)) && (localc.n() == null)) || (!cj.a(true)) || (!(localm instanceof com.viber.voip.contacts.adapters.g.a)));
    ensureContactIsNotBlocked(localc, new u(this, localm));
  }

  public void onLoadFinished(d paramd, boolean paramBoolean)
  {
    boolean bool1 = true;
    super.onLoadFinished(paramd, paramBoolean);
    boolean bool2;
    com.b.a.a.a locala1;
    View localView1;
    if (!this.mOpenedForForward)
    {
      if (addSubAdapterHeader())
      {
        com.b.a.a.a locala2 = this.mMergeAdapter;
        View localView2 = this.mSubAdapterHeaderSection;
        if (getSubAdapterCount() <= 0)
          break label92;
        bool2 = bool1;
        locala2.b(localView2, bool2);
      }
      locala1 = this.mMergeAdapter;
      localView1 = this.mContactsSection;
      if (getSubAdapterCount() <= 0)
        break label98;
    }
    while (true)
    {
      locala1.b(localView1, bool1);
      if (isAdded())
        requestLayoutListViewWithDelay();
      return;
      label92: bool2 = false;
      break;
      label98: bool1 = false;
    }
  }

  public void onPause()
  {
    ((com.viber.voip.contacts.c.d.g)this.mContactsManager.get()).e().b(this);
    super.onPause();
  }

  public boolean onQueryTextChange(String paramString)
  {
    boolean bool = super.onQueryTextChange(paramString);
    if (bool)
      this.mContactsLoader.a(paramString, dr.a(paramString), this.mConversationId);
    return bool;
  }

  public void onResume()
  {
    super.onResume();
    ((com.viber.voip.contacts.c.d.g)this.mContactsManager.get()).e().a(this);
  }

  public void onStart()
  {
    super.onStart();
    this.mPermissionManager.a(this.mEmptyScreenPermissionListener);
  }

  public void onStop()
  {
    super.onStop();
    this.mPermissionManager.b(this.mEmptyScreenPermissionListener);
  }

  public void onSyncStateChanged(int paramInt, boolean paramBoolean)
  {
    runOnUiThread(new t(this, paramInt, paramBoolean));
  }

  public void onSyncStateChangedInternal(int paramInt, boolean paramBoolean)
  {
    if (this.mSyncState != paramInt)
    {
      this.mSyncState = paramInt;
      if (!paramBoolean)
        this.mContactsLoader.l();
      this.mActivityWrapper.a(getActivity(), this.mSyncState);
      if ((paramInt == 3) && (!d.p.l.d()) && (!ViberApplication.getInstance().isOnForeground()))
        com.viber.voip.ui.dialogs.a.e().a(this).b(this);
    }
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (!this.mOpenedForForward)
    {
      if (addSubAdapterHeader())
      {
        this.mSubAdapterHeaderSection = getLayoutInflater().inflate(R.layout.view_contacts_section_header, getListView(), false);
        ((TextView)this.mSubAdapterHeaderSection.findViewById(R.id.label)).setText(getSubAdapterHeaderText());
        this.mSubAdapterHeaderSection.findViewById(R.id.filterAllView).setVisibility(8);
        this.mSubAdapterHeaderSection.findViewById(R.id.filterViberView).setVisibility(8);
      }
      this.mContactsSection = getLayoutInflater().inflate(R.layout.view_contacts_section_header, getListView(), false);
      this.mContactsSection.findViewById(R.id.filterAllView).setVisibility(8);
      this.mContactsSection.findViewById(R.id.filterViberView).setVisibility(8);
    }
  }

  public void setSearchQuery(String paramString)
  {
    super.setSearchQuery(paramString);
    if (getActivity() == null)
    {
      this.mSyncState = -1;
      setListAdapter(null);
      if (this.mContactsLoader != null)
      {
        this.mContactsLoader.q();
        this.mContactsLoader.j();
        this.mContactsLoader = null;
      }
    }
  }

  protected void updateCheckedParticipant(ParticipantSelector.Participant paramParticipant)
  {
    ListView localListView;
    int i;
    int i2;
    if (this.mParticipantAdapter != null)
    {
      this.mParticipantAdapter.a(this.mParticipantSelector.b(true), this.mParticipantSelector.i(), this.mParticipantSelector.d());
      if (!this.mOpenedForForward)
        this.mContactsRecentListAdapter.a(this.mParticipantSelector.b(true), this.mParticipantSelector.i(), this.mParticipantSelector.d());
      localListView = getListView();
      i = localListView.getFirstVisiblePosition();
      if (i <= localListView.getLastVisiblePosition())
      {
        if ((this.mOpenedForForward) || (this.mContactsRecentListAdapter.getCount() <= 0))
          break label264;
        if (this.mContactsRecentListAdapter.a(i, paramParticipant))
        {
          int i1 = i - localListView.getFirstVisiblePosition();
          if (addSubAdapterHeader())
          {
            i2 = 1;
            label145: int i3 = i2 + i1;
            this.mContactsRecentListAdapter.getView(i, localListView.getChildAt(i3), localListView);
          }
        }
      }
    }
    label264: label268: 
    while (true)
    {
      i++;
      break;
      i2 = 0;
      break label145;
      int m = this.mContactsRecentListAdapter.getCount();
      int n;
      if (addSubAdapterHeader())
        n = 2;
      label203: for (int j = i - (n + m); ; j = i)
      {
        if (!this.mParticipantAdapter.a(j, paramParticipant))
          break label268;
        int k = i - localListView.getFirstVisiblePosition();
        this.mParticipantAdapter.getView(j, localListView.getChildAt(k), localListView);
        break;
        n = 1;
        break label203;
        return;
      }
    }
  }

  protected void updateCheckedParticipants()
  {
    if ((getListAdapter() != null) && (this.mMergeAdapter != null))
    {
      this.mParticipantAdapter.a(this.mParticipantSelector.b(true), this.mParticipantSelector.i(), this.mParticipantSelector.d());
      if (!this.mOpenedForForward)
        this.mContactsRecentListAdapter.a(this.mParticipantSelector.b(true), this.mParticipantSelector.i(), this.mParticipantSelector.d());
      this.mMergeAdapter.notifyDataSetChanged();
    }
  }

  protected void updateEmptyScreen()
  {
    x localx = this.mActivityWrapper;
    b.b localb = b.b.b;
    int i = this.mSyncState;
    if ((!TextUtils.isEmpty(this.mSearchMediator.a())) && (canAddCustomNumber()));
    for (boolean bool = true; ; bool = false)
    {
      localx.a(localb, i, true, bool, false);
      return;
    }
  }

  public static abstract interface a
  {
    public abstract void a(Intent paramIntent);

    public abstract void b(Intent paramIntent);
  }

  private static class b
    implements f.a
  {
    private final WeakReference<s> a;

    b(s params)
    {
      this.a = new WeakReference(params);
    }

    public void a()
    {
      s locals = (s)this.a.get();
      if (locals != null)
      {
        locals.showLoading(false);
        ad.a().c(locals);
      }
    }

    public void a(long paramLong, String paramString)
    {
      com.viber.voip.invitelinks.g.a(this, paramLong, paramString);
    }

    public void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity, String paramString)
    {
      s locals = (s)this.a.get();
      if (locals != null)
      {
        if ((!paramPublicGroupConversationItemLoaderEntity.isCommunityType()) || (cd.c(paramPublicGroupConversationItemLoaderEntity.getGroupRole())) || (!com.viber.voip.messages.m.b()))
          break label72;
        ((com.viber.voip.invitelinks.linkscreen.f)locals.mLinkActionsInteractor.get()).a(paramPublicGroupConversationItemLoaderEntity.getId(), paramPublicGroupConversationItemLoaderEntity.getGroupName(), paramPublicGroupConversationItemLoaderEntity.getIconUri(), paramString);
      }
      while (true)
      {
        locals.showLoading(false);
        return;
        label72: ((com.viber.voip.invitelinks.linkscreen.f)locals.mLinkActionsInteractor.get()).c(paramPublicGroupConversationItemLoaderEntity.getId(), paramPublicGroupConversationItemLoaderEntity.getGroupName(), paramPublicGroupConversationItemLoaderEntity.getIconUri(), paramString);
      }
    }

    public void b()
    {
      s locals = (s)this.a.get();
      if (locals != null)
      {
        locals.showLoading(false);
        com.viber.voip.ui.dialogs.l.g().c(locals);
      }
    }

    public void c()
    {
      s locals = (s)this.a.get();
      if (locals != null)
      {
        locals.showLoading(false);
        com.viber.voip.ui.dialogs.k.n().c(locals);
      }
    }

    public void d()
    {
      s locals = (s)this.a.get();
      if (locals != null)
      {
        locals.showLoading(false);
        com.viber.voip.ui.dialogs.l.p().c(locals);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.s
 * JD-Core Version:    0.6.2
 */