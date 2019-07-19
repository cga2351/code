package com.reactnativecommunity.webview;

import android.app.Activity;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.widget.Toast;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@ReactModule(name="RNCWebView")
public class RNCWebViewModule extends ReactContextBaseJavaModule
  implements ActivityEventListener
{
  private static final int FILE_DOWNLOAD_PERMISSION_REQUEST = 1;
  public static final String MODULE_NAME = "RNCWebView";
  private static final int PICKER = 1;
  private static final int PICKER_LEGACY = 3;
  final String DEFAULT_MIME_TYPES = "*/*";
  private DownloadManager.Request downloadRequest;
  private ValueCallback<Uri[]> filePathCallback;
  private ValueCallback<Uri> filePathCallbackLegacy;
  private Uri outputFileUri;
  private PermissionListener webviewFileDownloaderPermissionListener = new PermissionListener()
  {
    public boolean onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
    {
      int i = 1;
      switch (paramAnonymousInt)
      {
      default:
        i = 0;
      case 1:
      }
      do
      {
        return i;
        if ((paramAnonymousArrayOfInt.length <= 0) || (paramAnonymousArrayOfInt[0] != 0))
          break;
      }
      while (RNCWebViewModule.this.downloadRequest == null);
      RNCWebViewModule.this.downloadFile();
      return i;
      Toast.makeText(RNCWebViewModule.this.getCurrentActivity().getApplicationContext(), "Cannot download files as permission was denied. Please provide permission to write to storage, in order to download files.", i).show();
      return i;
    }
  };

  public RNCWebViewModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
    paramReactApplicationContext.addActivityEventListener(this);
  }

  private Boolean acceptsImages(String paramString)
  {
    if (paramString.matches("\\.\\w+"))
      paramString = getMimeTypeFromExtension(paramString.replace(".", ""));
    if ((paramString.isEmpty()) || (paramString.toLowerCase().contains("image")));
    for (boolean bool = true; ; bool = false)
      return Boolean.valueOf(bool);
  }

  private Boolean acceptsImages(String[] paramArrayOfString)
  {
    String[] arrayOfString = getAcceptedMimeType(paramArrayOfString);
    if ((isArrayEmpty(arrayOfString).booleanValue()) || (arrayContainsString(arrayOfString, "image").booleanValue()));
    for (boolean bool = true; ; bool = false)
      return Boolean.valueOf(bool);
  }

  private Boolean acceptsVideo(String paramString)
  {
    if (paramString.matches("\\.\\w+"))
      paramString = getMimeTypeFromExtension(paramString.replace(".", ""));
    if ((paramString.isEmpty()) || (paramString.toLowerCase().contains("video")));
    for (boolean bool = true; ; bool = false)
      return Boolean.valueOf(bool);
  }

  private Boolean acceptsVideo(String[] paramArrayOfString)
  {
    String[] arrayOfString = getAcceptedMimeType(paramArrayOfString);
    if ((isArrayEmpty(arrayOfString).booleanValue()) || (arrayContainsString(arrayOfString, "video").booleanValue()));
    for (boolean bool = true; ; bool = false)
      return Boolean.valueOf(bool);
  }

  private Boolean arrayContainsString(String[] paramArrayOfString, String paramString)
  {
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
      if (paramArrayOfString[j].contains(paramString))
        return Boolean.valueOf(true);
    return Boolean.valueOf(false);
  }

  private String[] getAcceptedMimeType(String[] paramArrayOfString)
  {
    int i = 0;
    if (isArrayEmpty(paramArrayOfString).booleanValue())
      return new String[] { "*/*" };
    String[] arrayOfString = new String[paramArrayOfString.length];
    if (i < paramArrayOfString.length)
    {
      String str = paramArrayOfString[i];
      if (str.matches("\\.\\w+"))
        arrayOfString[i] = getMimeTypeFromExtension(str.replace(".", ""));
      while (true)
      {
        i++;
        break;
        arrayOfString[i] = str;
      }
    }
    return arrayOfString;
  }

  private File getCapturedFile(String paramString)
    throws IOException
  {
    String str1 = "";
    String str2 = "";
    String str3 = "";
    if (paramString.equals("android.media.action.IMAGE_CAPTURE"))
    {
      str1 = "image-";
      str2 = ".jpg";
      str3 = Environment.DIRECTORY_PICTURES;
    }
    String str4;
    while (true)
    {
      str4 = str1 + String.valueOf(System.currentTimeMillis()) + str2;
      if (Build.VERSION.SDK_INT >= 23)
        break;
      return new File(Environment.getExternalStoragePublicDirectory(str3), str4);
      if (paramString.equals("android.media.action.VIDEO_CAPTURE"))
      {
        str1 = "video-";
        str2 = ".mp4";
        str3 = Environment.DIRECTORY_MOVIES;
      }
    }
    return File.createTempFile(str4, str2, getReactApplicationContext().getExternalFilesDir(null));
  }

  private Intent getFileChooserIntent(String paramString)
  {
    if (paramString.isEmpty());
    for (String str = "*/*"; ; str = paramString)
    {
      if (paramString.matches("\\.\\w+"))
        str = getMimeTypeFromExtension(paramString.replace(".", ""));
      Intent localIntent = new Intent("android.intent.action.GET_CONTENT");
      localIntent.addCategory("android.intent.category.OPENABLE");
      localIntent.setType(str);
      return localIntent;
    }
  }

  private Intent getFileChooserIntent(String[] paramArrayOfString, boolean paramBoolean)
  {
    Intent localIntent = new Intent("android.intent.action.GET_CONTENT");
    localIntent.addCategory("android.intent.category.OPENABLE");
    localIntent.setType("*/*");
    localIntent.putExtra("android.intent.extra.MIME_TYPES", getAcceptedMimeType(paramArrayOfString));
    localIntent.putExtra("android.intent.extra.ALLOW_MULTIPLE", paramBoolean);
    return localIntent;
  }

  private String getMimeTypeFromExtension(String paramString)
  {
    String str = null;
    if (paramString != null)
      str = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString);
    return str;
  }

  private Uri getOutputUri(String paramString)
  {
    try
    {
      File localFile2 = getCapturedFile(paramString);
      localFile1 = localFile2;
      if (Build.VERSION.SDK_INT < 23)
        return Uri.fromFile(localFile1);
    }
    catch (IOException localIOException)
    {
      File localFile1;
      while (true)
      {
        Log.e("CREATE FILE", "Error occurred while creating the File", localIOException);
        localIOException.printStackTrace();
        localFile1 = null;
      }
      String str = getReactApplicationContext().getPackageName();
      return FileProvider.getUriForFile(getReactApplicationContext(), str + ".fileprovider", localFile1);
    }
  }

  private PermissionAwareActivity getPermissionAwareActivity()
  {
    Activity localActivity = getCurrentActivity();
    if (localActivity == null)
      throw new IllegalStateException("Tried to use permissions API while not attached to an Activity.");
    if (!(localActivity instanceof PermissionAwareActivity))
      throw new IllegalStateException("Tried to use permissions API but the host Activity doesn't implement PermissionAwareActivity.");
    return (PermissionAwareActivity)localActivity;
  }

  private Intent getPhotoIntent()
  {
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    this.outputFileUri = getOutputUri("android.media.action.IMAGE_CAPTURE");
    localIntent.putExtra("output", this.outputFileUri);
    return localIntent;
  }

  private Uri[] getSelectedFiles(Intent paramIntent, int paramInt)
  {
    Uri[] arrayOfUri = null;
    if (paramIntent == null);
    while (true)
    {
      return arrayOfUri;
      if (paramIntent.getData() != null)
      {
        arrayOfUri = null;
        if (paramInt == -1)
        {
          int i = Build.VERSION.SDK_INT;
          arrayOfUri = null;
          if (i >= 21)
            return WebChromeClient.FileChooserParams.parseResult(paramInt, paramIntent);
        }
      }
      else
      {
        ClipData localClipData = paramIntent.getClipData();
        arrayOfUri = null;
        if (localClipData != null)
        {
          int j = paramIntent.getClipData().getItemCount();
          arrayOfUri = new Uri[j];
          for (int k = 0; k < j; k++)
            arrayOfUri[k] = paramIntent.getClipData().getItemAt(k).getUri();
        }
      }
    }
  }

  private Intent getVideoIntent()
  {
    Intent localIntent = new Intent("android.media.action.VIDEO_CAPTURE");
    localIntent.putExtra("output", getOutputUri("android.media.action.VIDEO_CAPTURE"));
    return localIntent;
  }

  private Boolean isArrayEmpty(String[] paramArrayOfString)
  {
    boolean bool;
    if (paramArrayOfString.length != 0)
    {
      int i = paramArrayOfString.length;
      bool = false;
      if (i == 1)
      {
        int j = paramArrayOfString[0].length();
        bool = false;
        if (j != 0);
      }
    }
    else
    {
      bool = true;
    }
    return Boolean.valueOf(bool);
  }

  public void downloadFile()
  {
    ((DownloadManager)getCurrentActivity().getBaseContext().getSystemService("download")).enqueue(this.downloadRequest);
    Toast.makeText(getCurrentActivity().getApplicationContext(), "Downloading", 1).show();
  }

  public String getName()
  {
    return "RNCWebView";
  }

  public boolean grantFileDownloaderPermissions()
  {
    if (Build.VERSION.SDK_INT < 23)
      return true;
    if (ContextCompat.checkSelfPermission(getCurrentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") != 0);
    for (boolean bool = false; ; bool = true)
    {
      if (!bool)
        getPermissionAwareActivity().requestPermissions(new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" }, 1, this.webviewFileDownloaderPermissionListener);
      return bool;
    }
  }

  @ReactMethod
  public void isFileUploadSupported(Promise paramPromise)
  {
    Boolean localBoolean = Boolean.valueOf(false);
    int i = Build.VERSION.SDK_INT;
    if (i >= 21)
      localBoolean = Boolean.valueOf(true);
    if ((i >= 16) && (i <= 18))
      localBoolean = Boolean.valueOf(true);
    paramPromise.resolve(localBoolean);
  }

  public void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.filePathCallback == null) && (this.filePathCallbackLegacy == null))
      return;
    switch (paramInt1)
    {
    case 2:
    default:
    case 1:
      while (true)
      {
        this.filePathCallback = null;
        this.filePathCallbackLegacy = null;
        this.outputFileUri = null;
        return;
        if (paramInt2 != -1)
        {
          if (this.filePathCallback != null)
            this.filePathCallback.onReceiveValue(null);
        }
        else
        {
          Uri[] arrayOfUri1 = getSelectedFiles(paramIntent, paramInt2);
          if (arrayOfUri1 != null)
          {
            this.filePathCallback.onReceiveValue(arrayOfUri1);
          }
          else
          {
            ValueCallback localValueCallback = this.filePathCallback;
            Uri[] arrayOfUri2 = new Uri[1];
            arrayOfUri2[0] = this.outputFileUri;
            localValueCallback.onReceiveValue(arrayOfUri2);
          }
        }
      }
    case 3:
    }
    Object localObject;
    if (paramInt2 != -1)
      localObject = null;
    while (true)
    {
      this.filePathCallbackLegacy.onReceiveValue(localObject);
      break;
      if (paramIntent == null)
        localObject = this.outputFileUri;
      else
        localObject = paramIntent.getData();
    }
  }

  public void onNewIntent(Intent paramIntent)
  {
  }

  public void setDownloadRequest(DownloadManager.Request paramRequest)
  {
    this.downloadRequest = paramRequest;
  }

  public void startPhotoPickerIntent(ValueCallback<Uri> paramValueCallback, String paramString)
  {
    this.filePathCallbackLegacy = paramValueCallback;
    Intent localIntent = Intent.createChooser(getFileChooserIntent(paramString), "");
    ArrayList localArrayList = new ArrayList();
    if (acceptsImages(paramString).booleanValue())
      localArrayList.add(getPhotoIntent());
    if (acceptsVideo(paramString).booleanValue())
      localArrayList.add(getVideoIntent());
    localIntent.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])localArrayList.toArray(new Parcelable[0]));
    if (localIntent.resolveActivity(getCurrentActivity().getPackageManager()) != null)
    {
      getCurrentActivity().startActivityForResult(localIntent, 3);
      return;
    }
    Log.w("RNCWebViewModule", "there is no Activity to handle this Intent");
  }

  public boolean startPhotoPickerIntent(ValueCallback<Uri[]> paramValueCallback, Intent paramIntent, String[] paramArrayOfString, boolean paramBoolean)
  {
    this.filePathCallback = paramValueCallback;
    ArrayList localArrayList = new ArrayList();
    if (acceptsImages(paramArrayOfString).booleanValue())
      localArrayList.add(getPhotoIntent());
    if (acceptsVideo(paramArrayOfString).booleanValue())
      localArrayList.add(getVideoIntent());
    Intent localIntent1 = getFileChooserIntent(paramArrayOfString, paramBoolean);
    Intent localIntent2 = new Intent("android.intent.action.CHOOSER");
    localIntent2.putExtra("android.intent.extra.INTENT", localIntent1);
    localIntent2.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])localArrayList.toArray(new Parcelable[0]));
    if (localIntent2.resolveActivity(getCurrentActivity().getPackageManager()) != null)
    {
      getCurrentActivity().startActivityForResult(localIntent2, 1);
      return true;
    }
    Log.w("RNCWebViewModule", "there is no Activity to handle this Intent");
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.reactnativecommunity.webview.RNCWebViewModule
 * JD-Core Version:    0.6.2
 */