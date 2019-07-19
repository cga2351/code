package android.support.v4.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;

public final class ContentResolverCompat
{
  public static Cursor query(ContentResolver paramContentResolver, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, android.support.v4.os.CancellationSignal paramCancellationSignal)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      if (paramCancellationSignal != null);
      try
      {
        for (Object localObject = paramCancellationSignal.getCancellationSignalObject(); ; localObject = null)
        {
          Cursor localCursor = paramContentResolver.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, (android.os.CancellationSignal)localObject);
          return localCursor;
        }
      }
      catch (Exception localException)
      {
        if ((localException instanceof android.os.OperationCanceledException))
          throw new android.support.v4.os.OperationCanceledException();
        throw localException;
      }
    }
    if (paramCancellationSignal != null)
      paramCancellationSignal.throwIfCanceled();
    return paramContentResolver.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.content.ContentResolverCompat
 * JD-Core Version:    0.6.2
 */