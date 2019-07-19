package pl.droidsonroids.gif;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class GifViewSavedState extends View.BaseSavedState
{
  public static final Parcelable.Creator<GifViewSavedState> CREATOR = new Parcelable.Creator()
  {
    public GifViewSavedState a(Parcel paramAnonymousParcel)
    {
      return new GifViewSavedState(paramAnonymousParcel, null);
    }

    public GifViewSavedState[] a(int paramAnonymousInt)
    {
      return new GifViewSavedState[paramAnonymousInt];
    }
  };
  final long[][] mStates;

  private GifViewSavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.mStates = new long[paramParcel.readInt()][];
    for (int i = 0; i < this.mStates.length; i++)
      this.mStates[i] = paramParcel.createLongArray();
  }

  GifViewSavedState(Parcelable paramParcelable, long[] paramArrayOfLong)
  {
    super(paramParcelable);
    this.mStates = new long[1][];
    this.mStates[0] = paramArrayOfLong;
  }

  GifViewSavedState(Parcelable paramParcelable, Drawable[] paramArrayOfDrawable)
  {
    super(paramParcelable);
    this.mStates = new long[paramArrayOfDrawable.length][];
    int i = 0;
    if (i < paramArrayOfDrawable.length)
    {
      Drawable localDrawable = paramArrayOfDrawable[i];
      if ((localDrawable instanceof b))
        this.mStates[i] = ((b)localDrawable).f.n();
      while (true)
      {
        i++;
        break;
        this.mStates[i] = null;
      }
    }
  }

  void restoreState(Drawable paramDrawable, int paramInt)
  {
    if ((this.mStates[paramInt] != null) && ((paramDrawable instanceof b)))
    {
      b localb = (b)paramDrawable;
      localb.a(localb.f.a(this.mStates[paramInt], localb.e));
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.mStates.length);
    long[][] arrayOfLong = this.mStates;
    int i = arrayOfLong.length;
    for (int j = 0; j < i; j++)
      paramParcel.writeLongArray(arrayOfLong[j]);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     pl.droidsonroids.gif.GifViewSavedState
 * JD-Core Version:    0.6.2
 */