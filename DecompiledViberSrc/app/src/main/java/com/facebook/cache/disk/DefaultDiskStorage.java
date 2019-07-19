package com.facebook.cache.disk;

import android.os.Environment;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory;
import com.facebook.common.file.FileTree;
import com.facebook.common.file.FileTreeVisitor;
import com.facebook.common.file.FileUtils;
import com.facebook.common.file.FileUtils.CreateDirectoryException;
import com.facebook.common.file.FileUtils.ParentDirNotFoundException;
import com.facebook.common.file.FileUtils.RenameException;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class DefaultDiskStorage
  implements DiskStorage
{
  private static final String CONTENT_FILE_EXTENSION = ".cnt";
  private static final String DEFAULT_DISK_STORAGE_VERSION_PREFIX = "v2";
  private static final int SHARDING_BUCKET_COUNT = 100;
  private static final Class<?> TAG = DefaultDiskStorage.class;
  private static final String TEMP_FILE_EXTENSION = ".tmp";
  static final long TEMP_FILE_LIFETIME_MS = TimeUnit.MINUTES.toMillis(30L);
  private final CacheErrorLogger mCacheErrorLogger;
  private final Clock mClock;
  private final boolean mIsExternal;
  private final File mRootDirectory;
  private final File mVersionDirectory;

  public DefaultDiskStorage(File paramFile, int paramInt, CacheErrorLogger paramCacheErrorLogger)
  {
    Preconditions.checkNotNull(paramFile);
    this.mRootDirectory = paramFile;
    this.mIsExternal = isExternal(paramFile, paramCacheErrorLogger);
    this.mVersionDirectory = new File(this.mRootDirectory, getVersionSubdirectoryName(paramInt));
    this.mCacheErrorLogger = paramCacheErrorLogger;
    recreateDirectoryIfVersionChanges();
    this.mClock = SystemClock.get();
  }

  private long doRemove(File paramFile)
  {
    long l;
    if (!paramFile.exists())
      l = 0L;
    do
    {
      return l;
      l = paramFile.length();
    }
    while (paramFile.delete());
    return -1L;
  }

  private DiskStorage.DiskDumpInfoEntry dumpCacheEntry(DiskStorage.Entry paramEntry)
    throws IOException
  {
    EntryImpl localEntryImpl = (EntryImpl)paramEntry;
    String str1 = "";
    byte[] arrayOfByte = localEntryImpl.getResource().read();
    String str2 = typeOfBytes(arrayOfByte);
    if ((str2.equals("undefined")) && (arrayOfByte.length >= 4))
    {
      Locale localLocale = (Locale)null;
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = Byte.valueOf(arrayOfByte[0]);
      arrayOfObject[1] = Byte.valueOf(arrayOfByte[1]);
      arrayOfObject[2] = Byte.valueOf(arrayOfByte[2]);
      arrayOfObject[3] = Byte.valueOf(arrayOfByte[3]);
      str1 = String.format(localLocale, "0x%02X 0x%02X 0x%02X 0x%02X", arrayOfObject);
    }
    return new DiskStorage.DiskDumpInfoEntry(localEntryImpl.getResource().getFile().getPath(), str2, (float)localEntryImpl.getSize(), str1);
  }

  @Nullable
  @FileType
  private static String getFileTypefromExtension(String paramString)
  {
    if (".cnt".equals(paramString))
      return ".cnt";
    if (".tmp".equals(paramString))
      return ".tmp";
    return null;
  }

  private String getFilename(String paramString)
  {
    FileInfo localFileInfo = new FileInfo(".cnt", paramString, null);
    return localFileInfo.toPath(getSubdirectoryPath(localFileInfo.resourceId));
  }

  private FileInfo getShardFileInfo(File paramFile)
  {
    FileInfo localFileInfo = FileInfo.fromFile(paramFile);
    if (localFileInfo == null)
      return null;
    if (getSubdirectory(localFileInfo.resourceId).equals(paramFile.getParentFile()));
    while (true)
    {
      return localFileInfo;
      localFileInfo = null;
    }
  }

  private File getSubdirectory(String paramString)
  {
    return new File(getSubdirectoryPath(paramString));
  }

  private String getSubdirectoryPath(String paramString)
  {
    String str = String.valueOf(Math.abs(paramString.hashCode() % 100));
    return this.mVersionDirectory + File.separator + str;
  }

  @VisibleForTesting
  static String getVersionSubdirectoryName(int paramInt)
  {
    Locale localLocale = (Locale)null;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = "v2";
    arrayOfObject[1] = Integer.valueOf(100);
    arrayOfObject[2] = Integer.valueOf(paramInt);
    return String.format(localLocale, "%s.ols%d.%d", arrayOfObject);
  }

  private static boolean isExternal(File paramFile, CacheErrorLogger paramCacheErrorLogger)
  {
    String str1 = null;
    try
    {
      File localFile = Environment.getExternalStorageDirectory();
      boolean bool1 = false;
      String str2;
      if (localFile != null)
        str2 = localFile.toString();
      try
      {
        str1 = paramFile.getCanonicalPath();
        boolean bool2 = str1.contains(str2);
        bool1 = false;
        if (bool2)
          bool1 = true;
        return bool1;
      }
      catch (IOException localIOException)
      {
        paramCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.OTHER, TAG, "failed to read folder to check if external: " + str1, localIOException);
        return false;
      }
    }
    catch (Exception localException)
    {
      paramCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.OTHER, TAG, "failed to get the external storage directory!", localException);
    }
    return false;
  }

  private void mkdirs(File paramFile, String paramString)
    throws IOException
  {
    try
    {
      FileUtils.mkdirs(paramFile);
      return;
    }
    catch (FileUtils.CreateDirectoryException localCreateDirectoryException)
    {
      this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, TAG, paramString, localCreateDirectoryException);
      throw localCreateDirectoryException;
    }
  }

  private boolean query(String paramString, boolean paramBoolean)
  {
    File localFile = getContentFileFor(paramString);
    boolean bool = localFile.exists();
    if ((paramBoolean) && (bool))
      localFile.setLastModified(this.mClock.now());
    return bool;
  }

  private void recreateDirectoryIfVersionChanges()
  {
    int i = 1;
    if (!this.mRootDirectory.exists());
    while (true)
    {
      if (i != 0);
      try
      {
        FileUtils.mkdirs(this.mVersionDirectory);
        return;
        if (!this.mVersionDirectory.exists())
          FileTree.deleteRecursively(this.mRootDirectory);
      }
      catch (FileUtils.CreateDirectoryException localCreateDirectoryException)
      {
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, TAG, "version directory could not be created: " + this.mVersionDirectory, null);
        return;
      }
      i = 0;
    }
  }

  private String typeOfBytes(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length >= 2)
    {
      if ((paramArrayOfByte[0] == -1) && (paramArrayOfByte[1] == -40))
        return "jpg";
      if ((paramArrayOfByte[0] == -119) && (paramArrayOfByte[1] == 80))
        return "png";
      if ((paramArrayOfByte[0] == 82) && (paramArrayOfByte[1] == 73))
        return "webp";
      if ((paramArrayOfByte[0] == 71) && (paramArrayOfByte[1] == 73))
        return "gif";
    }
    return "undefined";
  }

  public void clearAll()
  {
    FileTree.deleteContents(this.mRootDirectory);
  }

  public boolean contains(String paramString, Object paramObject)
  {
    return query(paramString, false);
  }

  @VisibleForTesting
  File getContentFileFor(String paramString)
  {
    return new File(getFilename(paramString));
  }

  public DiskStorage.DiskDumpInfo getDumpInfo()
    throws IOException
  {
    List localList = getEntries();
    DiskStorage.DiskDumpInfo localDiskDumpInfo = new DiskStorage.DiskDumpInfo();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      DiskStorage.DiskDumpInfoEntry localDiskDumpInfoEntry = dumpCacheEntry((DiskStorage.Entry)localIterator.next());
      String str = localDiskDumpInfoEntry.type;
      if (!localDiskDumpInfo.typeCounts.containsKey(str))
        localDiskDumpInfo.typeCounts.put(str, Integer.valueOf(0));
      localDiskDumpInfo.typeCounts.put(str, Integer.valueOf(1 + ((Integer)localDiskDumpInfo.typeCounts.get(str)).intValue()));
      localDiskDumpInfo.entries.add(localDiskDumpInfoEntry);
    }
    return localDiskDumpInfo;
  }

  public List<DiskStorage.Entry> getEntries()
    throws IOException
  {
    EntriesCollector localEntriesCollector = new EntriesCollector(null);
    FileTree.walkFileTree(this.mVersionDirectory, localEntriesCollector);
    return localEntriesCollector.getEntries();
  }

  public BinaryResource getResource(String paramString, Object paramObject)
  {
    File localFile = getContentFileFor(paramString);
    if (localFile.exists())
    {
      localFile.setLastModified(this.mClock.now());
      return FileBinaryResource.createOrNull(localFile);
    }
    return null;
  }

  public String getStorageName()
  {
    String str = this.mRootDirectory.getAbsolutePath();
    return "_" + str.substring(1 + str.lastIndexOf('/'), str.length()) + "_" + str.hashCode();
  }

  public DiskStorage.Inserter insert(String paramString, Object paramObject)
    throws IOException
  {
    FileInfo localFileInfo = new FileInfo(".tmp", paramString, null);
    File localFile = getSubdirectory(localFileInfo.resourceId);
    if (!localFile.exists())
      mkdirs(localFile, "insert");
    try
    {
      InserterImpl localInserterImpl = new InserterImpl(paramString, localFileInfo.createTempFile(localFile));
      return localInserterImpl;
    }
    catch (IOException localIOException)
    {
      this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, TAG, "insert", localIOException);
      throw localIOException;
    }
  }

  public boolean isEnabled()
  {
    return true;
  }

  public boolean isExternal()
  {
    return this.mIsExternal;
  }

  public void purgeUnexpectedResources()
  {
    FileTree.walkFileTree(this.mRootDirectory, new PurgingVisitor(null));
  }

  public long remove(DiskStorage.Entry paramEntry)
  {
    return doRemove(((EntryImpl)paramEntry).getResource().getFile());
  }

  public long remove(String paramString)
  {
    return doRemove(getContentFileFor(paramString));
  }

  public boolean touch(String paramString, Object paramObject)
  {
    return query(paramString, true);
  }

  private class EntriesCollector
    implements FileTreeVisitor
  {
    private final List<DiskStorage.Entry> result = new ArrayList();

    private EntriesCollector()
    {
    }

    public List<DiskStorage.Entry> getEntries()
    {
      return Collections.unmodifiableList(this.result);
    }

    public void postVisitDirectory(File paramFile)
    {
    }

    public void preVisitDirectory(File paramFile)
    {
    }

    public void visitFile(File paramFile)
    {
      DefaultDiskStorage.FileInfo localFileInfo = DefaultDiskStorage.this.getShardFileInfo(paramFile);
      if ((localFileInfo != null) && (localFileInfo.type == ".cnt"))
        this.result.add(new DefaultDiskStorage.EntryImpl(localFileInfo.resourceId, paramFile, null));
    }
  }

  @VisibleForTesting
  static class EntryImpl
    implements DiskStorage.Entry
  {
    private final String id;
    private final FileBinaryResource resource;
    private long size;
    private long timestamp;

    private EntryImpl(String paramString, File paramFile)
    {
      Preconditions.checkNotNull(paramFile);
      this.id = ((String)Preconditions.checkNotNull(paramString));
      this.resource = FileBinaryResource.createOrNull(paramFile);
      this.size = -1L;
      this.timestamp = -1L;
    }

    public String getId()
    {
      return this.id;
    }

    public FileBinaryResource getResource()
    {
      return this.resource;
    }

    public long getSize()
    {
      if (this.size < 0L)
        this.size = this.resource.size();
      return this.size;
    }

    public long getTimestamp()
    {
      if (this.timestamp < 0L)
        this.timestamp = this.resource.getFile().lastModified();
      return this.timestamp;
    }
  }

  private static class FileInfo
  {
    public final String resourceId;

    @DefaultDiskStorage.FileType
    public final String type;

    private FileInfo(@DefaultDiskStorage.FileType String paramString1, String paramString2)
    {
      this.type = paramString1;
      this.resourceId = paramString2;
    }

    @Nullable
    public static FileInfo fromFile(File paramFile)
    {
      String str1 = paramFile.getName();
      int i = str1.lastIndexOf('.');
      if (i <= 0)
        return null;
      String str2 = DefaultDiskStorage.getFileTypefromExtension(str1.substring(i));
      if (str2 == null)
        return null;
      String str3 = str1.substring(0, i);
      if (str2.equals(".tmp"))
      {
        int j = str3.lastIndexOf('.');
        if (j <= 0)
          return null;
        str3 = str3.substring(0, j);
      }
      return new FileInfo(str2, str3);
    }

    public File createTempFile(File paramFile)
      throws IOException
    {
      return File.createTempFile(this.resourceId + ".", ".tmp", paramFile);
    }

    public String toPath(String paramString)
    {
      return paramString + File.separator + this.resourceId + this.type;
    }

    public String toString()
    {
      return this.type + "(" + this.resourceId + ")";
    }
  }

  public static @interface FileType
  {
    public static final String CONTENT = ".cnt";
    public static final String TEMP = ".tmp";
  }

  private static class IncompleteFileException extends IOException
  {
    public final long actual;
    public final long expected;

    public IncompleteFileException(long paramLong1, long paramLong2)
    {
      super();
      this.expected = paramLong1;
      this.actual = paramLong2;
    }
  }

  @VisibleForTesting
  class InserterImpl
    implements DiskStorage.Inserter
  {
    private final String mResourceId;

    @VisibleForTesting
    final File mTemporaryFile;

    public InserterImpl(String paramFile, File arg3)
    {
      this.mResourceId = paramFile;
      Object localObject;
      this.mTemporaryFile = localObject;
    }

    public boolean cleanUp()
    {
      return (!this.mTemporaryFile.exists()) || (this.mTemporaryFile.delete());
    }

    public BinaryResource commit(Object paramObject)
      throws IOException
    {
      File localFile = DefaultDiskStorage.this.getContentFileFor(this.mResourceId);
      Throwable localThrowable;
      try
      {
        FileUtils.rename(this.mTemporaryFile, localFile);
        if (localFile.exists())
          localFile.setLastModified(DefaultDiskStorage.this.mClock.now());
        return FileBinaryResource.createOrNull(localFile);
      }
      catch (FileUtils.RenameException localRenameException)
      {
        localThrowable = localRenameException.getCause();
        if (localThrowable != null)
          break label88;
      }
      CacheErrorLogger.CacheErrorCategory localCacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
      while (true)
      {
        DefaultDiskStorage.this.mCacheErrorLogger.logError(localCacheErrorCategory, DefaultDiskStorage.TAG, "commit", localRenameException);
        throw localRenameException;
        label88: if ((localThrowable instanceof FileUtils.ParentDirNotFoundException))
          localCacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND;
        else if ((localThrowable instanceof FileNotFoundException))
          localCacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND;
        else
          localCacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
      }
    }

    // ERROR //
    public void writeData(com.facebook.cache.common.WriterCallback paramWriterCallback, Object paramObject)
      throws IOException
    {
      // Byte code:
      //   0: new 111	java/io/FileOutputStream
      //   3: dup
      //   4: aload_0
      //   5: getfield 24	com/facebook/cache/disk/DefaultDiskStorage$InserterImpl:mTemporaryFile	Ljava/io/File;
      //   8: invokespecial 114	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   11: astore_3
      //   12: new 116	com/facebook/common/internal/CountingOutputStream
      //   15: dup
      //   16: aload_3
      //   17: invokespecial 119	com/facebook/common/internal/CountingOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   20: astore 4
      //   22: aload_1
      //   23: aload 4
      //   25: invokeinterface 124 2 0
      //   30: aload 4
      //   32: invokevirtual 127	com/facebook/common/internal/CountingOutputStream:flush	()V
      //   35: aload 4
      //   37: invokevirtual 130	com/facebook/common/internal/CountingOutputStream:getCount	()J
      //   40: lstore 6
      //   42: aload_3
      //   43: invokevirtual 133	java/io/FileOutputStream:close	()V
      //   46: aload_0
      //   47: getfield 24	com/facebook/cache/disk/DefaultDiskStorage$InserterImpl:mTemporaryFile	Ljava/io/File;
      //   50: invokevirtual 136	java/io/File:length	()J
      //   53: lload 6
      //   55: lcmp
      //   56: ifeq +56 -> 112
      //   59: new 138	com/facebook/cache/disk/DefaultDiskStorage$IncompleteFileException
      //   62: dup
      //   63: lload 6
      //   65: aload_0
      //   66: getfield 24	com/facebook/cache/disk/DefaultDiskStorage$InserterImpl:mTemporaryFile	Ljava/io/File;
      //   69: invokevirtual 136	java/io/File:length	()J
      //   72: invokespecial 141	com/facebook/cache/disk/DefaultDiskStorage$IncompleteFileException:<init>	(JJ)V
      //   75: athrow
      //   76: astore 8
      //   78: aload_0
      //   79: getfield 17	com/facebook/cache/disk/DefaultDiskStorage$InserterImpl:this$0	Lcom/facebook/cache/disk/DefaultDiskStorage;
      //   82: invokestatic 86	com/facebook/cache/disk/DefaultDiskStorage:access$1000	(Lcom/facebook/cache/disk/DefaultDiskStorage;)Lcom/facebook/cache/common/CacheErrorLogger;
      //   85: getstatic 144	com/facebook/cache/common/CacheErrorLogger$CacheErrorCategory:WRITE_UPDATE_FILE_NOT_FOUND	Lcom/facebook/cache/common/CacheErrorLogger$CacheErrorCategory;
      //   88: invokestatic 90	com/facebook/cache/disk/DefaultDiskStorage:access$900	()Ljava/lang/Class;
      //   91: ldc 146
      //   93: aload 8
      //   95: invokeinterface 97 5 0
      //   100: aload 8
      //   102: athrow
      //   103: astore 5
      //   105: aload_3
      //   106: invokevirtual 133	java/io/FileOutputStream:close	()V
      //   109: aload 5
      //   111: athrow
      //   112: return
      //
      // Exception table:
      //   from	to	target	type
      //   0	12	76	java/io/FileNotFoundException
      //   12	42	103	finally
    }
  }

  private class PurgingVisitor
    implements FileTreeVisitor
  {
    private boolean insideBaseDirectory;

    private PurgingVisitor()
    {
    }

    private boolean isExpectedFile(File paramFile)
    {
      DefaultDiskStorage.FileInfo localFileInfo = DefaultDiskStorage.this.getShardFileInfo(paramFile);
      if (localFileInfo == null)
        return false;
      if (localFileInfo.type == ".tmp")
        return isRecentFile(paramFile);
      String str = localFileInfo.type;
      boolean bool = false;
      if (str == ".cnt")
        bool = true;
      Preconditions.checkState(bool);
      return true;
    }

    private boolean isRecentFile(File paramFile)
    {
      return paramFile.lastModified() > DefaultDiskStorage.this.mClock.now() - DefaultDiskStorage.TEMP_FILE_LIFETIME_MS;
    }

    public void postVisitDirectory(File paramFile)
    {
      if ((!DefaultDiskStorage.this.mRootDirectory.equals(paramFile)) && (!this.insideBaseDirectory))
        paramFile.delete();
      if ((this.insideBaseDirectory) && (paramFile.equals(DefaultDiskStorage.this.mVersionDirectory)))
        this.insideBaseDirectory = false;
    }

    public void preVisitDirectory(File paramFile)
    {
      if ((!this.insideBaseDirectory) && (paramFile.equals(DefaultDiskStorage.this.mVersionDirectory)))
        this.insideBaseDirectory = true;
    }

    public void visitFile(File paramFile)
    {
      if ((!this.insideBaseDirectory) || (!isExpectedFile(paramFile)))
        paramFile.delete();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.cache.disk.DefaultDiskStorage
 * JD-Core Version:    0.6.2
 */