package com.my.target.b.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.my.target.at;
import com.my.target.ax;
import com.my.target.ay;
import com.my.target.b.c.a.d;
import com.my.target.bj;
import com.my.target.cj;
import com.my.target.cm;
import com.my.target.dp;

public final class b
  implements c
{
  private final bj a;
  private final cj b;
  private final cm c;
  private com.my.target.b.c.a.c d;
  private c.a e;

  private b(cj paramcj, bj parambj, cm paramcm)
  {
    this.b = paramcj;
    this.a = parambj;
    this.c = paramcm;
  }

  private b(String paramString, Context paramContext)
  {
  }

  public static b a(String paramString, Context paramContext)
  {
    return new b(paramString, paramContext);
  }

  public final cj a()
  {
    return this.b;
  }

  public final void a(com.my.target.b.c.b.b paramb)
  {
    this.d = paramb.f();
    if (this.d == null)
      return;
    d locald = this.d.E();
    cm localcm1 = this.c;
    localcm1.getTitleTextView().setTextColor(locald.j());
    label91: label122: TextView localTextView1;
    label224: TextView localTextView2;
    label260: label296: final com.my.target.b.c.a.c localc;
    cm localcm2;
    label409: com.my.target.common.a.b localb1;
    if (locald.b())
    {
      localcm1.getTitleTextView().setTypeface(null, 1);
      localcm1.getDomainTextView().setTextColor(locald.o());
      if (!locald.d())
        break label588;
      localcm1.getDomainTextView().setTypeface(null, 1);
      localcm1.getRatingTextView().setTextColor(locald.p());
      if (!locald.e())
        break label602;
      localcm1.getRatingTextView().setTypeface(null, 1);
      localcm1.a(locald.h(), locald.i());
      localcm1.getAgeRestrictionsView().setTextColor(locald.l());
      localcm1.getAgeRestrictionsView().a(1, locald.m());
      localcm1.getAgeRestrictionsView().setBackgroundColor(locald.k());
      bj.a(localcm1.getCtaButton(), locald.r(), locald.s());
      localcm1.getCtaButton().setTextColor(locald.t());
      if (!locald.g())
        break label616;
      localcm1.getCtaButton().setTypeface(null, 1);
      localTextView1 = localcm1.getDescriptionTextView();
      if (localTextView1 != null)
      {
        localTextView1.setTextColor(locald.n());
        if (!locald.c())
          break label630;
        localTextView1.setTypeface(null, 1);
      }
      localTextView2 = localcm1.getDisclaimerTextView();
      if (localTextView2 != null)
      {
        localTextView2.setTextColor(locald.q());
        if (!locald.f())
          break label640;
        localTextView2.setTypeface(null, 1);
      }
      localc = this.d;
      localcm2 = this.c;
      localcm2.getTitleTextView().setText(localc.p());
      TextView localTextView3 = localcm2.getDisclaimerTextView();
      if (localTextView3 != null)
        localTextView3.setText(localc.g());
      TextView localTextView4 = localcm2.getDescriptionTextView();
      if (localTextView4 != null)
        localTextView4.setText(localc.f());
      localcm2.getCtaButton().setText(localc.d());
      if (!TextUtils.isEmpty(localc.a()))
        break label650;
      localcm2.getAgeRestrictionsView().setVisibility(8);
      localcm2.getDomainTextView().setText(localc.h());
      localb1 = localc.l();
      if (!"banner".equals(localc.r()))
        break label679;
      ax localax2 = localcm2.getBannerImage();
      if ((localb1 != null) && (localax2 != null))
        localax2.setImageData(localb1);
    }
    while (true)
    {
      localcm2.getRatingTextView().setText(String.valueOf(localc.t()));
      localcm2.getStarsRatingView().setRating(localc.n());
      localcm2.a(localc);
      View.OnClickListener local1 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          if (b.a(b.this) != null)
            b.a(b.this).a(localc, null);
        }
      };
      localcm2.a(localc.B(), localc.r().equals("banner"), local1);
      this.c.b();
      this.b.addView(this.c.a());
      return;
      localcm1.getTitleTextView().setTypeface(null, 0);
      break;
      label588: localcm1.getDomainTextView().setTypeface(null, 0);
      break label91;
      label602: localcm1.getRatingTextView().setTypeface(null, 0);
      break label122;
      label616: localcm1.getCtaButton().setTypeface(null, 0);
      break label224;
      label630: localTextView1.setTypeface(null, 0);
      break label260;
      label640: localTextView2.setTypeface(null, 0);
      break label296;
      label650: localcm2.getAgeRestrictionsView().setVisibility(0);
      localcm2.getAgeRestrictionsView().setText(localc.a());
      break label409;
      label679: com.my.target.common.a.b localb2 = localc.j();
      if (localb2 != null)
        localcm2.getIconImage().setImageData(localb2);
      ax localax1 = localcm2.getMainImage();
      if ((localb1 != null) && (localax1 != null))
        localax1.setImageData(localb1);
    }
  }

  public final void a(c.a parama)
  {
    this.e = parama;
  }

  public final void b()
  {
    this.c.a().setVisibility(0);
    if ((this.e != null) && (this.d != null))
      this.e.a(this.d);
  }

  public final void c()
  {
    this.c.a().setVisibility(8);
    dp.a("Stop native banner");
    this.c.c();
  }

  public final void d()
  {
    dp.a("Pause native banner");
    this.c.c();
  }

  public final void e()
  {
    dp.a("Resume native banner");
    this.c.b();
  }

  public final void f()
  {
    c();
    this.e = null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.b.d.b
 * JD-Core Version:    0.6.2
 */