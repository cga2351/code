package com.viber.voip.sound.tones;

import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.Builder;
import android.media.SoundPool.OnLoadCompleteListener;
import android.net.Uri;
import android.os.Vibrator;
import android.provider.Settings.Global;
import android.provider.Settings.SettingNotFoundException;
import android.telephony.TelephonyManager;
import com.viber.common.b.b;
import com.viber.common.b.h;
import com.viber.common.d.a;
import com.viber.common.d.i;
import com.viber.dexshared.Logger;
import com.viber.voip.R.raw;
import com.viber.voip.ViberEnv;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.settings.d.ag;
import com.viber.voip.settings.d.m;
import com.viber.voip.sound.audiofocus.AudioFocusManager;
import com.viber.voip.sound.audiofocus.AudioFocusableMediaPlayer;
import com.viber.voip.sound.audiofocus.AudioFocusableMediaPlayer.PlaybackListener;
import com.viber.voip.sound.bluetooth.BtControl;
import com.viber.voip.util.bw;
import com.viber.voip.util.dk;

public class RingtonePlayer
  implements IRingtonePlayer
{
  private static final int BUSY_TONE = 1;
  private static final long[] CALL_VIBRATION_PATTERN = { 1000L, 1000L };
  private static final int DATA_INTERRUPTION_TONE = 5;
  private static final int HANGUP_TONE = 3;
  private static final int HOLD_TONE = 4;
  private static final Logger L = ViberEnv.getLogger();
  private static final int NO_TONE = 0;
  private static final int RINGBACK_TONE = 2;
  private static final int ZEN_MODE_ALARMS = 2;
  private static final int ZEN_MODE_IMPORTANT_INTERRUPTIONS = 1;
  private static final int ZEN_MODE_NO_INTERRUPTIONS = 3;
  private static final int ZEN_MODE_OFF;
  private final AudioFocusManager mAudioFocusManager;
  private final AudioManager mAudioManager;
  private BtControl mBtControl = null;
  private final SoundPool mCallPool;
  private final Context mContext;
  private final SoundPool mDtmfPool;
  private final NotificationManager mNotificationManager;
  private final Object mPlayerLock = new Object();
  private AudioFocusableMediaPlayer mRingtonePlayer;
  private int mRingtonePlayerOrigin = 0;
  private final SoundPool mSamplesPool;
  private final TelephonyManager mTelephonyManager;
  private final Vibrator mVibrator;

  public RingtonePlayer(Context paramContext)
  {
    i.a();
    this.mContext = paramContext.getApplicationContext();
    this.mVibrator = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.mAudioManager = ((AudioManager)paramContext.getSystemService("audio"));
    this.mNotificationManager = ((NotificationManager)paramContext.getSystemService("notification"));
    this.mTelephonyManager = ((TelephonyManager)paramContext.getSystemService("phone"));
    this.mAudioFocusManager = new AudioFocusManager(paramContext);
    this.mSamplesPool = createPool(5);
    this.mDtmfPool = createPool(8);
    this.mCallPool = createPool(0);
  }

  private boolean canVibrateInternal()
  {
    int i = this.mAudioManager.getRingerMode();
    boolean bool = d.m.b.d();
    switch (i)
    {
    default:
      return bool;
    case 1:
      return true;
    case 0:
    }
    if (a.j())
    {
      switch (this.mNotificationManager.getCurrentInterruptionFilter())
      {
      case 1:
      case 2:
      }
      return false;
    }
    if (a.g())
      try
      {
        int j = Settings.Global.getInt(this.mContext.getContentResolver(), "zen_mode");
        switch (j)
        {
        case 0:
        case 1:
        }
        return false;
      }
      catch (Settings.SettingNotFoundException localSettingNotFoundException)
      {
        return false;
      }
    return false;
  }

  private static SoundPool createPool(int paramInt)
  {
    if (a.g())
    {
      AudioAttributes localAudioAttributes = new AudioAttributes.Builder().setLegacyStreamType(paramInt).build();
      return new SoundPool.Builder().setMaxStreams(1).setAudioAttributes(localAudioAttributes).build();
    }
    return new SoundPool(1, paramInt, 0);
  }

  private boolean isSilentModeOn()
  {
    return (!a.g()) && (this.mAudioManager.getRingerMode() == 0);
  }

  private void loadSound(PooledToneInfo paramPooledToneInfo, SoundPool paramSoundPool)
  {
    if (paramSoundPool == null)
      return;
    try
    {
      paramPooledToneInfo.setSoundId(paramSoundPool.load(this.mContext.getResources().openRawResourceFd(paramPooledToneInfo.getResourceId()), 1));
      return;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
    }
  }

  private void playPooledSound(final PooledToneInfo paramPooledToneInfo, final int paramInt, SoundPool paramSoundPool)
  {
    if (paramSoundPool == null)
      return;
    if (paramPooledToneInfo.getSoundId() == 0)
    {
      paramSoundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener()
      {
        public void onLoadComplete(SoundPool paramAnonymousSoundPool, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          if (paramPooledToneInfo.getSoundId() == paramAnonymousInt1)
          {
            paramAnonymousSoundPool.setOnLoadCompleteListener(null);
            if (paramAnonymousInt2 == 0)
              RingtonePlayer.this.playPooledSound(paramPooledToneInfo, paramInt, paramAnonymousSoundPool);
          }
        }
      });
      loadSound(paramPooledToneInfo, paramSoundPool);
      return;
    }
    if ((!a.d()) && (paramInt > 0));
    for (int i = paramInt - 1; ; i = paramInt)
    {
      paramPooledToneInfo.setStreamId(paramSoundPool.play(paramPooledToneInfo.getSoundId(), paramPooledToneInfo.getVolume(), paramPooledToneInfo.getVolume(), 1, i, 1.0F));
      if (paramPooledToneInfo.getStreamId() != 0)
        break;
      loadSound(paramPooledToneInfo, paramSoundPool);
      return;
    }
  }

  private void playRingtone(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    playRingtone(dk.a(paramInt1, this.mContext), paramInt2, paramBoolean, false, paramInt3);
  }

  private void playRingtone(Uri paramUri, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    while (true)
    {
      synchronized (this.mPlayerLock)
      {
        stopMediaPlayer(paramInt2);
        this.mRingtonePlayerOrigin = paramInt2;
        this.mRingtonePlayer = new AudioFocusableMediaPlayer(paramInt1, this.mAudioFocusManager, this.mContext);
        if (!paramBoolean1)
          this.mRingtonePlayer.setPlaybackListener(new AudioFocusableMediaPlayer.PlaybackListener()
          {
            public void onPlayStarted()
            {
            }

            public void onPlayStopped(int paramAnonymousInt)
            {
              synchronized (RingtonePlayer.this.mPlayerLock)
              {
                if (RingtonePlayer.this.mRingtonePlayer != null)
                {
                  RingtonePlayer.this.mRingtonePlayer.setPlaybackListener(null);
                  RingtonePlayer.access$202(RingtonePlayer.this, null);
                  RingtonePlayer.access$302(RingtonePlayer.this, 0);
                }
                return;
              }
            }
          });
        this.mRingtonePlayer.setLooping(paramBoolean1);
        AudioFocusableMediaPlayer localAudioFocusableMediaPlayer = this.mRingtonePlayer;
        if (paramBoolean2)
        {
          i = 3;
          localAudioFocusableMediaPlayer.play(paramUri, i);
          return;
        }
      }
      int i = 0;
    }
  }

  private void stopMediaPlayer(int paramInt)
  {
    synchronized (this.mPlayerLock)
    {
      if (this.mRingtonePlayerOrigin != paramInt)
        return;
      if (this.mRingtonePlayer == null)
        return;
    }
    if (this.mRingtonePlayer.isPlaying())
      this.mRingtonePlayer.stop();
    while (true)
    {
      this.mRingtonePlayer = null;
      this.mRingtonePlayerOrigin = 0;
      return;
      this.mRingtonePlayer.cancel();
    }
  }

  private void stopPooledTone(PooledToneInfo paramPooledToneInfo, SoundPool paramSoundPool)
  {
    if (paramSoundPool == null)
      return;
    if ((paramPooledToneInfo.getSoundId() != 0) || (paramPooledToneInfo.getStreamId() == 0));
    paramSoundPool.stop(paramPooledToneInfo.getStreamId());
    paramSoundPool.setOnLoadCompleteListener(null);
    paramPooledToneInfo.setStreamId(0);
  }

  public boolean canPlaySound()
  {
    return (!isSilentModeOn()) && (!bw.a(this.mTelephonyManager));
  }

  public boolean canVibrate()
  {
    return (!bw.a(this.mTelephonyManager)) && (canVibrateInternal());
  }

  public Uri getCallTone(CallInfo paramCallInfo)
  {
    if (isSilentModeOn())
      return null;
    boolean bool = paramCallInfo.isTransfer();
    int i;
    Uri localUri1;
    if ((!bool) && ((paramCallInfo.isViberIn()) || (d.m.a.d())))
    {
      i = 1;
      localUri1 = Uri.parse(d.m.c.d());
      if (!bool)
        break label79;
    }
    Uri localUri2;
    label79: for (int j = R.raw.transfer_in; ; j = R.raw.viber_ring)
    {
      localUri2 = dk.a(j, this.mContext);
      if (i == 0)
        break label87;
      return localUri1;
      i = 0;
      break;
    }
    label87: return localUri2;
  }

  public void init()
  {
    loadSound(CallTone.BUSY.getToneInfo(), this.mCallPool);
    loadSound(CallTone.RINGBACK.getToneInfo(), this.mCallPool);
    loadSound(CallTone.HANGUP.getToneInfo(), this.mCallPool);
    loadSound(CallTone.HOLD.getToneInfo(), this.mCallPool);
    loadSound(CallTone.DATA_INTERRUPTION_TONE.getToneInfo(), this.mCallPool);
  }

  public boolean isSoundNotificationsAllowed()
  {
    switch (this.mAudioManager.getRingerMode())
    {
    default:
      return true;
    case 0:
    case 1:
    }
    return false;
  }

  public void playCallTone(CallInfo paramCallInfo)
  {
    int i = 2;
    Uri localUri = getCallTone(paramCallInfo);
    if (localUri == null)
      return;
    int j;
    int k;
    if (canVibrateInternal())
    {
      if (!a.g())
        break label129;
      if (this.mAudioManager.getRingerMode() != i)
        break label116;
      j = 1;
      AudioAttributes.Builder localBuilder = new AudioAttributes.Builder().setContentType(4);
      if (j == 0)
        break label122;
      k = 7;
      label62: AudioAttributes localAudioAttributes = localBuilder.setUsage(k).build();
      this.mVibrator.vibrate(CALL_VIBRATION_PATTERN, 0, localAudioAttributes);
    }
    while (true)
    {
      if ((this.mBtControl != null) && (this.mBtControl.isHeadsetConnected()))
        i = 0;
      playRingtone(localUri, i, true, false, 1);
      return;
      label116: j = 0;
      break;
      label122: k = 6;
      break label62;
      label129: this.mVibrator.vibrate(CALL_VIBRATION_PATTERN, 0);
    }
  }

  public void playCustomTone(Uri paramUri)
  {
    if (!canPlaySound())
      return;
    playRingtone(paramUri, 5, false, true, 3);
  }

  public void playDtmfTone(DtmfTone paramDtmfTone)
  {
    if ((!canPlaySound()) || (!isSoundNotificationsAllowed()))
      return;
    playPooledSound(paramDtmfTone.getToneInfo(), 0, this.mDtmfPool);
  }

  public void playInCallTone(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 0:
      stopInCallTone();
      return;
    case 1:
      playPooledSound(CallTone.BUSY.getToneInfo(), -1, this.mCallPool);
      return;
    case 2:
      playPooledSound(CallTone.RINGBACK.getToneInfo(), -1, this.mCallPool);
      return;
    case 3:
      playPooledSound(CallTone.HANGUP.getToneInfo(), 3, this.mCallPool);
      return;
    case 4:
      playPooledSound(CallTone.HOLD.getToneInfo(), -1, this.mCallPool);
      return;
    case 5:
    }
    playPooledSound(CallTone.DATA_INTERRUPTION_TONE.getToneInfo(), -1, this.mCallPool);
  }

  public void playSample(SampleTone paramSampleTone)
  {
    if (!canPlaySound());
    while ((paramSampleTone.isOutgoing()) && (!d.ag.h.d()))
      return;
    if ((paramSampleTone.getLoop() == 0) && (this.mAudioManager.isMusicActive()))
    {
      playRingtone(paramSampleTone.getToneInfo().getResourceId(), 3, false, 4);
      return;
    }
    playPooledSound(paramSampleTone.getToneInfo(), paramSampleTone.getLoop(), this.mSamplesPool);
  }

  public void playStickerPromo(Uri paramUri, boolean paramBoolean)
  {
    if (!canPlaySound());
    while ((this.mRingtonePlayer != null) && (this.mRingtonePlayer.isPlaying()) && (!paramBoolean))
      return;
    if ((this.mAudioManager.isMusicActive()) || (this.mAudioManager.isWiredHeadsetOn()) || (this.mAudioManager.isBluetoothA2dpOn()));
    for (int i = 3; ; i = 5)
    {
      playRingtone(paramUri, i, false, true, 2);
      return;
    }
  }

  public void setBtControl(BtControl paramBtControl)
  {
    this.mBtControl = paramBtControl;
  }

  public void stopAllTones()
  {
    int i = 0;
    stopCallTone();
    stopStickerPromo();
    SampleTone[] arrayOfSampleTone = SampleTone.values();
    int j = arrayOfSampleTone.length;
    for (int k = 0; k < j; k++)
      stopPooledTone(arrayOfSampleTone[k].getToneInfo(), this.mSamplesPool);
    DtmfTone[] arrayOfDtmfTone = DtmfTone.values();
    int m = arrayOfDtmfTone.length;
    while (i < m)
    {
      stopPooledTone(arrayOfDtmfTone[i].getToneInfo(), this.mDtmfPool);
      i++;
    }
  }

  public void stopCallTone()
  {
    this.mVibrator.cancel();
    stopMediaPlayer(1);
  }

  public void stopInCallTone()
  {
    CallTone[] arrayOfCallTone = CallTone.values();
    int i = arrayOfCallTone.length;
    for (int j = 0; j < i; j++)
      stopPooledTone(arrayOfCallTone[j].getToneInfo(), this.mCallPool);
  }

  public void stopSample(SampleTone paramSampleTone)
  {
    stopPooledTone(paramSampleTone.getToneInfo(), this.mSamplesPool);
    stopMediaPlayer(4);
  }

  public void stopStickerPromo()
  {
    stopMediaPlayer(2);
  }

  public void vibrate(int paramInt)
  {
    if (!canVibrate())
      return;
    this.mVibrator.vibrate(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.tones.RingtonePlayer
 * JD-Core Version:    0.6.2
 */