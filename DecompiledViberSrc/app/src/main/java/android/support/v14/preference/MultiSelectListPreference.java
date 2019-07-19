package android.support.v14.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.preference.Preference.BaseSavedState;
import android.support.v7.preference.R.attr;
import android.support.v7.preference.R.styleable;
import android.support.v7.preference.internal.AbstractMultiSelectListPreference;
import android.util.AttributeSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MultiSelectListPreference extends AbstractMultiSelectListPreference
{
  private CharSequence[] a;
  private CharSequence[] b;
  private Set<String> c = new HashSet();

  public MultiSelectListPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, TypedArrayUtils.getAttr(paramContext, R.attr.dialogPreferenceStyle, 16842897));
  }

  public MultiSelectListPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }

  public MultiSelectListPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MultiSelectListPreference, paramInt1, paramInt2);
    this.a = TypedArrayUtils.getTextArray(localTypedArray, R.styleable.MultiSelectListPreference_entries, R.styleable.MultiSelectListPreference_android_entries);
    this.b = TypedArrayUtils.getTextArray(localTypedArray, R.styleable.MultiSelectListPreference_entryValues, R.styleable.MultiSelectListPreference_android_entryValues);
    localTypedArray.recycle();
  }

  protected Object a(TypedArray paramTypedArray, int paramInt)
  {
    CharSequence[] arrayOfCharSequence = paramTypedArray.getTextArray(paramInt);
    HashSet localHashSet = new HashSet();
    int i = arrayOfCharSequence.length;
    for (int j = 0; j < i; j++)
      localHashSet.add(arrayOfCharSequence[j].toString());
    return localHashSet;
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
    a(localSavedState.mValues);
  }

  protected void a(Object paramObject)
  {
    a(c((Set)paramObject));
  }

  public void a(Set<String> paramSet)
  {
    this.c.clear();
    this.c.addAll(paramSet);
    b(paramSet);
  }

  public CharSequence[] a()
  {
    return this.a;
  }

  public CharSequence[] b()
  {
    return this.b;
  }

  public Set<String> c()
  {
    return this.c;
  }

  protected Parcelable d()
  {
    Parcelable localParcelable = super.d();
    if (F())
      return localParcelable;
    SavedState localSavedState = new SavedState(localParcelable);
    localSavedState.mValues = c();
    return localSavedState;
  }

  private static class SavedState extends Preference.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public MultiSelectListPreference.SavedState a(Parcel paramAnonymousParcel)
      {
        return new MultiSelectListPreference.SavedState(paramAnonymousParcel);
      }

      public MultiSelectListPreference.SavedState[] a(int paramAnonymousInt)
      {
        return new MultiSelectListPreference.SavedState[paramAnonymousInt];
      }
    };
    Set<String> mValues;

    SavedState(Parcel paramParcel)
    {
      super();
      int i = paramParcel.readInt();
      this.mValues = new HashSet();
      String[] arrayOfString = new String[i];
      paramParcel.readStringArray(arrayOfString);
      Collections.addAll(this.mValues, arrayOfString);
    }

    SavedState(Parcelable paramParcelable)
    {
      super();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.mValues.size());
      paramParcel.writeStringArray((String[])this.mValues.toArray(new String[this.mValues.size()]));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v14.preference.MultiSelectListPreference
 * JD-Core Version:    0.6.2
 */