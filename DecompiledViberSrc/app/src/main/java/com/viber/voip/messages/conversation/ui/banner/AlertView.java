package com.viber.voip.messages.conversation.ui.banner;

import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.viber.dexshared.Logger;
import com.viber.voip.R.anim;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.dj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AlertView extends LinearLayout
  implements ViewTreeObserver.OnGlobalLayoutListener, Animation.AnimationListener
{
  private static final Logger b = ViberEnv.getLogger();
  protected Map<a, b> a = new HashMap(3);
  private final ArrayMap<a, Animation> c = new ArrayMap();
  private final ArrayMap<a, Animation> d = new ArrayMap();
  private int e = -1;

  public AlertView(Context paramContext)
  {
    this(paramContext, null);
  }

  public AlertView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public AlertView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private Animation a(a parama, int paramInt1, int paramInt2, ArrayMap<a, Animation> paramArrayMap)
  {
    Animation localAnimation = (Animation)paramArrayMap.get(parama);
    if (localAnimation == null)
      if (paramInt1 == 0)
        break label48;
    label48: for (localAnimation = AnimationUtils.loadAnimation(getContext(), paramInt1); ; localAnimation = AnimationUtils.loadAnimation(getContext(), paramInt2))
    {
      localAnimation.setAnimationListener(this);
      paramArrayMap.put(parama, localAnimation);
      return localAnimation;
    }
  }

  private static void a(ArrayMap<a, Animation> paramArrayMap)
  {
    Iterator localIterator = paramArrayMap.values().iterator();
    while (localIterator.hasNext())
    {
      Animation localAnimation = (Animation)localIterator.next();
      localAnimation.setAnimationListener(null);
      localAnimation.cancel();
    }
    paramArrayMap.clear();
  }

  private static void a(ArrayMap<a, Animation> paramArrayMap, Animation paramAnimation)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = paramArrayMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry2 = (Map.Entry)localIterator1.next();
      if (paramAnimation == localEntry2.getValue())
        localArrayList.add(localEntry2);
    }
    Iterator localIterator2 = localArrayList.iterator();
    while (localIterator2.hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)localIterator2.next();
      ((Animation)localEntry1.getValue()).setAnimationListener(null);
      paramArrayMap.remove(localEntry1.getKey());
    }
  }

  private int c()
  {
    this.e = -1;
    int i = getAlertTopAppearanceOrder();
    Iterator localIterator = this.a.values().iterator();
    int j = 0;
    if (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      boolean bool = localb.isLaidNextOrOver(i);
      dj.b(localb.layout, bool);
      if (bool);
      for (int k = 1; ; k = 0)
      {
        j = k + j;
        break;
      }
    }
    return j;
  }

  protected final Animation a(b paramb)
  {
    return a(paramb.getMode(), paramb.getShowAnimationResId(), R.anim.alert_slide_in, this.c);
  }

  public void a(a parama, boolean paramBoolean)
  {
    boolean bool = paramBoolean & true;
    if ((!a(parama)) || (c(parama)));
    b localb;
    do
    {
      return;
      localb = (b)this.a.get(parama);
    }
    while (localb == null);
    if ((bool) && (this.a.size() == 1))
    {
      localb.layout.startAnimation(b(localb));
      return;
    }
    b(parama);
  }

  public void a(b paramb, boolean paramBoolean)
  {
    b(paramb, paramBoolean);
  }

  public final boolean a()
  {
    return (getVisibility() == 0) && (!this.a.isEmpty());
  }

  public final boolean a(a parama)
  {
    return (getVisibility() == 0) && (this.a.containsKey(parama));
  }

  protected final Animation b(b paramb)
  {
    return a(paramb.getMode(), paramb.getHideAnimationResId(), R.anim.alert_slide_out, this.d);
  }

  public void b()
  {
    a(this.c);
    a(this.d);
    Iterator localIterator = new HashSet(this.a.values()).iterator();
    while (localIterator.hasNext())
      b(((b)localIterator.next()).getMode());
  }

  protected void b(a parama)
  {
    b localb = (b)this.a.remove(parama);
    c();
    if (localb != null)
    {
      removeView(localb.layout);
      localb.onHide();
    }
    if (this.a.isEmpty())
    {
      dj.b(this, false);
      dj.b(this, this);
    }
  }

  protected final void b(b paramb, boolean paramBoolean)
  {
    if ((paramb == null) || (this.a.containsKey(paramb.getMode())))
      return;
    if (paramb.layout.getParent() != null)
      removeView(paramb.layout);
    c(paramb, paramBoolean);
  }

  protected void c(b paramb, boolean paramBoolean)
  {
    this.a.put(paramb.getMode(), paramb);
    int i = c();
    if (getChildCount() == 0)
    {
      getViewTreeObserver().addOnGlobalLayoutListener(this);
      addView(paramb.layout);
    }
    while (true)
    {
      if ((paramBoolean) && (paramb.isLaidNextOrOver(getAlertTopAppearanceOrder())))
        paramb.layout.startAnimation(a(paramb));
      dj.b(this, true);
      paramb.onShow();
      return;
      if (paramb.isPriorityAlert())
      {
        if (1 == i);
        for (boolean bool2 = true; ; bool2 = false)
        {
          addView(paramb.layout, 0);
          paramBoolean = bool2;
          break;
        }
      }
      boolean bool1 = false;
      if (1 == i)
        bool1 = true;
      addView(paramb.layout);
      paramBoolean = bool1;
    }
  }

  protected final boolean c(a parama)
  {
    Animation localAnimation = (Animation)this.d.get(parama);
    return (localAnimation != null) && (localAnimation.hasStarted()) && (!localAnimation.hasEnded());
  }

  protected final int getAlertTopAppearanceOrder()
  {
    if (this.e >= 0)
      return this.e;
    Iterator localIterator = this.a.values().iterator();
    int i = 0;
    b localb;
    if (localIterator.hasNext())
    {
      localb = (b)localIterator.next();
      if (!localb.isLaidNextOrOver(i))
        break label75;
    }
    label75: for (int j = localb.getAppearanceOrder(); ; j = i)
    {
      i = j;
      break;
      this.e = i;
      return i;
    }
  }

  public void onAnimationEnd(Animation paramAnimation)
  {
    post(new a(this, paramAnimation));
  }

  public void onAnimationRepeat(Animation paramAnimation)
  {
  }

  public void onAnimationStart(Animation paramAnimation)
  {
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }

  protected void onDetachedFromWindow()
  {
    b();
    super.onDetachedFromWindow();
  }

  public void onGlobalLayout()
  {
  }

  public static abstract interface a
  {
  }

  public static abstract interface b
  {
    public abstract AlertView M_();
  }

  public static enum c
    implements AlertView.a
  {
    static
    {
      c[] arrayOfc = new c[1];
      arrayOfc[0] = a;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.banner.AlertView
 * JD-Core Version:    0.6.2
 */