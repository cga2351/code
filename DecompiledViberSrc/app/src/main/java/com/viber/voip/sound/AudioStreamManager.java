package com.viber.voip.sound;

import android.app.Activity;
import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.LinkedList;

public class AudioStreamManager
{
  private static final Logger L = ViberEnv.getLogger();
  private final Context mContext;
  protected final LinkedList<Integer> mStreamStack = new LinkedList();

  public AudioStreamManager(Context paramContext)
  {
    this.mContext = paramContext;
  }

  public boolean changeStream(int paramInt)
  {
    if (!(this.mContext instanceof Activity))
      return false;
    this.mStreamStack.push(Integer.valueOf(((Activity)this.mContext).getVolumeControlStream()));
    ((Activity)this.mContext).setVolumeControlStream(paramInt);
    return true;
  }

  public int getCurrentAudioStream()
  {
    if (!(this.mContext instanceof Activity))
      return -2147483648;
    return ((Activity)this.mContext).getVolumeControlStream();
  }

  public boolean restoreStream()
  {
    if (!(this.mContext instanceof Activity))
      return false;
    Integer localInteger = (Integer)this.mStreamStack.poll();
    if (localInteger != null)
      ((Activity)this.mContext).setVolumeControlStream(localInteger.intValue());
    if (localInteger != null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.AudioStreamManager
 * JD-Core Version:    0.6.2
 */