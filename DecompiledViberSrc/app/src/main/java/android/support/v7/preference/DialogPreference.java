package android.support.v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.TypedArrayUtils;
import android.util.AttributeSet;

public abstract class DialogPreference extends Preference
{
  private CharSequence a;
  private CharSequence b;
  private Drawable c;
  private CharSequence d;
  private CharSequence e;
  private int f;

  public DialogPreference(Context paramContext)
  {
    this(paramContext, null);
  }

  public DialogPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, TypedArrayUtils.getAttr(paramContext, R.attr.dialogPreferenceStyle, 16842897));
  }

  public DialogPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }

  public DialogPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.DialogPreference, paramInt1, paramInt2);
    this.a = TypedArrayUtils.getString(localTypedArray, R.styleable.DialogPreference_dialogTitle, R.styleable.DialogPreference_android_dialogTitle);
    if (this.a == null)
      this.a = y();
    this.b = TypedArrayUtils.getString(localTypedArray, R.styleable.DialogPreference_dialogMessage, R.styleable.DialogPreference_android_dialogMessage);
    this.c = TypedArrayUtils.getDrawable(localTypedArray, R.styleable.DialogPreference_dialogIcon, R.styleable.DialogPreference_android_dialogIcon);
    this.d = TypedArrayUtils.getString(localTypedArray, R.styleable.DialogPreference_positiveButtonText, R.styleable.DialogPreference_android_positiveButtonText);
    this.e = TypedArrayUtils.getString(localTypedArray, R.styleable.DialogPreference_negativeButtonText, R.styleable.DialogPreference_android_negativeButtonText);
    this.f = TypedArrayUtils.getResourceId(localTypedArray, R.styleable.DialogPreference_dialogLayout, R.styleable.DialogPreference_android_dialogLayout, 0);
    localTypedArray.recycle();
  }

  public void a(int paramInt)
  {
    a(I().getString(paramInt));
  }

  public void a(CharSequence paramCharSequence)
  {
    this.a = paramCharSequence;
  }

  public CharSequence e()
  {
    return this.a;
  }

  public CharSequence f()
  {
    return this.b;
  }

  public Drawable g()
  {
    return this.c;
  }

  public CharSequence h()
  {
    return this.d;
  }

  public CharSequence i()
  {
    return this.e;
  }

  public int j()
  {
    return this.f;
  }

  protected void k()
  {
    L().a(this);
  }

  public static abstract interface a
  {
    public abstract Preference a(CharSequence paramCharSequence);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.preference.DialogPreference
 * JD-Core Version:    0.6.2
 */