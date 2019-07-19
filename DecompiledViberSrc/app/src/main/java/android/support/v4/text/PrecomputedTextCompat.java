package android.support.v4.text;

import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.support.v4.os.TraceCompat;
import android.support.v4.util.ObjectsCompat;
import android.support.v4.util.Preconditions;
import android.text.Layout.Alignment;
import android.text.PrecomputedText;
import android.text.PrecomputedText.Params;
import android.text.PrecomputedText.Params.Builder;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class PrecomputedTextCompat
  implements Spannable
{
  private static final char LINE_FEED = '\n';
  private static Executor sExecutor = null;
  private static final Object sLock = new Object();
  private final int[] mParagraphEnds;
  private final Params mParams;
  private final Spannable mText;
  private final PrecomputedText mWrapped;

  private PrecomputedTextCompat(PrecomputedText paramPrecomputedText, Params paramParams)
  {
    this.mText = paramPrecomputedText;
    this.mParams = paramParams;
    this.mParagraphEnds = null;
    this.mWrapped = paramPrecomputedText;
  }

  private PrecomputedTextCompat(CharSequence paramCharSequence, Params paramParams, int[] paramArrayOfInt)
  {
    this.mText = new SpannableString(paramCharSequence);
    this.mParams = paramParams;
    this.mParagraphEnds = paramArrayOfInt;
    this.mWrapped = null;
  }

  public static PrecomputedTextCompat create(CharSequence paramCharSequence, Params paramParams)
  {
    Preconditions.checkNotNull(paramCharSequence);
    Preconditions.checkNotNull(paramParams);
    ArrayList localArrayList;
    while (true)
    {
      int k;
      try
      {
        TraceCompat.beginSection("PrecomputedText");
        if ((Build.VERSION.SDK_INT >= 28) && (paramParams.mWrapped != null))
        {
          PrecomputedTextCompat localPrecomputedTextCompat2 = new PrecomputedTextCompat(PrecomputedText.create(paramCharSequence, paramParams.mWrapped), paramParams);
          return localPrecomputedTextCompat2;
        }
        localArrayList = new ArrayList();
        int i = paramCharSequence.length();
        j = 0;
        if (j >= i)
          break;
        k = TextUtils.indexOf(paramCharSequence, '\n', j, i);
        if (k < 0)
        {
          j = i;
          localArrayList.add(Integer.valueOf(j));
          continue;
        }
      }
      finally
      {
        TraceCompat.endSection();
      }
      int j = k + 1;
    }
    int[] arrayOfInt = new int[localArrayList.size()];
    for (int m = 0; m < localArrayList.size(); m++)
      arrayOfInt[m] = ((Integer)localArrayList.get(m)).intValue();
    if (Build.VERSION.SDK_INT >= 23)
      StaticLayout.Builder.obtain(paramCharSequence, 0, paramCharSequence.length(), paramParams.getTextPaint(), 2147483647).setBreakStrategy(paramParams.getBreakStrategy()).setHyphenationFrequency(paramParams.getHyphenationFrequency()).setTextDirection(paramParams.getTextDirection()).build();
    while (true)
    {
      PrecomputedTextCompat localPrecomputedTextCompat1 = new PrecomputedTextCompat(paramCharSequence, paramParams, arrayOfInt);
      TraceCompat.endSection();
      return localPrecomputedTextCompat1;
      if (Build.VERSION.SDK_INT >= 21)
        new StaticLayout(paramCharSequence, paramParams.getTextPaint(), 2147483647, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    }
  }

  private int findParaIndex(int paramInt)
  {
    for (int i = 0; i < this.mParagraphEnds.length; i++)
      if (paramInt < this.mParagraphEnds[i])
        return i;
    throw new IndexOutOfBoundsException("pos must be less than " + this.mParagraphEnds[(-1 + this.mParagraphEnds.length)] + ", gave " + paramInt);
  }

  public static Future<PrecomputedTextCompat> getTextFuture(CharSequence paramCharSequence, Params paramParams, Executor paramExecutor)
  {
    PrecomputedTextFutureTask localPrecomputedTextFutureTask = new PrecomputedTextFutureTask(paramParams, paramCharSequence);
    if (paramExecutor == null);
    synchronized (sLock)
    {
      if (sExecutor == null)
        sExecutor = Executors.newFixedThreadPool(1);
      paramExecutor = sExecutor;
      paramExecutor.execute(localPrecomputedTextFutureTask);
      return localPrecomputedTextFutureTask;
    }
  }

  public char charAt(int paramInt)
  {
    return this.mText.charAt(paramInt);
  }

  public int getParagraphCount()
  {
    if (Build.VERSION.SDK_INT >= 28)
      return this.mWrapped.getParagraphCount();
    return this.mParagraphEnds.length;
  }

  public int getParagraphEnd(int paramInt)
  {
    Preconditions.checkArgumentInRange(paramInt, 0, getParagraphCount(), "paraIndex");
    if (Build.VERSION.SDK_INT >= 28)
      return this.mWrapped.getParagraphEnd(paramInt);
    return this.mParagraphEnds[paramInt];
  }

  public int getParagraphStart(int paramInt)
  {
    Preconditions.checkArgumentInRange(paramInt, 0, getParagraphCount(), "paraIndex");
    int i;
    if (Build.VERSION.SDK_INT >= 28)
      i = this.mWrapped.getParagraphStart(paramInt);
    do
    {
      return i;
      i = 0;
    }
    while (paramInt == 0);
    return this.mParagraphEnds[(paramInt - 1)];
  }

  public Params getParams()
  {
    return this.mParams;
  }

  public PrecomputedText getPrecomputedText()
  {
    if ((this.mText instanceof PrecomputedText))
      return (PrecomputedText)this.mText;
    return null;
  }

  public int getSpanEnd(Object paramObject)
  {
    return this.mText.getSpanEnd(paramObject);
  }

  public int getSpanFlags(Object paramObject)
  {
    return this.mText.getSpanFlags(paramObject);
  }

  public int getSpanStart(Object paramObject)
  {
    return this.mText.getSpanStart(paramObject);
  }

  public <T> T[] getSpans(int paramInt1, int paramInt2, Class<T> paramClass)
  {
    if (Build.VERSION.SDK_INT >= 28)
      return this.mWrapped.getSpans(paramInt1, paramInt2, paramClass);
    return this.mText.getSpans(paramInt1, paramInt2, paramClass);
  }

  public int length()
  {
    return this.mText.length();
  }

  public int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass)
  {
    return this.mText.nextSpanTransition(paramInt1, paramInt2, paramClass);
  }

  public void removeSpan(Object paramObject)
  {
    if ((paramObject instanceof MetricAffectingSpan))
      throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.mWrapped.removeSpan(paramObject);
      return;
    }
    this.mText.removeSpan(paramObject);
  }

  public void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramObject instanceof MetricAffectingSpan))
      throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.mWrapped.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
      return;
    }
    this.mText.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
  }

  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    return this.mText.subSequence(paramInt1, paramInt2);
  }

  public String toString()
  {
    return this.mText.toString();
  }

  public static final class Params
  {
    private final int mBreakStrategy;
    private final int mHyphenationFrequency;
    private final TextPaint mPaint;
    private final TextDirectionHeuristic mTextDir;
    final PrecomputedText.Params mWrapped;

    public Params(PrecomputedText.Params paramParams)
    {
      this.mPaint = paramParams.getTextPaint();
      this.mTextDir = paramParams.getTextDirection();
      this.mBreakStrategy = paramParams.getBreakStrategy();
      this.mHyphenationFrequency = paramParams.getHyphenationFrequency();
      this.mWrapped = paramParams;
    }

    Params(TextPaint paramTextPaint, TextDirectionHeuristic paramTextDirectionHeuristic, int paramInt1, int paramInt2)
    {
      if (Build.VERSION.SDK_INT >= 28);
      for (this.mWrapped = new PrecomputedText.Params.Builder(paramTextPaint).setBreakStrategy(paramInt1).setHyphenationFrequency(paramInt2).setTextDirection(paramTextDirectionHeuristic).build(); ; this.mWrapped = null)
      {
        this.mPaint = paramTextPaint;
        this.mTextDir = paramTextDirectionHeuristic;
        this.mBreakStrategy = paramInt1;
        this.mHyphenationFrequency = paramInt2;
        return;
      }
    }

    public boolean equals(Object paramObject)
    {
      if (paramObject == this);
      Params localParams;
      do
      {
        do
        {
          return true;
          if ((paramObject == null) || (!(paramObject instanceof Params)))
            return false;
          localParams = (Params)paramObject;
          if (this.mWrapped != null)
            return this.mWrapped.equals(localParams.mWrapped);
          if (Build.VERSION.SDK_INT >= 23)
          {
            if (this.mBreakStrategy != localParams.getBreakStrategy())
              return false;
            if (this.mHyphenationFrequency != localParams.getHyphenationFrequency())
              return false;
          }
          if ((Build.VERSION.SDK_INT >= 18) && (this.mTextDir != localParams.getTextDirection()))
            return false;
          if (this.mPaint.getTextSize() != localParams.getTextPaint().getTextSize())
            return false;
          if (this.mPaint.getTextScaleX() != localParams.getTextPaint().getTextScaleX())
            return false;
          if (this.mPaint.getTextSkewX() != localParams.getTextPaint().getTextSkewX())
            return false;
          if (Build.VERSION.SDK_INT >= 21)
          {
            if (this.mPaint.getLetterSpacing() != localParams.getTextPaint().getLetterSpacing())
              return false;
            if (!TextUtils.equals(this.mPaint.getFontFeatureSettings(), localParams.getTextPaint().getFontFeatureSettings()))
              return false;
          }
          if (this.mPaint.getFlags() != localParams.getTextPaint().getFlags())
            return false;
          if (Build.VERSION.SDK_INT >= 24)
          {
            if (!this.mPaint.getTextLocales().equals(localParams.getTextPaint().getTextLocales()))
              return false;
          }
          else if ((Build.VERSION.SDK_INT >= 17) && (!this.mPaint.getTextLocale().equals(localParams.getTextPaint().getTextLocale())))
            return false;
          if (this.mPaint.getTypeface() != null)
            break;
        }
        while (localParams.getTextPaint().getTypeface() == null);
        return false;
      }
      while (this.mPaint.getTypeface().equals(localParams.getTextPaint().getTypeface()));
      return false;
    }

    public int getBreakStrategy()
    {
      return this.mBreakStrategy;
    }

    public int getHyphenationFrequency()
    {
      return this.mHyphenationFrequency;
    }

    public TextDirectionHeuristic getTextDirection()
    {
      return this.mTextDir;
    }

    public TextPaint getTextPaint()
    {
      return this.mPaint;
    }

    public int hashCode()
    {
      if (Build.VERSION.SDK_INT >= 24)
      {
        Object[] arrayOfObject5 = new Object[11];
        arrayOfObject5[0] = Float.valueOf(this.mPaint.getTextSize());
        arrayOfObject5[1] = Float.valueOf(this.mPaint.getTextScaleX());
        arrayOfObject5[2] = Float.valueOf(this.mPaint.getTextSkewX());
        arrayOfObject5[3] = Float.valueOf(this.mPaint.getLetterSpacing());
        arrayOfObject5[4] = Integer.valueOf(this.mPaint.getFlags());
        arrayOfObject5[5] = this.mPaint.getTextLocales();
        arrayOfObject5[6] = this.mPaint.getTypeface();
        arrayOfObject5[7] = Boolean.valueOf(this.mPaint.isElegantTextHeight());
        arrayOfObject5[8] = this.mTextDir;
        arrayOfObject5[9] = Integer.valueOf(this.mBreakStrategy);
        arrayOfObject5[10] = Integer.valueOf(this.mHyphenationFrequency);
        return ObjectsCompat.hash(arrayOfObject5);
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        Object[] arrayOfObject4 = new Object[11];
        arrayOfObject4[0] = Float.valueOf(this.mPaint.getTextSize());
        arrayOfObject4[1] = Float.valueOf(this.mPaint.getTextScaleX());
        arrayOfObject4[2] = Float.valueOf(this.mPaint.getTextSkewX());
        arrayOfObject4[3] = Float.valueOf(this.mPaint.getLetterSpacing());
        arrayOfObject4[4] = Integer.valueOf(this.mPaint.getFlags());
        arrayOfObject4[5] = this.mPaint.getTextLocale();
        arrayOfObject4[6] = this.mPaint.getTypeface();
        arrayOfObject4[7] = Boolean.valueOf(this.mPaint.isElegantTextHeight());
        arrayOfObject4[8] = this.mTextDir;
        arrayOfObject4[9] = Integer.valueOf(this.mBreakStrategy);
        arrayOfObject4[10] = Integer.valueOf(this.mHyphenationFrequency);
        return ObjectsCompat.hash(arrayOfObject4);
      }
      if (Build.VERSION.SDK_INT >= 18)
      {
        Object[] arrayOfObject3 = new Object[9];
        arrayOfObject3[0] = Float.valueOf(this.mPaint.getTextSize());
        arrayOfObject3[1] = Float.valueOf(this.mPaint.getTextScaleX());
        arrayOfObject3[2] = Float.valueOf(this.mPaint.getTextSkewX());
        arrayOfObject3[3] = Integer.valueOf(this.mPaint.getFlags());
        arrayOfObject3[4] = this.mPaint.getTextLocale();
        arrayOfObject3[5] = this.mPaint.getTypeface();
        arrayOfObject3[6] = this.mTextDir;
        arrayOfObject3[7] = Integer.valueOf(this.mBreakStrategy);
        arrayOfObject3[8] = Integer.valueOf(this.mHyphenationFrequency);
        return ObjectsCompat.hash(arrayOfObject3);
      }
      if (Build.VERSION.SDK_INT >= 17)
      {
        Object[] arrayOfObject2 = new Object[9];
        arrayOfObject2[0] = Float.valueOf(this.mPaint.getTextSize());
        arrayOfObject2[1] = Float.valueOf(this.mPaint.getTextScaleX());
        arrayOfObject2[2] = Float.valueOf(this.mPaint.getTextSkewX());
        arrayOfObject2[3] = Integer.valueOf(this.mPaint.getFlags());
        arrayOfObject2[4] = this.mPaint.getTextLocale();
        arrayOfObject2[5] = this.mPaint.getTypeface();
        arrayOfObject2[6] = this.mTextDir;
        arrayOfObject2[7] = Integer.valueOf(this.mBreakStrategy);
        arrayOfObject2[8] = Integer.valueOf(this.mHyphenationFrequency);
        return ObjectsCompat.hash(arrayOfObject2);
      }
      Object[] arrayOfObject1 = new Object[8];
      arrayOfObject1[0] = Float.valueOf(this.mPaint.getTextSize());
      arrayOfObject1[1] = Float.valueOf(this.mPaint.getTextScaleX());
      arrayOfObject1[2] = Float.valueOf(this.mPaint.getTextSkewX());
      arrayOfObject1[3] = Integer.valueOf(this.mPaint.getFlags());
      arrayOfObject1[4] = this.mPaint.getTypeface();
      arrayOfObject1[5] = this.mTextDir;
      arrayOfObject1[6] = Integer.valueOf(this.mBreakStrategy);
      arrayOfObject1[7] = Integer.valueOf(this.mHyphenationFrequency);
      return ObjectsCompat.hash(arrayOfObject1);
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("{");
      localStringBuilder.append("textSize=" + this.mPaint.getTextSize());
      localStringBuilder.append(", textScaleX=" + this.mPaint.getTextScaleX());
      localStringBuilder.append(", textSkewX=" + this.mPaint.getTextSkewX());
      if (Build.VERSION.SDK_INT >= 21)
      {
        localStringBuilder.append(", letterSpacing=" + this.mPaint.getLetterSpacing());
        localStringBuilder.append(", elegantTextHeight=" + this.mPaint.isElegantTextHeight());
      }
      if (Build.VERSION.SDK_INT >= 24)
        localStringBuilder.append(", textLocale=" + this.mPaint.getTextLocales());
      while (true)
      {
        localStringBuilder.append(", typeface=" + this.mPaint.getTypeface());
        if (Build.VERSION.SDK_INT >= 26)
          localStringBuilder.append(", variationSettings=" + this.mPaint.getFontVariationSettings());
        localStringBuilder.append(", textDir=" + this.mTextDir);
        localStringBuilder.append(", breakStrategy=" + this.mBreakStrategy);
        localStringBuilder.append(", hyphenationFrequency=" + this.mHyphenationFrequency);
        localStringBuilder.append("}");
        return localStringBuilder.toString();
        if (Build.VERSION.SDK_INT >= 17)
          localStringBuilder.append(", textLocale=" + this.mPaint.getTextLocale());
      }
    }

    public static class Builder
    {
      private int mBreakStrategy;
      private int mHyphenationFrequency;
      private final TextPaint mPaint;
      private TextDirectionHeuristic mTextDir;

      public Builder(TextPaint paramTextPaint)
      {
        this.mPaint = paramTextPaint;
        if (Build.VERSION.SDK_INT >= 23)
        {
          this.mBreakStrategy = 1;
          this.mHyphenationFrequency = 1;
        }
        while (Build.VERSION.SDK_INT >= 18)
        {
          this.mTextDir = TextDirectionHeuristics.FIRSTSTRONG_LTR;
          return;
          this.mHyphenationFrequency = 0;
          this.mBreakStrategy = 0;
        }
        this.mTextDir = null;
      }

      public PrecomputedTextCompat.Params build()
      {
        return new PrecomputedTextCompat.Params(this.mPaint, this.mTextDir, this.mBreakStrategy, this.mHyphenationFrequency);
      }

      public Builder setBreakStrategy(int paramInt)
      {
        this.mBreakStrategy = paramInt;
        return this;
      }

      public Builder setHyphenationFrequency(int paramInt)
      {
        this.mHyphenationFrequency = paramInt;
        return this;
      }

      public Builder setTextDirection(TextDirectionHeuristic paramTextDirectionHeuristic)
      {
        this.mTextDir = paramTextDirectionHeuristic;
        return this;
      }
    }
  }

  private static class PrecomputedTextFutureTask extends FutureTask<PrecomputedTextCompat>
  {
    PrecomputedTextFutureTask(PrecomputedTextCompat.Params paramParams, CharSequence paramCharSequence)
    {
      super();
    }

    private static class PrecomputedTextCallback
      implements Callable<PrecomputedTextCompat>
    {
      private PrecomputedTextCompat.Params mParams;
      private CharSequence mText;

      PrecomputedTextCallback(PrecomputedTextCompat.Params paramParams, CharSequence paramCharSequence)
      {
        this.mParams = paramParams;
        this.mText = paramCharSequence;
      }

      public PrecomputedTextCompat call()
        throws Exception
      {
        return PrecomputedTextCompat.create(this.mText, this.mParams);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.text.PrecomputedTextCompat
 * JD-Core Version:    0.6.2
 */