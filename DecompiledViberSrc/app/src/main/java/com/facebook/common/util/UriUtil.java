package com.facebook.common.util;

import android.net.Uri;
import android.net.Uri.Builder;
import android.provider.ContactsContract;
import android.provider.MediaStore.Images.Media;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.annotation.Nullable;

public class UriUtil
{
  public static final String DATA_SCHEME = "data";
  public static final String HTTPS_SCHEME = "https";
  public static final String HTTP_SCHEME = "http";
  public static final String LOCAL_ASSET_SCHEME = "asset";
  private static final Uri LOCAL_CONTACT_IMAGE_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "display_photo");
  public static final String LOCAL_CONTENT_SCHEME = "content";
  public static final String LOCAL_FILE_SCHEME = "file";
  public static final String LOCAL_RESOURCE_SCHEME = "res";
  public static final String QUALIFIED_RESOURCE_SCHEME = "android.resource";

  // ERROR //
  @Nullable
  public static String getRealPathFromUri(android.content.ContentResolver paramContentResolver, Uri paramUri)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: invokestatic 58	com/facebook/common/util/UriUtil:isLocalContentUri	(Landroid/net/Uri;)Z
    //   6: ifeq +89 -> 95
    //   9: aload_0
    //   10: aload_1
    //   11: aconst_null
    //   12: aconst_null
    //   13: aconst_null
    //   14: aconst_null
    //   15: invokevirtual 64	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   18: astore 4
    //   20: aload 4
    //   22: ifnull +94 -> 116
    //   25: aload 4
    //   27: invokeinterface 70 1 0
    //   32: ifeq +84 -> 116
    //   35: aload 4
    //   37: ldc 72
    //   39: invokeinterface 76 2 0
    //   44: istore 6
    //   46: iload 6
    //   48: iconst_m1
    //   49: if_icmpeq +67 -> 116
    //   52: aload 4
    //   54: iload 6
    //   56: invokeinterface 80 2 0
    //   61: astore 7
    //   63: aload 7
    //   65: astore 5
    //   67: aload 4
    //   69: ifnull +10 -> 79
    //   72: aload 4
    //   74: invokeinterface 83 1 0
    //   79: aload 5
    //   81: areturn
    //   82: astore_3
    //   83: aload_2
    //   84: ifnull +9 -> 93
    //   87: aload_2
    //   88: invokeinterface 83 1 0
    //   93: aload_3
    //   94: athrow
    //   95: aload_1
    //   96: invokestatic 86	com/facebook/common/util/UriUtil:isLocalFileUri	(Landroid/net/Uri;)Z
    //   99: ifeq +15 -> 114
    //   102: aload_1
    //   103: invokevirtual 90	android/net/Uri:getPath	()Ljava/lang/String;
    //   106: areturn
    //   107: astore_3
    //   108: aload 4
    //   110: astore_2
    //   111: goto -28 -> 83
    //   114: aconst_null
    //   115: areturn
    //   116: aconst_null
    //   117: astore 5
    //   119: goto -52 -> 67
    //
    // Exception table:
    //   from	to	target	type
    //   9	20	82	finally
    //   25	46	107	finally
    //   52	63	107	finally
  }

  @Nullable
  public static String getSchemeOrNull(@Nullable Uri paramUri)
  {
    if (paramUri == null)
      return null;
    return paramUri.getScheme();
  }

  public static Uri getUriForFile(File paramFile)
  {
    return Uri.fromFile(paramFile);
  }

  public static Uri getUriForQualifiedResource(String paramString, int paramInt)
  {
    return new Uri.Builder().scheme("android.resource").authority(paramString).path(String.valueOf(paramInt)).build();
  }

  public static Uri getUriForResourceId(int paramInt)
  {
    return new Uri.Builder().scheme("res").path(String.valueOf(paramInt)).build();
  }

  public static boolean isDataUri(@Nullable Uri paramUri)
  {
    return "data".equals(getSchemeOrNull(paramUri));
  }

  public static boolean isLocalAssetUri(@Nullable Uri paramUri)
  {
    return "asset".equals(getSchemeOrNull(paramUri));
  }

  public static boolean isLocalCameraUri(Uri paramUri)
  {
    String str = paramUri.toString();
    return (str.startsWith(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString())) || (str.startsWith(MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString()));
  }

  public static boolean isLocalContactUri(Uri paramUri)
  {
    return (isLocalContentUri(paramUri)) && ("com.android.contacts".equals(paramUri.getAuthority())) && (!paramUri.getPath().startsWith(LOCAL_CONTACT_IMAGE_URI.getPath()));
  }

  public static boolean isLocalContentUri(@Nullable Uri paramUri)
  {
    return "content".equals(getSchemeOrNull(paramUri));
  }

  public static boolean isLocalFileUri(@Nullable Uri paramUri)
  {
    return "file".equals(getSchemeOrNull(paramUri));
  }

  public static boolean isLocalResourceUri(@Nullable Uri paramUri)
  {
    return "res".equals(getSchemeOrNull(paramUri));
  }

  public static boolean isNetworkUri(@Nullable Uri paramUri)
  {
    String str = getSchemeOrNull(paramUri);
    return ("https".equals(str)) || ("http".equals(str));
  }

  public static boolean isQualifiedResourceUri(@Nullable Uri paramUri)
  {
    return "android.resource".equals(getSchemeOrNull(paramUri));
  }

  public static Uri parseUriOrNull(@Nullable String paramString)
  {
    if (paramString != null)
      return Uri.parse(paramString);
    return null;
  }

  @Nullable
  public static URL uriToUrl(@Nullable Uri paramUri)
  {
    if (paramUri == null)
      return null;
    try
    {
      URL localURL = new URL(paramUri.toString());
      return localURL;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new RuntimeException(localMalformedURLException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.util.UriUtil
 * JD-Core Version:    0.6.2
 */