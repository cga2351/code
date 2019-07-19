package com.viber.voip.sound.tones;

import android.net.Uri;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.sound.bluetooth.BtControl;

public abstract interface IRingtonePlayer
{
  public abstract boolean canPlaySound();

  public abstract boolean canVibrate();

  public abstract Uri getCallTone(CallInfo paramCallInfo);

  public abstract void init();

  public abstract boolean isSoundNotificationsAllowed();

  public abstract void playCallTone(CallInfo paramCallInfo);

  public abstract void playCustomTone(Uri paramUri);

  public abstract void playDtmfTone(DtmfTone paramDtmfTone);

  public abstract void playInCallTone(int paramInt);

  public abstract void playSample(SampleTone paramSampleTone);

  public abstract void playStickerPromo(Uri paramUri, boolean paramBoolean);

  public abstract void setBtControl(BtControl paramBtControl);

  public abstract void stopAllTones();

  public abstract void stopCallTone();

  public abstract void stopInCallTone();

  public abstract void stopSample(SampleTone paramSampleTone);

  public abstract void stopStickerPromo();

  public abstract void vibrate(int paramInt);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.tones.IRingtonePlayer
 * JD-Core Version:    0.6.2
 */