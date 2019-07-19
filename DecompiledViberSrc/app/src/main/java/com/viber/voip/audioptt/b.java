package com.viber.voip.audioptt;

import android.media.AudioRecord;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class b
{
  c a;
  AudioRecord b;
  BufferedOutputStream c;
  long d = 9223372036854775807L;

  public static AudioRecord a(int paramInt)
  {
    return new AudioRecord(paramInt, 16000, 16, 2, 320000);
  }

  static short a(int paramInt, short[] paramArrayOfShort)
  {
    int i = 0;
    short s1 = 0;
    short s2;
    if (i < paramInt)
    {
      s2 = paramArrayOfShort[i];
      if (s2 == -32768)
        s2 = 32767;
      if (s2 < 0)
        s2 = (short)-s2;
      if (s1 >= s2)
        break label55;
    }
    while (true)
    {
      i++;
      s1 = s2;
      break;
      return s1;
      label55: s2 = s1;
    }
  }

  public void a()
    throws IOException
  {
    Log.i("AudioPttRecorder", "run");
    byte[] arrayOfByte1 = new byte[65536];
    byte[] arrayOfByte2 = new byte[2];
    BufferedOutputStream localBufferedOutputStream = this.c;
    if (localBufferedOutputStream == null)
      throw new RuntimeException("You forgot AudioPttRecorder.openForWriting");
    arrayOfByte2[0] = 26;
    localBufferedOutputStream.write(arrayOfByte2, 0, 1);
    long l1 = LibSpeex.nInitSpxEncoder();
    if (l1 == 0L)
      throw new RuntimeException("Failed to initialize SpeexJni");
    int i = (int)LibSpeex.nGetEncoderFrameSize(l1);
    PrintStream localPrintStream = System.err;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = Integer.valueOf(i);
    localPrintStream.println(String.format("Frame size = %d", arrayOfObject1));
    short[] arrayOfShort = new short[i];
    Object localObject1 = null;
    long l2 = 0L;
    while (true)
    {
      AudioRecord localAudioRecord;
      try
      {
        if (l2 < this.d);
        try
        {
          if (localObject1 != this.b)
            Log.i("AudioPttRecorder", "source changed");
          localAudioRecord = this.b;
          if (localAudioRecord == null)
          {
            localBufferedOutputStream.flush();
            Log.d("AudioPttRecorder", "finished");
            return;
          }
        }
        finally
        {
        }
      }
      finally
      {
        LibSpeex.nDestroySpxEncoder(l1);
        Log.i("AudioPttRecorder", "exited");
      }
      if (localAudioRecord.read(arrayOfShort, 0, i) == i)
      {
        if (this.a != null)
        {
          short s = a(i, arrayOfShort);
          this.a.currentVolume(l2, s);
        }
        long l3 = LibSpeex.nEncodeBuffer(l1, arrayOfShort, arrayOfByte1, arrayOfByte1.length);
        if (l3 < 0L)
          throw new RuntimeException("Something wrong with encoding Speex");
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Long.valueOf(l3);
        Log.d("AudioPttRecorder", String.format("Write packet len=%d", arrayOfObject2));
        arrayOfByte2[0] = ((byte)(int)(0xFF & l3));
        arrayOfByte2[1] = ((byte)(int)(l3 >> 8));
        localBufferedOutputStream.write(arrayOfByte2, 0, 2);
        localBufferedOutputStream.write(arrayOfByte1, 0, (int)l3);
        l2 = 1L + l2;
        localObject1 = localAudioRecord;
      }
    }
  }

  public void a(long paramLong)
  {
    this.d = (paramLong / 20L);
  }

  public void a(AudioRecord paramAudioRecord)
  {
    try
    {
      this.b = paramAudioRecord;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(c paramc)
  {
    this.a = paramc;
  }

  public void a(BufferedOutputStream paramBufferedOutputStream)
  {
    this.c = paramBufferedOutputStream;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.audioptt.b
 * JD-Core Version:    0.6.2
 */