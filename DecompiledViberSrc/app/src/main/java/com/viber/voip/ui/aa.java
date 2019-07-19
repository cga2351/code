package com.viber.voip.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.Pair;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.provider.d;
import com.viber.provider.d.a;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.g;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.contacts.adapters.n;
import com.viber.voip.contacts.adapters.p;
import com.viber.voip.contacts.adapters.p.a;
import com.viber.voip.contacts.b;
import com.viber.voip.contacts.b.a;
import com.viber.voip.contacts.b.b;
import com.viber.voip.contacts.ui.ParticipantSelector;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.contacts.ui.ParticipantSelector.e;
import com.viber.voip.contacts.ui.al;
import com.viber.voip.contacts.ui.s.a;
import com.viber.voip.contacts.ui.x;
import com.viber.voip.h.a;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.messages.k;
import com.viber.voip.messages.ui.forward.e;
import com.viber.voip.messages.ui.forward.f;
import com.viber.voip.model.entity.l;
import com.viber.voip.ui.dialogs.r;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.dj;
import com.viber.voip.util.dr;
import com.viber.voip.widget.WrapContentAwareLinearLayoutManager;
import com.viber.voip.widget.ah;
import java.util.Map;
import java.util.Set;

public abstract class aa extends au
  implements View.OnClickListener, AbsListView.OnScrollListener, d.a, ParticipantSelector.e, e, ac.a
{
  protected static final int DEFAULT_MIN_CHECKED_PARTICIPANTS_COUNT_FOR_DONE_BUTTON = 1;
  private static final long KEYBOARD_DELAY = 100L;
  private static final Logger L = ViberEnv.getLogger();
  private static final long REQUEST_LAYOUT_TIMEOUT = 300L;
  protected x mActivityWrapper;
  private boolean mContactsLoaded;
  private MenuItem mDoneMenuItem;
  private int mListItemHeaderHeight;
  private final View.OnClickListener mOnSelectedParticipantAction = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      p.a locala = (p.a)aa.this.mSelectedParticipantsView.getChildViewHolder(paramAnonymousView);
      if (locala == null)
        return;
      aa.this.handleParticipantSelectedInView(p.b(locala.getAdapterPosition()));
    }
  };
  protected n mParticipantAdapter;
  private d mParticipantLoader;
  protected ParticipantSelector mParticipantSelector;
  private String mQuery;
  private Runnable mRequestLayoutListViewRunnable = new Runnable()
  {
    public void run()
    {
      aa.this.getListView().requestLayout();
    }
  };
  private final Runnable mSearchAction = new Runnable()
  {
    public void run()
    {
      aa.this.onActivitySearchRequested();
    }
  };
  protected ac mSearchMediator;
  private f mSearchQueryChangeListener;
  private String mSearchedNumber;
  private String mSelectedNumber = "";
  private p mSelectedParticipantAdapter;
  private RecyclerView mSelectedParticipantsView;
  private c mSoftInputModeChangeListener;
  protected final Handler mUiHandler = av.a(av.e.a);

  private void addedCheckedToParticipantsList()
  {
    int i = 0;
    updateParticipantListVisibility(false);
    Set localSet = this.mParticipantSelector.b(true);
    if ((this.mParticipantLoader != null) && (this.mContactsLoaded))
    {
      int j = getAllContactsCount();
      this.mSelectedParticipantAdapter.a(false);
      this.mSelectedParticipantAdapter.a();
      while (i < j)
      {
        ParticipantSelector.Participant localParticipant = findByPosition(i);
        if (localParticipant != null)
        {
          this.mSelectedParticipantAdapter.a(localParticipant);
          localSet.remove(localParticipant);
        }
        i++;
      }
      if (localSet.size() != 0)
        this.mSelectedParticipantAdapter.a(localSet);
      this.mSelectedParticipantAdapter.a(true);
      this.mSelectedParticipantAdapter.notifyDataSetChanged();
    }
  }

  private void handleParticipantRemovedFromView(int paramInt)
  {
    ParticipantSelector.Participant localParticipant = this.mSelectedParticipantAdapter.a(paramInt);
    if (localParticipant != null)
    {
      if (!TextUtils.isEmpty(localParticipant.getNumber()))
      {
        this.mSelectedNumber = "";
        this.mSearchMediator.b();
      }
      this.mParticipantSelector.c(localParticipant);
    }
  }

  @SuppressLint({"NewApi"})
  private void handleParticipantSelectedInView(int paramInt)
  {
    final ParticipantSelector.Participant localParticipant = this.mSelectedParticipantAdapter.d(paramInt);
    if (localParticipant.isLocal())
    {
      if ((!TextUtils.isEmpty(this.mSearchMediator.a())) && (TextUtils.isEmpty(this.mSelectedNumber)));
      for (int i = 1000; ; i = 0)
      {
        this.mSelectedNumber = "";
        this.mSearchMediator.a("");
        this.mSelectedParticipantsView.postDelayed(new Runnable()
        {
          public void run()
          {
            int i = aa.this.getListView().getFirstVisiblePosition();
            int j = aa.this.findPosition(localParticipant);
            if (j == -1)
              return;
            int m;
            int k;
            if ((aa.this.mParticipantLoader instanceof b))
            {
              m = ((b)aa.this.mParticipantLoader).v().getCount();
              if (m > 0)
                k = 2 * aa.this.mListItemHeaderHeight;
            }
            while (true)
            {
              int n;
              int i1;
              if (aa.this.mParticipantAdapter.e_(j))
              {
                n = 0;
                if (m > 0)
                  n = -aa.this.mListItemHeaderHeight - k;
                i1 = j + m;
                if (Math.abs(i - i1) <= 100)
                  break label186;
                aa.this.getListView().setSelectionFromTop(i1, n);
              }
              while (true)
              {
                aa.this.mSearchMediator.i();
                return;
                if (m > 0)
                {
                  n = aa.this.mListItemHeaderHeight - k;
                  break;
                }
                n = aa.this.mListItemHeaderHeight;
                break;
                label186: aa.this.getListView().smoothScrollToPositionFromTop(i1, n);
              }
              k = 0;
              continue;
              k = 0;
              m = 0;
            }
          }
        }
        , i);
        return;
      }
    }
    this.mSearchMediator.a("");
    this.mSelectedNumber = localParticipant.getNumber();
    this.mSearchMediator.a(this.mSelectedNumber);
  }

  private void setSearchedNumber(String paramString)
  {
    if (paramString != null)
    {
      String str = paramString.replaceFirst("[-.]*", "");
      if (PhoneNumberUtils.isGlobalPhoneNumber(str))
      {
        this.mSearchedNumber = dr.a(ViberApplication.getInstance(), str, str);
        return;
      }
    }
    this.mSearchedNumber = null;
  }

  private void updateParticipantListVisibility(final boolean paramBoolean)
  {
    final int i;
    if (this.mParticipantSelector.a(false) != 0)
    {
      i = 0;
      if (this.mSelectedParticipantsView.getVisibility() == i)
        break label49;
      this.mUiHandler.post(new Runnable()
      {
        public void run()
        {
          dj.c(aa.this.mSelectedParticipantsView, i);
          if (paramBoolean)
            aa.this.updateParticipantsHeader(false, true);
        }
      });
    }
    label49: 
    while (!paramBoolean)
    {
      return;
      i = 8;
      break;
    }
    updateParticipantsHeader(false, true);
  }

  private void updateParticipantsHeader(boolean paramBoolean)
  {
    updateParticipantsHeader(paramBoolean, true);
  }

  private void updateParticipantsHeader(boolean paramBoolean1, boolean paramBoolean2)
  {
    FragmentActivity localFragmentActivity1 = getActivity();
    int j;
    if ((localFragmentActivity1 != null) && (this.mActivityWrapper != null) && (this.mSearchMediator != null))
    {
      int i = countParticipantsForDoneButton();
      if (!canRemoveAddedParticipants())
        break label119;
      j = this.mParticipantSelector.k();
      if ((i < getMinCheckedParticipantsCountForDoneButton()) || ((this.mParticipantSelector.b()) && (i > j)))
        break label131;
    }
    label131: for (boolean bool = true; ; bool = false)
    {
      setDoneVisible(bool);
      if (paramBoolean2)
        this.mActivityWrapper.a(localFragmentActivity1, countParticipantsForHeader(), j);
      if (paramBoolean1)
      {
        FragmentActivity localFragmentActivity2 = getActivity();
        if (localFragmentActivity2 != null)
          localFragmentActivity2.supportInvalidateOptionsMenu();
      }
      return;
      label119: j = this.mParticipantSelector.j();
      break;
    }
  }

  protected boolean canAddCustomNumber()
  {
    return false;
  }

  protected boolean canRemoveAddedParticipants()
  {
    return true;
  }

  protected boolean canRestoreSearch()
  {
    return false;
  }

  protected int countParticipantsForDoneButton()
  {
    ParticipantSelector localParticipantSelector = this.mParticipantSelector;
    if ((!this.mParticipantSelector.b()) || (!canRemoveAddedParticipants()));
    for (boolean bool = true; ; bool = false)
      return localParticipantSelector.a(bool);
  }

  protected int countParticipantsForHeader()
  {
    return countParticipantsForDoneButton();
  }

  protected c createDefaultSoftInputModeChangeListener()
  {
    return new a();
  }

  protected abstract n createParticipantAdapter();

  protected abstract d createParticipantLoader(boolean paramBoolean);

  protected ParticipantSelector createParticipantSelector()
  {
    return new ParticipantSelector(getActivity(), av.a(av.e.a), av.a(av.e.f), av.a(av.e.d), this, UserManager.from(getActivity()).getRegistrationValues(), (s.a)getActivity(), com.viber.voip.messages.controller.manager.o.a(), a.b(), ViberApplication.getInstance().getEngine(false).getOnlineUserActivityHelper(), ViberApplication.getInstance().getMessagesManager().d(), ViberApplication.getInstance().getMessagesManager().z(), ab.b(), ak.a(), getChatOrigin(getArguments()), g.a().c().g());
  }

  protected abstract ParticipantSelector.Participant findByPosition(int paramInt);

  protected abstract int findPosition(ParticipantSelector.Participant paramParticipant);

  protected ListAdapter getAdapter()
  {
    return this.mParticipantAdapter;
  }

  protected int getAllContactsCount()
  {
    if (this.mParticipantLoader != null)
      return this.mParticipantLoader.getCount();
    return 0;
  }

  protected String getChatOrigin(Bundle paramBundle)
  {
    if (paramBundle != null)
      return paramBundle.getString("extra_create_chat_origin", "");
    return "";
  }

  protected int getContactsPermissionString()
  {
    return R.string.participant_chooser_permission_description;
  }

  protected int getMinCheckedParticipantsCountForDoneButton()
  {
    return 1;
  }

  protected c getSoftInputModeChangeListener()
  {
    return this.mSoftInputModeChangeListener;
  }

  protected void handleArguments(Bundle paramBundle)
  {
  }

  protected void handleDone()
  {
  }

  protected void handleSoftInputMode()
  {
    if (this.mSoftInputModeChangeListener.a())
      dj.a(getActivity());
  }

  protected abstract x inflateEmptyStub(View paramView);

  protected boolean isAllowUncheckDisabled()
  {
    return false;
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    setHasOptionsMenu(true);
    View localView = getView();
    this.mParticipantSelector = createParticipantSelector();
    this.mActivityWrapper = inflateEmptyStub(localView);
    this.mActivityWrapper.a(localView, this, getContactsPermissionString());
    this.mSearchMediator = new al(this, localView);
    this.mSelectedParticipantsView = ((RecyclerView)localView.findViewById(R.id.participants_listview));
    ContactsListView localContactsListView = (ContactsListView)localView.findViewById(16908298);
    this.mActivityWrapper.a(true);
    this.mActivityWrapper.a(this);
    updateParticipantsHeader(true);
    handleArguments(getArguments());
    this.mUiHandler.postDelayed(this.mSearchAction, 100L);
    localContactsListView.a(true, this.mIsTablet);
    localContactsListView.a(this);
    dj.a(localContactsListView, true);
    int i = getResources().getDimensionPixelSize(R.dimen.compose_list_divider_width);
    new ItemTouchHelper(new b(null)).attachToRecyclerView(this.mSelectedParticipantsView);
    this.mSelectedParticipantsView.setLayoutManager(new WrapContentAwareLinearLayoutManager(getContext(), 0, false));
    this.mSelectedParticipantsView.addItemDecoration(new com.viber.voip.widget.a.c(i));
    this.mSelectedParticipantAdapter = new p(getActivity(), this.mParticipantSelector, this.mOnSelectedParticipantAction);
    this.mSelectedParticipantsView.setAdapter(this.mSelectedParticipantAdapter);
    this.mParticipantLoader = createParticipantLoader(true);
  }

  public boolean onActivitySearchRequested()
  {
    if (this.mSearchMediator != null)
      this.mSearchMediator.d();
    return true;
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof f))
      this.mSearchQueryChangeListener = ((f)paramActivity);
    if ((paramActivity instanceof c))
      this.mSoftInputModeChangeListener = ((c)paramActivity);
    do
    {
      return;
      this.mSoftInputModeChangeListener = createDefaultSoftInputModeChangeListener();
    }
    while (this.mSoftInputModeChangeListener != null);
    this.mSoftInputModeChangeListener = new a();
  }

  public void onClick(View paramView)
  {
    if (paramView == this.mActivityWrapper.d)
    {
      String str = this.mActivityWrapper.a.getText().toString();
      this.mParticipantSelector.a(str, this.mActivityWrapper.d);
    }
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    handleSoftInputMode();
    if (this.mActivityWrapper != null)
      this.mActivityWrapper.a(ViberApplication.isTablet(getActivity()), dj.c(getActivity()));
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    handleSoftInputMode();
    this.mListItemHeaderHeight = getResources().getDimensionPixelSize(R.dimen.list_section_divider_min_height);
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenuInflater.inflate(R.menu.menu_participant_selector, paramMenu);
    this.mDoneMenuItem = paramMenu.findItem(R.id.menu_done);
    ac localac;
    if ((canRestoreSearch()) && (this.mSearchMediator != null))
    {
      localac = this.mSearchMediator;
      if (!TextUtils.isEmpty(this.mQuery))
        break label60;
    }
    label60: for (String str = null; ; str = this.mQuery)
    {
      localac.a(str);
      return;
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout._ics_fragment_compose_contacts, paramViewGroup, false);
  }

  public void onDestroy()
  {
    if (this.mParticipantSelector != null)
      this.mParticipantSelector.a();
    super.onDestroy();
  }

  public void onDetach()
  {
    if (this.mSearchMediator != null)
    {
      if (this.mSearchQueryChangeListener != null)
        this.mSearchQueryChangeListener.a(this.mSearchMediator.a());
      this.mSearchMediator.c(false);
      this.mSearchMediator = null;
    }
    this.mSearchQueryChangeListener = null;
    this.mSoftInputModeChangeListener = null;
    super.onDetach();
  }

  public void onLoadFinished(d paramd, boolean paramBoolean)
  {
    boolean bool1 = true;
    if ((this.mParticipantLoader != paramd) || (this.mActivityWrapper == null));
    do
    {
      return;
      this.mContactsLoaded = bool1;
      if ((getListAdapter() != null) && (this.mParticipantAdapter != null))
        break;
      this.mParticipantAdapter = createParticipantAdapter();
      setListAdapter(getAdapter());
      updateCheckedParticipants();
      addedCheckedToParticipantsList();
      updateEmptyScreen();
    }
    while (!canAddCustomNumber());
    String str = this.mSearchedNumber;
    boolean bool2 = TextUtils.isEmpty(str);
    int i = getAllContactsCount();
    x localx1 = this.mActivityWrapper;
    boolean bool3;
    label118: x localx2;
    if ((!TextUtils.isEmpty(this.mSearchMediator.a())) || (i > 0))
    {
      bool3 = bool1;
      localx1.a(bool3, this.mSearchMediator);
      ParticipantSelector.Participant localParticipant = ParticipantSelector.Participant.createUnknown(str);
      localx2 = this.mActivityWrapper;
      if ((i != 0) || (this.mParticipantSelector.a(localParticipant)) || (bool2))
        break label191;
    }
    while (true)
    {
      localx2.a(bool1, str);
      return;
      this.mParticipantAdapter.notifyDataSetChanged();
      break;
      bool3 = false;
      break label118;
      label191: bool1 = false;
    }
  }

  public void onLoaderReset(d paramd)
  {
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (R.id.menu_done == paramMenuItem.getItemId())
    {
      handleDone();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  public void onParticipantAlreadyAdded(String paramString)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
      r.c().a(com.viber.common.d.c.a(localFragmentActivity, R.string.dialog_1004_message_already_participant, new Object[] { paramString })).a(localFragmentActivity);
  }

  public void onParticipantSelected(boolean paramBoolean, ParticipantSelector.Participant paramParticipant)
  {
    updateParticipantsHeader(true, false);
    if (paramBoolean)
    {
      if ((!TextUtils.isEmpty(this.mSearchMediator.a())) || (this.mQuery != null))
      {
        this.mSearchMediator.b();
        this.mQuery = null;
      }
      if (paramParticipant.isLocal())
        updateCheckedParticipant(paramParticipant);
      LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)this.mSelectedParticipantsView.getLayoutManager();
      int i = this.mSelectedParticipantAdapter.getItemCount();
      int j = 0;
      if (i > 0)
      {
        int k = localLinearLayoutManager.findLastVisibleItemPosition();
        int m = p.c(-1 + this.mSelectedParticipantAdapter.b());
        j = 0;
        if (k >= m)
          j = 1;
      }
      this.mSelectedParticipantAdapter.a(paramParticipant);
      if (j != 0)
        localLinearLayoutManager.scrollToPosition(-1 + this.mSelectedParticipantAdapter.getItemCount());
    }
    while (true)
    {
      updateParticipantListVisibility(true);
      return;
      if (paramParticipant.isLocal())
        updateCheckedParticipant(paramParticipant);
      this.mSelectedParticipantAdapter.c(paramParticipant);
    }
  }

  protected void onParticipantsReady(Map<ParticipantSelector.Participant, l> paramMap, int paramInt)
  {
    this.mParticipantSelector.a(paramMap, isAllowUncheckDisabled(), paramInt);
    updateParticipantsHeader(true);
    updateCheckedParticipants();
    addedCheckedToParticipantsList();
  }

  public void onPrepareOptionsMenu(Menu paramMenu)
  {
    updateParticipantsHeader(false, false);
  }

  public boolean onQueryTextChange(String paramString)
  {
    if ((!TextUtils.isEmpty(this.mSelectedNumber)) && (this.mSelectedNumber.equals(paramString)))
      return false;
    setSearchedNumber(paramString);
    this.mActivityWrapper.a();
    if (this.mSearchQueryChangeListener != null)
      this.mSearchQueryChangeListener.a(paramString);
    return true;
  }

  public boolean onQueryTextSubmit(String paramString)
  {
    return false;
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((this.mSearchMediator.e()) && (paramInt == 1))
      this.mSearchMediator.i();
  }

  public boolean onSearchViewShow(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.mSearchQueryChangeListener != null))
      this.mSearchQueryChangeListener.a();
    return true;
  }

  public void onStop()
  {
    this.mUiHandler.removeCallbacks(this.mSearchAction);
    super.onStop();
  }

  protected final void removeRequestLayoutListViewCallbacks()
  {
    getListView().removeCallbacks(this.mRequestLayoutListViewRunnable);
  }

  protected final void requestLayoutListViewWithDelay()
  {
    ListView localListView = getListView();
    localListView.removeCallbacks(this.mRequestLayoutListViewRunnable);
    localListView.postDelayed(this.mRequestLayoutListViewRunnable, 300L);
  }

  protected final void selectParticipants(boolean paramBoolean, ParticipantSelector.Participant[] paramArrayOfParticipant)
  {
    this.mParticipantSelector.a(paramBoolean, paramArrayOfParticipant);
  }

  protected void setDoneVisible(boolean paramBoolean)
  {
    if ((this.mDoneMenuItem != null) && (this.mDoneMenuItem.isVisible() != paramBoolean))
      this.mDoneMenuItem.setVisible(paramBoolean);
  }

  public void setSearchQuery(String paramString)
  {
    this.mQuery = paramString;
  }

  protected Pair<Boolean, String> shouldShowToast()
  {
    return new Pair(Boolean.valueOf(false), "");
  }

  protected void updateCheckedParticipant(ParticipantSelector.Participant paramParticipant)
  {
    updateCheckedParticipants();
  }

  protected void updateCheckedParticipants()
  {
    if ((getListAdapter() != null) && (this.mParticipantAdapter != null))
    {
      this.mParticipantAdapter.a(this.mParticipantSelector.b(true), this.mParticipantSelector.i(), this.mParticipantSelector.d());
      this.mParticipantAdapter.notifyDataSetChanged();
    }
  }

  protected void updateEmptyScreen()
  {
    x localx = this.mActivityWrapper;
    b.b localb = b.b.b;
    if ((!TextUtils.isEmpty(this.mSearchMediator.a())) && (canAddCustomNumber()));
    for (boolean bool = true; ; bool = false)
    {
      localx.a(localb, -1, true, bool, false);
      return;
    }
  }

  public static class a
    implements aa.c
  {
    public boolean a()
    {
      return !ViberApplication.isTablet(ViberApplication.getApplication());
    }
  }

  private class b extends ah
  {
    private b()
    {
    }

    public int getMovementFlags(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
    {
      if ((paramViewHolder.getItemViewType() == 1) && (!((p.a)paramViewHolder).a()))
        return super.getMovementFlags(paramRecyclerView, paramViewHolder);
      return 0;
    }

    public void onSwiped(RecyclerView.ViewHolder paramViewHolder, int paramInt)
    {
      aa.this.handleParticipantRemovedFromView(p.b(paramViewHolder.getAdapterPosition()));
    }
  }

  public static abstract interface c
  {
    public abstract boolean a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.aa
 * JD-Core Version:    0.6.2
 */