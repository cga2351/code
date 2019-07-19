package com.facebook.react.modules.camera;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore.Files;
import android.text.TextUtils;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

@ReactModule(name="CameraRollManager")
public class CameraRollManager extends ReactContextBaseJavaModule
{
  private static final String ASSET_TYPE_ALL = "All";
  private static final String ASSET_TYPE_PHOTOS = "Photos";
  private static final String ASSET_TYPE_VIDEOS = "Videos";
  private static final String ERROR_UNABLE_TO_FILTER = "E_UNABLE_TO_FILTER";
  private static final String ERROR_UNABLE_TO_LOAD = "E_UNABLE_TO_LOAD";
  private static final String ERROR_UNABLE_TO_LOAD_PERMISSION = "E_UNABLE_TO_LOAD_PERMISSION";
  private static final String ERROR_UNABLE_TO_SAVE = "E_UNABLE_TO_SAVE";
  public static final String NAME = "CameraRollManager";
  private static final String[] PROJECTION = { "_id", "mime_type", "bucket_display_name", "datetaken", "width", "height", "longitude", "latitude", "_data" };
  private static final String SELECTION_BUCKET = "bucket_display_name = ?";
  private static final String SELECTION_DATE_TAKEN = "datetaken < ?";

  public CameraRollManager(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  private static void putBasicNodeInfo(Cursor paramCursor, WritableMap paramWritableMap, int paramInt1, int paramInt2, int paramInt3)
  {
    paramWritableMap.putString("type", paramCursor.getString(paramInt1));
    paramWritableMap.putString("group_name", paramCursor.getString(paramInt2));
    paramWritableMap.putDouble("timestamp", paramCursor.getLong(paramInt3) / 1000.0D);
  }

  private static void putEdges(ContentResolver paramContentResolver, Cursor paramCursor, WritableMap paramWritableMap, int paramInt)
  {
    WritableNativeArray localWritableNativeArray = new WritableNativeArray();
    paramCursor.moveToFirst();
    int i = paramCursor.getColumnIndex("_id");
    int j = paramCursor.getColumnIndex("mime_type");
    int k = paramCursor.getColumnIndex("bucket_display_name");
    int m = paramCursor.getColumnIndex("datetaken");
    int n = paramCursor.getColumnIndex("width");
    int i1 = paramCursor.getColumnIndex("height");
    int i2 = paramCursor.getColumnIndex("longitude");
    int i3 = paramCursor.getColumnIndex("latitude");
    int i4 = paramCursor.getColumnIndex("_data");
    int i5 = 0;
    if ((i5 < paramInt) && (!paramCursor.isAfterLast()))
    {
      WritableNativeMap localWritableNativeMap1 = new WritableNativeMap();
      WritableNativeMap localWritableNativeMap2 = new WritableNativeMap();
      if (putImageInfo(paramContentResolver, paramCursor, localWritableNativeMap2, i, n, i1, i4))
      {
        putBasicNodeInfo(paramCursor, localWritableNativeMap2, j, k, m);
        putLocationInfo(paramCursor, localWritableNativeMap2, i2, i3);
        localWritableNativeMap1.putMap("node", localWritableNativeMap2);
        localWritableNativeArray.pushMap(localWritableNativeMap1);
      }
      for (int i6 = i5; ; i6 = i5 - 1)
      {
        paramCursor.moveToNext();
        i5 = i6 + 1;
        break;
      }
    }
    paramWritableMap.putArray("edges", localWritableNativeArray);
  }

  // ERROR //
  private static boolean putImageInfo(ContentResolver paramContentResolver, Cursor paramCursor, WritableMap paramWritableMap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: new 126	com/facebook/react/bridge/WritableNativeMap
    //   3: dup
    //   4: invokespecial 127	com/facebook/react/bridge/WritableNativeMap:<init>	()V
    //   7: astore 7
    //   9: new 166	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   16: ldc 169
    //   18: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: iload 6
    //   24: invokeinterface 89 2 0
    //   29: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 183	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   38: astore 8
    //   40: aload 7
    //   42: ldc 185
    //   44: aload 8
    //   46: invokevirtual 186	android/net/Uri:toString	()Ljava/lang/String;
    //   49: invokeinterface 95 3 0
    //   54: aload_1
    //   55: iload 4
    //   57: invokeinterface 190 2 0
    //   62: i2f
    //   63: fstore 9
    //   65: aload_1
    //   66: iload 5
    //   68: invokeinterface 190 2 0
    //   73: i2f
    //   74: fstore 10
    //   76: aload 8
    //   78: invokevirtual 186	android/net/Uri:toString	()Ljava/lang/String;
    //   81: invokestatic 196	java/net/URLConnection:guessContentTypeFromName	(Ljava/lang/String;)Ljava/lang/String;
    //   84: astore 11
    //   86: aload 11
    //   88: ifnull +115 -> 203
    //   91: aload 11
    //   93: ldc 198
    //   95: invokevirtual 202	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   98: ifeq +105 -> 203
    //   101: aload_0
    //   102: aload 8
    //   104: ldc 204
    //   106: invokevirtual 210	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   109: astore 17
    //   111: new 212	android/media/MediaMetadataRetriever
    //   114: dup
    //   115: invokespecial 213	android/media/MediaMetadataRetriever:<init>	()V
    //   118: astore 18
    //   120: aload 18
    //   122: aload 17
    //   124: invokevirtual 219	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   127: invokevirtual 223	android/media/MediaMetadataRetriever:setDataSource	(Ljava/io/FileDescriptor;)V
    //   130: fload 9
    //   132: fconst_0
    //   133: fcmpg
    //   134: ifle +10 -> 144
    //   137: fload 10
    //   139: fconst_0
    //   140: fcmpg
    //   141: ifgt +29 -> 170
    //   144: aload 18
    //   146: bipush 18
    //   148: invokevirtual 226	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   151: invokestatic 231	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   154: i2f
    //   155: fstore 9
    //   157: aload 18
    //   159: bipush 19
    //   161: invokevirtual 226	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   164: invokestatic 231	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   167: i2f
    //   168: fstore 10
    //   170: aload 7
    //   172: ldc 233
    //   174: aload 18
    //   176: bipush 9
    //   178: invokevirtual 226	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   181: invokestatic 231	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   184: sipush 1000
    //   187: idiv
    //   188: invokeinterface 237 3 0
    //   193: aload 18
    //   195: invokevirtual 240	android/media/MediaMetadataRetriever:release	()V
    //   198: aload 17
    //   200: invokevirtual 243	android/content/res/AssetFileDescriptor:close	()V
    //   203: fload 9
    //   205: fconst_0
    //   206: fcmpg
    //   207: ifle +10 -> 217
    //   210: fload 10
    //   212: fconst_0
    //   213: fcmpg
    //   214: ifgt +61 -> 275
    //   217: aload_0
    //   218: aload 8
    //   220: ldc 204
    //   222: invokevirtual 210	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   225: astore 13
    //   227: new 245	android/graphics/BitmapFactory$Options
    //   230: dup
    //   231: invokespecial 246	android/graphics/BitmapFactory$Options:<init>	()V
    //   234: astore 14
    //   236: aload 14
    //   238: iconst_1
    //   239: putfield 250	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   242: aload 13
    //   244: invokevirtual 219	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   247: aconst_null
    //   248: aload 14
    //   250: invokestatic 256	android/graphics/BitmapFactory:decodeFileDescriptor	(Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   253: pop
    //   254: aload 14
    //   256: getfield 260	android/graphics/BitmapFactory$Options:outWidth	I
    //   259: i2f
    //   260: fstore 9
    //   262: aload 14
    //   264: getfield 263	android/graphics/BitmapFactory$Options:outHeight	I
    //   267: i2f
    //   268: fstore 10
    //   270: aload 13
    //   272: invokevirtual 243	android/content/res/AssetFileDescriptor:close	()V
    //   275: aload 7
    //   277: ldc 53
    //   279: fload 9
    //   281: f2d
    //   282: invokeinterface 109 4 0
    //   287: aload 7
    //   289: ldc 55
    //   291: fload 10
    //   293: f2d
    //   294: invokeinterface 109 4 0
    //   299: aload_2
    //   300: ldc_w 265
    //   303: aload 7
    //   305: invokeinterface 143 3 0
    //   310: iconst_1
    //   311: ireturn
    //   312: astore 20
    //   314: ldc_w 267
    //   317: new 166	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   324: ldc_w 269
    //   327: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload 8
    //   332: invokevirtual 186	android/net/Uri:toString	()Ljava/lang/String;
    //   335: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: aload 20
    //   343: invokestatic 275	com/facebook/common/logging/FLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   346: aload 18
    //   348: invokevirtual 240	android/media/MediaMetadataRetriever:release	()V
    //   351: aload 17
    //   353: invokevirtual 243	android/content/res/AssetFileDescriptor:close	()V
    //   356: iconst_0
    //   357: ireturn
    //   358: astore 16
    //   360: ldc_w 267
    //   363: new 166	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   370: ldc_w 277
    //   373: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: aload 8
    //   378: invokevirtual 186	android/net/Uri:toString	()Ljava/lang/String;
    //   381: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: aload 16
    //   389: invokestatic 275	com/facebook/common/logging/FLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   392: iconst_0
    //   393: ireturn
    //   394: astore 19
    //   396: aload 18
    //   398: invokevirtual 240	android/media/MediaMetadataRetriever:release	()V
    //   401: aload 17
    //   403: invokevirtual 243	android/content/res/AssetFileDescriptor:close	()V
    //   406: aload 19
    //   408: athrow
    //   409: astore 12
    //   411: ldc_w 267
    //   414: new 166	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   421: ldc_w 279
    //   424: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload 8
    //   429: invokevirtual 186	android/net/Uri:toString	()Ljava/lang/String;
    //   432: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: aload 12
    //   440: invokestatic 275	com/facebook/common/logging/FLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   443: iconst_0
    //   444: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   144	170	312	java/lang/NumberFormatException
    //   170	193	312	java/lang/NumberFormatException
    //   101	130	358	java/lang/Exception
    //   193	203	358	java/lang/Exception
    //   346	356	358	java/lang/Exception
    //   396	409	358	java/lang/Exception
    //   144	170	394	finally
    //   170	193	394	finally
    //   314	346	394	finally
    //   217	275	409	java/io/IOException
  }

  private static void putLocationInfo(Cursor paramCursor, WritableMap paramWritableMap, int paramInt1, int paramInt2)
  {
    double d1 = paramCursor.getDouble(paramInt1);
    double d2 = paramCursor.getDouble(paramInt2);
    if ((d1 > 0.0D) || (d2 > 0.0D))
    {
      WritableNativeMap localWritableNativeMap = new WritableNativeMap();
      localWritableNativeMap.putDouble("longitude", d1);
      localWritableNativeMap.putDouble("latitude", d2);
      paramWritableMap.putMap("location", localWritableNativeMap);
    }
  }

  private static void putPageInfo(Cursor paramCursor, WritableMap paramWritableMap, int paramInt)
  {
    WritableNativeMap localWritableNativeMap = new WritableNativeMap();
    if (paramInt < paramCursor.getCount());
    for (boolean bool = true; ; bool = false)
    {
      localWritableNativeMap.putBoolean("has_next_page", bool);
      if (paramInt < paramCursor.getCount())
      {
        paramCursor.moveToPosition(paramInt - 1);
        localWritableNativeMap.putString("end_cursor", paramCursor.getString(paramCursor.getColumnIndex("datetaken")));
      }
      paramWritableMap.putMap("page_info", localWritableNativeMap);
      return;
    }
  }

  public String getName()
  {
    return "CameraRollManager";
  }

  @ReactMethod
  public void getPhotos(ReadableMap paramReadableMap, Promise paramPromise)
  {
    int i = paramReadableMap.getInt("first");
    String str1;
    String str2;
    label56: String str3;
    if (paramReadableMap.hasKey("after"))
    {
      str1 = paramReadableMap.getString("after");
      if (!paramReadableMap.hasKey("groupName"))
        break label131;
      str2 = paramReadableMap.getString("groupName");
      if (!paramReadableMap.hasKey("assetType"))
        break label137;
      str3 = paramReadableMap.getString("assetType");
      label79: if (!paramReadableMap.hasKey("mimeTypes"))
        break label144;
    }
    label131: label137: label144: for (ReadableArray localReadableArray = paramReadableMap.getArray("mimeTypes"); ; localReadableArray = null)
    {
      if (!paramReadableMap.hasKey("groupTypes"))
        break label150;
      throw new JSApplicationIllegalArgumentException("groupTypes is not supported on Android");
      str1 = null;
      break;
      str2 = null;
      break label56;
      str3 = "Photos";
      break label79;
    }
    label150: new GetMediaTask(getReactApplicationContext(), i, str1, str2, localReadableArray, str3, paramPromise, null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }

  @ReactMethod
  public void saveToCameraRoll(String paramString1, String paramString2, Promise paramPromise)
  {
    new SaveToCameraRoll(getReactApplicationContext(), Uri.parse(paramString1), paramPromise).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }

  private static class GetMediaTask extends GuardedAsyncTask<Void, Void>
  {

    @Nullable
    private final String mAfter;
    private final String mAssetType;
    private final Context mContext;
    private final int mFirst;

    @Nullable
    private final String mGroupName;

    @Nullable
    private final ReadableArray mMimeTypes;
    private final Promise mPromise;

    private GetMediaTask(ReactContext paramReactContext, int paramInt, @Nullable String paramString1, @Nullable String paramString2, @Nullable ReadableArray paramReadableArray, String paramString3, Promise paramPromise)
    {
      super();
      this.mContext = paramReactContext;
      this.mFirst = paramInt;
      this.mAfter = paramString1;
      this.mGroupName = paramString2;
      this.mMimeTypes = paramReadableArray;
      this.mPromise = paramPromise;
      this.mAssetType = paramString3;
    }

    protected void doInBackgroundGuarded(Void[] paramArrayOfVoid)
    {
      StringBuilder localStringBuilder = new StringBuilder("1");
      ArrayList localArrayList = new ArrayList();
      if (!TextUtils.isEmpty(this.mAfter))
      {
        localStringBuilder.append(" AND datetaken < ?");
        localArrayList.add(this.mAfter);
      }
      if (!TextUtils.isEmpty(this.mGroupName))
      {
        localStringBuilder.append(" AND bucket_display_name = ?");
        localArrayList.add(this.mGroupName);
      }
      if (this.mAssetType.equals("Photos"))
        localStringBuilder.append(" AND media_type = 1");
      while ((this.mMimeTypes != null) && (this.mMimeTypes.size() > 0))
      {
        localStringBuilder.append(" AND mime_type IN (");
        int i = 0;
        while (true)
          if (i < this.mMimeTypes.size())
          {
            localStringBuilder.append("?,");
            localArrayList.add(this.mMimeTypes.getString(i));
            i++;
            continue;
            if (this.mAssetType.equals("Videos"))
            {
              localStringBuilder.append(" AND media_type = 3");
              break;
            }
            if (this.mAssetType.equals("All"))
            {
              localStringBuilder.append(" AND media_type IN (3,1)");
              break;
            }
            this.mPromise.reject("E_UNABLE_TO_FILTER", "Invalid filter option: '" + this.mAssetType + "'. Expected one of '" + "Photos" + "', '" + "Videos" + "' or '" + "All" + "'.");
            return;
          }
        localStringBuilder.replace(-1 + localStringBuilder.length(), localStringBuilder.length(), ")");
      }
      WritableNativeMap localWritableNativeMap = new WritableNativeMap();
      ContentResolver localContentResolver = this.mContext.getContentResolver();
      Cursor localCursor;
      try
      {
        localCursor = localContentResolver.query(MediaStore.Files.getContentUri("external"), CameraRollManager.PROJECTION, localStringBuilder.toString(), (String[])localArrayList.toArray(new String[localArrayList.size()]), "datetaken DESC, date_modified DESC LIMIT " + (1 + this.mFirst));
        if (localCursor == null)
        {
          this.mPromise.reject("E_UNABLE_TO_LOAD", "Could not get media");
          return;
        }
      }
      catch (SecurityException localSecurityException)
      {
        this.mPromise.reject("E_UNABLE_TO_LOAD_PERMISSION", "Could not get media: need READ_EXTERNAL_STORAGE permission", localSecurityException);
        return;
      }
      try
      {
        CameraRollManager.putEdges(localContentResolver, localCursor, localWritableNativeMap, this.mFirst);
        CameraRollManager.putPageInfo(localCursor, localWritableNativeMap, this.mFirst);
        return;
      }
      finally
      {
        localCursor.close();
        this.mPromise.resolve(localWritableNativeMap);
      }
    }
  }

  private static class SaveToCameraRoll extends GuardedAsyncTask<Void, Void>
  {
    private final Context mContext;
    private final Promise mPromise;
    private final Uri mUri;

    public SaveToCameraRoll(ReactContext paramReactContext, Uri paramUri, Promise paramPromise)
    {
      super();
      this.mContext = paramReactContext;
      this.mUri = paramUri;
      this.mPromise = paramPromise;
    }

    // ERROR //
    protected void doInBackgroundGuarded(Void[] paramArrayOfVoid)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: new 35	java/io/File
      //   5: dup
      //   6: aload_0
      //   7: getfield 20	com/facebook/react/modules/camera/CameraRollManager$SaveToCameraRoll:mUri	Landroid/net/Uri;
      //   10: invokevirtual 41	android/net/Uri:getPath	()Ljava/lang/String;
      //   13: invokespecial 44	java/io/File:<init>	(Ljava/lang/String;)V
      //   16: astore_3
      //   17: getstatic 50	android/os/Environment:DIRECTORY_DCIM	Ljava/lang/String;
      //   20: invokestatic 54	android/os/Environment:getExternalStoragePublicDirectory	(Ljava/lang/String;)Ljava/io/File;
      //   23: astore 13
      //   25: aload 13
      //   27: invokevirtual 58	java/io/File:mkdirs	()Z
      //   30: pop
      //   31: aload 13
      //   33: invokevirtual 61	java/io/File:isDirectory	()Z
      //   36: ifne +73 -> 109
      //   39: aload_0
      //   40: getfield 22	com/facebook/react/modules/camera/CameraRollManager$SaveToCameraRoll:mPromise	Lcom/facebook/react/bridge/Promise;
      //   43: ldc 63
      //   45: ldc 65
      //   47: invokeinterface 71 3 0
      //   52: iconst_0
      //   53: ifeq +14 -> 67
      //   56: aconst_null
      //   57: invokevirtual 76	java/nio/channels/FileChannel:isOpen	()Z
      //   60: ifeq +7 -> 67
      //   63: aconst_null
      //   64: invokevirtual 80	java/nio/channels/FileChannel:close	()V
      //   67: iconst_0
      //   68: ifeq +14 -> 82
      //   71: aconst_null
      //   72: invokevirtual 76	java/nio/channels/FileChannel:isOpen	()Z
      //   75: ifeq +7 -> 82
      //   78: aconst_null
      //   79: invokevirtual 80	java/nio/channels/FileChannel:close	()V
      //   82: return
      //   83: astore 35
      //   85: ldc 82
      //   87: ldc 84
      //   89: aload 35
      //   91: invokestatic 90	com/facebook/common/logging/FLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   94: goto -27 -> 67
      //   97: astore 34
      //   99: ldc 82
      //   101: ldc 92
      //   103: aload 34
      //   105: invokestatic 90	com/facebook/common/logging/FLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   108: return
      //   109: new 35	java/io/File
      //   112: dup
      //   113: aload 13
      //   115: aload_3
      //   116: invokevirtual 95	java/io/File:getName	()Ljava/lang/String;
      //   119: invokespecial 98	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   122: astore 15
      //   124: aload_3
      //   125: invokevirtual 95	java/io/File:getName	()Ljava/lang/String;
      //   128: astore 16
      //   130: aload 16
      //   132: bipush 46
      //   134: invokevirtual 104	java/lang/String:indexOf	(I)I
      //   137: iflt +470 -> 607
      //   140: aload 16
      //   142: iconst_0
      //   143: aload 16
      //   145: bipush 46
      //   147: invokevirtual 107	java/lang/String:lastIndexOf	(I)I
      //   150: invokevirtual 111	java/lang/String:substring	(II)Ljava/lang/String;
      //   153: astore 18
      //   155: aload 16
      //   157: aload 16
      //   159: bipush 46
      //   161: invokevirtual 107	java/lang/String:lastIndexOf	(I)I
      //   164: invokevirtual 114	java/lang/String:substring	(I)Ljava/lang/String;
      //   167: astore 17
      //   169: iconst_0
      //   170: istore 20
      //   172: aload 15
      //   174: astore 19
      //   176: aload 19
      //   178: invokevirtual 117	java/io/File:createNewFile	()Z
      //   181: ifne +65 -> 246
      //   184: new 119	java/lang/StringBuilder
      //   187: dup
      //   188: invokespecial 121	java/lang/StringBuilder:<init>	()V
      //   191: aload 18
      //   193: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   196: ldc 127
      //   198: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   201: astore 31
      //   203: iload 20
      //   205: iconst_1
      //   206: iadd
      //   207: istore 32
      //   209: new 35	java/io/File
      //   212: dup
      //   213: aload 13
      //   215: aload 31
      //   217: iload 20
      //   219: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   222: aload 17
      //   224: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   227: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   230: invokespecial 98	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   233: astore 33
      //   235: iload 32
      //   237: istore 20
      //   239: aload 33
      //   241: astore 19
      //   243: goto -67 -> 176
      //   246: new 135	java/io/FileInputStream
      //   249: dup
      //   250: aload_3
      //   251: invokespecial 138	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   254: invokevirtual 142	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
      //   257: astore 21
      //   259: aload 21
      //   261: astore 5
      //   263: new 144	java/io/FileOutputStream
      //   266: dup
      //   267: aload 19
      //   269: invokespecial 145	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   272: invokevirtual 146	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
      //   275: astore 22
      //   277: aload 22
      //   279: aload 5
      //   281: lconst_0
      //   282: aload 5
      //   284: invokevirtual 150	java/nio/channels/FileChannel:size	()J
      //   287: invokevirtual 154	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
      //   290: pop2
      //   291: aload 5
      //   293: invokevirtual 80	java/nio/channels/FileChannel:close	()V
      //   296: aload 22
      //   298: invokevirtual 80	java/nio/channels/FileChannel:close	()V
      //   301: aload_0
      //   302: getfield 18	com/facebook/react/modules/camera/CameraRollManager$SaveToCameraRoll:mContext	Landroid/content/Context;
      //   305: astore 27
      //   307: iconst_1
      //   308: anewarray 100	java/lang/String
      //   311: astore 28
      //   313: aload 28
      //   315: iconst_0
      //   316: aload 19
      //   318: invokevirtual 157	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   321: aastore
      //   322: aload 27
      //   324: aload 28
      //   326: aconst_null
      //   327: new 159	com/facebook/react/modules/camera/CameraRollManager$SaveToCameraRoll$1
      //   330: dup
      //   331: aload_0
      //   332: invokespecial 162	com/facebook/react/modules/camera/CameraRollManager$SaveToCameraRoll$1:<init>	(Lcom/facebook/react/modules/camera/CameraRollManager$SaveToCameraRoll;)V
      //   335: invokestatic 168	android/media/MediaScannerConnection:scanFile	(Landroid/content/Context;[Ljava/lang/String;[Ljava/lang/String;Landroid/media/MediaScannerConnection$OnScanCompletedListener;)V
      //   338: aload 5
      //   340: ifnull +16 -> 356
      //   343: aload 5
      //   345: invokevirtual 76	java/nio/channels/FileChannel:isOpen	()Z
      //   348: ifeq +8 -> 356
      //   351: aload 5
      //   353: invokevirtual 80	java/nio/channels/FileChannel:close	()V
      //   356: aload 22
      //   358: ifnull -276 -> 82
      //   361: aload 22
      //   363: invokevirtual 76	java/nio/channels/FileChannel:isOpen	()Z
      //   366: ifeq -284 -> 82
      //   369: aload 22
      //   371: invokevirtual 80	java/nio/channels/FileChannel:close	()V
      //   374: return
      //   375: astore 29
      //   377: ldc 82
      //   379: ldc 92
      //   381: aload 29
      //   383: invokestatic 90	com/facebook/common/logging/FLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   386: return
      //   387: astore 30
      //   389: ldc 82
      //   391: ldc 84
      //   393: aload 30
      //   395: invokestatic 90	com/facebook/common/logging/FLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   398: goto -42 -> 356
      //   401: astore 8
      //   403: aconst_null
      //   404: astore 9
      //   406: aload_0
      //   407: getfield 22	com/facebook/react/modules/camera/CameraRollManager$SaveToCameraRoll:mPromise	Lcom/facebook/react/bridge/Promise;
      //   410: aload 8
      //   412: invokeinterface 171 2 0
      //   417: aload_2
      //   418: ifnull +14 -> 432
      //   421: aload_2
      //   422: invokevirtual 76	java/nio/channels/FileChannel:isOpen	()Z
      //   425: ifeq +7 -> 432
      //   428: aload_2
      //   429: invokevirtual 80	java/nio/channels/FileChannel:close	()V
      //   432: aload 9
      //   434: ifnull -352 -> 82
      //   437: aload 9
      //   439: invokevirtual 76	java/nio/channels/FileChannel:isOpen	()Z
      //   442: ifeq -360 -> 82
      //   445: aload 9
      //   447: invokevirtual 80	java/nio/channels/FileChannel:close	()V
      //   450: return
      //   451: astore 11
      //   453: ldc 82
      //   455: ldc 92
      //   457: aload 11
      //   459: invokestatic 90	com/facebook/common/logging/FLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   462: return
      //   463: astore 12
      //   465: ldc 82
      //   467: ldc 84
      //   469: aload 12
      //   471: invokestatic 90	com/facebook/common/logging/FLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   474: goto -42 -> 432
      //   477: astore 4
      //   479: aconst_null
      //   480: astore 5
      //   482: aload 5
      //   484: ifnull +16 -> 500
      //   487: aload 5
      //   489: invokevirtual 76	java/nio/channels/FileChannel:isOpen	()Z
      //   492: ifeq +8 -> 500
      //   495: aload 5
      //   497: invokevirtual 80	java/nio/channels/FileChannel:close	()V
      //   500: aload_2
      //   501: ifnull +14 -> 515
      //   504: aload_2
      //   505: invokevirtual 76	java/nio/channels/FileChannel:isOpen	()Z
      //   508: ifeq +7 -> 515
      //   511: aload_2
      //   512: invokevirtual 80	java/nio/channels/FileChannel:close	()V
      //   515: aload 4
      //   517: athrow
      //   518: astore 7
      //   520: ldc 82
      //   522: ldc 84
      //   524: aload 7
      //   526: invokestatic 90	com/facebook/common/logging/FLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   529: goto -29 -> 500
      //   532: astore 6
      //   534: ldc 82
      //   536: ldc 92
      //   538: aload 6
      //   540: invokestatic 90	com/facebook/common/logging/FLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   543: goto -28 -> 515
      //   546: astore 4
      //   548: aconst_null
      //   549: astore_2
      //   550: goto -68 -> 482
      //   553: astore 24
      //   555: aload 22
      //   557: astore_2
      //   558: aload 24
      //   560: astore 4
      //   562: goto -80 -> 482
      //   565: astore 4
      //   567: aload 9
      //   569: astore 10
      //   571: aload_2
      //   572: astore 5
      //   574: aload 10
      //   576: astore_2
      //   577: goto -95 -> 482
      //   580: astore 8
      //   582: aload 5
      //   584: astore_2
      //   585: aconst_null
      //   586: astore 9
      //   588: goto -182 -> 406
      //   591: astore 23
      //   593: aload 5
      //   595: astore_2
      //   596: aload 22
      //   598: astore 9
      //   600: aload 23
      //   602: astore 8
      //   604: goto -198 -> 406
      //   607: ldc 173
      //   609: astore 17
      //   611: aload 16
      //   613: astore 18
      //   615: aload 15
      //   617: astore 19
      //   619: iconst_0
      //   620: istore 20
      //   622: goto -446 -> 176
      //
      // Exception table:
      //   from	to	target	type
      //   63	67	83	java/io/IOException
      //   78	82	97	java/io/IOException
      //   369	374	375	java/io/IOException
      //   351	356	387	java/io/IOException
      //   17	52	401	java/io/IOException
      //   109	169	401	java/io/IOException
      //   176	203	401	java/io/IOException
      //   209	235	401	java/io/IOException
      //   246	259	401	java/io/IOException
      //   445	450	451	java/io/IOException
      //   428	432	463	java/io/IOException
      //   17	52	477	finally
      //   109	169	477	finally
      //   176	203	477	finally
      //   209	235	477	finally
      //   246	259	477	finally
      //   495	500	518	java/io/IOException
      //   511	515	532	java/io/IOException
      //   263	277	546	finally
      //   277	338	553	finally
      //   406	417	565	finally
      //   263	277	580	java/io/IOException
      //   277	338	591	java/io/IOException
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.camera.CameraRollManager
 * JD-Core Version:    0.6.2
 */