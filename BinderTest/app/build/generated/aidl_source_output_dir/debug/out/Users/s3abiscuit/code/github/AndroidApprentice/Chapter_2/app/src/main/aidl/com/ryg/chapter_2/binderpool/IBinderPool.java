/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package com.ryg.chapter_2.binderpool;
public interface IBinderPool extends android.os.IInterface
{
  /** Default implementation for IBinderPool. */
  public static class Default implements com.ryg.chapter_2.binderpool.IBinderPool
  {
    /**
         * @param binderCode, the unique token of specific Binder<br/>
         * @return specific Binder who's token is binderCode.
         */
    @Override public android.os.IBinder queryBinder(int binderCode) throws android.os.RemoteException
    {
      return null;
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements com.ryg.chapter_2.binderpool.IBinderPool
  {
    private static final java.lang.String DESCRIPTOR = "com.ryg.chapter_2.binderpool.IBinderPool";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an com.ryg.chapter_2.binderpool.IBinderPool interface,
     * generating a proxy if needed.
     */
    public static com.ryg.chapter_2.binderpool.IBinderPool asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof com.ryg.chapter_2.binderpool.IBinderPool))) {
        return ((com.ryg.chapter_2.binderpool.IBinderPool)iin);
      }
      return new com.ryg.chapter_2.binderpool.IBinderPool.Stub.Proxy(obj);
    }
    @Override public android.os.IBinder asBinder()
    {
      return this;
    }
    @Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
    {
      java.lang.String descriptor = DESCRIPTOR;
      switch (code)
      {
        case INTERFACE_TRANSACTION:
        {
          reply.writeString(descriptor);
          return true;
        }
        case TRANSACTION_queryBinder:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          android.os.IBinder _result = this.queryBinder(_arg0);
          reply.writeNoException();
          reply.writeStrongBinder(_result);
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements com.ryg.chapter_2.binderpool.IBinderPool
    {
      private android.os.IBinder mRemote;
      Proxy(android.os.IBinder remote)
      {
        mRemote = remote;
      }
      @Override public android.os.IBinder asBinder()
      {
        return mRemote;
      }
      public java.lang.String getInterfaceDescriptor()
      {
        return DESCRIPTOR;
      }
      /**
           * @param binderCode, the unique token of specific Binder<br/>
           * @return specific Binder who's token is binderCode.
           */
      @Override public android.os.IBinder queryBinder(int binderCode) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        android.os.IBinder _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(binderCode);
          boolean _status = mRemote.transact(Stub.TRANSACTION_queryBinder, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().queryBinder(binderCode);
          }
          _reply.readException();
          _result = _reply.readStrongBinder();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      public static com.ryg.chapter_2.binderpool.IBinderPool sDefaultImpl;
    }
    static final int TRANSACTION_queryBinder = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    public static boolean setDefaultImpl(com.ryg.chapter_2.binderpool.IBinderPool impl) {
      if (Stub.Proxy.sDefaultImpl == null && impl != null) {
        Stub.Proxy.sDefaultImpl = impl;
        return true;
      }
      return false;
    }
    public static com.ryg.chapter_2.binderpool.IBinderPool getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
  /**
       * @param binderCode, the unique token of specific Binder<br/>
       * @return specific Binder who's token is binderCode.
       */
  public android.os.IBinder queryBinder(int binderCode) throws android.os.RemoteException;
}
