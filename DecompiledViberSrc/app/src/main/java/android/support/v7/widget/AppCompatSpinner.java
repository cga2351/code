package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.TintableBackgroundView;
import android.support.v4.view.ViewCompat;
import android.support.v7.a.a.a;
import android.support.v7.appcompat.R.attr;
import android.support.v7.view.menu.s;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class AppCompatSpinner extends Spinner
  implements TintableBackgroundView
{
  private static final int[] ATTRS_ANDROID_SPINNERMODE = { 16843505 };
  private static final int MAX_ITEMS_MEASURED = 15;
  private static final int MODE_DIALOG = 0;
  private static final int MODE_DROPDOWN = 1;
  private static final int MODE_THEME = -1;
  private static final String TAG = "AppCompatSpinner";
  private final AppCompatBackgroundHelper mBackgroundTintHelper;
  int mDropDownWidth;
  private ForwardingListener mForwardingListener;
  DropdownPopup mPopup;
  private final Context mPopupContext;
  private final boolean mPopupSet;
  private SpinnerAdapter mTempAdapter;
  final Rect mTempRect;

  public AppCompatSpinner(Context paramContext)
  {
    this(paramContext, null);
  }

  public AppCompatSpinner(Context paramContext, int paramInt)
  {
    this(paramContext, null, R.attr.spinnerStyle, paramInt);
  }

  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.spinnerStyle);
  }

  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, -1);
  }

  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this(paramContext, paramAttributeSet, paramInt1, paramInt2, null);
  }

  // ERROR //
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, Resources.Theme paramTheme)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 64	android/widget/Spinner:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: new 66	android/graphics/Rect
    //   11: dup
    //   12: invokespecial 68	android/graphics/Rect:<init>	()V
    //   15: putfield 70	android/support/v7/widget/AppCompatSpinner:mTempRect	Landroid/graphics/Rect;
    //   18: aload_1
    //   19: aload_2
    //   20: getstatic 75	android/support/v7/appcompat/R$styleable:Spinner	[I
    //   23: iload_3
    //   24: iconst_0
    //   25: invokestatic 81	android/support/v7/widget/TintTypedArray:obtainStyledAttributes	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/TintTypedArray;
    //   28: astore 6
    //   30: aload_0
    //   31: new 83	android/support/v7/widget/AppCompatBackgroundHelper
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 86	android/support/v7/widget/AppCompatBackgroundHelper:<init>	(Landroid/view/View;)V
    //   39: putfield 88	android/support/v7/widget/AppCompatSpinner:mBackgroundTintHelper	Landroid/support/v7/widget/AppCompatBackgroundHelper;
    //   42: aload 5
    //   44: ifnull +264 -> 308
    //   47: aload_0
    //   48: new 90	android/support/v7/view/d
    //   51: dup
    //   52: aload_1
    //   53: aload 5
    //   55: invokespecial 93	android/support/v7/view/d:<init>	(Landroid/content/Context;Landroid/content/res/Resources$Theme;)V
    //   58: putfield 95	android/support/v7/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   61: aload_0
    //   62: getfield 95	android/support/v7/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   65: ifnull +160 -> 225
    //   68: iload 4
    //   70: iconst_m1
    //   71: if_icmpne +51 -> 122
    //   74: aload_1
    //   75: aload_2
    //   76: getstatic 41	android/support/v7/widget/AppCompatSpinner:ATTRS_ANDROID_SPINNERMODE	[I
    //   79: iload_3
    //   80: iconst_0
    //   81: invokevirtual 100	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   84: astore 17
    //   86: aload 17
    //   88: astore 14
    //   90: aload 14
    //   92: iconst_0
    //   93: invokevirtual 106	android/content/res/TypedArray:hasValue	(I)Z
    //   96: ifeq +16 -> 112
    //   99: aload 14
    //   101: iconst_0
    //   102: iconst_0
    //   103: invokevirtual 110	android/content/res/TypedArray:getInt	(II)I
    //   106: istore 18
    //   108: iload 18
    //   110: istore 4
    //   112: aload 14
    //   114: ifnull +8 -> 122
    //   117: aload 14
    //   119: invokevirtual 113	android/content/res/TypedArray:recycle	()V
    //   122: iload 4
    //   124: iconst_1
    //   125: if_icmpne +100 -> 225
    //   128: new 115	android/support/v7/widget/AppCompatSpinner$DropdownPopup
    //   131: dup
    //   132: aload_0
    //   133: aload_0
    //   134: getfield 95	android/support/v7/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   137: aload_2
    //   138: iload_3
    //   139: invokespecial 118	android/support/v7/widget/AppCompatSpinner$DropdownPopup:<init>	(Landroid/support/v7/widget/AppCompatSpinner;Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   142: astore 11
    //   144: aload_0
    //   145: getfield 95	android/support/v7/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   148: aload_2
    //   149: getstatic 75	android/support/v7/appcompat/R$styleable:Spinner	[I
    //   152: iload_3
    //   153: iconst_0
    //   154: invokestatic 81	android/support/v7/widget/TintTypedArray:obtainStyledAttributes	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/TintTypedArray;
    //   157: astore 12
    //   159: aload_0
    //   160: aload 12
    //   162: getstatic 121	android/support/v7/appcompat/R$styleable:Spinner_android_dropDownWidth	I
    //   165: bipush 254
    //   167: invokevirtual 124	android/support/v7/widget/TintTypedArray:getLayoutDimension	(II)I
    //   170: putfield 126	android/support/v7/widget/AppCompatSpinner:mDropDownWidth	I
    //   173: aload 11
    //   175: aload 12
    //   177: getstatic 129	android/support/v7/appcompat/R$styleable:Spinner_android_popupBackground	I
    //   180: invokevirtual 133	android/support/v7/widget/TintTypedArray:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   183: invokevirtual 137	android/support/v7/widget/AppCompatSpinner$DropdownPopup:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   186: aload 11
    //   188: aload 6
    //   190: getstatic 140	android/support/v7/appcompat/R$styleable:Spinner_android_prompt	I
    //   193: invokevirtual 144	android/support/v7/widget/TintTypedArray:getString	(I)Ljava/lang/String;
    //   196: invokevirtual 148	android/support/v7/widget/AppCompatSpinner$DropdownPopup:setPromptText	(Ljava/lang/CharSequence;)V
    //   199: aload 12
    //   201: invokevirtual 149	android/support/v7/widget/TintTypedArray:recycle	()V
    //   204: aload_0
    //   205: aload 11
    //   207: putfield 151	android/support/v7/widget/AppCompatSpinner:mPopup	Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;
    //   210: aload_0
    //   211: new 153	android/support/v7/widget/AppCompatSpinner$1
    //   214: dup
    //   215: aload_0
    //   216: aload_0
    //   217: aload 11
    //   219: invokespecial 156	android/support/v7/widget/AppCompatSpinner$1:<init>	(Landroid/support/v7/widget/AppCompatSpinner;Landroid/view/View;Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;)V
    //   222: putfield 158	android/support/v7/widget/AppCompatSpinner:mForwardingListener	Landroid/support/v7/widget/ForwardingListener;
    //   225: aload 6
    //   227: getstatic 161	android/support/v7/appcompat/R$styleable:Spinner_android_entries	I
    //   230: invokevirtual 165	android/support/v7/widget/TintTypedArray:getTextArray	(I)[Ljava/lang/CharSequence;
    //   233: astore 9
    //   235: aload 9
    //   237: ifnull +31 -> 268
    //   240: new 167	android/widget/ArrayAdapter
    //   243: dup
    //   244: aload_1
    //   245: ldc 168
    //   247: aload 9
    //   249: invokespecial 171	android/widget/ArrayAdapter:<init>	(Landroid/content/Context;I[Ljava/lang/Object;)V
    //   252: astore 10
    //   254: aload 10
    //   256: getstatic 176	android/support/v7/appcompat/R$layout:support_simple_spinner_dropdown_item	I
    //   259: invokevirtual 180	android/widget/ArrayAdapter:setDropDownViewResource	(I)V
    //   262: aload_0
    //   263: aload 10
    //   265: invokevirtual 184	android/support/v7/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   268: aload 6
    //   270: invokevirtual 149	android/support/v7/widget/TintTypedArray:recycle	()V
    //   273: aload_0
    //   274: iconst_1
    //   275: putfield 186	android/support/v7/widget/AppCompatSpinner:mPopupSet	Z
    //   278: aload_0
    //   279: getfield 188	android/support/v7/widget/AppCompatSpinner:mTempAdapter	Landroid/widget/SpinnerAdapter;
    //   282: ifnull +16 -> 298
    //   285: aload_0
    //   286: aload_0
    //   287: getfield 188	android/support/v7/widget/AppCompatSpinner:mTempAdapter	Landroid/widget/SpinnerAdapter;
    //   290: invokevirtual 184	android/support/v7/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   293: aload_0
    //   294: aconst_null
    //   295: putfield 188	android/support/v7/widget/AppCompatSpinner:mTempAdapter	Landroid/widget/SpinnerAdapter;
    //   298: aload_0
    //   299: getfield 88	android/support/v7/widget/AppCompatSpinner:mBackgroundTintHelper	Landroid/support/v7/widget/AppCompatBackgroundHelper;
    //   302: aload_2
    //   303: iload_3
    //   304: invokevirtual 192	android/support/v7/widget/AppCompatBackgroundHelper:loadFromAttributes	(Landroid/util/AttributeSet;I)V
    //   307: return
    //   308: aload 6
    //   310: getstatic 195	android/support/v7/appcompat/R$styleable:Spinner_popupTheme	I
    //   313: iconst_0
    //   314: invokevirtual 198	android/support/v7/widget/TintTypedArray:getResourceId	(II)I
    //   317: istore 7
    //   319: iload 7
    //   321: ifeq +20 -> 341
    //   324: aload_0
    //   325: new 90	android/support/v7/view/d
    //   328: dup
    //   329: aload_1
    //   330: iload 7
    //   332: invokespecial 200	android/support/v7/view/d:<init>	(Landroid/content/Context;I)V
    //   335: putfield 95	android/support/v7/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   338: goto -277 -> 61
    //   341: getstatic 205	android/os/Build$VERSION:SDK_INT	I
    //   344: bipush 23
    //   346: if_icmpge +15 -> 361
    //   349: aload_1
    //   350: astore 8
    //   352: aload_0
    //   353: aload 8
    //   355: putfield 95	android/support/v7/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   358: goto -297 -> 61
    //   361: aconst_null
    //   362: astore 8
    //   364: goto -12 -> 352
    //   367: astore 15
    //   369: aconst_null
    //   370: astore 14
    //   372: ldc 21
    //   374: ldc 207
    //   376: aload 15
    //   378: invokestatic 213	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   381: pop
    //   382: aload 14
    //   384: ifnull -262 -> 122
    //   387: aload 14
    //   389: invokevirtual 113	android/content/res/TypedArray:recycle	()V
    //   392: goto -270 -> 122
    //   395: astore 13
    //   397: aconst_null
    //   398: astore 14
    //   400: aload 14
    //   402: ifnull +8 -> 410
    //   405: aload 14
    //   407: invokevirtual 113	android/content/res/TypedArray:recycle	()V
    //   410: aload 13
    //   412: athrow
    //   413: astore 13
    //   415: goto -15 -> 400
    //   418: astore 15
    //   420: goto -48 -> 372
    //
    // Exception table:
    //   from	to	target	type
    //   74	86	367	java/lang/Exception
    //   74	86	395	finally
    //   90	108	413	finally
    //   372	382	413	finally
    //   90	108	418	java/lang/Exception
  }

  int compatMeasureContentWidth(SpinnerAdapter paramSpinnerAdapter, Drawable paramDrawable)
  {
    if (paramSpinnerAdapter == null)
      return 0;
    int i = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
    int j = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
    int k = Math.max(0, getSelectedItemPosition());
    int m = Math.min(paramSpinnerAdapter.getCount(), k + 15);
    int n = Math.max(0, k - (15 - (m - k)));
    View localView1 = null;
    int i1 = 0;
    int i2 = 0;
    int i3;
    if (n < m)
    {
      i3 = paramSpinnerAdapter.getItemViewType(n);
      if (i3 == i2)
        break label206;
    }
    for (View localView2 = null; ; localView2 = localView1)
    {
      localView1 = paramSpinnerAdapter.getView(n, localView2, this);
      if (localView1.getLayoutParams() == null)
        localView1.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      localView1.measure(i, j);
      i1 = Math.max(i1, localView1.getMeasuredWidth());
      n++;
      i2 = i3;
      break;
      if (paramDrawable != null)
      {
        paramDrawable.getPadding(this.mTempRect);
        return i1 + (this.mTempRect.left + this.mTempRect.right);
      }
      return i1;
      label206: i3 = i2;
    }
  }

  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.mBackgroundTintHelper != null)
      this.mBackgroundTintHelper.applySupportBackgroundTint();
  }

  public int getDropDownHorizontalOffset()
  {
    if (this.mPopup != null)
      return this.mPopup.getHorizontalOffset();
    if (Build.VERSION.SDK_INT >= 16)
      return super.getDropDownHorizontalOffset();
    return 0;
  }

  public int getDropDownVerticalOffset()
  {
    if (this.mPopup != null)
      return this.mPopup.getVerticalOffset();
    if (Build.VERSION.SDK_INT >= 16)
      return super.getDropDownVerticalOffset();
    return 0;
  }

  public int getDropDownWidth()
  {
    if (this.mPopup != null)
      return this.mDropDownWidth;
    if (Build.VERSION.SDK_INT >= 16)
      return super.getDropDownWidth();
    return 0;
  }

  public Drawable getPopupBackground()
  {
    if (this.mPopup != null)
      return this.mPopup.getBackground();
    if (Build.VERSION.SDK_INT >= 16)
      return super.getPopupBackground();
    return null;
  }

  public Context getPopupContext()
  {
    if (this.mPopup != null)
      return this.mPopupContext;
    if (Build.VERSION.SDK_INT >= 23)
      return super.getPopupContext();
    return null;
  }

  public CharSequence getPrompt()
  {
    if (this.mPopup != null)
      return this.mPopup.getHintText();
    return super.getPrompt();
  }

  public ColorStateList getSupportBackgroundTintList()
  {
    if (this.mBackgroundTintHelper != null)
      return this.mBackgroundTintHelper.getSupportBackgroundTintList();
    return null;
  }

  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (this.mBackgroundTintHelper != null)
      return this.mBackgroundTintHelper.getSupportBackgroundTintMode();
    return null;
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.mPopup != null) && (this.mPopup.isShowing()))
      this.mPopup.dismiss();
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.mPopup != null) && (View.MeasureSpec.getMode(paramInt1) == -2147483648))
      setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), compatMeasureContentWidth(getAdapter(), getBackground())), View.MeasureSpec.getSize(paramInt1)), getMeasuredHeight());
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.mForwardingListener != null) && (this.mForwardingListener.onTouch(this, paramMotionEvent)))
      return true;
    return super.onTouchEvent(paramMotionEvent);
  }

  public boolean performClick()
  {
    if (this.mPopup != null)
    {
      if (!this.mPopup.isShowing())
        this.mPopup.show();
      return true;
    }
    return super.performClick();
  }

  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    if (!this.mPopupSet)
      this.mTempAdapter = paramSpinnerAdapter;
    do
    {
      return;
      super.setAdapter(paramSpinnerAdapter);
    }
    while (this.mPopup == null);
    if (this.mPopupContext == null);
    for (Context localContext = getContext(); ; localContext = this.mPopupContext)
    {
      this.mPopup.setAdapter(new DropDownAdapter(paramSpinnerAdapter, localContext.getTheme()));
      return;
    }
  }

  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (this.mBackgroundTintHelper != null)
      this.mBackgroundTintHelper.onSetBackgroundDrawable(paramDrawable);
  }

  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (this.mBackgroundTintHelper != null)
      this.mBackgroundTintHelper.onSetBackgroundResource(paramInt);
  }

  public void setDropDownHorizontalOffset(int paramInt)
  {
    if (this.mPopup != null)
      this.mPopup.setHorizontalOffset(paramInt);
    while (Build.VERSION.SDK_INT < 16)
      return;
    super.setDropDownHorizontalOffset(paramInt);
  }

  public void setDropDownVerticalOffset(int paramInt)
  {
    if (this.mPopup != null)
      this.mPopup.setVerticalOffset(paramInt);
    while (Build.VERSION.SDK_INT < 16)
      return;
    super.setDropDownVerticalOffset(paramInt);
  }

  public void setDropDownWidth(int paramInt)
  {
    if (this.mPopup != null)
      this.mDropDownWidth = paramInt;
    while (Build.VERSION.SDK_INT < 16)
      return;
    super.setDropDownWidth(paramInt);
  }

  public void setPopupBackgroundDrawable(Drawable paramDrawable)
  {
    if (this.mPopup != null)
      this.mPopup.setBackgroundDrawable(paramDrawable);
    while (Build.VERSION.SDK_INT < 16)
      return;
    super.setPopupBackgroundDrawable(paramDrawable);
  }

  public void setPopupBackgroundResource(int paramInt)
  {
    setPopupBackgroundDrawable(a.b(getPopupContext(), paramInt));
  }

  public void setPrompt(CharSequence paramCharSequence)
  {
    if (this.mPopup != null)
    {
      this.mPopup.setPromptText(paramCharSequence);
      return;
    }
    super.setPrompt(paramCharSequence);
  }

  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.mBackgroundTintHelper != null)
      this.mBackgroundTintHelper.setSupportBackgroundTintList(paramColorStateList);
  }

  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.mBackgroundTintHelper != null)
      this.mBackgroundTintHelper.setSupportBackgroundTintMode(paramMode);
  }

  private static class DropDownAdapter
    implements ListAdapter, SpinnerAdapter
  {
    private SpinnerAdapter mAdapter;
    private ListAdapter mListAdapter;

    public DropDownAdapter(SpinnerAdapter paramSpinnerAdapter, Resources.Theme paramTheme)
    {
      this.mAdapter = paramSpinnerAdapter;
      if ((paramSpinnerAdapter instanceof SpinnerAdapter))
        this.mListAdapter = ((SpinnerAdapter)paramSpinnerAdapter);
      if (paramTheme != null)
      {
        if ((Build.VERSION.SDK_INT < 23) || (!(paramSpinnerAdapter instanceof android.widget.ThemedSpinnerAdapter)))
          break label69;
        android.widget.ThemedSpinnerAdapter localThemedSpinnerAdapter1 = (android.widget.ThemedSpinnerAdapter)paramSpinnerAdapter;
        if (localThemedSpinnerAdapter1.getDropDownViewTheme() != paramTheme)
          localThemedSpinnerAdapter1.setDropDownViewTheme(paramTheme);
      }
      label69: ThemedSpinnerAdapter localThemedSpinnerAdapter;
      do
      {
        do
          return;
        while (!(paramSpinnerAdapter instanceof ThemedSpinnerAdapter));
        localThemedSpinnerAdapter = (ThemedSpinnerAdapter)paramSpinnerAdapter;
      }
      while (localThemedSpinnerAdapter.getDropDownViewTheme() != null);
      localThemedSpinnerAdapter.setDropDownViewTheme(paramTheme);
    }

    public boolean areAllItemsEnabled()
    {
      ListAdapter localListAdapter = this.mListAdapter;
      if (localListAdapter != null)
        return localListAdapter.areAllItemsEnabled();
      return true;
    }

    public int getCount()
    {
      if (this.mAdapter == null)
        return 0;
      return this.mAdapter.getCount();
    }

    public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (this.mAdapter == null)
        return null;
      return this.mAdapter.getDropDownView(paramInt, paramView, paramViewGroup);
    }

    public Object getItem(int paramInt)
    {
      if (this.mAdapter == null)
        return null;
      return this.mAdapter.getItem(paramInt);
    }

    public long getItemId(int paramInt)
    {
      if (this.mAdapter == null)
        return -1L;
      return this.mAdapter.getItemId(paramInt);
    }

    public int getItemViewType(int paramInt)
    {
      return 0;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      return getDropDownView(paramInt, paramView, paramViewGroup);
    }

    public int getViewTypeCount()
    {
      return 1;
    }

    public boolean hasStableIds()
    {
      return (this.mAdapter != null) && (this.mAdapter.hasStableIds());
    }

    public boolean isEmpty()
    {
      return getCount() == 0;
    }

    public boolean isEnabled(int paramInt)
    {
      ListAdapter localListAdapter = this.mListAdapter;
      if (localListAdapter != null)
        return localListAdapter.isEnabled(paramInt);
      return true;
    }

    public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      if (this.mAdapter != null)
        this.mAdapter.registerDataSetObserver(paramDataSetObserver);
    }

    public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      if (this.mAdapter != null)
        this.mAdapter.unregisterDataSetObserver(paramDataSetObserver);
    }
  }

  private class DropdownPopup extends ListPopupWindow
  {
    ListAdapter mAdapter;
    private CharSequence mHintText;
    private final Rect mVisibleRect = new Rect();

    public DropdownPopup(Context paramAttributeSet, AttributeSet paramInt, int arg4)
    {
      super(paramInt, i);
      setAnchorView(AppCompatSpinner.this);
      setModal(true);
      setPromptPosition(0);
      setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppCompatSpinner.this.setSelection(paramAnonymousInt);
          if (AppCompatSpinner.this.getOnItemClickListener() != null)
            AppCompatSpinner.this.performItemClick(paramAnonymousView, paramAnonymousInt, AppCompatSpinner.DropdownPopup.this.mAdapter.getItemId(paramAnonymousInt));
          AppCompatSpinner.DropdownPopup.this.dismiss();
        }
      });
    }

    void computeContentWidth()
    {
      Drawable localDrawable = getBackground();
      int i3;
      int i;
      label46: int j;
      int k;
      int m;
      int i1;
      int i2;
      if (localDrawable != null)
      {
        localDrawable.getPadding(AppCompatSpinner.this.mTempRect);
        if (ViewUtils.isLayoutRtl(AppCompatSpinner.this))
        {
          i3 = AppCompatSpinner.this.mTempRect.right;
          i = i3;
          j = AppCompatSpinner.this.getPaddingLeft();
          k = AppCompatSpinner.this.getPaddingRight();
          m = AppCompatSpinner.this.getWidth();
          if (AppCompatSpinner.this.mDropDownWidth != -2)
            break label245;
          i1 = AppCompatSpinner.this.compatMeasureContentWidth((SpinnerAdapter)this.mAdapter, getBackground());
          i2 = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels - AppCompatSpinner.this.mTempRect.left - AppCompatSpinner.this.mTempRect.right;
          if (i1 <= i2)
            break label294;
        }
      }
      while (true)
      {
        setContentWidth(Math.max(i2, m - j - k));
        label169: if (ViewUtils.isLayoutRtl(AppCompatSpinner.this));
        for (int n = i + (m - k - getWidth()); ; n = i + j)
        {
          setHorizontalOffset(n);
          return;
          i3 = -AppCompatSpinner.this.mTempRect.left;
          break;
          Rect localRect = AppCompatSpinner.this.mTempRect;
          AppCompatSpinner.this.mTempRect.right = 0;
          localRect.left = 0;
          i = 0;
          break label46;
          label245: if (AppCompatSpinner.this.mDropDownWidth == -1)
          {
            setContentWidth(m - j - k);
            break label169;
          }
          setContentWidth(AppCompatSpinner.this.mDropDownWidth);
          break label169;
        }
        label294: i2 = i1;
      }
    }

    public CharSequence getHintText()
    {
      return this.mHintText;
    }

    boolean isVisibleToUser(View paramView)
    {
      return (ViewCompat.isAttachedToWindow(paramView)) && (paramView.getGlobalVisibleRect(this.mVisibleRect));
    }

    public void setAdapter(ListAdapter paramListAdapter)
    {
      super.setAdapter(paramListAdapter);
      this.mAdapter = paramListAdapter;
    }

    public void setPromptText(CharSequence paramCharSequence)
    {
      this.mHintText = paramCharSequence;
    }

    public void show()
    {
      boolean bool = isShowing();
      computeContentWidth();
      setInputMethodMode(2);
      super.show();
      getListView().setChoiceMode(1);
      setSelection(AppCompatSpinner.this.getSelectedItemPosition());
      if (bool);
      ViewTreeObserver localViewTreeObserver;
      do
      {
        return;
        localViewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
      }
      while (localViewTreeObserver == null);
      final ViewTreeObserver.OnGlobalLayoutListener local2 = new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public void onGlobalLayout()
        {
          if (!AppCompatSpinner.DropdownPopup.this.isVisibleToUser(AppCompatSpinner.this))
          {
            AppCompatSpinner.DropdownPopup.this.dismiss();
            return;
          }
          AppCompatSpinner.DropdownPopup.this.computeContentWidth();
          AppCompatSpinner.DropdownPopup.this.show();
        }
      };
      localViewTreeObserver.addOnGlobalLayoutListener(local2);
      setOnDismissListener(new PopupWindow.OnDismissListener()
      {
        public void onDismiss()
        {
          ViewTreeObserver localViewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
          if (localViewTreeObserver != null)
            localViewTreeObserver.removeGlobalOnLayoutListener(local2);
        }
      });
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.AppCompatSpinner
 * JD-Core Version:    0.6.2
 */