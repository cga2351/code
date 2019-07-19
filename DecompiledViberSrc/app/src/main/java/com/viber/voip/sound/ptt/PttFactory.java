package com.viber.voip.sound.ptt;

import com.viber.voip.i.c.k;
import com.viber.voip.i.f;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.greenrobot.eventbus.EventBus;

public class PttFactory
{
  public static AudioPlayer createPttPlayer(EventBus paramEventBus, String paramString, File paramFile, int paramInt)
  {
    if (paramFile == null)
      return null;
    if (isNewPtt(paramFile.getAbsolutePath()))
      return new MpAudioPlayer(paramEventBus, paramString, paramFile, paramInt);
    return new AudioPttPlayer(paramEventBus, paramString, paramFile, paramInt);
  }

  public static AudioRecorder createPttRecorder(AudioPttRecordDelegate paramAudioPttRecordDelegate, File paramFile)
  {
    if (paramFile == null)
      return null;
    if (!c.k.a.e())
      return new AudioPttRecorder(paramAudioPttRecordDelegate, paramFile);
    return new MediaRecordPtt(paramAudioPttRecordDelegate, paramFile);
  }

  public static boolean isNewPtt(String paramString)
  {
    byte[] arrayOfByte = new byte[16];
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramString);
      localFileInputStream.read(arrayOfByte);
      localFileInputStream.close();
      return new String(arrayOfByte).contains("fty");
    }
    catch (IOException localIOException)
    {
      while (true)
        localIOException.printStackTrace();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.ptt.PttFactory
 * JD-Core Version:    0.6.2
 */