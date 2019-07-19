package com.viber.voip.react;

import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.HashMap;
import java.util.Map;

public class ReactContextManager
{
  private static final Logger a = ViberEnv.getLogger();
  private final Map<String, d> b;
  private final Handler c;
  private Map<String, a> d = new HashMap();

  public ReactContextManager(Map<String, d> paramMap, Handler paramHandler)
  {
    this.b = paramMap;
    this.c = paramHandler;
  }

  public static a a(String paramString, boolean paramBoolean)
  {
    return new a(paramString, paramBoolean, null);
  }

  public void a(Params paramParams)
  {
    String str = paramParams.getReactContextKey();
    if (!"".equals(str));
    for (d locald = (d)this.b.get(str); ; locald = null)
    {
      a locala2;
      if (locald != null)
      {
        a locala1 = (a)this.d.get(str);
        if (locala1 != null)
        {
          this.c.removeCallbacks(locala1);
          this.d.remove(str);
        }
        locala2 = new a(locald, paramParams);
        if (paramParams.isInitRequested())
          locala2.run();
      }
      else
      {
        return;
      }
      if (paramParams.shouldDestroyImmediately())
      {
        locala2.run();
        return;
      }
      this.d.put(str, locala2);
      this.c.postDelayed(locala2, 5000L);
      return;
    }
  }

  public static final class Params
    implements Parcelable
  {
    public static final Parcelable.Creator<Params> CREATOR = new Parcelable.Creator()
    {
      public ReactContextManager.Params a(Parcel paramAnonymousParcel)
      {
        return new ReactContextManager.Params(paramAnonymousParcel);
      }

      public ReactContextManager.Params[] a(int paramAnonymousInt)
      {
        return new ReactContextManager.Params[paramAnonymousInt];
      }
    };
    private final boolean mInitRequested;
    private final String mMemberId;
    private final String mReactContextKey;
    private final String mRegPhoneCanonized;
    private final boolean mShouldDestroyImmediately;
    private final boolean mShouldReconfigureReactInstanceManager;

    protected Params(Parcel paramParcel)
    {
      this.mReactContextKey = paramParcel.readString();
      boolean bool2;
      boolean bool3;
      if (paramParcel.readByte() != 0)
      {
        bool2 = bool1;
        this.mInitRequested = bool2;
        this.mMemberId = paramParcel.readString();
        this.mRegPhoneCanonized = paramParcel.readString();
        if (paramParcel.readByte() == 0)
          break label78;
        bool3 = bool1;
        label54: this.mShouldDestroyImmediately = bool3;
        if (paramParcel.readByte() == 0)
          break label84;
      }
      while (true)
      {
        this.mShouldReconfigureReactInstanceManager = bool1;
        return;
        bool2 = false;
        break;
        label78: bool3 = false;
        break label54;
        label84: bool1 = false;
      }
    }

    private Params(String paramString1, boolean paramBoolean1, String paramString2, String paramString3, boolean paramBoolean2, boolean paramBoolean3)
    {
      this.mReactContextKey = paramString1;
      this.mInitRequested = paramBoolean1;
      this.mMemberId = paramString2;
      this.mRegPhoneCanonized = paramString3;
      this.mShouldDestroyImmediately = paramBoolean2;
      this.mShouldReconfigureReactInstanceManager = paramBoolean3;
    }

    public int describeContents()
    {
      return 0;
    }

    public String getMemberId()
    {
      return this.mMemberId;
    }

    public String getReactContextKey()
    {
      return this.mReactContextKey;
    }

    public String getRegPhoneCanonized()
    {
      return this.mRegPhoneCanonized;
    }

    boolean isInitRequested()
    {
      return this.mInitRequested;
    }

    boolean shouldDestroyImmediately()
    {
      return this.mShouldDestroyImmediately;
    }

    public boolean shouldReconfigureReactInstanceManager()
    {
      return this.mShouldReconfigureReactInstanceManager;
    }

    public String toString()
    {
      return "Params{mReactContextKey='" + this.mReactContextKey + '\'' + ", mInitRequested=" + this.mInitRequested + ", mMemberId='" + this.mMemberId + '\'' + ", mRegPhoneCanonized='" + this.mRegPhoneCanonized + '\'' + ", mShouldDestroyImmediately=" + this.mShouldDestroyImmediately + ", mShouldReconfigureReactInstanceManager=" + this.mShouldReconfigureReactInstanceManager + '}';
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      paramParcel.writeString(this.mReactContextKey);
      int j;
      int k;
      if (this.mInitRequested)
      {
        j = i;
        paramParcel.writeByte((byte)j);
        paramParcel.writeString(this.mMemberId);
        paramParcel.writeString(this.mRegPhoneCanonized);
        if (!this.mShouldDestroyImmediately)
          break label80;
        k = i;
        label53: paramParcel.writeByte((byte)k);
        if (!this.mShouldReconfigureReactInstanceManager)
          break label86;
      }
      while (true)
      {
        paramParcel.writeByte((byte)i);
        return;
        j = 0;
        break;
        label80: k = 0;
        break label53;
        label86: i = 0;
      }
    }
  }

  public static final class a
  {
    private final String a;
    private final boolean b;
    private String c;
    private String d;
    private boolean e;
    private boolean f;

    private a(String paramString, boolean paramBoolean)
    {
      this.a = paramString;
      this.b = paramBoolean;
    }

    public ReactContextManager.Params a()
    {
      return new ReactContextManager.Params(this.a, this.b, this.c, this.d, this.e, this.f, null);
    }

    public a a(String paramString)
    {
      this.c = paramString;
      return this;
    }

    public a a(boolean paramBoolean)
    {
      return this;
    }

    public a b(String paramString)
    {
      this.d = paramString;
      return this;
    }

    public a b(boolean paramBoolean)
    {
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.react.ReactContextManager
 * JD-Core Version:    0.6.2
 */