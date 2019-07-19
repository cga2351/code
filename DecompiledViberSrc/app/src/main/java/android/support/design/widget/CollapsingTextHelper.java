package android.support.design.widget;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.design.a.a;
import android.support.v4.math.MathUtils;
import android.support.v4.text.TextDirectionHeuristicCompat;
import android.support.v4.text.TextDirectionHeuristicsCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.widget.TintTypedArray;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;

public final class CollapsingTextHelper
{
  private static final boolean DEBUG_DRAW;
  private static final Paint DEBUG_DRAW_PAINT;
  private static final boolean USE_SCALING_TEXTURE;
  private boolean boundsChanged;
  private final Rect collapsedBounds;
  private float collapsedDrawX;
  private float collapsedDrawY;
  private int collapsedShadowColor;
  private float collapsedShadowDx;
  private float collapsedShadowDy;
  private float collapsedShadowRadius;
  private ColorStateList collapsedTextColor;
  private int collapsedTextGravity = 16;
  private float collapsedTextSize = 15.0F;
  private Typeface collapsedTypeface;
  private final RectF currentBounds;
  private float currentDrawX;
  private float currentDrawY;
  private float currentTextSize;
  private Typeface currentTypeface;
  private boolean drawTitle;
  private final Rect expandedBounds;
  private float expandedDrawX;
  private float expandedDrawY;
  private float expandedFraction;
  private int expandedShadowColor;
  private float expandedShadowDx;
  private float expandedShadowDy;
  private float expandedShadowRadius;
  private ColorStateList expandedTextColor;
  private int expandedTextGravity = 16;
  private float expandedTextSize = 15.0F;
  private Bitmap expandedTitleTexture;
  private Typeface expandedTypeface;
  private boolean isRtl;
  private TimeInterpolator positionInterpolator;
  private float scale;
  private int[] state;
  private CharSequence text;
  private final TextPaint textPaint;
  private TimeInterpolator textSizeInterpolator;
  private CharSequence textToDraw;
  private float textureAscent;
  private float textureDescent;
  private Paint texturePaint;
  private final TextPaint tmpPaint;
  private boolean useTexture;
  private final View view;

  static
  {
    if (Build.VERSION.SDK_INT < 18);
    for (boolean bool = true; ; bool = false)
    {
      USE_SCALING_TEXTURE = bool;
      DEBUG_DRAW_PAINT = null;
      if (DEBUG_DRAW_PAINT != null)
      {
        DEBUG_DRAW_PAINT.setAntiAlias(true);
        DEBUG_DRAW_PAINT.setColor(-65281);
      }
      return;
    }
  }

  public CollapsingTextHelper(View paramView)
  {
    this.view = paramView;
    this.textPaint = new TextPaint(129);
    this.tmpPaint = new TextPaint(this.textPaint);
    this.collapsedBounds = new Rect();
    this.expandedBounds = new Rect();
    this.currentBounds = new RectF();
  }

  private static int blendColors(int paramInt1, int paramInt2, float paramFloat)
  {
    float f1 = 1.0F - paramFloat;
    float f2 = f1 * Color.alpha(paramInt1) + paramFloat * Color.alpha(paramInt2);
    float f3 = f1 * Color.red(paramInt1) + paramFloat * Color.red(paramInt2);
    float f4 = f1 * Color.green(paramInt1) + paramFloat * Color.green(paramInt2);
    float f5 = f1 * Color.blue(paramInt1) + paramFloat * Color.blue(paramInt2);
    return Color.argb((int)f2, (int)f3, (int)f4, (int)f5);
  }

  private void calculateBaseOffsets()
  {
    int i = 1;
    float f1 = this.currentTextSize;
    calculateUsingTextSize(this.collapsedTextSize);
    float f2;
    int k;
    label60: float f3;
    if (this.textToDraw != null)
    {
      f2 = this.textPaint.measureText(this.textToDraw, 0, this.textToDraw.length());
      int j = this.collapsedTextGravity;
      if (!this.isRtl)
        break label371;
      k = i;
      int m = GravityCompat.getAbsoluteGravity(j, k);
      switch (m & 0x70)
      {
      default:
        this.collapsedDrawY = ((this.textPaint.descent() - this.textPaint.ascent()) / 2.0F - this.textPaint.descent() + this.collapsedBounds.centerY());
        label138: switch (m & 0x800007)
        {
        default:
          this.collapsedDrawX = this.collapsedBounds.left;
          label180: calculateUsingTextSize(this.expandedTextSize);
          CharSequence localCharSequence = this.textToDraw;
          f3 = 0.0F;
          if (localCharSequence != null)
            f3 = this.textPaint.measureText(this.textToDraw, 0, this.textToDraw.length());
          int n = this.expandedTextGravity;
          if (this.isRtl)
          {
            label238: int i1 = GravityCompat.getAbsoluteGravity(n, i);
            switch (i1 & 0x70)
            {
            default:
              this.expandedDrawY = ((this.textPaint.descent() - this.textPaint.ascent()) / 2.0F - this.textPaint.descent() + this.expandedBounds.centerY());
              label314: switch (i1 & 0x800007)
              {
              default:
                this.expandedDrawX = this.expandedBounds.left;
              case 1:
              case 5:
              }
              break;
            case 80:
            case 48:
            }
          }
          break;
        case 1:
        case 5:
        }
        break;
      case 80:
      case 48:
      }
    }
    while (true)
    {
      clearTexture();
      setInterpolatedTextSize(f1);
      return;
      f2 = 0.0F;
      break;
      label371: k = 0;
      break label60;
      this.collapsedDrawY = this.collapsedBounds.bottom;
      break label138;
      this.collapsedDrawY = (this.collapsedBounds.top - this.textPaint.ascent());
      break label138;
      this.collapsedDrawX = (this.collapsedBounds.centerX() - f2 / 2.0F);
      break label180;
      this.collapsedDrawX = (this.collapsedBounds.right - f2);
      break label180;
      i = 0;
      break label238;
      this.expandedDrawY = this.expandedBounds.bottom;
      break label314;
      this.expandedDrawY = (this.expandedBounds.top - this.textPaint.ascent());
      break label314;
      this.expandedDrawX = (this.expandedBounds.centerX() - f3 / 2.0F);
      continue;
      this.expandedDrawX = (this.expandedBounds.right - f3);
    }
  }

  private void calculateCurrentOffsets()
  {
    calculateOffsets(this.expandedFraction);
  }

  private boolean calculateIsRtl(CharSequence paramCharSequence)
  {
    int i = 1;
    if (ViewCompat.getLayoutDirection(this.view) == i)
      if (i == 0)
        break label41;
    label41: for (TextDirectionHeuristicCompat localTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL; ; localTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR)
    {
      return localTextDirectionHeuristicCompat.isRtl(paramCharSequence, 0, paramCharSequence.length());
      i = 0;
      break;
    }
  }

  private void calculateOffsets(float paramFloat)
  {
    interpolateBounds(paramFloat);
    this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, paramFloat, this.positionInterpolator);
    this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, paramFloat, this.positionInterpolator);
    setInterpolatedTextSize(lerp(this.expandedTextSize, this.collapsedTextSize, paramFloat, this.textSizeInterpolator));
    if (this.collapsedTextColor != this.expandedTextColor)
      this.textPaint.setColor(blendColors(getCurrentExpandedTextColor(), getCurrentCollapsedTextColor(), paramFloat));
    while (true)
    {
      this.textPaint.setShadowLayer(lerp(this.expandedShadowRadius, this.collapsedShadowRadius, paramFloat, null), lerp(this.expandedShadowDx, this.collapsedShadowDx, paramFloat, null), lerp(this.expandedShadowDy, this.collapsedShadowDy, paramFloat, null), blendColors(this.expandedShadowColor, this.collapsedShadowColor, paramFloat));
      ViewCompat.postInvalidateOnAnimation(this.view);
      return;
      this.textPaint.setColor(getCurrentCollapsedTextColor());
    }
  }

  private void calculateUsingTextSize(float paramFloat)
  {
    boolean bool1 = true;
    if (this.text == null)
      return;
    float f1 = this.collapsedBounds.width();
    float f2 = this.expandedBounds.width();
    float f3;
    boolean bool2;
    if (isClose(paramFloat, this.collapsedTextSize))
    {
      f3 = this.collapsedTextSize;
      this.scale = 1.0F;
      if (this.currentTypeface == this.collapsedTypeface)
        break label333;
      this.currentTypeface = this.collapsedTypeface;
      bool2 = bool1;
    }
    while (true)
    {
      if (f1 > 0.0F)
      {
        if ((this.currentTextSize != f3) || (this.boundsChanged) || (bool2))
        {
          bool2 = bool1;
          label104: this.currentTextSize = f3;
          this.boundsChanged = false;
        }
      }
      else
      {
        if ((this.textToDraw != null) && (!bool2))
          break;
        this.textPaint.setTextSize(this.currentTextSize);
        this.textPaint.setTypeface(this.currentTypeface);
        TextPaint localTextPaint = this.textPaint;
        if (this.scale == 1.0F)
          break label322;
        label165: localTextPaint.setLinearText(bool1);
        CharSequence localCharSequence = TextUtils.ellipsize(this.text, this.textPaint, f1, TextUtils.TruncateAt.END);
        if (TextUtils.equals(localCharSequence, this.textToDraw))
          break;
        this.textToDraw = localCharSequence;
        this.isRtl = calculateIsRtl(this.textToDraw);
        return;
        f3 = this.expandedTextSize;
        if (this.currentTypeface == this.expandedTypeface)
          break label327;
        this.currentTypeface = this.expandedTypeface;
      }
      label310: label322: label327: for (bool2 = bool1; ; bool2 = false)
      {
        if (isClose(paramFloat, this.expandedTextSize));
        for (this.scale = 1.0F; ; this.scale = (paramFloat / this.expandedTextSize))
        {
          float f4 = this.collapsedTextSize / this.expandedTextSize;
          if (f2 * f4 <= f1)
            break label310;
          f1 = Math.min(f1 / f4, f2);
          break;
        }
        f1 = f2;
        break;
        bool2 = false;
        break label104;
        bool1 = false;
        break label165;
      }
      label333: bool2 = false;
    }
  }

  private void clearTexture()
  {
    if (this.expandedTitleTexture != null)
    {
      this.expandedTitleTexture.recycle();
      this.expandedTitleTexture = null;
    }
  }

  private void ensureExpandedTexture()
  {
    if ((this.expandedTitleTexture != null) || (this.expandedBounds.isEmpty()) || (TextUtils.isEmpty(this.textToDraw)));
    do
    {
      int i;
      int j;
      do
      {
        return;
        calculateOffsets(0.0F);
        this.textureAscent = this.textPaint.ascent();
        this.textureDescent = this.textPaint.descent();
        i = Math.round(this.textPaint.measureText(this.textToDraw, 0, this.textToDraw.length()));
        j = Math.round(this.textureDescent - this.textureAscent);
      }
      while ((i <= 0) || (j <= 0));
      this.expandedTitleTexture = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      new Canvas(this.expandedTitleTexture).drawText(this.textToDraw, 0, this.textToDraw.length(), 0.0F, j - this.textPaint.descent(), this.textPaint);
    }
    while (this.texturePaint != null);
    this.texturePaint = new Paint(3);
  }

  private int getCurrentExpandedTextColor()
  {
    if (this.state != null)
      return this.expandedTextColor.getColorForState(this.state, 0);
    return this.expandedTextColor.getDefaultColor();
  }

  private void getTextPaintCollapsed(TextPaint paramTextPaint)
  {
    paramTextPaint.setTextSize(this.collapsedTextSize);
    paramTextPaint.setTypeface(this.collapsedTypeface);
  }

  private void interpolateBounds(float paramFloat)
  {
    this.currentBounds.left = lerp(this.expandedBounds.left, this.collapsedBounds.left, paramFloat, this.positionInterpolator);
    this.currentBounds.top = lerp(this.expandedDrawY, this.collapsedDrawY, paramFloat, this.positionInterpolator);
    this.currentBounds.right = lerp(this.expandedBounds.right, this.collapsedBounds.right, paramFloat, this.positionInterpolator);
    this.currentBounds.bottom = lerp(this.expandedBounds.bottom, this.collapsedBounds.bottom, paramFloat, this.positionInterpolator);
  }

  private static boolean isClose(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) < 0.001F;
  }

  private static float lerp(float paramFloat1, float paramFloat2, float paramFloat3, TimeInterpolator paramTimeInterpolator)
  {
    if (paramTimeInterpolator != null)
      paramFloat3 = paramTimeInterpolator.getInterpolation(paramFloat3);
    return a.a(paramFloat1, paramFloat2, paramFloat3);
  }

  private Typeface readFontFamilyTypeface(int paramInt)
  {
    TypedArray localTypedArray = this.view.getContext().obtainStyledAttributes(paramInt, new int[] { 16843692 });
    try
    {
      String str = localTypedArray.getString(0);
      if (str != null)
      {
        Typeface localTypeface = Typeface.create(str, 0);
        return localTypeface;
      }
      return null;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  private static boolean rectEquals(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (paramRect.left == paramInt1) && (paramRect.top == paramInt2) && (paramRect.right == paramInt3) && (paramRect.bottom == paramInt4);
  }

  private void setInterpolatedTextSize(float paramFloat)
  {
    calculateUsingTextSize(paramFloat);
    if ((USE_SCALING_TEXTURE) && (this.scale != 1.0F));
    for (boolean bool = true; ; bool = false)
    {
      this.useTexture = bool;
      if (this.useTexture)
        ensureExpandedTexture();
      ViewCompat.postInvalidateOnAnimation(this.view);
      return;
    }
  }

  public float calculateCollapsedTextWidth()
  {
    if (this.text == null)
      return 0.0F;
    getTextPaintCollapsed(this.tmpPaint);
    return this.tmpPaint.measureText(this.text, 0, this.text.length());
  }

  public void draw(Canvas paramCanvas)
  {
    int i = paramCanvas.save();
    float f1;
    float f2;
    int j;
    float f3;
    if ((this.textToDraw != null) && (this.drawTitle))
    {
      f1 = this.currentDrawX;
      f2 = this.currentDrawY;
      if ((!this.useTexture) || (this.expandedTitleTexture == null))
        break label135;
      j = 1;
      if (j == 0)
        break label141;
      f3 = this.textureAscent * this.scale;
      (this.textureDescent * this.scale);
      label73: if (j != 0)
        f2 += f3;
      if (this.scale != 1.0F)
        paramCanvas.scale(this.scale, this.scale, f1, f2);
      if (j == 0)
        break label171;
      paramCanvas.drawBitmap(this.expandedTitleTexture, f1, f2, this.texturePaint);
    }
    while (true)
    {
      paramCanvas.restoreToCount(i);
      return;
      label135: j = 0;
      break;
      label141: f3 = this.textPaint.ascent() * this.scale;
      (this.textPaint.descent() * this.scale);
      break label73;
      label171: paramCanvas.drawText(this.textToDraw, 0, this.textToDraw.length(), f1, f2, this.textPaint);
    }
  }

  public void getCollapsedTextActualBounds(RectF paramRectF)
  {
    boolean bool = calculateIsRtl(this.text);
    float f1;
    if (!bool)
    {
      f1 = this.collapsedBounds.left;
      paramRectF.left = f1;
      paramRectF.top = this.collapsedBounds.top;
      if (bool)
        break label95;
    }
    label95: for (float f2 = paramRectF.left + calculateCollapsedTextWidth(); ; f2 = this.collapsedBounds.right)
    {
      paramRectF.right = f2;
      paramRectF.bottom = (this.collapsedBounds.top + getCollapsedTextHeight());
      return;
      f1 = this.collapsedBounds.right - calculateCollapsedTextWidth();
      break;
    }
  }

  public ColorStateList getCollapsedTextColor()
  {
    return this.collapsedTextColor;
  }

  public int getCollapsedTextGravity()
  {
    return this.collapsedTextGravity;
  }

  public float getCollapsedTextHeight()
  {
    getTextPaintCollapsed(this.tmpPaint);
    return -this.tmpPaint.ascent();
  }

  public float getCollapsedTextSize()
  {
    return this.collapsedTextSize;
  }

  public Typeface getCollapsedTypeface()
  {
    if (this.collapsedTypeface != null)
      return this.collapsedTypeface;
    return Typeface.DEFAULT;
  }

  public int getCurrentCollapsedTextColor()
  {
    if (this.state != null)
      return this.collapsedTextColor.getColorForState(this.state, 0);
    return this.collapsedTextColor.getDefaultColor();
  }

  public ColorStateList getExpandedTextColor()
  {
    return this.expandedTextColor;
  }

  public int getExpandedTextGravity()
  {
    return this.expandedTextGravity;
  }

  public float getExpandedTextSize()
  {
    return this.expandedTextSize;
  }

  public Typeface getExpandedTypeface()
  {
    if (this.expandedTypeface != null)
      return this.expandedTypeface;
    return Typeface.DEFAULT;
  }

  public float getExpansionFraction()
  {
    return this.expandedFraction;
  }

  public CharSequence getText()
  {
    return this.text;
  }

  public final boolean isStateful()
  {
    return ((this.collapsedTextColor != null) && (this.collapsedTextColor.isStateful())) || ((this.expandedTextColor != null) && (this.expandedTextColor.isStateful()));
  }

  void onBoundsChanged()
  {
    if ((this.collapsedBounds.width() > 0) && (this.collapsedBounds.height() > 0) && (this.expandedBounds.width() > 0) && (this.expandedBounds.height() > 0));
    for (boolean bool = true; ; bool = false)
    {
      this.drawTitle = bool;
      return;
    }
  }

  public void recalculate()
  {
    if ((this.view.getHeight() > 0) && (this.view.getWidth() > 0))
    {
      calculateBaseOffsets();
      calculateCurrentOffsets();
    }
  }

  public void setCollapsedBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!rectEquals(this.collapsedBounds, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      this.collapsedBounds.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.boundsChanged = true;
      onBoundsChanged();
    }
  }

  public void setCollapsedTextAppearance(int paramInt)
  {
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(this.view.getContext(), paramInt, R.styleable.TextAppearance);
    if (localTintTypedArray.hasValue(R.styleable.TextAppearance_android_textColor))
      this.collapsedTextColor = localTintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColor);
    if (localTintTypedArray.hasValue(R.styleable.TextAppearance_android_textSize))
      this.collapsedTextSize = localTintTypedArray.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, (int)this.collapsedTextSize);
    this.collapsedShadowColor = localTintTypedArray.getInt(R.styleable.TextAppearance_android_shadowColor, 0);
    this.collapsedShadowDx = localTintTypedArray.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0F);
    this.collapsedShadowDy = localTintTypedArray.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0F);
    this.collapsedShadowRadius = localTintTypedArray.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0F);
    localTintTypedArray.recycle();
    if (Build.VERSION.SDK_INT >= 16)
      this.collapsedTypeface = readFontFamilyTypeface(paramInt);
    recalculate();
  }

  public void setCollapsedTextColor(ColorStateList paramColorStateList)
  {
    if (this.collapsedTextColor != paramColorStateList)
    {
      this.collapsedTextColor = paramColorStateList;
      recalculate();
    }
  }

  public void setCollapsedTextGravity(int paramInt)
  {
    if (this.collapsedTextGravity != paramInt)
    {
      this.collapsedTextGravity = paramInt;
      recalculate();
    }
  }

  public void setCollapsedTextSize(float paramFloat)
  {
    if (this.collapsedTextSize != paramFloat)
    {
      this.collapsedTextSize = paramFloat;
      recalculate();
    }
  }

  public void setCollapsedTypeface(Typeface paramTypeface)
  {
    if (this.collapsedTypeface != paramTypeface)
    {
      this.collapsedTypeface = paramTypeface;
      recalculate();
    }
  }

  public void setExpandedBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!rectEquals(this.expandedBounds, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      this.expandedBounds.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.boundsChanged = true;
      onBoundsChanged();
    }
  }

  public void setExpandedTextAppearance(int paramInt)
  {
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(this.view.getContext(), paramInt, R.styleable.TextAppearance);
    if (localTintTypedArray.hasValue(R.styleable.TextAppearance_android_textColor))
      this.expandedTextColor = localTintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColor);
    if (localTintTypedArray.hasValue(R.styleable.TextAppearance_android_textSize))
      this.expandedTextSize = localTintTypedArray.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, (int)this.expandedTextSize);
    this.expandedShadowColor = localTintTypedArray.getInt(R.styleable.TextAppearance_android_shadowColor, 0);
    this.expandedShadowDx = localTintTypedArray.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0F);
    this.expandedShadowDy = localTintTypedArray.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0F);
    this.expandedShadowRadius = localTintTypedArray.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0F);
    localTintTypedArray.recycle();
    if (Build.VERSION.SDK_INT >= 16)
      this.expandedTypeface = readFontFamilyTypeface(paramInt);
    recalculate();
  }

  public void setExpandedTextColor(ColorStateList paramColorStateList)
  {
    if (this.expandedTextColor != paramColorStateList)
    {
      this.expandedTextColor = paramColorStateList;
      recalculate();
    }
  }

  public void setExpandedTextGravity(int paramInt)
  {
    if (this.expandedTextGravity != paramInt)
    {
      this.expandedTextGravity = paramInt;
      recalculate();
    }
  }

  public void setExpandedTextSize(float paramFloat)
  {
    if (this.expandedTextSize != paramFloat)
    {
      this.expandedTextSize = paramFloat;
      recalculate();
    }
  }

  public void setExpandedTypeface(Typeface paramTypeface)
  {
    if (this.expandedTypeface != paramTypeface)
    {
      this.expandedTypeface = paramTypeface;
      recalculate();
    }
  }

  public void setExpansionFraction(float paramFloat)
  {
    float f = MathUtils.clamp(paramFloat, 0.0F, 1.0F);
    if (f != this.expandedFraction)
    {
      this.expandedFraction = f;
      calculateCurrentOffsets();
    }
  }

  public void setPositionInterpolator(TimeInterpolator paramTimeInterpolator)
  {
    this.positionInterpolator = paramTimeInterpolator;
    recalculate();
  }

  public final boolean setState(int[] paramArrayOfInt)
  {
    this.state = paramArrayOfInt;
    if (isStateful())
    {
      recalculate();
      return true;
    }
    return false;
  }

  public void setText(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || (!paramCharSequence.equals(this.text)))
    {
      this.text = paramCharSequence;
      this.textToDraw = null;
      clearTexture();
      recalculate();
    }
  }

  public void setTextSizeInterpolator(TimeInterpolator paramTimeInterpolator)
  {
    this.textSizeInterpolator = paramTimeInterpolator;
    recalculate();
  }

  public void setTypefaces(Typeface paramTypeface)
  {
    this.expandedTypeface = paramTypeface;
    this.collapsedTypeface = paramTypeface;
    recalculate();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.widget.CollapsingTextHelper
 * JD-Core Version:    0.6.2
 */