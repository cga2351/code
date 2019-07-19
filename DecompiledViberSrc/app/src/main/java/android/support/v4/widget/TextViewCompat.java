package android.support.v4.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.text.PrecomputedTextCompat;
import android.support.v4.text.PrecomputedTextCompat.Params;
import android.support.v4.text.PrecomputedTextCompat.Params.Builder;
import android.support.v4.util.Preconditions;
import android.text.Editable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class TextViewCompat
{
  public static final int AUTO_SIZE_TEXT_TYPE_NONE = 0;
  public static final int AUTO_SIZE_TEXT_TYPE_UNIFORM = 1;
  private static final int LINES = 1;
  private static final String LOG_TAG = "TextViewCompat";
  private static Field sMaxModeField;
  private static boolean sMaxModeFieldFetched;
  private static Field sMaximumField;
  private static boolean sMaximumFieldFetched;
  private static Field sMinModeField;
  private static boolean sMinModeFieldFetched;
  private static Field sMinimumField;
  private static boolean sMinimumFieldFetched;

  public static int getAutoSizeMaxTextSize(TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 27)
      return paramTextView.getAutoSizeMaxTextSize();
    if ((paramTextView instanceof AutoSizeableTextView))
      return ((AutoSizeableTextView)paramTextView).getAutoSizeMaxTextSize();
    return -1;
  }

  public static int getAutoSizeMinTextSize(TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 27)
      return paramTextView.getAutoSizeMinTextSize();
    if ((paramTextView instanceof AutoSizeableTextView))
      return ((AutoSizeableTextView)paramTextView).getAutoSizeMinTextSize();
    return -1;
  }

  public static int getAutoSizeStepGranularity(TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 27)
      return paramTextView.getAutoSizeStepGranularity();
    if ((paramTextView instanceof AutoSizeableTextView))
      return ((AutoSizeableTextView)paramTextView).getAutoSizeStepGranularity();
    return -1;
  }

  public static int[] getAutoSizeTextAvailableSizes(TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 27)
      return paramTextView.getAutoSizeTextAvailableSizes();
    if ((paramTextView instanceof AutoSizeableTextView))
      return ((AutoSizeableTextView)paramTextView).getAutoSizeTextAvailableSizes();
    return new int[0];
  }

  public static int getAutoSizeTextType(TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 27)
      return paramTextView.getAutoSizeTextType();
    if ((paramTextView instanceof AutoSizeableTextView))
      return ((AutoSizeableTextView)paramTextView).getAutoSizeTextType();
    return 0;
  }

  public static Drawable[] getCompoundDrawablesRelative(TextView paramTextView)
  {
    int i = 1;
    if (Build.VERSION.SDK_INT >= 18)
      return paramTextView.getCompoundDrawablesRelative();
    if (Build.VERSION.SDK_INT >= 17)
    {
      if (paramTextView.getLayoutDirection() == i);
      while (true)
      {
        Drawable[] arrayOfDrawable = paramTextView.getCompoundDrawables();
        if (i != 0)
        {
          Drawable localDrawable1 = arrayOfDrawable[2];
          Drawable localDrawable2 = arrayOfDrawable[0];
          arrayOfDrawable[0] = localDrawable1;
          arrayOfDrawable[2] = localDrawable2;
        }
        return arrayOfDrawable;
        i = 0;
      }
    }
    return paramTextView.getCompoundDrawables();
  }

  public static int getFirstBaselineToTopHeight(TextView paramTextView)
  {
    return paramTextView.getPaddingTop() - paramTextView.getPaint().getFontMetricsInt().top;
  }

  public static int getLastBaselineToBottomHeight(TextView paramTextView)
  {
    return paramTextView.getPaddingBottom() + paramTextView.getPaint().getFontMetricsInt().bottom;
  }

  public static int getMaxLines(TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 16)
      return paramTextView.getMaxLines();
    if (!sMaxModeFieldFetched)
    {
      sMaxModeField = retrieveField("mMaxMode");
      sMaxModeFieldFetched = true;
    }
    if ((sMaxModeField != null) && (retrieveIntFromField(sMaxModeField, paramTextView) == 1))
    {
      if (!sMaximumFieldFetched)
      {
        sMaximumField = retrieveField("mMaximum");
        sMaximumFieldFetched = true;
      }
      if (sMaximumField != null)
        return retrieveIntFromField(sMaximumField, paramTextView);
    }
    return -1;
  }

  public static int getMinLines(TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 16)
      return paramTextView.getMinLines();
    if (!sMinModeFieldFetched)
    {
      sMinModeField = retrieveField("mMinMode");
      sMinModeFieldFetched = true;
    }
    if ((sMinModeField != null) && (retrieveIntFromField(sMinModeField, paramTextView) == 1))
    {
      if (!sMinimumFieldFetched)
      {
        sMinimumField = retrieveField("mMinimum");
        sMinimumFieldFetched = true;
      }
      if (sMinimumField != null)
        return retrieveIntFromField(sMinimumField, paramTextView);
    }
    return -1;
  }

  private static int getTextDirection(TextDirectionHeuristic paramTextDirectionHeuristic)
  {
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL);
    do
    {
      do
        return 1;
      while (paramTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR);
      if (paramTextDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR)
        return 2;
      if (paramTextDirectionHeuristic == TextDirectionHeuristics.LTR)
        return 3;
      if (paramTextDirectionHeuristic == TextDirectionHeuristics.RTL)
        return 4;
      if (paramTextDirectionHeuristic == TextDirectionHeuristics.LOCALE)
        return 5;
      if (paramTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR)
        return 6;
    }
    while (paramTextDirectionHeuristic != TextDirectionHeuristics.FIRSTSTRONG_RTL);
    return 7;
  }

  private static TextDirectionHeuristic getTextDirectionHeuristic(TextView paramTextView)
  {
    int i = 1;
    if ((paramTextView.getTransformationMethod() instanceof PasswordTransformationMethod))
      return TextDirectionHeuristics.LTR;
    if ((Build.VERSION.SDK_INT >= 28) && ((0xF & paramTextView.getInputType()) == 3))
    {
      int j = Character.getDirectionality(android.icu.text.DecimalFormatSymbols.getInstance(paramTextView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
      if ((j == i) || (j == 2))
        return TextDirectionHeuristics.RTL;
      return TextDirectionHeuristics.LTR;
    }
    if (paramTextView.getLayoutDirection() == i);
    while (true)
      switch (paramTextView.getTextDirection())
      {
      default:
        if (i == 0)
          break label137;
        return TextDirectionHeuristics.FIRSTSTRONG_RTL;
        i = 0;
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      }
    label137: return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    return TextDirectionHeuristics.ANYRTL_LTR;
    return TextDirectionHeuristics.LTR;
    return TextDirectionHeuristics.RTL;
    return TextDirectionHeuristics.LOCALE;
    return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    return TextDirectionHeuristics.FIRSTSTRONG_RTL;
  }

  public static PrecomputedTextCompat.Params getTextMetricsParams(TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 28)
      return new PrecomputedTextCompat.Params(paramTextView.getTextMetricsParams());
    PrecomputedTextCompat.Params.Builder localBuilder = new PrecomputedTextCompat.Params.Builder(new TextPaint(paramTextView.getPaint()));
    if (Build.VERSION.SDK_INT >= 23)
    {
      localBuilder.setBreakStrategy(paramTextView.getBreakStrategy());
      localBuilder.setHyphenationFrequency(paramTextView.getHyphenationFrequency());
    }
    if (Build.VERSION.SDK_INT >= 18)
      localBuilder.setTextDirection(getTextDirectionHeuristic(paramTextView));
    return localBuilder.build();
  }

  private static Field retrieveField(String paramString)
  {
    Field localField = null;
    try
    {
      localField = TextView.class.getDeclaredField(paramString);
      localField.setAccessible(true);
      return localField;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      Log.e("TextViewCompat", "Could not retrieve " + paramString + " field.");
    }
    return localField;
  }

  private static int retrieveIntFromField(Field paramField, TextView paramTextView)
  {
    try
    {
      int i = paramField.getInt(paramTextView);
      return i;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Log.d("TextViewCompat", "Could not retrieve value of " + paramField.getName() + " field.");
    }
    return -1;
  }

  public static void setAutoSizeTextTypeUniformWithConfiguration(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IllegalArgumentException
  {
    if (Build.VERSION.SDK_INT >= 27)
      paramTextView.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
    while (!(paramTextView instanceof AutoSizeableTextView))
      return;
    ((AutoSizeableTextView)paramTextView).setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public static void setAutoSizeTextTypeUniformWithPresetSizes(TextView paramTextView, int[] paramArrayOfInt, int paramInt)
    throws IllegalArgumentException
  {
    if (Build.VERSION.SDK_INT >= 27)
      paramTextView.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
    while (!(paramTextView instanceof AutoSizeableTextView))
      return;
    ((AutoSizeableTextView)paramTextView).setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
  }

  public static void setAutoSizeTextTypeWithDefaults(TextView paramTextView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 27)
      paramTextView.setAutoSizeTextTypeWithDefaults(paramInt);
    while (!(paramTextView instanceof AutoSizeableTextView))
      return;
    ((AutoSizeableTextView)paramTextView).setAutoSizeTextTypeWithDefaults(paramInt);
  }

  public static void setCompoundDrawablesRelative(TextView paramTextView, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramTextView.setCompoundDrawablesRelative(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      int i;
      Drawable localDrawable;
      if (paramTextView.getLayoutDirection() == 1)
      {
        i = 1;
        if (i == 0)
          break label67;
        localDrawable = paramDrawable3;
        label45: if (i == 0)
          break label73;
      }
      while (true)
      {
        paramTextView.setCompoundDrawables(localDrawable, paramDrawable2, paramDrawable1, paramDrawable4);
        return;
        i = 0;
        break;
        label67: localDrawable = paramDrawable1;
        break label45;
        label73: paramDrawable1 = paramDrawable3;
      }
    }
    paramTextView.setCompoundDrawables(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }

  public static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      int i;
      int j;
      if (paramTextView.getLayoutDirection() == 1)
      {
        i = 1;
        if (i == 0)
          break label67;
        j = paramInt3;
        label45: if (i == 0)
          break label73;
      }
      while (true)
      {
        paramTextView.setCompoundDrawablesWithIntrinsicBounds(j, paramInt2, paramInt1, paramInt4);
        return;
        i = 0;
        break;
        label67: j = paramInt1;
        break label45;
        label73: paramInt1 = paramInt3;
      }
    }
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView paramTextView, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      int i;
      Drawable localDrawable;
      if (paramTextView.getLayoutDirection() == 1)
      {
        i = 1;
        if (i == 0)
          break label67;
        localDrawable = paramDrawable3;
        label45: if (i == 0)
          break label73;
      }
      while (true)
      {
        paramTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, paramDrawable2, paramDrawable1, paramDrawable4);
        return;
        i = 0;
        break;
        label67: localDrawable = paramDrawable1;
        break label45;
        label73: paramDrawable1 = paramDrawable3;
      }
    }
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }

  public static void setCustomSelectionActionModeCallback(TextView paramTextView, ActionMode.Callback paramCallback)
  {
    paramTextView.setCustomSelectionActionModeCallback(wrapCustomSelectionActionModeCallback(paramTextView, paramCallback));
  }

  public static void setFirstBaselineToTopHeight(TextView paramTextView, int paramInt)
  {
    Preconditions.checkArgumentNonnegative(paramInt);
    if (Build.VERSION.SDK_INT >= 28)
      paramTextView.setFirstBaselineToTopHeight(paramInt);
    while (true)
    {
      return;
      Paint.FontMetricsInt localFontMetricsInt = paramTextView.getPaint().getFontMetricsInt();
      if ((Build.VERSION.SDK_INT < 16) || (paramTextView.getIncludeFontPadding()));
      for (int i = localFontMetricsInt.top; paramInt > Math.abs(i); i = localFontMetricsInt.ascent)
      {
        int j = paramInt - -i;
        paramTextView.setPadding(paramTextView.getPaddingLeft(), j, paramTextView.getPaddingRight(), paramTextView.getPaddingBottom());
        return;
      }
    }
  }

  public static void setLastBaselineToBottomHeight(TextView paramTextView, int paramInt)
  {
    Preconditions.checkArgumentNonnegative(paramInt);
    Paint.FontMetricsInt localFontMetricsInt = paramTextView.getPaint().getFontMetricsInt();
    if ((Build.VERSION.SDK_INT < 16) || (paramTextView.getIncludeFontPadding()));
    for (int i = localFontMetricsInt.bottom; ; i = localFontMetricsInt.descent)
    {
      if (paramInt > Math.abs(i))
      {
        int j = paramInt - i;
        paramTextView.setPadding(paramTextView.getPaddingLeft(), paramTextView.getPaddingTop(), paramTextView.getPaddingRight(), j);
      }
      return;
    }
  }

  public static void setLineHeight(TextView paramTextView, int paramInt)
  {
    Preconditions.checkArgumentNonnegative(paramInt);
    int i = paramTextView.getPaint().getFontMetricsInt(null);
    if (paramInt != i)
      paramTextView.setLineSpacing(paramInt - i, 1.0F);
  }

  public static void setPrecomputedText(TextView paramTextView, PrecomputedTextCompat paramPrecomputedTextCompat)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      paramTextView.setText(paramPrecomputedTextCompat.getPrecomputedText());
      return;
    }
    if (!getTextMetricsParams(paramTextView).equals(paramPrecomputedTextCompat.getParams()))
      throw new IllegalArgumentException("Given text can not be applied to TextView.");
    paramTextView.setText(paramPrecomputedTextCompat);
  }

  public static void setTextAppearance(TextView paramTextView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramTextView.setTextAppearance(paramInt);
      return;
    }
    paramTextView.setTextAppearance(paramTextView.getContext(), paramInt);
  }

  public static void setTextMetricsParams(TextView paramTextView, PrecomputedTextCompat.Params paramParams)
  {
    if (Build.VERSION.SDK_INT >= 18)
      paramTextView.setTextDirection(getTextDirection(paramParams.getTextDirection()));
    if (Build.VERSION.SDK_INT < 23)
    {
      float f = paramParams.getTextPaint().getTextScaleX();
      paramTextView.getPaint().set(paramParams.getTextPaint());
      if (f == paramTextView.getTextScaleX())
        paramTextView.setTextScaleX(1.0F + f / 2.0F);
      paramTextView.setTextScaleX(f);
      return;
    }
    paramTextView.getPaint().set(paramParams.getTextPaint());
    paramTextView.setBreakStrategy(paramParams.getBreakStrategy());
    paramTextView.setHyphenationFrequency(paramParams.getHyphenationFrequency());
  }

  public static ActionMode.Callback wrapCustomSelectionActionModeCallback(TextView paramTextView, ActionMode.Callback paramCallback)
  {
    if ((Build.VERSION.SDK_INT < 26) || (Build.VERSION.SDK_INT > 27) || ((paramCallback instanceof OreoCallback)))
      return paramCallback;
    return new OreoCallback(paramCallback, paramTextView);
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface AutoSizeTextType
  {
  }

  private static class OreoCallback
    implements ActionMode.Callback
  {
    private static final int MENU_ITEM_ORDER_PROCESS_TEXT_INTENT_ACTIONS_START = 100;
    private final ActionMode.Callback mCallback;
    private boolean mCanUseMenuBuilderReferences;
    private boolean mInitializedMenuBuilderReferences;
    private Class mMenuBuilderClass;
    private Method mMenuBuilderRemoveItemAtMethod;
    private final TextView mTextView;

    OreoCallback(ActionMode.Callback paramCallback, TextView paramTextView)
    {
      this.mCallback = paramCallback;
      this.mTextView = paramTextView;
      this.mInitializedMenuBuilderReferences = false;
    }

    private Intent createProcessTextIntent()
    {
      return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
    }

    private Intent createProcessTextIntentForResolveInfo(ResolveInfo paramResolveInfo, TextView paramTextView)
    {
      Intent localIntent = createProcessTextIntent();
      if (!isEditable(paramTextView));
      for (boolean bool = true; ; bool = false)
        return localIntent.putExtra("android.intent.extra.PROCESS_TEXT_READONLY", bool).setClassName(paramResolveInfo.activityInfo.packageName, paramResolveInfo.activityInfo.name);
    }

    private List<ResolveInfo> getSupportedActivities(Context paramContext, PackageManager paramPackageManager)
    {
      ArrayList localArrayList = new ArrayList();
      if (!(paramContext instanceof Activity))
        return localArrayList;
      Iterator localIterator = paramPackageManager.queryIntentActivities(createProcessTextIntent(), 0).iterator();
      while (localIterator.hasNext())
      {
        ResolveInfo localResolveInfo = (ResolveInfo)localIterator.next();
        if (isSupportedActivity(localResolveInfo, paramContext))
          localArrayList.add(localResolveInfo);
      }
      return localArrayList;
    }

    private boolean isEditable(TextView paramTextView)
    {
      return ((paramTextView instanceof Editable)) && (paramTextView.onCheckIsTextEditor()) && (paramTextView.isEnabled());
    }

    private boolean isSupportedActivity(ResolveInfo paramResolveInfo, Context paramContext)
    {
      boolean bool2;
      if (paramContext.getPackageName().equals(paramResolveInfo.activityInfo.packageName))
        bool2 = true;
      int i;
      do
      {
        boolean bool1;
        do
        {
          return bool2;
          bool1 = paramResolveInfo.activityInfo.exported;
          bool2 = false;
        }
        while (!bool1);
        if (paramResolveInfo.activityInfo.permission == null)
          break;
        i = paramContext.checkSelfPermission(paramResolveInfo.activityInfo.permission);
        bool2 = false;
      }
      while (i != 0);
      return true;
    }

    private void recomputeProcessTextMenuItems(Menu paramMenu)
    {
      Context localContext = this.mTextView.getContext();
      PackageManager localPackageManager = localContext.getPackageManager();
      if (!this.mInitializedMenuBuilderReferences)
        this.mInitializedMenuBuilderReferences = true;
      try
      {
        this.mMenuBuilderClass = Class.forName("com.android.internal.view.menu.MenuBuilder");
        Class localClass2 = this.mMenuBuilderClass;
        Class[] arrayOfClass2 = new Class[1];
        arrayOfClass2[0] = Integer.TYPE;
        this.mMenuBuilderRemoveItemAtMethod = localClass2.getDeclaredMethod("removeItemAt", arrayOfClass2);
        this.mCanUseMenuBuilderReferences = true;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        try
        {
          if ((this.mCanUseMenuBuilderReferences) && (this.mMenuBuilderClass.isInstance(paramMenu)));
          Method localMethod;
          for (Object localObject = this.mMenuBuilderRemoveItemAtMethod; ; localObject = localMethod)
          {
            for (int i = -1 + paramMenu.size(); i >= 0; i--)
            {
              MenuItem localMenuItem = paramMenu.getItem(i);
              if ((localMenuItem.getIntent() != null) && ("android.intent.action.PROCESS_TEXT".equals(localMenuItem.getIntent().getAction())))
              {
                Object[] arrayOfObject = new Object[1];
                arrayOfObject[0] = Integer.valueOf(i);
                ((Method)localObject).invoke(paramMenu, arrayOfObject);
              }
            }
            localClassNotFoundException = localClassNotFoundException;
            this.mMenuBuilderClass = null;
            this.mMenuBuilderRemoveItemAtMethod = null;
            this.mCanUseMenuBuilderReferences = false;
            break;
            Class localClass1 = paramMenu.getClass();
            Class[] arrayOfClass1 = new Class[1];
            arrayOfClass1[0] = Integer.TYPE;
            localMethod = localClass1.getDeclaredMethod("removeItemAt", arrayOfClass1);
          }
          List localList = getSupportedActivities(localContext, localPackageManager);
          for (int j = 0; j < localList.size(); j++)
          {
            ResolveInfo localResolveInfo = (ResolveInfo)localList.get(j);
            paramMenu.add(0, 0, j + 100, localResolveInfo.loadLabel(localPackageManager)).setIntent(createProcessTextIntentForResolveInfo(localResolveInfo, this.mTextView)).setShowAsAction(1);
          }
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
        }
        catch (NoSuchMethodException localNoSuchMethodException1)
        {
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        label180: break label180;
      }
    }

    public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
    {
      return this.mCallback.onActionItemClicked(paramActionMode, paramMenuItem);
    }

    public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      return this.mCallback.onCreateActionMode(paramActionMode, paramMenu);
    }

    public void onDestroyActionMode(ActionMode paramActionMode)
    {
      this.mCallback.onDestroyActionMode(paramActionMode);
    }

    public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      recomputeProcessTextMenuItems(paramMenu);
      return this.mCallback.onPrepareActionMode(paramActionMode, paramMenu);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.widget.TextViewCompat
 * JD-Core Version:    0.6.2
 */