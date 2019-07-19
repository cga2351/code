package com.viber.voip.market;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.c.a;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.m.c;
import com.viber.common.permission.c;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.permissions.f;
import com.viber.voip.registration.CountryCode;
import com.viber.voip.registration.SelectCountryActivity;
import com.viber.voip.settings.d.z;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.af;
import com.viber.voip.util.ViberActionRunner.bk;
import com.viber.voip.util.cj;
import com.viber.voip.util.cj.a;
import com.viber.voip.util.dj;
import com.viber.voip.util.dl;
import com.viber.voip.util.dz;
import com.viber.voip.widget.ViberWebView;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ViberWebApiActivity extends ViberFragmentActivity
  implements m.c, b.e
{
  private static final Logger a = ViberEnv.getLogger();
  protected static final String[] e = { ".westernunion.com", ".viber.com", ".rakuten.com", ".rakuten.co.jp", ".viber.co.jp", ".wallet" };
  private n b;
  private s c;
  private String d;
  protected ViberWebView f;
  protected ViewGroup g;
  protected com.viber.voip.ui.n h;
  protected boolean i;
  protected String j = "";
  private long k;
  private boolean l;
  private c m;
  private com.viber.common.permission.b n;
  private final cj.a o;

  public ViberWebApiActivity()
  {
    Pair[] arrayOfPair = new Pair[1];
    arrayOfPair[0] = com.viber.voip.permissions.m.a(67);
    this.n = new f(this, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        if ((paramAnonymousObject instanceof String))
          ViberWebApiActivity.a(ViberWebApiActivity.this, (String)paramAnonymousObject);
      }
    };
    this.o = new cj.a()
    {
      private String b;

      public void connectivityChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        if (paramAnonymousInt1 == -1)
        {
          ViberWebApiActivity.this.b(false);
          if ((!ViberWebApiActivity.this.isFinishing()) && (ViberWebApiActivity.this.f != null));
        }
        while (this.b == null)
        {
          return;
          this.b = ViberWebApiActivity.this.f.getUrl();
          if (!com.viber.common.d.a.c())
          {
            ViberWebApiActivity.this.f.clearView();
            return;
          }
          ViberWebApiActivity.this.f.loadUrl("about:blank");
          return;
        }
        ViberWebApiActivity.this.f(this.b);
        this.b = null;
      }
    };
  }

  public static Intent a(Class<?> paramClass)
  {
    Intent localIntent = new Intent(ViberApplication.getApplication(), paramClass);
    localIntent.setFlags(335544320);
    return localIntent;
  }

  public static void a(Intent paramIntent)
  {
    dz.a(ViberApplication.getApplication(), paramIntent);
  }

  private void d(String paramString)
  {
    if (this.m.a(com.viber.voip.permissions.n.l))
      h(paramString);
    while (this.l)
      return;
    this.m.a(this, 67, com.viber.voip.permissions.n.l, paramString);
    this.l = true;
  }

  private void h(String paramString)
  {
    this.d = dl.a(paramString, ViberApplication.getInstance().getLocationManager().b(1));
    q();
  }

  private String i(String paramString)
  {
    long l1 = System.currentTimeMillis() / 3600000L;
    return Uri.parse(paramString).buildUpon().appendQueryParameter("t", String.valueOf(l1)).build().toString();
  }

  private void l()
  {
    n();
    x();
    y();
  }

  @SuppressLint({"SetJavaScriptEnabled"})
  private void x()
  {
    this.f = ((ViberWebView)findViewById(R.id.webview));
    if (k())
      this.f.setLayerType(1, null);
    WebSettings localWebSettings = this.f.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    this.f.setWebViewClient(a(new Runnable()
    {
      public void run()
      {
        ViberWebApiActivity.this.b(false);
      }
    }));
    this.f.setWebChromeClient(o());
    localWebSettings.setDomStorageEnabled(true);
    dz.a(getIntent(), this.f);
  }

  private void y()
  {
    View localView;
    if (d.z.b.d())
    {
      localView = findViewById(R.id.change_market_url_btn);
      if (localView != null);
    }
    else
    {
      return;
    }
    localView.setVisibility(0);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        c.a locala = new c.a(ViberWebApiActivity.this);
        final EditText localEditText = new EditText(ViberWebApiActivity.this);
        localEditText.setHint("Enter url");
        localEditText.setText(ViberWebApiActivity.a(ViberWebApiActivity.this));
        locala.b(localEditText);
        locala.b(R.string.cancel_btn_text, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            paramAnonymous2DialogInterface.cancel();
          }
        });
        locala.a(R.string.ok_btn_text, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            paramAnonymous2DialogInterface.cancel();
            ViberWebApiActivity.b(ViberWebApiActivity.this, localEditText.getText().toString());
            ViberWebApiActivity.this.f.clearHistory();
            ViberWebApiActivity.this.b();
          }
        });
        locala.c();
      }
    });
  }

  private void z()
  {
    this.k = new SecureRandom().nextLong();
  }

  protected WebViewClient a(Runnable paramRunnable)
  {
    return new a(paramRunnable);
  }

  protected String a(String paramString)
  {
    return dl.h(dl.j(dl.b(i(paramString))));
  }

  public void a(int paramInt, String paramString)
  {
  }

  public void a(int paramInt, boolean paramBoolean, String paramString)
  {
    switch (paramInt)
    {
    default:
      return;
    case 1:
      if (paramBoolean)
        af.a(v()).d();
      while (true)
      {
        finish();
        return;
        af.a(paramString, v(), false).d();
      }
    case 0:
      af.d().d();
      return;
    case 2:
    }
    af.e().a(this).a(this);
  }

  public void a(b.e.a parama)
  {
  }

  public void a(Object paramObject, String paramString)
  {
    this.f.addJavascriptInterface(paramObject, paramString);
  }

  public void a(String paramString1, String paramString2, String paramString3)
  {
  }

  protected void b()
  {
    if (this.d == null);
    while ((isFinishing()) || (isDestroyed()))
      return;
    String str = this.d;
    try
    {
      localURL = new URL(this.d);
      if ((localURL != null) && (e(localURL.getHost())))
      {
        str = a(this.d);
        if (this.c == null)
          r();
      }
      f(str);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      while (true)
        URL localURL = null;
    }
  }

  protected void b(boolean paramBoolean)
  {
    int i1 = 8;
    ViewGroup localViewGroup = this.g;
    int i2;
    View localView;
    if (paramBoolean)
    {
      i2 = 0;
      dj.c(localViewGroup, i2);
      localView = this.h.a;
      if (!paramBoolean)
        break label55;
    }
    while (true)
    {
      dj.c(localView, i1);
      if (!paramBoolean)
        t();
      return;
      i2 = i1;
      break;
      label55: i1 = 0;
    }
  }

  protected abstract String c();

  public void c(String paramString)
  {
  }

  protected abstract String d();

  protected int e()
  {
    return R.layout.market_layout;
  }

  protected boolean e(String paramString)
  {
    String[] arrayOfString = e;
    int i1 = arrayOfString.length;
    for (int i2 = 0; ; i2++)
    {
      boolean bool = false;
      if (i2 < i1)
      {
        if (paramString.endsWith(arrayOfString[i2]))
          bool = true;
      }
      else
        return bool;
    }
  }

  public void e_(final String paramString)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        dj.a(ViberWebApiActivity.this, paramString);
      }
    });
  }

  protected Intent f()
  {
    return new Intent("com.viber.voip.action.MORE");
  }

  protected void f(String paramString)
  {
    boolean bool = cj.b(this);
    b(bool);
    if (bool)
    {
      this.j = paramString;
      this.f.loadUrl(paramString);
    }
  }

  public void g()
  {
  }

  public void g(String paramString)
  {
    String str = "javascript:" + paramString;
    if (this.i)
      return;
    this.f.loadUrl(str);
  }

  protected void h()
  {
  }

  public void i()
  {
    startActivityForResult(new Intent(this, SelectCountryActivity.class), 100);
  }

  public boolean isDestroyed()
  {
    return this.i;
  }

  protected b j()
  {
    return b.a;
  }

  protected boolean k()
  {
    return false;
  }

  protected void m()
  {
    android.support.v7.app.a locala = getSupportActionBar();
    if (locala != null)
    {
      locala.a(false);
      locala.b(true);
      locala.a(d());
      setProgressBarIndeterminateVisibility(false);
    }
  }

  protected void n()
  {
    this.g = ((ViewGroup)findViewById(R.id.main_layout));
    this.h = new com.viber.voip.ui.n(getWindow().getDecorView());
    this.h.b();
    this.h.f.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ViberWebApiActivity.this.b();
      }
    });
  }

  protected WebChromeClient o()
  {
    return new WebChromeClient();
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default:
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    case 100:
    }
    if (-1 == paramInt2)
    {
      CountryCode localCountryCode = (CountryCode)paramIntent.getParcelableExtra("extra_selected_code");
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("name", localCountryCode.getName());
        localJSONObject.put("code", localCountryCode.getCode());
        g("(function(){Market.onCountriesSelect('" + localJSONObject.toString() + "');})()");
        return;
      }
      catch (JSONException localJSONException)
      {
        return;
      }
    }
    g("(function(){Market.onCountriesSelect();})()");
  }

  public void onBackPressed()
  {
    if (u())
    {
      this.f.goBack();
      return;
    }
    if (isTaskRoot())
    {
      startActivity(f());
      finish();
      return;
    }
    super.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    boolean bool = true;
    super.onCreate(paramBundle);
    h();
    setContentView(e());
    m();
    l();
    b(bool);
    if ((paramBundle != null) && (paramBundle.getBoolean("permission_requested")));
    while (true)
    {
      this.l = bool;
      this.m = c.a(this);
      this.m.a(this.n);
      p();
      b();
      return;
      bool = false;
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    this.i = true;
    if (this.b != null)
      this.b.a();
    if (this.c != null)
      this.c.a();
    this.f.setWebViewClient(null);
    this.f.destroy();
    this.m.b(this.n);
  }

  public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    if (paramm.a(DialogCode.D3003))
    {
      startActivity(ViberActionRunner.bk.a(this, "Dialog 3003-CC (Refused payment)", null).addFlags(67108864));
      finish();
    }
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return super.onOptionsItemSelected(paramMenuItem);
    case 16908332:
    }
    onBackPressed();
    return true;
  }

  protected void onPause()
  {
    super.onPause();
    if (this.c != null)
      this.c.c();
  }

  protected void onResume()
  {
    super.onResume();
    if (this.c != null)
      this.c.b();
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("permission_requested", this.l);
  }

  protected void onStart()
  {
    cj.a(ViberApplication.getApplication()).a(this.o);
    super.onStart();
    z();
    if (this.c != null)
      this.c.a(w());
  }

  protected void onStop()
  {
    cj.a(ViberApplication.getApplication()).b(this.o);
    super.onStop();
  }

  protected void p()
  {
    String str = c();
    this.d = str;
    if ((str != null) && (t_()))
      d(str);
  }

  protected void q()
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      b();
      return;
    }
    av.a(av.e.a).post(new Runnable()
    {
      public void run()
      {
        ViberWebApiActivity.this.b();
      }
    });
  }

  protected void r()
  {
    this.b = new n();
    this.c = s();
    this.c.a(w());
    this.c.b();
  }

  protected s s()
  {
    return new b(this, this.b, this, getIntent().getBooleanExtra("is_open_market", false), j());
  }

  protected void t()
  {
  }

  protected boolean t_()
  {
    return false;
  }

  protected boolean u()
  {
    return dz.a(this.f);
  }

  protected boolean v()
  {
    return false;
  }

  public long w()
  {
    return this.k;
  }

  protected class a extends com.viber.voip.util.k.b
  {
    public a(Runnable arg2)
    {
      super();
    }

    protected boolean a(String paramString)
    {
      if (d.z.b.d());
      while (true)
      {
        return true;
        try
        {
          URL localURL1 = new URL(ViberWebApiActivity.a(ViberWebApiActivity.this));
          URL localURL2 = new URL(paramString);
          if ((!localURL1.getHost().equals(localURL2.getHost())) || (!localURL1.getAuthority().equals(localURL2.getAuthority())))
          {
            boolean bool = ViberWebApiActivity.this.e(localURL2.getHost());
            if (!bool)
              return false;
          }
        }
        catch (MalformedURLException localMalformedURLException)
        {
        }
      }
      return false;
    }
  }

  public static enum b
  {
    static
    {
      b[] arrayOfb = new b[10];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
      arrayOfb[3] = d;
      arrayOfb[4] = e;
      arrayOfb[5] = f;
      arrayOfb[6] = g;
      arrayOfb[7] = h;
      arrayOfb[8] = i;
      arrayOfb[9] = j;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.ViberWebApiActivity
 * JD-Core Version:    0.6.2
 */