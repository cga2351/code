package com.viber.voip.publicaccount.ui.screen.a;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.publicaccount.d.c;
import com.viber.voip.publicaccount.entity.CrmItem;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.wizard.a.e;
import com.viber.voip.publicaccount.wizard.a.e.a;
import com.viber.voip.util.ViberActionRunner.aq;
import com.viber.voip.util.cj;
import com.viber.voip.util.da;
import java.util.Locale;

public class a extends e
  implements View.OnClickListener
{
  private static final Logger f = ViberEnv.getLogger();
  private c g;

  public static a a(Bundle paramBundle)
  {
    a locala = new a();
    locala.setArguments(b(paramBundle));
    return locala;
  }

  private PublicAccount e(Bundle paramBundle)
  {
    return (PublicAccount)paramBundle.getParcelable("public_account");
  }

  private Intent j()
  {
    if (this.c.getCrm() != null);
    String str1;
    for (String str2 = this.c.getAuthToken(); ; str2 = this.c.getAuthToken() + ", " + str1)
    {
      da.a(getContext(), str2, null);
      Intent localIntent = new Intent("android.intent.action.SEND");
      localIntent.putExtra("android.intent.extra.TEXT", str2);
      localIntent.setType("text/plain");
      return localIntent;
      str1 = getString(R.string.public_account_crm_for_developers_link);
    }
  }

  protected void a()
  {
    CrmItem localCrmItem = this.c.getCrm();
    String str1;
    String str2;
    if (cj.a(true))
    {
      str1 = this.c.getAuthToken();
      if (localCrmItem == null)
        break label175;
      str2 = localCrmItem.getAction();
    }
    for (int i = 3; ; i = 2)
    {
      ViberActionRunner.aq.a(getContext(), this.c, str2);
      da.a(getContext(), str1, getString(R.string.public_account_edit_copy_to_clipboard_toast_message));
      if (this.e == e.a.a)
        ViberApplication.getInstance().getEngine(false).getCdrController().handleReportPACreationStartAndLeaveProcess(this.d, System.currentTimeMillis(), 99, true, this.c.getName(), this.c.getCategoryId(), this.c.getSubCategoryId(), this.c.getTagLines(), this.c.getCountryCode(), this.c.getLocation(), this.c.getWebsite(), this.c.getEmail(), this.c.getGroupUri(), this.c.isAgeRestricted(), i);
      finish();
      return;
      label175: str2 = getString(R.string.public_account_crm_for_developers_link);
    }
  }

  public int b()
  {
    if (e(getArguments()).getCrm() != null)
      return R.string.create_public_account_third_screen_key_screen_builtin_title;
    return R.string.create_public_account_chat_solution_developers_title;
  }

  public Bundle c()
  {
    return g();
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.btn_copy_and_open)
      a();
    while (i != R.id.key)
      return;
    da.a(getContext(), this.c.getAuthToken(), getString(R.string.public_account_edit_copy_to_clipboard_toast_message));
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
    paramMenuInflater.inflate(R.menu.menu_pa_choose_inbox, paramMenu);
    this.g = ((c)MenuItemCompat.getActionProvider(paramMenu.findItem(R.id.menu_share)));
    if (this.g != null)
      this.g.setShareIntent(j());
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.create_public_account_third_key, paramViewGroup, false);
    setHasOptionsMenu(true);
    TextView localTextView1 = (TextView)localView.findViewById(R.id.subtitle);
    TextView localTextView2 = (TextView)localView.findViewById(R.id.key);
    localTextView2.setText(this.c.getAuthToken());
    localTextView2.setOnClickListener(this);
    localView.findViewById(R.id.btn_copy_and_open).setOnClickListener(this);
    String str = Locale.getDefault().getLanguage();
    CrmItem localCrmItem = this.c.getCrm();
    if (localCrmItem == null)
    {
      localTextView1.setText(R.string.create_public_account_use_this_key_to_integrate_api);
      TextView localTextView4 = (TextView)localView.findViewById(R.id.read_more);
      da.a(localTextView4, getString(R.string.create_public_account_read_more, new Object[] { str }), false, false);
      localTextView4.setMovementMethod(LinkMovementMethod.getInstance());
      localTextView4.setVisibility(0);
      return localView;
    }
    int i = R.string.create_public_account_use_this_Key_to_connect;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = localCrmItem.getName();
    localTextView1.setText(getString(i, arrayOfObject1));
    TextView localTextView3 = (TextView)localView.findViewById(R.id.link_read_about);
    int j = R.string.create_public_account_read_about;
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = localCrmItem.getName();
    arrayOfObject2[1] = str;
    da.a(localTextView3, getString(j, arrayOfObject2), false, false);
    localTextView3.setMovementMethod(LinkMovementMethod.getInstance());
    localTextView3.setVisibility(0);
    return localView;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.screen.a.a
 * JD-Core Version:    0.6.2
 */