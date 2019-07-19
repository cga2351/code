package com.viber.voip.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.viber.common.d.c;
import com.viber.voip.R.attr;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.styleable;
import com.viber.voip.ui.ViberTextView;
import com.viber.voip.util.dc;

public abstract class ViewWithDescription extends RelativeLayout
{
  protected ColorStateList a;
  protected boolean b;
  protected int[] c = new int[4];
  protected boolean d;
  private int e;
  private View f;
  private TextView g;
  private TextView h;
  private TextView i;
  private RelativeLayout.LayoutParams j;
  private RelativeLayout.LayoutParams k;
  private String l;
  private float m;
  private int n;
  private int o;
  private ColorStateList p;
  private ColorStateList q;
  private a r;

  public ViewWithDescription(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public ViewWithDescription(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public ViewWithDescription(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  protected TextView a()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(3, this.e);
    if (b());
    for (int i1 = 7; ; i1 = 5)
    {
      localLayoutParams.addRule(i1, this.e);
      ViberTextView localViberTextView = new ViberTextView(getContext());
      localViberTextView.setLayoutParams(localLayoutParams);
      localViberTextView.setTextSize(1, 12.0F);
      localViberTextView.setVisibility(4);
      localViberTextView.setIncludeFontPadding(false);
      localViberTextView.setMovementMethod(LinkMovementMethod.getInstance());
      return localViberTextView;
    }
  }

  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ViewWithDescription);
    while (true)
    {
      try
      {
        this.l = localTypedArray.getString(R.styleable.ViewWithDescription_android_description);
        this.e = localTypedArray.getResourceId(R.styleable.ViewWithDescription_mainBodyId, R.id.view_with_description_main_view_id);
        this.m = localTypedArray.getDimension(R.styleable.ViewWithDescription_descriptionPadding, 0.0F);
        this.c[0] = ((int)localTypedArray.getDimension(R.styleable.ViewWithDescription_leftBodyMargin, 0.0F));
        this.c[1] = ((int)localTypedArray.getDimension(R.styleable.ViewWithDescription_topBodyMargin, getResources().getDimension(R.dimen.text_view_with_description_default_top_margin)));
        this.c[2] = ((int)localTypedArray.getDimension(R.styleable.ViewWithDescription_rightBodyMargin, 0.0F));
        this.c[3] = ((int)localTypedArray.getDimension(R.styleable.ViewWithDescription_bottomBodyMargin, getResources().getDimension(R.dimen.text_view_with_description_default_bottom_margin)));
        this.n = ((int)localTypedArray.getDimension(R.styleable.ViewWithDescription_leftDescriptionPadding, 0.0F));
        this.o = localTypedArray.getDimensionPixelSize(R.styleable.ViewWithDescription_minHeight, getResources().getDimensionPixelSize(R.dimen.default_tag_field_height));
        this.b = localTypedArray.getBoolean(R.styleable.ViewWithDescription_android_enabled, true);
        this.d = localTypedArray.getBoolean(R.styleable.ViewWithDescription_supportRtl, false);
        localTypedArray.recycle();
        this.a = dc.e(paramContext, R.attr.viewWithDescriptionStatusColor);
        this.p = dc.e(paramContext, R.attr.viewWithDescriptionTextColor);
        this.q = dc.e(paramContext, R.attr.viewWithDescriptionWarningColor);
        setDescendantFocusability(131072);
        setMinimumHeight(this.o);
        this.g = c(paramContext, paramAttributeSet);
        a(this.g, getActionViewVerticalGravity());
        this.j = new RelativeLayout.LayoutParams(-1, -2);
        this.j.addRule(3, R.id.description_text);
        if (this.g != null)
        {
          RelativeLayout.LayoutParams localLayoutParams2 = this.j;
          if (b())
          {
            i4 = 1;
            localLayoutParams2.addRule(i4, this.g.getId());
          }
        }
        else
        {
          this.f = b(paramContext, paramAttributeSet);
          this.f.setLayoutParams(this.j);
          if (this.e != 0)
            this.f.setId(this.e);
          this.h = a();
          this.k = new RelativeLayout.LayoutParams(-2, -2);
          RelativeLayout.LayoutParams localLayoutParams1 = this.k;
          if (!b())
            break label593;
          i1 = 11;
          localLayoutParams1.addRule(i1);
          this.i = new ViberTextView(getContext());
          this.i.setLayoutParams(this.k);
          this.i.setTextSize(1, 12.0F);
          this.i.setTextColor(this.p);
          if (!b())
            break label600;
          i2 = 0;
          if (!b())
            break label609;
          i3 = this.n;
          this.i.setPadding(i2, 0, i3, (int)this.m);
          this.i.setId(R.id.description_text);
          this.i.setIncludeFontPadding(false);
          setDescription(this.l);
          if (this.g != null)
            addView(this.g);
          addView(this.f);
          if (this.h != null)
            addView(this.h);
          addView(this.i);
          setEnabled(this.b);
          this.r = a.a;
          return;
        }
      }
      finally
      {
        localTypedArray.recycle();
      }
      int i4 = 0;
      continue;
      label593: int i1 = 9;
      continue;
      label600: int i2 = this.n;
      continue;
      label609: int i3 = 0;
    }
  }

  protected void a(TextView paramTextView, int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramTextView != null)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(paramInt);
      if (!b())
        break label49;
    }
    label49: for (int i1 = 9; ; i1 = 11)
    {
      localLayoutParams.addRule(i1);
      paramTextView.setLayoutParams(localLayoutParams);
      paramTextView.setIncludeFontPadding(false);
      return;
    }
  }

  public void a(ValidationState paramValidationState)
  {
    a(a.a(paramValidationState.mStateCode), paramValidationState.mStateMessage);
  }

  public void a(a parama, int paramInt)
  {
    a(parama, getResources().getString(paramInt));
  }

  public void a(a parama, CharSequence paramCharSequence)
  {
    setStatusMessage(paramCharSequence);
    setTextColorByState(parama);
    this.r = parama;
  }

  protected abstract View b(Context paramContext, AttributeSet paramAttributeSet);

  protected boolean b()
  {
    return (c.a()) && (this.d);
  }

  protected TextView c(Context paramContext, AttributeSet paramAttributeSet)
  {
    return null;
  }

  protected int getActionViewVerticalGravity()
  {
    return 15;
  }

  public int getBodyViewId()
  {
    return this.e;
  }

  public TextView getDescriptionView()
  {
    return this.i;
  }

  public a getState()
  {
    if (this.r != null)
      return this.r;
    return a.a;
  }

  public CharSequence getStatusMessage()
  {
    return this.h.getText();
  }

  public ValidationState getValidationState()
  {
    return new ValidationState(getState().ordinal(), getStatusMessage());
  }

  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    a(a.a(localSavedState.stateCode), localSavedState.stateMessage);
  }

  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.stateMessage = getStatusMessage();
    localSavedState.stateCode = getState().ordinal();
    return localSavedState;
  }

  public void setDescription(String paramString)
  {
    this.l = paramString;
    this.i.setText(paramString);
  }

  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    for (int i1 = 0; i1 < getChildCount(); i1++)
      getChildAt(i1).setEnabled(paramBoolean);
  }

  public void setStatus(a parama)
  {
    a(parama, "");
  }

  protected void setStatusMessage(CharSequence paramCharSequence)
  {
    if (this.h != null)
    {
      if (TextUtils.isEmpty(paramCharSequence))
        break label31;
      this.h.setVisibility(0);
    }
    while (true)
    {
      this.h.setText(paramCharSequence);
      return;
      label31: this.h.setVisibility(4);
    }
  }

  protected void setStatusMessageColor(ColorStateList paramColorStateList)
  {
    if (this.h != null)
      this.h.setTextColor(paramColorStateList);
  }

  protected void setTextColorByState(a parama)
  {
    switch (1.a[parama.ordinal()])
    {
    default:
      setStatusMessageColor(this.a);
      this.i.setTextColor(this.p);
      return;
    case 1:
    }
    setStatusMessageColor(this.q);
    this.i.setTextColor(this.q);
  }

  static class SavedState extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public ViewWithDescription.SavedState a(Parcel paramAnonymousParcel)
      {
        return new ViewWithDescription.SavedState(paramAnonymousParcel);
      }

      public ViewWithDescription.SavedState[] a(int paramAnonymousInt)
      {
        return new ViewWithDescription.SavedState[paramAnonymousInt];
      }
    };
    int stateCode;
    CharSequence stateMessage;

    public SavedState(Parcel paramParcel)
    {
      super();
      this.stateCode = paramParcel.readInt();
      this.stateMessage = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    }

    public SavedState(Parcelable paramParcelable)
    {
      super();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.stateCode);
      TextUtils.writeToParcel(this.stateMessage, paramParcel, paramInt);
    }
  }

  public static class ValidationState
    implements Parcelable
  {
    public static final Parcelable.Creator<ValidationState> CREATOR = new Parcelable.Creator()
    {
      public ViewWithDescription.ValidationState a(Parcel paramAnonymousParcel)
      {
        return new ViewWithDescription.ValidationState(paramAnonymousParcel);
      }

      public ViewWithDescription.ValidationState[] a(int paramAnonymousInt)
      {
        return new ViewWithDescription.ValidationState[paramAnonymousInt];
      }
    };
    protected int mStateCode;
    protected CharSequence mStateMessage;

    public ValidationState()
    {
    }

    public ValidationState(int paramInt, CharSequence paramCharSequence)
    {
      this.mStateCode = paramInt;
      this.mStateMessage = paramCharSequence;
    }

    protected ValidationState(Parcel paramParcel)
    {
      this.mStateCode = paramParcel.readInt();
      this.mStateMessage = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.mStateCode);
      TextUtils.writeToParcel(this.mStateMessage, paramParcel, paramInt);
    }
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[5];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
    }

    public static a a(int paramInt)
    {
      if ((paramInt < 0) || (paramInt > values().length))
        return a;
      return values()[paramInt];
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.ViewWithDescription
 * JD-Core Version:    0.6.2
 */