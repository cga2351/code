package com.viber.voip.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.PopupMenu.OnDismissListener;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.appnexus.opensdk.NativeAdEventListener;
import com.appnexus.opensdk.NativeAdResponse;
import com.appnexus.opensdk.NativeAdSDK;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAdView;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAdView;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ads.d.c;
import com.viber.voip.ads.d.h;
import com.viber.voip.ads.d.l;
import com.viber.voip.ads.d.n;
import com.viber.voip.ads.d.o;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.f.b;
import com.viber.voip.util.e.j;
import java.util.ArrayList;
import java.util.List;

public class PublicAccountAdView extends FrameLayout
  implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener
{
  protected Point a;
  private ImageView b;
  private ImageView c;
  private ImageView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private View h;
  private FrameLayout i;
  private Button j;
  private com.viber.voip.util.e.f k;
  private com.viber.voip.util.e.f l;
  private n m;
  private PopupMenu n;
  private a o;
  private boolean p;

  public PublicAccountAdView(Context paramContext)
  {
    super(paramContext);
    a();
  }

  public PublicAccountAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }

  public PublicAccountAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }

  private void a()
  {
    View localView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_messages_public_group__ad_item, this, true);
    this.b = ((ImageView)localView.findViewById(R.id.ad_image));
    this.c = ((ImageView)localView.findViewById(R.id.more_menu));
    this.d = ((ImageView)localView.findViewById(R.id.provider_icon));
    this.e = ((TextView)localView.findViewById(R.id.ad_title));
    this.f = ((TextView)localView.findViewById(R.id.ad_subtitle));
    this.g = ((TextView)localView.findViewById(R.id.ad_sponsored_lbl));
    this.h = localView.findViewById(R.id.provider_container);
    this.j = ((Button)localView.findViewById(R.id.ad_btn));
    this.i = ((FrameLayout)localView.findViewById(R.id.ad_admob_view_container));
    this.k = new com.viber.voip.util.e.f.a().a(Integer.valueOf(R.drawable.ic_vibe_loading)).b(Integer.valueOf(R.drawable.ic_vibe_loading)).a(f.b.b).c();
    this.l = new com.viber.voip.util.e.f.a().a(f.b.a).c();
    dj.a(this.c, j.a(8.0F));
    this.c.setOnClickListener(this);
    setOnLongClickListener(this);
  }

  private void a(Context paramContext, com.viber.voip.ads.d.f paramf)
  {
    NativeAd localNativeAd = paramf.C();
    com.viber.voip.ads.d.e locale;
    ImageView localImageView;
    TextView localTextView1;
    TextView localTextView2;
    Button localButton;
    boolean bool3;
    if ((localNativeAd instanceof NativeContentAd))
    {
      NativeContentAdView localNativeContentAdView = (NativeContentAdView)LayoutInflater.from(paramContext).inflate(R.layout.admob_native_content_business_inbox_item_view, null);
      locale = new com.viber.voip.ads.d.e(localNativeContentAdView);
      localImageView = (ImageView)localNativeContentAdView.findViewById(R.id.ad_image);
      localTextView1 = (TextView)localNativeContentAdView.findViewById(R.id.ad_title);
      localTextView2 = (TextView)localNativeContentAdView.findViewById(R.id.ad_subtitle);
      localButton = (Button)localNativeContentAdView.findViewById(R.id.ad_btn);
      TextView localTextView4 = (TextView)localNativeContentAdView.findViewById(R.id.ad_sponsored_lbl);
      com.viber.voip.util.e.e.a(ViberApplication.getApplication()).a(((NativeAd.Image)((NativeContentAd)localNativeAd).getImages().get(0)).getUri(), localImageView, this.k);
      localTextView1.setText(((NativeContentAd)localNativeAd).getHeadline());
      localTextView2.setText(((NativeContentAd)localNativeAd).getBody());
      if (!TextUtils.isEmpty(((NativeContentAd)localNativeAd).getCallToAction()))
      {
        bool3 = true;
        dj.b(localButton, bool3);
        localButton.setText(((NativeContentAd)localNativeAd).getCallToAction());
        dj.b(localTextView4, paramf.j());
        if (paramf.j())
          localTextView4.setText(paramf.i());
      }
    }
    c localc;
    for (Object localObject = locale; ; localObject = localc)
    {
      ((h)localObject).a(localNativeAd);
      dj.b(this.c, true);
      if (this.b != null)
        ((h)localObject).e(localImageView);
      if (this.e != null)
        ((h)localObject).b(localTextView1);
      if (this.f != null)
        ((h)localObject).c(localTextView2);
      if (this.j != null)
        ((h)localObject).d(localButton);
      if (this.m.B() != null)
        a(this.m, ((h)localObject).a());
      this.i.removeAllViews();
      this.i.addView(((h)localObject).a());
      b();
      do
      {
        return;
        bool3 = false;
        break;
      }
      while (!(localNativeAd instanceof NativeAppInstallAd));
      NativeAppInstallAdView localNativeAppInstallAdView = (NativeAppInstallAdView)LayoutInflater.from(paramContext).inflate(R.layout.admob_native_app_install_business_inbox_item_view, null);
      localc = new c(localNativeAppInstallAdView);
      localImageView = (ImageView)localNativeAppInstallAdView.findViewById(R.id.ad_image);
      localTextView1 = (TextView)localNativeAppInstallAdView.findViewById(R.id.ad_title);
      localTextView2 = (TextView)localNativeAppInstallAdView.findViewById(R.id.ad_subtitle);
      localButton = (Button)localNativeAppInstallAdView.findViewById(R.id.ad_btn);
      TextView localTextView3 = (TextView)localNativeAppInstallAdView.findViewById(R.id.ad_sponsored_lbl);
      com.viber.voip.util.e.e.a(ViberApplication.getApplication()).a(((NativeAppInstallAd)localNativeAd).getIcon().getUri(), localImageView, this.k);
      localTextView1.setText(((NativeAppInstallAd)localNativeAd).getHeadline());
      localTextView2.setText(((NativeAppInstallAd)localNativeAd).getBody());
      boolean bool1 = TextUtils.isEmpty(((NativeAppInstallAd)localNativeAd).getCallToAction());
      boolean bool2 = false;
      if (!bool1)
        bool2 = true;
      dj.b(localButton, bool2);
      localButton.setText(((NativeAppInstallAd)localNativeAd).getCallToAction());
      dj.b(localTextView3, paramf.j());
      if (paramf.j())
        localTextView3.setText(paramf.i());
    }
  }

  private void a(Context paramContext, final com.viber.voip.ads.d.f paramf, final a parama)
  {
    if (paramf.C() != null)
      a(paramContext, paramf);
    while (true)
    {
      paramf.a(new com.viber.voip.ads.d.f.a()
      {
        public void a()
        {
          parama.a(paramf, jdField_this, "other");
        }
      });
      return;
      View localView = paramf.F();
      if ((localView != null) && (getChildAt(0) != localView))
      {
        removeAllViews();
        if (localView.getParent() != null)
          ((ViewGroup)localView.getParent()).removeAllViews();
        addView(localView, 0);
      }
    }
  }

  private void b()
  {
    dj.b(this.b, false);
    dj.b(this.e, false);
    dj.b(this.f, false);
    dj.b(this.h, false);
    dj.b(this.j, false);
  }

  private void c()
  {
    this.n = new PopupMenu(getContext(), this.c);
    this.n.getMenuInflater().inflate(R.menu.context_menu_pa_ad, this.n.getMenu());
    this.n.getMenu().findItem(R.id.ad_hide).setVisible(this.m.o());
    this.n.getMenu().findItem(R.id.ad_report).setVisible(this.m.n());
    this.n.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
    {
      public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        if (PublicAccountAdView.b(PublicAccountAdView.this) == null)
          return true;
        int i = paramAnonymousMenuItem.getItemId();
        if (i == R.id.ad_hide)
          PublicAccountAdView.b(PublicAccountAdView.this).b(PublicAccountAdView.a(PublicAccountAdView.this), PublicAccountAdView.this);
        while (true)
        {
          PublicAccountAdView.a(PublicAccountAdView.this, true);
          return true;
          if (i == R.id.ad_report)
            PublicAccountAdView.b(PublicAccountAdView.this).c(PublicAccountAdView.a(PublicAccountAdView.this), PublicAccountAdView.this);
        }
      }
    });
    this.n.setOnDismissListener(new PopupMenu.OnDismissListener()
    {
      public void onDismiss(PopupMenu paramAnonymousPopupMenu)
      {
        if (!PublicAccountAdView.c(PublicAccountAdView.this))
          PublicAccountAdView.b(PublicAccountAdView.this).d(PublicAccountAdView.a(PublicAccountAdView.this), PublicAccountAdView.this);
        PublicAccountAdView.a(PublicAccountAdView.this, false);
      }
    });
  }

  public void a(n paramn, View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this);
    localArrayList.add(this.j);
    NativeAdResponse localNativeAdResponse = paramn.B();
    if (localNativeAdResponse != null)
    {
      NativeAdSDK.registerTracking(localNativeAdResponse, paramView, localArrayList, new NativeAdEventListener()
      {
        public void onAdWasClicked()
        {
          PublicAccountAdView.b(PublicAccountAdView.this).a(PublicAccountAdView.a(PublicAccountAdView.this), PublicAccountAdView.this, "other");
        }

        public void onAdWasClicked(String paramAnonymousString1, String paramAnonymousString2)
        {
        }

        public void onAdWillLeaveApplication()
        {
        }
      });
      return;
    }
    this.j.setOnClickListener(this);
    setOnTouchListener(this);
    setOnClickListener(this);
  }

  public void a(n paramn, a parama)
  {
    this.m = paramn;
    this.o = parama;
    if ((paramn instanceof com.viber.voip.ads.d.f))
    {
      dj.b(this.i, true);
      a(getContext(), (com.viber.voip.ads.d.f)paramn, parama);
      return;
    }
    dj.b(this.i, false);
    if ((this.m instanceof o))
    {
      this.j.setOnClickListener(this);
      setOnTouchListener(this);
      setOnClickListener(this);
    }
    dj.b(this.b, true);
    dj.b(this.e, true);
    dj.b(this.f, true);
    dj.b(this.h, true);
    com.viber.voip.util.e.e.a(ViberApplication.getApplication()).a(paramn.f(), this.b, this.k);
    this.e.setText(paramn.g());
    this.f.setText(paramn.h());
    dj.b(this.g, paramn.j());
    if (paramn.j())
    {
      this.g.setText(paramn.i());
      if (paramn.z())
      {
        dj.b(this.d, true);
        com.viber.voip.util.e.e.a(ViberApplication.getApplication()).a(Uri.parse(paramn.x()), this.d, this.l, null);
      }
    }
    if (paramn.A())
      this.h.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          PublicAccountAdView.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(PublicAccountAdView.a(PublicAccountAdView.this).y())));
        }
      });
    dj.b(this.j, paramn.l());
    if (paramn.l())
    {
      if (!paramn.t())
        break label356;
      this.j.setText(R.string.public_account_info_menu_follow);
    }
    while (true)
    {
      ImageView localImageView = this.c;
      boolean bool1;
      if (!paramn.o())
      {
        boolean bool2 = paramn.n();
        bool1 = false;
        if (!bool2);
      }
      else
      {
        bool1 = true;
      }
      dj.b(localImageView, bool1);
      if (!(this.m instanceof l))
        break;
      a(paramn, this);
      return;
      label356: this.j.setText(paramn.k());
    }
  }

  public void onClick(View paramView)
  {
    if (this.o == null)
      return;
    String str = "other";
    Rect localRect2;
    Rect localRect3;
    Rect localRect4;
    if ((this.m instanceof o))
    {
      int[] arrayOfInt = new int[2];
      this.b.getLocationOnScreen(arrayOfInt);
      Rect localRect1 = new Rect(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + this.b.getWidth(), arrayOfInt[1] + this.b.getHeight());
      this.e.getLocationOnScreen(arrayOfInt);
      localRect2 = new Rect(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + this.e.getWidth(), arrayOfInt[1] + this.e.getHeight());
      this.f.getLocationOnScreen(arrayOfInt);
      localRect3 = new Rect(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + this.f.getWidth(), arrayOfInt[1] + this.f.getHeight());
      this.h.getLocationOnScreen(arrayOfInt);
      localRect4 = new Rect(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + this.h.getWidth(), arrayOfInt[1] + this.h.getHeight());
      if ((this.a != null) && (localRect1.contains(this.a.x, this.a.y)))
      {
        this.a = null;
        str = "image";
      }
    }
    while (true)
    {
      this.o.a(this.m, this, str);
      return;
      if ((this.a != null) && (localRect2.contains(this.a.x, this.a.y)))
      {
        this.a = null;
        str = "title";
      }
      else if ((this.a != null) && (localRect3.contains(this.a.x, this.a.y)))
      {
        this.a = null;
        str = "text";
      }
      else if ((this.a != null) && (localRect4.contains(this.a.x, this.a.y)))
      {
        this.a = null;
        str = "sponsored";
      }
      else
      {
        int i1 = paramView.getId();
        if (i1 == R.id.more_menu)
        {
          str = "menu icon";
          if (this.n == null)
            c();
          this.n.show();
        }
        else if (i1 == R.id.ad_btn)
        {
          str = "button";
          continue;
          if (paramView.getId() == R.id.more_menu)
          {
            str = "menu icon";
            if (this.n == null)
              c();
            this.n.show();
          }
        }
      }
    }
  }

  public boolean onLongClick(View paramView)
  {
    if (this.o != null)
      this.o.a(this.m, this);
    return false;
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.a = new Point((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY());
    return false;
  }

  public static abstract interface a
  {
    public abstract void a(n paramn, PublicAccountAdView paramPublicAccountAdView);

    public abstract void a(n paramn, PublicAccountAdView paramPublicAccountAdView, String paramString);

    public abstract void b(n paramn, PublicAccountAdView paramPublicAccountAdView);

    public abstract void c(n paramn, PublicAccountAdView paramPublicAccountAdView);

    public abstract void d(n paramn, PublicAccountAdView paramPublicAccountAdView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.PublicAccountAdView
 * JD-Core Version:    0.6.2
 */