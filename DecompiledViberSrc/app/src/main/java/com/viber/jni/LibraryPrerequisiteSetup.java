package com.viber.jni;

public class LibraryPrerequisiteSetup
{
  public static void setup(boolean paramBoolean, String paramString)
  {
    DeviceFlags.WEAK_DEVICE = paramBoolean;
    SystemInfo.setApplicationDataDir(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.LibraryPrerequisiteSetup
 * JD-Core Version:    0.6.2
 */