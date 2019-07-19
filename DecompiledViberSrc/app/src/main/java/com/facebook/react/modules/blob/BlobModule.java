package com.facebook.react.modules.blob;

import android.content.ContentResolver;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.modules.network.NetworkingModule.RequestBodyHandler;
import com.facebook.react.modules.network.NetworkingModule.ResponseHandler;
import com.facebook.react.modules.network.NetworkingModule.UriHandler;
import com.facebook.react.modules.websocket.WebSocketModule;
import com.facebook.react.modules.websocket.WebSocketModule.ContentHandler;
import f.f;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

@ReactModule(name="BlobModule")
public class BlobModule extends ReactContextBaseJavaModule
{
  protected static final String NAME = "BlobModule";
  private final Map<String, byte[]> mBlobs = new HashMap();
  private final NetworkingModule.RequestBodyHandler mNetworkingRequestBodyHandler = new NetworkingModule.RequestBodyHandler()
  {
    public boolean supports(ReadableMap paramAnonymousReadableMap)
    {
      return paramAnonymousReadableMap.hasKey("blob");
    }

    public RequestBody toRequestBody(ReadableMap paramAnonymousReadableMap, String paramAnonymousString)
    {
      if ((paramAnonymousReadableMap.hasKey("type")) && (!paramAnonymousReadableMap.getString("type").isEmpty()));
      for (String str1 = paramAnonymousReadableMap.getString("type"); ; str1 = paramAnonymousString)
      {
        if (str1 == null)
          str1 = "application/octet-stream";
        ReadableMap localReadableMap = paramAnonymousReadableMap.getMap("blob");
        String str2 = localReadableMap.getString("blobId");
        byte[] arrayOfByte = BlobModule.this.resolve(str2, localReadableMap.getInt("offset"), localReadableMap.getInt("size"));
        return RequestBody.create(MediaType.parse(str1), arrayOfByte);
      }
    }
  };
  private final NetworkingModule.ResponseHandler mNetworkingResponseHandler = new NetworkingModule.ResponseHandler()
  {
    public boolean supports(String paramAnonymousString)
    {
      return "blob".equals(paramAnonymousString);
    }

    public WritableMap toResponseData(ResponseBody paramAnonymousResponseBody)
      throws IOException
    {
      byte[] arrayOfByte = paramAnonymousResponseBody.bytes();
      WritableMap localWritableMap = Arguments.createMap();
      localWritableMap.putString("blobId", BlobModule.this.store(arrayOfByte));
      localWritableMap.putInt("offset", 0);
      localWritableMap.putInt("size", arrayOfByte.length);
      return localWritableMap;
    }
  };
  private final NetworkingModule.UriHandler mNetworkingUriHandler = new NetworkingModule.UriHandler()
  {
    public WritableMap fetch(Uri paramAnonymousUri)
      throws IOException
    {
      byte[] arrayOfByte = BlobModule.this.getBytesFromUri(paramAnonymousUri);
      WritableMap localWritableMap = Arguments.createMap();
      localWritableMap.putString("blobId", BlobModule.this.store(arrayOfByte));
      localWritableMap.putInt("offset", 0);
      localWritableMap.putInt("size", arrayOfByte.length);
      localWritableMap.putString("type", BlobModule.this.getMimeTypeFromUri(paramAnonymousUri));
      localWritableMap.putString("name", BlobModule.this.getNameFromUri(paramAnonymousUri));
      localWritableMap.putDouble("lastModified", BlobModule.this.getLastModifiedFromUri(paramAnonymousUri));
      return localWritableMap;
    }

    public boolean supports(Uri paramAnonymousUri, String paramAnonymousString)
    {
      String str = paramAnonymousUri.getScheme();
      if (("http".equals(str)) || ("https".equals(str)));
      for (int i = 1; (i == 0) && ("blob".equals(paramAnonymousString)); i = 0)
        return true;
      return false;
    }
  };
  private final WebSocketModule.ContentHandler mWebSocketContentHandler = new WebSocketModule.ContentHandler()
  {
    public void onMessage(f paramAnonymousf, WritableMap paramAnonymousWritableMap)
    {
      byte[] arrayOfByte = paramAnonymousf.i();
      WritableMap localWritableMap = Arguments.createMap();
      localWritableMap.putString("blobId", BlobModule.this.store(arrayOfByte));
      localWritableMap.putInt("offset", 0);
      localWritableMap.putInt("size", arrayOfByte.length);
      paramAnonymousWritableMap.putMap("data", localWritableMap);
      paramAnonymousWritableMap.putString("type", "blob");
    }

    public void onMessage(String paramAnonymousString, WritableMap paramAnonymousWritableMap)
    {
      paramAnonymousWritableMap.putString("data", paramAnonymousString);
    }
  };

  public BlobModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  private byte[] getBytesFromUri(Uri paramUri)
    throws IOException
  {
    InputStream localInputStream = getReactApplicationContext().getContentResolver().openInputStream(paramUri);
    if (localInputStream == null)
      throw new FileNotFoundException("File not found for " + paramUri);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    while (true)
    {
      int i = localInputStream.read(arrayOfByte);
      if (i == -1)
        break;
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    return localByteArrayOutputStream.toByteArray();
  }

  private long getLastModifiedFromUri(Uri paramUri)
  {
    if ("file".equals(paramUri.getScheme()))
      return new File(paramUri.toString()).lastModified();
    return 0L;
  }

  private String getMimeTypeFromUri(Uri paramUri)
  {
    String str1 = getReactApplicationContext().getContentResolver().getType(paramUri);
    if (str1 == null)
    {
      String str2 = MimeTypeMap.getFileExtensionFromUrl(paramUri.getPath());
      if (str2 != null)
        str1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str2);
    }
    if (str1 == null)
      str1 = "";
    return str1;
  }

  private String getNameFromUri(Uri paramUri)
  {
    if ("file".equals(paramUri.getScheme()))
      return paramUri.getLastPathSegment();
    String[] arrayOfString = { "_display_name" };
    Cursor localCursor = getReactApplicationContext().getContentResolver().query(paramUri, arrayOfString, null, null, null);
    if (localCursor != null);
    try
    {
      if (localCursor.moveToFirst())
      {
        String str = localCursor.getString(0);
        return str;
      }
      return paramUri.getLastPathSegment();
    }
    finally
    {
      localCursor.close();
    }
  }

  private WebSocketModule getWebSocketModule()
  {
    return (WebSocketModule)getReactApplicationContext().getNativeModule(WebSocketModule.class);
  }

  @ReactMethod
  public void addNetworkingHandler()
  {
    NetworkingModule localNetworkingModule = (NetworkingModule)getReactApplicationContext().getNativeModule(NetworkingModule.class);
    localNetworkingModule.addUriHandler(this.mNetworkingUriHandler);
    localNetworkingModule.addRequestBodyHandler(this.mNetworkingRequestBodyHandler);
    localNetworkingModule.addResponseHandler(this.mNetworkingResponseHandler);
  }

  @ReactMethod
  public void addWebSocketHandler(int paramInt)
  {
    getWebSocketModule().setContentHandler(paramInt, this.mWebSocketContentHandler);
  }

  @ReactMethod
  public void createFromParts(ReadableArray paramReadableArray, String paramString)
  {
    ArrayList localArrayList = new ArrayList(paramReadableArray.size());
    int i = 0;
    int j = 0;
    if (i < paramReadableArray.size())
    {
      ReadableMap localReadableMap1 = paramReadableArray.getMap(i);
      String str = localReadableMap1.getString("type");
      int k = -1;
      switch (str.hashCode())
      {
      default:
      case 3026845:
      case -891985903:
      }
      while (true)
        switch (k)
        {
        default:
          throw new IllegalArgumentException("Invalid type for blob: " + localReadableMap1.getString("type"));
          if (str.equals("blob"))
          {
            k = 0;
            continue;
            if (str.equals("string"))
              k = 1;
          }
          break;
        case 0:
        case 1:
        }
      ReadableMap localReadableMap2 = localReadableMap1.getMap("data");
      j += localReadableMap2.getInt("size");
      localArrayList.add(i, resolve(localReadableMap2));
      while (true)
      {
        i++;
        break;
        byte[] arrayOfByte = localReadableMap1.getString("data").getBytes(Charset.forName("UTF-8"));
        j += arrayOfByte.length;
        localArrayList.add(i, arrayOfByte);
      }
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(j);
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
      localByteBuffer.put((byte[])localIterator.next());
    store(localByteBuffer.array(), paramString);
  }

  public Map<String, Object> getConstants()
  {
    Resources localResources = getReactApplicationContext().getResources();
    int i = localResources.getIdentifier("blob_provider_authority", "string", getReactApplicationContext().getPackageName());
    if (i == 0)
      return null;
    return MapBuilder.of("BLOB_URI_SCHEME", "content", "BLOB_URI_HOST", localResources.getString(i));
  }

  public String getName()
  {
    return "BlobModule";
  }

  @ReactMethod
  public void release(String paramString)
  {
    remove(paramString);
  }

  public void remove(String paramString)
  {
    this.mBlobs.remove(paramString);
  }

  @ReactMethod
  public void removeWebSocketHandler(int paramInt)
  {
    getWebSocketModule().setContentHandler(paramInt, null);
  }

  public byte[] resolve(Uri paramUri)
  {
    String str1 = paramUri.getLastPathSegment();
    int i = -1;
    String str2 = paramUri.getQueryParameter("offset");
    int j = 0;
    if (str2 != null)
      j = Integer.parseInt(str2, 10);
    String str3 = paramUri.getQueryParameter("size");
    if (str3 != null)
      i = Integer.parseInt(str3, 10);
    return resolve(str1, j, i);
  }

  public byte[] resolve(ReadableMap paramReadableMap)
  {
    return resolve(paramReadableMap.getString("blobId"), paramReadableMap.getInt("offset"), paramReadableMap.getInt("size"));
  }

  public byte[] resolve(String paramString, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = (byte[])this.mBlobs.get(paramString);
    if (arrayOfByte == null)
      arrayOfByte = null;
    do
    {
      return arrayOfByte;
      if (paramInt2 == -1)
        paramInt2 = arrayOfByte.length - paramInt1;
    }
    while ((paramInt1 <= 0) && (paramInt2 == arrayOfByte.length));
    return Arrays.copyOfRange(arrayOfByte, paramInt1, paramInt1 + paramInt2);
  }

  @ReactMethod
  public void sendOverSocket(ReadableMap paramReadableMap, int paramInt)
  {
    byte[] arrayOfByte = resolve(paramReadableMap.getString("blobId"), paramReadableMap.getInt("offset"), paramReadableMap.getInt("size"));
    if (arrayOfByte != null)
    {
      getWebSocketModule().sendBinary(f.a(arrayOfByte), paramInt);
      return;
    }
    getWebSocketModule().sendBinary((f)null, paramInt);
  }

  public String store(byte[] paramArrayOfByte)
  {
    String str = UUID.randomUUID().toString();
    store(paramArrayOfByte, str);
    return str;
  }

  public void store(byte[] paramArrayOfByte, String paramString)
  {
    this.mBlobs.put(paramString, paramArrayOfByte);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.blob.BlobModule
 * JD-Core Version:    0.6.2
 */