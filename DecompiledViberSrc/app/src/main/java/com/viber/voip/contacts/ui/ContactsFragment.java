package com.viber.voip.contacts.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.arch.lifecycle.e.b;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m.c;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.dialer.DialerController;
import com.viber.provider.d.a;
import com.viber.voip.R.attr;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ads.b.c.b.a.a;
import com.viber.voip.ads.b.c.b.f.b;
import com.viber.voip.analytics.story.StoryConstants.h.a;
import com.viber.voip.analytics.story.b.a.h;
import com.viber.voip.analytics.story.b.a.h.a;
import com.viber.voip.analytics.story.b.a.h.a.a;
import com.viber.voip.au;
import com.viber.voip.av.e;
import com.viber.voip.billing.PurchaseSupportActivity;
import com.viber.voip.calls.ui.m.a;
import com.viber.voip.calls.ui.u;
import com.viber.voip.contacts.b.b;
import com.viber.voip.contacts.c.d.g.b;
import com.viber.voip.contacts.c.d.g.c;
import com.viber.voip.contacts.c.d.n.a;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.ui.view.SearchNoResultsView;
import com.viber.voip.model.AggregatedCall;
import com.viber.voip.phone.call.CallInitiationId;
import com.viber.voip.registration.af;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.b.e.a;
import com.viber.voip.settings.d.ac;
import com.viber.voip.settings.d.ad;
import com.viber.voip.settings.d.au;
import com.viber.voip.settings.d.p;
import com.viber.voip.ui.ContactsListView;
import com.viber.voip.ui.MenuSearchMediator;
import com.viber.voip.ui.ViberListView;
import com.viber.voip.ui.ac.a;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.o.a;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ViberActionRunner.af;
import com.viber.voip.util.ViberActionRunner.b;
import com.viber.voip.util.ViberActionRunner.o;
import com.viber.voip.util.ViberActionRunner.r;
import com.viber.voip.util.ae;
import com.viber.voip.util.bb;
import com.viber.voip.util.bm;
import com.viber.voip.util.cj;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import com.viber.voip.util.dr;
import com.viber.voip.util.x;
import com.viber.voip.util.x.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import org.webrtc.videoengine.EngineDelegate;
import org.webrtc.videoengine.EngineDelegate.VideoEngineEventSubscriber;

public class ContactsFragment extends com.viber.voip.ui.o
  implements SwipeRefreshLayout.OnRefreshListener, View.OnClickListener, View.OnTouchListener, m.c, d.a, f.b, m.a, com.viber.voip.contacts.adapters.e, com.viber.voip.contacts.adapters.m, g.c, n.a, ContactDetailsFragment.c, ac.a
{
  private static final Logger a = ViberEnv.getLogger();

  @Inject
  com.viber.voip.ads.b.c.a.b A;
  private com.viber.voip.calls.ui.o B;
  private View C;
  private View D;
  private View E;
  private SearchNoResultsView F;
  private MenuItem G;
  private MenuItem H;
  private Intent I;
  private Parcelable J;
  private boolean K = false;
  private com.viber.voip.ui.i L;
  private Rect M;
  private com.viber.voip.ui.f.b T;
  private int U = 0;
  private boolean V;
  private int W = -1;
  private boolean X = false;
  private int Y = 0;
  private c Z = new c(null);
  private final bg aa = new bg();
  private n ab;
  private com.viber.voip.analytics.story.d.c ac;
  private com.viber.voip.analytics.story.b.c ad;
  private com.viber.voip.analytics.story.g.a ae;
  private dagger.a<h> af;
  private com.viber.voip.permissions.k ag;
  private com.viber.common.permission.b ah;
  private final com.viber.common.permission.b ai;
  private com.viber.voip.ads.b.c.c.c aj;
  private final com.viber.voip.ads.b.c.a<com.viber.voip.ads.b.c.c.c> ak;
  private g.b al;
  private EngineDelegate.VideoEngineEventSubscriber am;
  private int b = -1;
  private android.support.v4.util.Pair<Long, Integer> c = new android.support.v4.util.Pair(Long.valueOf(-1L), Integer.valueOf(0));
  private android.support.v4.util.Pair<Integer, Integer> d = new android.support.v4.util.Pair(Integer.valueOf(-1), Integer.valueOf(0));
  protected com.viber.voip.contacts.b e;
  protected com.viber.voip.calls.b f;
  protected aj g;
  protected dagger.a<com.viber.voip.contacts.c.d.g> h;
  protected MenuSearchMediator i;
  protected ak j;
  protected Handler k = com.viber.voip.av.a(av.e.a);
  protected dagger.a<com.viber.voip.messages.k> l;
  protected a m;
  protected b n;
  protected d o;
  protected ViberListView p;
  protected SwipeRefreshLayout q;
  protected com.b.a.a.a r;
  protected com.viber.voip.contacts.adapters.i s;
  protected com.viber.voip.contacts.adapters.l t;
  protected View u;
  protected View v;
  protected View w;
  com.viber.voip.viberout.a x = com.viber.voip.viberout.a.a();
  protected com.viber.common.permission.c y;

  @Inject
  @Named("com.viber.voip.CallsTabAdsController")
  com.viber.voip.ads.b.c.b.f z;

  public ContactsFragment()
  {
    super(1);
    android.util.Pair[] arrayOfPair = new android.util.Pair[2];
    arrayOfPair[0] = com.viber.voip.permissions.m.a(49);
    arrayOfPair[1] = com.viber.voip.permissions.m.a(72);
    this.ai = new com.viber.voip.permissions.e(this, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        default:
        case 49:
          do
            return;
          while (!(paramAnonymousObject instanceof ContactsFragment.MemberActionInfo));
          ContactsFragment.this.g.a((ContactsFragment.MemberActionInfo)paramAnonymousObject, ContactsFragment.a(ContactsFragment.this));
          return;
        case 72:
        }
        ViberActionRunner.b.a(ContactsFragment.this.getActivity(), "Contacts");
      }
    };
    this.ak = new com.viber.voip.ads.b.c.a()
    {
      public void a()
      {
        if (!bm.a(ContactsFragment.this.getLifecycle(), e.b.d))
          return;
        ContactsFragment.a(ContactsFragment.this, null);
      }

      public void a(com.viber.voip.ads.b.c.c.c paramAnonymousc)
      {
        if (!bm.a(ContactsFragment.this.getLifecycle(), e.b.d))
          return;
        ContactsFragment.a(ContactsFragment.this, paramAnonymousc);
      }
    };
    this.al = new g.b()
    {
      public void a()
      {
        ContactsFragment.a(ContactsFragment.this, new ag(this));
      }
    };
    this.am = new EngineDelegate.VideoEngineEventSubscriber()
    {
      public void onAvailableFeatures(boolean paramAnonymousBoolean1, final boolean paramAnonymousBoolean2, boolean paramAnonymousBoolean3, boolean paramAnonymousBoolean4)
      {
        ContactsFragment.b(ContactsFragment.this, new Runnable()
        {
          public void run()
          {
            if (ContactsFragment.b(ContactsFragment.this) != null)
            {
              ContactsFragment.b(ContactsFragment.this).a(paramAnonymousBoolean2);
              ContactsFragment.b(ContactsFragment.this).notifyDataSetChanged();
            }
            if (ContactsFragment.this.s != null)
            {
              ContactsFragment.this.s.a(paramAnonymousBoolean2);
              ContactsFragment.this.s.notifyDataSetChanged();
            }
          }
        });
      }

      public void onFailure(int paramAnonymousInt)
      {
      }

      public void onStartRecvVideo(int paramAnonymousInt)
      {
      }

      public void onStartSendVideo()
      {
      }

      public void onStopRecvVideo(int paramAnonymousInt)
      {
      }

      public void onStopSendVideo()
      {
      }
    };
  }

  private void E()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null)
      return;
    this.L = new com.viber.voip.ui.i(localFragmentActivity.getWindow().getDecorView(), R.id.fab_open_keypad, new y(this));
  }

  private void F()
  {
    com.viber.voip.ads.b.c.a.c localc = new com.viber.voip.ads.b.c.a.c(getContext(), null, this.z, this.p, this.r, null);
    this.aa.a(R.layout.list_item_vo_section, getLayoutInflater(), this.p, localc, com.viber.voip.ads.b.b.b.c.h, this.A);
    this.Z.a(this.aa.b());
  }

  private com.viber.voip.model.c G()
  {
    long l1 = I();
    int i1;
    com.viber.voip.model.c localc;
    if ((l1 != -1L) && (((Integer)this.c.second).intValue() == 0))
    {
      i1 = this.e.a(l1);
      if (i1 != -1)
        localc = this.s.c(i1);
    }
    while (true)
    {
      if ((localc == null) && (this.s.getCount() > 0))
      {
        localc = this.s.c(0);
        i1 = 0;
      }
      if (localc != null)
        a(i1, 0);
      return localc;
      localc = null;
      continue;
      i1 = -1;
      localc = null;
    }
  }

  private AggregatedCall H()
  {
    Object localObject;
    if (!x())
    {
      localObject = null;
      return localObject;
    }
    long l1 = I();
    if ((l1 != -1L) && (this.c.second != null) && (((Integer)this.c.second).intValue() != 1))
      return null;
    int i4;
    AggregatedCall localAggregatedCall;
    int i1;
    if (l1 != -1L)
    {
      i4 = this.f.a(l1);
      if (i4 != -1)
      {
        localAggregatedCall = (AggregatedCall)this.B.a(i4);
        i1 = i4;
      }
    }
    while (true)
    {
      int i3;
      if ((localAggregatedCall == null) && (this.B.getCount() > 0))
      {
        i3 = 0;
        localObject = (AggregatedCall)this.B.a(0);
      }
      while (localObject != null)
      {
        a(i3, 1);
        return localObject;
        int i2 = i1;
        localObject = localAggregatedCall;
        i3 = i2;
      }
      break;
      i1 = i4;
      localAggregatedCall = null;
      continue;
      i1 = -1;
      localAggregatedCall = null;
    }
  }

  private long I()
  {
    if ((this.c.first == null) || (this.c.second == null))
      return -1L;
    return ((Long)this.c.first).longValue();
  }

  private int J()
  {
    int i1 = 1;
    if ((this.d.first == null) || (this.d.second == null))
      return -1;
    int i2 = ((Integer)this.d.first).intValue();
    int i3 = ((Integer)this.d.second).intValue();
    int i4;
    int i6;
    label113: int i7;
    int i10;
    label140: int i11;
    label164: int i12;
    label172: int i8;
    if (((!l()) && (!this.e.x_())) || ((n()) && (this.e.v().getCount() > 0)))
    {
      i4 = i1;
      int i5 = i2 + getListView().getHeaderViewsCount();
      if (!this.K)
        break label201;
      i6 = i1;
      i7 = i5 + i6;
      if (i3 != 0)
        break label225;
      if (!x())
        break label207;
      i10 = this.B.getCount();
      if (i10 > 0)
        i10++;
      if (!n())
        break label213;
      i11 = this.t.getCount();
      if (i4 == 0)
        break label219;
      i12 = i1;
      i8 = i7 + (i10 + (i12 + i11));
    }
    while (true)
    {
      if (i2 == -1);
      while (true)
      {
        return i8 + i1;
        i4 = 0;
        break;
        label201: i6 = 0;
        break label113;
        label207: i10 = 0;
        break label140;
        label213: i11 = 0;
        break label164;
        label219: i12 = 0;
        break label172;
        label225: if (i3 != i1)
          break label261;
        if (x());
        for (int i9 = i1; ; i9 = 0)
        {
          i8 = i9 + i7;
          break;
        }
        i1 = 0;
      }
      label261: i8 = i7;
    }
  }

  private boolean K()
  {
    return (!l()) && ((this.K) || (this.Y != 0));
  }

  private void L()
  {
    if (this.I != null)
    {
      a(this.I);
      this.I = null;
    }
  }

  private void M()
  {
    if (this.y.a(com.viber.voip.permissions.n.k))
    {
      ViberActionRunner.b.a(getActivity(), "Contacts");
      return;
    }
    this.y.a(this, 72, com.viber.voip.permissions.n.k);
  }

  private void N()
  {
    if (this.n != null)
      this.n.c(null);
  }

  private boolean O()
  {
    return (this.z != null) && (!l()) && (!this.V) && (this.U == 3) && (this.Y != 0) && (this.z.e()) && (!this.z.d());
  }

  private boolean P()
  {
    return (this.i != null) && (this.i.e()) && (!TextUtils.isEmpty(this.i.a()));
  }

  private void Q()
  {
    if (this.aj != null)
    {
      this.aa.a(this.aj);
      return;
    }
    this.aa.a(true);
  }

  private void a(int paramInt1, int paramInt2)
  {
    this.d = new android.support.v4.util.Pair(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }

  private void a(long paramLong, int paramInt)
  {
    int i1 = -1;
    switch (paramInt)
    {
    default:
    case 0:
    case 1:
    }
    while (true)
    {
      a(i1, paramInt);
      return;
      if ((this.e != null) && (this.s != null))
      {
        i1 = this.e.a(paramLong);
        if (this.s.c(i1) == null)
        {
          i1 = 0;
          continue;
          if ((this.f != null) && (this.B != null))
          {
            int i2 = this.f.a(paramLong);
            if ((i2 != i1) && (this.B.a(i2) != null))
              i1 = i2;
          }
        }
      }
    }
  }

  private void a(Activity paramActivity)
  {
    if (O())
    {
      com.viber.voip.ads.b.c.b.a locala = new b.a.a(paramActivity).a(false).a();
      this.z.a(locala, this.ak);
    }
  }

  private void a(com.viber.voip.ads.b.c.c.c paramc)
  {
    if ((this.aj != null) && (this.aj.equals(paramc)));
    do
    {
      return;
      this.aj = paramc;
      Q();
    }
    while (this.aj == null);
    this.z.l();
  }

  private void a(b.b paramb)
  {
    boolean bool1 = true;
    View localView1 = this.D;
    boolean bool2;
    View localView2;
    if (paramb == b.b.b)
    {
      bool2 = bool1;
      localView1.setSelected(bool2);
      localView2 = this.E;
      if (paramb != b.b.a)
        break label49;
    }
    while (true)
    {
      localView2.setSelected(bool1);
      return;
      bool2 = false;
      break;
      label49: bool1 = false;
    }
  }

  private void a(Member paramMember)
  {
    MemberActionInfo localMemberActionInfo = new MemberActionInfo(paramMember, P());
    if (this.y.a(com.viber.voip.permissions.n.h))
    {
      this.g.a(localMemberActionInfo, this.af);
      return;
    }
    this.y.a(this, 49, com.viber.voip.permissions.n.h, localMemberActionInfo);
  }

  private void a(AggregatedCall paramAggregatedCall)
  {
    if (paramAggregatedCall == null)
      return;
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramAggregatedCall);
    this.ad.a(1);
    ViberApplication.getInstance().getRecentCallsManager().a(localArrayList, new ad(this));
  }

  private void a(boolean paramBoolean, com.viber.voip.model.c paramc)
  {
    b(paramc.getId(), 0);
    com.viber.voip.model.j localj = paramc.n();
    String str1;
    String str2;
    label42: Collection localCollection;
    long l1;
    String str3;
    String str4;
    Uri localUri;
    if (localj != null)
    {
      str1 = localj.c();
      if (localj == null)
        break label148;
      str2 = localj.a();
      localCollection = paramc.t();
      l1 = paramc.getId();
      str3 = paramc.k();
      str4 = paramc.q();
      localUri = paramc.o();
      if (localCollection.isEmpty())
        break label154;
    }
    label148: label154: for (String str5 = (String)localCollection.iterator().next(); ; str5 = null)
    {
      Intent localIntent = ViberActionRunner.o.a(false, l1, str3, str4, localUri, str5, str1, str2);
      this.m.a(paramBoolean, localIntent);
      return;
      str1 = null;
      break;
      str2 = null;
      break label42;
    }
  }

  private void b(long paramLong, int paramInt)
  {
    this.c = new android.support.v4.util.Pair(Long.valueOf(paramLong), Integer.valueOf(paramInt));
    a(paramLong, paramInt);
  }

  private void b(ConferenceInfo paramConferenceInfo)
  {
    FragmentActivity localFragmentActivity = requireActivity();
    if (P());
    for (String str = "Search Results"; ; str = "Contacts list")
    {
      startActivity(ViberActionRunner.r.a(localFragmentActivity, paramConferenceInfo, str));
      return;
    }
  }

  private void b(boolean paramBoolean, int paramInt)
  {
    ((com.viber.voip.contacts.c.d.g)this.h.get()).b(this);
    this.k.post(new Runnable()
    {
      public void run()
      {
        ContactsFragment.this.q.setRefreshing(false);
      }
    });
  }

  private void d(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.r.getItem(paramInt);
    if (localObject == null);
    while (true)
    {
      return;
      AggregatedCall localAggregatedCall;
      com.viber.voip.model.a locala2;
      Intent localIntent;
      if ((localObject instanceof AggregatedCall))
      {
        b(((AggregatedCall)localObject).getId(), 1);
        localAggregatedCall = (AggregatedCall)localObject;
        locala2 = localAggregatedCall.getContact();
        if ((localAggregatedCall.isTypeViberGroup()) && (localAggregatedCall.hasConferenceInfo()))
          localIntent = ViberActionRunner.r.a(requireActivity(), localAggregatedCall.getAggregatedHash(), localAggregatedCall.getConferenceInfo(), "Contacts list");
      }
      while (localIntent != null)
      {
        this.m.a(paramBoolean, localIntent);
        return;
        if (locala2 != null)
        {
          com.viber.voip.model.j localj2 = locala2.n();
          String str3;
          label142: String str4;
          label156: long l1;
          String str5;
          String str6;
          String str7;
          Uri localUri;
          if (localj2 != null)
          {
            str3 = localj2.c();
            if (localj2 == null)
              break label261;
            str4 = localj2.a();
            l1 = locala2.getId();
            str5 = locala2.q();
            str6 = localAggregatedCall.getCanonizedNumber();
            str7 = locala2.k();
            localUri = locala2.o();
            if ((!localAggregatedCall.isViberCall()) || (!locala2.p()))
              break label267;
          }
          label261: label267: for (boolean bool = true; ; bool = false)
          {
            localIntent = ViberActionRunner.o.a(l1, str5, str6, str3, str7, localUri, bool, localAggregatedCall.getAggregatedHash(), str4);
            break;
            str3 = null;
            break label142;
            str4 = null;
            break label156;
          }
        }
        localIntent = ViberActionRunner.o.a(localAggregatedCall.getCanonizedNumber(), localAggregatedCall.isViberCall(), localAggregatedCall.getAggregatedHash());
        continue;
        if ((localObject instanceof com.viber.voip.model.a))
        {
          b(((com.viber.voip.model.a)localObject).getId(), 1);
          com.viber.voip.model.a locala1 = (com.viber.voip.model.a)localObject;
          com.viber.voip.model.j localj1 = locala1.n();
          String str1;
          if (localj1 != null)
          {
            str1 = localj1.c();
            label352: if (localj1 == null)
              break label414;
          }
          label414: for (String str2 = localj1.a(); ; str2 = null)
          {
            localIntent = ViberActionRunner.o.a(false, locala1.getId(), locala1.k(), locala1.q(), locala1.o(), null, str1, str2);
            break;
            str1 = null;
            break label352;
          }
        }
        localIntent = null;
      }
    }
  }

  private void d(boolean paramBoolean)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null)
      return;
    if (((!dj.c(localFragmentActivity)) && (dj.b(getActivity()))) || (!paramBoolean))
    {
      if (!paramBoolean);
      for (boolean bool = true; ; bool = false)
      {
        c(bool);
        return;
      }
    }
    c(paramBoolean);
  }

  private com.viber.common.permission.b i()
  {
    return new com.viber.voip.permissions.g(this, this.ag.a(new int[] { 0 }))
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
      }
    };
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.b != paramInt)
    {
      this.b = paramInt;
      if ((c()) && (!paramBoolean))
      {
        this.e.l();
        this.f.l();
      }
      if ((getActivity() != null) && (this.b != -1) && ((this.W != -1) || (this.b != 4)) && (this.W != this.b))
        break label81;
    }
    label81: 
    do
    {
      return;
      this.W = this.b;
      runOnUiThread(new aa(this));
    }
    while ((paramInt != 3) || (d.p.l.d()) || (ViberApplication.getInstance().isOnForeground()));
    com.viber.voip.ui.dialogs.a.e().a(this).b(this);
  }

  public void a(Intent paramIntent)
  {
    if (bb.a(paramIntent))
    {
      if (this.e != null)
        break label27;
      this.I = new Intent(paramIntent);
    }
    label27: long l1;
    String str;
    do
    {
      return;
      l1 = paramIntent.getLongExtra("contact_id", -1L);
      b(l1, 0);
      str = paramIntent.getStringExtra("con_number");
      if (l1 != -1L)
      {
        a(true);
        return;
      }
    }
    while (TextUtils.isEmpty(str));
    ViberApplication.getInstance().getContactManager().c().a(str, l1, new ab(this, str));
  }

  public void a(ConferenceInfo paramConferenceInfo)
  {
    this.i.f();
    b(paramConferenceInfo);
  }

  public void a(com.viber.voip.model.c paramc)
  {
    com.viber.voip.model.j localj = paramc.n();
    if (localj != null)
      a(Member.from(localj));
  }

  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      CallInitiationId.noteNextCallInitiationAttemptId();
      h localh = (h)this.af.get();
      h.a.a locala = h.a.i().a(new String[] { paramString }).a("Recents - Main Screen").a(paramBoolean1, paramBoolean2).b(paramBoolean1);
      boolean bool = false;
      if (!paramBoolean1)
        bool = true;
      localh.b(locala.a(bool).a());
      if (paramBoolean1)
        ViberApplication.getInstance().getEngine(true).getDialerController().handleDialViberOut(paramString);
    }
    else
    {
      return;
    }
    ViberApplication.getInstance().getEngine(true).getDialerController().handleDial(paramString, paramBoolean2);
  }

  protected void a(boolean paramBoolean)
  {
    if ((this.r == null) || (this.i == null))
      return;
    if (!TextUtils.isEmpty(this.i.a()))
    {
      super.v_();
      return;
    }
    if (H() != null)
    {
      int i2 = J();
      getListView().setItemChecked(i2, true);
      d(i2, paramBoolean);
      return;
    }
    com.viber.voip.model.c localc = G();
    int i1 = J();
    if (localc != null)
    {
      getListView().setItemChecked(i1, true);
      a(paramBoolean, localc);
      return;
    }
    a(0);
  }

  protected void a(boolean paramBoolean, int paramInt)
  {
    super.a(paramBoolean, paramInt);
    if ((this.L != null) && (this.L.b() != null) && (this.T != null))
      this.T.a(paramBoolean, paramInt);
  }

  protected boolean a()
  {
    return (this.i != null) && (this.i.e());
  }

  public void b()
  {
    a(null);
  }

  public void b(int paramInt)
  {
    b(true, paramInt);
  }

  @Deprecated
  protected void b(int paramInt, boolean paramBoolean)
  {
  }

  protected void b(MenuItem paramMenuItem)
  {
    if (g())
    {
      this.i.a(paramMenuItem, this.O, this.P);
      onSearchViewShow(this.O);
    }
  }

  public void b(com.viber.voip.model.c paramc)
  {
    com.viber.voip.model.j localj = paramc.n();
    if (localj != null)
    {
      String str = localj.c();
      if (!TextUtils.isEmpty(str))
      {
        CallInitiationId.noteNextCallInitiationAttemptId();
        ((h)this.af.get()).b(h.a.i().a(new String[] { str }).a("Contacts list").a(false, true).b(false).a(true).a());
        ViberApplication.getInstance().getEngine(true).getDialerController().handleDial(str, true);
      }
    }
  }

  public void b(boolean paramBoolean)
  {
    com.viber.voip.z localz = com.viber.voip.aa.b(this);
    SwipeRefreshLayout localSwipeRefreshLayout;
    if (localz != null)
    {
      localz.a(paramBoolean);
      if (paramBoolean)
        this.mRemoteBannerDisplayController.d();
    }
    else
    {
      d(paramBoolean);
      if (this.p != null)
      {
        localSwipeRefreshLayout = this.q;
        if ((paramBoolean) || (!m()))
          break label75;
      }
    }
    label75: for (boolean bool = true; ; bool = false)
    {
      localSwipeRefreshLayout.setEnabled(bool);
      return;
      this.mRemoteBannerDisplayController.c();
      break;
    }
  }

  public void c(int paramInt)
  {
    d.p.h.a(paramInt);
  }

  public void c(com.viber.voip.model.c paramc)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramc.t().iterator();
    while (localIterator.hasNext())
      localArrayList.add(ParticipantSelector.Participant.createUnknown((String)localIterator.next()));
    x.a(getActivity(), localArrayList, null, null, x.a.c, new ParticipantSelector.d()
    {
      public void a(ParticipantSelector.Participant paramAnonymousParticipant)
      {
      }

      public void a(boolean paramAnonymousBoolean, ParticipantSelector.Participant paramAnonymousParticipant)
      {
        ContactsFragment.d(ContactsFragment.this).a(ae.b(), "Contacts", 1.0D);
        if (ContactsFragment.e(ContactsFragment.this))
        {
          ViberActionRunner.af.a(ContactsFragment.this.getActivity(), paramAnonymousParticipant.getNumber());
          return;
        }
        ViberActionRunner.af.a(ContactsFragment.this.getActivity(), Collections.singletonList(paramAnonymousParticipant.getNumber()));
      }
    });
  }

  protected void c(boolean paramBoolean)
  {
    dj.a(this.G, paramBoolean);
    dj.a(this.H, paramBoolean);
  }

  public boolean c()
  {
    return (this.e != null) && (this.e.d()) && (this.f != null) && (this.f.d());
  }

  public void c_(int paramInt)
  {
    b(false, paramInt);
  }

  public void d()
  {
    b(true, 0);
  }

  @Deprecated
  protected void d(int paramInt)
  {
    super.d(paramInt);
  }

  protected void e()
  {
    boolean bool1 = true;
    if (this.U == 3)
    {
      ak localak;
      b.b localb;
      int i1;
      boolean bool2;
      if ((this.j != null) || ((!ao.f()) && (!this.y.a(com.viber.voip.permissions.n.j))))
      {
        localak = r();
        localb = k();
        i1 = this.b;
        bool2 = l();
        if ((!this.V) && (TextUtils.isEmpty(this.P)))
          break label90;
      }
      while (true)
      {
        localak.a(localb, i1, bool2, bool1, K());
        return;
        label90: bool1 = false;
      }
    }
    r().d(bool1);
  }

  public void e(int paramInt)
  {
    if (this.e == null)
      d.p.h.a(paramInt);
    do
    {
      return;
      w();
      this.O = false;
      b.b localb = b.b.values()[paramInt];
      this.e.a(localb);
      a(localb);
      this.ac.a(StoryConstants.h.a.a(s()));
    }
    while (this.s == null);
    this.s.notifyDataSetChanged();
  }

  protected void f()
  {
    ((ContactsListView)this.p).a(false, this.mIsTablet);
  }

  protected void h()
  {
    f();
    this.p.setOnCreateContextMenuListener(this);
    ViberListView localViberListView = this.p;
    if (this.mIsTablet);
    for (int i1 = 1; ; i1 = 0)
    {
      localViberListView.setChoiceMode(i1);
      this.f.p();
      this.f.i();
      this.e.p();
      if (TextUtils.isEmpty(this.P))
        break;
      this.e.a(this.P, dr.a(this.P), b.b.b);
      return;
    }
    this.e.b(k());
  }

  public com.viber.voip.contacts.b j()
  {
    return new com.viber.voip.contacts.b(4, getActivity(), getLoaderManager(), this.h, this, k());
  }

  public b.b k()
  {
    return b.b.values()[d.p.h.d()];
  }

  public boolean l()
  {
    return false;
  }

  protected boolean m()
  {
    return !ao.f();
  }

  protected boolean n()
  {
    return l();
  }

  protected int o()
  {
    return R.string.contact_list_permission_description;
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    LayoutInflater localLayoutInflater = getLayoutInflater();
    FragmentActivity localFragmentActivity = getActivity();
    boolean bool1 = this.mIsTablet;
    com.viber.voip.contacts.b.a locala1 = this.e.w();
    com.viber.voip.contacts.b.a locala2 = this.e.u();
    boolean bool2;
    if (!l())
    {
      bool2 = true;
      this.s = new com.viber.voip.contacts.adapters.j(localFragmentActivity, bool1, locala1, this, this, locala2, bool2, localLayoutInflater);
      this.t = new com.viber.voip.contacts.adapters.l(getActivity(), this.mIsTablet, this.e.v(), true, localLayoutInflater);
      this.B = new com.viber.voip.calls.ui.ad(getActivity(), this.f, null, null, this.i, false);
      this.B.a(this);
      this.r = new com.b.a.a.a();
      this.ab = new n(this.r, this.C, this.F, this.E, this.D, this.u, this.y, this.e, this.f, l(), this.mIsTablet, this);
      F();
      p();
      this.p.setAdapter(this.r);
      this.p.a(this);
      this.p.setOnTouchListener(this);
      if (this.z != null)
      {
        this.z.b(this.p, this.r);
        this.z.a(this);
      }
      if (this.mIsTablet)
        L();
      if (!l())
      {
        this.x.a(this.Z);
        if (!this.x.b())
          break label372;
        this.x.c(this.Z);
      }
    }
    while (true)
    {
      if (com.viber.voip.aa.a(this))
      {
        E();
        if ((this.L != null) && (this.L.b() != null) && (this.T != null))
          this.T.a(this.L.b());
      }
      return;
      bool2 = false;
      break;
      label372: this.x.h();
    }
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
    FragmentActivity localFragmentActivity = getActivity();
    if (!(localFragmentActivity instanceof a))
    {
      Fragment localFragment4 = getParentFragment();
      if (!(localFragment4 instanceof a))
        throw new ClassCastException("ContactsFragment.Callbacks is not implemented!");
      this.m = ((a)localFragment4);
    }
    Fragment localFragment2;
    while (true)
      if (!(localFragmentActivity instanceof com.viber.voip.permissions.l))
      {
        Fragment localFragment3 = getParentFragment();
        if (!(localFragment3 instanceof com.viber.voip.permissions.l))
        {
          throw new ClassCastException("PermissionConfigProvider is not implemented!");
          this.m = ((a)paramContext);
        }
        else
        {
          this.ag = ((com.viber.voip.permissions.l)localFragment3).getPermissionConfigForFragment(this);
          if ((localFragmentActivity instanceof b))
            break label188;
          localFragment2 = getParentFragment();
          if (!(localFragment2 instanceof b))
            break;
        }
      }
    label188: for (this.n = ((b)localFragment2); ; this.n = ((b)paramContext))
    {
      if ((localFragmentActivity instanceof d))
        break label199;
      Fragment localFragment1 = getParentFragment();
      if ((localFragment1 instanceof d))
        this.o = ((d)localFragment1);
      return;
      this.ag = ((com.viber.voip.permissions.l)localFragmentActivity).getPermissionConfigForFragment(this);
      break;
    }
    label199: this.o = ((d)paramContext);
  }

  public boolean onBackPressed()
  {
    if ((this.i != null) && (this.i.e()))
    {
      this.i.f();
      return true;
    }
    return false;
  }

  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == R.id.sync_contact_btn)
      this.g.b();
    do
    {
      return;
      if (i1 == R.id.invite_contact_btn)
      {
        startActivity(new Intent("com.viber.voip.action.INVITE_TO_VIBER"));
        return;
      }
      if (i1 == R.id.sync_retry)
      {
        this.g.b();
        return;
      }
      if ((i1 == R.id.filterAllView) || (i1 == R.id.filterViberView))
      {
        e(Integer.valueOf((String)paramView.getTag()).intValue());
        this.X = true;
        return;
      }
      if (i1 == R.id.button_request_permission)
      {
        int i2 = this.ag.a(0);
        this.y.a(this, i2, com.viber.voip.permissions.n.j);
        return;
      }
    }
    while ((i1 != R.id.openAllView) || (this.o == null));
    this.o.f();
  }

  // ERROR //
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 1280	com/viber/voip/ui/o:onContextItemSelected	(Landroid/view/MenuItem;)Z
    //   5: ifne +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aload_1
    //   11: invokeinterface 1286 1 0
    //   16: checkcast 1288	android/widget/AdapterView$AdapterContextMenuInfo
    //   19: astore_2
    //   20: aload_2
    //   21: ifnull -13 -> 8
    //   24: aload_2
    //   25: getfield 1291	android/widget/AdapterView$AdapterContextMenuInfo:targetView	Landroid/view/View;
    //   28: ifnull -20 -> 8
    //   31: aload_2
    //   32: getfield 1291	android/widget/AdapterView$AdapterContextMenuInfo:targetView	Landroid/view/View;
    //   35: invokevirtual 1261	android/view/View:getTag	()Ljava/lang/Object;
    //   38: instanceof 1293
    //   41: ifeq +25 -> 66
    //   44: aload_0
    //   45: aload_2
    //   46: getfield 1291	android/widget/AdapterView$AdapterContextMenuInfo:targetView	Landroid/view/View;
    //   49: invokevirtual 1261	android/view/View:getTag	()Ljava/lang/Object;
    //   52: checkcast 1293	com/viber/voip/calls/ui/u
    //   55: invokevirtual 1295	com/viber/voip/calls/ui/u:e	()Ljava/lang/Object;
    //   58: checkcast 372	com/viber/voip/model/AggregatedCall
    //   61: invokespecial 1297	com/viber/voip/contacts/ui/ContactsFragment:a	(Lcom/viber/voip/model/AggregatedCall;)V
    //   64: iconst_1
    //   65: ireturn
    //   66: aload_2
    //   67: getfield 1291	android/widget/AdapterView$AdapterContextMenuInfo:targetView	Landroid/view/View;
    //   70: invokevirtual 1261	android/view/View:getTag	()Ljava/lang/Object;
    //   73: checkcast 1299	com/viber/voip/contacts/ui/m
    //   76: astore_3
    //   77: aload_3
    //   78: ifnull -70 -> 8
    //   81: aload_3
    //   82: invokevirtual 1301	com/viber/voip/contacts/ui/m:a	()Lcom/viber/voip/model/c;
    //   85: ifnull -77 -> 8
    //   88: aload_3
    //   89: invokevirtual 1301	com/viber/voip/contacts/ui/m:a	()Lcom/viber/voip/model/c;
    //   92: astore 4
    //   94: aload 4
    //   96: invokeinterface 594 1 0
    //   101: astore 5
    //   103: aload_1
    //   104: invokeinterface 1304 1 0
    //   109: istore 6
    //   111: iload 6
    //   113: getstatic 1307	com/viber/voip/R$string:menu_addStar	I
    //   116: if_icmpeq +11 -> 127
    //   119: iload 6
    //   121: getstatic 1310	com/viber/voip/R$string:menu_removeStar	I
    //   124: if_icmpne +57 -> 181
    //   127: aload_0
    //   128: getfield 413	com/viber/voip/contacts/ui/ContactsFragment:y	Lcom/viber/common/permission/c;
    //   131: getstatic 1050	com/viber/voip/permissions/n:j	[Ljava/lang/String;
    //   134: invokevirtual 423	com/viber/common/permission/c:a	([Ljava/lang/String;)Z
    //   137: ifeq -73 -> 64
    //   140: aload 4
    //   142: invokeinterface 1312 1 0
    //   147: ifne +28 -> 175
    //   150: iconst_1
    //   151: istore 7
    //   153: iload 7
    //   155: aload 4
    //   157: invokeinterface 589 1 0
    //   162: aload 4
    //   164: invokeinterface 606 1 0
    //   169: invokestatic 1315	com/viber/voip/contacts/ui/aj:a	(ZJLjava/lang/String;)V
    //   172: goto -108 -> 64
    //   175: iconst_0
    //   176: istore 7
    //   178: goto -25 -> 153
    //   181: iload 6
    //   183: getstatic 1318	com/viber/voip/R$id:menu_contact_free_call	I
    //   186: if_icmpne +20 -> 206
    //   189: aload 5
    //   191: ifnull -127 -> 64
    //   194: aload_0
    //   195: aload 5
    //   197: invokestatic 857	com/viber/voip/memberid/Member:from	(Lcom/viber/voip/model/j;)Lcom/viber/voip/memberid/Member;
    //   200: invokespecial 859	com/viber/voip/contacts/ui/ContactsFragment:a	(Lcom/viber/voip/memberid/Member;)V
    //   203: goto -139 -> 64
    //   206: iload 6
    //   208: getstatic 1321	com/viber/voip/R$id:menu_contact_free_message	I
    //   211: if_icmpne +39 -> 250
    //   214: aload 5
    //   216: ifnull -152 -> 64
    //   219: aload_0
    //   220: getfield 542	com/viber/voip/contacts/ui/ContactsFragment:g	Lcom/viber/voip/contacts/ui/aj;
    //   223: aload 5
    //   225: invokeinterface 599 1 0
    //   230: aload 5
    //   232: invokeinterface 598 1 0
    //   237: aload 4
    //   239: invokeinterface 604 1 0
    //   244: invokevirtual 1324	com/viber/voip/contacts/ui/aj:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   247: goto -183 -> 64
    //   250: iload 6
    //   252: getstatic 1327	com/viber/voip/R$id:menu_contact_edit	I
    //   255: if_icmpne +20 -> 275
    //   258: aload_0
    //   259: invokevirtual 256	com/viber/voip/contacts/ui/ContactsFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   262: aload 4
    //   264: invokeinterface 606 1 0
    //   269: invokestatic 1328	com/viber/voip/contacts/ui/aj:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   272: goto -208 -> 64
    //   275: iload 6
    //   277: getstatic 1331	com/viber/voip/R$id:menu_contact_delete	I
    //   280: if_icmpne +100 -> 380
    //   283: new 1333	android/os/Bundle
    //   286: dup
    //   287: invokespecial 1334	android/os/Bundle:<init>	()V
    //   290: astore 8
    //   292: aload 8
    //   294: ldc_w 814
    //   297: aload 4
    //   299: invokeinterface 589 1 0
    //   304: invokevirtual 1338	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   307: aload 8
    //   309: ldc_w 1340
    //   312: aload 4
    //   314: invokeinterface 606 1 0
    //   319: invokevirtual 1344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   322: invokestatic 1348	com/viber/voip/ui/dialogs/k:f	()Lcom/viber/common/dialogs/l$a;
    //   325: aload_0
    //   326: invokevirtual 798	com/viber/common/dialogs/l$a:a	(Landroid/support/v4/app/Fragment;)Lcom/viber/common/dialogs/a$a;
    //   329: aload 8
    //   331: invokevirtual 1351	com/viber/common/dialogs/a$a:a	(Landroid/os/Parcelable;)Lcom/viber/common/dialogs/a$a;
    //   334: astore 9
    //   336: iconst_2
    //   337: anewarray 498	java/lang/Object
    //   340: astore 10
    //   342: aload 10
    //   344: iconst_0
    //   345: aload 4
    //   347: invokeinterface 604 1 0
    //   352: aastore
    //   353: aload 10
    //   355: iconst_1
    //   356: aload 4
    //   358: invokeinterface 604 1 0
    //   363: aastore
    //   364: aload 9
    //   366: iconst_m1
    //   367: aload 10
    //   369: invokevirtual 1354	com/viber/common/dialogs/a$a:b	(I[Ljava/lang/Object;)Lcom/viber/common/dialogs/a$a;
    //   372: aload_0
    //   373: invokevirtual 803	com/viber/common/dialogs/a$a:b	(Landroid/support/v4/app/Fragment;)Lcom/viber/common/dialogs/m;
    //   376: pop
    //   377: goto -313 -> 64
    //   380: iload 6
    //   382: getstatic 1357	com/viber/voip/R$id:menu_contact_google_voice	I
    //   385: if_icmpne +218 -> 603
    //   388: aload_0
    //   389: invokevirtual 256	com/viber/voip/contacts/ui/ContactsFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   392: invokevirtual 1363	android/support/v4/app/FragmentActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   395: astore 14
    //   397: getstatic 1369	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   400: astore 15
    //   402: iconst_1
    //   403: anewarray 623	java/lang/String
    //   406: dup
    //   407: iconst_0
    //   408: ldc_w 1371
    //   411: aastore
    //   412: astore 16
    //   414: iconst_2
    //   415: anewarray 623	java/lang/String
    //   418: astore 17
    //   420: aload 17
    //   422: iconst_0
    //   423: aload 4
    //   425: invokeinterface 1373 1 0
    //   430: invokestatic 1376	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   433: aastore
    //   434: aload 17
    //   436: iconst_1
    //   437: ldc_w 1378
    //   440: aastore
    //   441: aload 14
    //   443: aload 15
    //   445: aload 16
    //   447: ldc_w 1380
    //   450: aload 17
    //   452: aconst_null
    //   453: invokevirtual 1386	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   456: astore 18
    //   458: aload 18
    //   460: astore 13
    //   462: aconst_null
    //   463: astore 19
    //   465: aload 13
    //   467: ifnull +45 -> 512
    //   470: aload 13
    //   472: invokeinterface 1391 1 0
    //   477: istore 23
    //   479: aconst_null
    //   480: astore 19
    //   482: iload 23
    //   484: ifeq +28 -> 512
    //   487: aload 13
    //   489: invokeinterface 1392 1 0
    //   494: iconst_1
    //   495: if_icmple +52 -> 547
    //   498: aload_0
    //   499: invokevirtual 256	com/viber/voip/contacts/ui/ContactsFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   502: ldc_w 1394
    //   505: iconst_0
    //   506: invokestatic 1400	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   509: invokevirtual 1403	android/widget/Toast:show	()V
    //   512: aload_0
    //   513: invokevirtual 256	com/viber/voip/contacts/ui/ContactsFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   516: astore 20
    //   518: aload 19
    //   520: ifnonnull +40 -> 560
    //   523: ldc_w 1405
    //   526: astore 22
    //   528: aload 20
    //   530: aload 22
    //   532: iconst_0
    //   533: invokestatic 1400	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   536: invokevirtual 1403	android/widget/Toast:show	()V
    //   539: aload 13
    //   541: invokestatic 1410	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   544: goto -480 -> 64
    //   547: aload 13
    //   549: iconst_0
    //   550: invokeinterface 1414 2 0
    //   555: astore 19
    //   557: goto -45 -> 512
    //   560: new 1416	java/lang/StringBuilder
    //   563: dup
    //   564: invokespecial 1417	java/lang/StringBuilder:<init>	()V
    //   567: ldc_w 1419
    //   570: invokevirtual 1423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: aload 19
    //   575: invokevirtual 1423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: invokevirtual 1426	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: astore 21
    //   583: aload 21
    //   585: astore 22
    //   587: goto -59 -> 528
    //   590: astore 12
    //   592: aconst_null
    //   593: astore 13
    //   595: aload 13
    //   597: invokestatic 1410	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   600: aload 12
    //   602: athrow
    //   603: iload 6
    //   605: getstatic 1429	com/viber/voip/R$id:menu_contact_system_info	I
    //   608: if_icmpne +19 -> 627
    //   611: aload_0
    //   612: getfield 542	com/viber/voip/contacts/ui/ContactsFragment:g	Lcom/viber/voip/contacts/ui/aj;
    //   615: aload_0
    //   616: invokevirtual 256	com/viber/voip/contacts/ui/ContactsFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   619: aload 4
    //   621: invokevirtual 1432	com/viber/voip/contacts/ui/aj:a	(Landroid/content/Context;Lcom/viber/voip/model/c;)V
    //   624: goto -560 -> 64
    //   627: aload_0
    //   628: aload_1
    //   629: invokespecial 1280	com/viber/voip/ui/o:onContextItemSelected	(Landroid/view/MenuItem;)Z
    //   632: ireturn
    //   633: astore 12
    //   635: goto -40 -> 595
    //
    // Exception table:
    //   from	to	target	type
    //   388	458	590	finally
    //   470	479	633	finally
    //   487	512	633	finally
    //   512	518	633	finally
    //   528	539	633	finally
    //   547	557	633	finally
    //   560	583	633	finally
  }

  public void onCreate(Bundle paramBundle)
  {
    this.i = new MenuSearchMediator(this);
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      b(paramBundle.getLong("selected_contact_id", -1L), paramBundle.getInt("selected_item_loader_type", 0));
      this.J = paramBundle.getParcelable("list_instance_state");
    }
    setHasOptionsMenu(true);
    FragmentActivity localFragmentActivity = getActivity();
    this.y = com.viber.common.permission.c.a(localFragmentActivity);
    this.ah = i();
    this.g = new aj(localFragmentActivity);
    this.h = ViberApplication.getInstance().getLazyContactManager();
    this.l = ViberApplication.getInstance().getLazyMessagesManager();
    com.viber.voip.analytics.g localg = com.viber.voip.analytics.g.a();
    this.ac = localg.c().a();
    this.ad = localg.c().h();
    this.ae = localg.c().c();
    this.af = ViberApplication.getInstance().getLazyUserStartsCallEventCollector();
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AdapterView.AdapterContextMenuInfo localAdapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    if ((localAdapterContextMenuInfo.targetView.getTag() == null) || ((!(localAdapterContextMenuInfo.targetView.getTag() instanceof m)) && (!(localAdapterContextMenuInfo.targetView.getTag() instanceof u))));
    TextView localTextView;
    m localm;
    do
    {
      return;
      View localView = getLayoutInflater().inflate(R.layout.context_menu_header, null);
      localTextView = (TextView)localView.findViewById(R.id.text);
      paramContextMenu.setHeaderView(localView);
      if ((localAdapterContextMenuInfo.targetView.getTag() instanceof u))
      {
        paramContextMenu.add(0, R.string.btn_msg_delete, 0, R.string.btn_msg_delete);
        String str = ((u)localAdapterContextMenuInfo.targetView.getTag()).b();
        if (!TextUtils.isEmpty(str))
          localTextView.setText(str);
        super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
        return;
      }
      localm = (m)localAdapterContextMenuInfo.targetView.getTag();
    }
    while ((localm == null) || (localm.a() == null) || (localm.a().getId() == -1L));
    com.viber.voip.model.c localc = localm.a();
    localTextView.setText(localc.k());
    if (localc.r())
      paramContextMenu.add(0, R.string.menu_removeStar, 0, R.string.menu_removeStar);
    while (true)
    {
      if (localc.p())
      {
        paramContextMenu.add(0, R.id.menu_contact_free_call, 0, R.string.menu_free_call);
        paramContextMenu.add(0, R.id.menu_contact_free_message, 0, R.string.menu_free_message);
      }
      if (ao.f())
        break;
      getActivity().getMenuInflater().inflate(R.menu.context_menu_contacts, paramContextMenu);
      break;
      paramContextMenu.add(0, R.string.menu_addStar, 0, R.string.menu_addStar);
    }
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    if ((!g()) || (isDetached()) || (getActivity() == null))
      return;
    paramMenuInflater.inflate(R.menu.menu_contacts, paramMenu);
    if (ao.f())
      paramMenu.removeItem(R.id.menu_add_contact);
    while (true)
    {
      MenuItem localMenuItem = paramMenu.findItem(R.id.menu_search);
      SearchView localSearchView = (SearchView)localMenuItem.getActionView();
      localSearchView.setQueryHint(ViberApplication.getLocalizedResources().getString(R.string.menu_search));
      dj.a(localSearchView, getContext());
      b(localMenuItem);
      return;
      this.H = paramMenu.findItem(R.id.menu_add_contact);
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout._ics_fragment_contacts, paramViewGroup, false);
    this.p = ((ViberListView)localView.findViewById(16908298));
    this.q = ((SwipeRefreshLayout)localView.findViewById(R.id.swipe_refresh_layout));
    this.q.setOnRefreshListener(this);
    this.q.setProgressBackgroundColorSchemeResource(dc.a(this.q.getContext(), R.attr.swipeToRefreshBackground));
    SwipeRefreshLayout localSwipeRefreshLayout = this.q;
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = dc.a(this.q.getContext(), R.attr.swipeToRefreshArrowColor);
    localSwipeRefreshLayout.setColorSchemeResources(arrayOfInt);
    if (com.viber.common.d.a.g())
      this.p.setNestedScrollingEnabled(true);
    this.q.setEnabled(m());
    if (this.h != null)
      ((com.viber.voip.contacts.c.d.g)this.h.get()).a(this.al);
    this.F = ((SearchNoResultsView)paramLayoutInflater.inflate(R.layout.search_no_results_item, this.p, false));
    this.e = j();
    this.f = new com.viber.voip.calls.b(getActivity(), getLoaderManager(), "", this);
    this.C = paramLayoutInflater.inflate(R.layout.view_no_permission, this.p, false);
    this.u = paramLayoutInflater.inflate(R.layout.view_contacts_section_header, this.p, false);
    if (!l())
    {
      this.v = paramLayoutInflater.inflate(R.layout.view_recent_calls_section_top_header, this.p, false);
      this.v.findViewById(R.id.openAllView).setOnClickListener(this);
      this.w = paramLayoutInflater.inflate(R.layout.view_recent_calls_section_bottom_header, this.p, false);
    }
    this.D = this.u.findViewById(R.id.filterAllView);
    this.E = this.u.findViewById(R.id.filterViberView);
    if (!l())
    {
      this.D.setOnClickListener(this);
      this.E.setOnClickListener(this);
      a(this.e.r());
    }
    while (true)
    {
      if (m())
        dj.a(this.p, new Runnable()
        {
          public void run()
          {
            int i = ContactsFragment.this.getResources().getDimensionPixelOffset(R.dimen.contacts_list_fast_scroll_touch_area_width);
            int j = ContactsFragment.this.getResources().getDimensionPixelOffset(R.dimen.contacts_list_fast_scroll_touch_area_height);
            int k = ContactsFragment.this.p.getTop();
            int m = ContactsFragment.this.p.getRight();
            int n = ContactsFragment.this.p.getLeft();
            if (ContactsFragment.c(ContactsFragment.this))
            {
              ContactsFragment.a(ContactsFragment.this, new Rect(n, k, i + n, j + k));
              return;
            }
            ContactsFragment.a(ContactsFragment.this, new Rect(m - i, k, m, j + k));
          }
        });
      return localView;
      this.D.setVisibility(8);
      this.E.setVisibility(8);
      this.ac.b(ae.b());
    }
  }

  public void onDestroy()
  {
    super.onDestroy();
    this.x.b(this.Z);
    ((com.viber.voip.contacts.c.d.g)this.h.get()).b(this);
  }

  public void onDestroyOptionsMenu()
  {
    super.onDestroyOptionsMenu();
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    this.e.q();
    this.f.q();
    c(this.e.r().ordinal());
    if (this.p != null)
      this.q.setOnRefreshListener(null);
    if (this.j != null);
    try
    {
      this.j.d(false);
      label62: this.j = null;
      if (this.B != null)
        this.B.a(null);
      if (this.T != null)
        this.T.b();
      if (this.z != null)
      {
        this.z.m();
        this.z.b(this);
      }
      return;
    }
    catch (Exception localException)
    {
      break label62;
    }
  }

  public void onDetach()
  {
    super.onDetach();
    if (this.i != null)
      this.i.c(true);
    if (this.h != null)
      ((com.viber.voip.contacts.c.d.g)this.h.get()).b(this.al);
    this.f = null;
  }

  public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    if (paramm.a(DialogCode.D108))
      switch (paramInt)
      {
      default:
      case -1:
      }
    while ((!paramm.a(DialogCode.D336b)) || (paramInt != -1))
    {
      return;
      this.g.b();
      return;
    }
    Bundle localBundle = (Bundle)paramm.d();
    ViberApplication.getInstance().getContactManager().a(localBundle.getLong("contact_id"), localBundle.getString("lookup_key"));
    this.ac.a();
  }

  public void onFragmentVisibilityChanged(boolean paramBoolean)
  {
    super.onFragmentVisibilityChanged(paramBoolean);
    com.viber.voip.ui.i locali;
    if (this.L != null)
    {
      locali = this.L;
      if ((!paramBoolean) || (a()))
        break label68;
    }
    label68: for (boolean bool = true; ; bool = false)
    {
      locali.a(bool);
      FragmentActivity localFragmentActivity = getActivity();
      if ((paramBoolean) && ((localFragmentActivity instanceof com.viber.voip.ab)))
      {
        ((com.viber.voip.ab)localFragmentActivity).h();
        a(localFragmentActivity);
      }
      return;
    }
  }

  public void onListItemClick(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof m))
    {
      m localm = (m)paramView.getTag();
      if ((localm == null) || (localm.a() == null))
        return;
      a(true, localm.a());
    }
    while (true)
    {
      FragmentActivity localFragmentActivity = getActivity();
      if (!(localFragmentActivity instanceof au))
        break;
      au localau = (au)localFragmentActivity;
      localau.k();
      localau.b(false);
      return;
      if ((localObject instanceof u))
        d(paramInt, true);
    }
  }

  @SuppressLint({"CheckResult"})
  public void onLoadFinished(com.viber.provider.d paramd, boolean paramBoolean)
  {
    int i1 = 1;
    if ((this.r == null) || (!isAdded()))
      return;
    this.V = this.e.x_();
    label45: label118: FragmentActivity localFragmentActivity;
    if ((!l()) && (!this.V))
    {
      int i3 = i1;
      this.K = i3;
      this.r.b(this.aa.a(), this.K);
      com.b.a.a.a locala = this.r;
      View localView = this.u;
      if (((l()) || (this.V)) && ((!n()) || (this.e.v().getCount() <= 0)))
        break label439;
      int i5 = i1;
      locala.b(localView, i5);
      if (this.V)
        break label445;
      this.ab.a(paramd);
      label142: if (!this.e.s())
        break label503;
      this.p.setAdapter(this.r);
      label163: if ((paramBoolean) && (this.J != null) && (this.p != null))
        this.p.onRestoreInstanceState(this.J);
      if ((!(paramd instanceof com.viber.voip.calls.c)) || (l()))
        break label519;
      if ((this.V) || (paramd.getCount() <= 0))
        break label513;
      int i7 = i1;
      label223: this.r.b(this.v, i7);
      this.r.a(this.B, i7);
      this.r.b(this.w, i7);
      if (!(paramd instanceof com.viber.voip.calls.b))
        break label568;
      this.U = com.viber.voip.util.av.e(this.U, 2);
      int i12 = this.Y;
      if (paramd.getCount() <= 0)
        break label562;
      int i13 = i1;
      label297: this.Y = com.viber.voip.util.av.b(i12, 2, i13);
      label309: localFragmentActivity = getActivity();
      if ((this.mIsTablet) && (this.U == 3))
      {
        if (((localFragmentActivity instanceof au)) && (!v()))
          ((au)localFragmentActivity).k();
        if ((!(localFragmentActivity instanceof au)) || (!((au)localFragmentActivity).l()))
          D();
      }
      if (this.U != 3)
        break label624;
    }
    while (true)
    {
      if ((this.S) || (i1 != 0))
        e();
      if ((i1 == 0) || (localFragmentActivity == null) || (!isAdded()) || (isHidden()))
        break;
      a(localFragmentActivity);
      return;
      int i4 = 0;
      break label45;
      label439: int i6 = 0;
      break label118;
      label445: if (paramd.getCount() > 0)
      {
        this.r.b(this.F, false);
        break label142;
      }
      if (paramd.getCount() != 0)
        break label142;
      this.F.setQueryText(this.i.a());
      this.r.b(this.F, i1);
      break label142;
      label503: this.r.notifyDataSetChanged();
      break label163;
      label513: int i8 = 0;
      break label223;
      label519: if ((!this.V) && (this.f != null) && (this.f.getCount() > 0) && (!l()))
      {
        i8 = i1;
        break label223;
      }
      i8 = 0;
      break label223;
      label562: int i14 = 0;
      break label297;
      label568: if (!(paramd instanceof com.viber.voip.contacts.b))
        break label309;
      this.U = com.viber.voip.util.av.e(this.U, i1);
      int i9 = this.Y;
      if (paramd.getCount() > 0);
      int i11;
      for (int i10 = i1; ; i11 = 0)
      {
        this.Y = com.viber.voip.util.av.b(i9, i1, i10);
        break;
      }
      label624: int i2 = 0;
    }
  }

  public void onLoaderReset(com.viber.provider.d paramd)
  {
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i1 = 4;
    int i2 = 1;
    if (getActivity() == null)
      i2 = 0;
    int i3;
    do
    {
      do
      {
        do
        {
          return i2;
          i3 = paramMenuItem.getItemId();
          if (i3 == R.id.menu_add_contact)
          {
            M();
            return i2;
          }
        }
        while (i3 == R.id.menu_search);
        if (i3 != R.id.menu_reset_first_sync)
          break;
        d.p.l.a(false);
        this.g.c();
        this.g.d();
        this.g.f();
      }
      while (!(this.h instanceof com.viber.voip.contacts.c.d.i));
      ((com.viber.voip.contacts.c.d.i)this.h).o();
      return i2;
      if (i3 != R.id.menu_remove_contacts)
        break;
      this.g.d();
      this.g.f();
    }
    while (!(this.h instanceof com.viber.voip.contacts.c.d.i));
    ((com.viber.voip.contacts.c.d.i)this.h).o();
    return i2;
    if (i3 == R.id.menu_remove_viber_contacts)
    {
      this.g.f();
      if ((this.h instanceof com.viber.voip.contacts.c.d.i))
        ((com.viber.voip.contacts.c.d.i)this.h).o();
    }
    while (true)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      if (i3 == R.id.menu_clear_images)
      {
        com.viber.voip.util.e.e.a(ViberApplication.getApplication()).c();
        return i2;
      }
      if (i3 == R.id.menu_share_address_book)
      {
        if (ao.f())
          break;
        ((com.viber.voip.contacts.c.d.a.b)this.h).t();
        return i2;
      }
      if (i3 == R.id.menu_run_sync_account)
      {
        com.viber.service.contacts.sync.a.a().b();
        return i2;
      }
      if (i3 == R.id.menu_show_sync_screen)
      {
        this.g.a(this.e.getCount(), r(), i2);
        return i2;
      }
      if (i3 == R.id.menu_show_sync_viber_faild_screen)
      {
        this.g.a(this.e.getCount(), r(), 5);
        return i2;
      }
      if (i3 == R.id.menu_show_no_contacts_screen)
      {
        this.g.a(this.e.getCount(), r(), 2);
        return i2;
      }
      if (i3 == R.id.menu_show_no_viber_contacts_screen)
      {
        this.g.a(this.e.getCount(), r(), 3);
        return i2;
      }
      if (i3 == R.id.menu_show_no_contacts_found_screen)
      {
        this.g.a(this.e.getCount(), r(), i1);
        return i2;
      }
      if (i3 == R.id.menu_remove_screen)
      {
        this.g.a(this.e.getCount(), r(), 0);
        return i2;
      }
      if (i3 == R.id.menu_show_top_loading_view)
      {
        ak localak = r();
        FragmentActivity localFragmentActivity2 = getActivity();
        if (r().b());
        while (true)
        {
          localak.a(localFragmentActivity2, i1);
          return i2;
          i1 = i2;
        }
      }
      if (i3 == R.id.menu_open_block_list)
      {
        startActivity(new Intent("com.viber.voip.action.BLOCK_LIST"));
        return i2;
      }
      if (i3 == R.id.menu_clear_images)
      {
        com.viber.voip.util.e.e.a(ViberApplication.getApplication()).c();
        return i2;
      }
      if (i3 == R.id.menu_show_dialog_602)
      {
        PurchaseSupportActivity.a(getActivity());
        return i2;
      }
      if (i3 == R.id.menu_need_force_update)
      {
        if (ao.f())
        {
          d.ad.k.a(i2);
          return i2;
        }
        Toast.makeText(getActivity(), "Must be secondary!", 0).show();
        return i2;
      }
      if (i3 == R.id.menu_show_url_scheme_push)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("title", "Guns");
        localBundle.putString("text", "Open Settings screen");
        localBundle.putString("action", "viber://more/settings");
        localBundle.putString("image", "https://cs7062.vk.me/c7002/v7002050/6f2b/JEms7DRpREw.jpg");
        localBundle.putString("sound", "http://www.soundjay.com/transportation/train-whistle-01.mp3");
        com.viber.voip.notif.g.a(getContext()).a().a(localBundle);
        return i2;
      }
      if (i3 == R.id.menu_force_rakuten_sharing)
      {
        boolean bool = d.au.b.d();
        com.viber.common.b.b localb = d.au.b;
        FragmentActivity localFragmentActivity1;
        StringBuilder localStringBuilder;
        if (!bool)
        {
          int i5 = i2;
          localb.a(i5);
          localFragmentActivity1 = getActivity();
          localStringBuilder = new StringBuilder().append("Force rakuten sharing enabled: ");
          if (bool)
            break label748;
        }
        label748: int i8;
        for (int i7 = i2; ; i8 = 0)
        {
          Toast.makeText(localFragmentActivity1, i7, 0).show();
          return i2;
          int i6 = 0;
          break;
        }
      }
      if (i3 == R.id.menu_reset_memberid_migration)
      {
        d.ac.b.e();
        com.viber.voip.model.e.e("member_id_migration");
        ViberApplication.exit(getActivity(), i2);
        return i2;
      }
      if (i3 == R.id.menu_reset_participants_info)
      {
        com.viber.voip.av.a(av.e.d).post(new Runnable()
        {
          public void run()
          {
            com.viber.voip.messages.controller.manager.ak localak = com.viber.voip.messages.controller.manager.ak.a();
            Iterator localIterator = localak.c().iterator();
            while (localIterator.hasNext())
            {
              com.viber.voip.model.entity.m localm = (com.viber.voip.model.entity.m)localIterator.next();
              if (!localm.isOwner())
              {
                localm.c("");
                localm.g("");
                localm.f("");
                localm.a(0L);
                localak.b(localm);
              }
            }
            ViberApplication.exit(ContactsFragment.this.getActivity(), true);
          }
        });
        return i2;
      }
      if (i3 == R.id.menu_clear_messages_database)
      {
        com.viber.voip.messages.controller.manager.ab.b().u();
        com.viber.voip.model.a.b.e();
        e.a.h.a(null);
        e.a.i.a(null);
        av.e.g.a().post(new ac(this));
        return i2;
      }
      if (i3 == R.id.menu_fetch_balance)
      {
        com.viber.voip.viberout.a.a().a(0L);
      }
      else if (i3 == R.id.menu_create_conversations)
      {
        ai localai = ViberApplication.getInstance().getMessagesManager().c();
        af localaf = ViberApplication.getInstance().getUserManager().getRegistrationValues();
        for (int i4 = 0; i4 < this.e.getCount(); i4++)
        {
          com.viber.voip.model.c localc = this.e.c(i4);
          if ((localc.p()) && (!com.viber.voip.messages.m.a(localaf, localc.n().a())))
            localai.a(new com.viber.voip.messages.controller.c.b(0L, localc.n().a(), 0, 0).a(0, "Hi! How are you?", 0, null, 0), null);
        }
        ViberApplication.getInstance().showToast("Done!");
      }
    }
  }

  public void onPause()
  {
    super.onPause();
    EngineDelegate.removeEventSubscriber(this.am);
    if (this.z != null)
      this.z.k();
  }

  public boolean onQueryTextChange(String paramString)
  {
    this.P = paramString;
    if (this.e != null)
      this.e.a(paramString, dr.a(paramString));
    return true;
  }

  public boolean onQueryTextSubmit(String paramString)
  {
    return false;
  }

  public void onRefresh()
  {
    if (cj.a(false))
    {
      ((com.viber.voip.contacts.c.d.g)this.h.get()).a(this);
      this.g.a();
      this.q.setRefreshing(true);
      return;
    }
    this.q.setRefreshing(false);
  }

  public void onResume()
  {
    super.onResume();
    EngineDelegate.addEventSubscriber(this.am);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    long l1;
    if (this.c.first != null)
    {
      l1 = ((Long)this.c.first).longValue();
      paramBundle.putLong("selected_contact_id", l1);
      if (this.c.second == null)
        break label93;
    }
    label93: for (int i1 = ((Integer)this.c.second).intValue(); ; i1 = 0)
    {
      paramBundle.putInt("selected_item_loader_type", i1);
      paramBundle.putParcelable("list_instance_state", this.p.onSaveInstanceState());
      super.onSaveInstanceState(paramBundle);
      return;
      l1 = -1L;
      break;
    }
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public boolean onSearchViewShow(boolean paramBoolean)
  {
    this.O = paramBoolean;
    b(paramBoolean);
    com.viber.voip.ui.i locali;
    if (this.L != null)
    {
      locali = this.L;
      if (paramBoolean)
        break label35;
    }
    label35: for (boolean bool = true; ; bool = false)
    {
      locali.a(bool);
      return true;
    }
  }

  public void onStart()
  {
    super.onStart();
    com.viber.voip.contacts.c.f.a.a(ViberApplication.getApplication()).a(this);
    if ((!this.i.e()) && (!this.O) && (this.e != null) && (!TextUtils.isEmpty(this.e.a())))
      this.e.a("", "");
    this.y.a(this.ai);
    this.y.a(this.ah);
  }

  public void onStop()
  {
    super.onStop();
    com.viber.voip.contacts.c.f.a.a(ViberApplication.getApplication()).b(this);
    this.y.b(this.ai);
    this.y.b(this.ah);
  }

  public void onSyncStateChanged(int paramInt, boolean paramBoolean)
  {
    runOnUiThread(new z(this, paramInt, paramBoolean));
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.i != null) && (this.i.e()) && ((paramView == getListView()) || (paramView.getId() == 16908292)) && (paramMotionEvent.getAction() == 0) && (!this.mIsTablet))
      this.i.i();
    int i1;
    int i2;
    if ((this.p.isFastScrollEnabled()) && (m()) && (this.M != null))
    {
      i1 = (int)paramMotionEvent.getX();
      i2 = (int)paramMotionEvent.getY();
    }
    switch (paramMotionEvent.getActionMasked())
    {
    default:
    case 0:
      do
        return false;
      while (!this.M.contains(i1, i2));
      this.q.setEnabled(false);
      return false;
    case 1:
    }
    this.q.setEnabled(true);
    return false;
  }

  protected void p()
  {
    if (!l())
    {
      this.r.a(this.aa.a());
      this.r.b(this.aa.a(), false);
      this.r.a(this.v);
      this.r.b(this.v, false);
      this.r.a(this.B);
      this.r.a(this.B, false);
      this.r.a(this.w);
      this.r.b(this.w, false);
    }
    while (true)
    {
      this.r.a(this.u);
      this.r.b(this.u, false);
      this.r.a(this.s);
      this.r.a(this.F);
      this.r.b(this.F, false);
      this.r.a(this.C);
      this.r.b(this.C, false);
      if (!l())
      {
        this.T = new com.viber.voip.ui.f.b(this.u.getContext(), this.r, getResources().getDimensionPixelSize(R.dimen.contacts_list_empty_view_under_fab_height));
        this.T.a();
      }
      return;
      if (n())
        this.r.a(this.t);
    }
  }

  public void q()
  {
    w();
  }

  protected ak r()
  {
    if (this.j == null)
    {
      b(getView());
      View localView = getView().findViewById(16908292);
      if (localView != null)
        getListView().setEmptyView(localView);
      this.j = new ak(getView(), this.y);
      this.j.a(getView(), this, o());
      this.j.b(getView(), false);
      this.j.k.setOnTouchListener(this);
    }
    return this.j;
  }

  public b.b s()
  {
    if (this.e == null)
      return k();
    return this.e.r();
  }

  protected void t()
  {
    int i1;
    if (this.mIsTablet)
    {
      i1 = J();
      setListAdapter(this.r);
    }
    while (true)
    {
      super.t();
      if ((this.mIsTablet) && (i1 != -1))
        getListView().setItemChecked(i1, true);
      return;
      i1 = -1;
    }
  }

  @Deprecated
  protected int u()
  {
    return super.u();
  }

  public boolean v()
  {
    return (this.e != null) && (this.e.getCount() > 0);
  }

  protected void v_()
  {
    if (this.X)
    {
      a(true);
      this.X = false;
      return;
    }
    a(false);
  }

  public boolean w()
  {
    if ((this.i != null) && (this.i.e()))
    {
      this.i.f();
      return true;
    }
    return false;
  }

  protected boolean x()
  {
    return (!l()) && (!this.V);
  }

  public void z_()
  {
    a(null);
  }

  static class MemberActionInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<MemberActionInfo> CREATOR = new Parcelable.Creator()
    {
      public ContactsFragment.MemberActionInfo a(Parcel paramAnonymousParcel)
      {
        return new ContactsFragment.MemberActionInfo(paramAnonymousParcel);
      }

      public ContactsFragment.MemberActionInfo[] a(int paramAnonymousInt)
      {
        return new ContactsFragment.MemberActionInfo[paramAnonymousInt];
      }
    };
    public final boolean isFromSearchResults;
    public final Member member;

    protected MemberActionInfo(Parcel paramParcel)
    {
      if (paramParcel.readByte() != 0);
      for (boolean bool = true; ; bool = false)
      {
        this.isFromSearchResults = bool;
        this.member = ((Member)paramParcel.readParcelable(Member.class.getClassLoader()));
        return;
      }
    }

    MemberActionInfo(Member paramMember, boolean paramBoolean)
    {
      this.member = paramMember;
      this.isFromSearchResults = paramBoolean;
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      if (this.isFromSearchResults);
      for (byte b = 1; ; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeParcelable(this.member, paramInt);
        return;
      }
    }
  }

  public static abstract interface a extends o.a
  {
    public abstract void a(boolean paramBoolean, Intent paramIntent);
  }

  public static abstract interface b extends o.a
  {
    public abstract void c(Intent paramIntent);
  }

  private class c
    implements com.viber.voip.viberout.a.a
  {
    private TextView b;
    private TextView c;
    private View d;

    private c()
    {
    }

    private void a(CharSequence paramCharSequence, boolean paramBoolean)
    {
      this.b.setText(paramCharSequence);
      int i;
      TextView localTextView;
      if (paramBoolean)
      {
        i = ContactsFragment.this.getResources().getColor(R.color.mantis);
        this.b.setTextColor(i);
        localTextView = this.c;
        if (paramBoolean)
          break label72;
      }
      label72: for (boolean bool = true; ; bool = false)
      {
        dj.b(localTextView, bool);
        return;
        i = dc.d(this.b.getContext(), R.attr.textVoBalanceTextRegularColor);
        break;
      }
    }

    private boolean a(String paramString, int paramInt)
    {
      if (("no_balance".equals(paramString)) && (paramInt == 0));
      for (boolean bool = true; ; bool = false)
      {
        if (bool)
          a(ContactsFragment.this.getString(R.string.vo_section_subtitle), false);
        return bool;
      }
    }

    public void a(View paramView)
    {
      this.d = paramView;
      ICdrController localICdrController = ViberApplication.getInstance().getEngine(false).getCdrController();
      this.b = ((TextView)paramView.findViewById(R.id.voSubtitleView));
      this.c = ((TextView)paramView.findViewById(R.id.voBuyCreditView));
      ah localah = new ah(this, localICdrController);
      this.d.setOnClickListener(localah);
      this.c.setOnClickListener(localah);
    }

    public void onFetchBalanceCanceled()
    {
      a(ContactsFragment.this.getString(R.string.vo_section_subtitle), false);
    }

    public void onFetchBalanceFinished(com.viber.voip.billing.b.a parama, String paramString)
    {
      FragmentActivity localFragmentActivity = ContactsFragment.this.getActivity();
      if (localFragmentActivity == null);
      while (a(paramString, parama.e()))
        return;
      a(com.viber.voip.viberout.ui.d.a(paramString, parama.e(), localFragmentActivity), true);
    }

    public void onFetchBalanceStarted()
    {
    }

    public void setLocalBalance(String paramString, int paramInt)
    {
      FragmentActivity localFragmentActivity = ContactsFragment.this.getActivity();
      if (localFragmentActivity == null);
      while (a(paramString, paramInt))
        return;
      a(com.viber.voip.viberout.ui.d.a(paramString, paramInt, localFragmentActivity), true);
    }
  }

  public static abstract interface d
  {
    public abstract void f();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.ContactsFragment
 * JD-Core Version:    0.6.2
 */