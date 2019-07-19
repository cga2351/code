package com.viber.voip.sound;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import com.viber.voip.util.dv;
import java.io.File;
import java.io.FileNotFoundException;

public class RingtoneProvider extends ContentProvider
{
  public static final String AUTHORITY = "com.viber.voip.provider.ringtone";
  private static final int CODE_NOTIFICATION = 1;
  private static final int CODE_RINGTONE = 2;
  private static final String[] COLUMNS = { "title", "_display_name", "_size" };
  private static final String CONTENT_AUTHORITY_SLASH = "content://com.viber.voip.provider.ringtone/";
  static final String LOG_TAG = "RingtoneProvider";
  private static final String MIME_TYPE_RINGTONE = "audio/mpeg";
  private static Uri NOTIFICATION_CONTENT_URI;
  private static final String NOTIFICATION_PATH = "notification";
  private static final String RINGTONE_PATH = "ringtone";
  private static UriMatcher URI_MATCHER;

  private static Object[] copyOf(Object[] paramArrayOfObject, int paramInt)
  {
    Object[] arrayOfObject = new Object[paramInt];
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, paramInt);
    return arrayOfObject;
  }

  private static String[] copyOf(String[] paramArrayOfString, int paramInt)
  {
    String[] arrayOfString = new String[paramInt];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramInt);
    return arrayOfString;
  }

  private static Uri getNotificationContentUri()
  {
    if (NOTIFICATION_CONTENT_URI == null)
      NOTIFICATION_CONTENT_URI = Uri.parse("content://com.viber.voip.provider.ringtone/notification");
    return NOTIFICATION_CONTENT_URI;
  }

  public static Uri getNotificationContentUri(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    return Uri.withAppendedPath(getNotificationContentUri(), paramString);
  }

  private UriMatcher getUriMatcher()
  {
    if (URI_MATCHER == null);
    try
    {
      if (URI_MATCHER == null)
      {
        UriMatcher localUriMatcher = new UriMatcher(-1);
        localUriMatcher.addURI("com.viber.voip.provider.ringtone", "notification/*", 1);
        localUriMatcher.addURI("com.viber.voip.provider.ringtone", "ringtone/*", 2);
        URI_MATCHER = localUriMatcher;
      }
      return URI_MATCHER;
    }
    finally
    {
    }
  }

  private String obtainSoundTitle(File paramFile)
  {
    Object localObject = null;
    if (paramFile != null)
    {
      boolean bool = paramFile.exists();
      localObject = null;
      if (bool)
        break label19;
    }
    while (true)
    {
      return localObject;
      label19: MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      try
      {
        localMediaMetadataRetriever.setDataSource(paramFile.getPath());
        String str = localMediaMetadataRetriever.extractMetadata(7);
        localObject = str;
        if (!TextUtils.isEmpty((CharSequence)localObject))
          continue;
        return paramFile.getName();
      }
      catch (RuntimeException localRuntimeException)
      {
        while (true)
        {
          Log.e("RingtoneProvider", "obtainSoundTitle: unable to extract sound metadata", localRuntimeException);
          localObject = null;
        }
      }
    }
  }

  private File uriToFile(Uri paramUri, Context paramContext)
  {
    switch (getUriMatcher().match(paramUri))
    {
    default:
      return null;
    case 1:
      return dv.O.b(paramContext, paramUri.getLastPathSegment());
    case 2:
    }
    return dv.P.b(paramContext, paramUri.getLastPathSegment());
  }

  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("No external deletes");
  }

  public String getType(Uri paramUri)
  {
    Log.d("RingtoneProvider", "getType() called with: uri = [" + paramUri + "]");
    switch (getUriMatcher().match(paramUri))
    {
    default:
      return null;
    case 1:
    case 2:
    }
    return "audio/mpeg";
  }

  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    throw new UnsupportedOperationException("No external inserts");
  }

  public boolean onCreate()
  {
    Log.d("RingtoneProvider", "onCreate() called");
    return true;
  }

  public AssetFileDescriptor openAssetFile(Uri paramUri, String paramString)
    throws FileNotFoundException
  {
    Log.d("RingtoneProvider", "openAssetFile() called with: uri = [" + paramUri + "], mode = [" + paramString + "]");
    ParcelFileDescriptor localParcelFileDescriptor = openFile(paramUri, paramString);
    if (localParcelFileDescriptor != null)
      return new AssetFileDescriptor(localParcelFileDescriptor, 0L, -1L);
    return null;
  }

  public AssetFileDescriptor openAssetFile(Uri paramUri, String paramString, CancellationSignal paramCancellationSignal)
    throws FileNotFoundException
  {
    Log.d("RingtoneProvider", "openAssetFile() called with: uri = [" + paramUri + "], mode = [" + paramString + "], signal = [" + paramCancellationSignal + "]");
    return openAssetFile(paramUri, paramString);
  }

  public ParcelFileDescriptor openFile(Uri paramUri, String paramString)
    throws FileNotFoundException
  {
    Log.d("RingtoneProvider", "openFile() called with: uri = [" + paramUri + "], mode = [" + paramString + "]");
    if (!"r".equals(paramString))
      throw new IllegalArgumentException("mode must be \"r\"");
    Context localContext = getContext();
    if (localContext == null)
      throw new IllegalStateException("Context is not available to open file");
    File localFile = uriToFile(paramUri, localContext);
    if (localFile == null)
      return super.openFile(paramUri, paramString);
    return ParcelFileDescriptor.open(localFile, 268435456);
  }

  public ParcelFileDescriptor openFile(Uri paramUri, String paramString, CancellationSignal paramCancellationSignal)
    throws FileNotFoundException
  {
    Log.d("RingtoneProvider", "openFile() called with: uri = [" + paramUri + "], mode = [" + paramString + "], signal = [" + paramCancellationSignal + "]");
    return openFile(paramUri, paramString);
  }

  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    Context localContext = getContext();
    if (localContext == null)
      throw new IllegalStateException("Context is not available to query ringtone info");
    File localFile = uriToFile(paramUri, localContext);
    String str1 = obtainSoundTitle(localFile);
    if (paramArrayOfString1 == null)
      paramArrayOfString1 = COLUMNS;
    String[] arrayOfString1 = new String[paramArrayOfString1.length];
    Object[] arrayOfObject1 = new Object[paramArrayOfString1.length];
    int i = paramArrayOfString1.length;
    int j = 0;
    int k = 0;
    String str2;
    int m;
    if (j < i)
    {
      str2 = paramArrayOfString1[j];
      if ("_display_name".equals(str2))
      {
        arrayOfString1[k] = "_display_name";
        m = k + 1;
        arrayOfObject1[k] = str1;
      }
    }
    while (true)
    {
      j++;
      k = m;
      break;
      if ("_size".equals(str2))
      {
        arrayOfString1[k] = "_size";
        int n = k + 1;
        if ((localFile != null) && (localFile.exists()));
        for (long l = localFile.length(); ; l = 0L)
        {
          arrayOfObject1[k] = Long.valueOf(l);
          m = n;
          break;
        }
      }
      if ("title".equals(str2))
      {
        arrayOfString1[k] = "title";
        m = k + 1;
        arrayOfObject1[k] = str1;
        continue;
        String[] arrayOfString2 = copyOf(arrayOfString1, k);
        Object[] arrayOfObject2 = copyOf(arrayOfObject1, k);
        MatrixCursor localMatrixCursor = new MatrixCursor(arrayOfString2, 1);
        localMatrixCursor.addRow(arrayOfObject2);
        return localMatrixCursor;
      }
      else
      {
        m = k;
      }
    }
  }

  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("No external updates");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.RingtoneProvider
 * JD-Core Version:    0.6.2
 */