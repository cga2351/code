package com.viber.voip.rakuten;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebHistoryItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ScrollView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.ui.n;
import com.viber.voip.util.dz;
import com.viber.voip.util.http.OkHttpClientFactory;
import com.viber.voip.util.k.b;
import com.viber.voip.widget.ViberWebView;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class RakutenAccountWebViewActivity extends ViberFragmentActivity
{
  private static final Logger a = ViberEnv.getLogger();
  private ViberWebView b;
  private a c;

  private void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 31	com/viber/voip/rakuten/RakutenAccountWebViewActivity:getIntent	()Landroid/content/Intent;
    //   4: ldc 33
    //   6: invokevirtual 39	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   9: astore_1
    //   10: aload_0
    //   11: new 41	com/viber/voip/rakuten/RakutenAccountWebViewActivity$1
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 44	com/viber/voip/rakuten/RakutenAccountWebViewActivity$1:<init>	(Lcom/viber/voip/rakuten/RakutenAccountWebViewActivity;)V
    //   19: putfield 26	com/viber/voip/rakuten/RakutenAccountWebViewActivity:c	Lcom/viber/voip/rakuten/RakutenAccountWebViewActivity$a;
    //   22: aload_0
    //   23: getfield 26	com/viber/voip/rakuten/RakutenAccountWebViewActivity:c	Lcom/viber/voip/rakuten/RakutenAccountWebViewActivity$a;
    //   26: iconst_1
    //   27: anewarray 46	java/lang/String
    //   30: dup
    //   31: iconst_0
    //   32: aload_1
    //   33: aastore
    //   34: invokevirtual 52	com/viber/voip/rakuten/RakutenAccountWebViewActivity$a:execute	([Ljava/lang/Object;)Landroid/os/AsyncTask;
    //   37: pop
    //   38: return
  }

  private void b()
  {
    CookieManager.getInstance().setAcceptCookie(true);
  }

  private void c()
  {
    CookieSyncManager.getInstance().sync();
  }

  @SuppressLint({"SetJavaScriptEnabled"})
  private void d()
  {
    this.b = ((ViberWebView)findViewById(R.id.webview));
    WebSettings localWebSettings = this.b.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setDomStorageEnabled(true);
    this.b.setWebChromeClient(new WebChromeClient()
    {
      public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        if (paramAnonymousInt < 100);
      }
    });
    this.b.setWebViewClient(new b());
    dz.a(getIntent(), this.b);
  }

  private void e()
  {
    View localView1 = getWindow().getDecorView();
    View localView2 = localView1.findViewById(R.id.empty_root);
    if (localView2 != null);
    for (ViewParent localViewParent = localView2.getParent(); ; localViewParent = null)
    {
      if ((localViewParent instanceof ScrollView))
      {
        localView2.setId(-1);
        ((View)localViewParent).setId(R.id.empty_root);
      }
      final n localn = new n(localView1);
      localn.b();
      localn.a.setVisibility(0);
      localn.f.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          localn.a.setVisibility(8);
          RakutenAccountWebViewActivity.f(RakutenAccountWebViewActivity.this);
        }
      });
      return;
    }
  }

  private boolean f()
  {
    if (this.b.canGoBack())
    {
      g();
      return true;
    }
    return false;
  }

  private void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 78	com/viber/voip/rakuten/RakutenAccountWebViewActivity:b	Lcom/viber/voip/widget/ViberWebView;
    //   4: invokevirtual 193	com/viber/voip/widget/ViberWebView:copyBackForwardList	()Landroid/webkit/WebBackForwardList;
    //   7: astore_1
    //   8: aload_1
    //   9: invokevirtual 199	android/webkit/WebBackForwardList:getCurrentIndex	()I
    //   12: istore_2
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: aload_1
    //   17: invokevirtual 202	android/webkit/WebBackForwardList:getSize	()I
    //   20: if_icmpge +28 -> 48
    //   23: aload_1
    //   24: iload_3
    //   25: invokevirtual 206	android/webkit/WebBackForwardList:getItemAtIndex	(I)Landroid/webkit/WebHistoryItem;
    //   28: astore 6
    //   30: aload 6
    //   32: invokevirtual 212	android/webkit/WebHistoryItem:getUrl	()Ljava/lang/String;
    //   35: pop
    //   36: aload 6
    //   38: invokevirtual 215	android/webkit/WebHistoryItem:getOriginalUrl	()Ljava/lang/String;
    //   41: pop
    //   42: iinc 3 1
    //   45: goto -30 -> 15
    //   48: aload_1
    //   49: iload_2
    //   50: iconst_1
    //   51: isub
    //   52: invokevirtual 206	android/webkit/WebBackForwardList:getItemAtIndex	(I)Landroid/webkit/WebHistoryItem;
    //   55: invokevirtual 212	android/webkit/WebHistoryItem:getUrl	()Ljava/lang/String;
    //   58: astore 4
    //   60: aload_0
    //   61: getfield 26	com/viber/voip/rakuten/RakutenAccountWebViewActivity:c	Lcom/viber/voip/rakuten/RakutenAccountWebViewActivity$a;
    //   64: ifnonnull +32 -> 96
    //   67: aload_0
    //   68: new 217	com/viber/voip/rakuten/RakutenAccountWebViewActivity$4
    //   71: dup
    //   72: aload_0
    //   73: invokespecial 218	com/viber/voip/rakuten/RakutenAccountWebViewActivity$4:<init>	(Lcom/viber/voip/rakuten/RakutenAccountWebViewActivity;)V
    //   76: putfield 26	com/viber/voip/rakuten/RakutenAccountWebViewActivity:c	Lcom/viber/voip/rakuten/RakutenAccountWebViewActivity$a;
    //   79: aload_0
    //   80: getfield 26	com/viber/voip/rakuten/RakutenAccountWebViewActivity:c	Lcom/viber/voip/rakuten/RakutenAccountWebViewActivity$a;
    //   83: iconst_1
    //   84: anewarray 46	java/lang/String
    //   87: dup
    //   88: iconst_0
    //   89: aload 4
    //   91: aastore
    //   92: invokevirtual 52	com/viber/voip/rakuten/RakutenAccountWebViewActivity$a:execute	([Ljava/lang/Object;)Landroid/os/AsyncTask;
    //   95: pop
    //   96: return
  }

  public void finish()
  {
    this.b.loadUrl("");
    this.b.clearHistory();
    super.finish();
  }

  public void onBackPressed()
  {
    if (f())
      return;
    if (isTaskRoot())
    {
      startActivity(new Intent("com.viber.voip.action.MORE"));
      finish();
      return;
    }
    super.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.generic_web_view);
    setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
    getSupportActionBar().a(false);
    getSupportActionBar().b(true);
    getSupportActionBar().b(R.string.rakuten_account);
    d();
    a();
  }

  protected void onDestroy()
  {
    this.c = null;
    if (this.b != null)
    {
      this.b.loadUrl("");
      this.b.destroy();
      c();
    }
    super.onDestroy();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return false;
    case 16908332:
    }
    onBackPressed();
    return true;
  }

  class a extends AsyncTask<String, Void, RakutenAccountWebViewActivity.b>
  {
    a()
    {
    }

    protected RakutenAccountWebViewActivity.b a(String[] paramArrayOfString)
    {
      String str1 = paramArrayOfString[0];
      try
      {
        OkHttpClient.Builder localBuilder = ViberEnv.getOkHttpClientFactory().createBuilder();
        Request.Builder localBuilder1 = new Request.Builder().url(str1);
        Response localResponse = localBuilder.build().newCall(localBuilder1.build()).execute();
        if (localResponse.code() == 403)
          return new RakutenAccountWebViewActivity.b(str1, RakutenAccountWebViewActivity.b.a.b, null);
        String str2 = localResponse.body().string();
        RakutenAccountWebViewActivity.b localb = new RakutenAccountWebViewActivity.b(str1, RakutenAccountWebViewActivity.b.a.a, str2);
        return localb;
      }
      catch (IOException localIOException)
      {
      }
      return new RakutenAccountWebViewActivity.b(str1, RakutenAccountWebViewActivity.b.a.c, null);
    }
  }

  private static class b
  {
    String a;
    a b;
    String c;

    b(String paramString1, a parama, String paramString2)
    {
      this.a = paramString1;
      this.b = parama;
      this.c = paramString2;
    }

    static enum a
    {
      static
      {
        a[] arrayOfa = new a[3];
        arrayOfa[0] = a;
        arrayOfa[1] = b;
        arrayOfa[2] = c;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.rakuten.RakutenAccountWebViewActivity
 * JD-Core Version:    0.6.2
 */