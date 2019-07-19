package com.my.target;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.my.target.b.c.a.i;
import com.my.target.common.a.b;

@SuppressLint({"ViewConstructor"})
public final class da extends RelativeLayout
{
  private final RelativeLayout a;
  private final ImageView b;
  private final ImageView c;
  private final bj d;
  private final boolean e;
  private final View.OnClickListener f;

  public da(Context paramContext, bj parambj, boolean paramBoolean)
  {
    super(paramContext);
    this.a = new RelativeLayout(paramContext);
    this.b = new ImageView(paramContext);
    bj.a(this.b, "logo_image");
    this.c = new ImageView(paramContext);
    bj.a(this.c, "store_image");
    this.d = parambj;
    this.e = paramBoolean;
    this.f = new a(paramContext, (byte)0);
  }

  final void a()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(12, -1);
    this.a.setLayoutParams(localLayoutParams);
    ImageView localImageView = this.b;
    Context localContext = getContext();
    byte[] arrayOfByte = Base64.decode("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", 0);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDensity = 320;
    localOptions.inTargetDensity = localContext.getResources().getDisplayMetrics().densityDpi;
    localImageView.setImageBitmap(BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions));
    this.a.addView(this.b);
    this.a.addView(this.c);
    addView(this.a);
  }

  final void a(int paramInt, boolean paramBoolean)
  {
    int i = paramInt / 3;
    if (this.e)
      i = paramInt / 5;
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-2, i);
    label94: RelativeLayout.LayoutParams localLayoutParams2;
    if (paramBoolean)
    {
      localLayoutParams1.setMargins(this.d.c(24), this.d.c(4), this.d.c(24), this.d.c(8));
      localLayoutParams1.addRule(15, -1);
      if (Build.VERSION.SDK_INT < 17)
        break label267;
      localLayoutParams1.addRule(20);
      this.c.setScaleType(ImageView.ScaleType.FIT_START);
      this.c.setLayoutParams(localLayoutParams1);
      localLayoutParams2 = new RelativeLayout.LayoutParams(-2, i);
      if (!paramBoolean)
        break label277;
      localLayoutParams2.setMargins(this.d.c(8), this.d.c(4), this.d.c(8), this.d.c(8));
      label169: localLayoutParams2.addRule(15, -1);
      if (Build.VERSION.SDK_INT < 17)
        break label321;
      localLayoutParams2.addRule(21);
    }
    while (true)
    {
      this.b.setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.b.setLayoutParams(localLayoutParams2);
      this.b.setOnClickListener(this.f);
      return;
      localLayoutParams1.setMargins(this.d.c(24), this.d.c(16), this.d.c(24), this.d.c(16));
      break;
      label267: localLayoutParams1.addRule(9);
      break label94;
      label277: localLayoutParams2.setMargins(this.d.c(24), this.d.c(16), this.d.c(24), this.d.c(16));
      break label169;
      label321: localLayoutParams2.addRule(11);
    }
  }

  public final void setBanner(i parami)
  {
    b localb = parami.K();
    if (("store".equals(parami.m())) && (localb != null) && (localb.f() != null))
      this.c.setImageBitmap(localb.f());
  }

  private static final class a
    implements View.OnClickListener
  {
    private final Context a;

    private a(Context paramContext)
    {
      this.a = paramContext;
    }

    public final void onClick(View paramView)
    {
      try
      {
        Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://target.my.com/"));
        if (!(this.a instanceof Activity))
          localIntent.addFlags(268435456);
        this.a.startActivity(localIntent);
        return;
      }
      catch (Throwable localThrowable)
      {
        dp.a(localThrowable.getMessage());
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.da
 * JD-Core Version:    0.6.2
 */