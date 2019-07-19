package com.facebook.react.modules.camera;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

@ReactModule(name="ImageEditingManager")
public class ImageEditingManager extends ReactContextBaseJavaModule
{
  private static final int COMPRESS_QUALITY = 90;

  @SuppressLint({"InlinedApi"})
  private static final String[] EXIF_ATTRIBUTES = { "FNumber", "DateTime", "DateTimeDigitized", "ExposureTime", "Flash", "FocalLength", "GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp", "ImageLength", "ImageWidth", "ISOSpeedRatings", "Make", "Model", "Orientation", "SubSecTime", "SubSecTimeDigitized", "SubSecTimeOriginal", "WhiteBalance" };
  private static final List<String> LOCAL_URI_PREFIXES = Arrays.asList(new String[] { "file://", "content://" });
  protected static final String NAME = "ImageEditingManager";
  private static final String TEMP_FILE_PREFIX = "ReactNative_cropped_image_";

  public ImageEditingManager(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
    new CleanTask(getReactApplicationContext(), null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }

  private static void copyExif(Context paramContext, Uri paramUri, File paramFile)
    throws IOException
  {
    File localFile = getFileFromUri(paramContext, paramUri);
    if (localFile == null)
    {
      FLog.w("ReactNative", "Couldn't get real path for uri: " + paramUri);
      return;
    }
    ExifInterface localExifInterface1 = new ExifInterface(localFile.getAbsolutePath());
    ExifInterface localExifInterface2 = new ExifInterface(paramFile.getAbsolutePath());
    for (String str1 : EXIF_ATTRIBUTES)
    {
      String str2 = localExifInterface1.getAttribute(str1);
      if (str2 != null)
        localExifInterface2.setAttribute(str1, str2);
    }
    localExifInterface2.saveAttributes();
  }

  private static File createTempFile(Context paramContext, @Nullable String paramString)
    throws IOException
  {
    Object localObject = paramContext.getExternalCacheDir();
    File localFile = paramContext.getCacheDir();
    if ((localObject == null) && (localFile == null))
      throw new IOException("No cache directory available");
    if (localObject == null);
    for (localObject = localFile; ; localObject = localFile)
      do
        return File.createTempFile("ReactNative_cropped_image_", getFileExtensionForType(paramString), (File)localObject);
      while ((localFile == null) || (((File)localObject).getFreeSpace() > localFile.getFreeSpace()));
  }

  private static Bitmap.CompressFormat getCompressFormatForType(String paramString)
  {
    if ("image/png".equals(paramString))
      return Bitmap.CompressFormat.PNG;
    if ("image/webp".equals(paramString))
      return Bitmap.CompressFormat.WEBP;
    return Bitmap.CompressFormat.JPEG;
  }

  private static int getDecodeSampleSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 1;
    if ((paramInt2 > paramInt3) || (paramInt1 > paramInt4))
    {
      int j = paramInt2 / 2;
      int k = paramInt1 / 2;
      while ((k / i >= paramInt3) && (j / i >= paramInt4))
        i *= 2;
    }
    return i;
  }

  private static String getFileExtensionForType(@Nullable String paramString)
  {
    if ("image/png".equals(paramString))
      return ".png";
    if ("image/webp".equals(paramString))
      return ".webp";
    return ".jpg";
  }

  @Nullable
  private static File getFileFromUri(Context paramContext, Uri paramUri)
  {
    File localFile1;
    if (paramUri.getScheme().equals("file"))
      localFile1 = new File(paramUri.getPath());
    Cursor localCursor;
    do
    {
      boolean bool;
      do
      {
        return localFile1;
        bool = paramUri.getScheme().equals("content");
        localFile1 = null;
      }
      while (!bool);
      localCursor = paramContext.getContentResolver().query(paramUri, new String[] { "_data" }, null, null, null);
      localFile1 = null;
    }
    while (localCursor == null);
    try
    {
      if (localCursor.moveToFirst())
      {
        String str = localCursor.getString(0);
        if (!TextUtils.isEmpty(str))
        {
          File localFile2 = new File(str);
          return localFile2;
        }
      }
      return null;
    }
    finally
    {
      localCursor.close();
    }
  }

  private static boolean isLocalUri(String paramString)
  {
    Iterator localIterator = LOCAL_URI_PREFIXES.iterator();
    while (localIterator.hasNext())
      if (paramString.startsWith((String)localIterator.next()))
        return true;
    return false;
  }

  private static void writeCompressedBitmapToFile(Bitmap paramBitmap, String paramString, File paramFile)
    throws IOException
  {
    FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
    try
    {
      paramBitmap.compress(getCompressFormatForType(paramString), 90, localFileOutputStream);
      return;
    }
    finally
    {
      if (localFileOutputStream != null)
        localFileOutputStream.close();
    }
  }

  @ReactMethod
  public void cropImage(String paramString, ReadableMap paramReadableMap, Callback paramCallback1, Callback paramCallback2)
  {
    ReadableMap localReadableMap1;
    if (paramReadableMap.hasKey("offset"))
    {
      localReadableMap1 = paramReadableMap.getMap("offset");
      if (!paramReadableMap.hasKey("size"))
        break label125;
    }
    label125: for (ReadableMap localReadableMap2 = paramReadableMap.getMap("size"); ; localReadableMap2 = null)
    {
      if ((localReadableMap1 != null) && (localReadableMap2 != null) && (localReadableMap1.hasKey("x")) && (localReadableMap1.hasKey("y")) && (localReadableMap2.hasKey("width")) && (localReadableMap2.hasKey("height")))
        break label131;
      throw new JSApplicationIllegalArgumentException("Please specify offset and size");
      localReadableMap1 = null;
      break;
    }
    label131: if ((paramString == null) || (paramString.isEmpty()))
      throw new JSApplicationIllegalArgumentException("Please specify a URI");
    CropTask localCropTask = new CropTask(getReactApplicationContext(), paramString, (int)localReadableMap1.getDouble("x"), (int)localReadableMap1.getDouble("y"), (int)localReadableMap2.getDouble("width"), (int)localReadableMap2.getDouble("height"), paramCallback1, paramCallback2, null);
    if (paramReadableMap.hasKey("displaySize"))
    {
      ReadableMap localReadableMap3 = paramReadableMap.getMap("displaySize");
      localCropTask.setTargetSize((int)localReadableMap3.getDouble("width"), (int)localReadableMap3.getDouble("height"));
    }
    localCropTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }

  public Map<String, Object> getConstants()
  {
    return Collections.emptyMap();
  }

  public String getName()
  {
    return "ImageEditingManager";
  }

  public void onCatalystInstanceDestroy()
  {
    new CleanTask(getReactApplicationContext(), null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }

  private static class CleanTask extends GuardedAsyncTask<Void, Void>
  {
    private final Context mContext;

    private CleanTask(ReactContext paramReactContext)
    {
      super();
      this.mContext = paramReactContext;
    }

    private void cleanDirectory(File paramFile)
    {
      File[] arrayOfFile = paramFile.listFiles(new FilenameFilter()
      {
        public boolean accept(File paramAnonymousFile, String paramAnonymousString)
        {
          return paramAnonymousString.startsWith("ReactNative_cropped_image_");
        }
      });
      if (arrayOfFile != null)
      {
        int i = arrayOfFile.length;
        for (int j = 0; j < i; j++)
          arrayOfFile[j].delete();
      }
    }

    protected void doInBackgroundGuarded(Void[] paramArrayOfVoid)
    {
      cleanDirectory(this.mContext.getCacheDir());
      File localFile = this.mContext.getExternalCacheDir();
      if (localFile != null)
        cleanDirectory(localFile);
    }
  }

  private static class CropTask extends GuardedAsyncTask<Void, Void>
  {
    final Context mContext;
    final Callback mError;
    final int mHeight;
    final Callback mSuccess;
    int mTargetHeight = 0;
    int mTargetWidth = 0;
    final String mUri;
    final int mWidth;
    final int mX;
    final int mY;

    private CropTask(ReactContext paramReactContext, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Callback paramCallback1, Callback paramCallback2)
    {
      super();
      if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 <= 0) || (paramInt4 <= 0))
      {
        Object[] arrayOfObject = new Object[4];
        arrayOfObject[0] = Integer.valueOf(paramInt1);
        arrayOfObject[1] = Integer.valueOf(paramInt2);
        arrayOfObject[2] = Integer.valueOf(paramInt3);
        arrayOfObject[3] = Integer.valueOf(paramInt4);
        throw new JSApplicationIllegalArgumentException(String.format("Invalid crop rectangle: [%d, %d, %d, %d]", arrayOfObject));
      }
      this.mContext = paramReactContext;
      this.mUri = paramString;
      this.mX = paramInt1;
      this.mY = paramInt2;
      this.mWidth = paramInt3;
      this.mHeight = paramInt4;
      this.mSuccess = paramCallback1;
      this.mError = paramCallback2;
    }

    private Bitmap crop(BitmapFactory.Options paramOptions)
      throws IOException
    {
      InputStream localInputStream = openBitmapInputStream();
      BitmapRegionDecoder localBitmapRegionDecoder = BitmapRegionDecoder.newInstance(localInputStream, false);
      try
      {
        Bitmap localBitmap = localBitmapRegionDecoder.decodeRegion(new Rect(this.mX, this.mY, this.mX + this.mWidth, this.mY + this.mHeight), paramOptions);
        return localBitmap;
      }
      finally
      {
        if (localInputStream != null)
          localInputStream.close();
        localBitmapRegionDecoder.recycle();
      }
    }

    private Bitmap cropAndResize(int paramInt1, int paramInt2, BitmapFactory.Options paramOptions)
      throws IOException
    {
      Assertions.assertNotNull(paramOptions);
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      InputStream localInputStream1 = openBitmapInputStream();
      float f7;
      float f8;
      float f9;
      float f10;
      float f11;
      InputStream localInputStream2;
      Bitmap localBitmap;
      while (true)
      {
        float f2;
        try
        {
          BitmapFactory.decodeStream(localInputStream1, null, localOptions);
          if (localInputStream1 != null)
            localInputStream1.close();
          float f1 = this.mWidth / this.mHeight;
          f2 = paramInt1 / paramInt2;
          if (f1 > f2)
          {
            float f13 = f2 * this.mHeight;
            float f14 = this.mHeight;
            float f15 = this.mX + (this.mWidth - f13) / 2.0F;
            float f16 = this.mY;
            f7 = paramInt2 / this.mHeight;
            f8 = f15;
            f9 = f16;
            f10 = f13;
            f11 = f14;
            paramOptions.inSampleSize = ImageEditingManager.getDecodeSampleSize(this.mWidth, this.mHeight, paramInt1, paramInt2);
            localOptions.inJustDecodeBounds = false;
            localInputStream2 = openBitmapInputStream();
            try
            {
              localBitmap = BitmapFactory.decodeStream(localInputStream2, null, paramOptions);
              if (localBitmap != null)
                break;
              throw new IOException("Cannot decode bitmap: " + this.mUri);
            }
            finally
            {
              if (localInputStream2 != null)
                localInputStream2.close();
            }
          }
        }
        finally
        {
          if (localInputStream1 != null)
            localInputStream1.close();
        }
        float f3 = this.mWidth;
        float f4 = this.mWidth / f2;
        float f5 = this.mX;
        float f6 = this.mY + (this.mHeight - f4) / 2.0F;
        f7 = paramInt1 / this.mWidth;
        f8 = f5;
        f9 = f6;
        f10 = f3;
        f11 = f4;
      }
      if (localInputStream2 != null)
        localInputStream2.close();
      int i = (int)Math.floor(f8 / paramOptions.inSampleSize);
      int j = (int)Math.floor(f9 / paramOptions.inSampleSize);
      int k = (int)Math.floor(f10 / paramOptions.inSampleSize);
      int m = (int)Math.floor(f11 / paramOptions.inSampleSize);
      float f12 = f7 * paramOptions.inSampleSize;
      Matrix localMatrix = new Matrix();
      localMatrix.setScale(f12, f12);
      return Bitmap.createBitmap(localBitmap, i, j, k, m, localMatrix, true);
    }

    private InputStream openBitmapInputStream()
      throws IOException
    {
      if (ImageEditingManager.isLocalUri(this.mUri));
      for (InputStream localInputStream = this.mContext.getContentResolver().openInputStream(Uri.parse(this.mUri)); localInputStream == null; localInputStream = new URL(this.mUri).openConnection().getInputStream())
        throw new IOException("Cannot open bitmap: " + this.mUri);
      return localInputStream;
    }

    protected void doInBackgroundGuarded(Void[] paramArrayOfVoid)
    {
      Bitmap localBitmap;
      String str;
      while (true)
      {
        BitmapFactory.Options localOptions;
        try
        {
          localOptions = new BitmapFactory.Options();
          if ((this.mTargetWidth > 0) && (this.mTargetHeight > 0))
          {
            i = 1;
            if (i == 0)
              break label111;
            localBitmap = cropAndResize(this.mTargetWidth, this.mTargetHeight, localOptions);
            str = localOptions.outMimeType;
            if ((str != null) && (!str.isEmpty()))
              break;
            throw new IOException("Could not determine MIME type");
          }
        }
        catch (Exception localException)
        {
          Callback localCallback1 = this.mError;
          Object[] arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = localException.getMessage();
          localCallback1.invoke(arrayOfObject1);
          return;
        }
        int i = 0;
        continue;
        label111: localBitmap = crop(localOptions);
      }
      File localFile = ImageEditingManager.createTempFile(this.mContext, str);
      ImageEditingManager.writeCompressedBitmapToFile(localBitmap, str, localFile);
      if (str.equals("image/jpeg"))
        ImageEditingManager.copyExif(this.mContext, Uri.parse(this.mUri), localFile);
      Callback localCallback2 = this.mSuccess;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Uri.fromFile(localFile).toString();
      localCallback2.invoke(arrayOfObject2);
    }

    public void setTargetSize(int paramInt1, int paramInt2)
    {
      if ((paramInt1 <= 0) || (paramInt2 <= 0))
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = Integer.valueOf(paramInt1);
        arrayOfObject[1] = Integer.valueOf(paramInt2);
        throw new JSApplicationIllegalArgumentException(String.format("Invalid target size: [%d, %d]", arrayOfObject));
      }
      this.mTargetWidth = paramInt1;
      this.mTargetHeight = paramInt2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.camera.ImageEditingManager
 * JD-Core Version:    0.6.2
 */