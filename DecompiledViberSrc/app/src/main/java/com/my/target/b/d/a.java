package com.my.target.b.d;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.my.target.ae;
import com.my.target.aq;
import com.my.target.aq.a;
import com.my.target.au;
import com.my.target.au.a;
import com.my.target.aw;
import com.my.target.b.c.b.b;
import com.my.target.bj;
import com.my.target.cj;
import com.my.target.d;
import com.my.target.dp;
import com.my.target.dq;
import com.my.target.s;
import com.my.target.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class a
  implements aq.a, c
{
  final Context a;
  final d b;
  final au.a c = new b((byte)0);
  String d;
  com.my.target.a e;
  aw f;
  c.a g;
  c h;
  com.my.target.b.c.a.c i;
  boolean j;
  boolean k;
  au l;
  aq m;
  ViewGroup n;
  f o;
  private final com.my.target.a p;
  private final cj q;
  private final WeakReference<Activity> r;
  private final a s;
  private final com.my.target.a.b t;
  private aw u;
  private Uri v;
  private e w;

  private a(ViewGroup paramViewGroup)
  {
    this(com.my.target.a.a("inline"), new aw(paramViewGroup.getContext()), new cj(paramViewGroup.getContext()), paramViewGroup);
  }

  private a(com.my.target.a parama, aw paramaw, cj paramcj, ViewGroup paramViewGroup)
  {
    this.p = parama;
    this.f = paramaw;
    this.q = paramcj;
    this.a = paramViewGroup.getContext();
    if ((this.a instanceof Activity))
    {
      this.r = new WeakReference((Activity)this.a);
      this.n = ((ViewGroup)((Activity)this.a).getWindow().getDecorView().findViewById(16908290));
    }
    while (true)
    {
      this.d = "loading";
      this.b = d.a(this.a);
      a(paramaw);
      this.t = new e(parama, "inline");
      parama.a(this.t);
      this.s = new a(parama);
      paramaw.addOnLayoutChangeListener(this.s);
      return;
      this.r = new WeakReference(null);
      View localView = paramViewGroup.getRootView();
      if (localView != null)
      {
        this.n = ((ViewGroup)localView.findViewById(16908290));
        if (this.n == null)
          this.n = ((ViewGroup)localView);
      }
    }
  }

  public static a a(ViewGroup paramViewGroup)
  {
    return new a(paramViewGroup);
  }

  private void b(String paramString)
  {
    if (this.h != null)
      this.h.a(paramString);
  }

  public final void a()
  {
    this.q.setVisibility(0);
    if (this.v != null)
    {
      this.v = null;
      if (this.e != null)
      {
        this.e.a(false);
        this.e.d("hidden");
        this.e.a();
        this.e = null;
        this.p.a(true);
      }
      if (this.u != null)
      {
        this.u.a(true);
        if (this.u.getParent() != null)
          ((ViewGroup)this.u.getParent()).removeView(this.u);
        this.u.destroy();
        this.u = null;
      }
    }
    while (true)
    {
      if ((this.l != null) && (this.l.getParent() != null))
        ((ViewGroup)this.l.getParent()).removeView(this.l);
      this.l = null;
      a("default");
      if (this.h != null)
        this.h.c();
      h();
      this.p.a(this.b);
      this.f.onResume();
      return;
      if (this.f != null)
      {
        if (this.f.getParent() != null)
          ((ViewGroup)this.f.getParent()).removeView(this.f);
        a(this.f);
      }
    }
  }

  public final void a(aq paramaq, FrameLayout paramFrameLayout)
  {
    this.m = paramaq;
    this.l = new au(this.a);
    au localau = this.l;
    this.q.setVisibility(8);
    paramFrameLayout.addView(localau, new ViewGroup.LayoutParams(-1, -1));
    if (this.v != null)
    {
      this.e = com.my.target.a.a("inline");
      this.u = new aw(this.a);
      com.my.target.a locala = this.e;
      aw localaw = this.u;
      this.w = new e(locala, "inline");
      locala.a(this.w);
      localau.addView(localaw, new ViewGroup.LayoutParams(-1, -1));
      locala.a(localaw);
      if (this.m != null)
      {
        if ((this.i != null) && (this.v != null))
          dq.a(new d(this.i, this.m, this.v, locala, this.a));
      }
      else
        if (this.k)
          break label312;
    }
    label312: for (boolean bool = true; ; bool = false)
    {
      localau.setCloseVisible(bool);
      localau.setOnCloseListener(this.c);
      if ((this.h != null) && (this.v == null))
        this.h.b();
      dp.a("MRAIDMRAID dialog create");
      return;
      this.m.dismiss();
      break;
      if ((this.f == null) || (this.f.getParent() == null))
        break;
      ((ViewGroup)this.f.getParent()).removeView(this.f);
      localau.addView(this.f, new ViewGroup.LayoutParams(-1, -1));
      a("expanded");
      break;
    }
  }

  final void a(aw paramaw)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 1;
    this.q.addView(paramaw);
    paramaw.setLayoutParams(localLayoutParams);
  }

  public final void a(b paramb)
  {
    this.i = paramb.f();
    if (this.i != null)
    {
      String str = this.i.F();
      if (str != null)
      {
        if (this.f != null)
        {
          this.p.a(this.f);
          this.p.b(str);
          return;
        }
        b("unable to find MRAID webview");
        return;
      }
    }
    b("failed to load, failed MRAID initialization");
  }

  public final void a(c paramc)
  {
    this.h = paramc;
  }

  public final void a(c.a parama)
  {
    this.g = parama;
  }

  final void a(String paramString)
  {
    dp.a("MRAID state set to " + paramString);
    this.d = paramString;
    this.p.d(paramString);
    if (this.e != null)
      this.e.d(paramString);
    if ("hidden".equals(paramString))
      dp.a("MraidPresenter: Mraid on close");
  }

  public final void a(boolean paramBoolean)
  {
    dp.a("MRAIDMRAID dialog focus" + paramBoolean);
    if (this.e != null)
      this.e.a(paramBoolean);
    while (true)
    {
      if (this.u != null)
      {
        if (!paramBoolean)
          break;
        this.u.onResume();
      }
      return;
      this.p.a(paramBoolean);
    }
    this.u.a(false);
  }

  final boolean a(Uri paramUri)
  {
    if (this.f == null)
      dp.a("Cannot expand: webview destroyed");
    while ((!this.d.equals("default")) && (!this.d.equals("resized")))
      return false;
    this.v = paramUri;
    aq.a(this, this.a).show();
    return true;
  }

  public final void b()
  {
    if ((this.g != null) && (this.i != null))
      this.g.a(this.i);
  }

  public final void c()
  {
    if (((this.m == null) || (this.e != null)) && (this.f != null))
      this.f.a(true);
  }

  public final void d()
  {
    if (((this.m == null) || (this.e != null)) && (this.f != null))
      this.f.a(false);
  }

  public final void e()
  {
    if (((this.m == null) || (this.e != null)) && (this.f != null))
      this.f.onResume();
  }

  public final void f()
  {
    a("hidden");
    this.h = null;
    this.g = null;
    this.p.a();
    if (this.l != null)
    {
      this.l.removeAllViews();
      this.l.setOnCloseListener(null);
      ViewParent localViewParent = this.l.getParent();
      if (localViewParent != null)
        ((ViewGroup)localViewParent).removeView(this.l);
      this.l = null;
    }
    if (this.f != null)
    {
      this.f.a(true);
      if (this.f.getParent() != null)
        ((ViewGroup)this.f.getParent()).removeView(this.f);
      this.f.destroy();
      this.f = null;
    }
    if (this.e != null)
    {
      this.e.a();
      this.e = null;
    }
    if (this.u != null)
    {
      this.u.a(true);
      if (this.u.getParent() != null)
        ((ViewGroup)this.u.getParent()).removeView(this.u);
      this.u.destroy();
      this.u = null;
    }
  }

  public final cj g()
  {
    return this.q;
  }

  final void h()
  {
    int[] arrayOfInt = new int[2];
    DisplayMetrics localDisplayMetrics = this.a.getResources().getDisplayMetrics();
    this.b.a(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    if (this.n != null)
    {
      this.n.getLocationOnScreen(arrayOfInt);
      this.b.c(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + this.n.getMeasuredWidth(), arrayOfInt[1] + this.n.getMeasuredHeight());
    }
    if ((!this.d.equals("expanded")) && (!this.d.equals("resized")))
    {
      this.q.getLocationOnScreen(arrayOfInt);
      this.b.a(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + this.q.getMeasuredWidth(), arrayOfInt[1] + this.q.getMeasuredHeight());
    }
    if (this.u != null)
    {
      this.u.getLocationOnScreen(arrayOfInt);
      this.b.b(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + this.u.getMeasuredWidth(), arrayOfInt[1] + this.u.getMeasuredHeight());
    }
    while (this.f == null)
      return;
    this.f.getLocationOnScreen(arrayOfInt);
    this.b.b(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + this.f.getMeasuredWidth(), arrayOfInt[1] + this.f.getMeasuredHeight());
  }

  final boolean i()
  {
    Activity localActivity = (Activity)this.r.get();
    if ((localActivity == null) || (this.f == null))
      return false;
    return bj.a(localActivity, this.f);
  }

  final class a
    implements View.OnLayoutChangeListener
  {
    private final com.my.target.a b;

    a(com.my.target.a arg2)
    {
      Object localObject;
      this.b = localObject;
    }

    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      a.this.o = null;
      a.this.h();
      this.b.a(a.this.b);
    }
  }

  private final class b
    implements au.a
  {
    private b()
    {
    }

    public final void a()
    {
      if (a.this.m != null)
        a.this.m.dismiss();
    }
  }

  public static abstract interface c
  {
    public abstract void a();

    public abstract void a(float paramFloat1, float paramFloat2, Context paramContext);

    public abstract void a(String paramString);

    public abstract void a(String paramString, com.my.target.b.c.a.c paramc, Context paramContext);

    public abstract void b();

    public abstract void c();
  }

  static final class d
    implements Runnable
  {
    com.my.target.a a;
    private com.my.target.b.c.a.c b;
    private Context c;
    private aq d;
    private Uri e;

    d(com.my.target.b.c.a.c paramc, aq paramaq, Uri paramUri, com.my.target.a parama, Context paramContext)
    {
      this.b = paramc;
      this.c = paramContext.getApplicationContext();
      this.d = paramaq;
      this.e = paramUri;
      this.a = parama;
    }

    public final void run()
    {
      s locals = s.a();
      locals.c(this.e.toString(), this.c);
      final String str = ae.a(this.b.G(), (String)locals.d());
      if (!TextUtils.isEmpty(str))
      {
        dq.c(new Runnable()
        {
          public final void run()
          {
            a.d.this.a.b(str);
          }
        });
        return;
      }
      this.a.a("expand", "Failed to handling mraid");
      this.d.dismiss();
    }
  }

  private final class e
    implements com.my.target.a.b
  {
    private final com.my.target.a b;
    private final String c;

    e(com.my.target.a paramString, String arg3)
    {
      this.b = paramString;
      Object localObject;
      this.c = localObject;
    }

    public final void a()
    {
      if (a.this.m != null)
        a.this.m.dismiss();
    }

    public final void a(Uri paramUri)
    {
      if ((a.this.g != null) && (a.this.i != null))
        a.this.g.a(a.this.i, paramUri.toString());
    }

    public final void a(com.my.target.a parama)
    {
      StringBuilder localStringBuilder = new StringBuilder("onPageLoaded callback from ");
      String str;
      if (parama == a.this.e)
      {
        str = " second ";
        dp.a(str + "webview");
        ArrayList localArrayList = new ArrayList();
        if (a.this.i())
          localArrayList.add("'inlineVideo'");
        localArrayList.add("'vpaid'");
        parama.a(localArrayList);
        parama.c(this.c);
        parama.a(parama.c());
        if ((a.this.m == null) || (!a.this.m.isShowing()))
          break label173;
        a.this.a("expanded");
      }
      while (true)
      {
        parama.b();
        if ((parama != a.this.e) && (a.this.h != null))
          a.this.h.a();
        return;
        str = " primary ";
        break;
        label173: a.this.a("default");
      }
    }

    public final void a(boolean paramBoolean)
    {
      if ((paramBoolean) && (a.this.m != null))
        return;
      this.b.a(paramBoolean);
    }

    public final boolean a(float paramFloat1, float paramFloat2)
    {
      if (!a.this.j)
      {
        this.b.a("playheadEvent", "Calling VPAID command before VPAID init");
        return false;
      }
      if ((paramFloat1 >= 0.0F) && (paramFloat2 >= 0.0F) && (a.this.h != null) && (a.this.i != null))
        a.this.h.a(paramFloat1, paramFloat2, a.this.a);
      return true;
    }

    public final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5)
    {
      a.this.o = new a.f();
      if (a.this.n == null)
      {
        dp.a("Unable to set resize properties: container view for resize is not defined");
        this.b.a("setResizeProperties", "container view for resize is not defined");
        a.this.o = null;
        return false;
      }
      if ((paramInt1 < 50) || (paramInt2 < 50))
      {
        dp.a("Unable to set resize properties: properties cannot be less than closeable container");
        this.b.a("setResizeProperties", "properties cannot be less than closeable container");
        a.this.o = null;
        return false;
      }
      bj localbj = bj.a(a.this.a);
      a.this.o.a(paramBoolean);
      a.this.o.a(localbj.c(paramInt1), localbj.c(paramInt2), localbj.c(paramInt3), localbj.c(paramInt4), paramInt5);
      if (!paramBoolean)
      {
        Rect localRect = new Rect();
        a.this.n.getGlobalVisibleRect(localRect);
        if (!a.this.o.a(localRect))
        {
          dp.a("Unable to set resize properties: allowOffscreen is false, maxSize is (" + localRect.width() + "," + localRect.height() + ") resize properties: (" + a.this.o.a() + "," + a.this.o.b() + ")");
          this.b.a("setResizeProperties", "resize properties with allowOffscreen false out of viewport");
          a.this.o = null;
          return false;
        }
      }
      return true;
    }

    public final boolean a(ConsoleMessage paramConsoleMessage, com.my.target.a parama)
    {
      StringBuilder localStringBuilder = new StringBuilder("Console message: from ");
      if (parama == a.this.e);
      for (String str = " second "; ; str = " primary ")
      {
        dp.a(str + "webview: " + paramConsoleMessage.message());
        return true;
      }
    }

    public final boolean a(String paramString)
    {
      if (!a.this.j)
      {
        this.b.a("vpaidEvent", "Calling VPAID command before VPAID init");
        return false;
      }
      if ((a.this.h != null) && (a.this.i != null))
        a.this.h.a(paramString, a.this.i, a.this.a);
      return true;
    }

    public final boolean a(String paramString, JsResult paramJsResult)
    {
      dp.a("JS Alert: " + paramString);
      paramJsResult.confirm();
      return true;
    }

    public final boolean a(boolean paramBoolean, com.my.target.c paramc)
    {
      dp.a("Orientation properties isn't supported in standard banners");
      return false;
    }

    public final void b()
    {
    }

    public final void b(boolean paramBoolean)
    {
      a.this.k = paramBoolean;
      au localau;
      if ((a.this.d.equals("expanded")) && (a.this.l != null))
      {
        localau = a.this.l;
        if (paramBoolean)
          break label74;
      }
      label74: for (boolean bool = true; ; bool = false)
      {
        localau.setCloseVisible(bool);
        if (!paramBoolean)
          a.this.l.setOnCloseListener(a.this.c);
        return;
      }
    }

    public final boolean b(Uri paramUri)
    {
      return a.this.a(paramUri);
    }

    public final boolean d()
    {
      if (!a.this.d.equals("default"))
      {
        dp.a("Unable to resize: wrong state for resize: " + a.this.d);
        this.b.a("resize", "wrong state for resize " + a.this.d);
        return false;
      }
      if (a.this.o == null)
      {
        dp.a("Unable to resize: resize properties not set");
        this.b.a("resize", "resize properties not set");
        return false;
      }
      if ((a.this.n == null) || (a.this.f == null))
      {
        dp.a("Unable to resize: views not initialized");
        this.b.a("resize", "views not initialized");
        return false;
      }
      if (!a.this.o.a(a.this.n, a.this.f))
      {
        dp.a("Unable to resize: views not visible");
        this.b.a("resize", "views not visible");
        return false;
      }
      a.this.l = new au(a.this.a);
      a.this.o.a(a.this.l);
      if (!a.this.o.b(a.this.l))
      {
        dp.a("Unable to resize: close button is out of visible range");
        this.b.a("resize", "close button is out of visible range");
        a.this.l = null;
        return false;
      }
      ViewGroup localViewGroup = (ViewGroup)a.this.f.getParent();
      if (localViewGroup != null)
        localViewGroup.removeView(a.this.f);
      a.this.l.addView(a.this.f, new FrameLayout.LayoutParams(-1, -1));
      a.this.l.setOnCloseListener(new au.a()
      {
        public final void a()
        {
          a.e locale = a.e.this;
          if ((locale.a.l == null) || (locale.a.f == null));
          do
          {
            return;
            if (locale.a.l.getParent() != null)
            {
              ((ViewGroup)locale.a.l.getParent()).removeView(locale.a.l);
              locale.a.l.removeAllViews();
              locale.a.a(locale.a.f);
              locale.a.a("default");
              locale.a.l.setOnCloseListener(null);
              locale.a.l = null;
            }
          }
          while (locale.a.h == null);
          locale.a.h.c();
        }
      });
      a.this.n.addView(a.this.l);
      a.this.a("resized");
      if (a.this.h != null)
        a.this.h.b();
      return true;
    }

    public final void n_()
    {
      a.this.j = true;
    }
  }

  public static final class f
  {
    private boolean a = true;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private Rect g;
    private Rect h;
    private int i;
    private int j;

    public final int a()
    {
      return this.d;
    }

    final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.d = paramInt1;
      this.e = paramInt2;
      this.b = paramInt3;
      this.c = paramInt4;
      this.f = paramInt5;
    }

    final void a(au paramau)
    {
      if ((this.h == null) || (this.g == null))
      {
        dp.a("Setup views before resizing");
        return;
      }
      this.i = (this.h.top - this.g.top + this.c);
      this.j = (this.h.left - this.g.left + this.b);
      if (!this.a)
      {
        if (this.i + this.e > this.g.height())
        {
          dp.a("Try to reposition creative vertically because of resize allowOffscreen:false and out of max size properties");
          this.i = (this.g.height() - this.e);
        }
        if (this.j + this.d > this.g.width())
        {
          dp.a("Try to reposition creative horizontally because of resize allowOffscreen:false and out of max size properties");
          this.j = (this.g.width() - this.d);
        }
      }
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.d, this.e);
      localLayoutParams.topMargin = this.i;
      localLayoutParams.leftMargin = this.j;
      paramau.setLayoutParams(localLayoutParams);
      paramau.setCloseGravity(this.f);
      paramau.setCloseVisible(false);
    }

    final void a(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }

    final boolean a(Rect paramRect)
    {
      return (this.d <= paramRect.width()) && (this.e <= paramRect.height());
    }

    final boolean a(ViewGroup paramViewGroup, aw paramaw)
    {
      this.g = new Rect();
      this.h = new Rect();
      return (paramViewGroup.getGlobalVisibleRect(this.g)) && (paramaw.getGlobalVisibleRect(this.h));
    }

    public final int b()
    {
      return this.e;
    }

    final boolean b(au paramau)
    {
      if (this.g == null)
        return false;
      Rect localRect1 = new Rect(this.j, this.i, this.g.right, this.g.bottom);
      Rect localRect2 = new Rect(this.j, this.i, this.j + this.d, this.i + this.e);
      Rect localRect3 = new Rect();
      paramau.a(this.f, localRect2, localRect3);
      return localRect1.contains(localRect3);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.b.d.a
 * JD-Core Version:    0.6.2
 */