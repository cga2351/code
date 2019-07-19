package com.viber.voip.messages.ui.media.player;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.widget.ImageView.ScaleType;
import com.viber.voip.util.ag;
import com.viber.voip.util.ah;
import com.viber.voip.util.ai;
import com.viber.voip.util.aj;
import com.viber.voip.util.ak;
import com.viber.voip.util.cl;

public abstract interface MediaPlayer
{
  public static final a a = (a)cl.b(a.class);
  public static final MediaPlayer b = (MediaPlayer)cl.b(MediaPlayer.class);

  public abstract void a();

  public abstract void a(long paramLong);

  public abstract void b();

  @ag(a=false)
  public abstract boolean c();

  @ag(a=false)
  public abstract boolean d();

  public abstract String getActionReplyData();

  @aj(a=0L)
  public abstract long getCurrentPositionMillis();

  @ak(a=VisualSpec.class)
  public abstract VisualSpec getCurrentVisualSpec();

  @aj(a=0L)
  public abstract long getDurationMillis();

  @ai(a=-1)
  public abstract int getPlayerType();

  public abstract String getSourceUrl();

  @ai(a=0)
  public abstract int getThumbnailResource();

  @ah(a=ImageView.ScaleType.class, b="FIT_CENTER")
  public abstract ImageView.ScaleType getThumbnailScaleType();

  public abstract String getThumbnailUrl();

  public abstract void setActionReplyData(String paramString);

  public abstract void setCallbacks(a parama);

  public abstract void setHasVisualContent(boolean paramBoolean);

  public abstract void setLogoLayoutId(int paramInt);

  public abstract void setLoop(boolean paramBoolean);

  public abstract void setSourceUrl(String paramString);

  public abstract void setThumbnailResource(int paramInt);

  public abstract void setThumbnailScaleType(ImageView.ScaleType paramScaleType);

  public abstract void setThumbnailUrl(String paramString);

  public abstract void setVisualSpec(VisualSpec paramVisualSpec);

  public static class VisualSpec
    implements Parcelable
  {
    public static final Parcelable.Creator<VisualSpec> CREATOR = new Parcelable.Creator()
    {
      public MediaPlayer.VisualSpec a(Parcel paramAnonymousParcel)
      {
        return new MediaPlayer.VisualSpec(paramAnonymousParcel);
      }

      public MediaPlayer.VisualSpec[] a(int paramAnonymousInt)
      {
        return new MediaPlayer.VisualSpec[paramAnonymousInt];
      }
    };
    private String mActionReplyData;
    private boolean mHasVisualContent;
    private int mLogoLayoutId;
    private boolean mLoop;
    private int mPlayerType;
    private String mSourceUrl;
    private int mThumbnailResource;
    private ImageView.ScaleType mThumbnailScaleType;
    private String mThumbnailUrl;

    public VisualSpec()
    {
    }

    protected VisualSpec(Parcel paramParcel)
    {
      int j;
      if (paramParcel.readByte() != 0)
      {
        j = i;
        this.mHasVisualContent = j;
        this.mSourceUrl = paramParcel.readString();
        this.mThumbnailUrl = paramParcel.readString();
        this.mThumbnailResource = paramParcel.readInt();
        this.mThumbnailScaleType = ImageView.ScaleType.values()[paramParcel.readInt()];
        this.mPlayerType = paramParcel.readInt();
        this.mLogoLayoutId = paramParcel.readInt();
        if (paramParcel.readByte() != i)
          break label99;
      }
      while (true)
      {
        this.mLoop = i;
        this.mActionReplyData = paramParcel.readString();
        return;
        j = 0;
        break;
        label99: i = 0;
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

    public String getActionReplyData()
    {
      return this.mActionReplyData;
    }

    public int getLogoLayoutId()
    {
      return this.mLogoLayoutId;
    }

    public int getPlayerType()
    {
      return this.mPlayerType;
    }

    public String getSourceUrl()
    {
      return this.mSourceUrl;
    }

    public int getThumbnailResource()
    {
      return this.mThumbnailResource;
    }

    public ImageView.ScaleType getThumbnailScaleType()
    {
      return this.mThumbnailScaleType;
    }

    public String getThumbnailUrl()
    {
      return this.mThumbnailUrl;
    }

    public boolean hasVisualContent()
    {
      return this.mHasVisualContent;
    }

    public boolean isLoop()
    {
      return this.mLoop;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      byte b1 = 1;
      byte b2;
      if (this.mHasVisualContent)
      {
        b2 = b1;
        paramParcel.writeByte(b2);
        paramParcel.writeString(this.mSourceUrl);
        paramParcel.writeString(this.mThumbnailUrl);
        paramParcel.writeInt(this.mThumbnailResource);
        paramParcel.writeInt(this.mThumbnailScaleType.ordinal());
        paramParcel.writeInt(this.mPlayerType);
        paramParcel.writeInt(this.mLogoLayoutId);
        if (!this.mLoop)
          break label97;
      }
      while (true)
      {
        paramParcel.writeByte((byte)b1);
        paramParcel.writeString(this.mActionReplyData);
        return;
        b2 = 0;
        break;
        label97: b1 = 0;
      }
    }

    public static final class a
    {
      private MediaPlayer.VisualSpec a = new MediaPlayer.VisualSpec();

      private a()
      {
        a(true);
        a(ImageView.ScaleType.FIT_CENTER);
        b(-1);
        c(0);
      }

      private a(MediaPlayer.VisualSpec paramVisualSpec)
      {
        this();
        a(paramVisualSpec.mHasVisualContent);
        a(paramVisualSpec.mSourceUrl);
        b(paramVisualSpec.mThumbnailUrl);
        a(paramVisualSpec.mThumbnailResource);
        a(paramVisualSpec.mThumbnailScaleType);
        b(paramVisualSpec.mPlayerType);
        b(paramVisualSpec.mLoop);
        c(paramVisualSpec.mActionReplyData);
      }

      public a a(int paramInt)
      {
        MediaPlayer.VisualSpec.access$502(this.a, paramInt);
        return this;
      }

      public a a(ImageView.ScaleType paramScaleType)
      {
        MediaPlayer.VisualSpec.access$602(this.a, paramScaleType);
        return this;
      }

      public a a(String paramString)
      {
        MediaPlayer.VisualSpec.access$302(this.a, paramString);
        return this;
      }

      public a a(boolean paramBoolean)
      {
        MediaPlayer.VisualSpec.access$202(this.a, paramBoolean);
        return this;
      }

      public MediaPlayer.VisualSpec a()
      {
        MediaPlayer.VisualSpec localVisualSpec = this.a;
        this.a = new MediaPlayer.VisualSpec();
        return localVisualSpec;
      }

      public a b(int paramInt)
      {
        MediaPlayer.VisualSpec.access$702(this.a, paramInt);
        return this;
      }

      public a b(String paramString)
      {
        MediaPlayer.VisualSpec.access$402(this.a, paramString);
        return this;
      }

      public a b(boolean paramBoolean)
      {
        MediaPlayer.VisualSpec.access$802(this.a, paramBoolean);
        return this;
      }

      public a c(int paramInt)
      {
        MediaPlayer.VisualSpec.access$1002(this.a, paramInt);
        return this;
      }

      public a c(String paramString)
      {
        MediaPlayer.VisualSpec.access$902(this.a, paramString);
        return this;
      }
    }
  }

  public static abstract interface a
  {
    public abstract void a(MediaPlayer paramMediaPlayer);

    public abstract void a(MediaPlayer paramMediaPlayer, int paramInt);

    public abstract void a(MediaPlayer paramMediaPlayer, long paramLong1, long paramLong2);

    public abstract void b(MediaPlayer paramMediaPlayer);

    public abstract void b(MediaPlayer paramMediaPlayer, int paramInt);

    public abstract void c(MediaPlayer paramMediaPlayer);
  }

  public static abstract interface b
  {
    public static final b a = (b)cl.b(b.class);

    public abstract void a();

    public abstract void a(boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.MediaPlayer
 * JD-Core Version:    0.6.2
 */