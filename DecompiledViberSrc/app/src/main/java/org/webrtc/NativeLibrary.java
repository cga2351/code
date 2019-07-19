package org.webrtc;

class NativeLibrary
{
  private static String TAG = "NativeLibrary";
  private static boolean libraryLoaded = false;
  private static Object lock = new Object();

  static void initialize(NativeLibraryLoader paramNativeLibraryLoader, String paramString)
  {
    synchronized (lock)
    {
      if (libraryLoaded)
      {
        Logging.d(TAG, "Native library has already been loaded.");
        return;
      }
      Logging.d(TAG, "Loading native library: " + paramString);
      libraryLoaded = paramNativeLibraryLoader.load(paramString);
      return;
    }
  }

  static boolean isLoaded()
  {
    synchronized (lock)
    {
      boolean bool = libraryLoaded;
      return bool;
    }
  }

  static class DefaultLoader
    implements NativeLibraryLoader
  {
    public boolean load(String paramString)
    {
      Logging.d(NativeLibrary.TAG, "Loading library: " + paramString);
      try
      {
        System.loadLibrary(paramString);
        return true;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        Logging.e(NativeLibrary.TAG, "Failed to load native library: " + paramString, localUnsatisfiedLinkError);
      }
      return false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.NativeLibrary
 * JD-Core Version:    0.6.2
 */