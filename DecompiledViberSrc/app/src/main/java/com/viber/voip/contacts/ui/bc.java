package com.viber.voip.contacts.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.ArrayMap;
import android.widget.ListView;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m.c;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.secure.TrustPeerController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.contacts.adapters.TrustedContactsAdapter;
import com.viber.voip.contacts.adapters.TrustedContactsAdapter.TrustedContactAdapterItem;
import com.viber.voip.contacts.adapters.TrustedContactsAdapter.a;
import com.viber.voip.messages.controller.ci;
import com.viber.voip.messages.controller.ci.a;
import com.viber.voip.messages.k;
import com.viber.voip.ui.au;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.s;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class bc extends au
  implements m.c, TrustedContactsAdapter.a
{
  private static final Logger a = ViberEnv.getLogger();
  private TrustPeerController b;
  private TrustedContactsAdapter c;

  private void a()
  {
    setListShown(false);
    final HashSet localHashSet1 = new HashSet(Arrays.asList(this.b.getTrustedPeersList()));
    final HashSet localHashSet2 = new HashSet(Arrays.asList(this.b.getBreachedPeersList()));
    ViberApplication.getInstance().getMessagesManager().e().a(localHashSet1, new ci.a()
    {
      public void onGetUserDetail(com.viber.voip.model.entity.m[] paramAnonymousArrayOfm)
      {
        ArrayMap localArrayMap = new ArrayMap(paramAnonymousArrayOfm.length);
        int i = paramAnonymousArrayOfm.length;
        for (int j = 0; j < i; j++)
        {
          com.viber.voip.model.entity.m localm = paramAnonymousArrayOfm[j];
          if ((localHashSet1.contains(localm.a())) && (((TrustedContactsAdapter.TrustedContactAdapterItem)localArrayMap.get(localm.a()) == null) || (localm.g() == 1)))
            localArrayMap.put(localm.a(), new TrustedContactsAdapter.TrustedContactAdapterItem(localm.a(), localm.getNumber(), localm.o(), localHashSet2.contains(localm.a())));
        }
        av.a(av.e.a).post(new be(this, localArrayMap));
      }

      public void onGetUserError()
      {
        av.a(av.e.a).post(new bf(this));
      }
    }
    , true);
  }

  private void a(List<TrustedContactsAdapter.TrustedContactAdapterItem> paramList)
  {
    this.c.a(paramList);
    if (getView() != null)
      setListShown(true);
  }

  public void a(TrustedContactsAdapter.TrustedContactAdapterItem paramTrustedContactAdapterItem)
  {
    s.c(paramTrustedContactAdapterItem.displayName).a(paramTrustedContactAdapterItem).a(this).b(this);
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getListView().setDivider(null);
    ListView localListView = getListView();
    TrustedContactsAdapter localTrustedContactsAdapter = new TrustedContactsAdapter(getActivity(), this, getLayoutInflater());
    this.c = localTrustedContactsAdapter;
    localListView.setAdapter(localTrustedContactsAdapter);
    if (paramBundle != null)
    {
      a(paramBundle.getParcelableArrayList("items"));
      return;
    }
    a();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = ViberApplication.getInstance().getEngine(false).getTrustPeerController();
  }

  public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    if ((paramm.a(DialogCode.D1505)) && (paramInt == -1))
    {
      TrustedContactsAdapter.TrustedContactAdapterItem localTrustedContactAdapterItem = (TrustedContactsAdapter.TrustedContactAdapterItem)paramm.d();
      av.a(av.e.h).post(new bd(this, localTrustedContactAdapterItem));
      this.c.a(localTrustedContactAdapterItem);
    }
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelableArrayList("items", this.c.a());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.bc
 * JD-Core Version:    0.6.2
 */