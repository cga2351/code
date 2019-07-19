package android.support.v7.view;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.bool;
import android.support.v7.appcompat.R.dimen;
import android.support.v7.appcompat.R.styleable;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;

public class a
{
  private Context a;

  private a(Context paramContext)
  {
    this.a = paramContext;
  }

  public static a a(Context paramContext)
  {
    return new a(paramContext);
  }

  public int a()
  {
    Configuration localConfiguration = this.a.getResources().getConfiguration();
    int i = localConfiguration.screenWidthDp;
    int j = localConfiguration.screenHeightDp;
    if ((localConfiguration.smallestScreenWidthDp > 600) || (i > 600) || ((i > 960) && (j > 720)) || ((i > 720) && (j > 960)))
      return 5;
    if ((i >= 500) || ((i > 640) && (j > 480)) || ((i > 480) && (j > 640)))
      return 4;
    if (i >= 360)
      return 3;
    return 2;
  }

  public boolean b()
  {
    if (Build.VERSION.SDK_INT >= 19);
    while (!ViewConfiguration.get(this.a).hasPermanentMenuKey())
      return true;
    return false;
  }

  public int c()
  {
    return this.a.getResources().getDisplayMetrics().widthPixels / 2;
  }

  public boolean d()
  {
    return this.a.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs);
  }

  public int e()
  {
    TypedArray localTypedArray = this.a.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
    int i = localTypedArray.getLayoutDimension(R.styleable.ActionBar_height, 0);
    Resources localResources = this.a.getResources();
    if (!d())
      i = Math.min(i, localResources.getDimensionPixelSize(R.dimen.abc_action_bar_stacked_max_height));
    localTypedArray.recycle();
    return i;
  }

  public boolean f()
  {
    return this.a.getApplicationInfo().targetSdkVersion < 14;
  }

  public int g()
  {
    return this.a.getResources().getDimensionPixelSize(R.dimen.abc_action_bar_stacked_tab_max_width);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.view.a
 * JD-Core Version:    0.6.2
 */