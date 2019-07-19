package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelImpl
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelImpl> CREATOR = new Parcelable.Creator()
  {
    public ParcelImpl a(Parcel paramAnonymousParcel)
    {
      return new ParcelImpl(paramAnonymousParcel);
    }

    public ParcelImpl[] a(int paramAnonymousInt)
    {
      return new ParcelImpl[paramAnonymousInt];
    }
  };
  private final c mParcel;

  protected ParcelImpl(Parcel paramParcel)
  {
    this.mParcel = new b(paramParcel).h();
  }

  public ParcelImpl(c paramc)
  {
    this.mParcel = paramc;
  }

  public int describeContents()
  {
    return 0;
  }

  public <T extends c> T getVersionedParcel()
  {
    return this.mParcel;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    new b(paramParcel).a(this.mParcel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.versionedparcelable.ParcelImpl
 * JD-Core Version:    0.6.2
 */