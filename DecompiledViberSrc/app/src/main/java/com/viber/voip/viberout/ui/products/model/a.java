package com.viber.voip.viberout.ui.products.model;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.content.res.ResourcesCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.viber.voip.R.color;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.api.a.b.a.h;
import com.viber.voip.api.a.b.a.i;
import com.viber.voip.api.a.b.a.j;
import com.viber.voip.api.a.b.a.k;
import com.viber.voip.api.a.b.a.l;
import com.viber.voip.api.a.b.a.m;
import com.viber.voip.api.a.b.a.m.a;
import com.viber.voip.util.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;

public class a
{
  private final Resources a;
  private final com.viber.voip.viberout.ui.products.a b;

  @Inject
  public a(Resources paramResources, com.viber.voip.viberout.ui.products.a parama)
  {
    this.a = paramResources;
    this.b = parama;
  }

  private String a(k paramk)
  {
    return this.b.a(paramk.b(), paramk.a());
  }

  private String a(l paraml)
  {
    return paraml.b();
  }

  public CountryModel a(com.viber.voip.api.a.b.a.c paramc)
  {
    return new CountryModel(paramc.a(), paramc.b(), paramc.c());
  }

  public CreditModel a(com.viber.voip.api.a.b.a.d paramd)
  {
    CreditModel localCreditModel = new CreditModel();
    localCreditModel.setAmount(paramd.a().a());
    localCreditModel.setFormattedAmount(paramd.a().b());
    localCreditModel.setRecommended(paramd.c());
    localCreditModel.setInfoAction(paramd.d().b());
    localCreditModel.setBuyAction(paramd.d().a());
    if (paramd.b() != null)
      localCreditModel.setExtraFormattedAmount(paramd.b().b());
    return localCreditModel;
  }

  public DestinationModel a(m.a parama, l paraml)
  {
    DestinationModel localDestinationModel = new DestinationModel();
    localDestinationModel.setName(parama.a());
    String str = parama.b();
    int i;
    switch (str.hashCode())
    {
    default:
      i = -1;
      switch (i)
      {
      default:
        label55: localDestinationModel.setIconResId(R.drawable.ic_toll_free);
      case 0:
      case 1:
      }
      break;
    case -1068855134:
    case -1616620449:
    }
    while (true)
    {
      Resources localResources1 = this.a;
      int j = R.string.vo_credit_per_min_price;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = parama.c().b();
      localDestinationModel.setRateLine1(localResources1.getString(j, arrayOfObject1));
      if (parama.c().a() != 0.0D)
        break label239;
      if (!"landline".equals(parama.b()))
        localDestinationModel.setRateLine1(this.a.getString(R.string.free));
      localDestinationModel.setRateLine2(this.a.getString(R.string.unlimited));
      localDestinationModel.setMinutes(-1);
      return localDestinationModel;
      if (!str.equals("mobile"))
        break;
      i = 0;
      break label55;
      if (!str.equals("landline"))
        break;
      i = 1;
      break label55;
      localDestinationModel.setIconResId(R.drawable.ic_mobile);
      continue;
      localDestinationModel.setIconResId(R.drawable.ic_landline);
    }
    label239: int k = Double.valueOf(paraml.a() / parama.c().a()).intValue();
    Resources localResources2 = this.a;
    int m = R.string.vo_plan_offer;
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = String.valueOf(k);
    localDestinationModel.setRateLine2(localResources2.getString(m, arrayOfObject2));
    localDestinationModel.setMinutes(k);
    return localDestinationModel;
  }

  @SuppressLint({"StringFormatMatches"})
  public PlanModel a(j paramj)
  {
    PlanModel localPlanModel = new PlanModel();
    boolean bool;
    label54: String str1;
    label191: String str2;
    String str3;
    double d;
    if (paramj.j() != null)
    {
      bool = true;
      localPlanModel.setType(paramj.g());
      localPlanModel.setCountry(paramj.a());
      if (TextUtils.isEmpty(paramj.b()))
        break label370;
      localPlanModel.setCountryIcon(Uri.parse(paramj.b()));
      localPlanModel.setCountryCode(paramj.l()[0].b());
      Resources localResources1 = this.a;
      int i = R.string.vo_plan_discount;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(paramj.f());
      localPlanModel.setDiscount(localResources1.getString(i, arrayOfObject1));
      localPlanModel.setDiscountValue(paramj.f());
      if (!paramj.e().b())
        break label378;
      StringBuilder localStringBuilder = new StringBuilder();
      Resources localResources2 = this.a;
      int j = R.string.vo_plan_offer;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = this.a.getString(R.string.unlimited);
      str1 = localResources2.getString(j, arrayOfObject2) + "*";
      localPlanModel.setOffer(str1);
      localPlanModel.setUnlimited(paramj.e().b());
      localPlanModel.setDestinations(TextUtils.join(", ", paramj.h()));
      localPlanModel.setHasIntroductory(bool);
      str2 = a(paramj.c());
      str3 = a(paramj.d());
      if (!bool)
        break label495;
      d = paramj.j().a().a();
      if (d != 0.0D)
        break label423;
      localPlanModel.setBuyButtonText(this.a.getString(R.string.vo_pricing_buy_button_free_trial));
      label284: localPlanModel.setBuyButtonTextNonLocalized(str2);
      localPlanModel.setDescription(this.a.getString(R.string.vo_pricing_buy_button_terms, new Object[] { str2, "", str3 }));
    }
    while (true)
    {
      localPlanModel.setBuyAction(paramj.i().a());
      localPlanModel.setInfoAction(paramj.i().b());
      localPlanModel.setMultipleDestinations(paramj.k());
      localPlanModel.setDestinationCountriesCount(paramj.l().length);
      return localPlanModel;
      bool = false;
      break;
      label370: localPlanModel.setCountryIcon(null);
      break label54;
      label378: Resources localResources4 = this.a;
      int m = R.string.vo_plan_offer;
      Object[] arrayOfObject4 = new Object[1];
      arrayOfObject4[0] = String.valueOf(paramj.e().a());
      str1 = localResources4.getString(m, arrayOfObject4);
      break label191;
      label423: if (d <= 0.0D)
        break label284;
      h localh = paramj.j();
      Resources localResources3 = this.a;
      int k = R.string.vo_pricing_buy_button_price;
      Object[] arrayOfObject3 = new Object[2];
      arrayOfObject3[0] = a(localh.b());
      arrayOfObject3[1] = a(localh.a());
      localPlanModel.setBuyButtonText(localResources3.getString(k, arrayOfObject3));
      break label284;
      label495: if (localPlanModel.isSubscription())
      {
        localPlanModel.setBuyButtonText(this.a.getString(R.string.vo_plan_price, new Object[] { str2, str3 }));
        localPlanModel.setDescription(this.a.getString(R.string.vo_subscription_desc));
      }
      else if (localPlanModel.isCallingPlan())
      {
        localPlanModel.setBuyButtonText(str2);
        localPlanModel.setDescription(this.a.getString(R.string.vo_calling_plan_desc, new Object[] { str3 }));
      }
      else
      {
        localPlanModel.setBuyButtonText(null);
        localPlanModel.setBuyButtonText(null);
      }
    }
  }

  public RateModel a(m paramm, l paraml)
  {
    RateModel localRateModel = new RateModel();
    localRateModel.setCountryIcon(Uri.parse(paramm.a().c()));
    localRateModel.setCountryName(paramm.a().a());
    int i = -1;
    ArrayList localArrayList = new ArrayList();
    m.a[] arrayOfa = paramm.b();
    int j = arrayOfa.length;
    int k = 0;
    for (int m = 0; m < j; m++)
    {
      m.a locala = arrayOfa[m];
      DestinationModel localDestinationModel = a(locala, paraml);
      localArrayList.add(localDestinationModel);
      if ((locala.c().a() == 0.0D) && ("landline".equals(locala.b())))
        k = 1;
      i = Math.max(i, localDestinationModel.getMinutes());
    }
    localRateModel.setDestinations(localArrayList);
    localRateModel.setMaxMinutes(i);
    if (k != 0)
    {
      localRateModel.setRateEquation("");
      return localRateModel;
    }
    Resources localResources = this.a;
    int n = R.string.vo_credit_estimated_value;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paraml.b();
    arrayOfObject[1] = Integer.valueOf(i);
    SpannableString localSpannableString = new SpannableString(localResources.getString(n, arrayOfObject));
    localSpannableString.setSpan(new ForegroundColorSpan(ResourcesCompat.getColor(this.a, R.color.highlighted_price, null)), 0, paraml.b().length(), 33);
    localRateModel.setRateEquation(localSpannableString);
    return localRateModel;
  }

  public List<CreditModel> a(Collection<com.viber.voip.api.a.b.a.d> paramCollection)
  {
    return u.a(paramCollection, new c(this));
  }

  public List<RateModel> a(Collection<m> paramCollection, l paraml)
  {
    List localList = u.a(paramCollection, new b(this, paraml));
    if (!localList.isEmpty())
      ((RateModel)localList.get(-1 + localList.size())).setLast(true);
    return localList;
  }

  public List<CountryModel> a(List<com.viber.voip.api.a.b.a.c> paramList)
  {
    return u.a(paramList, new d(this));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.model.a
 * JD-Core Version:    0.6.2
 */