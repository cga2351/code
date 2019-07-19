package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

public abstract class ai extends l
{
  private static final String[] h = { "android:visibility:visibility", "android:visibility:parent" };
  private int i = 3;

  private b b(s params1, s params2)
  {
    b localb = new b();
    localb.a = false;
    localb.b = false;
    if ((params1 != null) && (params1.a.containsKey("android:visibility:visibility")))
    {
      localb.c = ((Integer)params1.a.get("android:visibility:visibility")).intValue();
      localb.e = ((ViewGroup)params1.a.get("android:visibility:parent"));
      if ((params2 == null) || (!params2.a.containsKey("android:visibility:visibility")))
        break label177;
      localb.d = ((Integer)params2.a.get("android:visibility:visibility")).intValue();
      localb.f = ((ViewGroup)params2.a.get("android:visibility:parent"));
    }
    while (true)
      if ((params1 != null) && (params2 != null))
      {
        if ((localb.c == localb.d) && (localb.e == localb.f))
        {
          return localb;
          localb.c = -1;
          localb.e = null;
          break;
          label177: localb.d = -1;
          localb.f = null;
          continue;
        }
        if (localb.c != localb.d)
          if (localb.c == 0)
          {
            localb.b = false;
            localb.a = true;
          }
      }
    while (true)
    {
      return localb;
      if (localb.d == 0)
      {
        localb.b = true;
        localb.a = true;
        continue;
        if (localb.f == null)
        {
          localb.b = false;
          localb.a = true;
        }
        else if (localb.e == null)
        {
          localb.b = true;
          localb.a = true;
          continue;
          if ((params1 == null) && (localb.d == 0))
          {
            localb.b = true;
            localb.a = true;
          }
          else if ((params2 == null) && (localb.c == 0))
          {
            localb.b = false;
            localb.a = true;
          }
        }
      }
    }
  }

  private void d(s params)
  {
    int j = params.b.getVisibility();
    params.a.put("android:visibility:visibility", Integer.valueOf(j));
    params.a.put("android:visibility:parent", params.b.getParent());
    int[] arrayOfInt = new int[2];
    params.b.getLocationOnScreen(arrayOfInt);
    params.a.put("android:visibility:screenLocation", arrayOfInt);
  }

  public Animator a(ViewGroup paramViewGroup, s params1, int paramInt1, s params2, int paramInt2)
  {
    if (((0x1 & this.i) != 1) || (params2 == null))
      return null;
    if (params1 == null)
    {
      View localView = (View)params2.b.getParent();
      if (b(b(localView, false), a(localView, false)).a)
        return null;
    }
    return a(paramViewGroup, params2.b, params1, params2);
  }

  public Animator a(ViewGroup paramViewGroup, s params1, s params2)
  {
    b localb = b(params1, params2);
    if ((localb.a) && ((localb.e != null) || (localb.f != null)))
    {
      if (localb.b)
        return a(paramViewGroup, params1, localb.c, params2, localb.d);
      return b(paramViewGroup, params1, localb.c, params2, localb.d);
    }
    return null;
  }

  public Animator a(ViewGroup paramViewGroup, View paramView, s params1, s params2)
  {
    return null;
  }

  public void a(int paramInt)
  {
    if ((paramInt & 0xFFFFFFFC) != 0)
      throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    this.i = paramInt;
  }

  public void a(s params)
  {
    d(params);
  }

  public boolean a(s params1, s params2)
  {
    if ((params1 == null) && (params2 == null));
    b localb;
    do
    {
      do
        return false;
      while ((params1 != null) && (params2 != null) && (params2.a.containsKey("android:visibility:visibility") != params1.a.containsKey("android:visibility:visibility")));
      localb = b(params1, params2);
    }
    while ((!localb.a) || ((localb.c != 0) && (localb.d != 0)));
    return true;
  }

  public String[] a()
  {
    return h;
  }

  public Animator b(ViewGroup paramViewGroup, s params1, int paramInt1, s params2, int paramInt2)
  {
    if ((0x2 & this.i) != 2)
      return null;
    Object localObject1;
    label22: View localView1;
    if (params1 != null)
    {
      localObject1 = params1.b;
      if (params2 == null)
        break label196;
      localView1 = params2.b;
      label34: if ((localView1 != null) && (localView1.getParent() != null))
        break label330;
      if (localView1 == null)
        break label202;
      localObject1 = localView1;
      localView1 = null;
    }
    while (true)
    {
      label59: final w localw;
      Animator localAnimator2;
      label196: label202: View localView2;
      Object localObject2;
      if ((localObject1 != null) && (params1 != null))
      {
        int[] arrayOfInt1 = (int[])params1.a.get("android:visibility:screenLocation");
        int k = arrayOfInt1[0];
        int m = arrayOfInt1[1];
        int[] arrayOfInt2 = new int[2];
        paramViewGroup.getLocationOnScreen(arrayOfInt2);
        ((View)localObject1).offsetLeftAndRight(k - arrayOfInt2[0] - ((View)localObject1).getLeft());
        ((View)localObject1).offsetTopAndBottom(m - arrayOfInt2[1] - ((View)localObject1).getTop());
        localw = x.a(paramViewGroup);
        localw.a((View)localObject1);
        localAnimator2 = b(paramViewGroup, (View)localObject1, params1, params2);
        if (localAnimator2 == null)
        {
          localw.b((View)localObject1);
          return localAnimator2;
          localObject1 = null;
          break label22;
          localView1 = null;
          break label34;
          if (localObject1 == null)
            break label499;
          if (((View)localObject1).getParent() == null)
          {
            localView1 = null;
            continue;
          }
          if (!(((View)localObject1).getParent() instanceof View))
            break label499;
          localView2 = (View)((View)localObject1).getParent();
          if (!b(a(localView2, true), b(localView2, true)).a)
            localObject2 = q.a(paramViewGroup, (View)localObject1, localView2);
        }
      }
      while (true)
      {
        localObject1 = localObject2;
        localView1 = null;
        break label59;
        if (localView2.getParent() == null)
        {
          int n = localView2.getId();
          if ((n != -1) && (paramViewGroup.findViewById(n) != null) && (this.e))
          {
            localObject2 = localObject1;
            continue;
            label330: if (paramInt2 == 4)
            {
              localObject1 = null;
              break label59;
            }
            if (localObject1 == localView1)
            {
              localObject1 = null;
              break label59;
            }
            if (this.e)
            {
              localView1 = null;
              break label59;
            }
            localObject1 = q.a(paramViewGroup, (View)localObject1, (View)((View)localObject1).getParent());
            localView1 = null;
            break label59;
            localAnimator2.addListener(new AnimatorListenerAdapter()
            {
              public void onAnimationEnd(Animator paramAnonymousAnimator)
              {
                localw.b(this.b);
              }
            });
            return localAnimator2;
            if (localView1 == null)
              break;
            int j = localView1.getVisibility();
            ad.a(localView1, 0);
            Animator localAnimator1 = b(paramViewGroup, localView1, params1, params2);
            if (localAnimator1 != null)
            {
              a locala = new a(localView1, paramInt2, true);
              localAnimator1.addListener(locala);
              a.a(localAnimator1, locala);
              a(locala);
              return localAnimator1;
            }
            ad.a(localView1, j);
            return localAnimator1;
          }
        }
        localObject2 = null;
      }
      label499: localView1 = null;
      localObject1 = null;
    }
  }

  public Animator b(ViewGroup paramViewGroup, View paramView, s params1, s params2)
  {
    return null;
  }

  public void b(s params)
  {
    d(params);
  }

  private static class a extends AnimatorListenerAdapter
    implements a.a, l.c
  {
    boolean a = false;
    private final View b;
    private final int c;
    private final ViewGroup d;
    private final boolean e;
    private boolean f;

    a(View paramView, int paramInt, boolean paramBoolean)
    {
      this.b = paramView;
      this.c = paramInt;
      this.d = ((ViewGroup)paramView.getParent());
      this.e = paramBoolean;
      a(true);
    }

    private void a()
    {
      if (!this.a)
      {
        ad.a(this.b, this.c);
        if (this.d != null)
          this.d.invalidate();
      }
      a(false);
    }

    private void a(boolean paramBoolean)
    {
      if ((this.e) && (this.f != paramBoolean) && (this.d != null))
      {
        this.f = paramBoolean;
        x.a(this.d, paramBoolean);
      }
    }

    public void a(l paraml)
    {
      a();
      paraml.b(this);
    }

    public void b(l paraml)
    {
      a(false);
    }

    public void c(l paraml)
    {
      a(true);
    }

    public void d(l paraml)
    {
    }

    public void onAnimationCancel(Animator paramAnimator)
    {
      this.a = true;
    }

    public void onAnimationEnd(Animator paramAnimator)
    {
      a();
    }

    public void onAnimationPause(Animator paramAnimator)
    {
      if (!this.a)
        ad.a(this.b, this.c);
    }

    public void onAnimationRepeat(Animator paramAnimator)
    {
    }

    public void onAnimationResume(Animator paramAnimator)
    {
      if (!this.a)
        ad.a(this.b, 0);
    }

    public void onAnimationStart(Animator paramAnimator)
    {
    }
  }

  private static class b
  {
    boolean a;
    boolean b;
    int c;
    int d;
    ViewGroup e;
    ViewGroup f;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.transition.ai
 * JD-Core Version:    0.6.2
 */