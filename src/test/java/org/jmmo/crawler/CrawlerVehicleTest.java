package org.jmmo.crawler;

import org.junit.Test;

import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class CrawlerVehicleTest {

    CrawlerVehicle crawlerVehicle = new CrawlerVehicle();

    @Test
    public void testCheckPath() throws Exception {
        crawlerVehicle.rootDir = Paths.get("output").toAbsolutePath();

        String file1 = crawlerVehicle.urlToPath(new URL(URLDecoder.decode("https://ru.wikipedia.org/w/index.php?title=%D0%96%D0%BE%D0%B7%D0%B5_%D0%A1%D0%B5%D1%80%D0%B6%D0%B8%D0%BE_%D0%93%D0%B0%D0%B1%D1%80%D0%B8%D0%B5%D0%BB%D0%BB%D0%B8&action=edit&redlink=1", "utf-8"))).toString();
        assertEquals("index.php.html", Paths.get(file1).getFileName().toString());
        crawlerVehicle.files.put(file1, 0);

        String file2 = crawlerVehicle.urlToPath(new URL(URLDecoder.decode("https://ru.wikipedia.org/w/index.php?title=%D0%96%D0%BE%D0%B7%D0%B5_%D0%A1%D0%B5%D1%80%D0%B6%D0%B8%D0%BE_%D0%93%D0%B0%D0%B1%D1%80%D0%B8%D0%B5%D0%BB%D0%BB%D0%B8&action=edit&redlink=1", "utf-8"))).toString();
        assertEquals("index.php_1.html", Paths.get(file2).getFileName().toString());
    }
}