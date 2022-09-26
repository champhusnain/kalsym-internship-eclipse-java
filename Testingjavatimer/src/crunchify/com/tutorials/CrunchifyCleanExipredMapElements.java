package crunchify.com.tutorials;
import net.spy.memcached.MemcachedClient;
import java.io.IOException;
import java.net.InetSocketAddress;
/**
 * @author Crunchify.com 
 * Version: 1.0.0 
 * Details: Use dependency net.spy.spymemcached to retrieve, store Key Value pair from MemCached Server
 * 
 */
public class CrunchifyCleanExipredMapElements {
    public static void main(String[] args) {
        implementCrunchifySpyMemcached();
    }
    // Approach-1: net.spy.spymemcached
    // Use dependency net.spy.spymemcached to retrieve, store Key Value pair from MemCached Server
    private static void implementCrunchifySpyMemcached() {
        // Get a memcache client operating on the specified memcached locations.
        MemcachedClient crunchifySpyMemCached;
        try {
            crunchifySpyMemCached = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
            log("=====> Approach-1: SpyMemcached <=====\n");
            log("==> Connected to Crunchify's Local Server Successfully." + " Host: localhost, Port: 11211");

            
            Object myObject = null;
            for (int i = 0; i < 5000000; i++)
            {
            	crunchifySpyMemCached.set(new String("HELLO"), 3600, i+1);
                    myObject=crunchifySpyMemCached.get("HELLO");
                    String value = myObject.toString();
                    System.out.println("***" + value);
                    
                    if (i == 1000)
                    {
                    	
                    	log(crunchifySpyMemCached.getStats(null));
                    	
                    }
                   
                    }
            log("==> Total 50M Records added to MemCached");
            
            //for (int i = 0; i < 1001; i++)
            //{
            	//log("Key: HELLO, Value: " + crunchifySpyMemCached.get("HELLO"));
                  //  }
            log("==> Total 50M Records added to MemCached");
            
         
            log(crunchifySpyMemCached.getStats(null));
            //log("Key: Crunchify, Value: " + crunchifySpyMemCached.get("Crunchify"));
            //log("==> If no record found, it returns NULL\n");
        } catch (IOException e) {
            // Prints this throwable and its backtrace to the standard error stream
            e.printStackTrace();
        }
    }
    private static void log(Object object) {
        System.out.println(object);
    }
}
