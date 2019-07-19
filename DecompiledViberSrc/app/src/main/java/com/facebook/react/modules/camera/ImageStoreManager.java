package com.facebook.react.modules.camera;

import android.os.AsyncTask;
import android.util.Base64OutputStream;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

@ReactModule(name="ImageStoreManager")
public class ImageStoreManager extends ReactContextBaseJavaModule
{
  private static final int BUFFER_SIZE = 8192;

  public ImageStoreManager(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  private static void closeQuietly(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException localIOException)
    {
    }
  }

  String convertInputStreamToBase64OutputStream(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Base64OutputStream localBase64OutputStream = new Base64OutputStream(localByteArrayOutputStream, 2);
    byte[] arrayOfByte = new byte[8192];
    try
    {
      while (true)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i <= -1)
          break;
        localBase64OutputStream.write(arrayOfByte, 0, i);
      }
    }
    finally
    {
      closeQuietly(localBase64OutputStream);
    }
    closeQuietly(localBase64OutputStream);
    return localByteArrayOutputStream.toString();
  }

  @ReactMethod
  public void getBase64ForTag(String paramString, Callback paramCallback1, Callback paramCallback2)
  {
    new GetBase64Task(getReactApplicationContext(), paramString, paramCallback1, paramCallback2, null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }

  public String getName()
  {
    return "ImageStoreManager";
  }

  private class GetBase64Task extends GuardedAsyncTask<Void, Void>
  {
    private final Callback mError;
    private final Callback mSuccess;
    private final String mUri;

    private GetBase64Task(ReactContext paramString, String paramCallback1, Callback paramCallback2, Callback arg5)
    {
      super();
      this.mUri = paramCallback1;
      this.mSuccess = paramCallback2;
      Object localObject;
      this.mError = localObject;
    }

    // ERROR //
    protected void doInBackgroundGuarded(Void[] paramArrayOfVoid)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 16	com/facebook/react/modules/camera/ImageStoreManager$GetBase64Task:this$0	Lcom/facebook/react/modules/camera/ImageStoreManager;
      //   4: invokestatic 45	com/facebook/react/modules/camera/ImageStoreManager:access$100	(Lcom/facebook/react/modules/camera/ImageStoreManager;)Lcom/facebook/react/bridge/ReactApplicationContext;
      //   7: invokevirtual 51	com/facebook/react/bridge/ReactApplicationContext:getContentResolver	()Landroid/content/ContentResolver;
      //   10: aload_0
      //   11: getfield 21	com/facebook/react/modules/camera/ImageStoreManager$GetBase64Task:mUri	Ljava/lang/String;
      //   14: invokestatic 57	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
      //   17: invokevirtual 63	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
      //   20: astore 5
      //   22: aload_0
      //   23: getfield 23	com/facebook/react/modules/camera/ImageStoreManager$GetBase64Task:mSuccess	Lcom/facebook/react/bridge/Callback;
      //   26: astore 10
      //   28: iconst_1
      //   29: anewarray 65	java/lang/Object
      //   32: astore 11
      //   34: aload 11
      //   36: iconst_0
      //   37: aload_0
      //   38: getfield 16	com/facebook/react/modules/camera/ImageStoreManager$GetBase64Task:this$0	Lcom/facebook/react/modules/camera/ImageStoreManager;
      //   41: aload 5
      //   43: invokevirtual 69	com/facebook/react/modules/camera/ImageStoreManager:convertInputStreamToBase64OutputStream	(Ljava/io/InputStream;)Ljava/lang/String;
      //   46: aastore
      //   47: aload 10
      //   49: aload 11
      //   51: invokeinterface 74 2 0
      //   56: aload 5
      //   58: invokestatic 78	com/facebook/react/modules/camera/ImageStoreManager:access$200	(Ljava/io/Closeable;)V
      //   61: return
      //   62: astore 7
      //   64: aload_0
      //   65: getfield 25	com/facebook/react/modules/camera/ImageStoreManager$GetBase64Task:mError	Lcom/facebook/react/bridge/Callback;
      //   68: astore 8
      //   70: iconst_1
      //   71: anewarray 65	java/lang/Object
      //   74: astore 9
      //   76: aload 9
      //   78: iconst_0
      //   79: aload 7
      //   81: invokevirtual 82	java/io/IOException:getMessage	()Ljava/lang/String;
      //   84: aastore
      //   85: aload 8
      //   87: aload 9
      //   89: invokeinterface 74 2 0
      //   94: aload 5
      //   96: invokestatic 78	com/facebook/react/modules/camera/ImageStoreManager:access$200	(Ljava/io/Closeable;)V
      //   99: return
      //   100: astore_2
      //   101: aload_0
      //   102: getfield 25	com/facebook/react/modules/camera/ImageStoreManager$GetBase64Task:mError	Lcom/facebook/react/bridge/Callback;
      //   105: astore_3
      //   106: iconst_1
      //   107: anewarray 65	java/lang/Object
      //   110: astore 4
      //   112: aload 4
      //   114: iconst_0
      //   115: aload_2
      //   116: invokevirtual 83	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
      //   119: aastore
      //   120: aload_3
      //   121: aload 4
      //   123: invokeinterface 74 2 0
      //   128: return
      //   129: astore 6
      //   131: aload 5
      //   133: invokestatic 78	com/facebook/react/modules/camera/ImageStoreManager:access$200	(Ljava/io/Closeable;)V
      //   136: aload 6
      //   138: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   22	56	62	java/io/IOException
      //   0	22	100	java/io/FileNotFoundException
      //   56	61	100	java/io/FileNotFoundException
      //   94	99	100	java/io/FileNotFoundException
      //   131	139	100	java/io/FileNotFoundException
      //   22	56	129	finally
      //   64	94	129	finally
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.camera.ImageStoreManager
 * JD-Core Version:    0.6.2
 */