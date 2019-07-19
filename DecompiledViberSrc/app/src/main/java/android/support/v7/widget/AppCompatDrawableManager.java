package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.graphics.drawable.c;
import android.support.graphics.drawable.i;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.ColorUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.LruCache;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.color;
import android.support.v7.appcompat.R.drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class AppCompatDrawableManager
{
  private static final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY;
  private static final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED;
  private static final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL;
  private static final ColorFilterLruCache COLOR_FILTER_CACHE;
  private static final boolean DEBUG = false;
  private static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
  private static AppCompatDrawableManager INSTANCE;
  private static final String PLATFORM_VD_CLAZZ = "android.graphics.drawable.VectorDrawable";
  private static final String SKIP_DRAWABLE_TAG = "appcompat_skip_skip";
  private static final String TAG = "AppCompatDrawableManag";
  private static final int[] TINT_CHECKABLE_BUTTON_LIST = arrayOfInt6;
  private static final int[] TINT_COLOR_CONTROL_NORMAL;
  private static final int[] TINT_COLOR_CONTROL_STATE_LIST;
  private ArrayMap<String, InflateDelegate> mDelegates;
  private final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> mDrawableCaches = new WeakHashMap(0);
  private boolean mHasCheckedVectorDrawableSetup;
  private SparseArrayCompat<String> mKnownDrawableIdTags;
  private WeakHashMap<Context, SparseArrayCompat<ColorStateList>> mTintLists;
  private TypedValue mTypedValue;

  static
  {
    COLOR_FILTER_CACHE = new ColorFilterLruCache(6);
    int[] arrayOfInt1 = new int[3];
    arrayOfInt1[0] = R.drawable.abc_textfield_search_default_mtrl_alpha;
    arrayOfInt1[1] = R.drawable.abc_textfield_default_mtrl_alpha;
    arrayOfInt1[2] = R.drawable.abc_ab_share_pack_mtrl_alpha;
    COLORFILTER_TINT_COLOR_CONTROL_NORMAL = arrayOfInt1;
    int[] arrayOfInt2 = new int[7];
    arrayOfInt2[0] = R.drawable.abc_ic_commit_search_api_mtrl_alpha;
    arrayOfInt2[1] = R.drawable.abc_seekbar_tick_mark_material;
    arrayOfInt2[2] = R.drawable.abc_ic_menu_share_mtrl_alpha;
    arrayOfInt2[3] = R.drawable.abc_ic_menu_copy_mtrl_am_alpha;
    arrayOfInt2[4] = R.drawable.abc_ic_menu_cut_mtrl_alpha;
    arrayOfInt2[5] = R.drawable.abc_ic_menu_selectall_mtrl_alpha;
    arrayOfInt2[6] = R.drawable.abc_ic_menu_paste_mtrl_am_alpha;
    TINT_COLOR_CONTROL_NORMAL = arrayOfInt2;
    int[] arrayOfInt3 = new int[10];
    arrayOfInt3[0] = R.drawable.abc_textfield_activated_mtrl_alpha;
    arrayOfInt3[1] = R.drawable.abc_textfield_search_activated_mtrl_alpha;
    arrayOfInt3[2] = R.drawable.abc_cab_background_top_mtrl_alpha;
    arrayOfInt3[3] = R.drawable.abc_text_cursor_material;
    arrayOfInt3[4] = R.drawable.abc_text_select_handle_left_mtrl_dark;
    arrayOfInt3[5] = R.drawable.abc_text_select_handle_middle_mtrl_dark;
    arrayOfInt3[6] = R.drawable.abc_text_select_handle_right_mtrl_dark;
    arrayOfInt3[7] = R.drawable.abc_text_select_handle_left_mtrl_light;
    arrayOfInt3[8] = R.drawable.abc_text_select_handle_middle_mtrl_light;
    arrayOfInt3[9] = R.drawable.abc_text_select_handle_right_mtrl_light;
    COLORFILTER_COLOR_CONTROL_ACTIVATED = arrayOfInt3;
    int[] arrayOfInt4 = new int[3];
    arrayOfInt4[0] = R.drawable.abc_popup_background_mtrl_mult;
    arrayOfInt4[1] = R.drawable.abc_cab_background_internal_bg;
    arrayOfInt4[2] = R.drawable.abc_menu_hardkey_panel_mtrl_mult;
    COLORFILTER_COLOR_BACKGROUND_MULTIPLY = arrayOfInt4;
    int[] arrayOfInt5 = new int[2];
    arrayOfInt5[0] = R.drawable.abc_tab_indicator_material;
    arrayOfInt5[1] = R.drawable.abc_textfield_search_material;
    TINT_COLOR_CONTROL_STATE_LIST = arrayOfInt5;
    int[] arrayOfInt6 = new int[2];
    arrayOfInt6[0] = R.drawable.abc_btn_check_material;
    arrayOfInt6[1] = R.drawable.abc_btn_radio_material;
  }

  private void addDelegate(String paramString, InflateDelegate paramInflateDelegate)
  {
    if (this.mDelegates == null)
      this.mDelegates = new ArrayMap();
    this.mDelegates.put(paramString, paramInflateDelegate);
  }

  private boolean addDrawableToCache(Context paramContext, long paramLong, Drawable paramDrawable)
  {
    try
    {
      Drawable.ConstantState localConstantState = paramDrawable.getConstantState();
      if (localConstantState != null)
      {
        LongSparseArray localLongSparseArray = (LongSparseArray)this.mDrawableCaches.get(paramContext);
        if (localLongSparseArray == null)
        {
          localLongSparseArray = new LongSparseArray();
          this.mDrawableCaches.put(paramContext, localLongSparseArray);
        }
        localLongSparseArray.put(paramLong, new WeakReference(localConstantState));
      }
      for (boolean bool = true; ; bool = false)
        return bool;
    }
    finally
    {
    }
  }

  private void addTintListToCache(Context paramContext, int paramInt, ColorStateList paramColorStateList)
  {
    if (this.mTintLists == null)
      this.mTintLists = new WeakHashMap();
    SparseArrayCompat localSparseArrayCompat = (SparseArrayCompat)this.mTintLists.get(paramContext);
    if (localSparseArrayCompat == null)
    {
      localSparseArrayCompat = new SparseArrayCompat();
      this.mTintLists.put(paramContext, localSparseArrayCompat);
    }
    localSparseArrayCompat.append(paramInt, paramColorStateList);
  }

  private static boolean arrayContains(int[] paramArrayOfInt, int paramInt)
  {
    int i = paramArrayOfInt.length;
    for (int j = 0; ; j++)
    {
      boolean bool = false;
      if (j < i)
      {
        if (paramArrayOfInt[j] == paramInt)
          bool = true;
      }
      else
        return bool;
    }
  }

  private void checkVectorDrawableSetup(Context paramContext)
  {
    if (this.mHasCheckedVectorDrawableSetup);
    Drawable localDrawable;
    do
    {
      return;
      this.mHasCheckedVectorDrawableSetup = true;
      localDrawable = getDrawable(paramContext, R.drawable.abc_vector_test);
    }
    while ((localDrawable != null) && (isVectorDrawable(localDrawable)));
    this.mHasCheckedVectorDrawableSetup = false;
    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
  }

  private ColorStateList createBorderlessButtonColorStateList(Context paramContext)
  {
    return createButtonColorStateList(paramContext, 0);
  }

  private ColorStateList createButtonColorStateList(Context paramContext, int paramInt)
  {
    int[][] arrayOfInt = new int[4][];
    int[] arrayOfInt1 = new int[4];
    int i = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlHighlight);
    int j = ThemeUtils.getDisabledThemeAttrColor(paramContext, R.attr.colorButtonNormal);
    arrayOfInt[0] = ThemeUtils.DISABLED_STATE_SET;
    arrayOfInt1[0] = j;
    arrayOfInt[1] = ThemeUtils.PRESSED_STATE_SET;
    arrayOfInt1[1] = ColorUtils.compositeColors(i, paramInt);
    arrayOfInt[2] = ThemeUtils.FOCUSED_STATE_SET;
    arrayOfInt1[2] = ColorUtils.compositeColors(i, paramInt);
    arrayOfInt[3] = ThemeUtils.EMPTY_STATE_SET;
    arrayOfInt1[3] = paramInt;
    return new ColorStateList(arrayOfInt, arrayOfInt1);
  }

  private static long createCacheKey(TypedValue paramTypedValue)
  {
    return paramTypedValue.assetCookie << 32 | paramTypedValue.data;
  }

  private ColorStateList createColoredButtonColorStateList(Context paramContext)
  {
    return createButtonColorStateList(paramContext, ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorAccent));
  }

  private ColorStateList createDefaultButtonColorStateList(Context paramContext)
  {
    return createButtonColorStateList(paramContext, ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorButtonNormal));
  }

  private Drawable createDrawableIfNeeded(Context paramContext, int paramInt)
  {
    if (this.mTypedValue == null)
      this.mTypedValue = new TypedValue();
    TypedValue localTypedValue = this.mTypedValue;
    paramContext.getResources().getValue(paramInt, localTypedValue, true);
    long l = createCacheKey(localTypedValue);
    Object localObject = getCachedDrawable(paramContext, l);
    if (localObject != null);
    do
    {
      return localObject;
      if (paramInt == R.drawable.abc_cab_background_top_material)
      {
        Drawable[] arrayOfDrawable = new Drawable[2];
        arrayOfDrawable[0] = getDrawable(paramContext, R.drawable.abc_cab_background_internal_bg);
        arrayOfDrawable[1] = getDrawable(paramContext, R.drawable.abc_cab_background_top_mtrl_alpha);
        localObject = new LayerDrawable(arrayOfDrawable);
      }
    }
    while (localObject == null);
    ((Drawable)localObject).setChangingConfigurations(localTypedValue.changingConfigurations);
    addDrawableToCache(paramContext, l, (Drawable)localObject);
    return localObject;
  }

  private ColorStateList createSwitchThumbColorStateList(Context paramContext)
  {
    int[][] arrayOfInt = new int[3][];
    int[] arrayOfInt1 = new int[3];
    ColorStateList localColorStateList = ThemeUtils.getThemeAttrColorStateList(paramContext, R.attr.colorSwitchThumbNormal);
    if ((localColorStateList != null) && (localColorStateList.isStateful()))
    {
      arrayOfInt[0] = ThemeUtils.DISABLED_STATE_SET;
      arrayOfInt1[0] = localColorStateList.getColorForState(arrayOfInt[0], 0);
      arrayOfInt[1] = ThemeUtils.CHECKED_STATE_SET;
      arrayOfInt1[1] = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated);
      arrayOfInt[2] = ThemeUtils.EMPTY_STATE_SET;
      arrayOfInt1[2] = localColorStateList.getDefaultColor();
    }
    while (true)
    {
      return new ColorStateList(arrayOfInt, arrayOfInt1);
      arrayOfInt[0] = ThemeUtils.DISABLED_STATE_SET;
      arrayOfInt1[0] = ThemeUtils.getDisabledThemeAttrColor(paramContext, R.attr.colorSwitchThumbNormal);
      arrayOfInt[1] = ThemeUtils.CHECKED_STATE_SET;
      arrayOfInt1[1] = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated);
      arrayOfInt[2] = ThemeUtils.EMPTY_STATE_SET;
      arrayOfInt1[2] = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorSwitchThumbNormal);
    }
  }

  private static PorterDuffColorFilter createTintFilter(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, int[] paramArrayOfInt)
  {
    if ((paramColorStateList == null) || (paramMode == null))
      return null;
    return getPorterDuffColorFilter(paramColorStateList.getColorForState(paramArrayOfInt, 0), paramMode);
  }

  public static AppCompatDrawableManager get()
  {
    try
    {
      if (INSTANCE == null)
      {
        INSTANCE = new AppCompatDrawableManager();
        installDefaultInflateDelegates(INSTANCE);
      }
      AppCompatDrawableManager localAppCompatDrawableManager = INSTANCE;
      return localAppCompatDrawableManager;
    }
    finally
    {
    }
  }

  private Drawable getCachedDrawable(Context paramContext, long paramLong)
  {
    try
    {
      LongSparseArray localLongSparseArray = (LongSparseArray)this.mDrawableCaches.get(paramContext);
      Drawable localDrawable;
      if (localLongSparseArray == null)
        localDrawable = null;
      while (true)
      {
        return localDrawable;
        WeakReference localWeakReference = (WeakReference)localLongSparseArray.get(paramLong);
        if (localWeakReference != null)
        {
          Drawable.ConstantState localConstantState = (Drawable.ConstantState)localWeakReference.get();
          if (localConstantState != null)
            localDrawable = localConstantState.newDrawable(paramContext.getResources());
          else
            localLongSparseArray.delete(paramLong);
        }
        else
        {
          localDrawable = null;
        }
      }
    }
    finally
    {
    }
  }

  public static PorterDuffColorFilter getPorterDuffColorFilter(int paramInt, PorterDuff.Mode paramMode)
  {
    try
    {
      PorterDuffColorFilter localPorterDuffColorFilter = COLOR_FILTER_CACHE.get(paramInt, paramMode);
      if (localPorterDuffColorFilter == null)
      {
        localPorterDuffColorFilter = new PorterDuffColorFilter(paramInt, paramMode);
        COLOR_FILTER_CACHE.put(paramInt, paramMode, localPorterDuffColorFilter);
      }
      return localPorterDuffColorFilter;
    }
    finally
    {
    }
  }

  private ColorStateList getTintListFromCache(Context paramContext, int paramInt)
  {
    if (this.mTintLists != null)
    {
      SparseArrayCompat localSparseArrayCompat = (SparseArrayCompat)this.mTintLists.get(paramContext);
      if (localSparseArrayCompat != null)
        return (ColorStateList)localSparseArrayCompat.get(paramInt);
      return null;
    }
    return null;
  }

  static PorterDuff.Mode getTintMode(int paramInt)
  {
    int i = R.drawable.abc_switch_thumb_material;
    PorterDuff.Mode localMode = null;
    if (paramInt == i)
      localMode = PorterDuff.Mode.MULTIPLY;
    return localMode;
  }

  private static void installDefaultInflateDelegates(AppCompatDrawableManager paramAppCompatDrawableManager)
  {
    if (Build.VERSION.SDK_INT < 24)
    {
      paramAppCompatDrawableManager.addDelegate("vector", new VdcInflateDelegate());
      paramAppCompatDrawableManager.addDelegate("animated-vector", new AvdcInflateDelegate());
      paramAppCompatDrawableManager.addDelegate("animated-selector", new AsldcInflateDelegate());
    }
  }

  private static boolean isVectorDrawable(Drawable paramDrawable)
  {
    return ((paramDrawable instanceof i)) || ("android.graphics.drawable.VectorDrawable".equals(paramDrawable.getClass().getName()));
  }

  private Drawable loadDrawableFromDelegates(Context paramContext, int paramInt)
  {
    if ((this.mDelegates != null) && (!this.mDelegates.isEmpty()))
    {
      Object localObject;
      if (this.mKnownDrawableIdTags != null)
      {
        String str2 = (String)this.mKnownDrawableIdTags.get(paramInt);
        if ((!"appcompat_skip_skip".equals(str2)) && ((str2 == null) || (this.mDelegates.get(str2) != null)))
          break label81;
        localObject = null;
      }
      while (true)
      {
        return localObject;
        this.mKnownDrawableIdTags = new SparseArrayCompat();
        label81: if (this.mTypedValue == null)
          this.mTypedValue = new TypedValue();
        TypedValue localTypedValue = this.mTypedValue;
        Resources localResources = paramContext.getResources();
        localResources.getValue(paramInt, localTypedValue, true);
        long l = createCacheKey(localTypedValue);
        Drawable localDrawable = getCachedDrawable(paramContext, l);
        if (localDrawable != null)
          return localDrawable;
        XmlResourceParser localXmlResourceParser;
        AttributeSet localAttributeSet;
        if ((localTypedValue.string != null) && (localTypedValue.string.toString().endsWith(".xml")))
          try
          {
            localXmlResourceParser = localResources.getXml(paramInt);
            localAttributeSet = Xml.asAttributeSet(localXmlResourceParser);
            int i;
            do
              i = localXmlResourceParser.next();
            while ((i != 2) && (i != 1));
            if (i != 2)
              throw new XmlPullParserException("No start tag found");
          }
          catch (Exception localException)
          {
            Log.e("AppCompatDrawableManag", "Exception while inflating drawable", localException);
          }
        for (localObject = localDrawable; localObject == null; localObject = localDrawable)
        {
          this.mKnownDrawableIdTags.append(paramInt, "appcompat_skip_skip");
          return localObject;
          String str1 = localXmlResourceParser.getName();
          this.mKnownDrawableIdTags.append(paramInt, str1);
          InflateDelegate localInflateDelegate = (InflateDelegate)this.mDelegates.get(str1);
          if (localInflateDelegate != null)
            localDrawable = localInflateDelegate.createFromXmlInner(paramContext, localXmlResourceParser, localAttributeSet, paramContext.getTheme());
          if (localDrawable != null)
          {
            localDrawable.setChangingConfigurations(localTypedValue.changingConfigurations);
            boolean bool = addDrawableToCache(paramContext, l, localDrawable);
            if (!bool);
          }
        }
      }
    }
    return null;
  }

  private void removeDelegate(String paramString, InflateDelegate paramInflateDelegate)
  {
    if ((this.mDelegates != null) && (this.mDelegates.get(paramString) == paramInflateDelegate))
      this.mDelegates.remove(paramString);
  }

  private static void setPorterDuffColorFilter(Drawable paramDrawable, int paramInt, PorterDuff.Mode paramMode)
  {
    if (DrawableUtils.canSafelyMutateDrawable(paramDrawable))
      paramDrawable = paramDrawable.mutate();
    if (paramMode == null)
      paramMode = DEFAULT_MODE;
    paramDrawable.setColorFilter(getPorterDuffColorFilter(paramInt, paramMode));
  }

  private Drawable tintDrawable(Context paramContext, int paramInt, boolean paramBoolean, Drawable paramDrawable)
  {
    ColorStateList localColorStateList = getTintList(paramContext, paramInt);
    if (localColorStateList != null)
    {
      if (DrawableUtils.canSafelyMutateDrawable(paramDrawable))
        paramDrawable = paramDrawable.mutate();
      paramDrawable = DrawableCompat.wrap(paramDrawable);
      DrawableCompat.setTintList(paramDrawable, localColorStateList);
      PorterDuff.Mode localMode = getTintMode(paramInt);
      if (localMode != null)
        DrawableCompat.setTintMode(paramDrawable, localMode);
    }
    do
    {
      return paramDrawable;
      if (paramInt == R.drawable.abc_seekbar_track_material)
      {
        LayerDrawable localLayerDrawable2 = (LayerDrawable)paramDrawable;
        setPorterDuffColorFilter(localLayerDrawable2.findDrawableByLayerId(16908288), ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlNormal), DEFAULT_MODE);
        setPorterDuffColorFilter(localLayerDrawable2.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlNormal), DEFAULT_MODE);
        setPorterDuffColorFilter(localLayerDrawable2.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated), DEFAULT_MODE);
        return paramDrawable;
      }
      if ((paramInt == R.drawable.abc_ratingbar_material) || (paramInt == R.drawable.abc_ratingbar_indicator_material) || (paramInt == R.drawable.abc_ratingbar_small_material))
      {
        LayerDrawable localLayerDrawable1 = (LayerDrawable)paramDrawable;
        setPorterDuffColorFilter(localLayerDrawable1.findDrawableByLayerId(16908288), ThemeUtils.getDisabledThemeAttrColor(paramContext, R.attr.colorControlNormal), DEFAULT_MODE);
        setPorterDuffColorFilter(localLayerDrawable1.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated), DEFAULT_MODE);
        setPorterDuffColorFilter(localLayerDrawable1.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated), DEFAULT_MODE);
        return paramDrawable;
      }
    }
    while ((tintDrawableUsingColorFilter(paramContext, paramInt, paramDrawable)) || (!paramBoolean));
    return null;
  }

  static void tintDrawable(Drawable paramDrawable, TintInfo paramTintInfo, int[] paramArrayOfInt)
  {
    if ((DrawableUtils.canSafelyMutateDrawable(paramDrawable)) && (paramDrawable.mutate() != paramDrawable))
      Log.d("AppCompatDrawableManag", "Mutated drawable is not the same instance as the input.");
    label64: label93: label106: 
    while (true)
    {
      return;
      ColorStateList localColorStateList;
      PorterDuff.Mode localMode;
      if ((paramTintInfo.mHasTintList) || (paramTintInfo.mHasTintMode))
        if (paramTintInfo.mHasTintList)
        {
          localColorStateList = paramTintInfo.mTintList;
          if (!paramTintInfo.mHasTintMode)
            break label93;
          localMode = paramTintInfo.mTintMode;
          paramDrawable.setColorFilter(createTintFilter(localColorStateList, localMode, paramArrayOfInt));
        }
      while (true)
      {
        if (Build.VERSION.SDK_INT > 23)
          break label106;
        paramDrawable.invalidateSelf();
        return;
        localColorStateList = null;
        break;
        localMode = DEFAULT_MODE;
        break label64;
        paramDrawable.clearColorFilter();
      }
    }
  }

  static boolean tintDrawableUsingColorFilter(Context paramContext, int paramInt, Drawable paramDrawable)
  {
    PorterDuff.Mode localMode1 = DEFAULT_MODE;
    int j;
    Object localObject;
    int k;
    int i;
    if (arrayContains(COLORFILTER_TINT_COLOR_CONTROL_NORMAL, paramInt))
    {
      j = R.attr.colorControlNormal;
      localObject = localMode1;
      k = 1;
      i = -1;
    }
    while (true)
      if (k != 0)
      {
        if (DrawableUtils.canSafelyMutateDrawable(paramDrawable))
          paramDrawable = paramDrawable.mutate();
        paramDrawable.setColorFilter(getPorterDuffColorFilter(ThemeUtils.getThemeAttrColor(paramContext, j), (PorterDuff.Mode)localObject));
        if (i != -1)
          paramDrawable.setAlpha(i);
        return true;
        if (arrayContains(COLORFILTER_COLOR_CONTROL_ACTIVATED, paramInt))
        {
          j = R.attr.colorControlActivated;
          localObject = localMode1;
          k = 1;
          i = -1;
        }
        else if (arrayContains(COLORFILTER_COLOR_BACKGROUND_MULTIPLY, paramInt))
        {
          PorterDuff.Mode localMode2 = PorterDuff.Mode.MULTIPLY;
          k = 1;
          localObject = localMode2;
          j = 16842801;
          i = -1;
        }
        else if (paramInt == R.drawable.abc_list_divider_mtrl_alpha)
        {
          j = 16842800;
          i = Math.round(40.799999F);
          localObject = localMode1;
          k = 1;
        }
        else if (paramInt == R.drawable.abc_dialog_material_background)
        {
          j = 16842801;
          localObject = localMode1;
          k = 1;
          i = -1;
        }
      }
      else
      {
        return false;
        i = -1;
        localObject = localMode1;
        j = 0;
        k = 0;
      }
  }

  public Drawable getDrawable(Context paramContext, int paramInt)
  {
    try
    {
      Drawable localDrawable = getDrawable(paramContext, paramInt, false);
      return localDrawable;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  Drawable getDrawable(Context paramContext, int paramInt, boolean paramBoolean)
  {
    try
    {
      checkVectorDrawableSetup(paramContext);
      Drawable localDrawable = loadDrawableFromDelegates(paramContext, paramInt);
      if (localDrawable == null)
        localDrawable = createDrawableIfNeeded(paramContext, paramInt);
      if (localDrawable == null)
        localDrawable = ContextCompat.getDrawable(paramContext, paramInt);
      if (localDrawable != null)
        localDrawable = tintDrawable(paramContext, paramInt, paramBoolean, localDrawable);
      if (localDrawable != null)
        DrawableUtils.fixDrawable(localDrawable);
      return localDrawable;
    }
    finally
    {
    }
  }

  ColorStateList getTintList(Context paramContext, int paramInt)
  {
    try
    {
      Object localObject2 = getTintListFromCache(paramContext, paramInt);
      if (localObject2 == null)
      {
        if (paramInt != R.drawable.abc_edit_text_material)
          break label49;
        localObject2 = android.support.v7.a.a.a.a(paramContext, R.color.abc_tint_edittext);
      }
      while (true)
      {
        if (localObject2 != null)
          addTintListToCache(paramContext, paramInt, (ColorStateList)localObject2);
        return localObject2;
        label49: if (paramInt == R.drawable.abc_switch_track_mtrl_alpha)
        {
          localObject2 = android.support.v7.a.a.a.a(paramContext, R.color.abc_tint_switch_track);
        }
        else if (paramInt == R.drawable.abc_switch_thumb_material)
        {
          localObject2 = createSwitchThumbColorStateList(paramContext);
        }
        else if (paramInt == R.drawable.abc_btn_default_mtrl_shape)
        {
          localObject2 = createDefaultButtonColorStateList(paramContext);
        }
        else if (paramInt == R.drawable.abc_btn_borderless_material)
        {
          localObject2 = createBorderlessButtonColorStateList(paramContext);
        }
        else if (paramInt == R.drawable.abc_btn_colored_material)
        {
          localObject2 = createColoredButtonColorStateList(paramContext);
        }
        else if ((paramInt == R.drawable.abc_spinner_mtrl_am_alpha) || (paramInt == R.drawable.abc_spinner_textfield_background_material))
        {
          localObject2 = android.support.v7.a.a.a.a(paramContext, R.color.abc_tint_spinner);
        }
        else if (arrayContains(TINT_COLOR_CONTROL_NORMAL, paramInt))
        {
          localObject2 = ThemeUtils.getThemeAttrColorStateList(paramContext, R.attr.colorControlNormal);
        }
        else if (arrayContains(TINT_COLOR_CONTROL_STATE_LIST, paramInt))
        {
          localObject2 = android.support.v7.a.a.a.a(paramContext, R.color.abc_tint_default);
        }
        else if (arrayContains(TINT_CHECKABLE_BUTTON_LIST, paramInt))
        {
          localObject2 = android.support.v7.a.a.a.a(paramContext, R.color.abc_tint_btn_checkable);
        }
        else if (paramInt == R.drawable.abc_seekbar_thumb_material)
        {
          ColorStateList localColorStateList = android.support.v7.a.a.a.a(paramContext, R.color.abc_tint_seek_thumb);
          localObject2 = localColorStateList;
        }
      }
    }
    finally
    {
    }
  }

  public void onConfigurationChanged(Context paramContext)
  {
    try
    {
      LongSparseArray localLongSparseArray = (LongSparseArray)this.mDrawableCaches.get(paramContext);
      if (localLongSparseArray != null)
        localLongSparseArray.clear();
      return;
    }
    finally
    {
    }
  }

  Drawable onDrawableLoadedFromResources(Context paramContext, VectorEnabledTintResources paramVectorEnabledTintResources, int paramInt)
  {
    try
    {
      Drawable localDrawable1 = loadDrawableFromDelegates(paramContext, paramInt);
      if (localDrawable1 == null)
        localDrawable1 = paramVectorEnabledTintResources.superGetDrawable(paramInt);
      Drawable localDrawable2;
      if (localDrawable1 != null)
        localDrawable2 = tintDrawable(paramContext, paramInt, false, localDrawable1);
      for (Drawable localDrawable3 = localDrawable2; ; localDrawable3 = null)
        return localDrawable3;
    }
    finally
    {
    }
  }

  static class AsldcInflateDelegate
    implements AppCompatDrawableManager.InflateDelegate
  {
    public Drawable createFromXmlInner(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    {
      try
      {
        android.support.v7.b.a.a locala = android.support.v7.b.a.a.a(paramContext, paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
        return locala;
      }
      catch (Exception localException)
      {
        Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", localException);
      }
      return null;
    }
  }

  private static class AvdcInflateDelegate
    implements AppCompatDrawableManager.InflateDelegate
  {
    public Drawable createFromXmlInner(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    {
      try
      {
        c localc = c.a(paramContext, paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
        return localc;
      }
      catch (Exception localException)
      {
        Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", localException);
      }
      return null;
    }
  }

  private static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter>
  {
    public ColorFilterLruCache(int paramInt)
    {
      super();
    }

    private static int generateCacheKey(int paramInt, PorterDuff.Mode paramMode)
    {
      return 31 * (paramInt + 31) + paramMode.hashCode();
    }

    PorterDuffColorFilter get(int paramInt, PorterDuff.Mode paramMode)
    {
      return (PorterDuffColorFilter)get(Integer.valueOf(generateCacheKey(paramInt, paramMode)));
    }

    PorterDuffColorFilter put(int paramInt, PorterDuff.Mode paramMode, PorterDuffColorFilter paramPorterDuffColorFilter)
    {
      return (PorterDuffColorFilter)put(Integer.valueOf(generateCacheKey(paramInt, paramMode)), paramPorterDuffColorFilter);
    }
  }

  private static abstract interface InflateDelegate
  {
    public abstract Drawable createFromXmlInner(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme);
  }

  private static class VdcInflateDelegate
    implements AppCompatDrawableManager.InflateDelegate
  {
    public Drawable createFromXmlInner(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    {
      try
      {
        i locali = i.a(paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
        return locali;
      }
      catch (Exception localException)
      {
        Log.e("VdcInflateDelegate", "Exception while inflating <vector>", localException);
      }
      return null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.AppCompatDrawableManager
 * JD-Core Version:    0.6.2
 */