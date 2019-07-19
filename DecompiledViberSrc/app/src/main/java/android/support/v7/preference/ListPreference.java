package android.support.v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.content.res.TypedArrayUtils;
import android.text.TextUtils;
import android.util.AttributeSet;

public class ListPreference extends DialogPreference
{
  private CharSequence[] a;
  private CharSequence[] b;
  private String c;
  private String d;
  private boolean e;

  public ListPreference(Context paramContext)
  {
    this(paramContext, null);
  }

  public ListPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, TypedArrayUtils.getAttr(paramContext, R.attr.dialogPreferenceStyle, 16842897));
  }

  public ListPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }

  public ListPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    TypedArray localTypedArray1 = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ListPreference, paramInt1, paramInt2);
    this.a = TypedArrayUtils.getTextArray(localTypedArray1, R.styleable.ListPreference_entries, R.styleable.ListPreference_android_entries);
    this.b = TypedArrayUtils.getTextArray(localTypedArray1, R.styleable.ListPreference_entryValues, R.styleable.ListPreference_android_entryValues);
    localTypedArray1.recycle();
    TypedArray localTypedArray2 = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.Preference, paramInt1, paramInt2);
    this.d = TypedArrayUtils.getString(localTypedArray2, R.styleable.Preference_summary, R.styleable.Preference_android_summary);
    localTypedArray2.recycle();
  }

  private int b()
  {
    return c(this.c);
  }

  protected Object a(TypedArray paramTypedArray, int paramInt)
  {
    return paramTypedArray.getString(paramInt);
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
    b(localSavedState.value);
  }

  protected void a(Object paramObject)
  {
    b(g((String)paramObject));
  }

  public void a(CharSequence[] paramArrayOfCharSequence)
  {
    this.a = paramArrayOfCharSequence;
  }

  public void b(int paramInt)
  {
    if (this.b != null)
      b(this.b[paramInt].toString());
  }

  public void b(CharSequence paramCharSequence)
  {
    super.b(paramCharSequence);
    if ((paramCharSequence == null) && (this.d != null))
      this.d = null;
    while ((paramCharSequence == null) || (paramCharSequence.equals(this.d)))
      return;
    this.d = paramCharSequence.toString();
  }

  public void b(String paramString)
  {
    if (!TextUtils.equals(this.c, paramString));
    for (int i = 1; ; i = 0)
    {
      if ((i != 0) || (!this.e))
      {
        this.c = paramString;
        this.e = true;
        f(paramString);
        if (i != 0)
          d_();
      }
      return;
    }
  }

  public void b(CharSequence[] paramArrayOfCharSequence)
  {
    this.b = paramArrayOfCharSequence;
  }

  public int c(String paramString)
  {
    if ((paramString != null) && (this.b != null))
      for (int i = -1 + this.b.length; i >= 0; i--)
        if (this.b[i].equals(paramString))
          return i;
    return -1;
  }

  protected Parcelable d()
  {
    Parcelable localParcelable = super.d();
    if (F())
      return localParcelable;
    SavedState localSavedState = new SavedState(localParcelable);
    localSavedState.value = p();
    return localSavedState;
  }

  public CharSequence[] m()
  {
    return this.a;
  }

  public CharSequence[] n()
  {
    return this.b;
  }

  public CharSequence o()
  {
    Object localObject = q();
    if (this.d == null)
      return super.o();
    String str = this.d;
    Object[] arrayOfObject = new Object[1];
    if (localObject == null)
      localObject = "";
    arrayOfObject[0] = localObject;
    return String.format(str, arrayOfObject);
  }

  public String p()
  {
    return this.c;
  }

  public CharSequence q()
  {
    int i = b();
    if ((i >= 0) && (this.a != null))
      return this.a[i];
    return null;
  }

  private static class SavedState extends Preference.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public ListPreference.SavedState a(Parcel paramAnonymousParcel)
      {
        return new ListPreference.SavedState(paramAnonymousParcel);
      }

      public ListPreference.SavedState[] a(int paramAnonymousInt)
      {
        return new ListPreference.SavedState[paramAnonymousInt];
      }
    };
    String value;

    public SavedState(Parcel paramParcel)
    {
      super();
      this.value = paramParcel.readString();
    }

    public SavedState(Parcelable paramParcelable)
    {
      super();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.value);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.preference.ListPreference
 * JD-Core Version:    0.6.2
 */