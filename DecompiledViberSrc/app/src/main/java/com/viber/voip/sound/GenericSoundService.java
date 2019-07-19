package com.viber.voip.sound;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import android.os.HandlerThread;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.PhoneControllerDelegateAdapter;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.conf.ConferenceCall;
import com.viber.voip.sound.audiofocus.AudioFocusManager;
import com.viber.voip.sound.audiofocus.AudioFocusableAdapter;
import com.viber.voip.sound.bluetooth.BtControl;
import com.viber.voip.sound.bluetooth.BtControl.IBluetoothDeviceListener;
import com.viber.voip.sound.config.SoundConfig;
import com.viber.voip.sound.tones.IRingtonePlayer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.webrtc.voiceengine.WebRtcAudioManager;
import org.webrtc.voiceengine.WebRtcAudioUtils;

public class GenericSoundService extends PhoneControllerDelegateAdapter
  implements ISoundService, BtControl.IBluetoothDeviceListener
{
  private static final int GSM_CALL_END_HANDLING_DELAY = 300;
  private static final Logger L = ViberEnv.getLogger();
  private static final int SAMPLE_RATE_16K_HZ = 16000;
  private static Handler _handler = new Handler(_handlerThread.getLooper());
  private static HandlerThread _handlerThread = new HandlerThread("SoundService");
  private final AudioFocusManager _audioFocusControl;
  private final AudioFocusableAdapter _audioFocusListener = new AudioFocusableAdapter();
  private final AudioManager _audioManager;
  private final BtControl _btControl;
  private final Context _context;
  private boolean _isSpeakerOn = false;
  private final int _modeInCall;
  private boolean _oldSpeakerState = false;
  private boolean _shouldRestoreSpeaker = false;
  private SoundConfig _soundConfig = new SoundConfig();
  private boolean _speakerStateBeforeHeadsetIsPlugged = false;
  private final Map<ISoundService.SpeakerStateListener, Object> _speakerStateListeners = Collections.synchronizedMap(new HashMap());
  private boolean mInGSMCall = false;
  private boolean mInViberCall = false;
  private RouteUsage mRouteUsage = RouteUsage.None;
  private boolean mUserWantsSpeaker = false;
  private boolean mWiredHeadphonesConnected;

  static
  {
    _handlerThread.setDaemon(true);
    _handlerThread.start();
  }

  public GenericSoundService(Context paramContext, int paramInt, boolean paramBoolean)
  {
    this._context = paramContext;
    this._modeInCall = paramInt;
    this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
    IRingtonePlayer localIRingtonePlayer = ViberApplication.getInstance().getRingtonePlayer();
    this._btControl = new BtControl(this._audioManager, this._context, this);
    localIRingtonePlayer.setBtControl(this._btControl);
    this._audioFocusControl = new AudioFocusManager(this._context);
    HeadphonePlugStateListener localHeadphonePlugStateListener = new HeadphonePlugStateListener();
    this._context.registerReceiver(localHeadphonePlugStateListener, new IntentFilter("android.intent.action.HEADSET_PLUG"));
    this._isSpeakerOn = isSpeakerphoneOn();
    WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(true);
    if (paramBoolean)
      WebRtcAudioUtils.setDefaultSampleRateHz(16000);
  }

  private String _getCallerMethodName()
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    if (arrayOfStackTraceElement.length < 5)
      return "";
    return arrayOfStackTraceElement[4].getClassName() + "." + arrayOfStackTraceElement[4].getMethodName();
  }

  private static String getModeName(int paramInt)
  {
    if (-1 == paramInt)
      return "MODE_CURRENT";
    if (2 == paramInt)
      return "MODE_IN_CALL";
    if (-2 == paramInt)
      return "MODE_INVALID";
    if (paramInt == 0)
      return "MODE_NORMAL";
    if (1 == paramInt)
      return "MODE_RINGTONE";
    if (3 == paramInt)
      return "MODE_IN_COMMUNICATION";
    return "unknown";
  }

  private void notifyHeadphonesConnectionChange(boolean paramBoolean)
  {
    HashMap localHashMap;
    synchronized (this._speakerStateListeners)
    {
      localHashMap = new HashMap(this._speakerStateListeners);
      Iterator localIterator = localHashMap.entrySet().iterator();
      if (localIterator.hasNext())
        ((ISoundService.SpeakerStateListener)((Map.Entry)localIterator.next()).getKey()).onHeadphonesConnected(paramBoolean);
    }
    localHashMap.clear();
  }

  private void notifySpeakerStateChange(boolean paramBoolean1, boolean paramBoolean2)
  {
    HashMap localHashMap;
    while (true)
    {
      Map.Entry localEntry;
      synchronized (this._speakerStateListeners)
      {
        localHashMap = new HashMap(this._speakerStateListeners);
        Iterator localIterator = localHashMap.entrySet().iterator();
        if (!localIterator.hasNext())
          break;
        localEntry = (Map.Entry)localIterator.next();
        if (paramBoolean2)
          ((ISoundService.SpeakerStateListener)localEntry.getKey()).onSpeakerStatePreChanged(paramBoolean1);
      }
      ((ISoundService.SpeakerStateListener)localEntry.getKey()).onSpeakerStateChanged(paramBoolean1);
    }
    localHashMap.clear();
  }

  private void notifySpeakerStatePostChange(boolean paramBoolean)
  {
    notifySpeakerStateChange(paramBoolean, false);
  }

  private void notifySpeakerStatePreChange(boolean paramBoolean)
  {
    notifySpeakerStateChange(paramBoolean, true);
  }

  private void processPhoneStateChanged(int paramInt)
  {
    switch (paramInt)
    {
    case 1:
    case 2:
    case 4:
    case 7:
    default:
      return;
    case 5:
      if (!this._btControl.isHeadsetConnected())
      {
        setSpeakerphoneOn(true);
        this._oldSpeakerState = this._audioManager.isSpeakerphoneOn();
        this._shouldRestoreSpeaker = true;
      }
      prepareCallAudioRoute();
      this._audioFocusControl.requestAudioFocus(this._audioFocusListener, 0, 2);
      return;
    case 6:
      prepareCallAudioRoute();
      this._audioFocusControl.requestAudioFocus(this._audioFocusListener, 0, 2);
      return;
    case 3:
      if (this._shouldRestoreSpeaker)
      {
        this._shouldRestoreSpeaker = false;
        setSpeakerphoneOn(this._oldSpeakerState);
      }
      this.mInViberCall = true;
      return;
    case 8:
      this.mInViberCall = false;
      return;
    case 0:
    }
    this.mInViberCall = false;
    this._shouldRestoreSpeaker = false;
    cleanupAudioRoute();
    this._audioFocusControl.abandonAudioFocus();
  }

  private void updateAudioRoute()
  {
    if (this.mRouteUsage == RouteUsage.None);
    do
    {
      return;
      if (((this.mRouteUsage == RouteUsage.Ptt) || (this.mRouteUsage == RouteUsage.VideoPtt)) && (this._btControl.isHeadsetConnected()))
      {
        if (this.mUserWantsSpeaker)
        {
          this._btControl.enableBluetoothRoute();
          setMode(mode_bluetooth());
          return;
        }
        setMode(mode_default());
        this._btControl.disableBluetoothRoute();
        return;
      }
      if (isSpeakerphoneOn() != this.mUserWantsSpeaker)
        break;
      notifySpeakerStatePreChange(this.mUserWantsSpeaker);
      notifySpeakerStatePostChange(this.mUserWantsSpeaker);
    }
    while ((this.mUserWantsSpeaker) || (!this._btControl.isHeadsetConnected()));
    this._btControl.enableBluetoothRoute();
    return;
    notifySpeakerStatePreChange(this.mUserWantsSpeaker);
    if ((this.mUserWantsSpeaker) && (this._btControl.isHeadsetConnected()))
      this._btControl.disableBluetoothRoute();
    this._audioManager.setSpeakerphoneOn(this.mUserWantsSpeaker);
    if ((!this.mUserWantsSpeaker) && (this._btControl.isHeadsetConnected()))
      this._btControl.enableBluetoothRoute();
    this._isSpeakerOn = isSpeakerphoneOn();
    notifySpeakerStatePostChange(isSpeakerphoneOn());
  }

  public void cleanupAudioRoute()
  {
    if (this.mInGSMCall);
    while (this.mRouteUsage == RouteUsage.None)
      return;
    this.mRouteUsage = RouteUsage.None;
    this._speakerStateBeforeHeadsetIsPlugged = false;
    this.mUserWantsSpeaker = false;
    this._audioManager.setSpeakerphoneOn(false);
    this._btControl.disableBluetoothRoute();
    setMode(mode_default());
  }

  public BtControl getBluetoothCtl()
  {
    return this._btControl;
  }

  public Context getContext()
  {
    return this._context;
  }

  public Handler getHandler()
  {
    return _handler;
  }

  public AudioManager getPlatformAudioManager()
  {
    return this._audioManager;
  }

  public SoundConfig getSoundConfig()
  {
    return this._soundConfig;
  }

  public boolean isBluetoothOn()
  {
    return (this._btControl.isScoOn()) || (this._btControl.isA2dpOn());
  }

  public boolean isGSMCallActive()
  {
    return this.mInGSMCall;
  }

  public boolean isHeadsetPluggedIn()
  {
    return this.mWiredHeadphonesConnected;
  }

  public boolean isRTCCallActive()
  {
    CallHandler localCallHandler = ViberApplication.getInstance().getEngine(false).getCallHandler();
    boolean bool;
    if (localCallHandler.getRTCCall() == null)
    {
      ConferenceCall localConferenceCall = localCallHandler.getCurrentConferenceCall();
      bool = false;
      if (localConferenceCall == null);
    }
    else
    {
      bool = true;
    }
    return bool;
  }

  public boolean isSpeakerphoneOn()
  {
    return this._audioManager.isSpeakerphoneOn();
  }

  public boolean isUserWantsSpeaker()
  {
    return this.mUserWantsSpeaker;
  }

  public boolean isViberCallActive()
  {
    return this.mInViberCall;
  }

  public int mode_InCall()
  {
    return this._modeInCall;
  }

  public int mode_bluetooth()
  {
    return 3;
  }

  public int mode_default()
  {
    return 0;
  }

  public void onCallEnded(long paramLong, boolean paramBoolean, String paramString, int paramInt1, int paramInt2)
  {
    if (_handler != null)
      _handler.post(new Runnable()
      {
        public void run()
        {
          GenericSoundService.access$802(GenericSoundService.this, false);
          GenericSoundService.this.cleanupAudioRoute();
        }
      });
  }

  public void onCallStarted(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (_handler != null)
      _handler.post(new Runnable()
      {
        public void run()
        {
          GenericSoundService.this.setMode(GenericSoundService.this.mode_InCall());
          GenericSoundService.access$802(GenericSoundService.this, true);
          if (!GenericSoundService.this.isSpeakerphoneOn())
            GenericSoundService.this._btControl.enableBluetoothRoute();
        }
      });
  }

  public void onDeviceConnected(BluetoothDevice paramBluetoothDevice)
  {
    if (this.mInViberCall)
      this._btControl.enableBluetoothRoute();
  }

  public void onDeviceDisconnected(BluetoothDevice paramBluetoothDevice)
  {
    if (!this._btControl.isHeadsetConnected())
      this._btControl.disableBluetoothRoute();
  }

  public void onError(BluetoothDevice paramBluetoothDevice)
  {
    onDeviceDisconnected(paramBluetoothDevice);
  }

  public void onGSMStateChange(int paramInt, String paramString)
  {
    CallInfo localCallInfo = ViberApplication.getInstance().getEngine(false).getCurrentCall();
    if ((localCallInfo == null) || (!localCallInfo.isConference()) || (!localCallInfo.isCallInProgress()));
    do
    {
      return;
      switch (paramInt)
      {
      default:
        return;
      case 0:
        this.mInGSMCall = false;
        _handler.postDelayed(new Runnable()
        {
          public void run()
          {
            if (!GenericSoundService.this._isSpeakerOn)
              GenericSoundService.this._btControl.enableBluetoothRoute();
            GenericSoundService.this.setSpeakerphoneOn(GenericSoundService.this._isSpeakerOn);
          }
        }
        , 300L);
        return;
      case 1:
      }
    }
    while (this.mInGSMCall);
    this.mInGSMCall = true;
    _handler.post(new Runnable()
    {
      public void run()
      {
        GenericSoundService.this._btControl.disableBluetoothRoute();
      }
    });
  }

  public void onHangup()
  {
  }

  public void onPhoneStateChanged(final int paramInt)
  {
    _handler.post(new Runnable()
    {
      public void run()
      {
        GenericSoundService.this.processPhoneStateChanged(paramInt);
      }
    });
  }

  public void prepareCallAudioRoute()
  {
    if (this.mInGSMCall)
      return;
    this.mRouteUsage = RouteUsage.Call;
    updateAudioRoute();
  }

  public void preparePttAudioRoute()
  {
    if (this.mInGSMCall)
      return;
    this.mRouteUsage = RouteUsage.Ptt;
    this.mUserWantsSpeaker = true;
    updateAudioRoute();
  }

  public void prepareVideoPttAudioRoute()
  {
    if (this.mInGSMCall)
      return;
    this.mRouteUsage = RouteUsage.VideoPtt;
    if (!this._audioManager.isWiredHeadsetOn());
    for (boolean bool = true; ; bool = false)
    {
      this.mUserWantsSpeaker = bool;
      updateAudioRoute();
      return;
    }
  }

  public void registerSpeakerStateListener(ISoundService.SpeakerStateListener paramSpeakerStateListener)
  {
    this._speakerStateListeners.put(paramSpeakerStateListener, null);
  }

  public void setMode(int paramInt)
  {
    if (this.mInGSMCall);
    while (true)
    {
      return;
      try
      {
        if (this._audioManager.getMode() != paramInt)
        {
          this._audioManager.setMode(paramInt);
          return;
        }
      }
      catch (Exception localException)
      {
      }
    }
  }

  public void setSpeakerphoneOn(boolean paramBoolean)
  {
    this.mUserWantsSpeaker = paramBoolean;
    updateAudioRoute();
  }

  class HeadphonePlugStateListener extends BroadcastReceiver
  {
    HeadphonePlugStateListener()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      boolean bool = true;
      if (!"android.intent.action.HEADSET_PLUG".equals(paramIntent.getAction()))
        return;
      int i = paramIntent.getIntExtra("state", 0);
      GenericSoundService localGenericSoundService;
      if (i != 0)
      {
        GenericSoundService.access$002(GenericSoundService.this, bool);
        GenericSoundService.access$102(GenericSoundService.this, GenericSoundService.this.isSpeakerphoneOn());
        GenericSoundService.access$202(GenericSoundService.this, false);
        GenericSoundService.this.updateAudioRoute();
        localGenericSoundService = GenericSoundService.this;
        if (i == 0)
          break label140;
      }
      while (true)
      {
        localGenericSoundService.notifyHeadphonesConnectionChange(bool);
        return;
        GenericSoundService.access$002(GenericSoundService.this, false);
        if (GenericSoundService.this._speakerStateBeforeHeadsetIsPlugged)
          GenericSoundService.access$202(GenericSoundService.this, GenericSoundService.this._speakerStateBeforeHeadsetIsPlugged);
        GenericSoundService.access$102(GenericSoundService.this, false);
        GenericSoundService.this.updateAudioRoute();
        break;
        label140: bool = false;
      }
    }
  }

  static enum RouteUsage
  {
    static
    {
      None = new RouteUsage("None", 3);
      RouteUsage[] arrayOfRouteUsage = new RouteUsage[4];
      arrayOfRouteUsage[0] = Call;
      arrayOfRouteUsage[1] = Ptt;
      arrayOfRouteUsage[2] = VideoPtt;
      arrayOfRouteUsage[3] = None;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.GenericSoundService
 * JD-Core Version:    0.6.2
 */