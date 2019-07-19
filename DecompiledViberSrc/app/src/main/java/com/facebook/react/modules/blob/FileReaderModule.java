package com.facebook.react.modules.blob;

import android.util.Base64;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name="FileReaderModule")
public class FileReaderModule extends ReactContextBaseJavaModule
{
  private static final String ERROR_INVALID_BLOB = "ERROR_INVALID_BLOB";
  protected static final String NAME = "FileReaderModule";

  public FileReaderModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  private BlobModule getBlobModule()
  {
    return (BlobModule)getReactApplicationContext().getNativeModule(BlobModule.class);
  }

  public String getName()
  {
    return "FileReaderModule";
  }

  @ReactMethod
  public void readAsDataURL(ReadableMap paramReadableMap, Promise paramPromise)
  {
    byte[] arrayOfByte = getBlobModule().resolve(paramReadableMap.getString("blobId"), paramReadableMap.getInt("offset"), paramReadableMap.getInt("size"));
    if (arrayOfByte == null)
    {
      paramPromise.reject("ERROR_INVALID_BLOB", "The specified blob is invalid");
      return;
    }
    while (true)
    {
      StringBuilder localStringBuilder;
      try
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("data:");
        if ((paramReadableMap.hasKey("type")) && (!paramReadableMap.getString("type").isEmpty()))
        {
          localStringBuilder.append(paramReadableMap.getString("type"));
          localStringBuilder.append(";base64,");
          localStringBuilder.append(Base64.encodeToString(arrayOfByte, 2));
          paramPromise.resolve(localStringBuilder.toString());
          return;
        }
      }
      catch (Exception localException)
      {
        paramPromise.reject(localException);
        return;
      }
      localStringBuilder.append("application/octet-stream");
    }
  }

  @ReactMethod
  public void readAsText(ReadableMap paramReadableMap, String paramString, Promise paramPromise)
  {
    byte[] arrayOfByte = getBlobModule().resolve(paramReadableMap.getString("blobId"), paramReadableMap.getInt("offset"), paramReadableMap.getInt("size"));
    if (arrayOfByte == null)
    {
      paramPromise.reject("ERROR_INVALID_BLOB", "The specified blob is invalid");
      return;
    }
    try
    {
      paramPromise.resolve(new String(arrayOfByte, paramString));
      return;
    }
    catch (Exception localException)
    {
      paramPromise.reject(localException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.blob.FileReaderModule
 * JD-Core Version:    0.6.2
 */