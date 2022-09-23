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
            // Set an object in the cache (using the default transcoder) regardless of any existing value.
            // The exp value is passed along to memcached exactly as given, and will be processed per the memcached protocol specification:
            // The actual value sent may either be Unix time (number of seconds since January 1, 1970, as a 32-bit value), or a number of seconds starting from
            // current time. In the latter case, this number of seconds may not exceed 60*60*24*30 (number of seconds in 30 days); if the number sent by a
            // client is larger than that, the server will consider it to be real Unix time value rather than an offset from current time.
            //crunchifySpyMemCached.set("Crunchify", 2000, "New York");
          //  crunchifySpyMemCached.set("Google", 2000, "Mountain View");
           // crunchifySpyMemCached.set("PayPal", 2000, "San Jose");
           // crunchifySpyMemCached.set("Twitter", 2000, "San Francisco");
           // crunchifySpyMemCached.set("Amazon", 2000, "Seattle");
            
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
            
            // Get with a single key and decode using the default transcoder.
           // log("Key: Google, Value: " + crunchifySpyMemCached.get("Google"));
          //  log("Key: PayPal, Value: " + crunchifySpyMemCached.get("PayPal"));
           // log("Key: Twitter, Value: " + crunchifySpyMemCached.get("Twitter")); 
           // log("Key: Amazon, Value: " + crunchifySpyMemCached.get("Amazon"));
           // log("Key: Crunchify, Value: " + crunchifySpyMemCached.get("Crunchify"));
           // log("==> Total  Records Retrieved from MemCached using net.spy.spymemcached method:\n");
            // Delete the given key from the cache.
            //crunchifySpyMemCached.delete("Crunchify");
            //log("==> Key:Crunchify deleted successfully\n");
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
