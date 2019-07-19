package com.facebook.common.media;

import android.webkit.MimeTypeMap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;

public class MediaUtils
{
  public static final Map<String, String> ADDITIONAL_ALLOWED_MIME_TYPES = ImmutableMap.of("mkv", "video/x-matroska", "glb", "model/gltf-binary");

  @Nullable
  private static String extractExtension(String paramString)
  {
    int i = paramString.lastIndexOf('.');
    if ((i < 0) || (i == -1 + paramString.length()))
      return null;
    return paramString.substring(i + 1);
  }

  @Nullable
  public static String extractMime(String paramString)
  {
    String str1 = extractExtension(paramString);
    String str3;
    if (str1 == null)
      str3 = null;
    String str2;
    do
    {
      return str3;
      str2 = str1.toLowerCase(Locale.US);
      str3 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str2);
    }
    while (str3 != null);
    return (String)ADDITIONAL_ALLOWED_MIME_TYPES.get(str2);
  }

  public static boolean isNonNativeSupportedMimeType(String paramString)
  {
    return ADDITIONAL_ALLOWED_MIME_TYPES.containsValue(paramString);
  }

  public static boolean isPhoto(@Nullable String paramString)
  {
    return (paramString != null) && (paramString.startsWith("image/"));
  }

  public static boolean isThreeD(@Nullable String paramString)
  {
    return (paramString != null) && (paramString.equals("model/gltf-binary"));
  }

  public static boolean isVideo(@Nullable String paramString)
  {
    return (paramString != null) && (paramString.startsWith("video/"));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.media.MediaUtils
 * JD-Core Version:    0.6.2
 */