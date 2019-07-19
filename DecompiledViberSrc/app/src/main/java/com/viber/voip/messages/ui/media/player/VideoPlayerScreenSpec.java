package com.viber.voip.messages.ui.media.player;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class VideoPlayerScreenSpec
  implements Parcelable
{
  public static final Parcelable.Creator<VideoPlayerScreenSpec> CREATOR = new Parcelable.Creator()
  {
    public VideoPlayerScreenSpec a(Parcel paramAnonymousParcel)
    {
      return new VideoPlayerScreenSpec(paramAnonymousParcel);
    }

    public VideoPlayerScreenSpec[] a(int paramAnonymousInt)
    {
      return new VideoPlayerScreenSpec[paramAnonymousInt];
    }
  };
  public MediaPlayerControls.VisualSpec controlsVisualSpec;
  public Rect minimizedWindowRect;
  public MediaPlayer.VisualSpec visualSpec;

  protected VideoPlayerScreenSpec(Parcel paramParcel)
  {
    this.visualSpec = ((MediaPlayer.VisualSpec)paramParcel.readParcelable(MediaPlayer.VisualSpec.class.getClassLoader()));
    this.controlsVisualSpec = ((MediaPlayerControls.VisualSpec)paramParcel.readParcelable(MediaPlayerControls.VisualSpec.class.getClassLoader()));
    this.minimizedWindowRect = ((Rect)paramParcel.readParcelable(Rect.class.getClassLoader()));
  }

  public VideoPlayerScreenSpec(MediaPlayer.VisualSpec paramVisualSpec, MediaPlayerControls.VisualSpec paramVisualSpec1, Rect paramRect)
  {
    this.visualSpec = paramVisualSpec;
    this.controlsVisualSpec = paramVisualSpec1;
    this.minimizedWindowRect = paramRect;
  }

  public int describeContents()
  {
    return 0;
  }

  public void set(VideoPlayerScreenSpec paramVideoPlayerScreenSpec)
  {
    this.visualSpec = paramVideoPlayerScreenSpec.visualSpec;
    this.controlsVisualSpec = paramVideoPlayerScreenSpec.controlsVisualSpec;
    this.minimizedWindowRect = paramVideoPlayerScreenSpec.minimizedWindowRect;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.visualSpec, paramInt);
    paramParcel.writeParcelable(this.controlsVisualSpec, paramInt);
    paramParcel.writeParcelable(this.minimizedWindowRect, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.VideoPlayerScreenSpec
 * JD-Core Version:    0.6.2
 */