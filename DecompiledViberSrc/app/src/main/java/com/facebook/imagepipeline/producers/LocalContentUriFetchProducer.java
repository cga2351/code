package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class LocalContentUriFetchProducer extends LocalFetchProducer
{
  public static final String PRODUCER_NAME = "LocalContentUriFetchProducer";
  private static final String[] PROJECTION = { "_id", "_data" };
  private final ContentResolver mContentResolver;

  public LocalContentUriFetchProducer(Executor paramExecutor, PooledByteBufferFactory paramPooledByteBufferFactory, ContentResolver paramContentResolver)
  {
    super(paramExecutor, paramPooledByteBufferFactory);
    this.mContentResolver = paramContentResolver;
  }

  @Nullable
  private EncodedImage getCameraImage(Uri paramUri)
    throws IOException
  {
    Cursor localCursor = this.mContentResolver.query(paramUri, PROJECTION, null, null, null);
    if (localCursor == null)
      return null;
    try
    {
      int i = localCursor.getCount();
      if (i == 0)
        return null;
      localCursor.moveToFirst();
      String str = localCursor.getString(localCursor.getColumnIndex("_data"));
      if (str != null)
      {
        EncodedImage localEncodedImage = getEncodedImage(new FileInputStream(str), getLength(str));
        return localEncodedImage;
      }
      return null;
    }
    finally
    {
      localCursor.close();
    }
  }

  private static int getLength(String paramString)
  {
    if (paramString == null)
      return -1;
    return (int)new File(paramString).length();
  }

  protected EncodedImage getEncodedImage(ImageRequest paramImageRequest)
    throws IOException
  {
    Uri localUri = paramImageRequest.getSourceUri();
    Object localObject;
    EncodedImage localEncodedImage;
    if (UriUtil.isLocalContactUri(localUri))
      if (localUri.toString().endsWith("/photo"))
      {
        localObject = this.mContentResolver.openInputStream(localUri);
        localEncodedImage = getEncodedImage((InputStream)localObject, -1);
      }
    do
    {
      while (true)
      {
        return localEncodedImage;
        if (localUri.toString().endsWith("/display_photo"))
          try
          {
            FileInputStream localFileInputStream = this.mContentResolver.openAssetFileDescriptor(localUri, "r").createInputStream();
            localObject = localFileInputStream;
          }
          catch (IOException localIOException)
          {
            throw new IOException("Contact photo does not exist: " + localUri);
          }
      }
      localObject = ContactsContract.Contacts.openContactPhotoInputStream(this.mContentResolver, localUri);
      if (localObject != null)
        break;
      throw new IOException("Contact photo does not exist: " + localUri);
      if (!UriUtil.isLocalCameraUri(localUri))
        break label166;
      localEncodedImage = getCameraImage(localUri);
    }
    while (localEncodedImage != null);
    label166: return getEncodedImage(this.mContentResolver.openInputStream(localUri), -1);
  }

  protected String getProducerName()
  {
    return "LocalContentUriFetchProducer";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.LocalContentUriFetchProducer
 * JD-Core Version:    0.6.2
 */