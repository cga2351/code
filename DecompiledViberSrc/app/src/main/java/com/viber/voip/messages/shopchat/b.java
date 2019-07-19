package com.viber.voip.messages.shopchat;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.mixpanel.android.mpmetrics.MixpanelAPI.c;
import com.shopchat.library.RootView.a;
import com.shopchat.library.ShopChatView;
import com.shopchat.library.util.e;
import com.viber.dexshared.Logger;
import com.viber.voip.R.anim;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberEnv;
import com.viber.voip.registration.af;
import com.viber.voip.settings.d.r;
import com.viber.voip.ui.aq;
import com.viber.voip.ui.b.a.a;
import com.viber.voip.util.dj;
import java.util.Collections;
import java.util.Locale;
import javax.inject.Inject;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends aq
{
  private static final Logger c = ViberEnv.getLogger();

  @Inject
  com.viber.voip.messages.controller.publicaccount.d a;

  @Inject
  af b;
  private Animation d;
  private Animation e;
  private ShopChatView f;
  private a g;
  private com.shopchat.library.a.a h;
  private final View.OnClickListener i = new c(this);

  public static b a(OpenShopChatPanelData paramOpenShopChatPanelData)
  {
    b localb = new b();
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("data", paramOpenShopChatPanelData);
    localb.setArguments(localBundle);
    return localb;
  }

  private void a()
  {
    this.f.startAnimation(this.e);
  }

  private void a(ShopChatView paramShopChatView)
  {
    b(paramShopChatView);
  }

  private a b()
  {
    g localg = c();
    MixpanelAPI localMixpanelAPI = MixpanelAPI.getInstance(requireContext(), "9ecad602dae5c827548867e8c32e4925");
    localMixpanelAPI.getPeople().a(localMixpanelAPI.getDistinctId());
    localMixpanelAPI.unregisterSuperProperty("catalog");
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("catalog", localg.name());
      localMixpanelAPI.registerSuperProperties(localJSONObject);
      label58: return new a(requireContext(), localMixpanelAPI);
    }
    catch (JSONException localJSONException)
    {
      break label58;
    }
  }

  private void b(ShopChatView paramShopChatView)
  {
    if (this.b.e().toUpperCase().equals("RU"))
    {
      paramShopChatView.setLocale(new Locale(getResources().getConfiguration().locale.getLanguage(), "RU"));
      return;
    }
    paramShopChatView.setLocale(new Locale("en", "US"));
  }

  private g c()
  {
    if (this.b.e().toUpperCase().equals("RU"))
      return g.b;
    return g.a;
  }

  private static RootView.a d()
  {
    return null;
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.f.startAnimation(this.d);
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
    if ((paramContext instanceof a))
      this.g = ((a)paramContext);
    while (this.g == null)
    {
      throw new RuntimeException("ShopChatPanelFragment.Callback not implemented");
      Fragment localFragment = getParentFragment();
      if ((localFragment instanceof a))
        this.g = ((a)localFragment);
    }
  }

  public boolean onBackPressed()
  {
    if (!this.f.b())
      a();
    return true;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setRetainInstance(true);
    this.h = b();
    this.h.a(e.g.a());
    if (!d.r.t.d())
    {
      d.r.t.a(true);
      this.h.a(e.i.a(), Collections.EMPTY_MAP);
    }
    this.h.a(e.h.a(), Collections.EMPTY_MAP);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (paramBundle != null)
      this.h.a(e.j.a(), Collections.EMPTY_MAP);
    View localView = paramLayoutInflater.inflate(R.layout.fragment_shop_chat_panel, paramViewGroup, false);
    this.f = ((ShopChatView)localView.findViewById(R.id.shopChatView));
    dj.a(this.f.getCollapsePanelButton(), getResources().getDimensionPixelSize(R.dimen.small_button_touch_area));
    localView.findViewById(R.id.topPanelSpaceView).setOnClickListener(this.i);
    Context localContext = requireContext();
    this.d = AnimationUtils.loadAnimation(localContext, R.anim.long_bottom_slide_in);
    this.e = AnimationUtils.loadAnimation(localContext, R.anim.long_bottom_slide_out);
    this.d.setInterpolator(com.viber.voip.ui.b.c.c);
    this.e.setInterpolator(com.viber.voip.ui.b.c.d);
    this.e.setAnimationListener(new a.a()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        dj.b(b.a(b.this), false);
        if (b.b(b.this) != null)
          b.b(b.this).F();
      }
    });
    OpenShopChatPanelData localOpenShopChatPanelData = (OpenShopChatPanelData)getArguments().getParcelable("data");
    this.f.setViberShareListener(new d(this, localOpenShopChatPanelData));
    this.f.setGenericLogger(new f(c));
    a(this.f);
    this.f.setMixpanelListener(this.h);
    RootView.a locala = d();
    if (locala != null)
      this.f.setServerOverride(locala);
    this.f.setWebViewListener(new h(getActivity(), d.r.D));
    this.f.setCollapsePanelButtonClickListener(this.i);
    this.f.a();
    return localView;
  }

  public void onDestroy()
  {
    super.onDestroy();
    this.h.a(e.g.a(), Collections.EMPTY_MAP);
    this.h.a();
  }

  public void onDetach()
  {
    super.onDetach();
    this.g = null;
  }

  public static abstract interface a
  {
    public abstract void F();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.shopchat.b
 * JD-Core Version:    0.6.2
 */