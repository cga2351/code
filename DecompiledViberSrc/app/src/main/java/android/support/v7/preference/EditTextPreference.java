package android.support.v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.content.res.TypedArrayUtils;
import android.text.TextUtils;
import android.util.AttributeSet;

public class EditTextPreference extends DialogPreference
{
  private String a;

  public EditTextPreference(Context paramContext)
  {
    this(paramContext, null);
  }

  public EditTextPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, TypedArrayUtils.getAttr(paramContext, R.attr.editTextPreferenceStyle, 16842898));
  }

  public EditTextPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }

  public EditTextPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
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
    a(localSavedState.text);
  }

  protected void a(Object paramObject)
  {
    a(g((String)paramObject));
  }

  public void a(String paramString)
  {
    boolean bool1 = l();
    this.a = paramString;
    f(paramString);
    boolean bool2 = l();
    if (bool2 != bool1)
      c(bool2);
  }

  public String b()
  {
    return this.a;
  }

  protected Parcelable d()
  {
    Parcelable localParcelable = super.d();
    if (F())
      return localParcelable;
    SavedState localSavedState = new SavedState(localParcelable);
    localSavedState.text = b();
    return localSavedState;
  }

  public boolean l()
  {
    return (TextUtils.isEmpty(this.a)) || (super.l());
  }

  private static class SavedState extends Preference.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public EditTextPreference.SavedState a(Parcel paramAnonymousParcel)
      {
        return new EditTextPreference.SavedState(paramAnonymousParcel);
      }

      public EditTextPreference.SavedState[] a(int paramAnonymousInt)
      {
        return new EditTextPreference.SavedState[paramAnonymousInt];
      }
    };
    String text;

    public SavedState(Parcel paramParcel)
    {
      super();
      this.text = paramParcel.readString();
    }

    public SavedState(Parcelable paramParcelable)
    {
      super();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.text);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.preference.EditTextPreference
 * JD-Core Version:    0.6.2
 */