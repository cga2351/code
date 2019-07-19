package android.support.v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class SeekBarPreference extends Preference
{
  int a;
  int b;
  boolean c;
  SeekBar d;
  boolean e;
  private int f;
  private int g;
  private TextView h;
  private boolean i;
  private SeekBar.OnSeekBarChangeListener j = new SeekBar.OnSeekBarChangeListener()
  {
    public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
    {
      if ((paramAnonymousBoolean) && (!SeekBarPreference.this.c))
        SeekBarPreference.this.a(paramAnonymousSeekBar);
    }

    public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
    {
      SeekBarPreference.this.c = true;
    }

    public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
    {
      SeekBarPreference.this.c = false;
      if (paramAnonymousSeekBar.getProgress() + SeekBarPreference.this.b != SeekBarPreference.this.a)
        SeekBarPreference.this.a(paramAnonymousSeekBar);
    }
  };
  private View.OnKeyListener k = new View.OnKeyListener()
  {
    public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
    {
      if (paramAnonymousKeyEvent.getAction() != 0);
      while (((!SeekBarPreference.this.e) && ((paramAnonymousInt == 21) || (paramAnonymousInt == 22))) || (paramAnonymousInt == 23) || (paramAnonymousInt == 66))
        return false;
      if (SeekBarPreference.this.d == null)
      {
        Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
        return false;
      }
      return SeekBarPreference.this.d.onKeyDown(paramAnonymousInt, paramAnonymousKeyEvent);
    }
  };

  public SeekBarPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.seekBarPreferenceStyle);
  }

  public SeekBarPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }

  public SeekBarPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SeekBarPreference, paramInt1, paramInt2);
    this.b = localTypedArray.getInt(R.styleable.SeekBarPreference_min, 0);
    a(localTypedArray.getInt(R.styleable.SeekBarPreference_android_max, 100));
    b(localTypedArray.getInt(R.styleable.SeekBarPreference_seekBarIncrement, 0));
    this.e = localTypedArray.getBoolean(R.styleable.SeekBarPreference_adjustable, true);
    this.i = localTypedArray.getBoolean(R.styleable.SeekBarPreference_showSeekBarValue, true);
    localTypedArray.recycle();
  }

  private void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt < this.b)
      paramInt = this.b;
    if (paramInt > this.f)
      paramInt = this.f;
    if (paramInt != this.a)
    {
      this.a = paramInt;
      if (this.h != null)
        this.h.setText(String.valueOf(this.a));
      g(paramInt);
      if (paramBoolean)
        d_();
    }
  }

  protected Object a(TypedArray paramTypedArray, int paramInt)
  {
    return Integer.valueOf(paramTypedArray.getInt(paramInt, 0));
  }

  public final void a(int paramInt)
  {
    if (paramInt < this.b)
      paramInt = this.b;
    if (paramInt != this.f)
    {
      this.f = paramInt;
      d_();
    }
  }

  protected void a(Parcelable paramParcelable)
  {
    if (!paramParcelable.getClass().equals(SavedState.class))
    {
      super.a(paramParcelable);
      return;
    }
    SavedState localSavedState = (SavedState)paramParcelable;
    super.a(localSavedState.getSuperState());
    this.a = localSavedState.seekBarValue;
    this.b = localSavedState.min;
    this.f = localSavedState.max;
    d_();
  }

  public void a(l paraml)
  {
    super.a(paraml);
    paraml.itemView.setOnKeyListener(this.k);
    this.d = ((SeekBar)paraml.a(R.id.seekbar));
    this.h = ((TextView)paraml.a(R.id.seekbar_value));
    if (this.i)
      this.h.setVisibility(0);
    while (this.d == null)
    {
      Log.e("SeekBarPreference", "SeekBar view is null in onBindViewHolder.");
      return;
      this.h.setVisibility(8);
      this.h = null;
    }
    this.d.setOnSeekBarChangeListener(this.j);
    this.d.setMax(this.f - this.b);
    if (this.g != 0)
      this.d.setKeyProgressIncrement(this.g);
    while (true)
    {
      this.d.setProgress(this.a - this.b);
      if (this.h != null)
        this.h.setText(String.valueOf(this.a));
      this.d.setEnabled(z());
      return;
      this.g = this.d.getKeyProgressIncrement();
    }
  }

  void a(SeekBar paramSeekBar)
  {
    int m = this.b + paramSeekBar.getProgress();
    if (m != this.a)
    {
      if (b(Integer.valueOf(m)))
        a(m, false);
    }
    else
      return;
    paramSeekBar.setProgress(this.a - this.b);
  }

  protected void a(Object paramObject)
  {
    if (paramObject == null);
    for (Object localObject = Integer.valueOf(0); ; localObject = paramObject)
    {
      i(h(((Integer)localObject).intValue()));
      return;
    }
  }

  public final void b(int paramInt)
  {
    if (paramInt != this.g)
    {
      this.g = Math.min(this.f - this.b, Math.abs(paramInt));
      d_();
    }
  }

  protected Parcelable d()
  {
    Parcelable localParcelable = super.d();
    if (F())
      return localParcelable;
    SavedState localSavedState = new SavedState(localParcelable);
    localSavedState.seekBarValue = this.a;
    localSavedState.min = this.b;
    localSavedState.max = this.f;
    return localSavedState;
  }

  public void i(int paramInt)
  {
    a(paramInt, true);
  }

  private static class SavedState extends Preference.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public SeekBarPreference.SavedState a(Parcel paramAnonymousParcel)
      {
        return new SeekBarPreference.SavedState(paramAnonymousParcel);
      }

      public SeekBarPreference.SavedState[] a(int paramAnonymousInt)
      {
        return new SeekBarPreference.SavedState[paramAnonymousInt];
      }
    };
    int max;
    int min;
    int seekBarValue;

    public SavedState(Parcel paramParcel)
    {
      super();
      this.seekBarValue = paramParcel.readInt();
      this.min = paramParcel.readInt();
      this.max = paramParcel.readInt();
    }

    public SavedState(Parcelable paramParcelable)
    {
      super();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.seekBarValue);
      paramParcel.writeInt(this.min);
      paramParcel.writeInt(this.max);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.preference.SeekBarPreference
 * JD-Core Version:    0.6.2
 */