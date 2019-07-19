package com.viber.voip.messages.ui.media.player;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.voip.util.ak;
import com.viber.voip.util.cl;

public abstract interface MediaPlayerControls
{
  public static final a a = (a)cl.b(a.class);
  public static final MediaPlayerControls b = (MediaPlayerControls)cl.b(MediaPlayerControls.class);

  public abstract void a();

  public abstract void a(int paramInt, long paramLong1, long paramLong2);

  public abstract void b();

  public abstract void c();

  @ak(a=VisualSpec.class)
  public abstract VisualSpec getCurrentVisualSpec();

  public abstract void setCallbacks(a parama);

  public abstract void setControlsEnabled(boolean paramBoolean);

  public abstract void setVisibilityMode(int paramInt);

  public abstract void setVisualSpec(VisualSpec paramVisualSpec);

  public static class VisualSpec
    implements Parcelable
  {
    public static final Parcelable.Creator<VisualSpec> CREATOR = new Parcelable.Creator()
    {
      public MediaPlayerControls.VisualSpec a(Parcel paramAnonymousParcel)
      {
        return new MediaPlayerControls.VisualSpec(paramAnonymousParcel);
      }

      public MediaPlayerControls.VisualSpec[] a(int paramAnonymousInt)
      {
        return new MediaPlayerControls.VisualSpec[paramAnonymousInt];
      }
    };
    public static final VisualSpec EMPTY = new VisualSpec();
    private int mFavoriteOptionVisualState;
    private boolean mSendRichMessageAvailable;
    private String mSubtitle;
    private float mTextScale;
    private String mTitle;

    public VisualSpec()
    {
    }

    protected VisualSpec(Parcel paramParcel)
    {
      this.mTitle = paramParcel.readString();
      this.mSubtitle = paramParcel.readString();
      this.mTextScale = paramParcel.readFloat();
      this.mFavoriteOptionVisualState = paramParcel.readInt();
      if (paramParcel.readInt() == i);
      while (true)
      {
        this.mSendRichMessageAvailable = i;
        return;
        i = 0;
      }
    }

    public static a builder()
    {
      return new a(null);
    }

    public a buildUpon()
    {
      return new a(this, null);
    }

    public int describeContents()
    {
      return 0;
    }

    public int getFavoriteOptionVisualState()
    {
      return this.mFavoriteOptionVisualState;
    }

    public String getSubtitle()
    {
      return this.mSubtitle;
    }

    public float getTextScale()
    {
      return this.mTextScale;
    }

    public String getTitle()
    {
      return this.mTitle;
    }

    public boolean isSendRichMessageAvailable()
    {
      return this.mSendRichMessageAvailable;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.mTitle);
      paramParcel.writeString(this.mSubtitle);
      paramParcel.writeFloat(this.mTextScale);
      paramParcel.writeInt(this.mFavoriteOptionVisualState);
      if (this.mSendRichMessageAvailable);
      for (int i = 1; ; i = 0)
      {
        paramParcel.writeInt(i);
        return;
      }
    }

    public static final class a
    {
      private MediaPlayerControls.VisualSpec a = new MediaPlayerControls.VisualSpec();

      private a()
      {
        a(1.0F);
        a(0);
      }

      private a(MediaPlayerControls.VisualSpec paramVisualSpec)
      {
        this();
        a(paramVisualSpec.mTitle);
        b(paramVisualSpec.mSubtitle);
        a(paramVisualSpec.mTextScale);
        a(paramVisualSpec.mFavoriteOptionVisualState);
        a(paramVisualSpec.mSendRichMessageAvailable);
      }

      public a a(float paramFloat)
      {
        MediaPlayerControls.VisualSpec.access$402(this.a, paramFloat);
        return this;
      }

      public a a(int paramInt)
      {
        MediaPlayerControls.VisualSpec.access$502(this.a, paramInt);
        return this;
      }

      public a a(String paramString)
      {
        MediaPlayerControls.VisualSpec.access$202(this.a, paramString);
        return this;
      }

      public a a(boolean paramBoolean)
      {
        MediaPlayerControls.VisualSpec.access$602(this.a, paramBoolean);
        return this;
      }

      public MediaPlayerControls.VisualSpec a()
      {
        MediaPlayerControls.VisualSpec localVisualSpec = this.a;
        this.a = new MediaPlayerControls.VisualSpec();
        return localVisualSpec;
      }

      public a b(String paramString)
      {
        MediaPlayerControls.VisualSpec.access$302(this.a, paramString);
        return this;
      }
    }
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(int paramInt);

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.MediaPlayerControls
 * JD-Core Version:    0.6.2
 */