package com.viber.liblinkparser;

import android.text.TextUtils;
import com.viber.common.a.e;
import com.viber.common.a.f;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class LinkParser
{
  private static final Charset CHARSET_UTF_8;
  private static final e L;

  static
  {
    int i = 0;
    L = f.b();
    String[] arrayOfString = { "icuBinder", "linkparser" };
    try
    {
      Class localClass = Class.forName("com.viber.common.jni.NativeLibraryLoader");
      Class[] arrayOfClass = new Class[2];
      arrayOfClass[0] = String.class;
      arrayOfClass[1] = Boolean.TYPE;
      Method localMethod = localClass.getMethod("loadLibrary", arrayOfClass);
      int k = arrayOfString.length;
      for (int m = 0; m < k; m++)
      {
        String str = arrayOfString[m];
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = str;
        arrayOfObject[1] = Boolean.valueOf(false);
        localMethod.invoke(null, arrayOfObject);
      }
    }
    catch (Throwable localThrowable)
    {
      int j = arrayOfString.length;
      while (i < j)
      {
        System.loadLibrary(arrayOfString[i]);
        i++;
      }
      CHARSET_UTF_8 = Charset.forName("UTF-8");
    }
  }

  private static Http createHttp()
  {
    return new AndroidHttp();
  }

  public static Preview generatePreview(String paramString)
  {
    L.b("generatePreview, link: ?", new Object[] { paramString });
    Preview localPreview = nativeGeneratePreview(paramString, createHttp());
    L.b("generatePreview, result: ?", new Object[] { localPreview });
    if (!localPreview.isValid())
      localPreview = null;
    return localPreview;
  }

  private static byte[] getUtf8Bytes(String paramString)
  {
    byte[] arrayOfByte = null;
    if (paramString != null)
    {
      int i = paramString.length();
      arrayOfByte = null;
      if (i > 0)
        arrayOfByte = paramString.getBytes(CHARSET_UTF_8);
    }
    return arrayOfByte;
  }

  public static boolean isDirectMediaLink(String paramString1, String paramString2)
  {
    return nativeIsDirectMediaLink(paramString1, paramString2);
  }

  public static boolean isEmbeddedMedia(String paramString, int paramInt)
  {
    return nativeIsEmbeddedMedia(paramString, paramInt);
  }

  private static native Preview nativeGeneratePreview(String paramString, Http paramHttp);

  private static native boolean nativeIsDirectMediaLink(String paramString1, String paramString2);

  private static native boolean nativeIsEmbeddedMedia(String paramString, int paramInt);

  private static native ArrayList<LinkSpec> nativeParseText(String paramString, int paramInt);

  public static ArrayList<LinkSpec> parseText(String paramString, LinkParser.LinkSpec.Type paramType)
  {
    return nativeParseText(paramString, paramType.ordinal());
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EmbeddedMediaType
  {
    public static final int ALL = 0;
    public static final int VK = 2;
    public static final int YOUTUBE = 1;
  }

  public static class LinkSpec
  {
    public final int end;
    public final int start;
    public final Type type;

    private LinkSpec(int paramInt1, int paramInt2, int paramInt3)
    {
      this.start = paramInt1;
      this.end = paramInt2;
      this.type = Type.values()[paramInt3];
    }

    public String toString()
    {
      return "LinkSpec{, start=" + this.start + ", end=" + this.end + ", type=" + this.type + '}';
    }

    public static enum Type
    {
      static
      {
        EMAIL = new Type("EMAIL", 2);
        PHONE = new Type("PHONE", 3);
        VIBER = new Type("VIBER", 4);
        Type[] arrayOfType = new Type[5];
        arrayOfType[0] = ALL;
        arrayOfType[1] = WEB;
        arrayOfType[2] = EMAIL;
        arrayOfType[3] = PHONE;
        arrayOfType[4] = VIBER;
      }
    }
  }

  public static class Preview
  {
    public final int contentLength;
    public final String contentType;
    public final String error;
    public final String thumbnail;
    public final String thumbnailContentType;
    public final String title;
    public final String type;
    public final String url;
    public final String videoType;
    public final String videoUrl;

    public Preview(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      this.title = paramString1;
      this.type = paramString2;
      this.url = paramString3;
      this.thumbnail = paramString4;
      this.thumbnailContentType = paramString9;
      this.contentType = paramString5;
      this.contentLength = paramInt;
      this.error = paramString6;
      this.videoUrl = paramString7;
      this.videoType = paramString8;
    }

    public boolean isValid()
    {
      return TextUtils.isEmpty(this.error);
    }

    public String toString()
    {
      return "Preview{title='" + this.title + '\'' + ", type='" + this.type + '\'' + ", url='" + this.url + '\'' + ", thumbnail='" + this.thumbnail + '\'' + ", thumbnailContentType='" + this.thumbnailContentType + '\'' + ", contentType='" + this.contentType + '\'' + ", contentLength=" + this.contentLength + ", error='" + this.error + '\'' + ", videoUrl='" + this.videoUrl + '\'' + ", videoType='" + this.videoType + '\'' + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.liblinkparser.LinkParser
 * JD-Core Version:    0.6.2
 */