package org.webrtc.audio;

import org.webrtc.voiceengine.WebRtcAudioRecord;
import org.webrtc.voiceengine.WebRtcAudioTrack;

@Deprecated
public class LegacyAudioDeviceModule
  implements AudioDeviceModule
{
  public long getNativeAudioDeviceModulePointer()
  {
    return 0L;
  }

  public void release()
  {
  }

  public void setMicrophoneMute(boolean paramBoolean)
  {
    WebRtcAudioRecord.setMicrophoneMute(paramBoolean);
  }

  public void setSpeakerMute(boolean paramBoolean)
  {
    WebRtcAudioTrack.setSpeakerMute(paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.audio.LegacyAudioDeviceModule
 * JD-Core Version:    0.6.2
 */