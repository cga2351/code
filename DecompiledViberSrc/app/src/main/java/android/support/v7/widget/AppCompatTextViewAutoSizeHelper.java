package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.v7.appcompat.R.styleable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class AppCompatTextViewAutoSizeHelper
{
  private static final int DEFAULT_AUTO_SIZE_GRANULARITY_IN_PX = 1;
  private static final int DEFAULT_AUTO_SIZE_MAX_TEXT_SIZE_IN_SP = 112;
  private static final int DEFAULT_AUTO_SIZE_MIN_TEXT_SIZE_IN_SP = 12;
  private static final String TAG = "ACTVAutoSizeHelper";
  private static final RectF TEMP_RECTF = new RectF();
  static final float UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE = -1.0F;
  private static final int VERY_WIDE = 1048576;
  private static ConcurrentHashMap<String, Method> sTextViewMethodByNameCache = new ConcurrentHashMap();
  private float mAutoSizeMaxTextSizeInPx = -1.0F;
  private float mAutoSizeMinTextSizeInPx = -1.0F;
  private float mAutoSizeStepGranularityInPx = -1.0F;
  private int[] mAutoSizeTextSizesInPx = new int[0];
  private int mAutoSizeTextType = 0;
  private final Context mContext;
  private boolean mHasPresetAutoSizeValues = false;
  private boolean mNeedsAutoSizeText = false;
  private TextPaint mTempTextPaint;
  private final TextView mTextView;

  AppCompatTextViewAutoSizeHelper(TextView paramTextView)
  {
    this.mTextView = paramTextView;
    this.mContext = this.mTextView.getContext();
  }

  private int[] cleanupAutoSizePresetSizes(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    if (i == 0);
    while (true)
    {
      return paramArrayOfInt;
      Arrays.sort(paramArrayOfInt);
      ArrayList localArrayList = new ArrayList();
      for (int j = 0; j < i; j++)
      {
        int n = paramArrayOfInt[j];
        if ((n > 0) && (Collections.binarySearch(localArrayList, Integer.valueOf(n)) < 0))
          localArrayList.add(Integer.valueOf(n));
      }
      if (i != localArrayList.size())
      {
        int k = localArrayList.size();
        paramArrayOfInt = new int[k];
        for (int m = 0; m < k; m++)
          paramArrayOfInt[m] = ((Integer)localArrayList.get(m)).intValue();
      }
    }
  }

  private void clearAutoSizeConfiguration()
  {
    this.mAutoSizeTextType = 0;
    this.mAutoSizeMinTextSizeInPx = -1.0F;
    this.mAutoSizeMaxTextSizeInPx = -1.0F;
    this.mAutoSizeStepGranularityInPx = -1.0F;
    this.mAutoSizeTextSizesInPx = new int[0];
    this.mNeedsAutoSizeText = false;
  }

  private StaticLayout createStaticLayoutForMeasuring(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt1, int paramInt2)
  {
    TextDirectionHeuristic localTextDirectionHeuristic = (TextDirectionHeuristic)invokeAndReturnWithDefault(this.mTextView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
    StaticLayout.Builder localBuilder = StaticLayout.Builder.obtain(paramCharSequence, 0, paramCharSequence.length(), this.mTempTextPaint, paramInt1).setAlignment(paramAlignment).setLineSpacing(this.mTextView.getLineSpacingExtra(), this.mTextView.getLineSpacingMultiplier()).setIncludePad(this.mTextView.getIncludeFontPadding()).setBreakStrategy(this.mTextView.getBreakStrategy()).setHyphenationFrequency(this.mTextView.getHyphenationFrequency());
    if (paramInt2 == -1)
      paramInt2 = 2147483647;
    return localBuilder.setMaxLines(paramInt2).setTextDirection(localTextDirectionHeuristic).build();
  }

  private StaticLayout createStaticLayoutForMeasuringPre23(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt)
  {
    float f1;
    float f2;
    if (Build.VERSION.SDK_INT >= 16)
    {
      f1 = this.mTextView.getLineSpacingMultiplier();
      f2 = this.mTextView.getLineSpacingExtra();
    }
    for (boolean bool = this.mTextView.getIncludeFontPadding(); ; bool = ((Boolean)invokeAndReturnWithDefault(this.mTextView, "getIncludeFontPadding", Boolean.valueOf(true))).booleanValue())
    {
      return new StaticLayout(paramCharSequence, this.mTempTextPaint, paramInt, paramAlignment, f1, f2, bool);
      f1 = ((Float)invokeAndReturnWithDefault(this.mTextView, "getLineSpacingMultiplier", Float.valueOf(1.0F))).floatValue();
      f2 = ((Float)invokeAndReturnWithDefault(this.mTextView, "getLineSpacingExtra", Float.valueOf(0.0F))).floatValue();
    }
  }

  private int findLargestTextSizeWhichFits(RectF paramRectF)
  {
    int i = this.mAutoSizeTextSizesInPx.length;
    if (i == 0)
      throw new IllegalStateException("No available text sizes to choose from.");
    int j = 0;
    int k = 1;
    int m = i - 1;
    while (k <= m)
    {
      int n = (k + m) / 2;
      if (suggestedSizeFitsInSpace(this.mAutoSizeTextSizesInPx[n], paramRectF))
      {
        int i1 = n + 1;
        j = k;
        k = i1;
      }
      else
      {
        m = n - 1;
        j = m;
      }
    }
    return this.mAutoSizeTextSizesInPx[j];
  }

  private Method getTextViewMethod(String paramString)
  {
    try
    {
      Method localMethod = (Method)sTextViewMethodByNameCache.get(paramString);
      if (localMethod == null)
      {
        localMethod = TextView.class.getDeclaredMethod(paramString, new Class[0]);
        if (localMethod != null)
        {
          localMethod.setAccessible(true);
          sTextViewMethodByNameCache.put(paramString, localMethod);
        }
      }
      return localMethod;
    }
    catch (Exception localException)
    {
      Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + paramString + "() method", localException);
    }
    return null;
  }

  private <T> T invokeAndReturnWithDefault(Object paramObject, String paramString, T paramT)
  {
    int i = 0;
    try
    {
      Object localObject2 = getTextViewMethod(paramString).invoke(paramObject, new Object[0]);
      paramT = localObject2;
      if (paramT == null);
      return paramT;
    }
    catch (Exception localException)
    {
      do
      {
        i = 1;
        Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + paramString + "() method", localException);
      }
      while (0 == 0);
      return null;
    }
    finally
    {
      if ((0 != 0) || (i == 0));
    }
  }

  private void setRawTextSize(float paramFloat)
  {
    if (paramFloat != this.mTextView.getPaint().getTextSize())
    {
      this.mTextView.getPaint().setTextSize(paramFloat);
      if (Build.VERSION.SDK_INT < 18)
        break label128;
    }
    label128: for (boolean bool = this.mTextView.isInLayout(); ; bool = false)
    {
      if (this.mTextView.getLayout() != null)
        this.mNeedsAutoSizeText = false;
      try
      {
        Method localMethod = getTextViewMethod("nullLayouts");
        if (localMethod != null)
          localMethod.invoke(this.mTextView, new Object[0]);
        if (!bool)
        {
          this.mTextView.requestLayout();
          this.mTextView.invalidate();
          return;
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", localException);
          continue;
          this.mTextView.forceLayout();
        }
      }
    }
  }

  private boolean setupAutoSizeText()
  {
    if ((supportsAutoSizeText()) && (this.mAutoSizeTextType == 1))
      if ((!this.mHasPresetAutoSizeValues) || (this.mAutoSizeTextSizesInPx.length == 0))
      {
        float f1 = Math.round(this.mAutoSizeMinTextSizeInPx);
        int i = 1;
        while (Math.round(f1 + this.mAutoSizeStepGranularityInPx) <= Math.round(this.mAutoSizeMaxTextSizeInPx))
        {
          i++;
          f1 += this.mAutoSizeStepGranularityInPx;
        }
        int[] arrayOfInt = new int[i];
        float f2 = this.mAutoSizeMinTextSizeInPx;
        for (int j = 0; j < i; j++)
        {
          arrayOfInt[j] = Math.round(f2);
          f2 += this.mAutoSizeStepGranularityInPx;
        }
        this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(arrayOfInt);
      }
    for (this.mNeedsAutoSizeText = true; ; this.mNeedsAutoSizeText = false)
      return this.mNeedsAutoSizeText;
  }

  private void setupAutoSizeUniformPresetSizes(TypedArray paramTypedArray)
  {
    int i = paramTypedArray.length();
    int[] arrayOfInt = new int[i];
    if (i > 0)
    {
      for (int j = 0; j < i; j++)
        arrayOfInt[j] = paramTypedArray.getDimensionPixelSize(j, -1);
      this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(arrayOfInt);
      setupAutoSizeUniformPresetSizesConfiguration();
    }
  }

  private boolean setupAutoSizeUniformPresetSizesConfiguration()
  {
    int i = this.mAutoSizeTextSizesInPx.length;
    if (i > 0);
    for (boolean bool = true; ; bool = false)
    {
      this.mHasPresetAutoSizeValues = bool;
      if (this.mHasPresetAutoSizeValues)
      {
        this.mAutoSizeTextType = 1;
        this.mAutoSizeMinTextSizeInPx = this.mAutoSizeTextSizesInPx[0];
        this.mAutoSizeMaxTextSizeInPx = this.mAutoSizeTextSizesInPx[(i - 1)];
        this.mAutoSizeStepGranularityInPx = -1.0F;
      }
      return this.mHasPresetAutoSizeValues;
    }
  }

  private boolean suggestedSizeFitsInSpace(int paramInt, RectF paramRectF)
  {
    Object localObject = this.mTextView.getText();
    TransformationMethod localTransformationMethod = this.mTextView.getTransformationMethod();
    if (localTransformationMethod != null)
    {
      CharSequence localCharSequence = localTransformationMethod.getTransformation((CharSequence)localObject, this.mTextView);
      if (localCharSequence != null)
        localObject = localCharSequence;
    }
    int i;
    label79: Layout.Alignment localAlignment;
    if (Build.VERSION.SDK_INT >= 16)
    {
      i = this.mTextView.getMaxLines();
      if (this.mTempTextPaint != null)
        break label192;
      this.mTempTextPaint = new TextPaint();
      this.mTempTextPaint.set(this.mTextView.getPaint());
      this.mTempTextPaint.setTextSize(paramInt);
      localAlignment = (Layout.Alignment)invokeAndReturnWithDefault(this.mTextView, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL);
      if (Build.VERSION.SDK_INT < 23)
        break label202;
    }
    label192: label202: for (StaticLayout localStaticLayout = createStaticLayoutForMeasuring((CharSequence)localObject, localAlignment, Math.round(paramRectF.right), i); ; localStaticLayout = createStaticLayoutForMeasuringPre23((CharSequence)localObject, localAlignment, Math.round(paramRectF.right)))
    {
      if ((i == -1) || ((localStaticLayout.getLineCount() <= i) && (localStaticLayout.getLineEnd(-1 + localStaticLayout.getLineCount()) == ((CharSequence)localObject).length())))
        break label221;
      return false;
      i = -1;
      break;
      this.mTempTextPaint.reset();
      break label79;
    }
    label221: return localStaticLayout.getHeight() <= paramRectF.bottom;
  }

  private boolean supportsAutoSizeText()
  {
    return !(this.mTextView instanceof AppCompatEditText);
  }

  private void validateAndSetAutoSizeTextTypeUniformConfiguration(float paramFloat1, float paramFloat2, float paramFloat3)
    throws IllegalArgumentException
  {
    if (paramFloat1 <= 0.0F)
      throw new IllegalArgumentException("Minimum auto-size text size (" + paramFloat1 + "px) is less or equal to (0px)");
    if (paramFloat2 <= paramFloat1)
      throw new IllegalArgumentException("Maximum auto-size text size (" + paramFloat2 + "px) is less or equal to minimum auto-size " + "text size (" + paramFloat1 + "px)");
    if (paramFloat3 <= 0.0F)
      throw new IllegalArgumentException("The auto-size step granularity (" + paramFloat3 + "px) is less or equal to (0px)");
    this.mAutoSizeTextType = 1;
    this.mAutoSizeMinTextSizeInPx = paramFloat1;
    this.mAutoSizeMaxTextSizeInPx = paramFloat2;
    this.mAutoSizeStepGranularityInPx = paramFloat3;
    this.mHasPresetAutoSizeValues = false;
  }

  void autoSizeText()
  {
    if (!isAutoSizeEnabled());
    do
    {
      return;
      if (!this.mNeedsAutoSizeText)
        break;
    }
    while ((this.mTextView.getMeasuredHeight() <= 0) || (this.mTextView.getMeasuredWidth() <= 0));
    int i;
    if (((Boolean)invokeAndReturnWithDefault(this.mTextView, "getHorizontallyScrolling", Boolean.valueOf(false))).booleanValue())
      i = 1048576;
    while (true)
    {
      int j = this.mTextView.getHeight() - this.mTextView.getCompoundPaddingBottom() - this.mTextView.getCompoundPaddingTop();
      if ((i <= 0) || (j <= 0))
        break;
      synchronized (TEMP_RECTF)
      {
        TEMP_RECTF.setEmpty();
        TEMP_RECTF.right = i;
        TEMP_RECTF.bottom = j;
        float f = findLargestTextSizeWhichFits(TEMP_RECTF);
        if (f != this.mTextView.getTextSize())
          setTextSizeInternal(0, f);
        this.mNeedsAutoSizeText = true;
        return;
        i = this.mTextView.getMeasuredWidth() - this.mTextView.getTotalPaddingLeft() - this.mTextView.getTotalPaddingRight();
      }
    }
  }

  int getAutoSizeMaxTextSize()
  {
    return Math.round(this.mAutoSizeMaxTextSizeInPx);
  }

  int getAutoSizeMinTextSize()
  {
    return Math.round(this.mAutoSizeMinTextSizeInPx);
  }

  int getAutoSizeStepGranularity()
  {
    return Math.round(this.mAutoSizeStepGranularityInPx);
  }

  int[] getAutoSizeTextAvailableSizes()
  {
    return this.mAutoSizeTextSizesInPx;
  }

  int getAutoSizeTextType()
  {
    return this.mAutoSizeTextType;
  }

  boolean isAutoSizeEnabled()
  {
    return (supportsAutoSizeText()) && (this.mAutoSizeTextType != 0);
  }

  void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt)
  {
    TypedArray localTypedArray1 = this.mContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AppCompatTextView, paramInt, 0);
    if (localTypedArray1.hasValue(R.styleable.AppCompatTextView_autoSizeTextType))
      this.mAutoSizeTextType = localTypedArray1.getInt(R.styleable.AppCompatTextView_autoSizeTextType, 0);
    if (localTypedArray1.hasValue(R.styleable.AppCompatTextView_autoSizeStepGranularity));
    for (float f1 = localTypedArray1.getDimension(R.styleable.AppCompatTextView_autoSizeStepGranularity, -1.0F); ; f1 = -1.0F)
    {
      if (localTypedArray1.hasValue(R.styleable.AppCompatTextView_autoSizeMinTextSize));
      for (float f2 = localTypedArray1.getDimension(R.styleable.AppCompatTextView_autoSizeMinTextSize, -1.0F); ; f2 = -1.0F)
      {
        if (localTypedArray1.hasValue(R.styleable.AppCompatTextView_autoSizeMaxTextSize));
        for (float f3 = localTypedArray1.getDimension(R.styleable.AppCompatTextView_autoSizeMaxTextSize, -1.0F); ; f3 = -1.0F)
        {
          if (localTypedArray1.hasValue(R.styleable.AppCompatTextView_autoSizePresetSizes))
          {
            int i = localTypedArray1.getResourceId(R.styleable.AppCompatTextView_autoSizePresetSizes, 0);
            if (i > 0)
            {
              TypedArray localTypedArray2 = localTypedArray1.getResources().obtainTypedArray(i);
              setupAutoSizeUniformPresetSizes(localTypedArray2);
              localTypedArray2.recycle();
            }
          }
          localTypedArray1.recycle();
          if (supportsAutoSizeText())
          {
            if (this.mAutoSizeTextType == 1)
            {
              if (!this.mHasPresetAutoSizeValues)
              {
                DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
                if (f2 == -1.0F)
                  f2 = TypedValue.applyDimension(2, 12.0F, localDisplayMetrics);
                if (f3 == -1.0F)
                  f3 = TypedValue.applyDimension(2, 112.0F, localDisplayMetrics);
                if (f1 == -1.0F)
                  f1 = 1.0F;
                validateAndSetAutoSizeTextTypeUniformConfiguration(f2, f3, f1);
              }
              setupAutoSizeText();
            }
            return;
          }
          this.mAutoSizeTextType = 0;
          return;
        }
      }
    }
  }

  void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IllegalArgumentException
  {
    if (supportsAutoSizeText())
    {
      DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
      validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(paramInt4, paramInt1, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt2, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt3, localDisplayMetrics));
      if (setupAutoSizeText())
        autoSizeText();
    }
  }

  void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
    throws IllegalArgumentException
  {
    int i = 0;
    if (supportsAutoSizeText())
    {
      int j = paramArrayOfInt.length;
      if (j > 0)
      {
        int[] arrayOfInt = new int[j];
        if (paramInt == 0)
          arrayOfInt = Arrays.copyOf(paramArrayOfInt, j);
        while (true)
        {
          this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(arrayOfInt);
          if (setupAutoSizeUniformPresetSizesConfiguration())
            break;
          throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(paramArrayOfInt));
          DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
          while (i < j)
          {
            arrayOfInt[i] = Math.round(TypedValue.applyDimension(paramInt, paramArrayOfInt[i], localDisplayMetrics));
            i++;
          }
        }
      }
      this.mHasPresetAutoSizeValues = false;
      if (setupAutoSizeText())
        autoSizeText();
    }
  }

  void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    if (supportsAutoSizeText())
      switch (paramInt)
      {
      default:
        throw new IllegalArgumentException("Unknown auto-size text type: " + paramInt);
      case 0:
        clearAutoSizeConfiguration();
      case 1:
      }
    do
    {
      return;
      DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
      validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(2, 12.0F, localDisplayMetrics), TypedValue.applyDimension(2, 112.0F, localDisplayMetrics), 1.0F);
    }
    while (!setupAutoSizeText());
    autoSizeText();
  }

  void setTextSizeInternal(int paramInt, float paramFloat)
  {
    if (this.mContext == null);
    for (Resources localResources = Resources.getSystem(); ; localResources = this.mContext.getResources())
    {
      setRawTextSize(TypedValue.applyDimension(paramInt, paramFloat, localResources.getDisplayMetrics()));
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.AppCompatTextViewAutoSizeHelper
 * JD-Core Version:    0.6.2
 */