package com.viber.svg.jni;

import android.graphics.Matrix;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryPictureRasterizationInfoStorage extends PictureRasterizationInfoStorage
{
  private static final Logger L = Logger.create(BinaryPictureRasterizationInfoStorage.class.getSimpleName());

  public BinaryPictureRasterizationInfoStorage(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramString, paramInt1, paramInt2, paramInt3, "bin");
  }

  private Matrix readMatrix(DataInputStream paramDataInputStream, float[] paramArrayOfFloat)
    throws IOException
  {
    for (int i = 0; i < 6; i++)
      paramArrayOfFloat[i] = ((float)paramDataInputStream.readDouble());
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(paramArrayOfFloat);
    return localMatrix;
  }

  private void writeMatrix(DataOutputStream paramDataOutputStream, Matrix paramMatrix, float[] paramArrayOfFloat)
    throws IOException
  {
    paramMatrix.getValues(paramArrayOfFloat);
    for (int i = 0; i < 6; i++)
      paramDataOutputStream.writeDouble(paramArrayOfFloat[i]);
  }

  public BitmapPictureRenderer.PictureRasterizationInfo[] load()
    throws IOException
  {
    DataInputStream localDataInputStream = new DataInputStream(new FileInputStream(this.filename));
    L.debug("Loading " + this.filename);
    try
    {
      int i = localDataInputStream.readInt();
      if (i != this.rasterizationVersion)
      {
        L.debug("Rasterization version mismatch: " + i + ", expected:" + this.rasterizationVersion);
        return null;
      }
      int j = localDataInputStream.readInt();
      int k = localDataInputStream.readInt();
      if ((j != this.prepareViewportWidth) || (k != this.prepareViewportHeight))
      {
        L.debug("Rasterization info mismatch (pvpw: " + j + ", pvph: " + k + "), expected (pvpw: " + this.prepareViewportWidth + ", pvph: " + this.prepareViewportHeight + ")");
        return null;
      }
      float[] arrayOfFloat = { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
      int m = localDataInputStream.readInt();
      BitmapPictureRenderer.PictureRasterizationInfo[] arrayOfPictureRasterizationInfo = new BitmapPictureRenderer.PictureRasterizationInfo[m];
      for (int n = 0; n < m; n++)
        if (localDataInputStream.readBoolean())
          arrayOfPictureRasterizationInfo[n] = new BitmapPictureRenderer.PictureRasterizationInfo(localDataInputStream.readInt(), localDataInputStream.readInt(), readMatrix(localDataInputStream, arrayOfFloat), readMatrix(localDataInputStream, arrayOfFloat));
      return arrayOfPictureRasterizationInfo;
    }
    finally
    {
      localDataInputStream.close();
    }
  }

  public void save(BitmapPictureRenderer.PictureRasterizationInfo[] paramArrayOfPictureRasterizationInfo)
    throws IOException
  {
    int i = 0;
    DataOutputStream localDataOutputStream = new DataOutputStream(new FileOutputStream(this.filename));
    while (true)
    {
      try
      {
        localDataOutputStream.writeInt(this.rasterizationVersion);
        localDataOutputStream.writeInt(this.prepareViewportWidth);
        localDataOutputStream.writeInt(this.prepareViewportHeight);
        float[] arrayOfFloat = { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
        localDataOutputStream.writeInt(paramArrayOfPictureRasterizationInfo.length);
        if (i < paramArrayOfPictureRasterizationInfo.length)
        {
          BitmapPictureRenderer.PictureRasterizationInfo localPictureRasterizationInfo = paramArrayOfPictureRasterizationInfo[i];
          if (localPictureRasterizationInfo == null)
          {
            localDataOutputStream.writeBoolean(false);
          }
          else
          {
            localDataOutputStream.writeBoolean(true);
            localDataOutputStream.writeInt(localPictureRasterizationInfo.bitmapWidth);
            localDataOutputStream.writeInt(localPictureRasterizationInfo.bitmapHeight);
            writeMatrix(localDataOutputStream, localPictureRasterizationInfo.rasterizeMatrix, arrayOfFloat);
            writeMatrix(localDataOutputStream, localPictureRasterizationInfo.renderMatrix, arrayOfFloat);
          }
        }
      }
      finally
      {
        localDataOutputStream.close();
      }
      localDataOutputStream.close();
      return;
      i++;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.BinaryPictureRasterizationInfoStorage
 * JD-Core Version:    0.6.2
 */