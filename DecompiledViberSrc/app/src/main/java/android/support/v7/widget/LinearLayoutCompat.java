package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class LinearLayoutCompat extends ViewGroup
{
  public static final int HORIZONTAL = 0;
  private static final int INDEX_BOTTOM = 2;
  private static final int INDEX_CENTER_VERTICAL = 0;
  private static final int INDEX_FILL = 3;
  private static final int INDEX_TOP = 1;
  public static final int SHOW_DIVIDER_BEGINNING = 1;
  public static final int SHOW_DIVIDER_END = 4;
  public static final int SHOW_DIVIDER_MIDDLE = 2;
  public static final int SHOW_DIVIDER_NONE = 0;
  public static final int VERTICAL = 1;
  private static final int VERTICAL_GRAVITY_COUNT = 4;
  private boolean mBaselineAligned = true;
  private int mBaselineAlignedChildIndex = -1;
  private int mBaselineChildTop = 0;
  private Drawable mDivider;
  private int mDividerHeight;
  private int mDividerPadding;
  private int mDividerWidth;
  private int mGravity = 8388659;
  private int[] mMaxAscent;
  private int[] mMaxDescent;
  private int mOrientation;
  private int mShowDividers;
  private int mTotalLength;
  private boolean mUseLargestChild;
  private float mWeightSum;

  public LinearLayoutCompat(Context paramContext)
  {
    this(paramContext, null);
  }

  public LinearLayoutCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public LinearLayoutCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.LinearLayoutCompat, paramInt, 0);
    int i = localTintTypedArray.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
    if (i >= 0)
      setOrientation(i);
    int j = localTintTypedArray.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
    if (j >= 0)
      setGravity(j);
    boolean bool = localTintTypedArray.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
    if (!bool)
      setBaselineAligned(bool);
    this.mWeightSum = localTintTypedArray.getFloat(R.styleable.LinearLayoutCompat_android_weightSum, -1.0F);
    this.mBaselineAlignedChildIndex = localTintTypedArray.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
    this.mUseLargestChild = localTintTypedArray.getBoolean(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
    setDividerDrawable(localTintTypedArray.getDrawable(R.styleable.LinearLayoutCompat_divider));
    this.mShowDividers = localTintTypedArray.getInt(R.styleable.LinearLayoutCompat_showDividers, 0);
    this.mDividerPadding = localTintTypedArray.getDimensionPixelSize(R.styleable.LinearLayoutCompat_dividerPadding, 0);
    localTintTypedArray.recycle();
  }

  private void forceUniformHeight(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
    for (int j = 0; j < paramInt1; j++)
    {
      View localView = getVirtualChildAt(j);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.height == -1)
        {
          int k = localLayoutParams.width;
          localLayoutParams.width = localView.getMeasuredWidth();
          measureChildWithMargins(localView, paramInt2, 0, i, 0);
          localLayoutParams.width = k;
        }
      }
    }
  }

  private void forceUniformWidth(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
    for (int j = 0; j < paramInt1; j++)
    {
      View localView = getVirtualChildAt(j);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.width == -1)
        {
          int k = localLayoutParams.height;
          localLayoutParams.height = localView.getMeasuredHeight();
          measureChildWithMargins(localView, i, 0, paramInt2, 0);
          localLayoutParams.height = k;
        }
      }
    }
  }

  private void setChildFrame(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.layout(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
  }

  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }

  void drawDividersHorizontal(Canvas paramCanvas)
  {
    int i = getVirtualChildCount();
    boolean bool = ViewUtils.isLayoutRtl(this);
    int j = 0;
    if (j < i)
    {
      View localView2 = getVirtualChildAt(j);
      LayoutParams localLayoutParams2;
      if ((localView2 != null) && (localView2.getVisibility() != 8) && (hasDividerBeforeChildAt(j)))
      {
        localLayoutParams2 = (LayoutParams)localView2.getLayoutParams();
        if (!bool)
          break label91;
      }
      label91: for (int m = localView2.getRight() + localLayoutParams2.rightMargin; ; m = localView2.getLeft() - localLayoutParams2.leftMargin - this.mDividerWidth)
      {
        drawVerticalDivider(paramCanvas, m);
        j++;
        break;
      }
    }
    View localView1;
    int k;
    if (hasDividerBeforeChildAt(i))
    {
      localView1 = getVirtualChildAt(i - 1);
      if (localView1 != null)
        break label171;
      if (!bool)
        break label152;
      k = getPaddingLeft();
    }
    while (true)
    {
      drawVerticalDivider(paramCanvas, k);
      return;
      label152: k = getWidth() - getPaddingRight() - this.mDividerWidth;
      continue;
      label171: LayoutParams localLayoutParams1 = (LayoutParams)localView1.getLayoutParams();
      if (bool)
        k = localView1.getLeft() - localLayoutParams1.leftMargin - this.mDividerWidth;
      else
        k = localView1.getRight() + localLayoutParams1.rightMargin;
    }
  }

  void drawDividersVertical(Canvas paramCanvas)
  {
    int i = getVirtualChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView2 = getVirtualChildAt(j);
      if ((localView2 != null) && (localView2.getVisibility() != 8) && (hasDividerBeforeChildAt(j)))
      {
        LayoutParams localLayoutParams2 = (LayoutParams)localView2.getLayoutParams();
        drawHorizontalDivider(paramCanvas, localView2.getTop() - localLayoutParams2.topMargin - this.mDividerHeight);
      }
    }
    View localView1;
    if (hasDividerBeforeChildAt(i))
    {
      localView1 = getVirtualChildAt(i - 1);
      if (localView1 != null)
        break label125;
    }
    label125: LayoutParams localLayoutParams1;
    for (int k = getHeight() - getPaddingBottom() - this.mDividerHeight; ; k = localView1.getBottom() + localLayoutParams1.bottomMargin)
    {
      drawHorizontalDivider(paramCanvas, k);
      return;
      localLayoutParams1 = (LayoutParams)localView1.getLayoutParams();
    }
  }

  void drawHorizontalDivider(Canvas paramCanvas, int paramInt)
  {
    this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, paramInt, getWidth() - getPaddingRight() - this.mDividerPadding, paramInt + this.mDividerHeight);
    this.mDivider.draw(paramCanvas);
  }

  void drawVerticalDivider(Canvas paramCanvas, int paramInt)
  {
    this.mDivider.setBounds(paramInt, getPaddingTop() + this.mDividerPadding, paramInt + this.mDividerWidth, getHeight() - getPaddingBottom() - this.mDividerPadding);
    this.mDivider.draw(paramCanvas);
  }

  protected LayoutParams generateDefaultLayoutParams()
  {
    if (this.mOrientation == 0)
      return new LayoutParams(-2, -2);
    if (this.mOrientation == 1)
      return new LayoutParams(-1, -2);
    return null;
  }

  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }

  protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }

  public int getBaseline()
  {
    int i = -1;
    if (this.mBaselineAlignedChildIndex < 0)
      i = super.getBaseline();
    View localView;
    int j;
    do
    {
      return i;
      if (getChildCount() <= this.mBaselineAlignedChildIndex)
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
      localView = getChildAt(this.mBaselineAlignedChildIndex);
      j = localView.getBaseline();
      if (j != i)
        break;
    }
    while (this.mBaselineAlignedChildIndex == 0);
    throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
    int k = this.mBaselineChildTop;
    int n;
    if (this.mOrientation == 1)
    {
      n = 0x70 & this.mGravity;
      if (n == 48);
    }
    int m;
    switch (n)
    {
    default:
      m = k;
    case 80:
    case 16:
    }
    while (true)
    {
      return j + (m + ((LayoutParams)localView.getLayoutParams()).topMargin);
      m = getBottom() - getTop() - getPaddingBottom() - this.mTotalLength;
      continue;
      m = k + (getBottom() - getTop() - getPaddingTop() - getPaddingBottom() - this.mTotalLength) / 2;
    }
  }

  public int getBaselineAlignedChildIndex()
  {
    return this.mBaselineAlignedChildIndex;
  }

  int getChildrenSkipCount(View paramView, int paramInt)
  {
    return 0;
  }

  public Drawable getDividerDrawable()
  {
    return this.mDivider;
  }

  public int getDividerPadding()
  {
    return this.mDividerPadding;
  }

  public int getDividerWidth()
  {
    return this.mDividerWidth;
  }

  public int getGravity()
  {
    return this.mGravity;
  }

  int getLocationOffset(View paramView)
  {
    return 0;
  }

  int getNextLocationOffset(View paramView)
  {
    return 0;
  }

  public int getOrientation()
  {
    return this.mOrientation;
  }

  public int getShowDividers()
  {
    return this.mShowDividers;
  }

  View getVirtualChildAt(int paramInt)
  {
    return getChildAt(paramInt);
  }

  int getVirtualChildCount()
  {
    return getChildCount();
  }

  public float getWeightSum()
  {
    return this.mWeightSum;
  }

  protected boolean hasDividerBeforeChildAt(int paramInt)
  {
    if (paramInt == 0)
      if ((0x1 & this.mShowDividers) == 0);
    do
    {
      return true;
      return false;
      if (paramInt != getChildCount())
        break;
    }
    while ((0x4 & this.mShowDividers) != 0);
    return false;
    if ((0x2 & this.mShowDividers) != 0)
      for (int i = paramInt - 1; ; i--)
      {
        if (i < 0)
          break label74;
        if (getChildAt(i).getVisibility() != 8)
          break;
      }
    return false;
    label74: return false;
  }

  public boolean isBaselineAligned()
  {
    return this.mBaselineAligned;
  }

  public boolean isMeasureWithLargestChildEnabled()
  {
    return this.mUseLargestChild;
  }

  void layoutHorizontal(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool1 = ViewUtils.isLayoutRtl(this);
    int i = getPaddingTop();
    int j = paramInt4 - paramInt2;
    int k = j - getPaddingBottom();
    int m = j - i - getPaddingBottom();
    int n = getVirtualChildCount();
    int i1 = 0x800007 & this.mGravity;
    int i2 = 0x70 & this.mGravity;
    boolean bool2 = this.mBaselineAligned;
    int[] arrayOfInt1 = this.mMaxAscent;
    int[] arrayOfInt2 = this.mMaxDescent;
    int i3;
    int i17;
    int i4;
    switch (GravityCompat.getAbsoluteGravity(i1, ViewCompat.getLayoutDirection(this)))
    {
    default:
      i3 = getPaddingLeft();
      if (bool1)
      {
        i17 = n - 1;
        i4 = -1;
      }
      break;
    case 5:
    case 1:
    }
    for (int i5 = i17; ; i5 = 0)
    {
      int i6 = 0;
      label143: int i7;
      View localView;
      int i8;
      if (i6 < n)
      {
        i7 = i5 + i4 * i6;
        localView = getVirtualChildAt(i7);
        if (localView == null)
        {
          i3 += measureNullChild(i7);
          i8 = i6;
        }
      }
      while (true)
      {
        i6 = i8 + 1;
        break label143;
        i3 = paramInt3 + getPaddingLeft() - paramInt1 - this.mTotalLength;
        break;
        i3 = getPaddingLeft() + (paramInt3 - paramInt1 - this.mTotalLength) / 2;
        break;
        if (localView.getVisibility() != 8)
        {
          int i9 = localView.getMeasuredWidth();
          int i10 = localView.getMeasuredHeight();
          LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if ((bool2) && (localLayoutParams.height != -1));
          for (int i11 = localView.getBaseline(); ; i11 = -1)
          {
            int i12 = localLayoutParams.gravity;
            if (i12 < 0)
              i12 = i2;
            int i13;
            switch (i12 & 0x70)
            {
            default:
              i13 = i;
              label348: if (!hasDividerBeforeChildAt(i7))
                break;
            case 48:
            case 16:
            case 80:
            }
            for (int i15 = i3 + this.mDividerWidth; ; i15 = i3)
            {
              int i16 = i15 + localLayoutParams.leftMargin;
              setChildFrame(localView, i16 + getLocationOffset(localView), i13, i9, i10);
              i3 = i16 + (i9 + localLayoutParams.rightMargin + getNextLocationOffset(localView));
              i8 = i6 + getChildrenSkipCount(localView, i7);
              break;
              i13 = i + localLayoutParams.topMargin;
              if (i11 == -1)
                break label348;
              i13 += arrayOfInt1[1] - i11;
              break label348;
              i13 = i + (m - i10) / 2 + localLayoutParams.topMargin - localLayoutParams.bottomMargin;
              break label348;
              i13 = k - i10 - localLayoutParams.bottomMargin;
              if (i11 == -1)
                break label348;
              int i14 = localView.getMeasuredHeight() - i11;
              i13 -= arrayOfInt2[2] - i14;
              break label348;
              return;
            }
          }
        }
        i8 = i6;
      }
      i4 = 1;
    }
  }

  void layoutVertical(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getPaddingLeft();
    int j = paramInt3 - paramInt1;
    int k = j - getPaddingRight();
    int m = j - i - getPaddingRight();
    int n = getVirtualChildCount();
    int i1 = 0x70 & this.mGravity;
    int i2 = 0x800007 & this.mGravity;
    int i3;
    int i4;
    int i5;
    label97: View localView;
    int i6;
    switch (i1)
    {
    default:
      i3 = getPaddingTop();
      i4 = 0;
      i5 = i3;
      if (i4 < n)
      {
        localView = getVirtualChildAt(i4);
        if (localView == null)
        {
          i5 += measureNullChild(i4);
          i6 = i4;
        }
      }
      break;
    case 80:
    case 16:
    }
    while (true)
    {
      i4 = i6 + 1;
      break label97;
      i3 = paramInt4 + getPaddingTop() - paramInt2 - this.mTotalLength;
      break;
      i3 = getPaddingTop() + (paramInt4 - paramInt2 - this.mTotalLength) / 2;
      break;
      if (localView.getVisibility() != 8)
      {
        int i7 = localView.getMeasuredWidth();
        int i8 = localView.getMeasuredHeight();
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        int i9 = localLayoutParams.gravity;
        if (i9 < 0)
          i9 = i2;
        int i10;
        switch (0x7 & GravityCompat.getAbsoluteGravity(i9, ViewCompat.getLayoutDirection(this)))
        {
        default:
          i10 = i + localLayoutParams.leftMargin;
          label278: if (!hasDividerBeforeChildAt(i4))
            break;
        case 1:
        case 5:
        }
        for (int i11 = i5 + this.mDividerHeight; ; i11 = i5)
        {
          int i12 = i11 + localLayoutParams.topMargin;
          setChildFrame(localView, i10, i12 + getLocationOffset(localView), i7, i8);
          i5 = i12 + (i8 + localLayoutParams.bottomMargin + getNextLocationOffset(localView));
          i6 = i4 + getChildrenSkipCount(localView, i4);
          break;
          i10 = i + (m - i7) / 2 + localLayoutParams.leftMargin - localLayoutParams.rightMargin;
          break label278;
          i10 = k - i7 - localLayoutParams.rightMargin;
          break label278;
          return;
        }
      }
      i6 = i4;
    }
  }

  void measureChildBeforeLayout(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    measureChildWithMargins(paramView, paramInt2, paramInt3, paramInt4, paramInt5);
  }

  void measureHorizontal(int paramInt1, int paramInt2)
  {
    this.mTotalLength = 0;
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 1;
    float f1 = 0.0F;
    int i1 = getVirtualChildCount();
    int i2 = View.MeasureSpec.getMode(paramInt1);
    int i3 = View.MeasureSpec.getMode(paramInt2);
    int i4 = 0;
    int i5 = 0;
    if ((this.mMaxAscent == null) || (this.mMaxDescent == null))
    {
      this.mMaxAscent = new int[4];
      this.mMaxDescent = new int[4];
    }
    int[] arrayOfInt1 = this.mMaxAscent;
    int[] arrayOfInt2 = this.mMaxDescent;
    arrayOfInt1[3] = -1;
    arrayOfInt1[2] = -1;
    arrayOfInt1[1] = -1;
    arrayOfInt1[0] = -1;
    arrayOfInt2[3] = -1;
    arrayOfInt2[2] = -1;
    arrayOfInt2[1] = -1;
    arrayOfInt2[0] = -1;
    boolean bool1 = this.mBaselineAligned;
    boolean bool2 = this.mUseLargestChild;
    int i6;
    int i7;
    int i8;
    label154: View localView4;
    int i64;
    int i62;
    int i59;
    int i65;
    if (i2 == 1073741824)
    {
      i6 = 1;
      i7 = 0;
      i8 = 0;
      if (i8 >= i1)
        break label916;
      localView4 = getVirtualChildAt(i8);
      if (localView4 != null)
        break label239;
      this.mTotalLength += measureNullChild(i8);
      i64 = i7;
      i62 = i5;
      i59 = n;
      i65 = j;
    }
    for (int i63 = i; ; i63 = i)
    {
      i8++;
      i7 = i64;
      i5 = i62;
      n = i59;
      j = i65;
      i = i63;
      break label154;
      i6 = 0;
      break;
      label239: if (localView4.getVisibility() != 8)
        break label284;
      i8 += getChildrenSkipCount(localView4, i8);
      i64 = i7;
      i62 = i5;
      i59 = n;
      i65 = j;
    }
    label284: if (hasDividerBeforeChildAt(i8))
      this.mTotalLength += this.mDividerWidth;
    LayoutParams localLayoutParams3 = (LayoutParams)localView4.getLayoutParams();
    float f7 = f1 + localLayoutParams3.weight;
    label376: int i52;
    if ((i2 == 1073741824) && (localLayoutParams3.width == 0) && (localLayoutParams3.weight > 0.0F))
      if (i6 != 0)
      {
        this.mTotalLength += localLayoutParams3.leftMargin + localLayoutParams3.rightMargin;
        if (!bool1)
          break label674;
        int i71 = View.MeasureSpec.makeMeasureSpec(0, 0);
        localView4.measure(i71, i71);
        label397: if ((i3 == 1073741824) || (localLayoutParams3.height != -1))
          break label2302;
        i52 = 1;
      }
    for (int i53 = 1; ; i53 = 0)
    {
      int i54 = localLayoutParams3.topMargin + localLayoutParams3.bottomMargin;
      int i55 = i54 + localView4.getMeasuredHeight();
      int i56 = localView4.getMeasuredState();
      int i57 = View.combineMeasuredStates(j, i56);
      int i68;
      if (bool1)
      {
        int i67 = localView4.getBaseline();
        if (i67 != -1)
        {
          if (localLayoutParams3.gravity >= 0)
            break label865;
          i68 = this.mGravity;
          label490: int i69 = (0xFFFFFFFE & (i68 & 0x70) >> 4) >> 1;
          arrayOfInt1[i69] = Math.max(arrayOfInt1[i69], i67);
          arrayOfInt2[i69] = Math.max(arrayOfInt2[i69], i55 - i67);
        }
      }
      int i58 = Math.max(i, i55);
      if ((n != 0) && (localLayoutParams3.height == -1))
      {
        i59 = 1;
        label562: if (localLayoutParams3.weight <= 0.0F)
          break label888;
        if (i53 == 0)
          break label881;
      }
      int i61;
      int i60;
      label674: label730: label863: label865: label881: for (int i66 = i54; ; i66 = i55)
      {
        i61 = Math.max(m, i66);
        i60 = k;
        i8 += getChildrenSkipCount(localView4, i8);
        i62 = i5;
        m = i61;
        k = i60;
        i63 = i58;
        i64 = i7;
        i65 = i57;
        i4 = i52;
        f1 = f7;
        break;
        int i70 = this.mTotalLength;
        this.mTotalLength = Math.max(i70, i70 + localLayoutParams3.leftMargin + localLayoutParams3.rightMargin);
        break label376;
        i5 = 1;
        break label397;
        int i47 = -2147483648;
        if ((localLayoutParams3.width == 0) && (localLayoutParams3.weight > 0.0F))
        {
          i47 = 0;
          localLayoutParams3.width = -2;
        }
        int i48 = i47;
        int i49;
        int i50;
        if (f7 == 0.0F)
        {
          i49 = this.mTotalLength;
          measureChildBeforeLayout(localView4, i8, paramInt1, i49, paramInt2, 0);
          if (i48 != -2147483648)
            localLayoutParams3.width = i48;
          i50 = localView4.getMeasuredWidth();
          if (i6 == 0)
            break label823;
        }
        int i51;
        for (this.mTotalLength += i50 + localLayoutParams3.leftMargin + localLayoutParams3.rightMargin + getNextLocationOffset(localView4); ; this.mTotalLength = Math.max(i51, i51 + i50 + localLayoutParams3.leftMargin + localLayoutParams3.rightMargin + getNextLocationOffset(localView4)))
        {
          if (!bool2)
            break label863;
          i7 = Math.max(i50, i7);
          break;
          i49 = 0;
          break label730;
          i51 = this.mTotalLength;
        }
        break label397;
        i68 = localLayoutParams3.gravity;
        break label490;
        i59 = 0;
        break label562;
      }
      label823: label888: if (i53 != 0);
      while (true)
      {
        i60 = Math.max(k, i54);
        i61 = m;
        break;
        i54 = i55;
      }
      label916: if ((this.mTotalLength > 0) && (hasDividerBeforeChildAt(i1)))
        this.mTotalLength += this.mDividerWidth;
      int i9;
      if ((arrayOfInt1[1] != -1) || (arrayOfInt1[0] != -1) || (arrayOfInt1[2] != -1) || (arrayOfInt1[3] != -1))
        i9 = Math.max(arrayOfInt1[3], Math.max(arrayOfInt1[0], Math.max(arrayOfInt1[1], arrayOfInt1[2]))) + Math.max(arrayOfInt2[3], Math.max(arrayOfInt2[0], Math.max(arrayOfInt2[1], arrayOfInt2[2])));
      for (int i10 = Math.max(i, i9); ; i10 = i)
      {
        if ((bool2) && ((i2 == -2147483648) || (i2 == 0)))
        {
          this.mTotalLength = 0;
          int i44 = 0;
          if (i44 < i1)
          {
            View localView3 = getVirtualChildAt(i44);
            int i46;
            if (localView3 == null)
            {
              this.mTotalLength += measureNullChild(i44);
              i46 = i44;
            }
            while (true)
            {
              i44 = i46 + 1;
              break;
              if (localView3.getVisibility() == 8)
              {
                i46 = i44 + getChildrenSkipCount(localView3, i44);
              }
              else
              {
                LayoutParams localLayoutParams2 = (LayoutParams)localView3.getLayoutParams();
                if (i6 != 0)
                {
                  this.mTotalLength += i7 + localLayoutParams2.leftMargin + localLayoutParams2.rightMargin + getNextLocationOffset(localView3);
                  i46 = i44;
                }
                else
                {
                  int i45 = this.mTotalLength;
                  this.mTotalLength = Math.max(i45, i45 + i7 + localLayoutParams2.leftMargin + localLayoutParams2.rightMargin + getNextLocationOffset(localView3));
                  i46 = i44;
                }
              }
            }
          }
        }
        this.mTotalLength += getPaddingLeft() + getPaddingRight();
        int i11 = View.resolveSizeAndState(Math.max(this.mTotalLength, getSuggestedMinimumWidth()), paramInt1, 0);
        int i12 = (0xFFFFFF & i11) - this.mTotalLength;
        int i13;
        float f2;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        View localView1;
        float f3;
        int i22;
        int i23;
        int i24;
        int i25;
        if ((i5 != 0) || ((i12 != 0) && (f1 > 0.0F)))
        {
          if (this.mWeightSum > 0.0F)
            f1 = this.mWeightSum;
          arrayOfInt1[3] = -1;
          arrayOfInt1[2] = -1;
          arrayOfInt1[1] = -1;
          arrayOfInt1[0] = -1;
          arrayOfInt2[3] = -1;
          arrayOfInt2[2] = -1;
          arrayOfInt2[1] = -1;
          arrayOfInt2[0] = -1;
          this.mTotalLength = 0;
          i13 = 0;
          f2 = f1;
          i14 = n;
          i15 = k;
          i16 = j;
          i17 = i12;
          i18 = -1;
          if (i13 < i1)
          {
            localView1 = getVirtualChildAt(i13);
            if (localView1 == null)
              break label2273;
            if (localView1.getVisibility() == 8)
            {
              f3 = f2;
              i22 = i17;
              i23 = i18;
              i24 = i15;
              i25 = i14;
            }
          }
        }
        while (true)
        {
          i13++;
          i15 = i24;
          i18 = i23;
          i14 = i25;
          i17 = i22;
          f2 = f3;
          break;
          LayoutParams localLayoutParams1 = (LayoutParams)localView1.getLayoutParams();
          float f4 = localLayoutParams1.weight;
          int i39;
          float f6;
          int i26;
          int i40;
          int i27;
          if (f4 > 0.0F)
          {
            i39 = (int)(f4 * i17 / f2);
            f6 = f2 - f4;
            i26 = i17 - i39;
            i40 = getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom() + localLayoutParams1.topMargin + localLayoutParams1.bottomMargin, localLayoutParams1.height);
            if ((localLayoutParams1.width != 0) || (i2 != 1073741824))
            {
              int i41 = i39 + localView1.getMeasuredWidth();
              if (i41 < 0)
                i41 = 0;
              localView1.measure(View.MeasureSpec.makeMeasureSpec(i41, 1073741824), i40);
              i27 = View.combineMeasuredStates(i16, 0xFF000000 & localView1.getMeasuredState());
            }
          }
          for (float f5 = f6; ; f5 = f2)
          {
            label1651: int i29;
            label1670: int i31;
            int i32;
            int i33;
            label1711: int i34;
            int i35;
            label1737: int i36;
            if (i6 != 0)
            {
              this.mTotalLength += localView1.getMeasuredWidth() + localLayoutParams1.leftMargin + localLayoutParams1.rightMargin + getNextLocationOffset(localView1);
              if ((i3 == 1073741824) || (localLayoutParams1.height != -1))
                break label1916;
              i29 = 1;
              int i30 = localLayoutParams1.topMargin + localLayoutParams1.bottomMargin;
              i31 = i30 + localView1.getMeasuredHeight();
              i32 = Math.max(i18, i31);
              if (i29 == 0)
                break label1922;
              i33 = i30;
              i34 = Math.max(i15, i33);
              if ((i14 == 0) || (localLayoutParams1.height != -1))
                break label1929;
              i35 = 1;
              if (bool1)
              {
                i36 = localView1.getBaseline();
                if (i36 != -1)
                  if (localLayoutParams1.gravity >= 0)
                    break label1935;
              }
            }
            label1922: label1929: label1935: for (int i37 = this.mGravity; ; i37 = localLayoutParams1.gravity)
            {
              int i38 = (0xFFFFFFFE & (i37 & 0x70) >> 4) >> 1;
              arrayOfInt1[i38] = Math.max(arrayOfInt1[i38], i36);
              arrayOfInt2[i38] = Math.max(arrayOfInt2[i38], i31 - i36);
              f3 = f5;
              i24 = i34;
              i25 = i35;
              i16 = i27;
              i22 = i26;
              i23 = i32;
              break;
              if (i39 > 0);
              while (true)
              {
                localView1.measure(View.MeasureSpec.makeMeasureSpec(i39, 1073741824), i40);
                break;
                i39 = 0;
              }
              int i28 = this.mTotalLength;
              this.mTotalLength = Math.max(i28, i28 + localView1.getMeasuredWidth() + localLayoutParams1.leftMargin + localLayoutParams1.rightMargin + getNextLocationOffset(localView1));
              break label1651;
              label1916: i29 = 0;
              break label1670;
              i33 = i31;
              break label1711;
              i35 = 0;
              break label1737;
            }
            this.mTotalLength += getPaddingLeft() + getPaddingRight();
            if ((arrayOfInt1[1] != -1) || (arrayOfInt1[0] != -1) || (arrayOfInt1[2] != -1) || (arrayOfInt1[3] != -1))
              i18 = Math.max(i18, Math.max(arrayOfInt1[3], Math.max(arrayOfInt1[0], Math.max(arrayOfInt1[1], arrayOfInt1[2]))) + Math.max(arrayOfInt2[3], Math.max(arrayOfInt2[0], Math.max(arrayOfInt2[1], arrayOfInt2[2]))));
            n = i14;
            int i19 = i15;
            j = i16;
            for (int i20 = i18; ; i20 = i10)
            {
              if ((n == 0) && (i3 != 1073741824));
              int i42;
              while (true)
              {
                int i21 = Math.max(i19 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
                setMeasuredDimension(i11 | 0xFF000000 & j, View.resolveSizeAndState(i21, paramInt2, j << 16));
                if (i4 != 0)
                  forceUniformHeight(i1, paramInt1);
                return;
                i42 = Math.max(k, m);
                if ((!bool2) || (i2 == 1073741824))
                  break;
                int i43 = 0;
                if (i43 >= i1)
                  break;
                View localView2 = getVirtualChildAt(i43);
                if ((localView2 == null) || (localView2.getVisibility() == 8));
                while (true)
                {
                  i43++;
                  break;
                  if (((LayoutParams)localView2.getLayoutParams()).weight > 0.0F)
                    localView2.measure(View.MeasureSpec.makeMeasureSpec(i7, 1073741824), View.MeasureSpec.makeMeasureSpec(localView2.getMeasuredHeight(), 1073741824));
                }
                i19 = i20;
              }
              i19 = i42;
            }
            i26 = i17;
            i27 = i16;
          }
          label2273: f3 = f2;
          i22 = i17;
          i23 = i18;
          i24 = i15;
          i25 = i14;
        }
      }
      label2302: i52 = i4;
    }
  }

  int measureNullChild(int paramInt)
  {
    return 0;
  }

  void measureVertical(int paramInt1, int paramInt2)
  {
    this.mTotalLength = 0;
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 1;
    float f1 = 0.0F;
    int i1 = getVirtualChildCount();
    int i2 = View.MeasureSpec.getMode(paramInt1);
    int i3 = View.MeasureSpec.getMode(paramInt2);
    int i4 = 0;
    int i5 = 0;
    int i6 = this.mBaselineAlignedChildIndex;
    boolean bool = this.mUseLargestChild;
    int i7 = 0;
    int i8 = 0;
    View localView4;
    int i58;
    int i56;
    int i53;
    int i59;
    int i57;
    label188: LayoutParams localLayoutParams3;
    float f7;
    int i46;
    if (i8 < i1)
    {
      localView4 = getVirtualChildAt(i8);
      if (localView4 == null)
      {
        this.mTotalLength += measureNullChild(i8);
        i58 = i7;
        i56 = i5;
        i53 = n;
        i59 = j;
      }
      for (i57 = i; ; i57 = i)
      {
        i8++;
        i7 = i58;
        i5 = i56;
        n = i53;
        j = i59;
        i = i57;
        break;
        if (localView4.getVisibility() != 8)
          break label188;
        i8 += getChildrenSkipCount(localView4, i8);
        i58 = i7;
        i56 = i5;
        i53 = n;
        i59 = j;
      }
      if (hasDividerBeforeChildAt(i8))
        this.mTotalLength += this.mDividerHeight;
      localLayoutParams3 = (LayoutParams)localView4.getLayoutParams();
      f7 = f1 + localLayoutParams3.weight;
      if ((i3 == 1073741824) && (localLayoutParams3.height == 0) && (localLayoutParams3.weight > 0.0F))
      {
        int i61 = this.mTotalLength;
        this.mTotalLength = Math.max(i61, i61 + localLayoutParams3.topMargin + localLayoutParams3.bottomMargin);
        i5 = 1;
        if ((i6 >= 0) && (i6 == i8 + 1))
          this.mBaselineChildTop = this.mTotalLength;
        if ((i8 < i6) && (localLayoutParams3.weight > 0.0F))
          throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
      }
      else
      {
        int i41 = -2147483648;
        if ((localLayoutParams3.height == 0) && (localLayoutParams3.weight > 0.0F))
        {
          i41 = 0;
          localLayoutParams3.height = -2;
        }
        int i42 = i41;
        if (f7 == 0.0F);
        for (int i43 = this.mTotalLength; ; i43 = 0)
        {
          measureChildBeforeLayout(localView4, i8, paramInt1, 0, paramInt2, i43);
          if (i42 != -2147483648)
            localLayoutParams3.height = i42;
          int i44 = localView4.getMeasuredHeight();
          int i45 = this.mTotalLength;
          this.mTotalLength = Math.max(i45, i45 + i44 + localLayoutParams3.topMargin + localLayoutParams3.bottomMargin + getNextLocationOffset(localView4));
          if (!bool)
            break;
          i7 = Math.max(i44, i7);
          break;
        }
      }
      if ((i2 == 1073741824) || (localLayoutParams3.width != -1))
        break label1629;
      i46 = 1;
    }
    for (int i47 = 1; ; i47 = 0)
    {
      int i48 = localLayoutParams3.leftMargin + localLayoutParams3.rightMargin;
      int i49 = i48 + localView4.getMeasuredWidth();
      int i50 = Math.max(i, i49);
      int i51 = localView4.getMeasuredState();
      int i52 = View.combineMeasuredStates(j, i51);
      if ((n != 0) && (localLayoutParams3.width == -1))
      {
        i53 = 1;
        label570: if (localLayoutParams3.weight <= 0.0F)
          break label663;
        if (i47 == 0)
          break label656;
      }
      int i55;
      int i54;
      label656: for (int i60 = i48; ; i60 = i49)
      {
        i55 = Math.max(m, i60);
        i54 = k;
        i8 += getChildrenSkipCount(localView4, i8);
        i56 = i5;
        m = i55;
        k = i54;
        i57 = i50;
        i58 = i7;
        i59 = i52;
        i4 = i46;
        f1 = f7;
        break;
        i53 = 0;
        break label570;
      }
      label663: if (i47 != 0);
      while (true)
      {
        i54 = Math.max(k, i48);
        i55 = m;
        break;
        i48 = i49;
      }
      if ((this.mTotalLength > 0) && (hasDividerBeforeChildAt(i1)))
        this.mTotalLength += this.mDividerHeight;
      if ((bool) && ((i3 == -2147483648) || (i3 == 0)))
      {
        this.mTotalLength = 0;
        int i38 = 0;
        if (i38 < i1)
        {
          View localView3 = getVirtualChildAt(i38);
          int i40;
          if (localView3 == null)
          {
            this.mTotalLength += measureNullChild(i38);
            i40 = i38;
          }
          while (true)
          {
            i38 = i40 + 1;
            break;
            if (localView3.getVisibility() == 8)
            {
              i40 = i38 + getChildrenSkipCount(localView3, i38);
            }
            else
            {
              LayoutParams localLayoutParams2 = (LayoutParams)localView3.getLayoutParams();
              int i39 = this.mTotalLength;
              this.mTotalLength = Math.max(i39, i39 + i7 + localLayoutParams2.topMargin + localLayoutParams2.bottomMargin + getNextLocationOffset(localView3));
              i40 = i38;
            }
          }
        }
      }
      this.mTotalLength += getPaddingTop() + getPaddingBottom();
      int i9 = View.resolveSizeAndState(Math.max(this.mTotalLength, getSuggestedMinimumHeight()), paramInt2, 0);
      int i10 = (0xFFFFFF & i9) - this.mTotalLength;
      float f2;
      int i12;
      int i13;
      int i14;
      int i15;
      int i16;
      View localView1;
      int i28;
      int i30;
      int i29;
      int i26;
      LayoutParams localLayoutParams1;
      int i31;
      int i33;
      int i19;
      int i20;
      float f4;
      if ((i5 != 0) || ((i10 != 0) && (f1 > 0.0F)))
      {
        if (this.mWeightSum > 0.0F)
          f1 = this.mWeightSum;
        this.mTotalLength = 0;
        int i11 = 0;
        f2 = f1;
        i12 = n;
        i13 = k;
        i14 = j;
        i15 = i;
        i16 = i10;
        while (true)
          if (i11 < i1)
          {
            localView1 = getVirtualChildAt(i11);
            if (localView1.getVisibility() == 8)
            {
              i28 = i13;
              i30 = i14;
              i29 = i15;
              i26 = i12;
              i11++;
              i13 = i28;
              i15 = i29;
              i12 = i26;
              i14 = i30;
            }
            else
            {
              localLayoutParams1 = (LayoutParams)localView1.getLayoutParams();
              float f3 = localLayoutParams1.weight;
              if (f3 <= 0.0F)
                break label1614;
              i31 = (int)(f3 * i16 / f2);
              float f6 = f2 - f3;
              int i32 = i16 - i31;
              i33 = getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + localLayoutParams1.leftMargin + localLayoutParams1.rightMargin, localLayoutParams1.width);
              if ((localLayoutParams1.height != 0) || (i3 != 1073741824))
              {
                int i34 = i31 + localView1.getMeasuredHeight();
                if (i34 < 0)
                  i34 = 0;
                localView1.measure(i33, View.MeasureSpec.makeMeasureSpec(i34, 1073741824));
                int i35 = View.combineMeasuredStates(i14, 0xFFFFFF00 & localView1.getMeasuredState());
                i19 = i32;
                i20 = i35;
                f4 = f6;
              }
            }
          }
      }
      while (true)
      {
        int i21 = localLayoutParams1.leftMargin + localLayoutParams1.rightMargin;
        int i22 = i21 + localView1.getMeasuredWidth();
        int i23 = Math.max(i15, i22);
        int i24;
        label1259: label1264: int i25;
        if ((i2 != 1073741824) && (localLayoutParams1.width == -1))
        {
          i24 = 1;
          if (i24 == 0)
            break label1393;
          i25 = Math.max(i13, i21);
          if ((i12 == 0) || (localLayoutParams1.width != -1))
            break label1400;
        }
        label1393: label1400: for (i26 = 1; ; i26 = 0)
        {
          int i27 = this.mTotalLength;
          this.mTotalLength = Math.max(i27, i27 + localView1.getMeasuredHeight() + localLayoutParams1.topMargin + localLayoutParams1.bottomMargin + getNextLocationOffset(localView1));
          i28 = i25;
          i29 = i23;
          float f5 = f4;
          i30 = i20;
          i16 = i19;
          f2 = f5;
          break;
          if (i31 > 0);
          while (true)
          {
            localView1.measure(i33, View.MeasureSpec.makeMeasureSpec(i31, 1073741824));
            break;
            i31 = 0;
          }
          i24 = 0;
          break label1259;
          i21 = i22;
          break label1264;
        }
        this.mTotalLength += getPaddingTop() + getPaddingBottom();
        n = i12;
        int i17 = i13;
        j = i14;
        for (int i18 = i15; ; i18 = i)
        {
          if ((n == 0) && (i2 != 1073741824));
          int i36;
          while (true)
          {
            setMeasuredDimension(View.resolveSizeAndState(Math.max(i17 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), paramInt1, j), i9);
            if (i4 != 0)
              forceUniformWidth(i1, paramInt2);
            return;
            i36 = Math.max(k, m);
            if ((!bool) || (i3 == 1073741824))
              break;
            int i37 = 0;
            if (i37 >= i1)
              break;
            View localView2 = getVirtualChildAt(i37);
            if ((localView2 == null) || (localView2.getVisibility() == 8));
            while (true)
            {
              i37++;
              break;
              if (((LayoutParams)localView2.getLayoutParams()).weight > 0.0F)
                localView2.measure(View.MeasureSpec.makeMeasureSpec(localView2.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i7, 1073741824));
            }
            i17 = i18;
          }
          i17 = i36;
        }
        label1614: f4 = f2;
        i19 = i16;
        i20 = i14;
      }
      label1629: i46 = i4;
    }
  }

  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mDivider == null)
      return;
    if (this.mOrientation == 1)
    {
      drawDividersVertical(paramCanvas);
      return;
    }
    drawDividersHorizontal(paramCanvas);
  }

  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
  }

  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mOrientation == 1)
    {
      layoutVertical(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    layoutHorizontal(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.mOrientation == 1)
    {
      measureVertical(paramInt1, paramInt2);
      return;
    }
    measureHorizontal(paramInt1, paramInt2);
  }

  public void setBaselineAligned(boolean paramBoolean)
  {
    this.mBaselineAligned = paramBoolean;
  }

  public void setBaselineAlignedChildIndex(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getChildCount()))
      throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    this.mBaselineAlignedChildIndex = paramInt;
  }

  public void setDividerDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == this.mDivider)
      return;
    this.mDivider = paramDrawable;
    if (paramDrawable != null)
      this.mDividerWidth = paramDrawable.getIntrinsicWidth();
    for (this.mDividerHeight = paramDrawable.getIntrinsicHeight(); ; this.mDividerHeight = 0)
    {
      boolean bool = false;
      if (paramDrawable == null)
        bool = true;
      setWillNotDraw(bool);
      requestLayout();
      return;
      this.mDividerWidth = 0;
    }
  }

  public void setDividerPadding(int paramInt)
  {
    this.mDividerPadding = paramInt;
  }

  public void setGravity(int paramInt)
  {
    if (this.mGravity != paramInt)
      if ((0x800007 & paramInt) != 0)
        break label44;
    label44: for (int i = 0x800003 | paramInt; ; i = paramInt)
    {
      if ((i & 0x70) == 0)
        i |= 48;
      this.mGravity = i;
      requestLayout();
      return;
    }
  }

  public void setHorizontalGravity(int paramInt)
  {
    int i = paramInt & 0x800007;
    if ((0x800007 & this.mGravity) != i)
    {
      this.mGravity = (i | 0xFF7FFFF8 & this.mGravity);
      requestLayout();
    }
  }

  public void setMeasureWithLargestChildEnabled(boolean paramBoolean)
  {
    this.mUseLargestChild = paramBoolean;
  }

  public void setOrientation(int paramInt)
  {
    if (this.mOrientation != paramInt)
    {
      this.mOrientation = paramInt;
      requestLayout();
    }
  }

  public void setShowDividers(int paramInt)
  {
    if (paramInt != this.mShowDividers)
      requestLayout();
    this.mShowDividers = paramInt;
  }

  public void setVerticalGravity(int paramInt)
  {
    int i = paramInt & 0x70;
    if ((0x70 & this.mGravity) != i)
    {
      this.mGravity = (i | 0xFFFFFF8F & this.mGravity);
      requestLayout();
    }
  }

  public void setWeightSum(float paramFloat)
  {
    this.mWeightSum = Math.max(0.0F, paramFloat);
  }

  public boolean shouldDelayChildPressedState()
  {
    return false;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface DividerMode
  {
  }

  public static class LayoutParams extends ViewGroup.MarginLayoutParams
  {
    public int gravity = -1;
    public float weight;

    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      this.weight = 0.0F;
    }

    public LayoutParams(int paramInt1, int paramInt2, float paramFloat)
    {
      super(paramInt2);
      this.weight = paramFloat;
    }

    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LinearLayoutCompat_Layout);
      this.weight = localTypedArray.getFloat(R.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0F);
      this.gravity = localTypedArray.getInt(R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
      localTypedArray.recycle();
    }

    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.weight = paramLayoutParams.weight;
      this.gravity = paramLayoutParams.gravity;
    }

    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }

    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface OrientationMode
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.LinearLayoutCompat
 * JD-Core Version:    0.6.2
 */