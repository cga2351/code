package android.support.v8.renderscript;

public class Matrix3f
{
  final float[] mMat = new float[9];

  public Matrix3f()
  {
    loadIdentity();
  }

  public Matrix3f(float[] paramArrayOfFloat)
  {
    System.arraycopy(paramArrayOfFloat, 0, this.mMat, 0, this.mMat.length);
  }

  public float get(int paramInt1, int paramInt2)
  {
    return this.mMat[(paramInt2 + paramInt1 * 3)];
  }

  public float[] getArray()
  {
    return this.mMat;
  }

  public void load(Matrix3f paramMatrix3f)
  {
    System.arraycopy(paramMatrix3f.getArray(), 0, this.mMat, 0, this.mMat.length);
  }

  public void loadIdentity()
  {
    this.mMat[0] = 1.0F;
    this.mMat[1] = 0.0F;
    this.mMat[2] = 0.0F;
    this.mMat[3] = 0.0F;
    this.mMat[4] = 1.0F;
    this.mMat[5] = 0.0F;
    this.mMat[6] = 0.0F;
    this.mMat[7] = 0.0F;
    this.mMat[8] = 1.0F;
  }

  public void loadMultiply(Matrix3f paramMatrix3f1, Matrix3f paramMatrix3f2)
  {
    for (int i = 0; i < 3; i++)
    {
      int j = 0;
      float f1 = 0.0F;
      float f2 = 0.0F;
      float f3 = 0.0F;
      while (j < 3)
      {
        float f4 = paramMatrix3f2.get(i, j);
        f3 += f4 * paramMatrix3f1.get(j, 0);
        f2 += f4 * paramMatrix3f1.get(j, 1);
        f1 += f4 * paramMatrix3f1.get(j, 2);
        j++;
      }
      set(i, 0, f3);
      set(i, 1, f2);
      set(i, 2, f1);
    }
  }

  public void loadRotate(float paramFloat)
  {
    loadIdentity();
    float f1 = 0.01745329F * paramFloat;
    float f2 = (float)Math.cos(f1);
    float f3 = (float)Math.sin(f1);
    this.mMat[0] = f2;
    this.mMat[1] = (-f3);
    this.mMat[3] = f3;
    this.mMat[4] = f2;
  }

  public void loadRotate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = 0.01745329F * paramFloat1;
    float f2 = (float)Math.cos(f1);
    float f3 = (float)Math.sin(f1);
    float f4 = (float)Math.sqrt(paramFloat2 * paramFloat2 + paramFloat3 * paramFloat3 + paramFloat4 * paramFloat4);
    if (f4 == 1.0F)
    {
      float f12 = 1.0F / f4;
      paramFloat2 *= f12;
      paramFloat3 *= f12;
      paramFloat4 *= f12;
    }
    float f5 = 1.0F - f2;
    float f6 = paramFloat2 * paramFloat3;
    float f7 = paramFloat3 * paramFloat4;
    float f8 = paramFloat4 * paramFloat2;
    float f9 = paramFloat2 * f3;
    float f10 = paramFloat3 * f3;
    float f11 = f3 * paramFloat4;
    this.mMat[0] = (f2 + f5 * (paramFloat2 * paramFloat2));
    this.mMat[3] = (f6 * f5 - f11);
    this.mMat[6] = (f10 + f8 * f5);
    this.mMat[1] = (f11 + f6 * f5);
    this.mMat[4] = (f2 + f5 * (paramFloat3 * paramFloat3));
    this.mMat[7] = (f7 * f5 - f9);
    this.mMat[2] = (f8 * f5 - f10);
    this.mMat[5] = (f9 + f7 * f5);
    this.mMat[8] = (f2 + f5 * (paramFloat4 * paramFloat4));
  }

  public void loadScale(float paramFloat1, float paramFloat2)
  {
    loadIdentity();
    this.mMat[0] = paramFloat1;
    this.mMat[4] = paramFloat2;
  }

  public void loadScale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    loadIdentity();
    this.mMat[0] = paramFloat1;
    this.mMat[4] = paramFloat2;
    this.mMat[8] = paramFloat3;
  }

  public void loadTranslate(float paramFloat1, float paramFloat2)
  {
    loadIdentity();
    this.mMat[6] = paramFloat1;
    this.mMat[7] = paramFloat2;
  }

  public void multiply(Matrix3f paramMatrix3f)
  {
    Matrix3f localMatrix3f = new Matrix3f();
    localMatrix3f.loadMultiply(this, paramMatrix3f);
    load(localMatrix3f);
  }

  public void rotate(float paramFloat)
  {
    Matrix3f localMatrix3f = new Matrix3f();
    localMatrix3f.loadRotate(paramFloat);
    multiply(localMatrix3f);
  }

  public void rotate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Matrix3f localMatrix3f = new Matrix3f();
    localMatrix3f.loadRotate(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    multiply(localMatrix3f);
  }

  public void scale(float paramFloat1, float paramFloat2)
  {
    Matrix3f localMatrix3f = new Matrix3f();
    localMatrix3f.loadScale(paramFloat1, paramFloat2);
    multiply(localMatrix3f);
  }

  public void scale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Matrix3f localMatrix3f = new Matrix3f();
    localMatrix3f.loadScale(paramFloat1, paramFloat2, paramFloat3);
    multiply(localMatrix3f);
  }

  public void set(int paramInt1, int paramInt2, float paramFloat)
  {
    this.mMat[(paramInt2 + paramInt1 * 3)] = paramFloat;
  }

  public void translate(float paramFloat1, float paramFloat2)
  {
    Matrix3f localMatrix3f = new Matrix3f();
    localMatrix3f.loadTranslate(paramFloat1, paramFloat2);
    multiply(localMatrix3f);
  }

  public void transpose()
  {
    for (int i = 0; i < 2; i++)
      for (int j = i + 1; j < 3; j++)
      {
        float f = this.mMat[(j + i * 3)];
        this.mMat[(j + i * 3)] = this.mMat[(i + j * 3)];
        this.mMat[(i + j * 3)] = f;
      }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.Matrix3f
 * JD-Core Version:    0.6.2
 */