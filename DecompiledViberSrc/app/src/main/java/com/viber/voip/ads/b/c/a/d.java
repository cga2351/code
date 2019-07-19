package com.viber.voip.ads.b.c.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.PopupMenu;
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
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAdView;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAdView;
import com.viber.voip.R.attr;
import com.viber.voip.R.id;
import com.viber.voip.R.menu;
import com.viber.voip.ads.b.a.b.a.b;
import com.viber.voip.ads.b.c.c.c;
import com.viber.voip.util.da;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.f.a;

class d
  implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener, a<c>
{
  private final ViewGroup a;
  private final i b;
  private final com.viber.voip.util.e.e c;
  private final com.viber.voip.util.e.f d;
  private final com.viber.voip.util.e.f e;
  private final int f;
  private final int g;
  private final int h;
  private View i;
  private final View j;
  private PopupMenu k;
  private c l;
  private boolean m;
  private Point n;
  private final NativeAppInstallAdView o;
  private final NativeContentAdView p;

  d(ViewGroup paramViewGroup, i parami, com.viber.voip.util.e.e parame, com.viber.voip.util.e.f paramf1, com.viber.voip.util.e.f paramf2, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramViewGroup;
    this.b = parami;
    this.j = paramViewGroup.findViewById(R.id.overflowButton);
    this.i = paramViewGroup.findViewById(R.id.adProviderView);
    this.c = parame;
    this.e = paramf2;
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramInt3;
    if (this.j != null)
      this.j.setOnClickListener(this);
    this.a.setOnLongClickListener(this);
    int i1 = dc.a(paramViewGroup.getContext(), R.attr.adsListingIconPlaceholder);
    this.d = paramf1.f().a(Integer.valueOf(i1)).b(Integer.valueOf(i1)).c();
    this.p = ((NativeContentAdView)LayoutInflater.from(paramViewGroup.getContext()).inflate(this.g, null));
    this.o = ((NativeAppInstallAdView)LayoutInflater.from(paramViewGroup.getContext()).inflate(this.h, null));
  }

  private PopupMenu a()
  {
    if (this.k == null)
      this.k = b();
    return this.k;
  }

  private View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(this.f, this.a, true);
  }

  private View a(ConstraintLayout paramConstraintLayout, int paramInt)
  {
    View localView = paramConstraintLayout.a(paramInt);
    if (localView != null)
      return localView;
    return paramConstraintLayout.findViewById(paramInt);
  }

  private NativeAdView a(com.viber.voip.ads.b.b.b.a parama)
  {
    if ((parama instanceof b))
      return this.p;
    return this.o;
  }

  @SuppressLint({"ClickableViewAccessibility"})
  private void a(ConstraintLayout paramConstraintLayout, c paramc)
  {
    ImageView localImageView = (ImageView)a(paramConstraintLayout, R.id.adImageView);
    TextView localTextView1 = (TextView)a(paramConstraintLayout, R.id.adTitleView);
    TextView localTextView2 = (TextView)a(paramConstraintLayout, R.id.adSubtitleView);
    TextView localTextView3 = (TextView)a(paramConstraintLayout, R.id.adSponsoredView);
    View localView = a(paramConstraintLayout, R.id.adProviderView);
    Button localButton = (Button)a(paramConstraintLayout, R.id.adButton);
    dj.b(this.i, false);
    dj.b(localView, true);
    dj.b(localButton, paramc.k());
    if ((paramc.a() instanceof com.viber.voip.ads.b.a.b.b.a))
    {
      Resources localResources = paramConstraintLayout.getResources();
      localImageView.setImageResource(paramc.c());
      localTextView1.setText(paramc.a(localResources));
      localTextView2.setText(paramc.b(localResources));
      if (paramc.k())
        localButton.setText(paramc.c(localResources));
      a(localView, localTextView3, paramc);
      paramConstraintLayout.setOnTouchListener(this);
      paramConstraintLayout.setOnClickListener(this);
      localButton.setOnClickListener(this);
      return;
    }
    this.c.a(paramc.b(), localImageView, this.d);
    localTextView1.setText(paramc.e());
    if (!da.a(paramc.f()));
    for (boolean bool = true; ; bool = false)
    {
      dj.b(localTextView2, bool);
      localTextView2.setText(paramc.f());
      if (!paramc.k())
        break;
      localButton.setText(paramc.i());
      break;
    }
  }

  private void a(View paramView, TextView paramTextView, c paramc)
  {
    dj.b(paramTextView, paramc.j());
    if (paramTextView != null)
      paramTextView.setText(paramc.g());
    ImageView localImageView;
    if (paramView != null)
    {
      localImageView = (ImageView)paramView.findViewById(R.id.adProviderIconView);
      String str1 = paramc.d();
      if ((str1 == null) || (!paramc.j()) || (da.a(str1)))
        break label134;
      dj.b(localImageView, true);
      this.c.a(Uri.parse(str1), localImageView, this.e, null);
    }
    while (true)
    {
      String str2 = paramc.h();
      if ((paramc.j()) && (!da.a(str2)))
        paramView.setOnClickListener(new f(str2));
      return;
      label134: dj.b(localImageView, false);
    }
  }

  private void a(NativeAdView paramNativeAdView, ConstraintLayout paramConstraintLayout, c paramc)
  {
    boolean bool1 = true;
    boolean bool2 = c(paramc);
    View localView1 = a(paramConstraintLayout, R.id.adProviderView);
    boolean bool3;
    ImageView localImageView;
    TextView localTextView1;
    TextView localTextView2;
    Button localButton;
    View localView2;
    label115: boolean bool4;
    if ((!bool2) || (this.i == null))
    {
      bool3 = bool1;
      dj.b(localView1, bool3);
      dj.b(this.i, bool2);
      localImageView = (ImageView)a(paramConstraintLayout, R.id.adImageView);
      localTextView1 = (TextView)a(paramConstraintLayout, R.id.adTitleView);
      localTextView2 = (TextView)a(paramConstraintLayout, R.id.adSubtitleView);
      localButton = (Button)a(paramConstraintLayout, R.id.adButton);
      if (!bool2)
        break label312;
      localView2 = this.i;
      TextView localTextView3 = (TextView)localView2.findViewById(R.id.adSponsoredView);
      this.c.a(paramc.b(), localImageView, this.d);
      localTextView1.setText(paramc.e());
      if (da.a(paramc.f()))
        break label319;
      bool4 = bool1;
      label174: dj.b(localTextView2, bool4);
      localTextView2.setText(paramc.f());
      if (da.a(paramc.i()))
        break label325;
      label204: dj.b(localButton, bool1);
      localButton.setText(paramc.i());
      a(localView2, localTextView3, paramc);
      if (!(paramNativeAdView instanceof NativeAppInstallAdView))
        break label331;
      ((NativeAppInstallAdView)paramNativeAdView).setIconView(localImageView);
      ((NativeAppInstallAdView)paramNativeAdView).setHeadlineView(localTextView1);
      ((NativeAppInstallAdView)paramNativeAdView).setBodyView(localTextView2);
      ((NativeAppInstallAdView)paramNativeAdView).setCallToActionView(localButton);
    }
    while (true)
    {
      paramNativeAdView.setNativeAd((NativeAd)paramc.a().x());
      paramc.a(new e(this, paramc));
      return;
      bool3 = false;
      break;
      label312: localView2 = localView1;
      break label115;
      label319: bool4 = false;
      break label174;
      label325: bool1 = false;
      break label204;
      label331: if ((paramNativeAdView instanceof NativeContentAdView))
      {
        ((NativeContentAdView)paramNativeAdView).setLogoView(localImageView);
        ((NativeContentAdView)paramNativeAdView).setHeadlineView(localTextView1);
        ((NativeContentAdView)paramNativeAdView).setBodyView(localTextView2);
        ((NativeContentAdView)paramNativeAdView).setCallToActionView(localButton);
      }
    }
  }

  private PopupMenu b()
  {
    boolean bool1 = true;
    if (this.j == null)
      return null;
    PopupMenu localPopupMenu = new PopupMenu(this.a.getContext(), this.j);
    Menu localMenu = localPopupMenu.getMenu();
    localPopupMenu.getMenuInflater().inflate(R.menu.context_menu_pa_ad, localMenu);
    MenuItem localMenuItem1 = localMenu.findItem(R.id.ad_hide);
    boolean bool2;
    MenuItem localMenuItem2;
    if ((this.l != null) && (this.l.m()))
    {
      bool2 = bool1;
      localMenuItem1.setVisible(bool2);
      localMenuItem2 = localMenu.findItem(R.id.ad_report);
      if ((this.l == null) || (!this.l.n()))
        break label160;
    }
    while (true)
    {
      localMenuItem2.setVisible(bool1);
      localPopupMenu.setOnMenuItemClickListener(new g(this));
      localPopupMenu.setOnDismissListener(new h(this));
      return localPopupMenu;
      bool2 = false;
      break;
      label160: bool1 = false;
    }
  }

  private String c()
  {
    int[] arrayOfInt = new int[2];
    if (this.n != null)
    {
      ConstraintLayout localConstraintLayout = (ConstraintLayout)this.a.findViewById(R.id.adViewContainer);
      ImageView localImageView = (ImageView)a(localConstraintLayout, R.id.adImageView);
      TextView localTextView1 = (TextView)a(localConstraintLayout, R.id.adTitleView);
      TextView localTextView2 = (TextView)a(localConstraintLayout, R.id.adSubtitleView);
      View localView = a(localConstraintLayout, R.id.adProviderView);
      localImageView.getLocationOnScreen(arrayOfInt);
      if (new Rect(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + localImageView.getWidth(), arrayOfInt[1] + localImageView.getHeight()).contains(this.n.x, this.n.y))
        return "image";
      localTextView1.getLocationOnScreen(arrayOfInt);
      if (new Rect(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + localTextView1.getWidth(), arrayOfInt[1] + localTextView1.getHeight()).contains(this.n.x, this.n.y))
        return "title";
      localTextView2.getLocationOnScreen(arrayOfInt);
      if (new Rect(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + localTextView2.getWidth(), arrayOfInt[1] + localTextView2.getHeight()).contains(this.n.x, this.n.y))
        return "text";
      localView.getLocationOnScreen(arrayOfInt);
      if (new Rect(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + localView.getWidth(), arrayOfInt[1] + localView.getHeight()).contains(this.n.x, this.n.y))
        return "sponsored";
      this.n = null;
    }
    return "other";
  }

  private boolean c(c paramc)
  {
    com.viber.voip.ads.b.b.b.a locala = paramc.a();
    Bundle localBundle;
    if ((locala instanceof com.viber.voip.ads.b.a.b.a.a))
      localBundle = ((NativeAppInstallAd)locala.x()).getExtras();
    while (true)
    {
      if (localBundle == null);
      for (String str = null; ; str = localBundle.getString("providerName"))
      {
        return "polymorph".equalsIgnoreCase(str);
        if (!(locala instanceof b))
          break label74;
        localBundle = ((NativeContentAd)locala.x()).getExtras();
        break;
      }
      label74: localBundle = null;
    }
  }

  public void a(c paramc)
  {
    if (paramc.equals(this.l))
      return;
    this.l = paramc;
    View localView1 = this.a.findViewById(R.id.adViewContainer);
    NativeAdView localNativeAdView1 = (NativeAdView)this.a.findViewById(R.id.googleAdView);
    com.viber.voip.ads.b.b.b.a locala = paramc.a();
    boolean bool;
    if (((locala instanceof com.viber.voip.ads.b.a.b.a.a)) || ((locala instanceof b)))
    {
      if ((localNativeAdView1 == null) && (localView1 != null))
        this.a.removeView(localView1);
      if ((((localNativeAdView1 instanceof NativeContentAdView)) && ((locala instanceof com.viber.voip.ads.b.a.b.a.a))) || (((localNativeAdView1 instanceof NativeAppInstallAdView)) && ((locala instanceof b))))
      {
        this.a.removeView(localNativeAdView1);
        localNativeAdView1 = null;
      }
      if (localNativeAdView1 == null)
      {
        localNativeAdView1 = a(locala);
        this.a.addView(localNativeAdView1, 0);
        localNativeAdView1.setAlpha(1.0F);
      }
      NativeAdView localNativeAdView2 = localNativeAdView1;
      a(localNativeAdView2, (ConstraintLayout)localNativeAdView2.findViewById(R.id.adViewContainer), this.l);
      if (this.j != null)
        this.j.setAlpha(1.0F);
      if ((this.l.m()) || (this.l.n()))
      {
        bool = true;
        label213: dj.b(this.j, bool);
        dj.b(this.a.findViewById(R.id.overflowButtonSpace), bool);
      }
    }
    else
    {
      if (localNativeAdView1 == null)
        break label310;
      this.a.removeView(localNativeAdView1);
    }
    label310: for (View localView2 = null; ; localView2 = localView1)
    {
      if (localView2 == null)
        localView2 = a(this.a.getContext());
      this.a.bringChildToFront(this.j);
      a((ConstraintLayout)localView2.findViewById(R.id.adViewContainer), this.l);
      break;
      bool = false;
      break label213;
    }
  }

  public void onClick(View paramView)
  {
    if ((this.b == null) || (this.l == null))
      return;
    String str = c();
    int i1 = paramView.getId();
    if (i1 == R.id.overflowButton)
    {
      PopupMenu localPopupMenu = a();
      if (localPopupMenu != null)
        localPopupMenu.show();
      str = "menu icon";
    }
    while (true)
    {
      this.b.a(this.l.a(), this.a, str);
      return;
      if (i1 == R.id.adButton)
        str = "button";
    }
  }

  public boolean onLongClick(View paramView)
  {
    if ((this.b != null) && (this.l != null))
      this.b.a(this.l.a(), this.a);
    return false;
  }

  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.n = new Point((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY());
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.b.c.a.d
 * JD-Core Version:    0.6.2
 */