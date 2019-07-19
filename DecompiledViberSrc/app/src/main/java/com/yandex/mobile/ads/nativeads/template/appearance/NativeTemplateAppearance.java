package com.yandex.mobile.ads.nativeads.template.appearance;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.yandex.mobile.ads.impl.dh;
import com.yandex.mobile.ads.nativeads.template.HorizontalOffset;
import com.yandex.mobile.ads.nativeads.template.SizeConstraint;
import com.yandex.mobile.ads.nativeads.template.SizeConstraint.SizeConstraintType;

public final class NativeTemplateAppearance
  implements Parcelable
{
  public static final Parcelable.Creator<NativeTemplateAppearance> CREATOR = new Parcelable.Creator()
  {
  };
  static final int a = Color.parseColor("#7f7f7f");
  static final int b = Color.parseColor("#ffd200");
  static final int c = Color.parseColor("#ffd200");
  static final int d = Color.parseColor("#f4c900");
  private final BannerAppearance e;
  private final TextAppearance f;
  private final TextAppearance g;
  private final TextAppearance h;
  private final TextAppearance i;
  private final TextAppearance j;
  private final TextAppearance k;
  private final TextAppearance l;
  private final ImageAppearance m;
  private final ImageAppearance n;
  private final ButtonAppearance o;
  private final RatingAppearance p;

  protected NativeTemplateAppearance(Parcel paramParcel)
  {
    this.e = ((BannerAppearance)paramParcel.readParcelable(BannerAppearance.class.getClassLoader()));
    this.f = ((TextAppearance)paramParcel.readParcelable(TextAppearance.class.getClassLoader()));
    this.g = ((TextAppearance)paramParcel.readParcelable(TextAppearance.class.getClassLoader()));
    this.h = ((TextAppearance)paramParcel.readParcelable(TextAppearance.class.getClassLoader()));
    this.i = ((TextAppearance)paramParcel.readParcelable(TextAppearance.class.getClassLoader()));
    this.j = ((TextAppearance)paramParcel.readParcelable(TextAppearance.class.getClassLoader()));
    this.k = ((TextAppearance)paramParcel.readParcelable(TextAppearance.class.getClassLoader()));
    this.l = ((TextAppearance)paramParcel.readParcelable(TextAppearance.class.getClassLoader()));
    this.m = ((ImageAppearance)paramParcel.readParcelable(ImageAppearance.class.getClassLoader()));
    this.n = ((ImageAppearance)paramParcel.readParcelable(ImageAppearance.class.getClassLoader()));
    this.o = ((ButtonAppearance)paramParcel.readParcelable(ButtonAppearance.class.getClassLoader()));
    this.p = ((RatingAppearance)paramParcel.readParcelable(RatingAppearance.class.getClassLoader()));
  }

  private NativeTemplateAppearance(Builder paramBuilder)
  {
    this.e = Builder.a(paramBuilder);
    this.f = Builder.b(paramBuilder);
    this.g = Builder.c(paramBuilder);
    this.h = Builder.d(paramBuilder);
    this.i = Builder.e(paramBuilder);
    this.j = Builder.f(paramBuilder);
    this.k = Builder.g(paramBuilder);
    this.l = Builder.h(paramBuilder);
    this.n = Builder.i(paramBuilder);
    this.m = Builder.j(paramBuilder);
    this.o = Builder.k(paramBuilder);
    this.p = Builder.l(paramBuilder);
  }

  public final int describeContents()
  {
    return 0;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    NativeTemplateAppearance localNativeTemplateAppearance;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localNativeTemplateAppearance = (NativeTemplateAppearance)paramObject;
      if (this.e != null)
      {
        if (this.e.equals(localNativeTemplateAppearance.e));
      }
      else
        while (localNativeTemplateAppearance.e != null)
          return false;
      if (this.f != null)
      {
        if (this.f.equals(localNativeTemplateAppearance.f));
      }
      else
        while (localNativeTemplateAppearance.f != null)
          return false;
      if (this.g != null)
      {
        if (this.g.equals(localNativeTemplateAppearance.g));
      }
      else
        while (localNativeTemplateAppearance.g != null)
          return false;
      if (this.h != null)
      {
        if (this.h.equals(localNativeTemplateAppearance.h));
      }
      else
        while (localNativeTemplateAppearance.h != null)
          return false;
      if (this.i != null)
      {
        if (this.i.equals(localNativeTemplateAppearance.i));
      }
      else
        while (localNativeTemplateAppearance.i != null)
          return false;
      if (this.j != null)
      {
        if (this.j.equals(localNativeTemplateAppearance.j));
      }
      else
        while (localNativeTemplateAppearance.j != null)
          return false;
      if (this.k != null)
      {
        if (this.k.equals(localNativeTemplateAppearance.k));
      }
      else
        while (localNativeTemplateAppearance.k != null)
          return false;
      if (this.l != null)
      {
        if (this.l.equals(localNativeTemplateAppearance.l));
      }
      else
        while (localNativeTemplateAppearance.l != null)
          return false;
      if (this.n != null)
      {
        if (this.n.equals(localNativeTemplateAppearance.n));
      }
      else
        while (localNativeTemplateAppearance.n != null)
          return false;
      if (this.m != null)
      {
        if (this.m.equals(localNativeTemplateAppearance.m));
      }
      else
        while (localNativeTemplateAppearance.m != null)
          return false;
      if (this.o != null)
      {
        if (this.o.equals(localNativeTemplateAppearance.o));
      }
      else
        while (localNativeTemplateAppearance.o != null)
          return false;
      if (this.p == null)
        break;
    }
    while (this.p.equals(localNativeTemplateAppearance.p));
    while (localNativeTemplateAppearance.p != null)
      return false;
    return true;
  }

  public final TextAppearance getAgeAppearance()
  {
    return this.f;
  }

  public final BannerAppearance getBannerAppearance()
  {
    return this.e;
  }

  public final TextAppearance getBodyAppearance()
  {
    return this.g;
  }

  public final ButtonAppearance getCallToActionAppearance()
  {
    return this.o;
  }

  public final TextAppearance getDomainAppearance()
  {
    return this.h;
  }

  public final ImageAppearance getFaviconAppearance()
  {
    return this.m;
  }

  public final ImageAppearance getImageAppearance()
  {
    return this.n;
  }

  public final RatingAppearance getRatingAppearance()
  {
    return this.p;
  }

  public final TextAppearance getReviewCountAppearance()
  {
    return this.i;
  }

  public final TextAppearance getSponsoredAppearance()
  {
    return this.j;
  }

  public final TextAppearance getTitleAppearance()
  {
    return this.k;
  }

  public final TextAppearance getWarningAppearance()
  {
    return this.l;
  }

  public final int hashCode()
  {
    int i1;
    int i3;
    label35: int i5;
    label59: int i7;
    label85: int i9;
    label111: int i11;
    label137: int i13;
    label163: int i15;
    label189: int i17;
    label215: int i19;
    label241: int i20;
    if (this.e != null)
    {
      i1 = this.e.hashCode();
      int i2 = i1 * 31;
      if (this.f == null)
        break label311;
      i3 = this.f.hashCode();
      int i4 = 31 * (i3 + i2);
      if (this.g == null)
        break label316;
      i5 = this.g.hashCode();
      int i6 = 31 * (i5 + i4);
      if (this.h == null)
        break label322;
      i7 = this.h.hashCode();
      int i8 = 31 * (i7 + i6);
      if (this.i == null)
        break label328;
      i9 = this.i.hashCode();
      int i10 = 31 * (i9 + i8);
      if (this.j == null)
        break label334;
      i11 = this.j.hashCode();
      int i12 = 31 * (i11 + i10);
      if (this.k == null)
        break label340;
      i13 = this.k.hashCode();
      int i14 = 31 * (i13 + i12);
      if (this.l == null)
        break label346;
      i15 = this.l.hashCode();
      int i16 = 31 * (i15 + i14);
      if (this.n == null)
        break label352;
      i17 = this.n.hashCode();
      int i18 = 31 * (i17 + i16);
      if (this.m == null)
        break label358;
      i19 = this.m.hashCode();
      i20 = 31 * (i19 + i18);
      if (this.o == null)
        break label364;
    }
    label311: label316: label322: label328: label334: label340: label346: label352: label358: label364: for (int i21 = this.o.hashCode(); ; i21 = 0)
    {
      int i22 = 31 * (i21 + i20);
      RatingAppearance localRatingAppearance = this.p;
      int i23 = 0;
      if (localRatingAppearance != null)
        i23 = this.p.hashCode();
      return i22 + i23;
      i1 = 0;
      break;
      i3 = 0;
      break label35;
      i5 = 0;
      break label59;
      i7 = 0;
      break label85;
      i9 = 0;
      break label111;
      i11 = 0;
      break label137;
      i13 = 0;
      break label163;
      i15 = 0;
      break label189;
      i17 = 0;
      break label215;
      i19 = 0;
      break label241;
    }
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.e, paramInt);
    paramParcel.writeParcelable(this.f, paramInt);
    paramParcel.writeParcelable(this.g, paramInt);
    paramParcel.writeParcelable(this.h, paramInt);
    paramParcel.writeParcelable(this.i, paramInt);
    paramParcel.writeParcelable(this.j, paramInt);
    paramParcel.writeParcelable(this.k, paramInt);
    paramParcel.writeParcelable(this.l, paramInt);
    paramParcel.writeParcelable(this.m, paramInt);
    paramParcel.writeParcelable(this.n, paramInt);
    paramParcel.writeParcelable(this.o, paramInt);
    paramParcel.writeParcelable(this.p, paramInt);
  }

  public static final class Builder
  {
    private BannerAppearance a = new BannerAppearance.Builder().setBackgroundColor(-1).setBorderColor(dh.a(-16777216, 90.0F)).setBorderWidth(1.0F).setContentPadding(new HorizontalOffset(10.0F, 10.0F)).setImageMargins(new HorizontalOffset(0.0F, 10.0F)).build();
    private TextAppearance b = new TextAppearance.Builder().setTextColor(NativeTemplateAppearance.a).setTextSize(15.0F).setFontFamilyName(null).setFontStyle(0).build();
    private TextAppearance c = new TextAppearance.Builder().setTextColor(-16777216).setTextSize(13.0F).setFontFamilyName(null).setFontStyle(0).build();
    private TextAppearance d = new TextAppearance.Builder().setTextColor(NativeTemplateAppearance.a).setTextSize(13.0F).setFontFamilyName(null).setFontStyle(0).build();
    private TextAppearance e = new TextAppearance.Builder().setTextColor(NativeTemplateAppearance.a).setTextSize(13.0F).setFontFamilyName(null).setFontStyle(0).build();
    private TextAppearance f = new TextAppearance.Builder().setTextColor(NativeTemplateAppearance.a).setTextSize(11.0F).setFontFamilyName(null).setFontStyle(0).build();
    private TextAppearance g = new TextAppearance.Builder().setTextColor(-16777216).setTextSize(15.0F).setFontFamilyName(null).setFontStyle(1).build();
    private TextAppearance h = new TextAppearance.Builder().setTextColor(NativeTemplateAppearance.a).setTextSize(13.0F).setFontFamilyName(null).setFontStyle(0).build();
    private ImageAppearance i = new ImageAppearance.Builder().setWidthConstraint(new SizeConstraint(SizeConstraint.SizeConstraintType.PREFERRED_RATIO, 0.3F)).build();
    private ImageAppearance j = new ImageAppearance.Builder().setWidthConstraint(new SizeConstraint(SizeConstraint.SizeConstraintType.FIXED, 16.0F)).build();
    private ButtonAppearance k = new ButtonAppearance.Builder().setBorderColor(NativeTemplateAppearance.b).setBorderWidth(1.0F).setNormalColor(-1).setPressedColor(NativeTemplateAppearance.c).setTextAppearance(new TextAppearance.Builder().setTextColor(-16777216).setTextSize(13.0F).setFontFamilyName(null).setFontStyle(0).build()).build();
    private RatingAppearance l = new RatingAppearance.Builder().setBackgroundStarColor(-3355444).setProgressStarColor(NativeTemplateAppearance.d).build();

    public final NativeTemplateAppearance build()
    {
      return new NativeTemplateAppearance(this, (byte)0);
    }

    public final Builder withAgeAppearance(TextAppearance paramTextAppearance)
    {
      this.b = a.a(this.b, paramTextAppearance);
      return this;
    }

    public final Builder withBannerAppearance(BannerAppearance paramBannerAppearance)
    {
      BannerAppearance localBannerAppearance1 = this.a;
      BannerAppearance localBannerAppearance2;
      if ((paramBannerAppearance == null) || (localBannerAppearance1.equals(paramBannerAppearance)))
      {
        localBannerAppearance2 = localBannerAppearance1;
        this.a = localBannerAppearance2;
        return this;
      }
      int m = paramBannerAppearance.getBackgroundColor();
      int n = paramBannerAppearance.getBorderColor();
      float f1 = paramBannerAppearance.getBorderWidth();
      HorizontalOffset localHorizontalOffset1 = paramBannerAppearance.getImageMargins();
      BannerAppearance.Builder localBuilder1 = new BannerAppearance.Builder();
      label64: int i1;
      label82: float f2;
      label102: HorizontalOffset localHorizontalOffset2;
      HorizontalOffset localHorizontalOffset3;
      BannerAppearance.Builder localBuilder5;
      if (m != 0)
      {
        BannerAppearance.Builder localBuilder2 = localBuilder1.setBackgroundColor(m);
        if (n == 0)
          break label179;
        i1 = n;
        BannerAppearance.Builder localBuilder3 = localBuilder2.setBorderColor(i1);
        if (f1 < 0.0F)
          break label188;
        f2 = f1;
        BannerAppearance.Builder localBuilder4 = localBuilder3.setBorderWidth(f2);
        localHorizontalOffset2 = localBannerAppearance1.getContentPadding();
        localHorizontalOffset3 = paramBannerAppearance.getContentPadding();
        if ((localHorizontalOffset3 != null) && (!localHorizontalOffset2.equals(localHorizontalOffset3)))
          break label197;
        localBuilder5 = localBuilder4.setContentPadding(localHorizontalOffset2);
        if (localHorizontalOffset1 == null)
          break label260;
      }
      label260: for (HorizontalOffset localHorizontalOffset4 = localHorizontalOffset1; ; localHorizontalOffset4 = localBannerAppearance1.getImageMargins())
      {
        localBannerAppearance2 = localBuilder5.setImageMargins(localHorizontalOffset4).build();
        break;
        m = localBannerAppearance1.getBackgroundColor();
        break label64;
        label179: i1 = localBannerAppearance1.getBorderColor();
        break label82;
        label188: f2 = localBannerAppearance1.getBorderWidth();
        break label102;
        label197: if (localHorizontalOffset3.getLeft() >= 0.0F);
        for (float f3 = localHorizontalOffset3.getLeft(); ; f3 = 0.0F)
        {
          boolean bool = localHorizontalOffset3.getRight() < 0.0F;
          float f4 = 0.0F;
          if (!bool)
            f4 = localHorizontalOffset3.getRight();
          localHorizontalOffset2 = new HorizontalOffset(f3, f4);
          break;
        }
      }
    }

    public final Builder withBodyAppearance(TextAppearance paramTextAppearance)
    {
      this.c = a.a(this.c, paramTextAppearance);
      return this;
    }

    public final Builder withCallToActionAppearance(ButtonAppearance paramButtonAppearance)
    {
      ButtonAppearance localButtonAppearance1 = this.k;
      ButtonAppearance localButtonAppearance2;
      if ((paramButtonAppearance == null) || (localButtonAppearance1.equals(paramButtonAppearance)))
      {
        localButtonAppearance2 = localButtonAppearance1;
        this.k = localButtonAppearance2;
        return this;
      }
      TextAppearance localTextAppearance = a.a(localButtonAppearance1.getTextAppearance(), paramButtonAppearance.getTextAppearance());
      int m = paramButtonAppearance.getBorderColor();
      float f1 = paramButtonAppearance.getBorderWidth();
      int n = paramButtonAppearance.getNormalColor();
      int i1 = paramButtonAppearance.getPressedColor();
      ButtonAppearance.Builder localBuilder1 = new ButtonAppearance.Builder().setTextAppearance(localTextAppearance);
      label82: float f2;
      label102: int i2;
      label120: ButtonAppearance.Builder localBuilder4;
      if (m != 0)
      {
        ButtonAppearance.Builder localBuilder2 = localBuilder1.setBorderColor(m);
        if (f1 < 0.0F)
          break label161;
        f2 = f1;
        ButtonAppearance.Builder localBuilder3 = localBuilder2.setBorderWidth(f2);
        if (n == 0)
          break label170;
        i2 = n;
        localBuilder4 = localBuilder3.setNormalColor(i2);
        if (i1 == 0)
          break label179;
      }
      label161: label170: label179: for (int i3 = i1; ; i3 = localButtonAppearance1.getPressedColor())
      {
        localButtonAppearance2 = localBuilder4.setPressedColor(i3).build();
        break;
        m = localButtonAppearance1.getBorderColor();
        break label82;
        f2 = localButtonAppearance1.getBorderWidth();
        break label102;
        i2 = localButtonAppearance1.getNormalColor();
        break label120;
      }
    }

    public final Builder withDomainAppearance(TextAppearance paramTextAppearance)
    {
      this.d = a.a(this.d, paramTextAppearance);
      return this;
    }

    public final Builder withFaviconAppearance(ImageAppearance paramImageAppearance)
    {
      this.j = a.a(this.j, paramImageAppearance);
      return this;
    }

    public final Builder withImageAppearance(ImageAppearance paramImageAppearance)
    {
      this.i = a.a(this.i, paramImageAppearance);
      return this;
    }

    public final Builder withRatingAppearance(RatingAppearance paramRatingAppearance)
    {
      RatingAppearance localRatingAppearance1 = this.l;
      RatingAppearance localRatingAppearance2;
      if ((paramRatingAppearance == null) || (localRatingAppearance1.equals(paramRatingAppearance)))
      {
        localRatingAppearance2 = localRatingAppearance1;
        this.l = localRatingAppearance2;
        return this;
      }
      int m = paramRatingAppearance.getBackgroundStarColor();
      int n = paramRatingAppearance.getProgressStarColor();
      RatingAppearance.Builder localBuilder1 = new RatingAppearance.Builder();
      label52: RatingAppearance.Builder localBuilder2;
      if (m != 0)
      {
        localBuilder2 = localBuilder1.setBackgroundStarColor(m);
        if (n == 0)
          break label93;
      }
      label93: for (int i1 = n; ; i1 = localRatingAppearance1.getProgressStarColor())
      {
        localRatingAppearance2 = localBuilder2.setProgressStarColor(i1).build();
        break;
        m = localRatingAppearance1.getBackgroundStarColor();
        break label52;
      }
    }

    public final Builder withReviewCountAppearance(TextAppearance paramTextAppearance)
    {
      this.e = a.a(this.e, paramTextAppearance);
      return this;
    }

    public final Builder withSponsoredAppearance(TextAppearance paramTextAppearance)
    {
      this.f = a.a(this.f, paramTextAppearance);
      return this;
    }

    public final Builder withTitleAppearance(TextAppearance paramTextAppearance)
    {
      this.g = a.a(this.g, paramTextAppearance);
      return this;
    }

    public final Builder withWarningAppearance(TextAppearance paramTextAppearance)
    {
      this.h = a.a(this.h, paramTextAppearance);
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.template.appearance.NativeTemplateAppearance
 * JD-Core Version:    0.6.2
 */