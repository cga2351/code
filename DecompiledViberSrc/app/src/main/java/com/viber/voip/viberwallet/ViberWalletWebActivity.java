package com.viber.voip.viberwallet;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.viber.common.b.b;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.c;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.market.MarketApi.c;
import com.viber.voip.market.ViberWebApiActivity;
import com.viber.voip.market.ViberWebApiActivity.a;
import com.viber.voip.market.b.p;
import com.viber.voip.market.s;
import com.viber.voip.messages.ui.media.ComposeDataContainer;
import com.viber.voip.settings.d.bm.a;
import com.viber.voip.ui.c.c;
import com.viber.voip.ui.c.j;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ai;
import com.viber.voip.ui.j.av;
import com.viber.voip.util.ce;
import com.viber.voip.util.cg;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import com.viber.voip.util.dl;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.zhanghai.android.materialprogressbar.MaterialProgressBar;
import org.json.JSONException;
import org.json.JSONObject;

public class ViberWalletWebActivity extends ViberWebApiActivity
  implements m.c, a.c
{
  private static final Logger a = ViberEnv.getLogger();
  private MaterialProgressBar b;
  private String c = a.a(a.a);
  private String d;
  private String k;
  private String l;
  private boolean m;

  private static Intent a(Intent paramIntent, boolean paramBoolean)
  {
    if (!d.bm.a.c.d())
    {
      Intent localIntent = new Intent(ViberApplication.getApplication(), ViberWalletWelcomeActivity.class);
      localIntent.setFlags(335544320);
      localIntent.putExtra("extra_forward", paramIntent);
      if (paramBoolean)
        localIntent = c.a(localIntent);
      return localIntent;
    }
    return paramIntent;
  }

  private String a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    String str1 = ap.c().aA;
    String str2;
    Uri.Builder localBuilder;
    if (this.m)
    {
      str2 = "user";
      localBuilder = Uri.parse(str1).buildUpon();
      localBuilder.appendPath(str2).appendPath(paramString2);
      if (!b.b.a().equals(paramString1))
        break label110;
      String str5 = getIntent().getStringExtra("extra_to_phone");
      localBuilder.appendPath("send-money").appendPath(str5);
    }
    while (true)
    {
      localBuilder.appendQueryParameter("ts", String.valueOf(paramLong)).appendQueryParameter("token", paramString3);
      return localBuilder.toString();
      str2 = "phone";
      break;
      label110: if (b.c.a().equals(paramString1))
      {
        String str4 = getIntent().getStringExtra("extra_request_id");
        localBuilder.appendPath("request-money").appendEncodedPath(str4);
      }
      else if (b.d.a().equals(paramString1))
      {
        String str3 = getIntent().getStringExtra("extra_transaction_id");
        localBuilder.appendPath("transaction").appendEncodedPath(str3).appendPath("details");
      }
      else if (b.e.a().equals(paramString1))
      {
        localBuilder.appendPath("payment");
        a(localBuilder);
      }
      else if (b.f.a().equals(paramString1))
      {
        localBuilder.appendPath("account-management");
      }
      else if (b.g.a().equals(paramString1))
      {
        localBuilder.appendPath("logout");
      }
      else if (b.h.a().equals(paramString1))
      {
        localBuilder.appendPath("billing-plans");
        b(localBuilder);
      }
    }
  }

  private void a(Uri.Builder paramBuilder)
  {
    String str1 = getIntent().getStringExtra("extra_payload");
    String str2 = getIntent().getStringExtra("extra_signature");
    String str3 = getIntent().getStringExtra("extra_invoice_id");
    String str4 = getIntent().getStringExtra("extra_expiry");
    if (!da.a(str1))
      paramBuilder.appendQueryParameter("payload", str1);
    if (!da.a(str2))
      paramBuilder.appendQueryParameter("signature", str2);
    if (!da.a(str3))
      paramBuilder.appendQueryParameter("invoice_id", str3);
    if (!da.a(str4))
      paramBuilder.appendQueryParameter("expiry", str4);
  }

  public static void a(String paramString, int paramInt)
  {
    Intent localIntent = a(ViberWalletWebActivity.class);
    localIntent.putExtra("extra_origin", b.c.a());
    localIntent.putExtra("extra_entry_point", paramInt);
    localIntent.putExtra("extra_request_id", paramString);
    a(b(localIntent));
  }

  public static void a(String paramString, int paramInt, boolean paramBoolean)
  {
    Intent localIntent = a(ViberWalletWebActivity.class);
    localIntent.putExtra("extra_origin", b.b.a());
    localIntent.putExtra("extra_entry_point", paramInt);
    localIntent.putExtra("extra_to_phone", paramString);
    if (paramBoolean)
      localIntent = c.a(localIntent);
    a(a(localIntent, paramBoolean));
  }

  public static void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Intent localIntent = a(ViberWalletWebActivity.class);
    localIntent.putExtra("extra_entry_point", paramInt);
    localIntent.putExtra("extra_origin", b.h.a());
    localIntent.putExtra("extra_id", paramString1);
    localIntent.putExtra("extra_provider_id", paramString2);
    if (!da.a(paramString3))
      localIntent.putExtra("extra_subscription_id", paramString3);
    a(b(localIntent));
  }

  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    Intent localIntent = a(ViberWalletWebActivity.class);
    localIntent.putExtra("extra_entry_point", paramInt);
    localIntent.putExtra("extra_origin", b.e.a());
    localIntent.putExtra("extra_payload", paramString1);
    localIntent.putExtra("extra_signature", paramString2);
    localIntent.putExtra("extra_invoice_id", paramString3);
    localIntent.putExtra("extra_expiry", paramString4);
    a(b(localIntent));
  }

  private void a(boolean paramBoolean, final b paramb)
  {
    new com.viber.voip.market.b.d().a(new MarketApi.c()
    {
      public void a(String paramAnonymousString)
      {
        if (!ViberWalletWebActivity.this.isDestroyed())
          ViberWalletWebActivity.a(ViberWalletWebActivity.this, false);
      }

      public void a(String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong)
      {
        if (!ViberWalletWebActivity.this.isDestroyed())
          if (paramb != null)
            break label66;
        label66: for (String str = ViberWalletWebActivity.this.getIntent().getStringExtra("extra_origin"); ; str = paramb.a())
        {
          ViberWalletWebActivity.a(ViberWalletWebActivity.this, ViberWalletWebActivity.a(ViberWalletWebActivity.this, str, paramAnonymousString1, paramAnonymousString2, paramAnonymousLong));
          ViberWalletWebActivity.a(ViberWalletWebActivity.this);
          ViberWalletWebActivity.b(ViberWalletWebActivity.this);
          return;
        }
      }
    }
    , paramBoolean);
  }

  private void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (paramBoolean);
      for (int i = 1; ; i = 0)
      {
        localJSONObject.put("status", i);
        if (paramBoolean)
        {
          localJSONObject.put("phone_number", cg.b(paramString1));
          localJSONObject.put("contact_name", paramString2);
        }
        g("(function(){Wallet.onSelectContact('" + localJSONObject.toString() + "');})()");
        return;
      }
    }
    catch (JSONException localJSONException)
    {
    }
  }

  private static Intent b(Intent paramIntent)
  {
    return a(paramIntent, false);
  }

  public static void b(int paramInt)
  {
    Intent localIntent = a(ViberWalletWebActivity.class);
    localIntent.putExtra("extra_origin", b.a.a());
    localIntent.putExtra("extra_entry_point", paramInt);
    a(b(localIntent));
  }

  private void b(Uri.Builder paramBuilder)
  {
    String str1 = getIntent().getStringExtra("extra_id");
    String str2 = getIntent().getStringExtra("extra_provider_id");
    boolean bool = getIntent().getExtras().containsKey("extra_subscription_id");
    String str3 = null;
    if (bool)
      str3 = getIntent().getStringExtra("extra_subscription_id");
    if (!da.a(str1))
      paramBuilder.appendQueryParameter("id", str1);
    if (!da.a(str2))
      paramBuilder.appendQueryParameter("provider_id", str2);
    if (!da.a(str3))
      paramBuilder.appendQueryParameter("subscription_id", str3);
  }

  public static void b(String paramString, int paramInt)
  {
    Intent localIntent = a(ViberWalletWebActivity.class);
    localIntent.putExtra("extra_origin", b.d.a());
    localIntent.putExtra("extra_entry_point", paramInt);
    localIntent.putExtra("extra_transaction_id", paramString);
    a(b(localIntent));
  }

  private boolean h(String paramString)
  {
    return (!da.a(paramString)) && (!ce.h.matcher(paramString).matches()) && (!URLUtil.isValidUrl(paramString)) && (!"about:blank".equals(paramString));
  }

  private void l()
  {
    new com.viber.voip.market.b.d().a(new MarketApi.c()
    {
      public void a(String paramAnonymousString)
      {
      }

      public void a(String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong)
      {
        String str1 = ViberWalletWebActivity.a(ViberWalletWebActivity.this, ViberWalletWebActivity.b.g.a(), paramAnonymousString1, paramAnonymousString2, paramAnonymousLong);
        String str2 = ViberWalletWebActivity.this.a(str1);
        new p().a(str2);
      }
    });
  }

  private void x()
  {
    final int i = getIntent().getIntExtra("extra_entry_point", 0);
    new com.viber.voip.market.b.d().a(new MarketApi.c()
    {
      public void a(String paramAnonymousString)
      {
      }

      public void a(String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong)
      {
        ViberApplication.getInstance().getEngine(false).getCdrController().handleReportWalletEntryFrom(paramAnonymousString2, i, "w1");
      }
    }
    , true);
  }

  protected WebViewClient a(Runnable paramRunnable)
  {
    // Byte code:
    //   0: new 384	com/viber/voip/viberwallet/ViberWalletWebActivity$5
    //   3: dup
    //   4: aload_0
    //   5: aload_1
    //   6: invokespecial 387	com/viber/voip/viberwallet/ViberWalletWebActivity$5:<init>	(Lcom/viber/voip/viberwallet/ViberWalletWebActivity;Ljava/lang/Runnable;)V
    //   9: areturn
  }

  protected String a(String paramString)
  {
    return dl.h(dl.j(dl.b(paramString)));
  }

  public void a()
  {
    finish();
  }

  public void a(int paramInt)
  {
    MaterialProgressBar localMaterialProgressBar = this.b;
    if (paramInt == 0);
    for (int i = 0; ; i = 4)
    {
      localMaterialProgressBar.setVisibility(i);
      return;
    }
  }

  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (paramString1 != null)
      dj.a(this, paramString1);
    if (paramString2 != null)
      dj.b(this, paramString2);
    if (!da.a(paramString3))
      this.d = paramString3;
    if (!da.a(paramString4))
      this.k = paramString4;
    if (!da.a(paramString5))
      this.c = paramString5;
  }

  public void a(Map<a.a, Boolean> paramMap)
  {
    Intent localIntent = new Intent("com.viber.voip.action.ACTION_CONTACT_LIST_SELECTABLE2_1TO1");
    localIntent.putExtra("title", getString(R.string.select_contact));
    localIntent.putExtra("return_result", true);
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry.getKey() == a.a.a)
        localIntent.putExtra("viber_user_filter", (Serializable)localEntry.getValue());
    }
    localIntent.putExtra("wallet_filter", true);
    localIntent.putExtra("extra_hide_root_number", true);
    localIntent.putExtra("extra_allow_select_self_number", true);
    startActivityForResult(localIntent, 100);
  }

  public void af_()
  {
    if (!isDestroyed())
    {
      this.l = null;
      a(true, b.a);
    }
  }

  public void b(String paramString)
  {
    startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
  }

  protected String c()
  {
    if (this.l == null)
      a(false, null);
    return this.l;
  }

  protected c createActivityDecorator()
  {
    return new com.viber.voip.ui.c.d(new j(), this, (av)ViberApplication.getInstance().getThemeController().get());
  }

  protected String d()
  {
    return "";
  }

  boolean d(String paramString)
  {
    return super.e(paramString);
  }

  protected int e()
  {
    return R.layout.wallet_layout;
  }

  protected boolean e(String paramString)
  {
    return true;
  }

  protected void m()
  {
    setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
    super.m();
  }

  protected void n()
  {
    super.n();
    this.b = ((MaterialProgressBar)findViewById(R.id.progress_bar));
    this.b.setVisibility(0);
  }

  protected WebChromeClient o()
  {
    return new WebChromeClient()
    {
      public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
        ViberWalletWebActivity.c(ViberWalletWebActivity.this).setProgress(paramAnonymousInt);
      }

      public void onReceivedTitle(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        super.onReceivedTitle(paramAnonymousWebView, paramAnonymousString);
        if (ViberWalletWebActivity.b(ViberWalletWebActivity.this, paramAnonymousString))
          dj.a(ViberWalletWebActivity.this, paramAnonymousString);
      }
    };
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
    boolean bool;
    String str2;
    String str1;
    if (-1 == paramInt2)
    {
      bool = true;
      if (!bool)
        break label84;
      ComposeDataContainer localComposeDataContainer = (ComposeDataContainer)paramIntent.getParcelableExtra("compose_data_extra");
      str2 = localComposeDataContainer.selectedNumber;
      str1 = localComposeDataContainer.contactName;
    }
    while (true)
    {
      a(bool, str2, str1);
      return;
      bool = false;
      break;
      label84: str1 = null;
      str2 = null;
    }
  }

  public void onBackPressed()
  {
    Object localObject = a.a;
    try
    {
      a locala = a.valueOf(this.c.toUpperCase());
      localObject = locala;
      label17: switch (6.a[localObject.ordinal()])
      {
      default:
        super.onBackPressed();
        return;
      case 1:
        finish();
        return;
      case 2:
        if (this.d == null)
          g("(function(){window.location.hash = '#';})()");
        while (true)
        {
          this.c = a.a(a.a);
          return;
          g("(function(){window.location.hash = '#" + this.d + "';})()");
        }
      case 3:
      }
      if (this.k == null)
        g("(function(){Wallet.onBackButtonClick(null);})()");
      while (true)
      {
        this.c = a.a(a.a);
        return;
        g("(function(){Wallet.onBackButtonClick('" + this.k + "');})()");
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label17;
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.m = false;
    x();
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(R.menu.menu_viber_wallet, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    if ((paramm.a(DialogCode.D2001)) && (-1 == paramInt))
    {
      l();
      finish();
    }
    if ((paramm.a(DialogCode.D2002)) && (-1 == paramInt))
    {
      this.l = null;
      a(false, b.a);
    }
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    if (i == R.id.menu_wallet_manage_account)
    {
      this.l = null;
      a(false, b.f);
    }
    while (true)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      if (i == R.id.menu_wallet_exit)
        ai.b().a(this).a(this);
      else if (i == R.id.menu_wallet_home)
        ai.c().a(this).a(this);
    }
  }

  protected s s()
  {
    return new a(this);
  }

  protected void t()
  {
    dj.a(this, getString(R.string.viber_wallet_title));
  }

  private static enum a
  {
    private String e;

    static
    {
      a[] arrayOfa = new a[4];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
    }

    private a(String paramString)
    {
      this.e = paramString;
    }
  }

  private static enum b
  {
    private String i;

    static
    {
      b[] arrayOfb = new b[8];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
      arrayOfb[3] = d;
      arrayOfb[4] = e;
      arrayOfb[5] = f;
      arrayOfb[6] = g;
      arrayOfb[7] = h;
    }

    private b(String paramString)
    {
      this.i = paramString;
    }

    public String a()
    {
      return this.i;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberwallet.ViberWalletWebActivity
 * JD-Core Version:    0.6.2
 */