package com.viber.voip.shareviber.invitescreen;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.util.ArraySet;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.o;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.av.e;
import com.viber.voip.calls.e;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.ui.view.SearchNoResultsView;
import com.viber.voip.permissions.m;
import com.viber.voip.permissions.n;
import com.viber.voip.registration.ao;
import com.viber.voip.shareviber.invitescreen.a.b.a;
import com.viber.voip.shareviber.invitescreen.a.d;
import com.viber.voip.shareviber.invitescreen.b.k;
import com.viber.voip.shareviber.invitescreen.b.l;
import com.viber.voip.ui.ContactsListView;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ViberActionRunner.af;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import java.util.List;

public class InviteActivity extends ViberFragmentActivity
  implements View.OnClickListener, b.a, b, c
{
  private static final Logger a = ViberEnv.getLogger();
  private Presenter b;
  private ContactsListView c;
  private com.b.a.a.a d;
  private d e;
  private com.viber.voip.shareviber.invitescreen.a.c f;
  private View g;
  private View h;
  private TextView i;
  private SearchNoResultsView j;
  private final TextWatcher k = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      InviteActivity.a(InviteActivity.this).a(paramAnonymousEditable.toString());
    }

    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
    }

    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
    }
  };
  private final TextView.OnEditorActionListener l = new TextView.OnEditorActionListener()
  {
    public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
    {
      if (paramAnonymousInt == 3)
      {
        dj.d(InviteActivity.this);
        return true;
      }
      return false;
    }
  };
  private com.viber.common.permission.c m;
  private View n;
  private View o;
  private final com.viber.common.permission.b p;

  public InviteActivity()
  {
    Pair[] arrayOfPair = new Pair[1];
    arrayOfPair[0] = m.a(95);
    this.p = new com.viber.voip.permissions.f(this, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        if (paramAnonymousInt == 95)
          InviteActivity.a(InviteActivity.this).i();
      }
    };
  }

  private void a(View paramView)
  {
    ((ImageView)paramView.findViewById(R.id.permission_icon)).setImageResource(R.drawable.ic_permission_contacts);
    ((TextView)paramView.findViewById(R.id.permission_description)).setText(R.string.block_list_permission_description);
    paramView.findViewById(R.id.button_request_permission).setOnClickListener(this);
  }

  public void a()
  {
    dj.b(this.g, false);
    dj.b(this.h, false);
  }

  public void a(int paramInt)
  {
    dj.b(this.g, true);
    dj.b(this.h, true);
    this.i.setText(String.valueOf(paramInt));
  }

  public void a(com.viber.voip.contacts.a parama, boolean paramBoolean)
  {
    this.d.a(this.j);
    this.d.b(this.j, true);
    LayoutInflater localLayoutInflater = getLayoutInflater();
    this.e = new d(this, this.mIsTablet, this, this.b, localLayoutInflater);
    this.d.a(this.e);
    this.d.a(this.e, true);
    this.f = new com.viber.voip.shareviber.invitescreen.a.c(this, this.mIsTablet, parama, this, this.b, localLayoutInflater);
    this.d.a(this.f);
    this.d.a(this.f, true);
    this.c.setAdapter(this.d);
  }

  public void a(com.viber.voip.model.c paramc, boolean paramBoolean)
  {
    this.b.a(paramc, paramBoolean);
  }

  public void a(List<com.viber.voip.model.a> paramList)
  {
    this.e.a(paramList);
    this.d.notifyDataSetChanged();
  }

  public void a(List<String> paramList, String paramString)
  {
    ViberActionRunner.af.a(this, paramList, paramString);
  }

  public void a(boolean paramBoolean)
  {
    com.b.a.a.a locala = this.d;
    d locald = this.e;
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      locala.a(locald, bool);
      return;
    }
  }

  public void a(boolean paramBoolean, String paramString)
  {
    com.b.a.a.a locala = this.d;
    com.viber.voip.shareviber.invitescreen.a.c localc = this.f;
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      locala.a(localc, bool);
      this.j.setQueryText(paramString);
      this.d.b(this.j, paramBoolean);
      return;
    }
  }

  public void b()
  {
    dj.b(this.o, false);
    dj.b(this.n, true);
    c();
  }

  public void c()
  {
    this.d.notifyDataSetChanged();
  }

  public void d()
  {
    dj.b(this.n, false);
    dj.b(this.o, true);
  }

  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == R.id.invite_button)
      this.b.f();
    while (i1 != R.id.button_request_permission)
      return;
    this.m.a(this, 95, n.j);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (ViberApplication.isTablet(this))
      dj.a(this, true, true);
    android.support.v7.app.a locala = getSupportActionBar();
    if (locala != null)
    {
      locala.e(true);
      locala.b(true);
      locala.b(R.string.share_viber_invite_friends);
    }
    setContentView(R.layout.invite_activity_layout);
    this.n = findViewById(R.id.contacts_root);
    this.o = findViewById(R.id.empty_no_permissions_root);
    a(this.o);
    this.c = ((ContactsListView)findViewById(R.id.list));
    this.d = new com.b.a.a.a();
    this.g = findViewById(R.id.invite_button);
    this.g.setOnClickListener(this);
    this.h = findViewById(R.id.invite_button_divider);
    this.i = ((TextView)findViewById(R.id.invite_counter));
    EditText localEditText = (EditText)findViewById(R.id.search);
    localEditText.addTextChangedListener(this.k);
    localEditText.setOnEditorActionListener(this.l);
    this.j = ((SearchNoResultsView)getLayoutInflater().inflate(R.layout.search_no_results_item, this.c, false));
    Application localApplication = ViberApplication.getApplication();
    ViberApplication localViberApplication = ViberApplication.getInstance();
    com.viber.voip.contacts.c.d.g localg = localViberApplication.getContactManager();
    a locala1 = new a(this, av.e.a.a(), getSupportLoaderManager(), localg);
    Engine localEngine = localViberApplication.getEngine(false);
    Member localMember = localViberApplication.getUserManager().getUser();
    boolean bool;
    String str;
    if (!ao.f())
    {
      bool = true;
      k localk = new k(new com.viber.voip.shareviber.invitescreen.b.f(bool, localMember, localApplication.getContentResolver(), localg.c(), e.a(localViberApplication), localEngine.getPhoneController(), UserManager.from(this).getRegistrationValues()), new l().a(), av.e.a.a());
      com.viber.voip.analytics.story.g.a locala2 = com.viber.voip.analytics.g.a().c().c();
      str = getIntent().getStringExtra("source_extra");
      if (da.a(str))
        str = "Value Changed Unavailable";
      this.b = new Presenter(locala1, this, localk, locala2, str);
      if (paramBundle != null)
        break label448;
    }
    label448: for (Object localObject = new Presenter.State("", new ArraySet(), false, true, getIntent().getStringExtra("text"), str); ; localObject = paramBundle.getParcelable("invite_screen_state"))
    {
      this.b.a(this, (Parcelable)localObject);
      this.m = com.viber.common.permission.c.a(this);
      return;
      bool = false;
      break;
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(R.menu.menu_invite, paramMenu);
    return true;
  }

  protected void onDestroy()
  {
    this.b.b();
    super.onDestroy();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i1 = paramMenuItem.getItemId();
    if (i1 == R.id.menu_invite_select_all)
    {
      this.b.g();
      return true;
    }
    if (i1 == 16908332)
    {
      finish();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putParcelable("invite_screen_state", this.b.c());
    super.onSaveInstanceState(paramBundle);
  }

  protected void onStart()
  {
    this.m.a(this.p);
    if (this.m.a(n.j))
      this.b.d();
    while (true)
    {
      super.onStart();
      return;
      this.b.h();
    }
  }

  protected void onStop()
  {
    this.b.e();
    this.m.b(this.p);
    super.onStop();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.shareviber.invitescreen.InviteActivity
 * JD-Core Version:    0.6.2
 */