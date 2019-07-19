package org.webrtc.videoengine;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.util.JsonReader;
import android.util.JsonToken;
import com.viber.voip.sound.NativeMediaDelegate;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ViEVideoSupport
{
  private static final boolean ALLOW_WHITELISTED_DEVICES_ONLY = false;
  private static final int DEFAULT_MINIMAL_API_VERSION = 14;
  private static int MINIMAL_API_VERSION;
  private static final Map<String, VideoSupportQuirks> deviceBlacklist = new HashMap();
  private static final Map<String, VideoSupportQuirks> deviceWhitelist = new HashMap();

  static
  {
    MINIMAL_API_VERSION = 14;
    deviceBlacklist.put("OT-4007D", null);
    deviceBlacklist.put("A3333", null);
    deviceBlacklist.put("S710e", null);
    deviceBlacklist.put("A810e", null);
    deviceBlacklist.put("A510e", null);
    deviceBlacklist.put("A7272", null);
    deviceBlacklist.put("LG-P500", null);
    deviceBlacklist.put("GT-S5830", null);
    deviceBlacklist.put("GT-S5570", null);
    deviceBlacklist.put("GT-i5510T", null);
    deviceBlacklist.put("GT-S5300", null);
    deviceBlacklist.put("GT-S5360", null);
    deviceBlacklist.put("GT-S6102", null);
    deviceBlacklist.put("X10i", null);
    deviceBlacklist.put("E10i", null);
    deviceBlacklist.put("ZTE U-V880", null);
    loadExternalSupportLists();
  }

  public static final void init()
  {
  }

  public static boolean isH264Available()
  {
    return ViEOMXHelper.isH264Available();
  }

  public static boolean isVP9Available()
  {
    return NativeMediaDelegate.isVP9Builtin();
  }

  public static final boolean isVideoCallSupported()
  {
    boolean bool1 = true;
    if (NativeMediaDelegate.isVideoSupportBuiltin());
    for (int i = bool1; i == 0; i = 0)
      return false;
    int j;
    int m;
    label58: int i1;
    label86: boolean bool2;
    if (MINIMAL_API_VERSION <= Build.VERSION.SDK_INT)
    {
      j = bool1;
      int k = i & j;
      if (deviceBlacklist.keySet().contains(Build.DEVICE))
        break label145;
      m = bool1;
      int n = k & m;
      if (deviceBlacklist.keySet().contains(Build.MODEL))
        break label151;
      i1 = bool1;
      bool2 = i1 & n | deviceWhitelist.keySet().contains(Build.DEVICE) | deviceWhitelist.keySet().contains(Build.MODEL);
      if ((0x2 & NativeMediaDelegate.getEngineStatus()) == 0)
        break label157;
    }
    while (true)
    {
      return bool2 & bool1;
      j = 0;
      break;
      label145: m = 0;
      break label58;
      label151: i1 = 0;
      break label86;
      label157: bool1 = false;
    }
  }

  static final boolean loadExternalSupportLists()
  {
    try
    {
      boolean bool = loadExternalSupportLists(Environment.getExternalStorageDirectory() + "/viber/video_quirks.json");
      return bool;
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  static final boolean loadExternalSupportLists(String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.exists())
      return false;
    try
    {
      JsonReader localJsonReader = new JsonReader(new InputStreamReader(new FileInputStream(localFile)));
      localJsonReader.setLenient(true);
      localJsonReader.beginObject();
      while (true)
      {
        String str1;
        if (localJsonReader.hasNext())
        {
          str1 = localJsonReader.nextName();
          if (str1 != null);
        }
        else
        {
          localJsonReader.endObject();
          return true;
        }
        String str2 = str1.toLowerCase();
        if (("whitelist".equals(str2)) || ("blacklist".equals(str2)))
        {
          localJsonReader.beginArray();
          if (localJsonReader.hasNext())
            if (!"blacklist".equals(str2))
              break label181;
          label181: for (Map localMap = deviceBlacklist; ; localMap = deviceWhitelist)
          {
            try
            {
              while (true)
              {
                VideoSupportQuirks localVideoSupportQuirks = VideoSupportQuirks.fromJSON(localJsonReader, localMap);
                if (localVideoSupportQuirks == null)
                  break;
                try
                {
                  localMap.put(VideoSupportQuirks.magic(localVideoSupportQuirks), localVideoSupportQuirks);
                  break;
                }
                finally
                {
                }
              }
            }
            catch (Exception localException2)
            {
            }
            localJsonReader.endArray();
            break;
          }
        }
        if ("minimal_api_level".contains(str2))
        {
          if ("STRING".equals(localJsonReader.peek().toString()))
          {
            String str3 = localJsonReader.nextString();
            int i = 10;
            if (str3.startsWith("0x"))
            {
              str3 = str3.replaceFirst("0x", "");
              i = 16;
            }
            MINIMAL_API_VERSION = Integer.parseInt(str3, i);
          }
          else
          {
            MINIMAL_API_VERSION = localJsonReader.nextInt();
          }
        }
        else
          localJsonReader.skipValue();
      }
    }
    catch (Exception localException1)
    {
    }
    return false;
  }

  static class VideoSupportQuirks
  {
    public final String ident;
    public final String vendor;

    public VideoSupportQuirks(String paramString1, String paramString2)
    {
      this.vendor = paramString1;
      this.ident = paramString2;
    }

    public static VideoSupportQuirks fromJSON(JsonReader paramJsonReader, Map<String, VideoSupportQuirks> paramMap)
      throws IOException
    {
      String str1;
      Object localObject2;
      try
      {
        paramJsonReader.beginObject();
        str1 = null;
        localObject2 = null;
        while (paramJsonReader.hasNext())
        {
          String str2 = paramJsonReader.nextName();
          if (str2 != null)
          {
            String str3 = str2.toLowerCase();
            try
            {
              if ("device".equals(str3))
              {
                str1 = paramJsonReader.nextString();
              }
              else if ("vendor".equals(str3))
              {
                String str4 = paramJsonReader.nextString();
                localObject2 = str4;
              }
            }
            catch (Exception localException)
            {
              return null;
            }
          }
        }
        paramJsonReader.endObject();
        if ((localObject2 == null) && (str1 == null))
          return null;
      }
      finally
      {
        paramJsonReader.endObject();
      }
      return new VideoSupportQuirks(localObject2, str1);
    }

    public static final String magic(VideoSupportQuirks paramVideoSupportQuirks)
    {
      if (paramVideoSupportQuirks != null)
        return paramVideoSupportQuirks.ident;
      return null;
    }

    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof VideoSupportQuirks)) && (toString().equals(paramObject.toString()));
    }

    public int hashCode()
    {
      return toString().hashCode();
    }

    public String toString()
    {
      return this.ident;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.videoengine.ViEVideoSupport
 * JD-Core Version:    0.6.2
 */