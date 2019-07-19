package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteArrayBufferedInputStream;
import com.facebook.common.util.StreamUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.IOException;
import java.io.InputStream;

public class ProgressiveJpegParser
{
  private static final int BUFFER_SIZE = 16384;
  private static final int NOT_A_JPEG = 6;
  private static final int READ_FIRST_JPEG_BYTE = 0;
  private static final int READ_MARKER_FIRST_BYTE_OR_ENTROPY_DATA = 2;
  private static final int READ_MARKER_SECOND_BYTE = 3;
  private static final int READ_SECOND_JPEG_BYTE = 1;
  private static final int READ_SIZE_FIRST_BYTE = 4;
  private static final int READ_SIZE_SECOND_BYTE = 5;
  private int mBestScanEndOffset;
  private int mBestScanNumber;
  private final ByteArrayPool mByteArrayPool;
  private int mBytesParsed;
  private boolean mEndMarkerRead;
  private int mLastByteRead;
  private int mNextFullScanNumber;
  private int mParserState;

  public ProgressiveJpegParser(ByteArrayPool paramByteArrayPool)
  {
    this.mByteArrayPool = ((ByteArrayPool)Preconditions.checkNotNull(paramByteArrayPool));
    this.mBytesParsed = 0;
    this.mLastByteRead = 0;
    this.mNextFullScanNumber = 0;
    this.mBestScanEndOffset = 0;
    this.mBestScanNumber = 0;
    this.mParserState = 0;
  }

  private boolean doParseMoreData(InputStream paramInputStream)
  {
    boolean bool = true;
    int i = this.mBestScanNumber;
    int j;
    try
    {
      while (this.mParserState != 6)
      {
        j = paramInputStream.read();
        if (j == -1)
          break;
        this.mBytesParsed = (1 + this.mBytesParsed);
        if (this.mEndMarkerRead)
        {
          this.mParserState = 6;
          this.mEndMarkerRead = false;
          return false;
        }
        switch (this.mParserState)
        {
        default:
          Preconditions.checkState(false);
          this.mLastByteRead = j;
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        }
      }
    }
    catch (IOException localIOException)
    {
      Throwables.propagate(localIOException);
      if (this.mParserState == 6)
        break label360;
    }
    if (this.mBestScanNumber != i);
    while (true)
    {
      return bool;
      if (j == 255)
      {
        this.mParserState = 1;
        break;
      }
      this.mParserState = 6;
      break;
      if (j == 216)
      {
        this.mParserState = 2;
        break;
      }
      this.mParserState = 6;
      break;
      if (j != 255)
        break;
      this.mParserState = 3;
      break;
      if (j == 255)
      {
        this.mParserState = 3;
        break;
      }
      if (j == 0)
      {
        this.mParserState = 2;
        break;
      }
      if (j == 217)
      {
        this.mEndMarkerRead = true;
        newScanOrImageEndFound(-2 + this.mBytesParsed);
        this.mParserState = 2;
        break;
      }
      if (j == 218)
        newScanOrImageEndFound(-2 + this.mBytesParsed);
      if (doesMarkerStartSegment(j))
      {
        this.mParserState = 4;
        break;
      }
      this.mParserState = 2;
      break;
      this.mParserState = 5;
      break;
      int k = -2 + (j + (this.mLastByteRead << 8));
      StreamUtil.skip(paramInputStream, k);
      this.mBytesParsed = (k + this.mBytesParsed);
      this.mParserState = 2;
      break;
      label360: bool = false;
    }
  }

  private static boolean doesMarkerStartSegment(int paramInt)
  {
    int i = 1;
    if (paramInt == i);
    while ((paramInt >= 208) && (paramInt <= 215))
      return false;
    if ((paramInt != 217) && (paramInt != 216));
    while (true)
    {
      return i;
      i = 0;
    }
  }

  private void newScanOrImageEndFound(int paramInt)
  {
    if (this.mNextFullScanNumber > 0)
      this.mBestScanEndOffset = paramInt;
    int i = this.mNextFullScanNumber;
    this.mNextFullScanNumber = (i + 1);
    this.mBestScanNumber = i;
  }

  public int getBestScanEndOffset()
  {
    return this.mBestScanEndOffset;
  }

  public int getBestScanNumber()
  {
    return this.mBestScanNumber;
  }

  public boolean isEndMarkerRead()
  {
    return this.mEndMarkerRead;
  }

  public boolean isJpeg()
  {
    return (this.mBytesParsed > 1) && (this.mParserState != 6);
  }

  public boolean parseMoreData(EncodedImage paramEncodedImage)
  {
    if (this.mParserState == 6)
      return false;
    if (paramEncodedImage.getSize() <= this.mBytesParsed)
      return false;
    PooledByteArrayBufferedInputStream localPooledByteArrayBufferedInputStream = new PooledByteArrayBufferedInputStream(paramEncodedImage.getInputStream(), (byte[])this.mByteArrayPool.get(16384), this.mByteArrayPool);
    try
    {
      StreamUtil.skip(localPooledByteArrayBufferedInputStream, this.mBytesParsed);
      boolean bool = doParseMoreData(localPooledByteArrayBufferedInputStream);
      return bool;
    }
    catch (IOException localIOException)
    {
      Throwables.propagate(localIOException);
      return false;
    }
    finally
    {
      Closeables.closeQuietly(localPooledByteArrayBufferedInputStream);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.decoder.ProgressiveJpegParser
 * JD-Core Version:    0.6.2
 */