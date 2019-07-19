package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.v7.appcompat.R.style;
import android.view.LayoutInflater;

public class d extends ContextWrapper
{
  private int a;
  private Resources.Theme b;
  private LayoutInflater c;
  private Configuration d;
  private Resources e;

  public d()
  {
    super(null);
  }

  public d(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.a = paramInt;
  }

  public d(Context paramContext, Resources.Theme paramTheme)
  {
    super(paramContext);
    this.b = paramTheme;
  }

  private Resources b()
  {
    if (this.e == null)
    {
      if (this.d != null)
        break label27;
      this.e = super.getResources();
    }
    while (true)
    {
      return this.e;
      label27: if (Build.VERSION.SDK_INT >= 17)
        this.e = createConfigurationContext(this.d).getResources();
    }
  }

  private void c()
  {
    if (this.b == null);
    for (boolean bool = true; ; bool = false)
    {
      if (bool)
      {
        this.b = getResources().newTheme();
        Resources.Theme localTheme = getBaseContext().getTheme();
        if (localTheme != null)
          this.b.setTo(localTheme);
      }
      a(this.b, this.a, bool);
      return;
    }
  }

  public int a()
  {
    return this.a;
  }

  protected void a(Resources.Theme paramTheme, int paramInt, boolean paramBoolean)
  {
    paramTheme.applyStyle(paramInt, true);
  }

  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
  }

  public AssetManager getAssets()
  {
    return getResources().getAssets();
  }

  public Resources getResources()
  {
    return b();
  }

  public Object getSystemService(String paramString)
  {
    if ("layout_inflater".equals(paramString))
    {
      if (this.c == null)
        this.c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
      return this.c;
    }
    return getBaseContext().getSystemService(paramString);
  }

  public Resources.Theme getTheme()
  {
    if (this.b != null)
      return this.b;
    if (this.a == 0)
      this.a = R.style.Theme_AppCompat_Light;
    c();
    return this.b;
  }

  public void setTheme(int paramInt)
  {
    if (this.a != paramInt)
    {
      this.a = paramInt;
      c();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.view.d
 * JD-Core Version:    0.6.2
 */