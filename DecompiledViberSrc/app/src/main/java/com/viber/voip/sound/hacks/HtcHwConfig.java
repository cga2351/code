package com.viber.voip.sound.hacks;

import android.content.Context;
import android.media.AudioManager;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.av;
import java.io.IOException;
import java.io.InputStream;

public abstract interface HtcHwConfig
{
  public static final String HW_AEC_DISABLE = "HTCHWAEC=OFF";
  public static final String HW_AEC_ENABLE = "HTCHWAEC=ON";
  public static final String HW_AEC_PROP_SUPPORT = "persist.audio.SupportHTCHWAEC";
  public static final boolean USE_HTC_EXPERIMENTAL_HW_AEC_QUIRKS = true;

  public static class HtcHwCtl
  {
    private static final Logger L = ViberEnv.getLogger();
    private static volatile byte _available = -1;
    private static volatile boolean _on = false;

    public static final void ctlHwAec(Context paramContext, AudioManager paramAudioManager, boolean paramBoolean)
    {
      while (true)
      {
        try
        {
          boolean bool = ctlHwAecSupported();
          if (!bool)
            return;
          if ((_on == paramBoolean) || ("0".equals(d.av.y.d())))
            continue;
          _on = paramBoolean;
          if (paramBoolean)
          {
            str = "HTCHWAEC=ON";
            paramAudioManager.setParameters(str);
            continue;
          }
        }
        finally
        {
        }
        String str = "HTCHWAEC=OFF";
      }
    }

    public static final boolean ctlHwAecSupported()
    {
      int i = 1;
      while (true)
      {
        try
        {
          String str;
          if (_available == -1)
          {
            str = HtcHwConfig.SystemProperty.getProperty("persist.audio.SupportHTCHWAEC");
            if (str == null)
              _available = 0;
          }
          try
          {
            _available = Byte.parseByte(str);
            int j = _available;
            if (j == i)
              return i;
          }
          catch (Exception localException)
          {
            _available = 0;
            continue;
          }
        }
        finally
        {
        }
        i = 0;
      }
    }
  }

  public static final class SystemProperty
  {
    public static final String getProperty(String paramString)
    {
      try
      {
        Process localProcess = Runtime.getRuntime().exec("getprop ".concat(paramString));
        InputStream localInputStream = localProcess.getInputStream();
        try
        {
          localProcess.waitFor();
          byte[] arrayOfByte = new byte[localInputStream.available()];
          localInputStream.read(arrayOfByte);
          String str = new String(arrayOfByte).replaceAll("[\r\n]$", "");
          return str;
        }
        catch (InterruptedException localInterruptedException)
        {
          return null;
        }
      }
      catch (IOException localIOException)
      {
      }
      return null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.hacks.HtcHwConfig
 * JD-Core Version:    0.6.2
 */