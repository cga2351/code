package com.viber.voip.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView.OnEditorActionListener;
import com.viber.common.d.a;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.styleable;
import com.viber.voip.util.dj;

public class TextViewWithDescription extends ViewWithDescription
  implements View.OnFocusChangeListener, View.OnTouchListener
{
  private ae e;
  private ProgressBar f;
  private boolean g;
  private ImageView h;
  private RelativeLayout.LayoutParams i;
  private RelativeLayout.LayoutParams j;
  private View.OnClickListener k;
  private a l;
  private View.OnFocusChangeListener m;
  private String n;
  private Drawable o;
  private Drawable p;
  private Drawable q;
  private int r;
  private int s;
  private int t;
  private boolean u;
  private String v;
  private View.OnClickListener w = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      TextViewWithDescription.this.performClick();
    }
  };

  public TextViewWithDescription(Context paramContext)
  {
    super(paramContext);
  }

  public TextViewWithDescription(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public TextViewWithDescription(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void a(ViewWithDescription.a parama)
  {
    int i1;
    int i2;
    switch (3.a[parama.ordinal()])
    {
    default:
      if (b())
      {
        i1 = this.c[2];
        if (!b())
          break label153;
        i2 = this.c[0];
      }
      break;
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      if (!a.a())
        break label163;
      this.e.setPaddingRelative(i1, this.c[1], i2, this.c[3]);
      return;
      if (b());
      for (i1 = this.s; ; i1 = this.c[0])
      {
        if (!b())
          break label135;
        i2 = this.c[0];
        break;
      }
      label135: i2 = this.s;
      continue;
      i1 = this.c[0];
      break;
      label153: i2 = this.c[2];
    }
    label163: this.e.setPadding(i1, this.c[1], i2, this.c[3]);
  }

  private void setRightDrawable(Drawable paramDrawable)
  {
    this.f.setVisibility(8);
    if (this.h == null)
    {
      this.h = new ImageView(getContext());
      this.h.setLayoutParams(this.j);
      this.h.setBackgroundResource(R.drawable.text_with_description_right_button_selector);
      addView(this.h);
      if (this.k != null)
        this.h.setOnClickListener(this.k);
    }
    this.h.setImageDrawable(paramDrawable);
    this.u = false;
  }

  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    int i1 = 9;
    super.a(paramContext, paramAttributeSet);
    Resources localResources = paramContext.getResources();
    int i2 = (int)localResources.getDimension(R.dimen.text_view_with_description_right_drawable_right_margin);
    this.i = new RelativeLayout.LayoutParams(-2, -2);
    RelativeLayout.LayoutParams localLayoutParams1 = this.i;
    int i3;
    label123: int i4;
    label154: label204: RelativeLayout.LayoutParams localLayoutParams3;
    if (b())
    {
      i3 = 11;
      localLayoutParams1.addRule(i3 | 0xF);
      this.i.addRule(8, this.e.getId());
      this.i.bottomMargin = ((int)localResources.getDimension(R.dimen.text_view_with_description_left_drawable_bottom_margin));
      if (!b())
        break label344;
      this.i.rightMargin = ((int)localResources.getDimension(R.dimen.text_view_with_description_left_drawable_left_margin));
      this.j = new RelativeLayout.LayoutParams(-2, -2);
      RelativeLayout.LayoutParams localLayoutParams2 = this.j;
      if (!b())
        break label363;
      i4 = i1;
      localLayoutParams2.addRule(i4);
      this.j.addRule(8, this.e.getId());
      this.j.bottomMargin = this.t;
      if (!b())
        break label370;
      this.j.leftMargin = i2;
      int i5 = (int)localResources.getDimension(R.dimen.text_view_with_description_progress_indicator_size);
      localLayoutParams3 = new RelativeLayout.LayoutParams(i5, i5);
      if (!b())
        break label382;
      label235: localLayoutParams3.addRule(i1);
      localLayoutParams3.addRule(8, this.e.getId());
      if (!b())
        break label388;
      localLayoutParams3.leftMargin = i2;
    }
    while (true)
    {
      localLayoutParams3.bottomMargin = this.t;
      this.f = new ProgressBar(paramContext);
      this.f.setLayoutParams(localLayoutParams3);
      this.f.setIndeterminate(true);
      this.f.setVisibility(8);
      this.s = ((int)localResources.getDimension(R.dimen.text_view_with_description_right_padding_from_drawable));
      addView(this.f);
      return;
      i3 = i1;
      break;
      label344: this.i.leftMargin = ((int)localResources.getDimension(R.dimen.text_view_with_description_left_drawable_left_margin));
      break label123;
      label363: i4 = 11;
      break label154;
      label370: this.j.rightMargin = i2;
      break label204;
      label382: i1 = 11;
      break label235;
      label388: localLayoutParams3.rightMargin = i2;
    }
  }

  public void a(TextWatcher paramTextWatcher)
  {
    this.e.addTextChangedListener(paramTextWatcher);
  }

  public void a(ViewWithDescription.a parama, CharSequence paramCharSequence)
  {
    setRightDrawable(null);
    this.h.setClickable(false);
    super.a(parama, paramCharSequence);
    switch (3.a[parama.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      a(parama);
      return;
      setRightDrawable(this.q);
      continue;
      setRightDrawable(getResources().getDrawable(R.drawable.text_view_with_description_status_error));
      continue;
      setRightDrawable(getResources().getDrawable(R.drawable.text_view_with_description_statusl_retry));
      this.h.setClickable(true);
      continue;
      this.f.setVisibility(0);
    }
  }

  public void a(InputFilter[] paramArrayOfInputFilter)
  {
    InputFilter[] arrayOfInputFilter1 = this.e.getFilters();
    InputFilter[] arrayOfInputFilter2 = new InputFilter[arrayOfInputFilter1.length + paramArrayOfInputFilter.length];
    System.arraycopy(arrayOfInputFilter1, 0, arrayOfInputFilter2, 0, arrayOfInputFilter1.length);
    System.arraycopy(paramArrayOfInputFilter, 0, arrayOfInputFilter2, arrayOfInputFilter1.length, paramArrayOfInputFilter.length);
    this.e.setFilters(arrayOfInputFilter2);
  }

  public boolean ah_()
  {
    return this.g;
  }

  @SuppressLint({"ClickableViewAccessibility"})
  protected View b(Context paramContext, AttributeSet paramAttributeSet)
  {
    Resources localResources = paramContext.getResources();
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TextViewWithDescription);
    while (true)
    {
      boolean bool2;
      try
      {
        this.v = localTypedArray.getString(R.styleable.TextViewWithDescription_android_hint);
        boolean bool1 = localTypedArray.getBoolean(R.styleable.TextViewWithDescription_editable, true);
        int i1 = localTypedArray.getInt(R.styleable.TextViewWithDescription_android_maxLength, 0);
        int i2 = localTypedArray.getInt(R.styleable.TextViewWithDescription_android_inputType, 0);
        int i3 = localTypedArray.getInt(R.styleable.TextViewWithDescription_android_imeOptions, 0);
        bool2 = localTypedArray.getBoolean(R.styleable.TextViewWithDescription_android_singleLine, false);
        int i4 = localTypedArray.getInt(R.styleable.TextViewWithDescription_android_maxLines, -1);
        this.o = localTypedArray.getDrawable(R.styleable.TextViewWithDescription_backgroundRes);
        if (this.o == null)
          this.o = localResources.getDrawable(R.drawable.edit_text_with_description_purple_1px);
        this.p = localTypedArray.getDrawable(R.styleable.TextViewWithDescription_backgroundResDisabled);
        if (this.p == null)
          this.p = localResources.getDrawable(R.drawable.edit_text_underline_1px);
        this.q = localTypedArray.getDrawable(R.styleable.TextViewWithDescription_okStatusDrawable);
        if (this.q == null)
          this.q = localResources.getDrawable(R.drawable.text_view_with_description_status_ok);
        this.r = ((int)localTypedArray.getDimension(R.styleable.TextViewWithDescription_android_textSize, paramContext.getResources().getDimension(R.dimen.text_view_with_description_default_text_size)));
        this.t = ((int)localTypedArray.getDimension(R.styleable.TextViewWithDescription_rightDrawableBottomMargin, paramContext.getResources().getDimension(R.dimen.text_view_with_description_right_drawable_bottom_margin)));
        ColorStateList localColorStateList1 = localTypedArray.getColorStateList(R.styleable.TextViewWithDescription_mainTextColor);
        ColorStateList localColorStateList2 = localTypedArray.getColorStateList(R.styleable.TextViewWithDescription_android_textColorHint);
        localTypedArray.recycle();
        this.e = new ae(paramContext);
        if (localColorStateList2 != null)
        {
          this.e.setHintTextColor(localColorStateList2);
          if (i1 > 0)
          {
            InputFilter[] arrayOfInputFilter = new InputFilter[1];
            arrayOfInputFilter[0] = new InputFilter.LengthFilter(i1);
            a(arrayOfInputFilter);
          }
          if ((i2 != 0) && (!isInEditMode()))
            this.e.setInputType(i2 | 0x1);
          setEditable(bool1);
          this.e.setHint(this.v);
          if (i4 <= -1)
            break label525;
          this.e.setMaxLines(i4);
          this.e.setTextSize(0, this.r);
          this.e.setIncludeFontPadding(false);
          if (localColorStateList1 != null)
            this.e.setTextColor(localColorStateList1);
          ae localae = this.e;
          if (!b())
            break label537;
          i5 = 5;
          localae.setGravity(i5);
          a(getState());
          if (i3 != 0)
            this.e.setImeOptions(i3);
          this.e.setOnTouchListener(this);
          this.e.setOnFocusChangeListener(this);
          this.e.setTypeface(Typeface.create("sans-serif", 0));
          this.e.addTextChangedListener(new TextWatcher()
          {
            public void afterTextChanged(Editable paramAnonymousEditable)
            {
              ae localae = TextViewWithDescription.b(TextViewWithDescription.this);
              if (paramAnonymousEditable.length() > 0);
              for (String str = ""; ; str = TextViewWithDescription.a(TextViewWithDescription.this))
              {
                localae.setHint(str);
                return;
              }
            }

            public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
            {
            }

            public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
            {
            }
          });
          return this.e;
        }
      }
      finally
      {
        localTypedArray.recycle();
      }
      this.e.setHintTextColor(getResources().getColorStateList(R.color.view_with_description_hint_color_states));
      continue;
      label525: this.e.setSingleLine(bool2);
      continue;
      label537: int i5 = 3;
    }
  }

  public void b(TextWatcher paramTextWatcher)
  {
    this.e.removeTextChangedListener(paramTextWatcher);
  }

  public ae getEditText()
  {
    return this.e;
  }

  public int getImeOptions()
  {
    return this.e.getImeOptions();
  }

  public Editable getText()
  {
    return this.e.getText();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.k = null;
  }

  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramView.getId() == getBodyViewId())
    {
      if (!paramBoolean)
        break label48;
      this.n = this.e.getText().toString();
    }
    while (true)
    {
      if (this.m != null)
        this.m.onFocusChange(paramView, paramBoolean);
      return;
      label48: if ((this.l != null) && (!this.e.getText().toString().equals(this.n)))
        this.l.a();
    }
  }

  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return onTouchEvent(paramMotionEvent);
  }

  public void setEditable(boolean paramBoolean)
  {
    this.g = paramBoolean;
    this.e.setFocusableInTouchMode(paramBoolean);
    this.e.setFocusable(paramBoolean);
    ae localae = this.e;
    if (paramBoolean);
    for (Drawable localDrawable = this.o; ; localDrawable = this.p)
    {
      dj.a(localae, localDrawable);
      this.e.setLongClickable(paramBoolean);
      return;
    }
  }

  public void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    this.e.setFilters(paramArrayOfInputFilter);
  }

  public void setImeOptions(int paramInt)
  {
    this.e.setImeOptions(paramInt);
  }

  public void setMaxLines(int paramInt)
  {
    this.e.setMaxLines(paramInt);
  }

  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.e.isFocusableInTouchMode())
      this.e.setFocusableInTouchMode(false);
    this.e.setOnClickListener(this.w);
    super.setOnClickListener(paramOnClickListener);
  }

  public void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    this.e.setOnEditorActionListener(paramOnEditorActionListener);
  }

  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.m = paramOnFocusChangeListener;
  }

  public void setOnTextChangedListener(a parama)
  {
    this.l = parama;
  }

  public void setSelection(int paramInt)
  {
    this.e.setSelection(paramInt);
  }

  public void setSingleLine(boolean paramBoolean)
  {
    this.e.setSingleLine(paramBoolean);
  }

  public void setText(String paramString)
  {
    this.e.setText(paramString);
    this.n = paramString;
    if (this.l != null)
      this.l.a();
  }

  public void setTryAgainListener(View.OnClickListener paramOnClickListener)
  {
    if (this.h != null)
    {
      this.h.setOnClickListener(paramOnClickListener);
      return;
    }
    this.k = paramOnClickListener;
  }

  public static abstract interface a
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.TextViewWithDescription
 * JD-Core Version:    0.6.2
 */