package com.facebook.react.modules.blob;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public final class BlobProvider extends ContentProvider
{
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }

  public String getType(Uri paramUri)
  {
    return null;
  }

  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }

  public boolean onCreate()
  {
    return true;
  }

  // ERROR //
  public android.os.ParcelFileDescriptor openFile(Uri paramUri, String paramString)
    throws java.io.FileNotFoundException
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc 24
    //   3: invokevirtual 30	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifne +47 -> 53
    //   9: new 20	java/io/FileNotFoundException
    //   12: dup
    //   13: new 32	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   20: ldc 35
    //   22: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 45	android/net/Uri:toString	()Ljava/lang/String;
    //   29: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 47
    //   34: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_2
    //   38: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 49
    //   43: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokespecial 53	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   52: athrow
    //   53: aload_0
    //   54: invokevirtual 57	com/facebook/react/modules/blob/BlobProvider:getContext	()Landroid/content/Context;
    //   57: invokevirtual 62	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   60: astore_3
    //   61: aload_3
    //   62: instanceof 64
    //   65: ifeq +138 -> 203
    //   68: aload_3
    //   69: checkcast 64	com/facebook/react/ReactApplication
    //   72: invokeinterface 68 1 0
    //   77: invokevirtual 74	com/facebook/react/ReactNativeHost:getReactInstanceManager	()Lcom/facebook/react/ReactInstanceManager;
    //   80: invokevirtual 80	com/facebook/react/ReactInstanceManager:getCurrentReactContext	()Lcom/facebook/react/bridge/ReactContext;
    //   83: ldc 82
    //   85: invokevirtual 88	com/facebook/react/bridge/ReactContext:getNativeModule	(Ljava/lang/Class;)Lcom/facebook/react/bridge/NativeModule;
    //   88: checkcast 82	com/facebook/react/modules/blob/BlobModule
    //   91: astore 4
    //   93: aload 4
    //   95: ifnonnull +13 -> 108
    //   98: new 90	java/lang/RuntimeException
    //   101: dup
    //   102: ldc 92
    //   104: invokespecial 93	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   107: athrow
    //   108: aload 4
    //   110: aload_1
    //   111: invokevirtual 97	com/facebook/react/modules/blob/BlobModule:resolve	(Landroid/net/Uri;)[B
    //   114: astore 5
    //   116: aload 5
    //   118: ifnonnull +38 -> 156
    //   121: new 20	java/io/FileNotFoundException
    //   124: dup
    //   125: new 32	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   132: ldc 35
    //   134: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_1
    //   138: invokevirtual 45	android/net/Uri:toString	()Ljava/lang/String;
    //   141: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc 99
    //   146: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokespecial 53	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   155: athrow
    //   156: invokestatic 105	android/os/ParcelFileDescriptor:createPipe	()[Landroid/os/ParcelFileDescriptor;
    //   159: astore 7
    //   161: aload 7
    //   163: iconst_0
    //   164: aaload
    //   165: astore 8
    //   167: new 107	android/os/ParcelFileDescriptor$AutoCloseOutputStream
    //   170: dup
    //   171: aload 7
    //   173: iconst_1
    //   174: aaload
    //   175: invokespecial 110	android/os/ParcelFileDescriptor$AutoCloseOutputStream:<init>	(Landroid/os/ParcelFileDescriptor;)V
    //   178: astore 9
    //   180: aload 9
    //   182: aload 5
    //   184: invokevirtual 116	java/io/OutputStream:write	([B)V
    //   187: aload 9
    //   189: invokevirtual 119	java/io/OutputStream:close	()V
    //   192: aload 8
    //   194: areturn
    //   195: astore 6
    //   197: aconst_null
    //   198: areturn
    //   199: astore 10
    //   201: aconst_null
    //   202: areturn
    //   203: aconst_null
    //   204: astore 4
    //   206: goto -113 -> 93
    //
    // Exception table:
    //   from	to	target	type
    //   156	161	195	java/io/IOException
    //   180	192	199	java/io/IOException
  }

  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return null;
  }

  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.blob.BlobProvider
 * JD-Core Version:    0.6.2
 */