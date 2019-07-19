package com.viber.voip.settings.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m.c;
import com.viber.common.permission.b;
import com.viber.jni.CSecondaryDeviceDetails;
import com.viber.jni.CSecondaryDeviceDetails.CSecondaryDeviceDetailsElement;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.secure.DeviceManagerController;
import com.viber.jni.secure.DeviceManagerDelegate;
import com.viber.jni.secure.DeviceManagerListener;
import com.viber.jni.secure.SecurePrimaryActivationDelegate;
import com.viber.jni.secure.SecurePrimaryActivationListener;
import com.viber.voip.R.attr;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.ViberApplication;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.o;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.permissions.f;
import com.viber.voip.permissions.n;
import com.viber.voip.registration.ak;
import com.viber.voip.registration.ak.c;
import com.viber.voip.secondary.SecondaryDevice;
import com.viber.voip.ui.aq;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.t;
import com.viber.voip.util.ViberActionRunner.aw;
import com.viber.voip.util.cj;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import com.viber.voip.widget.a.e;
import java.util.ArrayList;

public class q extends aq
  implements m.c, DeviceManagerDelegate, ak.c, com.viber.voip.ui.a.a
{
  private Handler a;
  private boolean b;
  private View c;
  private RecyclerView d;
  private View e;
  private View f;
  private com.viber.voip.secondary.a g;
  private ArrayList<SecondaryDevice> h;
  private ak i;
  private DeviceManagerListener j;
  private DeviceManagerController k;
  private SecurePrimaryActivationListener l;
  private com.viber.common.permission.c m;
  private com.viber.voip.analytics.story.i.c n;
  private final SecurePrimaryActivationDelegate o = new SecurePrimaryActivationDelegate()
  {
    public void onSecureSecondaryDeviceActivated(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
    {
      q.a(q.this).handleGetSecondaryDeviceDetails();
    }

    public void onSecureSecondaryRequest(int paramAnonymousInt)
    {
    }
  };
  private final RecyclerView.AdapterDataObserver p = new RecyclerView.AdapterDataObserver()
  {
    public void onChanged()
    {
      if ((q.b(q.this) == null) || (q.b(q.this).a()))
        dj.a(q.c(q.this), q.d(q.this), true);
    }

    public void onItemRangeRemoved(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      onChanged();
    }
  };
  private final b q;

  public q()
  {
    FragmentActivity localFragmentActivity = getActivity();
    Pair[] arrayOfPair = new Pair[1];
    arrayOfPair[0] = com.viber.voip.permissions.m.a(3);
    this.q = new f(localFragmentActivity, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        default:
          return;
        case 3:
        }
        q.this.b();
      }
    };
  }

  private static ArrayList<SecondaryDevice> a(CSecondaryDeviceDetails paramCSecondaryDeviceDetails)
  {
    ArrayList localArrayList = new ArrayList();
    CSecondaryDeviceDetails.CSecondaryDeviceDetailsElement[] arrayOfCSecondaryDeviceDetailsElement = paramCSecondaryDeviceDetails.elements;
    if (arrayOfCSecondaryDeviceDetailsElement != null)
    {
      int i1 = arrayOfCSecondaryDeviceDetailsElement.length;
      for (int i2 = 0; i2 < i1; i2++)
        localArrayList.add(SecondaryDevice.valueOf(arrayOfCSecondaryDeviceDetailsElement[i2]));
    }
    return localArrayList;
  }

  private void a(com.viber.voip.secondary.a parama)
  {
    int i1;
    if (this.g != null)
    {
      i1 = 1;
      this.g = parama;
      if (this.g != null)
        this.g.registerAdapterDataObserver(this.p);
      if (this.d != null)
      {
        this.d.setAdapter(parama);
        if ((this.g != null) && (!this.g.a()))
          break label118;
        dj.a(this.f, this.d, false);
      }
    }
    while (true)
    {
      if ((!this.b) && (i1 == 0))
      {
        IBinder localIBinder = getView().getWindowToken();
        boolean bool = false;
        if (localIBinder != null)
          bool = true;
        a(true, bool);
      }
      return;
      i1 = 0;
      break;
      label118: dj.a(this.d, this.f, false);
    }
  }

  private void a(ArrayList<SecondaryDevice> paramArrayList)
  {
    if (paramArrayList == null)
      paramArrayList = new ArrayList(0);
    this.h = paramArrayList;
    a(new com.viber.voip.secondary.a(getActivity(), paramArrayList, this, getLayoutInflater()));
  }

  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.b == paramBoolean1)
      return;
    this.b = paramBoolean1;
    if (paramBoolean1)
    {
      dj.a(this.c, this.e, paramBoolean2);
      return;
    }
    dj.a(this.e, this.c, paramBoolean2);
  }

  void a()
  {
    if (this.m.a(n.a))
    {
      b();
      return;
    }
    this.m.a(this, 3, n.a);
  }

  public void a(int paramInt, View paramView)
  {
    if (this.g.a(paramInt) == -1)
      return;
    SecondaryDevice localSecondaryDevice = this.g.b(paramInt);
    l.a locala = t.d();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = localSecondaryDevice.getSystemName();
    locala.b(-1, arrayOfObject).a(localSecondaryDevice).a(this).b(this);
  }

  public void a(String paramString)
  {
    int i1 = this.g.a(paramString);
    if ((i1 == -1) || (this.d == null))
      return;
    this.g.d(i1);
  }

  void b()
  {
    ViberActionRunner.aw.a(true, getActivity(), null, getActivity().getIntent().getStringExtra("analytics_connect_secondary_entry_point"));
  }

  public void b(String paramString)
  {
    int i1 = this.g.a(paramString);
    if ((i1 == -1) || (this.d == null))
      return;
    RecyclerView.ViewHolder localViewHolder = this.d.findViewHolderForAdapterPosition(i1);
    this.g.a(false, i1, localViewHolder);
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    View localView = getView();
    this.c = localView.findViewById(R.id.list_container);
    this.d = ((RecyclerView)localView.findViewById(16908298));
    this.e = localView.findViewById(16908301);
    this.f = localView.findViewById(16908292);
    TextView localTextView1 = (TextView)localView.findViewById(R.id.more_desktop_link);
    localTextView1.setOnClickListener(new r(this));
    TextView localTextView2 = (TextView)localView.findViewById(R.id.more_tablet_link);
    localTextView2.setOnClickListener(new s(this));
    dj.a(localTextView1, true);
    dj.a(localTextView2, true);
    e locale = new e(dc.g(getActivity(), R.attr.recyclerDividerDrawable));
    locale.a(0, true);
    this.d.addItemDecoration(locale);
    this.b = true;
    a(false, false);
    if (paramBundle == null)
      this.k.handleGetSecondaryDeviceDetails();
    while (true)
    {
      this.n.c(getActivity().getIntent().getStringExtra("extra entry point"));
      return;
      a(paramBundle.getParcelableArrayList("secondary_devices"));
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
    this.i = new ak(this);
    this.a = av.a(av.e.a);
    Engine localEngine = ViberApplication.getInstance().getEngine(false);
    this.j = localEngine.getDelegatesManager().getDeviceManagerListener();
    this.j.registerDelegate(new DeviceManagerDelegate[] { this });
    this.k = localEngine.getDeviceManagerController();
    this.l = localEngine.getDelegatesManager().getSecurePrimaryActivationListener();
    SecurePrimaryActivationListener localSecurePrimaryActivationListener = this.l;
    SecurePrimaryActivationDelegate[] arrayOfSecurePrimaryActivationDelegate = new SecurePrimaryActivationDelegate[1];
    arrayOfSecurePrimaryActivationDelegate[0] = this.o;
    localSecurePrimaryActivationListener.registerDelegate(arrayOfSecurePrimaryActivationDelegate);
    this.m = com.viber.common.permission.c.a(getActivity());
    this.n = g.a().c().j();
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenuInflater.inflate(R.menu.menu_manage_secondaries, paramMenu);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.fragment_manage_secondaries, paramViewGroup, false);
  }

  public void onDestroy()
  {
    this.j.removeDelegate(this);
    this.l.removeDelegate(this.o);
    if (this.g != null)
      this.g.unregisterAdapterDataObserver(this.p);
    super.onDestroy();
  }

  public void onDestroyView()
  {
    this.b = false;
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = null;
    super.onDestroyView();
  }

  public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    if (paramm.a(DialogCode.D402f));
    switch (paramInt)
    {
    default:
      return;
    case -1:
    }
    SecondaryDevice localSecondaryDevice = (SecondaryDevice)paramm.d();
    int i1 = this.g.a(localSecondaryDevice.getUdid());
    if ((cj.a(this, true)) && (i1 != -1))
    {
      RecyclerView.ViewHolder localViewHolder = this.d.findViewHolderForAdapterPosition(i1);
      this.g.a(true, i1, localViewHolder);
      this.i.a(localSecondaryDevice.getUdid(), localSecondaryDevice.getSystemId());
    }
    this.n.d("Deactivate Link");
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (R.id.menu_manage_secondaries_add == paramMenuItem.getItemId())
    {
      this.n.d("+ Icon");
      a();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelableArrayList("secondary_devices", this.h);
  }

  public void onSecondaryDeviceDetails(final CSecondaryDeviceDetails paramCSecondaryDeviceDetails)
  {
    final ArrayList localArrayList = a(paramCSecondaryDeviceDetails);
    this.a.post(new Runnable()
    {
      public void run()
      {
        if (!q.this.isAdded())
          return;
        if (paramCSecondaryDeviceDetails.status != 0)
        {
          q localq = q.this;
          ad.a().a(localq).b(localq);
        }
        q.a(q.this, localArrayList);
      }
    });
  }

  public void onStart()
  {
    super.onStart();
    this.m.a(this.q);
  }

  public void onStop()
  {
    this.m.b(this.q);
    super.onStop();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.q
 * JD-Core Version:    0.6.2
 */