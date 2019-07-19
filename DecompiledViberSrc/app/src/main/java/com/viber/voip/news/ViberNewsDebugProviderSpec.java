package com.viber.voip.news;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.common.b.b;
import com.viber.common.b.d;
import com.viber.common.b.h;
import com.viber.voip.settings.d.bi;
import java.util.concurrent.TimeUnit;

public class ViberNewsDebugProviderSpec extends ViberNewsProviderSpec
{
  public static final Parcelable.Creator<ViberNewsDebugProviderSpec> CREATOR = new Parcelable.Creator()
  {
    public ViberNewsDebugProviderSpec a(Parcel paramAnonymousParcel)
    {
      return new ViberNewsDebugProviderSpec(paramAnonymousParcel);
    }

    public ViberNewsDebugProviderSpec[] a(int paramAnonymousInt)
    {
      return new ViberNewsDebugProviderSpec[paramAnonymousInt];
    }
  };

  public ViberNewsDebugProviderSpec()
  {
    super(0, "", -1, 0L, false, 0, 1, new int[0]);
  }

  ViberNewsDebugProviderSpec(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public int describeContents()
  {
    return 0;
  }

  public int getArticlesDetectionStrategy()
  {
    return d.bi.f.d();
  }

  public long getCacheTimeMillis()
  {
    return TimeUnit.MINUTES.toMillis(d.bi.d.d());
  }

  public int getEntryPoint()
  {
    return d.bi.g.d();
  }

  public int getFeedScreenOrientation()
  {
    return d.bi.c.d();
  }

  public int getId()
  {
    return d.bi.a.d();
  }

  public String getUrl()
  {
    return d.bi.b.d();
  }

  public boolean isNewsProviderExists()
  {
    return !d.bi.b.d().equals(d.bi.b.f());
  }

  public boolean isUrlParameterRequired(int paramInt)
  {
    return true;
  }

  public boolean openArticleOnNewScreen()
  {
    return d.bi.e.d();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.news.ViberNewsDebugProviderSpec
 * JD-Core Version:    0.6.2
 */