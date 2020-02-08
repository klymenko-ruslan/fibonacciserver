package com.klymenko.fibonacciserver;

import com.klymenko.fibonacciserver.service.FibonacciHandler;
import com.klymenko.fibonacciserver.thrift.Fibonacci;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.server.TServer.Args;

public class Server {

    private static final int PORT = 9090;

    public static FibonacciHandler handler;

    public static Fibonacci.Processor processor;

    public static void main(String[] args) {
        handler = new FibonacciHandler();
        processor = new Fibonacci.Processor(handler);
        simple(processor);
    }

    public static void simple(Fibonacci.Processor processor) {
        try {
            TServerTransport serverTransport = new TServerSocket(PORT);
            TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));

            System.out.println("Server started on port " + PORT);
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
