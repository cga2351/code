package com.facebook.soloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.StrictMode.ThreadPolicy;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.annotation.Nullable;

public class ApplicationSoSource extends SoSource
{
  private Context applicationContext;
  private int flags;
  private DirectorySoSource soSource;

  public ApplicationSoSource(Context paramContext, int paramInt)
  {
    this.applicationContext = paramContext.getApplicationContext();
    if (this.applicationContext == null)
    {
      Log.w("SoLoader", "context.getApplicationContext returned null, holding reference to original context.");
      this.applicationContext = paramContext;
    }
    this.flags = paramInt;
    this.soSource = new DirectorySoSource(new File(this.applicationContext.getApplicationInfo().nativeLibraryDir), paramInt);
  }

  public void addToLdLibraryPath(Collection<String> paramCollection)
  {
    this.soSource.addToLdLibraryPath(paramCollection);
  }

  public boolean checkAndMaybeUpdate()
    throws IOException
  {
    try
    {
      File localFile1 = this.soSource.soDirectory;
      Context localContext = this.applicationContext.createPackageContext(this.applicationContext.getPackageName(), 0);
      File localFile2 = new File(localContext.getApplicationInfo().nativeLibraryDir);
      boolean bool1 = localFile1.equals(localFile2);
      boolean bool2 = false;
      if (!bool1)
      {
        Log.d("SoLoader", "Native library directory updated from " + localFile1 + " to " + localFile2);
        this.flags = (0x1 | this.flags);
        this.soSource = new DirectorySoSource(localFile2, this.flags);
        this.soSource.prepare(this.flags);
        this.applicationContext = localContext;
        bool2 = true;
      }
      return bool2;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      throw new RuntimeException(localNameNotFoundException);
    }
  }

  public int loadLibrary(String paramString, int paramInt, StrictMode.ThreadPolicy paramThreadPolicy)
    throws IOException
  {
    return this.soSource.loadLibrary(paramString, paramInt, paramThreadPolicy);
  }

  protected void prepare(int paramInt)
    throws IOException
  {
    this.soSource.prepare(paramInt);
  }

  public String toString()
  {
    return this.soSource.toString();
  }

  @Nullable
  public File unpackLibrary(String paramString)
    throws IOException
  {
    return this.soSource.unpackLibrary(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.soloader.ApplicationSoSource
 * JD-Core Version:    0.6.2
 */