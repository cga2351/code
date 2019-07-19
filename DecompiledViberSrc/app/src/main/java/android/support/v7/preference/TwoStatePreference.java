package android.support.v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public abstract class TwoStatePreference extends Preference
{
  protected boolean a;
  private CharSequence b;
  private CharSequence c;
  private boolean d;
  private boolean e;

  public TwoStatePreference(Context paramContext)
  {
    this(paramContext, null);
  }

  public TwoStatePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public TwoStatePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }

  public TwoStatePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }

  protected Object a(TypedArray paramTypedArray, int paramInt)
  {
    return Boolean.valueOf(paramTypedArray.getBoolean(paramInt, false));
  }

  protected void a(Parcelable paramParcelable)
  {
    if ((paramParcelable == null) || (!paramParcelable.getClass().equals(SavedState.class)))
    {
      super.a(paramParcelable);
      return;
    }
    SavedState localSavedState = (SavedState)paramParcelable;
    super.a(localSavedState.getSuperState());
    f(localSavedState.checked);
  }

  protected void a(Object paramObject)
  {
    if (paramObject == null);
    for (Object localObject = Boolean.valueOf(false); ; localObject = paramObject)
    {
      f(e(((Boolean)localObject).booleanValue()));
      return;
    }
  }

  protected void b(l paraml)
  {
    b(paraml.a(16908304));
  }

  protected void b(View paramView)
  {
    if (!(paramView instanceof TextView))
      return;
    TextView localTextView = (TextView)paramView;
    int i = 1;
    if ((this.a) && (!TextUtils.isEmpty(this.b)))
    {
      localTextView.setText(this.b);
      i = 0;
      if (i == 0)
        break label130;
      CharSequence localCharSequence = o();
      if (TextUtils.isEmpty(localCharSequence))
        break label130;
      localTextView.setText(localCharSequence);
    }
    label128: label130: for (int j = 0; ; j = i)
    {
      int k = 0;
      if (j == 0);
      while (true)
      {
        if (k == localTextView.getVisibility())
          break label128;
        localTextView.setVisibility(k);
        return;
        if ((this.a) || (TextUtils.isEmpty(this.c)))
          break;
        localTextView.setText(this.c);
        i = 0;
        break;
        k = 8;
      }
      break;
    }
  }

  public boolean b()
  {
    return this.a;
  }

  protected Parcelable d()
  {
    Parcelable localParcelable = super.d();
    if (F())
      return localParcelable;
    SavedState localSavedState = new SavedState(localParcelable);
    localSavedState.checked = b();
    return localSavedState;
  }

  public void e(CharSequence paramCharSequence)
  {
    this.b = paramCharSequence;
    if (b())
      d_();
  }

  public void f(CharSequence paramCharSequence)
  {
    this.c = paramCharSequence;
    if (!b())
      d_();
  }

  public void f(boolean paramBoolean)
  {
    if (this.a != paramBoolean);
    for (int i = 1; ; i = 0)
    {
      if ((i != 0) || (!this.d))
      {
        this.a = paramBoolean;
        this.d = true;
        d(paramBoolean);
        if (i != 0)
        {
          c(l());
          d_();
        }
      }
      return;
    }
  }

  public void g(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }

  protected void k()
  {
    super.k();
    if (!b());
    for (boolean bool = true; ; bool = false)
    {
      if (b(Boolean.valueOf(bool)))
        f(bool);
      return;
    }
  }

  public boolean l()
  {
    boolean bool1;
    if (this.e)
      bool1 = this.a;
    while (true)
    {
      boolean bool2;
      if (!bool1)
      {
        boolean bool3 = super.l();
        bool2 = false;
        if (!bool3);
      }
      else
      {
        bool2 = true;
      }
      return bool2;
      if (!this.a)
        bool1 = true;
      else
        bool1 = false;
    }
  }

  static class SavedState extends Preference.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public TwoStatePreference.SavedState a(Parcel paramAnonymousParcel)
      {
        return new TwoStatePreference.SavedState(paramAnonymousParcel);
      }

      public TwoStatePreference.SavedState[] a(int paramAnonymousInt)
      {
        return new TwoStatePreference.SavedState[paramAnonymousInt];
      }
    };
    boolean checked;

    public SavedState(Parcel paramParcel)
    {
      super();
      if (paramParcel.readInt() == i);
      while (true)
      {
        this.checked = i;
        return;
        i = 0;
      }
    }

    public SavedState(Parcelable paramParcelable)
    {
      super();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      if (this.checked);
      for (int i = 1; ; i = 0)
      {
        paramParcel.writeInt(i);
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.preference.TwoStatePreference
 * JD-Core Version:    0.6.2
 */