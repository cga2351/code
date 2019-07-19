package com.my.target.a;

import android.content.Context;
import android.widget.RelativeLayout;
import com.my.target.az;
import com.my.target.ce;
import com.my.target.ce.a;
import com.my.target.dp;
import com.my.target.z;

public final class b extends RelativeLayout
{
  private z a;
  private a b;
  private com.my.target.b.b.b c;
  private boolean d = true;
  private boolean e = true;
  private boolean f;

  public b(Context paramContext)
  {
    super(paramContext);
    dp.c("MyTargetView created. Version: 5.3.11");
  }

  private void a(com.my.target.b.c.b.b paramb, String paramString)
  {
    if (this.b != null)
    {
      if (paramb != null)
        break label47;
      a locala = this.b;
      if (paramString == null)
        paramString = "no ad";
      locala.a(paramString, this);
    }
    while (true)
    {
      if (this.a != null)
        this.a.a(null);
      return;
      label47: if (this.a != null)
      {
        this.c = com.my.target.b.b.b.a(this, this.a);
        this.c.a(this.f);
        this.c.a(paramb);
      }
      else
      {
        this.b.a("no ad", this);
      }
    }
  }

  public static void setDebugMode(boolean paramBoolean)
  {
    dp.a = paramBoolean;
    if (paramBoolean)
      dp.a("Debug mode enabled");
  }

  public final void a()
  {
    if (this.a != null)
    {
      ce.a(this.a).a(new ce.a()
      {
        public void a(com.my.target.b.c.b.b paramAnonymousb, String paramAnonymousString)
        {
          b.a(b.this, paramAnonymousb, paramAnonymousString);
        }
      }).a(getContext());
      return;
    }
    dp.a("MyTargetView not initialized");
  }

  public final void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.a != null)
      return;
    String str = "standard_320x50";
    if (paramInt2 == 1)
      str = "standard_300x250";
    while (true)
    {
      this.a = z.a(paramInt1, str);
      this.a.b(this.d);
      this.a.c(this.e);
      this.a.d(paramBoolean);
      dp.a("MyTargetView initialized");
      return;
      if (paramInt2 == 2)
        str = "standard_728x90";
    }
  }

  public final void b()
  {
    if (this.c != null)
    {
      this.c.a();
      this.c = null;
    }
    this.b = null;
  }

  public final com.my.target.common.b getCustomParams()
  {
    if (this.a != null)
      return this.a.a();
    return null;
  }

  public final a getListener()
  {
    return this.b;
  }

  protected final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.f = true;
    if (this.c != null)
      this.c.a(true);
  }

  protected final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.f = true;
    if (this.c != null)
      this.c.a(false);
  }

  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.c != null)
      this.c.b(paramBoolean);
  }

  public final void setListener(a parama)
  {
    this.b = parama;
  }

  public final void setTrackingEnvironmentEnabled(boolean paramBoolean)
  {
    this.d = paramBoolean;
    if (this.a != null)
      this.a.b(paramBoolean);
  }

  public final void setTrackingLocationEnabled(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (this.a != null)
      this.a.c(paramBoolean);
  }

  public static abstract interface a
  {
    public abstract void a(b paramb);

    public abstract void a(String paramString, b paramb);

    public abstract void b(b paramb);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.a.b
 * JD-Core Version:    0.6.2
 */