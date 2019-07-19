package com.viber.voip.market;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.ShareActionProvider.OnShareTargetSelectedListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.appnexus.opensdk.AdView;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.R.id;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.j.c;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.billing.ProductId;
import com.viber.voip.billing.l;
import com.viber.voip.p;
import com.viber.voip.settings.d.z;
import com.viber.voip.stickers.c.g.a;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.i;
import com.viber.voip.util.ViberActionRunner.u;
import com.viber.voip.util.ae;
import com.viber.voip.util.ax;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import com.viber.voip.util.dl;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class StickerMarketActivity extends ViberWebApiActivity
  implements View.OnClickListener
{
  private static final Logger a = ViberEnv.getLogger();
  private d A = new d();
  private String b;
  private boolean c;
  private b d;
  private com.viber.voip.stickers.e.b k;
  private Handler l = av.a(av.e.a);
  private MenuItem m;
  private c n = c.a;
  private ShareActionProvider o;
  private Runnable p = new a(this, null);
  private long q;
  private int r;
  private g s;
  private ICdrController t;
  private o u;
  private View v;
  private View w;
  private View x;
  private ViewGroup y;
  private TextView z;

  private Intent A()
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    int i = R.string.sticker_package_sharing_text;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.n.d();
    localIntent.putExtra("android.intent.extra.TEXT", getString(i, arrayOfObject));
    localIntent.setType("text/plain");
    return localIntent;
  }

  public static Intent a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    Intent localIntent = a(b.d, paramInt2, paramString1, paramString2);
    localIntent.putExtra("stickers_collection_id", paramInt1);
    return localIntent;
  }

  public static Intent a(int paramInt1, boolean paramBoolean, int paramInt2, String paramString1, String paramString2)
  {
    return a(paramInt1, paramBoolean, false, paramInt2, null, paramString1, paramString2);
  }

  public static Intent a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = a(b.b, paramInt2, paramString2, paramString3);
    localIntent.putExtra("sticker_package_id", paramInt1);
    localIntent.putExtra("one_click_download", paramBoolean1);
    localIntent.putExtra("open_promotion_popup", paramBoolean2);
    localIntent.putExtra("promotion_code", paramString1);
    return localIntent;
  }

  private static Intent a(b paramb, int paramInt, String paramString1, String paramString2)
  {
    Intent localIntent = a(StickerMarketActivity.class);
    localIntent.putExtra("is_open_market", i.a().z());
    localIntent.putExtra("method", paramb.ordinal());
    localIntent.putExtra("source", paramInt);
    localIntent.putExtra("mixpanel_entry_point", paramString1);
    localIntent.putExtra("mixpanel_target_page", paramString2);
    return localIntent;
  }

  public static Intent a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    Intent localIntent = a(b.e, paramInt, paramString2, paramString3);
    localIntent.putExtra("stickers_tab_name", paramString1);
    return localIntent;
  }

  private String a(String paramString, int paramInt)
  {
    ProductId localProductId = ProductId.fromStickerPackageId(paramInt);
    return Uri.parse(paramString).buildUpon().appendPath(localProductId.getStringId()).build().toString();
  }

  public static void a(int paramInt, String paramString1, String paramString2)
  {
    a(a(b.a, paramInt, paramString1, paramString2));
  }

  public static void b(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    a(a(paramInt1, false, paramInt2, paramString1, paramString2));
  }

  private void b(int paramInt, String paramString)
  {
    this.t.handleReportShareFromStickerProductPage(paramString, paramInt, this.n.e().getStringId());
  }

  private static String d(String paramString)
  {
    return dl.g(dl.h(dl.j(dl.b(paramString))));
  }

  private String h(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(paramString);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = p.d();
    return String.format("?utm_source=Android&utm_medium=Android&utm_term=%s&utm_content=getstickerbutton", arrayOfObject);
  }

  private void l()
  {
    this.k = new com.viber.voip.stickers.e.b()
    {
      private void a(final String paramAnonymousString)
      {
        StickerMarketActivity.h(StickerMarketActivity.this).post(new Runnable()
        {
          public void run()
          {
            android.support.v7.app.a locala = StickerMarketActivity.this.getSupportActionBar();
            if ((!StickerMarketActivity.this.isDestroyed()) && (locala != null))
              locala.b(paramAnonymousString);
          }
        });
      }

      public void onStickerDeployed(Sticker paramAnonymousSticker)
      {
      }

      public void onStickerPackageDeployed(com.viber.voip.stickers.entity.a paramAnonymousa)
      {
        StickerMarketActivity.h(StickerMarketActivity.this).removeCallbacks(StickerMarketActivity.g(StickerMarketActivity.this));
        if (paramAnonymousa.e() == 400)
          return;
        StickerMarketActivity localStickerMarketActivity = StickerMarketActivity.this;
        int i = R.string.market_title_notification_installed;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = paramAnonymousa.f();
        a(localStickerMarketActivity.getString(i, arrayOfObject));
        StickerMarketActivity.h(StickerMarketActivity.this).postDelayed(StickerMarketActivity.g(StickerMarketActivity.this), 5000L);
      }

      public void onStickerPackageDownloadError(boolean paramAnonymousBoolean, com.viber.voip.stickers.entity.a paramAnonymousa)
      {
        StickerMarketActivity.h(StickerMarketActivity.this).removeCallbacks(StickerMarketActivity.g(StickerMarketActivity.this));
        if (paramAnonymousa.e() == 400)
          return;
        StickerMarketActivity localStickerMarketActivity = StickerMarketActivity.this;
        int i = R.string.market_title_notification_failed;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = paramAnonymousa.f();
        a(localStickerMarketActivity.getString(i, arrayOfObject));
        StickerMarketActivity.h(StickerMarketActivity.this).postDelayed(StickerMarketActivity.g(StickerMarketActivity.this), 5000L);
      }

      public void onStickerPackageDownloadScheduled(com.viber.voip.stickers.entity.a paramAnonymousa)
      {
      }

      public void onStickerPackageDownloadStarted(com.viber.voip.stickers.entity.a paramAnonymousa)
      {
        if (paramAnonymousa.e() == 400)
          return;
        StickerMarketActivity.h(StickerMarketActivity.this).removeCallbacks(StickerMarketActivity.g(StickerMarketActivity.this));
        StickerMarketActivity localStickerMarketActivity = StickerMarketActivity.this;
        int i = R.string.market_title_notification_downloading;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = paramAnonymousa.f();
        arrayOfObject[1] = "0 %";
        a(localStickerMarketActivity.getString(i, arrayOfObject));
      }

      public void onStickerPackageDownloading(com.viber.voip.stickers.entity.a paramAnonymousa, int paramAnonymousInt)
      {
        StickerMarketActivity.h(StickerMarketActivity.this).removeCallbacks(StickerMarketActivity.g(StickerMarketActivity.this));
        if (paramAnonymousa.e() == 400)
          return;
        StickerMarketActivity localStickerMarketActivity2;
        int j;
        Object[] arrayOfObject2;
        if (paramAnonymousInt < 100)
        {
          localStickerMarketActivity2 = StickerMarketActivity.this;
          j = R.string.market_title_notification_downloading;
          arrayOfObject2 = new Object[2];
          arrayOfObject2[0] = paramAnonymousa.f();
          arrayOfObject2[1] = (paramAnonymousInt + "%");
        }
        StickerMarketActivity localStickerMarketActivity1;
        int i;
        Object[] arrayOfObject1;
        for (String str = localStickerMarketActivity2.getString(j, arrayOfObject2); ; str = localStickerMarketActivity1.getString(i, arrayOfObject1))
        {
          a(str);
          return;
          localStickerMarketActivity1 = StickerMarketActivity.this;
          i = R.string.market_title_notification_installing;
          arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = paramAnonymousa.f();
        }
      }
    };
    i locali = i.a();
    locali.a(this.k);
    g.a locala = locali.o();
    if ((locala != null) && (locala.a.e() != 400))
      this.k.onStickerPackageDownloading(locala.a, locala.b);
  }

  private void x()
  {
    if (d.z.a.d())
    {
      super.b();
      return;
    }
    this.c = true;
    l.b(new k(this), false);
  }

  private void y()
  {
    av.a(av.e.f).post(new Runnable()
    {
      public void run()
      {
        String str = ax.a();
        Intent localIntent = StickerMarketActivity.this.getIntent();
        StickerMarketActivity.a(StickerMarketActivity.this, StickerMarketActivity.b.values()[localIntent.getIntExtra("method", 0)]);
        StickerMarketActivity.a(StickerMarketActivity.this, ap.c().aq);
        StickerMarketActivity.a(StickerMarketActivity.this, dl.d(StickerMarketActivity.i(StickerMarketActivity.this), str));
        StickerMarketActivity.this.p();
        StickerMarketActivity.this.q();
      }
    });
  }

  private void z()
  {
    int i = (int)(System.currentTimeMillis() - this.q) / 1000;
    this.t.handleReportStickerMarketEntry(w(), this.r, i, this.q);
  }

  protected WebViewClient a(Runnable paramRunnable)
  {
    // Byte code:
    //   0: new 382	com/viber/voip/market/StickerMarketActivity$4
    //   3: dup
    //   4: aload_0
    //   5: aload_1
    //   6: invokespecial 385	com/viber/voip/market/StickerMarketActivity$4:<init>	(Lcom/viber/voip/market/StickerMarketActivity;Ljava/lang/Runnable;)V
    //   9: areturn
  }

  protected String a(String paramString)
  {
    Intent localIntent = getIntent();
    int i = localIntent.getIntExtra("sticker_package_id", 0);
    boolean bool1 = localIntent.getBooleanExtra("one_click_download", false);
    boolean bool2 = localIntent.getBooleanExtra("open_promotion_popup", false);
    String str;
    switch (5.a[this.d.ordinal()])
    {
    default:
      str = dl.g(super.a(paramString));
      if (bool1)
        str = dl.k(str);
      break;
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (!bool2)
    {
      return str;
      str = d(a(paramString, i));
      break;
      str = d(h(a(paramString, i)));
      break;
      str = d(dl.a(paramString, localIntent.getIntExtra("stickers_collection_id", 0)));
      break;
      str = d(dl.c(paramString, da.h(localIntent.getStringExtra("stickers_tab_name"))));
      break;
    }
    return dl.b(str, localIntent.getStringExtra("promotion_code"));
  }

  public void a(int paramInt, String paramString)
  {
    int i = 1;
    if (this.m != null)
    {
      MenuItem localMenuItem = this.m;
      if (paramInt == i)
        localMenuItem.setVisible(i);
    }
    else
    {
      if (!da.a(paramString))
        break label49;
      this.n = c.a;
    }
    label49: 
    do
    {
      return;
      i = 0;
      break;
      this.n = new c(paramString);
    }
    while (this.o == null);
    this.o.setShareIntent(A());
  }

  public void a(String paramString1, String paramString2, String paramString3)
  {
    dj.b(this.w, true);
    dj.b(this.v, false);
    HashMap localHashMap = new HashMap();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString3);
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, localJSONObject.optString(str, ""));
      }
    }
    catch (JSONException localJSONException)
    {
      this.u.a(this, paramString2, paramString1, localHashMap);
    }
  }

  protected void b()
  {
    x();
  }

  protected String c()
  {
    if (this.b == null)
      y();
    return this.b;
  }

  public void c(String paramString)
  {
    this.u.a(paramString);
  }

  protected String d()
  {
    return getString(R.string.more_sticker_market);
  }

  protected ViberWebApiActivity.b j()
  {
    return ViberWebApiActivity.b.b;
  }

  public void onBackPressed()
  {
    if ((this.u != null) && (this.u.a()))
    {
      this.u.a(true);
      return;
    }
    super.onBackPressed();
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.report_video)
      this.u.b();
    while ((i != R.id.close_ad_btn) && (i != R.id.you_can_close_label))
      return;
    dj.b(this.x, false);
    this.u.a(false);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!ViberApplication.isTablet(this))
      com.viber.voip.n.a.d(this);
    Bundle localBundle = getIntent().getExtras();
    this.d = b.values()[localBundle.getInt("method", 0)];
    this.r = localBundle.getInt("source", 99);
    this.s = g.a();
    this.t = ViberApplication.getInstance().getEngine(false).getCdrController();
    l();
    sendBroadcast(new Intent("on_sticker_market_opened"));
    this.u = o.a(this, av.a(av.e.a), ViberApplication.getInstance().getEngine(false).getPhoneController());
    this.x = findViewById(R.id.video_ad_layout);
    this.y = ((ViewGroup)findViewById(R.id.video_ad_container));
    this.v = this.x.findViewById(R.id.close_ad_btn);
    this.w = this.x.findViewById(R.id.free_description);
    this.z = ((TextView)this.x.findViewById(R.id.you_can_close_label));
    this.x.findViewById(R.id.report_video).setOnClickListener(this);
    this.x.setOnTouchListener(j.a);
    this.v.setOnClickListener(this);
    this.z.setOnClickListener(this);
    this.u.a(this.A);
    this.s.c().f().a(localBundle.getString("mixpanel_entry_point", ""), localBundle.getString("mixpanel_target_page", ""), ae.b());
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(R.menu.menu_sticker_market, paramMenu);
    this.m = paramMenu.findItem(R.id.menu_share);
    this.m.setVisible(false);
    MenuItem localMenuItem = paramMenu.findItem(R.id.menu_share_share);
    if (localMenuItem != null)
    {
      this.o = ((ShareActionProvider)MenuItemCompat.getActionProvider(localMenuItem));
      if (this.o != null)
        this.o.setOnShareTargetSelectedListener(new ShareActionProvider.OnShareTargetSelectedListener()
        {
          public boolean onShareTargetSelected(ShareActionProvider paramAnonymousShareActionProvider, Intent paramAnonymousIntent)
          {
            String str = paramAnonymousIntent.getComponent().getPackageName();
            StickerMarketActivity.a(StickerMarketActivity.this, 1, str);
            return false;
          }
        });
    }
    return true;
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.u != null)
      this.u.b(this.A);
    i.a().b(this.k);
    this.l.removeCallbacks(this.p);
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    this.d = b.values()[paramIntent.getIntExtra("method", 0)];
    p();
    getSupportActionBar().a(d());
    if (this.m != null)
      this.m.setVisible(false);
    if (!this.c)
      b();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    boolean bool;
    if (i == R.id.menu_settings)
    {
      startActivity(new Intent(this, MarketSettingsActivity.class));
      bool = true;
    }
    int i1;
    do
    {
      int j;
      do
      {
        return bool;
        j = R.id.menu_share;
        bool = false;
      }
      while (i == j);
      if (i == R.id.menu_share_forward)
      {
        b(0, "");
        int i2 = R.string.sticker_package_forward_message_text;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = this.n.b();
        arrayOfObject[1] = this.n.d();
        startActivity(ViberActionRunner.u.a(getString(i2, arrayOfObject), false).addFlags(268435456));
        return true;
      }
      i1 = R.id.menu_share_share;
      bool = false;
    }
    while (i == i1);
    if (i == R.id.menu_share_copy_link)
    {
      b(2, "");
      ((ClipboardManager)getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("sticker package link", this.n.d()));
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  protected void onStart()
  {
    super.onStart();
    this.q = System.currentTimeMillis();
  }

  protected void onStop()
  {
    super.onStop();
    z();
    this.r = 7;
  }

  protected boolean t_()
  {
    return true;
  }

  private static class a extends com.viber.voip.d.b<StickerMarketActivity>
  {
    private a(StickerMarketActivity paramStickerMarketActivity)
    {
      super();
    }

    public void a(StickerMarketActivity paramStickerMarketActivity)
    {
      if (paramStickerMarketActivity.isDestroyed())
        return;
      paramStickerMarketActivity.getSupportActionBar().b(null);
    }
  }

  private static enum b
  {
    static
    {
      b[] arrayOfb = new b[5];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
      arrayOfb[3] = d;
      arrayOfb[4] = e;
    }
  }

  static class c
  {
    static c a = new c("");
    private String b = "";
    private String c = "";
    private String d = "";

    public c(String paramString)
    {
      try
      {
        if (!da.a(paramString))
          a(paramString);
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }

    private void a(String paramString)
      throws JSONException
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      this.b = localJSONObject.optString("id");
      this.c = localJSONObject.optString("title");
      this.d = localJSONObject.optString("landing_page_url");
    }

    public String a()
    {
      return this.b;
    }

    public String b()
    {
      return this.c;
    }

    public String c()
    {
      return this.d;
    }

    public String d()
    {
      return c().replace("http://", "");
    }

    public ProductId e()
    {
      return ProductId.fromString(a());
    }
  }

  class d
    implements o.b
  {
    d()
    {
    }

    public void a()
    {
      com.viber.voip.ui.b.a.b(StickerMarketActivity.f(StickerMarketActivity.this));
      com.viber.voip.ui.b.a.a(StickerMarketActivity.c(StickerMarketActivity.this));
      StickerMarketActivity.b(StickerMarketActivity.this).setText(R.string.western_union_menu_close);
    }

    public void a(long paramLong)
    {
      dj.b(StickerMarketActivity.b(StickerMarketActivity.this), true);
      TextView localTextView = StickerMarketActivity.b(StickerMarketActivity.this);
      StickerMarketActivity localStickerMarketActivity = StickerMarketActivity.this;
      int i = R.string.you_can_close_in_sec;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(paramLong));
      localTextView.setText(localStickerMarketActivity.getString(i, arrayOfObject));
    }

    public void a(AdView paramAdView, String paramString, int paramInt)
    {
      View localView;
      if (paramInt == 0)
      {
        StickerMarketActivity.d(StickerMarketActivity.this).addView(paramAdView);
        StickerMarketActivity.e(StickerMarketActivity.this).a(paramAdView);
        localView = StickerMarketActivity.a(StickerMarketActivity.this);
        if (paramInt != 0)
          break label63;
      }
      label63: for (boolean bool = true; ; bool = false)
      {
        dj.b(localView, bool);
        return;
        StickerMarketActivity.d(StickerMarketActivity.this).removeAllViews();
        break;
      }
    }

    public void a(String paramString)
    {
      dj.b(StickerMarketActivity.a(StickerMarketActivity.this), false);
      dj.b(StickerMarketActivity.b(StickerMarketActivity.this), false);
      dj.b(StickerMarketActivity.c(StickerMarketActivity.this), false);
      StickerMarketActivity.d(StickerMarketActivity.this).removeAllViews();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.StickerMarketActivity
 * JD-Core Version:    0.6.2
 */