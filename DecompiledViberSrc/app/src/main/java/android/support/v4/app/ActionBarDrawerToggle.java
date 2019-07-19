package android.support.v4.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import java.lang.reflect.Method;

@Deprecated
public class ActionBarDrawerToggle
  implements DrawerLayout.DrawerListener
{
  private static final int ID_HOME = 16908332;
  private static final String TAG = "ActionBarDrawerToggle";
  private static final int[] THEME_ATTRS = { 16843531 };
  private static final float TOGGLE_DRAWABLE_OFFSET = 0.3333333F;
  final Activity mActivity;
  private final Delegate mActivityImpl;
  private final int mCloseDrawerContentDescRes;
  private Drawable mDrawerImage;
  private final int mDrawerImageResource;
  private boolean mDrawerIndicatorEnabled = true;
  private final DrawerLayout mDrawerLayout;
  private boolean mHasCustomUpIndicator;
  private Drawable mHomeAsUpIndicator;
  private final int mOpenDrawerContentDescRes;
  private SetIndicatorInfo mSetIndicatorInfo;
  private SlideDrawable mSlider;

  public ActionBarDrawerToggle(Activity paramActivity, DrawerLayout paramDrawerLayout, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public ActionBarDrawerToggle(Activity paramActivity, DrawerLayout paramDrawerLayout, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mActivity = paramActivity;
    SlideDrawable localSlideDrawable;
    if ((paramActivity instanceof DelegateProvider))
    {
      this.mActivityImpl = ((DelegateProvider)paramActivity).getDrawerToggleDelegate();
      this.mDrawerLayout = paramDrawerLayout;
      this.mDrawerImageResource = paramInt1;
      this.mOpenDrawerContentDescRes = paramInt2;
      this.mCloseDrawerContentDescRes = paramInt3;
      this.mHomeAsUpIndicator = getThemeUpIndicator();
      this.mDrawerImage = ContextCompat.getDrawable(paramActivity, paramInt1);
      this.mSlider = new SlideDrawable(this.mDrawerImage);
      localSlideDrawable = this.mSlider;
      if (!paramBoolean)
        break label121;
    }
    label121: for (float f = 0.3333333F; ; f = 0.0F)
    {
      localSlideDrawable.setOffset(f);
      return;
      this.mActivityImpl = null;
      break;
    }
  }

  private static boolean assumeMaterial(Context paramContext)
  {
    return (paramContext.getApplicationInfo().targetSdkVersion >= 21) && (Build.VERSION.SDK_INT >= 21);
  }

  private Drawable getThemeUpIndicator()
  {
    if (this.mActivityImpl != null)
      return this.mActivityImpl.getThemeUpIndicator();
    if (Build.VERSION.SDK_INT >= 18)
    {
      ActionBar localActionBar = this.mActivity.getActionBar();
      if (localActionBar != null);
      for (Object localObject = localActionBar.getThemedContext(); ; localObject = this.mActivity)
      {
        TypedArray localTypedArray2 = ((Context)localObject).obtainStyledAttributes(null, THEME_ATTRS, 16843470, 0);
        Drawable localDrawable2 = localTypedArray2.getDrawable(0);
        localTypedArray2.recycle();
        return localDrawable2;
      }
    }
    TypedArray localTypedArray1 = this.mActivity.obtainStyledAttributes(THEME_ATTRS);
    Drawable localDrawable1 = localTypedArray1.getDrawable(0);
    localTypedArray1.recycle();
    return localDrawable1;
  }

  private void setActionBarDescription(int paramInt)
  {
    if (this.mActivityImpl != null)
      this.mActivityImpl.setActionBarDescription(paramInt);
    do
    {
      ActionBar localActionBar2;
      do
      {
        return;
        if (Build.VERSION.SDK_INT < 18)
          break;
        localActionBar2 = this.mActivity.getActionBar();
      }
      while (localActionBar2 == null);
      localActionBar2.setHomeActionContentDescription(paramInt);
      return;
      if (this.mSetIndicatorInfo == null)
        this.mSetIndicatorInfo = new SetIndicatorInfo(this.mActivity);
    }
    while (this.mSetIndicatorInfo.mSetHomeAsUpIndicator == null);
    try
    {
      ActionBar localActionBar1 = this.mActivity.getActionBar();
      Method localMethod = this.mSetIndicatorInfo.mSetHomeActionContentDescription;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      localMethod.invoke(localActionBar1, arrayOfObject);
      localActionBar1.setSubtitle(localActionBar1.getSubtitle());
      return;
    }
    catch (Exception localException)
    {
      Log.w("ActionBarDrawerToggle", "Couldn't set content description via JB-MR2 API", localException);
    }
  }

  private void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
  {
    if (this.mActivityImpl != null)
      this.mActivityImpl.setActionBarUpIndicator(paramDrawable, paramInt);
    ActionBar localActionBar2;
    do
    {
      return;
      if (Build.VERSION.SDK_INT < 18)
        break;
      localActionBar2 = this.mActivity.getActionBar();
    }
    while (localActionBar2 == null);
    localActionBar2.setHomeAsUpIndicator(paramDrawable);
    localActionBar2.setHomeActionContentDescription(paramInt);
    return;
    if (this.mSetIndicatorInfo == null)
      this.mSetIndicatorInfo = new SetIndicatorInfo(this.mActivity);
    if (this.mSetIndicatorInfo.mSetHomeAsUpIndicator != null)
      try
      {
        ActionBar localActionBar1 = this.mActivity.getActionBar();
        this.mSetIndicatorInfo.mSetHomeAsUpIndicator.invoke(localActionBar1, new Object[] { paramDrawable });
        Method localMethod = this.mSetIndicatorInfo.mSetHomeActionContentDescription;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(paramInt);
        localMethod.invoke(localActionBar1, arrayOfObject);
        return;
      }
      catch (Exception localException)
      {
        Log.w("ActionBarDrawerToggle", "Couldn't set home-as-up indicator via JB-MR2 API", localException);
        return;
      }
    if (this.mSetIndicatorInfo.mUpIndicatorView != null)
    {
      this.mSetIndicatorInfo.mUpIndicatorView.setImageDrawable(paramDrawable);
      return;
    }
    Log.w("ActionBarDrawerToggle", "Couldn't set home-as-up indicator");
  }

  public boolean isDrawerIndicatorEnabled()
  {
    return this.mDrawerIndicatorEnabled;
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (!this.mHasCustomUpIndicator)
      this.mHomeAsUpIndicator = getThemeUpIndicator();
    this.mDrawerImage = ContextCompat.getDrawable(this.mActivity, this.mDrawerImageResource);
    syncState();
  }

  public void onDrawerClosed(View paramView)
  {
    this.mSlider.setPosition(0.0F);
    if (this.mDrawerIndicatorEnabled)
      setActionBarDescription(this.mOpenDrawerContentDescRes);
  }

  public void onDrawerOpened(View paramView)
  {
    this.mSlider.setPosition(1.0F);
    if (this.mDrawerIndicatorEnabled)
      setActionBarDescription(this.mCloseDrawerContentDescRes);
  }

  public void onDrawerSlide(View paramView, float paramFloat)
  {
    float f1 = this.mSlider.getPosition();
    if (paramFloat > 0.5F);
    for (float f2 = Math.max(f1, 2.0F * Math.max(0.0F, paramFloat - 0.5F)); ; f2 = Math.min(f1, paramFloat * 2.0F))
    {
      this.mSlider.setPosition(f2);
      return;
    }
  }

  public void onDrawerStateChanged(int paramInt)
  {
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if ((paramMenuItem != null) && (paramMenuItem.getItemId() == 16908332) && (this.mDrawerIndicatorEnabled))
    {
      if (this.mDrawerLayout.isDrawerVisible(8388611))
        this.mDrawerLayout.closeDrawer(8388611);
      while (true)
      {
        return true;
        this.mDrawerLayout.openDrawer(8388611);
      }
    }
    return false;
  }

  public void setDrawerIndicatorEnabled(boolean paramBoolean)
  {
    int i;
    if (paramBoolean != this.mDrawerIndicatorEnabled)
    {
      if (!paramBoolean)
        break label55;
      SlideDrawable localSlideDrawable = this.mSlider;
      if (!this.mDrawerLayout.isDrawerOpen(8388611))
        break label47;
      i = this.mCloseDrawerContentDescRes;
      setActionBarUpIndicator(localSlideDrawable, i);
    }
    while (true)
    {
      this.mDrawerIndicatorEnabled = paramBoolean;
      return;
      label47: i = this.mOpenDrawerContentDescRes;
      break;
      label55: setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
    }
  }

  public void setHomeAsUpIndicator(int paramInt)
  {
    Drawable localDrawable = null;
    if (paramInt != 0)
      localDrawable = ContextCompat.getDrawable(this.mActivity, paramInt);
    setHomeAsUpIndicator(localDrawable);
  }

  public void setHomeAsUpIndicator(Drawable paramDrawable)
  {
    if (paramDrawable == null)
      this.mHomeAsUpIndicator = getThemeUpIndicator();
    for (this.mHasCustomUpIndicator = false; ; this.mHasCustomUpIndicator = true)
    {
      if (!this.mDrawerIndicatorEnabled)
        setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
      return;
      this.mHomeAsUpIndicator = paramDrawable;
    }
  }

  public void syncState()
  {
    SlideDrawable localSlideDrawable;
    if (this.mDrawerLayout.isDrawerOpen(8388611))
    {
      this.mSlider.setPosition(1.0F);
      if (this.mDrawerIndicatorEnabled)
      {
        localSlideDrawable = this.mSlider;
        if (!this.mDrawerLayout.isDrawerOpen(8388611))
          break label69;
      }
    }
    label69: for (int i = this.mCloseDrawerContentDescRes; ; i = this.mOpenDrawerContentDescRes)
    {
      setActionBarUpIndicator(localSlideDrawable, i);
      return;
      this.mSlider.setPosition(0.0F);
      break;
    }
  }

  @Deprecated
  public static abstract interface Delegate
  {
    public abstract Drawable getThemeUpIndicator();

    public abstract void setActionBarDescription(int paramInt);

    public abstract void setActionBarUpIndicator(Drawable paramDrawable, int paramInt);
  }

  @Deprecated
  public static abstract interface DelegateProvider
  {
    public abstract ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();
  }

  private static class SetIndicatorInfo
  {
    Method mSetHomeActionContentDescription;
    Method mSetHomeAsUpIndicator;
    ImageView mUpIndicatorView;

    SetIndicatorInfo(Activity paramActivity)
    {
      while (true)
      {
        View localView2;
        View localView3;
        try
        {
          this.mSetHomeAsUpIndicator = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[] { Drawable.class });
          Class[] arrayOfClass = new Class[1];
          arrayOfClass[0] = Integer.TYPE;
          this.mSetHomeActionContentDescription = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", arrayOfClass);
          return;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          View localView1 = paramActivity.findViewById(16908332);
          if (localView1 == null)
            continue;
          ViewGroup localViewGroup = (ViewGroup)localView1.getParent();
          if (localViewGroup.getChildCount() != 2)
            continue;
          localView2 = localViewGroup.getChildAt(0);
          localView3 = localViewGroup.getChildAt(1);
          if (localView2.getId() != 16908332);
        }
        while ((localView3 instanceof ImageView))
        {
          this.mUpIndicatorView = ((ImageView)localView3);
          return;
          localView3 = localView2;
        }
      }
    }
  }

  private class SlideDrawable extends InsetDrawable
    implements Drawable.Callback
  {
    private final boolean mHasMirroring;
    private float mOffset;
    private float mPosition;
    private final Rect mTmpRect;

    SlideDrawable(Drawable arg2)
    {
      super(0);
      int i = Build.VERSION.SDK_INT;
      boolean bool = false;
      if (i > 18)
        bool = true;
      this.mHasMirroring = bool;
      this.mTmpRect = new Rect();
    }

    public void draw(Canvas paramCanvas)
    {
      int i = 1;
      copyBounds(this.mTmpRect);
      paramCanvas.save();
      if (ViewCompat.getLayoutDirection(ActionBarDrawerToggle.this.mActivity.getWindow().getDecorView()) == i);
      for (int j = i; ; j = 0)
      {
        if (j != 0)
          i = -1;
        int k = this.mTmpRect.width();
        paramCanvas.translate(-this.mOffset * k * this.mPosition * i, 0.0F);
        if ((j != 0) && (!this.mHasMirroring))
        {
          paramCanvas.translate(k, 0.0F);
          paramCanvas.scale(-1.0F, 1.0F);
        }
        super.draw(paramCanvas);
        paramCanvas.restore();
        return;
      }
    }

    public float getPosition()
    {
      return this.mPosition;
    }

    public void setOffset(float paramFloat)
    {
      this.mOffset = paramFloat;
      invalidateSelf();
    }

    public void setPosition(float paramFloat)
    {
      this.mPosition = paramFloat;
      invalidateSelf();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.app.ActionBarDrawerToggle
 * JD-Core Version:    0.6.2
 */