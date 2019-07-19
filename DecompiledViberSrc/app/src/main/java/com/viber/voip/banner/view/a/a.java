package com.viber.voip.banner.view.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.google.android.gms.ads.formats.MediaView;
import com.viber.common.d.c;
import com.viber.dexshared.Logger;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.ViberEnv;
import com.viber.voip.banner.datatype.AdsAfterCallBanner;
import com.viber.voip.banner.datatype.Banner;
import com.viber.voip.banner.datatype.Banner.Background;
import com.viber.voip.banner.datatype.Banner.Size;
import com.viber.voip.banner.datatype.BannerItem;
import com.viber.voip.banner.datatype.BannerItem.Type;
import com.viber.voip.banner.datatype.BlankBannerItem;
import com.viber.voip.banner.datatype.ButtonBannerItem;
import com.viber.voip.banner.datatype.DismissBannerItem;
import com.viber.voip.banner.datatype.ImageBannerItem;
import com.viber.voip.banner.datatype.ImageBannerItem.Size;
import com.viber.voip.banner.datatype.TextBannerItem;
import com.viber.voip.banner.datatype.TextBannerItem.Alignment;
import com.viber.voip.banner.view.b;
import com.viber.voip.banner.view.b.d;
import com.viber.voip.ui.ViberTextView;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import com.viber.voip.util.dk;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.h.a;
import com.viber.voip.util.e.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class a<I>
{
  private static final Logger b = ViberEnv.getLogger();
  private static final ViewGroup.LayoutParams c = new ViewGroup.LayoutParams(-2, -2);
  protected final Context a;
  private final List<a<I>.a> d = new ArrayList();
  private final Set<Uri> e = new HashSet();
  private int f = 0;
  private int g = 1;
  private I h;
  private b i;
  private b j;

  protected a(Context paramContext)
  {
    this.a = paramContext;
    i();
  }

  private int a(Context paramContext, int paramInt1, int paramInt2)
  {
    Resources localResources = paramContext.getResources();
    if (paramInt1 == 1)
      return localResources.getDimensionPixelSize(R.dimen.ads_after_call_max_height);
    if (paramInt1 == 1)
      return localResources.getDimensionPixelSize(R.dimen.ads_after_call_max_height);
    if (paramInt2 == 2)
      return localResources.getDimensionPixelSize(R.dimen.ads_call_admob_max_size);
    return localResources.getDimensionPixelSize(R.dimen.ads_timeout_call_max_height);
  }

  private static int a(Banner paramBanner, ImageBannerItem.Size paramSize)
  {
    ImageBannerItem.Size localSize = ImageBannerItem.Size.ADS_AFTER_CALL_INTERNAL;
    int k = 0;
    if (paramSize == localSize)
    {
      if ((paramBanner instanceof AdsAfterCallBanner))
        k = ((AdsAfterCallBanner)paramBanner).getAdCallType();
    }
    else
      return k;
    return 1;
  }

  private int a(ImageBannerItem.Size paramSize, int paramInt1, int paramInt2)
  {
    if (paramSize == ImageBannerItem.Size.ADS_AFTER_CALL_INTERNAL)
      return a(this.a, paramInt1, paramInt2);
    return paramSize.getHeightSizeInPx();
  }

  private View a(Banner paramBanner, BannerItem paramBannerItem)
  {
    switch (1.a[paramBannerItem.getType().ordinal()])
    {
    default:
      return null;
    case 1:
      return b(paramBanner, (ImageBannerItem)paramBannerItem);
    case 2:
      return a(paramBanner, (ImageBannerItem)paramBannerItem);
    case 3:
      return a(paramBanner, (TextBannerItem)paramBannerItem);
    case 4:
      return a(paramBanner, (ButtonBannerItem)paramBannerItem);
    case 5:
      return a(paramBanner, (DismissBannerItem)paramBannerItem);
    case 6:
    }
    return a(paramBanner, (BlankBannerItem)paramBannerItem);
  }

  private View a(Banner paramBanner, BlankBannerItem paramBlankBannerItem)
  {
    LinearLayout.LayoutParams localLayoutParams = b(paramBanner, paramBlankBannerItem);
    localLayoutParams.width = 0;
    localLayoutParams.weight = 1.0F;
    View localView = new View(this.a);
    localView.setLayoutParams(localLayoutParams);
    return localView;
  }

  private View a(Banner paramBanner, DismissBannerItem paramDismissBannerItem)
  {
    LinearLayout.LayoutParams localLayoutParams = b(paramBanner, paramDismissBannerItem);
    ImageView localImageView = new ImageView(this.a);
    localImageView.setLayoutParams(localLayoutParams);
    localImageView.setId(R.id.remote_banner_dismiss);
    localImageView.setImageResource(R.drawable.x_closing_icon_selector);
    localImageView.setOnClickListener(this.i);
    return localImageView;
  }

  private View a(Banner paramBanner, ImageBannerItem paramImageBannerItem)
  {
    MediaView localMediaView = new MediaView(this.a);
    LinearLayout.LayoutParams localLayoutParams = b(paramBanner, paramImageBannerItem);
    ImageBannerItem.Size localSize = paramImageBannerItem.getSize();
    localLayoutParams.height = a(localSize, a(paramBanner, localSize), c(paramBanner));
    localLayoutParams.width = localSize.getWidthSizeInPx();
    localMediaView.setLayoutParams(localLayoutParams);
    return localMediaView;
  }

  private View b(Banner paramBanner, ImageBannerItem paramImageBannerItem)
  {
    ImageView localImageView = new ImageView(this.a);
    LinearLayout.LayoutParams localLayoutParams = b(paramBanner, paramImageBannerItem);
    ImageBannerItem.Size localSize = paramImageBannerItem.getSize();
    int k = a(paramBanner, localSize);
    int m = c(paramBanner);
    int n = a(localSize, k, m);
    if (localSize == ImageBannerItem.Size.ADS_AFTER_CALL_INTERNAL)
    {
      localImageView.setBackgroundColor(-16777216);
      localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      localImageView.setMaxHeight(n);
    }
    localLayoutParams.height = n;
    localLayoutParams.width = localSize.getWidthSizeInPx();
    localImageView.setLayoutParams(localLayoutParams);
    int i1 = localSize.getMaxWidthInPx();
    int i2 = localSize.getMaxHeightInPx();
    if (i1 >= 0)
    {
      localImageView.setAdjustViewBounds(true);
      localImageView.setMaxWidth(i1);
    }
    if (i2 >= 0)
    {
      localImageView.setAdjustViewBounds(true);
      localImageView.setMaxHeight(i2);
    }
    String str = paramImageBannerItem.getUrl();
    if (!da.a(str))
      a(Uri.parse(str), localImageView, k, m);
    return localImageView;
  }

  private LinearLayout.LayoutParams b(Banner paramBanner, BannerItem paramBannerItem)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(c);
    int[] arrayOfInt = paramBannerItem.getMargins();
    if (paramBanner.isOrientedVertically())
    {
      localLayoutParams.topMargin = j.a(arrayOfInt[0]);
      localLayoutParams.bottomMargin = j.a(arrayOfInt[1]);
      return localLayoutParams;
    }
    localLayoutParams.leftMargin = j.a(arrayOfInt[this.f]);
    localLayoutParams.rightMargin = j.a(arrayOfInt[this.g]);
    return localLayoutParams;
  }

  private static int c(Banner paramBanner)
  {
    if ((paramBanner instanceof AdsAfterCallBanner))
      return ((AdsAfterCallBanner)paramBanner).getAdCallProvider();
    return 0;
  }

  private void i()
  {
    if ((a()) && (c.a()))
    {
      this.f = 1;
      this.g = 0;
    }
  }

  protected View a(Banner paramBanner, ButtonBannerItem paramButtonBannerItem)
  {
    ViberTextView localViberTextView = new ViberTextView(this.a);
    localViberTextView.setLayoutParams(b(paramBanner, paramButtonBannerItem));
    Object localObject = (com.viber.voip.banner.view.b.e)paramButtonBannerItem.getWidgetTuner();
    if (localObject != null);
    while (true)
    {
      ((com.viber.voip.banner.view.b.e)localObject).l(localViberTextView);
      localViberTextView.setId(R.id.remote_banner_button);
      localViberTextView.setTag(R.id.tag_action, paramButtonBannerItem.getAction());
      if (paramBanner.shouldSetClickListeners())
        localViberTextView.setOnClickListener(this.i);
      localViberTextView.setText(paramButtonBannerItem.getCaption());
      return localViberTextView;
      localObject = new d();
    }
  }

  protected View a(Banner paramBanner, TextBannerItem paramTextBannerItem)
  {
    LinearLayout.LayoutParams localLayoutParams = b(paramBanner, paramTextBannerItem);
    ViberTextView localViberTextView;
    com.viber.voip.banner.view.b.e locale;
    label86: int k;
    if (paramBanner.isOrientedVertically())
    {
      localLayoutParams.height = 0;
      localLayoutParams.weight = 1.0F;
      localViberTextView = new ViberTextView(this.a);
      localViberTextView.setLayoutParams(localLayoutParams);
      localViberTextView.setIncludeFontPadding(false);
      if (paramTextBannerItem.getPaddingTop() > 0)
        localViberTextView.setPadding(0, j.a(paramTextBannerItem.getPaddingTop()), 0, 0);
      locale = (com.viber.voip.banner.view.b.e)paramTextBannerItem.getWidgetTuner();
      if (locale == null)
        break label243;
      locale.l(localViberTextView);
      if (b(paramTextBannerItem.getColor()))
        localViberTextView.setTextColor(Color.parseColor(paramTextBannerItem.getColor()));
      if ((paramTextBannerItem.getOpacity() != null) && (a(paramTextBannerItem.getOpacity())))
        localViberTextView.setAlpha(paramTextBannerItem.getOpacity().floatValue());
      if ((!a()) || (!c.a()))
        break label255;
      k = 5;
      label162: if (paramTextBannerItem.getAlignment() != null)
        switch (1.b[paramTextBannerItem.getAlignment().ordinal()])
        {
        default:
        case 1:
        case 2:
        case 3:
        }
    }
    while (true)
    {
      localViberTextView.setGravity(k);
      localViberTextView.setText(Html.fromHtml(paramTextBannerItem.getText()));
      return localViberTextView;
      localLayoutParams.width = 0;
      localLayoutParams.weight = 1.0F;
      break;
      label243: locale = new com.viber.voip.banner.view.b.e();
      break label86;
      label255: k = 3;
      break label162;
      k = 1;
      continue;
      k = 5;
      continue;
      k = 3;
    }
  }

  protected Banner a(String paramString)
  {
    return com.viber.voip.banner.e.a.g(paramString);
  }

  protected void a(Uri paramUri, View paramView, int paramInt1, int paramInt2)
  {
    a(paramUri, paramView, false, paramInt1, paramInt2);
  }

  protected void a(Uri paramUri, View paramView, boolean paramBoolean)
  {
    a(paramUri, paramView, false, 0, 0);
  }

  protected void a(Uri paramUri, View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    a locala = new a(paramView, paramUri, h(), paramInt1, paramInt2);
    this.d.add(locala);
    if (paramBoolean)
      this.e.add(paramUri);
  }

  protected void a(Banner paramBanner)
  {
  }

  protected void a(Banner paramBanner, ViewGroup paramViewGroup)
  {
    if ((paramBanner.getItems() == null) || (paramBanner.getItems().size() == 0));
    while (true)
    {
      return;
      Iterator localIterator = paramBanner.getItems().iterator();
      while (localIterator.hasNext())
      {
        BannerItem localBannerItem = (BannerItem)localIterator.next();
        View localView = a(paramBanner, localBannerItem);
        if (localView != null)
        {
          if (localBannerItem.getViewId() != 0)
          {
            localView.setId(localBannerItem.getViewId());
            if (paramBanner.shouldSetClickListeners())
              localView.setOnClickListener(this.i);
          }
          paramViewGroup.addView(localView);
          if (localBannerItem.getType() == BannerItem.Type.DISMISS_BUTTON)
            dj.a(localView, j.a(8.0F));
        }
      }
    }
  }

  public void a(Banner paramBanner, I paramI, b paramb)
  {
    this.i = paramb;
    this.h = paramI;
    if (paramBanner == null)
    {
      g();
      return;
    }
    a(paramBanner);
    if (!b(paramBanner))
    {
      g();
      return;
    }
    paramb.setBannerMeta(paramBanner);
    if (!a(paramb, paramBanner))
    {
      g();
      return;
    }
    d();
  }

  public void a(b paramb)
  {
    this.j = paramb;
  }

  public void a(String paramString, I paramI, b paramb)
  {
    a(a(paramString), paramI, paramb);
  }

  protected boolean a()
  {
    return true;
  }

  protected boolean a(b paramb, Banner paramBanner)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(c);
    label68: ImageView localImageView;
    label223: LinearLayout localLinearLayout;
    if (paramBanner.isOrientedVertically())
    {
      if ((-2147483648 == paramBanner.getSize().getVerticalWidthSizeInPx()) || (-2147483648 == paramBanner.getSize().getVerticalHeightSizeInPx()))
        return false;
      localLayoutParams.width = paramBanner.getSize().getVerticalWidthSizeInPx();
      localLayoutParams.height = paramBanner.getSize().getVerticalHeightSizeInPx();
      paramb.setLayoutParams(localLayoutParams);
      paramb.setId(R.id.remote_banner_container);
      paramb.setTag(R.id.tag_action, paramBanner.getAction());
      if (paramBanner.shouldSetClickListeners())
        paramb.setOnClickListener(paramb);
      localImageView = paramb.getBackgroundImageView();
      if ((localImageView == null) || (da.a(paramBanner.getBackground().getColor())))
        break label321;
      Float localFloat = paramBanner.getBackground().getOpacity();
      if ((localFloat == null) || (localFloat.floatValue() > 0.0F))
        localImageView.setBackgroundColor(Color.parseColor(paramBanner.getBackground().getColor()));
      if ((localFloat != null) && (localFloat.floatValue() > 0.0F))
        localImageView.setAlpha(paramBanner.getBackground().getOpacity().floatValue());
      if ((localFloat != null) && (0.0F == localFloat.floatValue()))
      {
        localImageView.setBackgroundDrawable(null);
        localImageView.setAlpha(0.0F);
      }
      localLinearLayout = paramb.getItemsViewGroup();
      if (!paramBanner.isOrientedVertically())
        break label368;
      localLinearLayout.setOrientation(1);
      if (paramBanner.getGravity() == null)
        break label359;
      localLinearLayout.setGravity(paramBanner.getGravity().intValue());
    }
    while (true)
    {
      a(paramBanner, localLinearLayout);
      return true;
      if ((-2147483648 == paramBanner.getSize().getWidthSizeInPx()) || (-2147483648 == paramBanner.getSize().getHeightSizeInPx()))
        break;
      localLayoutParams.width = paramBanner.getSize().getWidthSizeInPx();
      localLayoutParams.height = paramBanner.getSize().getHeightSizeInPx();
      break label68;
      label321: if ((localImageView == null) || (da.a(paramBanner.getBackground().getImage())))
        break label223;
      a(Uri.parse(paramBanner.getBackground().getImage()), localImageView, true);
      break label223;
      label359: localLinearLayout.setGravity(1);
      continue;
      label368: localLinearLayout.setOrientation(0);
      if (paramBanner.getGravity() != null)
        localLinearLayout.setGravity(paramBanner.getGravity().intValue());
      else
        localLinearLayout.setGravity(16);
    }
  }

  protected boolean a(Float paramFloat)
  {
    return (paramFloat.floatValue() >= 0.0F) && (paramFloat.floatValue() <= 1.0F);
  }

  public I b()
  {
    return this.h;
  }

  protected boolean b(Banner paramBanner)
  {
    if ((paramBanner == null) || (paramBanner.getItems() == null))
      return false;
    List localList = paramBanner.getItems();
    if (localList.contains(Banner.INVALID_BANNER_ITEM))
      return false;
    if ((paramBanner.hasActionSupport()) && (!c(paramBanner.getAction())))
      return false;
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      BannerItem localBannerItem = (BannerItem)localIterator.next();
      if (localBannerItem.getType() == BannerItem.Type.BUTTON)
      {
        ButtonBannerItem localButtonBannerItem = (ButtonBannerItem)localBannerItem;
        if ((paramBanner.hasActionSupport()) && (!c(localButtonBannerItem.getAction())))
          return false;
      }
    }
    if (paramBanner.getBackground() == null)
      return false;
    boolean bool = b(paramBanner.getBackground().getColor());
    if ((!bool) && (da.a(paramBanner.getBackground().getImage())))
      return false;
    return (!bool) || (paramBanner.getBackground().getOpacity() == null) || (a(paramBanner.getBackground().getOpacity()));
  }

  protected boolean b(String paramString)
  {
    if (da.a(paramString))
      return false;
    try
    {
      Color.parseColor(paramString);
      return true;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
    }
    return false;
  }

  public b c()
  {
    return this.i;
  }

  protected boolean c(String paramString)
  {
    try
    {
      Uri localUri = Uri.parse(paramString);
      boolean bool1;
      if (!dk.f(localUri))
      {
        boolean bool2 = dk.g(localUri);
        bool1 = false;
        if (!bool2);
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  protected void d()
  {
    if (this.d.size() == 0)
    {
      if (this.e.size() == 0)
      {
        e();
        return;
      }
      f();
      return;
    }
    ((a)this.d.get(0)).a();
  }

  protected void e()
  {
  }

  protected void f()
  {
  }

  protected void g()
  {
  }

  protected f h()
  {
    return f.a();
  }

  class a
    implements h.a
  {
    private View b;
    private Uri c;
    private f d;
    private int e;
    private int f;

    public a(View paramUri, Uri paramf, f paramInt1, int paramInt2, int arg6)
    {
      this.b = paramUri;
      this.c = paramf;
      this.d = paramInt1;
      this.e = paramInt2;
      int i;
      this.f = i;
    }

    public void a()
    {
      com.viber.voip.util.e.e.a(a.this.a).a(this.c, this.d, this);
    }

    public void onLoadComplete(Uri paramUri, Bitmap paramBitmap, boolean paramBoolean)
    {
      ImageView localImageView;
      int i;
      int j;
      int k;
      int i5;
      int m;
      if (paramBitmap != null)
      {
        if (!(this.b instanceof ImageView))
          break label333;
        localImageView = (ImageView)this.b;
        if (((paramBitmap != null) && (this.e == 2)) || (this.e == 1))
        {
          i = a.a(a.this, a.this.a, this.e, this.f);
          j = paramBitmap.getWidth();
          k = paramBitmap.getHeight();
          if (j <= 300)
            break label361;
          float f2 = j / 300.0F;
          int i4 = Math.round(j / f2);
          i5 = Math.round(k / f2);
          m = i4;
        }
      }
      for (int n = i5; ; n = k)
      {
        int i1;
        float f1;
        int i3;
        if (m > n)
        {
          i1 = 1;
          f1 = a.this.a.getResources().getDisplayMetrics().density;
          int i2 = Math.round(com.viber.voip.util.k.a.a(a.this.a) / f1);
          if (i1 == 0)
            break label319;
          i3 = Math.round(f1 * (i2 / m * n));
          label196: if ((this.e == 1) && (i3 > i))
            i3 = i;
          ViewGroup.LayoutParams localLayoutParams = localImageView.getLayoutParams();
          localLayoutParams.height = i3;
          localImageView.setLayoutParams(localLayoutParams);
          localImageView.setMaxHeight(i3);
          localImageView.setImageBitmap(paramBitmap);
        }
        while (true)
        {
          a.a(a.this).remove(paramUri);
          if (a.b(a.this) != null)
            a.b(a.this).onImageLoaded(this.b, paramBitmap, paramBoolean);
          a.c(a.this).remove(this);
          a.this.d();
          return;
          i1 = 0;
          break;
          label319: i3 = Math.round(f1 * n);
          break label196;
          label333: dj.a(this.b, new BitmapDrawable(a.this.a.getResources(), paramBitmap));
        }
        label361: m = j;
      }
    }
  }

  public static abstract interface b
  {
    public abstract void onImageLoaded(View paramView, Bitmap paramBitmap, boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.view.a.a
 * JD-Core Version:    0.6.2
 */