package com.viber.voip.ads;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebView;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.banner.datatype.StickerClickerMetaInfoItem;
import com.viber.voip.stickers.i;
import com.viber.voip.ui.GenericWebViewActivity;
import com.viber.voip.util.dz;

public class StickerClickerWebViewActivity extends GenericWebViewActivity
  implements View.OnTouchListener
{
  private static final Logger a = ViberEnv.getLogger();
  private GestureDetector b;
  private String[] c;
  private String[] d;
  private String[] e;
  private Handler f;
  private boolean g;
  private boolean m;
  private boolean n;
  private Runnable o;
  private long p;
  private boolean q;

  private static Intent a(Context paramContext, String paramString, StickerClickerMetaInfoItem paramStickerClickerMetaInfoItem)
  {
    Intent localIntent = new Intent(paramContext, StickerClickerWebViewActivity.class);
    localIntent.putExtra("extra_url", paramString);
    localIntent.putExtra("extra_ignore_history", true);
    localIntent.putExtra("extra_track_urls_imp", paramStickerClickerMetaInfoItem.getLandingPageImpUrls());
    localIntent.putExtra("extra_track_urls_view", paramStickerClickerMetaInfoItem.getLandingPageViewUrls());
    localIntent.putExtra("extra_track_urls_click", paramStickerClickerMetaInfoItem.getLandingPageClickUrls());
    localIntent.putExtra("extra_use_host_for_title", true);
    return localIntent;
  }

  public static void a(Context paramContext, Uri paramUri, StickerClickerMetaInfoItem paramStickerClickerMetaInfoItem)
  {
    dz.a(paramContext, a(paramContext, paramUri.toString(), paramStickerClickerMetaInfoItem));
  }

  public void a()
  {
    super.a();
    if ((this.g) || (this.q));
    do
    {
      return;
      this.g = true;
      if (this.c != null)
        i.a().b().b().a(this.c);
    }
    while (this.o == null);
    this.f.postDelayed(this.o, 1000L);
  }

  protected void a(WebView paramWebView)
  {
    super.a(paramWebView);
    paramWebView.setOnTouchListener(this);
  }

  protected void b()
  {
    this.q = true;
    super.b();
  }

  protected void onCreate(Bundle paramBundle)
  {
    if (!ViberApplication.isTablet(this))
      com.viber.voip.n.a.d(this);
    super.onCreate(paramBundle);
    this.b = new GestureDetector(this, new a());
    this.f = new Handler();
    this.c = getIntent().getStringArrayExtra("extra_track_urls_imp");
    this.e = getIntent().getStringArrayExtra("extra_track_urls_view");
    this.d = getIntent().getStringArrayExtra("extra_track_urls_click");
    this.p = System.currentTimeMillis();
    if (this.e != null)
      this.o = new Runnable()
      {
        public void run()
        {
          if (StickerClickerWebViewActivity.a(StickerClickerWebViewActivity.this))
            return;
          StickerClickerWebViewActivity.a(StickerClickerWebViewActivity.this, true);
          i.a().b().b().a(StickerClickerWebViewActivity.b(StickerClickerWebViewActivity.this));
        }
      };
  }

  protected void onRestart()
  {
    super.onRestart();
    if ((!this.n) && (this.o != null))
      this.f.postDelayed(this.o, 1000L);
  }

  protected void onStop()
  {
    if (this.o != null)
      this.f.removeCallbacks(this.o);
    super.onStop();
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.b.onTouchEvent(paramMotionEvent);
    return false;
  }

  class a extends GestureDetector.SimpleOnGestureListener
  {
    a()
    {
    }

    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      boolean bool = true;
      if ((StickerClickerWebViewActivity.c(StickerClickerWebViewActivity.this)) || (StickerClickerWebViewActivity.d(StickerClickerWebViewActivity.this)))
        bool = false;
      do
      {
        return bool;
        StickerClickerWebViewActivity.b(StickerClickerWebViewActivity.this, bool);
      }
      while (StickerClickerWebViewActivity.e(StickerClickerWebViewActivity.this) == null);
      i.a().b().b().a(StickerClickerWebViewActivity.e(StickerClickerWebViewActivity.this));
      return bool;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.StickerClickerWebViewActivity
 * JD-Core Version:    0.6.2
 */