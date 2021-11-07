//Proiect VVS

package test;

import main.Server;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.ServerSocket;

public class Test {
     private Server server ;
    @Before
    public void beforeTest(){

        try {
            ServerSocket serverConnect = new ServerSocket(8081);
            server = new Server(serverConnect.accept());
            Thread thread = new Thread(server);
            thread.start();
        } catch (IOException e) {
            System.err.println("Server Connection error : " + e.getMessage());
        }
    }
    @org.junit.Test
    public void testDefault(){
        try {
            server.handleDefault();
            Assert.assertEquals(Server.DEFAULT_FILE,server.getFileShown());
        }catch (IOException e) {
        assert false;

        }

    }
    @org.junit.Test
    public void testMaintenance(){
        try {
            server.handleMaintenance();
            Assert.assertEquals(Server.MAINTENANCE,server.getFileShown());
        }catch (IOException e) {
            assert false;

        }

    }
    @org.junit.Test
    public void testUnsupported(){
        try {
            server.handleUnsupported();
            Assert.assertEquals(Server.METHOD_NOT_SUPPORTED,server.getFileShown());
        }catch (IOException e) {
            assert false;

        }

    }

}

