package com.yandex.mobile.ads.nativeads.template;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build.VERSION;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.yandex.mobile.ads.impl.dh;
import com.yandex.mobile.ads.impl.x;
import com.yandex.mobile.ads.nativeads.MediaView;
import com.yandex.mobile.ads.nativeads.NativeAdAssets;
import com.yandex.mobile.ads.nativeads.NativeAdException;
import com.yandex.mobile.ads.nativeads.NativeAdImage;
import com.yandex.mobile.ads.nativeads.NativeAdImageLoadingListener;
import com.yandex.mobile.ads.nativeads.NativeAdMedia;
import com.yandex.mobile.ads.nativeads.NativeAdType;
import com.yandex.mobile.ads.nativeads.NativeGenericAd;
import com.yandex.mobile.ads.nativeads.ae;
import com.yandex.mobile.ads.nativeads.aw;
import com.yandex.mobile.ads.nativeads.template.appearance.BannerAppearance;
import com.yandex.mobile.ads.nativeads.template.appearance.ButtonAppearance;
import com.yandex.mobile.ads.nativeads.template.appearance.ImageAppearance;
import com.yandex.mobile.ads.nativeads.template.appearance.NativeTemplateAppearance;
import com.yandex.mobile.ads.nativeads.template.appearance.NativeTemplateAppearance.Builder;
import com.yandex.mobile.ads.nativeads.template.appearance.RatingAppearance;
import com.yandex.mobile.ads.nativeads.template.appearance.TextAppearance;
import com.yandex.mobile.ads.nativeads.w;
import java.util.Arrays;

public final class NativeBannerView extends ae<aw>
{
  private static final int a = Color.parseColor("#eaeaea");
  private NativeAdType A;
  private NativeAdAssets B;
  private e C;
  private d D;
  private NativeGenericAd E;
  private b F;
  private final NativeAdImageLoadingListener G = new NativeAdImageLoadingListener()
  {
    public final void onFinishLoadingImages()
    {
      if (NativeBannerView.a(NativeBannerView.this) != null)
        NativeBannerView.a(NativeBannerView.this).removeImageLoadingListener(this);
      NativeBannerView.b(NativeBannerView.this).a();
    }
  };
  private NativeTemplateAppearance b;
  private TextView c;
  private TextView d;
  private Button e;
  private TextView f;
  private ImageView g;
  private g h;
  private TextView i;
  private TextView j;
  private ImageView k;
  private f l;
  private TextView m;
  private ImageView n;
  private ImageView o;
  private LinearLayout p;
  private final int q = dh.a(getContext(), 4.0F);
  private final int r = dh.a(getContext(), 8.0F);
  private final int s = dh.a(getContext(), 12.0F);
  private LinearLayout t;
  private LinearLayout u;
  private LinearLayout v;
  private ImageView w;
  private LinearLayout x;
  private MediaView y;
  private LinearLayout z;

  public NativeBannerView(Context paramContext)
  {
    super(paramContext);
    n();
  }

  public NativeBannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    n();
  }

  public NativeBannerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    n();
  }

  private TextView A()
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    localTextView.setMaxLines(1);
    localTextView.setGravity(8388613);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.leftMargin = this.q;
    localTextView.setLayoutParams(localLayoutParams);
    return localTextView;
  }

  private View B()
  {
    this.u = new LinearLayout(getContext());
    this.u.setOrientation(0);
    this.u.setBaselineAligned(false);
    View localView1 = D();
    View localView2 = G();
    this.u.addView(localView1);
    this.u.addView(localView2);
    return this.u;
  }

  private View C()
  {
    this.v = new LinearLayout(getContext());
    this.v.setOrientation(0);
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams1.topMargin = this.r;
    this.v.setLayoutParams(localLayoutParams1);
    LinearLayout localLinearLayout1 = new LinearLayout(getContext());
    localLinearLayout1.setOrientation(1);
    localLinearLayout1.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    f localf = new f(getContext());
    localf.setNumStars(5);
    localf.setStepSize(0.5F);
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams2.rightMargin = this.r;
    localf.setLayoutParams(localLayoutParams2);
    this.l = localf;
    TextView localTextView = new TextView(getContext());
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    localTextView.setMaxLines(1);
    localTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    this.m = localTextView;
    localLinearLayout1.addView(this.l);
    localLinearLayout1.addView(this.m);
    LinearLayout localLinearLayout2 = new LinearLayout(getContext());
    localLinearLayout2.setOrientation(0);
    localLinearLayout2.setGravity(5);
    localLinearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    if (Build.VERSION.SDK_INT >= 11);
    for (Button localButton = new Button(getContext(), null, 16843563); ; localButton = new Button(getContext()))
    {
      localButton.setEllipsize(TextUtils.TruncateAt.END);
      localButton.setMaxLines(1);
      localButton.setTransformationMethod(null);
      int i1 = dh.a(getContext(), 26.0F);
      localButton.setMinimumHeight(i1);
      localButton.setMinHeight(i1);
      localButton.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      this.e = localButton;
      localLinearLayout2.addView(this.e);
      this.v.addView(localLinearLayout1);
      this.v.addView(localLinearLayout2);
      return this.v;
    }
  }

  private View D()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = this.q;
    FrameLayout localFrameLayout = new FrameLayout(getContext());
    localFrameLayout.setLayoutParams(localLayoutParams);
    this.k = F();
    this.g = F();
    this.n = E();
    localFrameLayout.addView(this.k);
    localFrameLayout.addView(this.g);
    localFrameLayout.addView(this.n);
    return localFrameLayout;
  }

  private ImageView E()
  {
    ImageView localImageView = new ImageView(getContext());
    localImageView.setAdjustViewBounds(true);
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    return localImageView;
  }

  private ImageView F()
  {
    ImageView localImageView = new ImageView(getContext());
    localImageView.setAdjustViewBounds(true);
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    return localImageView;
  }

  private View G()
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    localLinearLayout.setOrientation(1);
    this.i = H();
    this.d = I();
    this.f = J();
    localLinearLayout.addView(this.i);
    localLinearLayout.addView(this.d);
    localLinearLayout.addView(this.f);
    localLinearLayout.addView(C());
    return localLinearLayout;
  }

  private TextView H()
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    localTextView.setMaxLines(2);
    localTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    return localTextView;
  }

  private TextView I()
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    localTextView.setMaxLines(3);
    localTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    return localTextView;
  }

  private TextView J()
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    localTextView.setMaxLines(1);
    localTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    return localTextView;
  }

  private View K()
  {
    this.j = L();
    return this.j;
  }

  private TextView L()
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    return localTextView;
  }

  private void M()
  {
    N();
    O();
    Q();
    R();
    invalidate();
    requestLayout();
  }

  private void N()
  {
    Z();
    aa();
    ab();
    ac();
  }

  private void O()
  {
    this.e.setTextColor(this.b.getCallToActionAppearance().getTextAppearance().getTextColor());
    this.e.setTextSize(this.b.getCallToActionAppearance().getTextAppearance().getTextSize());
    this.e.setTypeface(Typeface.create(this.b.getCallToActionAppearance().getTextAppearance().getFontFamilyName(), this.b.getCallToActionAppearance().getTextAppearance().getFontStyle()));
    P();
  }

  private void P()
  {
    float f1 = dh.a(getContext(), 5.0F);
    float[] arrayOfFloat = new float[8];
    Arrays.fill(arrayOfFloat, f1);
    RoundRectShape localRoundRectShape = new RoundRectShape(arrayOfFloat, null, arrayOfFloat);
    ShapeDrawable localShapeDrawable1 = new ShapeDrawable(localRoundRectShape);
    localShapeDrawable1.getPaint().setColor(this.b.getCallToActionAppearance().getPressedColor());
    ShapeDrawable localShapeDrawable2 = new ShapeDrawable(localRoundRectShape);
    localShapeDrawable2.getPaint().setColor(this.b.getCallToActionAppearance().getNormalColor());
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842913 }, localShapeDrawable1);
    localStateListDrawable.addState(new int[] { 16842919 }, localShapeDrawable1);
    localStateListDrawable.addState(new int[0], localShapeDrawable2);
    int i1 = dh.a(getContext(), this.b.getCallToActionAppearance().getBorderWidth());
    ShapeDrawable localShapeDrawable3 = new ShapeDrawable();
    localShapeDrawable3.setShape(localRoundRectShape);
    Paint localPaint = localShapeDrawable3.getPaint();
    localPaint.setColor(this.b.getCallToActionAppearance().getBorderColor());
    localPaint.setStrokeWidth(i1);
    localPaint.setStyle(Paint.Style.STROKE);
    LayerDrawable localLayerDrawable = new LayerDrawable(new Drawable[] { localStateListDrawable, localShapeDrawable3 });
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.e.setBackground(localLayerDrawable);
      return;
    }
    this.e.setBackgroundDrawable(localLayerDrawable);
  }

  private void Q()
  {
    LayerDrawable localLayerDrawable = (LayerDrawable)this.l.getProgressDrawable();
    localLayerDrawable.getDrawable(2).setColorFilter(this.b.getRatingAppearance().getProgressStarColor(), PorterDuff.Mode.SRC_ATOP);
    localLayerDrawable.getDrawable(1).setColorFilter(this.b.getRatingAppearance().getBackgroundStarColor(), PorterDuff.Mode.SRC_ATOP);
    localLayerDrawable.getDrawable(0).setColorFilter(this.b.getRatingAppearance().getBackgroundStarColor(), PorterDuff.Mode.SRC_ATOP);
  }

  private void R()
  {
    S();
    T();
    U();
    V();
    W();
    X();
    Y();
  }

  private void S()
  {
    this.c.setTypeface(Typeface.create(this.b.getAgeAppearance().getFontFamilyName(), this.b.getAgeAppearance().getFontStyle()));
    this.c.setTextColor(this.b.getAgeAppearance().getTextColor());
    this.c.setTextSize(2, this.b.getAgeAppearance().getTextSize());
  }

  private void T()
  {
    this.d.setTypeface(Typeface.create(this.b.getBodyAppearance().getFontFamilyName(), this.b.getBodyAppearance().getFontStyle()));
    this.d.setTextColor(this.b.getBodyAppearance().getTextColor());
    this.d.setTextSize(2, this.b.getBodyAppearance().getTextSize());
  }

  private void U()
  {
    this.f.setTypeface(Typeface.create(this.b.getDomainAppearance().getFontFamilyName(), this.b.getDomainAppearance().getFontStyle()));
    this.f.setTextColor(this.b.getDomainAppearance().getTextColor());
    this.f.setTextSize(2, this.b.getDomainAppearance().getTextSize());
  }

  private void V()
  {
    this.m.setTypeface(Typeface.create(this.b.getReviewCountAppearance().getFontFamilyName(), this.b.getReviewCountAppearance().getFontStyle()));
    this.m.setTextColor(this.b.getReviewCountAppearance().getTextColor());
    this.m.setTextSize(2, this.b.getReviewCountAppearance().getTextSize());
  }

  private void W()
  {
    this.h.setTypeface(Typeface.create(this.b.getSponsoredAppearance().getFontFamilyName(), this.b.getSponsoredAppearance().getFontStyle()));
    this.h.setTextColor(this.b.getSponsoredAppearance().getTextColor());
    this.h.setTextSize(2, this.b.getSponsoredAppearance().getTextSize());
  }

  private void X()
  {
    this.i.setTypeface(Typeface.create(this.b.getTitleAppearance().getFontFamilyName(), this.b.getTitleAppearance().getFontStyle()));
    this.i.setTextColor(this.b.getTitleAppearance().getTextColor());
    this.i.setTextSize(2, this.b.getTitleAppearance().getTextSize());
  }

  private void Y()
  {
    this.j.setTypeface(Typeface.create(this.b.getWarningAppearance().getFontFamilyName(), this.b.getWarningAppearance().getFontStyle()));
    this.j.setTextColor(this.b.getWarningAppearance().getTextColor());
    this.j.setTextSize(2, this.b.getWarningAppearance().getTextSize());
  }

  private void Z()
  {
    float f1 = this.b.getBannerAppearance().getBorderWidth();
    int i1 = dh.a(getContext(), f1);
    ShapeDrawable localShapeDrawable1 = new ShapeDrawable();
    localShapeDrawable1.setShape(new RectShape());
    Paint localPaint1 = localShapeDrawable1.getPaint();
    localPaint1.setColor(this.b.getBannerAppearance().getBackgroundColor());
    localPaint1.setStyle(Paint.Style.FILL);
    ShapeDrawable localShapeDrawable2 = new ShapeDrawable();
    localShapeDrawable2.setShape(new RectShape());
    Paint localPaint2 = localShapeDrawable2.getPaint();
    localPaint2.setColor(this.b.getBannerAppearance().getBorderColor());
    localPaint2.setStrokeWidth(2.0F * i1);
    localPaint2.setStyle(Paint.Style.STROKE);
    LayerDrawable localLayerDrawable = new LayerDrawable(new Drawable[] { localShapeDrawable1, localShapeDrawable2 });
    if (Build.VERSION.SDK_INT >= 16)
      setBackground(localLayerDrawable);
    while (true)
    {
      setPadding(i1, i1, i1, i1);
      return;
      setBackgroundDrawable(localLayerDrawable);
    }
  }

  private static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 != 0)
      paramInt3 = Math.round(paramInt1 / paramInt2 * paramInt3);
    return paramInt3;
  }

  private FrameLayout.LayoutParams a(NativeAdImage paramNativeAdImage, int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = paramNativeAdImage.getWidth();
    int i2 = paramNativeAdImage.getHeight();
    a.d locald = a(this.b.getImageAppearance().getWidthConstraint()).a(getContext(), paramInt1, i1, i2);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(locald.a(), locald.b());
    localLayoutParams.leftMargin = paramInt2;
    localLayoutParams.rightMargin = paramInt3;
    return localLayoutParams;
  }

  private static a a(SizeConstraint paramSizeConstraint)
  {
    switch (2.a[paramSizeConstraint.getSizeConstraintType().ordinal()])
    {
    default:
      return new a.c(paramSizeConstraint.getValue());
    case 1:
      return new a.a(paramSizeConstraint.getValue());
    case 2:
      return new a.b(paramSizeConstraint.getValue());
    case 3:
    }
    return new a.c(paramSizeConstraint.getValue());
  }

  private void a(int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.u.getLayoutParams();
    localLayoutParams.leftMargin = paramInt;
    this.u.setLayoutParams(localLayoutParams);
  }

  private void aa()
  {
    int i1 = dh.a(getContext(), this.b.getBannerAppearance().getContentPadding().getLeft());
    int i2 = dh.a(getContext(), this.b.getBannerAppearance().getContentPadding().getRight());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.setMargins(i1, this.r, i2, this.q);
    this.t.setLayoutParams(localLayoutParams);
    this.t.invalidate();
  }

  private void ab()
  {
    int i1 = dh.a(getContext(), this.b.getBannerAppearance().getContentPadding().getLeft());
    int i2 = dh.a(getContext(), this.b.getBannerAppearance().getContentPadding().getRight());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.leftMargin = i1;
    localLayoutParams.rightMargin = i2;
    localLayoutParams.bottomMargin = this.q;
    this.u.setLayoutParams(localLayoutParams);
    this.u.invalidate();
  }

  private void ac()
  {
    int i1 = dh.a(getContext(), this.b.getBannerAppearance().getContentPadding().getLeft());
    int i2 = dh.a(getContext(), this.b.getBannerAppearance().getContentPadding().getRight());
    this.j.setPadding(i1, this.q, i2, this.q);
    this.j.invalidate();
  }

  private void n()
  {
    this.b = new NativeTemplateAppearance.Builder().build();
    this.o = F();
    this.p = p();
    addView(this.o, new ViewGroup.LayoutParams(-1, -2));
    addView(this.p, new ViewGroup.LayoutParams(-1, -1));
    o();
    ImageView[] arrayOfImageView = new ImageView[5];
    arrayOfImageView[0] = this.n;
    arrayOfImageView[1] = this.k;
    arrayOfImageView[2] = this.g;
    arrayOfImageView[3] = this.w;
    arrayOfImageView[4] = this.o;
    this.F = new b(arrayOfImageView);
    M();
  }

  private void o()
  {
    this.o.setVisibility(8);
    this.p.setVisibility(8);
  }

  private LinearLayout p()
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(1);
    View localView1 = v();
    View localView2 = B();
    View localView3 = q();
    View localView4 = r();
    View localView5 = K();
    localLinearLayout.addView(localView1);
    localLinearLayout.addView(localView2);
    localLinearLayout.addView(localView3);
    localLinearLayout.addView(localView4);
    localLinearLayout.addView(localView5);
    return localLinearLayout;
  }

  private View q()
  {
    this.x = s();
    this.w = t();
    this.x.addView(this.w);
    return this.x;
  }

  private View r()
  {
    this.z = s();
    this.y = u();
    this.z.addView(this.y);
    return this.z;
  }

  private LinearLayout s()
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(0);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    return localLinearLayout;
  }

  private ImageView t()
  {
    ImageView localImageView = new ImageView(getContext());
    localImageView.setAdjustViewBounds(true);
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localImageView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    return localImageView;
  }

  private MediaView u()
  {
    MediaView localMediaView = new MediaView(getContext());
    localMediaView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    return localMediaView;
  }

  private View v()
  {
    this.t = new LinearLayout(getContext());
    this.t.setOrientation(0);
    this.t.setGravity(17);
    this.t.setWeightSum(4.0F);
    View localView1 = w();
    View localView2 = x();
    View localView3 = z();
    this.t.addView(localView1);
    this.t.addView(localView2);
    this.t.addView(localView3);
    return this.t;
  }

  private View w()
  {
    View localView = new View(getContext());
    localView.setLayoutParams(new LinearLayout.LayoutParams(0, 0, 1.0F));
    return localView;
  }

  private View x()
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setGravity(17);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 2.0F));
    this.h = y();
    localLinearLayout.addView(this.h);
    return localLinearLayout;
  }

  private g y()
  {
    g localg = new g(getContext());
    localg.setEllipsize(TextUtils.TruncateAt.END);
    localg.setMaxLines(1);
    localg.setGravity(17);
    localg.setPadding(0, 0, 0, dh.a(getContext(), 4.0F));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    localg.setLayoutParams(localLayoutParams);
    return localg;
  }

  private View z()
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0F));
    this.c = A();
    localLinearLayout.addView(this.c);
    return localLinearLayout;
  }

  final TextView a()
  {
    return this.c;
  }

  public final void applyAppearance(NativeTemplateAppearance paramNativeTemplateAppearance)
  {
    if ((paramNativeTemplateAppearance != null) && (!paramNativeTemplateAppearance.equals(this.b)))
    {
      this.b = paramNativeTemplateAppearance;
      M();
    }
  }

  final TextView b()
  {
    return this.d;
  }

  final Button c()
  {
    return this.e;
  }

  final TextView d()
  {
    return this.f;
  }

  final ImageView e()
  {
    ImageView localImageView = this.g;
    NativeAdImage localNativeAdImage;
    if (this.D != null)
    {
      localNativeAdImage = this.B.getImage();
      if (localNativeAdImage != null)
      {
        if (!d.b(localNativeAdImage))
          break label38;
        localImageView = this.o;
      }
    }
    label38: 
    while (!d.a(localNativeAdImage))
      return localImageView;
    return this.w;
  }

  final MediaView f()
  {
    return this.y;
  }

  final TextView g()
  {
    return this.h;
  }

  final TextView h()
  {
    return this.i;
  }

  final TextView i()
  {
    return this.j;
  }

  final ImageView j()
  {
    return this.k;
  }

  final View k()
  {
    return this.l;
  }

  final TextView l()
  {
    return this.m;
  }

  final ImageView m()
  {
    return this.n;
  }

  protected final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.E != null)
      this.E.addImageLoadingListener(this.G);
  }

  protected final void onDetachedFromWindow()
  {
    if (this.E != null)
      this.E.removeImageLoadingListener(this.G);
    super.onDetachedFromWindow();
  }

  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    int i1;
    int i2;
    int i4;
    label397: int i8;
    int i9;
    int i10;
    label475: int i11;
    int i12;
    label507: int i13;
    label545: LinearLayout.LayoutParams localLayoutParams7;
    label816: LinearLayout.LayoutParams localLayoutParams6;
    label911: label933: label942: TextView localTextView;
    if (this.D != null)
    {
      i1 = View.MeasureSpec.getSize(paramInt1);
      d locald1 = this.D;
      Context localContext = getContext();
      i2 = dh.a(localContext, this.b.getBannerAppearance().getContentPadding().getLeft());
      int i3 = dh.a(localContext, this.b.getBannerAppearance().getContentPadding().getRight());
      if ((!locald1.a()) && (!locald1.b()) && (!locald1.c()))
        break label1031;
      i4 = 1;
      if (i4 == 0)
        break label1037;
      int i14 = Math.round(i1 - i2 - i3);
      int i15 = dh.a(getContext(), this.b.getBannerAppearance().getImageMargins().getLeft()) + dh.a(getContext(), this.b.getBannerAppearance().getContentPadding().getLeft());
      int i16 = dh.a(getContext(), this.b.getBannerAppearance().getImageMargins().getRight());
      FrameLayout.LayoutParams localLayoutParams9 = new FrameLayout.LayoutParams(0, 0);
      if (locald1.a())
      {
        NativeAdImage localNativeAdImage3 = this.B.getFavicon();
        int i17 = localNativeAdImage3.getWidth();
        int i18 = localNativeAdImage3.getHeight();
        a.d locald = a(this.b.getFaviconAppearance().getWidthConstraint()).a(getContext(), i14, i17, i18);
        int i19 = dh.a(getContext(), 5.0F);
        localLayoutParams9 = new FrameLayout.LayoutParams(locald.a(), locald.b());
        localLayoutParams9.leftMargin = i15;
        localLayoutParams9.rightMargin = i19;
      }
      this.n.setLayoutParams(localLayoutParams9);
      FrameLayout.LayoutParams localLayoutParams10 = new FrameLayout.LayoutParams(0, 0);
      if (locald1.b())
        localLayoutParams10 = a(this.B.getIcon(), i14, i15, i16);
      this.k.setLayoutParams(localLayoutParams10);
      FrameLayout.LayoutParams localLayoutParams11 = new FrameLayout.LayoutParams(0, 0);
      if (locald1.c())
        localLayoutParams11 = a(this.B.getImage(), i14, i15, i16);
      this.g.setLayoutParams(localLayoutParams11);
      a(0);
      Object localObject = new LinearLayout.LayoutParams(0, 0);
      if (locald1.d())
      {
        NativeAdImage localNativeAdImage2 = this.B.getImage();
        i8 = localNativeAdImage2.getWidth();
        i9 = localNativeAdImage2.getHeight();
        float f1 = localNativeAdImage2.getWidth();
        float f2 = localNativeAdImage2.getHeight();
        if ((f2 == 0.0F) || (f1 / f2 >= 1.0F))
          break label1084;
        i10 = 1;
        if (i10 == 0)
          break label1090;
        i11 = Math.round(i1 * 3 / 4);
        i12 = Math.round(i11 / i9 * i8);
        float f3 = localNativeAdImage2.getWidth();
        float f4 = localNativeAdImage2.getHeight();
        if ((f4 == 0.0F) || (f3 / f4 <= 1.5F))
          break label1106;
        i13 = 1;
        if (i13 == 0)
          i11 = Math.round(0.8F * i11);
        LinearLayout.LayoutParams localLayoutParams8 = new LinearLayout.LayoutParams(i12, i11);
        localLayoutParams8.topMargin = this.q;
        localLayoutParams8.gravity = 1;
        localObject = localLayoutParams8;
      }
      this.x.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (Build.VERSION.SDK_INT <= 17)
      {
        FrameLayout.LayoutParams localLayoutParams2 = new FrameLayout.LayoutParams(0, 0);
        if (locald1.e())
        {
          NativeAdImage localNativeAdImage1 = this.B.getImage();
          localLayoutParams2 = new FrameLayout.LayoutParams(i1, a(i1, localNativeAdImage1.getWidth(), localNativeAdImage1.getHeight()));
        }
        this.o.setLayoutParams(localLayoutParams2);
      }
      d locald2 = this.D;
      LinearLayout.LayoutParams localLayoutParams3 = new LinearLayout.LayoutParams(0, 0);
      NativeAdMedia localNativeAdMedia = this.B.getMedia();
      if ((localNativeAdMedia != null) && (locald2.f()))
        localLayoutParams3 = new LinearLayout.LayoutParams(i1, new x(localNativeAdMedia.getAspectRatio()).b(i1));
      this.z.setLayoutParams(localLayoutParams3);
      if (!this.C.c())
        break label1224;
      if (!this.C.b())
        break label1124;
      ((ViewManager)this.v.getParent()).removeView(this.v);
      localLayoutParams7 = new LinearLayout.LayoutParams(-1, -2);
      if (!this.C.a())
        break label1112;
      localLayoutParams7.topMargin = this.s;
      localLayoutParams7.bottomMargin = this.r;
      this.v.setLayoutParams(localLayoutParams7);
      int i6 = dh.a(getContext(), this.b.getBannerAppearance().getContentPadding().getLeft());
      int i7 = dh.a(getContext(), this.b.getBannerAppearance().getContentPadding().getRight());
      this.v.setPadding(i6, 0, i7, 0);
      this.p.addView(this.v, -1 + this.p.getChildCount());
      if (!this.C.d())
        break label1208;
      localLayoutParams6 = new LinearLayout.LayoutParams(-1, -2);
      this.e.setLayoutParams(localLayoutParams6);
      int i5 = Math.round(0.4F * i1);
      this.e.setMinWidth(i5);
      this.e.setMinimumWidth(i5);
      if (this.C.f())
      {
        localTextView = this.j;
        if (!this.C.e())
          break label1243;
        localTextView.setBackgroundColor(0);
      }
    }
    while (true)
    {
      LinearLayout.LayoutParams localLayoutParams4 = new LinearLayout.LayoutParams(-1, -2);
      this.j.setLayoutParams(localLayoutParams4);
      super.onMeasure(paramInt1, paramInt2);
      return;
      label1031: i4 = 0;
      break;
      label1037: FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(0, 0);
      this.n.setLayoutParams(localLayoutParams1);
      this.k.setLayoutParams(localLayoutParams1);
      this.g.setLayoutParams(localLayoutParams1);
      a(i2);
      break label397;
      label1084: i10 = 0;
      break label475;
      label1090: i11 = a(i1, i8, i9);
      i12 = i1;
      break label507;
      label1106: i13 = 0;
      break label545;
      label1112: localLayoutParams7.topMargin = this.q;
      break label816;
      label1124: ((ViewManager)this.v.getParent()).removeView(this.v);
      this.v.setPadding(0, 0, 0, 0);
      LinearLayout.LayoutParams localLayoutParams5 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams5.topMargin = this.r;
      localLayoutParams5.bottomMargin = this.r;
      ((ViewManager)this.f.getParent()).addView(this.v, localLayoutParams5);
      break label911;
      label1208: localLayoutParams6 = new LinearLayout.LayoutParams(-2, -2);
      break label933;
      label1224: this.v.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
      break label942;
      label1243: localTextView.setBackgroundColor(dh.a(localTextView.getCurrentTextColor(), 92.0F));
    }
  }

  public final void setAd(NativeGenericAd paramNativeGenericAd)
  {
    if (this.E != paramNativeGenericAd);
    while (true)
    {
      try
      {
        if (this.E != null)
          this.E.removeImageLoadingListener(this.G);
        paramNativeGenericAd.addImageLoadingListener(this.G);
        this.A = paramNativeGenericAd.getAdType();
        this.B = paramNativeGenericAd.getAdAssets();
        this.C = new e(this.B, this.A);
        this.D = new d(this.B, this.A);
        ((w)paramNativeGenericAd).a(this);
        if (this.D != null)
        {
          NativeAdImage localNativeAdImage = this.B.getImage();
          if ((localNativeAdImage != null) && (d.b(localNativeAdImage)))
          {
            this.o.setVisibility(0);
            i1 = 8;
            this.p.setVisibility(i1);
            this.E = paramNativeGenericAd;
            return;
          }
        }
      }
      catch (NativeAdException localNativeAdException)
      {
        return;
      }
      int i1 = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.template.NativeBannerView
 * JD-Core Version:    0.6.2
 */