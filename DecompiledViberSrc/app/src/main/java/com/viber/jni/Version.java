package com.viber.jni;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Version
{
  private static final Logger L = ViberEnv.getLogger();
  private static Pattern sFeatureVersionPattern;
  private static Pattern sReleaseVersionPattern = Pattern.compile("^([0-9]+)\\.([0-9]+)\\.([0-9]+)\\.([0-9]+)$");
  public final int Build;
  public final String FddFeature;
  public final int Major;
  public final int Minor;
  public final int MinorMinor;

  static
  {
    sFeatureVersionPattern = Pattern.compile("^(.*)\\.([0-9]+)$");
  }

  private Version(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    this.Major = paramInt1;
    this.Minor = paramInt2;
    this.MinorMinor = paramInt3;
    this.Build = paramInt4;
    this.FddFeature = paramString;
  }

  public static Version parseVersionString(String paramString)
  {
    if (paramString == null)
      L.e("verStr = null", new Object[0]);
    Matcher localMatcher1 = sReleaseVersionPattern.matcher(paramString);
    Version localVersion;
    if (localMatcher1.find())
      localVersion = new Version(Integer.parseInt(localMatcher1.group(1)), Integer.parseInt(localMatcher1.group(2)), Integer.parseInt(localMatcher1.group(3)), Integer.parseInt(localMatcher1.group(4)), null);
    while (true)
      if (localVersion == null)
      {
        L.d("can't parse viber version: ?, verStr", new Object[0]);
        return null;
        L.d("can't parse as release version, parsing as feature version", new Object[0]);
        Matcher localMatcher2 = sFeatureVersionPattern.matcher(paramString);
        if (localMatcher2.find())
          localVersion = new Version(0, 0, 0, Integer.parseInt(localMatcher2.group(2)), localMatcher2.group(1));
      }
      else
      {
        Logger localLogger = L;
        Object[] arrayOfObject = new Object[4];
        arrayOfObject[0] = Integer.valueOf(localVersion.Major);
        arrayOfObject[1] = Integer.valueOf(localVersion.Minor);
        arrayOfObject[2] = Integer.valueOf(localVersion.MinorMinor);
        arrayOfObject[3] = Integer.valueOf(localVersion.Build);
        localLogger.c("parsed version ?.?.?.?", arrayOfObject);
        return localVersion;
        localVersion = null;
      }
  }

  public boolean isNewerThen(Version paramVersion)
  {
    if (this.Major != paramVersion.Major)
      if (this.Major <= paramVersion.Major);
    do
    {
      do
      {
        do
        {
          return true;
          return false;
          if (this.Minor == paramVersion.Minor)
            break;
        }
        while (this.Minor > paramVersion.Minor);
        return false;
        if (this.MinorMinor == paramVersion.MinorMinor)
          break;
      }
      while (this.MinorMinor > paramVersion.MinorMinor);
      return false;
    }
    while (this.Build > paramVersion.Build);
    return false;
  }

  public String toString()
  {
    return "Major = " + this.Major + "Minor = " + this.Minor + "MinorMinor = " + this.MinorMinor + "Build = " + this.Build;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.Version
 * JD-Core Version:    0.6.2
 */