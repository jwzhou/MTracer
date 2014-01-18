/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package edu.berkeley.xtrace.reporting;

import java.util.ArrayList;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.HashSet;
import org.apache.thrift.*;

import org.apache.thrift.protocol.*;
import org.apache.thrift.transport.*;

public class XTraceReporter {

  public interface Iface {

    /**
     * A method definition looks like C code. It has a return type, arguments,
     * and optionally a list of exceptions that it may throw. Note that argument
     * lists and exception lists are specified using the exact same syntax as
     * field lists in struct or exception definitions.
     */
    public void ping() throws TException;

    public void sendReport(String report) throws TException;

  }

  public static class Client implements Iface {
    public Client(TProtocol prot)
    {
      this(prot, prot);
    }

    public Client(TProtocol iprot, TProtocol oprot)
    {
      iprot_ = iprot;
      oprot_ = oprot;
    }

    protected TProtocol iprot_;
    protected TProtocol oprot_;

    protected int seqid_;

    public void ping() throws TException
    {
      send_ping();
      recv_ping();
    }

    public void send_ping() throws TException
    {
      oprot_.writeMessageBegin(new TMessage("ping", TMessageType.CALL, seqid_));
      ping_args args = new ping_args();
      args.write(oprot_);
      oprot_.writeMessageEnd();
      oprot_.getTransport().flush();
    }

    public void recv_ping() throws TException
    {
      TMessage msg = iprot_.readMessageBegin();
      if (msg.type == TMessageType.EXCEPTION) {
        TApplicationException x = TApplicationException.read(iprot_);
        iprot_.readMessageEnd();
        throw x;
      }
      ping_result result = new ping_result();
      result.read(iprot_);
      iprot_.readMessageEnd();
      return;
    }

    public void sendReport(String report) throws TException
    {
      send_sendReport(report);
      recv_sendReport();
    }

    public void send_sendReport(String report) throws TException
    {
      oprot_.writeMessageBegin(new TMessage("sendReport", TMessageType.CALL, seqid_));
      sendReport_args args = new sendReport_args();
      args.report = report;
      args.write(oprot_);
      oprot_.writeMessageEnd();
      oprot_.getTransport().flush();
    }

    public void recv_sendReport() throws TException
    {
      TMessage msg = iprot_.readMessageBegin();
      if (msg.type == TMessageType.EXCEPTION) {
        TApplicationException x = TApplicationException.read(iprot_);
        iprot_.readMessageEnd();
        throw x;
      }
      sendReport_result result = new sendReport_result();
      result.read(iprot_);
      iprot_.readMessageEnd();
      return;
    }

  }
  public static class Processor implements TProcessor {
    public Processor(Iface iface)
    {
      iface_ = iface;
      processMap_.put("ping", new ping());
      processMap_.put("sendReport", new sendReport());
    }

    protected static interface ProcessFunction {
      public void process(int seqid, TProtocol iprot, TProtocol oprot) throws TException;
    }

    private Iface iface_;
    protected final HashMap<String,ProcessFunction> processMap_ = new HashMap<String,ProcessFunction>();

    public boolean process(TProtocol iprot, TProtocol oprot) throws TException
    {
      TMessage msg = iprot.readMessageBegin();
      ProcessFunction fn = processMap_.get(msg.name);
      if (fn == null) {
        TProtocolUtil.skip(iprot, TType.STRUCT);
        iprot.readMessageEnd();
        TApplicationException x = new TApplicationException(TApplicationException.UNKNOWN_METHOD, "Invalid method name: '"+msg.name+"'");
        oprot.writeMessageBegin(new TMessage(msg.name, TMessageType.EXCEPTION, msg.seqid));
        x.write(oprot);
        oprot.writeMessageEnd();
        oprot.getTransport().flush();
        return true;
      }
      fn.process(msg.seqid, iprot, oprot);
      return true;
    }

    private class ping implements ProcessFunction {
      public void process(int seqid, TProtocol iprot, TProtocol oprot) throws TException
      {
        ping_args args = new ping_args();
        args.read(iprot);
        iprot.readMessageEnd();
        ping_result result = new ping_result();
        iface_.ping();
        oprot.writeMessageBegin(new TMessage("ping", TMessageType.REPLY, seqid));
        result.write(oprot);
        oprot.writeMessageEnd();
        oprot.getTransport().flush();
      }

    }

    private class sendReport implements ProcessFunction {
      public void process(int seqid, TProtocol iprot, TProtocol oprot) throws TException
      {
        sendReport_args args = new sendReport_args();
        args.read(iprot);
        iprot.readMessageEnd();
        sendReport_result result = new sendReport_result();
        iface_.sendReport(args.report);
        oprot.writeMessageBegin(new TMessage("sendReport", TMessageType.REPLY, seqid));
        result.write(oprot);
        oprot.writeMessageEnd();
        oprot.getTransport().flush();
      }

    }

  }

  public static class ping_args implements java.io.Serializable   {
    public ping_args() {
    }

    public void read(TProtocol iprot) throws TException {
      TField field;
      iprot.readStructBegin();
      while (true)
      {
        field = iprot.readFieldBegin();
        if (field.type == TType.STOP) { 
          break;
        }
        switch (field.id)
        {
          default:
            TProtocolUtil.skip(iprot, field.type);
            break;
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();
    }

    public void write(TProtocol oprot) throws TException {
      TStruct struct = new TStruct("ping_args");
      oprot.writeStructBegin(struct);
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

    public String toString() {
      StringBuilder sb = new StringBuilder("ping_args(");
      sb.append(")");
      return sb.toString();
    }

  }

  public static class ping_result implements java.io.Serializable   {
    public ping_result() {
    }

    public void read(TProtocol iprot) throws TException {
      TField field;
      iprot.readStructBegin();
      while (true)
      {
        field = iprot.readFieldBegin();
        if (field.type == TType.STOP) { 
          break;
        }
        switch (field.id)
        {
          default:
            TProtocolUtil.skip(iprot, field.type);
            break;
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();
    }

    public void write(TProtocol oprot) throws TException {
      TStruct struct = new TStruct("ping_result");
      oprot.writeStructBegin(struct);

      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

    public String toString() {
      StringBuilder sb = new StringBuilder("ping_result(");
      sb.append(")");
      return sb.toString();
    }

  }

  public static class sendReport_args implements java.io.Serializable   {
    public String report;

    public final Isset __isset = new Isset();
    public static final class Isset {
      public boolean report = false;
    }

    public sendReport_args() {
    }

    public sendReport_args(
      String report)
    {
      this();
      this.report = report;
      this.__isset.report = true;
    }

    public void read(TProtocol iprot) throws TException {
      TField field;
      iprot.readStructBegin();
      while (true)
      {
        field = iprot.readFieldBegin();
        if (field.type == TType.STOP) { 
          break;
        }
        switch (field.id)
        {
          case 1:
            if (field.type == TType.STRING) {
              this.report = iprot.readString();
              this.__isset.report = true;
            } else { 
              TProtocolUtil.skip(iprot, field.type);
            }
            break;
          default:
            TProtocolUtil.skip(iprot, field.type);
            break;
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();
    }

    public void write(TProtocol oprot) throws TException {
      TStruct struct = new TStruct("sendReport_args");
      oprot.writeStructBegin(struct);
      TField field = new TField("report", TType.STRING, (short)1);
      if (this.report != null) {
//        field.name = "report";
//        field.type = TType.STRING;
//        field.id = 1;
        oprot.writeFieldBegin(field);
        oprot.writeString(this.report);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

    public String toString() {
      StringBuilder sb = new StringBuilder("sendReport_args(");
      sb.append("report:");
      sb.append(this.report);
      sb.append(")");
      return sb.toString();
    }

  }

  public static class sendReport_result implements java.io.Serializable   {
    public sendReport_result() {
    }

    public void read(TProtocol iprot) throws TException {
      TField field;
      iprot.readStructBegin();
      while (true)
      {
        field = iprot.readFieldBegin();
        if (field.type == TType.STOP) { 
          break;
        }
        switch (field.id)
        {
          default:
            TProtocolUtil.skip(iprot, field.type);
            break;
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();
    }

    public void write(TProtocol oprot) throws TException {
      TStruct struct = new TStruct("sendReport_result");
      oprot.writeStructBegin(struct);

      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

    public String toString() {
      StringBuilder sb = new StringBuilder("sendReport_result(");
      sb.append(")");
      return sb.toString();
    }

  }

}
