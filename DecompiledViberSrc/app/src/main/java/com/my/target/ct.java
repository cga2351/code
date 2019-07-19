package com.my.target;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.my.target.common.a.b;

public final class ct extends RelativeLayout
{
  private static final int a = bj.a();
  private final av b;
  private final RelativeLayout.LayoutParams c;
  private final ax d;
  private final at e;
  private final bj f;
  private b g;
  private b h;

  public ct(Context paramContext)
  {
    super(paramContext);
    setBackgroundColor(0);
    this.f = bj.a(paramContext);
    this.d = new ax(paramContext);
    this.d.setId(a);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    this.d.setLayoutParams(localLayoutParams);
    addView(this.d);
    this.b = new av(paramContext);
    this.b.a(ap.a((int)TypedValue.applyDimension(1, 28.0F, paramContext.getResources().getDisplayMetrics())), false);
    this.c = new RelativeLayout.LayoutParams(-2, -2);
    this.c.addRule(7, a);
    this.c.addRule(6, a);
    this.b.setLayoutParams(this.c);
    this.e = new at(paramContext);
    addView(this.b);
    addView(this.e);
  }

  private void a()
  {
    WindowManager localWindowManager = (WindowManager)getContext().getApplicationContext().getSystemService("window");
    if (localWindowManager != null)
    {
      Display localDisplay = localWindowManager.getDefaultDisplay();
      int i = localDisplay.getWidth();
      int j = localDisplay.getHeight();
      if (i / j <= 1.0F)
        break label79;
      localb = this.h;
      if (localb == null)
        if (this.h == null)
          break label88;
    }
    label79: label88: for (b localb = this.h; ; localb = this.g)
    {
      if (localb != null)
        break label97;
      return;
      localb = this.g;
      break;
    }
    label97: this.d.setImageData(localb);
  }

  public final void a(b paramb1, b paramb2, b paramb3)
  {
    this.h = paramb1;
    this.g = paramb2;
    Bitmap localBitmap = null;
    if (paramb3 != null)
      localBitmap = paramb3.e();
    if (localBitmap != null)
    {
      this.b.a(localBitmap, true);
      RelativeLayout.LayoutParams localLayoutParams1 = this.c;
      RelativeLayout.LayoutParams localLayoutParams2 = this.c;
      int i = -this.b.getMeasuredWidth();
      localLayoutParams2.leftMargin = i;
      localLayoutParams1.bottomMargin = i;
    }
    a();
  }

  public final av getCloseButton()
  {
    return this.b;
  }

  public final ImageView getImageView()
  {
    return this.d;
  }

  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    a();
  }

  public final void setAgeRestrictions(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.e.a(1, -7829368);
      this.e.setPadding(this.f.c(2), 0, 0, 0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      int i = this.f.c(10);
      localLayoutParams.topMargin = i;
      localLayoutParams.leftMargin = i;
      localLayoutParams.addRule(5, a);
      localLayoutParams.addRule(6, a);
      this.e.setLayoutParams(localLayoutParams);
      this.e.setTextColor(-1118482);
      this.e.a(1, -1118482, this.f.c(3));
      this.e.setBackgroundColor(1711276032);
      this.e.setText(paramString);
      return;
    }
    this.e.setVisibility(8);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.ct
 * JD-Core Version:    0.6.2
 */