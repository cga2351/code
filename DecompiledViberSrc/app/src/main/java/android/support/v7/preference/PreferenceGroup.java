package android.support.v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class PreferenceGroup extends Preference
{
  final SimpleArrayMap<String, Long> a = new SimpleArrayMap();
  private List<Preference> b = new ArrayList();
  private boolean c = true;
  private int d = 0;
  private boolean e = false;
  private int f = 2147483647;
  private a g = null;
  private final Handler h = new Handler();
  private final Runnable i = new Runnable()
  {
    public void run()
    {
      try
      {
        PreferenceGroup.this.a.clear();
        return;
      }
      finally
      {
      }
    }
  };

  public PreferenceGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public PreferenceGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }

  public PreferenceGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.PreferenceGroup, paramInt1, paramInt2);
    this.c = TypedArrayUtils.getBoolean(localTypedArray, R.styleable.PreferenceGroup_orderingFromXml, R.styleable.PreferenceGroup_orderingFromXml, true);
    if (localTypedArray.hasValue(R.styleable.PreferenceGroup_initialExpandedChildrenCount))
      a(TypedArrayUtils.getInt(localTypedArray, R.styleable.PreferenceGroup_initialExpandedChildrenCount, R.styleable.PreferenceGroup_initialExpandedChildrenCount, 2147483647));
    localTypedArray.recycle();
  }

  private boolean f(Preference paramPreference)
  {
    try
    {
      paramPreference.Q();
      if (paramPreference.P() == this)
        paramPreference.a(null);
      boolean bool = this.b.remove(paramPreference);
      if (bool)
      {
        String str = paramPreference.C();
        if (str != null)
        {
          this.a.put(str, Long.valueOf(paramPreference.c_()));
          this.h.removeCallbacks(this.i);
          this.h.post(this.i);
        }
        if (this.e)
          paramPreference.N();
      }
      return bool;
    }
    finally
    {
    }
  }

  public void M()
  {
    super.M();
    this.e = true;
    int j = e();
    for (int k = 0; k < j; k++)
      b(k).M();
  }

  public void N()
  {
    int j = 0;
    super.N();
    this.e = false;
    int k = e();
    while (j < k)
    {
      b(j).N();
      j++;
    }
  }

  public Preference a(CharSequence paramCharSequence)
  {
    if (TextUtils.equals(C(), paramCharSequence))
      return this;
    int j = e();
    for (int k = 0; k < j; k++)
    {
      Preference localPreference1 = b(k);
      String str = localPreference1.C();
      if ((str != null) && (str.equals(paramCharSequence)))
        return localPreference1;
      if ((localPreference1 instanceof PreferenceGroup))
      {
        Preference localPreference2 = ((PreferenceGroup)localPreference1).a(paramCharSequence);
        if (localPreference2 != null)
          return localPreference2;
      }
    }
    return null;
  }

  public void a(int paramInt)
  {
    if ((paramInt != 2147483647) && (!E()))
      Log.e("PreferenceGroup", getClass().getSimpleName() + " should have a key defined if it contains an expandable preference");
    this.f = paramInt;
  }

  protected void a(Parcelable paramParcelable)
  {
    if ((paramParcelable == null) || (!paramParcelable.getClass().equals(SavedState.class)))
    {
      super.a(paramParcelable);
      return;
    }
    SavedState localSavedState = (SavedState)paramParcelable;
    this.f = localSavedState.mInitialExpandedChildrenCount;
    super.a(localSavedState.getSuperState());
  }

  public int b()
  {
    return this.f;
  }

  public Preference b(int paramInt)
  {
    return (Preference)this.b.get(paramInt);
  }

  protected void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    int j = e();
    for (int k = 0; k < j; k++)
      b(k).b(paramBundle);
  }

  public void b(Preference paramPreference)
  {
    c(paramPreference);
  }

  public void c(boolean paramBoolean)
  {
    super.c(paramBoolean);
    int j = e();
    for (int k = 0; k < j; k++)
      b(k).b(this, paramBoolean);
  }

  public boolean c(Preference paramPreference)
  {
    if (this.b.contains(paramPreference))
      return true;
    if (paramPreference.C() != null)
    {
      for (PreferenceGroup localPreferenceGroup = this; localPreferenceGroup.P() != null; localPreferenceGroup = localPreferenceGroup.P());
      String str2 = paramPreference.C();
      if (localPreferenceGroup.a(str2) != null)
        Log.e("PreferenceGroup", "Found duplicated key: \"" + str2 + "\". This can cause unintended behaviour," + " please use unique keys for every preference.");
    }
    if (paramPreference.x() == 2147483647)
    {
      if (this.c)
      {
        int k = this.d;
        this.d = (k + 1);
        paramPreference.d(k);
      }
      if ((paramPreference instanceof PreferenceGroup))
        ((PreferenceGroup)paramPreference).f(this.c);
    }
    int j = Collections.binarySearch(this.b, paramPreference);
    if (j < 0)
      j = -1 + j * -1;
    if (!e(paramPreference))
      return false;
    while (true)
    {
      j localj;
      try
      {
        this.b.add(j, paramPreference);
        localj = L();
        String str1 = paramPreference.C();
        if ((str1 != null) && (this.a.containsKey(str1)))
        {
          l = ((Long)this.a.get(str1)).longValue();
          this.a.remove(str1);
          paramPreference.a(localj, l);
          paramPreference.a(this);
          if (this.e)
            paramPreference.M();
          K();
          return true;
        }
      }
      finally
      {
      }
      long l = localj.a();
    }
  }

  protected Parcelable d()
  {
    return new SavedState(super.d(), this.f);
  }

  protected void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    int j = e();
    for (int k = 0; k < j; k++)
      b(k).d(paramBundle);
  }

  public boolean d(Preference paramPreference)
  {
    boolean bool = f(paramPreference);
    K();
    return bool;
  }

  public int e()
  {
    return this.b.size();
  }

  protected boolean e(Preference paramPreference)
  {
    paramPreference.b(this, l());
    return true;
  }

  public void f(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  protected boolean f()
  {
    return true;
  }

  public a g()
  {
    return this.g;
  }

  void h()
  {
    try
    {
      Collections.sort(this.b);
      return;
    }
    finally
    {
    }
  }

  static class SavedState extends Preference.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public PreferenceGroup.SavedState a(Parcel paramAnonymousParcel)
      {
        return new PreferenceGroup.SavedState(paramAnonymousParcel);
      }

      public PreferenceGroup.SavedState[] a(int paramAnonymousInt)
      {
        return new PreferenceGroup.SavedState[paramAnonymousInt];
      }
    };
    int mInitialExpandedChildrenCount;

    SavedState(Parcel paramParcel)
    {
      super();
      this.mInitialExpandedChildrenCount = paramParcel.readInt();
    }

    SavedState(Parcelable paramParcelable, int paramInt)
    {
      super();
      this.mInitialExpandedChildrenCount = paramInt;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.mInitialExpandedChildrenCount);
    }
  }

  public static abstract interface a
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.preference.PreferenceGroup
 * JD-Core Version:    0.6.2
 */