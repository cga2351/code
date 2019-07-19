package com.facebook;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Log;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public final class NativeAppCallAttachmentStore
  implements NativeAppCallContentProvider.AttachmentDataSource
{
  static final String ATTACHMENTS_DIR_NAME = "com.facebook.NativeAppCallAttachmentStore.files";
  private static final String TAG = NativeAppCallAttachmentStore.class.getName();
  private static File attachmentsDirectory;

  private <T> void addAttachments(Context paramContext, UUID paramUUID, Map<String, T> paramMap, ProcessAttachment<T> paramProcessAttachment)
  {
    if (paramMap.size() == 0);
    while (true)
    {
      return;
      if (attachmentsDirectory == null)
        cleanupAllAttachments(paramContext);
      ensureAttachmentsDirectoryExists(paramContext);
      ArrayList localArrayList = new ArrayList();
      try
      {
        Iterator localIterator2 = paramMap.entrySet().iterator();
        while (localIterator2.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator2.next();
          String str = (String)localEntry.getKey();
          Object localObject = localEntry.getValue();
          File localFile2 = getAttachmentFile(paramUUID, str, true);
          localArrayList.add(localFile2);
          paramProcessAttachment.processAttachment(localObject, localFile2);
        }
      }
      catch (IOException localIOException)
      {
        Log.e(TAG, "Got unexpected exception:" + localIOException);
        Iterator localIterator1 = localArrayList.iterator();
        while (localIterator1.hasNext())
        {
          File localFile1 = (File)localIterator1.next();
          try
          {
            localFile1.delete();
          }
          catch (Exception localException)
          {
          }
        }
        throw new FacebookException(localIOException);
      }
    }
  }

  static File getAttachmentsDirectory(Context paramContext)
  {
    try
    {
      if (attachmentsDirectory == null)
        attachmentsDirectory = new File(paramContext.getCacheDir(), "com.facebook.NativeAppCallAttachmentStore.files");
      File localFile = attachmentsDirectory;
      return localFile;
    }
    finally
    {
    }
  }

  public void addAttachmentFilesForCall(Context paramContext, UUID paramUUID, Map<String, File> paramMap)
  {
    Validate.notNull(paramContext, "context");
    Validate.notNull(paramUUID, "callId");
    Validate.containsNoNulls(paramMap.values(), "imageAttachmentFiles");
    Validate.containsNoNullOrEmpty(paramMap.keySet(), "imageAttachmentFiles");
    addAttachments(paramContext, paramUUID, paramMap, new ProcessAttachment()
    {
      public void processAttachment(File paramAnonymousFile1, File paramAnonymousFile2)
        throws IOException
      {
        FileOutputStream localFileOutputStream = new FileOutputStream(paramAnonymousFile2);
        try
        {
          localFileInputStream = new FileInputStream(paramAnonymousFile1);
          try
          {
            byte[] arrayOfByte = new byte[1024];
            while (true)
            {
              int i = localFileInputStream.read(arrayOfByte);
              if (i <= 0)
                break;
              localFileOutputStream.write(arrayOfByte, 0, i);
            }
          }
          finally
          {
          }
          Utility.closeQuietly(localFileOutputStream);
          Utility.closeQuietly(localFileInputStream);
          throw localObject1;
          Utility.closeQuietly(localFileOutputStream);
          Utility.closeQuietly(localFileInputStream);
          return;
        }
        finally
        {
          while (true)
            FileInputStream localFileInputStream = null;
        }
      }
    });
  }

  public void addAttachmentsForCall(Context paramContext, UUID paramUUID, Map<String, Bitmap> paramMap)
  {
    Validate.notNull(paramContext, "context");
    Validate.notNull(paramUUID, "callId");
    Validate.containsNoNulls(paramMap.values(), "imageAttachments");
    Validate.containsNoNullOrEmpty(paramMap.keySet(), "imageAttachments");
    addAttachments(paramContext, paramUUID, paramMap, new ProcessAttachment()
    {
      public void processAttachment(Bitmap paramAnonymousBitmap, File paramAnonymousFile)
        throws IOException
      {
        FileOutputStream localFileOutputStream = new FileOutputStream(paramAnonymousFile);
        try
        {
          paramAnonymousBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localFileOutputStream);
          return;
        }
        finally
        {
          Utility.closeQuietly(localFileOutputStream);
        }
      }
    });
  }

  void cleanupAllAttachments(Context paramContext)
  {
    Utility.deleteDirectory(getAttachmentsDirectory(paramContext));
  }

  public void cleanupAttachmentsForCall(Context paramContext, UUID paramUUID)
  {
    Utility.deleteDirectory(getAttachmentsDirectoryForCall(paramUUID, false));
  }

  File ensureAttachmentsDirectoryExists(Context paramContext)
  {
    File localFile = getAttachmentsDirectory(paramContext);
    localFile.mkdirs();
    return localFile;
  }

  File getAttachmentFile(UUID paramUUID, String paramString, boolean paramBoolean)
    throws IOException
  {
    File localFile1 = getAttachmentsDirectoryForCall(paramUUID, paramBoolean);
    if (localFile1 == null)
      return null;
    try
    {
      File localFile2 = new File(localFile1, URLEncoder.encode(paramString, "UTF-8"));
      return localFile2;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return null;
  }

  File getAttachmentsDirectoryForCall(UUID paramUUID, boolean paramBoolean)
  {
    File localFile;
    if (attachmentsDirectory == null)
      localFile = null;
    do
    {
      return localFile;
      localFile = new File(attachmentsDirectory, paramUUID.toString());
    }
    while ((!paramBoolean) || (localFile.exists()));
    localFile.mkdirs();
    return localFile;
  }

  public File openAttachment(UUID paramUUID, String paramString)
    throws FileNotFoundException
  {
    if ((Utility.isNullOrEmpty(paramString)) || (paramUUID == null))
      throw new FileNotFoundException();
    try
    {
      File localFile = getAttachmentFile(paramUUID, paramString, false);
      return localFile;
    }
    catch (IOException localIOException)
    {
    }
    throw new FileNotFoundException();
  }

  static abstract interface ProcessAttachment<T>
  {
    public abstract void processAttachment(T paramT, File paramFile)
      throws IOException;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.NativeAppCallAttachmentStore
 * JD-Core Version:    0.6.2
 */