package android.support.graphics.drawable;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class c extends h
  implements b
{
  ArrayList<Object> a = null;
  final Drawable.Callback b = new Drawable.Callback()
  {
    public void invalidateDrawable(Drawable paramAnonymousDrawable)
    {
      c.this.invalidateSelf();
    }

    public void scheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable, long paramAnonymousLong)
    {
      c.this.scheduleSelf(paramAnonymousRunnable, paramAnonymousLong);
    }

    public void unscheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable)
    {
      c.this.unscheduleSelf(paramAnonymousRunnable);
    }
  };
  private a d;
  private Context e;
  private ArgbEvaluator f = null;
  private Animator.AnimatorListener g = null;

  c()
  {
    this(null, null, null);
  }

  private c(Context paramContext)
  {
    this(paramContext, null, null);
  }

  private c(Context paramContext, a parama, Resources paramResources)
  {
    this.e = paramContext;
    if (parama != null)
    {
      this.d = parama;
      return;
    }
    this.d = new a(paramContext, parama, this.b, paramResources);
  }

  public static c a(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    c localc = new c(paramContext);
    localc.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return localc;
  }

  private void a(Animator paramAnimator)
  {
    if ((paramAnimator instanceof AnimatorSet))
    {
      ArrayList localArrayList = ((AnimatorSet)paramAnimator).getChildAnimations();
      if (localArrayList != null)
        for (int i = 0; i < localArrayList.size(); i++)
          a((Animator)localArrayList.get(i));
    }
    if ((paramAnimator instanceof ObjectAnimator))
    {
      ObjectAnimator localObjectAnimator = (ObjectAnimator)paramAnimator;
      String str = localObjectAnimator.getPropertyName();
      if (("fillColor".equals(str)) || ("strokeColor".equals(str)))
      {
        if (this.f == null)
          this.f = new ArgbEvaluator();
        localObjectAnimator.setEvaluator(this.f);
      }
    }
  }

  private void a(String paramString, Animator paramAnimator)
  {
    paramAnimator.setTarget(this.d.b.a(paramString));
    if (Build.VERSION.SDK_INT < 21)
      a(paramAnimator);
    if (this.d.d == null)
    {
      this.d.d = new ArrayList();
      this.d.e = new ArrayMap();
    }
    this.d.d.add(paramAnimator);
    this.d.e.put(paramAnimator, paramString);
  }

  public void applyTheme(Resources.Theme paramTheme)
  {
    if (this.c != null)
      DrawableCompat.applyTheme(this.c, paramTheme);
  }

  public boolean canApplyTheme()
  {
    if (this.c != null)
      return DrawableCompat.canApplyTheme(this.c);
    return false;
  }

  public void draw(Canvas paramCanvas)
  {
    if (this.c != null)
      this.c.draw(paramCanvas);
    do
    {
      return;
      this.d.b.draw(paramCanvas);
    }
    while (!this.d.c.isStarted());
    invalidateSelf();
  }

  public int getAlpha()
  {
    if (this.c != null)
      return DrawableCompat.getAlpha(this.c);
    return this.d.b.getAlpha();
  }

  public int getChangingConfigurations()
  {
    if (this.c != null)
      return this.c.getChangingConfigurations();
    return super.getChangingConfigurations() | this.d.a;
  }

  public Drawable.ConstantState getConstantState()
  {
    if ((this.c != null) && (Build.VERSION.SDK_INT >= 24))
      return new b(this.c.getConstantState());
    return null;
  }

  public int getIntrinsicHeight()
  {
    if (this.c != null)
      return this.c.getIntrinsicHeight();
    return this.d.b.getIntrinsicHeight();
  }

  public int getIntrinsicWidth()
  {
    if (this.c != null)
      return this.c.getIntrinsicWidth();
    return this.d.b.getIntrinsicWidth();
  }

  public int getOpacity()
  {
    if (this.c != null)
      return this.c.getOpacity();
    return this.d.b.getOpacity();
  }

  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
    throws XmlPullParserException, IOException
  {
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }

  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    if (this.c != null)
    {
      DrawableCompat.inflate(this.c, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    int i = paramXmlPullParser.getEventType();
    int j = 1 + paramXmlPullParser.getDepth();
    if ((i != 1) && ((paramXmlPullParser.getDepth() >= j) || (i != 3)))
    {
      String str1;
      if (i == 2)
      {
        str1 = paramXmlPullParser.getName();
        if (!"animated-vector".equals(str1))
          break label182;
        TypedArray localTypedArray2 = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, a.e);
        int m = localTypedArray2.getResourceId(0, 0);
        if (m != 0)
        {
          i locali = i.a(paramResources, m, paramTheme);
          locali.a(false);
          locali.setCallback(this.b);
          if (this.d.b != null)
            this.d.b.setCallback(null);
          this.d.b = locali;
        }
        localTypedArray2.recycle();
      }
      label182: TypedArray localTypedArray1;
      while (true)
      {
        i = paramXmlPullParser.next();
        break;
        if ("target".equals(str1))
        {
          localTypedArray1 = paramResources.obtainAttributes(paramAttributeSet, a.f);
          String str2 = localTypedArray1.getString(0);
          int k = localTypedArray1.getResourceId(1, 0);
          if (k != 0)
          {
            if (this.e == null)
              break label255;
            a(str2, e.a(this.e, k));
          }
          localTypedArray1.recycle();
        }
      }
      label255: localTypedArray1.recycle();
      throw new IllegalStateException("Context can't be null when inflating animators");
    }
    this.d.a();
  }

  public boolean isAutoMirrored()
  {
    if (this.c != null)
      return DrawableCompat.isAutoMirrored(this.c);
    return this.d.b.isAutoMirrored();
  }

  public boolean isRunning()
  {
    if (this.c != null)
      return ((AnimatedVectorDrawable)this.c).isRunning();
    return this.d.c.isRunning();
  }

  public boolean isStateful()
  {
    if (this.c != null)
      return this.c.isStateful();
    return this.d.b.isStateful();
  }

  public Drawable mutate()
  {
    if (this.c != null)
      this.c.mutate();
    return this;
  }

  protected void onBoundsChange(Rect paramRect)
  {
    if (this.c != null)
    {
      this.c.setBounds(paramRect);
      return;
    }
    this.d.b.setBounds(paramRect);
  }

  protected boolean onLevelChange(int paramInt)
  {
    if (this.c != null)
      return this.c.setLevel(paramInt);
    return this.d.b.setLevel(paramInt);
  }

  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.c != null)
      return this.c.setState(paramArrayOfInt);
    return this.d.b.setState(paramArrayOfInt);
  }

  public void setAlpha(int paramInt)
  {
    if (this.c != null)
    {
      this.c.setAlpha(paramInt);
      return;
    }
    this.d.b.setAlpha(paramInt);
  }

  public void setAutoMirrored(boolean paramBoolean)
  {
    if (this.c != null)
    {
      DrawableCompat.setAutoMirrored(this.c, paramBoolean);
      return;
    }
    this.d.b.setAutoMirrored(paramBoolean);
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.c != null)
    {
      this.c.setColorFilter(paramColorFilter);
      return;
    }
    this.d.b.setColorFilter(paramColorFilter);
  }

  public void setTint(int paramInt)
  {
    if (this.c != null)
    {
      DrawableCompat.setTint(this.c, paramInt);
      return;
    }
    this.d.b.setTint(paramInt);
  }

  public void setTintList(ColorStateList paramColorStateList)
  {
    if (this.c != null)
    {
      DrawableCompat.setTintList(this.c, paramColorStateList);
      return;
    }
    this.d.b.setTintList(paramColorStateList);
  }

  public void setTintMode(PorterDuff.Mode paramMode)
  {
    if (this.c != null)
    {
      DrawableCompat.setTintMode(this.c, paramMode);
      return;
    }
    this.d.b.setTintMode(paramMode);
  }

  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.c != null)
      return this.c.setVisible(paramBoolean1, paramBoolean2);
    this.d.b.setVisible(paramBoolean1, paramBoolean2);
    return super.setVisible(paramBoolean1, paramBoolean2);
  }

  public void start()
  {
    if (this.c != null)
      ((AnimatedVectorDrawable)this.c).start();
    while (this.d.c.isStarted())
      return;
    this.d.c.start();
    invalidateSelf();
  }

  public void stop()
  {
    if (this.c != null)
    {
      ((AnimatedVectorDrawable)this.c).stop();
      return;
    }
    this.d.c.end();
  }

  private static class a extends Drawable.ConstantState
  {
    int a;
    i b;
    AnimatorSet c;
    ArrayList<Animator> d;
    ArrayMap<Animator, String> e;

    public a(Context paramContext, a parama, Drawable.Callback paramCallback, Resources paramResources)
    {
      if (parama != null)
      {
        this.a = parama.a;
        Drawable.ConstantState localConstantState;
        if (parama.b != null)
        {
          localConstantState = parama.b.getConstantState();
          if (paramResources == null)
            break label224;
        }
        label224: for (this.b = ((i)localConstantState.newDrawable(paramResources)); ; this.b = ((i)localConstantState.newDrawable()))
        {
          this.b = ((i)this.b.mutate());
          this.b.setCallback(paramCallback);
          this.b.setBounds(parama.b.getBounds());
          this.b.a(false);
          if (parama.d == null)
            return;
          int j = parama.d.size();
          this.d = new ArrayList(j);
          this.e = new ArrayMap(j);
          while (i < j)
          {
            Animator localAnimator1 = (Animator)parama.d.get(i);
            Animator localAnimator2 = localAnimator1.clone();
            String str = (String)parama.e.get(localAnimator1);
            localAnimator2.setTarget(this.b.a(str));
            this.d.add(localAnimator2);
            this.e.put(localAnimator2, str);
            i++;
          }
        }
        a();
      }
    }

    public void a()
    {
      if (this.c == null)
        this.c = new AnimatorSet();
      this.c.playTogether(this.d);
    }

    public int getChangingConfigurations()
    {
      return this.a;
    }

    public Drawable newDrawable()
    {
      throw new IllegalStateException("No constant state support for SDK < 24.");
    }

    public Drawable newDrawable(Resources paramResources)
    {
      throw new IllegalStateException("No constant state support for SDK < 24.");
    }
  }

  private static class b extends Drawable.ConstantState
  {
    private final Drawable.ConstantState a;

    public b(Drawable.ConstantState paramConstantState)
    {
      this.a = paramConstantState;
    }

    public boolean canApplyTheme()
    {
      return this.a.canApplyTheme();
    }

    public int getChangingConfigurations()
    {
      return this.a.getChangingConfigurations();
    }

    public Drawable newDrawable()
    {
      c localc = new c();
      localc.c = this.a.newDrawable();
      localc.c.setCallback(localc.b);
      return localc;
    }

    public Drawable newDrawable(Resources paramResources)
    {
      c localc = new c();
      localc.c = this.a.newDrawable(paramResources);
      localc.c.setCallback(localc.b);
      return localc;
    }

    public Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      c localc = new c();
      localc.c = this.a.newDrawable(paramResources, paramTheme);
      localc.c.setCallback(localc.b);
      return localc;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.graphics.drawable.c
 * JD-Core Version:    0.6.2
 */