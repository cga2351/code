package org.webrtc.voiceengine;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.media.AudioFormat.Builder;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.AudioEffect;
import android.media.audiofx.AudioEffect.Descriptor;
import android.media.audiofx.AudioEffect.OnControlStatusChangeListener;
import android.media.audiofx.AudioEffect.OnEnableStatusChangeListener;
import android.media.audiofx.AutomaticGainControl;
import android.media.audiofx.NoiseSuppressor;
import android.os.Build;
import android.os.Build.VERSION;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.sound.ISoundService;
import com.viber.voip.sound.SoundFactory;
import com.viber.voip.sound.bluetooth.BtControl;
import com.viber.voip.sound.config.SoundConfig;
import java.lang.reflect.Constructor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

class AudioDeviceAndroid
  implements IAudioDevice
{
  private static final Set<String> ACOUSTIC_ECHO_CANCELER_BLACKLIST;
  private static final Set<String> AUTOMATIC_GAIN_CONTROL_BLACKLIST;
  public static final int FALLBACK_REC_AUDIOSOURCE = 1;
  public static final int FLAG_AUDIOPLAYBACK_STARTED = 8;
  public static final int FLAG_AUDIORECORD_INITIALIZED = 1;
  public static final int FLAG_AUDIORECORD_STARTED = 4;
  public static final int FLAG_AUDIOTRACK_INITIALIZED = 2;
  public static final int FLAG_INACTIVE = 0;
  public static final int FLAG_VE_STARTED = 16;
  private static final Logger L = ViberEnv.getLogger();
  private static final Set<String> NOISE_SUPPRESSOR_BLACKLIST;
  private static final boolean RESPECT_AUDIO_ATTRIBUTES_ON_API21_AND_HIGHER = true;
  private static final UUID SOFTWARE_ACOUSTIC_ECHO_CANCELER_UUID;
  private static final UUID SOFTWARE_AUTOMATIC_GAIN_CONTROL_UUID;
  private static final Set<String> SOFTWARE_EFFECTS_BLACKLIST;
  private static final UUID SOFTWARE_NOISE_SUPPRESSOR_UUID;
  public static final int[] audioSources = { 7, 1, 0, 5 };
  private ISoundService _audioManager;
  private AudioRecord _audioRecord = null;
  private volatile int _audioRoute = 0;
  private int _audioSource = 0;
  private AudioTrack _audioTrack = null;
  private int _bufferedPlaySamples = 0;
  private int _bufferedRecSamples = 0;
  private Context _context;
  private boolean _doPlayInit = true;
  private boolean _doRecInit = true;
  private boolean _isPlaying = false;
  private boolean _isRecording = false;
  private ByteBuffer _playBuffer = ByteBuffer.allocateDirect(this._tempBufPlay.length);
  private final ReentrantLock _playLock = new ReentrantLock();
  private int _playPosition = 0;
  private int _playbackStream = 0;
  private ByteBuffer _recBuffer = ByteBuffer.allocateDirect(this._tempBufRec.length);
  private final ReentrantLock _recLock = new ReentrantLock();
  private byte[] _tempBufPlay = null;
  private byte[] _tempBufRec = null;
  private Object aecFilter = null;
  private Object agcFilter = null;
  private volatile int flags = 0;
  private Set<IAudioDevice.AudioDeviceStateListener> listeners = Collections.synchronizedSet(new HashSet());
  private Object nsFilter = null;

  static
  {
    SOFTWARE_NOISE_SUPPRESSOR_UUID = UUID.fromString("c06c8400-8e06-11e0-9cb6-0002a5d5c51b");
    SOFTWARE_ACOUSTIC_ECHO_CANCELER_UUID = UUID.fromString("bb392ec0-8d4d-11e0-a896-0002a5d5c51b");
    SOFTWARE_AUTOMATIC_GAIN_CONTROL_UUID = UUID.fromString("aa8130e0-66fc-11e0-bad0-0002a5d5c51b");
    NOISE_SUPPRESSOR_BLACKLIST = new HashSet();
    ACOUSTIC_ECHO_CANCELER_BLACKLIST = new HashSet();
    AUTOMATIC_GAIN_CONTROL_BLACKLIST = new HashSet();
    SOFTWARE_EFFECTS_BLACKLIST = new HashSet();
    SOFTWARE_EFFECTS_BLACKLIST.add("GT-P7510");
  }

  AudioDeviceAndroid()
  {
    this(SoundFactory.getSoundService(ViberApplication.getApplication()));
    this._context = this._audioManager.getContext();
  }

  public AudioDeviceAndroid(ISoundService paramISoundService)
  {
    this(paramISoundService, 44100);
  }

  public AudioDeviceAndroid(ISoundService paramISoundService, int paramInt)
  {
    this._audioManager = paramISoundService;
    AudioDeviceManager.registerAudioDevice(this);
  }

  private int GetBufferedPlaySamplesCount()
  {
    return this._bufferedPlaySamples;
  }

  private int InitPlayback(int paramInt)
  {
    return InitPlaybackWithOwnBuffers(paramInt, this._tempBufPlay, this._playBuffer);
  }

  private int InitRecording(int paramInt1, int paramInt2)
  {
    return InitRecordingWithOwnBuffers(paramInt1, paramInt2, this._tempBufRec, this._recBuffer);
  }

  // ERROR //
  private int PlayAudio(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 164	org/webrtc/voiceengine/AudioDeviceAndroid:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual 238	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   7: aload_0
    //   8: getfield 153	org/webrtc/voiceengine/AudioDeviceAndroid:_audioTrack	Landroid/media/AudioTrack;
    //   11: astore_3
    //   12: aload_3
    //   13: ifnonnull +13 -> 26
    //   16: aload_0
    //   17: getfield 164	org/webrtc/voiceengine/AudioDeviceAndroid:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   20: invokevirtual 241	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   23: bipush 254
    //   25: ireturn
    //   26: aload_0
    //   27: getfield 168	org/webrtc/voiceengine/AudioDeviceAndroid:_doPlayInit	Z
    //   30: iconst_1
    //   31: if_icmpne +26 -> 57
    //   34: aload_0
    //   35: invokespecial 245	org/webrtc/voiceengine/AudioDeviceAndroid:sound_io_use_high_priority_media_thread	()Z
    //   38: istore 10
    //   40: iload 10
    //   42: ifeq +10 -> 52
    //   45: aload_0
    //   46: invokespecial 248	org/webrtc/voiceengine/AudioDeviceAndroid:sound_io_media_thread_priority	()I
    //   49: invokestatic 254	android/os/Process:setThreadPriority	(I)V
    //   52: aload_0
    //   53: iconst_0
    //   54: putfield 168	org/webrtc/voiceengine/AudioDeviceAndroid:_doPlayInit	Z
    //   57: aload_0
    //   58: getfield 210	org/webrtc/voiceengine/AudioDeviceAndroid:_playBuffer	Ljava/nio/ByteBuffer;
    //   61: aload_0
    //   62: getfield 157	org/webrtc/voiceengine/AudioDeviceAndroid:_tempBufPlay	[B
    //   65: invokevirtual 258	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   68: pop
    //   69: aload_0
    //   70: getfield 153	org/webrtc/voiceengine/AudioDeviceAndroid:_audioTrack	Landroid/media/AudioTrack;
    //   73: aload_0
    //   74: getfield 157	org/webrtc/voiceengine/AudioDeviceAndroid:_tempBufPlay	[B
    //   77: iconst_0
    //   78: iload_1
    //   79: invokevirtual 264	android/media/AudioTrack:write	([BII)I
    //   82: istore 5
    //   84: aload_0
    //   85: getfield 210	org/webrtc/voiceengine/AudioDeviceAndroid:_playBuffer	Ljava/nio/ByteBuffer;
    //   88: invokevirtual 268	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   91: pop
    //   92: aload_0
    //   93: aload_0
    //   94: getfield 180	org/webrtc/voiceengine/AudioDeviceAndroid:_bufferedPlaySamples	I
    //   97: iload 5
    //   99: iconst_1
    //   100: ishr
    //   101: iadd
    //   102: putfield 180	org/webrtc/voiceengine/AudioDeviceAndroid:_bufferedPlaySamples	I
    //   105: aload_0
    //   106: getfield 153	org/webrtc/voiceengine/AudioDeviceAndroid:_audioTrack	Landroid/media/AudioTrack;
    //   109: invokevirtual 271	android/media/AudioTrack:getPlaybackHeadPosition	()I
    //   112: istore 7
    //   114: iload 7
    //   116: aload_0
    //   117: getfield 182	org/webrtc/voiceengine/AudioDeviceAndroid:_playPosition	I
    //   120: if_icmpge +8 -> 128
    //   123: aload_0
    //   124: iconst_0
    //   125: putfield 182	org/webrtc/voiceengine/AudioDeviceAndroid:_playPosition	I
    //   128: aload_0
    //   129: aload_0
    //   130: getfield 180	org/webrtc/voiceengine/AudioDeviceAndroid:_bufferedPlaySamples	I
    //   133: iload 7
    //   135: aload_0
    //   136: getfield 182	org/webrtc/voiceengine/AudioDeviceAndroid:_playPosition	I
    //   139: isub
    //   140: isub
    //   141: putfield 180	org/webrtc/voiceengine/AudioDeviceAndroid:_bufferedPlaySamples	I
    //   144: aload_0
    //   145: iload 7
    //   147: putfield 182	org/webrtc/voiceengine/AudioDeviceAndroid:_playPosition	I
    //   150: aload_0
    //   151: getfield 172	org/webrtc/voiceengine/AudioDeviceAndroid:_isRecording	Z
    //   154: istore 8
    //   156: iconst_0
    //   157: istore 9
    //   159: iload 8
    //   161: ifne +9 -> 170
    //   164: aload_0
    //   165: getfield 180	org/webrtc/voiceengine/AudioDeviceAndroid:_bufferedPlaySamples	I
    //   168: istore 9
    //   170: iload 5
    //   172: iload_1
    //   173: if_icmpeq +12 -> 185
    //   176: aload_0
    //   177: getfield 164	org/webrtc/voiceengine/AudioDeviceAndroid:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   180: invokevirtual 241	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   183: iconst_m1
    //   184: ireturn
    //   185: aload_0
    //   186: getfield 164	org/webrtc/voiceengine/AudioDeviceAndroid:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   189: invokevirtual 241	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   192: iload 9
    //   194: ireturn
    //   195: astore_2
    //   196: aload_0
    //   197: getfield 164	org/webrtc/voiceengine/AudioDeviceAndroid:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   200: invokevirtual 241	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   203: aload_2
    //   204: athrow
    //   205: astore 11
    //   207: goto -155 -> 52
    //
    // Exception table:
    //   from	to	target	type
    //   7	12	195	finally
    //   26	40	195	finally
    //   45	52	195	finally
    //   52	57	195	finally
    //   57	128	195	finally
    //   128	156	195	finally
    //   164	170	195	finally
    //   45	52	205	java/lang/Exception
  }

  // ERROR //
  private int RecordAudio(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 166	org/webrtc/voiceengine/AudioDeviceAndroid:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual 238	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   7: aload_0
    //   8: getfield 155	org/webrtc/voiceengine/AudioDeviceAndroid:_audioRecord	Landroid/media/AudioRecord;
    //   11: astore 4
    //   13: aload 4
    //   15: ifnonnull +13 -> 28
    //   18: aload_0
    //   19: getfield 166	org/webrtc/voiceengine/AudioDeviceAndroid:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   22: invokevirtual 241	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   25: bipush 254
    //   27: ireturn
    //   28: aload_0
    //   29: getfield 170	org/webrtc/voiceengine/AudioDeviceAndroid:_doRecInit	Z
    //   32: iconst_1
    //   33: if_icmpne +26 -> 59
    //   36: aload_0
    //   37: invokespecial 245	org/webrtc/voiceengine/AudioDeviceAndroid:sound_io_use_high_priority_media_thread	()Z
    //   40: istore 8
    //   42: iload 8
    //   44: ifeq +10 -> 54
    //   47: aload_0
    //   48: invokespecial 248	org/webrtc/voiceengine/AudioDeviceAndroid:sound_io_media_thread_priority	()I
    //   51: invokestatic 254	android/os/Process:setThreadPriority	(I)V
    //   54: aload_0
    //   55: iconst_0
    //   56: putfield 170	org/webrtc/voiceengine/AudioDeviceAndroid:_doRecInit	Z
    //   59: aload_0
    //   60: getfield 212	org/webrtc/voiceengine/AudioDeviceAndroid:_recBuffer	Ljava/nio/ByteBuffer;
    //   63: invokevirtual 268	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   66: pop
    //   67: aload_0
    //   68: getfield 155	org/webrtc/voiceengine/AudioDeviceAndroid:_audioRecord	Landroid/media/AudioRecord;
    //   71: aload_0
    //   72: getfield 159	org/webrtc/voiceengine/AudioDeviceAndroid:_tempBufRec	[B
    //   75: iconst_0
    //   76: iload_1
    //   77: invokevirtual 277	android/media/AudioRecord:read	([BII)I
    //   80: istore 6
    //   82: aload_0
    //   83: getfield 212	org/webrtc/voiceengine/AudioDeviceAndroid:_recBuffer	Ljava/nio/ByteBuffer;
    //   86: aload_0
    //   87: getfield 159	org/webrtc/voiceengine/AudioDeviceAndroid:_tempBufRec	[B
    //   90: iconst_0
    //   91: iload 6
    //   93: invokevirtual 281	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   96: pop
    //   97: aload_0
    //   98: getfield 166	org/webrtc/voiceengine/AudioDeviceAndroid:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   101: invokevirtual 241	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   104: aload_0
    //   105: getfield 180	org/webrtc/voiceengine/AudioDeviceAndroid:_bufferedPlaySamples	I
    //   108: ireturn
    //   109: astore_3
    //   110: aload_0
    //   111: getfield 166	org/webrtc/voiceengine/AudioDeviceAndroid:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   114: invokevirtual 241	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   117: goto -13 -> 104
    //   120: astore_2
    //   121: aload_0
    //   122: getfield 166	org/webrtc/voiceengine/AudioDeviceAndroid:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   125: invokevirtual 241	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   128: aload_2
    //   129: athrow
    //   130: astore 9
    //   132: goto -78 -> 54
    //
    // Exception table:
    //   from	to	target	type
    //   7	13	109	java/lang/Exception
    //   28	42	109	java/lang/Exception
    //   54	59	109	java/lang/Exception
    //   59	97	109	java/lang/Exception
    //   7	13	120	finally
    //   28	42	120	finally
    //   47	54	120	finally
    //   54	59	120	finally
    //   59	97	120	finally
    //   47	54	130	java/lang/Exception
  }

  private int SetPlayoutSpeakerInternal(boolean paramBoolean)
  {
    if (paramBoolean)
      this._audioManager.getBluetoothCtl().disableBluetoothRoute();
    this._audioManager.getPlatformAudioManager().setSpeakerphoneOn(paramBoolean);
    if (!paramBoolean)
      this._audioManager.getBluetoothCtl().enableBluetoothRoute();
    return 0;
  }

  private String _getCallerMethodName()
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    if (arrayOfStackTraceElement.length < 5)
      return "";
    return arrayOfStackTraceElement[4].getClassName() + "." + arrayOfStackTraceElement[4].getMethodName();
  }

  @TargetApi(21)
  private AudioTrack createAudioTrackApi21(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    AudioAttributes.Builder localBuilder = new AudioAttributes.Builder();
    localBuilder.setLegacyStreamType(paramInt2);
    AudioAttributes localAudioAttributes = localBuilder.build();
    AudioFormat.Builder localBuilder1 = new AudioFormat.Builder();
    localBuilder1.setChannelMask(paramInt4);
    localBuilder1.setEncoding(2);
    localBuilder1.setSampleRate(paramInt3);
    return new AudioTrack(localAudioAttributes, localBuilder1.build(), paramInt6, paramInt7, 0);
  }

  @TargetApi(16)
  private static boolean disableEffectForAudioRecordSession(Object paramObject)
  {
    if (paramObject != null)
      try
      {
        if ((paramObject instanceof AudioEffect))
        {
          ((AudioEffect)paramObject).setEnabled(false);
          ((AudioEffect)paramObject).release();
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        return false;
      }
    return false;
  }

  @TargetApi(16)
  private static Object enableEffectForAudioRecordSession(AudioRecord paramAudioRecord, EffectFactory paramEffectFactory)
  {
    if ((paramAudioRecord == null) || (paramEffectFactory == null))
      return null;
    return enableEffectForAudioRecordSessionId(paramAudioRecord.getAudioSessionId(), paramEffectFactory);
  }

  @TargetApi(16)
  private static Object enableEffectForAudioRecordSessionId(int paramInt, EffectFactory paramEffectFactory)
  {
    try
    {
      if (paramEffectFactory.isBlacklisted())
        return null;
      AudioEffect localAudioEffect = paramEffectFactory.create(paramInt);
      if (localAudioEffect != null)
      {
        localAudioEffect.setEnableStatusListener(new AudioEffect.OnEnableStatusChangeListener()
        {
          public void onEnableStatusChange(AudioEffect paramAnonymousAudioEffect, boolean paramAnonymousBoolean)
          {
          }
        });
        localAudioEffect.setControlStatusListener(new AudioEffect.OnControlStatusChangeListener()
        {
          public void onControlStatusChange(AudioEffect paramAnonymousAudioEffect, boolean paramAnonymousBoolean)
          {
          }
        });
        localAudioEffect.setEnabled(true);
        return localAudioEffect;
      }
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  // ERROR //
  private static int getRecAudioSourceForNativeSourceInternal(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 82	org/webrtc/voiceengine/AudioDeviceAndroid:audioSources	[I
    //   8: iload_0
    //   9: iaload
    //   10: istore 5
    //   12: bipush 7
    //   14: iload 5
    //   16: if_icmpne +33 -> 49
    //   19: iload 5
    //   21: iload_1
    //   22: invokestatic 428	org/webrtc/voiceengine/NativeADMDelegate:isVoiceCommRouteAvailable	(II)I
    //   25: istore 6
    //   27: iload 6
    //   29: ifeq +20 -> 49
    //   32: ldc 2
    //   34: monitorexit
    //   35: iload_2
    //   36: ireturn
    //   37: astore 4
    //   39: ldc 2
    //   41: monitorexit
    //   42: aload 4
    //   44: athrow
    //   45: astore_3
    //   46: goto -14 -> 32
    //   49: iload 5
    //   51: istore_2
    //   52: goto -20 -> 32
    //
    // Exception table:
    //   from	to	target	type
    //   5	12	37	finally
    //   19	27	37	finally
    //   5	12	45	java/lang/Exception
    //   19	27	45	java/lang/Exception
  }

  private void processOnCapturePostStartEvent()
  {
    if (4 == (0x4 & this.flags));
    while (true)
    {
      return;
      setFlagsInternal(4);
      Iterator localIterator = this.listeners.iterator();
      while (localIterator.hasNext())
        ((IAudioDevice.AudioDeviceStateListener)localIterator.next()).onCapturePostStart();
    }
  }

  private void processOnCaptureStartEvent()
  {
    if (1 == (0x1 & this.flags));
    while (true)
    {
      return;
      setFlagsInternal(1);
      Iterator localIterator = this.listeners.iterator();
      while (localIterator.hasNext())
        ((IAudioDevice.AudioDeviceStateListener)localIterator.next()).onCaptureStart();
    }
  }

  private void processOnCaptureStopEvent()
  {
    if (1 != (0x1 & this.flags));
    while (true)
    {
      return;
      clearFlagsInternal(1);
      clearFlagsInternal(4);
      Iterator localIterator = this.listeners.iterator();
      while (localIterator.hasNext())
        ((IAudioDevice.AudioDeviceStateListener)localIterator.next()).onCaptureStop();
    }
  }

  private void processOnOverallStartEvent(int paramInt)
  {
    if (16 == (0x10 & this.flags))
      return;
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
      ((IAudioDevice.AudioDeviceStateListener)localIterator.next()).onStart(paramInt);
    setFlagsInternal(16);
  }

  private void processOnOverallStopEvent(int paramInt)
  {
    if (16 != (0x10 & this.flags))
      return;
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
      ((IAudioDevice.AudioDeviceStateListener)localIterator.next()).onStop(paramInt);
    clearFlagsInternal(16);
  }

  private void processOnPlaybackPostStartEvent()
  {
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
      ((IAudioDevice.AudioDeviceStateListener)localIterator.next()).onPlaybackPostStart();
  }

  private void processOnPlaybackPostStopEvent(int paramInt)
  {
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
      ((IAudioDevice.AudioDeviceStateListener)localIterator.next()).onPlaybackPostStop(paramInt);
  }

  private void processOnPlaybackPreStartEvent(int paramInt)
  {
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
      ((IAudioDevice.AudioDeviceStateListener)localIterator.next()).onPlaybackPreStart(paramInt);
  }

  private void processOnPlaybackPreStopEvent()
  {
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
      ((IAudioDevice.AudioDeviceStateListener)localIterator.next()).onPlaybackPreStop();
  }

  private boolean respectAudioAttributes()
  {
    return 21 <= Build.VERSION.SDK_INT;
  }

  private void setFlagsInternal(int paramInt)
  {
    this.flags = (paramInt | this.flags);
  }

  private int sound_io_media_thread_priority()
  {
    return this._audioManager.getSoundConfig().getMediaThreadPriority();
  }

  private boolean sound_io_use_high_priority_media_thread()
  {
    return this._audioManager.getSoundConfig().useThreadPriorityBoost();
  }

  public int CheckDeviceVoiceCommunicationAbility(int paramInt1, int paramInt2)
  {
    return NativeADMDelegate.isVoiceCommRouteAvailable(paramInt1, paramInt2);
  }

  public int GetAudioRoute()
  {
    return this._audioRoute;
  }

  public int GetPlayoutVolume()
  {
    return 0;
  }

  public int InitPlaybackWithOwnBuffers(int paramInt, byte[] paramArrayOfByte, ByteBuffer paramByteBuffer)
  {
    int i = 4;
    if (2 == this._audioRoute)
      return -1;
    int j = AudioTrack.getMinBufferSize(paramInt, i, 2);
    if (-2 == j)
    {
      j = AudioTrack.getMinBufferSize(paramInt, 2, 2);
      i = 2;
    }
    if (j < 6000)
      j <<= 1;
    if (paramArrayOfByte == null)
    {
      this._tempBufPlay = new byte[j];
      if (paramByteBuffer != null)
        break label126;
    }
    label126: for (this._playBuffer = ByteBuffer.allocateDirect(this._tempBufPlay.length); ; this._playBuffer = paramByteBuffer)
    {
      if (this._playBuffer != null)
      {
        this._playBuffer.order(ByteOrder.nativeOrder());
        this._playBuffer.position(0);
      }
      if (this._audioTrack == null)
        break label134;
      return 0;
      this._tempBufPlay = paramArrayOfByte;
      break;
    }
    label134: if (((1 == this._audioRoute) || (3 == this._audioRoute)) && (this._audioManager.getBluetoothCtl().isHeadsetConnected()) && (!this._audioManager.getPlatformAudioManager().isBluetoothA2dpOn()))
      this._playbackStream = 0;
    try
    {
      if (respectAudioAttributes())
      {
        this._audioTrack = createAudioTrackApi21(this._audioRoute, this._playbackStream, paramInt, i, 2, j, 1);
        if (this._audioTrack == null)
          throw new NullPointerException("AudioTrack failed to be initialized for sampleRate=" + paramInt + ", stream=" + this._playbackStream + ", plyBufSz=" + j);
      }
    }
    catch (Throwable localThrowable)
    {
      while (this._audioTrack == null)
      {
        return -1;
        this._audioTrack = new AudioTrack(this._playbackStream, paramInt, i, 2, j, 1);
      }
      if (this._audioTrack.getState() != 1)
      {
        this._audioTrack.release();
        this._audioTrack = null;
        return -1;
      }
      setFlagsInternal(2);
    }
    return 0;
  }

  // ERROR //
  public int InitRecordingWithOwnBuffers(int paramInt1, int paramInt2, byte[] paramArrayOfByte, ByteBuffer paramByteBuffer)
  {
    // Byte code:
    //   0: iconst_1
    //   1: aload_0
    //   2: getfield 184	org/webrtc/voiceengine/AudioDeviceAndroid:_audioRoute	I
    //   5: if_icmpne +5 -> 10
    //   8: iconst_m1
    //   9: ireturn
    //   10: aload_0
    //   11: iload_1
    //   12: putfield 176	org/webrtc/voiceengine/AudioDeviceAndroid:_audioSource	I
    //   15: iload_2
    //   16: bipush 16
    //   18: iconst_2
    //   19: invokestatic 556	android/media/AudioRecord:getMinBufferSize	(III)I
    //   22: istore 5
    //   24: aload_3
    //   25: ifnonnull +207 -> 232
    //   28: aload_0
    //   29: getfield 159	org/webrtc/voiceengine/AudioDeviceAndroid:_tempBufRec	[B
    //   32: ifnonnull +39 -> 71
    //   35: bipush 254
    //   37: iload 5
    //   39: if_icmpne +11 -> 50
    //   42: iload_2
    //   43: iconst_2
    //   44: iconst_2
    //   45: invokestatic 556	android/media/AudioRecord:getMinBufferSize	(III)I
    //   48: istore 5
    //   50: bipush 254
    //   52: iload 5
    //   54: if_icmpeq +17 -> 71
    //   57: iload 5
    //   59: iconst_1
    //   60: ishl
    //   61: istore 5
    //   63: aload_0
    //   64: iload 5
    //   66: newarray byte
    //   68: putfield 159	org/webrtc/voiceengine/AudioDeviceAndroid:_tempBufRec	[B
    //   71: aload 4
    //   73: ifnonnull +167 -> 240
    //   76: aload_0
    //   77: aload_0
    //   78: getfield 159	org/webrtc/voiceengine/AudioDeviceAndroid:_tempBufRec	[B
    //   81: arraylength
    //   82: invokestatic 208	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   85: putfield 212	org/webrtc/voiceengine/AudioDeviceAndroid:_recBuffer	Ljava/nio/ByteBuffer;
    //   88: aload_0
    //   89: getfield 212	org/webrtc/voiceengine/AudioDeviceAndroid:_recBuffer	Ljava/nio/ByteBuffer;
    //   92: ifnull +23 -> 115
    //   95: aload_0
    //   96: getfield 212	org/webrtc/voiceengine/AudioDeviceAndroid:_recBuffer	Ljava/nio/ByteBuffer;
    //   99: invokestatic 516	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   102: invokevirtual 520	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   105: pop
    //   106: aload_0
    //   107: getfield 212	org/webrtc/voiceengine/AudioDeviceAndroid:_recBuffer	Ljava/nio/ByteBuffer;
    //   110: iconst_0
    //   111: invokevirtual 524	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   114: pop
    //   115: aload_0
    //   116: iload_2
    //   117: iconst_5
    //   118: imul
    //   119: sipush 200
    //   122: idiv
    //   123: putfield 178	org/webrtc/voiceengine/AudioDeviceAndroid:_bufferedRecSamples	I
    //   126: aload_0
    //   127: getfield 155	org/webrtc/voiceengine/AudioDeviceAndroid:_audioRecord	Landroid/media/AudioRecord;
    //   130: ifnull +15 -> 145
    //   133: aload_0
    //   134: getfield 155	org/webrtc/voiceengine/AudioDeviceAndroid:_audioRecord	Landroid/media/AudioRecord;
    //   137: invokevirtual 557	android/media/AudioRecord:release	()V
    //   140: aload_0
    //   141: aconst_null
    //   142: putfield 155	org/webrtc/voiceengine/AudioDeviceAndroid:_audioRecord	Landroid/media/AudioRecord;
    //   145: iload_1
    //   146: iload_2
    //   147: invokestatic 559	org/webrtc/voiceengine/AudioDeviceAndroid:getRecAudioSourceForNativeSourceInternal	(II)I
    //   150: istore 6
    //   152: aload_0
    //   153: new 274	android/media/AudioRecord
    //   156: dup
    //   157: iload 6
    //   159: iload_2
    //   160: bipush 16
    //   162: iconst_2
    //   163: iload 5
    //   165: invokespecial 562	android/media/AudioRecord:<init>	(IIIII)V
    //   168: putfield 155	org/webrtc/voiceengine/AudioDeviceAndroid:_audioRecord	Landroid/media/AudioRecord;
    //   171: aload_0
    //   172: getfield 155	org/webrtc/voiceengine/AudioDeviceAndroid:_audioRecord	Landroid/media/AudioRecord;
    //   175: ifnonnull +79 -> 254
    //   178: new 536	java/lang/NullPointerException
    //   181: dup
    //   182: new 321	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 322	java/lang/StringBuilder:<init>	()V
    //   189: ldc_w 564
    //   192: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: iload_2
    //   196: invokevirtual 541	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   199: ldc_w 566
    //   202: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: iload 6
    //   207: invokevirtual 541	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   210: ldc_w 568
    //   213: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: iload 5
    //   218: invokevirtual 541	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   221: invokevirtual 339	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokespecial 548	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   227: athrow
    //   228: astore 8
    //   230: iconst_m1
    //   231: ireturn
    //   232: aload_0
    //   233: aload_3
    //   234: putfield 159	org/webrtc/voiceengine/AudioDeviceAndroid:_tempBufRec	[B
    //   237: goto -166 -> 71
    //   240: aload_0
    //   241: aload 4
    //   243: putfield 212	org/webrtc/voiceengine/AudioDeviceAndroid:_recBuffer	Ljava/nio/ByteBuffer;
    //   246: goto -158 -> 88
    //   249: astore 7
    //   251: aload 7
    //   253: athrow
    //   254: aload_0
    //   255: getfield 155	org/webrtc/voiceengine/AudioDeviceAndroid:_audioRecord	Landroid/media/AudioRecord;
    //   258: invokevirtual 569	android/media/AudioRecord:getState	()I
    //   261: iconst_1
    //   262: if_icmpeq +17 -> 279
    //   265: aload_0
    //   266: getfield 155	org/webrtc/voiceengine/AudioDeviceAndroid:_audioRecord	Landroid/media/AudioRecord;
    //   269: invokevirtual 557	android/media/AudioRecord:release	()V
    //   272: aload_0
    //   273: aconst_null
    //   274: putfield 155	org/webrtc/voiceengine/AudioDeviceAndroid:_audioRecord	Landroid/media/AudioRecord;
    //   277: iconst_m1
    //   278: ireturn
    //   279: invokestatic 572	org/webrtc/voiceengine/NativeADMDelegate:isPlatformWideAECEffectAvailable	()Z
    //   282: ifeq +21 -> 303
    //   285: aload_0
    //   286: aload_0
    //   287: getfield 155	org/webrtc/voiceengine/AudioDeviceAndroid:_audioRecord	Landroid/media/AudioRecord;
    //   290: new 574	org/webrtc/voiceengine/AudioDeviceAndroid$AECDefaultFactory
    //   293: dup
    //   294: invokespecial 575	org/webrtc/voiceengine/AudioDeviceAndroid$AECDefaultFactory:<init>	()V
    //   297: invokestatic 577	org/webrtc/voiceengine/AudioDeviceAndroid:enableEffectForAudioRecordSession	(Landroid/media/AudioRecord;Lorg/webrtc/voiceengine/AudioDeviceAndroid$EffectFactory;)Ljava/lang/Object;
    //   300: putfield 198	org/webrtc/voiceengine/AudioDeviceAndroid:aecFilter	Ljava/lang/Object;
    //   303: aload_0
    //   304: getfield 198	org/webrtc/voiceengine/AudioDeviceAndroid:aecFilter	Ljava/lang/Object;
    //   307: ifnonnull +24 -> 331
    //   310: aload_0
    //   311: aload_0
    //   312: getfield 155	org/webrtc/voiceengine/AudioDeviceAndroid:_audioRecord	Landroid/media/AudioRecord;
    //   315: new 579	org/webrtc/voiceengine/AudioDeviceAndroid$UUIDEffectCreator
    //   318: dup
    //   319: getstatic 96	org/webrtc/voiceengine/AudioDeviceAndroid:SOFTWARE_ACOUSTIC_ECHO_CANCELER_UUID	Ljava/util/UUID;
    //   322: invokespecial 582	org/webrtc/voiceengine/AudioDeviceAndroid$UUIDEffectCreator:<init>	(Ljava/util/UUID;)V
    //   325: invokestatic 577	org/webrtc/voiceengine/AudioDeviceAndroid:enableEffectForAudioRecordSession	(Landroid/media/AudioRecord;Lorg/webrtc/voiceengine/AudioDeviceAndroid$EffectFactory;)Ljava/lang/Object;
    //   328: putfield 198	org/webrtc/voiceengine/AudioDeviceAndroid:aecFilter	Ljava/lang/Object;
    //   331: invokestatic 585	org/webrtc/voiceengine/NativeADMDelegate:isPlatformWideNSEffectAvailable	()Z
    //   334: ifeq +21 -> 355
    //   337: aload_0
    //   338: aload_0
    //   339: getfield 155	org/webrtc/voiceengine/AudioDeviceAndroid:_audioRecord	Landroid/media/AudioRecord;
    //   342: new 587	org/webrtc/voiceengine/AudioDeviceAndroid$NSDefaultFactory
    //   345: dup
    //   346: invokespecial 588	org/webrtc/voiceengine/AudioDeviceAndroid$NSDefaultFactory:<init>	()V
    //   349: invokestatic 577	org/webrtc/voiceengine/AudioDeviceAndroid:enableEffectForAudioRecordSession	(Landroid/media/AudioRecord;Lorg/webrtc/voiceengine/AudioDeviceAndroid$EffectFactory;)Ljava/lang/Object;
    //   352: putfield 200	org/webrtc/voiceengine/AudioDeviceAndroid:nsFilter	Ljava/lang/Object;
    //   355: aload_0
    //   356: getfield 200	org/webrtc/voiceengine/AudioDeviceAndroid:nsFilter	Ljava/lang/Object;
    //   359: ifnonnull +24 -> 383
    //   362: aload_0
    //   363: aload_0
    //   364: getfield 155	org/webrtc/voiceengine/AudioDeviceAndroid:_audioRecord	Landroid/media/AudioRecord;
    //   367: new 579	org/webrtc/voiceengine/AudioDeviceAndroid$UUIDEffectCreator
    //   370: dup
    //   371: getstatic 92	org/webrtc/voiceengine/AudioDeviceAndroid:SOFTWARE_NOISE_SUPPRESSOR_UUID	Ljava/util/UUID;
    //   374: invokespecial 582	org/webrtc/voiceengine/AudioDeviceAndroid$UUIDEffectCreator:<init>	(Ljava/util/UUID;)V
    //   377: invokestatic 577	org/webrtc/voiceengine/AudioDeviceAndroid:enableEffectForAudioRecordSession	(Landroid/media/AudioRecord;Lorg/webrtc/voiceengine/AudioDeviceAndroid$EffectFactory;)Ljava/lang/Object;
    //   380: putfield 200	org/webrtc/voiceengine/AudioDeviceAndroid:nsFilter	Ljava/lang/Object;
    //   383: invokestatic 591	org/webrtc/voiceengine/NativeADMDelegate:isPlatformWideAGCEffectAvailable	()Z
    //   386: ifeq +21 -> 407
    //   389: aload_0
    //   390: aload_0
    //   391: getfield 155	org/webrtc/voiceengine/AudioDeviceAndroid:_audioRecord	Landroid/media/AudioRecord;
    //   394: new 593	org/webrtc/voiceengine/AudioDeviceAndroid$AGCDefaultFactory
    //   397: dup
    //   398: invokespecial 594	org/webrtc/voiceengine/AudioDeviceAndroid$AGCDefaultFactory:<init>	()V
    //   401: invokestatic 577	org/webrtc/voiceengine/AudioDeviceAndroid:enableEffectForAudioRecordSession	(Landroid/media/AudioRecord;Lorg/webrtc/voiceengine/AudioDeviceAndroid$EffectFactory;)Ljava/lang/Object;
    //   404: putfield 202	org/webrtc/voiceengine/AudioDeviceAndroid:agcFilter	Ljava/lang/Object;
    //   407: aload_0
    //   408: getfield 202	org/webrtc/voiceengine/AudioDeviceAndroid:agcFilter	Ljava/lang/Object;
    //   411: ifnonnull +24 -> 435
    //   414: aload_0
    //   415: aload_0
    //   416: getfield 155	org/webrtc/voiceengine/AudioDeviceAndroid:_audioRecord	Landroid/media/AudioRecord;
    //   419: new 579	org/webrtc/voiceengine/AudioDeviceAndroid$UUIDEffectCreator
    //   422: dup
    //   423: getstatic 100	org/webrtc/voiceengine/AudioDeviceAndroid:SOFTWARE_AUTOMATIC_GAIN_CONTROL_UUID	Ljava/util/UUID;
    //   426: invokespecial 582	org/webrtc/voiceengine/AudioDeviceAndroid$UUIDEffectCreator:<init>	(Ljava/util/UUID;)V
    //   429: invokestatic 577	org/webrtc/voiceengine/AudioDeviceAndroid:enableEffectForAudioRecordSession	(Landroid/media/AudioRecord;Lorg/webrtc/voiceengine/AudioDeviceAndroid$EffectFactory;)Ljava/lang/Object;
    //   432: putfield 202	org/webrtc/voiceengine/AudioDeviceAndroid:agcFilter	Ljava/lang/Object;
    //   435: aload_0
    //   436: getfield 178	org/webrtc/voiceengine/AudioDeviceAndroid:_bufferedRecSamples	I
    //   439: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   152	228	228	java/lang/Exception
    //   152	228	249	finally
  }

  // ERROR //
  public int ProbePlayback(int paramInt)
  {
    // Byte code:
    //   0: iconst_2
    //   1: istore_2
    //   2: iload_1
    //   3: iconst_4
    //   4: iload_2
    //   5: invokestatic 510	android/media/AudioTrack:getMinBufferSize	(III)I
    //   8: istore_3
    //   9: bipush 254
    //   11: iload_3
    //   12: if_icmpne +126 -> 138
    //   15: iload_1
    //   16: iload_2
    //   17: iload_2
    //   18: invokestatic 510	android/media/AudioTrack:getMinBufferSize	(III)I
    //   21: istore_3
    //   22: iload_3
    //   23: sipush 6000
    //   26: if_icmpge +7 -> 33
    //   29: iload_3
    //   30: iconst_1
    //   31: ishl
    //   32: istore_3
    //   33: aconst_null
    //   34: astore 4
    //   36: new 260	android/media/AudioTrack
    //   39: dup
    //   40: iconst_0
    //   41: iload_1
    //   42: iload_2
    //   43: iconst_2
    //   44: iload_3
    //   45: iconst_1
    //   46: invokespecial 551	android/media/AudioTrack:<init>	(IIIIII)V
    //   49: astore 5
    //   51: aload 5
    //   53: invokevirtual 554	android/media/AudioTrack:getState	()I
    //   56: istore 9
    //   58: iload 9
    //   60: iconst_1
    //   61: if_icmpeq +15 -> 76
    //   64: aload 5
    //   66: ifnull +8 -> 74
    //   69: aload 5
    //   71: invokevirtual 555	android/media/AudioTrack:release	()V
    //   74: iconst_m1
    //   75: ireturn
    //   76: aload 5
    //   78: ifnull +8 -> 86
    //   81: aload 5
    //   83: invokevirtual 555	android/media/AudioTrack:release	()V
    //   86: iconst_0
    //   87: ireturn
    //   88: astore 10
    //   90: aconst_null
    //   91: astore 5
    //   93: aload 5
    //   95: ifnull +8 -> 103
    //   98: aload 5
    //   100: invokevirtual 555	android/media/AudioTrack:release	()V
    //   103: iconst_m1
    //   104: ireturn
    //   105: astore 8
    //   107: aload 4
    //   109: ifnull +8 -> 117
    //   112: aload 4
    //   114: invokevirtual 555	android/media/AudioTrack:release	()V
    //   117: aload 8
    //   119: athrow
    //   120: astore 7
    //   122: aload 5
    //   124: astore 4
    //   126: aload 7
    //   128: astore 8
    //   130: goto -23 -> 107
    //   133: astore 6
    //   135: goto -42 -> 93
    //   138: iconst_4
    //   139: istore_2
    //   140: goto -118 -> 22
    //
    // Exception table:
    //   from	to	target	type
    //   36	51	88	java/lang/Throwable
    //   36	51	105	finally
    //   51	58	120	finally
    //   51	58	133	java/lang/Throwable
  }

  // ERROR //
  public int ProbeRecording(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 184	org/webrtc/voiceengine/AudioDeviceAndroid:_audioRoute	I
    //   4: iconst_1
    //   5: if_icmpne +5 -> 10
    //   8: iload_2
    //   9: ireturn
    //   10: iload_2
    //   11: bipush 16
    //   13: iconst_2
    //   14: invokestatic 556	android/media/AudioRecord:getMinBufferSize	(III)I
    //   17: istore_3
    //   18: aconst_null
    //   19: astore 4
    //   21: new 274	android/media/AudioRecord
    //   24: dup
    //   25: iload_1
    //   26: iload_2
    //   27: invokestatic 559	org/webrtc/voiceengine/AudioDeviceAndroid:getRecAudioSourceForNativeSourceInternal	(II)I
    //   30: iload_2
    //   31: bipush 16
    //   33: iconst_2
    //   34: iload_3
    //   35: invokespecial 562	android/media/AudioRecord:<init>	(IIIII)V
    //   38: astore 5
    //   40: aload 5
    //   42: invokevirtual 569	android/media/AudioRecord:getState	()I
    //   45: istore 9
    //   47: iload 9
    //   49: iconst_1
    //   50: if_icmpeq +15 -> 65
    //   53: aload 5
    //   55: ifnull +8 -> 63
    //   58: aload 5
    //   60: invokevirtual 557	android/media/AudioRecord:release	()V
    //   63: iconst_m1
    //   64: ireturn
    //   65: aload 5
    //   67: ifnull +8 -> 75
    //   70: aload 5
    //   72: invokevirtual 557	android/media/AudioRecord:release	()V
    //   75: iload_2
    //   76: iconst_5
    //   77: imul
    //   78: sipush 200
    //   81: idiv
    //   82: ireturn
    //   83: astore 10
    //   85: aconst_null
    //   86: astore 5
    //   88: aload 5
    //   90: ifnull +8 -> 98
    //   93: aload 5
    //   95: invokevirtual 557	android/media/AudioRecord:release	()V
    //   98: iconst_m1
    //   99: ireturn
    //   100: astore 8
    //   102: aload 4
    //   104: ifnull +8 -> 112
    //   107: aload 4
    //   109: invokevirtual 557	android/media/AudioRecord:release	()V
    //   112: aload 8
    //   114: athrow
    //   115: astore 7
    //   117: aload 5
    //   119: astore 4
    //   121: aload 7
    //   123: astore 8
    //   125: goto -23 -> 102
    //   128: astore 6
    //   130: goto -42 -> 88
    //
    // Exception table:
    //   from	to	target	type
    //   21	40	83	java/lang/Exception
    //   21	40	100	finally
    //   40	47	115	finally
    //   40	47	128	java/lang/Exception
  }

  public int SetAudioRoute(int paramInt)
  {
    switch (paramInt)
    {
    case 2:
    default:
    case 1:
    case 3:
    }
    for (this._playbackStream = 0; ; this._playbackStream = 3)
    {
      this._audioRoute = paramInt;
      return paramInt;
    }
  }

  public int SetPlayoutSpeaker(boolean paramBoolean)
  {
    AudioManager localAudioManager = this._audioManager.getPlatformAudioManager();
    BtControl localBtControl = this._audioManager.getBluetoothCtl();
    if ((this._audioRoute != 0) && ((this._audioManager.isHeadsetPluggedIn()) || (localAudioManager.isBluetoothA2dpOn())));
    do
    {
      return 0;
      if ((this._audioRoute != 0) && (localBtControl.isHeadsetConnected()))
      {
        if (paramBoolean)
        {
          localBtControl.enableBluetoothRoute();
          localAudioManager.setMode(this._audioManager.mode_bluetooth());
          return 0;
        }
        localAudioManager.setMode(this._audioManager.mode_default());
        localBtControl.disableBluetoothRoute();
        return 0;
      }
    }
    while (paramBoolean == this._audioManager.getPlatformAudioManager().isSpeakerphoneOn());
    if (this._audioRoute != 1)
      return SetPlayoutSpeakerInternal(paramBoolean);
    if (this._audioTrack != null)
      this._playLock.lock();
    while (true)
    {
      try
      {
        if (this._audioTrack == null)
          break label253;
        i = this._audioTrack.getSampleRate();
        if (i == 0)
        {
          SetPlayoutSpeakerInternal(paramBoolean);
          return 0;
        }
        StopPlayback();
        SetPlayoutSpeakerInternal(paramBoolean);
        if (paramBoolean)
        {
          this._playbackStream = 3;
          InitPlayback(i);
          StartPlayback();
          return 0;
        }
        this._playbackStream = 0;
        continue;
      }
      finally
      {
        this._playLock.unlock();
      }
      SetPlayoutSpeakerInternal(paramBoolean);
      return 0;
      label253: int i = 0;
    }
  }

  public int SetPlayoutVolume(int paramInt)
  {
    return paramInt;
  }

  public int StartPlayback()
  {
    if (this._audioTrack == null)
      return -1;
    this._audioTrack.setPlaybackHeadPosition(0);
    if (8 != (0x8 & this.flags))
      processOnPlaybackPreStartEvent(this._audioRoute);
    if (this._audioTrack.getPlayState() != 3);
    try
    {
      this._audioTrack.play();
      PlayAudio(this._tempBufPlay.length);
      this._audioTrack.flush();
      if (8 != (0x8 & this.flags))
      {
        processOnPlaybackPostStartEvent();
        if (4 == (0x4 & this.flags))
          processOnOverallStartEvent(this._audioRoute);
      }
      setFlagsInternal(8);
      this._isPlaying = true;
      return 0;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      localIllegalStateException.printStackTrace();
      this._isPlaying = true;
    }
    return -1;
  }

  public int StartRecording()
  {
    processOnCaptureStartEvent();
    try
    {
      this._audioRecord.startRecording();
      processOnCapturePostStartEvent();
      if ((!this._isRecording) && (8 == (0x8 & this.flags)))
        processOnOverallStartEvent(this._audioRoute);
      this._isRecording = true;
      return 0;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      localIllegalStateException.printStackTrace();
    }
    return -1;
  }

  public int StopPlayback()
  {
    processOnPlaybackPreStopEvent();
    try
    {
      this._playLock.lock();
      if (this._audioTrack != null)
      {
        int i = this._audioTrack.getPlayState();
        if (i != 3);
      }
      try
      {
        this._audioTrack.stop();
        this._audioTrack.flush();
        this._audioTrack.release();
        this._audioTrack = null;
        this._doPlayInit = true;
        this._playLock.unlock();
        processOnPlaybackPostStopEvent(this._audioRoute);
        if ((8 == (0x8 & this.flags)) && (4 != (0x4 & this.flags)))
          processOnOverallStopEvent(this._audioRoute);
        clearFlagsInternal(2);
        clearFlagsInternal(8);
        this._isPlaying = false;
        return 0;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        while (true)
          localIllegalStateException.printStackTrace();
      }
    }
    finally
    {
      this._doPlayInit = true;
      this._playLock.unlock();
    }
  }

  // ERROR //
  public int StopRecording()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 166	org/webrtc/voiceengine/AudioDeviceAndroid:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual 238	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   7: aload_0
    //   8: getfield 155	org/webrtc/voiceengine/AudioDeviceAndroid:_audioRecord	Landroid/media/AudioRecord;
    //   11: ifnull +96 -> 107
    //   14: aload_0
    //   15: getfield 155	org/webrtc/voiceengine/AudioDeviceAndroid:_audioRecord	Landroid/media/AudioRecord;
    //   18: invokevirtual 673	android/media/AudioRecord:getRecordingState	()I
    //   21: istore_2
    //   22: iload_2
    //   23: iconst_3
    //   24: if_icmpne +10 -> 34
    //   27: aload_0
    //   28: getfield 155	org/webrtc/voiceengine/AudioDeviceAndroid:_audioRecord	Landroid/media/AudioRecord;
    //   31: invokevirtual 674	android/media/AudioRecord:stop	()V
    //   34: aload_0
    //   35: getfield 198	org/webrtc/voiceengine/AudioDeviceAndroid:aecFilter	Ljava/lang/Object;
    //   38: ifnull +18 -> 56
    //   41: aload_0
    //   42: getfield 198	org/webrtc/voiceengine/AudioDeviceAndroid:aecFilter	Ljava/lang/Object;
    //   45: invokestatic 676	org/webrtc/voiceengine/AudioDeviceAndroid:disableEffectForAudioRecordSession	(Ljava/lang/Object;)Z
    //   48: ifeq +8 -> 56
    //   51: aload_0
    //   52: aconst_null
    //   53: putfield 198	org/webrtc/voiceengine/AudioDeviceAndroid:aecFilter	Ljava/lang/Object;
    //   56: aload_0
    //   57: getfield 200	org/webrtc/voiceengine/AudioDeviceAndroid:nsFilter	Ljava/lang/Object;
    //   60: ifnull +18 -> 78
    //   63: aload_0
    //   64: getfield 200	org/webrtc/voiceengine/AudioDeviceAndroid:nsFilter	Ljava/lang/Object;
    //   67: invokestatic 676	org/webrtc/voiceengine/AudioDeviceAndroid:disableEffectForAudioRecordSession	(Ljava/lang/Object;)Z
    //   70: ifeq +8 -> 78
    //   73: aload_0
    //   74: aconst_null
    //   75: putfield 200	org/webrtc/voiceengine/AudioDeviceAndroid:nsFilter	Ljava/lang/Object;
    //   78: aload_0
    //   79: getfield 202	org/webrtc/voiceengine/AudioDeviceAndroid:agcFilter	Ljava/lang/Object;
    //   82: ifnull +18 -> 100
    //   85: aload_0
    //   86: getfield 202	org/webrtc/voiceengine/AudioDeviceAndroid:agcFilter	Ljava/lang/Object;
    //   89: invokestatic 676	org/webrtc/voiceengine/AudioDeviceAndroid:disableEffectForAudioRecordSession	(Ljava/lang/Object;)Z
    //   92: ifeq +8 -> 100
    //   95: aload_0
    //   96: aconst_null
    //   97: putfield 202	org/webrtc/voiceengine/AudioDeviceAndroid:agcFilter	Ljava/lang/Object;
    //   100: aload_0
    //   101: getfield 155	org/webrtc/voiceengine/AudioDeviceAndroid:_audioRecord	Landroid/media/AudioRecord;
    //   104: invokevirtual 557	android/media/AudioRecord:release	()V
    //   107: aload_0
    //   108: aconst_null
    //   109: putfield 155	org/webrtc/voiceengine/AudioDeviceAndroid:_audioRecord	Landroid/media/AudioRecord;
    //   112: aload_0
    //   113: iconst_1
    //   114: putfield 170	org/webrtc/voiceengine/AudioDeviceAndroid:_doRecInit	Z
    //   117: aload_0
    //   118: getfield 166	org/webrtc/voiceengine/AudioDeviceAndroid:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   121: invokevirtual 241	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   124: aload_0
    //   125: invokespecial 678	org/webrtc/voiceengine/AudioDeviceAndroid:processOnCaptureStopEvent	()V
    //   128: aload_0
    //   129: iconst_1
    //   130: invokevirtual 458	org/webrtc/voiceengine/AudioDeviceAndroid:clearFlagsInternal	(I)V
    //   133: bipush 8
    //   135: bipush 8
    //   137: aload_0
    //   138: getfield 186	org/webrtc/voiceengine/AudioDeviceAndroid:flags	I
    //   141: iand
    //   142: if_icmpeq +11 -> 153
    //   145: aload_0
    //   146: aload_0
    //   147: getfield 184	org/webrtc/voiceengine/AudioDeviceAndroid:_audioRoute	I
    //   150: invokespecial 669	org/webrtc/voiceengine/AudioDeviceAndroid:processOnOverallStopEvent	(I)V
    //   153: aload_0
    //   154: iconst_0
    //   155: putfield 172	org/webrtc/voiceengine/AudioDeviceAndroid:_isRecording	Z
    //   158: iconst_0
    //   159: ireturn
    //   160: astore_1
    //   161: aload_0
    //   162: iconst_1
    //   163: putfield 170	org/webrtc/voiceengine/AudioDeviceAndroid:_doRecInit	Z
    //   166: aload_0
    //   167: getfield 166	org/webrtc/voiceengine/AudioDeviceAndroid:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   170: invokevirtual 241	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   173: aload_0
    //   174: invokespecial 678	org/webrtc/voiceengine/AudioDeviceAndroid:processOnCaptureStopEvent	()V
    //   177: aload_1
    //   178: athrow
    //   179: astore_3
    //   180: goto -146 -> 34
    //
    // Exception table:
    //   from	to	target	type
    //   0	22	160	finally
    //   27	34	160	finally
    //   34	56	160	finally
    //   56	78	160	finally
    //   78	100	160	finally
    //   100	107	160	finally
    //   107	112	160	finally
    //   27	34	179	java/lang/IllegalStateException
  }

  public void clearFlagsInternal(int paramInt)
  {
    this.flags &= (paramInt ^ 0xFFFFFFFF);
  }

  public boolean isActive()
  {
    try
    {
      if (this._audioRecord != null)
      {
        AudioTrack localAudioTrack = this._audioTrack;
        if (localAudioTrack != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  public void registerStateListener(IAudioDevice.AudioDeviceStateListener paramAudioDeviceStateListener)
  {
    this.listeners.add(paramAudioDeviceStateListener);
  }

  // ERROR //
  public void waitForInitialize()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 686	org/webrtc/voiceengine/AudioDeviceAndroid:isActive	()Z
    //   4: ifne +26 -> 30
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: ldc2_w 687
    //   13: invokevirtual 692	java/lang/Object:wait	(J)V
    //   16: aload_0
    //   17: monitorexit
    //   18: goto -18 -> 0
    //   21: astore_2
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_2
    //   25: athrow
    //   26: astore_1
    //   27: goto -11 -> 16
    //   30: return
    //
    // Exception table:
    //   from	to	target	type
    //   9	16	21	finally
    //   16	18	21	finally
    //   22	24	21	finally
    //   9	16	26	java/lang/InterruptedException
  }

  @TargetApi(16)
  static class AECDefaultFactory
    implements AudioDeviceAndroid.EffectFactory
  {
    public AudioEffect create(int paramInt)
    {
      return AcousticEchoCanceler.create(paramInt);
    }

    public boolean isBlacklisted()
    {
      return AudioDeviceAndroid.ACOUSTIC_ECHO_CANCELER_BLACKLIST.contains(Build.MODEL);
    }

    public String toString()
    {
      return "AcousticEchoCanceler platform default";
    }
  }

  @TargetApi(16)
  static class AGCDefaultFactory
    implements AudioDeviceAndroid.EffectFactory
  {
    public AudioEffect create(int paramInt)
    {
      return AutomaticGainControl.create(paramInt);
    }

    public boolean isBlacklisted()
    {
      return AudioDeviceAndroid.AUTOMATIC_GAIN_CONTROL_BLACKLIST.contains(Build.MODEL);
    }

    public String toString()
    {
      return "AutoGainControl platform default";
    }
  }

  @TargetApi(16)
  static abstract interface EffectFactory
  {
    public abstract AudioEffect create(int paramInt);

    public abstract boolean isBlacklisted();
  }

  @TargetApi(16)
  static class NSDefaultFactory
    implements AudioDeviceAndroid.EffectFactory
  {
    public AudioEffect create(int paramInt)
    {
      return NoiseSuppressor.create(paramInt);
    }

    public boolean isBlacklisted()
    {
      return AudioDeviceAndroid.NOISE_SUPPRESSOR_BLACKLIST.contains(Build.MODEL);
    }

    public String toString()
    {
      return "NoiseSuppression platform default";
    }
  }

  @TargetApi(16)
  static class UUIDEffectCreator
    implements AudioDeviceAndroid.EffectFactory
  {
    private static AudioEffect.Descriptor[] descriptors = null;
    private final UUID uuid;

    public UUIDEffectCreator(UUID paramUUID)
    {
      this.uuid = paramUUID;
    }

    public AudioEffect create(int paramInt)
    {
      try
      {
        if (descriptors == null)
        {
          descriptors = AudioEffect.queryEffects();
          AudioEffect.Descriptor[] arrayOfDescriptor2 = descriptors;
          int k = arrayOfDescriptor2.length;
          int m = 0;
          int n = 0;
          while (m < k)
          {
            arrayOfDescriptor2[m];
            n++;
            m++;
          }
        }
        if ((descriptors == null) || (descriptors.length == 0) || (this.uuid == null))
          return null;
      }
      finally
      {
      }
      AudioEffect.Descriptor[] arrayOfDescriptor1 = descriptors;
      int i = arrayOfDescriptor1.length;
      int j = 0;
      AudioEffect.Descriptor localDescriptor;
      if (j < i)
      {
        localDescriptor = arrayOfDescriptor1[j];
        if ((localDescriptor == null) || (localDescriptor.uuid == null) || (localDescriptor.uuid.compareTo(this.uuid) != 0));
      }
      while (true)
      {
        if (localDescriptor == null)
        {
          return null;
          j++;
          break;
        }
        try
        {
          Class[] arrayOfClass = new Class[4];
          arrayOfClass[0] = UUID.class;
          arrayOfClass[1] = UUID.class;
          arrayOfClass[2] = Integer.TYPE;
          arrayOfClass[3] = Integer.TYPE;
          Constructor localConstructor = AudioEffect.class.getDeclaredConstructor(arrayOfClass);
          localConstructor.setAccessible(true);
          Object[] arrayOfObject = new Object[4];
          arrayOfObject[0] = localDescriptor.type;
          arrayOfObject[1] = localDescriptor.uuid;
          arrayOfObject[2] = Integer.valueOf(0);
          arrayOfObject[3] = Integer.valueOf(paramInt);
          AudioEffect localAudioEffect = (AudioEffect)localConstructor.newInstance(arrayOfObject);
          return localAudioEffect;
        }
        catch (Throwable localThrowable)
        {
          return null;
        }
        localDescriptor = null;
      }
    }

    public boolean isBlacklisted()
    {
      return AudioDeviceAndroid.SOFTWARE_EFFECTS_BLACKLIST.contains(Build.MODEL);
    }

    public String toString()
    {
      return "UUID effect filter creator for " + this.uuid;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.voiceengine.AudioDeviceAndroid
 * JD-Core Version:    0.6.2
 */