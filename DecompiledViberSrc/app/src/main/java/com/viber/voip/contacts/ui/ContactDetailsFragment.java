package com.viber.voip.contacts.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.c;
import com.viber.common.ui.ShapeImageView;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.OnlineContactInfo;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.dialer.DialerController;
import com.viber.jni.secure.TrustPeerController;
import com.viber.voip.R.attr;
import com.viber.voip.R.bool;
import com.viber.voip.R.color;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.b.a.h.a.a;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.billing.b.t;
import com.viber.voip.calls.d;
import com.viber.voip.calls.d.b;
import com.viber.voip.calls.d.d;
import com.viber.voip.contacts.c.c.c.a;
import com.viber.voip.contacts.c.d.s.a;
import com.viber.voip.contacts.model.ExtraActionAfterContactIsAdded;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.ui.media.ComposeDataContainer;
import com.viber.voip.model.Call;
import com.viber.voip.permissions.n;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.call.CallHandler.ContactDetailsAnalyticsCallInfo;
import com.viber.voip.phone.call.CallInitiationId;
import com.viber.voip.phone.call.listeners.CallInitiationListenersStore;
import com.viber.voip.registration.af;
import com.viber.voip.ui.at;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.user.OnlineUserActivityHelper;
import com.viber.voip.user.OnlineUserActivityHelper.UiOnlineUserInfoDelegate;
import com.viber.voip.user.UserDetailPhotoSetter;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ViberActionRunner.af;
import com.viber.voip.util.ViberActionRunner.c;
import com.viber.voip.util.ViberActionRunner.u;
import com.viber.voip.util.ae;
import com.viber.voip.util.cg;
import com.viber.voip.util.cj;
import com.viber.voip.util.ck;
import com.viber.voip.util.cv;
import com.viber.voip.util.dc;
import com.viber.voip.util.dg;
import com.viber.voip.util.dj;
import com.viber.voip.util.v;
import com.viber.voip.util.x.a;
import com.viber.voip.widget.ObservableCollapsingToolbarLayout;
import com.viber.voip.widget.ObservableCollapsingToolbarLayout.c;
import com.viber.voip.widget.ProportionalLayout;
import com.viber.voip.widget.ViberAppBarLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

public class ContactDetailsFragment extends at
  implements View.OnClickListener, m.c, c.a, com.viber.voip.contacts.c.d.g.a, OnlineUserActivityHelper.UiOnlineUserInfoDelegate
{
  private static c aq = i.a;
  private static final Logger m = ViberEnv.getLogger();
  private String A;
  private String B;
  private boolean C;
  private boolean D;
  private boolean E;
  private boolean F;
  private ArrayList<Call> G = new ArrayList();
  private long H;
  private Map<Member, Boolean> I = new HashMap();
  private final UserDetailPhotoSetter J = new UserDetailPhotoSetter();
  private View.OnClickListener K;
  private com.viber.common.permission.c L;
  private com.viber.voip.permissions.k M;
  private com.viber.common.permission.b N;
  private com.viber.voip.util.e.e O;
  private com.viber.voip.util.e.f P;
  private com.viber.voip.analytics.story.d.c Q;
  private com.viber.voip.analytics.story.e.c R;
  private int S;
  private ObservableCollapsingToolbarLayout T;
  private ViberAppBarLayout U;
  private com.viber.voip.widget.toolbar.a V;
  private com.viber.voip.widget.e W;
  private Toolbar X;
  private View Y;
  private View Z;
  protected RecyclerView a;
  private View aa;
  private boolean ab = true;
  private boolean ac;
  private b ad;
  private com.viber.voip.ui.ao ae;
  private int af;
  private int ag;
  private int ah;
  private int ai;
  private int aj;
  private int ak;
  private int al;
  private ExtraActionAfterContactIsAdded am;
  private dagger.a<com.viber.voip.analytics.story.b.a.h> an;
  private com.viber.voip.util.e.h.a ao = new f(this);
  private final com.viber.voip.util.e.h.a ap = new g(this);
  private c ar = aq;
  private View.OnClickListener as = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (ContactDetailsFragment.a(ContactDetailsFragment.this) != null)
      {
        if (ContactDetailsFragment.a(ContactDetailsFragment.this).a())
          ContactDetailsFragment.a(ContactDetailsFragment.this).setExpandedToOffset(false);
      }
      else
        return;
      ContactDetailsFragment.a(ContactDetailsFragment.this).setExpanded(true);
    }
  };
  protected com.viber.voip.contacts.adapters.a.a b;
  protected e c;

  @Inject
  com.viber.voip.analytics.g d;

  @Inject
  com.viber.voip.app.b e;

  @Inject
  com.viber.voip.contacts.c.d.g f;

  @Inject
  CallHandler g;

  @Inject
  dagger.a<DialerController> h;

  @Inject
  PhoneController i;

  @Inject
  OnlineUserActivityHelper j;

  @Inject
  TrustPeerController k;
  ParticipantSelector.d l = new ParticipantSelector.d()
  {
    public void a(ParticipantSelector.Participant paramAnonymousParticipant)
    {
    }

    public void a(boolean paramAnonymousBoolean, ParticipantSelector.Participant paramAnonymousParticipant)
    {
      String str1 = ContactDetailsFragment.m(ContactDetailsFragment.this);
      String str2 = ContactDetailsFragment.m(ContactDetailsFragment.this);
      String str3 = paramAnonymousParticipant.getNumber();
      String str4;
      Uri localUri;
      if (ContactDetailsFragment.n(ContactDetailsFragment.this) == null)
      {
        str4 = ContactDetailsFragment.m(ContactDetailsFragment.this);
        localUri = ContactDetailsFragment.o(ContactDetailsFragment.this);
        if (ContactDetailsFragment.o(ContactDetailsFragment.this) == null)
          break label118;
      }
      label118: for (String str5 = ContactDetailsFragment.o(ContactDetailsFragment.this).getLastPathSegment(); ; str5 = "")
      {
        Intent localIntent = ViberActionRunner.u.a(new ComposeDataContainer(str1, str2, str3, str4, localUri, str5));
        ContactDetailsFragment.this.startActivity(localIntent);
        return;
        str4 = ContactDetailsFragment.n(ContactDetailsFragment.this);
        break;
      }
    }
  };
  private ImageView n;
  private ProportionalLayout o;
  private View p;
  private b q;
  private TextView r;
  private TextView s;
  private Handler t;
  private com.viber.voip.contacts.c.c.c u;
  private boolean v;
  private com.viber.voip.model.b w;
  private String x;
  private Uri y;
  private String z;

  private void a(float paramFloat)
  {
    if (this.V == null)
      return;
    this.V.a(v.a(paramFloat, this.ah, this.ai));
    this.V.b(v.a(paramFloat, this.aj, this.ak));
  }

  private void a(long paramLong)
  {
    com.viber.voip.calls.e.a(ViberApplication.getInstance()).a(paramLong, new d.b()
    {
      public void a(final long paramAnonymousLong, Collection<Call> paramAnonymousCollection)
      {
        ContactDetailsFragment.h(ContactDetailsFragment.this).post(new Runnable()
        {
          public void run()
          {
            if ((ContactDetailsFragment.this.isAdded()) && (paramAnonymousLong == ContactDetailsFragment.f(ContactDetailsFragment.this)))
            {
              ContactDetailsFragment.g(ContactDetailsFragment.this).clear();
              ContactDetailsFragment.g(ContactDetailsFragment.this).addAll(this.b);
              if ((ContactDetailsFragment.this.a != null) && (ContactDetailsFragment.this.a.getAdapter() != null))
                ContactDetailsFragment.this.a.getAdapter().notifyDataSetChanged();
            }
          }
        });
      }
    });
  }

  private void a(View paramView)
  {
    this.a = ((RecyclerView)paramView.findViewById(R.id.items));
    this.p = paramView.findViewById(16908292);
    this.n = ((ImageView)paramView.findViewById(R.id.photo));
    ProportionalLayout localProportionalLayout;
    if (this.e.a())
    {
      this.o = ((ProportionalLayout)paramView.findViewById(R.id.view));
      if (this.o != null)
      {
        localProportionalLayout = this.o;
        if (!g())
          break label163;
      }
    }
    label163: for (float f1 = 0.5F; ; f1 = 1.0F)
    {
      localProportionalLayout.setRatio(f1);
      if ((this.E) && (!g()))
      {
        this.r = ((TextView)paramView.findViewById(R.id.title));
        this.s = ((TextView)paramView.findViewById(R.id.subtitle));
      }
      if ((g()) && (this.e.a()))
        paramView.findViewById(R.id.title_container).setVisibility(8);
      return;
    }
  }

  private void a(d paramd)
  {
    switch (4.b[paramd.ordinal()])
    {
    default:
      return;
    case 1:
      this.a.setVisibility(0);
      this.p.setVisibility(8);
      return;
    case 2:
    }
    this.a.setVisibility(8);
    this.p.setVisibility(8);
  }

  private void a(final e parame)
  {
    ParticipantSelector.d local8 = new ParticipantSelector.d()
    {
      public void a(ParticipantSelector.Participant paramAnonymousParticipant)
      {
      }

      public void a(boolean paramAnonymousBoolean, ParticipantSelector.Participant paramAnonymousParticipant)
      {
        FragmentActivity localFragmentActivity = ContactDetailsFragment.this.getActivity();
        if (localFragmentActivity != null)
          parame.a(localFragmentActivity, ContactDetailsFragment.i(ContactDetailsFragment.this), ContactDetailsFragment.j(ContactDetailsFragment.this), new ContactDetailsFragment.a(ContactDetailsFragment.this.e, ContactDetailsFragment.this.d, ContactDetailsFragment.this.g, (DialerController)ContactDetailsFragment.this.h.get(), paramAnonymousParticipant, ContactDetailsFragment.a(ContactDetailsFragment.this, parame)));
      }
    };
    com.viber.voip.util.x.a(getActivity(), this.w, local8);
  }

  private void a(e parame, ParticipantSelector.Participant paramParticipant)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      if (this.e.a(localFragmentActivity))
        this.ar.q();
      parame.a(localFragmentActivity, this.R, this.an, new a(this.e, this.d, this.g, (DialerController)this.h.get(), paramParticipant, b(parame)));
    }
  }

  private void a(com.viber.voip.model.b paramb)
  {
    if (!this.e.a())
    {
      this.O.a(paramb, this.y, this.n, this.P, this.ao);
      this.n.setOnClickListener(this.as);
    }
    do
    {
      return;
      this.O.a(paramb, this.y, this.n, this.P, this.ap);
    }
    while (g());
    this.K = this.J.setupContactDetailsPhotoForClick(this, this.n, this.E, this.o, this.y, true);
    this.n.setOnClickListener(this.K);
  }

  private void a(String paramString)
  {
    if ((!this.D) || (TextUtils.isEmpty(paramString)))
      return;
    this.S = this.i.generateSequence();
    this.j.obtainInfo(paramString, this.S, this);
  }

  private void a(List<com.viber.voip.contacts.model.a> paramList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (getActivity() == null)
      return;
    ck localck = new ck(getActivity());
    localck.a(this.ad.a(paramString, paramBoolean1, paramBoolean2));
    if (this.C)
      localck.a(new com.viber.voip.contacts.adapters.o(getActivity(), this.G, getLayoutInflater()));
    com.viber.voip.contacts.adapters.a.a locala = a(paramList);
    this.b = locala;
    localck.a(locala);
    this.a.setAdapter(localck);
  }

  public static void a(boolean paramBoolean, int paramInt, long paramLong)
  {
    Engine localEngine = ViberApplication.getInstance().getEngine(false);
    ICdrController localICdrController;
    int i1;
    if (localEngine.isInitialized())
    {
      localICdrController = localEngine.getCdrController();
      i1 = 0;
      if (paramBoolean)
        break label44;
    }
    while (true)
    {
      localICdrController.handleReportMakeMobileCall(i1, paramInt, paramLong);
      return;
      label44: i1 = 1;
    }
  }

  @TargetApi(21)
  private boolean a(float paramFloat, Window paramWindow)
  {
    boolean bool1 = com.viber.common.d.a.i();
    boolean bool2 = false;
    if (bool1)
    {
      if (paramFloat < 0.67F)
        break label33;
      paramWindow.setStatusBarColor(this.al);
    }
    while (true)
    {
      bool2 = true;
      return bool2;
      label33: paramWindow.setStatusBarColor(0);
    }
  }

  private Bundle b(e parame)
  {
    switch (4.a[parame.ordinal()])
    {
    default:
      return null;
    case 4:
    }
    Bundle localBundle = new Bundle(1);
    localBundle.putString("number", this.A);
    return localBundle;
  }

  private void b(float paramFloat)
  {
    if (this.ae == null)
      return;
    this.ae.a(v.a(paramFloat, this.af, this.ag));
  }

  private void b(com.viber.voip.model.b paramb)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()))
      return;
    a(d.b);
    a(paramb);
    String str1 = paramb.k();
    ArrayList localArrayList;
    boolean bool1;
    int i1;
    label129: Set localSet;
    String str2;
    if ((this.E) || (this.e.a()))
    {
      b(str1);
      localArrayList = new ArrayList();
      if (((paramb.s() == null) || (paramb.s().size() <= 0)) && ((!this.D) || (this.A == null)))
        break label250;
      if (this.F)
        localArrayList.add(l.a(localFragmentActivity));
      bool1 = true;
      i1 = 0;
      localSet = c(paramb);
      str2 = ViberApplication.getInstance().getUserManager().getRegistrationValues().h();
      if (str2 != null)
        break label321;
    }
    label321: for (String str3 = ""; ; str3 = str2)
    {
      this.I = paramb.c();
      Iterator localIterator = localSet.iterator();
      while (true)
        if (localIterator.hasNext())
        {
          String str4 = (String)localIterator.next();
          localArrayList.add(l.a(str4));
          if (str3.equals(str4))
          {
            this.ac = true;
            continue;
            this.V.a(str1);
            this.V.c();
            break;
            label250: p();
            i1 = 1;
            bool1 = false;
            break label129;
          }
        }
      boolean bool2 = false;
      if (i1 != 0)
      {
        int i2 = localArrayList.size();
        bool2 = false;
        if (i2 > 0)
          bool2 = true;
      }
      a(localArrayList, str1, bool1, bool2);
      if (bool1)
        a(this.B);
      b(true);
      return;
    }
  }

  private void b(String paramString)
  {
    if (this.r != null)
      if (TextUtils.isEmpty(paramString))
        this.r.setVisibility(8);
    android.support.v7.app.a locala;
    do
    {
      do
      {
        return;
        this.r.setVisibility(0);
        this.r.setText(paramString);
        return;
      }
      while (getActivity() == null);
      locala = ((AppCompatActivity)getActivity()).getSupportActionBar();
    }
    while (locala == null);
    locala.a(paramString);
  }

  private void b(boolean paramBoolean)
  {
    if ((this.x == null) || (!this.x.equals(this.A)))
    {
      this.x = this.A;
      this.Q.c(ae.b());
    }
  }

  private static void b(boolean paramBoolean, int paramInt)
  {
    ViberApplication.getInstance().getEngine(false).getCallHandler().setContactDetailsAnalyticsCallInfo(new CallHandler.ContactDetailsAnalyticsCallInfo(paramBoolean, paramInt));
  }

  private Set<String> c(com.viber.voip.model.b paramb)
  {
    Collection localCollection = paramb.a();
    HashSet localHashSet = new HashSet(localCollection.size());
    Iterator localIterator = localCollection.iterator();
    while (localIterator.hasNext())
      localHashSet.add(((com.viber.voip.model.entity.k)localIterator.next()).c());
    return localHashSet;
  }

  private void c(float paramFloat)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (a(paramFloat, localFragmentActivity.getWindow())));
    while ((!com.viber.common.d.a.j()) || (localFragmentActivity == null))
      return;
    if ((paramFloat >= 0.67F) && (dc.b()));
    for (boolean bool = true; ; bool = false)
    {
      dj.b(localFragmentActivity, bool);
      return;
    }
  }

  private void c(String paramString)
  {
    if (this.s != null)
      if (TextUtils.isEmpty(paramString))
        this.s.setVisibility(4);
    android.support.v7.app.a locala;
    do
    {
      do
      {
        return;
        this.s.setVisibility(0);
        this.s.setText(paramString);
        return;
      }
      while (getActivity() == null);
      locala = ((AppCompatActivity)getActivity()).getSupportActionBar();
    }
    while (locala == null);
    locala.b(paramString);
  }

  private void c(Set<Member> paramSet, boolean paramBoolean)
  {
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      Member localMember = (Member)localIterator.next();
      if (this.I.containsKey(localMember))
        this.I.put(localMember, Boolean.valueOf(paramBoolean));
    }
    l();
  }

  private void d(final String paramString)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (ContactDetailsFragment.this.getActivity() == null)
          return;
        if ((!ContactDetailsFragment.p(ContactDetailsFragment.this)) && (!ContactDetailsFragment.this.e.a()))
        {
          ContactDetailsFragment.q(ContactDetailsFragment.this).b(paramString);
          return;
        }
        ContactDetailsFragment.a(ContactDetailsFragment.this, paramString);
      }
    });
  }

  private com.viber.voip.permissions.e f()
  {
    return new com.viber.voip.permissions.e(this, this.M.a(new int[] { 0, 2, 1 }))
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        default:
          return;
        case 60:
        case 61:
          ContactDetailsFragment.b(ContactDetailsFragment.this);
          return;
        case 46:
        case 47:
          ContactDetailsFragment.c(ContactDetailsFragment.this);
          return;
        case 84:
        case 85:
        }
        ContactDetailsFragment.d(ContactDetailsFragment.this);
      }
    };
  }

  private boolean g()
  {
    return getActivity() instanceof ContactDetailsDialogActivity;
  }

  private void h()
  {
    if (this.L.a(n.h))
    {
      i();
      return;
    }
    int i1 = this.M.a(2);
    this.L.a(this, i1, n.h);
  }

  private void i()
  {
    this.d.a(com.viber.voip.analytics.story.l.h.b());
    a(e.d);
  }

  private void j()
  {
    if (this.L.a(n.h))
    {
      k();
      return;
    }
    int i1 = this.M.a(1);
    this.L.a(this, i1, n.h);
  }

  private void k()
  {
    a(e.a, b());
  }

  private void l()
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        FragmentActivity localFragmentActivity = ContactDetailsFragment.this.getActivity();
        if (localFragmentActivity != null)
          localFragmentActivity.invalidateOptionsMenu();
      }
    });
  }

  private void m()
  {
    if (this.L.a(n.k))
    {
      n();
      return;
    }
    int i1 = this.M.a(0);
    this.L.a(this, i1, n.k);
  }

  private void n()
  {
    if (TextUtils.isEmpty(this.B))
    {
      ViberActionRunner.c.b(getActivity(), this.A, "Manual", "Contact Profile");
      return;
    }
    ViberActionRunner.c.a(getActivity(), this.B, this.A, "Manual", "Contact Profile");
  }

  private com.viber.voip.model.j o()
  {
    com.viber.voip.model.entity.x localx;
    if (!TextUtils.isEmpty(this.B))
      localx = new com.viber.voip.model.entity.x(this.B, this.A, "");
    com.viber.voip.model.j localj;
    do
    {
      com.viber.voip.model.b localb;
      do
      {
        return localx;
        localb = this.w;
        localx = null;
      }
      while (localb == null);
      localj = this.w.n();
      localx = null;
    }
    while (localj == null);
    return this.w.n();
  }

  private void p()
  {
    d(null);
  }

  final com.viber.voip.contacts.adapters.a.a a()
  {
    return this.b;
  }

  protected com.viber.voip.contacts.adapters.a.a a(List<com.viber.voip.contacts.model.a> paramList)
  {
    return this.c.a(this.a, paramList);
  }

  public void a(Intent paramIntent)
  {
    if (paramIntent == null)
      return;
    String str1 = paramIntent.getAction();
    if (str1 != null)
      if ((str1.equals("com.viber.voip.action.VIEW_CONTACT")) || (str1.equals("com.viber.voip.action.VIEW_CONTACT_DIALOG")))
        break label245;
    String str2;
    long l1;
    label245: for (boolean bool = true; ; bool = false)
    {
      this.C = bool;
      this.z = paramIntent.getStringExtra("name");
      this.A = paramIntent.getStringExtra("con_number");
      this.B = paramIntent.getStringExtra("member_id");
      this.y = ((Uri)paramIntent.getParcelableExtra("photo_uri"));
      this.D = paramIntent.getBooleanExtra("is_viber", false);
      this.H = paramIntent.getLongExtra("aggregated_hash", 0L);
      this.S = 0;
      str2 = paramIntent.getStringExtra("lookup_key");
      l1 = paramIntent.getLongExtra("contact_id", -1L);
      if ((this.w != null) && (this.w.getId() != l1))
        this.G.clear();
      this.w = null;
      if (l1 == -1L)
        this.am = ((ExtraActionAfterContactIsAdded)paramIntent.getParcelableExtra("action_after_contact_is_added"));
      if ((!cg.c(this.A)) && ((!TextUtils.isEmpty(this.B)) || (!TextUtils.isEmpty(this.A)) || (l1 != -1L)))
        break;
      this.ar.q();
      return;
    }
    String str3;
    if (!TextUtils.isEmpty(this.z))
    {
      str3 = this.z;
      if ((!this.E) && (!this.e.a()))
        break label415;
      b(str3);
    }
    while (true)
    {
      if (this.n != null)
      {
        a(null);
        d(null);
      }
      cv.a().a(l1);
      this.f.a(new s.a().a(l1).a(str2).b(this.A).c(this.B).a(true).a(), this);
      if (this.C)
        a(this.H);
      this.u.a(this);
      return;
      if (!TextUtils.isEmpty(this.A))
      {
        str3 = this.A;
        break;
      }
      str3 = " ";
      break;
      label415: this.V.a(str3);
    }
  }

  public void a(View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (g());
    while ((!(this.n instanceof ShapeImageView)) || (paramBoolean))
      return;
    this.n.setOnClickListener(paramOnClickListener);
  }

  final void a(com.viber.voip.contacts.model.a parama)
  {
    CallInitiationId.noteNextCallInitiationAttemptId();
    com.viber.voip.analytics.story.b.a.h localh = (com.viber.voip.analytics.story.b.a.h)this.an.get();
    h.a.a locala = com.viber.voip.analytics.story.b.a.h.a.i();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = parama.b;
    localh.b(locala.a(arrayOfString).b("Viber Out").a("Contact Profile").b(true).a());
    com.viber.voip.block.g.a local9 = new com.viber.voip.block.g.a()
    {
      public void a()
      {
        ViberApplication.getInstance().getEngine(false).getCallHandler().getCallInitiationListenersStore().notifyListeners(6, CallInitiationId.getCurrentCallInitiationAttemptId());
      }

      public void a(Set<Member> paramAnonymousSet)
      {
        ContactDetailsFragment.a(ContactDetailsFragment.k(ContactDetailsFragment.this), 1);
        ((DialerController)ContactDetailsFragment.this.h.get()).handleDialViberOut(this.a.a());
      }
    };
    if (this.D)
    {
      com.viber.voip.block.g.a(requireActivity(), new Member(this.B, this.A, null, this.z, null), local9);
      return;
    }
    local9.a(null);
  }

  final void a(e parame, List<com.viber.voip.model.j> paramList)
  {
    a(parame, b(paramList));
  }

  final void a(final e parame, Set<ParticipantSelector.Participant> paramSet)
  {
    com.viber.voip.util.x.a(getActivity(), paramSet, null, null, x.a.c, new ParticipantSelector.d()
    {
      public void a(ParticipantSelector.Participant paramAnonymousParticipant)
      {
      }

      public void a(boolean paramAnonymousBoolean, ParticipantSelector.Participant paramAnonymousParticipant)
      {
        ContactDetailsFragment.a(ContactDetailsFragment.this, parame, paramAnonymousParticipant);
      }
    });
  }

  public void a(com.viber.voip.model.b paramb, int paramInt)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null)
      return;
    if (4 == paramInt)
    {
      cj.c(localFragmentActivity);
      return;
    }
    if (2 == paramInt)
    {
      com.viber.voip.ui.dialogs.f.d().d();
      return;
    }
    if (paramb != null)
    {
      this.v = paramb.r();
      this.w = paramb;
      this.y = paramb.o();
      this.z = paramb.k();
      this.D = paramb.p();
      com.viber.voip.model.j localj;
      if (((this.B == null) || (this.A == null)) && (this.D))
      {
        localj = o();
        if (localj != null)
          this.B = localj.a();
      }
      for (this.A = localj.c(); ; this.A = this.w.w().a())
      {
        localFragmentActivity.getIntent().putExtra("photo_uri", this.y);
        b(paramb);
        l();
        if ((paramb.getId() == -1L) || (this.am == null))
          break;
        this.am.onContactAdded(localFragmentActivity);
        return;
      }
    }
    this.ar.q();
  }

  public void a(Set<Member> paramSet, boolean paramBoolean)
  {
    c(paramSet, true);
  }

  final List<com.viber.voip.model.j> b()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.w != null)
      localArrayList.addAll(this.w.s());
    while (TextUtils.isEmpty(this.B))
      return localArrayList;
    localArrayList.add(new com.viber.voip.model.entity.x(this.B, this.A, ""));
    return localArrayList;
  }

  public Set<ParticipantSelector.Participant> b(List<com.viber.voip.model.j> paramList)
  {
    HashSet localHashSet = new HashSet(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      localHashSet.add(ParticipantSelector.Participant.from((com.viber.voip.model.j)localIterator.next(), this.w));
    return localHashSet;
  }

  public void b(Set<Member> paramSet, boolean paramBoolean)
  {
    c(paramSet, false);
  }

  final com.viber.voip.model.b c()
  {
    return this.w;
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
    FragmentActivity localFragmentActivity = getActivity();
    if (!(localFragmentActivity instanceof c))
      throw new ClassCastException("Activity must implement fragment's callbacks.");
    if (!(localFragmentActivity instanceof com.viber.voip.permissions.l))
      throw new ClassCastException("Activity must implement PermissionConfigProvider");
    this.ar = ((c)localFragmentActivity);
    this.M = ((com.viber.voip.permissions.l)localFragmentActivity).getPermissionConfigForFragment(this);
  }

  public boolean onBackPressed()
  {
    return this.q.a();
  }

  public void onClick(View paramView)
  {
    e locale = (e)paramView.getTag();
    switch (4.a[locale.ordinal()])
    {
    default:
      return;
    case 1:
      j();
      return;
    case 2:
      a(e.b, b());
      return;
    case 3:
      h();
      return;
    case 4:
    }
    a(e.e);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.an = ViberApplication.getInstance().getLazyUserStartsCallEventCollector();
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null);
    for (Object localObject = ViberApplication.getApplication(); ; localObject = localFragmentActivity)
    {
      this.E = this.e.a((Context)localObject);
      String str;
      if (paramBundle != null)
      {
        str = paramBundle.getString("reported_number");
        this.x = str;
        this.O = com.viber.voip.util.e.e.a((Context)localObject);
        this.L = com.viber.common.permission.c.a((Context)localObject);
        this.N = f();
        if (!this.e.a())
          break label318;
      }
      label318: for (int i1 = dc.a((Context)localObject, R.attr.contactDetailsDefaultPhotoLand); ; i1 = dc.a((Context)localObject, R.attr.contactDetailsDefaultPhoto))
      {
        this.P = com.viber.voip.util.e.f.e(i1);
        this.t = av.a(av.e.a);
        this.u = new com.viber.voip.contacts.c.c.a.c();
        this.F = this.g.isLocalVideoAvailable();
        this.af = ContextCompat.getColor((Context)localObject, R.color.negative);
        this.ag = ContextCompat.getColor((Context)localObject, R.color.main_light);
        this.ah = dc.d((Context)localObject, R.attr.toolbarTitleInverseColor);
        this.ai = dc.d((Context)localObject, R.attr.toolbarTitleColor);
        this.aj = dc.d((Context)localObject, R.attr.toolbarSubtitleInverseColor);
        this.ak = dc.d((Context)localObject, R.attr.toolbarSubtitleCollapsedColor);
        this.al = dc.d((Context)localObject, R.attr.statusBarDefaultLollipopColor);
        this.Q = this.d.c().a();
        this.R = this.d.c().g();
        setHasOptionsMenu(true);
        if (paramBundle == null)
          break label330;
        Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray("call_entities");
        if (arrayOfParcelable == null)
          break label330;
        int i2 = arrayOfParcelable.length;
        for (int i3 = 0; i3 < i2; i3++)
        {
          Parcelable localParcelable = arrayOfParcelable[i3];
          this.G.add((Call)localParcelable);
        }
        str = null;
        break;
      }
      label330: this.c = new e(this, (Context)localObject, this.M, this.an);
      this.c.a(paramBundle);
      return;
    }
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenuInflater.inflate(R.menu.menu_contact_details, paramMenu);
    if ((!g()) && (this.E) && (!this.e.a()) && (ViberApplication.getApplication().getResources().getBoolean(R.bool.is_600dp)))
    {
      paramMenu.findItem(R.id.menu_favorite).setShowAsAction(0);
      paramMenu.findItem(R.id.menu_contact_edit).setShowAsAction(0);
    }
    if (com.viber.voip.registration.ao.f())
    {
      paramMenu.removeItem(R.id.menu_contact_edit);
      paramMenu.removeItem(R.id.menu_contact_delete);
      paramMenu.removeItem(R.id.menu_add);
      paramMenu.removeItem(R.id.menu_block);
    }
  }

  @SuppressLint({"NewApi"})
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    ViewGroup localViewGroup = (ViewGroup)paramLayoutInflater.inflate(R.layout.contact_details, paramViewGroup, false);
    FragmentActivity localFragmentActivity = getActivity();
    this.ad = new b(this, null);
    this.ad.a(paramLayoutInflater, localViewGroup);
    this.q = new b(localFragmentActivity, (ViewGroup)localFragmentActivity.getWindow().getDecorView(), (ViewGroup)localViewGroup.findViewById(R.id.photo_container), getLayoutInflater());
    this.V = new com.viber.voip.widget.toolbar.a(localViewGroup);
    this.Y = localViewGroup.findViewById(R.id.overlay);
    this.Z = localViewGroup.findViewById(R.id.gradient_top);
    this.aa = localViewGroup.findViewById(R.id.gradient_bottom);
    this.U = ((ViberAppBarLayout)localViewGroup.findViewById(R.id.app_bar_layout));
    if (this.U != null)
      this.U.addOnOffsetChangedListener(this.V);
    this.X = ((Toolbar)localViewGroup.findViewById(R.id.toolbar));
    this.W = new com.viber.voip.widget.e(dc.g(localViewGroup.getContext(), R.attr.toolbarBackground), this.Y, this.Z, this.aa, this.X)
    {
      public boolean adjustGradient()
      {
        return !ContactDetailsFragment.e(ContactDetailsFragment.this);
      }

      public void onScroll(float paramAnonymousFloat, ObservableCollapsingToolbarLayout.c paramAnonymousc)
      {
        super.onScroll(paramAnonymousFloat, paramAnonymousc);
        ContactDetailsFragment.a(ContactDetailsFragment.this, paramAnonymousFloat);
        ContactDetailsFragment.b(ContactDetailsFragment.this, paramAnonymousFloat);
        ContactDetailsFragment.c(ContactDetailsFragment.this, paramAnonymousFloat);
      }
    };
    this.T = ((ObservableCollapsingToolbarLayout)localViewGroup.findViewById(R.id.collapsing_toolbar_layout));
    if (this.T != null)
      this.T.setOnScrollListener(this.W);
    if (!this.E)
    {
      this.ae = new com.viber.voip.ui.ao(this.X);
      ((AppCompatActivity)localFragmentActivity).setSupportActionBar(this.X);
      android.support.v7.app.a locala = ((AppCompatActivity)localFragmentActivity).getSupportActionBar();
      locala.b(true);
      locala.c(this.e.a());
    }
    a(localViewGroup);
    a(d.a);
    if ((getActivity() != null) && (com.viber.common.d.a.i()) && (this.e.a()))
      getActivity().getWindow().setStatusBarColor(this.al);
    return localViewGroup;
  }

  public void onDestroyView()
  {
    if (this.T != null)
      this.T.setOnScrollListener(null);
    if (this.U != null)
      this.U.removeOnOffsetChangedListener(this.V);
    super.onDestroyView();
  }

  public void onDetach()
  {
    super.onDetach();
    this.ar = aq;
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    if ((paramm.a(DialogCode.D336b)) && (paramInt == -1))
    {
      this.f.a(this.w.getId(), this.w.q());
      this.Q.a();
      this.ar.q();
    }
  }

  public void onOnlineStatusActivityReady(int paramInt, OnlineContactInfo[] paramArrayOfOnlineContactInfo)
  {
    if (!isAdded());
    while (true)
    {
      return;
      OnlineContactInfo localOnlineContactInfo;
      if ((paramArrayOfOnlineContactInfo != null) && (paramArrayOfOnlineContactInfo.length > 0))
        if (paramInt == this.S)
          localOnlineContactInfo = paramArrayOfOnlineContactInfo[0];
      while ((paramInt == this.S) || (localOnlineContactInfo != null))
      {
        d(dg.a(localOnlineContactInfo));
        return;
        if (this.B != null)
        {
          int i1 = paramArrayOfOnlineContactInfo.length;
          for (int i2 = 0; ; i2++)
          {
            if (i2 >= i1)
              break label96;
            localOnlineContactInfo = paramArrayOfOnlineContactInfo[i2];
            if (this.B.equals(localOnlineContactInfo.memberId))
              break;
          }
        }
        label96: localOnlineContactInfo = null;
      }
    }
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i1 = paramMenuItem.getItemId();
    if (i1 == R.id.menu_contact_edit)
      if (this.w != null)
        aj.a(getActivity(), this.w.q());
    do
    {
      return true;
      if (i1 == R.id.menu_add)
      {
        m();
        return true;
      }
      if (i1 == R.id.menu_contact_delete)
      {
        if (this.C)
        {
          ViberApplication.getInstance().getRecentCallsManager().b(this.G, new d.d()
          {
            public void a()
            {
              ContactDetailsFragment.l(ContactDetailsFragment.this).q();
            }
          });
          return true;
        }
        if (TextUtils.isEmpty(this.z));
        for (String str3 = this.A; ; str3 = this.z)
        {
          com.viber.voip.ui.dialogs.k.f().a(this).b(-1, new Object[] { str3, str3 }).b(this);
          return true;
        }
      }
      if (i1 != R.id.menu_favorite)
        break;
    }
    while ((this.w == null) || (!this.L.a(n.j)));
    if (!this.w.r());
    for (boolean bool2 = true; ; bool2 = false)
    {
      this.v = bool2;
      aj.a(this.v, this.w.getId(), this.w.q());
      l();
      return true;
    }
    if (i1 == R.id.menu_block)
    {
      boolean bool1 = this.I.containsValue(Boolean.valueOf(false));
      aj.a(getActivity(), this.I, this.z, false, new h(this, bool1));
      if (bool1)
      {
        this.Q.a(1.0D, "Edit Contact");
        return true;
      }
      this.Q.b(1.0D, "Edit Contact");
      return true;
    }
    if (i1 == R.id.menu_share_contact)
    {
      Map localMap = this.w.d();
      Set localSet = localMap.keySet();
      HashSet localHashSet = new HashSet(localMap.size());
      Iterator localIterator = localSet.iterator();
      if (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        Member localMember = (Member)localMap.get(str1);
        if (localMember != null);
        for (String str2 = localMember.getId(); ; str2 = null)
        {
          localHashSet.add(new ParticipantSelector.Participant(str2, str1, this.z, this.y, true));
          break;
        }
      }
      com.viber.voip.util.x.a(getActivity(), localHashSet, this.l);
      return true;
    }
    if (i1 == R.id.menu_debug_untrust)
    {
      this.k.handleTrustPeer(this.A, false);
      getActivity().finish();
      return super.onOptionsItemSelected(paramMenuItem);
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  public void onPrepareOptionsMenu(Menu paramMenu)
  {
    boolean bool1 = true;
    MenuItem localMenuItem1 = paramMenu.findItem(R.id.menu_add);
    MenuItem localMenuItem2 = paramMenu.findItem(R.id.menu_favorite);
    MenuItem localMenuItem3 = paramMenu.findItem(R.id.menu_contact_edit);
    MenuItem localMenuItem4 = paramMenu.findItem(R.id.menu_contact_delete);
    MenuItem localMenuItem5 = paramMenu.findItem(R.id.menu_block);
    MenuItem localMenuItem6 = paramMenu.findItem(R.id.menu_share_contact);
    paramMenu.findItem(R.id.menu_debug_untrust);
    boolean bool3;
    int i2;
    label175: int i3;
    if ((this.w != null) && (this.w.getId() > 0L))
    {
      if (localMenuItem1 != null)
        localMenuItem1.setVisible(false);
      if (localMenuItem3 != null)
        localMenuItem3.setVisible(bool1);
      if (localMenuItem4 != null)
      {
        if (!this.C)
        {
          bool3 = bool1;
          localMenuItem4.setVisible(bool3);
        }
      }
      else
      {
        if (localMenuItem2 != null)
        {
          localMenuItem2.setVisible(bool1);
          if (!this.v)
            break label310;
          i2 = R.drawable.ic_ab_favorite;
          localMenuItem2.setIcon(i2);
          if (!this.v)
            break label318;
          i3 = R.string.menu_removeStar;
          label197: localMenuItem2.setTitle(i3);
        }
        if (localMenuItem6 != null)
          localMenuItem6.setVisible(bool1);
        if (localMenuItem5 != null)
        {
          if ((this.I.isEmpty()) || (this.ac))
            break label414;
          label245: localMenuItem5.setVisible(bool1);
          if (bool1)
            if (this.I.containsValue(Boolean.valueOf(false)))
              break label419;
        }
      }
    }
    label408: label414: label419: for (int i1 = R.string.unblock; ; i1 = R.string.block)
    {
      localMenuItem5.setTitle(i1);
      if (this.ae != null)
        this.ae.a();
      return;
      bool3 = false;
      break;
      label310: i2 = R.drawable.top_bar_star_icon;
      break label175;
      label318: i3 = R.string.menu_add_to_fav;
      break label197;
      if (localMenuItem1 != null)
        if (this.w == null)
          break label408;
      for (boolean bool2 = bool1; ; bool2 = false)
      {
        localMenuItem1.setVisible(bool2);
        if (localMenuItem2 != null)
          localMenuItem2.setVisible(false);
        if (localMenuItem3 != null)
          localMenuItem3.setVisible(false);
        if (localMenuItem4 != null)
          localMenuItem4.setVisible(false);
        if (localMenuItem6 == null)
          break;
        localMenuItem6.setVisible(false);
        break;
      }
      bool1 = false;
      break label245;
    }
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putString("reported_number", this.x);
    if ((this.C) && (this.G != null))
      paramBundle.putParcelableArrayList("call_entities", this.G);
    this.c.b(paramBundle);
    super.onSaveInstanceState(paramBundle);
  }

  public void onStart()
  {
    super.onStart();
    this.c.b();
    this.L.a(this.N);
  }

  public void onStop()
  {
    this.c.c();
    this.L.b(this.N);
    this.f.a(this);
    this.u.b(this);
    this.q.a();
    this.j.removeListener(this);
    super.onStop();
  }

  static class a
  {
    final com.viber.voip.app.b a;
    final com.viber.voip.analytics.g b;
    final CallHandler c;
    final DialerController d;
    final ParticipantSelector.Participant e;
    private final Bundle f;

    a(com.viber.voip.app.b paramb, com.viber.voip.analytics.g paramg, CallHandler paramCallHandler, DialerController paramDialerController, ParticipantSelector.Participant paramParticipant, Bundle paramBundle)
    {
      this.a = paramb;
      this.b = paramg;
      this.c = paramCallHandler;
      this.d = paramDialerController;
      this.e = paramParticipant;
      this.f = paramBundle;
    }
  }

  private static class b
  {
    private final View.OnClickListener a;
    private ContactDetailsButtonsLayout b;
    private ProgressBar c;

    private b(View.OnClickListener paramOnClickListener)
    {
      this.a = paramOnClickListener;
    }

    public View a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      int i;
      int j;
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        i = 1;
        ProgressBar localProgressBar = this.c;
        j = 0;
        if (i == 0)
          break label55;
        label25: localProgressBar.setVisibility(j);
        if (i == 0)
          break label61;
        this.b.a();
      }
      while (true)
      {
        return this.b;
        i = 0;
        break;
        label55: j = 4;
        break label25;
        label61: if (paramBoolean1)
          this.b.a(R.string.menu_free_call, R.string.menu_free_message, ContactDetailsFragment.e.a, ContactDetailsFragment.e.b);
        else
          this.b.a(R.string.viber_out_call_button, R.string.invite_to_viber, ContactDetailsFragment.e.d, ContactDetailsFragment.e.e);
      }
    }

    public void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
    {
      this.b = ((ContactDetailsButtonsLayout)paramLayoutInflater.inflate(R.layout.contact_details_list_item_viber_buttons_gsm_call_support, paramViewGroup, false));
      this.b.a(this.a, this.a);
      this.c = ((ProgressBar)this.b.findViewById(R.id.checking_progress));
    }
  }

  public static abstract interface c
  {
    public abstract void q();
  }

  private static enum d
  {
    static
    {
      d[] arrayOfd = new d[2];
      arrayOfd[0] = a;
      arrayOfd[1] = b;
    }
  }

  protected static abstract enum e
  {
    static
    {
      e[] arrayOfe = new e[5];
      arrayOfe[0] = a;
      arrayOfe[1] = b;
      arrayOfe[2] = c;
      arrayOfe[3] = d;
      arrayOfe[4] = e;
    }

    abstract void a(Context paramContext, com.viber.voip.analytics.story.e.c paramc, dagger.a<com.viber.voip.analytics.story.b.a.h> parama, ContactDetailsFragment.a parama1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.ContactDetailsFragment
 * JD-Core Version:    0.6.2
 */