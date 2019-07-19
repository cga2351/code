package com.viber.voip.contacts.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.CheckBox;
import android.widget.ListView;
import com.viber.common.permission.c;
import com.viber.provider.d;
import com.viber.voip.R.attr;
import com.viber.voip.ViberApplication;
import com.viber.voip.contacts.adapters.a.a;
import com.viber.voip.contacts.adapters.n;
import com.viber.voip.contacts.b.b;
import com.viber.voip.messages.conversation.ac;
import com.viber.voip.messages.conversation.ae;
import com.viber.voip.messages.k;
import com.viber.voip.model.entity.l;
import com.viber.voip.ui.aa;
import com.viber.voip.util.cj;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class a extends aa
{
  private dagger.a<k> a;
  private ac b;
  private c c;
  private long d;
  private long e;
  private View.OnLayoutChangeListener f = new View.OnLayoutChangeListener()
  {
    public void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
    {
      if (paramAnonymousInt8 != paramAnonymousInt4)
        a.a(a.this);
    }
  };

  private ParticipantSelector.Participant a(ParticipantSelector.Participant paramParticipant)
  {
    if (this.mParticipantSelector.b(true).contains(paramParticipant))
      return paramParticipant;
    return null;
  }

  protected int countParticipantsForDoneButton()
  {
    return this.mParticipantSelector.a(false);
  }

  protected int countParticipantsForHeader()
  {
    ParticipantSelector localParticipantSelector = this.mParticipantSelector;
    if ((!this.mParticipantSelector.b()) || (!canRemoveAddedParticipants()));
    for (boolean bool = true; ; bool = false)
      return localParticipantSelector.a(bool);
  }

  protected n createParticipantAdapter()
  {
    return new com.viber.voip.contacts.adapters.a(getActivity(), this.b, getLayoutInflater());
  }

  protected d createParticipantLoader(boolean paramBoolean)
  {
    this.b = new ac(getActivity(), false, false, getLoaderManager(), this.a, this, com.viber.voip.h.a.b());
    this.b.p();
    if (paramBoolean)
    {
      this.b.b(this.d);
      this.b.i();
    }
    return this.b;
  }

  protected ParticipantSelector.Participant findByPosition(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getAllContactsCount()))
      return null;
    return a(ParticipantSelector.Participant.from(this.b.e(paramInt)));
  }

  protected int findPosition(ParticipantSelector.Participant paramParticipant)
  {
    if (this.b == null)
    {
      j = -1;
      return j;
    }
    int i = this.b.getCount();
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label53;
      if (this.b.e(j).h().equals(paramParticipant.getMemberId()))
        break;
    }
    label53: return 0;
  }

  public long getConversationId()
  {
    return this.d;
  }

  public long getGroupId()
  {
    return this.e;
  }

  protected void handleArguments(Bundle paramBundle)
  {
    if (paramBundle == null)
      return;
    this.d = paramBundle.getLong("conversation_id", -1L);
    this.e = paramBundle.getLong("group_id", -1L);
  }

  protected void handleDone()
  {
    Set localSet = this.mParticipantSelector.b(false);
    if ((localSet == null) || (localSet.isEmpty()))
      return;
    Intent localIntent = new Intent();
    localIntent.putExtra("group_id", this.e);
    localIntent.putParcelableArrayListExtra("selected_admins", new ArrayList(localSet));
    dj.d(getActivity());
    getActivity().setResult(-1, localIntent);
    getActivity().finish();
  }

  protected x inflateEmptyStub(View paramView)
  {
    return new x(paramView, this.c);
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getListView().setSelector(dc.g(getActivity(), R.attr.list_selector));
    getListView().addOnLayoutChangeListener(this.f);
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    View localView = getView();
    if (localView != null)
      localView.invalidate();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = ViberApplication.getInstance().getLazyMessagesManager();
    this.c = c.a(getActivity());
  }

  public void onDestroy()
  {
    this.b.q();
    this.b.j();
    super.onDestroy();
  }

  public void onDestroyView()
  {
    getListView().removeOnLayoutChangeListener(this.f);
    removeRequestLayoutListViewCallbacks();
    super.onDestroyView();
  }

  public void onListItemClick(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof a.a));
    a.a locala;
    do
    {
      do
        return;
      while (!cj.a(true));
      locala = (a.a)localObject;
    }
    while (!locala.b.isEnabled());
    if (!locala.b.isChecked());
    for (boolean bool = true; ; bool = false)
    {
      ParticipantSelector.Participant[] arrayOfParticipant = new ParticipantSelector.Participant[1];
      arrayOfParticipant[0] = ParticipantSelector.Participant.from(this.b.e(paramInt));
      selectParticipants(bool, arrayOfParticipant);
      return;
    }
  }

  public void onLoadFinished(d paramd, boolean paramBoolean)
  {
    if (this.b != paramd)
      return;
    if (paramBoolean)
    {
      HashMap localHashMap = new HashMap();
      int i = getAllContactsCount();
      for (int j = 0; j < i; j++)
      {
        ae localae = this.b.e(j);
        if (localae.l())
        {
          l locall = new l();
          locall.a(0);
          locall.a(2, 2);
          localHashMap.put(ParticipantSelector.Participant.from(localae), locall);
        }
      }
      if (!localHashMap.isEmpty())
        onParticipantsReady(localHashMap, 2);
    }
    super.onLoadFinished(paramd, paramBoolean);
  }

  public boolean onQueryTextChange(String paramString)
  {
    boolean bool = super.onQueryTextChange(paramString);
    if (bool)
      this.b.a(paramString, PhoneNumberUtils.stripSeparators(paramString));
    return bool;
  }

  public void setSearchQuery(String paramString)
  {
    super.setSearchQuery(paramString);
    if (getActivity() == null);
    do
    {
      return;
      setListAdapter(null);
    }
    while (this.b == null);
    this.b.q();
    this.b.j();
    this.b = null;
  }

  protected void updateEmptyScreen()
  {
    this.mActivityWrapper.a(b.b.b, -1, false, true, false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.a
 * JD-Core Version:    0.6.2
 */