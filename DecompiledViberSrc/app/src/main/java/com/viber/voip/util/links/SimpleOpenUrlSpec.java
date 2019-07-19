package com.viber.voip.util.links;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.voip.util.da;
import com.viber.voip.util.dk;

public class SimpleOpenUrlSpec
  implements Parcelable
{
  public static final Parcelable.Creator<SimpleOpenUrlSpec> CREATOR = new Parcelable.Creator()
  {
    public SimpleOpenUrlSpec a(Parcel paramAnonymousParcel)
    {
      return new SimpleOpenUrlSpec(paramAnonymousParcel);
    }

    public SimpleOpenUrlSpec[] a(int paramAnonymousInt)
    {
      return new SimpleOpenUrlSpec[paramAnonymousInt];
    }
  };
  public final int orientation;
  public final boolean shouldCheckSafety;
  public final boolean shouldOpenExternally;
  public final Uri uri;
  public final String url;
  public final int urlOrigin;

  protected SimpleOpenUrlSpec(Parcel paramParcel)
  {
    this.uri = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    this.url = paramParcel.readString();
    boolean bool2;
    if (paramParcel.readByte() != 0)
    {
      bool2 = bool1;
      this.shouldOpenExternally = bool2;
      if (paramParcel.readByte() == 0)
        break label78;
    }
    while (true)
    {
      this.shouldCheckSafety = bool1;
      this.urlOrigin = paramParcel.readInt();
      this.orientation = paramParcel.readInt();
      return;
      bool2 = false;
      break;
      label78: bool1 = false;
    }
  }

  public SimpleOpenUrlSpec(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramString, paramBoolean1, paramBoolean2, 0);
  }

  public SimpleOpenUrlSpec(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this(paramString, paramBoolean1, paramBoolean2, paramInt, -1);
  }

  public SimpleOpenUrlSpec(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    this.url = da.b(toWebOrUrlScheme(paramString), "");
    this.uri = Uri.parse(this.url);
    this.shouldOpenExternally = paramBoolean1;
    this.shouldCheckSafety = paramBoolean2;
    this.urlOrigin = paramInt1;
    this.orientation = paramInt2;
  }

  private static boolean isInternalAppUrlScheme(Uri paramUri)
  {
    return (dk.g(paramUri)) || (dk.h(paramUri)) || (dk.i(paramUri)) || (dk.k(paramUri)) || (dk.j(paramUri));
  }

  private static String toWebOrUrlScheme(String paramString)
  {
    if ((!da.a(paramString)) && (!paramString.startsWith("http")) && (!isInternalAppUrlScheme(Uri.parse(paramString))))
      paramString = "http://" + paramString;
    return paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean isInternalAppUrlScheme()
  {
    return isInternalAppUrlScheme(this.uri);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b1 = 1;
    paramParcel.writeParcelable(this.uri, paramInt);
    paramParcel.writeString(this.url);
    byte b2;
    if (this.shouldOpenExternally)
    {
      b2 = b1;
      paramParcel.writeByte(b2);
      if (!this.shouldCheckSafety)
        break label70;
    }
    while (true)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.urlOrigin);
      paramParcel.writeInt(this.orientation);
      return;
      b2 = 0;
      break;
      label70: b1 = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.links.SimpleOpenUrlSpec
 * JD-Core Version:    0.6.2
 */