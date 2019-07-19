package com.viber.voip.wallet.wu;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.c;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.menu;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.market.ViberWebApiActivity;
import com.viber.voip.market.s;
import com.viber.voip.ui.c.c;
import com.viber.voip.ui.c.d;
import com.viber.voip.ui.c.h;
import com.viber.voip.ui.dialogs.ai;
import com.viber.voip.ui.j.av;
import com.viber.voip.util.ViberActionRunner.br.a;
import com.viber.voip.util.dj;
import com.viber.voip.widget.ViberWebView;

public class WesternUnionWebActivity extends ViberWebApiActivity
  implements m.c, b.a
{
  private static final Logger a = ViberEnv.getLogger();
  private String b;

  public void a()
  {
    finish();
  }

  public void a_(String paramString1, String paramString2, String paramString3)
  {
    dj.a(this, paramString1);
    dj.b(this, paramString2);
    this.b = paramString3;
  }

  protected String c()
  {
    String str1 = getIntent().getStringExtra("origin");
    String str2 = getIntent().getStringExtra("token");
    ap.a locala = ap.c();
    Uri.Builder localBuilder = Uri.parse(locala.av).buildUpon().appendQueryParameter("token", str2).appendQueryParameter("origin", str1);
    if (TextUtils.isEmpty(str1))
      localBuilder.appendPath(locala.az);
    while (true)
    {
      return localBuilder.build().toString();
      if (ViberActionRunner.br.a.c.a().equals(str1))
        localBuilder.appendPath(locala.ax);
      else if (ViberActionRunner.br.a.b.a().equals(str1))
        localBuilder.appendPath(locala.ay);
      else
        localBuilder.appendPath(locala.aw);
    }
  }

  protected c createActivityDecorator()
  {
    return new d(new h(), this, (av)ViberApplication.getInstance().getThemeController().get());
  }

  protected String d()
  {
    return "";
  }

  public void f_(String paramString)
  {
    startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
  }

  public void onBackPressed()
  {
    if (!TextUtils.isEmpty(this.b))
    {
      g("(function(){window.location.href = '#" + this.b + "'})()");
      this.b = null;
      return;
    }
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (com.viber.common.d.a.d())
      this.f.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(R.menu.menu_western_union, paramMenu);
    return true;
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    if (-1 == paramInt)
      finish();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    if (i == 16908332)
    {
      dj.d(this);
      return super.onOptionsItemSelected(paramMenuItem);
    }
    if (i == R.id.menu_close)
    {
      ai.a().a(this).a(this);
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  protected s s()
  {
    return new b(this, this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.wallet.wu.WesternUnionWebActivity
 * JD-Core Version:    0.6.2
 */