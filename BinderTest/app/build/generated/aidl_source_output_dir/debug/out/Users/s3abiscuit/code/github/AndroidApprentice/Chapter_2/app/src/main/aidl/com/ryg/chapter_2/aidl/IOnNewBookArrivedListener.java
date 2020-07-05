/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package com.ryg.chapter_2.aidl;
public interface IOnNewBookArrivedListener extends android.os.IInterface
{
  /** Default implementation for IOnNewBookArrivedListener. */
  public static class Default implements com.ryg.chapter_2.aidl.IOnNewBookArrivedListener
  {
    @Override public void onNewBookArrived(com.ryg.chapter_2.aidl.Book newBook) throws android.os.RemoteException
    {
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements com.ryg.chapter_2.aidl.IOnNewBookArrivedListener
  {
    private static final java.lang.String DESCRIPTOR = "com.ryg.chapter_2.aidl.IOnNewBookArrivedListener";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an com.ryg.chapter_2.aidl.IOnNewBookArrivedListener interface,
     * generating a proxy if needed.
     */
    public static com.ryg.chapter_2.aidl.IOnNewBookArrivedListener asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof com.ryg.chapter_2.aidl.IOnNewBookArrivedListener))) {
        return ((com.ryg.chapter_2.aidl.IOnNewBookArrivedListener)iin);
      }
      return new com.ryg.chapter_2.aidl.IOnNewBookArrivedListener.Stub.Proxy(obj);
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
        case TRANSACTION_onNewBookArrived:
        {
          data.enforceInterface(descriptor);
          com.ryg.chapter_2.aidl.Book _arg0;
          if ((0!=data.readInt())) {
            _arg0 = com.ryg.chapter_2.aidl.Book.CREATOR.createFromParcel(data);
          }
          else {
            _arg0 = null;
          }
          this.onNewBookArrived(_arg0);
          reply.writeNoException();
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements com.ryg.chapter_2.aidl.IOnNewBookArrivedListener
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
      @Override public void onNewBookArrived(com.ryg.chapter_2.aidl.Book newBook) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          if ((newBook!=null)) {
            _data.writeInt(1);
            newBook.writeToParcel(_data, 0);
          }
          else {
            _data.writeInt(0);
          }
          boolean _status = mRemote.transact(Stub.TRANSACTION_onNewBookArrived, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().onNewBookArrived(newBook);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      public static com.ryg.chapter_2.aidl.IOnNewBookArrivedListener sDefaultImpl;
    }
    static final int TRANSACTION_onNewBookArrived = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    public static boolean setDefaultImpl(com.ryg.chapter_2.aidl.IOnNewBookArrivedListener impl) {
      if (Stub.Proxy.sDefaultImpl == null && impl != null) {
        Stub.Proxy.sDefaultImpl = impl;
        return true;
      }
      return false;
    }
    public static com.ryg.chapter_2.aidl.IOnNewBookArrivedListener getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
  public void onNewBookArrived(com.ryg.chapter_2.aidl.Book newBook) throws android.os.RemoteException;
}
