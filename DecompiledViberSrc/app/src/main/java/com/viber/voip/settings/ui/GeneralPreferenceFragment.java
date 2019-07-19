package com.viber.voip.settings.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.c.a;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.Preference.b;
import android.support.v7.preference.Preference.c;
import android.support.v7.preference.PreferenceScreen;
import android.support.v7.preference.j;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import com.viber.common.b.d;
import com.viber.common.b.h;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m.c;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.R.xml;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ap;
import com.viber.voip.messages.a.g.b;
import com.viber.voip.phone.MinimizedCallManager;
import com.viber.voip.phone.PhoneApp;
import com.viber.voip.pixie.ProxySettings;
import com.viber.voip.pixie.ProxySettingsHolder;
import com.viber.voip.registration.ActivationController;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.ad.a;
import com.viber.voip.settings.d.af;
import com.viber.voip.settings.d.ag;
import com.viber.voip.settings.d.az;
import com.viber.voip.settings.d.m;
import com.viber.voip.settings.d.p;
import com.viber.voip.settings.d.r;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.t;
import com.viber.voip.user.UserData;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ViberActionRunner.ax;
import com.viber.voip.util.da;
import java.io.Serializable;
import java.util.Locale;
import java.util.MissingResourceException;
import javax.inject.Inject;
import org.greenrobot.eventbus.EventBus;

public class GeneralPreferenceFragment extends SettingsHeadersActivity.a
  implements m.c
{
  private static final Logger c = ViberEnv.getLogger();

  @Inject
  EventBus b;
  private Preference d;
  private com.viber.common.permission.c e;
  private final com.viber.common.permission.b f;

  public GeneralPreferenceFragment()
  {
    Pair[] arrayOfPair = new Pair[1];
    arrayOfPair[0] = com.viber.voip.permissions.m.a(70);
    this.f = new com.viber.voip.permissions.e(this, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        ((CheckBoxPreference)GeneralPreferenceFragment.this.a(d.p.g.c())).f(true);
      }
    };
  }

  private void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    ViberActionRunner.ax.a(this, 207, paramString, paramBoolean1, paramBoolean2);
  }

  private void j()
  {
    ProxySettings localProxySettings = ProxySettingsHolder.obtain();
    if ((!localProxySettings.enabled) || (da.a(localProxySettings.url)));
    for (String str = "None"; ; str = localProxySettings.url + ":" + localProxySettings.port)
    {
      this.d.b(str);
      return;
    }
  }

  private void k()
  {
    ((CheckBoxPreference)a(d.r.E.c())).f(d.r.E.d());
  }

  private void l()
  {
    if (!this.e.a(com.viber.voip.permissions.n.j))
      d.p.g.a(false);
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)a(d.p.g.c());
    localCheckBoxPreference.f(d.p.g.d());
    localCheckBoxPreference.a(new Preference.b()
    {
      public boolean a(Preference paramAnonymousPreference, Object paramAnonymousObject)
      {
        if (GeneralPreferenceFragment.a(GeneralPreferenceFragment.this).a(com.viber.voip.permissions.n.j))
          return true;
        GeneralPreferenceFragment.a(GeneralPreferenceFragment.this).a(GeneralPreferenceFragment.this, 70, com.viber.voip.permissions.n.j);
        return false;
      }
    });
  }

  private void m()
  {
    PreferenceScreen localPreferenceScreen = b();
    String[] arrayOfString1 = new String[2];
    arrayOfString1[0] = getString(R.string.pref_wifi_policy_always_connected);
    arrayOfString1[1] = getString(R.string.pref_wifi_policy_use_device_settings);
    String[] arrayOfString2 = { "pref_wifi_policy_always_connected", "pref_wifi_policy_use_device_settings" };
    String[] arrayOfString3 = new String[2];
    arrayOfString3[0] = getString(R.string.pref_wifi_policy_always_connected_sub);
    arrayOfString3[1] = getString(R.string.pref_wifi_policy_use_device_settings_sub);
    SummaryListPreference localSummaryListPreference = new SummaryListPreference(a().g());
    try
    {
      String str2 = Locale.getDefault().getISO3Language();
      str1 = str2;
      if ("ara".equals(str1))
        localSummaryListPreference.c(R.layout.long_preference);
      while (true)
      {
        localSummaryListPreference.d(d.af.d.c());
        localSummaryListPreference.a(arrayOfString1);
        localSummaryListPreference.b(arrayOfString2);
        localSummaryListPreference.c(arrayOfString3);
        localSummaryListPreference.a(R.string.pref_wifi_sleep_policy);
        localSummaryListPreference.e(R.string.pref_wifi_sleep_policy);
        localSummaryListPreference.c(d.af.d.f());
        localPreferenceScreen.c(localSummaryListPreference);
        localSummaryListPreference.a(new Preference.b()
        {
          public boolean a(Preference paramAnonymousPreference, Object paramAnonymousObject)
          {
            boolean bool = "pref_wifi_policy_always_connected".equals(paramAnonymousObject.toString());
            ViberApplication.getInstance().getPhoneApp().lockWifi(bool);
            return true;
          }
        });
        return;
        localSummaryListPreference.c(R.layout._ics_custom_preference_layout);
      }
    }
    catch (MissingResourceException localMissingResourceException)
    {
      while (true)
        String str1 = null;
    }
  }

  private void n()
  {
    Preference localPreference = new x(a().g(), x.a.a, getString(R.string.pref_restore_defaults_key), getString(R.string.pref_restore_defaults_title)).a(new Preference.c()
    {
      public boolean a(Preference paramAnonymousPreference)
      {
        t.a().a(GeneralPreferenceFragment.this).b(GeneralPreferenceFragment.this);
        return true;
      }
    }).a();
    b().c(localPreference);
  }

  private void o()
  {
    b().c(new x(a().g(), x.a.a, getString(R.string.pref_exit_defaults_key), getString(R.string.exit)).a(new m(this)).a());
  }

  private void p()
  {
    ViberApplication localViberApplication = ViberApplication.getInstance();
    localViberApplication.getFacebookManager().a();
    d.ad.a.c.e();
    d.m.f.e();
    ActivationController localActivationController = localViberApplication.getActivationController();
    String str1 = localActivationController.getCountryCode();
    String str2 = localActivationController.getAlphaCountryCode();
    String str3 = localActivationController.getRegNumber();
    String str4 = localActivationController.getCountry();
    String str5 = localActivationController.getRegNumberCanonized();
    int i = d.p.i.d();
    String str6 = localViberApplication.getActivationController().getDeviceKey();
    UserData localUserData = UserManager.from(ViberApplication.getApplication()).getUserData();
    String str7 = ap.d();
    localActivationController.storeRegValues(str1, str2, str4, str3);
    localActivationController.storeRegNumberCanonized(str5);
    d.p.i.a(i);
    d.az.a.a(str7);
    localViberApplication.getActivationController().setDeviceKey(str6);
    localUserData.setUserData(localUserData.getViberName(), localUserData.getImage());
    UserManager.from(getActivity()).getUserData();
  }

  private void q()
  {
    r();
    u.j();
    y.j();
    v.j();
    c.j();
    i.j();
    i();
  }

  private void r()
  {
    d.p.g.e();
    d.ag.e.e();
    d.af.e.a("pref_pixie_mode_auto");
    d.p.c.e();
    d.r.E.e();
  }

  public boolean a(Preference paramPreference)
  {
    if (d.r.e.c().equals(paramPreference.C()))
    {
      startActivity(new Intent(getActivity(), ProxySettingsPreferenceActivity.class));
      return true;
    }
    if (getString(R.string.pref_ui_language_key).equals(paramPreference.C()))
    {
      a(d.ad.a.c.d(), false, false);
      return true;
    }
    return false;
  }

  public void b(Bundle paramBundle, String paramString)
  {
    a(R.xml.settings_general, paramString);
  }

  public void b(Preference paramPreference)
  {
    if ((paramPreference instanceof SummaryListPreference))
    {
      c localc = c.b(paramPreference.C());
      localc.setTargetFragment(this, 0);
      localc.show(getFragmentManager(), "GeneralPreferenceFragment.SUMMARY_LIST_DIALOG");
      return;
    }
    super.b(paramPreference);
  }

  public void i()
  {
    com.viber.service.contacts.sync.a.a().c();
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
      localFragmentActivity.recreate();
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((207 == paramInt1) && (paramInt2 == -1))
    {
      String str = paramIntent.getStringExtra("selected_lang");
      boolean bool = paramIntent.getBooleanExtra("from_url_scheme", false);
      d.ad.a.c.a(str);
      this.b.post(new g.b(str, bool));
      ((UiLanguagePreference)a(d.ad.a.c.c())).f();
      getActivity().recreate();
    }
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.e = com.viber.common.permission.c.a(getActivity());
    k();
    m();
    n();
    o();
    l();
    if (!ao.g())
      b().d(a(d.p.g.c()));
    b().d(a(d.af.e.c()));
    this.d = a(d.r.e.c());
    if ((!ao.f()) && (getArguments() != null) && (getArguments().containsKey("inner_screen")));
    switch (getArguments().getByte("inner_screen"))
    {
    default:
      getArguments().remove("inner_screen");
      return;
    case 4:
    }
    String str = getArguments().getString("ui_language", null);
    if (str != null);
    for (boolean bool = true; ; bool = false)
    {
      if (str == null)
        str = d.ad.a.c.d();
      a(str, true, bool);
      getArguments().remove("ui_language");
      break;
    }
  }

  public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    if ((paramm.a(DialogCode.D355a)) && (paramInt == -1))
      if (MinimizedCallManager.getInstance().endCallIfNeeded())
        ViberApplication.exit(getActivity(), false);
    do
    {
      a locala;
      do
      {
        return;
        com.viber.voip.messages.extras.a.e.d(getActivity());
        ViberApplication.exit(getActivity(), false);
        return;
        if (!paramm.a(DialogCode.D425))
          break;
        locala = (a)paramm.d();
        if (paramInt == -1)
        {
          d.af.e.a(locala.a);
          ViberApplication.exit(getActivity(), true);
          return;
        }
      }
      while (paramInt != -2);
      d.af.e.a(locala.b);
      return;
    }
    while ((!paramm.a(DialogCode.D400)) || (paramInt != -1));
    p();
    q();
  }

  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    super.onSharedPreferenceChanged(paramSharedPreferences, paramString);
    if (paramString.equals(d.ag.e.c()))
      b(paramString, d.ag.e.d());
    do
    {
      return;
      if (paramString.equals(d.p.c.c()))
      {
        b(paramString, d.p.c.d());
        return;
      }
      if (paramString.equals(d.p.g.c()))
      {
        com.viber.service.contacts.sync.a.a().c();
        return;
      }
    }
    while (!paramString.equals(d.r.E.c()));
    b(paramString, d.r.E.d());
  }

  public void onStart()
  {
    super.onStart();
    this.e.a(this.f);
    j();
  }

  public void onStop()
  {
    super.onStop();
    this.e.b(this.f);
  }

  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    com.viber.common.app.a.a(new k(this, paramIntent, paramBundle), new Intent[] { paramIntent });
  }

  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    com.viber.common.app.a.a(new l(this, paramIntent, paramInt, paramBundle), new Intent[] { paramIntent });
  }

  public static class SummaryListPreference extends ListPreference
  {
    private CharSequence[] a;

    public SummaryListPreference(Context paramContext)
    {
      super();
    }

    public void a(String paramString)
    {
      if (b(paramString))
        b(paramString);
    }

    public CharSequence[] b()
    {
      return this.a;
    }

    public void c(CharSequence[] paramArrayOfCharSequence)
    {
      this.a = paramArrayOfCharSequence;
    }
  }

  private static class a
    implements Serializable
  {
    String a;
    String b;
  }

  public static class b extends ArrayAdapter<CharSequence>
    implements View.OnClickListener
  {
    int a;
    CharSequence[] b;
    CharSequence[] c;
    CharSequence[] d;
    GeneralPreferenceFragment.c e;
    private LayoutInflater f;

    public b(Context paramContext, int paramInt1, CharSequence[] paramArrayOfCharSequence1, CharSequence[] paramArrayOfCharSequence2, CharSequence[] paramArrayOfCharSequence3, int paramInt2, GeneralPreferenceFragment.c paramc, LayoutInflater paramLayoutInflater)
    {
      super(paramInt1, paramArrayOfCharSequence2);
      this.a = paramInt2;
      this.b = paramArrayOfCharSequence1;
      this.c = paramArrayOfCharSequence2;
      this.d = paramArrayOfCharSequence3;
      this.e = paramc;
      this.f = paramLayoutInflater;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = this.f.inflate(R.layout.preference_dialog_summary_item, paramViewGroup, false);
      localView.setOnClickListener(this);
      localView.setTag(this.c[paramInt]);
      if (this.b != null)
        ((TextView)localView.findViewById(R.id.item_name)).setText(this.b[paramInt]);
      if (this.d != null)
        ((TextView)localView.findViewById(R.id.item_summary)).setText(this.d[paramInt]);
      RadioButton localRadioButton = (RadioButton)localView.findViewById(R.id.check_box);
      if (paramInt == this.a);
      for (boolean bool = true; ; bool = false)
      {
        localRadioButton.setChecked(bool);
        localRadioButton.setClickable(false);
        return localView;
      }
    }

    public void onClick(View paramView)
    {
      if ((this.e != null) && (paramView.getTag() != null))
      {
        ((GeneralPreferenceFragment.SummaryListPreference)this.e.b()).a(paramView.getTag().toString());
        this.e.dismiss();
      }
    }
  }

  public static class c extends android.support.v7.preference.c
  {
    public static c b(String paramString)
    {
      c localc = new c();
      Bundle localBundle = new Bundle(1);
      localBundle.putString("key", paramString);
      localc.setArguments(localBundle);
      return localc;
    }

    protected void a(c.a parama)
    {
      super.a(parama);
      GeneralPreferenceFragment.SummaryListPreference localSummaryListPreference = (GeneralPreferenceFragment.SummaryListPreference)b();
      int i = localSummaryListPreference.c(localSummaryListPreference.J().getString(localSummaryListPreference.C(), "pref_wifi_policy_always_connected"));
      LayoutInflater localLayoutInflater = LayoutInflater.from(parama.a());
      parama.a(new GeneralPreferenceFragment.b(parama.a(), R.layout.preference_dialog_summary_item, localSummaryListPreference.m(), localSummaryListPreference.n(), localSummaryListPreference.b(), i, this, localLayoutInflater), null);
    }

    public void a(boolean paramBoolean)
    {
    }

    public void startActivity(Intent paramIntent, Bundle paramBundle)
    {
      com.viber.common.app.a.a(new n(this, paramIntent, paramBundle), new Intent[] { paramIntent });
    }

    public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
    {
      com.viber.common.app.a.a(new o(this, paramIntent, paramInt, paramBundle), new Intent[] { paramIntent });
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.GeneralPreferenceFragment
 * JD-Core Version:    0.6.2
 */